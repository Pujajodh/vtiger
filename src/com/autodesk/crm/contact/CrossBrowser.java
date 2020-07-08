package com.autodesk.crm.contact;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class CrossBrowser {
	
	WebDriver driver;
	
	@BeforeMethod
	@Parameters({"browser"})
	public void openbro(String bro)
	
	{
		if(bro.equals("firefox"))
		{
		System.setProperty("webdriver.gecko.driver", "./exe/geckodriver.exe");
		
		 driver= new FirefoxDriver();
		 
		
		}
		
		else if(bro.equals("chrome"))
		{
		System.setProperty("webdriver.chrome.driver", "./exe/chromedriver.exe");
		
		 driver= new ChromeDriver();
		 
		
		}
		
		
		
	}
	@Test
	public void test() {
		 driver.get("https://www.google.com");
		System.out.println("googel is open");
		
	}
	@AfterMethod
	public void close()
	{
		driver.close();
	}
}
