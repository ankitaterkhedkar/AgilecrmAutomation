package com.agileCrmAutomation;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.agilecrm.pages.DealPage;
import com.agilecrm.pages.LoginPage;

public class DealAgileCrmTestCase extends BaseClass {

	// public static void main(String[] args) {
	// DealAgileCrmTestCase Deal=new DealAgileCrmTestCase();
	// Deal.launchBrowser("chrome");
	// driver.navigate().to("https://cyberautomation.agilecrm.com");
	// LoginPage log=new LoginPage();
	// log.login("cst100@yopmail.com","Test1234");
	@Test
		public void adddeal1()
		{
		DealPage dealpage=new DealPage();
		
		click(By.id("dealsmenu"),"click on deal");
		//int count=50;
		List<String> dealNames=new ArrayList<>();
		//while(count<60) {
			//count++;
		for (int i = 51; i <=52; i++) {
			String dealNamae=dealpage.addDeal("AgileCrm1_Deal_"+i, "1000"+i);
			dealNames.add(dealNamae);
			
		}
			
		for(String dealName: dealNames) {
			
			dealpage.searchDeal(dealName);//search Deal by name
			
			//select deal
		
			
			
				dealpage.archiveDeal(dealName);
			
			//dealpage.archiveDeal(dealName);//archeive deal
			
			//verify deal is archeived or not
			//dealpage.dealStatus(dealName);
			
		}
		
		
		
		
		
	}

}
