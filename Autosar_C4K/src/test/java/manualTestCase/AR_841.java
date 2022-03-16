package manualTestCase;

import org.testng.annotations.Test;

import com.Common;

import base.BaseClass;

public class AR_841 extends BaseClass{
	
Common com = new Common();
	
	@Test
	public void cheatSheetOpenC4KValidation() throws Exception {
		logger = BaseClass.exreporter.createTest("AR_841");
		com.LunchApp("D:\\compose4ksar-16.5.4-win32.win32.x86_64\\AR841");
		com.cheatSheetOpenC4K("cheat sheet");
	}

}
