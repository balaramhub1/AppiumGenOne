package uiSelector;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class UiSelectOne {
	
	AndroidDriver drv;
	DesiredCapabilities cap;
  
  @BeforeTest
  public void beforeTest() throws InterruptedException, MalformedURLException {
	  cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Redmi");
		cap.setCapability(MobileCapabilityType.APP_PACKAGE, "net.one97.paytm");
		cap.setCapability(MobileCapabilityType.APP_ACTIVITY, "landingpage.activity.AJRMainActivity");
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 200);
		  
		  
		drv=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		Thread.sleep(3000);
	  
  }
  
  @Test
  public void f() throws InterruptedException {
	  
	  /*
	   * Select an ui element in the same screen using text attribute using UiSelector Class of android
	   */
	  
	  drv.findElement(By.name("Electricity")).click();
	  drv.findElement(By.id("net.one97.paytm:id/select_opertor_layout")).click();
	  
	  drv.findElementByAndroidUIAutomator("new UiSelector().text(\"BSES Yamuna - Delhi\")").click();
	  
	  Thread.sleep(5000);
	  
	  
  }

  @AfterTest
  public void afterTest() {
	  drv.quit();
  }

}
