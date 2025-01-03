package com.ui.pages;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
 
import com.utility.BrowserUtility;
 
public class LoginPage extends BrowserUtility{
	private static final By EMAIL_TEXT_BOX_LOCATOR =By.id("email");
	private static final By PASSWORD_TEXT_BOX_LOCATOR =By.id("passwd");
	private static final By SUBMIT_BUTTON_LOCATOR=By.id("SubmitLogin");
	
	public LoginPage(WebDriver driver) {
		super(driver);
 
	}
public MyAccountPage doLoginWith( String emailAddress, String password ) {
entertext(EMAIL_TEXT_BOX_LOCATOR, emailAddress);
entertext(PASSWORD_TEXT_BOX_LOCATOR, password);
clickon(SUBMIT_BUTTON_LOCATOR);
MyAccountPage myaccountpage=new MyAccountPage(getDriver());
return myaccountpage;
	
	
}
 
 
 
	}