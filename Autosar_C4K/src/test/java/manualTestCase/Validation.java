package manualTestCase;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.awt.Desktop.Action;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.Common;

import base.BaseClass;

public class Validation extends BaseClass{
	
	Common com = new Common();
	@Test
	
	public void VerifyMultiplicityContraints() throws Exception {
		
		logger = BaseClass.exreporter.createTest("AR-77");
		com.LunchApp("D:\\workspace\\");
		com.CreateProjectOnNewTool("TestOroject");
		Thread.sleep(3000);
		com.NewCreateDefaultArxml("TestOroject");
		com.VerifyContraints("TestOroject");
		com.closeApplication();
	}
	@Test
	
	public void VerifyValidationError() throws Exception {
		
		logger = BaseClass.exreporter.createTest("AR-1020");
		com.LunchApp("D:\\workspace\\");
		com.CreateProjectOnNewTool("TestOroject");
		Thread.sleep(3000);
		String Filepath = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator
				+ "AR_1020";
		System.out.println(Filepath);
		com.ImportArxmlFile("TestOroject", "ECU_Extract.arxml", Filepath);
		String Validationfile = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator
				+ "AR_1032";
		com.VerifyValidationTxt("TestOroject", Validationfile);
		com.ReadValidationTxt(Validationfile);
		com.closeApplication();
		com.closeApplication();
	}
	
@Test
	
	public void VerifyValidationErrorInAscending() throws Exception {
		
		logger = BaseClass.exreporter.createTest("AR-1032");
		com.LunchApp("D:\\workspace\\");
		com.CreateProjectOnNewTool("TestOroject");
		Thread.sleep(3000);
		String Filepath = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator
				+ "AR_1020";
		System.out.println(Filepath);
		com.ImportArxmlFile("TestOroject", "ECU_Extract.arxml", Filepath);
		String Validationfile = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator
				+ "AR_1032";
		com.VerifyValidationTxt("TestOroject", Validationfile);
		com.ReadValidationTxt(Validationfile);
		com.closeApplication();
	}
}
