package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import pageObjects.HealthInsurancePage;
import pageObjects.HomePage;

public class TSC003_Health_Insurance_Menu {
	
	WebDriver driver;
	HealthInsurancePage Health= new HealthInsurancePage(driver);
	HomePage Home= new HomePage(driver);
	@Test
	public void Test1() {
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
