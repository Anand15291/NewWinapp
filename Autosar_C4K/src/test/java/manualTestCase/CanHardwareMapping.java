package manualTestCase;

import java.io.File;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Common;

import base.BaseClass;

public class CanHardwareMapping extends BaseClass {
	
	Common com = new Common();
	@Test
	
	public void VerifyCanObjectAdd () throws Exception {
		
		logger = BaseClass.exreporter.createTest("AR-852");
		String project = RandomStringUtils.randomAlphabetic(5);
		System.out.println(project);
		com.LunchApp("D:\\workspace\\");
		String ProjPath = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator+"NewProject";
		com.ImportProject(ProjPath);
		com.CanHardwareMapping("NewProject");
		com.closeApplication();
		logger.pass("test case Pass");
		
	}
	@Test
	
	public void VerifyHarmonizeOption() throws Exception {
		
		logger = BaseClass.exreporter.createTest("AR-929");
		String project = RandomStringUtils.randomAlphabetic(5);
		System.out.println(project);
		com.LunchApp("D:\\workspace\\");
		String ProjPath = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator+"NewProject";
		com.ImportProject(ProjPath);
		com.CanHardwareMapping("NewProject");
		DesktopSession = Root();
		boolean flag = DesktopSession.findElementByName("Harmonize").isEnabled();
		System.out.println(flag);
		DesktopSession.findElementByName("Harmonize").click();
		Thread.sleep(1000);
		boolean newflag = DesktopSession.findElementByName("Harmonize").isEnabled();
		System.out.println(newflag);
		Assert.assertEquals(flag, true);
		Assert.assertEquals(newflag, false);
		com.closeApplication();
		logger.pass("test case Pass");
	}

	@Test
	public void VerifyCanController() throws Exception {
		
		logger = BaseClass.exreporter.createTest("AR-1360");
		String project = RandomStringUtils.randomAlphabetic(5);
		System.out.println(project);
		com.LunchApp("D:\\workspace\\");
		String ProjPath = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator+"NewProject";
		com.ImportProject(ProjPath);
		com.VerifyCanController("NewProject");
		com.closeApplication();
		
	}
	
	@Test
	public void VerifyCanControllerTabAdded() throws Exception {
		
		logger = BaseClass.exreporter.createTest("AR-1361");
		String project = RandomStringUtils.randomAlphabetic(5);
		System.out.println(project);
		com.LunchApp("D:\\workspace\\");
		String ProjPath = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator+"NewProject";
		com.ImportProject(ProjPath);
		com.VerifynewlyAddCanTab("NewProject");
		com.closeApplication();
		
	}
	
	@Test
	public void VerifyCanControllerNewTabAdded() throws Exception {
		
		logger = BaseClass.exreporter.createTest("AR-1362");
		String project = RandomStringUtils.randomAlphabetic(5);
		System.out.println(project);
		com.LunchApp("D:\\workspace\\");
		String ProjPath = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator+"NewProject";
		com.ImportProject(ProjPath);
		com.VerifynewlyAddCanTab("NewProject");
		com.closeApplication();
		
	}
	@Test
	public void VerifyMappingCanController() throws Exception {
		
		logger = BaseClass.exreporter.createTest("AR-1364");
		com.LunchApp("D:\\workspace\\");
		String ProjPath = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator+"NewProject";
		com.ImportProject(ProjPath);
		//com.VerifynewlyAddCanTab("NewProject");
		com.VerifyMappedFrame("NewProject");
		com.closeApplication();
		
	}
	
	@Test
	
	public void VerifyProxyIssues() throws Exception {
		
		logger = BaseClass.exreporter.createTest("AR-1674");
		com.LunchApp("D:\\workspace\\");
		String ProjPath = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator+"Merge_ECUExtract";
		com.ImportProject(ProjPath);
		String project= "Merge_ECUExtract";
		String filename = com.ECUCCompareonTwoFiles(project);
		System.out.println(filename);
		com.closeApplication();
		Thread.sleep(1000);
		Setup();
		com.LunchApp("D:\\workspace\\");
		com.CreateProjectOnNewTool("NewProject");
		com.PasteNewECUfile("NewProject", filename);
		com.closeApplication();
	}
}
