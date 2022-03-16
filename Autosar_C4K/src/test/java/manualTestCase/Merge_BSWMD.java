package manualTestCase;

import java.io.File;

import org.testng.annotations.Test;

import com.Common;

import base.BaseClass;

public class Merge_BSWMD extends BaseClass {

	Common com = new Common();

	@Test

	public void VerifyCanObjectAdd() throws Exception {
		logger = BaseClass.exreporter.createTest("AR-1633");
		com.LunchApp("D:\\compose4ksar-18.1.3-win32.win32.x86_64\\AR1633");
		logger.debug("Debug this path for chrome path issue");
		com.CreateProjectOnNewTool("AR1633");

		String ProjPath = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator + "AR1633";
		com.ImportArxmlFile("AR1633", ProjPath);
		com.closeApplication();
	}

	@Test
	public void VerifyIntegratorBswmd() throws Exception {

		logger = BaseClass.exreporter.createTest("AR-1647");
		com.LunchApp("D:\\compose4ksar-18.1.3-win32.win32.x86_64\\AR1147");
		
		com.NewCreateProjectAndNewFolderBswmd("AR1147", "integrator_bswmd");
		com.propertiesEnabledVerificationBswmd("AR1147");
		com.closeApplication();
	}
}
