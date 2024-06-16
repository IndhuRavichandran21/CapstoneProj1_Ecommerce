package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethod;
import pages.SearchByDepartment;

public class ByDepartmentSelectionTest extends ProjectSpecificationMethod{

	//Add item to card through department selection
	@Test(priority = 1, dataProvider = "searchByDept")
	public void selectByDept(String department, String productCategory, String productSubCategory, String productUrl) {
		SearchByDepartment searchByDeptObj = new SearchByDepartment(driver);
		searchByDeptObj.selectByDept(department, productCategory, productSubCategory, productUrl);
		Assert.assertEquals(driver.getTitle(), "Cart - Best Buy");
	}
	
}
