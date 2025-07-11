package pageObjects;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
 
public class TravelInsurancePage {
    WebDriver driver;
 
    public TravelInsurancePage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    
    //Locators
    @FindBy(xpath="//div[@class='prd-icon add shadowHandler short' and .//p[contains(text(),'Travel')]]")
    WebElement travelInsurance;
    
    @FindBy(xpath="//input[@id='country']")
    WebElement inputBox;
    
    @FindBy(xpath="//li[@class='search-item']")
    List<WebElement> Country;
    
    @FindBy(xpath="//div[@class='newPq_duration_wrap__dateCol'][1]")
    WebElement startDate;
    
    @FindBy(xpath="//div[@class='MuiPickersDesktopDateRangeCalendar-root']/div[2]/div/button[2]")
    WebElement clickNextButton;
    
    @FindBy(xpath="//button[@class='travel_main_cta' and text()='Continue' or text()='Done']")
    WebElement continueButton;
    
    @FindBy(xpath="//div[@class='memSelectRadioWrapper__radio']")
    List<WebElement> selectNumberOfTravellersList;
    
    @FindBy(xpath="//div[@class='memSelectRadioWrapper__radio']/input")
    List<WebElement> selectNumberOfTravellers;
    
    @FindBy(xpath="//div[@class='options_box_wrapper__option']/input")
    List<WebElement> AgeSelection;
    
    @FindBy(xpath="//div[@class='options_box_wrapper__option']")
    List<WebElement> AgeSelectionList;
    
    @FindBy(xpath="//div[@class='customDropdown ' and @id='0']")
    WebElement firstAgeBox;
    
    @FindBy(xpath="//div[@class='customDropdown ' and @id='1']")
    WebElement secondAgeBox;
    
    @FindBy(xpath="//input[@id='ped_no']")
    WebElement selectNo;
    
    @FindBy(xpath="//button[@class='travel_main_cta' and text()='Done']")
    WebElement DoneButton;
    
    @FindBy(xpath="//button[@class='travel_main_cta']")
    WebElement ViewPlansButton;
    
    
    
    //Action Methods
    
    //one - 1
    public void clickInput() {
    	inputBox.click();
    }
    
    //two - 2
    public void selectCountry(String country) {
    	
    	for(WebElement ele:Country) {
    		
    	
    		if(ele.getText().equalsIgnoreCase(country)) {
    			Actions act=new Actions(driver);
    			act.doubleClick(ele).perform();
    			break;
    		}
    		
    	}
    }
    
    //three - 3
    public void clickStartDate() {
    	startDate.click();
    }
    
    //four - 4
    public void selectStartDate(String stdate) {
    	
    	String st[]=stdate.split("/");
    	String date=st[0];
    	String month=st[1];
    	String year=st[2];
    	String startdate=month.substring(0,3).concat(" ").concat(date).concat(", ").concat(year);
    	
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofMillis(500));
		
    	while(true) {


			try{

				WebElement ele=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@aria-label='"+startdate+"']")));
				ele.click();
				break;
			}catch(Exception e) {
				clickNextButton.click();
			}

		}
    }
    
    //five - 5
    public void selectEndDate(String eddate) {
    	
    	String st[]=eddate.split("/");
    	String date=st[0];
    	String month=st[1];
    	String year=st[2];
    	String Enddate=month.substring(0,3).concat(" ").concat(date).concat(", ").concat(year);
    	
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofMillis(1000));
		
    	while(true) {


			try{

				WebElement ele=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@aria-label='"+Enddate+"']")));
				ele.click();
				break;
			}catch(Exception e) {
				clickNextButton.click();
			}

		}
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
 
    //six - 6
    public void clickContinueButton() {
    	continueButton.click();
    }
    
    //seven - 7
    public void selectTravellers(String numberOfTravellers) {
    	int i=0;
    	for(WebElement ele:selectNumberOfTravellers) {
    		if(ele.getAttribute("value").equals(numberOfTravellers)) {
    			try {
    				System.out.println("try block executed");
    				selectNumberOfTravellersList.get(i).click();
        			break;
    			}
    			catch(Exception e) {
    				selectNumberOfTravellersList.get(i).click();
    				System.out.println("catch block executed");
        			break;
    			}	
    		}
    		i++;
    	}
    	
    }
    
    //eight - 8
    public void selectAge(String age) {
    	int i=0;
    	String st=age.concat(" ").concat("years_undefined");
    	
    	for(WebElement ele:AgeSelection) {
    		if(ele.getAttribute("id").equals(st)) {
    			try {
    				AgeSelectionList.get(i).click();
    				break;
    			}
    			catch(Exception e) {
    				AgeSelectionList.get(i).click();
    				break;
    			}		
    		}
    		i++;
    	}
    }
    
    //nine - 9
    public void clickFirstAgeBox() {
    	firstAgeBox.click();
    }
    
    //ten - 10
    public void clickSecondAgeBox() {
    	secondAgeBox.click();
    }
    
    //eleven - 11
    public void selectNoValue() {
    	selectNo.click();
    }
    
    //twelve - 12
    public void clickDoneButton() {
    	DoneButton.click();
    }
    
    //thirteen - 13
    public void clickViewPlans() {
    	ViewPlansButton.click();
    }
    
    
}
 
 


