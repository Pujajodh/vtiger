package com.autodesk.crm.genericlib;

import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverCommonLib {
	/**
	 * wait for element status based on visibility
	 */
       WebDriver driver;
	public void waitForElementStat(WebDriver driver, WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}
	
	
	public void waitAndClickElement(WebDriver driver, WebElement ele) throws InterruptedException
	{
		int count=0;
		while(count<=20)
		{
			try
			{
				ele.click();
				break;
				
			}
			catch(Throwable t)
			{
				Thread.sleep(1000);
				count++;
			}
		}
		
	}
   public int randomno()
   {
	   Random ram=new Random();
	 
	int data=ram.nextInt(1000);
	return data;
   }
	/**
	 * wait for pagetitle based on avilibility
	 */
	public void waitForPageTitle(WebDriver driver, String title) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.titleContains(title));

	}

	/**
	 * wait for element to load
	 */
	public void waitForElement(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	/**
	 * used to select the content of the drop down based on index
	 * 
	 */
	public void selectStr(WebElement ele, String txt) {
		Select s = new Select(ele);
		s.selectByVisibleText(txt);
	}

	/**
	 * used to select the content of the drop down based on index
	 *
	 */
	public void selectInt(WebElement ele, int val) {
		Select s = new Select(ele);
		s.selectByIndex(val);
	}

	public void check(WebDriver driver) {
		List<WebElement> ch = driver.findElements(By.xpath("//input[@ type=\"checkbox\"]"));
		for(int i=1; i<=ch.size()-1; i++)
		{  
			
			
			ch.get(i).click();
			i++;
		}
	}
		
		public int checkb(WebDriver driver) {
			List<WebElement> ch = driver.findElements(By.xpath("//input[@ type=\"checkbox\"]"));
			int size =ch.size();
			return size;
	}

	/**
	 * used to take mouse cursor on the element
	 */

	public void moveToEle(WebElement ele, WebDriver driver) {
		Actions a = new Actions(driver);
		a.moveToElement(ele).perform();
	}

	public void moveByOffset(int x, int y, WebDriver driver) {

		Actions a = new Actions(driver);
		a.moveByOffset(x, y).perform();
	}

	/**
	 * used to swtich to any window in pagetitle
	 */
	public void switchToNewTab(WebDriver driver, String title) {

		String hand1=driver.getWindowHandle();
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			driver.switchTo().window(it.next());
			String actPagTit = driver.getTitle();
			if (actPagTit.equals(title)) {
				break;
			}
		}
	}

	/**
	 * to click on ok
	 */
	public void alert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	/**
	 * to click on cancel
	 */
	public void diss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * for verification of dropdown is multi selectable or not
	 * 
	 */
	public void mutiselect(WebElement ele)
	{
		Select drop=new Select(ele);
		if(drop.isMultiple())
		{
			System.out.println("allows multiple selection");
		}
		else
		{
			System.out.println("dose not allow multipe section");
		}
	}
}
