package manualTestCase;

import java.io.File;

import org.testng.annotations.Test;

import com.Common;

import base.BaseClass;
import pageObject.Pageobj;

public class AR_1520 extends BaseClass {
	Common com = new Common();
	@Test
	
	public void SwbaseVerification () throws Exception {
		
		logger = BaseClass.exreporter.createTest("AR_1520");
		com.LunchApp("D:\\workspace\\");	
		String Project = com.CreateProject("Demo");
		System.out.println("---->   " + Project);
		String DBCfilelocation = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator
				+ "DBC";
		System.out.println("---------->      " + DBCfilelocation);
		String setEcu = Pageobj.SetECu;
		com.Upload_DBC_File(Project, DBCfilelocation,setEcu);
		String value = Pageobj.SwBaseType16;
		com.VerifyDBCDetailsSwBase(Project,value,"16","signed char");
		com.closeApplication();
		logger.pass("test case Pass");
		
		
		
		
	}

}
