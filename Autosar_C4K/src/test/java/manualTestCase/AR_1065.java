package manualTestCase;

import java.io.File;

import org.testng.annotations.Test;

import com.Common;

import base.BaseClass;

public class AR_1065 extends BaseClass {
	Common com = new Common();
	@Test
	
	public void DataMappingSignalgroup () throws Exception {
		
		logger = BaseClass.exreporter.createTest("AR_1065");
		com.LunchApp("D:\\workspace\\AR_1065");
		String ProjectLocation = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator
				+ "C4K_AutoSAR_Project";
		System.out.println("---------->      " + ProjectLocation);
		//DataMapping[Release_R_1_1_2_1_V2G]
		com.ImportProject(ProjectLocation);
		com.MappingSignalData("Release_R_1_1_2_1_V2G");
		com.closeApplication();
		logger.pass("test case Pass");

		
	}

}
