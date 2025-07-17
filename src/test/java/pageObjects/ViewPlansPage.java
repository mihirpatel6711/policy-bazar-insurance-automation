package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ViewPlansPage extends BasePage{
	
	 
    public ViewPlansPage(WebDriver driver) {
        super(driver);
    }
    
    //Locators 
    
    @FindBy(xpath="//input[@id='studentTrip']")
    WebElement studentPlansButton;
    
    @FindBy(xpath= "//label[@for='Traveller_1']")
    WebElement selectFirstTraveller;
    
    @FindBy(xpath="//label[@for='Traveller_2']")
    WebElement selectSecondTraveller;
    
    @FindBy(xpath = "//select[@id='feet']")
    WebElement travelDurationDropdown;

    @FindBy(xpath="//button[normalize-space()='Apply']")
    WebElement applyButton;
    
    @FindBy(xpath="//section[@class='newFilterSection sort']//details//summary")
    WebElement sortByPrice;
    
    @FindBy(xpath="//input[@id='17_sort']")
    WebElement lowtohigh;
    
    @FindBy(xpath="//article[@class ='quotesCardWrapper ']//p[@class='quotesCard--insurerName']")
    List<WebElement> namesList;
    
    @FindBy(xpath="//article[@class ='quotesCardWrapper ']//span[@class='premiumPlanPrice']")
    List<WebElement> priceList;
    

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
	
	 /** Section 14: Student Plan Selection */
	
	 /**
	  * Checks if the student plan button is clickable.
	  *
	  * @return true if clickable; false otherwise
	  */
    public boolean isStudentPlanSelectable() {
        return isElementClickable(studentPlansButton);
    }    

	/**
	 * Clicks the student plan button.
	 */
    public void selectStudentPlans() {
    	studentPlansButton.click();
    }           

	/** Section 15: First Traveller Selection */
    
	/**
	 * Checks if the first traveller checkbox is clickable.
	 *
	 * @return true if clickable; false otherwise
	 */
    public boolean isFirstTravellerClickable() {
        return isElementClickable(selectFirstTraveller);
    }    

	/**
	 * Selects the first traveller by clicking the checkbox.
	 */
    public void selectFirstTraveller() {
    	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
    	WebElement ele=wait.until(ExpectedConditions.elementToBeClickable(selectFirstTraveller));
    	ele.click();
//    	System.out.println("Traveller one checked");
    }    

	/** Section 16: Second Traveller Selection */
	
	/**
	 * Checks if the second traveller checkbox is clickable.
	 *
	 * @return true if clickable; false otherwise
	 */
    public boolean isSecondTravellerClickable() {
        return isElementClickable(selectSecondTraveller);
    }
    public void selectSecondTraveller() {
    	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
    	WebElement ele=wait.until(ExpectedConditions.elementToBeClickable(selectSecondTraveller));
    	ele.click();
//    	System.out.println("Traveller two checked");
    }     

	/** Section 17: Travel Duration Dropdown */
	
	/**
	 * Checks if the travel duration dropdown contains the specified value and is selectable.
	 *
	 * @param duration Duration value to check
	 * @return true if selectable; false otherwise
	 */
    public boolean isTravelDurationSelectable(String duration) {
    	return isDropdownValueSelectable(travelDurationDropdown,duration);
    }    

	/**
	 * Selects a travel duration from the dropdown.
	 *
	 * @param duration Duration value to select
	 */
    public void selectTravelDuration(String duration) {
        Select select = new Select(travelDurationDropdown);
        select.selectByVisibleText(duration);
    }    

	/** Section 18: Apply Button */
	
	/**
	 * Checks if the Apply button is clickable.
	 *
	 * @return true if clickable; false otherwise
	 */
    public boolean isApplyButtonClickable() {
    	return isElementClickable(applyButton);
    }    

	/**
	 * Clicks the Apply button.
	 */
    public void clickApplyButton() {
    	applyButton.click();
    }    

	/** Section 19: Sort By Price */
	
	/**
	 * Checks if the Sort By button is clickable.
	 *
	 * @return true if clickable; false otherwise
	 */
    public boolean issortByButtonClickable() {
    	return isElementClickable(sortByPrice);
    }   

	/**
	 * Clicks the Sort By Price button.
	 */
    public void selectSortBy() {
    	sortByPrice.click();
    }        

	/** Section 20: Low to High Sorting */
	
	/**
	 * Checks if the Low to High sorting option is clickable.
	 *
	 * @return true if clickable; false otherwise
	 */
    public boolean isLowToHighButtonClickable() {
    	return isElementClickable(lowtohigh);
    }    

	/**
	 * Selects the Low to High sorting option.
	 */
    public void selectLowToHigh() {
    	lowtohigh.click();
    }    

	/** Section 21: Plan Summary */
	
	/**
	 * Checks if the list of company names is populated.
	 *
	 * @return true if populated; false otherwise
	 */
    public boolean isNameListPopulated() {
    	return isListPopulated(namesList);
    }    

	/**
	 * Checks if the list of prices is populated.
	 *
	 * @return true if populated; false otherwise
	 */
    public boolean isPriceListPopulated() {
    	return isListPopulated(priceList);
    }   

	/**
	 * Prints the top 3 insurance plans with company name and price.
	 */
    public void printList() {
    	for(int i=1; i<=3; i++) {
	    	String element="";
	    	String companyName = namesList.get(i).getText();
	    	String price = priceList.get(i).getText();
	    	element="Company Name = "+companyName+" : Price = "+price;
	    	System.out.println(element);	
	    }
    }

}

