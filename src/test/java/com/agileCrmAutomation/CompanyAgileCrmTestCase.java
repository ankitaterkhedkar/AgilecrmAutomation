package com.agileCrmAutomation;

//import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.agilecrm.pages.CompanyPage;
import com.agilecrm.pages.LoginPage;

public class CompanyAgileCrmTestCase extends BaseClass{
       
	  // @BeforeMethod
	   //public void aLogin()
	   //{
		//CompanyAgileCrmTestCase company =new CompanyAgileCrmTestCase();
	   // launchBrowser("chrome");	
	   //  driver.navigate().to("https://cyberautomation.agilecrm.com");
	   //  LoginPage log=new LoginPage();
		// log.login("cst100@yopmail.com","Test1234");
	  // }
	   @Test
	   public void baddcompany()
	   {
		 CompanyPage cmp=new CompanyPage();
	     cmp.addCompany();
	   }
	

}
