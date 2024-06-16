package base;

import java.io.IOException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import utils.Utility;

public class ProjectSpecificationMethod extends Utility{

	
	@BeforeSuite
	@Parameters({"siteUrl"})
	//check for the url is broken or not
	public void validateUrlConnection(String siteUrl) throws IOException {			
		urlConnectionValidation(siteUrl);		
	}
	
	@Parameters({"browser","siteUrl","country"})
	@BeforeMethod
	//launch the browser and select country
	public void launchBrowser(String browser, String siteUrl, String country) {
		browserLaunch(browser,siteUrl);
		selectCountry(country);
	}
	
	
	@AfterMethod
	//close the browser after each Test
	public void closeBrowser() {
		browserClose();
	}
	
	@DataProvider
	public String[][] valid_AccountCreationDetails() throws IOException {
		return getExcelData("Valid_AccountCreationDetails"); //passing the sheet name of the excel to get data
	}
	
	@DataProvider
	public String[][] invalid_AccountCreationDetails() throws IOException {
		return getExcelData("InValid_AccountCreationDetails");
	}
	
	@DataProvider
	public String[][] valid_signInDetails() throws IOException {
		return getExcelData("Valid_SignInDetails");
	}
	
	@DataProvider
	public String[][] invalid_signInDetails() throws IOException {
		return getExcelData("InValid_SignInDetails");
	}
	
	@DataProvider
	public String[][] productDetails() throws IOException {
		return getExcelData("ProductDetails");
	}
	
	@DataProvider
	public String[][] searchByDept() throws IOException {
		return getExcelData("SearchByDept");
	}
	
	@DataProvider
	public String[][] searchByBrand() throws IOException {
		return getExcelData("SearchByBrand");
	}
	
	@DataProvider
	public String[][] paymentDetails() throws IOException {
		return getExcelData("PaymentDetails");
	}
	
	@DataProvider
	public String[][] filterOptions() throws IOException {
		return getExcelData("FilterOptions");
	}
}
