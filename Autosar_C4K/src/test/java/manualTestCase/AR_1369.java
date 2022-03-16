package manualTestCase;

import org.testng.annotations.Test;

import com.Common;

import base.BaseClass;

public class AR_1369 extends BaseClass{
	
Common com = new Common();
	
	@Test
	public void workSpacePathVerify() throws Exception {
		logger = BaseClass.exreporter.createTest("AR_1369");
		com.LunchAppWithoutRandom("C:\\Users\\krishnad8\\c4k_workspace");
		com.validateWorkspacePath();

	}
}
