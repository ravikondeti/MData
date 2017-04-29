package Selenium.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParallelTest1 {
	
	WebDriver Driver;
	@BeforeClass
	@Parameters("browser")
	public void beforeMethod(String browser) {
		if(browser.equalsIgnoreCase("firefox")){
		System.setProperty("webdriver.gecko.driver", "D:\\Softwares\\SeleniumBrowserDrivers\\geckodriver-v0.10.0-win64\\geckodriver.exe");
		Driver =new FirefoxDriver();
	}else if (browser.equalsIgnoreCase("chrome")){
		System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\SeleniumBrowserDrivers\\chromedriver_win32\\chromedriver.exe");
		Driver =new ChromeDriver();
	}else if(browser.equalsIgnoreCase("ie")){
		System.setProperty("webdriver.ie.driver", "D:\\Softwares\\SeleniumBrowserDrivers\\IEDriverServer_x64_2.53.1\\IEDriverServer.exe");
		Driver =new InternetExplorerDriver();
	}
	}
  @Test
  public void faceBookLauncher() throws InterruptedException {
	  
	 Driver.get("https://www.facebook.com/");
	 Thread.sleep(2000);
  }
 
  @AfterClass
  public void afterMethos() {
	  Driver.quit();
  }
}
