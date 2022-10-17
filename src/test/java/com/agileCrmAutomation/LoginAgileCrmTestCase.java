package com.agileCrmAutomation;



import java.time.Duration;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//import com.agilecrm.pages.Contacts_selfcreated;
import com.agilecrm.pages.LoginPage;
public class LoginAgileCrmTestCase extends BaseClass {
	
	 LoginPage loginpage;

   //public static void main(String[] args) {
	@BeforeTest
	public void login()
	{
	  // LoginAgileCrmTestCase login=new LoginAgileCrmTestCase();
	   launchBrowser("chrome");
	   driver.navigate().to("https://cyberautomation.agilecrm.com");
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	   loginpage=new  LoginPage();
       loginpage.login("cst100@yopmail.com", "Test1234");
	   //loginpage.login("gh@yopmail.com", "Test1234");
	   //loginpage.login("cst28@yopmail.com", "Test1234");
	  // loginpage.forGotPassword();
	  // loginpage.signInWithGoogle();
	  // loginpage.signInWithYahoo();
	}
	@AfterTest
	public void logout1()
	{
		LoginPage loginpage=new  LoginPage();
		loginpage.logOut();
	}
	
	@Test
	public void verifyYahooSignIn() {
		loginpage.signInWithYahoo();
	}
	   
	   
	   
	   
	   
	   
	   
	   //Contacts_selfcreated c1=new Contacts_selfcreated();
	   //c1.login1("automation@yopmail.com", "Test1234");
	  
	   
	   
	   
	   
		

	}

