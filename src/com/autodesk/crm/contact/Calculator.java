package com.autodesk.crm.contact;

import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

public class Calculator {

	public static void main(String[] args) {
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability("deviceName", "Redmi Note 8pro");
		cap.setCapability("automationName", "appium");
		cap.setCapability("platformName", "andriod");
		cap.setCapability("platformVersion", "7.1.1");
		cap.setCapability("appPackage", "com.google.android.calculator");
		cap.setCapability("appActivity", "com.android.calculator2.Calculator");
		cap.setCapability("UDID", "4dlnr4pjpjzshq8t");
		
		//URL url= new URL("http://localhost:4723/wd/hub");
		//AndroidDriver driver= new AndroidDriver(url, cap);


	}

}
