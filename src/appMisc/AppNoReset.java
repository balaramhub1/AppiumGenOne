package appMisc;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

/*
 * java-client 2.2
 */

public class AppNoReset {
	
	MobileDriver drv;
	DesiredCapabilities cap;
  
  @BeforeTest
  public void beforeTest() throws MalformedURLException {
	  
	  File appDir=new File("E:\\Video Tutorial\\APPIUM\\appium tool\\Appium Tutorial\\APK_Files_For_Testing\\");
	  File appName=new File(appDir,"vehicleRegistrationInd.apk");
	  
	  cap=new DesiredCapabilities();
	  cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Redmi");
	  cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
	  cap.setCapability(MobileCapabilityType.APP, appName.getAbsolutePath());
	  //cap.setCapability(MobileCapabilityType.NO_RESET, "noReset");
	  
	  
	  //Below 2 desiredCapabilities are not applicable in java-client 4.0
	  cap.setCapability(MobileCapabilityType.APP_PACKAGE, "in.navaratna9.www.vehicle_registration_details_Ind");
	  cap.setCapability(MobileCapabilityType.APP_ACTIVITY, "Splashscreen");
	  
	  drv=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);
	  
  }
  
  
  @Test
  public void f() {
	  
  }

  @AfterTest
  public void afterTest() {
	  drv.quit();
  }

}
