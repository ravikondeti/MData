package AppiumTest.Appium;

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

import com.google.common.util.concurrent.UncaughtExceptionHandlers;

import genericlib.Lib;
import genericlib.GetFileProperty;
import genericlib.ImageRecog;
import genericlib.OCR;
import genericlib.Action;
import genericlib.log;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

// TODO: Auto-generated Javadoc
/**
 * The Class AppiumSampleTest.
 */
public class AppiumSampleTest {

	/** The driver. */
	// RemoteWebDriver driver = null;
	WebDriver driver = null;
	// EventFiringWebDriver fireWebDriver = null;
	// AndroidDriver<WebElement> driver =null;

	/** The gen lib. */
	Lib genLib = new Lib();

	/** The en button xpath. */
	String enButtonXpath = "";

	/** The method name. */
	String methodName = "";

	/** The end activity discard. */
	String endActivityDiscard = "";

	String screenShotFilePath = "";
	String[] screenshotfilepaths = {};
	String ocrTextOut = "";
	String appTitle = "";
	String endActivityAcceptXpath = "";
	String displayTextView = "";
	String visibleTextView = "";
	String displayPopUp = "";
	String exceptionButton = "";
	String exceptiontextfield = "";
	String encodingTextView = "";
	String topLevelElementTest = "";
	String touchButton = "";
	String focusedLayout="";
	String focusedText ="";
	String userRegistrationButton = "";
	String welcomeToNewUser = "";
	String userNameInput = "";
	String emailInput = "";
	String passwordInput = "";
	String nameInput = "";
	String progLangSelect = "";
	String iAcceptAddsBox = "";
	String completeUserRegisterButton = "";

	String programmingLanguageTitle = "";
	String selectRuby = "";
	String selectPHP = "";
	String selectScala = "";
	String selectCSharp = "";

	String verifyUserTitle = "";
	String labelName = "";
	String NameData = "";
	String labelUserName = "";
	String userNamedata = "";
	String labelPassword = "";
	String passwordData = "";
	String labelEmail = "";
	String emailData = "";
	String labelProgLang = "";
	String progLangData = "";
	String labelIAccceptAdds = "";
	String iAcceptAddsData = "";
	String submitUserRegisteration = "";
	String crashMessage = "";
	String okButton = "";
	
	String linearLayout="";
	String lastGesture ="";
	String actionResult="";
	String scaleFactor="";
	String canvasButton="";

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
		cap.setCapability("newCommandTimeout", 6000);
		cap.setCapability("platformVersion", "23");
		cap.setCapability("deviceName", "Nexus S");
		cap.setCapability("platformName", "Android");
		cap.setCapability("autoAcceptAlerts", true);
		cap.setCapability("autoDismissAlerts", true);
		cap.setCapability("app", "C:\\Users\\Mr\\Downloads\\selendroid-test-app-0.17.0.apk");
		cap.setCapability("automationName", "Appium");
		cap.setCapability("appPackage", "io.selendroid.testapp");
		cap.setCapability("appActivity", "io.selendroid.testapp.HomeScreenActivity");
		// driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"),
		// cap);
		log.info("EventFiringWebDriver is created");
		driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		enButtonXpath = Lib.getProperty(GetFileProperty.homePagePropertyPath, "endButton");
		endActivityDiscard = Lib.getProperty(GetFileProperty.endActivityPropertyPath, "discardButton");
		appTitle = Lib.getProperty(GetFileProperty.homePagePropertyPath, "appTitle");
		endActivityAcceptXpath = Lib.getProperty(GetFileProperty.endActivityPropertyPath, "acceptButton");
		userRegistrationButton = Lib.getProperty(GetFileProperty.homePagePropertyPath, "userRegistrationButton");
		displayTextView = Lib.getProperty(GetFileProperty.homePagePropertyPath, "displayTextView");
		visibleTextView = Lib.getProperty(GetFileProperty.homePagePropertyPath, "visibleTextView");
		displayPopUp = Lib.getProperty(GetFileProperty.homePagePropertyPath, "displayPopUp");
		exceptionButton = Lib.getProperty(GetFileProperty.homePagePropertyPath, "exceptionButton");
		exceptiontextfield = Lib.getProperty(GetFileProperty.homePagePropertyPath, "exceptiontextfield");
		encodingTextView = Lib.getProperty(GetFileProperty.homePagePropertyPath, "encodingTextView");
		topLevelElementTest = Lib.getProperty(GetFileProperty.homePagePropertyPath, "topLevelElementTest");
		touchButton = Lib.getProperty(GetFileProperty.homePagePropertyPath, "touchButton");
		focusedLayout = Lib.getProperty(GetFileProperty.homePagePropertyPath, "focusedLayout");
		focusedText = Lib.getProperty(GetFileProperty.homePagePropertyPath, "focusedText");

		// User Registration page properties
		welcomeToNewUser = Lib.getProperty(GetFileProperty.registrationPagePropFilePath, "welcomeToNewUser");
		userNameInput = Lib.getProperty(GetFileProperty.registrationPagePropFilePath, "userNameInput");
		emailInput = Lib.getProperty(GetFileProperty.registrationPagePropFilePath, "emailInput");
		passwordInput = Lib.getProperty(GetFileProperty.registrationPagePropFilePath, "passwordInput");
		nameInput = Lib.getProperty(GetFileProperty.registrationPagePropFilePath, "nameInput");
		progLangSelect = Lib.getProperty(GetFileProperty.registrationPagePropFilePath, "progLangSelect");
		iAcceptAddsBox = Lib.getProperty(GetFileProperty.registrationPagePropFilePath, "iAcceptAddsBox");
		iAcceptAddsBox = Lib.getProperty(GetFileProperty.registrationPagePropFilePath, "iAcceptAddsBox");
		completeUserRegisterButton = Lib.getProperty(GetFileProperty.registrationPagePropFilePath,
				"registerUserButton");

		// Programming language option properties
		programmingLanguageTitle = Lib.getProperty(GetFileProperty.selectProgLanguage, "programmingLanguageTitle");
		selectRuby = Lib.getProperty(GetFileProperty.selectProgLanguage, "selectRuby");
		selectPHP = Lib.getProperty(GetFileProperty.selectProgLanguage, "selectPHP");
		selectScala = Lib.getProperty(GetFileProperty.selectProgLanguage, "selectScala");
		selectCSharp = Lib.getProperty(GetFileProperty.selectProgLanguage, "selectCSharp");

		// Verify user registration details
		verifyUserTitle = Lib.getProperty(GetFileProperty.verifyRegisterUserDeatils, "verifyUserTitle");
		labelName = Lib.getProperty(GetFileProperty.verifyRegisterUserDeatils, "labelName");
		NameData = Lib.getProperty(GetFileProperty.verifyRegisterUserDeatils, "NameData");
		labelUserName = Lib.getProperty(GetFileProperty.verifyRegisterUserDeatils, "labelUserName");
		userNamedata = Lib.getProperty(GetFileProperty.verifyRegisterUserDeatils, "userNamedata");
		labelPassword = Lib.getProperty(GetFileProperty.verifyRegisterUserDeatils, "labelPassword");
		passwordData = Lib.getProperty(GetFileProperty.verifyRegisterUserDeatils, "passwordData");
		labelEmail = Lib.getProperty(GetFileProperty.verifyRegisterUserDeatils, "labelEmail");
		emailData = Lib.getProperty(GetFileProperty.verifyRegisterUserDeatils, "emailData");
		labelProgLang = Lib.getProperty(GetFileProperty.verifyRegisterUserDeatils, "labelProgLang");
		progLangData = Lib.getProperty(GetFileProperty.verifyRegisterUserDeatils, "progLangData");
		labelIAccceptAdds = Lib.getProperty(GetFileProperty.verifyRegisterUserDeatils, "labelIAccceptAdds");
		iAcceptAddsData = Lib.getProperty(GetFileProperty.verifyRegisterUserDeatils, "iAcceptAddsData");
		submitUserRegisteration = Lib.getProperty(GetFileProperty.verifyRegisterUserDeatils, "submitUserRegisteration");

		crashMessage = Lib.getProperty(GetFileProperty.appcrashproperties, "crashMessage");
		okButton = Lib.getProperty(GetFileProperty.appcrashproperties, "okButton");
		
		 linearLayout=Lib.getProperty(GetFileProperty.lastGesture, "linearLayout");
		 lastGesture =Lib.getProperty(GetFileProperty.lastGesture, "lastGesture");
		 actionResult=Lib.getProperty(GetFileProperty.lastGesture, "actionResult");
		 scaleFactor=Lib.getProperty(GetFileProperty.lastGesture, "scaleFactor");
		 canvasButton=Lib.getProperty(GetFileProperty.lastGesture, "canvasButton");

	}

	@SuppressWarnings("unchecked")
	@BeforeMethod
	public void startApp() {
		// String methodName=result.getMethod().getMethodName();
		// String invokedMethod=method.getTestMethod().getMethodName();
		log.startTestCase("TestMethod");
		((AppiumDriver<WebElement>) driver).launchApp();
	}

	/**
	 * App test.
	 *
	 * @param method
	 *            the method
	 * @throws InterruptedException
	 *             the interrupted exception
	 */
	// @Test
	public void newUserRegistrationTest() throws InterruptedException {
		SessionId currSession = ((AppiumDriver<WebElement>) driver).getSessionId();
		log.info("Current sessionID: " + currSession);
		Action.waitForElement(driver, 10, userRegistrationButton);
		Action.click(driver, userRegistrationButton);
		Reporter.log("Clicked on User Registration Button");
		Action.waitForElement(driver, 10, welcomeToNewUser);
		Action.isDisplayed(driver, welcomeToNewUser);
		Reporter.log("Verified for New user Registration page.");
		Action.implicitWait(driver, 3);
		Reporter.log("Driver Waited for three seconds.");
		Action.sendKeys(driver, userNameInput, "Ravi");
		Reporter.log("Typed username.");
		Action.sendKeys(driver, emailInput, "test@gmail.com");
		Reporter.log("Typed email address.");
		Action.sendKeys(driver, passwordInput, "1234");
		Reporter.log("Typed Password.");
		Action.click(driver, nameInput);
		Reporter.log("Clicked on Name.");
		Thread.sleep(2000);
		Reporter.log("Driver waited for 2 seconds.");
		Action.clear(driver, nameInput);
		Reporter.log("Clear Text from Name TextView.");
		Action.sendKeys(driver, nameInput, "Ravi Kondeti");
		Reporter.log("Entered Name ");
		Action.implicitWait(driver, 2);
		Reporter.log("Driver waited for 2 seconds.");
		((AppiumDriver<WebElement>) driver).hideKeyboard();
		Reporter.log("Hidden Keyboard.");
		Action.click(driver, progLangSelect);
		Reporter.log("Clicked on programming Language select button.");

		boolean isDisplayed = Action.isDisplayed(driver, programmingLanguageTitle);
		if (isDisplayed) {
			Action.click(driver, selectPHP);
			boolean isSelected = Action.isSelected(driver, iAcceptAddsBox);
			if (isSelected) {
				log.info("I Accept adds check box already selected");
			} else {
				Action.click(driver, iAcceptAddsBox);
			}
			Action.click(driver, completeUserRegisterButton);
			Action.waitForElement(driver, 10, verifyUserTitle);
			String text = Action.getText(driver, verifyUserTitle);
			if (text.equals("Verify user")) {
				log.info("Successfully navigated to Verify user details page");
				Action.click(driver, submitUserRegisteration);
				Assert.assertTrue(Action.isDisplayed(driver, enButtonXpath),
						"User Regiustration Successfully complete");
			} else {
				log.info("Application not navigated to Verify user details page");
				Assert.assertEquals(text, "Verify user", "Application not navigated to Verify user details page");
			}

		} else {
			Assert.assertTrue(isDisplayed, "Programming Language Page is not displaying");
		}
	}

	 //@Test
	public void UserDetailVerificationTest() throws InterruptedException {
		SessionId currSession = ((AppiumDriver<WebElement>) driver).getSessionId();
		log.info("Current sessionID: " + currSession);
		Action.waitForElement(driver, 10, userRegistrationButton);
		Action.click(driver, userRegistrationButton);
		Reporter.log("Clicked on User Registration Button");
		Thread.sleep(2000);
		Action.waitForElement(driver, 10, welcomeToNewUser);
		Action.isDisplayed(driver, welcomeToNewUser);
		Reporter.log("Verified for New user Registration page.");
		Thread.sleep(2000);
		Reporter.log("Driver Waited for three seconds.");
		Action.sendKeys(driver, userNameInput, "Ravi");
		Reporter.log("Typed username.");
		Action.sendKeys(driver, emailInput, "test@gmail.com");
		Reporter.log("Typed email address.");
		Action.sendKeys(driver, passwordInput, "1234");
		Reporter.log("Typed Password.");
		Action.click(driver, nameInput);
		Reporter.log("Clicked on Name.");
		Thread.sleep(2000);
		Reporter.log("Driver waited for 2 seconds.");
		Action.clearText(driver, nameInput);
		Reporter.log("Clear Text from Name TextView.");
		Action.sendKeys(driver, nameInput, "Ravi Kondeti");
		Reporter.log("Entered Name ");
		Action.implicitWait(driver, 2);
		Reporter.log("Driver waited for 2 seconds.");
		((AppiumDriver<WebElement>) driver).hideKeyboard();
		Reporter.log("Hidden Keyboard.");
		Action.click(driver, progLangSelect);
		Reporter.log("Clicked on programming Language select button.");

		boolean isDisplayed = Action.isDisplayed(driver, programmingLanguageTitle);
		if (isDisplayed) {
			Action.click(driver, selectPHP);
			boolean isSelected = Action.isSelected(driver, iAcceptAddsBox);
			if (isSelected) {
				log.info("I Accept adds check box already selected");
			} else {
				Action.click(driver, iAcceptAddsBox);
			}
			Action.click(driver, completeUserRegisterButton);
			Action.waitForElement(driver, 10, verifyUserTitle);
			String text = Action.getText(driver, verifyUserTitle);
			if (text.equals("Verify user")) {
				log.info("Successfully navigated to Verify user details page");
				Assert.assertEquals(Action.getText(driver, NameData), "Ravi Kondeti");
				Assert.assertEquals(Action.getText(driver, userNamedata), "Ravi");
				Assert.assertEquals(Action.getText(driver, passwordData), "1234");
				Assert.assertEquals(Action.getText(driver, emailData), "test@gmail.com");
				Assert.assertEquals(Action.getText(driver, progLangData), "PHP");
				Assert.assertEquals(Action.getText(driver, iAcceptAddsData), "true");
				Action.click(driver, submitUserRegisteration);
				Assert.assertTrue(Action.isDisplayed(driver, enButtonXpath), "User Verification Successfully complete");
			} else {
				log.info("Application not navigated to Verify user details page");
				Assert.assertEquals(text, "Verify user", "Application not navigated to Verify user details page");
			}

		} else {
			Assert.assertTrue(isDisplayed, "Programming Language Page is not displaying");
		}
	}

	//@Test
	public void displayTextViewTest() throws Exception {

		boolean result;
		SessionId currSession = ((AppiumDriver<WebElement>) driver).getSessionId();
		log.info("Current sessionID: " + currSession);
		try {
			Action.waitForElement(driver, 10, "visibleTextVie");
			result = Action.isDisplayed(driver, "visibleTextView");
			Assert.assertFalse(result, "Text view is displayed.");
		} catch (Exception ex) {
			log.error(ex.getMessage());

		} finally {
			Action.click(driver, displayTextView);
			result = Action.isDisplayed(driver, visibleTextView);
			Assert.assertTrue(result, "Text view is not displayed.");
			String visibleText = Action.getText(driver, visibleTextView);
			Reporter.log("Text view is displaying text as :" + visibleText);
		}
	}

	 //@Test
	public void displayPopUp() {
		SessionId currSession = ((AppiumDriver<WebElement>) driver).getSessionId();
		log.info("Current sessionID: " + currSession);
		try {
			Action.waitForElement(driver, 10, displayPopUp);
			Action.click(driver, displayPopUp);
			Reporter.log("Clicked on display popup button.");
			ImageRecog.tapOnImage(driver, "Images/DismissButton2.png");
			// ((AppiumDriver<WebElement>)driver).switchTo().alert().dismiss();
			Reporter.log("Accepted popup window.");

		} catch (Exception e) {
			log.error(e.getMessage());
			Reporter.log(e.getStackTrace().toString());
		}

	}

	//@Test
	public void unhandledExceptionTest() throws Exception {

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Thread.currentThread().setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
			public void uncaughtException(Thread t, Throwable e) {
				Action.click(driver, exceptionButton);
				log.info("Performed click operation on Unhandled Exception Button.");
				StringWriter sw = new StringWriter();
				e.printStackTrace(new PrintWriter(sw));
				String stacktrace = sw.toString();
				log.info(stacktrace);
			}
		});
		throw new RuntimeException("RunTime Exception Occured.");

	}

	//@Test
	public void unhandledTextExceptionTest() throws Exception {
		Thread.currentThread().setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
			public void uncaughtException(Thread t, Throwable e) {
				Action.sendKeys(driver, exceptiontextfield, "TEST");
				StringWriter sw = new StringWriter();
				e.printStackTrace(new PrintWriter(sw));
				String stacktrace = sw.toString();
				log.info(stacktrace);
			}
		});
		throw new RuntimeException("RunTime Exception Occured while sending keys to Text field.");
	}
	
	
	//@Test
	public void checkFocusTest(){
		Action.click(driver, topLevelElementTest);
		Reporter.log("Clicked on FocusButton.");
		boolean result =Action.isDisplayed(driver, focusedText);
		Assert.assertTrue(result,"Focused Text is not displayed.");
		String text = Action.getText(driver, focusedText);
		Reporter.log("Focused Text displayed with Text as "+text);
		String attributeState= Action.getAttribute(driver, focusedLayout, "focused");
		Assert.assertEquals(attributeState, "true");
		Reporter.log("Focus transfered to Layout.");
		
	}
	
	//@Test
	public void singleTap(){
		Action.click(driver, touchButton);
		boolean result =Action.isDisplayed(driver, lastGesture);
		Assert.assertTrue(result,"Application not navigated to Last Gesture page.");
		Action.click(driver, linearLayout);
		String tapConfirmText =Action.getText(driver, actionResult);
		Assert.assertEquals(tapConfirmText, "SINGLE TAP CONFIRMED", "Single click operation was not performed.");
	}
	
	//@Test
	public void doubleTap(){
		Action.click(driver, touchButton);
		boolean result =Action.isDisplayed(driver, lastGesture);
		Assert.assertTrue(result,"Application not navigated to Last Gesture page.");
		
//	WebElement element = driver.findElement(By.xpath(linearLayout));
//	try {
//		Lib.doubleClick(driver, element);
//	} catch (InterruptedException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
	//TouchActions actions = new TouchActions(driver);
	//actions.doubleTap(element);
	
		//((AppiumDriver<WebElement>)driver).tap(1, driver.findElement(By.xpath(linearLayout)), 1);
		//((AppiumDriver<WebElement>)driver).tap(1, driver.findElement(By.xpath(linearLayout)), 1);
		TouchAction touchAction = new TouchAction((AppiumDriver<WebElement>)driver);
		
		TouchAction action1 =touchAction.tap(driver.findElement(By.xpath(linearLayout)));
		TouchAction action2 =touchAction. tap(driver.findElement(By.xpath(linearLayout)));

		MultiTouchAction multiTouchAction = new MultiTouchAction((AppiumDriver<WebElement>)driver);
		MultiTouchAction action =multiTouchAction.add(action1).add(action2);
		
		((AppiumDriver<WebElement>)driver).performMultiTouchAction(action);
		String tapConfirmText =Action.getText(driver, actionResult);
		Assert.assertEquals(tapConfirmText, "ON DOUBLE TAP EVENT", "Double tap operation was not performed.");
	}
	
	@Test
	public void swipeTest() throws InterruptedException{
		((AppiumDriver<WebElement>)driver).pinch(driver.findElement(By.xpath(touchButton)));
		Thread.sleep(5000);
		Action.click(driver, touchButton);
		boolean result =Action.isDisplayed(driver, lastGesture);
		Assert.assertTrue(result,"Application not navigated to Last Gesture page.");
		((AppiumDriver<WebElement>)driver).swipe(200,100, 200, 400, 10000);
		
		
		
		String tapConfirmText =Action.getText(driver, actionResult);
		Assert.assertEquals(tapConfirmText, "SCROLL", "SCROLL operation was not performed.");
		
	}

	@SuppressWarnings("unchecked")
	@AfterMethod
	public void closeApplicationAfterTest(ITestResult result) {
		if (result.isSuccess()) {

			((AppiumDriver<WebElement>) driver).closeApp();
		} else {
			String methodName = result.getMethod().getMethodName();
			genLib.getScreenShot(driver, GetFileProperty.screenShotPath, methodName, "png");
			((AppiumDriver<WebElement>) driver).closeApp();
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
