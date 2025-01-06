package testpages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import testbase.BasePage;
import testbase.BaseTest;

public class Registrationpage extends BasePage{
	
	public Registrationpage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public BaseTest bt=new BaseTest();

	@FindBy(xpath="//input[@name='firstname']")
	WebElement firstName;
	
	@FindBy(xpath="//input[@name='lastname']")
	WebElement lastName;
	
	@FindBy(xpath="//input[@name='email']")
	WebElement email;
	
	@FindBy(xpath="//input[@name='telephone']")
	WebElement phoneNumber;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath="//input[@name='confirm']")
	WebElement confirmPassword;
	
	@FindBy(xpath="//input[@name='newsletter' and @value='0']")
	WebElement subscribe_News_Letter;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement policy;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement continue_Button;
	
	@FindBy(xpath="//p[contains(text(),'account has been successfully created!')]")
	WebElement accountSuccess;
	
	public void fillRegistration(String fname,String lname,String mailId,String phone,String pword) {
		bt.sendText(firstName, fname);
		bt.sendText(lastName, lname);
		bt.sendText(email, mailId);
		bt.sendText(phoneNumber, phone);
		bt.sendText(password, pword);
		bt.sendText(confirmPassword, pword);
	}
	
	public void click_subscribe_News_Letter() {
		subscribe_News_Letter.click();
	}
	
	public void click_policy() {
		policy.click();
	}
	
	public void click_continue_Button() {
		continue_Button.click();
	}
	
	public String getConfirmationMessage() {
		try {
		return accountSuccess.getText();
		}catch(Exception e){
			return e.getMessage();
		}
		
	}
	
	
}
