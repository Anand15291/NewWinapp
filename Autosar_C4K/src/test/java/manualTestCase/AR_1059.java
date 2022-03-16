package manualTestCase;

import org.testng.annotations.Test;

import com.Common;

import base.BaseClass;

public class AR_1059 extends BaseClass{
	
Common com = new Common();
	
	@Test
	public void exportFIleOptionValidation() throws Exception {
		logger = BaseClass.exreporter.createTest("AR_1059");
		com.LunchApp("D:\\compose4ksar-18.1.3-win32.win32.x86_64\\AR1059");
		com.exportFileContextOptionValidations();
		com.closeApplication();
	}

}
