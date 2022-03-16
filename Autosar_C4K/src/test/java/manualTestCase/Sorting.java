package manualTestCase;

import java.io.File;

import org.testng.annotations.Test;

import com.Common;

import base.BaseClass;

public class Sorting extends BaseClass {
	
	Common com = new Common();
	@Test
	
	public void SortRootlabelelement() throws Exception {
		
		logger = BaseClass.exreporter.createTest("AR-1660");
		com.LunchApp("D:\\workspace\\");
		String Projectpath = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator+"NewProject";
		System.out.println(Projectpath);
		com.ImportProject(Projectpath);
		com.SortingValidation("NewProject");
		com.closeApplication();
	}
	@Test
	
	public void Sortchildlabelelement() throws Exception {
		
		logger = BaseClass.exreporter.createTest("AR-1661");
		com.LunchApp("D:\\workspace\\");
		String Projectpath = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator+"ProjectNw";
		System.out.println(Projectpath);
		com.ImportProject(Projectpath);
		com.SortingChildLebel("ProjectNew");
		com.closeApplication();
	}

}
