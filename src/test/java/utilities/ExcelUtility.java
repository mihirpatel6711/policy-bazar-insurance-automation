package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



/**
 * ExcelUtility provides reusable methods to read and write data from Excel (.xlsx) files.
 * It uses Apache POI library to interact with Excel sheets and supports both reading and writing operations.
 */
public class ExcelUtility {
	
	public FileInputStream fi;
	public FileOutputStream fo;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	String path ;
	
	

	/**
	     * Constructor to initialize ExcelUtility with the file path.
	     *
	     * @param path Path to the Excel file
	     */
	public ExcelUtility (String path) {
		this.path = path;		
	}
	

	/**
	     * Returns the number of rows in the specified sheet.
	     *
	     * @param sheetName Name of the sheet
	     * @return Total number of rows (zero-based index of last row)
	     * @throws IOException if the file cannot be read
	     */	
	public int getRowCount(String sheetName) throws IOException {
		
		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();
		workbook.close();
		fi.close();		
		
		return rowCount;
		
		
	}	
	
	/**
	     * Returns the number of cells (columns) in a specific row of the sheet.
	     *
	     * @param sheetName Name of the sheet
	     * @param rownum    Row number to inspect
	     * @return Total number of cells in the row
	     * @throws IOException if the file cannot be read
	     */
	public int getCellCount(String sheetName, int rownum) throws IOException{
		
		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rownum);
		int cellcount = row.getLastCellNum();
		workbook.close();
		fi.close();	
		
		
		return cellcount;
	}
	

/**
     * Retrieves the data from a specific cell in the sheet.
     * Uses DataFormatter to return the value as a String regardless of cell type.
     *
     * @param sheetName Name of the sheet
     * @param rownum    Row number
     * @param colnum    Column number
     * @return Cell data as a String
     * @throws IOException if the file cannot be read
     */
	public String getCellData(String sheetName,int rownum,int colnum) throws IOException
	{
		fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheet(sheetName);
		row=sheet.getRow(rownum);
		cell=row.getCell(colnum);
		
		DataFormatter formatter = new DataFormatter();
		String data;
		try{
		data = formatter.formatCellValue(cell); //Returns the formatted value of a cell as a String regardless of the cell type.
		}
		catch(Exception e)
		{
			data="";
		}
		workbook.close();
		fi.close();
		return data;
	}
	
	

	/**
	     * Writes data to a specific Creates the file, sheet, row, or cell if they do not exist.
	     *
	     * @param sheetName Name of the sheet
	     * @param rownum    Row number
	     * @param colnum    Column number
	     * @param data      Data to write into the cell
	     * @throws IOException if the file cannot be written
	     */

	public void setCellData(String sheetName,int rownum,int colnum,String data) throws IOException
	{
		File xlfile=new File(path);
		
		// Create new workbook and file if it doesn't exist
		if(!xlfile.exists())    
		{
		workbook=new XSSFWorkbook();
		fo=new FileOutputStream(path);
		workbook.write(fo);
		}
		
				
		fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(fi);
			
		// Create sheet if it doesn't exist
		if(workbook.getSheetIndex(sheetName)==-1) 
			workbook.createSheet(sheetName);
		sheet=workbook.getSheet(sheetName);
					
		// Create row if it doesn't exist
		if(sheet.getRow(rownum)==null)   
				sheet.createRow(rownum);
		row=sheet.getRow(rownum);
		
		// Create and set cell value
		cell=row.createCell(colnum);
		cell.setCellValue(data);
		
		// Write changes to file
		fo=new FileOutputStream(path);
		workbook.write(fo);	
		

		// Close resources

		workbook.close();
		fi.close();
		fo.close();
	}
	
	
	
	
	
	
	
	
	


}
