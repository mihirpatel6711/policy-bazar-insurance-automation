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


public class TSC002_Car_Insurance_Quote extends BaseClass{
	 
	 HomePage homePage;
	 CarInsurancePage insurancePage;
	 
	  
	    @Test(dataProvider = "CarInsurance", dataProviderClass=DataProviders.class)
	    public void testCarInsuranceSelection(String city, String carBrand, String carModel, String carFuelType, String carVariant, String name, String mobileNumber  ) throws InterruptedException {//For new brand car-->"click here"
	    	Thread.sleep(1000);
	    	//driver.findElement(By.xpath("(//i[@class='icon-bg homeIconsBg car-insurance'])[2]")).click();
	    	homePage = new HomePage(driver);
	    	homePage.carInsuranceClick();
	    	
	        insurancePage = new CarInsurancePage(driver);
	        Thread.sleep(1000);
	        insurancePage.clickStart();

	        Assert.assertTrue(insurancePage.isListPopulated(insurancePage.selectcity), "City list not populated");
	        boolean iscityclickable = insurancePage.isCityClickable(city);
	        Assert.assertTrue(iscityclickable, "City not clickable");
	        insurancePage.chooseCity(city);  // select city 
	        

	        Assert.assertTrue(insurancePage.isListPopulated(insurancePage.selectbrandname), "Brand list not populated");
	        boolean isbandclickable = insurancePage.isBrandclickable(carBrand);
	        Assert.assertTrue(isbandclickable, "band not clickable");
	        insurancePage.chooseBrand(carBrand); // Selecting the brand

	        Assert.assertTrue(insurancePage.isListPopulated(insurancePage.carmodel), "Model list not populated");
	        boolean ismodelclickable = insurancePage.isModelclickable(carModel);
	        Assert.assertTrue(ismodelclickable, "model not clickable");
	        insurancePage.chooseModel(carModel); // choosing the model

	        Assert.assertTrue(insurancePage.isListPopulated(insurancePage.carfueltype), "Fuel type list not populated");
	        boolean isfueltypeclickable = insurancePage.isFuelTypeclickable(carFuelType);
	        Assert.assertTrue(isfueltypeclickable, "fueltype not clickable");
	        insurancePage.chooseFuelType(carFuelType); //car fuel type

	        Assert.assertTrue(insurancePage.isListPopulated(insurancePage.carvariant), "Variant list not populated");
	        boolean isvariantclickable = insurancePage.isVariantclickable(carVariant);
	        Assert.assertTrue(isvariantclickable, "carvariant not clickable");
	        insurancePage.chooseVariant(carVariant);// car variant
	        
	        insurancePage.setName(name);//Enter the number for car details
	        insurancePage.setMobileNumber(mobileNumber);// As per the statement entering the invalid mobile number
	        
	        String errorMsg = insurancePage.capturePhoneErrorMessage();
	        System.out.println(errorMsg); //Capturing and printing the error message   
	    }
	
	
	

}
