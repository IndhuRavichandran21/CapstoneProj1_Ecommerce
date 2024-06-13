package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage {

	WebDriver driver;
	
	public CheckOutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[text()='Choose Pickup Location']")
	WebElement pickupBtn;
	
	@FindBy(id = "user.emailAddress")
	WebElement element_emailID;
	
	@FindBy(id = "user.phone")
	WebElement element_phoneNumber;
	
	@FindBy(css = "div.button--continue")
	WebElement proceedPayment;
	
	public void pickUpLocation(String storeID) {
		pickupBtn.click();
		WebElement selectStore = driver.findElement(By.cssSelector("[data-store-id='"+storeID+"']"));
		selectStore.click();	
	}
	
	public void enterContactInfo(String emailID, String phoneNumber) {
		element_emailID.sendKeys(emailID);
		element_phoneNumber.sendKeys(phoneNumber);
		proceedPayment.click();
	}
}
