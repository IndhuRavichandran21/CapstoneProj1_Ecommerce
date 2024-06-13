package pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
	
	public void searchItem(String productName, String productUrl) {
		searchBox.sendKeys(productName);
		searchIcon.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		try {
			handleActions(productUrl);
			viewCart.click();
		} catch (NoSuchElementException e) {
			System.out.println("Product Not Found");
		}
		catch (Exception e) {
			System.out.println(e);
		}

	}
	
	public void searchAndFilter(String productName, String price, String brand, String features, String color) {
		searchBox.sendKeys(productName);
		searchIcon.click();

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
