package testpages;

import org.openqa.selenium.support.FindBy;

import testbase.BasePage;
import testbase.BaseTest;

import org.openqa.selenium.*;

public class HomePage extends BasePage {
	
	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public BaseTest bt=new BaseTest();
	
	@FindBy(xpath="//span[contains(text(),'Account')]")
	WebElement myAccount;
	
	@FindBy(xpath="//a[contains(text(),'Register')]")
	WebElement register;
	
	@FindBy(xpath="//a[contains(text(),'Login')]")
	WebElement login;
	
	public void click_myAccount() {
	
		myAccount.click();
	}
	
public void click_register() {
	bt.waitForElement(register, 30);
		register.click();
	}

public void click_login() {
	bt.waitForElement(login, 30);
	login.click();
}
	
}
