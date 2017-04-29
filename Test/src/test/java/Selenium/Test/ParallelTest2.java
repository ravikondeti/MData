package Selenium.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ParallelTest2 {
	
	WebDriver ffDriver1;
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", "D:\\Softwares\\SeleniumBrowserDrivers\\geckodriver-v0.10.0-win64\\geckodriver.exe");
	}
  @Test
  public void googleLauncher() throws InterruptedException {
	  ffDriver1 =new FirefoxDriver();
	 ffDriver1.get("https://www.google.com.sg/");
	 Thread.sleep(2000);
  }
  
  @AfterClass
  public void afterClass() {
	  ffDriver1.quit();
  }
  
}
