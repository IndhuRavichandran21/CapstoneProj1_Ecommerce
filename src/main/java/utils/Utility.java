package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Utility {

	public static WebDriver driver;
	public String [][]data; 
	
	public void urlConnectionValidation(String siteUrl) {
		
       try {		
			URL siteLink = new URL(siteUrl);
			HttpURLConnection httpConnection = (HttpURLConnection) siteLink.openConnection();
			httpConnection.connect();
			httpConnection.setConnectTimeout(2000);
			int resposeCode = httpConnection.getResponseCode();
			System.out.println(resposeCode);
			if(resposeCode<=400) {
				System.out.println("The website url is working");
			}
			else
				System.out.println("The website url is broken");
					
		} catch (Exception e) {
			System.out.println("The website url is broken");
		}

	}
	
	public void browserLaunch(String browser ,String siteUrl) {
		
		//launch the browser based on the parameter passed
		if(browser.equals("chrome")) {
			driver = new ChromeDriver();
		}
		    	
		if(browser.equals("firefox"))
		{
			driver = new FirefoxDriver();
		}
		
		if(browser.equals("headless")) {		 
			ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");			
			options.addArguments("--start-maximized");
			driver = new ChromeDriver(options);		
		}
		
		driver.get(siteUrl); //launch the url
		Assert.assertEquals(driver.getTitle(), "Best Buy International: Select your Country - Best Buy");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public void selectCountry(String country) {
		if(country.equals("US"))
			driver.findElement(By.cssSelector("div[lang='en']>.country-selection>.us-link")).click();
		
		if(country.equals("Canada"))	
		    driver.findElement(By.cssSelector("div[lang='en']>.country-selection>.canada-link")).click();
		
		List<WebElement> list = driver.findElements(By.id("survey_invite_no")); //handling popup
		if(list.size()==1)
			driver.findElement(By.id("survey_invite_no")).click();
		
	}

	public void browserClose() {
		driver.quit();
	}
	
	//fetch data from excel
	public String[][] getExcelData(String sheetName) throws IOException {
		
		FileInputStream fis = new FileInputStream("C:\\Users\\Admin\\Desktop\\Indhu_ZenClass\\JavaPrograms\\eclipse-workspace\\capstoneProj1\\data\\EcommerceData.xlsx");
		XSSFWorkbook workBook = new XSSFWorkbook(fis);
		XSSFSheet workSheet = workBook.getSheet(sheetName);
		XSSFRow row;
		XSSFCell column;
		int rowCount = workSheet.getLastRowNum();
		int columnCount= workSheet.getRow(0).getLastCellNum();
		data = new String[rowCount][columnCount];
		
		for(int i=0; i<rowCount; i++) {		
			row = workSheet.getRow(i+1);
			
			for(int j=0; j<columnCount; j++) {						
				column = row.getCell(j,MissingCellPolicy.CREATE_NULL_AS_BLANK);
			   if(column.getCellType() == CellType.NUMERIC)
				   data[i][j] = String.valueOf(column.getNumericCellValue());
			   if(column.getCellType() == CellType.STRING)
			   
				data[i][j] = column.getStringCellValue();				
			}
		}
		workBook.close();
		return data;
	}
	
	/*
	public void handleActions(String productUrl) throws WebDriverException{
		
		//Actions actionsObj = new Actions(driver);	
		JavascriptExecutor js = (JavascriptExecutor) driver;		
		WebElement selectProduct=driver.findElement(By.xpath("//div[@class='column-left']//a[@href='"+productUrl+"']"));
		js.executeScript("arguments[0].scrollIntoView(true)", selectProduct);
		//actionsObj.scrollToElement(selectProduct).build().perform();
		WebElement addProductToCart=driver.findElement(By.xpath("//a[@href='"+productUrl+"']/ancestor::div[@class='column-middle']/following-sibling::div//div[@class='fulfillment-add-to-cart-button']"));		
		addProductToCart.click();
	}
	*/
	
	public String takeScreenshot(String screenshotName) throws IOException {
		String screenshotPath = "C:\\Users\\Admin\\Desktop\\Indhu_ZenClass\\JavaPrograms\\eclipse-workspace\\capstoneProj1\\screenshot\\"+screenshotName+".jpg";
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		File destination = new File(screenshotPath);
		FileUtils.copyFile(source, destination);
		return screenshotPath;
		
	}
}
