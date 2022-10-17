package com.agileCrmAutomation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AmazonAppliancesSearch extends BaseClass {
    @Test
    @Parameters({"browser"})
	public  void main(String browser) {
		AmazonAppliancesSearch a1 = new AmazonAppliancesSearch();
		a1.launchBrowser(browser);
		driver.navigate().to("https://www.amazon.in/");
		selectDroppdownValByText(driver.findElement(By.xpath("//select[@id='searchDropdownBox']")), "Appliances");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Washing Machine");
		click(By.id("nav-search-submit-button"), "click on search button");
		List<WebElement> appliancenames = driver.findElements(By.xpath("//div[@class='sg-row']/descendant::h2/a/span"));
		
		List<WebElement> appliancecost = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
		// (this is also xpath for cost)driver.findElement(By.xpath("//div[@class='sg-row']/descendant::span[@class='a-price']"))
		for (int i = 0; i < appliancecost.size(); i++) 
		{
			          String cost =appliancecost.get(i).getText();
			           String cost1=cost.replace(",", "");
			          int i1=Integer.parseInt(cost1);
			          if(i1>20000)
			          {
			        	  System.out.println(appliancenames.get(i).getText() + " : " + i1);
			          }
					
				
				
		}



}
}
