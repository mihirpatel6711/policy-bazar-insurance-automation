package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import pageObjects.HealthInsurancePage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TSC003_Health_Insurance_Menu extends BaseClass {
	
	
	static HealthInsurancePage Health;
	static HomePage Home;
	
	@Test
	public void Test1() {
		logger.info("*** Initiated: Travel Insurance Page ***");
		logger.info("***TestScript-1 started***");
		
		Home= new HomePage(driver);
		Health= new HealthInsurancePage(driver);
		
		Home.HoverOnInsuranceProducts();
		logger.info("Action: Hovered on Insurance Dropdown");
		
		Boolean check=Health.isDropdownPresent();
		Assert.assertTrue(check);
		logger.info("Verified: Dropdown is present when hovered");
		System.out.println("TestCase-1 Passed : The dropdown is visible when hovered");
		//Boolean check2=Health.isHealthElementClickable(Home.healthInsurance);
		
		Boolean check2=Health.isHealthElementClickable(Health.healthInsurance);
		Assert.assertTrue(check2);
		logger.info("Verified: The Health Insurance is clickable");
		System.out.println("TestCase-2 Passed : The Element is \"Health Insurance\" clickable");
		
	}
	
	
	@Test
	public void Test2() {
//		Home= new HomePage(driver);
//		Health= new HealthInsurancePage(driver);
		logger.info("***TestScript-2 started***");
		
		Home.HoverOnInsuranceProducts();
		logger.info("Action: Hovered on Insurance Dropdown");
		
		Home.healthInsuranceClick();
		logger.info("Action: Health Insurance is clicked");
		
		Health.hoverHealth(driver);
		logger.info("Action: Hovered on Health Insurance Dropdown");
		
		boolean check3=Health.isHealthDropdownPresent();
		Assert.assertTrue(check3);
		logger.info("Verified: Health dropdown is present when hovered");
		System.out.println("TestCase-3 Passed : The Health Insurance Dropdown is visbile when hovered");
		
		Boolean check4= Health.isHealthElementClickable(Health.famInsu);
		Assert.assertTrue(check4);
		logger.info("Verified: The Menu Item in Health Insurance dropdown is clickable");
		System.out.println("TestCase-4 Passed : Menu item  is clickable ");
		
		Boolean check5=Health.validateRedirection(driver);
		Assert.assertTrue(check5);
		logger.info("Verified: The link redirects correctly.");
		System.out.println("TestCase-5 Passed : There is proper redirection");
	}
}
