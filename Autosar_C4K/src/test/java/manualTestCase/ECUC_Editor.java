package manualTestCase;

import java.io.File;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import com.Common;

import base.BaseClass;

public class ECUC_Editor extends BaseClass{

	Common com = new Common();
	
	@Test
	
	public void VerifyParameterInfo() throws Exception {
		logger = BaseClass.exreporter.createTest("AR-701");
		String project = RandomStringUtils.randomAlphabetic(5);
		System.out.println(project);
		com.LunchApp("D:\\workspace\\");
		com.CreateProjectOnNewTool(project);
		boolean flag = com.VerifyDefaultarxml(project);
		if(flag==true) {
			System.out.println("Not required");
		}
		else {
			com.NewCreateDefaultArxml(project);
		}
		//com.VerifyElementInfo(project);
		com.closeApplication();
		logger.pass("test case Pass");
	}
	
	@Test
	
	public void VerifyParameterLabel() throws Exception {
		
		logger = BaseClass.exreporter.createTest("AR-305");
		String project = RandomStringUtils.randomAlphabetic(5);
		System.out.println(project);
		com.LunchApp("D:\\workspace\\");
		String ProjPath = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator+"Tes";
		com.ImportProject(ProjPath);
		String Project = "Tes";
		com.VerifyParameterTooltip(Project);
		com.closeApplication();
		logger.pass("test case Pass");
	}
	
	@Test
	
	public void SubcontanierView() throws Exception {
		
		logger = BaseClass.exreporter.createTest("AR-1630");
		String project = RandomStringUtils.randomAlphabetic(5);
		System.out.println(project);
		com.LunchApp("D:\\workspace\\");
		String ProjPath = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator+"ProjectNw";
		com.ImportProject(ProjPath);
		String Project = "ProjectNew";
		com.SubcontainerViews(Project);
		com.closeApplication();
		logger.pass("test case Pass");
	}
}
