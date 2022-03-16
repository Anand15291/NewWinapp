package manualTestCase;

import org.testng.annotations.Test;

import com.Common;

import base.BaseClass;

public class AR_844 extends BaseClass{
	
Common com = new Common();
	
	@Test
	public void cheatSheetTaskValidation_ResetAllTask() throws Exception {
		logger = BaseClass.exreporter.createTest("AR_844");
		com.LunchApp("D:\\compose4ksar-16.5.4-win32.win32.x86_64\\AR_844");
		com.resetAllTask();
		com.closeApplication();
	}

}
