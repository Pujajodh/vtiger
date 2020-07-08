package com.autodesk.crm.objectrepo;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewLead {
	 WebDriver driver;
	

	@FindBy(name="lastname")
	private WebElement lastn;
	
	@FindBy(name="company")
	private WebElement comp;
	
	@FindBy(name="button")
	private WebElement saveBu;
	
	public WebElement getSaveBu() {
		return saveBu;
	}

	
	public WebElement getLastn() {
		return lastn;
	}

	public WebElement getComp() {
		return comp;
	}
	
	public CreateNewLead(WebDriver driver)
	
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void creatnewL(String lastName, String copName) throws EncryptedDocumentException, IOException
	
	{
		
		lastn.sendKeys(lastName);
		comp.sendKeys(copName);
		saveBu.click();
		
	}

}
