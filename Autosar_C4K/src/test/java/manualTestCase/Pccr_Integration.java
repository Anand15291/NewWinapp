package manualTestCase;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.nio.file.Paths;
import java.util.List;

import org.testng.annotations.Test;

import com.Common;

import base.BaseClass;

public class Pccr_Integration extends BaseClass{
	
	Common com = new Common();
	
	
	@Test (priority=1)
	public void codeGeneration() throws Exception {
		logger = BaseClass.exreporter.createTest("Code_Generation_AR1599");
		 com.LunchApp("D:\\compose4ksar-18.1.3-win32.win32.x86_64\\AR1599");
		
		  String ProjPath = System.getProperty("user.dir") + File.separator +"ImportProject" + File.separator+"pccr";
		  com.ImportProject(ProjPath);
		  com.code_Generation("pccr");
		  
		  String FilePathH = System.getProperty("user.dir") + File.separator +"ImportProject" + File.separator+"pccr"+ File.separator+"pccr"+ File.separator+"22_MemIf"+ File.separator+"inc";
		  String FilePathc = System.getProperty("user.dir") + File.separator +"ImportProject" + File.separator+"pccr"+ File.separator+"pccr"+ File.separator+"22_MemIf"+ File.separator+"src";
		  boolean HExt = com.ValidateExtensionsFiles(FilePathH, ".h");
		  boolean CExt = com.ValidateExtensionsFiles(FilePathc, ".c");
		  assertEquals(HExt, true);
		  assertEquals(CExt, true);
		  com.closeApplication();
		  com.closeApplication();
		 //"D:\\Automation_C4K\\winappdriver_automation\\Autosar_C4K\\ImportProject\\pccr\\pccr\\22_MemIf\\inc"
		
		
	}
	
	
	@Test (priority=2)
	public void pccrinstallValidation() throws Exception {
		logger = BaseClass.exreporter.createTest("Code_Generation_AR1600");
		 com.LunchApp("D:\\workspace");
		
		  String ProjPath = System.getProperty("user.dir") + File.separator +"ImportProject" + File.separator+"pccr";
		  com.ImportProject(ProjPath);
		  com.installPCCR_As_Addon_Validation();
		  com.closeApplication();
	}

}
