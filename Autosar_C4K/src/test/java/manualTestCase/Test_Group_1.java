package manualTestCase;

import java.io.File;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import com.Common;

import base.BaseClass;

public class Test_Group_1 extends BaseClass{
	
	Common com = new Common();
	@Test (priority=11, alwaysRun = true)
	public void EcucReport() throws Exception {
		
		logger = BaseClass.exreporter.createTest("AR_807");
		String value = RandomStringUtils.randomAlphabetic(8);
		System.out.println(value);
		com.LunchApp("D:\\CK4_422\\"+value);
		String Projectlocation = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator+"AR_807";
		//com.CreateProject("Sample");
		System.out.println(Projectlocation);
		com.ImportProject(Projectlocation);
		com.ECUCompareReport("rest");
		com.readHTMLReport();
		com.closeApplication();
		logger.pass("test case Pass");
		
	}
	
	@Test (priority=10, alwaysRun = true)
	public void VerifyIsignal() throws Exception {
		logger = BaseClass.exreporter.createTest("AR_810");
		String value = RandomStringUtils.randomAlphabetic(8);
		System.out.println(value);
		com.LunchApp("D:\\CK4_422\\"+value);
		String Projectlocation = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator+"AR_807";
		System.out.println(Projectlocation);
		com.ImportProject(Projectlocation);
		com.IsignalECUCCompare("rest");
		com.readIsignalHTMLReport();
		com.closeApplication();
		logger.pass("test case Pass");
	}
	
//@Test (priority=9, alwaysRun = true)
	
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


@Test (priority=1, alwaysRun = true,enabled = false)
public void cheatSheetOpenC4KValidation() throws Exception {
	logger = BaseClass.exreporter.createTest("AR_841");
	com.LunchApp("D:\\compose4ksar-16.5.4-win32.win32.x86_64\\AR841");
	com.cheatSheetOpenC4K("cheat sheet");
}


@Test (priority=2, alwaysRun = true,enabled = false)
public void cheatSheetTaskValidation() throws Exception {
	logger = BaseClass.exreporter.createTest("AR_842");
	com.LunchApp("D:\\workspace");
	com.cheatSheetTask();
	com.closeApplication();
}

@Test (priority=3, alwaysRun = true,enabled = false)
public void cheatSheetTaskValidation_Skip() throws Exception {
	logger = BaseClass.exreporter.createTest("AR_843");
	com.LunchApp("D:\\compose4ksar-16.5.4-win32.win32.x86_64\\AR_843");
	com.cheatSheetTaskSkipandNext();
	com.closeApplication();
}

@Test (priority=4, alwaysRun = true,enabled = false)
public void cheatSheetTaskValidation_ResetAllTask() throws Exception {
	logger = BaseClass.exreporter.createTest("AR_844");
	com.LunchApp("D:\\compose4ksar-16.5.4-win32.win32.x86_64\\AR_844");
	com.resetAllTask();
	com.closeApplication();
}


@Test (priority=5, alwaysRun = true,enabled = false)
public void cheatSheetTaskValidation_ResetSingleTask() throws Exception {
	logger = BaseClass.exreporter.createTest("AR_845");
	com.LunchApp("D:\\compose4ksar-16.5.4-win32.win32.x86_64\\AR_845");
	com.resetSingleTask();
	com.closeApplication();
}

@Test (priority=8, alwaysRun = true)
public void VerifySkip() throws Exception {
	
	logger = BaseClass.exreporter.createTest("AR_847");
	com.LunchApp("D:\\CK4_422\\AR847");
	com.VerifyCheatSheetSkip();
	com.closeApplication();
	logger.pass("test case Pass");
}


@SuppressWarnings("static-access")
@Test (priority=7, alwaysRun = true)
public void defaultWorksapceValidation() throws Exception {
	logger = BaseClass.exreporter.createTest("AR_925");
	com.LunchAppWithoutRandom("D:\\compose4ksar-18.1.3-win32.win32.x86_64\\Krish");
	com.closeApplication();
	com.Setup();
	String AppPath1 = "D:\\compose4ksar-18.1.3-win32.win32.x86_64\\Krish";
	com.validateDefaultWorkspacePath(AppPath1);

}


@Test (priority=6, alwaysRun = true)
public void launchingTwoApplicationVerification() throws Exception {
	logger = BaseClass.exreporter.createTest("AR_961");
	com.LunchAppMultipleInstance("D:\\compose4ksar-18.1.3-win32.win32.x86_64\\Krish1");
	DesktopSession.findElementByName("Cancel").click();
	
	
}

}
