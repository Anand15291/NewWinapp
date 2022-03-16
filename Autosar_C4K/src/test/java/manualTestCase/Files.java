package manualTestCase;

import java.io.File;
import java.io.FilenameFilter;

import org.apache.commons.digester.plugins.strategies.FinderFromFile;

public class Files {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//FilesnamesOnDir("C:\\Users\\sandeepa8\\Desktop\\Santi_Payslip\\201_Crc");
		boolean flag = false;
		File file = new File("C:\\Users\\sandeepa8\\Desktop\\Santi_Payslip");
		String[] names = file.list();

		for(String name : names)
		{
			System.out.println(name);
		 if(name.contains("_Com")) {
			 flag=true;
			 
		 }
		}
	System.out.println(flag);
	}
	
//	public static String FilesnamesOnDir (String path) {
//		String filename="";
//        try {
//            File f = new File(path);
//
//            FilenameFilter filter = new FilenameFilter() {
//                public boolean accept(File f, String name) {
//                    // We want to find only .c files
//                    return name.endsWith(".txt");
//                }
//            };
//
//            // Note that this time we are using a File class as an array,
//            // instead of String
//            File[] files = f.listFiles(filter);
//
//            // Get the names of the files by using the .getName() method
//            for (int i = 0; i < files.length; i++) {
//                System.out.println(files[i].getName());
//                 filename = files[i].getName();
//            }
//        } catch (Exception e) {
//            System.err.println(e.getMessage());
//        }
//        return filename;
//        		
//	}

}
