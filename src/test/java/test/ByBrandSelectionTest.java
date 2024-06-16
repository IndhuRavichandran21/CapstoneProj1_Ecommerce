package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.ProjectSpecificationMethod;
import pages.SearchByBrand;

public class ByBrandSelectionTest extends ProjectSpecificationMethod{

	//Add item to card through brand selection
	@Test(priority = 1, dataProvider = "searchByBrand")
	public void selectByBrand(String brandName, String product, String productUrl) {
		SearchByBrand searchByBrandObj = new SearchByBrand(driver);
		searchByBrandObj.selectByBrand(brandName, product, productUrl);
		Assert.assertEquals(driver.getTitle(), "Cart - Best Buy");
	}
}
