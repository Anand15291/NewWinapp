package manualTestCase;

import java.io.File;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import com.Common;

import base.BaseClass;

public class AR_811 extends BaseClass {

	Common com = new Common();
	
	@Test
	
	public void VerifyDelete() throws Exception {
		logger = BaseClass.exreporter.createTest("AR_811");
		String value = RandomStringUtils.randomAlphabetic(8);
		System.out.println(value);
		com.LunchApp("D:\\CK4_422\\"+value);
		String Projectlocation = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator+"811";
		System.out.println(Projectlocation);
		com.ImportProject(Projectlocation);
		com.VerifyDeleteonHTMLFile("delete");
		String reportpath = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator+"ECUCReport"+File.separator+"DeleteECUCReport";
		com.VerifyDeletedOnEcuc(reportpath);
		com.closeApplication();
		logger.pass("test case Pass");
	}
}
