package manualTestCase;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Common;
import com.Utility;

import base.BaseClass;
import pageObject.Pageobj;

public class Redmine_61761 extends BaseClass{

	
	Common com = new Common();
	Utility ut = new Utility();
	public Pageobj po = new Pageobj();
	
	@Test
	
	public void BatchValidationOnEmptyContainer() throws Exception {
		logger = BaseClass.exreporter.createTest("AR-1811");
		com.LunchApp("D:\\workspace\\");
		String FilePath = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator + "AR-1811";
		com.ImportProjectSaveWorkspace(FilePath);
		boolean flag = com.VerifyBatchValidationOnEmptyContainer("NewTest");
		Assert.assertEquals(flag, true);
		com.closeApplication();
		
	}
	
	@Test
	
	public void BatchValidationOnContainer() throws Exception {
		
		logger = BaseClass.exreporter.createTest("AR-1812");
		com.LunchApp("D:\\workspace\\");
		String FilePath = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator + "AR-1812";
		com.ImportProjectSaveWorkspace(FilePath);
		boolean flag = com.VerifyBatchValidationOnEmptyContainer("Demo");
		Assert.assertEquals(flag, false);
		com.closeApplication();
		
	}
	
@Test
	
	public void BatchValidationOnContainers() throws Exception {
		
		logger = BaseClass.exreporter.createTest("AR-1813");
		com.LunchApp("D:\\workspace\\");
		String FilePath = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator + "AR-1812";
		com.ImportProjectSaveWorkspace(FilePath);
		boolean flag = com.VerifyBatchValidationOnEmptyContainer("Demo");
		Assert.assertEquals(flag, false);
		com.closeApplication();
		
	}
}
