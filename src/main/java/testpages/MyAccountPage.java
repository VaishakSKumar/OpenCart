package testpages;


import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import testbase.BasePage;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//h2[text()='My Account']")
	WebElement myAccountmessage;
	
	public boolean isMessageDisplayed() {
		try {
		return myAccountmessage.isDisplayed();
		}catch(Exception e) {
			return false;
		}
		
	}
}
