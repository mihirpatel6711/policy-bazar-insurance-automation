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
    public void clickStart() {
    	clickStartButton.click();
    }
    
    public boolean isListPopulated(List<WebElement> elements) {
        return elements != null && !elements.isEmpty();
    }
    
    public boolean isCityClickable(String cityName) {
        for (WebElement city : selectcity) {
            if (city.getText().equalsIgnoreCase(cityName)) {
                
            	return isElementClickable(city);  
            }
        }
		return false;
        
    }
    
    public void chooseCity(String cityName) {
        for (WebElement city : selectcity) {
            if (city.getText().equalsIgnoreCase(cityName)) {
                city.click();
                System.out.println("selected  city :"+cityName);
                break;
            }
        }
    }
    public boolean isBrandclickable(String brandName) {
        for (WebElement brand : selectbrandname) {
            if (brand.getText().equalsIgnoreCase(brandName)) {
            	return isElementClickable(brand);
                
            }
        }
		return false;
    }
    

    public void chooseBrand(String brandName) {
        for (WebElement brand : selectbrandname) {
            if (brand.getText().equalsIgnoreCase(brandName)) {
                brand.click();
                System.out.println("selected brandname :"+brandName);
                break;
            }
        }
    }
    public boolean isModelclickable(String modelName) {
        for (WebElement model : carmodel) {
            if (model.getText().equalsIgnoreCase(modelName)) {
            	return isElementClickable(model);
            }
        }
		return false;
    }

    public void chooseModel(String modelName) {
        for (WebElement model : carmodel) {
            if (model.getText().equalsIgnoreCase(modelName)) {
                model.click();
                System.out.println("selected carmodel: "+modelName);
                break;
            }
        }
    }
    public boolean isFuelTypeclickable(String fuelType) {
        for (WebElement fuel : carfueltype) {
            if (fuel.getText().equalsIgnoreCase(fuelType)) {
            	return isElementClickable(fuel);  
            }
        }
		return false;
    }

    public void chooseFuelType(String fuelType) {
        for (WebElement fuel : carfueltype) {
            if (fuel.getText().equalsIgnoreCase(fuelType)) {
                fuel.click();
                System.out.println("selected carfueltype : "+fuelType);
                break;
            }
        }
    }
    public boolean isVariantclickable(String variantName) {
        for (WebElement variant : carvariant) {
            if (variant.getText().equalsIgnoreCase(variantName)) {
            	return isElementClickable(variant);
               
            }
        }
		return false;
    }

    public void chooseVariant(String variantName) {
        for (WebElement variant : carvariant) {
            if (variant.getText().equalsIgnoreCase(variantName)) {
                variant.click();
                System.out.println("selected carvariant: "+variantName);
                break;
            }
        }
    }
    
    public void setName(String name) {
		fullname.sendKeys(name);
		System.out.println("Name entered: " + name);
	}
    public void setMobileNumber(String number) {
    	 MobileNumber.sendKeys(number);
    	 System.out.println("Number entered: " + number);
    }

    public String capturePhoneErrorMessage() {
    try {
          return errormessage.getText();
    } catch (Exception e) {
        return "No error message found";
    }
}
}


 



	


	
	
    




	 



		


		
		
	    




