package com.autodesk.crm.genericlib;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileLib {

	String profile = "../Autodesk_CRM_Framwork/data/commonData.properties";
	String filepath = "../Autodesk_CRM_Framwork/data/testData.xlsx";
	ArrayList<String> data = new ArrayList<>();

	/**
	 * used to read data form excel
	 * 
	 * @param
	 * @throws IOException
	 * @throws EncryptedDocumentException
	 * 
	 */

	public String getExcelData(String sheetName, int rowName, int cellname)
			throws EncryptedDocumentException, IOException

	{
		Workbook b = WorkbookFactory.create(new FileInputStream(filepath));
		Sheet s = b.getSheet(sheetName);
		Row r = s.getRow(rowName);
		Cell c = r.getCell(cellname);
		String data = c.getStringCellValue();
		
		
		return data;
		
	}
	
	
	public String getExcelInt(String sheetName, int rowName, int cellname)
			throws EncryptedDocumentException, IOException

	{
		Workbook b = WorkbookFactory.create(new FileInputStream(filepath));
		Sheet s = b.getSheet(sheetName);
		Row r = s.getRow(rowName);
		Cell c = r.getCell(cellname);
		int data = (int) c.getNumericCellValue();
		String data1 = String.valueOf(data);
		
		return data1;
		
	}

	public void setExcelData(String sheetName, int rowName, int cellNam, String data)
			throws EncryptedDocumentException, IOException

	{

		FileInputStream fis = new FileInputStream("filepath");
		Workbook book = WorkbookFactory.create(fis);

		Sheet s = book.getSheet(sheetName);
		Row r = s.getRow(rowName);
		Cell c = r.createCell(cellNam);
		c.setCellValue(data);
		FileOutputStream out = new FileOutputStream("filepath");
		book.write(out);
		book.close();

	}

	public int getRowCount(String sheetN) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("filepath");
		Workbook book = WorkbookFactory.create(fis);

		Sheet s = book.getSheet("Sheet1");
		int row = s.getLastRowNum();
		return row;
	}

	public String getPropertyKeyValue(String key) throws IOException {
		FileInputStream fis = new FileInputStream(profile);
		Properties pro = new Properties();
		pro.load(fis);

		return pro.getProperty(key);
	}
	
	public ArrayList<String> compareexceldata(String file, String sheetname) throws EncryptedDocumentException, FileNotFoundException, IOException
	{
		
		Workbook b = WorkbookFactory.create(new FileInputStream(file));
		Sheet s = b.getSheet(sheetname);
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
		return data;
	}

	
	public String[][] compareexceldata2(String file, String sheetname) throws EncryptedDocumentException, FileNotFoundException, IOException
	{	
		String arr[][] = null;
	
	Workbook b = WorkbookFactory.create(new FileInputStream(file));
	Sheet s = b.getSheet(sheetname);
	int rowcount = s.getLastRowNum();
	System.out.println(rowcount);
	for (int i = 0; i <= rowcount; i++) {
		Row r = s.getRow(i);
		short cel = r.getLastCellNum();
		for (int j = 0; j < cel; j++) {
			Cell c = r.getCell(j);
			String hj = c.toString();
	arr[i][j]=hj;
		}
	}
	
	return arr;
		
		
	}
}
