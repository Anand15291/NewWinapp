package manualTestCase;

import java.io.File;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Common;

import base.BaseClass;

public class AR_1342 extends BaseClass {
	
	 Common com = new Common();
	@Test
	
	
	public  void VerifyReport () throws Exception {
		//ExportValidation_Project
		logger = BaseClass.exreporter.createTest("Verify The Report Name");
		com.LunchApp("D:\\CK4_422\\sand");
		String filelocation = System.getProperty("user.dir")+File.separator+"ImportProject"+File.separator+"ExportValidation_Project";
		 System.out.println("---------->      "+filelocation);
		com.ImportProject(filelocation);
		String Project = "ExportValidation_Project";
		String file = com.VerifyReportName(Project,filelocation);
		com.closeApplication();
		logger.pass("test case Pass");
		
		
	}

}
