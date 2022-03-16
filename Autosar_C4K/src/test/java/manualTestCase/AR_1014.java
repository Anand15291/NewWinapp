package manualTestCase;

import java.io.File;
import org.testng.annotations.Test;

import com.Common;

import base.BaseClass;

public class AR_1014 extends BaseClass {
	
	Common com = new Common();
	
	@Test
	
	public void VariableAcess() throws Exception {
		
		logger = BaseClass.exreporter.createTest("AR_1014");
		com.LunchApp("D:\\workspace\\");
		String ProjectPath = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator
				+ "AR_1014";
		System.out.println(ProjectPath);
		com.ImportProjectSaveWorkspace(ProjectPath);
		String Projectname = "DemoProject_Redmine_51816";
		com.VariableAccessCopyPaste(Projectname,ProjectPath);
	
		String fileName = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator+"AR_1014"+File.separator+"Project_Redmine"+File.separator+"default.arxml";
		com.VerifydefaultArxml(fileName, Projectname);
		com.closeApplication();

	}
	
	

}
