package com.autodesk.crm.objectrepo;

import java.io.IOException;

import org.apache.commons.io.serialization.ClassNameMatcher;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.autodesk.crm.genericlib.FileLib;
import com.autodesk.crm.genericlib.WebDriverCommonLib;

public class HomePage {

	WebDriver driver;

	@FindBy(linkText="Leads")
	private WebElement lead;

	@FindBy(linkText = "Organizations")
	private WebElement org;

	@FindBy(linkText = "Contacts")
	private WebElement cont;
	
	@FindBy(xpath="//img[@src=\"themes/softed/images/user.PNG\"]")
	private WebElement adm;

	@FindBy(linkText="Sign Out")
	private WebElement logout;

	@FindBy(xpath="(//a[@href=\"javascript:;\"])[1]")
	private WebElement more;
	
	@FindBy(xpath="(//a[@class='drop_downnew'])[21]")
	private WebElement invoice;
	
	
	public HomePage(WebDriver driver) {
		
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
	}
	
	

	public WebElement getLead() {
		return lead;
	}

	public WebElement getOrg() {
		return org;
	}

	public WebElement getCont() {
		return cont;
	}

	public WebElement getAdm() {
		return adm;
	}

	public WebElement getLogout() {
		return logout;
	}

	public WebElement getMore() {
		return more;
	}

	public WebElement getInvoice() {
		return invoice;
	}

	public void invoicepag() 
	{
		WebDriverCommonLib web= new WebDriverCommonLib();
		
		web.moveToEle(more, driver);
		
		web.moveToEle(invoice, driver);
		invoice.click();
		
	}
	  
	public void logOut()
	{
		WebDriverCommonLib web=new WebDriverCommonLib();
		web.moveToEle(adm, driver);
		logout.click();
	}
}
