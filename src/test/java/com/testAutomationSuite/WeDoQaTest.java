package com.testAutomationSuite;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;


public class WeDoQaTest {
	@Test
	public void testWeDoQa() throws InterruptedException {
		//Webdriver location
		System.setProperty("webdriver.gecko.driver", ".\\drivers\\geckodriver.exe");
		//launching Firefox
		WebDriver driver = new FirefoxDriver();
		//create Actions instance so we can use actions with WebDriver
		Actions action = new Actions(driver);
		//We have to add wait time for a website components to load, up to 15 Seconds wait time
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		//open google.com
		driver.get("https://google.com");
		
		//Type cheese into the SearchBar
		WebElement searchBar = driver.findElement(By.cssSelector("#tsf > div:nth-child(2) > div > div.RNNXgb > div > div.a4bIc > input"));
		searchBar.sendKeys("wedoqa.com");
		Thread.sleep(100);
				
		//Click on search
		WebElement searchButton = driver.findElement(By.cssSelector("#tsf > div:nth-child(2) > div > div.FPdoLc.VlcLAe > center > input.gNO89b"));
		action.moveToElement(searchButton);
		action.click();
		action.perform();
		Thread.sleep(100);
		
		//Click on first result that will lead to wedoqa.com
		driver.findElement(By.partialLinkText("https://www.wedoqa.com/")).click();
		Thread.sleep(100);
		
		//Move to Testimonials / References section
		WebElement testimonials = driver.findElement(By.cssSelector("#testimonials > div.section-header > div > div > div > h3"));
		action.moveToElement(testimonials);
		action.click();
		action.perform();
		//Shutdown the driver
		driver.close();
	}		
}
