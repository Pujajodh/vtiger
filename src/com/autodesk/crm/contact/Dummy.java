package com.autodesk.crm.contact;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class Dummy {
	@Test
	public void test() throws EncryptedDocumentException, IOException {
		String file = "../Autodesk_CRM_Framwork/data/testData.xlsx";
		ArrayList<String> data = new ArrayList<>();
		ArrayList<String> data1 = new ArrayList<>();
		String data123[] = null;
		Workbook b = WorkbookFactory.create(new FileInputStream(file));
		Sheet s = b.getSheet("Sheet2");
		int rowcount = s.getLastRowNum();
		System.out.println(rowcount);
		for (int i = 0; i <= rowcount; i++) {
			Row r = s.getRow(i);
			short cel = r.getLastCellNum();
			for (int j = 0; j < cel; j++) {
				Cell c = r.getCell(j);
				String hj = c.toString();
				data.add(hj);

			}

		}
		System.out.println(data);

		System.out.println("=======================");

		Sheet s1 = b.getSheet("Sheet4");
		int rowcount1 = s1.getLastRowNum();
		System.out.println(rowcount1);

		for (int i1 = 0; i1 <= rowcount; i1++) {
			Row r1 = s1.getRow(i1);
			short cell = r1.getLastCellNum();
			for (int j1 = 0; j1 < cell; j1++) {
				Cell c1 = r1.getCell(j1);
				String hj1 = c1.toString();
				data1.add(hj1);

			}

		}
		System.out.println(data1);
		System.out.println("=============");

		if (rowcount == rowcount1) {
			System.out.println("row is same");

			if (data.equals(data1)) {
				System.out.println("data is also same");
			} else {
				System.out.println("data is not same");
			}

		}
	}

}
