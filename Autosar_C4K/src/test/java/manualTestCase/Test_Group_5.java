package manualTestCase;

import org.testng.annotations.Test;

import com.Common;

import base.BaseClass;

public class Test_Group_5 extends BaseClass {

	Common com = new Common();

	//@Test (priority=10, alwaysRun = true) 
	public void VerifySkip() throws Exception {

		logger = BaseClass.exreporter.createTest("AR_847");
		com.LunchApp("D:\\workspace\\AR847");
		com.VerifyCheatSheetSkip();
		logger.pass("test case Pass");
		com.closeApplication();
	}

	@Test (priority=9, alwaysRun = true)

	public void checkNavigation() throws Exception {

		logger = BaseClass.exreporter.createTest("AR_1625");
		com.LunchApp("D:\\workspace\\navi");
		com.navigateToLink();
		logger.pass("test case Pass");
		com.closeApplication();
	}

	@Test (priority=1)
	public void launchingTwoApplicationVerification() throws Exception {
		logger = BaseClass.exreporter.createTest("AR_961");
		com.LunchAppMultipleInstance("D:\\workspace\\Krish1");
		com.closeApplication();

	}

	@Test (priority=2, alwaysRun = true)

	public void integrator_BSWMD() throws Exception {

		logger = BaseClass.exreporter.createTest("AR_1124");
		com.LunchApp("D:\\workspace\\AR1124");
		String Project = com.CreateProjectOnNewTool("AR1124");
		System.out.println("---->   " + Project);
		com.propertiesEnabledVerification("AR1124");
		logger.pass("Test Passed");
		com.closeApplication();

	}

	@Test (priority=7, alwaysRun = true)

	public void CheckSearchedResult() throws Exception {

		logger = BaseClass.exreporter.createTest("AR_1626");
		com.LunchApp("D:\\workspace\\search");
		String value = "Creating a Java class";
		com.SearchedContent(value);
		logger.pass("test case Pass");
		com.closeApplication();
	}

	@Test (priority=8, alwaysRun = true)

	public void VerifyPrintOption() throws Exception {

		logger = BaseClass.exreporter.createTest("AR_1627");
		com.LunchApp("D:\\workspace\\Print");
		com.VerifyPrintOption();
		logger.pass("test case Pass");
		com.closeApplication();
	}

	//@Test (priority=3, alwaysRun = true)
	public void showInSystemExplorerOptionValidation() throws Exception {
		logger = BaseClass.exreporter.createTest("AR_841");
		com.LunchApp("D:\\workspace");
		com.cheatSheetOpenC4K("cheat sheet");
	}

	//@Test (priority=4, alwaysRun = true)
	public void cheatSheetTaskValidation() throws Exception {
		logger = BaseClass.exreporter.createTest("AR_842");
		com.LunchApp("D:\\workspace");
		com.cheatSheetTask();
		com.closeApplication();
	}

	//@Test (priority=5, alwaysRun = true)
	public void cheatSheetTaskValidation_Skip() throws Exception {
		logger = BaseClass.exreporter.createTest("AR_843");
		com.LunchApp("D:\\workspace");
		com.cheatSheetTaskSkipandNext();
		com.closeApplication();
	}

	//@Test (priority=6, alwaysRun = true)
	public void cheatSheetTaskValidation_ResetAllTask() throws Exception {
		logger = BaseClass.exreporter.createTest("AR_844");
		com.LunchApp("D:\\workspace");
		com.resetAllTask();
		com.closeApplication();
	}

	//@Test (priority=7, alwaysRun = true)
	public void cheatSheetTaskValidation_ResetSingleTask() throws Exception {
		logger = BaseClass.exreporter.createTest("AR_845");
		com.LunchApp("D:\\workspace");
		com.resetSingleTask();
		com.closeApplication();
	}

}
