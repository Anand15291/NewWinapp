package manualTestCase;

import org.testng.annotations.Test;

import com.Common;

import base.BaseClass;

public class Basik_Integration extends BaseClass {

	Common com = new Common();

	@Test 
	public void AbasikIntegratedAddonInstall() throws Exception {
		logger = BaseClass.exreporter.createTest("BasikTool_Integrate_As_Addon_AR1603");
		com.LunchApp("D:\\compose4ksar-18.1.3-win32.win32.x86_64\\AR1603");
		com.basikToll_Integraate_As_Addon();
		com.closeApplication();
	}
	
	
	@Test 
	public void BbasikToolReinstall() throws Exception {
		logger = BaseClass.exreporter.createTest("BasikTool_Reinstall_AR1606");
		com.LunchApp("D:\\compose4ksar-18.1.3-win32.win32.x86_64\\AR1606");
		com.uninstall_BasikToll_Integraate_As_Addon();
		com.basikToll_Reinstall();
		com.closeApplication();
	}
	
	@Test 
	public void CbasikToolShouldNotDisplayAfterUninstallation() throws Exception {
		logger = BaseClass.exreporter.createTest("BasikTool_Reinstall_AR1615");
		com.LunchApp("D:\\compose4ksar-18.1.3-win32.win32.x86_64\\AR1615");
		com.uninstall_BasikToll_Integraate_As_Addon();
		com.closeApplication();
	}
	
	@Test 
	public void DbasikInterfaceValodation() throws Exception {
		logger = BaseClass.exreporter.createTest("BasikTool_Integrate_Interface_AR1601");
		com.LunchApp("D:\\compose4ksar-18.1.3-win32.win32.x86_64\\AR1601");
		com.basikToll_Integraate_As_Addon();
		com.basikTool_Interface();
		com.uninstall_BasikToll_Integraate_As_Addon();
		com.closeApplication();
	}
	
}
