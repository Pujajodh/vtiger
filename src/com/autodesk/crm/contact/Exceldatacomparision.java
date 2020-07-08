package com.autodesk.crm.contact;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.autodesk.crm.genericlib.FileLib;

public class Exceldatacomparision {
	
	@Test
	public void test() throws EncryptedDocumentException, FileNotFoundException, IOException
	{
		String path="../Autodesk_CRM_Framwork/data/testData.xlsx";
		String path2="../Autodesk_CRM_Framwork/data/testData2.xlsx";
		FileLib lib=new FileLib();
		 ArrayList<String> data = lib.compareexceldata(path, "Sheet4");
		 ArrayList<String> data2 = lib.compareexceldata(path2, "Sheet1");
		if(data.equals(data2))
		{
			System.out.println("data is same");
			
		}else {
			System.out.println("data is not same");
		}
	
	System.out.println("===============by using array===============");
	
	String[][] data3 = lib.compareexceldata2(path, "Sheet4");
	 String[][] data4= lib.compareexceldata2(path2, "Sheet1");
	if(data3.equals(data4))
	{
		System.out.println("data3 is same");
		
	}else {
		System.out.println("data3 is not same");
	}
}

}
