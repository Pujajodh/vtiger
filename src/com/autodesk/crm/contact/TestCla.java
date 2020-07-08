package com.autodesk.crm.contact;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Result.class)
public class TestCla {
	WebDriver driver;

	@Test
	public void test1() {

		System.setProperty("webdriver.gecko.driver", "./exe/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://www.google.com");

	}

	@Test
	public void test2() {
		System.setProperty("webdriver.gecko.driver", "./exe/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://www.faceook.com");

	}

}
