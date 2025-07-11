package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	
	//usage => @Test(dataProvider="TravelInsurance",dataProviderClass=DataProviders.class)
	
	
	@DataProvider(name = "TravelInsurance")
	public String[][] getTravelInsuranceData() throws IOException{
		
		String path=".\\testData\\PolicyBazar_TravelInsuranceData.xlsx";//taking xl file from testData
		ExcelUtility xlutil = new ExcelUtility (path);
		
		int totalrows = xlutil.getRowCount("Sheet1");
		int totalcols = xlutil.getCellCount(path, totalrows);
		
		String travelInsuranceData[][] = new String [totalrows][totalcols];
		
		for (int i=1;i<= totalrows;i++) {
			for (int j=0; j<totalcols; j++) {
				travelInsuranceData[i-1][j] = xlutil.getCellData("Sheet1",i,j);
				
				
			}
		}
		return travelInsuranceData;		
		
		
	}
	
	@DataProvider(name = "CarInsurance")
	public String[][] getCarInsuranceData() throws IOException{
		
		String path=".\\testData\\PolicyBazar_CarInsuranceData.xlsx";//taking xl file from testData
		ExcelUtility xlutil = new ExcelUtility (path);
		
		int totalrows = xlutil.getRowCount("Sheet1");
		int totalcols = xlutil.getCellCount(path, totalrows);
		
		String carInsuranceData[][] = new String [totalrows][totalcols];
		
		for (int i=1;i<= totalrows;i++) {
			for (int j=0; j<totalcols; j++) {
				carInsuranceData[i-1][j] = xlutil.getCellData("Sheet1",i,j);
				
				
			}
		}
		return carInsuranceData;
		
		
	}
	
	
	
	
	

}
