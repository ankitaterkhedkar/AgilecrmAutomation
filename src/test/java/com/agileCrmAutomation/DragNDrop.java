package com.agileCrmAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.agilecrm.pages.LoginPage;

public class DragNDrop extends BaseClass {
    @Test(groups= {"Regression"})
    @Parameters({"browser","username","password"})
	public void main(String browser,String username,String password) {
		DragNDrop dd=new DragNDrop();
		//dd.launchBrowser("chrome");
		dd.launchBrowser(browser);
	 	driver.navigate().to("https://cyberautomation.agilecrm.com");
		LoginPage lp=new LoginPage();
		//lp.login("cst100@yopmail.com", "Test1234");

		lp.login(username, password);
		WebElement e=driver.findElement(By.id("dealsmenu"));
		Actions action=new Actions(driver);
		action.click(e).build().perform();
		waitForVisibility(driver.findElement(By.xpath("//ul[@id='deals-by-paging-relax-model-list']/descendant::div[@data='New'][1]")));
		WebElement sourceele=driver.findElement(By.xpath("//ul[@id='deals-by-paging-model-list']/descendant::div[@data='New'][1]"));
		WebElement destinationele=driver.findElement(By.xpath("//div[@id='Prospect-list-container']/div/ul"));
		action.dragAndDrop(sourceele,destinationele).build().perform();
		

	}

}
