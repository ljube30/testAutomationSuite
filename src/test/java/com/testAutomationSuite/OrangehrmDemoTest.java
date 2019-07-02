package com.testAutomationSuite;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OrangehrmDemoTest {
	@Test
	public void testOrangeHrm() throws InterruptedException {
		//Webdriver location
		System.setProperty("webdriver.gecko.driver", ".\\drivers\\geckodriver.exe");
		//launching Firefox
		WebDriver driver = new FirefoxDriver();
		//We have to add wait time for a website components to load, up to 15 Seconds wait time
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		//Navigate to the website
		driver.get("https://orangehrm-demo-6x.orangehrmlive.com");
		Thread.sleep(500);
		//Click on login
		driver.findElement(By.cssSelector("#btnLogin")).click();
		Thread.sleep(3000);
		//Click on Recruitment
		driver.findElement(By.cssSelector("#menu_recruitment_viewRecruitmentModule > span.left-menu-title")).click();
		Thread.sleep(3000);
		//Open left side panel
		/*
		 * Stuck here, driver can't find menu button, tried using selector xpath, iframe selection  
		 * 
		 * */
		driver.findElement(By.cssSelector(".mdi-navigation-menu")).click();
		Thread.sleep(500);
		
		//Click on candidates
		driver.findElement(By.cssSelector("#slide-out > li:nth-child(7) > a")).click();
		Thread.sleep(500);
		
		//Shutdown the driver
		driver.close();
	}		
}
