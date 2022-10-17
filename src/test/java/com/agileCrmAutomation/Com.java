package com.agileCrmAutomation;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Com {
	public void Com()
	{
		System.out.println("this is Com constructor");
	}
	 @BeforeTest
	  public void beforeTest()
	  {
		  System.out.println("this is before Test method");
	  }
	  @BeforeClass
	  public void beforeclass()
	  {
		  System.out.println("this is before class method");
	  }
	  @BeforeMethod
	  public void beforeMethod()
	  {
		  System.out.println("this is before method method");
	  }
	  @Test
	  public void test()
	  {
		  System.out.println("this is second class method");
	  }
	  @AfterTest
	  public void afterTest()
	  {
		  System.out.println("this is After Test method");
	  }
	  @AfterClass
	  public void afterclass()
	  {
		  System.out.println("this is After class method");
	  }
	  @AfterMethod
	  public void afterMethod()
	  {
		  System.out.println("this is After method method");
	  }
  
}
