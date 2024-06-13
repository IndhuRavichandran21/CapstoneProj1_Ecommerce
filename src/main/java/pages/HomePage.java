package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = ".shop-account-menu")
	WebElement elementAccountTab;
	
	@FindBy(xpath = "//a[contains(@class,'create-account-btn')]")
	WebElement elementCreateAccount;
	
	@FindBy(xpath = "//a[contains(@class,'sign-in-btn')]")
	WebElement elementSignIn;
	
	//select Account Tab
	public void clickAccountSelection() {
		elementAccountTab.click();
	}
	
	//select create Account btn
	public void clickCreateAccount() {
		elementCreateAccount.click();
	}
	
	//select sign In btn
	public void clickSignIn() {
		elementSignIn.click();
	}

}
