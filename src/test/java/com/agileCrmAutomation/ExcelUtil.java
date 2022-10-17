package com.agileCrmAutomation;

import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelUtil {
       static Workbook wb;
       @Test
	public  void main() throws IOException {
		String filepath="C:\\Users\\hp\\Desktop\\Test case\\Selenium\\Book1.xlsx";
		String extension=filepath.substring(filepath.indexOf("."));
		System.out.println(extension);
		FileInputStream input=new FileInputStream(filepath);
		if(extension.equals(".xlsx"))
		{
			wb=new XSSFWorkbook(input);
		}
		else
		{
			wb=new HSSFWorkbook(input);
		}
		Sheet sheet=wb.getSheet("LoginTestData");
		System.out.println(sheet.getSheetName());
	    int totalrows=sheet.getPhysicalNumberOfRows();
	     System.out.println(totalrows);
	     int totalcolumns=sheet.getRow(0).getPhysicalNumberOfCells();
	     System.out.println(totalcolumns);
		for(int i=1;i<totalrows;i++)
		{
			Row row=sheet.getRow(i);
			for(int j=0;j<totalcolumns;j++)
			{
				Cell cell=row.getCell(j);
				String cellvalue=cell.getStringCellValue();
				if(j==0) 
				{
					System.out.print(cellvalue);
				}
				if(j==1)
				{
					System.out.println(" "+cellvalue);
				}
				
			}

	}
		wb.close();
		input.close();

}
}
