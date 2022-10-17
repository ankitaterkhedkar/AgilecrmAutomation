package com.agileCrmAutomation;

import org.openqa.selenium.By;
//import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.agilecrm.pages.DealPage;
import com.agilecrm.pages.LoginPage;

public class DealNewDragnDropCase extends BaseClass {
  @Test
  public void aalogin() {
	  launchBrowser("chrome");
	  driver.navigate().to("https://cyberautomation.agilecrm.com");
	  LoginPage login=new LoginPage();
	  login.login("cst100@yopmail.com", "Test1234");
	}
  public void adddeal()
  {
	  DealPage dealpage=new DealPage();
		click(By.id("dealsmenu"),"click on deal");
		dealpage.addDeal("elizabeth", "1000");
  }
  @Test
  public void changeDealStatus() throws Exception
  { 
	  DealPage dealpage=new DealPage();
	 // DealPage dealpage=new DealPage();
		click(By.id("dealsmenu"),"click on deal");
	  dealpage.changedealStatus("Proposal", "Won");
     	  
  }

  
  
}
