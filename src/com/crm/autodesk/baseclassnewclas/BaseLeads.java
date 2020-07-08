package com.crm.autodesk.baseclassnewclas;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.autodesk.crm.genericlib.BaseClass;
import com.autodesk.crm.objectrepo.CreateNewLead;
import com.autodesk.crm.objectrepo.Leadinfopage;
import com.autodesk.crm.objectrepo.MoreInfo;
import com.autodesk.crm.objectrepo.PlusLead;

public class BaseLeads extends BaseClass {
	@Test
	public void Lead() throws EncryptedDocumentException, IOException, InterruptedException {
		/* test data */

		String leadC = fie.getExcelData("Sheet1", 1, 1) + web.randomno();
		String leadN = fie.getExcelData("Sheet1", 1, 0) + web.randomno();
		String docN = fie.getExcelData("Sheet1", 1, 3) + web.randomno();
		System.out.println(leadN);
		System.out.println(leadC);
		/* step1: navigate to lead */
		h1.getLead().click();
		/* step2: navigate create new lead */
		PlusLead p1 = new PlusLead(driver);
		{
			p1.click();
		}
		/* step3: navigate to create lead and fill info and save */
		CreateNewLead cnl = new CreateNewLead(driver);
		cnl.creatnewL(leadN, leadC);
		/* step2: verify */
		Leadinfopage lip = new Leadinfopage(driver);
		web.waitForElement(driver);
		String actul = lip.getLeadinfo().getText();
		System.out.println(actul);
		Assert.assertTrue(actul.contains(leadN));
		String lname = lip.getLastname().getText();
		System.out.println(lname);
		Assert.assertEquals(lname, leadN);
		/* step2: navigate to more information */
		MoreInfo mi = new MoreInfo(driver);
		web.waitForElement(driver);
		mi.clickdoc(docN);
		/* verify */
		System.out.println(docN);

		String docname = mi.getDocname().getText();

		System.out.println(docname);
		Assert.assertEquals(docname, docN);

	}

}
