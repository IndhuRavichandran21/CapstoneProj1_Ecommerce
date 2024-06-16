package pages;

import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MenuValidation {
	WebDriver driver;
	String menuBarText;
	String menuDropDownText;

	public MenuValidation(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//ul[contains(@class,'bottom-nav-left')]//a[@aria-hidden='false']")
	List<WebElement> menuBars;
	
	@FindBy(xpath = "//button[@data-lid='hdr_utility_more']")
	WebElement menuDropDownIcon;
	
	@FindBy(xpath = "//a[@class='utility-menu-flyout-list-item']")
	List<WebElement> menuDropDownList;
	
	@FindBy(xpath = "//button[contains(@class,'menuCloseBtn ')]")
	WebElement closeMenu;
	
	//validate each menu by verifying the title
	public void navigateEachMenu() {
		for(int i=0;i<menuBars.size();i++) {
			WebElement menuBar=menuBars.get(i);
			menuBarText=menuBar.getText();
			menuBar.click();		
			System.out.println("text= "+menuBarText+" title= "+driver.getTitle());
			
			if(driver.getTitle().contains(menuBarText)) {
				System.out.println("The title of "+ menuBarText +" is valid");
			}
			else 
				System.out.println("The title of "+ menuBarText +" is not valid");
		
		}
		
		menuDropDownIcon.click();

		for(int i=0;i<menuDropDownList.size();i++) {
			WebElement menu=menuDropDownList.get(i);
			menuDropDownText=menu.getText();
			menu.click();		
			System.out.println("text= "+menuDropDownText+" title= "+driver.getTitle());
			
			if(driver.getTitle().contains(menuDropDownText)) {
				System.out.println("The title of "+ menuDropDownText +" is valid");
			}
			else 
				System.out.println("The title of "+ menuDropDownText +" is not valid");
			menuDropDownIcon.click();
		}
		
		closeMenu.click();
	}

}
