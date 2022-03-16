package manualTestCase;

import org.testng.annotations.Test;

import com.Common;

import base.BaseClass;

public class AR_925 extends BaseClass{
	
	Common com = new Common();

	@SuppressWarnings("static-access")
	@Test
	public void defaultWorksapceValidation() throws Exception {
		logger = BaseClass.exreporter.createTest("AR_925");
		com.LunchAppWithoutRandom("D:\\compose4ksar-18.1.3-win32.win32.x86_64\\Krish");
		com.closeApplication();
		com.Setup();
		String AppPath1 = "D:\\compose4ksar-18.1.3-win32.win32.x86_64\\Krish";
		com.validateDefaultWorkspacePath(AppPath1);

	}
}
