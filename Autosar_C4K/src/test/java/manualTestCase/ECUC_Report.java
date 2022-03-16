package manualTestCase;

import java.io.File;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import com.Common;

import base.BaseClass;

public class ECUC_Report extends BaseClass{
	
	Common com = new Common();
	@Test
	
	public void VerifyEcucReportHTML() throws Exception {
		
		logger = BaseClass.exreporter.createTest("AR-1340");
		String project = RandomStringUtils.randomAlphabetic(5);
		System.out.println(project);
		com.LunchApp("D:\\workspace\\");
		com.CreateProjectOnNewTool(project);
		String filepath = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator+"Tes";
		String filename = "Daimler_extract.arxml";
		String Reportpath= System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator+"AR1567"+File.separator+"ECU_Report";
		String fileToDelete = Reportpath+File.separator+"Daimler_extract_Report.html";
		com.ImportArxmlFile(project, filename, filepath);
		com.DeleteFileInsideFolder(fileToDelete);
		String htmlpath = com.Generate_ECU_Report(project, Reportpath, "HTML", filename);
		com.VerifyEcuCHTMLReport(htmlpath);
		com.closeApplication();
		logger.pass("test case Pass");
	}
	
	@Test
	
	public void VerifyEcucReportExcel() throws Exception {
		
		logger = BaseClass.exreporter.createTest("AR-1341");
		String project = RandomStringUtils.randomAlphabetic(5);
		System.out.println(project);
		com.LunchApp("D:\\workspace\\");
		com.CreateProjectOnNewTool(project);
		String filepath = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator+"Tes";
		String filename = "Daimler_extract.arxml";
		String Reportpath=System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator+"AR1567"+File.separator+"ECU_Report";
		String fileToDelete = Reportpath+File.separator+"Daimler_extract_Report.xls";
		com.ImportArxmlFile(project, filename, filepath);
		com.DeleteFileInsideFolder(fileToDelete);
		com.Generate_ECU_Report(project, Reportpath, "EXCEL", filename);
		com.closeApplication();
		logger.pass("test case Pass");
	}

}
