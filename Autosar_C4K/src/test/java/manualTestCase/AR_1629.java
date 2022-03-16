package manualTestCase;

import org.testng.annotations.Test;

import com.Common;

import base.BaseClass;

public class AR_1629 extends BaseClass {

	Common com = new Common();
	

	@Test
	
	public void VerifyNextSection ( ) throws Exception {
		
		logger = BaseClass.exreporter.createTest("AR_1629");
		com.LunchApp("D:\\CK4_422\\Next");
		com.VerifyHelpContentGroup();
		com.closeApplication();
		logger.pass("test case Pass");
	}
}
