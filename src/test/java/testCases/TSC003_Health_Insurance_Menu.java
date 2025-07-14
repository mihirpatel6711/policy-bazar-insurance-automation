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
		Home= new HomePage(driver);
		Health= new HealthInsurancePage(driver);
		
		Home.HoverOnInsuranceProducts();
		Boolean check=Health.isDropdownPresent();
		Assert.assertTrue(check);
		System.out.println("TestCase-1 Passed : The dropdown is visible when hovered");
		//Boolean check2=Health.isHealthElementClickable(Home.healthInsurance);
		Boolean check2=Health.isHealthElementClickable(Health.healthInsurance);
		Assert.assertTrue(check2);
		System.out.println("TestCase-2 Passed : The Element is \"Health Insurance\" clickable");
		
	}
	
	
	@Test
	public void Test2() {
//		Home= new HomePage(driver);
//		Health= new HealthInsurancePage(driver);
		
		Home.HoverOnInsuranceProducts();
		
		Home.healthInsuranceClick();
		Health.hoverHealth(driver);
		
		boolean check3=Health.isHealthDropdownPresent();
		Assert.assertTrue(check3);
		System.out.println("TestCase-3 Passed : The Health Insurance Dropdown is visbile when hovered");
		Boolean check4= Health.isHealthElementClickable(Health.famInsu);
		Assert.assertTrue(check4);
		System.out.println("TestCase-4 Passed : Menu item  is clickable ");
		Boolean check5=Health.validateRedirection(driver);
		Assert.assertTrue(check5);
		System.out.println("TestCase-5 Passed : There is proper redirection");
	}
}
