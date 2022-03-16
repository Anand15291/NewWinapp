package manualTestCase;

import java.io.File;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import com.Common;

import base.BaseClass;

public class AR_807 extends BaseClass{
	
	Common com = new Common();
	@Test
	public void EcucReport() throws Exception {
		
		logger = BaseClass.exreporter.createTest("AR_807");
		String value = RandomStringUtils.randomAlphabetic(8);
		System.out.println(value);
		com.LunchApp("D:\\CK4_422\\"+value);
		String Projectlocation = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator+"AR_807";
		//com.CreateProject("Sample");
		System.out.println(Projectlocation);
		com.ImportProject(Projectlocation);
		com.ECUCompareReport("rest");
		com.readHTMLReport();
		com.closeApplication();
		logger.pass("test case Pass");
		
	}
	

}
