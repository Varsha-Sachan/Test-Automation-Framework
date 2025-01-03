package com.ui.tests;

import static com.constants.Browser.*;
import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pages.Homepage;
import com.ui.pojo.User;
import com.utility.LoggerUtility;

@Listeners({ com.ui.listener.TestListener.class })

public class LoginTest extends TestBase {

	Logger logger = LoggerUtility.getLogger(this.getClass());


	@Test(description = "Valid user able to login in to application with JSON Data..", groups = { "e2e",
			"Sanity" }, dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginTestDataProvider", retryAnalyzer = com.ui.listener.MyRetryAnalyzer.class)
	public void loginTest(User user) {
		assertEquals(homepage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getusername(),
				"Jatin Sharma1");
	}

	@Test(description = "Verifies with the invalid user is able to login into the application", groups = { "e2e",
			"Sanity" })
	public void loginTest1() {
		assertEquals(homepage.goToLoginPage().doLoginWith("bakomam596@skrak.com", "password").getusername(),
				"Jatin Sharma111");
	}

	@Test(description = "Verifies with the valid user is able to login into the application", groups = { "e2e",
			"Sanity" }, dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginTestCSVDataProvider")
	public void loginTestCSV(User user) {
		assertEquals(homepage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getusername(),
				"Jatin Sharma");
	}

	@Test(description = "Verifies with the valid user is able to login into the application", groups = { "e2e",
			"Sanity" }, dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginTestExcelDataProvider")

	public void loginTestExcel1(User user) {

		assertEquals(homepage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getusername(),
				"Jatin Sharma");

	}

}
