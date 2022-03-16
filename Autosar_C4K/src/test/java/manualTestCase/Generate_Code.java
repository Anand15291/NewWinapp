package manualTestCase;


import java.io.File;

import org.testng.annotations.Test;

import com.Common;

import base.BaseClass;

public class Generate_Code extends BaseClass {
	
	Common com = new Common();
	
	@Test
	
	public void RetainingManualfile() throws Exception {
	logger = BaseClass.exreporter.createTest("AR-1015");
	com.LunchApp("D:\\workspace\\");
	String ProjPath = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator+"BSW";
	com.ImportProject(ProjPath);
	
	com.GenerateCodes("KEIHIN_421","gvg");
	com.closeApplication();
	}
//	@Test
//	public void TestGeneratecode() throws Exception {
//		logger = BaseClass.exreporter.createTest("Test1");
//		com.LunchApp("D:\\workspace\\");
//		String ProjPath = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator+"GenerateCode";
//		com.ImportProject(ProjPath);
//		
		//com.GenerateCodes("BSW");
//		com.closeApplication();
//		}
	@Test
	public void RetainingManualfilefromlocaldrive() throws Exception {
		logger = BaseClass.exreporter.createTest("AR-1016");
		com.LunchApp("D:\\workspace\\");
		String ProjPath = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator+"BSW";
		com.ImportProject(ProjPath);
		
		//com.GenerateCodes("KEIHIN_421");
		com.closeApplication();
	}
}
