package manualTestCase;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Common;

import base.BaseClass;

public class AR_1343 extends BaseClass {
	
	Common com =  new Common();
	
	@Test
	public void VerifytheErrorNos () throws Exception {
		
		
		logger = BaseClass.exreporter.createTest("AR_1343");
		com.LunchApp("D:\\workspace\\jgsccg");
		String filelocation = System.getProperty("user.dir")+File.separator+"ImportProject"+File.separator+"ExportValidation_Project";
		 System.out.println("---------->      "+filelocation);
		com.ImportProject(filelocation);
		String Project = "ExportValidation_Project";
		String file = com.VerifyReportName(Project,filelocation);
		int totalerrors = com.NoofErrorValidation();
		String excelpath = filelocation+File.separator+file;
		int totalerrorinsheet = com.RowinExcel(excelpath);
		Assert.assertEquals(totalerrors, totalerrorinsheet);
		com.closeApplication();
		logger.pass("test case Pass");
	}

}
