package manualTestCase;

import java.io.File;

import org.testng.annotations.Test;

import com.Common;

import base.BaseClass;

public class AR_794 extends BaseClass {
	
	Common com = new Common();
	@Test
	public void Verifycolumn() throws Exception {
		
		logger = BaseClass.exreporter.createTest("AR-794");
		com.LunchApp("D:\\CK4_422\\column");
		String filelocation = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator
				+ "tooltips";
		System.out.println("---------->      " + filelocation);
		com.ImportProject(filelocation);
		String project = "Sample";
		com.VerifyDisplayOnRte(project);
		com.closeApplication();
		logger.pass("test case Pass");
	}
	

}
