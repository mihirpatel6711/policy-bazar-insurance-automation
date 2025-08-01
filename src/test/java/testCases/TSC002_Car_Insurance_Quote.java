package testCases;
import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.DataProviders;
import pageObjects.CarInsurancePage;
import pageObjects.HomePage;
import testBase.BaseClass;


import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import utilities.ExtentReportManager;



/**
 * Test Case ID: TSC002_Car_Insurance_Quote
 * Purpose: Validate the workflow of selecting car insurance options and submitting user details.
 * Data Driven: Uses test data from DataProviders for multiple combinations of user inputs.
 */

public class TSC002_Car_Insurance_Quote extends BaseClass{
	// Page object for the Home Page where car insurance option is selected
	 HomePage homePage;
	// Page object for the Car Insurance workflow containing form interactions
	 CarInsurancePage insurancePage;
	 ExtentTest extentTest;
	 
	    
		 /**
		  * Test Method: testCarInsuranceSelection
		  * Description: Executes a complete flow of selecting city, car brand, model, fuel type, variant,
		  * and inputs name and mobile number to verify the error message for invalid mobile number.
		  */
	 
	    @Test(dataProvider = "CarInsurance", dataProviderClass=DataProviders.class)
	    public void testCarInsuranceInvalidContactDetailsErrorMessage(String city, String carBrand, String carModel, String carFuelType, String carVariant, String name, String mobileNumber  ) throws InterruptedException {//For new brand car-->"click here"
	    	
	    	

	    	
			extentTest = ExtentReportManager.extent.createTest("Car Insurance Test - " + city + ", " + carBrand + ", " + carModel + ", " + carFuelType + ", " + carVariant + ", " + name + ", " + mobileNumber );
			extentTest.assignCategory("Car Insurance");

	    	Thread.sleep(1000);  // Temporary wait for UI elements to stabilize before interaction
	    	
	    	//driver.findElement(By.xpath("(//i[@class='icon-bg homeIconsBg car-insurance'])[2]")).click();
	    	
	    	homePage = new HomePage(driver); // Initialize HomePage object
	    	homePage.carInsuranceClick(); // Click on Car Insurance icon/button
	    	logger.info("Action: Car Insurance option clicked on Home Page");
	    	extentTest.log(Status.INFO, "Action: Car Insurance option clicked on Home Page");

	    	
	        insurancePage = new CarInsurancePage(driver);// Initialize CarInsurancePage object
	        Thread.sleep(1000);// Wait for page transition
	        logger.info("*** Initiated: Car Insurance Page ***");
	        extentTest.log(Status.INFO, "*** Initiated: Car Insurance Page ***");
	        
	        insurancePage.clickStart();	 // Click on "Start" button to begin form selection process
	        logger.info("Action: Start button clicked");
	        extentTest.log(Status.INFO, "Action: Start button clicked");
	        
	        // ======================== City Selection ========================
	        
	        // Verify and select the city from dropdown
	        try {
	        Assert.assertTrue(insurancePage.isListPopulated(insurancePage.selectcity), "City list not populated");
	        logger.info("Verified: City list populated");
	        extentTest.log(Status.PASS, "Verified: City list populated");
	        }
	        catch(AssertionError e) {
	        	extentTest.log(Status.FAIL, "Error message mismatch: " + e.getMessage());
	        	throw e;

	        }
	        
	        
	        // Check if the required city is clickable
	        try {
	        boolean iscityclickable = insurancePage.isCityClickable(city);
	        Assert.assertTrue(iscityclickable, "City not clickable");
	        logger.info("Verified: City '" + city + "' is clickable");
	        extentTest.log(Status.PASS, "Verified: City '" + city + "' is clickable");
	        }
	        catch(AssertionError e) {
	        	extentTest.log(Status.FAIL, "Error message mismatch: " + e.getMessage());
	        	throw e;

	        }
	        
	        
	        // Select the specified city from the dropdown
	        insurancePage.chooseCity(city);  // Select the specified city from list
	        logger.info("Action: City '" + city + "' selected");
	        extentTest.log(Status.INFO, "Action: City '" + city + "' selected");
	        
	        
	        // ======================== Brand Selection ========================	        

	        // Verify that the car brand list is populated
	        try {
	        Assert.assertTrue(insurancePage.isListPopulated(insurancePage.selectbrandname), "Brand list not populated");
	        logger.info("Verified: Brand list populated");
	        extentTest.log(Status.PASS, "Verified: Brand list populated");
	        }
	        catch(AssertionError e) {
	        	extentTest.log(Status.FAIL, "Error message mismatch: " + e.getMessage());
	        	throw e;

	        }
	        
	        
	        // Check if the specified car brand is clickable
	        try {
	        boolean isbandclickable = insurancePage.isBrandclickable(carBrand);
	        Assert.assertTrue(isbandclickable, "band not clickable");
	        logger.info("Verified: Brand '" + carBrand + "' is clickable");
	        extentTest.log(Status.PASS, "Verified: Brand '" + carBrand + "' is clickable");
	        }
	        catch(AssertionError e) {
	        	extentTest.log(Status.FAIL, "Error message mismatch: " + e.getMessage());
	        	throw e;

	        }
	        
	        
	        // Select the car brand
	        insurancePage.chooseBrand(carBrand); // Selecting the brand
	        logger.info("Action: Brand '" + carBrand + "' selected");
	        extentTest.log(Status.INFO, "Action: Brand '" + carBrand + "' selected");

	        
	        // ======================== Model Selection ========================
	        
	        
	        // Verify that car model options are available
	        try {
	        Assert.assertTrue(insurancePage.isListPopulated(insurancePage.carmodel), "Model list not populated");
	        logger.info("Verified: Model list populated");
	        extentTest.log(Status.PASS, "Verified: Model list populated");
	        }
	        catch(AssertionError e) {
	        	extentTest.log(Status.FAIL, "Error message mismatch: " + e.getMessage());
	        	throw e;

	        }
	        
	        
	        // Validate that the model option is clickable
	        try {
	        boolean ismodelclickable = insurancePage.isModelclickable(carModel);
	        Assert.assertTrue(ismodelclickable, "model not clickable");
	        logger.info("Verified: Model '" + carModel + "' is clickable");
	        extentTest.log(Status.PASS, "Verified: Model '" + carModel + "' is clickable");
	        
	        }
	        catch(AssertionError e) {
	        	extentTest.log(Status.FAIL, "Error message mismatch: " + e.getMessage());
	        	throw e;

	        }
	        
	        // Select the required car model
	        insurancePage.chooseModel(carModel); // choosing the model
	        logger.info("Action: Model '" + carModel + "' selected");
	        extentTest.log(Status.INFO, "Action: Model '" + carModel + "' selected");
	        
	        // ======================== Fuel Type Selection ========================

	        // Confirm that fuel type options are loaded
	        try {
	        Assert.assertTrue(insurancePage.isListPopulated(insurancePage.carfueltype), "Fuel type list not populated");
	        logger.info("Verified: Fuel type list populated");
	        extentTest.log(Status.PASS, "Verified: Fuel type list populated");
	        }
	        catch(AssertionError e) {
	        	extentTest.log(Status.FAIL, "Error message mismatch: " + e.getMessage());
	        	throw e;

	        }
	        
	        // Check if the fuel type can be clicked
	        try {
	        boolean isfueltypeclickable = insurancePage.isFuelTypeclickable(carFuelType);
	        Assert.assertTrue(isfueltypeclickable, "fueltype not clickable");
	        logger.info("Verified: Fuel type '" + carFuelType + "' is clickable");
	        extentTest.log(Status.PASS, "Verified: Fuel type '" + carFuelType + "' is clickable");	        
	        }
	        catch(AssertionError e) {
	        	extentTest.log(Status.FAIL, "Error message mismatch: " + e.getMessage());
	        	throw e;

	        }	        
	        
	        // Select the vehicle's fuel type
	        insurancePage.chooseFuelType(carFuelType); //car fuel type
	        logger.info("Action: Fuel type '" + carFuelType + "' selected");
	        extentTest.log(Status.INFO, "Action: Fuel type '" + carFuelType + "' selected");

	        // ======================== Variant Selection ========================
	        
	        // Ensure the variant list is available
	        try {
	        Assert.assertTrue(insurancePage.isListPopulated(insurancePage.carvariant), "Variant list not populated");
	        logger.info("Verified: Variant list populated");
	        extentTest.log(Status.PASS, "Verified: Variant list populated");
	        }
	        catch(AssertionError e) {
	        	extentTest.log(Status.FAIL, "Error message mismatch: " + e.getMessage());
	        	throw e;
	        }	 
	        
	        
	        // Validate that the variant is clickable
	        try {
	        boolean isvariantclickable = insurancePage.isVariantclickable(carVariant);
	        Assert.assertTrue(isvariantclickable, "carvariant not clickable");
	        logger.info("Verified: Variant '" + carVariant + "' is clickable");
	        extentTest.log(Status.PASS, "Verified: Variant '" + carVariant + "' is clickable");
	        }
	        catch(AssertionError e) {
	        	extentTest.log(Status.FAIL, "Error message mismatch: " + e.getMessage());
	        	throw e;

	        }	
	        
	        
	        // Select the car variant
	        insurancePage.chooseVariant(carVariant);// car variant
	        logger.info("Action: Variant '" + carVariant + "' selected");
	        extentTest.log(Status.INFO, "Action: Variant '" + carVariant + "' selected");
	        
	        // ======================== Form Inputs ========================
	        
	        // Enter the user's name into the input field
	        insurancePage.setName(name);
	        logger.info("Action: Name '" + name + "' entered");
	        extentTest.log(Status.INFO, "Action: Name '" + name + "' entered");
	        
	        // Enter the user's mobile number (intentionally invalid for negative test)
	        insurancePage.setMobileNumber(mobileNumber);// As per the statement entering the invalid mobile number
	        logger.info("Action: Mobile number '" + mobileNumber + "' entered");
	        extentTest.log(Status.INFO, "Action: Mobile number '" + mobileNumber + "' entered");
	        
	        
	        // Capture and log error message displayed on invalid mobile number input
	        String errorMsg = insurancePage.capturePhoneErrorMessage();
	        logger.info("Captured Error Message: " + errorMsg);
	        extentTest.log(Status.INFO, "Captured Error Message: " + errorMsg + " ");
	        
	        // on pass take screenshot
	        try {
	        	String captureScreen = captureScreen("Test Car Insurance");
	        	extentTest.addScreenCaptureFromPath(captureScreen);
	        }
	        catch(Exception e) {
	        	e.printStackTrace();
	        }
	        
	        
	        System.out.println(errorMsg); //Capturing and printing the error message 
	       
	    }
	
	
	

}
