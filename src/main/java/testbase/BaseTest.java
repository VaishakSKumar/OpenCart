package testbase;

import java.io.FileReader;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.text.RandomStringGenerator;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseTest {
	
	public WebDriver driver;
	public Properties p;
	 @BeforeClass
	 @Parameters({"browser"})
	 public void setUp(String browser) throws Exception  {
		 
		 p=new Properties();
		 FileReader fr=new FileReader("C:\\Users\\Vaishak S Kumar\\java\\OpenCart\\src\\test\\resources\\config\\config.properties");
		 p.load(fr);
		 
		 switch (browser.toLowerCase()) {
		case "chrome":
			driver=new ChromeDriver();
			break;
	case "edge":
		driver=new EdgeDriver();
			break;
	case "firefox":
		driver=new FirefoxDriver();
		break;
		default:
			System.out.println("Invalid Browser");
			break;
		}
		 
		 
		 driver.manage().window().maximize();
		 
		
		
		 driver.get(p.getProperty("appURL"));
	 }
	 
	
	public void sendText(WebElement element,String string) {
		element.sendKeys(string);
	}
	

	public String randomString() {
		RandomStringGenerator generator=new RandomStringGenerator.Builder().withinRange('a','z').build();
		String randomString=generator.generate(5);
		return randomString;
	}
	
	public String randomNumeric() {
		RandomStringGenerator generator=new RandomStringGenerator.Builder().withinRange('0','9').build();
		String randomString=generator.generate(10);
		return randomString;
	}
	
	public String randomPassword() {
		RandomStringGenerator generator=new RandomStringGenerator.Builder().withinRange('0','z').build();
		String randomString=generator.generate(10);
		return randomString;
	}
	
	public void waitForElement(WebElement element,long duration) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(duration));
		
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	 @AfterClass
	 public void tearDown() {
		 driver.quit();
	 }
	 

}
