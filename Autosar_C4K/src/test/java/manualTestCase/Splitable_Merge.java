package manualTestCase;

import java.io.File;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import com.Common;

import base.BaseClass;

public class Splitable_Merge extends BaseClass {

	Common com = new Common();

	@Test

	public void VerifyDisableMergefileOption() throws Exception {

		logger = BaseClass.exreporter.createTest("AR-953");
		String project = RandomStringUtils.randomAlphabetic(5);
		System.out.println(project);
		com.LunchApp("D:\\workspace\\");
		String ProjectPath = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator
				+ "MergeFiles";
		com.ImportProject(ProjectPath);
		com.MergeFileoption();
		com.closeApplication();
		logger.pass("test case Pass");
	}

	@Test

	public void VerifyMergefileOptionSinglearxmlfile() throws Exception {

		logger = BaseClass.exreporter.createTest("AR-949");
		String project = RandomStringUtils.randomAlphabetic(5);
		System.out.println(project);
		com.LunchApp("D:\\workspace\\");
		String ProjectPath = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator
				+ "MergeFiles";
		com.ImportProject(ProjectPath);
		com.SingleFileMergeOption();
		com.closeApplication();
		logger.pass("test case Pass");
	}

	@Test

	public void VerifyImportARXMLfile() throws Exception {

		logger = BaseClass.exreporter.createTest("AR-956");
		String project = RandomStringUtils.randomAlphabetic(5);
		System.out.println(project);
		com.LunchApp("D:\\workspace\\");
		com.CreateProjectOnNewTool(project);
		String filepath = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator + "AR_1014"
				+ File.separator + "Project_Redmine";
		com.ImportArxmlAndDelete(project, filepath);
		com.closeApplication();
		logger.pass("test case Pass");
	}

	@Test

	public void VerifyMergeIssueExtract() throws Exception {
		logger = BaseClass.exreporter.createTest("AR-1056");
		com.LunchApp("D:\\workspace\\");
		String ProjectPath = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator
				+ "Test";
		com.ImportProject(ProjectPath);
		String Project = "Tes";
		com.VerifyEcucOptionDisable(Project);
		com.closeApplication();
		logger.pass("test case Pass");
	}
}
