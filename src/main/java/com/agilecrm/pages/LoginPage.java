package com.agilecrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.agileCrmAutomation.BaseClass;

public class LoginPage extends BaseClass{
	  public void login(String username, String password) 
	  {
		WebElement uname = driver.findElement(By.name("email"));
		uname.clear();
		uname.sendKeys(username);
		WebElement pwd = driver.findElement(By.name("password"));
		pwd.clear();
		pwd.sendKeys(password);
		WebElement signin = driver.findElement(By.xpath("//input[@type='submit']"));
		signin.click();
		if (driver.findElement(By.xpath("//a[@class='close']/parent::*")).isDisplayed())
		{
			invalidPasswordTest(username);
		}
		else
		{
			//logOut();
			System.out.println("login successful");
		}
	}
		
	
	     public void logOut() 
	     {
		
	    	    WebElement profileimg = driver.findElement(By.xpath("//li[@id='fat-menu']/child::a/span/img"));
				profileimg.click();
				driver.findElement(By.xpath("//a[text()=\"Logout\"]")).click();
				System.out.println("logout successful");
	      }


		public void invalidPasswordTest(String username)
		{
			String validationmsg = driver.findElement(By.xpath("//a[@class='close']/parent::*")).getText();
			if (validationmsg.contains("Incorrect password. Please try again")) 
			{
				System.out.println("invalid password");
		    }
			else if (validationmsg.contains("We have not been able to locate any user"))
			 {
				System.out.println("invalid username" + username);
	         }
       }
		public void forGotPassword()
		{
			driver.findElement(By.xpath("//a[contains(text(),\"Password\")]")).click();
			if (driver.findElement(By.xpath("//strong[text()='Enter Your Email']")).isDisplayed()) 
			{
				System.out.println("forgot password successful");
				driver.navigate().back();
		    }
        }
		public void signInWithGoogle()
		{
			driver.findElement(By.xpath("//button[@id='btnSearch']/child::img")).click();
			if (driver.findElement(By.xpath("//div[contains(text(),'Sign in with Google')]")).isDisplayed())
			{
				System.out.println("Sign in with google successful");
				driver.navigate().back();
            }
			else 
			{
				System.out.println("Sign in with google failed");
			}
       }
		public void signInWithYahoo()
		{
			driver.findElement(By.xpath("//button[@id='btnClear']/child::img")).click();
			if (driver.findElement(By.xpath("//h4[contains(text(),'Sign')]")).isDisplayed()) 
			{
				System.out.println("Sign in with yahoo unsuccesful");
				
			}

			else
			{
				System.out.println("Sign in with successful");
			}
       }
}