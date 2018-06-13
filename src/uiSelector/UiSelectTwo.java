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

public class UiSelectTwo {
	
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
	   * Select an ui element in the next screen using text attribute using UiSelector Class of android
	   * Select an ui element in a scroll view or scrolling list view.
	   * Script is for java client above 2.2(as scrollTo() and scrollToExact() are depricated
	   */
	  String uiSel="new UiSelector().text(\"Madhya Gujarat Vij\")";
	  //String command = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(" + uiSel + ".instance(0));";
	  String command2 ="new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView("+uiSel+")";
	  
	  drv.findElement(By.name("Electricity")).click();
	  
	  drv.findElement(By.id("net.one97.paytm:id/select_opertor_layout")).click();
	  
	  //drv.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().className(\"android.widget.ListView\")).scrollIntoView(\"new UiSelector().text(\"Madhya Gujarat Vij\")\")").click();
	  
	  /*drv.findElement(By.xpath("//android.widget.ListView/"
	  		+ "android.widget.RelativeLayout/"
	  		+ "android.widget.TextView[@text='Madhya Gujarat Vij']"));*/
	  
	  drv.findElementByAndroidUIAutomator(command2).click();
	  //"command" also works
	  Thread.sleep(5000);
	  
	  
  }

  @AfterTest
  public void afterTest() {
	  drv.quit();
  }

}
