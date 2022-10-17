package com.agileCrmAutomation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.agilecrm.pages.LoginPage;

public class ExcelFIleWritePractice extends BaseClass {
	  static WebElement ele1=driver.findElement(By.id("contactsmenu"));
	

	public static void main(String[] args) throws IOException, InterruptedException {
	  //@Test
	  //public void main() throws IOException, InterruptedException {
		launchBrowser("chrome");
		driver.navigate().to("https://cyberautomation.agilecrm.com");
		LoginPage lp = new LoginPage();
		lp.login("cst100@yopmail.com", "Test1234");
		//click(By.id("contactsmenu"), "Click on contact menu");
		click(ele1, "Click on contact menu");
		Thread.sleep(5000);
		File f = new File("F:\\Test case\\Selenium\\ContactData1.xlsx");
		FileOutputStream fos = new FileOutputStream(f);
		Workbook wb = new XSSFWorkbook();
		Sheet sheet = wb.createSheet("Contactdata");
		for (int i = 0; i<1 ; i++)
		{ 		int k=0;
			Row ro = sheet.createRow(i);
			for (int j = 0; j < 2; j++) 
			{
				Cell c0 = ro.createCell(j);
				WebElement element = driver.findElement(By.xpath("//table[@id='contacts-table']//th[" + k +"+2]"));
				
				System.out.println(element.getText());
				String str = element.getText();
				c0.setCellValue(str);
				k=k+2;
			}
		}
		for (int rowInWebpage = 1; rowInWebpage < 3; rowInWebpage++)
		{ 	int columnInWebPage=2;
			Row ro = sheet.createRow(rowInWebpage);
			for (int columnInSheet = 0; columnInSheet < 2; columnInSheet++) 
			{
				Cell c0 = ro.createCell(columnInSheet);
				System.out.println("rowInWebpage = " + rowInWebpage + ", columnInWebPage = " + columnInWebPage + ", columnInSheet = " + columnInSheet);
				
				WebElement element = driver.findElement(By.xpath("//tbody[@id='contacts-list-view-model-list']/tr["+rowInWebpage+"]/td["+columnInWebPage+"]/descendant::a"));
				
				System.out.println(element.getText());
				String str = element.getText();
				c0.setCellValue(str);
				columnInWebPage++;
			}
		}
		
		
		
		
		
		wb.write(fos);
		fos.close();
		wb.close();
		System.out.println("file is written");

	}

}
