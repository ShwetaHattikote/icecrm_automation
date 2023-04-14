package com.icrhrm_automation.utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListners implements ITestListener{

//	String reportPath;
//	ExtentReports extentReporter;
	/*
	 * @Override public void onStart(ISuite suite) { // ISuiteListener
	 * System.out.println("This is onStart of ISuite from TestListners"); }
	 * 
	 * @Override public void onFinish(ISuite suite) { // ISuiteListener
	 * System.out.println("This is onFinish of ISuite from TestListners");
	 * //extentReporter.flush(); ExtentTestManager.endTest();
	 * 
	 * }
	 */

	@Override
	public void onStart(ITestContext context) {
		System.out.println("This is onStart of ITestContext from TestListners");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("This is onFinish of ITestContest from TestListners");
		ExtentTestManager.endTest();
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("This is onTestStart of ITestResult from TestListners");
		String methodName = result.getMethod().getMethodName();
		ExtentTestManager.createTest(methodName);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("This is onTestSuccess of ITestResult from TestListners");
//		captureScreenShot(result);
		
		/*
		 * System.out.println("ReportPath is "+ reportPath); String screenShotPath =
		 * reportPath + "/" + result.getMethod().getMethodName() + ".jpg";
		 * System.out.println("ScreenShot file name "+screenShot);
		 * 
		 * TakesScreenshot takesScreenshot = (TakesScreenshot)driver;
		 * System.out.println("Take screenShot "+takesScreenshot); File sourceFile =
		 * takesScreenshot.getScreenshotAs(OutputType.FILE); File destinationFile = new
		 * File(screenShot);
		 * 
		 * try { FileUtils.copyFile(sourceFile, destinationFile); } catch (IOException
		 * e) { // e.printStackTrace(); throw new RuntimeException(e); }
		 */
		//log.fail(result.getThrowable().getMessage());
		//log.addScreenCaptureFromPath(screenShotPath, "Failed screenshot");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("This is onTestFailure of ITestResult from TestListners");
		ExtentTestManager.getTest().fail(result.getThrowable());
//		captureScreenShot(result);
		/*
		 * String screenShot = reportPath + "/" + result.getMethod().getMethodName() +
		 * ".jpg"; TakesScreenshot takesScreenshot = (TakesScreenshot) driver; File
		 * sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE); File
		 * destinationFile = new File(screenShot);
		 * 
		 * try { FileUtils.copyFile(sourceFile, destinationFile); } catch (IOException
		 * e) { // e.printStackTrace(); throw new RuntimeException(e); }
		 */
	}
}
