package com.selenium.senarios;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

//Scenario 1
//1.	Open a browser of your choice say Mozilla Firefox using Gecko Driver
//2.	Navigate to Gmail (https://www.gmail.com)
//3.	Login to your Gmail with correct credentials.
//4.	Verify that by default “Primary” section is selected.
//5.	If not click on the Primary tab.
//6.	Get the count of the total number of emails in the Primary tab.
//7.	Get the name of the sender and subject of Nth Email of your inbox.
//8.	Write a method to get the name of the sender and subject of email of your inbox.




public class Senario_1 {
	@Test
	public void gmail() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "../Autodesk_CRM_Framwork/exe/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.gmail.com");
		driver.findElement(By.id("identifierId")).sendKeys("patilra098@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("puja@1396");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait= new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.urlContains("https://mail.google.com/mail/u/0/#inbox"));
		
		
		WebElement pri = driver.findElement(By.xpath("//div[@id=':2l']"));
		//Assert.assertTrue(pri.isSelected());
		if(pri.isSelected())
		{
			System.out.println("Primary is selected");
		}else {
			System.out.println("not selecyed");
			//pri.click();
		}
		
		String test = driver.findElement(By.xpath("//div[@id=\":2j\"]/ancestor::div[@class=\"nH bkK nn\"]/descendant::div[@class=\"Cr aqJ\"]/descendant::span[@class=\"Dj\"]/chlid::span")).getText();
		System.out.println(test);
		//driver.close();
	}
}
