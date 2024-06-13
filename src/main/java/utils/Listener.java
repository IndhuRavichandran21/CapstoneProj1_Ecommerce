package utils;

import java.io.IOException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import base.ProjectSpecificationMethod;

public class Listener extends ProjectSpecificationMethod implements ITestListener{

	ExtentReports extentReports = EcommerceReport.getReport();
	ExtentTest test;
	String screenshotFilePath;
	
	@Override
	public void onTestStart(ITestResult result) {
		test = extentReports.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		test.fail(result.getThrowable());
		try {
			screenshotFilePath = takeScreenshot(result.getMethod().getMethodName());
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		test.addScreenCaptureFromPath(screenshotFilePath,result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, "Test skipped");
	}

	@Override
	public void onFinish(ITestContext context) {
		extentReports.flush();
	}

}
