package com.testAutomationSuite;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OrangehrmDemoTest {
	@Test
	public void testOrangeHrm() {
		//Webdriver location
		System.setProperty("webdriver.gecko.driver", ".\\drivers\\geckodriver.exe");
		//launching Firefox
		WebDriver driver = new FirefoxDriver();
		//We have to add wait time for a website components to load, up to 15 Seconds wait time
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.get("https://orangehrm-demo-6x.orangehrmlive.com");
		
		//Shutdown the driver
		driver.close();
	}		
}
