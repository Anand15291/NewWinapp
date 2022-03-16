package manualTestCase;

import org.testng.annotations.Test;

import com.Common;

import base.BaseClass;

public class AR_847 extends BaseClass {
	
	Common com = new Common();
	@Test
	public void VerifySkip() throws Exception {
		
		logger = BaseClass.exreporter.createTest("AR_847");
		com.LunchApp("D:\\CK4_422\\AR847");
		com.VerifyCheatSheetSkip();
		com.closeApplication();
		logger.pass("test case Pass");
	}

}
