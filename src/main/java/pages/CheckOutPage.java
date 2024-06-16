package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CheckOutPage {

	WebDriver driver;
	
	public CheckOutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[text()='Choose Pickup Location']")
	WebElement pickupBtn;
	
	@FindBy(css = "input#firstName")
	WebElement elementFirstName;
	
	@FindBy(css = "input#lastName")
	WebElement elementLastName;
	
	@FindBy(css = "input#street")
	WebElement elementAddress;
	
	@FindBy(css = "input#city")
	WebElement elementCity;
	
	@FindBy(css = "select#state")
	WebElement elementState;
	
	@FindBy(css = "input#zipcode")
	WebElement elementZipCode;
	
	@FindBy(xpath = "//span[text()='Apply']/parent::button")
	WebElement applyAddressDetails;
	
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
	
	public void enterContactInfo(String firstName, String lastName, String address, String city, String state, String zipCode, String emailID, String phoneNumber) throws InterruptedException {
		
		Thread.sleep(1000);
		int size = driver.findElements(By.cssSelector("div.shipping-location-address-container")).size();
		if(size==1) {
			elementFirstName.sendKeys(firstName);
		    elementLastName.sendKeys(lastName);
		    elementAddress.sendKeys(address);
		    elementCity.sendKeys(city);		
		    Select selectObj = new Select(elementState);
		    selectObj.selectByVisibleText(state);
		    elementZipCode.sendKeys(zipCode);
		    applyAddressDetails.click();
			element_emailID.sendKeys(emailID);
		    element_phoneNumber.sendKeys(phoneNumber);
		}
			
		else {
			element_emailID.sendKeys(emailID);
		    element_phoneNumber.sendKeys(phoneNumber);
		}
			
		    proceedPayment.click();
	}
}
