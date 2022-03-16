package manualTestCase;

import java.io.File;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import com.Common;

import base.BaseClass;

public class AR_1567 extends BaseClass {
	
	Common com = new Common();
	@Test
	
	public void VerifyEcucReportHTML() throws Exception {
		
		logger = BaseClass.exreporter.createTest("AR-1567");
		String project = RandomStringUtils.randomAlphabetic(5);
		System.out.println(project);
		com.LunchApp("D:\\workspace\\");
		com.CreateProjectOnNewTool(project);
		String filepath = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator+"AR1567";
		String filename = "RHS_ECU_Extract.arxml";
		String Reportpath= System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator+"AR1567"+File.separator+"ECU_Report";
		String fileToDelete = Reportpath+File.separator+"RHS_ECU_Extract_Report.html";
		com.ImportArxmlFile(project, filename, filepath);
		//com.DeleteFileInsideFolder(fileToDelete);
		String reportpath  = com.Generate_ECU_Report(project, Reportpath, "HTML", filename);
		System.out.println(reportpath+" =-=-=> xs ");
		com.VerifyHTMLReport(reportpath);
		com.closeApplication();
		logger.pass("test case Pass");
	}

	@Test
	
	public void VerifyEcucReportEXCEL() throws Exception {
		
		logger = BaseClass.exreporter.createTest("AR-1567");
		String project = RandomStringUtils.randomAlphabetic(5);
		System.out.println(project);
		com.LunchApp("D:\\workspace\\");
		com.CreateProjectOnNewTool(project);
		String filepath = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator+"AR1567";
		String filename = "RHS_ECU_Extract.arxml";
		String Reportpath=System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator+"AR1567"+File.separator+"ECU_Report";
		String fileToDelete = Reportpath+File.separator+"RHS_ECU_Extract_Report.xls";
		com.ImportArxmlFile(project, filename, filepath);
		//com.DeleteFileInsideFolder(fileToDelete);
		String reportpath  = com.Generate_ECU_Report(project, Reportpath, "HTML", filename);
		com.closeApplication();
		logger.pass("test case Pass");
	}
}
