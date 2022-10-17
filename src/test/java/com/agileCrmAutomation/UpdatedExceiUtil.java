package com.agileCrmAutomation;
import java.io.FileInputStream;
import java.io.FileOutputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class UpdatedExceiUtil {
	
	private static final CellType STRING = null;


	private String getFileExtension(String filepath)
	{
		String extension=filepath.substring(filepath.indexOf("."));
		System.out.println(extension);
		return extension;
	}
	private Workbook getWorkBookInstance(String filepath) throws IOException
	{   Workbook wb;
		FileInputStream input=new FileInputStream(filepath);
		if(getFileExtension(filepath).equals(".xlsx"))
		{
			wb=new XSSFWorkbook(input);
		}
		else
		{
			wb=new HSSFWorkbook(input);
		}
		return wb;
	}
	private Sheet getSheet(String filepath,String sheetname) throws IOException
	{
		Sheet sheet=null;
		Workbook wb=getWorkBookInstance(filepath);
		sheet=wb.getSheet(sheetname);
		return sheet;
	}
	public Object[][] getExcetData(String filepath,String sheetname) throws IOException
	{
		Sheet sheet=getSheet(filepath, sheetname);
		int totoalRow=sheet.getPhysicalNumberOfRows();
		int totalcolumn=sheet.getRow(0).getPhysicalNumberOfCells();
		return getCellValue(sheet,totoalRow,totalcolumn);
	}
	private Object[][] getCellValue(Sheet sheet,int totalRows,int totalcolumns)
	{
		Object[][] value=new Object[totalRows][totalcolumns];
		for(int i=1;i<totalRows;i++)
		{
			Row row=sheet.getRow(i);
			for(int j=0;j<totalcolumns;j++)
			{
				Cell cell=row.getCell(j);
				CellType type=cell.getCellType();
				switch(type) {
				case STRING:
					value[i][j]=cell.getStringCellValue();
					break;
				case NUMERIC:
					value[i][j]=cell.getNumericCellValue();
					break;
				
				case BOOLEAN:
					value[i][j]=cell.getBooleanCellValue();
					break;
				
				case _NONE:
					value[i][j]=null;
					break;
				
				case BLANK:
					value[i][j]=null;
					break;
				
				
				
				}
				
			}
			
		}
		return value;
	}
	
   public void setDataExcel(String filepath,String sheetname,int rownum,int cellnum,Object value)
   {
	   try {
		    Workbook wb=getWorkBookInstance(filepath);
		    Sheet sheet;
		    if(wb.getSheet(sheetname)!=null)
		    {
		    	sheet=wb.getSheet(sheetname);
		    }
		    else
		    {
		    	sheet=wb.createSheet(sheetname);
		    }
		    Row row;
		    if(sheet.getRow(rownum)!=null)
		    {
		    	row=sheet.getRow(rownum);
		    }
		    else
		    {
		    	row=sheet.createRow(rownum);
		    }
		   Cell cell;
		   if(row.getCell(cellnum)!=null)
		    {
		    	cell=row.getCell(cellnum);
		    }
		    else
		    {
		    	cell=row.createCell(cellnum);
		    }
		   setCellValue(cell,value);
		   FileOutputStream op=new FileOutputStream(filepath);
		   wb.write(op);
		   wb.close();
	   }
	   catch(IOException e)
	   {
		   e.printStackTrace();
	   }
   }
   public void setCellValue(Cell cell,Object val)
   {
	   if(val instanceof Integer)
	   {
		   cell.setCellValue((int)val);
	   } else if(val instanceof String)
	   {
		   cell.setCellValue(val.toString());
	   } else if(val instanceof Boolean)
	   {
		   cell.setCellValue((boolean)val);
	   } 
	   
   }
	public static void main(String[] args) throws IOException {
		String filepath="F:\\Test case\\Selenium\\Book1.xlsx";
		//String filepath1="F:\\Test case\\Selenium\\Book2.xlsx";
		UpdatedExceiUtil excelvalues=new UpdatedExceiUtil();
		Object[][] data=excelvalues.getExcetData(filepath,"LoginTestData");
		int rowLength=data.length;
		int columnLength=data[0].length;
		for(int i=1;i<=rowLength-1;i++)
		{
			for(int j=0;j<columnLength;j++)
			{
				System.out.println(data[i][j]);
			}
		}
		excelvalues.setDataExcel(filepath,"LoginTestData",0,0,excelvalues.getCellValue(excelvalues.getSheet( filepath,"LoginTestData"),10,2));
		//excelvalues.setCellValue(,excelvalues.getCellValue(excelvalues.getSheet( filepath,"LoginTestData"),10,2);
	}

}
