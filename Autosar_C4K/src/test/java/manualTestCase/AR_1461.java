package manualTestCase;

import java.io.File;

import org.testng.annotations.Test;

import com.Common;

import base.BaseClass;

public class AR_1461 extends BaseClass {
	
	Common com = new Common();
	@Test
	
	public void ComSignalEndianness () throws Exception {
		
		logger = BaseClass.exreporter.createTest("AR_1461");
		com.LunchApp("D:\\CK4_422\\NewIndian");
		String Project = com.CreateProjectOnNewTool("LittleIndian");
		System.out.println("---->   " + Project);
		String LDFpath = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator+"LDF";
		System.out.println("ldf path  --->  "+LDFpath);
		com.ImportLDFFile("LittleIndian", LDFpath);
		System.out.println("Verify Step ---------> ");
		com.VerifyComSignalEndianess("LittleIndian");
		com.closeApplication();
		logger.pass("test case Pass");
	}
	

}
