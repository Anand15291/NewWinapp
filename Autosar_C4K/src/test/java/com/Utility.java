package com;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.apache.commons.collections.map.HashedMap;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

@SuppressWarnings("unused")
public class Utility {

	public Map<Integer, String> ReadTXTfile(String path) throws IOException {

		String file = path;
		BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
		@SuppressWarnings("unchecked")
		Map<Integer, String> map = new HashedMap();
		String curLine;
		int i = 1;
		while ((curLine = bufferedReader.readLine()) != null) {
			// process the line as required
			// System.out.println(curLine);
			String[] data = curLine.split(": ");
			// System.out.println(data[0]);
			String value = data[0];
			if (value.contains("Severity and Description")) {

				System.out.println("no need to add in map");
			} else {

				map.put(i, value);
				i++;
			}
		}

		bufferedReader.close();
		return map;
	}

	public Map<Integer, String> Readexcel(String filepath) throws IOException {

		String path = filepath;
		File file = new File(path);

		// Create an object of FileInputStream class to read excel file
		FileInputStream inputStream = new FileInputStream(file);

		// creating workbook instance that refers to .xls file
		@SuppressWarnings("resource")
		HSSFWorkbook wb = new HSSFWorkbook(inputStream);

		// creating a Sheet object
		HSSFSheet sheet = wb.getSheet("Validation Error Report");
		Map<Integer, String> map = new HashMap<Integer, String>();
		// get all rows in the sheet
		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
		System.out.println("----->    " + rowCount);
		// iterate over all the row to print the data present in each cell.
		for (int i = 1; i <= rowCount; i++) {

			// get cell count in a row
			int cellcount = sheet.getRow(i).getLastCellNum();

			String array = sheet.getRow(i).getCell(0).getStringCellValue();

			String[] arr = array.split(": ", 2);
			System.out.println(arr[0] + "   ==================>");
			String values = arr[0];
			map.put(i, values);
			System.out.println(map + " 11111111111  ===> ");
		}
		System.out.println(map.size() + " =-=> dsvc ");
		return map;
	}

	public int listRunningProcesses() {
		List<String> pro = new ArrayList<String>();
		// static int i = 0;
		List<String> processes = new ArrayList<String>();
		int count = 0;
		try {
			String line;
			java.lang.Process p = Runtime.getRuntime().exec("tasklist.exe /nh");
			BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
			while ((line = input.readLine()) != null) {
				if (!line.trim().equals("")) {
					processes.add(line.substring(0, line.indexOf(" ")));
				}

			}
			input.close();
		} catch (Exception err) {
			err.printStackTrace();
		}

		String result = "";
		String vaue = "";
		for (int i = 0; i <= processes.size() - 1; i++) {
			vaue = processes.get(i);
			if (vaue.equalsIgnoreCase("compose.exe")) {
				count++;
			}
		}

		return count;
	}

	public String FilesnamesOnDir(String path) {
		String filename = "";
		try {
			File f = new File(path);

			FilenameFilter filter = new FilenameFilter() {
				public boolean accept(File f, String name) {
					// We want to find only .c files
					return name.endsWith(".html");
				}
			};

			// Note that this time we are using a File class as an array,
			// instead of String
			File[] files = f.listFiles(filter);


			// Get the names of the files by using the .getName() method
			for (int i = 0; i < files.length; i++) {
				System.out.println(files[i].getName());
				filename = files[i].getName();
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return filename;
	}
		public String FilesnamesOnDir (String path,final String fileextension) {
			String filename="";
	        try {
	            File f = new File(path);

	            FilenameFilter filter = new FilenameFilter() {
	                public boolean accept(File f, String name) {
	                    // We want to find only .c files
	                    return name.endsWith(fileextension);
	                }
	            };

	            // Note that this time we are using a File class as an array,
	            // instead of String
	            File[] files = f.listFiles(filter);

	            // Get the names of the files by using the .getName() method
	            for (int i = 0; i < files.length; i++) {
	                System.out.println(files[i].getName());
	                 filename = files[i].getName();
	            }
	        } catch (Exception e) {
	            System.err.println(e.getMessage());
	        }
	        return filename;
	        		

		}
		

	

	public static void ReadTXT(String Path) throws IOException {
		// File path is passed as parameter
		File file = new File(Path);

		// Note: Double backquote is to avoid compiler
		// interpret words
		// like \test as \t (ie. as a escape sequence)

		// Creating an object of BufferedReader class
		BufferedReader br = new BufferedReader(new FileReader(file));

		// Declaring a string variable
		String st;
		// Condition holds true till
		// there is character in a string
		while ((st = br.readLine()) != null)

			// Print the string
			System.out.println(st);
		String search = "C:\\Users\\soujanyap1.KPIT\\Downloads\\LDF_Input_Files\\PWL21_E1A_R1_HCP_LIN_1.ldf, C:\\Users\\soujanyap1.KPIT\\Downloads\\LDF_Input_Files\\PWL21_E1A_R1_HCP_LIN_2.ldf";
		String replacement = "C:\\Users\\sandeepa8\\Downloads\\LDF_Input_Files\\PWL21_E1A_R1_HCP_LIN_1.ldf, C:\\Users\\sandeepa8\\Downloads\\LDF_Input_Files\\PWL21_E1A_R1_HCP_LIN_2.ldf";
		st.replaceAll(search, replacement);
	}

	public static String Read(String filePath) throws IOException {

		StringBuffer fileData = new StringBuffer();
		BufferedReader reader = new BufferedReader(new FileReader(filePath));
		char[] buf = new char[1024];
		int numRead = 0;
		while ((numRead = reader.read(buf)) != -1) {
			String readData = String.valueOf(buf, 0, numRead);
			fileData.append(readData);
		}
		reader.close();
		System.out.println(fileData.toString());
		return fileData.toString();
	}

	public static void WriteOnTxt(String filePath, String oldString, String newString) throws Exception {
		StringBuffer fileData = new StringBuffer();
		BufferedReader reader = new BufferedReader(new FileReader(filePath));
		char[] buf = new char[1024];
		int numRead = 0;
		BufferedWriter wb = null;
		try {
			while ((numRead = reader.read(buf)) != -1) {
				String readData = String.valueOf(buf, 0, numRead);
				fileData.append(readData);
			}
			reader.close();
			System.out.println(fileData.toString());
			String writedata = fileData.toString();
			wb = new BufferedWriter(new FileWriter(filePath));
			String modifiedFileContent = writedata.replaceAll(oldString, newString);
			wb = new BufferedWriter(new FileWriter(filePath));

			// 9
			wb.write(modifiedFileContent);

		} catch (IOException e) {
			// handle exception
		} finally {
			// 10
			try {
				if (reader != null) {
					reader.close();
				}

				if (wb != null) {
					wb.close();
				}

			} catch (IOException e) {
				// handle exception
			}
		}
	}
	
	
	public static void getNameOfDir(String path) {
		//Creating a File object for directory
	      File directoryPath = new File(path);
	      //List of all files and directories
	      String contents[] = directoryPath.list();	
	      System.out.println(contents.length);
	      System.out.println("List of files and directories in the specified directory:");
	      for(int i=0; i<contents.length; i++) {
	         if(contents[i].contains("_BswM, _EcuC, 10_EcuM, 11_FiM,12_ComM,140_CanSM,15_Det,2_Rte,20_NvM,201_Crc,22_MemIf,60_CanIf"))
	         System.out.println("PASS");
	         
	}
}
}
	

