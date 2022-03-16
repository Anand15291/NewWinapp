package manualTestCase;

import org.testng.annotations.Test;

import com.Common;

import base.BaseClass;

public class AR_1627 extends BaseClass {
	
	Common com  = new Common();
	
	@Test
	
	public void VerifyPrintOption ( ) throws Exception {
		
		logger = BaseClass.exreporter.createTest("AR_1627");
		com.LunchApp("D:\\CK4_422\\Print");
		com.VerifyPrintOption();
		com.closeApplication();
		logger.pass("test case Pass");
	}

}
