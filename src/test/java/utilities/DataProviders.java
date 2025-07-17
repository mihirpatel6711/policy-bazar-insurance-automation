package utilities;

import java.io.IOException;


import org.testng.annotations.DataProvider;


	/**
	 * DataProviders class supplies test data to TestNG test methods using @DataProvider annotation.
	 * It reads data from Excel files using the ExcelUtility class and returns it in a 2D array format.
	 * 
	 * Usage Example:
	 * @Test(dataProvider = "TravelInsurance", dataProviderClass = DataProviders.class)
	 */

public class DataProviders {	

	/**
	     * Provides test data for Travel Insurance test cases.
	     * Reads data from 'PolicyBazar_TravelInsuranceData.xlsx' located in the testData directory.
	     *
	     * @return A 2D String array containing travel insurance test data
	     * @throws IOException if the Excel file cannot be read
	     */
	@DataProvider(name = "TravelInsurance")
	public String[][] getTravelInsuranceData() throws IOException{
		
		//Path to the Excel file containing travel insurance test data
		String path=".\\testData\\PolicyBazar_TravelInsuranceData.xlsx";
		
		// Create an instance of ExcelUtility to interact with the Excel file
		ExcelUtility xlutil = new ExcelUtility (path);
		
		// Get the total number of rows and columns from Sheet1
		int totalrows = xlutil.getRowCount("Sheet1");
		int totalcols = xlutil.getCellCount("Sheet1", totalrows);
		
		// Initialize a 2D array to store the data
		String travelInsuranceData[][] = new String [totalrows][totalcols];
		
		// Loop through each cell and populate the array
		for (int i=1;i<= totalrows;i++) {
			for (int j=0; j<totalcols; j++) {
				travelInsuranceData[i-1][j] = xlutil.getCellData("Sheet1",i,j);
				
				
			}
		}
		// Return the populated data array to the test method
		return travelInsuranceData;		
		
		
	}
	
	

	/**
	     * Provides test data for Car Insurance test cases.
	     * Reads data from 'PolicyBazar_CarInsuranceData.xlsx' located in the testData directory.
	     *
	     * @return A 2D String array containing car insurance test data
	     * @throws IOException if the Excel file cannot be read
	     */	
	@DataProvider(name = "CarInsurance")
	public String[][] getCarInsuranceData() throws IOException{
		
		// Path to the Excel file containing car insurance test data
		String path=".\\testData\\PolicyBazar_CarInsuranceData.xlsx";
		
		// Create an instance of ExcelUtility to interact with the Excel file
		ExcelUtility xlutil = new ExcelUtility (path);
		
		// Get the total number of rows and columns from Sheet1
		int totalrows = xlutil.getRowCount("Sheet1");
		int totalcols = xlutil.getCellCount("Sheet1", totalrows);
	
		// Initialize a 2D array to store the data
		String carInsuranceData[][] = new String [totalrows][totalcols];
		
		// Loop through each cell and populate the array
		for (int i=1;i<= totalrows;i++) {
			for (int j=0; j<totalcols; j++) {
				carInsuranceData[i-1][j] = xlutil.getCellData("Sheet1",i,j);
				
				
			}
		}
		// Return the populated data array to the test method
		return carInsuranceData;
		
		
	}
	
	
	
	
	

}
