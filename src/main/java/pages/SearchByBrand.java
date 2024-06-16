package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecificationMethod;

public class SearchByBrand extends ProjectSpecificationMethod{

		WebDriver driver;
		
		public SearchByBrand(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		
	@FindBy(css = ".hamburger-menu")
	WebElement menu;
	
	@FindBy(xpath = "//button[text()='Brands']")
	WebElement selectBrand;

	@FindBy(xpath = "//a[contains(@class,'go-to-cart')]")
	WebElement viewCart;

	//search the item based on brand and add it to cart
	public void selectByBrand(String brandName, String product, String productUrl) {
		menu.click();
		selectBrand.click();
		WebElement select_Brands_Category = driver.findElement(By.xpath("//a[@class='hamburger-menu-flyout-list-item  ' and text()='"+brandName+"']"));
		select_Brands_Category.click();
		
		WebElement select_Brands_SubCategory = driver.findElement(By.linkText(product));
		select_Brands_SubCategory.click();
		
		try {
			//handleActions(productUrl);
			//driver.findElement(By.xpath("//a[@href='"+productUrl+"']/ancestor::div[@class='column-middle']/following-sibling::div//div[@class='fulfillment-add-to-cart-button']"));		
			
			JavascriptExecutor js = (JavascriptExecutor) driver;					
			js.executeScript("arguments[0].scrollIntoView(true)", driver.findElement(By.xpath("//a[@href='"+productUrl+"']/ancestor::li[@class='sku-item']")));	
			WebElement addProductToCart=driver.findElement(By.xpath("//a[@href='"+productUrl+"']/ancestor::div[@class='column-middle']/following-sibling::div//div[@class='fulfillment-add-to-cart-button']"));		
			Thread.sleep(10000);
			addProductToCart.click();	
			Thread.sleep(10000);
			viewCart.click();
			
		} 
		catch (Exception e) {
			System.out.println("Product Not Found");
		}
						
	}
}
