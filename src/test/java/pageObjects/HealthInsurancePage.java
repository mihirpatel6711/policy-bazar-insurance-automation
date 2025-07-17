package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HealthInsurancePage extends BasePage {
	//public WebDriver driver;	
	Actions act;


	public HealthInsurancePage (WebDriver driver)
	{
		super(driver);
	}
		
		//locators
		
		
//		@FindBy(xpath="//a[text()='Insurance Products ']") 
//		WebElement hovaInsuDropdown;
		
		@FindBy(xpath="/html/body/div[6]/div[2]/div/ul/li[2]/div/div/div[3]") 
		WebElement insuDropdownContainer; //For Validation
		
		@FindBy(xpath="/html/body/div[6]/div[2]/div/ul/li[2]/div/div/div[3]/h3/a")
		public WebElement healthInsurance;
		
		@FindBy(xpath="//span[@itemprop='name'][normalize-space()='Health Insurance']")
		WebElement hovaHealthDropdown;
		
		@FindBy(xpath="//*[@id=\"navigatorType\"]/body/div[1]/nav/div/div[2]/div/div[2]/ul/li[3]/ul") 
		WebElement healthDropdownContainer;  //for Health dropDown validation
		
		@FindBy(xpath="/html/body/div[1]/nav/div/div[2]/div/div[2]/ul/li[3]/ul/li") 
		List<WebElement> menuItems;
		
		
		@FindBy(xpath="//*[@id=\"navigatorType\"]/body/div[1]/nav/div/div[2]/div/div[2]/ul/li[3]/ul/li[3]/a/span")
		public WebElement famInsu; // validation
		
		//action methods
		//---------------------------------------------------------------------
		
		
//		public void hoverInsurance(WebDriver driver) {
//			act= new Actions(driver);
//			act.moveToElement(hovaInsuDropdown).perform();
//		}
		
		

		/**
		 * Checks if the insurance dropdown container is displayed on the page.
		 *
		 * @return true if the dropdown is visible; false otherwise
		 */
		public boolean isDropdownPresent() {     
			return insuDropdownContainer.isDisplayed();
		}		

		/**
		 * Validates whether the given health-related WebElement is clickable.
		 *
		 * @param element WebElement to validate
		 * @return true if the element is clickable; false otherwise
		 */
		public boolean isHealthElementClickable( WebElement element) {   //validation
			return isElementClickable(element);
		}		

		/**
		 * Clicks on the Health Insurance section or link.
		 */
		public void clickHealthInsu() {
			healthInsurance.click();
		}		

		/**
		 * Validates whether the current page title matches the expected title
		 * after redirection to the Health Insurance page.
		 *
		 * @param driver WebDriver instance
		 * @return true if the title matches the expected value; false otherwise
		 */
		public Boolean validateRedirection(WebDriver driver) {
			 String title=driver.getTitle();
			 if(title.equals("Health Insurance: Buy Medical Insurance Plans @ ₹10/Day*")){
				 return true;
			 }else {
				 return false;
			 }
		}		

		/**
		 * Performs a mouse hover action over the Health dropdown menu.
		 *
		 * @param driver WebDriver instance
		 */
		public void hoverHealth(WebDriver driver) {
			act= new Actions(driver);
			act.moveToElement(hovaHealthDropdown).perform();
		}		

		/**
		 * Checks if the health dropdown container is displayed on the page.
		 *
		 * @return true if the dropdown is visible; false otherwise
		 */		
		public boolean isHealthDropdownPresent() {     
			return healthDropdownContainer.isDisplayed();
		}		

		/**
		 * Prints the text of each menu item under the health dropdown to the console.
		 * Useful for debugging or verifying UI content.
		 */
		public void printMenuItems() {
//			List<WebElement> mylist= driver.findElements(By.xpath("/html/body/div[1]/nav/div/div[2]/div/div[2]/ul/li[3]/ul/li"));
			for(WebElement innerElements: menuItems) {
				System.out.println(innerElements.getText());
			}
			System.out.println("----------------------------------");
		}
}
