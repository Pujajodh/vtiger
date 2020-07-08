package com.autodesk.crm.objectrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.autodesk.crm.genericlib.WebDriverCommonLib;

public class LastViewList {
	
	@FindBy(xpath="//img[@title=\"Last Viewed\"]")
	private WebElement lastview;
	
	@FindBy(xpath="//table[@class='hdrNameBg']//tr[1]//td[2]//a[1]")
	private WebElement ele;
	
	
	public LastViewList(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
	}

	public void click()
	{
		
		
		lastview.click();
		ele.click();
		
	}
	
}

