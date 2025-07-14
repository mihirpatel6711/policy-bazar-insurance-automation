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
	public WebDriver driver;	
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
		
		public boolean isDropdownPresent() {     //Validation
			return insuDropdownContainer.isDisplayed();
		}
		
		
			
			
		public boolean isHealthElementClickable( WebElement element) {   //validation
			return isElementClickable(element);
		}
		
		
		public void clickHealthInsu() {
			healthInsurance.click();
		}
		
		public Boolean validateRedirection(WebDriver driver) {
			 String title=driver.getTitle();
			 if(title.equals("Health Insurance: Buy Medical Insurance Plans @ ₹10/Day*")){
				 return true;
			 }else {
				 return false;
			 }
		}
		
		
		public void hoverHealth(WebDriver driver) {
			act= new Actions(driver);
			act.moveToElement(hovaHealthDropdown).perform();
		}
		
		public boolean isHealthDropdownPresent() {     //Validation
			return healthDropdownContainer.isDisplayed();
		}
		
		public void printMenuItems() {
//			List<WebElement> mylist= driver.findElements(By.xpath("/html/body/div[1]/nav/div/div[2]/div/div[2]/ul/li[3]/ul/li"));
			for(WebElement innerElements: menuItems) {
				System.out.println(innerElements.getText());
			}
			System.out.println("----------------------------------");
		}
}
