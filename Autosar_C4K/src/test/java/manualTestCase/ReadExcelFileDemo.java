package manualTestCase;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadExcelFileDemo {
	public static void main(String[] args) throws IOException{
		//Validation_Report123
		String path = "D:\\Orginal_Automation\\winappdriver_automation\\Autosar_C4K\\ImportProject\\ExportValidation_Project\\R9ILBon.xls";
		 File file =    new File(path);
		 
	        //Create an object of FileInputStream class to read excel file
	        FileInputStream inputStream = new FileInputStream(file);
	 
	        //creating workbook instance that refers to .xls file
	        HSSFWorkbook wb=new HSSFWorkbook(inputStream);
	 
	        //creating a Sheet object
	        HSSFSheet sheet=wb.getSheet("Validation Error Report");
	        Map<Integer, String> map = new HashMap<Integer, String>();
	        //get all rows in the sheet
	        int rowCount=sheet.getLastRowNum()-sheet.getFirstRowNum();
	        System.out.println("----->    "+rowCount);
	        //iterate over all the row to print the data present in each cell.
	        for(int i=1;i<=rowCount;i++){
	            
	            //get cell count in a row
	            int cellcount=sheet.getRow(i).getLastCellNum();
	            
	            //iterate over each cell to print its value
	            //System.out.println("Row"+ i+" data is :");
	            
//	            for(int j=0;j<cellcount;j++){
//	                System.out.print(sheet.getRow(i).getCell(j).getStringCellValue() +",");
//	            }
	           String array =  sheet.getRow(i).getCell(0).getStringCellValue();
//	            System.out.println(array+"    --------->");
//	            System.out.println(sheet.getRow(i).getCell(0).getStringCellValue());
	          String [] arr =  array.split(": ", 2);
	          //System.out.println(arr[0]+"   ==================>");
	          String values = arr[0];
	          map.put(i, values);
	          //System.out.println(map+" 11111111111  ===> ");
	          System.out.println(map.get(i)+"    iiiiiiii   ");
	          System.out.println(map.get(517)+"    uuuuuuuuuuu   ");
		}
	     
	        
	}
}