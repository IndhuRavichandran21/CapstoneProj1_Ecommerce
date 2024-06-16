package pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.ProjectSpecificationMethod;

public class SearchAndFilterPage extends ProjectSpecificationMethod{

	WebDriver driver;
	public SearchAndFilterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="gh-search-input")
	WebElement searchBox;
	
	@FindBy(className = "header-search-button")
	WebElement searchIcon;
	
	@FindBy(xpath = "//a[contains(@class,'go-to-cart')]")
	WebElement viewCart;
	
	//search the product and add to cart
	public void searchItem(String productName, String productUrl) throws InterruptedException {
		searchBox.sendKeys(productName);
		searchIcon.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
		//handleActions(productUrl);
		//WebElement selectProduct=driver.findElement(By.xpath("//div[@class='column-left']//a[@href='"+productUrl+"']"));
		//selectProduct.click();	
		
		WebElement addProductToCart = driver.findElement(By.xpath("//a[@href='"+productUrl+"']/ancestor::div[@class='column-middle']/following-sibling::div//button[contains(@class,'add-to-cart-button')]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;					
		js.executeScript("arguments[0].scrollIntoView(true)", driver.findElement(By.xpath("//a[@href='"+productUrl+"']/ancestor::li[@class='sku-item']")));			
		
		Thread.sleep(7000);
		js.executeScript("arguments[0].click()",addProductToCart);	
		
		Thread.sleep(5000);
		viewCart.click();
					
	}
	
	//filter the search result
	public void searchAndFilter(String productName, String price, String brand, String features, String color) throws InterruptedException {
		searchBox.sendKeys(productName);
		searchIcon.click();
		Thread.sleep(2000);
		
		WebElement selectPrice=driver.findElement(By.xpath("//fieldset[@name='Price']//a[text()='"+price+"']"));
		selectPrice.click();

		WebElement selectBrand=driver.findElement(By.xpath("//fieldset[@name='Brand']//a[text()='"+brand+"']"));
		selectBrand.click();
		
		WebElement selectFeatures=driver.findElement(By.xpath("//fieldset[@name='Features']//a[text()='"+features+"']"));
		selectFeatures.click();
		
		WebElement selectColor=driver.findElement(By.xpath("//fieldset[@name='Color']//a[text()='"+color+"']"));
		selectColor.click();
	}
}
