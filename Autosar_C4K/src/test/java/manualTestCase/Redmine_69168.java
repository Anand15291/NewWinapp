package manualTestCase;

import java.io.File;

import org.testng.annotations.Test;

import com.Common;

import base.BaseClass;

public class Redmine_69168 extends BaseClass {

	Common com = new Common();

	@Test
	
	public void VerifyDemDtrGeneration() throws Exception {

		logger = BaseClass.exreporter.createTest("AR-1796");
		com.LunchApp("D:\\workspace\\");
		String projpath = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator+"KEIHIN_421";
		com.ImportProject(projpath);
		Thread.sleep(2000);
		com.VerifyDEMModule("KEIHIN_421");

	}
}
