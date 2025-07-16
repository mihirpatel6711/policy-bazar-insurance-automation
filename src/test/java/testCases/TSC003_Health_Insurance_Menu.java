package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import pageObjects.HealthInsurancePage;
import pageObjects.HomePage;
import testBase.BaseClass;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import utilities.ExtentReportManager;

/**
 * Test Script: TSC003_Health_Insurance_Menu
 * Objective: Validates the navigation and interactions involving the 'Insurance Products'
 *            and 'Health Insurance' menus across homepage and health insurance section.
 */

public class TSC003_Health_Insurance_Menu extends BaseClass {
	
	// Page Object References
	static HealthInsurancePage Health;
	static HomePage Home;
	ExtentTest extentTest;
	
	/**
	 * Test Method: Test1
	 * Description: Validates the functionality of the Insurance Products dropdown on the Travel Insurance page.
	 *              This test hovers over the Insurance Products menu, checks the visibility of the dropdown,
	 *              and verifies that the "Health Insurance" element is clickable upon interaction.
	 */

	@Test
	public void testHealthInsuranceDropdownAndClickability() {
		
		extentTest = ExtentReportManager.extent.createTest("Health Insurance Test Case - 1");
		extentTest.assignCategory("Health Insurance");
		
		
		logger.info("*** Initiated: Health Insurance Page ***");
		extentTest.log(Status.INFO, "*** Initiated: Health Insurance Page ***");
		logger.info("***TestScript-1 started***");
		extentTest.log(Status.INFO, "***TestScript-1 started***");
		
		// Initialize page object instances with WebDriver
		Home= new HomePage(driver);
		Health= new HealthInsurancePage(driver);
		
		// Hover over Insurance Products to reveal dropdown
		Home.HoverOnInsuranceProducts();
		logger.info("Action: Hovered on Insurance Dropdown");
		extentTest.log(Status.INFO, "Action: Hovered on Insurance Dropdown");
		
		// Validate presence of dropdown after hover
		try {
		Boolean check=Health.isDropdownPresent();
		Assert.assertTrue(check);
		logger.info("Verified: Dropdown is present when hovered");		
		System.out.println("TestCase-1 Passed : The dropdown is visible when hovered");
		extentTest.log(Status.PASS, "Verified: Dropdown is present when hovered");
		
		}
		catch(AssertionError e) {
        	extentTest.log(Status.FAIL, "Error message mismatch: " + e.getMessage());
        	throw e;

        }		
		
		
		// Validate that 'Health Insurance' element is clickable
		try {
		Boolean check2=Health.isHealthElementClickable(Health.healthInsurance);
		Assert.assertTrue(check2);
		logger.info("Verified: The Health Insurance is clickable");
		System.out.println("TestCase-2 Passed : The Element is \"Health Insurance\" clickable");
		extentTest.log(Status.PASS, "Verified: The Health Insurance is clickable");
		}
		catch(AssertionError e) {
        	extentTest.log(Status.FAIL, "Error message mismatch: " + e.getMessage());
        	throw e;

        }
		// on pass take screenshot
        try {
        	String captureScreen = captureScreen("Test Health Insurance - Test case-1");
        	extentTest.addScreenCaptureFromPath(captureScreen);
        }
        catch(Exception e) {
        	e.printStackTrace();
        }
		
	}
	
	/**
	 * Test Method: Test2
	 * Description: Validates interaction flow for navigating through Insurance and Health dropdowns.
	 *              This test clicks on the Health Insurance option, verifies the redirection,
	 *              hovers over the Health Insurance dropdown on the new page, checks its visibility,
	 *              and confirms that the Family Insurance menu item is clickable.
	 */

	@Test
	public void testHealthInsuranceMenuClickAndRedirect() {
		
		extentTest = ExtentReportManager.extent.createTest("Health Insurance Test Case - 2");
		extentTest.assignCategory("Health Insurance");
		

		logger.info("***TestScript-2 started***");
		extentTest.log(Status.INFO, "***TestScript-2 started***");
		
		// Hover over Insurance Products and click Health Insurance
		Home.HoverOnInsuranceProducts();
		logger.info("Action: Hovered on Insurance Dropdown");
		extentTest.log(Status.INFO, "Action: Hovered on Insurance Dropdown");
		
		// Triggers navigation to Health Insurance Page
		Home.healthInsuranceClick();
		logger.info("Action: Health Insurance is clicked");
		extentTest.log(Status.INFO, "Action: Health Insurance is clicked");
		
		//=============================Health Insurance Page===============================
		
		// Hover on Health Insurance dropdown on new page
		Health.hoverHealth(driver);
		logger.info("Action: Hovered on Health Insurance Dropdown");
		extentTest.log(Status.INFO, "Action: Hovered on Health Insurance Dropdown");
		
		// Validate presence of Health Insurance dropdown post-hover
		try {
		boolean check3=Health.isHealthDropdownPresent();
		Assert.assertTrue(check3);
		logger.info("Verified: Health dropdown is present when hovered");
		System.out.println("TestCase-3 Passed : The Health Insurance Dropdown is visbile when hovered");
		extentTest.log(Status.PASS, "Verified: Health dropdown is present when hovered");
		}
		catch(AssertionError e) {
        	extentTest.log(Status.FAIL, "Error message mismatch: " + e.getMessage());
        	throw e;
        	


        }
		
		// Validate clickability of 'Family Insurance' menu item
		try {
		Boolean check4= Health.isHealthElementClickable(Health.famInsu);
		Assert.assertTrue(check4);
		logger.info("Verified: The Menu Item in Health Insurance dropdown is clickable");
		System.out.println("TestCase-4 Passed : Menu item  is clickable ");
		extentTest.log(Status.PASS, "Verified: The Menu Item in Health Insurance dropdown is clickable");
		}
		catch(AssertionError e) {
        	extentTest.log(Status.FAIL, "Error message mismatch: " + e.getMessage());
        	throw e;

        }
		
		// Validate the redirection behavior after interaction
		try {
		Boolean check5=Health.validateRedirection(driver);
		Assert.assertTrue(check5);
		logger.info("Verified: The link redirects correctly.");
		System.out.println("TestCase-5 Passed : There is proper redirection");
		extentTest.log(Status.PASS, "Verified: The link redirects correctly.");
		}
		catch(AssertionError e) {
        	extentTest.log(Status.FAIL, "Error message mismatch: " + e.getMessage());
        	throw e;

        }
		
		// on pass take screenshot
        try {
        	String captureScreen = captureScreen("Test Health Insurance- Test case-2");
        	extentTest.addScreenCaptureFromPath(captureScreen);
        }
        catch(Exception e) {
        	e.printStackTrace();
        }
		
	}
}
