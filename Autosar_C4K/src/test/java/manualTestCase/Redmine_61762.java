package manualTestCase;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Common;
import com.Utility;

import base.BaseClass;
import pageObject.Pageobj;

public class Redmine_61762 extends BaseClass{

	
	Common com = new Common();
	Utility ut = new Utility();
	public Pageobj po = new Pageobj();
	
	@Test
	
	public void BatchValidationOnEmptyContainer() throws Exception {
		logger = BaseClass.exreporter.createTest("AR-1825");
		com.LunchApp("D:\\workspace\\");
		String FilePath = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator + "AR-1825";
		com.ImportProjectSaveWorkspace(FilePath);
		boolean flag = com.VerifyBatchValidationOnEmptyIpduContainer("NewTest");
		System.out.println(flag);
		com.closeApplication();
		Assert.assertEquals(flag, true);
	}
	@Test
	
	public void BatchValidationOnContainer() throws Exception {
		logger = BaseClass.exreporter.createTest("AR-1827");
		com.LunchApp("D:\\workspace\\");
		String FilePath = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator + "AR-1827";
		com.ImportProjectSaveWorkspace(FilePath);
		boolean flag = com.VerifyBatchValidationOnEmptyIpduContainer("TestData");
		System.out.println(flag);
		com.closeApplication();
		Assert.assertEquals(flag, false);
	}

}
