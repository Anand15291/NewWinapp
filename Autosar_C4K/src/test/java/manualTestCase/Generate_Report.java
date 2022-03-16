package manualTestCase;

import java.io.File;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import com.Common;

import base.BaseClass;

public class Generate_Report extends BaseClass{
	
	Common com = new Common();
	
	@Test
	
	public void VerifyReport() throws Exception {
		logger = BaseClass.exreporter.createTest("AR-805");
		String project = RandomStringUtils.randomAlphabetic(5);
		System.out.println(project);
		com.LunchApp("D:\\workspace\\");
		com.CreateProjectOnNewTool(project);
		String filepath = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator+"AR_867";
		String filename = "Test.arxml";
		com.ImportArxmlFile(project, filename, filepath);
		com.VerifyGenerateCode(project,filename);
		com.closeApplication();
	}

}
