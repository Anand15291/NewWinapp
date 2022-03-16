package manualTestCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Common;

import base.BaseClass;

public class Group_By extends BaseClass {
	
	Common com = new Common();
	@Test
	
	public void VerifyTargetObject() throws Exception {
		
		logger = BaseClass.exreporter.createTest("AR-1657");
		com.LunchApp("D:\\workspace\\");
		com.CreateProjectOnNewTool("Demo");
		boolean flag  = com.verifyObject("Target Object","Demo");
		System.out.println(flag);
		Assert.assertEquals(flag, false);
		com.closeApplication();
	}
	

@Test
	
	public void VerifyRuleLabel() throws Exception {
		
		logger = BaseClass.exreporter.createTest("AR-1658");
		com.LunchApp("D:\\workspace\\");
		com.CreateProjectOnNewTool("Demo");
		boolean flag  = com.verifyObject("Rule Label","Demo");
		System.out.println(flag);
		Assert.assertEquals(flag, false);
		com.closeApplication();
	}

@Test

public void VerifyMessageID() throws Exception {
	
	logger = BaseClass.exreporter.createTest("AR-1659");
	com.LunchApp("D:\\workspace\\");
	com.CreateProjectOnNewTool("Demo");
	boolean flag  = com.verifyObject("Message ID","Demo");
	System.out.println(flag);
	Assert.assertEquals(flag, true);
	com.closeApplication();
}

@Test

public void VerifyBSWModule() throws Exception {
	
	logger = BaseClass.exreporter.createTest("AR-1662");
	com.LunchApp("D:\\workspace\\");
	com.CreateProjectOnNewTool("Demo");
	boolean flag  = com.verifyObject("BSW Module","Demo");
	System.out.println(flag);
	Assert.assertEquals(flag, true);
	com.closeApplication();
}
@Test

public void VerifyBSWModuleErrorswarningsInfo() throws Exception {
	
	logger = BaseClass.exreporter.createTest("AR-1663");
	com.LunchApp("D:\\workspace\\");
	com.CreateProjectOnNewTool("Demo");
	com.BSWgroupbyErrors("Demo", "BSW Module");
	com.closeApplication();
}
}
