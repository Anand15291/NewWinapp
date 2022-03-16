package manualTestCase;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;

public class Readtxt {
	
	

	    public static void main(String[] args) throws IOException {
	        String file = "D:\\workspace\\cbb\\chkjg\\Copy of Test.arxml";
	        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
	        Map< Integer, String>map = new HashedMap();
	        String curLine;
	        int i=1;
	        while ((curLine = bufferedReader.readLine()) != null){
	            //process the line as required
	            System.out.println(curLine);
	           String [] data = curLine.split("\\r?\\n|\\r");
	           System.out.println(data[0]);
	           String value = data[0];
	           System.out.println(curLine.split("\\r?\\n|\\r")+" =====>  ");
	        	   
	        	   map.put(i, value);
	        	   i++;
	           }
	        String file1 = "D:\\workspace\\cbb\\chkjg\\Test.arxml";
	        BufferedReader bufferedReader1 = new BufferedReader(new FileReader(file1));
	        Map< Integer, String>map1 = new HashedMap();
	        String curLine1;
	        int i1=1;
	        while ((curLine1 = bufferedReader1.readLine()) != null){
	            //process the line as required
	            System.out.println(curLine1);
	           String [] data = curLine1.split("\\r?\\n|\\r");
	           System.out.println(data[0]);
	           String value1 = data[0];
	           System.out.println(curLine1.split("\\r?\\n|\\r")+" =====>  ");
	        	   
	        	   map1.put(i1, value1);
	        	   i1++;
	           }
	        
	        System.out.println(map1.size());
	        System.out.println(map.size());
	        System.out.println((map1.get(821)));
	        System.out.println((map1.get(824)));
	        System.out.println((map1.get(828)));
	        System.out.println((map1.get(832)));
	        System.out.println((map1.get(836)));
	        System.out.println(map.get(821).equals(map1.get(821)));
	        System.out.println(map.get(824).equals(map1.get(824)));
	        System.out.println(map.get(828).equals(map1.get(828)));
	        System.out.println(map.get(832).equals(map1.get(832)));
	        System.out.println(map.get(836).equals(map1.get(836)));
	        
	        bufferedReader.close();
	    
	    }   	
	    	
	    
	}


