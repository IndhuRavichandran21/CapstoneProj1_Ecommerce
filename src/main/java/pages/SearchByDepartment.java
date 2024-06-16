package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecificationMethod;

public class SearchByDepartment extends ProjectSpecificationMethod{

	WebDriver driver;
	
	public SearchByDepartment(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = ".hamburger-menu")
	WebElement menu;
	
	@FindBy(xpath = "//a[contains(@class,'go-to-cart')]")
	WebElement viewCart;
	
	//search the item based on department and add it to cart
	public void selectByDept(String department, String productCategory, String productSubCategory, String productUrl) {
		menu.click();
		WebElement selectDept = driver.findElement(By.xpath("//button[text()='"+department+"']"));
		selectDept.click();
		
		WebElement selectCategory = driver.findElement(By.xpath("//button[text()='"+productCategory+"']"));
		selectCategory.click();
		if(driver.findElement(By.xpath("//li//button")).isDisplayed()) {
			WebElement selectSubCategory = driver.findElement(By.linkText(productSubCategory));
			selectSubCategory.click();
		}
		
		try {
			//handleActions(productUrl);
			//driver.findElement(By.xpath("//a[@href='"+productUrl+"']/ancestor::div[@class='column-middle']/following-sibling::div//div[@class='fulfillment-add-to-cart-button']"));		
			
			JavascriptExecutor js = (JavascriptExecutor) driver;					
			js.executeScript("arguments[0].scrollIntoView(true)", driver.findElement(By.xpath("//a[@href='"+productUrl+"']/ancestor::li[@class='sku-item']")));	
			WebElement addProductToCart=driver.findElement(By.xpath("//a[@href='"+productUrl+"']/ancestor::div[@class='column-middle']/following-sibling::div//div[@class='fulfillment-add-to-cart-button']"));		
			Thread.sleep(7000);
			addProductToCart.click();	
			Thread.sleep(7000);
			viewCart.click();
			
		} 
		catch (Exception e) {
			System.out.println("Product Not Found");
		}

	}
}
