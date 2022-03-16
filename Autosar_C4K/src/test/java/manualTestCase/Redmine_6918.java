package manualTestCase;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Common;
import com.Utility;

import base.BaseClass;
import pageObject.Pageobj;

public class Redmine_6918 extends BaseClass{

	Common com = new Common();
	Utility ut = new Utility();
	Pageobj po = new Pageobj();
	
	@Test
	
	public void ECUCMappingForDEMModule() throws Exception {
		
		logger = BaseClass.exreporter.createTest("AR-1796");
		com.LunchApp("D:\\workspace\\");
		String FilePath = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator + "AR-1769";
		com.ImportProjectSaveWorkspace(FilePath);
		Thread.sleep(1000);
		com.GenerateECUCMappingForDem("KEIHIN_421");
		com.VerifyDemModule("KEIHIN_421");
		com.closeApplication();
	}

	@Test

	public void VerifyOrderOfDemDtr() throws Exception {

		logger = BaseClass.exreporter.createTest("AR-1797");
		com.LunchApp("D:\\workspace\\");
		String FilePath = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator + "AR-1769";
		com.ImportProjectSaveWorkspace(FilePath);
		Thread.sleep(1000);
		com.GenerateECUCMappingForDem("KEIHIN_421");
		Map <Integer,String>map= new HashMap<>();
		map = com.VerifyDemModule("KEIHIN_421");
		System.out.println(map);
		Assert.assertEquals(map.get(0), "DemDtr_MID01T80 [DemDtr_USD]");
		Assert.assertEquals(map.get(1), "DemDtr_MID01T81 [DemDtr_USD]");
		Assert.assertEquals(map.get(2), "DemDtr_MID05T80 [DemDtr_USD]");
		Assert.assertEquals(map.get(3), "DemDtr_MID05T81 [DemDtr_USD]");
		Assert.assertEquals(map.get(4), "DemDtr_MID41TA0 [DemDtr_USD]");
		Assert.assertEquals(map.get(5), "DemDtr_MID45TA0 [DemDtr_USD]");
		Assert.assertEquals(map.get(6), "DemDtr_MID81TB0 [DemDtr_USD]");
		Assert.assertEquals(map.get(7), "DemDtr_MID82TB0 [DemDtr_USD]");
		Assert.assertEquals(map.get(8), "DemDtr_MIDA1T90 [DemDtr_USD]");
		Assert.assertEquals(map.get(9), "DemDtr_MIDA1T91 [DemDtr_USD]");
		Assert.assertEquals(map.get(10), "DemDtr_MIDA2T92 [DemDtr_USD]");
		Assert.assertEquals(map.get(11), "DemDtr_MIDA2T93 [DemDtr_USD]");
		Assert.assertEquals(map.get(12), "DemDtr_MIDA3T92 [DemDtr_USD]");
		Assert.assertEquals(map.get(13), "DemDtr_MIDA3T93 [DemDtr_USD]");
		com.closeApplication();
	}
	
	@Test

	public void VerifyDemDtrOrder() throws Exception {

		logger = BaseClass.exreporter.createTest("AR-1798");
		com.LunchApp("D:\\workspace\\");
		String FilePath = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator + "AR-1769";
		com.ImportProjectSaveWorkspace(FilePath);
		Thread.sleep(1500);
		com.GenerateECUCMappingForDem("KEIHIN_421");
		Map <Integer,String>map= new HashMap<>();
		map = com.VerifyDemModule("KEIHIN_421");
		System.out.println(map);
		Assert.assertEquals(map.get(0), "DemDtr_MID01T80 [DemDtr_USD]");
		Assert.assertEquals(map.get(1), "DemDtr_MID01T81 [DemDtr_USD]");
		Assert.assertEquals(map.get(2), "DemDtr_MID05T80 [DemDtr_USD]");
		Assert.assertEquals(map.get(3), "DemDtr_MID05T81 [DemDtr_USD]");
		Assert.assertEquals(map.get(4), "DemDtr_MID41TA0 [DemDtr_USD]");
		Assert.assertEquals(map.get(5), "DemDtr_MID45TA0 [DemDtr_USD]");
		Assert.assertEquals(map.get(6), "DemDtr_MID81TB0 [DemDtr_USD]");
		Assert.assertEquals(map.get(7), "DemDtr_MID82TB0 [DemDtr_USD]");
		Assert.assertEquals(map.get(8), "DemDtr_MIDA1T90 [DemDtr_USD]");
		Assert.assertEquals(map.get(9), "DemDtr_MIDA1T91 [DemDtr_USD]");
		Assert.assertEquals(map.get(10), "DemDtr_MIDA2T92 [DemDtr_USD]");
		Assert.assertEquals(map.get(11), "DemDtr_MIDA2T93 [DemDtr_USD]");
		Assert.assertEquals(map.get(12), "DemDtr_MIDA3T92 [DemDtr_USD]");
		Assert.assertEquals(map.get(13), "DemDtr_MIDA3T93 [DemDtr_USD]");
		com.closeApplication();
	}
}
