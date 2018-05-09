package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class CustomListeners implements ITestListener {
	//we have to call these in testng.xml

	public void onTestStart(ITestResult result) {
		
		
	}

	public void onTestSuccess(ITestResult result) {
		
		
	}

	public void onTestFailure(ITestResult result) {
				
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		//above statement is used to make the below html code to work
		Reporter.log("<a href=\"abcd.html\">capture screenshot1</a>");
		System.out.println("capture screenshot");
	}

	public void onTestSkipped(ITestResult result) {
		
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	public void onStart(ITestContext context) {
		
		
	}

	public void onFinish(ITestContext context) {
		
		}

}
