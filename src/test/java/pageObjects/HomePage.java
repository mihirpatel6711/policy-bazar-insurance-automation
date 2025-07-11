package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	Actions act=new Actions(driver);
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
		@FindBy(xpath="/html/body/div[6]/div[2]/div/ul/li[2]/div/div/div[3]/h3/a")
		WebElement healthInsurance;




		//Action Methods

		//Hovering on the Insurance product
		public void HoverOnInsuranceProducts() {
			
			act.moveToElement(insuranceProductsButton).perform();
		}


		//Selecting the Health insurance 
		public void healthInsuranceClick() {

			healthInsurance.click();
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
