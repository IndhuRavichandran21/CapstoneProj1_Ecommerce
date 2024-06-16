package test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.ProjectSpecificationMethod;
import pages.CartPage;
import pages.CheckOutPage;
import pages.PaymentPage;
import pages.SearchAndFilterPage;
import pages.SignInPage;

public class OrderPlaceTest extends ProjectSpecificationMethod{

	//checkout item and add payment details and place the order
	@Test(priority=1, dataProvider = "paymentDetails")
	public void placeOrder(String productName, String productUrl, String emailId, 
			String phoneNumber, String cardNumber, String firstName, String lastName, 
			String address, String city, String state, String zipCode) throws InterruptedException {
		
		SearchAndFilterPage searchAndFilterObj = new SearchAndFilterPage(driver);
		CartPage cartPageObj = new CartPage(driver);
		SignInPage signInPageObj = new SignInPage(driver);
		CheckOutPage checkOutPageObj = new CheckOutPage(driver);
		PaymentPage paymentPageObj = new PaymentPage(driver);
		
		searchAndFilterObj.searchItem(productName, productUrl);
		cartPageObj.checkOut();		
		signInPageObj.guestUser();
        try {
        	
        	checkOutPageObj.enterContactInfo(firstName, lastName, address, city, state, zipCode, emailId, phoneNumber);		
    		paymentPageObj.paymentDetails(cardNumber, firstName, lastName, address, city, state, zipCode);
			
		} catch (Exception e) {
			int size1 = driver.findElements(By.xpath("//div//span[text()='Request failed because of network connection']")).size();
			if(size1==1)
			System.out.println("Unable to place the order due to network connection");
			else
				System.out.println(e);
		}
        String expectedVal = "Please enter a valid card number.";
        String actualVal = driver.findElement(By.xpath("//div[@id='cardError']//p")).getText();
        Assert.assertEquals(expectedVal, actualVal);
		
	}

}
