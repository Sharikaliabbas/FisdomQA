package utils;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.ExtentReports;

public class ExtentReporterNG {
	
    static ExtentReports extent;
	
	public static ExtentReports extentReportGenerator() {
		
	String path = System.getProperty("user.dir")+"\\reports\\output.html";
	
	ExtentSparkReporter reporter = new ExtentSparkReporter(path);
	
	reporter.config().setReportName("FISDOM_QA_Automation");
	
	reporter.config().setDocumentTitle("BookingTestCases");
	
	extent = new ExtentReports();
	
	extent.attachReporter(reporter);
	
	extent.setSystemInfo("Tester", "Sharik");
	
	return extent;
	
	
	
	} 
}
