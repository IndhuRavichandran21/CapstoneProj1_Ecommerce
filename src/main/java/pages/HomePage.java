package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(@class,'create-account-btn')]")));
		elementCreateAccount.click();
	}
	
	//select sign In btn
	public void clickSignIn() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(@class,'sign-in-btn')]")));
		elementSignIn.click();
	}

}
