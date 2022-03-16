package manualTestCase;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Common;
import com.Utility;

import base.BaseClass;
import pageObject.Pageobj;

public class Redmine_66015 extends BaseClass{
	
	Common com = new Common();
	Utility ut = new Utility();
	Pageobj po = new Pageobj();
	
	@Test
	
	public void VerifyTranferProperty() throws Exception {
		
		logger = BaseClass.exreporter.createTest("AR-1695");
		com.LunchApp("D:\\workspace\\");
		String DBCpath = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator+"AR-1695";
		com.CreateProjectOnNewTool("TestData");
		com.ImportDBCFile("TestData", DBCpath,"HCP");
		String eleone = "SignalPduMapping_CRC_ENGINE_HYBD_FD_3 [ISignalToIPduMapping]";
		String eletwo = "SignalPduMapping_EngCltTmp [ISignalToIPduMapping]";
		String elethree = "SignalPduMapping_EngCltTmpV [ISignalToIPduMapping]";
		String elefour = "SignalPduMapping_EngSpd [ISignalToIPduMapping]";
		String elefive = "SignalPduMapping_MessageCounter_ENGINE_HYBD_FD_3 [ISignalToIPduMapping]";
		String elesix = "SignalPduMapping_RadFanReq [ISignalToIPduMapping]";
		com.TranferPropertyCyclicAllSignal("TestData","ISignalIPdu_ENGINE_HYBD_FD_3_CAN_ePT [ISignalIPdu]",14);
		Map<Integer, String>map =  new HashedMap();
		int count =0;
		map.put(1, eleone);
		map.put(2, eletwo);
		map.put(3, elethree);
		map.put(4, elefour);
		map.put(5, elefive);
		map.put(6, elesix);
		System.out.println(map);
		boolean flag = false;
		for(int i=1;i<=map.size();i++) {
			String ele = map.get(i);
			System.out.println(ele+" =-= -=> "+i);
			flag=com.VerifyProperty(ele,"Transfer Property", "PENDING");
			if(flag=true) {
				count++;
			}
		}
		System.out.println(count);
		Assert.assertEquals(count, 6);
		
	}
	
	@Test
	
	public void VerifyPropertyOnChange() throws Exception {
		logger = BaseClass.exreporter.createTest("AR-1697");
		com.LunchApp("D:\\workspace\\");
		String DBCpath = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator+"AR-1695";
		com.CreateProjectOnNewTool("TestData");
		com.ImportDBCFile("TestData", DBCpath,"HCP");
		boolean flag = false;
		boolean flagN = false;
		com.TranferPropertyCyclicAllSignal("TestData","ISignalIPdu_IMPACT_INFO_CAN_ePT [ISignalIPdu]",45);
		flag=com.VerifyProperty("SignalPduMapping_IMPACTCommand [ISignalToIPduMapping]", "Transfer Property","PENDING");
		flagN=com.VerifyProperty("SignalPduMapping_IMPACTConfirm [ISignalToIPduMapping]", "Transfer Property","TRIGGERED-ON-CHANGE");
		Assert.assertEquals(flag, true);
		Assert.assertEquals(flagN, true);
		com.closeApplication();
	}
	
	@Test
	
	public void VerifyISignalIPdu_LV_CHARGER1_CAN_CProperty() throws Exception {
		
		logger = BaseClass.exreporter.createTest("AR-1698");
		com.LunchApp("D:\\workspace\\");
		String DBCpath = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator+"AR-1698";
		com.ImportProjectSaveWorkspace(DBCpath);
		boolean flag = false;
		boolean flagN = false;
		boolean flagO = false;
		boolean flagOl= false;
		com.TranferPropertyCyclicAllSignal("test","ISignalIPdu_LV_CHARGER1_CAN_C [ISignalIPdu]",75);
		flag=com.VerifyProperty("SignalPduMapping_CRC_LV_CHARGER1 [ISignalToIPduMapping]","Transfer Property", "TRIGGERED-ON-CHANGE-WITHOUT-REPETITION");
		flagN=com.VerifyProperty("SignalPduMapping_DCDC_OperationModeSts [ISignalToIPduMapping]","Transfer Property", "TRIGGERED-ON-CHANGE-WITHOUT-REPETITION");
		//SignalPduMapping_LVDC_CurrentFeedback [ISignalToIPduMapping]
		flagO=com.VerifyProperty("SignalPduMapping_LVDC_CurrentFeedback [ISignalToIPduMapping]","Transfer Property", "PENDING");
		flagOl=com.VerifyProperty("SignalPduMapping_MessageCounter_LV_CHARGER1 [ISignalToIPduMapping]", "Transfer Property","PENDING");
		System.out.println(flag +" =-=--> "+flagN+flagO+flagOl);
		Assert.assertEquals(flag, true);
		Assert.assertEquals(flagN, true);
		Assert.assertEquals(flagO, true);
		Assert.assertEquals(flagOl, true);
		com.closeApplication();
	}

	@Test

	public void VerifyISignalIPdu_HYBRID_THERMAL() throws Exception{
		logger = BaseClass.exreporter.createTest("AR-1699");
		com.LunchApp("D:\\workspace\\");
		String DBCpath = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator+"AR-1699";
		com.ImportProjectSaveWorkspace(DBCpath);
		boolean flag = false;
		boolean flagN = false;
		boolean flagO = false;
		boolean flagOl= false;
		boolean flagNW= false;
		boolean flagy= false;
		com.TranferPropertyCyclicAllSignal("NewPro","ISignalIPdu_HYBRID_THERMAL_COMMAND_CAN_ePT [ISignalIPdu]",42);
		
		flag=com.VerifyProperty("SignalPduMapping_BATHTR_Enbl [ISignalToIPduMapping]","Transfer Property", "PENDING");
		flagN=com.VerifyProperty("SignalPduMapping_BATHTR_PwrCnsAllwd [ISignalToIPduMapping]","Transfer Property", "PENDING");
		//SignalPduMapping_LVDC_CurrentFeedback [ISignalToIPduMapping]
		flagO=com.VerifyProperty("SignalPduMapping_BATHTR_WtrTempDes [ISignalToIPduMapping]","Transfer Property" ,"TRIGGERED-ON-CHANGE");
		flagOl=com.VerifyProperty("SignalPduMapping_LTAP_Cmd [ISignalToIPduMapping]","Transfer Property", "TRIGGERED-ON-CHANGE-WITHOUT-REPETITION");
		flagNW=com.VerifyProperty("SignalPduMapping_LTAP_Failsafe_ACT [ISignalToIPduMapping]","Transfer Property", "TRIGGERED");
		flagy=com.VerifyProperty("SignalPduMapping_LTAP_PostRunCom [ISignalToIPduMapping]","Transfer Property", "PENDING");
		System.out.println(flag +" =-=--> "+flagN+flagO+flagOl+" =-=-=> "+flagNW+" =-=-=> "+flagy);
		Assert.assertEquals(flag, true);
		Assert.assertEquals(flagN, true);
		Assert.assertEquals(flagO, true);
		Assert.assertEquals(flagOl, true);
		Assert.assertEquals(flagNW, true);
		Assert.assertEquals(flagy, true);
		com.closeApplication();

	}

	@Test

	public void VerifyTriggerWithoutRepettion() throws Exception {
		logger = BaseClass.exreporter.createTest("AR-1700");
		com.LunchApp("D:\\workspace\\");
		String DBCpath = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator+"AR-1700";
		com.ImportProjectSaveWorkspace(DBCpath);
		boolean flag = false;
		com.TranferPropertyCyclicAllSignal("NewTest","ISignalIPdu_TRANSM_FD_2_CAN_ePT [ISignalIPdu]",48);
		flag=com.VerifyProperty("SignalPduMapping_GearEngagedForDisplay [ISignalToIPduMapping]","Transfer Property", "TRIGGERED-WITHOUT-REPETITION");
		System.out.println(flag);
		Assert.assertEquals(flag, true);
		com.closeApplication();
	}

@Test

public void VerifyTRIGGER_ON_CHANGE_WITHOUT_REPETITION() throws Exception {

	logger = BaseClass.exreporter.createTest("AR-1701");
		com.LunchApp("D:\\workspace\\");
		String DBCpath = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator+"AR-1701";
		com.ImportProjectSaveWorkspace(DBCpath);
		boolean flag = false;
		boolean flagy = false;
		com.TranferPropertyCyclicAllSignal("NewData","ISignalIPdu_LV_CHARGER1_CAN_C [ISignalIPdu]",66);
		flag=com.VerifyProperty("SignalPduMapping_DCDC_OperationModeSts [ISignalToIPduMapping]","Transfer Property", "TRIGGERED-ON-CHANGE-WITHOUT-REPETITION");
		flagy = com.VerifyProperty("SignalPduMapping_MessageCounter_LV_CHARGER1 [ISignalToIPduMapping]","Transfer Property", "PENDING");
		System.out.println(flag+"  ====>  "+flagy);
		Assert.assertEquals(flag, true);
		Assert.assertEquals(flagy, true);
		com.closeApplication();
}

@Test

public void VerifyTriggerOnChange() throws Exception{

		logger = BaseClass.exreporter.createTest("AR-1702");
		com.LunchApp("D:\\workspace\\");
		String DBCpath = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator+"AR-1702";
		com.ImportProjectSaveWorkspace(DBCpath);
		boolean flag = false;
		boolean flagy = false;
		com.TranferPropertyCyclicAllSignal("DemoProj","ISignalIPdu_TELEMATIC_FD_1_CAN_ePT [ISignalIPdu]",48);
		flag=com.VerifyProperty("SignalPduMapping_GPS_Date_Month [ISignalToIPduMapping]","Transfer Property", "PENDING");
		flagy = com.VerifyProperty("SignalPduMapping_GPS_UTC_Minute [ISignalToIPduMapping]","Transfer Property", "TRIGGERED-ON-CHANGE");
		System.out.println(flag+"  ====>  "+flagy);
		Assert.assertEquals(flag, true);
		Assert.assertEquals(flagy, true);
		com.closeApplication();
}

@Test

public void VerifyTrggeredWithoutRepetition () throws Exception {

	logger = BaseClass.exreporter.createTest("AR-1703");
		com.LunchApp("D:\\workspace\\");
		String DBCpath = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator+"AR-1703";
		com.ImportProjectSaveWorkspace(DBCpath);
		boolean flag = false;
		boolean flagy = false;
		com.TranferPropertyCyclicAllSignal("Demo","ISignalIPdu_LV_CHARGER1_CAN_C [ISignalIPdu]",66);
		flag=com.VerifyProperty("SignalPduMapping_DCDC_OperationModeSts [ISignalToIPduMapping]","Transfer Property", "PENDING");
		flagy = com.VerifyProperty("SignalPduMapping_MessageCounter_LV_CHARGER1 [ISignalToIPduMapping]","Transfer Property", "TRIGGERED-WITHOUT-REPETITION");
		System.out.println(flag+"  ====>  "+flagy);
		Assert.assertEquals(flag, true);
		Assert.assertEquals(flagy, true);
		com.closeApplication();
}

@Test

public void VerifyTriggered () throws Exception{

	logger = BaseClass.exreporter.createTest("AR-1704");
		com.LunchApp("D:\\workspace\\");
		String DBCpath = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator+"AR-1704";
		com.ImportProjectSaveWorkspace(DBCpath);
		boolean flag = false;
		boolean flagy = false;
		com.TranferPropertyCyclicAllSignal("Demo","ISignalIPdu_LV_CHARGER1_CAN_C [ISignalIPdu]",66);
		flag=com.VerifyProperty("SignalPduMapping_DCDC_OperationModeSts [ISignalToIPduMapping]","Transfer Property", "PENDING");
		flagy = com.VerifyProperty("SignalPduMapping_MessageCounter_LV_CHARGER1 [ISignalToIPduMapping]","Transfer Property", "TRIGGERED");
		System.out.println(flag+"  ====>  "+flagy);
		Assert.assertEquals(flag, true);
		Assert.assertEquals(flagy, true);
		com.closeApplication();
}
@Test

public void VerifyTriggeredOnWriteWithRepetition () throws Exception {
		logger = BaseClass.exreporter.createTest("AR-1705");
		com.LunchApp("D:\\workspace\\");
		String DBCpath = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator+"AR-1705";
		com.ImportProjectSaveWorkspace(DBCpath);
		boolean flag = false;
		boolean flagy = false;
		com.TranferPropertyCyclicAllSignal("Demo","ISignalIPdu_LV_CHARGER1_CAN_ePT [ISignalIPdu]",36);
		flag=com.VerifyProperty("SignalPduMapping_DCDC_OperationModeSts [ISignalToIPduMapping]","Transfer Property", "TRIGGERED");
		flagy = com.VerifyProperty("SignalPduMapping_CRC_LV_CHARGER1 [ISignalToIPduMapping]","Transfer Property", "PENDING");
		System.out.println(flag+"  ====>  "+flagy);
		Assert.assertEquals(flag, true);
		Assert.assertEquals(flagy, true);
		com.closeApplication();
}
@Test
public void Verify_ISignalIPdu_Development_APPL_ECU_CAN_D() throws Exception {
	logger = BaseClass.exreporter.createTest("AR-1706");
	com.LunchApp("D:\\workspace\\");
	String DBCpath = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator+"AR-1706";
	com.ImportProjectSaveWorkspace(DBCpath);
	boolean flag = false;
	com.TranferPropertyCyclicAllSignal("NewDemo","ISignalIPdu_Development_APPL_ECU_CAN_D [ISignalIPdu]",6);
	flag=com.VerifyProperty("SignalPduMapping_Development_APPL_ECU [ISignalToIPduMapping]","Transfer Property", "PENDING");
	System.out.println(flag+"  ====>  ");
	Assert.assertEquals(flag, true);
	com.closeApplication();

}

@Test

public void VerifyISignalIPdu_Development_APPL_ECU_CAN_D() throws Exception {

	logger = BaseClass.exreporter.createTest("AR-1707");
	com.LunchApp("D:\\workspace\\");
	String DBCpath = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator+"AR-1706";
	com.ImportProjectSaveWorkspace(DBCpath);
	boolean flag = false;
	com.TranferPropertyCyclicAllSignal("NewDemo","ISignalIPdu_Development_ECU_APPL_CAN_D [ISignalIPdu]",9);
	flag=com.VerifyProperty("SignalPduMapping_Development_ECU_APPL [ISignalToIPduMapping]","Transfer Property", "TRIGGERED");
	System.out.println(flag+"  ====>  ");
	Assert.assertEquals(flag, true);
	com.closeApplication();

}
}
