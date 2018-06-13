package appMisc;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;

public class OrientOne {
	
	AndroidDriver drv;
	DesiredCapabilities cap;
  
  @BeforeTest
  public void beforeTest() throws MalformedURLException {
	  cap= new DesiredCapabilities();
	  cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Lenovo A6000");
	  cap.setCapability(MobileCapabilityType.PLATFORM_NAME,MobilePlatform.ANDROID);
	  cap.setCapability(MobileCapabilityType.APP_PACKAGE, "com.finessCalculator");
	  cap.setCapability(MobileCapabilityType.APP_ACTIVITY, "FitnessCalculatorActivity");
	  cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "200");
	  
	  drv=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);
	  drv.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
  }
  
  @Test
  public void f() throws InterruptedException {
	  String ori1=drv.getOrientation().toString();
	  System.out.println("Current Device Orientation is : "+ori1);
	  
	  Thread.sleep(3000);
	  
	  drv.rotate(ScreenOrientation.LANDSCAPE);
	  
	  String ori2=drv.getOrientation().toString();
	  System.out.println("Current Device Orientation is : "+ori2);
	  
	  Thread.sleep(3000);
  }

  @AfterTest
  public void afterTest() {
	  drv.quit();
	  
  }

}
