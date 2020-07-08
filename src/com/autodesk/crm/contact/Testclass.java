package com.autodesk.crm.contact;

import org.testng.annotations.Test;

public class Testclass {
	@Test(groups="smoke")
	public void creatauser()
	{
		System.out.println("test1 is running");
		
	}
	@Test(groups="smoke")
	public void deleteuser()
	{
		System.out.println("test2 is running");
	}
	@Test(groups="smoke")
	public void adduser()
	{
		System.out.println("test3 is running");
	}
	@Test(groups="regreesion")
	public void createproduct()
	{
		System.out.println("test4 is running");
	}

	@Test(groups="regreesion")
	public void deleteproudct()
	{
		System.out.println("test4 is running");
	}
}
