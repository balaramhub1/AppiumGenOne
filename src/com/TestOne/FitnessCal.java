package com.TestOne;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class FitnessCal {
	
	AndroidDriver drv;
	DesiredCapabilities cap;
  
  @BeforeTest
  public void beforeTest() throws MalformedURLException {
	  
	  cap=new DesiredCapabilities();
	  cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Redmi");
	  cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
	  cap.setCapability(MobileCapabilityType.APP_PACKAGE, "com.finessCalculator");
	  cap.setCapability(MobileCapabilityType.APP_ACTIVITY, "FitnessCalculatorActivity");
	  
	  drv=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);
  }
  
  @Test
  public void f() throws InterruptedException {
	  
	  drv.findElement(By.id("com.finessCalculator:id/map")).click();
	  Thread.sleep(3000);
	  drv.findElement(By.name("Lean Body Mass Index")).click();
	  Thread.sleep(3000);
	  
  }

  @AfterTest
  public void afterTest() {
	  drv.quit();
	  
  }

}
