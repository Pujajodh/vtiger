package com.autodesk.crm.leads;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.autodesk.crm.genericlib.FileLib;
import com.autodesk.crm.genericlib.WebDriverCommonLib;
import com.autodesk.crm.objectrepo.ContactPage;

public class Contact {

	@Test
	public void organizationTest() throws IOException, AWTException {

		FileLib fie = new FileLib();
		String url = fie.getPropertyKeyValue("url");
		String key = fie.getPropertyKeyValue("key");
		String value = fie.getPropertyKeyValue("value");
		
		Assert.assertEquals(key, "webdriver.gecko.driver");
		Assert.assertEquals(value, "../Autodesk_CRM_Framwork/exe/geckodriver.exe");
		System.out.println("key "+ key+"   value   "+value);
		
		System.setProperty(key, value);
		WebDriver driver = new FirefoxDriver();

		driver.get("http://192.168.1.2:8888");
		String un = fie.getPropertyKeyValue("un");
		String pass = fie.getPropertyKeyValue("pass");
		driver.findElement(By.name("user_name")).sendKeys(un);
		
		driver.findElement(By.name("user_password")).sendKeys("manager");
		driver.findElement(By.id("submitButton")).click();
		WebDriverCommonLib web = new WebDriverCommonLib();
		web.waitForElement(driver);
		WebElement ele = driver.findElement(By.xpath("(.//a[text()='Contacts'])"));
		ele.click();

		WebElement ele1 = driver.findElement(By.xpath("//img[@ title=\"Create Contact...\"]"));
		ele1.click();

		String fn = fie.getExcelData("sheet", 1, 2);
		String ln = fie.getExcelData("sheet", 1, 3);

		// String assph= fie.getExcelInt("sheet", 1, 4);
		String assph = fie.getExcelData("sheet", 1, 4);

		WebElement ele2 = driver.findElement(By.name("salutationtype"));
		web.selectStr(ele2, "Ms.");
		driver.findElement(By.name("firstname")).sendKeys(fn);
		driver.findElement(By.name("lastname")).sendKeys(ln);
		driver.findElement(By.id("assistantphone")).sendKeys(assph);

		// String ph= fie.getExcelInt("sheet", 1, 5);
		String ph = fie.getExcelData("sheet", 1, 5);

		driver.findElement(By.name("phone")).sendKeys(ph);

		String mob = fie.getExcelData("sheet", 1, 6);
		driver.findElement(By.name("mobile")).sendKeys(mob);

		String homph = fie.getExcelData("sheet", 1, 7);
		driver.findElement(By.id("homephone")).sendKeys(homph);

		String otph = fie.getExcelData("sheet", 1, 8);
		driver.findElement(By.name("otherphone")).sendKeys(otph);

		String em = fie.getExcelData("sheet", 1, 9);
		driver.findElement(By.name("email")).sendKeys(em);

		String seem = fie.getExcelData("sheet", 1, 10);
		driver.findElement(By.id("secondaryemail")).sendKeys(seem);

		driver.findElement(By.name("button")).click();
		web.waitForElement(driver);

		WebElement e = driver.findElement(By.xpath("//img[@ title=\"Create Contact...\"]"));
		e.click();
		web.waitForElement(driver);
		String fn1 = fie.getExcelData("sheet", 2, 2);
		String ln1 = fie.getExcelData("sheet", 2, 3);
		ContactPage c = new ContactPage(driver);
		c.info(fn1, ln1);
		web.waitForElement(driver);
		driver.findElement(By.name("button")).click();

		driver.findElement(By.xpath("(.//a[text()='Contacts'])")).click();
		int pre=web.checkb(driver);

		web.check(driver);
		
		driver.findElement(By.xpath("(//input[@ value=\"Delete\"])[2]")).click();
		web.alert(driver);
		
		int after=web.checkb(driver);
		if(pre==after)
		{
			System.out.println("info is not deleted");
		}
		else
		{
			System.out.println("deleted");
		}
	}

}