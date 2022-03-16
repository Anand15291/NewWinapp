package manualTestCase;

import org.testng.annotations.Test;

import com.Common;

import base.BaseClass;

public class AR_961 extends BaseClass{

Common com = new Common();
	
	@Test
	public void launchingTwoApplicationVerification() throws Exception {
		logger = BaseClass.exreporter.createTest("AR_961");
		com.LunchAppMultipleInstance("D:\\compose4ksar-18.1.3-win32.win32.x86_64\\Krish1");
		com.closeApplication();
		
		
	}
	
}
