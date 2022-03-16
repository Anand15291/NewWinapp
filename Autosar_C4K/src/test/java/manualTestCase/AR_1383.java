package manualTestCase;

import org.testng.annotations.Test;

import com.Common;

import base.BaseClass;

public class AR_1383 extends BaseClass{
	
	Common com = new Common();
	@Test
	//TimeStamp issue
	public void IsignalIPdu_merged () throws Exception {
		
		logger = BaseClass.exreporter.createTest("AR_1383");
		com.LunchApp("D:\\workspace\\AR-13893");
		String Project = com.CreateProjectOnNewTool("13803");
		System.out.println("--->  "+Project);
		String fistFile = "BNE_FLM_L_Boardnet.arxml";
		String secondfile = "BNE_FLM_R_Boardnet.arxml";
		com.ImportFileToProject(Project, fistFile, secondfile);
		com.Mergefiles(Project,fistFile, secondfile);
		com.closeApplication();
		logger.pass("test case Pass");
		
	}

}
