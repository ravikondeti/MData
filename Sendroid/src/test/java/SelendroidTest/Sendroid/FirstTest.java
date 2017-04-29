package SelendroidTest.Sendroid;

import org.testng.annotations.Test;

import io.selendroid.client.SelendroidDriver;
import io.selendroid.common.SelendroidCapabilities;
import io.selendroid.standalone.SelendroidConfiguration;
import io.selendroid.standalone.SelendroidLauncher;
import io.selendroid.standalone.server.model.SelendroidStandaloneDriver;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.apache.http.client.methods.Configurable;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class FirstTest {
	
	private static SelendroidLauncher selendroidserver =null;
	private static WebDriver driver =null;
	
	 @BeforeClass
	  public void beforeClass() {
		 if (selendroidserver != null){
			 selendroidserver.stopSelendroid();
		 }
		 SelendroidConfiguration config = new SelendroidConfiguration();
		 config.addSupportedApp("src/main/resources/selendroid-test-app-0.17.0.apk");
		 selendroidserver = new SelendroidLauncher(config);
		 selendroidserver.launchSelendroid();
		 
		 SelendroidCapabilities caps = new SelendroidCapabilities("io.selendroid.testapp:0.17.0");
		 try {
			driver =new SelendroidDriver(caps);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
	
	 
  @Test
  public void f() {
	  System.out.print("Starting Test");
  }

 
 

  @AfterClass
  public void afterClass() {
	  
	  if (driver != null){
		  driver.quit();
	  }
	  
	  if (selendroidserver != null){
		  selendroidserver.stopSelendroid();
	  }
  }

}


