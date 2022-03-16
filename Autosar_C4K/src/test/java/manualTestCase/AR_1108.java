package manualTestCase;

import java.io.File;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Common;
import com.Utility;

import base.BaseClass;

public class AR_1108 extends BaseClass {
	
	Common com = new Common();
	Utility utl = new Utility();
	@SuppressWarnings("unchecked")
	@Test
	
	public void VerifyExcel() throws Exception {
		
		logger = BaseClass.exreporter.createTest("AR_1108");
		com.LunchApp("D:\\workspace\\hjvhv");
		String filelocation = System.getProperty("user.dir")+File.separator+"ImportProject"+File.separator+"ExportValidation_Project";
		System.out.println("---------->      "+filelocation);
		com.ImportProject(filelocation);
		String Project = "ExportValidation_Project";
		String file = com.VerifyReportName(Project,filelocation);
		 Map< Integer, String>map = new HashedMap();
		 Map< Integer, String>mapn = new HashedMap();
		com.AddErrorsOnFile(Project);
		String txtpath = filelocation+File.separator+"errors.txt";
		map = utl.ReadTXTfile(txtpath);
		String excelpath = filelocation+File.separator+file;
		mapn= utl.Readexcel(excelpath);
		
		for(int i=1;i<map.size();i++) {
			System.out.println(mapn.get(i)+"  ^^^^^^^^^^^^^^^^----- >  "+map.get(i));
			Assert.assertEquals(mapn.get(i), map.get(i));
			
		}
	
		com.closeApplication();
	}

}
