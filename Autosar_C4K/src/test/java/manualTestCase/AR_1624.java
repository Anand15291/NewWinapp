package manualTestCase;

import org.testng.annotations.Test;

import com.Common;

import base.BaseClass;

public class AR_1624 extends BaseClass {
	
	Common com  = new Common();
	@Test
	
	public void Verifybookmarkdoc () throws Exception {
		
		logger = BaseClass.exreporter.createTest("AR_1624");
		com.LunchApp("D:\\CK4_422\\bookmark");
		com.VerifyBookmark();
		com.closeApplication();
		com.closeApplication();
		logger.pass("test case Pass");
	}
	

}
