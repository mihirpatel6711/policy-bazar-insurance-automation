package pageObjects;
import java.time.Duration;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



	/**
	 * BasePage serves as a foundational class for all page objects.
	 * It encapsulates common functionality such as driver initialization and wait handling.
	 * All page classes should extend this class to inherit shared behaviors.
	 */

public class BasePage {
	
	// WebDriver instance used for interacting with the browser
	public WebDriver driver;
	

    // WebDriverWait instance used for explicit waits
	public WebDriverWait wait;
	

	/**
     * Constructor to initialize the BasePage with WebDriver and WebDriverWait.
     * Also initializes page elements using PageFactory.
     *
     * @param driver WebDriver instance passed from the test class or parent page
     */
	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	/**
     * Checks if a given WebElement is clickable within the defined wait duration.
     *
     * @param element WebElement to be checked for clickability
     * @return true if the element is clickable, false otherwise
     */
	
	public boolean isElementClickable(WebElement element) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }	
	
	

}


