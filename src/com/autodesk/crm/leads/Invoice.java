package com.autodesk.crm.leads;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.autodesk.crm.genericlib.FileLib;
import com.autodesk.crm.genericlib.WebDriverCommonLib;
import com.autodesk.crm.objectrepo.HomePage;
import com.autodesk.crm.objectrepo.loginpage;

public class Invoice
{	
	@Test
     public void invoicepage() throws IOException, InterruptedException
     {
	FileLib fie = new FileLib();
	String url = fie.getPropertyKeyValue("url");
	String key = fie.getPropertyKeyValue("key");
	String value = fie.getPropertyKeyValue("value");
	Assert.assertEquals(key, "webdriver.gecko.driver");
	Assert.assertEquals(value, "../Autodesk_CRM_Framwork/exe/geckodriver.exe");
	System.out.println("key "+ key+"value   "+value);
	System.setProperty(key, value);
	WebDriver driver = new FirefoxDriver();

	driver.get(url);
	
	String un = fie.getPropertyKeyValue("un");
	String pass = fie.getPropertyKeyValue("pass");
	
	Assert.assertEquals(un, "admin");
	
	System.out.println("un  "+   un);
	

	loginpage log=new loginpage(driver);
	log.loginToApp(un,pass);
	
	
	String homepagename = driver.findElement(By.xpath("//a[@class=\"hdrLink\"]")).getText();
	//String actual="Home"
	Assert.assertEquals(homepagename, "Home");
	System.out.println("home page displayed");
	WebDriverCommonLib web=new WebDriverCommonLib();
	web.waitForElement(driver);
	HomePage home= new HomePage(driver);
	home.invoicepag();
	
	home.logOut();
	driver.close();
	
}
}
