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
    
    public static boolean isListPopulated(List<WebElement> elements) {
        return elements != null && !elements.isEmpty();
    }
	
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
    
    
    
    
    //Action Methods
    
    //fourteen - 14
    public boolean isStudentPlanSelectable() {
        return isElementClickable(studentPlansButton);
    }
    public void selectStudentPlans() {
    	studentPlansButton.click();
    }
   
    
    //fifteen - 15
    public boolean isFirstTravellerClickable() {
        return isElementClickable(selectFirstTraveller);
    }
    public void selectFirstTraveller() {
    	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
    	WebElement ele=wait.until(ExpectedConditions.elementToBeClickable(selectFirstTraveller));
    	ele.click();
    	System.out.println("Traveller one checked");
    }
    
    
    //sixteen - 16
    public boolean isSecondTravellerClickable() {
        return isElementClickable(selectSecondTraveller);
    }
    public void selectSecondTraveller() {
    	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
    	WebElement ele=wait.until(ExpectedConditions.elementToBeClickable(selectSecondTraveller));
    	ele.click();
    	System.out.println("Traveller two checked");
    } 
    
    
    //seventeen - 17
    public boolean isTravelDurationSelectable(String duration) {
    	return isDropdownValueSelectable(travelDurationDropdown,duration);
    }
    public void selectTravelDuration(String duration) {
        Select select = new Select(travelDurationDropdown);
        select.selectByVisibleText(duration);
    }
    
    
    //eighteen - 18
    public boolean isApplyButtonClickable() {
    	return isElementClickable(applyButton);
    }
    public void clickApplyButton() {
    	applyButton.click();
    }
    
    
    //Nineteen - 19
    public boolean issortByButtonClickable() {
    	return isElementClickable(sortByPrice);
    }
    public void selectSortBy() {
    	sortByPrice.click();
    }
    
    
    //Twenty - 20
    public boolean isLowToHighButtonClickable() {
    	return isElementClickable(lowtohigh);
    }
    public void selectLowToHigh() {
    	lowtohigh.click();
    }
    
    
    //TwentyOne - 21
    public boolean isNameListPopulated() {
    	return isListPopulated(namesList);
    }
    public boolean isPriceListPopulated() {
    	return isListPopulated(priceList);
    }
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

