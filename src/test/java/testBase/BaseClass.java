package testBase;

import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.io.File;
import java.io.FileInputStream;




/**
 * BaseClass serves as the foundational setup and teardown class for all test cases.
 * It handles browser initialization, configuration loading, logging setup, and utility methods.
 */
public class BaseClass {
	
	
	public static WebDriver driver;
	public Logger logger;			// Logger instance for logging test execution
	public Properties p;			// Properties object to load configuration values
	
	
	

/**
     * Initializes the WebDriver based on the specified OS and browser.
     * Supports both local and remote execution environments.
     *
     * @param os Operating system (e.g., Windows, Mac)
     * @param br Browser name (e.g., Chrome, Edge)
     * @throws IOException if configuration file or remote URL fails to load
     */	

	@BeforeClass
	@Parameters({"os","browser"})
	public void setup(String os, String br) throws IOException {
		
		
		
		try {
			
		// Load configuration properties from file 
		FileReader file = new FileReader(".//src//test//resources//config.properties");
		p = new Properties();
		p.load(file);
		
		
		// Initialize logger using Log4j2
		logger = LogManager.getLogger(this.getClass());
		ChromeOptions chromeOptions;	
		
		 
		// Check execution environment: remote or local
		if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
		{
			System.out.println("Executing Remotely");
			DesiredCapabilities capabilities=new DesiredCapabilities();
			
			// Set platform based on OS parameter
			if(os.equalsIgnoreCase("windows"))
			{
				capabilities.setPlatform(Platform.WIN11);
			}
			else if (os.equalsIgnoreCase("mac"))
			{
				capabilities.setPlatform(Platform.MAC);
			}
			else
			{
				System.out.println("No matching os");
				return;
			}
			
			// Set browser capabilities			
			switch(br.toLowerCase())
			{
			case "chrome": capabilities.setBrowserName("chrome");
			capabilities.setBrowserName(br.toLowerCase());
			chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--disable-blink-features=AutomationControlled");
            chromeOptions.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
            chromeOptions.setExperimentalOption("useAutomationExtension", false);
            chromeOptions.addArguments("--start-maximized");
            capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
			break;
			case "edge": capabilities.setBrowserName("MicrosoftEdge"); break;
			default: System.out.println("No matching browser"); return;
			}
			
			//driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
			// This was depreciated
			
			// Convert string URL to URI and then to URL for remote execution
			String seleniumHubUrlString = "http://192.168.1.38:4444/wd/hub";
			URI uri = new URI(seleniumHubUrlString);
			URL seleniumHubUrl = uri.toURL();

			// Initialize RemoteWebDriver
			driver = new RemoteWebDriver(seleniumHubUrl, capabilities);
		}
		
		// Local execution setup
		if(p.getProperty("execution_env").equalsIgnoreCase("local"))
		{

			// launching browser based on condition 
			switch(br.toLowerCase()) {
			
			case "chrome":
				chromeOptions = new ChromeOptions();
	            chromeOptions.addArguments("--disable-blink-features=AutomationControlled");
	            chromeOptions.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
	            chromeOptions.setExperimentalOption("useAutomationExtension", false);
	            chromeOptions.addArguments("--start-maximized");
	            driver = new ChromeDriver(chromeOptions);
	            break;
			case "edge" : 
				EdgeOptions edgeOptions = new EdgeOptions();
	            edgeOptions.addArguments("--disable-blink-features=AutomationControlled");
	            edgeOptions.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
	            edgeOptions.setExperimentalOption("useAutomationExtension", false);
	            edgeOptions.addArguments("--start-maximized");
	            driver = new EdgeDriver(edgeOptions);
	            break;
			default : System.out.println("No matching browser....");
			return ;	
			
			}
		}		
		
		// Set implicit wait and maximize window
		
		//driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//driver.get(p.getProperty("appurl"));
		driver.manage().window().maximize();
			
				
		
	}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	

/**
     * Quits the WebDriver instance after all tests are executed.
     */
	@AfterClass
	public void tearDown(){
		driver.quit();
		
	}

    /**
     * Navigates to the application URL before each test method.
     */
	@BeforeMethod
	public void start() {
		driver.navigate().to(p.getProperty("appurl"));
	}	

    /**
     * Clears cookies and refreshes the browser after each test method.
     */
	@AfterMethod
	public void restart() {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();		
	}
	
    /**
     * Captures a screenshot of the current browser window.
     *
     * @param tname Test name or identifier for the screenshot file
     * @return Path to the saved screenshot file
     * @throws IOException if file saving fails
     */
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		return destination;

	}
	
	
	
	
	

}
