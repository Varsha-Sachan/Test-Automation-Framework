package com.ui.tests;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.constants.Browser;
import com.ui.pages.Homepage;
import com.utility.BrowserUtility;
import com.utility.LambdaTestUtility;
import com.utility.LoggerUtility;

public class TestBase {
    Logger logger = LoggerUtility.getLogger(this.getClass());
    protected Homepage homepage;
    private boolean isLambdaTest;
    private boolean isHeadLess = true;

    @Parameters({"browser", "isLambdaTest", "isHeadless"})
    @BeforeMethod(description = "To Launch the homepage")
    public void setUp(
    		@Optional("Chrome") String browser, 
    		@Optional ("false") boolean isLambdaTest,
    		@Optional("true") boolean isHeadless, ITestResult result) {
        
    	this.isLambdaTest = isLambdaTest;
        this.isHeadLess = isHeadless;
        
        WebDriver lambdaDriver;
        if (isLambdaTest) {
            lambdaDriver = LambdaTestUtility.initializeLambdaTestSession(browser, result.getMethod().getMethodName());
            homepage = new Homepage(lambdaDriver);
        } else {
            // Running the test on the local machine.
            logger.info("Loads the homepage of the website");
            homepage = new Homepage(Browser.valueOf(browser.toUpperCase()), isHeadLess);
        }
    }

    public BrowserUtility getInstance() {
        return homepage;
    }

    @AfterMethod(description = "Tear down the browser")
    public void tearDown() {
        if (isLambdaTest) {
            LambdaTestUtility.quitsession();
        } else {
            homepage.quit();
        }
    }
}
