package Utility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

public class listener extends baseClass implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
	
		test=extent.createTest(result.getMethod().getMethodName());
		test.log(Status.INFO, "Test case started execution: "+ result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.pass("Test Case Passed:" + result.getName());
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.fail("Test case failed: " +result.getName());
		test.fail("Test case error or exception: " +result.getThrowable());
		String filepath= null;
		try {
			driver= (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			filepath=takeScreenShot(result.getMethod().getMethodName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.addScreenCaptureFromPath(filepath, result.getMethod().getMethodName());

		
	}    

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
		
	}   
	 
	

	
	
}
