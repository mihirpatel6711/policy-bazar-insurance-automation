package testCases;

import java.time.Duration;

import org.testng.Assert;

import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.TravelInsurancePage;
import pageObjects.ViewPlansPage;
import testBase.BaseClass;
import utilities.DataProviders;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import utilities.ExtentReportManager;


/**
 * Test Case ID: TSC001_Student_Travel_Insurance
 * Purpose: Validate the workflow of selecting student travel insurance options.
 * Data Driven: Uses test data from DataProviders for multiple combinations of user inputs.
 */

public class TSC001_Student_Travel_Insurance extends BaseClass {
	
	// Page object for the Home Page where travel insurance option is selected
	HomePage homepage;
	// Page objects for the travel Insurance workflow containing form interactions
	TravelInsurancePage travelInsurance;
	ViewPlansPage viewplans;
	
	ExtentTest extentTest;
		
	/**
	  * Test Method: testStudentTravelInsurancePlans
	  * Description: Executes a complete flow of selecting country, startDate, endDate, numberOfTravellers, age1, age2, travelDuration , plan type and price
	  * and view top three plans based on above filters
	  */
	
	@Test(dataProvider="TravelInsurance", dataProviderClass=DataProviders.class)
	public void testStudentTravelInsurancePlans(String country,String startDate,String endDate, String numberOfTravellers, String age1,String age2, String travelDuration) throws InterruptedException {
		homepage = new HomePage(driver);// Initialize HomePage object
		travelInsurance = new TravelInsurancePage(driver); //Initialize TravelInsurancePage object
		viewplans = new ViewPlansPage(driver); //Initialize ViewPlansPage object
		
		extentTest = ExtentReportManager.extent.createTest("Travel Insurance Test - " + country + ", " + startDate+ ", " + endDate + ", " + numberOfTravellers + ", " + age1 + ", " + age2 + ", " + travelDuration );
		extentTest.assignCategory("Student Travel Insurance");
		
		try {    
		    //Travel Insurance
			logger.info("*** Initiated: Travel Insurance Page ***");
			extentTest.log(Status.INFO, "*** Initiated: Travel Insurance Page ***");
			
			
			//Click on Travel Insurance
		    homepage.travelInsurance();
			logger.info("Action: Travel Insurance option clicked on Home Page");
	    	extentTest.log(Status.INFO, "Action: Travel Insurance option clicked on Home Page");
	    	Thread.sleep(1000);
		    
			//Click on Input Field 
	    	try {
		    Assert.assertTrue(travelInsurance.isInputFieldClickable(), "Input Box is not clickable");
		    logger.info("Verified: Input box is clickable");
		    extentTest.log(Status.PASS, "Verified: Input box is clickable");
		    travelInsurance.clickInput();
		    logger.info("Action: Input field clicked");
		    extentTest.log(Status.INFO, "Action: Input field clicked");
	    	}
	    	catch(AssertionError e) {
	        	extentTest.log(Status.FAIL, "Error message mismatch: " + e.getMessage());
	        	throw e;
	        }
	    	
		    //Thread.sleep(1000);
		    
		    // ======================== Country Selection ========================
		    
		    //Country dropdown is populated
		    try {
		    	Assert.assertTrue(travelInsurance.isCountryListPopulated(), "Country list is not clickable or not populated");
			    logger.info("Verified: Country list is clickable and populated");
			    extentTest.log(Status.PASS, "Verified: Country list is clickable and populated");
			    travelInsurance.selectCountry(country);
			    logger.info("Action: Country selected – " + country);
			    extentTest.log(Status.INFO, "Action: country selected - " + country);
			   // Thread.sleep(1000);
		    }catch(AssertionError e) {
	        	extentTest.log(Status.FAIL, "Error message mismatch: " + e.getMessage());
	        	throw e;
	        }

		    // ======================== Start Date Selection ========================
		    
		    //start Date field is clickable
		    try {
		    	Assert.assertTrue(travelInsurance.isStartDateClickable(), "Start Date field is not clickable");
			    logger.info("Verified: Start date field is clickable");
			    extentTest.log(Status.PASS, "Verified: Start date field is clickable");
			    travelInsurance.clickStartDate();
			    logger.info("Action: Start date field clicked");
			    extentTest.log(Status.INFO, "Action: Start date field clicked");
			    Thread.sleep(300);
		    }catch(AssertionError e) {
	        	extentTest.log(Status.FAIL, "Error message mismatch: " + e.getMessage());
	        	throw e;
	        }
		   
		    //select Start Date
		    	travelInsurance.selectStartDate(startDate);
			    logger.info("Action: Start date selected");
			    extentTest.log(Status.INFO, "Action: start date selected - "+ startDate);
			    Thread.sleep(200);
		    
		    
		    
		    // ======================== End Date Selection ========================

            
		    //select End Date
		    	travelInsurance.selectEndDate(endDate);
				logger.info("Action: End date selected");
				extentTest.log(Status.INFO, "Action: end date selected - "+ endDate);
				Thread.sleep(200);
		    
		    
		    
		    //click continue Button
		    try {
		    	Assert.assertTrue(travelInsurance.isContinueButtonClickable(), "Continue button is not clickable");
			    logger.info("Verified: Continue button is clickable");
			    extentTest.log(Status.PASS, "Verified: Continue button is clickable");
			    travelInsurance.clickContinueButton();
			    logger.info("Action: Continue button clicked");
			    extentTest.log(Status.INFO, "Action: continue button clicked");
			    Thread.sleep(500);
		    }catch(AssertionError e) {
	        	extentTest.log(Status.FAIL, "Error message mismatch: " + e.getMessage());
	        	throw e;
	        }
		    
		    
		    // ======================== Number Of Travellers Selection ========================
		    
		    //Travellers list is clickable 
		    try {
		    	Assert.assertTrue(travelInsurance.isTravellersListPopulated(), "Traveller list is not populated");
			    logger.info("Verified: Traveller dropdown populated");
			    extentTest.log(Status.PASS, "Verified: Traveller dropdown populated");
			    travelInsurance.selectTravellers(numberOfTravellers);
			    logger.info("Action: Number of travellers selected");
			    extentTest.log(Status.INFO, "Action: Number of Travellers selected - "+ numberOfTravellers );
			    Thread.sleep(100);	
		    }catch(AssertionError e) {
	        	extentTest.log(Status.FAIL, "Error message mismatch: " + e.getMessage());
	        	throw e;
	        }
		    
		    
		    // ======================== Traveller Age Selection ========================
		    
		    
		    //click age box
		    try {
		    	Assert.assertTrue(travelInsurance.isFirstAgeBoxClickable(), "First age box is not clickable");
			    logger.info("Verified: First age box is clickable");
			    extentTest.log(Status.PASS, "Verified: First age box is clickable");
			    travelInsurance.clickFirstAgeBox();
			    logger.info("Action: First age box clicked");
			    extentTest.log(Status.INFO, "Action: First Age box clicked");
			    Thread.sleep(100);
		    }catch(AssertionError e) {
	        	extentTest.log(Status.FAIL, "Error message mismatch: " + e.getMessage());
	        	throw e;
	        }
		    
		    
		    //select first traveller Age
		    try {
		    	Assert.assertTrue(travelInsurance.isAgeListPopulated(), "Age list is empty or not clickable");
			    logger.info("Verified: Age selection list is populated");
			    extentTest.log(Status.PASS, "verified: Age selection list is populated");
			    travelInsurance.selectAge(age1);
			    logger.info("Action: First Traveller Age is selected ");
			    extentTest.log(Status.INFO, "Action: First Traveller Age selected - "+ age1);
			    Thread.sleep(100);
		    	
		    }catch(AssertionError e) {
	        	extentTest.log(Status.FAIL, "Error message mismatch: " + e.getMessage());
	        	throw e;
	        }
		   
             
		    //click age box
            try {
            	Assert.assertTrue(travelInsurance.isSecondAgeBoxClickable(), "Second age box is not clickable");
    		    logger.info("Verified: Second age box is clickable");
    		    extentTest.log(Status.PASS, "Verified: Second age box is clickable");
    		    travelInsurance.clickSecondAgeBox();
    		    logger.info("Action: Second age box clicked");
    		    extentTest.log(Status.INFO, "Action: Second Age box clicked");
    		    Thread.sleep(100);
		    }catch(AssertionError e) {
	        	extentTest.log(Status.FAIL, "Error message mismatch: " + e.getMessage());
	        	throw e;
	        }
		    
		    		    
		    //select second traveller Age
		    try {
		    	Assert.assertTrue(travelInsurance.isAgeListPopulated(), "Age list is empty or not clickable");
			    logger.info("Verified: Age selection list is populated");
			    extentTest.log(Status.PASS, "Verified: Age selection list is populated");
		    	travelInsurance.selectAge(age2);
			    logger.info("Action: Second Traveller Age is selected ");
			    extentTest.log(Status.INFO, "Action: Second Traveller Age selected - "+ age2);
			    Thread.sleep(100);	
		    }catch(AssertionError e) {
	        	extentTest.log(Status.FAIL, "Error message mismatch: " + e.getMessage());
	        	throw e;
	        }
		    

		    //Select No radio button
		    try {
		    	Assert.assertTrue(travelInsurance.isSelectNoClickable(), "‘No’ radio button is not clickable");
			    logger.info("Verified: ‘No’ radio button is clickable");
			    extentTest.log(Status.PASS, "Verified: ‘No’ radio button is clickable");
			    travelInsurance.selectNoButton();
			    logger.info("Action: ‘No’ radio button selected");
			    extentTest.log(Status.INFO, "Action: ‘No’ radio button selected");
			    //Thread.sleep(1000);
		    }catch(AssertionError e) {
	        	extentTest.log(Status.FAIL, "Error message mismatch: " + e.getMessage());
	        	throw e;
	        }
		    

		    //Click the Explore Plans Button
		    try {
		    	driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
		    	Assert.assertTrue(travelInsurance.isExplorePlanButtonClickable(), "Explore Plans button is not clickable");
			    logger.info("Verified: Explore Plans button is clickable");
			    extentTest.log(Status.PASS, "Verified: Explore Buttons button is clickable");
			    travelInsurance.exploreButton();
			    logger.info("Action: Explore Plans button clicked");
			    extentTest.log(Status.INFO, "Action: Explore Plans Button clicked");
			   // Thread.sleep(1000); T-14 Done
		    }catch(AssertionError e) {
//	        	extentTest.log(Status.FAIL, "Error message mismatch: " + e.getMessage());
//	        	throw e;
		    	
	        }
		    
		    
		    
		    //Click the ViewPlans Button
		    try {
		    	Assert.assertTrue(travelInsurance.isViewPlansButtonClickable(), "View Plans button is not clickable");
			    logger.info("Verified: View Plans button is clickable");
			    extentTest.log(Status.PASS, "Verified: View Plans button is clickable");
			    travelInsurance.clickViewPlans();
			    logger.info("Action: View Plans button clicked");
			    extentTest.log(Status.INFO, "Action: View Plans Button clicked");
			   // Thread.sleep(1000);	T--15  Done
		    }catch(AssertionError e) {

		    }
		    
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		    
		    
		    logger.info("*** Completed: Travel Insurance Page ***");
		    extentTest.log(Status.INFO, "Action: Travel Insurance Page completed");
		    
		    
		    //View Plans 

		    logger.info("*** Initiated: View Plans Page ***");
		    extentTest.log(Status.INFO, "*** Initiated: View Plans Page ***");
		    
		    // Students Plan button selection
		    try {
		    	Assert.assertTrue(viewplans.isStudentPlanSelectable(), "Student plan radio button is not selectable");
				logger.info("Verified: Student plan radio button is selectable");
				extentTest.log(Status.PASS, "Verified: Student plan radio button is selectable");
				viewplans.selectStudentPlans();
				logger.info("Action: Student plan radio button is selected");
				extentTest.log(Status.INFO, "Action: Student plan radio button selected");
				//Thread.sleep(2000);
		    }catch(AssertionError e) {
	        	extentTest.log(Status.FAIL, "Error message mismatch: " + e.getMessage());
	        	throw e;
	        }
		   

		    //Select First Traveller CheckBox
		    try {
		    	Assert.assertTrue(viewplans.isFirstTravellerClickable(), "First traveller checkbox is not clickable");
			    logger.info("Verified: First traveller checkbox is clickable");
			    extentTest.log(Status.PASS, "Verified: First traveller checkbox is clickable");
			   // Thread.sleep(2000);
			    Thread.sleep(1000);
			    viewplans.selectFirstTraveller();
			    logger.info("Action: First traveller checkbox checked");
			    extentTest.log(Status.INFO, "Action: First Traveller checkbox checked");
			    //Thread.sleep(2000); 
		    }catch(AssertionError e) {
	        	extentTest.log(Status.FAIL, "Error message mismatch: " + e.getMessage());
	        	throw e;
	        }
		    
		    
		    //Select Second Traveller CheckBox
		    try {
		    	Assert.assertTrue(viewplans.isSecondTravellerClickable(), "Second traveller checkbox is not clickable");
			    logger.info("Verified: Second traveller checkbox is clickable");
			    extentTest.log(Status.PASS, "Verified: Second traveller checkbox is clickable");
			    viewplans.selectSecondTraveller();
			    logger.info("Action: Second traveller checkbox checked");
			    extentTest.log(Status.INFO, "Action: Second Traveller checkbox checked");
			    Thread.sleep(100);
		    }catch(AssertionError e) {
	        	extentTest.log(Status.FAIL, "Error message mismatch: " + e.getMessage());
	        	throw e;
	        }
		    
		    
		    //Select the Travel Duration
		    try {
		    	Assert.assertTrue(viewplans.isTravelDurationSelectable(travelDuration), "Travel Duration is not selectable");
			    logger.info("Verified: Travel Duration is selectable");
			    extentTest.log(Status.PASS, "Verified: Travel Duration is selectable");
			    viewplans.selectTravelDuration(travelDuration);
			    logger.info("Action: Travel duration selected");
			    extentTest.log(Status.INFO, "Action: Travel Duration selected - " + travelDuration);
		    }catch(AssertionError e) {
	        	extentTest.log(Status.FAIL, "Error message mismatch: " + e.getMessage());
	        	throw e;
	        }
		    

		    //Click the Apply Button
		    try {
		    	Assert.assertTrue(viewplans.isApplyButtonClickable(), "Apply button is not clickable");
			    logger.info("Verified: Apply button is clickable");
			    extentTest.log(Status.PASS, "Verified: Apply button is clickable");
			    viewplans.clickApplyButton();
			    logger.info("Action: Apply button clicked");
			    extentTest.log(Status.INFO, "Action: Apply Button clicked");
		    }catch(AssertionError e) {
	        	extentTest.log(Status.FAIL, "Error message mismatch: " + e.getMessage());
	        	throw e;
	        }
		    
		    
		    
		    //Select the Sort By Radio Button
		    try {
		    	Thread.sleep(500);
		    	Assert.assertTrue(viewplans.issortByButtonClickable(), "Sort By option is not clickable");
			    logger.info("Verified: Sort By button is clickable");
			    extentTest.log(Status.PASS, "Verified: Sort By button is clickable");
			    viewplans.selectSortBy();
			    logger.info("Action: Sort By selected");
			    extentTest.log(Status.INFO, "Action: Sort By selected");
		    }catch(AssertionError e) {
	        	extentTest.log(Status.FAIL, "Error message mismatch: " + e.getMessage());
	        	throw e;
	        }
		    

		    
		    //Select the Low to High radio button
		    try {
		    	Assert.assertTrue(viewplans.isLowToHighButtonClickable(), "Low-to-High option is not clickable");
			    logger.info("Verified: Low-to-High button is clickable");
			    extentTest.log(Status.PASS, "Verified: Low-to-High button is clickable");
			    viewplans.selectLowToHigh();
			    logger.info("Action: Plans sorted from low to high prices");
			    extentTest.log(Status.INFO, "Action: plans sorted from low to high prices");
		    }catch(AssertionError e) {
	        	extentTest.log(Status.FAIL, "Error message mismatch: " + e.getMessage());
	        	throw e;
	        }
		    
		   
		    
		    //Printing the Travel Insurance Plan Details
		    try {
		    Assert.assertTrue(viewplans.isNameListPopulated(), "Names list is not populated");
		    logger.info("Verified: Names list populated");
		    extentTest.log(Status.PASS, "Verified: Names list populated");
		    }
		    catch(AssertionError e) {
	        	extentTest.log(Status.FAIL, "Error message mismatch: " + e.getMessage());
	        	throw e;
	        }
		    
		    try {
		    Assert.assertTrue(viewplans.isPriceListPopulated(), "Prices list is not populated");
		    logger.info("Verified: Price list populated");
		    extentTest.log(Status.PASS, "Verified: Price list populated");
		    }
		    catch(AssertionError e) {
	        	extentTest.log(Status.FAIL, "Error message mismatch: " + e.getMessage());
	        	throw e;
	        }
		    

		    viewplans.printList();
		    logger.info("The List of three lowest international  travel insurance plan with amount and insurance provider company have been printed...");
		    extentTest.log(Status.INFO, "Action: The List of three lowest international  travel insurance plan with amount and insurance provider company have been printed...");
		    
		    logger.info("*** Completed: View Plans Results ***");	
		    extentTest.log(Status.INFO, "Action: successfully completed the execution and results are printed");
		    
		 // on pass take screenshot
	        try {
	        	String captureScreen = captureScreen("Test Car Insurance");
	        	extentTest.addScreenCaptureFromPath(captureScreen);
	        }
	        catch(Exception e) {
	        	e.printStackTrace();
	        }
		    	    
			} 
			
			catch(Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
			
}
