package uiSelector;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class ScrollOne {
  
	AndroidDriver drv;
	DesiredCapabilities cap;
	
	@BeforeTest
	public void setUp() throws MalformedURLException, InterruptedException{
		
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
  public void f() {
	  // Not Working for element beyond the page.
	  // Works for element in the same page.
	  drv.findElement(By.name("Electricity")).click();
	  drv.findElement(By.id("net.one97.paytm:id/select_opertor_layout")).click();
	  
	  TouchAction act=new TouchAction(drv);
	  AndroidElement el1=(AndroidElement) drv.findElement(By.id("net.one97.paytm:id/operator_list"));
	  AndroidElement el2=(AndroidElement) drv.findElementByAndroidUIAutomator("new UiSelector().text(\"Madhya Gujarat Vij\")");
	  act.press(el1);
	  act.moveTo(el2).release().perform();
	  	  
  }
  

  @AfterTest
  public void afterTest() {
	  drv.quit();
  }

}
