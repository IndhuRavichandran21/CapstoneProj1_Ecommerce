package pages;

import org.openqa.selenium.By;
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

	public void selectByBrand(String brandName, String product, String productUrl) {
		menu.click();
		selectBrand.click();
		WebElement select_Brands_Category = driver.findElement(By.xpath("//a[@class='hamburger-menu-flyout-list-item  ' and text()='"+brandName+"']"));
		select_Brands_Category.click();
		
		WebElement select_Brands_SubCategory = driver.findElement(By.linkText(product));
		select_Brands_SubCategory.click();
		
		try {
			handleActions(productUrl);
			viewCart.click();
		} catch (Exception e) {
			System.out.println("Product Not Found");
		}
						
	}
}
