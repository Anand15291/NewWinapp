package manualTestCase;

import java.io.File;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Common;

import base.BaseClass;

public class Memory_Stack_Configuration extends BaseClass {
	
	Common com = new Common();
	
	@Test
	
	public void SequenceOfBlock() throws Exception {
		
		logger = BaseClass.exreporter.createTest("AR-867");
		String project = RandomStringUtils.randomAlphabetic(5);
		System.out.println(project);
		com.LunchApp("D:\\workspace\\");
		com.CreateProjectOnNewTool(project);
		String filepath = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator+"AR_867";
		String filename = "EcucDescription.arxml";
		com.ImportArxmlFile(project, filename, filepath);
		int steps  = com.VerifySequenceOfBlock(project,filename);
		System.out.println(steps+"  - -= ==> ");
		com.RestartProject();
		int newsteps  = com.VerifySequenceOfBlock(project,filename);
		System.out.println(newsteps+"  - -09tghj= ==> ");
		Assert.assertEquals(steps, newsteps);
		com.closeApplication();
	}

	@Test
	
	public void MemoryStackConfiguration() throws Exception {
		
		logger = BaseClass.exreporter.createTest("AR-611");
		String project = RandomStringUtils.randomAlphabetic(5);
		System.out.println(project);
		com.LunchApp("D:\\workspace\\");
		com.CreateProjectOnNewTool(project);
		String filepath = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator+"AR1648";
		String filename = "IOPT_minimal_system_desc.arxml";
		com.ImportArxmlFile(project, filename, filepath);
		//com.VerifyMemoryStack(project);
		com.closeApplication();
	}
}
