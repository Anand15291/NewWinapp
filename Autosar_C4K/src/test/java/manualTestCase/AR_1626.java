package manualTestCase;

import org.testng.annotations.Test;

import com.Common;

import base.BaseClass;

public class AR_1626 extends BaseClass{
	
Common com = new Common();
	
	@Test
	
	public void CheckSearchedResult () throws Exception {
		
		logger = BaseClass.exreporter.createTest("AR_1626");
		com.LunchApp("D:\\CK4_422\\search");
		String value = "Creating a Java class";
		com.SearchedContent(value);
		com.closeApplication();
		logger.pass("test case Pass");
	}
	
	
@Test
	
	public void checkNavigation () throws Exception {
		
		logger = BaseClass.exreporter.createTest("AR_1625");
		com.LunchApp("D:\\CK4_422\\navi");
		com.navigateToLink();
		com.closeApplication();
		logger.pass("test case Pass");
	}

}
