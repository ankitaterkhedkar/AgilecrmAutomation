package com.agileCrmAutomation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class actionsclass extends BaseClass{

	@Test
	public  void main()  {
		actionsclass ac=new actionsclass();
		ac.launchBrowser("chrome");
		driver.navigate().to("https://www.amazon.in/");
		Actions action =new Actions(driver);
		//WebElement e=driver.findElement(By.xpath("//div[@id='nav-xshop']/descendant::a[text()='Customer Service']")); alternative xpath
		//WebElement e=driver.findElement(By.xpath("//div[@id='nav-xshop']/a[text()='Customer Service']")); 
		WebElement e=driver.findElement(By.id("twotabsearchtextbox"));
		//action.click(e).sendKeys("ghfj").build().perform();
		System.out.println(" clicked on search and keys sent");
		action.moveToElement(e).click().sendKeys("Washing machine").build().perform();
		
		//action.contextClick(e).build().perform();
		//action.pause(Duration.ofSeconds(2)).sendKeys(Keys.DOWN).pause(Duration.ofSeconds(2)).sendKeys(Keys.ENTER).build().perform();
		

	}

}
