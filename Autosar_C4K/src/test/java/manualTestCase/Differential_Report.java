package manualTestCase;

import java.awt.Robot;
import java.io.File;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Common;

import base.BaseClass;

public class Differential_Report extends BaseClass {

	Common com = new Common();

	@Test

	public void VerifyEcucReportHTML() throws Exception {

		logger = BaseClass.exreporter.createTest("AR-911");
		com.LunchApp("D:\\workspace\\");
		// RegressionTest_Generate_DifferentialReport
		String Projectpath = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator
				+ "RegressionTest_Generate_DifferentialReport";
		com.ImportProject(Projectpath);
		com.VerifyHTMLfile();
		com.closeApplication();
	}

	@Test
	public void VerifySampleReportHTML() throws Exception {

		logger = BaseClass.exreporter.createTest("AR-912");
		com.LunchApp("D:\\workspace\\");
		String Projectpath = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator
				+ "Regression_Generate_DifferentialReport";
		com.ImportProject(Projectpath);
		com.VerifySampleHTMLReport();
		com.closeApplication();
	}
}
