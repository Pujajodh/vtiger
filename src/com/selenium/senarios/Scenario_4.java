package com.selenium.senarios;

//1.	Open any Browser of your choice (Mozilla firefox, Chrome, Internet Explorer or Safari). Write the code in such way that based on argument passed respective browser is selected.
//2.	Browse to Ebay website.
//3.	Write a method which do following:
//4.	On the homepage, there is a search box, type some product (say Apple Watches).
//5.	From categories dropdown, select the category of your product (say Watches).
//6.	Click Search button.




import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Scenario_4 {
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "../Autodesk_CRM_Framwork/exe/geckodriver.exe");
		WebDriver driver= new FirefoxDriver();
		int count=0;
		//ebay
		driver.get("https://www.ebay.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//div[@id='gh-ac-box2']/input[@class='gh-tb ui-autocomplete-input']")).sendKeys("Apple Watches");
		WebElement webelememnt=driver.findElement(By.xpath("//select[@class='gh-sb ']"));
		Select select= new Select((webelememnt));
		select.selectByVisibleText("Cell Phones & Accessories");
		driver.findElement(By.xpath("//input[@class='btn btn-prim gh-spr']")).click();

		// Get the 10th product from page
		Thread.sleep(3000);
		String XthProduct= driver.findElement(By.xpath("//li[@data-view='mi:1686|iid:10']/descendant::h3")).getText();
		System.out.println("10th Product is="+XthProduct);

		//Get the list of all Product from webpage
		 List<WebElement> products = driver.findElements(By.xpath("//ul[@class='srp-results srp-list clearfix']/child::li/descendant::h3"));
		for (WebElement pro : products)
		{
		System.out.println(pro.getText());
		count++;
		}
		System.out.println(count);
		}

}
