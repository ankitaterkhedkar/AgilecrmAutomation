package com.agilecrm.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.agileCrmAutomation.BaseClass;

public class Contacts_selfcreated extends BaseClass {
	public void login1(String username, String password) throws InterruptedException {
		WebElement uname = driver.findElement(By.name("email"));
		uname.clear();
		uname.sendKeys(username);
		WebElement pwd = driver.findElement(By.name("password"));
		pwd.clear();
		pwd.sendKeys(password);
		WebElement signin = driver.findElement(By.xpath("//input[@type='submit']"));
		signin.click();
		driver.findElement(By.xpath("//li[@id='contactsmenu']/child::a/i")).click();
		
     	Thread.sleep(8000);
		System.out.println("clicked on contact");
		boolean a=driver.findElement(By.xpath("//a[@modal_id='personModal']")).isDisplayed();
		System.out.println(a);
		if(driver.findElement(By.xpath("//div[text()='Contacts are your customers or prospects that you interact with using Agile.']/following-sibling::a")).isDisplayed())
		{
			driver.findElement(By.xpath("//div[text()='Contacts are your customers or prospects that you interact with using Agile.']/following-sibling::a")).click();
			addcontact1("Ankita","QA","Cyber");
		}
		System.out.println("there are contacts in list");
		driver.findElement(By.xpath("//div[@id='view-list']/child::div/button")).click();
		Thread.sleep(8000);
		System.out.println("clicked on Addcontact");
		
		addcontact("Xyz","QA","cyy");
		add("User1","Qa","cybersuccess");
}
	public void addcontact(String name, String title,String Companyname)throws InterruptedException
	{
		WebElement uname =driver.findElement(By.xpath( "//input[@id='fname']"));
		uname.sendKeys(name);
		WebElement title1 =driver.findElement(By.xpath( "//input[@id='job_title']"));
		title1.sendKeys(title);
		WebElement Companyname1 =driver.findElement(By.xpath( "//input[@id='contact_company']"));
		Companyname1.sendKeys(Companyname);
		driver.findElement(By.xpath("//a[@id='person_validate']")).click();
		//Thread.sleep(8000);
		String addedname=driver.findElement(By.xpath("//span[@id='contact_name']")).getText();
		if(addedname.equals(name))
		{
			System.out.println("Addition of contact successful");
			//Thread.sleep(8000);
			driver.navigate().back();//.to("https://realestateautomation.agilecrm.com/#contacts");
			delete(addedname);
		}
		else
		{
			System.out.println("Addition of unsuccesful");
		}
		
		
	}
	public void delete(String Deletename) throws InterruptedException
	{
		driver.findElement(By.xpath("//tbody[@id='contacts-list-view-model-list']/descendant::i[1]")).click();
		driver.findElement(By.xpath("//button[text()='Delete']")).click();
		//Thread.sleep(8000);
		driver.findElement(By.xpath("//a[@id='success_callback']")).click();
		System.out.println("element deleted succesfully");
		
	}
	public void addcontact1(String name, String title,String Companyname)throws InterruptedException
	{
		WebElement uname =driver.findElement(By.xpath( "//input[@id='fname']"));
		uname.sendKeys(name);
		WebElement title1 =driver.findElement(By.xpath( "//input[@id='job_title']"));
		title1.sendKeys(title);
		WebElement Companyname1 =driver.findElement(By.xpath( "//input[@id='contact_company']"));
		Companyname1.sendKeys(Companyname);
		driver.findElement(By.xpath("//a[@id='person_validate']")).click();
		//Thread.sleep(8000);
		String addedname=driver.findElement(By.xpath("//span[@id='contact_name']")).getText();
		if(addedname.equals(name))
		{
			System.out.println("Addition of contact successful");
			Thread.sleep(8000);
			driver.navigate().to("https://realestateautomation.agilecrm.com/#contacts");
			delete1(addedname);
		}
		else
		{
			System.out.println("Addition of contact unsuccesful");
		}
		
		
	}
	public void delete1(String Deletename) throws InterruptedException
	{
		driver.findElement(By.xpath("//tbody[@id='contacts-list-view-model-list']/descendant::i[1]")).click();
		driver.findElement(By.xpath("//button[text()='Delete']")).click();
		//Thread.sleep(8000);
		driver.findElement(By.xpath("//a[@id='success_callback']")).click();
		System.out.println("element deleted succesfully");
		
	}
	public void add(String name, String title,String Companyname)throws InterruptedException
	{
		driver.findElement(By.xpath("//a[@data-toggle='dropdown']/child::span/span")).click();
		//Thread.sleep(8000);
		driver.findElement(By.xpath("//li[@class='open']/descendant::div[1]")).click();
		//Thread.sleep(8000);
		WebElement uname =driver.findElement(By.xpath( "//input[@id='fname']"));
		uname.sendKeys(name);
		WebElement title1 =driver.findElement(By.xpath( "//input[@id='job_title']"));
		title1.sendKeys(title);
		WebElement Companyname1 =driver.findElement(By.xpath( "//input[@id='contact_company']"));
		Companyname1.sendKeys(Companyname);
		driver.findElement(By.xpath("//a[@id='person_validate']")).click();
		//Thread.sleep(8000);
		String addedname=driver.findElement(By.xpath("//span[@id='contact_name']")).getText();
		if(addedname.equals(name))
		{
			System.out.println("Addition of contact successful");
			//Thread.sleep(8000);
			driver.navigate().to("https://realestateautomation.agilecrm.com/#contacts");
			delete(addedname);
		}
		else
		{
			System.out.println("Addition of unsuccesful");
		}
		
	}
	
}

