package manualTestCase;

import java.io.File;
import java.util.List;
import java.util.Map;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.Common;
import com.Utility;
import base.BaseClass;
import pageObject.Pageobj;

public class All_Testcase_Suite extends BaseClass{
	
	Common com = new Common();
	Utility utl = new Utility();
	
	@Test (alwaysRun = true)
	
	public void VariableAcess() throws Exception {
		
		logger = BaseClass.exreporter.createTest("AR_1014");
		com.LunchApp("D:\\CK4_422\\AR1014N");
		String ProjectPath = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator
				+ "AR_1014";
		System.out.println(ProjectPath);
		com.ImportProject(ProjectPath);
		String Projectname = "DemoProject_Redmine_51816";
		com.VariableAccessCopyPaste(Projectname,ProjectPath);
	
		String fileName = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator+"AR_1014"+File.separator+"Project_Redmine"+File.separator+"default.arxml";
		com.VerifydefaultArxml(fileName, Projectname);
		com.closeApplication();

	}
	
	
	@Test (alwaysRun = true)
	public void showInSystemExplorerECUFile() throws Exception {
		logger = BaseClass.exreporter.createTest("AR_1028");
		com.LunchApp("D:\\compose4ksar-18.1.3-win32.win32.x86_64\\AR1028");
		String Project = com.CreateProject("AR1028");
		System.out.println("---->   " + Project);
		com.Upload_ECU_File(Project);
		com.closeApplication();
	}
	
	
@Test(alwaysRun = true)
	
	public void Export_SCW () throws Exception {
		logger = BaseClass.exreporter.createTest("AR_1054");
		com.LunchApp("D:\\CK4_422\\AR1054");
		String Project_Loc = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator
				+ "SWC_Export";
		System.out.println("======>   "+Project_Loc);
		com.ImportProject(Project_Loc);
		com.exportSWC("SWC_Export");
		com.closeApplication();
		logger.pass("test case Pass");
	}


@Test(alwaysRun = true)

    public void computeCanFiltersValidation() throws Exception {
	logger = BaseClass.exreporter.createTest("AR_1055");
	com.LunchApp("D:\\compose4ksar-18.1.3-win32.win32.x86_64\\AR1055");
	com.computeCanValidations();
	com.closeApplication();
}


@Test(alwaysRun = true)
public void exportFIleOptionValidation() throws Exception {
	logger = BaseClass.exreporter.createTest("AR_1059");
	com.LunchApp("D:\\compose4ksar-18.1.3-win32.win32.x86_64\\AR1059");
	com.exportFileContextOptionValidations();
	com.closeApplication();
}


//@Test

public void DataMappingSignalgroup () throws Exception {
	
	logger = BaseClass.exreporter.createTest("AR_1065");
	com.LunchApp("D:\\CK4_422\\AR_1065");
	String ProjectLocation = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator
			+ "C4K_AutoSAR_Project";
	System.out.println("---------->      " + ProjectLocation);
	//DataMapping[Release_R_1_1_2_1_V2G]
	com.ImportProject(ProjectLocation);
	com.MappingSignalData("Release_R_1_1_2_1_V2G");
	com.closeApplication();
	logger.pass("test case Pass");

	
}


@Test(alwaysRun = true)
public void VerifyButton() throws Exception {
	
	logger = BaseClass.exreporter.createTest("AR_1107");
	com.LunchApp("D:\\CK4_422\\dcs");
	String filelocation = System.getProperty("user.dir")+File.separator+"ImportProject"+File.separator+"ExportValidation_Project";
	 System.out.println("---------->      "+filelocation);
	com.ImportProject(filelocation);
	com.VerifyEnablement_of_Save_button();
	com.closeApplication();
	
}


@SuppressWarnings("unchecked")
@Test(alwaysRun = true)

public void VerifyExcel() throws Exception {
	
	logger = BaseClass.exreporter.createTest("AR_1108");
	com.LunchApp("D:\\CK4_422\\AR1108");
	String filelocation = System.getProperty("user.dir")+File.separator+"ImportProject"+File.separator+"ExportValidation_Project";
	System.out.println("---------->      "+filelocation);
	com.ImportProject(filelocation);
	String Project = "ExportValidation_Project";
	String file = com.VerifyReportName(Project,filelocation);
	 Map< Integer, String>map = new HashedMap();
	 Map< Integer, String>mapn = new HashedMap();
	com.AddErrorsOnFile(Project);
	String txtpath = filelocation+File.separator+"errors.txt";
	map = utl.ReadTXTfile(txtpath);
	String excelpath = filelocation+File.separator+file;
	mapn= utl.Readexcel(excelpath);
	
	for(int i=1;i<map.size();i++) {
		System.out.println(mapn.get(i)+"  ^^^^^^^^^^^^^^^^----- >  "+map.get(i));
		Assert.assertEquals(mapn.get(i), map.get(i));
		
	}

	com.closeApplication();
}


@Test(alwaysRun = true)

public void integrator_BSWMD() throws Exception {
	
	logger = BaseClass.exreporter.createTest("AR_1124");
	com.LunchApp("D:\\compose4ksar-18.1.3-win32.win32.x86_64\\AR1124");
	String Project = com.CreateProject("AR1124");
	System.out.println("---->   " + Project);
	com.propertiesEnabledVerification("AR1124");
	com.closeApplication();
	logger.pass("Test Passed");
	
	
	
}

@Test(alwaysRun = true)
public void integrator_BSWMD_MergeFiles() throws Exception {
	
	logger = BaseClass.exreporter.createTest("AR_1128");
	com.LunchApp("D:\\compose4ksar-18.1.3-win32.win32.x86_64\\AR1128");
	String Project = com.CreateProjectAndNewFolder("AR1128", "integrator_bswmd");
	System.out.println("---->   " + Project);
	com.Upload_Bswmd_File(Project);
	com.closeApplication();
	
}


@Test(alwaysRun = true)
public void VerifyHTMLfiles () throws Exception {
	

	logger = BaseClass.exreporter.createTest("AR_1137");
	String value = RandomStringUtils.randomAlphabetic(8);
	System.out.println(value);
	com.LunchApp("D:\\CK4_422\\"+value);
	String Projectlocation = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator+"CompareECUCExtract";
	System.out.println(Projectlocation);
	com.ImportProject(Projectlocation);
	String Ecucfile1 = "Merged_DiagExtract_r17.arxml";
	String Ecucfile2 = "Merged_DiagExtract_r18.arxml";
	String filename1 = "Merged_DiagExtract_r17";
	String filename2 = "Merged_DiagExtract_r18";
	String report17Path = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator+"ECUCReport"+File.separator+"Merged_DiagExtract_r17";
	String report18Path = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator+"ECUCReport"+File.separator+"Merged_DiagExtract_r18";
	String Projectname = "Compare_ECUC_Extract";
	com.CompareECUC(Projectname, Ecucfile1, filename2, report17Path);
	Thread.sleep(1000);
	com.CompareECUC(Projectname, Ecucfile2, filename1, report18Path);
	com.CompareTwoECUC_Report(report17Path, report18Path);
	com.closeApplication();
	logger.pass("test case Pass");
}


@Test(alwaysRun = true)
public void propertiesValidator() throws Exception {
	logger = BaseClass.exreporter.createTest("AR_1141");
	com.LunchApp("D:\\compose4ksar-18.1.3-win32.win32.x86_64\\AR1141");
	com.CreateTwoProject("AR1141");
	com.closeApplication();
	
}


@Test(alwaysRun = true)

public void ClientServerOperation () throws Exception {
	
	logger = BaseClass.exreporter.createTest("AR_1199");
	com.LunchApp("D:\\CK4_422\\CSOe");
	String Project = com.CreateProject("AR1199");
	System.out.println("---->   " + Project);
	String fistFile = "IOPT_minimal_system_desc.arxml";
	System.out.println("---------->      " + fistFile);
	com.ImportSingleFileToProject(Project, fistFile);
	com.ClientServerOperation(Project);
	com.closeApplication();
	logger.pass("test case Pass");
	
	
}


@Test(alwaysRun = true)
public void addModuleDefFileBswmdValidation() throws Exception {
	logger = BaseClass.exreporter.createTest("AR_1027");
	com.LunchApp("D:\\compose4ksar-18.1.3-win32.win32.x86_64\\AR1027");
	String Project = com.CreateProject("AR1207");
	System.out.println("---->   " + Project);
	com.addModuleDefinationFilesBswmd("AR1207");
	com.closeApplication();
}


@SuppressWarnings("unused")
@Test(alwaysRun = true)


public  void VerifyReport () throws Exception {
	//ExportValidation_Project
	logger = BaseClass.exreporter.createTest("Verify The Report Name");
	com.LunchApp("D:\\CK4_422\\sand");
	String filelocation = System.getProperty("user.dir")+File.separator+"ImportProject"+File.separator+"ExportValidation_Project";
	 System.out.println("---------->      "+filelocation);
	com.ImportProject(filelocation);
	String Project = "ExportValidation_Project";
	String file = com.VerifyReportName(Project,filelocation);
	com.closeApplication();
	logger.pass("test case Pass");
	
	
}

@Test(alwaysRun = true)
public void VerifytheErrorNos () throws Exception {
	
	
	logger = BaseClass.exreporter.createTest("AR_1343");
	com.LunchApp("D:\\CK4_422\\hvg");
	String filelocation = System.getProperty("user.dir")+File.separator+"ImportProject"+File.separator+"ExportValidation_Project";
	 System.out.println("---------->      "+filelocation);
	com.ImportProject(filelocation);
	String Project = "ExportValidation_Project";
	String file = com.VerifyReportName(Project,filelocation);
	int totalerrors = com.NoofErrorValidation();
	String excelpath = filelocation+File.separator+file;
	int totalerrorinsheet = com.RowinExcel(excelpath);
	Assert.assertEquals(totalerrors, totalerrorinsheet);
	com.closeApplication();
	logger.pass("test case Pass");
}


@Test(alwaysRun = true)
public void workSpacePathVerify() throws Exception {
	logger = BaseClass.exreporter.createTest("AR_1369");
	com.LunchAppWithoutRandom("C:\\Users\\krishnad8\\c4k_workspace");
	com.validateWorkspacePath();

}


@SuppressWarnings({ "unchecked", "unused" })
@Test(alwaysRun = true)
public void pathVerificationOfApp() throws Exception {
	
	
	logger = BaseClass.exreporter.createTest("AR_1381");
	String AppPath1 = "D:\\compose4ksar-18.1.3-win32.win32.x86_64\\Krish";
	
	com.verifyPreviousLocation(AppPath1); 
	Thread.sleep(2000); 
    Setup();
	Thread.sleep(2000);
	DesktopSession = Root();
	List <WebElement> wb = DesktopSession.findElementsByClassName("Edit");
	System.out.println(wb.size());
	for(int i =0; i<=wb.size()-1; i++) {
		String values = wb.get(i).getAttribute("Name").trim();
		if(values.equals("AppPath1"));
		break;
		
	}
	logger.pass("Verified the previous path of the Application");
	String pathVerify1 = wb.get(2).getAttribute("Value.Value");
	System.out.println(pathVerify1);
	Assert.assertEquals(pathVerify1, AppPath1);
	logger.pass("Verified the previous path of the Application");
	DesktopSession.findElementByName("Cancel").click();
	logger.pass("Second Application Instance has been launched and closed");
    
    

}

//@Test

public void IsignalIPdu_merged () throws Exception {
	
	logger = BaseClass.exreporter.createTest("AR_1383");
	com.LunchApp("D:\\CK4_422\\AR-13893");
	String Project = com.CreateProject("13803");
	System.out.println("--->  "+Project);
	String fistFile = "BNE_FLM_L_Boardnet.arxml";
	String secondfile = "BNE_FLM_R_Boardnet.arxml";
	com.ImportFileToProject(Project, fistFile, secondfile);
	com.Mergefiles(Project,fistFile, secondfile);
	com.closeApplication();
	logger.pass("test case Pass");
	
}


/*
 * @Test
 * 
 * public void ComSignalEndianness () throws Exception {
 * 
 * logger = BaseClass.exreporter.createTest("AR_1461");
 * com.LunchApp("D:\\CK4_422\\NewIndian"); String Project =
 * com.CreateProject("LittleIndian"); System.out.println("---->   " + Project);
 * String LDFpath = System.getProperty("user.dir") + File.separator +
 * "ImportProject" + File.separator+"LDF";
 * System.out.println("ldf path  --->  "+LDFpath);
 * com.ImportLDFFile("LittleIndian", LDFpath);
 * System.out.println("Verify Step ---------> ");
 * com.VerifyComSignalEndianess("LittleIndian"); com.closeApplication();
 * logger.pass("test case Pass"); }
 */


@Test(alwaysRun = true)

public void SwBase_SignalLength() throws Exception {
	logger = BaseClass.exreporter.createTest("AR_1519");
	com.LunchApp("D:\\CK4_422\\sanddy");
	String Project = com.CreateProject("Demo2");
	System.out.println("---->   " + Project);
	String DBCfilelocation = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator
			+ "DBC";
	System.out.println("---------->      " + DBCfilelocation);
	String setEcu = Pageobj.SetECu;
	com.Upload_DBC_File(Project, DBCfilelocation,setEcu);
	String value = Pageobj.SwBaseType;
	com.VerifyDBCDetailsSwBase("Sandeep",value,"2","unsigned char");
	com.closeApplication();
	logger.pass("test case Pass");

}


@Test(alwaysRun = true)

public void SwbaseVerification () throws Exception {
	
	logger = BaseClass.exreporter.createTest("AR_1520");
	com.LunchApp("D:\\CK4_422\\sanddy");
	
	String Project = com.CreateProject("Demo");
	System.out.println("---->   " + Project);
	String DBCfilelocation = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator
			+ "DBC";
	System.out.println("---------->      " + DBCfilelocation);
	String setEcu = Pageobj.SetECu;
	com.Upload_DBC_File(Project, DBCfilelocation,setEcu);
	String value = Pageobj.SwBaseType16;
	com.VerifyDBCDetailsSwBase(Project,value,"16","signed char");
	com.closeApplication();
	logger.pass("test case Pass");
	
	
	
	
}


@Test(alwaysRun = true)

public void SwBaseSignal() throws Exception {
	
	logger = BaseClass.exreporter.createTest("AR_1521");
	com.LunchApp("D:\\CK4_422\\sandy");
	//String Project = com.CreateProject("Demo8");
	//System.out.println("---->   " + Project);
	String setEcu = Pageobj.SetECu2;
	String DBCfilelocation = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator
			+ "DBC"+File.separator+"CAN";
	System.out.println("D=====> "+DBCfilelocation);
	com.Upload_DBC_File_CAN("Demo8", DBCfilelocation,setEcu);
	String value = Pageobj.SwBaseType20;
	com.VerifyDBCDetailsSwBase("Demo8",value,"20","signed char");
	com.closeApplication();
	logger.pass("test case Pass");
	
}


@Test(alwaysRun = true)

public void Verifybookmarkdoc () throws Exception {
	
	logger = BaseClass.exreporter.createTest("AR_1624");
	com.LunchApp("D:\\CK4_422\\bookmark");
	com.VerifyBookmark();
	com.closeApplication();
	logger.pass("test case Pass");
}


@Test(alwaysRun = true)

public void checkNavigation () throws Exception {
	
	logger = BaseClass.exreporter.createTest("AR_1625");
	com.LunchApp("D:\\CK4_422\\navi");
	com.navigateToLink();
	com.closeApplication();
	logger.pass("test case Pass");
}


@Test(alwaysRun = true)

public void VerifyNextSection ( ) throws Exception {
	
	logger = BaseClass.exreporter.createTest("AR_1629");
	com.LunchApp("D:\\CK4_422\\Next");
	com.VerifyHelpContentGroup();
	com.closeApplication();
	logger.pass("test case Pass");
}

@Test(alwaysRun = true)
public void UploadIOPTValidation() throws Exception {
	logger = BaseClass.exreporter.createTest("AR_431");
	com.LunchApp("D:\\compose4ksar-18.1.3-win32.win32.x86_64\\AR431");
	String Project = com.CreateProjectOnNewTool("AR431");
	System.out.println("---->   " + Project);
	com.Upload_IOPT_File(Project);
	com.closeApplication();
}


@Test(alwaysRun = true)
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


@Test(alwaysRun = true)
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


@Test(alwaysRun = true)
public void showInSystemExplorerOptionValidation() throws Exception {
	logger = BaseClass.exreporter.createTest("AR_796");
	com.LunchApp("D:\\compose4ksar-18.1.3-win32.win32.x86_64\\AR796");
	com.showInSystemExplorerOptionValidations();
	com.closeApplication();
}


@Test(alwaysRun = true)
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

@Test(alwaysRun = true)
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


@Test(alwaysRun = true)

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


@Test(alwaysRun = true)
public void defaultWorksapceValidation() throws Exception {
	logger = BaseClass.exreporter.createTest("AR_925");
	String AppPath1 = "D:\\compose4ksar-18.1.3-win32.win32.x86_64\\Krish";
	com.validateDefaultWorkspacePath(AppPath1);

}

@Test(alwaysRun = true)
public void launchingTwoApplicationVerification() throws Exception {
	logger = BaseClass.exreporter.createTest("AR_961");
	com.LunchAppMultipleInstance("D:\\compose4ksar-18.1.3-win32.win32.x86_64\\Krish1");
	com.closeApplication();
	
	
}

}
