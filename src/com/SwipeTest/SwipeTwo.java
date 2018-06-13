package com.SwipeTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class SwipeTwo {
	/*
	 * - Script to demonstrate swipe action.
	 * - scrollTo() and scrollToExat() are depricated hence driver.swipe(...) to be used
	 * - Swipe can be done in 2 cases
	 * - 2 - Swipe to an element in the next screen(not visible in the 1st screen )
	 * - Syntax:  	swipe(int startx, int starty, int endx, int endy, int duration)
	 */
	
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
	public void swipeTestOne() {
		
		// Swipe to element present in the same screen
		
		 drv.findElement(By.name("Electricity")).click();
		 drv.findElement(By.id("net.one97.paytm:id/select_opertor_layout")).click();
		
		 Dimension dim=drv.manage().window().getSize();
		 System.out.println("Dimension of Screen is " +dim);
		 
		 
		 		 
		//AndroidElement oplist =(AndroidElement) drv.findElements(By.xpath("//net.one97.paytm:id/operator_list/android.widget.RelativeLayout/android.widget.TextView"));
		List<WebElement> opList=new ArrayList<WebElement>();
		opList=drv.findElementsByAndroidUIAutomator("new UiSelector().resourceId(\"net.one97.paytm:id/row_container\").resourceId(\"net.one97.paytm:id/product_name\")");
		System.out.println(opList.size());
		
		for(WebElement el: opList){
			System.out.println(el.getText());
		}
		 
		 
	}
	
		
	@AfterTest
	public void tearDown(){
		drv.quit();
	}
	
	
}
