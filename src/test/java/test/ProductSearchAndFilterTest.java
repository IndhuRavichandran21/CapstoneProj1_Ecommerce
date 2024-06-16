package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.ProjectSpecificationMethod;
import pages.SearchAndFilterPage;

public class ProductSearchAndFilterTest extends ProjectSpecificationMethod{

	//search the product
	@Test(priority = 1, dataProvider = "productDetails")
	public void searchProduct(String productName, String productUrl) throws InterruptedException{
		
		SearchAndFilterPage searchAndFilterObj = new SearchAndFilterPage(driver);
		searchAndFilterObj.searchItem(productName, productUrl);
		Assert.assertEquals(driver.getTitle(), "Cart - Best Buy");
	}
	
	//search the product and filter the search result
	@Test(priority = 2, dataProvider = "filterOptions")
	public void filterSearchResults(String productName, String price, String brand, String features, String color) throws InterruptedException {
		
		SearchAndFilterPage searchAndFilterObj = new SearchAndFilterPage(driver);
		searchAndFilterObj.searchAndFilter(productName, price, brand, features, color);
	}
}
