package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PaymentPage {
 
	WebDriver driver;
	
	public PaymentPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "number")
	WebElement elementCardNumber;
	
	@FindBy(id = "first-name")
	WebElement elementFirstName;
	
	@FindBy(id = "last-name")
	WebElement elementLastName;
	
	@FindBy(id = "address-input")
	WebElement elementAddress;
	
	@FindBy(id = "city")
	WebElement elementCity;
	
	@FindBy(id = "state")
	WebElement elementState;
	
	@FindBy(id = "postalCode")
	WebElement elementZipCode;
	
	@FindBy(css = "[data-track='Place your Order - Contact Card']")
	WebElement placeOrder;
	
	//enter payment details
	public void paymentDetails(String cardNumber, String firstName, String lastName, String address, String city, String state, String zipCode) {
		int size = driver.findElements(By.id("billing-address-checkbox")).size();
		if(size==1)
		elementCardNumber.sendKeys(cardNumber);
		else {
			elementCardNumber.sendKeys(cardNumber);
			elementFirstName.sendKeys(firstName);
			elementLastName.sendKeys(lastName);
			elementAddress.sendKeys(address);
			elementCity.sendKeys(city);
			
			Select selectObj = new Select(elementState);
			selectObj.selectByVisibleText(state);
			elementZipCode.sendKeys(zipCode);
		}
		
		placeOrder.click();
		
	}
}
