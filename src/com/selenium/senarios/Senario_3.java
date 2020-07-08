package com.selenium.senarios;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

//1.	Open a browser of your choice say Mozilla Firefox
//2.	Navigate to http://jqueryui.com/droppable/ webpage.
//1.	Consider “Drag me to my target” as a source and “Drop here” as a target.
//2.	Write a code to perform drag and drop operation from source to target.
//3.	After drag and drop verify the operation is successfully by checking the color property of CSS and also verify text change. (Use assert statement to verify that color and text are as expected.)




import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Senario_3 {
	
	@Test
	public void Drop_Down() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "../Autodesk_CRM_Framwork/exe/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://jqueryui.com/droppable/");
		Actions act=new Actions(driver);
		 //WebElement target = driver.findElement(By.xpath("//p[contains(text(),'Drop here')]"));
		Timeouts sbv = driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement source = driver.findElement(By.xpath("//p[contains(text(),'Drag me to my target')]"));
		 WebElement target = driver.findElement(By.xpath("//p[contains(text(),'Drop here')]"));
		act.dragAndDrop(source, target);
		String msg = driver.findElement(By.xpath("//p[contains(text(),'Dropped!')]")).getText();
	    System.out.println(msg);
		
		
		
		
		
		
	
	
	}
}
