package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage{
	WebDriver driver;

	public SignInPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "fld-e")
	WebElement signIn_EmailId;
	
	@FindBy(id = "fld-p1")
	WebElement signIn_Password;
	
	@FindBy(xpath = "//button[text()='Sign In']")
	WebElement signIn;
	
	@FindBy(xpath = "//button[text()='Continue as Guest']")
	WebElement guest_User;

	//enter login credentials
	public void enterLoginCredentials(String emailId,String password) {
		signIn_EmailId.sendKeys(emailId);
		signIn_Password.sendKeys(password);
		signIn.click();
	}
	
	//select guest user to place order
	public void guestUser() {
		guest_User.click();
	}
}
