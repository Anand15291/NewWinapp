package manualTestCase;

import org.testng.annotations.Test;

import com.Common;

import base.BaseClass;

public class AR_431 extends BaseClass{

	Common com = new Common();

	@Test
	public void UploadIOPTValidation() throws Exception {
		logger = BaseClass.exreporter.createTest("AR_431");
		com.LunchApp("D:\\compose4ksar-18.1.3-win32.win32.x86_64\\AR431");
		String Project = com.CreateProjectOnNewTool("AR431");
		System.out.println("---->   " + Project);
		com.Upload_IOPT_File(Project);
		com.closeApplication();
	}
}
