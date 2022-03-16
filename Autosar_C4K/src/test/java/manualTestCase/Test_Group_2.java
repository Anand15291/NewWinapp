package manualTestCase;

import java.io.File;

import org.testng.annotations.Test;

import com.Common;

import base.BaseClass;

public class Test_Group_2 extends BaseClass{
	
	Common com  = new Common();
	
	@Test (priority=10, alwaysRun = true)
	
	public void Verifybookmarkdoc () throws Exception {
		
		logger = BaseClass.exreporter.createTest("AR_1624");
		com.LunchApp("D:\\CK4_422\\bookmark");
		com.VerifyBookmark();
		com.closeApplication();
		com.closeApplication();
		logger.pass("test case Pass");
	}
	
	
	@Test (priority=9, alwaysRun = true)
	
	public void checkNavigation () throws Exception {
		
		logger = BaseClass.exreporter.createTest("AR_1625");
		com.LunchApp("D:\\CK4_422\\navi");
		com.navigateToLink();
		com.closeApplication();
		logger.pass("test case Pass");
	}
	
	
	@Test(priority=8, alwaysRun = true)
	
	public void CheckSearchedResult () throws Exception {
		
		logger = BaseClass.exreporter.createTest("AR_1626");
		com.LunchApp("D:\\CK4_422\\search");
		String value = "Creating a Java class";
		com.SearchedContent(value);
		com.closeApplication();
		logger.pass("test case Pass");
	}
	
	
@Test (priority=7, alwaysRun = true)
	
	public void VerifyPrintOption ( ) throws Exception {
		
		logger = BaseClass.exreporter.createTest("AR_1627");
		com.LunchApp("D:\\CK4_422\\Print");
		com.VerifyPrintOption();
		com.closeApplication();
		com.closeApplication();
		logger.pass("test case Pass");
	}


@Test(priority=6, alwaysRun = true)

public void VerifyNextSection ( ) throws Exception {
	
	logger = BaseClass.exreporter.createTest("AR_1628");
	com.LunchApp("D:\\CK4_422\\Next");
	com.VerifyNextLink();
	//com.closeApplication();
	logger.pass("VerifyNextSection test case Pass");
}


@Test (priority=5, alwaysRun = true)

public void VerifyNextSection_ConentGroup ( ) throws Exception {
	
	logger = BaseClass.exreporter.createTest("AR_1629");
	com.LunchApp("D:\\CK4_422\\Next");
	com.VerifyHelpContentGroup();
	com.closeApplication();
	com.closeApplication();
	logger.pass("test case Pass");
}


//@Test (priority=1, alwaysRun = false)
//public void UploadIOPTValidation() throws Exception {
//	logger = BaseClass.exreporter.createTest("AR_431");
//	com.LunchApp("D:\\compose4ksar-18.1.3-win32.win32.x86_64\\AR431");
//	String Project = com.CreateProjectOnNewTool("AR431");
//	System.out.println("---->   " + Project);
//	com.Upload_IOPT_File(Project);
//	com.closeApplication();
//}


@Test (priority=4, alwaysRun = true)
public  void VerifyTip () throws Exception {
	
	logger = BaseClass.exreporter.createTest("AR-792");
	com.LunchApp("D:\\CK4_422\\tooltips");
	 String filelocation = System.getProperty("user.dir")+File.separator+"ImportProject"+File.separator+"Tip";
	 System.out.println("---------->      "+filelocation);
	com.ImportProject(filelocation);
	//Thread.sleep(20000);
	com.VerifyToolTip("InternalTriggerOccurredEvent", "Sample");
	com.closeApplication();
	logger.pass("test case Pass");
}


@Test (priority=3, alwaysRun = true)
public void Verifycolumn() throws Exception {
	
	logger = BaseClass.exreporter.createTest("AR-794");
	com.LunchApp("D:\\CK4_422\\column");
	String filelocation = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator
			+ "tooltips";
	System.out.println("---------->      " + filelocation);
	com.ImportProject(filelocation);
	String project = "Sample";
	com.VerifyDisplayOnRte(project);
	com.closeApplication();
	logger.pass("test case Pass");
}


@Test (priority=2, alwaysRun = true)
public void showInSystemExplorerOptionValidation() throws Exception {
	logger = BaseClass.exreporter.createTest("AR_796");
	com.LunchApp("D:\\compose4ksar-18.1.3-win32.win32.x86_64\\AR796");
	com.showInSystemExplorerOptionValidations();
	com.closeApplication();
}

}
