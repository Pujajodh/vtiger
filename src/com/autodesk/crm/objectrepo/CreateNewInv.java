package com.autodesk.crm.objectrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.autodesk.crm.genericlib.WebDriverCommonLib;

public class CreateNewInv

{
	WebDriver driver;

	@FindBy(name="subject")
	private WebElement sub; 
	
	@FindBy(xpath="(//img[@src=\"themes/softed/images/select.gif\"])[3]")
	private WebElement org; 
	
	@FindBy(id="1")
	private WebElement addorg; 
	
	@FindBy(xpath="//textarea[@name='bill_street']")
	private WebElement billadd; 
	
	@FindBy(name="ship_street")
	private WebElement shipadd; 
	
	@FindBy(name="qty1")
	private WebElement qty; 
	
	@FindBy(id="searchIcon1")
	private WebElement item;
	
	@FindBy(xpath=" //a[@id='popup_product_25']")
	private WebElement pro;
	
	@FindBy(xpath=("//title[contains(text(),'Administrator - Invoice - vtiger CRM 5 - Commercia')]"))
	private WebElement title;
	
	public WebElement getTitle() {
		return title;
	}

	public WebElement getPro() {
		return pro;
	}

	public WebElement getSub() {
		return sub;
	}

	public WebElement getOrg() {
		return org;
	}

	public WebElement getAddorg() {
		return addorg;
	}

	public WebElement getBilladd() {
		return billadd;
	}

	public WebElement getShipadd() {
		return shipadd;
	}

	public WebElement getQty() {
		return qty;
	}

	public WebElement getItem() {
		return item;
	} 
	
	public CreateNewInv(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void newinv(String sub1, String billa, String shadd,String qty1 )
	
	{
		String tit = title.getText();
	    sub.sendKeys(sub1);
	    org.click();
	    WebDriverCommonLib web=new WebDriverCommonLib();
	    web.switchToNewTab(driver, tit);
	    addorg.click();
	    
	    billadd.sendKeys(billa);
	    shipadd.sendKeys(shadd);
	    item.click();
	    web.switchToNewTab(driver, tit);
	    pro.click();
	    qty.sendKeys(qty1);
		
	}
}