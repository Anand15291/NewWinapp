package manualTestCase;

import java.io.File;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Common;

import base.BaseClass;
import pageObject.Pageobj;

public class Test_Group_3 extends BaseClass {

	Common com = new Common();

	@Test (priority=1, alwaysRun = true)
	public void addModuleDefFileBswmdValidation() throws Exception {
		logger = BaseClass.exreporter.createTest("AR_1027");
		com.LunchApp("D:\\workspace\\");
		String Project = com.CreateProjectOnNewTool("AR1207");
		System.out.println("---->   " + Project);
		com.addModuleDefinationFilesBswmd("AR1207");
		com.closeApplication();
	}

	@SuppressWarnings("unused")
	@Test (priority=4, alwaysRun = true)

	public void VerifyReport() throws Exception {
		// ExportValidation_Project
		logger = BaseClass.exreporter.createTest("Verify The Report Name");
		com.LunchApp("D:\\workspace\\");
		String filelocation = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator
				+ "ExportValidation_Project";
		System.out.println("---------->      " + filelocation);
		com.ImportProject(filelocation);
		String Project = "ExportValidation_Project";
		String file = com.VerifyReportName(Project, filelocation);
		com.closeApplication();
		logger.pass("test case Pass");

	}

	@Test (priority=5, alwaysRun = true)
	public void VerifytheErrorNos() throws Exception {

		logger = BaseClass.exreporter.createTest("AR_1343");
		com.LunchApp("D:\\workspace\\");
		String filelocation = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator
				+ "ExportValidation_Project";
		System.out.println("---------->      " + filelocation);
		com.ImportProject(filelocation);
		String Project = "ExportValidation_Project";
		String file = com.VerifyReportName(Project, filelocation);
		int totalerrors = com.NoofErrorValidation();
		String excelpath = filelocation + File.separator + file;
		int totalerrorinsheet = com.RowinExcel(excelpath);
		Assert.assertEquals(totalerrors, totalerrorinsheet);
		com.closeApplication();
		logger.pass("test case Pass");
	}

//	@Test (priority=2, alwaysRun = true)
//	public void workSpacePathVerify() throws Exception {
//		logger = BaseClass.exreporter.createTest("AR_1369");
//		com.LunchAppWithoutRandom("D:\\workspace\\gfx");
//		com.validateWorkspacePath();

	//}

//	@SuppressWarnings("unchecked")
//	@Test (priority=3, alwaysRun = true)
//	public void pathVerificationOfApp() throws Exception {
//
//		logger = BaseClass.exreporter.createTest("AR_1381");
//		String AppPath1 = "D:\\compose4ksar-18.1.3-win32.win32.x86_64\\Krish";
//		
//		com.verifyPreviousLocation(AppPath1); 
//		Thread.sleep(2000); 
//	    Setup();
//		Thread.sleep(2000);
//		DesktopSession = Root();
//		List <WebElement> wb = DesktopSession.findElementsByClassName("Edit");
//		System.out.println(wb.size());
//		logger.pass("Verified the previous path of the Application");
//		String pathVerify1 = wb.get(1).getAttribute("Value.Value");
//		System.out.println(pathVerify1);
//		Assert.assertEquals(pathVerify1, AppPath1);
//		logger.pass("Expected Path"+ AppPath1+" "+ "Actual Path" + pathVerify1);
//		logger.pass("Verified the previous path of the Application");
//		DesktopSession.findElementByName("Cancel").click();
//		logger.pass("Second Application Instance has been launched and closed");  
//	}

	@Test

	public void IsignalIPdu_merged() throws Exception {

		logger = BaseClass.exreporter.createTest("AR_1383");
		com.LunchApp("D:\\workspace\\");
		String Project = com.CreateProjectOnNewTool("13803");
		System.out.println("--->  " + Project);
		String fistFile = "BNE_FLM_L_Boardnet.arxml";
		String secondfile = "BNE_FLM_R_Boardnet.arxml";
		com.ImportFileToProject(Project, fistFile, secondfile);
		com.Mergefiles(Project, fistFile, secondfile);
		com.closeApplication();
		logger.pass("test case Pass");

	}

	@Test (priority=6, alwaysRun = true)

	public void ComSignalEndianness() throws Exception {

		logger = BaseClass.exreporter.createTest("AR_1461");
		com.LunchApp("D:\\workspace\\");
		String Project = com.CreateProjectOnNewTool("LittleIndian");
		System.out.println("---->   " + Project);
		String LDFpath = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator + "LDF";
		System.out.println("ldf path  --->  " + LDFpath);
		com.ImportLDFFile("LittleIndian", LDFpath);
		System.out.println("Verify Step ---------> ");
		com.VerifyComSignalEndianess("LittleIndian");
		com.closeApplication();
		logger.pass("test case Pass");
	}

	@Test (priority=7, alwaysRun = true)

	public void SwBase_SignalLength() throws Exception {
		logger = BaseClass.exreporter.createTest("AR_1519");
		com.LunchApp("D:\\workspace\\");
		String Project = com.CreateProjectOnNewTool("Demo2");
		System.out.println("---->   " + Project);
		String DBCfilelocation = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator
				+ "DBC";
		System.out.println("---------->      " + DBCfilelocation);
		String setEcu = Pageobj.SetECu;
		com.Upload_DBC_File(Project, DBCfilelocation, setEcu);
		String value = Pageobj.SwBaseType;
		com.VerifyDBCDetailsSwBase("Sandeep", value, "2", "unsigned char");
		com.closeApplication();
		logger.pass("test case Pass");

	}

	@Test (priority=8, alwaysRun = true)

	public void SwbaseVerification() throws Exception {

		logger = BaseClass.exreporter.createTest("AR_1520");
		com.LunchApp("D:\\workspace\\");

		String Project = com.CreateProjectOnNewTool("Demo");
		System.out.println("---->   " + Project);
		String DBCfilelocation = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator
				+ "DBC"+ File.separator +"CAN";
		System.out.println("---------->      " + DBCfilelocation);
		String setEcu = Pageobj.SetECu;
		com.Upload_DBC_File(Project, DBCfilelocation, setEcu);
		String value = Pageobj.SwBaseType16;
		com.VerifyDBCDetailsSwBase(Project, value, "16", "signed char");
		com.closeApplication();
		logger.pass("test case Pass");

	}

	@Test (priority=9, alwaysRun = true)

	public void SwBaseSignal() throws Exception {

		logger = BaseClass.exreporter.createTest("AR_1521");
		com.LunchApp("D:\\workspace\\");
		// String Project = com.CreateProject("Demo8");
		// System.out.println("----> " + Project);
		String setEcu = Pageobj.SetECu2;
		String DBCfilelocation = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator
				+ "DBC" + File.separator + "CAN";
		System.out.println("D=====> " + DBCfilelocation);
		com.Upload_DBC_File_CAN("Demo8", DBCfilelocation, setEcu);
		String value = Pageobj.SwBaseType20;
		com.VerifyDBCDetailsSwBase("Demo8", value, "20", "signed char");
		com.closeApplication();
		logger.pass("test case Pass");

	}

}
