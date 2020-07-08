package com.autodesk.crm.objectrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginpage 
{
    @FindBy(xpath="//input[@name='user_name']")
    private WebElement un;
    
    @FindBy(name="user_password")
    private WebElement pss;
    	
    @FindBy(id="submitButton")
    private WebElement login;

	public WebElement getUn() {
		return un;
	}

	public WebElement getPss() {
		return pss;
	}

	public WebElement getLogin() {
		return login;
	}
    
   public void loginToApp(String un1, String pass)
   {
	   un.sendKeys(un1);
	   pss.sendKeys(pass);
	   login.click();
	   
	   
   }
    
   
   public loginpage(WebDriver driver) {
	   PageFactory.initElements(driver, this);
   }
}
