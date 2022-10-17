package com.agilecrm.pages;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.agileCrmAutomation.BaseClass;

public class CompanyPage_selfcreated extends BaseClass {
	      By companyname=By.id("company_name");
	public  void main(String[] args) {
		CompanyPage_selfcreated company=new CompanyPage_selfcreated();
		company.launchBrowser("chrome");
		driver.navigate().to("https://learnautomation.agilecrm.com/");
		LoginPage log=new LoginPage();
		log.login("cst28@yopmail.com","Test1234");
		click(By.id("companiesmenu"),"click on company");
		click(By.xpath("//button[contains(text(),'Add Company')]"),"click on  add company");
		//waitForElementToBeClickable(By.id("company_name"));
		driver.findElement(companyname).sendKeys("harbinger66");
		click(By.id("continue-company"),"click on continue edit button");
		fluentWait(By.name("email-select"));
		Select select=new Select(driver.findElement(By.name("email-select")));
		List<WebElement> emaildropdownlist=select.getOptions();
		for(WebElement element:emaildropdownlist)
		{
			String text=element.getAttribute("value");
			System.out.println(text);
		}
		fluentWait(By.xpath("//select[@name='country']"));
		Select select1=new Select(driver.findElement(By.xpath("//select[@name='country']")));
		if(!select1.isMultiple())
		{
		List<WebElement> countrydropdownlist=select1.getOptions();
		for(WebElement element:countrydropdownlist)
		{
			//String text=element.getAttribute("value");
			String text=element.getText();
			System.out.println(text);
		}
		}
		else
		{
			System.out.println("not multiple selection");
		}
		

	}

}
