package test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.ProjectSpecificationMethod;
import pages.AccountCreationPage;
import pages.HomePage;

public class AccountCreationTest extends ProjectSpecificationMethod{
	
	//account creation with valid credentials
	@Test(priority = 1, dataProvider = "valid_AccountCreationDetails")
	public void createAccount_ValidCred(String firstName,String lastName, String emailId, String password, 
			String confirmPassword, String phoneNumber) throws InterruptedException{
		HomePage homePageObj = new HomePage(driver);
		AccountCreationPage accountCreationPageObj = new AccountCreationPage(driver);
		homePageObj.clickAccountSelection();
		homePageObj.clickCreateAccount();
		accountCreationPageObj.enterAccountCreationCredentials(firstName,lastName,emailId,password,confirmPassword,phoneNumber);
		
	}
	
	//account creation with Invalid credentials
	@Test(priority = 2, dataProvider = "invalid_AccountCreationDetails")
	public void createAccount_InValidCred(String firstName,String lastName, String emailId, String password, 
			String confirmPassword, String phoneNumber) throws InterruptedException{
		HomePage homePageObj = new HomePage(driver);
		AccountCreationPage accountCreationPageObj = new AccountCreationPage(driver);
		homePageObj.clickAccountSelection();
		homePageObj.clickCreateAccount();
		accountCreationPageObj.enterAccountCreationCredentials(firstName,lastName,emailId,password,confirmPassword,phoneNumber);
		Assert.assertTrue(driver.findElement(By.className("tb-validation")).isDisplayed());
	}
}
