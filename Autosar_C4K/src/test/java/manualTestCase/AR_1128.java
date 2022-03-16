package manualTestCase;

import org.testng.annotations.Test;

import com.Common;

import base.BaseClass;

public class AR_1128 extends BaseClass{
	
	Common com = new Common();
	
	@Test
	public void integrator_BSWMD_MergeFiles() throws Exception {
		
		logger = BaseClass.exreporter.createTest("AR_1128");
		com.LunchApp("D:\\compose4ksar-18.2.1-win32.win32.x86_64\\AR1128");
		String Project = com.CreateProjectOnNewToolAndNewFolder("AR1128", "integrator_bswmd");
		System.out.println("---->   " + Project);
		com.Upload_Bswmd_File(Project);
		com.closeApplication();
		
	}

}
