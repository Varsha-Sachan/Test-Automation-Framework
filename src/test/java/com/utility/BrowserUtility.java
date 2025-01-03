package com.utility;
 
import java.io.File;

import java.io.IOException;

import java.text.SimpleDateFormat;

import java.util.Date;
 
import org.apache.commons.io.FileUtils;

import org.apache.logging.log4j.Logger;

import org.openqa.selenium.By;

import org.openqa.selenium.OutputType;

import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
 
import com.constants.Browser;
 
public class BrowserUtility<TakeScreenshot> {

	Logger logger = LoggerUtility.getLogger(this.getClass());

	private static ThreadLocal< WebDriver> driver= new ThreadLocal<WebDriver>();
 
	/*

	 * public void setDriver(WebDriver driver) { this.driver = driver; }

	 */
 
 
	public WebDriver getDriver() {

		return driver.get();

	}
 
	public BrowserUtility(WebDriver driver) {
 
		super();

		this.driver.set(driver); // Initialize the Instance variable driver!!!

	}

// public BrowserUtility(String browserName) {

//	 if(browserName.equalsIgnoreCase("chrome")) {

//		 driver= new ChromeDriver();

//			 

//	 }

//	 else if(browserName.equalsIgnoreCase("edge")){

//		 

//		 driver=new EdgeDriver();

//		 

//	 } 

//	 else if(browserName.equalsIgnoreCase("firefox")) {

//		 driver= new FirefoxDriver();

//			 

//	 }

//	 else {

//		 

//		 System.out.println("please enter chrome , edge or firefox");

//	 }
 
	// }
 
	public void goToWebsite(String url) {

		logger.info("Go to Website url");

		driver.get().get(url);
 
	}
 
	public void maximizewebsite() {

		logger.info("Maximize the browser window");

		driver.get().manage().window().maximize();
 
	}
 
	public void clickon(By locator) {

		logger.info("Finding ELement with the locator" + locator);

		WebElement element = driver.get().findElement(locator);

		logger.info("ELement Found, now perform click" + locator);

		element.click();
 
	}
 
	public void entertext(By locator, String textToEnter) {

		logger.info("Finding ELement with the locator" + locator);

		WebElement element = driver.get().findElement(locator);

		logger.info("ELement Found, now enter text" + textToEnter);

		element.sendKeys(textToEnter);
 
	}
 
	public String getvisibletext(By locator) {

		logger.info("Finding ELement with the locator" + locator);

		WebElement element = driver.get().findElement(locator);

		logger.info("ELement Found, now returning the visible text" + element.getText());

		return element.getText();
 
	}
 
	public BrowserUtility(Browser browserName, boolean isHeadLess) {

		logger.info("Launching browser for " + browserName);

		if (browserName == Browser.CHROME) {
			if(isHeadLess) {
			ChromeOptions options=new ChromeOptions();
		options.addArguments("--headless=old");
			options.addArguments("--window-size= 1920,1080");
          driver.set(new ChromeDriver(options));			
			} 
		else {
            driver.set(new ChromeDriver());
		}
			
	      } 
		else if (browserName == Browser.EDGE) {
	if (isHeadLess) {
			EdgeOptions options = new EdgeOptions();
		options.addArguments("--headless=old");
		options.addArguments("--disable-gpu");
		driver.set(new EdgeDriver(options));
		} else {
	      driver.set(new EdgeDriver());
		
	     } 
		}
		else if (browserName == Browser.FIREFOX) {
			if (isHeadLess) {
			EdgeOptions options = new EdgeOptions();
			options.addArguments("--headless=old");
			options.addArguments("--disable-gpu");
			driver.set(new EdgeDriver(options));}
			else {
		driver.set(new FirefoxDriver());
			}
 
		} else {

			logger.error("Invalid Browser Name....Please select the chrome or edge only!!!");

			System.err.print("Invalid Browser Name....Please select the chrome or edge only!!!");

		}
 
	}

	public String takeScreenshot(String fileName) {

	    // Cast the driver to TakesScreenshot

	    TakesScreenshot takeScreenshot = (TakesScreenshot) driver.get();
 
	    // Capture the screenshot as a File

	    File file = takeScreenshot.getScreenshotAs(OutputType.FILE);
 
	    Date date = new Date();

	    SimpleDateFormat dateFormat = new SimpleDateFormat("HH-mm-ss");

	    String timestamp = dateFormat.format(date);
 	    // Construct the path to save the screenshot


	    String path = System.getProperty("user.dir") + "//screenshots//" +fileName+ " - "+ timestamp +".png"; 
	    // Create a new File object for the screenshot path

	    File screenshot = new File(path);
 
	    try {

	        // Copy the captured screenshot to the desired location

	        FileUtils.copyFile(file, screenshot);

	    } catch (IOException e) {

	        // Print the stack trace if an exception occurs

	        e.printStackTrace();

	    }
 
	    // Return the path of the saved screenshot

	    return path;

	}

	public void quit() {

		driver.get().quit();

	}

}

 