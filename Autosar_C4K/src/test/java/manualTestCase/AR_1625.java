package manualTestCase;

import org.testng.annotations.Test;

import com.Common;

import base.BaseClass;

public class AR_1625 extends BaseClass {
	
	Common com = new Common();
	
	@Test
	
	public void checkNavigation () throws Exception {
		
		logger = BaseClass.exreporter.createTest("AR_1625");
		com.LunchApp("D:\\CK4_422\\navi");
		com.navigateToLink();
		com.closeApplication();
		logger.pass("test case Pass");
	}

}
