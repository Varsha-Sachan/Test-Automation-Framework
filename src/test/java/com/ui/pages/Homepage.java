package com.ui.pages;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Browser;
import static com.constants.Env.*;
import com.utility.BrowserUtility;
import com.utility.JSONUtility;
import com.utility.LoggerUtility;

public final class Homepage extends BrowserUtility {
	Logger logger = LoggerUtility.getLogger(this.getClass());
	private static final By SIGN_IN_LINK_LOCATOR= By.xpath("//a[contains(text(),\"Sign in\")]");

	public Homepage(Browser browser,boolean isHeadLess) {
		super(browser,isHeadLess);//to call the parent class constructor from the child constructor
		goToWebsite(JSONUtility.readJson(QA).getUrl());
		maximizewebsite();
		
	}

	public LoginPage goToLoginPage() 
	{
		logger.info("Trying to click on go to the login page");
		clickon(SIGN_IN_LINK_LOCATOR);
		return new LoginPage(getDriver());
	}

	public Homepage(WebDriver driver) {
		super(driver); // To Call the Parent Class constructor from the child constructor
		goToWebsite(JSONUtility.readJson(QA).getUrl());
	}
	

}
