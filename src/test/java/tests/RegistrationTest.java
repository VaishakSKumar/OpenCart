package tests;

import org.testng.Assert;
import org.testng.annotations.*;

import testbase.BaseTest;
import testpages.HomePage;
import testpages.Registrationpage;

public class RegistrationTest extends BaseTest {
	
	
 public	HomePage hp;
 public Registrationpage rp;

 
 
 @Test(groups = {"Regression","Master"})
 public void Test() {
	 
	 hp=new HomePage(driver);
	
	 hp.click_myAccount();
	 
	 hp.click_register();
	 
	 rp=new Registrationpage(driver);
	 
	 rp.fillRegistration(randomString(), randomString(), randomString()+"@yopmail.com", randomNumeric(), randomPassword());
	 
	 rp.click_subscribe_News_Letter();
	 
	 rp.click_policy();
	 
	 rp.click_continue_Button();
	 
	 String accountMessage=rp.getConfirmationMessage();
	 
	 if (accountMessage.contains("Congratulations")) {
		Assert.assertTrue(true);
	}else {
		Assert.fail();
	}
 }
 

 
}
