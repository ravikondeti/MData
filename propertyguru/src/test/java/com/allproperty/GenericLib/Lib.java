package com.allproperty.GenericLib;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.Reporter;

import ch.qos.logback.core.util.FileUtil;
import io.appium.java_client.AppiumDriver;

// TODO: Auto-generated Javadoc
/**
 * The Class GenericLib.
 *
 * @author Ravi kondeti
 */
public class Lib {
	
	/**
	 * This Method is used to get the Xpath from property file.
	 *
	 * @param propertyFilePath the property file path
	 * @param propertyName the property name
	 * @return the property
	 */
	public static String getProperty(String propertyFilePath, String propertyName){
		log.info("Getting property for :"+propertyName);
		log.info("Property file path :"+propertyFilePath);
		File imageFile = new File(propertyFilePath);
		log.info("Absoluete property File Path :" +imageFile.getAbsolutePath());
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(propertyFilePath);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			log.error(e.getMessage());
		}
		Properties prop = new Properties();
		try {
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			log.error(e.getMessage());
			
		}
		String propXpath = prop.getProperty(propertyName);
		log.info("Got property value as :" +propXpath);
		return propXpath;
	}
	
	/**
	 * Gets the screen shot and save in desired location.
	 *
	 * @param driver the driver
	 * @param destFilePath the dest file path
	 * @param fileName the file name
	 * @param fileExtension the file extension
	 * @return the screen shot
	 */
	public String getScreenShot(WebDriver driver, String destFilePath,String fileName, String fileExtension){
		String destPathName = null;
		
		log.info("Getting Method name: Method name is " +fileName );
		
		Date date = new Date();
		log.info("Date object is created");
		
		Format formatter = new SimpleDateFormat("YYYYMMddhhmmssSSS");
		log.info("Simple Date Format is set as"+formatter.format(date));
		
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		log.info("Screen shot captured.");
		
		destPathName = destFilePath+fileName+"_"+formatter.format(date)+"."+fileExtension;
		File destFile = new File(destPathName);
		log.info("Screen shot saved as "+destPathName);
		
		try {
			FileUtils.copyFile(srcFile, destFile);
			log.info("Screen shot copied to "+destPathName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			log.error(e.getMessage());
		}
		return destPathName;
		
	}
	
	/**
	 * Gets the single screen shot.
	 *
	 * @param fireWebDriver the fire web driver
	 * @param destFilePath the dest file path
	 * @return the screen shot
	 */
	public String getScreenShot(WebDriver driver){
		String srcPath ="";
		
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		log.info("Screen shot captured.");
		
		srcPath =srcFile.getPath();
		log.info("Captured screen location : "+srcFile);
		
		return srcPath;
		
	}
	
	public static File getScreenShotAsFile(WebDriver driver){
		String destPathName = null;
		Date date = new Date();
		log.info("Date object is created");
		
		Format formatter = new SimpleDateFormat("YYYYMMddhhmmssSSS");
		log.info("Simple Date Format is set as"+formatter.format(date));
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		log.info("Screen shot captured.");
		destPathName = "Images/"+"SampleScreen"+"_"+formatter.format(date)+"."+"png";
		File destFile = new File(destPathName);
		log.info("Screen shot saved as "+destPathName);
		
		try {
			FileUtils.copyFile(srcFile, destFile);
			log.info("Screen shot copied to "+destPathName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			log.error(e.getMessage());
		}
		
		return srcFile;
		
	}
	
	/**
	 * Gets the n number of screen shots.
	 *
	 * @param fireWebDriver the fire web driver
	 * @param destFilePath the dest file path
	 * @param numOfScreenShots the num of screen shots
	 * @return the screen shot
	 */
	public static String[] getScreenShot(WebDriver driver, int numOfScreenShots) {
		String[] srcPath = new String[numOfScreenShots];
		
		for (int i = 0; i <numOfScreenShots; i++) {
			File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			log.info("Screen shot captured.");
			
			srcPath[i] = srcFile.getPath();
			log.info("Screen shot location : " + srcFile);

		}
		return srcPath;

	}
	
	public static void doubleClick(WebDriver driver, WebElement element) throws InterruptedException {

		//WebElement row = driver.findElements(By.tagName("tableCell")).get(4);

		HashMap<String, Object> tapObject = new HashMap<String, Object>();

		tapObject.put("x", 0.5); // in pixels from left

		tapObject.put("y", 0.5); // in pixels from top

		tapObject.put("tapCount", 2.0);  // double tap

		tapObject.put("element", ((RemoteWebElement) element).getId()); // the id of the element we want to tap

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("mobile: tap", tapObject);

		}
	
    
	
}
