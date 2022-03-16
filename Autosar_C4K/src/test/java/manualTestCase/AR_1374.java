package manualTestCase;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.testng.annotations.Test;

import com.Common;

import base.BaseClass;

public class AR_1374 extends BaseClass{
	
	Common com = new Common();
		
		@Test
		public void copyPasteResource() throws Exception {
			logger = BaseClass.exreporter.createTest("copyPasteResource");
			com.LunchApp("D:\\compose4ksar-18.1.3-win32.win32.x86_64\\AR1374");
			String filelocation = System.getProperty("user.dir")+File.separator+"ImportProject"+File.separator+"Common_GUI_Requirements";
			System.out.println("---------->      "+filelocation);
			com.ImportProject(filelocation);
			logger.pass("Existing Project Imported");
			
			
			  String filelocationfrom = System.getProperty("user.dir")+File.separator+"ImportProject"+File.separator+"Common_GUI_Requirements"+File.separator+"EcucDescription.arxml"; 
			  String filelocationto = System.getProperty("user.dir")+File.separator+"ImportProject" +File.separator+"EcucDescription4.arxml";
			  System.out.println(filelocationfrom); 
			  System.out.println(filelocationto);
			  Path fromFile = Paths.get(filelocationfrom); 
			  Path toFile = Paths.get(filelocationto); 
			  System.out.println(fromFile);
			  System.out.println(toFile); 
			  Files.copy(fromFile, toFile);
			  logger.pass("File copied to the local filesystem");
			  
			  File myObj = new File(filelocationto); 
			    if (myObj.delete()) { 
			      System.out.println("Deleted the file: " + myObj.getName());
			      logger.pass("Deleted the file from local filesystem");
			    } else {
			      System.out.println("Failed to delete the file.");
			      logger.pass("Failed to delete the file.");
			    }
			    
			  com.closeApplication();
			  
			 

			 


}
}
