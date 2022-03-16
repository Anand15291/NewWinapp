package manualTestCase;

import org.testng.annotations.Test;

import com.Common;

import base.BaseClass;

public class AR_846 extends BaseClass {
	
	Common com = new Common();
	
	@Test
	public void StartTask() throws Exception {
		
		logger = BaseClass.exreporter.createTest("AR_846");
		com.LunchApp("D:\\CK4_422\\AR846");
		//com.VerifyStartTask();
		logger.pass("test case Pass");
	}
	
	

}
