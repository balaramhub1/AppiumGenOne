package com.TestOne;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class DesiredCap {
	
	/*
	 * -Script to demonstrate the working of DesiredCapbabilities and MobileCapabilityType
	 */
	
	MobileDriver drv;
	DesiredCapabilities cap;
	
  @BeforeClass
  public void beforeClass() throws MalformedURLException {
	
	  cap=new DesiredCapabilities();
	  cap.setCapability(MobileCapabilityType.DEVICE_NAME, "1b25dd527d03");
	  cap.setCapability(MobileCapabilityType.APP, "D:\\Appium_TR\\APKfiles\\vehicleRegistrationInd.apk");
	  cap.setCapability(MobileCapabilityType.APP_PACKAGE, "in.navaratna9.www.vehicle_registration_details_Ind");
	  //cap.setCapability(MobileCapabilityType.NO_RESET, "");
	  cap.setCapability(MobileCapabilityType.APP_ACTIVITY, "Splashscreen");
	  
	  drv=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);
	  
	  //NO RESET is a new entry - it prevents reset of app state before script execution.
	  // if APP path is provided, appium will re-install the app every time at start of the script.
	  
	  
	  
  }
	
  @Test
  public void f() {
  }
  

  @AfterClass
  public void afterClass() {
  }

}
