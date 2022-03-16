package manualTestCase;

import java.io.File;

import org.testng.annotations.Test;

import com.Common;

import base.BaseClass;

public class AR_1107 extends BaseClass{
	
	Common com  = new Common();
	
	@Test
	public void VerifyButton() throws Exception {
		
		logger = BaseClass.exreporter.createTest("AR_1107");
		com.LunchApp("D:\\CK4_422\\dcs");
		String filelocation = System.getProperty("user.dir")+File.separator+"ImportProject"+File.separator+"ExportValidation_Project";
		 System.out.println("---------->      "+filelocation);
		com.ImportProject(filelocation);
		com.VerifyEnablement_of_Save_button();
		com.closeApplication();
		
	}

}
