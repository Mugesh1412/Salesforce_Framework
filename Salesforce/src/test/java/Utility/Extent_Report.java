package Utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Extent_Report extends baseClass{

	public ExtentReports Get_Reports() {
		ExtentSparkReporter reporter = new ExtentSparkReporter("./Reports/testReport.html");
		reporter.config().setReportName("Salesforce");
		reporter.config().setDocumentTitle("Test Execution Results");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("TEST EXECUTED BY", "Mugesh");
		return extent;
		
	}
	
	 public ExtentReports getExtent() {
	        return extent;
	    }

}
