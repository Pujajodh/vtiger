package com.autodesk.crm.objectrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage 
{
	@FindBy(name="firstname")
	private WebElement fname;
	
	@FindBy(name="lastname")
	private WebElement lname;
	
	@FindBy(name="crmbutton small delete")
	private  WebElement delet;

	public WebElement getFname() {
		return fname;
	}

	public WebElement getLname() {
		return lname;
	}
	
	
	public void info(String fn, String ln) {
		fname.sendKeys(fn);
		lname.sendKeys(ln);
		
	}
	
	public ContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	/*@FindBy(name="firstname")
	private WebElement fname;
	
	@FindBy(name="firstname")
	private WebElement fname;
	
	@FindBy(name="firstname")
	private WebElement fname;
	*/
	
	
}
