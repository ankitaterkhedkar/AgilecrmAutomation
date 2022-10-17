package com.agilecrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.agileCrmAutomation.BaseClass;

public class ContactPage extends BaseClass {

	By addContactButton = By.xpath("//div[@id='view-list']/child::div/button");
	By firstName = By.xpath("//input[@id='fname']");

	@FindBy(xpath = "//input[@id='job_title']")
	public WebElement jobTitleText;
	

	@FindBy(xpath = "//a[@id='person_validate']")
	public WebElement personValidate;

	public ContactPage() {

		PageFactory.initElements(driver, this);

	}

	String name;
	String title;
	String compnyname;
	String lastname;

	public void addContact() {
		name = "legend";
		title = "QA";
		compnyname = "google";
		click(addContactButton, "Click on add contact");
		fluentWait(By.id("name"));
		WebElement uname = driver.findElement(firstName);
		uname.sendKeys(name);
		/*
		 * WebElement title1 =driver.findElement(By.xpath( "//input[@id='job_title']"));
		 * title1.sendKeys(title);
		 */
		jobTitleText.sendKeys(title);
		WebElement Companyname1 = driver.findElement(By.xpath("//input[@id='contact_company']"));
		Companyname1.sendKeys(compnyname);
		click(personValidate, "click on save contact");
	}

	public void searchContact() {
		name = "legend";
		click(By.xpath("//li[@id=\"homemenu\"]/preceding::button[3]"), "click on search contact");
		click(By.xpath("//input[@name='all']/following-sibling::i"), "click on all");
		click(By.xpath("//input[@name='person']/following-sibling::i"), "click on contact checkbox");
		WebElement search = driver.findElement(By.id("searchText"));
		search.sendKeys(name);
		click(By.xpath("//button[@id='search-results']/child::i"), "click on search");
		click(By.xpath("//div[@class='text-cap custom-link']"), "click on added name");

	}

	public void updateContact() {
		lastname = "hopper";
		click(By.xpath("//div[@class='contact-lhs-actions']/descendant::i[1]"), "click on edit name");
		click(By.xpath("//input[@name='lname']"), "click on last name");
		WebElement lastname1 = driver.findElement(By.xpath("//input[@name='lname']"));
		lastname1.sendKeys(lastname);
		click(By.xpath("//a[@id='update']"), "click on update name");

	}

	public void deleteContact() {
		click(By.xpath("//i[@class='material-icons more_vert v-middle']"), "click on more ");
		click(By.xpath("//div[@class='dropdown ibm open']/descendant::span[7]"), "click on delete ");
		click(By.xpath("//a[@id='success_callback']"), "click on ok ");
	}

}
