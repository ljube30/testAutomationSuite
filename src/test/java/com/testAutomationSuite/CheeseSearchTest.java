package com.testAutomationSuite;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;



public class CheeseSearchTest 
{
	
	@Test
	public void testSearchForCheese() throws InterruptedException {
		//Webdriver location
		System.setProperty("webdriver.gecko.driver", ".\\drivers\\geckodriver.exe");
		//launching Firefox
		WebDriver driver = new FirefoxDriver();
		//create Actions instance so we can use actions with WebDriver
		Actions action = new Actions(driver);
		//We have to add wait time for a website components to load, up to 15 Seconds wait time
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.get("https://google.com");
		
		//Type cheese into the SearchBar
		WebElement searchBar = driver.findElement(By.cssSelector("#tsf > div:nth-child(2) > div > div.RNNXgb > div > div.a4bIc > input"));
		searchBar.sendKeys("cheese");
		Thread.sleep(1000);
		
		//Click on search
		WebElement searchButton = driver.findElement(By.cssSelector("div.VlcLAe:nth-child(5) > center:nth-child(2) > input:nth-child(1)"));
		action.moveToElement(searchButton);
		action.click();
		action.perform();
		Thread.sleep(1000);
		
		//Get the number of results string
		String results = "";
		results = driver.findElement(By.cssSelector("#resultStats")).getText();
		
		//Extract number from string 
		/*
		 * Ex. results = Oko 1.010.000.000 rezultata (0,28 sekundi) 
		 * so we need to get only the number 1.010.000.000
		 * My solution is to split the results string on spaces into the string array 
		 * and then access the array at index 1 because 0:[Oko] 1:[1.010.000.00] 2:[rezultata]...
		 * */
		String[] arr = results.split(" ");
		System.out.println(arr[1]);
		
		//Assert 
		assertEquals(arr[1], "777");
		
		//Shutdown the driver
		driver.close();
	}
}
