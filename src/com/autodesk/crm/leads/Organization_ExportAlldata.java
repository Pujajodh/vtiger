package com.autodesk.crm.leads;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.autodesk.crm.genericlib.FileLib;
import com.autodesk.crm.genericlib.WebDriverCommonLib;

public class Organization_ExportAlldata 
{
	@Test
	public void organizationTest() throws IOException, AWTException {
	
		
	FileLib fie=new FileLib();
	String url=fie.getPropertyKeyValue("url");
	String key=fie.getPropertyKeyValue("key");
	String value=fie.getPropertyKeyValue("value");
	System.setProperty(key, value);
	WebDriver driver=new FirefoxDriver();
	
	driver.get("http://192.168.1.2:8888");
	String un=fie.getPropertyKeyValue("un");
	String pass=fie.getPropertyKeyValue("pass");
	driver.findElement(By.name("user_name")).sendKeys(un);
	driver.findElement(By.name("user_password")).sendKeys("manager");
	driver.findElement(By.id("submitButton")).click();
	WebDriverCommonLib web=new WebDriverCommonLib();
	web.waitForElement(driver);
	WebElement ele=driver.findElement(By.xpath("(.//a[text()='Organizations'])[1]"));
	ele.click();
	
	//driver.findElement(By.xpath("//img[@ title=\"Create Organization...\"]")).click();
	
	
	/*
	driver.findElement(By.name("accountname")).sendKeys(');
	driver.findElement(By.name("website")).sendKeys(un);
	driver.findElement(By.name("button")).click();
	driver.findElement(By.name("user_name")).sendKeys(un);
	*/
	String data=fie.getExcelData("Sheet2", 2, 1);
	System.out.println(data);
	
	driver.findElement(By.name("selected_id")).click();
	
	driver.findElement(By.xpath("//img[@ title=\"Export Organizations\"]")).click();
	driver.findElement(By.name("search_type")).click();
	driver.findElement(By.name("export_data")).click();
	driver.findElement(By.name("Export")).click();
	
	Robot rw = new Robot();
	rw.keyPress(KeyEvent.VK_UP);
	rw.keyPress(KeyEvent.VK_ENTER);
	
	
	}
}
