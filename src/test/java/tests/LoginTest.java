package tests;

import org.testng.Assert;
import org.testng.annotations.*;

import testbase.BaseTest;
import testpages.HomePage;
import testpages.LoginPage;
import testpages.MyAccountPage;

public class LoginTest extends BaseTest{
	
	@Test(groups = {"Sanity","Master"})
	public void Test() {
		try {
		HomePage hp=new HomePage(driver);
		hp.click_myAccount();
		
		hp.click_login();
		
		LoginPage lp=new LoginPage(driver);
		lp.fillLoginFields(p.getProperty("email"), p.getProperty("password"));
		lp.click_Login();
		
		MyAccountPage account=new MyAccountPage(driver);
		boolean expected=account.isMessageDisplayed() ;
			Assert.assertEquals(expected, true,"Login Failed");
			
			account.click_logout();
		
	}catch(Exception e) {
		Assert.fail();
	}
		
		
	}
}
