package manualTestCase;

import java.io.File;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import com.Common;

import base.BaseClass;

public class AR_1137 extends BaseClass{
	
	Common com = new Common();
	
	@Test
	public void VerifyHTMLfiles () throws Exception {
		

		logger = BaseClass.exreporter.createTest("AR_1137");
		String value = RandomStringUtils.randomAlphabetic(8);
		System.out.println(value);
		com.LunchApp("D:\\workspace\\t7t");
		String Projectlocation = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator+"CompareECUCExtract";
		System.out.println(Projectlocation);
		com.ImportProject(Projectlocation);
		String Ecucfile1 = "Merged_DiagExtract_r17.arxml";
		String Ecucfile2 = "Merged_DiagExtract_r18.arxml";
		String filename1 = "Merged_DiagExtract_r17";
		String filename2 = "Merged_DiagExtract_r18";
		String report17Path = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator+"ECUCReport"+File.separator+"Merged_DiagExtract_r17";
		String report18Path = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator+"ECUCReport"+File.separator+"Merged_DiagExtract_r18";
		String Projectname = "Compare_ECUC_Extract";
		com.CompareECUC(Projectname, Ecucfile1, filename2, report17Path);
		Thread.sleep(1000);
		com.CompareECUC(Projectname, Ecucfile2, filename1, report18Path);
		com.CompareTwoECUC_Report(report17Path, report18Path);
		com.closeApplication();
		logger.pass("test case Pass");
	}
	
	
	@Test
	
	public void GetTimestamp() {
		logger = BaseClass.exreporter.createTest("AR_11375");
		String str = com.GetTime();
		System.out.println(str);
		String str1 = str.toString();
		System.out.println(str.length());
		System.out.println(str.charAt(str.length()-1)+" =--=-> ");
		String no = str.substring(str.length()-3, str.length());
		System.out.println(no+" ----->  ");
		int number = Integer.parseInt(no);
		System.out.println(number+3+"  -=-=> ");
		
		for(int i=0;i<=28;i++) {
			number++;
			
		//	str.replaceAll(no, number);
		}
	}

}
