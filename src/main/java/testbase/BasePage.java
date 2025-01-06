package testbase;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
	
	
		
		public WebDriver driver;
		
		public BasePage(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver, this);
		
		}
		
	
}
