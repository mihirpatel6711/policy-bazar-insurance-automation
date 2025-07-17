package pageObjects;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
 
public class TravelInsurancePage extends BasePage {
   
 
    public TravelInsurancePage(WebDriver driver) {
        super(driver);
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
    
    

	/**
	 * Checks if a list of WebElements is populated.
	 *
	 * @param elements List of WebElements to validate
	 * @return true if the list is not null and not empty; false otherwise
	 */
    public static boolean isListPopulated(List<WebElement> elements) {
        return elements != null && !elements.isEmpty();
    }
	

	/**
	 * Validates if a specific value is selectable from a dropdown WebElement.
	 *
	 * @param ele   Dropdown WebElement
	 * @param value Value to be selected
	 * @return true if the value is present and enabled; false otherwise
	 */
    public static boolean isDropdownValueSelectable(WebElement ele,String value) {
		Select select = new Select(ele);
		List<WebElement> options = select.getOptions();

		for (WebElement option : options) {
			if (option.getText().equals(value)) {
				return option.isEnabled(); 
			}
		}
	return false;
	}
    

	 // ===================== Action Methods =====================
	
	 /** Section 1: Input Field */
	
	 /**
	  * Checks if the input field is clickable.
	  *
	  * @return true if clickable; false otherwise
	  */    
    public boolean isInputFieldClickable() {
    	return isElementClickable(inputBox);
    }
    

	/**
	 * Clicks on the input field.
	 */
    public void clickInput() {
    	inputBox.click();
    }    
    

	/** Section 2: Country Selection */
	
	/**
	 * Checks if the country list is populated.
	 *
	 * @return true if populated; false otherwise
	 */
    public boolean isCountryListPopulated() {
    	return isListPopulated(Country);
    }    

	/**
	 * Selects a country from the list by double-clicking.
	 *
	 * @param country Country name to select
	 */
    public void selectCountry(String country) {
    	
    	for(WebElement ele:Country) {    	
    		if(ele.getText().equalsIgnoreCase(country)) {
    			Actions act=new Actions(driver);
    			act.doubleClick(ele).perform();
    			break;
    		}    		
    	}
    }    
    

	/** Section 3: Start Date Selection */
	
	/**
	 * Checks if the start date field is clickable.
	 *
	 * @return true if clickable; false otherwise
	 */
    public boolean isStartDateClickable() {
    	return isElementClickable(startDate);
    }    

	/**
	 * Clicks on the start date field.
	 */
    public void clickStartDate() {
    	startDate.click();
    }    
    

	/** Section 4: Start Date Calendar Navigation */
	
	/**
	 * Checks if the next button in the calendar is clickable.
	 *
	 * @return true if clickable; false otherwise
	 */
    public boolean isStartDateNextClickable() {
    	return isElementClickable(clickNextButton);
    }    

	/**
	 * Selects a start date from the calendar.
	 *
	 * @param stdate Date in format yyyy/MM/dd
	 */
    public void selectStartDate(String stdate) {
    	
    	String st[]=stdate.split("/");
    	String date=st[2];
    	String month=st[1];
    	String year=st[0];
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
    

	/** Section 5: End Date Selection */
	
	/**
	 * Checks if the next button for end date selection is clickable.
	 *
	 * @return true if clickable; false otherwise
	 */
    public boolean isEndDateClickNextClickable() {
    	return isElementClickable(clickNextButton);
    }    

	/**
	 * Selects an end date from the calendar.
	 *
	 * @param eddate Date in format yyyy/MM/dd
	 */
    public void selectEndDate(String eddate) {
    	
    	String st[]=eddate.split("/");
    	String date=st[2];
    	String month=st[1];
    	String year=st[0];
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
 
    
	/** Section 6: Continue Button */
	
	/**
	 * Checks if the continue button is clickable.
	 *
	 * @return true if clickable; false otherwise
	 */
    public boolean isContinueButtonClickable() {
    	return isElementClickable(continueButton);
    }    

	/**
	 * Clicks the continue button.
	 */
    public void clickContinueButton() {
    	continueButton.click();
    }
    

    /** Section 7: Traveller Selection */

	/**
	 * Checks if the traveller list is populated.
	 *
	 * @return true if populated; false otherwise
	 */
    public boolean isTravellersListPopulated() {
    	return isListPopulated(selectNumberOfTravellers);
    }    

	/**
	 * Selects the number of travellers.
	 *
	 * @param numberOfTravellers Number of travellers to select
	 */
    public void selectTravellers(String numberOfTravellers) {
    	int i=0;
    	for(WebElement ele:selectNumberOfTravellers) {
    		if(ele.getAttribute("value").equals(numberOfTravellers)) {
    			try {
    				selectNumberOfTravellersList.get(i).click();
        			break;
    			}
    			catch(Exception e) {
    				selectNumberOfTravellersList.get(i).click();
        			break;
    			}	
    		}
    		i++;
    	}    	
    }    

	/** Section 8: Age Selection */
	
	/**
	 * Checks if the age selection list is populated.
	 *
	 * @return true if populated; false otherwise
	 */
    public boolean isAgeListPopulated() {
    	return isListPopulated(AgeSelection);
    }    

	/**
	 * Selects age from the list.
	 *
	 * @param age Age value to select
	 */
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
    

	/** Section 9: First Age Box */
	
	/**
	 * Checks if the first age box is clickable.
	 *
	 * @return true if clickable; false otherwise
	 */
    public boolean isFirstAgeBoxClickable() {
    	return isElementClickable(firstAgeBox);
    }    

	/**
	 * Clicks the first age box.
	 */
    public void clickFirstAgeBox() {
    	firstAgeBox.click();
    }    
    

	/** Section 10: Second Age Box */
	
	/**
	 * Checks if the second age box is clickable.
	 *
	 * @return true if clickable; false otherwise
	 */
    public boolean isSecondAgeBoxClickable() {
    	return isElementClickable(secondAgeBox);
    }    

	/**
	 * Clicks the second age box.
	 */
    public void clickSecondAgeBox() {
    	secondAgeBox.click();
    }    

	/** Section 11: Select No Button */
	
	/**
	 * Checks if the "No" selection button is clickable.
	 *
	 * @return true if clickable; false otherwise
	 */
    public boolean isSelectNoClickable() {
    	return isElementClickable(selectNo);
    }    

	/**
	 * Clicks the "No" selection button.
	 */
    public void selectNoButton() {
    	selectNo.click();
    }
    

	/** Section 12: Done Button */
	
	/**
	 * Checks if the Done button is clickable.
	 *
	 * @return true if clickable; false otherwise
	 */
    public boolean isDoneButtonClickable() {
    	return isElementClickable(DoneButton);
    }    

	/**
	 * Clicks the Done button.
	 */
    public void clickDoneButton() {
    	DoneButton.click();
    }
    

	/** Section 13: View Plans Button */
	
	/**
	 * Checks if the View Plans button is clickable.
	 *
	 * @return true if clickable; false otherwise
	 */
    public boolean isViewPlansButtonClickable() {
    	return isElementClickable(ViewPlansButton);
    }
    

	/**
	 * Clicks the View Plans button.
	 */
    public void clickViewPlans() {
    	ViewPlansButton.click();
    }
    
    
}
 
 


