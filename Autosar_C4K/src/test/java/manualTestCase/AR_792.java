package manualTestCase;


import java.io.File;


import org.testng.annotations.Test;

import com.Common;

import base.BaseClass;

public class AR_792 extends BaseClass {
	
	public Common com = new Common();
@Test
	public  void VerifyTip () throws Exception {
		
		logger = BaseClass.exreporter.createTest("AR-792");
		com.LunchApp("D:\\CK4_422\\tooltips");
		 String filelocation = System.getProperty("user.dir")+File.separator+"ImportProject"+File.separator+"Tip";
		 System.out.println("---------->      "+filelocation);
		com.ImportProject(filelocation);
		//Thread.sleep(20000);
		com.VerifyToolTip("InternalTriggerOccurredEvent", "Sample");
		com.closeApplication();
		logger.pass("test case Pass");
	}
	
}
