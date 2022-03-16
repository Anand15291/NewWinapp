package manualTestCase;

import org.testng.annotations.Test;

import com.Common;

import base.BaseClass;

public class AR_1207 extends BaseClass {

	Common com = new Common();

	@Test
	public void addModuleDefFileBswmdValidation() throws Exception {
		logger = BaseClass.exreporter.createTest("AR_1027");
		com.LunchApp("D:\\compose4ksar-18.1.3-win32.win32.x86_64\\AR1027");
		String Project = com.CreateProjectOnNewTool("AR1207");
		System.out.println("---->   " + Project);
		com.addModuleDefinationFilesBswmd("AR1207");
		com.closeApplication();
	}
}
