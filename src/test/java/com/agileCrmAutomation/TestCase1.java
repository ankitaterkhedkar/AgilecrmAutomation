package com.agileCrmAutomation;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCase1 {
  
 
  @Test(priority =1)
  public void beforeTest()
  {
	  System.out.println("Ankita");
  }
  @Test(priority=2)
  public void beforeClass() throws Exception
  {
	  System.out.println("this is before classp method");
	 // throw new Exception("klkjm");
  }
  @Test(priority=3,dependsOnMethods= {"beforeTest","beforeClass"})
  public void beforeMethod()
  {
	  System.out.println("this is before methodp method");
  }
  @Test(priority=4)
  public void run1()
  {
	  System.out.println("hello");
  }


}
