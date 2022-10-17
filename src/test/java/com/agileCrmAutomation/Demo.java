package com.agileCrmAutomation;

import java.awt.AWTException;
import java.awt.Robot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Demo extends BaseClass{
    @Test
	public  void main() throws AWTException {
		Demo rc=new Demo();
		rc.launchBrowser("chrome");
		Actions action=new Actions(driver);
		driver.navigate().to("https://www.amazon.in/");
	
		WebElement img1=driver.findElement(By.xpath(""));
		
		//action.moveToElement(img1).build().perform();
		//String linkg="https://www.amazon.in/l/29701334031/";
		
		action.contextClick(img1).build().perform();

	}

}
