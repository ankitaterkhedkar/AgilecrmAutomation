package com.agileCrmAutomation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LinkVerification extends BaseClass {
     @Test(groups= {"Regression","Sanity"})
     @Parameters({"browser"})
	public void main(String browser)  {
		//LinkVerification LV=new  LinkVerification();
		launchBrowser(browser);
		imageVerification("https://www.amazon.in/");
		System.out.println("end of amazon link");
		imageVerification("https://www.flipkart.com/");


	}
	public static void imageVerification(String str)
	{
		driver.navigate().to(str);
		List<WebElement> elements=driver.findElements(By.tagName("img"));
		for(WebElement e:elements)
		{
			String link=e.getAttribute("src");
		 	if(link!=null && link.startsWith("http"))
			System.out.println(link);
		}
	}

}
