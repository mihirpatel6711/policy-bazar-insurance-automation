
package utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
//import java.net.URL;
import java.net.URL;



import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseClass;



/**
 * ExtentReportManager is a TestNG listener class that integrates ExtentReports
 * to generate detailed HTML reports for test execution.
 * 
 * It listens to test lifecycle events (start, success, failure, skip, finish)
 * and logs them into a styled report with screenshots and metadata.
 */

public class ExtentReportManager implements ITestListener {
	
	//ExtentSparkReporter is responsible for creating the HTML report file
	public ExtentSparkReporter sparkReporter;
	
	// ExtentReports is the main class that manages the report lifecycle
	public static  ExtentReports extent;	
	public ExtentTest test;

	// Report file name with timestamp
	String repName;

	

	/**
	     * Called when the test suite starts.
	     * Initializes the Extent report, sets metadata, and configures the report theme.
	     *
	     * @param testContext TestNG context object containing suite and test info
	     */
	public void onStart(ITestContext testContext) {
		
		/*SimpleDateFormat df=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
		Date dt=new Date();
		String currentdatetimestamp=df.format(dt);
		*/
		
		
		// Generate a timestamp for the report filename
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());// time stamp
		
		// Create a unique report name using the timestamp
		repName = "Test-Report-" + timeStamp + ".html";
		
		//Initialize the SparkReporter with the report file path
		sparkReporter = new ExtentSparkReporter(".\\reports\\" + repName);// specify location of the report
		
		// Set report document title (shown in browser tab)
		sparkReporter.config().setDocumentTitle("Policy-Bazar Automation"); 
		
		// Set report name (shown at the top of the report)
		sparkReporter.config().setReportName("Policy Bazar functional Testing"); 
		
		// Set the visual theme of the report (DARK or STANDARD)
		sparkReporter.config().setTheme(Theme.DARK);
		
		// Initialize ExtentReports and attach the SparkReporter
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		
		// Add system/environment info to the report
		extent.setSystemInfo("Application", "Policy-Bazar");
		extent.setSystemInfo("Module", "Admin");
		extent.setSystemInfo("Sub Module", "Customers");
		extent.setSystemInfo("User Name", System.getProperty("user.name"));
		extent.setSystemInfo("Environemnt", "QA");
		
		// Fetch OS and browser info from test parameters and add to report
		String os = testContext.getCurrentXmlTest().getParameter("os");
		extent.setSystemInfo("Operating System", os);
		
		
		String browser = testContext.getCurrentXmlTest().getParameter("browser");
		extent.setSystemInfo("Browser", browser);
		
		// If any groups are included in the test suite, log them in the report
		List<String> includedGroups = testContext.getCurrentXmlTest().getIncludedGroups();
		if(!includedGroups.isEmpty()) {
		extent.setSystemInfo("Groups", includedGroups.toString());
		}
	}

//	public void onTestSuccess(ITestResult result) {
//	
//		test = extent.createTest(result.getTestClass().getName());
//		test.assignCategory(result.getMethod().getGroups()); // to display groups in report
//		test.log(Status.PASS,result.getName()+" got successfully executed");
//		
//		try {
//			String imgPath = new BaseClass().captureScreen(result.getName());
//			test.addScreenCaptureFromPath(imgPath);
//			
//		} catch (IOException e1) {
//			e1.printStackTrace();
//		}
//		
//	}


	/**
	     * Called when a test case fails.
	     * Logs the failure status, error message, and attaches a screenshot.
	     *
	     * @param result ITestResult object containing test method info
	     */	
	public void onTestFailure(ITestResult result) {
		
		// Create a new test entry in the report using the class name
		test = extent.createTest(result.getTestClass().getName());
		
		// Assign groups to the test (if any)
		test.assignCategory(result.getMethod().getGroups());
		
		// Log the failure status and test name
		test.log(Status.FAIL,result.getName()+" got failed");
		
		// Log the exception or error message that caused the failure
		test.log(Status.INFO, result.getThrowable().getMessage());
		
		// Capture and attach screenshot to the report
		try {
			String imgPath = new BaseClass().captureScreen(result.getName());
			test.addScreenCaptureFromPath(imgPath);
			
		} catch (IOException e1) {
			e1.printStackTrace(); // Log error if screenshot fails
		}
	}


	/**
	     * Called when a test case is skipped.
	     * Logs the skip status and reason.
	     *
	     * @param result ITestResult object containing test method info
	     */	
	public void onTestSkipped(ITestResult result) {
		
		// Create a new test entry in the report
		test = extent.createTest(result.getTestClass().getName());
		
		// Assign groups to the test (if any)
		test.assignCategory(result.getMethod().getGroups());
		
		// Log the skip status and test name
		test.log(Status.SKIP, result.getName()+" got skipped");
		
		// Log the reason for skipping (exception or condition)
		test.log(Status.INFO, result.getThrowable().getMessage());
	}


    /**
     * Called when the test suite finishes.
     * Flushes the report to disk and opens it in the default browser.
     *
     * @param testContext TestNG context object
     */
	public void onFinish(ITestContext testContext) {
		
		// Write all test information to the report file
		
		extent.flush();
		
		// Construct the full path to the generated report
		String pathOfExtentReport = System.getProperty("user.dir")+"\\reports\\"+repName;
		File extentReport = new File(pathOfExtentReport);
		
		// Automatically open the report in the default system browser		
		try {
			Desktop.getDesktop().browse(extentReport.toURI());
		} catch (IOException e) {
			e.printStackTrace();  // Log error if report fails to open
		}		
		 
	}

}

