package manualTestCase;

import java.io.File;

import org.testng.annotations.Test;

import com.Common;

import base.BaseClass;

public class Export_SWC extends BaseClass {

	Common com = new Common();
	
	@Test

	public void VerifySWCfile() throws Exception {

		logger = BaseClass.exreporter.createTest("AR-1349");
		com.LunchApp("D:\\workspace\\");
		String Filepath = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator
				+ "Two_Projects";
		com.ImportProject(Filepath);
		com.exportSWC("SWC_Export");
		com.closeApplication();
	}

}
