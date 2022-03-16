package manualTestCase;

import java.io.File;

import org.testng.annotations.Test;

import com.Common;

import base.BaseClass;
import pageObject.Pageobj;

public class AR_1519 extends BaseClass {

	Common com = new Common();

	@Test

	public void SwBase_SignalLength() throws Exception {
		logger = BaseClass.exreporter.createTest("AR_1519");
		com.LunchApp("D:\\workspace\\");
		String Project = com.CreateProjectOnNewTool("Demo2");
		System.out.println("---->   " + Project);
		String DBCfilelocation = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator
				+ "DBC";
		System.out.println("---------->      " + DBCfilelocation);
		String setEcu = Pageobj.SetECu;
		com.Upload_DBC_File(Project, DBCfilelocation,setEcu);
		String value = Pageobj.SwBaseType;
		com.VerifyDBCDetailsSwBase(Project,value,"2","unsigned char");
		com.closeApplication();
		logger.pass("test case Pass");

	}

}
