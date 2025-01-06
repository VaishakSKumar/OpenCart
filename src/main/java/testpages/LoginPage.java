package testpages;


import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import testbase.BasePage;
import testbase.BaseTest;

public class LoginPage extends BasePage{
	
	public BaseTest bt=new BaseTest();;
	
	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath="//input[@placeholder='E-Mail Address']")
	WebElement myUsernamefield;
	
	@FindBy(xpath="//input[@placeholder='Password']")
	WebElement myPasswordfield;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement myLogginButton;
	
	public void fillLoginFields(String email,String password) {
		
		bt.waitForElement(myUsernamefield, 30);
		bt.sendText(myUsernamefield, email);
		bt.waitForElement(myPasswordfield, 30);
		bt.sendText(myPasswordfield,password);		
	}
	
	public void click_Login() {
		bt.waitForElement(myLogginButton, 30);
		myLogginButton.click();
	}
	
	
}
