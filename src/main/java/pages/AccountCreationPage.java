package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountCreationPage {

	WebDriver driver;
	SignInPage signInObjPageObj;

	public AccountCreationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		signInObjPageObj = new SignInPage(driver);
	}
	
	
	@FindBy(id="firstName")
	WebElement register_FirstName;
	
	@FindBy(id="lastName")
	WebElement register_LastName;
	
	@FindBy(id="email")
	WebElement register_Email;
	
	@FindBy(id="fld-p1")
	WebElement register_Password;
	
	@FindBy(id="reenterPassword")
	WebElement register_ConfirmPassword;
	
	@FindBy(id="phone")
	WebElement register_PhoneNumber;
	
	@FindBy(xpath="//button[text()='Create an Account']")
	WebElement createAccount;
	
	@FindBy(css = ".cia-create__signin>a")
	WebElement userExists_SignIn;
	
	//enter user credentials for account creation
	public void enterAccountCreationCredentials(String firstName,String lastName, String emailId, String password, String confirmPassword, String phoneNumber) {
		register_FirstName.sendKeys(firstName);
		register_LastName.sendKeys(lastName);
		register_Email.sendKeys(emailId);
		register_Password.sendKeys(password);
		register_ConfirmPassword.sendKeys(confirmPassword);
		register_PhoneNumber.sendKeys(phoneNumber);
		createAccount.click();
		if(userExists_SignIn.isDisplayed()) {
			userExists_SignIn.click();
			signInObjPageObj.enterLoginCredentials(emailId, password);
		}
			
	}
}
