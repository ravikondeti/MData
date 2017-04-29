package stepdefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginTest {
	WebDriver driver =null;
	@Given("^Launch the website store\\.demoqa\\.com$")
	public void launch_the_website_store_demoqa_com() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\SeleniumBrowserDrivers\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.get("http://store.demoqa.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@When("^Brower should land on home page$")
	public void brower_should_land_on_home_page() throws Throwable {
		String homePageTitle =driver.getTitle();
		Assert.assertEquals(homePageTitle, "ONLINE STORE | Toolsqa Dummy Test site", "Wrong title showing");

	}

	@Then("^Toolsqa logo should display at homepage$")
	public void toolsqa_logo_should_display_at_homepage() throws Throwable {
		Boolean isLogoDisplayed = driver.findElement(By.xpath("//a[@id='logo']/img")).isDisplayed();
		Assert.assertTrue(isLogoDisplayed, "Logo is not showing on homepage");
	}

	@Then("^Checkout button should be available at homepage$")
	public void checkout_button_should_be_available_at_homepage() throws Throwable {
		Boolean isCheckoutDisplayed =driver.findElement(By.xpath("//a[@title='Checkout']")).isDisplayed();
		Assert.assertTrue(isCheckoutDisplayed, "CheckOut button is not displayed on homepoage");
	}

	@Then("^my account option should display at homepage$")
	public void myaccount_option_should_display_at_homepage() throws Throwable {
		Boolean isMyAccountDisplayed =driver.findElement(By.xpath("//a[@title='My Account']")).isDisplayed();
		Assert.assertTrue(isMyAccountDisplayed, "MyAccount button is not displayed on homepoage");
	}

	@Then("^menu bar should display at homepage$")
	public void menu_bar_should_display_at_homepage() throws Throwable {
		Boolean isMenubarDisplayed =driver.findElement(By.xpath("//nav[@id='main-nav']")).isDisplayed();
		Assert.assertTrue(isMenubarDisplayed, "Menu Bar is not displayed on homepoage");
		
	}

	@When("^Menu bar options should display$")
	public void menu_bar_options_should_display() throws Throwable {
		Boolean isHomeButtonDisplayed =driver.findElement(By.xpath("//a[contains(text(),'Home')]")).isDisplayed();
		Assert.assertTrue(isHomeButtonDisplayed, "Home Button is not dispalyed on Menu barMenu");
		
		Boolean isProductCategoryButtonDisplayed =driver.findElement(By.xpath("//a[contains(text(),'Product Category')]")).isDisplayed();
		Assert.assertTrue(isProductCategoryButtonDisplayed, "Product Category Button is not dispalyed on Menu barMenu");
		
		Boolean isNoTitleButtonDisplayed =driver.findElement(By.xpath("//li[@id='menu-item-16']/a[contains(text(),'#0 (no title)')]")).isDisplayed();
		Assert.assertTrue(isNoTitleButtonDisplayed, "Product Category Button is not dispalyed on Menu barMenu");
		
		Boolean isAllProductButtonDisplayed =driver.findElement(By.xpath("//a[contains(text(),'All Product')]")).isDisplayed();
		Assert.assertTrue(isAllProductButtonDisplayed, "Product Category Button is not dispalyed on Menu barMenu");
		
	}

	@Then("^Search bar should display$")
	public void search_bar_should_display() throws Throwable {
		
		Boolean isSearchBarDisplayed =driver.findElement(By.xpath("//input[@class='search']")).isDisplayed();
		Assert.assertTrue(isSearchBarDisplayed, "Search Bar is not dispalyed on Menu barMenu");
		
	}

	
}
