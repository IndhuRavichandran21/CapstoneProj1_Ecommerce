package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class EcommerceReport {

	public static ExtentReports getReport() {
		String filePath = "C:\\Users\\Admin\\Desktop\\Indhu_ZenClass\\JavaPrograms\\eclipse-workspace\\capstoneProj1\\report\\EcommerceReport.html";
		ExtentSparkReporter reporter =new ExtentSparkReporter(filePath);
		reporter.config().setReportName("Ecommerce Report");
		
		ExtentReports extentReports = new ExtentReports();
		extentReports.attachReporter(reporter);
		return extentReports;
	}
	
}
