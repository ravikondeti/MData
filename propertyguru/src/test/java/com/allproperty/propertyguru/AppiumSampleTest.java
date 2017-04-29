package com.allproperty.propertyguru;

import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.xml.DOMConfigurator;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.internal.MultiAction;
import org.openqa.selenium.interactions.touch.DoubleTapAction;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Assert;
import org.testng.IInvokedMethod;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.yaml.snakeyaml.reader.UnicodeReader;

import com.allproperty.GenericLib.GetFileProperty;
import com.allproperty.GenericLib.Lib;
import com.allproperty.GenericLib.log;
import com.google.common.util.concurrent.UncaughtExceptionHandlers;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;


// TODO: Auto-generated Javadoc
/**
 * The Class AppiumSampleTest.
 */
public class AppiumSampleTest {

AppiumDriver<WebElement> driver =null;
Lib lib = new Lib();
	/**
	 * Initial setup.
	 *
	 * @throws MalformedURLException
	 *             the malformed URL exception
	 */
	@BeforeClass
	public void initialSetup() throws MalformedURLException {

		DesiredCapabilities cap = new DesiredCapabilities();
		// cap.setCapability(CapabilityType.BROWSER_NAME, "Android");
		cap.setCapability("noReset", "true");
		cap.setCapability("fullReset", "false");
		cap.setCapability("autoLaunch", false);
		cap.setCapability("newCommandTimeout", 60);
		cap.setCapability("platformVersion", "23");
		cap.setCapability("deviceName", "Nexus S");
		cap.setCapability("platformName", "Android");
		cap.setCapability("autoAcceptAlerts", true);
		cap.setCapability("autoDismissAlerts", true);
		cap.setCapability("app", "C:\\Users\\Mr\\Downloads\\com.allproperty.android.consumer.sg.apk");
		cap.setCapability("automationName", "Appium");
		cap.setCapability("appPackage", "com.allproperty.android.consumer.sg");
		cap.setCapability("appActivity", "com.allpropertymedia.android.apps.ui.DashboardActivity");
		// driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"),
		// cap);
		driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
	
	}


	@BeforeMethod
	public void startApp() {
		// String methodName=result.getMethod().getMethodName();
		// String invokedMethod=method.getTestMethod().getMethodName();
		log.startTestCase("TestMethod");
		driver.launchApp();
	}
@Test
public void sampleTest() throws InterruptedException{
	//String title =driver.getTitle();
	Thread.sleep(10000);
	Reporter.log("App Title is : ");
	
}
	

	@SuppressWarnings("unchecked")
	@AfterMethod
	public void closeApplicationAfterTest(ITestResult result) {
		if (result.isSuccess()) {

			 driver.closeApp();
		} else {
			String methodName = result.getMethod().getMethodName();
			lib.getScreenShot(driver, GetFileProperty.screenShotPath, methodName, "png");
			driver.closeApp();
			log.endTestCase(methodName);
		}
	}

	/**
	 * Close app.
	 */
	@AfterClass
	public void closeApp() {
		driver.quit();

	}
}
