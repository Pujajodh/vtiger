package com.autodesk.crm.genericlib;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.autodesk.crm.objectrepo.HomePage;
import com.autodesk.crm.objectrepo.loginpage;

public class BaseClass {
	public WebDriver driver;
	public FileLib fie;
	public WebDriverCommonLib web;
	public HomePage h1;

	@BeforeSuite
	public void congfiDatabase() {
		System.out.println("conect to db");

	}

	@BeforeClass
	public void congfiBC() throws IOException {
		fie = new FileLib();
		String browser = fie.getPropertyKeyValue("browser");
		System.out.println("====lunch the broswer");
		System.out.println(browser);

		if (browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "./exe/geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./exe/chromedriver.exe");
			driver = new ChromeDriver();
		}

	}

	@BeforeMethod
	public void confiBM() throws IOException {
		System.out.println("login t");
		web = new WebDriverCommonLib();
		String url = fie.getPropertyKeyValue("url");
		String userN = fie.getPropertyKeyValue("un");
		String pass = fie.getPropertyKeyValue("pass");
		System.out.println("login to app");
		loginpage lp = new loginpage(driver);
		web.waitForElement(driver);
		driver.get(url);
		lp.loginToApp(userN, pass);
		h1 = new HomePage(driver);

	}

	@AfterMethod
	public void confiAM() {

		System.out.println("logout Application");
		h1.logOut();
	}

	@AfterClass
	public void confiAC() {
		System.out.println("close broswer");
		driver.close();

	}

	@AfterSuite
	public void confiAS() {
		System.out.println("connection is closed");
	}
}
