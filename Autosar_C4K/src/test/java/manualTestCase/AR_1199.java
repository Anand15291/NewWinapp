package manualTestCase;

import java.io.File;

import org.testng.annotations.Test;

import com.Common;

import base.BaseClass;


public class AR_1199 extends BaseClass{
	Common com = new Common();
	
	@Test
	
	public void ClientServerOperation () throws Exception {
		
		logger = BaseClass.exreporter.createTest("AR_1199");
		com.LunchApp("D:\\workspace\\CSOe");
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
