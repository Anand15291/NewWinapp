package manualTestCase;

import java.io.File;

import org.testng.annotations.Test;

import com.Common;

import base.BaseClass;

public class AR_1054 extends BaseClass{
	Common com = new Common();
	@Test
	
	public void Export_SCW () throws Exception {
		logger = BaseClass.exreporter.createTest("AR_1054");
		com.LunchApp("D:\\workspace\\AR1054");
		String Project_Loc = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator
				+ "SWC_Export";
		System.out.println("======>   "+Project_Loc);
		com.ImportProject(Project_Loc);
		com.exportSWC("SWC_Export");
		com.closeApplication();
		logger.pass("test case Pass");
	}
	

}
