package manualTestCase;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Common;

import base.BaseClass;

public class Autosar_Project extends BaseClass {
	
	Common com = new Common();
	
	@Test
	
	public void Removefocus() throws Exception {
		logger = BaseClass.exreporter.createTest("AR-1086");
		String project = RandomStringUtils.randomAlphabetic(5);
		System.out.println(project);
		Robot rb = new Robot();
		com.LunchApp("D:\\workspace\\");
		com.CreateProjectOnNewTool(project);
		DesktopSession = Root();
		String flag = DesktopSession.findElementByName(project).getAttribute("HasKeyboardFocus");
		System.out.println(flag+"   =-= -> ");
		rb.keyPress(KeyEvent.VK_CONTROL);
		DesktopSession.findElementByName(project).click();
		rb.keyRelease(KeyEvent.VK_CONTROL);
		String Newflag = DesktopSession.findElementByName(project).getAttribute("HasKeyboardFocus");
		System.out.println(Newflag+"   sqsd=-= -> ");
		Assert.assertNotEquals(flag, Newflag);
		com.closeApplication();
		logger.pass("test case Pass");
	}
	
	@Test
	
	public void VerifyClearSearch() throws Exception {
		
		logger = BaseClass.exreporter.createTest("AR-83");
		String project = RandomStringUtils.randomAlphabetic(5);
		System.out.println(project);
		com.LunchApp("D:\\workspace\\");
		com.CreateProjectOnNewTool(project);
		com.VerifyClearSearch(project);
		com.closeApplication();
		logger.pass("test case Pass");
		
	}
	@Test
	
	public void VerifyOrderElements() throws Exception {
		logger = BaseClass.exreporter.createTest("AR-1132");
		String project = RandomStringUtils.randomAlphabetic(5);
		System.out.println(project);
		com.LunchApp("D:\\workspace\\");
		com.CreateProjectOnNewTool(project);
		String path = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator+"AR1132";
		System.out.println(path);
		String Filename = "Test.arxml";
		com.ImportArxmlFile(project,Filename, path);
		com.VerifyOrderofElement(project, path);
		com.closeApplication();
		logger.pass("test case Pass");
	}
}
