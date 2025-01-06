package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import testbase.BaseTest;
import testpages.HomePage;
import testpages.LoginPage;
import testpages.MyAccountPage;
import testutilities.Dataproviders;

public class LoginDDT extends BaseTest{

	@Test(dataProvider = "LoginData", dataProviderClass = Dataproviders.class)
	public void test(String email,String password, String expect) {
	try {
			HomePage hp=new HomePage(driver);
			hp.click_myAccount();
			
			hp.click_login();
			
			LoginPage lp=new LoginPage(driver);
			lp.fillLoginFields(email, password);
			lp.click_Login();
			
			MyAccountPage account=new MyAccountPage(driver);
			boolean expected=account.isMessageDisplayed() ;
				
			if (expect.equalsIgnoreCase("Valid")) {
				if (expected==true) {
				
					account.click_logout();
					Assert.assertTrue(true);
				}else {
					Assert.assertTrue(false);
					
				}
			}else if (expect.equalsIgnoreCase("Invalid")) {
				if (expected==true) {
					
					account.click_logout();
					Assert.assertTrue(false);
				}else {
					Assert.assertTrue(true);
					
				}
			}
	}catch(Exception e) {
		Assert.fail();
	}
			
			
		
	}
	
}
