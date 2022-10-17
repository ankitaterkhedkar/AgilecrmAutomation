package com.agileCrmAutomation;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class RightClicknNewWindow extends BaseClass{
	
	@FindBy(xpath="//div[@id='desktop-banner']")
	public WebElement e1;
	public RightClicknNewWindow()
	{
		PageFactory.initElements(driver, this);
	}
    @Test
	public  void main() throws AWTException, InterruptedException {
		RightClicknNewWindow rc=new RightClicknNewWindow();
		rc.launchBrowser("chrome");
		driver.navigate().to("https://www.amazon.in/");
		Actions action=new Actions(driver);
		//WebElement img1=driver.findElement(By.xpath("//div[@id='desktop-banner']"));
		
		//action.moveToElement(img1).build().perform();
		//String linkg="https://www.amazon.in/l/29701334031/";
		
		action.contextClick(e1).build().perform();
	 	Robot rb=new Robot();
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		String parentwindowid=driver.getWindowHandle();
		System.out.println(parentwindowid);
		Thread.sleep(5000);
		Set<String> childwindowid=driver.getWindowHandles();
		for( String windowid:childwindowid)
		{
			if(!windowid.equals(parentwindowid))
			driver.switchTo().window(windowid);
			System.out.println(driver.getTitle());
			List<WebElement> image=driver.findElements(By.xpath("//div[@class='DealContent-module__truncate_sWbxETx42ZPStTc9jwySW']"));
			List<WebElement> discount=driver.findElements(By.xpath("//div[@class='BadgeAutomated-module__badgeOneLineContainer_yYupgq1lKxb5h3bfDqA-B']/div[1]"));
			System.out.println("printing");
			for(int i=0;i<image.size();i++)
			{
				String s1=image.get(i).getText();
			    String s2=discount.get(i).getText();
				
				System.out.println(s1+" "+s2);
			}
		}
		

	}

}
