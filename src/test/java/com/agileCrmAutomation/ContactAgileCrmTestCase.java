package com.agileCrmAutomation;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.agilecrm.pages.ContactPage;
import com.agilecrm.pages.LoginPage;

public class ContactAgileCrmTestCase extends BaseClass{

	//public static void main(String[] args)  {
		//ContactAgileCrmTestCase contact =new ContactAgileCrmTestCase();
		//@BeforeClass
		//public void navigate1()
		//{
	     //launchBrowser("chrome");	
	     //driver.navigate().to("https://learnautomation.agilecrm.com");
		//}
		//@BeforeMethod
		//public void login()
		//{
	     //LoginPage log=new LoginPage();
		 //log.login("cst28@yopmail.com","Test1234");
		//}
		@Test
		public void addcontact()
		{
		 click(By.id("contactsmenu"), "Click on contact menu");
	        //click on addcontact
		 ContactPage contacttest=new ContactPage();
	        contacttest.addContact();
		}
	         //contacttest.searchContact();
	        //contacttest.updateContact();
	        //contacttest.deleteContact();
		//@AfterMethod
		//public void aftermethod()
		//{   LoginPage log=new LoginPage();
	      // log.logOut();
		//}

	}


