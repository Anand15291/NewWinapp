package manualTestCase;

import java.io.File;

import org.testng.annotations.Test;

import com.Common;

import base.BaseClass;
import pageObject.Pageobj;

public class AR_1521 extends BaseClass{
	Common com = new Common();
	@Test
	
	public void SwBaseSignal() throws Exception {
		
		logger = BaseClass.exreporter.createTest("AR_1521");
		com.LunchApp("D:\\workspace\\");
		String Project = com.CreateProject("Demo8");
		System.out.println("---->   " + Project);
		String setEcu = Pageobj.SetECu2;
		String DBCfilelocation = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator
				+ "DBC"+File.separator+"CAN";
		System.out.println("D=====> "+DBCfilelocation);
		com.Upload_DBC_File_CAN("Demo8", DBCfilelocation,setEcu);
		String value = Pageobj.SwBaseType20;
		com.VerifyDBCDetailsSwBase("Demo8",value,"20","signed char");
		com.closeApplication();
		logger.pass("test case Pass");
		
	}

}
