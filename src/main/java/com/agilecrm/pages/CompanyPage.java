package com.agilecrm.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.agileCrmAutomation.BaseClass;

public class CompanyPage extends BaseClass {
	public void addCompany() {
		click(By.id("companiesmenu"), "click on company");
		click(By.xpath("//button[contains(text(),'Add Company')]"), "click on  add company");
		// waitForElementToBeClickable(By.id("company_name"));
		driver.findElement(By.id("company_name")).sendKeys("apple1");
		driver.findElement(By.xpath("//input[@id='company_url']")).sendKeys("https://cubersuccess.biz");
		click(By.id("continue-company"), "click on continue edit button");
		fluentWait(By.xpath("//div[contains(@class,'second')]//input[@name='email']"));
		driver.findElement(By.xpath("//div[contains(@class,'second')]//input[@name='email']"))
				.sendKeys("cybersuccess@yopmail.com");
		fluentWait(By.name("email-select"));
		Select select = new Select(driver
				.findElement(By.xpath("//div[contains(@class,'second')]/descendant::select[@name='email-select']")));
		List<WebElement> emaildropdownlist = select.getOptions();
		for (WebElement element : emaildropdownlist) {

			String text = element.getAttribute("value");
			if (text.equalsIgnoreCase("primary")) {
				select.selectByValue(text);
				// System.out.println(text);
			}
		}
		driver.findElement(By.xpath("//div[contains(@class,'second')]//input[@id='phone']")).sendKeys("8796543278");
		Select select2 = new Select(
				driver.findElement(By.xpath("//div[contains(@class,'second')]//select[@name='phone-select']")));
		List<WebElement> phonenumberselect = select2.getOptions();
		for (WebElement e2 : phonenumberselect) {
			String str = e2.getText();
			if (str.equalsIgnoreCase("primary"))
				select2.selectByVisibleText(str);
		}
		driver.findElement(By.xpath("//div[contains(@class,'second')]//input[@id='website']"))
				.sendKeys("www.cybersuccess.biz");
		selectDroppdownValByText(
				driver.findElement(By.xpath("//div[contains(@class,'second')]//select[@name='website-select']")),
				"Website");
		driver.findElement(By.xpath("//div[contains(@class,'second')]//input[@id='address']"))
				.sendKeys("Goodluck Square");
		selectDroppdownValByText(
				driver.findElement(By.xpath("//div[contains(@class,'second')]//select[@name='address-type']")), "Work");
		driver.findElement(By.xpath("//div[contains(@class,'second')]//input[@id='city']")).sendKeys("Pune");
		driver.findElement(By.xpath("//div[contains(@class,'second')]//input[@id='state']")).sendKeys("Maharashtra");
		driver.findElement(By.xpath("//div[contains(@class,'second')]//input[@id='zip']")).sendKeys("411012");
		// fluentWait(By.xpath("//select[@name='country']"));
		Select select1 = new Select(
				driver.findElement(By.xpath("//div[contains(@class,'second')]//select[@id='country']")));
		List<WebElement> countrydropdownlist = select1.getOptions();
		for (WebElement element1 : countrydropdownlist) {
			// String text=element.getAttribute("value");
			String text1 = element1.getText();
			if (text1.equalsIgnoreCase("India")) {
				select1.selectByVisibleText(text1);
			}
		}

		click(By.xpath("//a[@id='company-update']"), "click on update button");
	}

}
