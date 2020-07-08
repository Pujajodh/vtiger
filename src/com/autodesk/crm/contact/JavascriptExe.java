package com.autodesk.crm.contact;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;



public class JavascriptExe  {
	@Test
	public void test() throws InterruptedException
	{
		System.setProperty("webdriver.gecko.driver", "../Autodesk_CRM_Framwork/exe/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://www.fb.com");
		JavascriptExecutor js=(JavascriptExecutor)driver;
	//	js.executeScript("alert('alert is presnt')", 0);
		
		js.executeScript("document.getElementById('email').value='sadmni@gmail.com'", 0);
		
		
		js.executeScript("window.scrollBy(0,1000)", 0);
		Thread.sleep(1000);
	}

}
