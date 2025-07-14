package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.TravelInsurancePage;
import pageObjects.ViewPlansPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TSC001_Student_Travel_Insurance extends BaseClass {
	@Test(dataProvider="TravelInsurance", dataProviderClass=DataProviders.class)
	public void Execute(String country,String startDate,String endDate, String numberOfTravellers, String age1,String age2, String travelDuration) throws InterruptedException {
		
		TravelInsurancePage tl=new TravelInsurancePage(driver);
		ViewPlansPage vp=new ViewPlansPage(driver);
		HomePage hp=new HomePage(driver);
		
		try {
			//HomePage
		    hp.travelInsurance();
		    Thread.sleep(1000);
		        
		    //Travel Insurance
			
			logger.info("*** Initiated: Travel Insurance Page ***");
		    
			//Click on Input Field 
		    Assert.assertTrue(tl.isInputFieldClickable(), "Input Box is not clickable");
		    logger.info("Verified: Input box is clickable");
		    tl.clickInput();
		    logger.info("Action: Input field clicked");
		    Thread.sleep(1000);
		    
		    //Country dropdown is populated
		    Assert.assertTrue(tl.isCountryListPopulated(), "Country list is not clickable or not populated");
		    logger.info("Verified: Country list is clickable and populated");
		    tl.selectCountry(country);
		    logger.info("Action: Country selected – " + country);
		    Thread.sleep(1000);

		    //start Date field is clickable
		    Assert.assertTrue(tl.isStartDateClickable(), "Start Date field is not clickable");
		    logger.info("Verified: Start date field is clickable");
		    tl.clickStartDate();
		    logger.info("Action: Start date field clicked");
		    Thread.sleep(3000);

		    //select Start Date
		    tl.selectStartDate(startDate);
		    logger.info("Action: Start date selected");
		    Thread.sleep(1000);
		    
		    //select End Date
		    tl.selectEndDate(endDate);
		    logger.info("Action: End date selected");
		    Thread.sleep(1000);
		  
		    //click continue Button
		    Assert.assertTrue(tl.isContinueButtonClickable(), "Continue button is not clickable");
		    logger.info("Verified: Continue button is clickable");
		    tl.clickContinueButton();
		    logger.info("Action: Continue button clicked");
		    Thread.sleep(1000);
		    
		    //Travellers list is clickable 
		    Assert.assertTrue(tl.isTravellersListPopulated(), "Traveller list is not populated");
		    logger.info("Verified: Traveller dropdown populated");
		    tl.selectTravellers(numberOfTravellers);
		    logger.info("Action: Number of travellers selected");
		    Thread.sleep(1000);
		    
		    //click age box
		    Assert.assertTrue(tl.isFirstAgeBoxClickable(), "First age box is not clickable");
		    logger.info("Verified: First age box is clickable");
		    tl.clickFirstAgeBox();
		    logger.info("Action: First age box clicked");
		    Thread.sleep(1000);

		    //select first traveller Age
		    Assert.assertTrue(tl.isAgeListPopulated(), "Age list is empty or not clickable");
		    logger.info("Verified: Age selection list is populated");
		    tl.selectAge(age1);
		    logger.info("Action: First Traveller Age is selected ");
		    Thread.sleep(1000);

		    //click age box
		    Assert.assertTrue(tl.isSecondAgeBoxClickable(), "Second age box is not clickable");
		    logger.info("Verified: Second age box is clickable");
		    tl.clickSecondAgeBox();
		    logger.info("Action: Second age box clicked");
		    Thread.sleep(1000);
		    
		    //select second traveller Age
		    tl.selectAge(age2);
		    logger.info("Action: Second Traveller Age is selected ");
		    Thread.sleep(1000);

		    //Select No radio button
		    Assert.assertTrue(tl.isSelectNoClickable(), "‘No’ radio button is not clickable");
		    logger.info("Verified: ‘No’ radio button is clickable");
		    tl.selectNoButton();
		    logger.info("Action: ‘No’ radio button selected");
		    Thread.sleep(1000);

		    //Click the Done Button
		    Assert.assertTrue(tl.isDoneButtonClickable(), "Done button is not clickable");
		    logger.info("Verified: Done button is clickable");
		    tl.clickDoneButton();
		    logger.info("Action: Done button clicked");
		    Thread.sleep(1000);
		    
		    
		    //Click the ViewPlans Button
		    Assert.assertTrue(tl.isViewPlansButtonClickable(), "View Plans button is not clickable");
		    logger.info("Verified: View Plans button is clickable");
		    tl.clickViewPlans();
		    logger.info("Action: View Plans button clicked");
		    Thread.sleep(1000);
		    logger.info("*** Completed: Travel Insurance Page ***");
		    
		    
		    
		    //View Plans 

		    logger.info("*** Initiated: View Plans Page ***");
		    
		    // Students Plan button selection
		    Assert.assertTrue(vp.isStudentPlanSelectable(), "Student plan button is not selectable");
		    logger.info("Verified: Student plan button is selectable");
		    vp.selectStudentPlans();
		    logger.info("Action: Student plan selected");

		    //Select First Traveller CheckBox
		    Thread.sleep(2000);
		    Assert.assertTrue(vp.isFirstTravellerClickable(), "First traveller checkbox is not clickable");
		    logger.info("Verified: First traveller checkbox is clickable");
		    Thread.sleep(2000);
		    vp.selectFirstTraveller();
		    logger.info("Action: First traveller selected");
		    Thread.sleep(2000); 
		    
		    //Select Second Traveller CheckBox
		    Assert.assertTrue(vp.isSecondTravellerClickable(), "Second traveller checkbox is not clickable");
		    logger.info("Verified: Second traveller checkbox is clickable");
		    vp.selectSecondTraveller();
		    logger.info("Action: Second traveller selected");
		    Thread.sleep(2000);
		    
		    //Select the Travel Duration
		    Assert.assertTrue(vp.isTravelDurationSelectable(travelDuration), "Travel Duration is not selectable");
		    logger.info("Verified: Travel Duration is selectable");
		    vp.selectTravelDuration(travelDuration);
		    logger.info("Action: Travel duration selected");

		    //Click the Apply Button
		    Assert.assertTrue(vp.isApplyButtonClickable(), "Apply button is not clickable");
		    logger.info("Verified: Apply button is clickable");
		    vp.clickApplyButton();
		    logger.info("Action: Apply button clicked");
		    
		    
		    //Select the Sort By Radio Button
		    Assert.assertTrue(vp.issortByButtonClickable(), "Sort By option is not clickable");
		    logger.info("Verified: Sort By button is clickable");
		    vp.selectSortBy();
		    logger.info("Action: Sort By selected");

		    
		    //Select the Low to High radio button
		    Assert.assertTrue(vp.isLowToHighButtonClickable(), "Low-to-High option is not clickable");
		    logger.info("Verified: Low-to-High button is clickable");
		    vp.selectLowToHigh();
		    logger.info("Action: Premium sorted from low to high");
		   
		    
		    //Printing the Travel Insurance Plan Details
		    Assert.assertTrue(vp.isNameListPopulated(), "Names list is not populated");
		    logger.info("Verified: Names list populated");

		    Assert.assertTrue(vp.isPriceListPopulated(), "Prices list is not populated");
		    logger.info("Verified: Price list populated");

		    vp.printList();
		    logger.info("The List of three lowest international  travel insurance plan with amount and insurance provider company have been printed...");
		    
		    logger.info("*** Completed: View Plans Results ***");	
		    	    
			} 
			
			catch(Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
			
}
