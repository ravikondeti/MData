package com.allproperty.GenericLib;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.sikuli.script.Finder;
import org.sikuli.script.Location;
import org.sikuli.script.Pattern;
import org.sikuli.script.Region;

import io.appium.java_client.AppiumDriver;

public class ImageRecog {

    //private AppiumDriver<WebElement> driver;
    private static int TIMEOUT = 90;
    private static int count = 0;
    
    //@Test(description="Launch app -> push login in button -> quit app")
    public static void tapOnImage(WebDriver driver, String imagePath) throws InterruptedException {

        Finder loginFinder;
        Pattern buttonImg = new Pattern(imagePath);
        log.info("Pattern object created.");
        buttonImg.similar((float) 0.3);       //1.0 exact match, 0.3 70% less picky about exact matches

        //wait until login screen -> push login button if found
        for (int i=0; i<TIMEOUT; i++) {    //90 second timeout
            if (i%10 == 0) {       // check for button every 10 secs
                try {
                	log.info("Checking for screen. Retry count is: "+i);
                    File currentScreen = Lib.getScreenShotAsFile(driver);    //returns a file object
                    log.info("screen shot captured");
                    BufferedImage bimg = ImageIO.read(currentScreen);
                    loginFinder = new Finder(
                            currentScreen.getAbsolutePath(),
                            new Region(0, 0, bimg.getWidth(), bimg.getHeight()));
                    loginFinder.find(buttonImg);
                    if (loginFinder.hasNext()) {
                        log.info("Givem Image Successfully found on screen.");
                        Location targetLocation = (loginFinder.next()).getTarget();
                        ((AppiumDriver<WebElement>)driver).tap(1, targetLocation.x, targetLocation.y, 1);
                        log.info("Clicked on given Image.");
                        break;
                    } else {
                    	log.info("Given Image not found on screen.");
                        continue;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                continue;
            }
            Thread.sleep(1*1000); //sleep 1 sec
        }
    }

}
