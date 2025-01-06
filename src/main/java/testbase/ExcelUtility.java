package testbase;


import java.io.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;


public class ExcelUtility {
	
	public FileInputStream fileInput;
	public FileOutputStream fileOutput;	
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	public XSSFCellStyle cellstyle;
	public String path;
	
	public ExcelUtility(String path) {
		this.path=path;
	}
	
	public int getRowCount(String sheetname) throws Exception {
		fileInput=new FileInputStream(path);
		workbook=new XSSFWorkbook(fileInput);
		sheet=workbook.getSheet(sheetname);
		int rowCount=sheet.getLastRowNum();
		workbook.close();
		fileInput.close();
		return rowCount;
		
	}
	
public int getCellCount(String sheetname,int rownum) throws Exception {
	fileInput=new FileInputStream(path);
	workbook=new XSSFWorkbook(fileInput);
	sheet=workbook.getSheet(sheetname);
	row=sheet.getRow(rownum);
	int cellNum=row.getLastCellNum();
	workbook.close();
	fileInput.close();
	return cellNum;
	}



public String getCellData(String sheetname,int rownum,int cellnum) throws Exception {
	fileInput=new FileInputStream(path);
	workbook=new XSSFWorkbook(fileInput);
	sheet=workbook.getSheet(sheetname);
	row=sheet.getRow(rownum);
	 cell=row.getCell(cellnum);
	 
	 
	 DataFormatter formatter=new DataFormatter();
	 
	 String data;
	 
	 try {
		data=formatter.formatCellValue(cell);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		data="";
	}
	 workbook.close();
		fileInput.close();
	return data;
	}
	

	public void setCellData(String sheetname,int rownum,int cellnum,String data) throws Exception {
		File xfile=new File(path);
		
		if (!xfile.exists()) {
			workbook=new XSSFWorkbook();
			fileOutput=new FileOutputStream(path);
			workbook.write(fileOutput);
		}
		fileInput=new FileInputStream(path);
		workbook=new XSSFWorkbook(fileInput);
		
		if (workbook.getSheetIndex(sheetname)==-1) {
			workbook.createSheet(sheetname);
		}
		sheet=workbook.getSheet(sheetname);
		if (sheet.getRow(rownum)==null) {
			sheet.createRow(rownum);
		}
		row=sheet.getRow(rownum);
		
		cell=row.createCell(cellnum);
		cell.setCellValue(data);
		fileOutput=new FileOutputStream(path);
		workbook.write(fileOutput);
		workbook.close();
		fileInput.close();
		fileOutput.close();
	}
	
	
	public void fillGreenColor(String sheetname,int rownum,int colnum) throws Exception {
		fileInput=new FileInputStream(path);
		workbook=new XSSFWorkbook(fileInput);
		sheet=workbook.getSheet(sheetname);
		
		row=sheet.getRow(rownum);
		cell=row.getCell(colnum);
		
		cellstyle=workbook.createCellStyle();
		
		cellstyle.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		cellstyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		cell.setCellStyle(cellstyle);
		workbook.write(fileOutput);
		workbook.close();
		fileInput.close();
		fileOutput.close();
		
	}
	
	
	public void fillRedColor(String sheetname,int rownum,int colnum) throws Exception {
		fileInput=new FileInputStream(path);
		workbook=new XSSFWorkbook(fileInput);
		sheet=workbook.getSheet(sheetname);
		
		row=sheet.getRow(rownum);
		cell=row.getCell(colnum);
		
		cellstyle=workbook.createCellStyle();
		
		cellstyle.setFillForegroundColor(IndexedColors.RED.getIndex());
		cellstyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		cell.setCellStyle(cellstyle);
		workbook.write(fileOutput);
		workbook.close();
		fileInput.close();
		fileOutput.close();
		
	}
}
