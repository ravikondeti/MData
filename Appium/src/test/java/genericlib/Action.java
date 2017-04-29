package genericlib;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

// TODO: Auto-generated Javadoc
/**
 * The Class WebAction.
 */
public class Action {
	
	/**
	 * Click.
	 *
	 * @param driver the driver
	 * @param elementXpath the element xpath
	 */
	public static void click(WebDriver driver, String elementXpath){
		log.info("elementXpath provided to click as: " +elementXpath);
		driver.findElement(By.xpath(elementXpath)).click();
		log.info("Clicked on " +elementXpath);
	}
	
	/**
	 * Close.
	 *
	 * @param driver the driver
	 * @param elementXpath the element xpath
	 */
	public static void clear(WebDriver driver, String elementXpath){
		log.info("elementXpath provided to clear as: " +elementXpath);
		driver.findElement(By.xpath(elementXpath)).clear();
		log.info("Text Cleared at " +elementXpath);
	}
	
	public static void clearText(WebDriver driver, String elementXpath){
		log.info("elementXpath provided to clear as: " +elementXpath);
		driver.findElement(By.xpath(elementXpath)).sendKeys(Keys.CONTROL,"a");
		driver.findElement(By.xpath(elementXpath)).sendKeys(Keys.DELETE);
		log.info("Text Cleared at " +elementXpath);
	}
	
	public static void delete(WebDriver driver, String elementXpath){
		log.info("elementXpath provided to clear as: " +elementXpath);
		driver.findElement(By.xpath(elementXpath)).clear();
		log.info("Text Cleared at " +elementXpath);
	}
	
	public static String getAttribute(WebDriver driver, String elementXpath, String attibuteName){
		String attributeOut=driver.findElement(By.xpath(elementXpath)).getAttribute(attibuteName);
		return attributeOut;
		
	}
	
	
	
	/**
	 * Send keys.
	 *
	 * @param driver the driver
	 * @param elementXpath the element xpath
	 * @param text the text
	 */
	public static void sendKeys(WebDriver driver, String elementXpath,String text){
		log.info("elementXpath provided to sendKeys as: " +elementXpath + " and text provided as:" +text);
		driver.findElement(By.xpath(elementXpath)).sendKeys(text); //findElement(By.xpath(elementXpath)).sendKeys(text);
		log.info("Input keys at " +elementXpath);
	}
	
	public static String getText(WebDriver driver, String elementXpath){
		log.info("elementXpath provided to getText as : " +elementXpath);
		String text =driver.findElement(By.xpath(elementXpath)).getText();
		log.info("Getting Text from element: " +elementXpath + " and Got the Text as: " +text);
		return text;
	}
	
	/**
	 * Implicit wait.
	 *
	 * @param driver the driver
	 * @param waitTime the wait time
	 */
	public static void implicitWait(WebDriver driver, long waitTime){
		log.info("Waittime provided as : " +waitTime);
		driver.manage().timeouts().implicitlyWait(waitTime, TimeUnit.SECONDS);
		log.info("WebDriver implicitly waited : "+waitTime +" seconds");
	}
	
	/**
	 * Explicitly Wait for element.
	 *
	 * @param driver the driver
	 * @param waitTime the wait time
	 * @param elementXpath the element xpath
	 */
	public static void waitForElement(WebDriver driver, long waitTime, String elementXpath){
		log.info("elementXpath provided to waitForElement as: " +elementXpath + " and Waittime provided as : " +waitTime);
		WebDriverWait waitDriver = new WebDriverWait(driver, waitTime);
		waitDriver.until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementXpath)));
		log.info("WebDriver Explicitly waited for element : "+elementXpath+" until "+waitTime +" seconds");
			
	}
	
	/**
	 * Checks if web element is displayed.
	 *
	 * @param driver the driver
	 * @param elementXpath the element xpath
	 */
	public static boolean isDisplayed(WebDriver driver,String elementXpath ){
		log.info("elementXpath provided to isDisplayed as: " +elementXpath);
		boolean result= driver.findElement(By.xpath(elementXpath)).isDisplayed();
		log.info("Is WebElement displayed : " +result);
		return result;
	}
	
	/**
	 * Checks if web element is enabled.
	 *
	 * @param driver the driver
	 * @param elementXpath the element xpath
	 */
	public static boolean isEnabled(WebDriver driver,String elementXpath ){
		log.info("elementXpath provided to isEnabled as: " +elementXpath);
		boolean result = driver.findElement(By.xpath(elementXpath)).isEnabled();
		log.info("Is WebElement Enabled : " +result);
		return result;
	}
	
	/**
	 * Checks if web element is selected.
	 *
	 * @param driver the driver
	 * @param elementXpath the element xpath
	 */
	public static boolean isSelected(WebDriver driver,String elementXpath ){
		log.info("elementXpath provided to isSelected as: " +elementXpath);
		boolean result=driver.findElement(By.xpath(elementXpath)).isSelected();
		log.info("Is WebElement selected : " +result);
		return result;
	}

}
