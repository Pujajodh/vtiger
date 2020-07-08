package com.autodesk.crm.contact;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.autodesk.crm.genericlib.WebDriverCommonLib;

public class Result implements ITestListener {
	static int passcount=0,failcount=0;
	WebDriver driver;
	WebDriverCommonLib web;
	
	

	@Override
	public void onFinish(ITestContext context) {
		Reporter.log("pass: "+ passcount,true);
		Reporter.log("fail: "+ failcount,true);
		
	}

	@Override
	public void onStart(ITestContext context) {
		
		String name=context.getName();
		Reporter.log(name+ "is startred",true);
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		
		
		String name=result.getName();
		Reporter.log("test "+name+ "is fail",true);
		failcount++;
		
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		int no= web.randomno();
		File des=new File("./screenshot"+no+"sc.png");
		try
		{
			FileUtils.copyFile(src, des);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestStart(ITestResult result) {
		
		String name=result.getName();
		Reporter.log("test "+name+ "is startred",true);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String name=result.getName();
		Reporter.log("test "+name+ "is pass",true);
		passcount++;
		
	}
	
	
	
	

}
