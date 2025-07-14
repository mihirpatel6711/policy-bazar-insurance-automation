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
import java.net.URL;
import java.text.SimpleDateFormat;
import java.io.File;
import java.io.FileInputStream;



public class BaseClass {
	
	
	public static WebDriver driver;
	public Logger logger;
	public Properties p;
	
	@BeforeClass
	@Parameters({"os","browser"})
	public void setup(String os, String br) throws IOException {
		
		
		
		
		
		// Loading properties file from the path 
		FileReader file = new FileReader(".//src//test//resources//config.properties");
		p = new Properties();
		p.load(file);
		
		// loading log4j2 file 
		logger = LogManager.getLogger(this.getClass());
		
		// usage ==> logger.info("**** Starting TC_003_LoginDDT *****"); in your test classes 
		
		if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
		{
			DesiredCapabilities capabilities=new DesiredCapabilities();
			
			//os
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
			
			//browser
			// launching browser based on condition 
			switch(br.toLowerCase()) {
			
			case "chrome":
				ChromeOptions chromeOptions = new ChromeOptions();
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
			
			driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
		}
		
		if(p.getProperty("execution_env").equalsIgnoreCase("local"))
		{

			// launching browser based on condition 
			switch(br.toLowerCase()) {
			
			case "chrome":
				ChromeOptions chromeOptions = new ChromeOptions();
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
		
		
		
		
		
		
		//driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//driver.get(p.getProperty("appurl"));
		driver.manage().window().maximize();
			
				
		
	}
	
	@AfterClass
	public void tearDown(){
		driver.quit();
		
	}
	
	@BeforeMethod
	public void start() {
		driver.navigate().to(p.getProperty("appurl"));
	}
	
	@AfterMethod
	public void restart() {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
		
		
		
		
	}
	
	
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
