package stepdefinition;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.impl.Log4JLogger;
import org.apache.logging.log4j.core.impl.Log4jLogEvent;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginTest {

	String url = "https://www.facebook.com/";
	//String username = "ravi.kondeti@gmail.com";
	//String password = "Paraiah@200186";
	WebDriver driver = null;
	WebDriverWait waitdriver = null;

	@Given("^user is on home page$")
	public void user_is_on_home_page() throws Throwable {
		System.setProperty("webdriver.gecko.driver",
				"D:\\Softwares\\SeleniumBrowserDrivers\\geckodriver-v0.10.0-win64\\geckodriver.exe");
		System.out.println("set firefox driver property.");
		driver = new FirefoxDriver();
		System.out.println("firefox Driver created");
		waitdriver = new WebDriverWait(driver, 10);
	}

	@When("^user navigate to log in page$")
	public void user_navigate_to_log_in_page() throws Throwable {
		driver.get(url);
		System.out.println("navigate to url");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
	@When("^user enter credentials to login$")
	public void user_enter_credentials_to_login(List<Credentials> usercrfedentials) throws Throwable {
		
		for (Credentials credentials: usercrfedentials){
			
		driver.findElement(By.id("email")).sendKeys(credentials.getUserName());
		System.out.println("entering password");
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(credentials.getPassword());
		System.out.println("clicking login button");
		driver.findElement(By.xpath("//label[@id='loginbutton']")).click();
		Thread.sleep(2000);
		
		}
	}
	/*@When("^user enter credentials to login$")
	public void user_enter_credentials_to_login(DataTable usercredentials) throws Throwable {
		System.out.println("creating map");
		for (Map<String, String> data : usercredentials.asMaps(String.class, String.class)){
			
			driver = new FirefoxDriver();
			waitdriver = new WebDriverWait(driver, 10);
			System.out.println("opening web url");
			driver.navigate().to(url);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			System.out.println("entering username");
		driver.findElement(By.id("email")).sendKeys(data.get("username"));
		System.out.println("entering password");
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(data.get("password"));
		System.out.println("clicking login button");
		driver.findElement(By.xpath("//label[@id='loginbutton']")).click();
		Thread.sleep(2000);
		
		}
	}*/
	/*@When("^user enter username and password$")
	public void user_enter_username_and_password() {
		driver.findElement(By.id("email")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(password);
		driver.findElement(By.xpath("//label[@id='loginbutton']")).click();

	}*/

	@Then("^message displayed login successfully$")
	public void message_displayed_login_successfully() throws Throwable {
		Boolean status = driver.findElement(By.xpath("//a[contains(text(),'Ravi Kondeti')]")).isDisplayed();
		Assert.assertTrue("Successful login.", status);

	}

	@When("^user log out from the appliation$")
	public void user_log_out_from_the_appliation() throws Throwable {
		 waitdriver.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[div[a[@id='pageLoginAnchor']]]")));
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[@id='pageLoginAnchor']")).click();
		Thread.sleep(2000);
		 waitdriver.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Log Out']")));
		driver.findElement(By.xpath("//span[text()='Log Out']")).click();
		// waitdriver.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value='Log
		// In']"))).isDisplayed();
	}

	@Then("^message displayed logout successfully$")
	public void message_displayed_logout_successfully() throws Throwable {
		Boolean isHomePage = driver.findElement(By.xpath("//input[@value='Log In']")).isDisplayed();
		Assert.assertTrue("Successful logout", isHomePage);
	}

}
