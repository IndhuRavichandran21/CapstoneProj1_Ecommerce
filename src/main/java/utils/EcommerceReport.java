package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class EcommerceReport {

	public static ExtentReports getReport() {
		String filePath = "C:\\Users\\Admin\\Desktop\\Indhu_ZenClass\\JavaPrograms\\eclipse-workspace\\capstoneProj1\\report\\EcommerceReport.html";
		ExtentSparkReporter reporter =new ExtentSparkReporter(filePath); //create html file in the path
		reporter.config().setReportName("Ecommerce Report"); //set the name of the report
		
		ExtentReports extentReports = new ExtentReports();
		extentReports.attachReporter(reporter); //get the information and attach it to the report file
		return extentReports;
	}
	
}
