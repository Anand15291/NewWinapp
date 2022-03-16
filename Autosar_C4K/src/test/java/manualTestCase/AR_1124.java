package manualTestCase;

import org.testng.annotations.Test;

import com.Common;

import base.BaseClass;

public class AR_1124 extends BaseClass{
	
	Common com = new Common();
	
	@Test
	
	public void integrator_BSWMD() throws Exception {
		
		logger = BaseClass.exreporter.createTest("AR_1124");
		com.LunchApp("D:\\compose4ksar-18.1.3-win32.win32.x86_64\\AR1124");
		String Project = com.CreateProjectOnNewTool("AR1124");
		System.out.println("---->   " + Project);
		com.propertiesEnabledVerification("AR1124");
		com.closeApplication();
		logger.pass("Test Passed");
		
		
		
	}

}
