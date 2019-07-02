package com.testAutomationSuite;

import java.util.Scanner;  

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {

	public static void main(String[] args) {
		  System.out.println("Which test do you want to run");
		  System.out.printf("1. WeDoQa\n2. Cheese Test\n3. OrangehrmDemoTest\n");
		  //Initiate scanner
		  Scanner input = new Scanner(System.in);
		  //Get choice from the user
		  int choice = input.nextInt();
		
		  switch(choice) {
		  case 1:
			  Result result1 = JUnitCore.runClasses(WeDoQaTest.class);
				
		      for (Failure failure : result1.getFailures()) {
		    	  System.out.println(failure.toString());
		      }
				
		      System.out.println(result1.wasSuccessful());
		      break;
		  case 2:
			  Result result2 = JUnitCore.runClasses(CheeseSearchTest.class);
				
		      for (Failure failure : result2.getFailures()) {
		         System.out.println("There is too much cheese on the internet");
		      }
				
		      System.out.println(result2.wasSuccessful());
		      break;
		  case 3:
			  Result result3 = JUnitCore.runClasses(OrangehrmDemoTest.class);
				
		      for (Failure failure : result3.getFailures()) {
		    	  System.out.println(failure.toString());
		      }
				
		      System.out.println(result3.wasSuccessful());
		      break;
		   default:
			   System.err.println("Invalid choice, for choice enter number between 1 and 3... Exiting app...");
			  
		  }
	   }

}
