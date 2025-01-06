package testutilities;

import org.testng.annotations.DataProvider;

public class Dataproviders {
	
	
	@DataProvider(name="LoginData")
	
	public String[][] getData() throws Exception{
		
		
		String path="C:\\Users\\Vaishak S Kumar\\java\\OpenCart\\TestData\\TestData.xlsx";
		
		ExcelUtility xlUtility=new ExcelUtility(path);
		
		int totalrow=xlUtility.getRowCount("Sheet1");
		int totalcell=xlUtility.getCellCount("Sheet1", 1);
		
		String loginData[][]=new String[totalrow][totalcell];
		
		for (int i = 1; i <= totalrow; i++) {
			for (int j = 0; j < totalcell; j++) {
				loginData[i-1][j]=xlUtility.getCellData("Sheet1", i	, j);
			}
		}
		
		return loginData;
		
	}

}
