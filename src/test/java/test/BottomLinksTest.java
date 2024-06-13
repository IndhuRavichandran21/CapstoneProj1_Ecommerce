package test;

import org.testng.annotations.Test;

import base.ProjectSpecificationMethod;
import pages.BottomLinkValidation;

public class BottomLinksTest extends ProjectSpecificationMethod{

	@Test(priority = 1)
	public void bottomLinkValidation() {
		BottomLinkValidation bottomLinkPageObj = new BottomLinkValidation(driver);
		bottomLinkPageObj.validateBottomLinks();
	}
	
}
