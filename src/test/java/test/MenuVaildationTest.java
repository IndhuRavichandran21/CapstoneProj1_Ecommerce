package test;

import org.testng.annotations.Test;

import base.ProjectSpecificationMethod;
import pages.MenuValidation;

public class MenuVaildationTest extends ProjectSpecificationMethod{

	@Test(priority = 1)
	public void validateMenu() {
		MenuValidation menuValidationObj = new MenuValidation(driver);
		menuValidationObj.navigateEachMenu();
	}
}
