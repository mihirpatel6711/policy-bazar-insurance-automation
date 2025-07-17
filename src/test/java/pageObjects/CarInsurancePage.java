package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class CarInsurancePage extends BasePage {

    public CarInsurancePage(WebDriver driver) {
		super(driver);
	}
    //Locators
    @FindBy(xpath = "/html/body/section/section/div/div/div/div[2]/div/div[3]/div/span")
    WebElement clickStartButton; 

    @FindBy(xpath = "//ul[@class='gridList CityRTO_gridList__W74_c']/li/span[1]")
    public List<WebElement> selectcity;

    @FindBy(xpath = "//ul[@class='gridList slideToLeft']/li/span")
    public List<WebElement> selectbrandname;

    @FindBy(xpath = "//ul[@class='gridList    slideToLeft mb-16']/li")
    public List<WebElement> carmodel;

    @FindBy(xpath = "//ul[@class='gridList slideToLeft']/li")
    public List<WebElement> carfueltype;

    @FindBy(xpath = "//ul[@class='gridList slideToLeft mb-24']/li")
    public List<WebElement> carvariant;

    @FindBy(xpath = "//input[@id='name-form-control']")
    WebElement inputField;
    
    @FindBy(xpath="//input[@placeholder = \"Full name\"]")
    WebElement fullname;
    
    @FindBy(xpath="//input[@placeholder = \"Mobile number\"]")
    WebElement MobileNumber;
    
    @FindBy(xpath="//div[@class='errorMsg']")
    WebElement errormessage;
    
    
    
    

   //Action methods
    

	
    //Clicks the "Start" button on the page.
    public void clickStart() {
    	clickStartButton.click();
    }
    
	/**
	 * Checks whether the provided list of WebElements is populated.
	 *
	 * @param elements List of WebElements to validate
	 * @return true if the list is not null and not empty; false otherwise
	 */
    public boolean isListPopulated(List<WebElement> elements) {
        return elements != null && !elements.isEmpty();
    }    

	/**
	 * Determines if a city element is clickable based on the provided city name.
	 *
	 * @param cityName Name of the city to verify
	 * @return true if the city element is clickable; false otherwise
	 */
    public boolean isCityClickable(String cityName) {
        for (WebElement city : selectcity) {
            if (city.getText().equalsIgnoreCase(cityName)) {
                
            	return isElementClickable(city);  
            }
        }
		return false;        
    }    

	/**
	 * Selects a city from the list based on the provided city name.
	 *
	 * @param cityName Name of the city to select
	 */
    public void chooseCity(String cityName) {
        for (WebElement city : selectcity) {
            if (city.getText().equalsIgnoreCase(cityName)) {
                city.click();
                System.out.println("selected  city :"+cityName);
                break;
            }
        }
    }    

	/**
	 * Determines if a brand element is clickable based on the provided brand name.
	 *
	 * @param brandName Name of the brand to verify
	 * @return true if the brand element is clickable; false otherwise
	 */
    public boolean isBrandclickable(String brandName) {
        for (WebElement brand : selectbrandname) {
            if (brand.getText().equalsIgnoreCase(brandName)) {
            	return isElementClickable(brand);                
            }
        }
		return false;
    }    

	/**
	 * Selects a brand from the list based on the provided brand name.
	 *
	 * @param brandName Name of the brand to select
	 */
    public void chooseBrand(String brandName) {
        for (WebElement brand : selectbrandname) {
            if (brand.getText().equalsIgnoreCase(brandName)) {
                brand.click();
                System.out.println("selected brandname :"+brandName);
                break;
            }
        }
    }    

	/**
	 * Determines if a car model element is clickable based on the provided model name.
	 *
	 * @param modelName Name of the car model to verify
	 * @return true if the model element is clickable; false otherwise
	 */
    public boolean isModelclickable(String modelName) {
        for (WebElement model : carmodel) {
            if (model.getText().equalsIgnoreCase(modelName)) {
            	return isElementClickable(model);
            }
        }
		return false;
    }    

	/**
	 * Selects a car model from the list based on the provided model name.
	 *
	 * @param modelName Name of the car model to select
	 */
    public void chooseModel(String modelName) {
        for (WebElement model : carmodel) {
            if (model.getText().equalsIgnoreCase(modelName)) {
                model.click();
                System.out.println("selected carmodel: "+modelName);
                break;
            }
        }
    }    

	/**
	 * Determines if a fuel type element is clickable based on the provided fuel type.
	 *
	 * @param fuelType Type of fuel to verify
	 * @return true if the fuel type element is clickable; false otherwise
	 */
    public boolean isFuelTypeclickable(String fuelType) {
        for (WebElement fuel : carfueltype) {
            if (fuel.getText().equalsIgnoreCase(fuelType)) {
            	return isElementClickable(fuel);  
            }
        }
		return false;
    }

	/**
	 * Selects a fuel type from the list based on the provided fuel type.
	 *
	 * @param fuelType Type of fuel to select
	 */
    public void chooseFuelType(String fuelType) {
        for (WebElement fuel : carfueltype) {
            if (fuel.getText().equalsIgnoreCase(fuelType)) {
                fuel.click();
                System.out.println("selected carfueltype : "+fuelType);
                break;
            }
        }
    }    

	/**
	 * Determines if a variant element is clickable based on the provided variant name.
	 *
	 * @param variantName Name of the variant to verify
	 * @return true if the variant element is clickable; false otherwise
	 */
    public boolean isVariantclickable(String variantName) {
        for (WebElement variant : carvariant) {
            if (variant.getText().equalsIgnoreCase(variantName)) {
            	return isElementClickable(variant);
               
            }
        }
		return false;
    }    

	/**
	 * Selects a variant from the list based on the provided variant name.
	 *
	 * @param variantName Name of the variant to select
	 */
    public void chooseVariant(String variantName) {
        for (WebElement variant : carvariant) {
            if (variant.getText().equalsIgnoreCase(variantName)) {
                variant.click();
                System.out.println("selected carvariant: "+variantName);
                break;
            }
        }
    }    

	/**
	 * Inputs the user's full name into the corresponding field.
	 *
	 * @param name Full name to be entered
	 */
    public void setName(String name) {
		fullname.sendKeys(name);
		System.out.println("Name entered: " + name);
	}
    
    /**
	 * Inputs the user's mobile number into the corresponding field.
	 *
	 * @param number Mobile number to be entered
	 */
    public void setMobileNumber(String number) {
    	 MobileNumber.sendKeys(number);
    	 System.out.println("Number entered: " + number);
    }    

	/**
	 * Captures and returns the error message displayed for the mobile number field.
	 *
	 * @return Error message text if present; otherwise, a default message
	 */
    public String capturePhoneErrorMessage() {
    try {
          return errormessage.getText();
    } catch (Exception e) {
        return "No error message found";
    }
}
}


 



	


	
	
    




	 



		


		
		
	    




