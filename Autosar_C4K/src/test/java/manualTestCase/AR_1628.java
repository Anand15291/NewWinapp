package manualTestCase;

import org.testng.annotations.Test;

import com.Common;
import org.testng.annotations.Test;
import base.BaseClass;

public class AR_1628 extends BaseClass {

	Common com = new Common();
	

	@Test
	
	public void VerifyNextSection ( ) throws Exception {
		
		logger = BaseClass.exreporter.createTest("AR_1628");
		com.LunchApp("D:\\CK4_422\\Next");
		com.VerifyNextLink();
		com.closeApplication();
		logger.pass("test case Pass");
	}
	
	
	
	
	
	
}
