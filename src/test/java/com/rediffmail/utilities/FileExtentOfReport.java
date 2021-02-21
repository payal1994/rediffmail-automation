package com.rediffmail.utilities;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class FileExtentOfReport {
	private static ExtentHtmlReporter htmlReporter;
	private static ExtentTest extentTest;
	static ScreenShot screenshort;
	private static ExtentReports extent;
	
	public FileExtentOfReport(WebDriver driver){
			screenshort= new ScreenShot(driver);
		}
	public static ExtentReports getExtentReport() {
		if(extent == null){
				htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/extendReport.html");
				extent = new ExtentReports();
		        extent.attachReporter(htmlReporter);
		        htmlReporter.config().setDocumentTitle("ELearning Extent Report");
		        htmlReporter.config().setReportName("Test Report");
		        htmlReporter.config().setTheme(Theme.DARK);
		        htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");	
		        }
		return extent;		
	}
	public static void getExecutionStatus(ITestResult result) throws IOException {
		if(result.getStatus() == ITestResult.FAILURE) {
			extentTest.addScreenCaptureFromPath(screenshort.captureScreen());
			extentTest.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" FAILED ", ExtentColor.RED));
			extentTest.fail(result.getThrowable());
		}
        else if(result.getStatus() == ITestResult.SUCCESS) {
        	extentTest.addScreenCaptureFromPath(screenshort.captureScreen());
           extentTest.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" PASSED ", ExtentColor.GREEN));
        	}
        else{
        	extentTest.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" SKIPPED ", ExtentColor.ORANGE));
        	extentTest.skip(result.getThrowable());
        }
    }
	public static void startExecutionOfTest(String testName){
		extent = getExtentReport();
		extentTest = extent.createTest(testName);
	}
	public static void stopExecutionOfTest(){
		extent.flush();
	}
	public static ExtentTest getExtentTest(){
		return extentTest;
	}
	
}
