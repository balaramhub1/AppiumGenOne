package com.TestOne;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

/*
 * This script is to demonstrate various ways of finding Mobile elements (Android)
 * Android Elements can be identified by resourceId,class name,XPath,name(text),
 * content-desc(content description)
 * payTm app will be used to demonstrate the identification of elements 
 */

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class FindElements {
  
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
	  
	  /*drv.findElementByName("Electricity").click();
	  drv.findElementById("net.one97.paytm:id/group_field_textview").click();*/
	  
	  drv.findElement(By.name("Electricity")).click();
	  //drv.findElement(By.id("net.one97.paytm:id/group_field_textview")).click();
	  
	  //drv.findElement(By.id("net.one97.paytm:id/select_opertor_layout")).click();
	  drv.scrollTo("Telangana State Southern Power Distribution Company Limited (TSSPDCL)").click();
	  Thread.sleep(4000);
	  
	  //drv.findElement(By.id("net.one97.paytm:id/dropdown_layout")).click();
	  drv.findElement(By.xpath("//android.widget.ScrollView/"
	  		+ "android.widget.RelativeLayout/android.widget.LinearLayout/"
	  		+ "android.widget.LinearLayout[@index='2']/android.widget.LinearLayout[@index='0']")).click();
	  
	  
	  	  
  }
  
  @AfterTest
  public void afterTest() {
	  
	  drv.quit();
  }

}
