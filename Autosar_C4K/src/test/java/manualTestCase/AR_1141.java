package manualTestCase;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Common;

import base.BaseClass;
import pageObject.Pageobj;

public class AR_1141 extends BaseClass {
	
	Common com = new Common();
	
	@Test
	public void propertiesValidator() throws Exception {
		logger = BaseClass.exreporter.createTest("AR_1141");
		Actions act = new Actions(DesktopSession);
		Robot rb = new Robot();
		com.LunchApp("D:\\compose4ksar-18.1.3-win32.win32.x86n_64\\AR1141");
		//com.CreateTwoProject("AR1141");
		String ProjectPath = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator+"MergeFiles";
		com.ImportProject(ProjectPath);
		DesktopSession.findElementByName(Pageobj.Properties_Tab).click();
		System.out.println("clicked on properties");
		Thread.sleep(1000);
		act.contextClick().perform();
		System.out.println("right clicked");
		logger.pass("Clicked On Properties Button");
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyPress(KeyEvent.VK_CONTROL);
		Thread.sleep(4000);
		DesktopSession.findElementByName("Sam").click();
		DesktopSession.findElementByName("Tom").click();
		act.contextClick().perform();
		Thread.sleep(1000);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		System.out.println(DesktopSession.findElementByXPath("//*[@LocalizedControlType = 'menu item']").isDisplayed());
		System.out.println(DesktopSession.findElementByName("Properties").getText());
		
		Map<Integer, String>map = new HashMap<Integer, String>();
		List<WebElement> lst = DesktopSession.findElementsByXPath("//*[@LocalizedControlType = 'menu item']");
		System.out.println(lst.size());
		for(int i = 0 ;i<=lst.size()-1;i++) {
			String menus = lst.get(i).getAttribute("Name");
			System.out.println(menus+" =-=-=-> ");
			map.put(i, menus);
		}
	 boolean flag = map.containsValue("Properties");
	 System.out.println(flag+" -=-=-=> ");
	 Assert.assertEquals(flag, false);
		//com.closeApplication();
		
	}

}
