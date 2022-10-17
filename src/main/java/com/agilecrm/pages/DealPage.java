package com.agilecrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import com.agileCrmAutomation.BaseClass;

public class DealPage extends BaseClass {
	public String addDeal(String name, String amt) {

		waitForElementToBeClickable(By.xpath("//button[contains(text(),'Add Deal')]"));
		click(By.xpath("//button[contains(text(),'Add Deal')]"), "click on  add deal");
		waitForElementToBeClickable(
				By.xpath("//div[@class='modal fade in']/descendant::span/input[@placeholder='Deal Name']"));
		driver.findElement(By.xpath("//div[@class='modal fade in']/descendant::span/input[@placeholder='Deal Name']"))
				.sendKeys(name);
		driver.findElement(By.xpath("//div[@class='modal fade in']/descendant::input[@placeholder='Deal Value']"))
				.sendKeys(amt);
		click(By.xpath("//div[@id='deals-new-footer']/child::a"), "click on Save");
		/*
		 * System.out.print(name + " "); System.out.println(amt); //
		 * waitForElementToBeClickable(By.xpath("//a[contains(text(),'software testing20
		 * // ')]")); //
		 * click(By.xpath("//header[@id='header']/descendant::button[3]"),"click on //
		 * search contact"); //
		 * click(By.xpath("//input[@name='all']/following-sibling::i"),"click on all");
		 * // click(By.xpath("//input[@name='opportunity']/following-sibling::i"),"click
		 * on // deals checkbox"); // WebElement search =
		 * driver.findElement(By.id("searchText")); // search.sendKeys(name); //
		 * click(By.xpath("//button[@id='search-results']/child::i"),"click on search");
		 * click(By.xpath("//div[@class='media-body']/child::a"),
		 * "click on added deal"); //
		 * click(By.xpath("//a[contains(text(),'software testing20 ')]"),"click on edit
		 * // deal"); click(By.xpath("//a[contains(text(),'Edit Deal')]"),
		 * "click on  edit deal"); click(By.xpath("//a[(@title='Archive')]"),
		 * "click on  Archieve deal"); // driver.navigate().back();
		 * 
		 * driver.navigate().back();
		 * 
		 * // System.out.println("two Deals are added and archived");
		 */
		return name;
	}

	public void searchDeal(String dealname) {
		click(By.xpath("//header[@id='header']/descendant::button[3]"), "click on search box");
		WebElement allCheckBox = driver.findElement(By.xpath("//input[@name='all']/following-sibling::i"));
		WebElement dealCheckBox = driver.findElement(By.xpath("//input[@name='opportunity']/following-sibling::i"));
		if (allCheckBox.isSelected()) {
			allCheckBox.click();
			dealCheckBox.click();
		}
		// if(dealname.contains("51"))
		// {
		// click(By.xpath("//input[@name='all']/following-sibling::i"),"click on all");
		// click(By.xpath("//input[@name='opportunity']/following-sibling::i"),"click on
		// deals checkbox");
		// }
		driver.findElement(By.id("searchText")).sendKeys(dealname);
		click(By.xpath("//button[@id='search-results']/child::i"), "click on search");
	}

	public void archiveDeal(String dealname) {
		click(By.xpath("//tbody[@id='deal-search-model-list']/descendant::tr[1]/descendant::div[3] "),
				"click on added deal");
		click(By.xpath("//a[contains(text(),'Edit Deal')]"), "clickon edit deal");
		click(By.xpath("//a[(@title='Archive')]"), "click on  Archive deal");

	}

	public void changedealStatus(String srcstatus, String deststatus) throws Exception {
		waitForElementToBeClickable(By.xpath("//ul[@milestone='" + srcstatus + "']/li[1]"));

		WebElement srcElement = driver.findElement(By.xpath("//ul[@milestone='" + srcstatus + "']/li[1]"));
		String dealname = driver.findElement(By.xpath("//ul[@milestone='" + srcstatus + "']/li[1]/descendant::a[1]"))
				.getText();
		WebElement destElement = driver.findElement(By.xpath("//ul[@milestone='" + deststatus + "']/li[1]"));
		Actions action = new Actions(driver);
		// action.dragAndDrop(srcElement, destElement).build().perform();
		Action dragAndDrop = action.clickAndHold(srcElement).moveToElement(destElement).release(destElement).build();
		dragAndDrop.perform();
		System.out.println("changing status of" + dealname + "from" + srcstatus + "to" + deststatus);

		String destdealName = driver
				.findElement(By.xpath("//ul[@milestone='" + deststatus + "']/li[1]/descendant::a[1]")).getText();
		System.out.println(destdealName);
		waitForVisibility(driver.findElement(By.xpath("//ul[@milestone='" + deststatus + "']/li[1]/descendant::a[1]")));
		WebElement element = driver
				.findElement(By.xpath("//ul[@milestone='" + deststatus + "']/li[1]/descendant::a[1]"));
		verifyDealStatus(deststatus, element);
	}

	public void verifyDealStatus(String expectedstatus, WebElement element) throws Exception {
		waitForElementToBeClickable(element);
		element.click();
		Thread.sleep(3000);
		String actualstatus = driver.findElement(By.xpath("//div[@class='panel-body']/div[3]/span[1]")).getText();
		if (actualstatus.equals(expectedstatus)) {
			System.out.println("successful drag and drop");
		} else
			throw new Exception("unsuccessful");
	}

}
