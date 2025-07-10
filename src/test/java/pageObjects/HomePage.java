package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	

	//Locators

		//For Insurance Products
		@FindBy(xpath="//ul[@class='ruby-menu']/li[2]")
		WebElement insuranceProductsButton;


		//Travel Insurance
		@FindBy(xpath="//section[@class='prd-row']/div[7]/a")
		WebElement travelInsurance;


		//Car Insurance
		@FindBy(xpath="//section[@class='prd-row']/div[4]/a")
		WebElement carInsurance;


		//Health Insurance
		@FindBy(xpath="//div[@class='ruby-col-3 hidden-md']//span[text()='Health Insurance Companies']/parent::a")
		WebElement healthInsurance;




		//Action Methods

		//Hovering on the Insurance product
		public void HoverOnInsuranceProducts() {
			Actions act=new Actions(driver);
			act.moveToElement(insuranceProductsButton).perform();
		}


		//Selecting the Health insurance 
		public void healthInsuranceClick() {
			Actions act=new Actions(driver);
			act.doubleClick(healthInsurance).perform();
		}

		//Navigating to the Car Insurance Page
		public void carInsuranceClick() {
			carInsurance.click();
		}

		//Navigating to the Travel Insurance Page
		public void travelInsurance() {
			travelInsurance.click();
		}


}
