package com.selenium.senarios;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Senarios {

	
	@Test
	public void drop_validate_01() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "../Autodesk_CRM_Framwork/exe/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.facebook.com/");

		WebElement rv = driver.findElement(By.xpath("//select[@id='day']"));
		Select s = new Select(rv);
		List<WebElement> vl = s.getOptions();
		Set set = new HashSet<>();
		for (int i = 0; i < vl.size(); i++) {
			String bn = vl.get(i).getText();
			set.add(bn);

		}
		// System.out.println(set);

		Assert.assertEquals(vl.size(), set.size());
		System.out.println("pass");
		driver.close();
	}

	@Test
	public void drop_validate_02() {
		System.setProperty("webdriver.gecko.driver", "../Autodesk_CRM_Framwork/exe/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.facebook.com/");

		WebElement rv = driver.findElement(By.xpath("//select[@id='month']"));
		Select s = new Select(rv);
		List<WebElement> vl = s.getOptions();
		List xc=new ArrayList();
		for (int i = 1; i < vl.size(); i++) {
			String bn = vl.get(i).getText();
			xc.add(bn);

		}System.out.println(xc);
		List temp = xc;
		Collections.sort(temp);
		System.out.println(temp);
		Assert.assertEquals(temp,vl);
		driver.close();
	}
	
	@Test
	public void drop_validate_03() {
		System.setProperty("webdriver.gecko.driver", "../Autodesk_CRM_Framwork/exe/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.facebook.com/");

		WebElement rv = driver.findElement(By.xpath("//select[@id='month']"));
		Select s = new Select(rv);
		List<WebElement> vl = s.getOptions();
		List<String> li=new ArrayList<>();
		li.add("Jan");
		li.add("Feb");
		li.add("Mar");
		li.add("Apr");
		li.add("May");
		li.add("Jun");
		li.add("Jul");
		li.add("Aug");
		li.add("Sept");
		li.add("Oct");
		li.add("Nov");
		li.add("Dec");
		
		List list=new ArrayList();
		for (int i = 1; i < vl.size(); i++) {
			String bn = vl.get(i).getText();
			//System.out.println(bn);
			list.add(bn);

		}
		
		Assert.assertEquals(li, list);
		System.out.println("passed");
		driver.close();
	}

}
