package com.autodesk.crm.contact;


import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class RemoteBro {
	@Test
	public void test() throws MalformedURLException
	{
	DesiredCapabilities cap= DesiredCapabilities.chrome();
	URL url=new URL("http://192.168.43.44:4444/wd/hub");//pooja ip add
	RemoteWebDriver web=new RemoteWebDriver(url,cap);
	web.get("http://localhost:8888");
		
	}

}
