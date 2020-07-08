package com.selenium.senarios;
//
//Scenario 2
//1.	Open any browser of your choice, say Mozilla Firefox
//2.	Navigate to https://www.gmail.com
//3.	Enter a valid Email Id or Phone Number
//4.	Click Next button
//5.	Enter Password and click “Sign in” button.
//6.	Verify that gmail is logged in successfully.
//7.	Click compose button and verify that a new mail window is opened.
//8.	Enter a Email Id
//9.	Enter some subject, say “Test Mail”
//10.	Enter some text in body
//11.	click send button.

import java.util.concurrent.TimeUnit;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Senario_2 {
	
	@Test
	public void composeMail() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "../Autodesk_CRM_Framwork/exe/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.gmail.com");
		driver.findElement(By.id("identifierId")).sendKeys("patilra098@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		Thread.sleep(4000);
		driver.findElement(By.name("password")).sendKeys("puja@1396");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait= new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.urlContains("https://mail.google.com/mail/u/0/#inbox"));
		String titile = driver.getTitle();
		System.out.println(titile);
		Assert.assertEquals("Inbox - patilra098@gmail.com - Gmail", titile);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='T-I J-J5-Ji T-I-KE L3']")).click();
		String comp = driver.findElement(By.xpath(" //div[@class='aYF']")).getText();
		Assert.assertEquals("New Message", comp);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id(":9p")).sendKeys("pujajodh@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.name("subjectbox")).sendKeys("automate");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class=\"Am Al editable LW-avf tS-tW\"]")).sendKeys("this is my 1st autmate msg");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class=\"T-I J-J5-Ji aoO v7 T-I-atl L3\"]")).click();
		
		
	}

}
