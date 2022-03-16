package manualTestCase;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;

import com.Utility;

public class Test {
	Utility ut = new Utility();

	public static void main(String[] args) throws Exception {

		String fileName = "D:\\24thDecR431ReleaseBuild\\c4k.cmd";
		File file = new File(fileName);
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String line;
		String[] data;
		Map<Integer, String> map = new HashedMap();
		int i = 1;
		while ((line = br.readLine()) != null) {
			// process the line
			// System.out.println(line);
			 String[] lines = line.split("\\r?\\n");
			  for (String line1 : lines) {
			          //  System.out.println(line1+" =-=-=->  ");
			            if(line1.contains("Dorg.osgi.framework.os.name=win32")) {
			            	map.put(i, line1);
			            }
			        }
		
//		boolean flag =	 line.contains("Dorg.osgi.framework.os.name=win32");
//		System.out.println(flag+" - - -= -= -> ");
	}
		System.out.println(map);
	}

}
