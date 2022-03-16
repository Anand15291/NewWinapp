package manualTestCase;

import org.testng.annotations.Test;

import com.Common;

import base.BaseClass;

public class AR_1055 extends BaseClass{
	
Common com = new Common();
	
	@Test
	public void computeCanFiltersValidation() throws Exception {
		logger = BaseClass.exreporter.createTest("AR_1055");
		com.LunchApp("D:\\compose4ksar-18.1.3-win32.win32.x86_64\\AR1055");
		com.computeCanValidations();
		com.closeApplication();
	}

}
