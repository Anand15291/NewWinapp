package manualTestCase;

import java.io.File;
import java.util.List;
import java.awt.event.KeyEvent;
import com.Common;
import com.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pageObject.Pageobj;

public class Redmine_68572 extends BaseClass{

    Common com = new Common();
	Utility ut = new Utility();
	Pageobj po = new Pageobj();

    @Test

    public void VerifyTheDataTypePolicy () throws Exception {

        logger = BaseClass.exreporter.createTest("AR-1816");
		com.LunchApp("D:\\workspace\\");
		String DBCpath = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator+"AR-1816";
		com.ImportProjectSaveWorkspace(DBCpath);
		boolean flag = false;
        com.TranferPropertyCyclicAllSignal("NewProj","ISignal_AUX_HYBRID_POWERTRAIN_MtrA_3PS_Possible_CAN_ePT [ISignal]",52);
        flag = com.VerifyProperty("ISignal_AUX_HYBRID_POWERTRAIN_MtrA_3PS_Possible_CAN_ePT [ISignal]","Data Type Policy","LEGACY");
        System.out.println(flag);
        Assert.assertEquals(flag, true);
        com.closeApplication();
    }

    @Test

    public void VerifyNetworkRepresentationProps() throws Exception {

        logger = BaseClass.exreporter.createTest("AR-1818");
		com.LunchApp("D:\\workspace\\");
		String DBCpath = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator+"AR-1816";
		com.ImportProjectSaveWorkspace(DBCpath);
		boolean flag = false;
        com.TranferPropertyCyclicAllSignal("NewProj","ISignal_AUX_HYBRID_POWERTRAIN_MtrA_3PS_Possible_CAN_ePT [ISignal]",52);
        DesktopSession.findElementByName("Sw Data Def Props [SwDataDefProps]").click();
        com.ExpandProject(1);
        try {
            flag = DesktopSession.findElementByName("Sw Data Def Props Conditional [SwDataDefPropsConditional]").isDisplayed();
            System.out.println(flag+" 0990----> ");
        } catch (Exception e) {
            //TODO: handle exception
        }
        Assert.assertEquals(flag, true);
        com.closeApplication();

    }

    
    @Test

    public void VerifyPropertiesOfNetworkRepresentationProps () throws Exception {

        logger = BaseClass.exreporter.createTest("AR-1819");
        Robot rb = new Robot();
		Actions act = new Actions(DesktopSession);
		com.LunchApp("D:\\workspace\\");
		String DBCpath = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator+"AR-1816";
		com.ImportProjectSaveWorkspace(DBCpath);
		boolean flag = false;
        com.TranferPropertyCyclicAllSignal("NewProj","ISignal_BCM_FD_10_CmdIgnSts_CAN_ePT [ISignal]",57);
        Thread.sleep(2000);
        DesktopSession.findElementByName("Sw Data Def Props [SwDataDefProps]").click();
        logger.pass("Clicked the SwDataDefProps");
        com.ExpandProject(1);
        DesktopSession.findElementByName("Sw Data Def Props Conditional [SwDataDefPropsConditional]").click();
		logger.pass("Clicked the module ele");
		DesktopSession.findElementByName(po.Properties_Tab).click();
		Thread.sleep(500);
		//WebElement prop = DesktopSession.findElementByName(po.Properties_Tab);
		act.doubleClick(DesktopSession.findElementByName(po.Properties_Tab)).build().perform();
		logger.pass("Double Clicked the Properties tab");
		Thread.sleep(500);
		//Transfer Property
		DesktopSession.findElementByName("Base Type").click();
		logger.pass("Clicked the Transfer Property");
        DesktopSession.findElementByName("Open").click();
        Thread.sleep(500);
        for(int j=0;j<=45;j++) {
            rb.keyPress(KeyEvent.VK_DOWN);
            rb.keyRelease(KeyEvent.VK_DOWN);
            logger.pass("Scrolling");
            }
        WebElement wb = DesktopSession.findElementByName("SwBaseType_SG_LEN_3_0_UNSIGNED [/AUTOSAR/SwBaseType_SG_LEN_3_0_UNSIGNED]");
        wb.click();
        String data="";
        List<WebElement>lst = DesktopSession.findElementsByXPath("//*[@LocalizedControlType='document']");
		System.out.println(lst.size()+" -=-> ");
		for(int i= 0;i<=lst.size()-1;i++) {
			String val = lst.get(i).getAttribute("Value.Value");
			System.out.println(val+"  0 - -= -> ");
			try {
			if(val.equalsIgnoreCase("SwBaseType_SG_LEN_3_0_UNSIGNED [/AUTOSAR/SwBaseType_SG_LEN_3_0_UNSIGNED]")) {
				val = data;
			}
			}catch (Exception e) {
				
			}
		}
        DesktopSession.findElementByName(po.Properties_Tab).click();
		//WebElement propn = DesktopSession.findElementByName(po.Properties_Tab);
		act.doubleClick().build().perform();
		logger.pass("Double Clicked the Properties tab");
        String Lengthonly= data.replaceAll("[^1-9]", "");
        System.out.println(Lengthonly+"  ==-=-=> ");
    }

}

