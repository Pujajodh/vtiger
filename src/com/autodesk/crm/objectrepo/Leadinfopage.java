package com.autodesk.crm.objectrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Leadinfopage {

	WebDriver driver;
	@FindBy(xpath="//span[@class=\"dvHeaderText\"]")
	private WebElement leadinfo;
	
	@FindBy(id="dtlview_Last Name")
	private WebElement lastname;
	
	@FindBy(id="dtlview_Company")
	private WebElement copname;

	public WebElement getLeadinfo() {
		return leadinfo;
	}

	public WebElement getLastname() {
		return lastname;
	}

	public WebElement getCopname() {
		return copname;
	}
	
	public Leadinfopage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
}
