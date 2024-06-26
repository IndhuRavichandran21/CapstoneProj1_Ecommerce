package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	
	WebDriver driver;
	
	public CartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[text()='Checkout']")
	WebElement checkOutBtn;
	
	//select checkout button 
	public void checkOut() throws InterruptedException {
		Thread.sleep(5000);
		checkOutBtn.click();	
	}
}
