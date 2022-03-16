package manualTestCase;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.Common;

import base.BaseClass;
import pageObject.Pageobj;

public class DBC extends BaseClass {

	Common com = new Common();
	public Pageobj po = new Pageobj();

	@Test
	public void VerifyTxtFile() throws Exception {

		logger = BaseClass.exreporter.createTest("AR_1441");
		com.LunchApp("D:\\workspace\\");
		com.CreateProjectOnNewTool("DBC_Project");
		com.VerifyTXTfile();
		com.closeApplication();
	}

	@Test

	public void VerifyTxtFileLDF() throws Exception {

		logger = BaseClass.exreporter.createTest("AR_1451");
		com.LunchApp("D:\\workspace\\");
		com.CreateProjectOnNewTool("LDF_Project");
		com.VerifyTXTfileLDF();
		com.closeApplication();
	}

}
