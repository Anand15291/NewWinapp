package manualTestCase;

import org.testng.annotations.Test;

import com.Common;

import base.BaseClass;

public class AR_843 extends BaseClass{
	
Common com = new Common();
	
	@Test
	public void cheatSheetTaskValidation_Skip() throws Exception {
		logger = BaseClass.exreporter.createTest("AR_843");
		com.LunchApp("D:\\compose4ksar-16.5.4-win32.win32.x86_64\\AR_843");
		com.cheatSheetTaskSkipandNext();
		com.closeApplication();
	}

}
