package Selenium.Test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class NewTest {
	WebDriver firefoxdriver;
	WebDriver ieDriver;
	WebDriver chromeDriver;
	String url;
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", "D:\\Softwares\\SeleniumBrowserDrivers\\geckodriver-v0.10.0-win64\\geckodriver.exe" );
		 
		  System.setProperty("webdriver.ie.driver", "D:\\Softwares\\SeleniumBrowserDrivers\\IEDriverServer_x64_2.53.1\\IEDriverServer.exe");
			
		  System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\SeleniumBrowserDrivers\\chromedriver_win32\\chromedriver.exe");
		  
		  
	}
	
  @Test
  public void firefoxLauncherTest() {
	  firefoxdriver = new FirefoxDriver(); 
	  firefoxdriver.get(url);
  }
  
  @Test
  public void ieDriverTest() { 
	  ieDriver =new InternetExplorerDriver(); 
	  ieDriver.get(url);  
  }
  
  @Test
  public void chromeDriverTest() {
	  chromeDriver =new ChromeDriver();
	  chromeDriver.get(url);
  }
  
  
  
  @BeforeMethod
  public void beforeMethod() {
	   url = "https://www.google.com.sg/";
	 
  }

  @AfterMethod
  public void afterMethod() throws InterruptedException {
	  Thread.sleep(5000);
	  
  }
  @AfterClass
  public void afterclass() {
	  firefoxdriver.quit();
	  ieDriver.quit();
	  chromeDriver.quit();

  }

}
