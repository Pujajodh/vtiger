package com.crm.autodesk.baseclassnewclas;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.autodesk.crm.genericlib.BaseClass;
import com.autodesk.crm.objectrepo.CreateNewInv;
import com.autodesk.crm.objectrepo.Invoicepage;
import com.autodesk.crm.objectrepo.PlusLead;


public class BaseInvoice extends BaseClass{
	@Test
	public void invoice() throws IOException, EncryptedDocumentException, InterruptedException
	{
		
		//navigate to invoice
		web.waitForElement(driver);
		h1.invoicepag();
		//click to new invoice
		Invoicepage ip=new Invoicepage(driver);
		web.waitForElement(driver);
		web.waitForElement(driver);
		ip.getCreatein().click();
		//create new invoice
		PlusLead plus=new PlusLead(driver);
		web.waitForElement(driver);
		plus.getCreatnelead().click();
		
		String su = fie.getExcelData("Sheet3", 1, 0) + web.randomno();
		String ba = fie.getExcelData("Sheet3", 1, 1) + web.randomno();
		String shad = fie.getExcelData("Sheet3", 1, 2) + web.randomno();
		String qty = fie.getExcelInt("Sheet3", 1, 3);
		System.out.println(su+"  "+ba+"  "+shad+"  "+qty);
		
		
		//add data
		CreateNewInv inv=new CreateNewInv(driver);
		inv.newinv(su, ba, shad, qty);
		
	}

}
