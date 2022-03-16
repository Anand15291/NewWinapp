package manualTestCase;

import java.io.File;

import org.testng.annotations.Test;

import com.Common;

import base.BaseClass;

@SuppressWarnings("unused")
public class DataMapping extends BaseClass{
	
	Common com = new Common();
	
	@Test (priority=1)
	public void dataMappingValidation() throws Exception {
		logger = BaseClass.exreporter.createTest("Data_MappingValidation");
		com.LunchApp("D:\\compose4ksar-18.1.3-win32.win32.x86_64\\AR1198");
		String Project = com.CreateProjectOnNewTool("AR1198");
		System.out.println("---->   " + Project);
		String fistFile = "IOPT_minimal_system_desc.arxml";
		System.out.println("---------->      " + fistFile);
		com.ImportSingleFile(Project, fistFile);
		com.dataMappingOptionValidation(Project);
		com.closeApplication();
	}

}
