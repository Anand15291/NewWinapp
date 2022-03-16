package manualTestCase;

import java.awt.Desktop.Action;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Common;

import base.BaseClass;
import pageObject.Pageobj;

@SuppressWarnings("unused")
public class AR_1381 extends BaseClass{
	
Common com = new Common();
	
	@SuppressWarnings("unchecked")
	@Test
	public void pathVerificationOfApp() throws Exception {
		
		
		logger = BaseClass.exreporter.createTest("AR_1381");
		String AppPath1 = "D:\\compose4ksar-18.1.3-win32.win32.x86_64\\Krish";
		
		com.verifyPreviousLocation(AppPath1); 
		Thread.sleep(2000); 
	    Setup();
		Thread.sleep(2000);
		DesktopSession = Root();
		List <WebElement> wb = DesktopSession.findElementsByClassName("Edit");
		System.out.println(wb.size());
		logger.pass("Verified the previous path of the Application");
		String pathVerify1 = wb.get(1).getAttribute("Value.Value");
		System.out.println(pathVerify1);
		Assert.assertEquals(pathVerify1, AppPath1);
		logger.pass("Expected Path"+ AppPath1+" "+ "Actual Path" + pathVerify1);
		logger.pass("Verified the previous path of the Application");
		DesktopSession.findElementByName("Cancel").click();
		logger.pass("Second Application Instance has been launched and closed");    
	
	}

}
