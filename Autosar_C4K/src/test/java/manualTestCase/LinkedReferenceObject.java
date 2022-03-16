package manualTestCase;

import java.io.File;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import com.Common;

import base.BaseClass;
import example.Process.GetProcess;

public class LinkedReferenceObject extends BaseClass{
	
	Common com = new Common();
	GetProcess gp = new GetProcess();
	@Test
	
	public void NoeditorMessage() throws Exception {
		
		logger = BaseClass.exreporter.createTest("AR-1650");
		String project = RandomStringUtils.randomAlphabetic(5);
		System.out.println(project);
		com.LunchApp("D:\\workspace\\");
		com.CreateProjectOnNewTool(project);
		String filepath = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator+"AR1648";
		String filename = "EcucDescription.arxml";
		com.ImportArxmlFile(project, filename, filepath);
		com.VerifyMessage(project, filename);
		com.closeApplication();
		logger.pass("test case Pass");
	}
	@Test
	
	public void ViewReferenceObject() throws Exception {
		
		logger = BaseClass.exreporter.createTest("AR-1648");
		String project = RandomStringUtils.randomAlphabetic(5);
		System.out.println(project);
		com.LunchApp("D:\\workspace\\");
		com.CreateProjectOnNewTool(project);
		String filepath = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator+"AR1648";
		String filename = "EcucDescription.arxml";
		com.ImportArxmlFile(project, filename, filepath);
		com.VerifyRefernceObject(project, filename);
		com.closeApplication();
		logger.pass("test case Pass");
	}

	@Test
	
	public void ViewReferenceObjectHighlighted() throws Exception {
		
		logger = BaseClass.exreporter.createTest("AR-1649");
		String project = RandomStringUtils.randomAlphabetic(5);
		System.out.println(project);
		com.LunchApp("D:\\workspace\\");
		com.CreateProjectOnNewTool(project);
		String filepath = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator+"AR1648";
		String filename = "EcucDescription.arxml";
		com.ImportArxmlFile(project, filename, filepath);
		com.VerifyRefernceObject(project, filename);
		com.closeApplication();
		logger.pass("test case Pass");
	}
	@Test
		public void GoToReferenceObjectHighlighedObject() throws Exception {
			
			logger = BaseClass.exreporter.createTest("AR-1668");
			String project = RandomStringUtils.randomAlphabetic(5);
			System.out.println(project);
			com.LunchApp("D:\\workspace\\");
			com.CreateProjectOnNewTool(project);
			String filepath = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator+"AR1648";
			String filename = "EcucDescription.arxml";
			com.ImportArxmlFile(project, filename, filepath);
			com.VerifyObjectHighlighted(project, filename);
			com.closeApplication();
			logger.pass("test case Pass");
		}
	
//	@Test
//	
//	public void MultivalueReferenceEle () throws Exception {
//		
//		logger = BaseClass.exreporter.createTest("AR-1672");
//		String project = RandomStringUtils.randomAlphabetic(5);
//		System.out.println(project);
//		com.LunchApp("D:\\workspace\\");
//		com.CreateProjectOnNewTool(project);
//		String filepath = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator+"AR1648";
//		String filename = "IOPT_minimal_system_desc.arxml";
//		com.ImportArxmlFile(project, filename, filepath);
//		com.VerifyMultivalueEle(project, filename);
//		com.closeApplication();
//		logger.pass("test case Pass");
//	}
	
	@Test
	
	public void SelectEleDialogOpen() throws Exception {
		
		logger = BaseClass.exreporter.createTest("Unknow");
		String project = RandomStringUtils.randomAlphabetic(5);
		System.out.println(project);
		com.LunchApp("D:\\workspace\\");
		com.CreateProjectOnNewTool(project);
		String filepath = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator+"AR1648";
		String filename = "IOPT_minimal_system_desc.arxml";
		com.ImportArxmlFile(project, filename, filepath);
		com.SelectElementDialogOpen(project, filename);
		com.closeApplication();
		logger.pass("test case Pass");
	}
	
	@Test
	public void LinkedEditorHighlighedObject() throws Exception {
		
		logger = BaseClass.exreporter.createTest("AR-1669");
		String project = RandomStringUtils.randomAlphabetic(5);
		System.out.println(project);
		com.LunchApp("D:\\workspace\\");
		com.CreateProjectOnNewTool(project);
		String filepath = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator+"AR1648";
		String filename = "EcucDescription.arxml";
		com.ImportArxmlFile(project, filename, filepath);
		Thread.sleep(1000);
		DesktopSession.findElementByName("Link with Editor").click();
		com.VerifyObjectHighlighted(project, filename);
		com.closeApplication();
		logger.pass("test case Pass");
	}
}
