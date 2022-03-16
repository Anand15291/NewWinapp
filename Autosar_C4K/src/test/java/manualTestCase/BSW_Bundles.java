package manualTestCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Common;

import base.BaseClass;

public class BSW_Bundles extends BaseClass {

	Common com = new Common();
	
	@Test
	
	public void VerifyErrorLog() throws Exception {
		
		logger = BaseClass.exreporter.createTest("AR-989");
		com.LunchApp("D:\\workspace\\");
		Thread.sleep(2000);
		DesktopSession.findElementByName("Quick Access").click();
		DesktopSession.findElementByName("Quick Access").sendKeys("Error Log");
		Thread.sleep(500);
		boolean flag1 = false;
		DesktopSession.findElementByName("Error Log (General)").click();
		boolean flag = DesktopSession.findElementByName("Error Log").isDisplayed();
		System.out.println(flag);
		try {
			 flag1 = DesktopSession.findElementByName("bundle unable to install").isDisplayed();
			System.out.println(flag1);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		Assert.assertEquals(flag, true);
		Assert.assertEquals(flag1, false);
	}
}
