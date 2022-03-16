package manualTestCase;
import java.io.File;
import java.util.Map;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Common;
import com.Utility;

import base.BaseClass;

public class Test_Group_4 extends BaseClass {

	Common com = new Common();

	@Test (priority=1, alwaysRun = true)
	public void showInSystemExplorerECUFile() throws Exception {
		logger = BaseClass.exreporter.createTest("AR_1028");
		com.LunchApp("D:\\compose\\AR1028");
		String Project = com.CreateProjectOnNewTool("AR1028");
		System.out.println("---->   " + Project);
		com.Upload_ECU_File(Project);
		com.closeApplication();
	}

	@Test  (priority=5, alwaysRun = true)
	public void computeCanFiltersValidation() throws Exception {
		logger = BaseClass.exreporter.createTest("AR_1055");
		com.LunchApp("D:\\compose4ksar-18.1.3-win32.win32.x86_64\\AR1055");
		com.computeCanValidations();
		com.closeApplication();
	}

	@Test  (priority=3, alwaysRun = true)
	public void exportFIleOptionValidation() throws Exception {
		logger = BaseClass.exreporter.createTest("AR_1059");
		com.LunchApp("D:\\compose4ksar-18.1.3-win32.win32.x86_64\\AR1059");
		com.exportFileContextOptionValidations();
		com.closeApplication();
	}

	@Test  (priority=11, alwaysRun = true)

	public void DataMappingSignalgroup() throws Exception {

		logger = BaseClass.exreporter.createTest("AR_1065");
		com.LunchApp("D:\\CK4_422\\AR_1065");
		String ProjectLocation = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator
				+ "C4K_AutoSAR_Project";
		System.out.println("---------->      " + ProjectLocation);
		// DataMapping[Release_R_1_1_2_1_V2G]
		com.ImportProject(ProjectLocation);
		com.MappingSignalData("Release_R_1_1_2_1_V2G");
		com.closeApplication();
		logger.pass("test case Pass");

	}

	@Test  (priority=10, alwaysRun = true)
	public void VerifyButton() throws Exception {

		logger = BaseClass.exreporter.createTest("AR_1107");
		com.LunchApp("D:\\CK4_422\\dcs");
		String filelocation = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator
				+ "ExportValidation_Project";
		System.out.println("---------->      " + filelocation);
		com.ImportProject(filelocation);
		com.VerifyEnablement_of_Save_button();
		com.closeApplication();

	}

	Utility utl = new Utility();

	@SuppressWarnings("unchecked")
	@Test  (priority=9, alwaysRun = true)

	public void VerifyExcel() throws Exception {

		logger = BaseClass.exreporter.createTest("AR_1108");
		com.LunchApp("D:\\CK4_422\\AR1108");
		String filelocation = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator
				+ "ExportValidation_Project";
		System.out.println("---------->      " + filelocation);
		com.ImportProject(filelocation);
		String Project = "ExportValidation_Project";
		String file = com.VerifyReportName(Project, filelocation);
		Map<Integer, String> map = new HashedMap();
		Map<Integer, String> mapn = new HashedMap();
		com.AddErrorsOnFile(Project);
		String txtpath = filelocation + File.separator + "errors.txt";
		map = utl.ReadTXTfile(txtpath);
		String excelpath = filelocation + File.separator + file;
		mapn = utl.Readexcel(excelpath);

		for (int i = 1; i < map.size(); i++) {
			System.out.println(mapn.get(i) + "  ^^^^^^^^^^^^^^^^----- >  " + map.get(i));
			Assert.assertEquals(mapn.get(i), map.get(i));

		}

		com.closeApplication();
	}

	@Test  (priority=4, alwaysRun = true)

	public void integrator_BSWMD() throws Exception {

		logger = BaseClass.exreporter.createTest("AR_1124");
		com.LunchApp("D:\\compose4ksar-18.1.3-win32.win32.x86_64\\AR1124");
		String Project = com.CreateProjectOnNewTool("AR1124");
		System.out.println("---->   " + Project);
		com.propertiesEnabledVerification("AR1124");
		com.closeApplication();
		logger.pass("Test Passed");

	}

	@Test  (priority=2, alwaysRun = true)
	public void integrator_BSWMD_MergeFiles() throws Exception {

		logger = BaseClass.exreporter.createTest("AR_1128");
		com.LunchApp("D:\\compose4ksar-18.1.3-win32.win32.x86_64\\AR1128");
		String Project = com.CreateProjectOnNewToolAndNewFolder("AR1128", "integrator_bswmd");
		System.out.println("---->   " + Project);
		com.Upload_Bswmd_File(Project);
		com.closeApplication();

	}

	@Test  (priority=8, alwaysRun = true,enabled = false)
	public void VerifyHTMLfiles() throws Exception {

		logger = BaseClass.exreporter.createTest("AR_1137");
		String value = RandomStringUtils.randomAlphabetic(8);
		System.out.println(value);
		com.LunchApp("D:\\CK4_422\\" + value);
		String Projectlocation = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator
				+ "CompareECUCExtract";
		System.out.println(Projectlocation);
		com.ImportProject(Projectlocation);
		String Ecucfile1 = "Merged_DiagExtract_r17.arxml";
		String Ecucfile2 = "Merged_DiagExtract_r18.arxml";
		String filename1 = "Merged_DiagExtract_r17";
		String filename2 = "Merged_DiagExtract_r18";
		String report17Path = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator
				+ "ECUCReport" + File.separator + "Merged_DiagExtract_r17";
		String report18Path = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator
				+ "ECUCReport" + File.separator + "Merged_DiagExtract_r18";
		String Projectname = "Compare_ECUC_Extract";
		com.CompareECUC(Projectname, Ecucfile1, filename2, report17Path);
		Thread.sleep(1000);
		com.CompareECUC(Projectname, Ecucfile2, filename1, report18Path);
		com.CompareTwoECUC_Report(report17Path, report18Path);
		com.closeApplication();
		logger.pass("test case Pass");
	}

//	@Test  (priority=6, alwaysRun = true)
//	public void propertiesValidator() throws Exception {
//		logger = BaseClass.exreporter.createTest("AR_1141");
//		com.LunchApp("D:\\compose4ksar-18.1.3-win32.win32.x86_64\\AR1141");
//		com.CreateTwoProject("AR1141");
//		com.closeApplication();
//
//	}

	@Test  (priority=7, alwaysRun = true)

	public void ClientServerOperation() throws Exception {

		logger = BaseClass.exreporter.createTest("AR_1199");
		com.LunchApp("D:\\CK4_422\\CSOe");
		String Project = com.CreateProjectOnNewTool("AR1199");
		System.out.println("---->   " + Project);
		String fistFile = "IOPT_minimal_system_desc.arxml";
		System.out.println("---------->      " + fistFile);
		com.ImportSingleFile(Project, fistFile);
		com.ClientServerOperation(Project);
		com.closeApplication();
		logger.pass("test case Pass");

	}

}
