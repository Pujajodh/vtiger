package com.autodesk.crm.leads;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.autodesk.crm.genericlib.BaseClass;
import com.autodesk.crm.genericlib.FileLib;
import com.autodesk.crm.genericlib.WebDriverCommonLib;
import com.autodesk.crm.objectrepo.CreateNewLead;
import com.autodesk.crm.objectrepo.HomePage;
import com.autodesk.crm.objectrepo.Leadinfopage;
import com.autodesk.crm.objectrepo.MoreInfo;
import com.autodesk.crm.objectrepo.PlusLead;
import com.autodesk.crm.objectrepo.loginpage;

public class LeadsPro extends BaseClass {

	WebDriver driver;

	@Test
	public void lead() throws IOException, InterruptedException {

		/* test data */
 
		String leadC = fie.getExcelData("Sheet1", 1, 1) + web.randomno();
		String leadN = fie.getExcelData("Sheet1", 1, 0) + web.randomno();
		System.out.println(leadN);
		System.out.println(leadC);

		/* step1: navigate to lead */
		
		h1.getLead().click();
		

		/*step2: navigate create new lead*/
		PlusLead pl=new PlusLead(driver);
		
		pl.click();
		 
		/* step3: navigate to create lead and fill info and save */

		CreateNewLead cnl = new CreateNewLead(driver);
		
		
		cnl.creatnewL(leadN, leadC);

		/* step2: verify */

		Leadinfopage lip = new Leadinfopage(driver);
		web.waitAndClickElement(driver, lip.getLeadinfo());
		String actleadtext = lip.getLeadinfo().getText();
		System.out.println(actleadtext);

		/*
		 * String homepagename =
		 * driver.findElement(By.xpath("//a[@class=\"hdrLink\"]")).getText();
		 * 
		 * Assert.assertEquals(homepagename, "Home");
		 * System.out.println("home page displayed");
		 * 
		 * HomePage home = new HomePage(driver); home.selectLead();
		 * 
		 * MoreInfo info = new MoreInfo(driver); web.waitForElement(driver);
		 * 
		 * // info.moreinfo();
		 * 
		 * info.clickdoc();
		 * 
		 * home.logOut(); driver.close();
		 */
	}
}
