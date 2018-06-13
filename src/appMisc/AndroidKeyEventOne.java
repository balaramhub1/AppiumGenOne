package appMisc;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.MobileCapabilityType;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class AndroidKeyEventOne {
	
	//Demonstrate AndroidKeyCodes for java client 2.2
  
	AndroidDriver drv;
	DesiredCapabilities cap;
	
	
  @BeforeTest
  public void beforeTest() throws MalformedURLException, InterruptedException {
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
	  
	  drv.findElement(By.id("net.one97.paytm:id/action_search")).click();
	  drv.findElement(By.id("net.one97.paytm:id/search_src_text")).sendKeys("abcd efgh");
	  
	  //drv.sendKeyEvent(AndroidKeyCode.BACKSPACE);
	  
	  //drv.sendKeyEvent(AndroidKeyCode.MENU);
	  
	  drv.sendKeyEvent(AndroidKeyCode.ENTER);
	  drv.findElement(By.id("android:id/button1")).click();
	  drv.hideKeyboard();
	  
	  Boolean appIn=drv.isAppInstalled("net.one97.paytm");
	  if(appIn){
		  System.out.println("Paytm app is installed");
	  }
	  
	  drv.closeApp();
	  
	  Thread.sleep(3000);
	  
	  drv.launchApp();
	  
	  Thread.sleep(5000);
	  
	  String orient=drv.getOrientation().toString();
	  
	  System.out.println("Orientation of the device is :"+orient);
	  
	  drv.rotate(ScreenOrientation.LANDSCAPE); // will not work if app doesn't support changing orientation.
	  
	  Thread.sleep(5000);
  }
  
  @AfterTest
  public void afterTest(){
	  
	  drv.quit();
	  
  }

}
