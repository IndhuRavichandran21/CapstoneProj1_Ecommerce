package pages;

import org.openqa.selenium.By;
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
			handleActions(productUrl);
			viewCart.click();
		} catch (Exception e) {
			System.out.println("Product Not Found");
		}

	}
}
