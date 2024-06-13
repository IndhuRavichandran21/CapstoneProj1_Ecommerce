package test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.ProjectSpecificationMethod;
import pages.HomePage;
import pages.SignInPage;

public class SignInTest extends ProjectSpecificationMethod{
	
	@Test(priority = 1, dataProvider = "valid_signInDetails")
	public void signIn_ValidCred(String emailId,String password) {
		HomePage homePageObj = new HomePage(driver);
		SignInPage signInPageObj = new SignInPage(driver);
		homePageObj.clickAccountSelection();
		homePageObj.clickSignIn();
		signInPageObj.enterLoginCredentials(emailId, password);
	}
	
	@Test(priority = 2, dataProvider = "invalid_signInDetails")
	public void signIn_InValidCred(String emailId,String password) {
		HomePage homePageObj = new HomePage(driver);
		SignInPage signInPageObj = new SignInPage(driver);
		homePageObj.clickAccountSelection();
		homePageObj.clickSignIn();
		signInPageObj.enterLoginCredentials(emailId, password);
		Assert.assertTrue(driver.findElement(By.className("tb-validation")).isDisplayed());
	}
}
