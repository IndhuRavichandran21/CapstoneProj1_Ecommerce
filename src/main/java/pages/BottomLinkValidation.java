package pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BottomLinkValidation {
	
	WebDriver driver;

	public BottomLinkValidation(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[contains(@class,'main-navigation')]")
	WebElement bottomLink;
	
	@FindBy(xpath="//a[@data-lid='ft_op_price_match_guarantee']")
	WebElement priceMatchLink;
	
	@FindBy(xpath="//a[@data-lid='ft_support_contact_us']")
	WebElement contactUsLink;
	
	@FindBy(xpath="//a[@data-lid='ft_partner_affiliate_program']")
	WebElement affliatePrgmLink;
	
	@FindBy(xpath="//a[@data-lid='ft_pay_my_best_buy_credit_card']")
	WebElement creditCardLink;
	
	@FindBy(xpath="//a[@data-lid='ft_member_best_buy_membership']")
	WebElement membershipLink;
	
	@FindBy(xpath="//a[@data-lid='ft_about_corporate_information']")
	WebElement corporateInfoLink;
	
	List<WebElement> list = new ArrayList<>();
	public void validateBottomLinks() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", bottomLink);

		list.add(priceMatchLink);
		list.add(contactUsLink);
		list.add(affliatePrgmLink);
		list.add(creditCardLink);
		list.add(membershipLink);
		list.add(corporateInfoLink);
		
		for (WebElement webElement : list) {
			String text = webElement.getText();
			webElement.click(); 
			String title = driver.getTitle();
 			if(title.contains(text)){
				System.out.println("The title of "+ title + " is valid");
			}
			else
				System.out.println("The title of "+ title + " is not valid");
		}
	
		
	}

}
