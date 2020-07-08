package com.autodesk.crm.contact;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.autodesk.crm.genericlib.BaseClass;
import com.autodesk.crm.genericlib.FileLib;
import com.autodesk.crm.genericlib.WebDriverCommonLib;
import com.autodesk.crm.objectrepo.CreateNewLead;
import com.autodesk.crm.objectrepo.HomePage;
import com.autodesk.crm.objectrepo.Invoicepage;
import com.autodesk.crm.objectrepo.MoreInfo;
import com.autodesk.crm.objectrepo.PlusLead;
import com.autodesk.crm.objectrepo.loginpage;

public class Dummay extends BaseClass {
	@Test
	public void test() throws EncryptedDocumentException, IOException {

		// navigate to invoice
		web.waitForElement(driver);
		h1.invoicepag();
		// click to new invoice
		Invoicepage ip = new Invoicepage(driver);
		ip.getCreatein().click();
		// create new invoice
		PlusLead plus = new PlusLead(driver);
		web.waitForElement(driver);
		plus.getCreatnelead().click();

		driver.findElement(By.name("subject")).sendKeys("puja");
		driver.findElement(By.xpath("(//img[@src=\"themes/softed/images/select.gif\"])[3]")).click();

		/*Set<String> set = driver.getWindowHandles();
		System.out.println(set);
		
		
		for (String hand : driver.getWindowHandles()) {
			System.out.println(hand);
			driver.switchTo().window(hand);
			
		}
		driver.findElement(By.xpath("//a[@id='1']")).click();
		
		*/
		String tit = driver.findElement(By.xpath("//title[contains(text(),'Administrator - Invoice - vtiger CRM 5 - Commercia')]")).getText();
		
		Set<String> set = driver.getWindowHandles();
		System.out.println(set);
		Iterator<String> it = set.iterator();
		
		while (it.hasNext()) {
			driver.switchTo().window(it.next());
			String actPagTit = driver.getTitle();
			if (actPagTit.equals(tit)) {
				 break;
				 }
			}
		
			
			
			driver.findElement(By.xpath("//a[@id='1']")).click();
			
			
			
			driver.findElement(By.xpath("//textarea[@name='bill_street']")).sendKeys("sfsgg");
			 
		
	}
}
