package com.autodesk.crm.objectrepo;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.autodesk.crm.genericlib.FileLib;
import com.autodesk.crm.genericlib.WebDriverCommonLib;

public class MoreInfo {
	WebDriver driver;

	@FindBy(xpath = "//body[@class='small']/table/tbody/tr/td/table/tbody/tr/td[@class='showPanelBg']/div[@class='small']/table/tbody/tr[1]/td[1]/table[1]/tbody[1]/tr[1]/td[4]/a[1] ")
	private WebElement more;

	@FindBy(xpath = " //img[@id='show_Leads_Documents'] ")
	private WebElement doc;

	@FindBy(xpath = "//input[@title=\"Add Document\"]")
	private WebElement add;

	@FindBy(className = "detailedViewTextBox")
	private WebElement title;

	@FindBy(xpath = "//tr[13]//td[1]//div[1]//input[1]")
	private WebElement save;

	@FindBy(xpath = "(//img[@title=\"Display\"])[1]")
	private WebElement acti;
	
	@FindBy(id="1")
	private WebElement docname;


	public WebElement getDocname() {
		return docname;
	}

	/*public void moreinfo() {
		WebDriverCommonLib web = new WebDriverCommonLib();

		web.moveToEle(more, driver);
		web.moveToEle(doc, driver);

	}
*/
	public void clickdoc(String name) throws EncryptedDocumentException, IOException {
		more.click();
		doc.click();
		add.click();
		//FileLib lab = new FileLib();
		//String name = lab.getExcelData("Sheet1", 1, 2);
		title.sendKeys(name);
		save.click();
		
		acti.click();

	}

	public WebElement getMore() {
		return more;
	}

	public WebElement getDoc() {
		return doc;
	}

	public MoreInfo(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

}
