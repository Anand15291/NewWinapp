package manualTestCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Common;

import base.BaseClass;
import pageObject.Pageobj;

public class LicenseProductName extends BaseClass {
	
	Common com = new Common();
	
	@Test
	
	public void VerifyProductNameR431() throws Exception {
		logger = BaseClass.exreporter.createTest("AR-1678");
		com.LunchApp("D:\\workspace\\");
		String value = com.VerifyProductLicence();
		System.out.println(value+" 900-0==-=-=-> ");
		//com.closeApplication();
		String value2[] = value.split("\n");
		System.out.println(value2[2]+"  :) ");
		String [] arryversion = value2[2].split(" ");
		String Verion = arryversion[4]+" "+arryversion[5];
		System.out.println(Verion);
		Assert.assertEquals(Verion.trim(), "AUTOSAR R4.3.1");
		com.closeApplication();
	}
//	@Test
//	
//	public void VerifyProductNameR422() throws Exception {
//		logger = BaseClass.exreporter.createTest("AR-1677");
//		com.LunchApp("D:\\workspace\\");
//		String value = com.VerifyProductLicence();
//		System.out.println(value+" 900-0==-=-=-> ");
//		//com.closeApplication();
//		String value2[] = value.split("\n");
//		System.out.println(value2[2]+"  :) ");
//		String [] arryversion = value2[2].split(" ");
//		String Verion = arryversion[4]+" "+arryversion[5];
//		System.out.println(Verion);
//		Assert.assertEquals(Verion.trim(), "AUTOSAR R4.2.2");
//		com.closeApplication();
//	}

	@Test 
	
	public void VerifyStrictMode() throws Exception {
		
		logger = BaseClass.exreporter.createTest("AR-1667");
		com.LunchApp("D:\\workspace\\");
		boolean flag=true;
		try {
		 flag = DesktopSession.findElementByName(Pageobj.Strictmode).isDisplayed();
		}catch (Exception e) {
			System.out.println(e);
		}
		System.out.println(flag);
		logger.pass("Strict mode is Present");
		Assert.assertEquals(flag, true);
		com.closeApplication();
	}
}
