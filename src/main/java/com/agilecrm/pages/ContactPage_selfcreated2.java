package com.agilecrm.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.agileCrmAutomation.BaseClass;

public class ContactPage_selfcreated2 extends BaseClass{
	String name;
	String title;
	String compnyname;
	String lastname;

	public static void main(String[] args) {
		ContactPage_selfcreated2 contact=new ContactPage_selfcreated2();
		contact.launchBrowser("chrome");
		driver.navigate().to("https://learnautomation.agilecrm.com/");
		LoginPage log=new LoginPage();
		log.login("cst20@yopmail.com","Test1234");
		//click on contact menu
        click(By.id("contactsmenu"), "Click on contact menu");
        //click on addcontact
        contact.addContact();
        contact.searchContact();
        contact.updateContact();
        contact.deleteContact();
        
		}
	public void addContact()
	{
		 name="legend";
		 title="QA";
		 compnyname="google";
		 click(By.xpath("//div[@id='view-list']/child::div/button"), "Click on add contact");
		 fluentWait(By.id("name"));
		 WebElement uname =driver.findElement(By.xpath( "//input[@id='fname']"));
			uname.sendKeys(name);
			WebElement title1 =driver.findElement(By.xpath( "//input[@id='job_title']"));
			title1.sendKeys(title);
			WebElement Companyname1 =driver.findElement(By.xpath( "//input[@id='contact_company']"));
			Companyname1.sendKeys(compnyname);
			click(By.xpath("//a[@id='person_validate']"),"click on save contact");
     }
	public void searchContact()
	{    name="legend";
		click(By.xpath("//li[@id=\"homemenu\"]/preceding::button[3]"),"click on search contact");
		click(By.xpath("//input[@name='all']/following-sibling::i"),"click on all");
		click(By.xpath("//input[@name='person']/following-sibling::i"),"click on contact checkbox");
		WebElement search = driver.findElement(By.id("searchText"));
		search.sendKeys(name);
		click(By.xpath("//button[@id='search-results']/child::i"),"click on search");
		click(By.xpath("//div[@class='text-cap custom-link']"),"click on added name");
		
	}
	public void updateContact()
	{   lastname="hopper";
		click(By.xpath("//div[@class='contact-lhs-actions']/descendant::i[1]"),"click on edit name");
		click(By.xpath("//input[@name='lname']"),"click on last name");
		WebElement lastname1 =driver.findElement(By.xpath( "//input[@name='lname']"));
		lastname1.sendKeys(lastname);
		click(By.xpath("//a[@id='update']"),"click on update name");
		
		
	}
	public void deleteContact()
	{  click(By.xpath("//i[@class='material-icons more_vert v-middle']"),"click on more ");
		click(By.xpath("//div[@class='dropdown ibm open']/descendant::span[7]"),"click on delete ");
		click(By.xpath("//a[@id='success_callback']"),"click on ok ");
	}

}
