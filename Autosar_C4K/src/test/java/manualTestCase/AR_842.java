package manualTestCase;

import org.testng.annotations.Test;

import com.Common;

import base.BaseClass;

public class AR_842 extends BaseClass{
	
	
Common com = new Common();
	
	@Test
	public void cheatSheetTaskValidation() throws Exception {
		logger = BaseClass.exreporter.createTest("AR_842");
		com.LunchApp("D:\\compose4ksar-16.5.4-win32.win32.x86_64\\AR842");
		com.cheatSheetTask();
		com.closeApplication();
		logger.pass("Closed The Application Successfully");
	}

}
