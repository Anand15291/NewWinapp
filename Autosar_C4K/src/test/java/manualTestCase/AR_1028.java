package manualTestCase;

import org.testng.annotations.Test;

import com.Common;

import base.BaseClass;

public class AR_1028 extends BaseClass{
	
	
	Common com = new Common();

	@Test
	public void showInSystemExplorerECUFile() throws Exception {
		logger = BaseClass.exreporter.createTest("AR_1028");
		com.LunchApp("D:\\compose4ksar-18.1.3-win32.win32.x86_64\\AR1028");
		com.CreateProjectOnNewTool("AR1028");
		System.out.println("---->   " + "AR1028");
		com.Upload_ECU_File("AR1028");
		com.closeApplication();
	}

}
