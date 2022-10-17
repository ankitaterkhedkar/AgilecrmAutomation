package com.agileCrmAutomation;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class AlertClass extends BaseClass {
    @Test
    
	public void a(){
		AlertClass ac=new AlertClass();
		ac.launchBrowser("chrome");
		driver.navigate().to("https://www.amazon.in/");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("prompt('This is sample alert');");
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().sendKeys("jhygikh");
		//alert.sendKeys("jhoijl");
		System.out.println("prompt");
		//alert.accept();
		//String alerttext=alert.getText();
		//System.out.println(alerttext);
		

	}

}
