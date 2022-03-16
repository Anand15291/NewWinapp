package manualTestCase;

import java.io.File;

import org.testng.annotations.Test;

import com.Common;

import base.BaseClass;

public class AR_1639 extends BaseClass {
	
	Common com = new Common();
	@Test
	
	public void VerifyECUCExtracrt() throws Exception {
		
		logger = BaseClass.exreporter.createTest("AR-1639");
		com.LunchApp("D:\\workspace\\");
		com.CreateProjectOnNewTool("testProject");
		String filePath = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator+"AR1639";
		System.out.println(filePath);
		com.VerifyECUCExtarctDBCFile("testProject",filePath);
		com.closeApplication();
	}

}
