package com;

import java.lang.*;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.zone.ZoneOffsetTransitionRule.TimeDefinition;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.sl.draw.geom.Path;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.mongodb.diagnostics.logging.Logger;

import base.BaseClass;
import freemarker.cache.WebappTemplateLoader;
import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;
import manualTestCase.WindowsProcessKiller;
import pageObject.Pageobj;

@SuppressWarnings("unused")
public class Common extends BaseClass {

	public Pageobj po = new Pageobj();
	public WindowsProcessKiller processkill = new WindowsProcessKiller();

	public String GetTime() {

		Date today = new Date();

		// displaying this date on IST timezone
		DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		df.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));
		String IST = df.format(today);
		System.out.println("Date in Indian Timezone (IST) : " + IST);
		return IST;

	}

	public void LunchApp(String AppPath) throws Exception {
		int length = 7;
		boolean useLetters = true;
		boolean useNumbers = true;
		DesktopSession = Root();
		Actions rightclick = new Actions(DesktopSession);
		logger.pass("Application opened");
		DesktopSession.findElementByName(Pageobj.workspaces).click();
		logger.pass("Click on the Workspace");
		String select = Keys.chord(Keys.CONTROL, "a");
		rightclick.sendKeys(DesktopSession.findElementByXPath(Pageobj.workspace), select);
		rightclick.perform();
		String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
		rightclick.sendKeys(DesktopSession.findElementByXPath(Pageobj.workspace), AppPath + "" + generatedString);
		// rightclick.sendKeys(DesktopSession.findElementByXPath(Pageobj.workspace),
		// AppPath);
		rightclick.perform();
		logger.pass("entered the Workspace path");
		DesktopSession.findElementByName(Pageobj.Launch).click();
		logger.pass("Clicked Ok");
		Thread.sleep(11000);
		WebElement max = DesktopSession.findElementByXPath(Pageobj.Maximize);
		rightclick.doubleClick(max).perform();
		logger.pass("Maximized");
		logger.pass("Sencond Application Instance has been launched");
	}

	//

	public void ImportProject(String PathDir) throws Exception {
		DesktopSession = Root();
		Robot rbb = new Robot();
		Actions rightclickaS = new Actions(DesktopSession);
		System.out.println("===================>     " + DesktopSession.findElementByName(Pageobj.File).isDisplayed());
		DesktopSession.findElementByName(Pageobj.File).click();
		logger.pass("Clicked On File");
		DesktopSession.findElementByName(Pageobj.Import).click();
		logger.pass("Clicked On Import");
		DesktopSession.findElementByClassName(Pageobj.Edit).click();
		logger.pass("Clicked On Edit");
		DesktopSession.findElementByName(Pageobj.General_Folder).click();
		logger.pass("Clicked On General");
		rbb.keyPress(KeyEvent.VK_RIGHT);
		rbb.keyPress(KeyEvent.VK_RIGHT);
		logger.pass("Expaned General");
		DesktopSession.findElementByName(Pageobj.Existing_dir).click();
		logger.pass("Clicked On Existing Project dir");
		DesktopSession.findElementByName(Pageobj.Next_Button).click();
		logger.pass("Clicked On Next");
		DesktopSession.findElementByName(Pageobj.Select_Root_dir).click();
		DesktopSession.findElementByClassName(Pageobj.Edit).click();
		WebElement field = DesktopSession.findElementByName(Pageobj.Select_Root_dir);
		rightclickaS.sendKeys(field, PathDir);
		rightclickaS.perform();
		logger.pass("Entered the Dir");
		DesktopSession.findElementByClassName(Pageobj.TreeView32).click();
		// DesktopSession.findElementByName(Pageobj.CopyToProject).click();
		DesktopSession.findElementByName(Pageobj.Finish_Button).click();
		System.out.println("done ----> ");
		// Thread.sleep(2000);
		logger.pass("Clicked On Finish");
	}

	public void CopyProjectToWorkspace(String PathDir) throws Exception {
		DesktopSession = Root();
		Robot rbb = new Robot();
		Actions rightclickaS = new Actions(DesktopSession);
		System.out.println("===================>     " + DesktopSession.findElementByName(Pageobj.File).isDisplayed());
		DesktopSession.findElementByName(Pageobj.File).click();
		logger.pass("Clicked On File");
		DesktopSession.findElementByName(Pageobj.Import).click();
		logger.pass("Clicked On Import");
		DesktopSession.findElementByClassName(Pageobj.Edit).click();
		logger.pass("Clicked On Edit");
		DesktopSession.findElementByName(Pageobj.General_Folder).click();
		logger.pass("Clicked On General");
		rbb.keyPress(KeyEvent.VK_RIGHT);
		rbb.keyPress(KeyEvent.VK_RIGHT);
		logger.pass("Expaned General");
		DesktopSession.findElementByName(Pageobj.Existing_dir).click();
		logger.pass("Clicked On Existing Project dir");
		DesktopSession.findElementByName(Pageobj.Next_Button).click();
		logger.pass("Clicked On Next");
		DesktopSession.findElementByName(Pageobj.Select_Root_dir).click();
		DesktopSession.findElementByClassName(Pageobj.Edit).click();
		WebElement field = DesktopSession.findElementByName(Pageobj.Select_Root_dir);
		rightclickaS.sendKeys(field, PathDir);
		rightclickaS.perform();
		logger.pass("Entered the Dir");
		DesktopSession.findElementByClassName(Pageobj.TreeView32).click();
		DesktopSession.findElementByName(Pageobj.CopyToProject).click();
		DesktopSession.findElementByName(Pageobj.Finish_Button).click();
		System.out.println("done ----> ");
		// Thread.sleep(2000);
		logger.pass("Clicked On Finish");
	}

	@SuppressWarnings("static-access")
	public void VerifyToolTip(String ToolTip, String ProjectName) throws Exception {
		DesktopSession = Root();
		Robot rb = new Robot();
		Actions rightclick = new Actions(DesktopSession);
		DesktopSession.findElementByName(ProjectName).click();
		logger.pass("Clicked On ProjectName");
		System.out.println("donesssa ----> ");
		// Thread.sleep(2000);
		rb.keyPress(KeyEvent.VK_RIGHT);
		logger.pass("Clicked On Project");
		System.out.println("donesz ----> ");
		WebElement wbn = DesktopSession.findElementByName(Pageobj.default_arxml);
		System.out.println("donesdsc ----> ");
		// Thread.sleep(5000);
		wbn.click();
		logger.pass("Clicked On default.arxml");
		// Thread.sleep(2000);
		rb.keyPress(KeyEvent.VK_RIGHT);
		Thread.sleep(1000);
		logger.pass("Expaned ");
		rb.keyPress(KeyEvent.VK_RIGHT);
		Thread.sleep(1000);
		logger.pass("Expaned ");
		rb.keyPress(KeyEvent.VK_RIGHT);
		Thread.sleep(1000);
		logger.pass("Expaned");
		rb.keyPress(KeyEvent.VK_RIGHT);
		Thread.sleep(1000);
		logger.pass("Expaned");
		rb.keyPress(KeyEvent.VK_RIGHT);
		Thread.sleep(1000);
		logger.pass("Expaned");
		rb.keyPress(KeyEvent.VK_RIGHT);
		Thread.sleep(1000);
		logger.pass("Expaned");
		WebElement rte = DesktopSession.findElementByName(Pageobj.Rte);
		rightclick.contextClick(rte).perform();
		Thread.sleep(1000);
		boolean bal = DesktopSession.findElementByName(Pageobj.Configure_Event_Mapping).isDisplayed();
		System.out.println("===-=-=-=-=-- >  " + bal);
		if (bal == true) {
			Thread.sleep(1000);
			DesktopSession.findElementByName(Pageobj.Configure_Event_Mapping).click();
		} else {
			rightclick.contextClick(rte).perform();
			Thread.sleep(3000);
			DesktopSession.findElementByName(Pageobj.Configure_Event_Mapping).click();
		}
		logger.pass("Clicked Configure Event Mapping");
		Thread.sleep(1000);
		String val = Pageobj.Rtehover;
		boolean flag = DesktopSession.findElementByName(val).isDisplayed();
		System.out.println("***************   >> " + flag);
		Thread.sleep(1000);
		DesktopSession.findElementByName(val).click();
		logger.pass("Clicked RteSwComponentInstance_1 [SwComponentPrototype]");
		rb.keyPress(KeyEvent.VK_RIGHT);
		// Thread.sleep(2000);
		logger.pass("Expaned");
		WebElement internal = DesktopSession.findElementByName(Pageobj.InternalTrigger);
		Thread.sleep(1000);
		rightclick.moveToElement(internal).perform();
		logger.pass("moveToElement to InternalTriggerOccurredEvent");
		Thread.sleep(1000);
		boolean gnf = DesktopSession.findElementByName(Pageobj.InternalEvent).isDisplayed();
		String valye = DesktopSession.findElementByName(Pageobj.InternalEvent).getAttribute("Name");
		System.out.println("1-0e-eie-oe0 >   " + gnf);
		System.out.println("9=9==8-=-8=i8---->  " + internal);
		System.out.println("*****************  >> " + valye);
		logger.pass("Got the Tooltip name");
		Assert.assertEquals(valye, ToolTip);
		logger.pass("ToolTip Verified Closing the Session");
		DesktopSession.close();

	}

	@SuppressWarnings("unchecked")
	public String VerifyReportName(String ProjectName, String Projectlocation) throws Exception {
		DesktopSession = Root();
		Robot rb = new Robot();
		Actions rightclick = new Actions(DesktopSession);
		// DesktopSession.findElementByName(ProjectName).click();
		logger.pass("Clicked on the Project");
		rb.keyPress(KeyEvent.VK_RIGHT);
		rb.keyPress(KeyEvent.VK_RIGHT);
		logger.pass("Expanded the Project");
		DesktopSession.findElementByName("ECUExtract.arxml").click();
		logger.pass("Clicked ECUExtract.arxml file");
		WebElement ecu = DesktopSession.findElementByName("ECUExtract.arxml");
		rightclick.contextClick(ecu).perform();
		logger.pass("RightClick on the ECUExtract.arxml file");
		Thread.sleep(1000);
		DesktopSession.findElementByName("Clear validation markers").click();
		logger.pass("Clear validation markers");
		Thread.sleep(1000);
		rightclick.contextClick(ecu).perform();
		logger.pass("RightClick on the ECUExtract.arxml file");
		Thread.sleep(1000);
		DesktopSession.findElementByName("Batch Validation").click();
		logger.pass("Clicked on Batch Validation");

		int i = 0;
		while (i <= 7) {
			System.out.println(i);
			logger.pass("Waiting");
			Thread.sleep(2000);
			if (DesktopSession.findElementByName("Export Validation Report").isEnabled()) {

				DesktopSession.findElementByName("Export Validation Report").click();
				break;
			} else {
				Thread.sleep(2000);
			}
			i++;
		}
		logger.pass("Clicked on Export Validation Report");

		Thread.sleep(3000);
		DesktopSession.findElementByName("All locations").click();
		Thread.sleep(1000);
		WebElement filepath = DesktopSession.findElementByName("Address");
		String select = Keys.chord(Keys.CONTROL, "a");
		rightclick.sendKeys(filepath, select);
		rightclick.perform();
		rightclick.sendKeys(Keys.BACK_SPACE).perform();
		rightclick.sendKeys(Projectlocation).perform();
		// DesktopSession.findElementById("1001").click();
		Thread.sleep(500);
		String arrow = "Go to " + '"' + Projectlocation + '"';
		DesktopSession.findElementByName(arrow).click();
		WebElement name = DesktopSession.findElementByName("File name:");
		DesktopSession.findElementByName("Open").click();
		WebElement ele = null;
		List<WebElement> lstedit = DesktopSession.findElementsByClassName("Edit");
		System.out.println(lstedit.size());
		for (int j = 0; j <= lstedit.size() - 1; j++) {
			String val = lstedit.get(j).getAttribute("Value.Value");
			System.out.println(val + " =- - =- => ");

			if (val.contains("ValidationReport_")) {
				ele = lstedit.get(j);
			}
		}
		ele.sendKeys(select);

		ele.sendKeys(Keys.BACK_SPACE);
		ele.click();
		logger.pass("Clicked dirpath");
		int length = 7;
		boolean useLetters = true;
		boolean useNumbers = true;
		String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
		ele.sendKeys(generatedString);
		logger.info("Entered the value on the input field");
		Thread.sleep(1000);
		DesktopSession.findElementByName("Save").click();
		logger.pass("clicked the save button");
		Thread.sleep(1000);
		WebElement webax = DesktopSession.findElementByName(ProjectName);
		rightclick.contextClick(webax).perform();
		Thread.sleep(1000);
		DesktopSession.findElementByName("Refresh").click();
		webax.click();
		logger.info("Project refreshed");
		String excel = generatedString + ".xls";
		boolean flag = DesktopSession.findElementByName(excel).isDisplayed();
		System.out.println("=-=-=-=->   " + flag);
		Assert.assertEquals(flag, true);
		logger.info("Newly Created report is Present and closing the session");
		return excel;

	}

	public String CreateProject(String ProjectName) throws Exception {
		DesktopSession = Root();
		Robot rb = new Robot();
		Actions rightclick = new Actions(DesktopSession);

		DesktopSession.findElementByName(Pageobj.File).click();
		logger.pass("Clicked On File");
		DesktopSession.findElementByName(Pageobj.New).click();
		logger.pass("Clicked On New");
		DesktopSession.findElementByName(Pageobj.Project).click();
		logger.pass("Clicked On Project");

		DesktopSession.findElementByName(Pageobj.Autosar).click();
		logger.pass("Clicked On Autosar");
		rb.keyPress(KeyEvent.VK_RIGHT);
		DesktopSession.findElementByName(Pageobj.NewAutosar).click();
		logger.pass("Clicked On NewAutosar");
		DesktopSession.findElementByName(Pageobj.Next_Button).click();
		logger.pass("Clicked On NextButton");
		WebElement Project = DesktopSession.findElementByName(Pageobj.ProjectName);
		rightclick.click(Project);
		rightclick.perform();
		logger.pass("Click on the Project");
		Thread.sleep(10000);
		String select = Keys.chord(Keys.CONTROL, "a");
		rightclick.sendKeys(Project, select);
		rightclick.perform();
		rightclick.sendKeys(Project, ProjectName);
		rightclick.perform();
		logger.pass("entered the ProjectName");
		DesktopSession.findElementByName(Pageobj.Finish_Button).click();
		return ProjectName;

	}

	public String CreateProjectOnNewTool(String ProjectName) throws Exception {
		DesktopSession = Root();
		Robot rb = new Robot();
		Actions rightclick = new Actions(DesktopSession);

		DesktopSession.findElementByName(Pageobj.File).click();
		logger.pass("Clicked On File");
		DesktopSession.findElementByName(Pageobj.New).click();
		logger.pass("Clicked On New");
		DesktopSession.findElementByName(Pageobj.Project).click();
		logger.pass("Clicked On Project");

		DesktopSession.findElementByName(Pageobj.General_Folder).click();
		logger.pass("Clicked On General_Folder");
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		rb.keyPress(KeyEvent.VK_RIGHT);
		rb.keyRelease(KeyEvent.VK_RIGHT);
		DesktopSession.findElementByName("ECU Configuration Project").click();
		logger.pass("Clicked On NewAutosar");
		DesktopSession.findElementByName(Pageobj.Next_Button).click();
		logger.pass("Clicked On NextButton");
		WebElement Project = DesktopSession.findElementByName(Pageobj.ProjectName);
		rightclick.click(Project);
		rightclick.perform();
		logger.pass("Click on the Project");
		Thread.sleep(10000);
		String select = Keys.chord(Keys.CONTROL, "a");
		rightclick.sendKeys(Project, select);
		rightclick.perform();
		rightclick.sendKeys(Project, ProjectName);
		rightclick.perform();
		logger.pass("entered the ProjectName");
		DesktopSession.findElementByName(Pageobj.Finish_Button).click();
		return ProjectName;

	}

	public void Upload_DBC_File(String ProjectName, String DBCPath, String SetEcu) throws Exception {

		DesktopSession = Root();
		Robot rb = new Robot();
		Actions rightclick = new Actions(DesktopSession);
		WebElement Project = DesktopSession.findElementByName(ProjectName);
		rightclick.contextClick(Project);
		rightclick.perform();
		Thread.sleep(10000);
		DesktopSession.findElementByName(Pageobj.Import).click();
		logger.pass("Clicked On Import");
		// DesktopSession.findElementByName(po.C4K).click();
		@SuppressWarnings("unchecked")
		List<WebElement> lstn = DesktopSession.findElementsByName(Pageobj.C4K);
		System.out.println(lstn.size());
		lstn.get(1).click();
		logger.pass("Clicked C4K");
		logger.pass("Clicked on the C4K");
		rb.keyPress(KeyEvent.VK_RIGHT);
		// rb.keyPress(KeyEvent.VK_RIGHT);
		logger.pass("Expanded the c4k");
		DesktopSession.findElementByName(Pageobj.DBC).click();
		logger.pass("Click DBC");
		DesktopSession.findElementByName(Pageobj.Next_Button).click();
		logger.pass("Clicked On NextButton");
		DesktopSession.findElementByName(Pageobj.Browse).click();
		logger.pass("Clicked On Browse button");
		Thread.sleep(1000);
		// Address: Documents
		DesktopSession.findElementByName("All locations").click();
		Thread.sleep(1000);
		WebElement filepath = DesktopSession.findElementByName("Address");
		String select = Keys.chord(Keys.CONTROL, "a");
		rightclick.sendKeys(filepath, select);
		rightclick.perform();
		rightclick.sendKeys(Keys.BACK_SPACE).perform();
		rightclick.sendKeys(filepath, DBCPath);
		rightclick.perform();
		String arrow;
		if (SetEcu.equals("CMM")) {
			arrow = "Go to " + '"' + System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator
					+ "DBC" + '"';
			System.out.println("======>  " + arrow);
		} else {
			arrow = "Go to " + '"' + System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator
					+ "DBC" + File.separator + "CAN" + '"' + '"';
			System.out.println("======>  " + arrow);
		}

		DesktopSession.findElementByName(arrow).click();
		logger.pass("entered the DBCPath");
		Thread.sleep(1000);
		DesktopSession.findElementByClassName("UIProperty").click();
		Thread.sleep(1000);
		DesktopSession.findElementByName(Pageobj.Open).click();
		logger.pass("Select open");
		Thread.sleep(1000);
		DesktopSession.findElementByClassName(Pageobj.Dropdown).click();
		logger.pass("Selected the Dropdown");
		DesktopSession.findElementByName(SetEcu).click();
		logger.pass("Selected the CMM");
		DesktopSession.findElementByName(Pageobj.Select_All).click();
		logger.pass("Selected the Select All");
		DesktopSession.findElementByName(Pageobj.Finish_Button).click();
		logger.pass("Selected the Finish button");
		Thread.sleep(2000);

	}

	// by scrolling the bar
	@SuppressWarnings("unchecked")
	public void ScrollToElement(WebElement ele) throws Exception {
		int i = 0;
		while (i <= 420) {
			System.out.println(i);
			logger.pass("scrolling");
			if (!ele.isDisplayed()) {
				System.out.println("Page down");
				List<WebElement> lst = DesktopSession.findElementsByName("Page down");
				System.out.println(lst.size() + " =-=-> ");
				DesktopSession.findElementByName("Page down").click();
				break;
			} else {
				Thread.sleep(1000);
			}
			i++;
		}

	}

	// Page up

	public void ScrollUPToElement(WebElement ele) throws Exception {
		int i = 0;
		while (i <= 4) {
			System.out.println(i);
			logger.info("scrolling");
			Thread.sleep(1000);
			if (ele.isDisplayed()) {

				DesktopSession.findElementByName("Page up").click();
				break;
			} else {
				Thread.sleep(1000);
			}
			i++;
		}

	}

	public void WaitToElementDisapear(WebElement element) throws Exception {

		int i = 0;
		while (i <= 14) {
			System.out.println(i);
			logger.pass("Loading");
			Thread.sleep(1000);
			if (element.isEnabled()) {

				Thread.sleep(12000);
				System.out.println("Waited for ---> " + i * 12 + " SECS");
				logger.pass("Waited for ---> " + i * 12 + " SECS");

			} else {
				break;
			}
			i++;
		}

	}

	public void ExpandProject(int TimestoExpand) throws Exception {
		Robot rb = new Robot();
		for (int i = 1; i <= TimestoExpand; i++) {
			rb.keyPress(KeyEvent.VK_RIGHT);
			Thread.sleep(1000);
		}

	}

	public void VerifyDBCDetailsSwBase(String ProjectName, String BaseType, String Max_Base_Type_Size, String Native)
			throws Exception {

		DesktopSession = Root();
		Robot rb = new Robot();
		Actions rightclick = new Actions(DesktopSession);
		DesktopSession.findElementByName(ProjectName).click();
		logger.pass("Clicked On ProjectName");
		ExpandProject(7);
//		rb.keyPress(KeyEvent.VK_RIGHT);
//		logger.pass("Clicked On Project");
//		Thread.sleep(1000);
//		rb.keyPress(KeyEvent.VK_RIGHT);
//		Thread.sleep(1000);
//		logger.pass("Expaned ");
//		rb.keyPress(KeyEvent.VK_RIGHT);
//		Thread.sleep(1000);
//		logger.pass("Expaned ");
//		rb.keyPress(KeyEvent.VK_RIGHT);
//		Thread.sleep(1000);
//		logger.pass("Expaned");
//		rb.keyPress(KeyEvent.VK_RIGHT);
//		Thread.sleep(1000);
//		logger.pass("Expaned");
//		rb.keyPress(KeyEvent.VK_RIGHT);
//		Thread.sleep(1000);
//		logger.pass("Expaned");
//		rb.keyPress(KeyEvent.VK_RIGHT);
		Thread.sleep(4000);
		logger.pass("Expaned");
		WebElement SwBaseType = DesktopSession.findElementByName(BaseType);
		ScrollToElement(SwBaseType);
		System.out.println("------>  Scrolled");
		Thread.sleep(1000);
		DesktopSession.findElementByName("Line down").click();
		DesktopSession.findElementByName("Line down").click();
		DesktopSession.findElementByName("Line down").click();
		SwBaseType.click();
		// 4786304
		logger.pass("Clicked SwBaseType");
		rb.keyPress(KeyEvent.VK_RIGHT);
		logger.pass("expanded");
		Thread.sleep(1000);
		WebElement BasicType = DesktopSession.findElementByName(Pageobj.BasicType);
		rightclick.doubleClick(BasicType).perform();
		Thread.sleep(1000);
		WebElement PropertyTab = DesktopSession.findElementByName(Pageobj.Properties_Tab);
		rightclick.doubleClick(PropertyTab).perform();
		DesktopSession.findElementByName(Pageobj.Max_Base_Type_Size).click();
		// getAttribute("Value.Value")
		WebElement size = (WebElement) DesktopSession.findElementsByClassName("Edit").get(1);
		System.out.println("-=-=-=-=->  " + size);
		String value = size.getAttribute("Value.Value");
		System.out.println("-=-===================>   " + value);
		Thread.sleep(1000);
		DesktopSession.findElementByName("Native Declaration").click();
		WebElement unchar = (WebElement) DesktopSession.findElementsByClassName("Edit").get(1);
		System.out.println("-=-=-=-=->  " + unchar);
		String Newchar = unchar.getAttribute("Value.Value");
		System.out.println("_____----------->  " + Newchar);
		Assert.assertEquals(value, Max_Base_Type_Size);
		Assert.assertEquals(Newchar, Native);
		// rightclick.keyDown( Keys.CONTROL ).sendKeys( "a" ).keyUp( Keys.CONTROL
		// ).build().perform();
		// rightclick.keyDown( Keys.CONTROL ).sendKeys( "c" ).keyUp( Keys.CONTROL
		// ).build().perform();

		// String str = rightclick.keyDown( Keys.CONTROL ).sendKeys( "v" ).keyUp(
		// Keys.CONTROL ).build().perform();

	}

	public void Upload_DBC_File_CAN(String ProjectName, String DBCPath, String SetEcu) throws Exception {

		DesktopSession = Root();
		Robot rb = new Robot();
		Actions rightclick = new Actions(DesktopSession);
		WebElement Project = DesktopSession.findElementByName(ProjectName);
		rightclick.contextClick(Project);
		rightclick.perform();
		Thread.sleep(1000);
		DesktopSession.findElementByName(Pageobj.Import).click();
		logger.pass("Clicked On Import");
		DesktopSession.findElementByName(Pageobj.Select_C4K).click();
		logger.pass("Clicked on the C4K");
		rb.keyPress(KeyEvent.VK_RIGHT);
		// rb.keyPress(KeyEvent.VK_RIGHT);
		logger.pass("Expanded the c4k");
		DesktopSession.findElementByName(Pageobj.DBC).click();
		logger.pass("Click DBC");
		DesktopSession.findElementByName(Pageobj.Next_Button).click();
		logger.pass("Clicked On NextButton");
		DesktopSession.findElementByName(Pageobj.Browse).click();
		logger.pass("Clicked On Browse button");
		Thread.sleep(1000);
		// Address: Documents
		DesktopSession.findElementByName("All locations").click();
		Thread.sleep(1000);
		WebElement filepath = DesktopSession.findElementByName("Address");
		String select = Keys.chord(Keys.CONTROL, "a");
		rightclick.sendKeys(filepath, select);
		rightclick.perform();
		rightclick.sendKeys(Keys.BACK_SPACE).perform();
		rightclick.sendKeys(filepath, DBCPath);
		rightclick.perform();
		String arrow = "Go to " + '"'
				+ "D:\\Orginal_Automation\\winappdriver_automation\\Autosar_C4K\\ImportProject\\DBC\\CAN" + '"';
		System.out.println("======>  " + arrow);
		DesktopSession.findElementByName(arrow).click();
		logger.pass("entered the DBCPath");
		Thread.sleep(1000);
		DesktopSession.findElementByClassName("UIProperty").click();
		Thread.sleep(1000);
		DesktopSession.findElementByName(Pageobj.Open).click();
		logger.pass("Select open");
		Thread.sleep(1000);
		DesktopSession.findElementByClassName(Pageobj.Dropdown).click();
		logger.pass("Selected the Dropdown");
		DesktopSession.findElementByName(SetEcu).click();
		logger.pass("Selected the CMM");
		DesktopSession.findElementByName(Pageobj.Select_All).click();
		logger.pass("Selected the Select All");
		DesktopSession.findElementByName(Pageobj.Finish_Button).click();
		logger.pass("Selected the Finish button");

		WebElement ele = DesktopSession.findElementByName("Mapping DBC to ECU is in progress...");
		boolean flag = DesktopSession.findElementByName("Mapping DBC to ECU is in progress...").isEnabled();
		System.out.println("=-=-=->  " + flag);

		WaitToElementDisapear(ele);
		Thread.sleep(2000);
	}

	public void ImportLDFFile(String ProjectName, String LDFPath) throws Exception {
		DesktopSession = Root();
		Robot rb = new Robot();
		Actions rightclick = new Actions(DesktopSession);
		WebElement Project = DesktopSession.findElementByName(ProjectName);
		rightclick.contextClick(Project);
		rightclick.perform();
		Thread.sleep(1000);
		DesktopSession.findElementByName(Pageobj.Import).click();

		logger.pass("Clicked On Import");
		DesktopSession.findElementByName(Pageobj.General_Folder).click();
		rb.keyPress(KeyEvent.VK_DOWN);
		logger.pass("Clicked on the C4K");
		rb.keyPress(KeyEvent.VK_RIGHT);
		// rb.keyPress(KeyEvent.VK_RIGHT);
		logger.pass("Expanded the c4k");
		Thread.sleep(1000);
		// DesktopSession.findElementByName(po.LDF).click();
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyPress(KeyEvent.VK_DOWN);
		logger.pass("Click LDF");
		DesktopSession.findElementByName(Pageobj.Next_Button).click();
		logger.pass("Clicked On NextButton");
		DesktopSession.findElementByName(Pageobj.LDFBrowse).click();
		logger.pass("Clicked On Browse button");
		Thread.sleep(1000);
		// Address: Documents
		DesktopSession.findElementByName("All locations").click();
		Thread.sleep(1000);
		WebElement filepath = DesktopSession.findElementByName("Address");
		String select = Keys.chord(Keys.CONTROL, "a");
		rightclick.sendKeys(filepath, select);
		rightclick.perform();
		rightclick.sendKeys(Keys.BACK_SPACE).perform();
		rightclick.sendKeys(filepath, LDFPath);
		rightclick.perform();
		String arrow = "Go to " + '"' + System.getProperty("user.dir") + File.separator + "ImportProject"
				+ File.separator + "LDF" + '"';
		System.out.println("======>  " + arrow);
		DesktopSession.findElementByName(arrow).click();
		logger.pass("entered the LDFPath");
		Thread.sleep(1000);
		DesktopSession.findElementByClassName("UIProperty").click();
		Thread.sleep(1000);
		DesktopSession.findElementByName(Pageobj.Open).click();
		logger.pass("Select open");
		Thread.sleep(1000);
		List<WebElement> lst = DesktopSession.findElementsByClassName(Pageobj.Dropdown);
		System.out.println(lst.size() + " ==-=-=-> ");
		DesktopSession.findElementByClassName(Pageobj.Dropdown).click();
		logger.pass("Selected the Dropdown");
		rightclick.click(DesktopSession.findElementByClassName(Pageobj.Dropdown)).perform();
		Thread.sleep(1000);
		// DesktopSession.findElementByName(Pageobj.HCP).click();
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		// DesktopSession.findElementByName(Pageobj.Finish_Button).click();
		logger.pass("Clicked enter");

	}

	public void VerifyComSignalEndianess(String Project) throws Exception {

		DesktopSession = Root();
		Actions rightclick = new Actions(DesktopSession);
		Robot rb = new Robot();
		DesktopSession.findElementByName(Pageobj.View_Menu).click();
		logger.pass("Selected the View_Menu");
		DesktopSession.findElementByName(Pageobj.CustomizeView).click();
		logger.pass("Selected the CustomizeView");
		DesktopSession.findElementByName(Pageobj.Resource).click();
		logger.pass("Selected the Resource");
		rb.keyPress(KeyEvent.VK_SPACE);
		DesktopSession.findElementByName(Pageobj.HideECUParam).click();
		rb.keyPress(KeyEvent.VK_SPACE);
		logger.pass("Selected the HideECUParam");
		DesktopSession.findElementByName(Pageobj.Launch).click();
		logger.pass("Selected the Launch");
		Thread.sleep(1000);
		WebElement proj = DesktopSession.findElementByName(Project);
		proj.click();
		logger.pass("Selected the Project");
		rightclick.contextClick(proj).perform();
		Thread.sleep(1000);
		DesktopSession.findElementByName(Pageobj.ECUC_Mapping).click();
		// Thread.sleep(1000);
		DesktopSession.findElementByName(Pageobj.Finish_Button).click();
		Thread.sleep(5000);
		proj.click();
		rb.keyPress(KeyEvent.VK_RIGHT);
		DesktopSession.findElementByName(Pageobj.ECUDescription).click();
		logger.pass("Selected the ECUDescription");
		ExpandProject(7);
		DesktopSession.findElementByName(Pageobj.COMModule).click();
		logger.pass("Selected the COMModule");
		rb.keyPress(KeyEvent.VK_RIGHT);
		DesktopSession.findElementByName(Pageobj.ComConfig).click();
		logger.pass("Selected the ComConfig");
		rb.keyPress(KeyEvent.VK_RIGHT);
		DesktopSession.findElementByName(Pageobj.ComSignal).click();
		logger.pass("Selected the ComSignal");
		rb.keyPress(KeyEvent.VK_RIGHT);
		DesktopSession.findElementByName(Pageobj.SignalIPDU).click();
		logger.pass("Selected the SignalIPDU");
		rb.keyPress(KeyEvent.VK_RIGHT);
		DesktopSession.findElementByName(Pageobj.ComSignalEndianness).click();
		logger.pass("Selected the ComSignalEndianness");
		Thread.sleep(1000);
		WebElement PropertyTab = DesktopSession.findElementByName(Pageobj.Properties_Tab);
		rightclick.doubleClick(PropertyTab).perform();
		logger.pass("doubleClick the Properties_Tab");
		WebElement EcuDetailsTab = DesktopSession.findElementByName(Pageobj.ECUDetailsTab);
		EcuDetailsTab.click();
		logger.pass("doubleClick the EcuDetailsTab");
//		String lilIndian = DesktopSession.findElementByName(Pageobj.LITTLE_ENDIAN)
//				.getAttribute("LegacyIAccessible.Name");
//		System.out.println("-------->    " + lilIndia.n);
		List<WebElement> lst1 = DesktopSession.findElementsByName("Value");
		lst1.get(1).click();
		// boolean value =
		// DesktopSession.findElementByName(Pageobj.LITTLE_ENDIAN).isDisplayed();
		// Assert.assertEquals(value, true);
		List<WebElement> lst = DesktopSession.findElementsByClassName("Edit");
		String value = lst.get(1).getAttribute("Value.Value");
		System.out.println(value);
		Assert.assertEquals(value, "LITTLE_ENDIAN");
	}

	public void ImportFileToProject(String Project, String filename, String secondfile) throws Exception {

		DesktopSession = Root();
		Actions act = new Actions(DesktopSession);
		Robot rb = new Robot();
		WebElement proj = DesktopSession.findElementByName(Project);
		proj.click();
		logger.pass("Click the Project");
		act.contextClick(proj).perform();
		Thread.sleep(1000);
		DesktopSession.findElementByName(Pageobj.Import).click();
		logger.pass("Clicked On Import");
		DesktopSession.findElementByName(Pageobj.General_Folder).click();
		logger.pass("Click the General_Folder");
		rb.keyPress(KeyEvent.VK_RIGHT);
		Thread.sleep(1000);
		DesktopSession.findElementByName(Pageobj.Import_FileSystem).click();
		logger.pass("Click the Import_FileSystem");
		DesktopSession.findElementByName(Pageobj.Next_Button).click();
		logger.pass("Click the Next_Button");
		// DesktopSession.findElementByName(Pageobj.Browse).click();
		DesktopSession.findElementByName(Pageobj.File_Directory).click();
		logger.pass("Click the File_Directory");
		String Filepath = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator
				+ "AR_1383";
		WebElement Inputfilepath = DesktopSession.findElementByName(Pageobj.File_Directory);
		// DesktopSession.findElementByName(Pageobj.File_Directory).sendKeys(Filepath);
		act.sendKeys(Inputfilepath, Filepath).perform();
		DesktopSession.findElementByClassName("SysTreeView32").click();
		logger.pass("Click the SysTreeView32");
		DesktopSession.findElementByName(filename).click();
		logger.pass("Click the filename");
		rb.keyPress(KeyEvent.VK_SPACE);
		Thread.sleep(500);
		DesktopSession.findElementByName(secondfile).click();
		logger.pass("Click the secondfile");
		rb.keyPress(KeyEvent.VK_SPACE);
		Thread.sleep(500);
		DesktopSession.findElementByName(Pageobj.Finish_Button).click();
		logger.pass("Click the Finish_Button");
		Thread.sleep(1000);
		DesktopSession = Root();
	}

	@SuppressWarnings("unchecked")
	public void Mergefiles(String Project, String File, String newFile) throws Exception {

		DesktopSession = Root();
		Actions act = new Actions(DesktopSession);
		Robot rb = new Robot();
		DesktopSession.findElementByName(Project).click();
		rb.keyPress(KeyEvent.VK_RIGHT);
		Thread.sleep(1000);
		DesktopSession.findElementByName(Project).click();
		rb.keyPress(KeyEvent.VK_CONTROL);
		DesktopSession.findElementByName(Project).click();
		DesktopSession.findElementByName(newFile).click();
		logger.pass("Click the newFile");
		Thread.sleep(500);
		DesktopSession.findElementByName(File).click();
		logger.pass("Click the File");
		// WebElement ele = DesktopSession.findElementByName(newFile);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		act.contextClick().perform();
		logger.pass("RightClick the newFile");
		Thread.sleep(1000);
		// String time = GetTime();
		DesktopSession.findElementByName(Pageobj.Merging_ECUC).click();
		Thread.sleep(1000);
		// System.out.println("===========================>>>> " + time);

		logger.pass("Click the Merging_ECUC");

		// time = GetTime();
		// System.out.println("--=-=-=-> " + time);
		Thread.sleep(15000);
		System.out.println("--=-=-=-> hybb     ");
		DesktopSession.findElementByName(Project).click();
		System.out.println("--=-=-=-> dtftyf     ");
		rb.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(1000);
		rb.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(1000);
		rb.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(1000);
		rb.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(1000);
		logger.pass("Click the EcuExtract file");
		ExpandProject(8);
		logger.pass("Expanded");
		DesktopSession.findElementByName("ISignalIPduGroups [ARPackage]").click();
		logger.pass("Click the ISignalIPduGroups");
		rb.keyPress(KeyEvent.VK_RIGHT);
		Thread.sleep(1000);
		rb.keyPress(KeyEvent.VK_RIGHT);
		Thread.sleep(1000);
		rb.keyPress(KeyEvent.VK_RIGHT);
		Thread.sleep(1000);
		rb.keyRelease(KeyEvent.VK_RIGHT);
		List<WebElement> lstb = DesktopSession.findElementsByXPath("//*[@LocalizedControlType='tree item']");
		System.out.println(lstb.size() + "  = -= - > ");
		for (int i = 0; i <= lstb.size() - 1; i++) {
			System.out.println("cftyjh==");
			rb.keyPress(KeyEvent.VK_DOWN);
			Thread.sleep(500);
			rb.keyRelease(KeyEvent.VK_DOWN);
			System.out.println("gxfrx==");
			// DesktopSession.findElementByName("FLM_R_IN_PduGroup_0000000ac0").click();
			String tree = lstb.get(i).getAttribute("Name");
			System.out.println("0==00=00=0=0=> " + tree);
			if (tree.contains("FLM_R_IN_PduGroup_") || tree.contains("FLM_R_OUT_PduGroup_")) {
				Thread.sleep(500);
				lstb.get(i).click();
				Thread.sleep(500);
				act.contextClick().perform();
				Thread.sleep(500);
				DesktopSession.findElementByName("Rename").click();
				Thread.sleep(1000);
				int str = DesktopSession.findElementsByClassName("Edit").size();
				System.out.println("=-=-=--=748----->     " + str);
				WebElement eleme = (WebElement) DesktopSession.findElementsByClassName("Edit").get(1);
				String value = eleme.getAttribute("Value.Value");
				System.out.println("==========aCZXZ====>   " + value);
			} else {
				System.out.println(" no matching value ");
			}
		}

	}

	public void ImportSingleFileToProject(String Project, String filename) throws Exception {

		DesktopSession = Root();
		// Thread.sleep(3000);
		Robot rb = new Robot();
		Actions act = new Actions(DesktopSession);
		logger.info("Click the Merging_ECUC");
		String time = GetTime();
		System.out.println("--=-=-=->    " + time);
		Thread.sleep(15000);
		System.out.println("--=-=-=-> hybb     ");
		DesktopSession.findElementByName(Project).click();
		System.out.println("--=-=-=-> dtftyf     ");
		rb.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(1000);
		rb.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(1000);
//		rb.keyPress(KeyEvent.VK_DOWN);
//		Thread.sleep(1000);
		logger.info("Click the EcuExtract file");
		ExpandProject(12);
		logger.info("Expanded");
		// "ISignalIPduGroups [ARPackage]"
		DesktopSession.findElementByName("ISignalIPduGroups [ARPackage]").click();
		logger.info("Click the ISignalIPduGroups");
		rb.keyPress(KeyEvent.VK_RIGHT);
		Thread.sleep(1000);
		rb.keyPress(KeyEvent.VK_RIGHT);
		Thread.sleep(1000);
		for (int i = 1; i <= 14; i++) {
			rb.keyPress(KeyEvent.VK_DOWN);
			act.contextClick().perform();
			Thread.sleep(500);
			DesktopSession.findElementByName("Rename").click();
			Thread.sleep(1000);
			int str = DesktopSession.findElementsByClassName("Edit").size();
			System.out.println("=-=-=--=748----->     " + str);
			WebElement eleme = (WebElement) DesktopSession.findElementsByClassName("Edit").get(1);
			String value = eleme.getAttribute("Value.Value");
			System.out.println("==========aCZXZ====>   " + value);
		}

	}

	public void ImportSingleFile(String Project, String filename) throws Exception {
		DesktopSession = Root();
		Thread.sleep(3000);
		Actions act = new Actions(DesktopSession);
		Robot rb = new Robot();
		WebElement proj = DesktopSession.findElementByName(Project);
		proj.click();
		logger.pass("Click the Project");
		act.contextClick(proj).perform();
		Thread.sleep(1000);
		DesktopSession.findElementByName(Pageobj.Import).click();
		logger.pass("Clicked On Import");
		DesktopSession.findElementByName(Pageobj.General_Folder).click();
		logger.pass("Click the General_Folder");
		rb.keyPress(KeyEvent.VK_RIGHT);
		Thread.sleep(1000);
		DesktopSession.findElementByName(Pageobj.Import_FileSystem).click();
		logger.pass("Click the Import_FileSystem");
		DesktopSession.findElementByName(Pageobj.Next_Button).click();
		logger.pass("Click the Next_Button");
		DesktopSession.findElementByName(Pageobj.File_Directory).click();
		logger.pass("Click the File_Directory");
		String Filepath = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator
				+ "AR-1199";
		WebElement Inputfilepath = DesktopSession.findElementByName(Pageobj.File_Directory);
		act.sendKeys(Inputfilepath, Filepath).perform();
		DesktopSession.findElementByClassName("SysTreeView32").click();
		logger.pass("Click the SysTreeView32");
		DesktopSession.findElementByName(filename).click();
		logger.pass("Click the filename");
		rb.keyPress(KeyEvent.VK_SPACE);
		Thread.sleep(500);
		DesktopSession.findElementByName(Pageobj.Finish_Button).click();
		logger.pass("Click the Finish_Button");
		Thread.sleep(1000);
	}

	public void ImportFile(String Project, String filename, String Filepath) throws Exception {
		DesktopSession = Root();
		Thread.sleep(3000);
		Actions act = new Actions(DesktopSession);
		Robot rb = new Robot();
		WebElement proj = DesktopSession.findElementByName(Project);
		proj.click();
		logger.pass("Click the Project");
		act.contextClick(proj).perform();
		Thread.sleep(1000);
		DesktopSession.findElementByName(Pageobj.Import).click();
		logger.pass("Clicked On Import");
		DesktopSession.findElementByName(Pageobj.General_Folder).click();
		logger.pass("Click the General_Folder");
		rb.keyPress(KeyEvent.VK_RIGHT);
		Thread.sleep(1000);
		DesktopSession.findElementByName(Pageobj.Import_FileSystem).click();
		logger.pass("Click the Import_FileSystem");
		DesktopSession.findElementByName(Pageobj.Next_Button).click();
		logger.pass("Click the Next_Button");
		DesktopSession.findElementByName(Pageobj.File_Directory).click();
		logger.pass("Click the File_Directory");
		WebElement Inputfilepath = DesktopSession.findElementByName(Pageobj.File_Directory);
		act.sendKeys(Inputfilepath, Filepath).perform();
		DesktopSession.findElementByClassName("SysTreeView32").click();
		logger.pass("Click the SysTreeView32");
		DesktopSession.findElementByName(filename).click();
		logger.pass("Click the filename");
		rb.keyPress(KeyEvent.VK_SPACE);
		Thread.sleep(500);
		DesktopSession.findElementByName(Pageobj.Finish_Button).click();
		logger.pass("Click the Finish_Button");
		Thread.sleep(1000);
	}

	public void dataMappingOptionValidation(String Project) throws Exception {

		DesktopSession = Root();
		Actions act = new Actions(DesktopSession);
		WebElement proj = DesktopSession.findElementByName(Project);
		act.contextClick(proj).perform();
		Thread.sleep(1000);
		logger.pass("Rightclicked on the project");
		boolean value = DesktopSession.findElementByName(Pageobj.Datamapping).isEnabled();
		System.out.println(value + "-------------------------------->>");
		Assert.assertEquals(true, value);
		DesktopSession.findElementByName(Pageobj.Datamapping).click();
		logger.pass("clicked on datamapping option");
		String MappingTab = "DataMapping[" + Project + "]";
		logger.pass("Name of the project in datamapping view" + MappingTab);
		System.out.println("----->   " + MappingTab);
		String mappingTabName = DesktopSession.findElementByName(MappingTab).getText();
		System.out.println("==========>>===========" + mappingTabName);

	}

	public void ClientServerOperation(String Project) throws Exception {

		DesktopSession = Root();
		Actions act = new Actions(DesktopSession);
		WebElement proj = DesktopSession.findElementByName(Project);
		act.contextClick(proj).perform();
		Thread.sleep(1000);
		DesktopSession.findElementByName(Pageobj.Datamapping).click();
		String MappingTab = "DataMapping[" + Project + "]";
		System.out.println("----->   " + MappingTab);
		WebElement Datatab = DesktopSession.findElementByName(MappingTab);
		WebElement Drag = DesktopSession.findElementByName(Pageobj.Drag);
		WebElement Drop = DesktopSession.findElementByName(Pageobj.Drop);
		act.dragAndDrop(Drag, Drop).build().perform();
		Thread.sleep(1000);
		String CSPTM = DesktopSession.findElementByName(Pageobj.ClientServerPrimitiveTypeMapping).getText();
		System.out.println("************---->   " + CSPTM);

		if (CSPTM.contains("ClientServerPrimitiveTypeMapping")) {

			Assert.assertTrue(true);
		} else {

			Assert.assertFalse(false);
		}
		String[] arrSplit = CSPTM.toString().split(" ");

		System.out.println(arrSplit);
		// String value = arrSplit[0].replace(" ", "");
		// System.out.println(" ==-=-=-=> "+value);

	}

	public void propertiesEnabledVerification(String Project) throws Exception {

		DesktopSession = Root();
		Actions act = new Actions(DesktopSession);
		Robot rb = new Robot();
		SoftAssert softAssert = new SoftAssert();
		WebElement proj = DesktopSession.findElementByName(Project);
		proj.click();
		logger.pass("Clicked the Project");
		act.contextClick(proj).perform();
		logger.pass("Right Clicked the Project");
		Thread.sleep(1000);
		boolean flag = DesktopSession.findElementByName(Pageobj.Properties_Tab).isEnabled();
		Assert.assertEquals(true, flag);
		logger.pass("Verified the Properties tab is enabled");
		DesktopSession.findElementByName(Pageobj.Properties_Tab).click();
		logger.pass("Clicked the properties Tab");
		DesktopSession.findElementByName(Pageobj.Module_Defination).click();
		logger.pass("Clicked the Module Defination Option");
		DesktopSession.findElementByName(Pageobj.Module_Defination_File1).click();
		rb.keyPress(KeyEvent.VK_SPACE);
		Thread.sleep(100);
		rb.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		logger.pass("Clicked the Module Defination file1");
		WebElement AR1124 = DesktopSession.findElementByName(Pageobj.Project_Folder);
		act.doubleClick(AR1124).perform();
		WebElement bswmdFolder = DesktopSession.findElementByName(Pageobj.BSWMD_Folder);
		act.click(bswmdFolder).perform();
		act.doubleClick(bswmdFolder).perform();
		boolean bswmd = DesktopSession.findElementByName(Pageobj.BSWMD_Folder).isDisplayed();
		Assert.assertEquals(bswmd, true);
		logger.pass("Verify the foldername created");
		boolean CanIf_BSWMD = DesktopSession.findElementByName(Pageobj.Module_Defination_File1).isDisplayed();
		softAssert.assertEquals(CanIf_BSWMD, true);
		logger.pass("Verify the File1 created");
		bswmdFolder.click();
		act.contextClick(bswmdFolder).perform();
		logger.pass("Right click on bswmdFolder");
		Thread.sleep(500);
		boolean merge_Files;
		try {
			merge_Files = DesktopSession.findElementByName(Pageobj.Merge_Files).isDisplayed();
			System.out.println(merge_Files);
		} catch (Exception e) {
			merge_Files = false;
			System.out.println(merge_Files);
		}

		Assert.assertEquals(false, merge_Files);

		logger.pass("Verify the merge file option is not displayed");

	}

	public void propertiesEnabledBswmdMergeVerification(String Project) throws Exception {

		DesktopSession = Root();
		Actions act = new Actions(DesktopSession);
		Robot rb = new Robot();
		SoftAssert softAssert = new SoftAssert();
		WebElement proj = DesktopSession.findElementByName(Project);
		proj.click();
		logger.pass("Clicked the Project");
		act.contextClick(proj).perform();
		logger.pass("Right Clicked the Project");
		Thread.sleep(1000);
		boolean flag = DesktopSession.findElementByName(Pageobj.Properties_Tab).isEnabled();
		Assert.assertEquals(true, flag);
		logger.pass("Verified the Properties tab is enabled");
		DesktopSession.findElementByName(Pageobj.Properties_Tab).click();
		logger.pass("Clicked the properties Tab");
		DesktopSession.findElementByName(Pageobj.Module_Defination).click();
		logger.pass("Clicked the Module Defination Option");
		DesktopSession.findElementByName(Pageobj.Module_Defination_File1).click();
		rb.keyPress(KeyEvent.VK_SPACE);
		Thread.sleep(100);
		rb.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		logger.pass("Clicked the Module Defination file1");
		WebElement AR1124 = DesktopSession.findElementByName(Pageobj.Project_Folder);
		act.doubleClick(AR1124).perform();
		WebElement bswmdFolder = DesktopSession.findElementByName(Pageobj.BSWMD_Folder);
		act.click(bswmdFolder).perform();
		act.doubleClick(bswmdFolder).perform();
		boolean bswmd = DesktopSession.findElementByName(Pageobj.BSWMD_Folder).isDisplayed();
		Assert.assertEquals(bswmd, true);
		logger.pass("Verify the foldername created");
		boolean CanIf_BSWMD = DesktopSession.findElementByName(Pageobj.Module_Defination_File1).isDisplayed();
		softAssert.assertEquals(CanIf_BSWMD, true);
		logger.pass("Verify the File1 created");

	}

	public String CreateProjectAndNewFolder(String ProjectName, String folderName) throws Exception {
		DesktopSession = Root();
		Robot rb = new Robot();
		Actions rightclick = new Actions(DesktopSession);

		DesktopSession.findElementByName(Pageobj.File).click();
		logger.pass("Clicked On File");
		DesktopSession.findElementByName(Pageobj.New).click();
		logger.pass("Clicked On New");
		DesktopSession.findElementByName(Pageobj.Project).click();
		logger.pass("Clicked On Project");
		DesktopSession.findElementByName(Pageobj.Autosar).click();
		logger.pass("Clicked On Autosar");
		rb.keyPress(KeyEvent.VK_RIGHT);
		DesktopSession.findElementByName(Pageobj.NewAutosar).click();
		logger.pass("Clicked On NewAutosar");
		DesktopSession.findElementByName(Pageobj.Next_Button).click();
		logger.pass("Clicked On NextButton");
		WebElement Project = DesktopSession.findElementByName(Pageobj.ProjectName);
		rightclick.click(Project);
		rightclick.perform();
		logger.pass("Click on the Project");
		Thread.sleep(10000);
		String select = Keys.chord(Keys.CONTROL, "a");
		rightclick.sendKeys(Project, select);
		rightclick.perform();
		rightclick.sendKeys(Project, ProjectName);
		rightclick.perform();
		logger.pass("entered the ProjectName");
		DesktopSession.findElementByName(Pageobj.Finish_Button).click();
		Thread.sleep(8000);
		DesktopSession = Root();
		WebElement proj = DesktopSession.findElementByName(Pageobj.Project_FolderIntergratorBswmd);
		proj.click();
		logger.pass("Clicked the Project");
		rightclick.contextClick().perform();
		Thread.sleep(500);
		logger.pass("Right Clicked the Project");
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyPress(KeyEvent.VK_ENTER);
		logger.pass("Clicked On New");
		Thread.sleep(500);
		DesktopSession.findElementByName(Pageobj.ProjectFolderCreation).click();
		logger.pass("Clicked On Folder Option");
		Thread.sleep(500);
		WebElement FolderName = DesktopSession.findElementByName(Pageobj.ProjectFolderName);
		FolderName.click();
		rightclick.sendKeys(folderName).perform();
		DesktopSession.findElementByName(Pageobj.Finish_Button).click();
		Thread.sleep(500);

		return ProjectName;

	}

	public String CreateProjectOnNewToolAndNewFolder(String ProjectName, String folderName) throws Exception {
		DesktopSession = Root();
		Robot rb = new Robot();
		Actions rightclick = new Actions(DesktopSession);

		DesktopSession.findElementByName(Pageobj.File).click();
		logger.pass("Clicked On File");
		DesktopSession.findElementByName(Pageobj.New).click();
		logger.pass("Clicked On New");
		DesktopSession.findElementByName(Pageobj.Project).click();
		logger.pass("Clicked On Project");
		DesktopSession.findElementByName(Pageobj.General_Folder).click();
		logger.pass("Clicked On General_Folder");
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		rb.keyPress(KeyEvent.VK_RIGHT);
		rb.keyRelease(KeyEvent.VK_RIGHT);
		DesktopSession.findElementByName("ECU Configuration Project").click();
		logger.pass("Clicked On NewAutosar");
		DesktopSession.findElementByName(Pageobj.Next_Button).click();
		logger.pass("Clicked On NextButton");
		WebElement Project = DesktopSession.findElementByName(Pageobj.ProjectName);
		rightclick.click(Project);
		rightclick.perform();
		logger.pass("Click on the Project");
		Thread.sleep(10000);
		String select = Keys.chord(Keys.CONTROL, "a");
		rightclick.sendKeys(Project, select);
		rightclick.perform();
		rightclick.sendKeys(Project, ProjectName);
		rightclick.perform();
		logger.pass("entered the ProjectName");
		DesktopSession.findElementByName(Pageobj.Finish_Button).click();
		Thread.sleep(8000);
		DesktopSession = Root();
		WebElement proj = DesktopSession.findElementByName(Pageobj.Project_FolderIntergratorBswmd);
		proj.click();
		logger.pass("Clicked the Project");
		rightclick.contextClick().perform();
		Thread.sleep(500);
		logger.pass("Right Clicked the Project");
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyPress(KeyEvent.VK_ENTER);
		logger.pass("Clicked On New");
		Thread.sleep(500);
		DesktopSession.findElementByName(Pageobj.ProjectFolderCreation).click();
		logger.pass("Clicked On Folder Option");
		Thread.sleep(500);
		WebElement FolderName = DesktopSession.findElementByName(Pageobj.ProjectFolderName);
		FolderName.click();
		rightclick.sendKeys(folderName).perform();
		DesktopSession.findElementByName(Pageobj.Finish_Button).click();
		Thread.sleep(500);

		return ProjectName;

	}

	public void Upload_Bswmd_File(String ProjectName) throws Exception {

		DesktopSession = Root();
		Robot rb = new Robot();
		Actions rightclick = new Actions(DesktopSession);
		WebElement bswmdFolder = DesktopSession.findElementByName(Pageobj.IntegratorBswmdFolder);
		rightclick.click(bswmdFolder).perform();
		logger.pass("Clicked On bswmdFolder");
		boolean bswmd = DesktopSession.findElementByName(Pageobj.IntegratorBswmdFolder).isDisplayed();
		Assert.assertEquals(bswmd, true);
		rightclick.contextClick(bswmdFolder).perform();
		logger.pass("Right Clicked On bswmdFolder");
		DesktopSession.findElementByName(Pageobj.Import).click();
		logger.pass("Clicked On Import");
		DesktopSession.findElementByName(Pageobj.General_Folder).click();
		logger.pass("Clicked on the General_Folder");
		rb.keyPress(KeyEvent.VK_RIGHT);
		logger.pass("Expanded the General_Folder");
		DesktopSession.findElementByName(Pageobj.Import_FileSystem).click();
		logger.pass("Clicked On Filesystem");
		DesktopSession.findElementByName(Pageobj.Next_Button).click();
		logger.pass("Clicked On NextButton");
		String filePath = getFilePath("ImportProject\\AR1128");
		WebElement Inputfilepath = DesktopSession.findElementByName(Pageobj.File_Directory);
		rightclick.click(Inputfilepath).perform();
		rightclick.sendKeys(Inputfilepath, filePath).perform();
		logger.pass("Passed The file path");
		rightclick.sendKeys(Keys.ENTER).perform();
		DesktopSession.findElementByName(Pageobj.Project_FolderIntergratorBswmd).click();
		rb.keyPress(KeyEvent.VK_SPACE);
		logger.pass("Selected the File to Upload");
		DesktopSession.findElementByName(Pageobj.Finish_Button).click();
		logger.pass("Clicked On Finish Button");
		rightclick.doubleClick(bswmdFolder).perform();
		logger.pass("Double Clicked On bswmdFolder");
		boolean BswmdFile = DesktopSession.findElementByName(Pageobj.BswmdFile).isDisplayed();
		Assert.assertEquals(BswmdFile, true);
		logger.pass("Verify the bswmdFolder created");
		rightclick.contextClick(bswmdFolder).perform();
		logger.pass("Right Clicked On bswmdFolder");
		boolean mergeBswmdFilesOption = DesktopSession.findElementByName(Pageobj.MergeBSWMDFiles).isDisplayed();
		Assert.assertEquals(mergeBswmdFilesOption, true);
		logger.pass("Verify the mergeBswmdFilesOption display");
		Thread.sleep(500);
		WebElement renameOption = DesktopSession.findElementByName(Pageobj.RenameOption);
		rightclick.click(renameOption).perform();
		logger.pass("Clicked On renameOption");
		WebElement RenameWithNewName = DesktopSession.findElementByName(Pageobj.RenameWithNewName);
		// DesktopSession.findElementByName(Pageobj.File_Directory).sendKeys(Filepath);
		rightclick.click(RenameWithNewName).perform();
		rightclick.sendKeys(RenameWithNewName, "Inte").perform();
		logger.pass("FOlder Rename with new name");
		DesktopSession.findElementByName(Pageobj.Launch).click();
		Thread.sleep(1000);
		boolean renameFolder = DesktopSession.findElementByName(Pageobj.NewFolderName).isDisplayed();
		System.out.println(renameFolder);
		Assert.assertEquals(renameFolder, true);
		logger.pass("Verify the Folder with Name created");

		WebElement renameOptionFolder = DesktopSession.findElementByName(Pageobj.NewFolderName);
		rightclick.click(renameOptionFolder).perform();
		rightclick.contextClick(renameOptionFolder).perform();

		boolean bswmdmerge_Files_option;
		try {
			bswmdmerge_Files_option = DesktopSession.findElementByName(Pageobj.MergeBSWMDFiles).isDisplayed();
			System.out.println(bswmdmerge_Files_option);
		} catch (Exception e) {
			bswmdmerge_Files_option = false;
			System.out.println(bswmdmerge_Files_option);
		}

		Assert.assertEquals(false, bswmdmerge_Files_option);

		logger.pass("Verify the bswmd merge file option is not displayed");

	}

	@SuppressWarnings("unchecked")
	public String CreateTwoProject(String ProjectName) throws Exception {
		DesktopSession = Root();
		Robot rb = new Robot();
		Actions rightclick = new Actions(DesktopSession);
		Thread.sleep(3000);
		DesktopSession.findElementByName(Pageobj.Properties_Tab).click();
		System.out.println("clicked on properties");
		Thread.sleep(1000);
		rightclick.contextClick().perform();
		System.out.println("right clicked");
		logger.pass("Clicked On Properties Button");
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyPress(KeyEvent.VK_ENTER);
		logger.pass("Clicked On Properties closed Button");
		for (int i = 1; i <= 2; i++) {
			DesktopSession.findElementByName(Pageobj.File).click();
			logger.pass("Clicked On File");
			DesktopSession.findElementByName(Pageobj.New).click();
			logger.pass("Clicked On New");
			DesktopSession.findElementByName(Pageobj.Project).click();
			logger.pass("Clicked On Project");
			DesktopSession.findElementByName(Pageobj.Autosar).click();
			logger.pass("Clicked On Autosar");
			rb.keyPress(KeyEvent.VK_RIGHT);
			DesktopSession.findElementByName(Pageobj.NewAutosar).click();
			logger.pass("Clicked On NewAutosar");
			DesktopSession.findElementByName(Pageobj.Next_Button).click();
			logger.pass("Clicked On NextButton");
			DesktopSession = Root();
			DesktopSession.findElementByName(Pageobj.ProjectName).click();
			rightclick.click().perform();
			logger.pass("Click on the Project");
			Thread.sleep(10000);
			String select = Keys.chord(Keys.CONTROL, "a");
			rightclick.sendKeys(select).perform();
			if (i == 1) {
				rightclick.sendKeys(ProjectName).perform();
				logger.pass("Entered the ProjectName");
			}
			if (i == 2) {
				rightclick.sendKeys(ProjectName + "k").perform();
				logger.pass("Entered the second ProjectName");
			}

			DesktopSession.findElementByName(Pageobj.Finish_Button).click();
			DesktopSession = Root();
			Thread.sleep(2000);
		}

		rb.keyPress(KeyEvent.VK_CONTROL);
		WebElement projectName = DesktopSession.findElementByName(Pageobj.Project_PropertiesValidator);
		projectName.click();
		logger.pass("Clicked on the Project_Folder");
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rightclick.contextClick().perform();
		logger.pass("Right Clicked on the Project_Folder");
		Thread.sleep(1000);

		Map<Integer, String> map = new HashMap<Integer, String>();
		List<WebElement> lst = DesktopSession.findElementsByXPath(Pageobj.MenuItem);
		System.out.println(lst.size());
		for (int i = 0; i <= lst.size() - 1; i++) {
			String menus = lst.get(i).getAttribute("Name");
			map.put(i, menus);
		}
		boolean flag = map.containsValue("Properties");
		System.out.println(flag + " -=-=-=> ");
		Assert.assertEquals(flag, false);
		logger.pass("Verify the properties option is not displayed");

		return ProjectName;

	}

	public void computeCanValidations() throws Exception {

		DesktopSession = Root();
		Actions rightclick = new Actions(DesktopSession);
		WebElement workspace = DesktopSession.findElementByClassName(Pageobj.BlankWorkspaceArea);
		rightclick.moveToElement(workspace, 161, 244).contextClick().perform();

		boolean computeCanLabel_option;
		try {
			computeCanLabel_option = DesktopSession.findElementByName(Pageobj.computeCanLabel).isDisplayed();
			System.out.println(computeCanLabel_option);
		} catch (Exception e) {
			computeCanLabel_option = false;
			System.out.println(computeCanLabel_option);
		}

		Assert.assertEquals(false, computeCanLabel_option);

		logger.pass("Verify the Compute Can Filter option is not displayed");

	}

	public void LunchAppMultipleInstance(String AppPath1) throws Exception {

		DesktopSession = Root();
		Actions rightclick = new Actions(DesktopSession);
		logger.pass("Application opened for App Path1");
		WebElement wb = DesktopSession.findElementByName(Pageobj.workspaces);
		rightclick.click(wb).perform();
		logger.pass("Click on the Workspace");
		String select = Keys.chord(Keys.CONTROL, "a");
		rightclick.sendKeys(wb, select).perform();
		rightclick.sendKeys(wb, AppPath1).perform();
		logger.pass("entered the Workspace path");
		DesktopSession.findElementByName(Pageobj.Launch).click();
		logger.pass("Clicked Ok");
		Thread.sleep(11000);
		WebElement max = DesktopSession.findElementByXPath(Pageobj.Maximize);
		rightclick.doubleClick(max).perform();
		logger.pass("Maximized1");
		logger.pass("First Application Instance has been launched");
		WebElement close1 = DesktopSession.findElementByName(Pageobj.CloseButton);
		rightclick.doubleClick(close1).perform();
		Thread.sleep(3000);
		Setup();
		Thread.sleep(4000);
		DesktopSession = Root();
		LunchAppWithoutRandom("D:\\compose4ksar-18.1.3-win32.win32.x86_64\\Krish");
		logger.pass("Second Application Instance has been launched");

	}

// Is displayed by webelement Parameter
	public static boolean IsDispayed(WebElement webelement) {
		try {
			webelement.isDisplayed();
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	// Wait Till Control Display
	public void WaitTillControlToDisplay(WindowsElement control, int Waittime) throws Exception {
		int startTime = 0;

		while (startTime < Waittime) {
			try {
				if (!control.isDisplayed())
					startTime += 1;
				else {
					Thread.sleep(1000);
					return;
				}
			} catch (Exception e) {
				Thread.sleep(1000);
				return; // We should have Control loaded by now
			}

			Thread.sleep(1000);
		}

		Assert.fail("Time Out : Control - " + control + " Did not loaded within " + Waittime + " Seconds");

	}

	// To get the generic absolute Filepath

	public String getFilePath(String filePath) {

		// filePath ="ImportProject\\AR1128";

		String workingDirectory = System.getProperty("user.dir");
		System.out.println(workingDirectory);

		String absoluteFilePath = workingDirectory + File.separator + filePath;

		System.out.println(absoluteFilePath);
		return absoluteFilePath;

	}

	public String getFilePathHomeDir(String filePath) {

		// filePath ="c4k_workspace";

		String workingDirectory = System.getProperty("user.home");
		System.out.println(workingDirectory);

		String absoluteFilePath = workingDirectory + File.separator + filePath;

		System.out.println(absoluteFilePath);
		return absoluteFilePath;

	}

	@SuppressWarnings("unchecked")
	public void MappingSignalData(String Project) throws Exception {
		DesktopSession = Root();
		// Thread.sleep(2000);
		Actions act = new Actions(DesktopSession);
		Robot rb = new Robot();
		WebElement proj = DesktopSession.findElementByName(Project);
//	act.contextClick(proj).perform();
//	Thread.sleep(1500);
//	logger.info("Click the Project");
		act.doubleClick(proj).perform();
		WebElement asw = DesktopSession.findElementByName(Pageobj.ASW);
		act.doubleClick(asw).perform();
		Thread.sleep(500);
		logger.info("DoubleClick the ASW");
		DesktopSession.findElementByName(Pageobj.MCB_ECU_Extract).click();
		Thread.sleep(500);
		logger.info("Click the MCB_ECU_Extract");
		ExpandProject(3);
		logger.info("Expanded");
		DesktopSession.findElementByName(Pageobj.datamappingPackage).click();
		Thread.sleep(500);
		logger.info("Click the datamappingPackage");
		ExpandProject(3);
		logger.info("Expanded");
		DesktopSession.findElementByName(Pageobj.DataMapping_SystemMapping).click();
		Thread.sleep(500);
		logger.info("Click the System_datamapping");
		ExpandProject(1);
		logger.info("Expanded");
		Thread.sleep(1000);
		List<WebElement> lst = DesktopSession.findElementsByName(Pageobj.Sender_Reciver);
		System.out.println(lst.size());
		logger.info("----->  " + lst.size());
		DesktopSession.findElementByName("Page up").click();
		DesktopSession.findElementByName("Page up").click();
		proj.click();
		act.contextClick(proj).build().perform();
		Thread.sleep(1000);
		DesktopSession.findElementByName(Pageobj.Datamapping).click();
		logger.info("Click the Datamapping");
		Thread.sleep(7000);
		DesktopSession = Root();
		List<WebElement> Max = DesktopSession.findElementsByName("Maximize");
		System.out.println(Max.size() + " =-=-");
		for (int i = 0; i <= Max.size() - 1; i++) {
			System.out.println(Max.get(i).getAttribute("BoundingRectangle") + " ==> " + i);

			System.out.println(Max.get(i).getAttribute("RuntimeId") + " =r=> " + i);
		}
		Max.get(10).click();
		Thread.sleep(500);
		DesktopSession.findElementByName("SigGrp_V2G_PymntOptnLst").click();
		Thread.sleep(1000);
		System.out.println(" =-=-");
		WebElement DragN = DesktopSession.findElementByName(Pageobj.Sig_GrpV2G_PymntOptnLst);
		logger.info("Drag");
		System.out.println("=- = -> " + DragN.getAttribute("Name"));
//		String data = DragN.getAttribute("Name");
//		DesktopSession.findElementByName(data).click();
//		System.out.println(DragN.isDisplayed() + "  ************");
//		WebElement DropN = DesktopSession.findElementByName(Pageobj.ChgIntf);
//		logger.info("Drop");
//		System.out.println(DropN.isDisplayed() + "  ************");
//		act.dragAndDrop(DragN, DropN).build().perform();
		// Thread.sleep(1000);
		logger.info("Drag & Drop Done");
//		List<WebElement> restore = DesktopSession.findElementsByName("Restore");
//		Max.get(2).click();
//		Thread.sleep(500);
		lst = DesktopSession.findElementsByName(Pageobj.Sender_Reciver);
		System.out.println("======>   " + lst.size());
		logger.info("======>   " + lst.size());

	}

	@SuppressWarnings("unchecked")
	public void exportSWC(String Project) throws Exception {

		DesktopSession = Root();
		Actions act = new Actions(DesktopSession);
		Robot robo = new Robot();
		WebElement proj = DesktopSession.findElementByName(Project);
		proj.click();
		logger.pass("Clicked Project");
		act.contextClick(proj).perform();
		Thread.sleep(500);
		DesktopSession.findElementByName(Pageobj.Export).click();
		logger.pass("Clicked Export");
		Thread.sleep(500);
		DesktopSession.findElementByName(Pageobj.General_Folder).click();
		logger.pass("Clicked C4K");
		robo.keyPress(KeyEvent.VK_DOWN);
		robo.keyRelease(KeyEvent.VK_DOWN);
		robo.keyPress(KeyEvent.VK_RIGHT);
		robo.keyRelease(KeyEvent.VK_RIGHT);
		Thread.sleep(1000);
		DesktopSession.findElementByName(Pageobj.Export_SWC).click();
		logger.pass("Clicked Export_SWC");
		DesktopSession.findElementByName(Pageobj.Next_Button).click();
		logger.pass("Clicked Next_Button");
		DesktopSession.findElementByName(Pageobj.Export_Project).click();
		logger.pass("Clicked Export_Project");
		robo.keyPress(KeyEvent.VK_RIGHT);
		Thread.sleep(1000);
		DesktopSession.findElementByName(Pageobj.Export_File).click();
		logger.pass("Clicked Export_File");
		String SWC1 = DesktopSession.findElementByName(Pageobj.SWC1).getText();
		logger.pass("Get Text SWC1");
		DesktopSession.findElementByName(Pageobj.SWC1).click();
		logger.pass("Clicked SWC1");
		System.out.println(SWC1);
		robo.keyPress(KeyEvent.VK_SPACE);
		String SWC2 = DesktopSession.findElementByName(Pageobj.SWC2).getText();
		logger.pass("Get Text SWC2");
		DesktopSession.findElementByName(Pageobj.SWC2).click();
		logger.pass("Clicked SWC2");
		System.out.println(SWC2);
		robo.keyPress(KeyEvent.VK_SPACE);
		robo.keyRelease(KeyEvent.VK_SPACE);
		String path = System.getProperty("user.dir") + File.separator + "Export";
		System.out.println("------>   " + path);
		File pathAsFile = new File(path);

		if (!Files.exists(Paths.get(path))) {
			pathAsFile.mkdir();
		}
		String fileOne = "";
		String fileTwo = "";
		File dir = null;
		try {
			System.out.println("cyugchghg");
			DesktopSession.findElementByName(Pageobj.Browse).click();
			List<WebElement> lst = DesktopSession.findElementsByXPath("//*[@LocalizedControlType='edit']");
			System.out.println(lst.size());
			String select = Keys.chord(Keys.CONTROL, "a");
			lst.get(0).sendKeys(select);
			logger.pass("Cntrl All");
			lst.get(0).sendKeys(Keys.BACK_SPACE);
			logger.pass("Backspace ");
			lst.get(0).sendKeys(path);
			logger.pass("Entering report path");
			DesktopSession.findElementByName("OK").click();
			logger.pass("Click OK");
//			DesktopSession.findElementByName("Open").click();
//			WebElement dirpath = DesktopSession.findElementByName(Pageobj.Dir);
//			act.sendKeys(dirpath, select);
//			act.perform();
//			act.sendKeys(dirpath, Keys.BACK_SPACE).perform();
//			act.click(dirpath).perform();
//			logger.pass("Clicked dirpath");
//			dirpath.sendKeys(path);
//			List<WebElement> lstw = DesktopSession.findElementsByClassName("Edit");
//			System.out.println(lstw.size());
//
//			lstw.get(2).sendKeys(path);
//
//			Thread.sleep(1000);
//			DesktopSession.findElementByName(Pageobj.Browse).click();
//			Thread.sleep(1000);
//			DesktopSession.findElementByName(Pageobj.Browse).click();
//			DesktopSession.findElementByName("OK").click();
			Thread.sleep(1000);
			DesktopSession.findElementByName(Pageobj.Finish_Button).click();
			logger.pass("Clicked Finish_Button");

			Thread.sleep(5000);

			File file = new File(path);
			String[] fileList = file.list();
			fileOne = fileList[0];
			fileTwo = fileList[1];
			System.out.println("  --->" + fileOne + "    ====>" + fileTwo);
			SWC1 = "SWC_" + SWC1 + ".arxml";
			SWC2 = "SWC_" + SWC2 + ".arxml";

			System.out.println("********>  " + SWC1 + "     ---=-=--> " + SWC2);
			dir = new File(path);
		} finally {

			FileUtils.deleteDirectory(dir);
		}
		if (fileOne.contains(SWC1) && fileTwo.contains(SWC2)) {

			Assert.assertTrue(true);
		} else {
			Assert.assertFalse(false);

		}

	}

	public int VerifytheNotepad1014(String fileName) throws IOException {
		File file = new File(fileName);
		FileReader fr = new FileReader(file);
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(fr);
		String line;
		int count = 0;
		while ((line = br.readLine()) != null) {
			// process the line
			System.out.println(line);
			if (line.contains("DATA-SEND-POINTS") || line.contains("DSP_1") || line.contains("DSP_1_copy1")
					|| line.contains("DATA-RECEIVE-POINT-BY-ARGUMENTS") || line.contains("DRPA_1")
					|| line.contains("DRPA_1_copy1")) {

				count++;
				System.out.println("====>  " + count);

			} else {
				System.out.println("No Matches");
			}

		}
		System.out.println("------->  " + count);
		return count;
	}

	@SuppressWarnings("unchecked")
	public void VariableAccessCopyPaste(String Projectname, String Path) throws Exception {

		DesktopSession = Root();
		Actions act = new Actions(DesktopSession);
		// Thread.sleep(1000);
		// ImportProject(Path);
		DesktopSession = Root();
		System.out.println(Projectname);
		logger.pass(Projectname);
		WebElement proj = DesktopSession.findElementByName(Projectname);

		logger.pass("Clicked on Project");
		proj.click();
		ExpandProject(2);
//		act.doubleClick(proj).perform();
//		act.doubleClick(proj).perform();
		DesktopSession.findElementByName(Pageobj.default_arxml).click();
		logger.pass("Clicked on default_arxml");
		ExpandProject(9);
		logger.pass("expanded");
		WebElement sib = DesktopSession.findElementByName(Pageobj.Sib);
		logger.pass("sib   " + sib);
		sib.click();
		logger.pass("clicked sib");
		for (int count = 1; count <= 2; count++) {
			logger.pass("in for loop");
			DesktopSession = Root();
			DesktopSession.findElementByName(Pageobj.Sib).click();
			act.contextClick().perform();
			Thread.sleep(1000);
			DesktopSession.findElementByName(Pageobj.NewChild).click();
			logger.pass("click NewChild");
			Thread.sleep(1000);
			DesktopSession.findElementByName(Pageobj.Runnables).click();
			logger.pass("click Runnables");
			Thread.sleep(1000);
			DesktopSession.findElementByName(Pageobj.Runnable_Entity).click();
			Thread.sleep(2000);
			logger.pass("click Runnable_Entity");
		}
		DesktopSession.findElementByName(Pageobj.Created_Runnable).click();

		act.contextClick().perform();
		logger.pass("Right click Runnable_Entity");
		Thread.sleep(1000);
		DesktopSession.findElementByName(Pageobj.NewChild).click();
		logger.pass("click NewChild");
		Thread.sleep(1000);
		DesktopSession.findElementByName(Pageobj.DSP).click();
		logger.pass("click DSP");
		Thread.sleep(1000);
		DesktopSession.findElementByName(Pageobj.Variable_Access).click();
		logger.pass("click Variable_Access");
		Thread.sleep(1000);
		DesktopSession.findElementByName(Pageobj.Variable_child).click();
		act.contextClick().perform();
		logger.pass("Rightclick Variable_Access");
		String DSP = "DSP_1";
		Thread.sleep(1000);
		DesktopSession.findElementByName(Pageobj.Rename).click();
		Thread.sleep(1000);
		logger.pass("click Rename");
		List<WebElement> rename_input1 = DesktopSession.findElementsByClassName("Edit");
		System.out.println(rename_input1.size());
		for (int i = 0; i <= rename_input1.size() - 1; i++) {
			String value = rename_input1.get(i).getAttribute("Value.Value");
			System.out.println(value + " = -=- = -=> " + i);
		}
		String valuesw2 = rename_input1.get(rename_input1.size() - 1).getAttribute("Value.Value");
		System.out.println(valuesw2 + "  =--=--olkn=-=-=-> ");
		System.out.println(rename_input1.get(rename_input1.size() - 1));
		WebElement valuen = rename_input1.get(rename_input1.size() - 1);
		valuen.click();
		String select = Keys.chord(Keys.CONTROL, "a");
		valuen.sendKeys(select);
		valuen.sendKeys(Keys.BACK_SPACE);
		valuen.sendKeys(DSP);
		logger.pass(" Renamed");
		sib.click();
		String DSPele = "DSP_1 [VariableAccess]";
		DesktopSession.findElementByName(DSPele).click();
		act.contextClick().perform();
		Thread.sleep(500);
		logger.pass("Rightclick DSP_1");
		DesktopSession.findElementByName("Copy").click();
		Thread.sleep(1000);
		logger.pass("click copy");
		DesktopSession.findElementByName(Pageobj.Created_Runnable).click();
		logger.pass("click copy");
		act.contextClick().perform();
		Thread.sleep(1000);
		DesktopSession.findElementByName("Paste").click();
		Thread.sleep(1000);
		logger.pass("click Paste");
		Thread.sleep(1000);

		///
		DesktopSession.findElementByName(Pageobj.Created_Runnable2).click();
		act.contextClick().perform();
		DesktopSession.findElementByName(Pageobj.NewChild).click();
		logger.pass("click NewChild");
		DesktopSession.findElementByName(Pageobj.DRP_By_Arrgument).click();
		logger.pass("click DRP_By_Arrgument");
		DesktopSession.findElementByName(Pageobj.Variable_Access).click();
		logger.pass("click Variable_Access");
		Thread.sleep(1000);
		DesktopSession.findElementByName(Pageobj.Variable_child).click();
		act.contextClick().perform();
		logger.pass("click variablechildn");
		String DRP = "DRPA_1";
		DesktopSession.findElementByName(Pageobj.Rename).click();
		logger.pass("click Rename");
		List<WebElement> rename_input = DesktopSession.findElementsByClassName("Edit");
		System.out.println(rename_input.size());

		for (int i = 0; i <= rename_input.size() - 1; i++) {
			String value = rename_input.get(i).getAttribute("Value.Value");

			System.out.println(value + " = -=- = -=> " + i);

		}
		String valuesw = rename_input.get(rename_input.size() - 1).getAttribute("Value.Value");
		System.out.println(valuesw + "   =-=-==-=-=-p>  ");
		System.out.println(rename_input.get(rename_input.size() - 1));
		WebElement value = rename_input.get(rename_input.size() - 1);
		// DesktopSession.findElementByName(Pageobj.Rename_Input);
		String select1 = Keys.chord(Keys.CONTROL, "a");
		value.sendKeys(select1);
		value.sendKeys(Keys.BACK_SPACE);
		value.sendKeys(DRP);
		logger.pass("click Sendkeys");
		sib.click();
		String DRPele = "DRPA_1 [VariableAccess]";// DRPA_1 [VariableAccess]
		DesktopSession.findElementByName(DRPele).click();
		act.contextClick().perform();
		Thread.sleep(500);
		logger.pass("Rightclick on DRP_1");
		DesktopSession.findElementByName("Copy").click();
		logger.pass("click Copy");
		DesktopSession.findElementByName(Pageobj.Created_Runnable2).click();
		act.contextClick().perform();
		DesktopSession.findElementByName("Paste").click();
		Thread.sleep(1000);
		logger.pass("click Paste");

		DesktopSession.findElementByName(Projectname).click();
		act.contextClick().perform();
		Thread.sleep(500);
		DesktopSession.findElementByName("Refresh").click();
		DesktopSession.findElementByName(Pageobj.Save).click();
		Thread.sleep(2000);

	}

	public void VerifydefaultArxml(String Path, String Projectname) throws Exception {
		DesktopSession = Root();
		Actions act = new Actions(DesktopSession);
		Robot robo = new Robot();
		int count = VerifytheNotepad1014(Path);
		System.out.println(count);
		DesktopSession.findElementByName(Projectname).click();
		ExpandProject(12);
		DesktopSession.findElementByName(Pageobj.Created_Runnable2).click();
		act.contextClick().perform();
		Thread.sleep(1000);
		DesktopSession.findElementByName("Delete").click();
		Thread.sleep(500);
		robo.keyPress(KeyEvent.VK_ENTER);
		robo.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		DesktopSession.findElementByName(Pageobj.Created_Runnable).click();
		act.contextClick().perform();
		Thread.sleep(1000);
		DesktopSession.findElementByName("Delete").click();
		Thread.sleep(500);
		robo.keyPress(KeyEvent.VK_ENTER);
		robo.keyRelease(KeyEvent.VK_ENTER);
		DesktopSession.findElementByName(Projectname).click();
		act.contextClick().perform();
		Thread.sleep(1000);
		DesktopSession.findElementByName("Refresh").click();
		DesktopSession.findElementByName(Pageobj.Save).click();
		Assert.assertEquals(count, 0);

	}

	public void ReadValidationExcel(String filepath) {

	}

	@SuppressWarnings("unchecked")
	public String AddErrorsOnFile(String Project) throws Exception {
		// DesktopSession = Root();
		DesktopSession = Root();
		Robot robo = new Robot();
		Actions act = new Actions(DesktopSession);
		List<WebElement> viewlist = DesktopSession.findElementsByName("View Menu");
		viewlist.get(1).click();
		Thread.sleep(500);
		DesktopSession.findElementByName("Preferences").click();
		Thread.sleep(500);
		List<WebElement> edit = DesktopSession.findElementsByClassName("Edit");
		System.out.println(edit.size() + "   =------> ");
		WebElement limittoshow = edit.get(1);
		String select = Keys.chord(Keys.CONTROL, "a");
		limittoshow.click();
		limittoshow.sendKeys(select);
		limittoshow.sendKeys(Keys.BACK_SPACE);
		limittoshow.sendKeys("500");
		DesktopSession.findElementByName(Pageobj.Launch).click();
		Thread.sleep(1000);
		DesktopSession.findElementByName("Description").click();
		logger.pass("click Description");
		// Thread.sleep(1000);
		act.contextClick().perform();
		Thread.sleep(1000);
		logger.pass("Rightclick Description");
		DesktopSession.findElementByName(Pageobj.Select_All).click();
		logger.pass("click Selectall");
		Thread.sleep(2000);
		DesktopSession.findElementByName("Description").click();

		logger.pass("click Description");
		int i = 0;
		while (i <= 7) {
			System.out.println(i);
			logger.info("Waiting");
			Thread.sleep(4000);
			try {
				if (DesktopSession.findElementByName("Copy").isEnabled()) {

					act.contextClick().perform();
					break;

				} else {
					Thread.sleep(2000);
				}
			} catch (Exception e) {
				System.out.println(e);
			}
			i++;
		}
		act.contextClick().perform();

		logger.pass("Rightclick Description");

		Thread.sleep(1000);
		DesktopSession.findElementByName("Copy").click();
		logger.pass("click Copy");
		Thread.sleep(1000);
		String generatedString = "errors.txt";
		// DesktopSession.findElementByName(Project).click();
		ExpandProject(2);
		WebElement existfile = DesktopSession.findElementByName("errors.txt");
		existfile.click();
		act.doubleClick().perform();
		List<WebElement> lst = DesktopSession.findElementsByName("errors.txt");
		System.out.println(lst.size() + "   =========>   ");
		WebElement value = lst.get(1);
		WebElement value1 = lst.get(2);
		WebElement value2 = lst.get(3);
		System.out.println("element four");
		act.moveToElement(value2).perform();

		System.out.println("element three");
		act.moveToElement(value1).perform();
		System.out.println("element two");
		act.moveToElement(value).perform();

		// act.doubleClick(value).perform();
		act.doubleClick(value1).perform();
		// act.doubleClick(value2).perform();
//		WebElement filetxt = DesktopSession.findElementByClassName("SWT_Window0");
//		filetxt.click();
//		act.contextClick().perform();
//		DesktopSession.findElementByName("Paste").click();
		// Thread.sleep(1000);
		robo.keyPress(KeyEvent.VK_CONTROL);
		robo.keyPress(KeyEvent.VK_A);
		robo.keyRelease(KeyEvent.VK_CONTROL);
		robo.keyRelease(KeyEvent.VK_A);
		robo.keyPress(KeyEvent.VK_BACK_SPACE);
		robo.keyRelease(KeyEvent.VK_BACK_SPACE);
		robo.keyPress(KeyEvent.VK_CONTROL);
		robo.keyPress(KeyEvent.VK_V);
		logger.pass("click Paste");
		robo.keyRelease(KeyEvent.VK_CONTROL);
		robo.keyRelease(KeyEvent.VK_V);
		logger.pass("release Paste");
		robo.keyPress(KeyEvent.VK_CONTROL);
		robo.keyPress(KeyEvent.VK_S);
		robo.keyRelease(KeyEvent.VK_CONTROL);
		robo.keyRelease(KeyEvent.VK_S);
		logger.pass("click Save");
		return generatedString;

	}

	@SuppressWarnings("unchecked")
	public Integer NoofErrorValidation() throws Exception {

		DesktopSession = Root();
		System.out.println("=============>sca");
		List<WebElement> lst = DesktopSession.findElementsByXPath("//*[@LocalizedControlType='text']");
		System.out.println(lst.size() + " =-=-> ");
		String text = "";
		for (int i = 0; i <= lst.size() - 1; i++) {
			System.out.println(lst.get(i).getAttribute("Name") + " = - > " + i);
		}
		// String text = DesktopSession.findElementByName("517 errors, 0 warnings, 0
		// infos").getText();
		text = lst.get(0).getAttribute("Name");
		System.out.println("text  -->  " + text);
		// 424 errors, 4 warnings, 7 infos
		String value = text.trim();
		String[] value1 = value.split(" ");
		System.out.println(value1[0]);
		System.out.println(value1[2]);
		System.out.println(value1[4]);
		String data = value1[0];
		String data1 = value1[2];
		String data2 = value1[4];
		System.out.println("text  -->  " + data);
		System.out.println("text  -->  " + data1);
		System.out.println("text  -->  " + data2);
		int number = Integer.parseInt(data);
		int number1 = Integer.parseInt(data1);
		int number2 = Integer.parseInt(data2);
		int Total = number + number1 + number2;
		System.out.println("----------->   " + Total);
		return Total;

	}

	@SuppressWarnings("resource")
	public Integer RowinExcel(String Excelpath) throws IOException {

		String path = Excelpath;
		File file = new File(path);

		// Create an object of FileInputStream class to read excel file
		FileInputStream inputStream = new FileInputStream(file);

		// creating workbook instance that refers to .xls file
		HSSFWorkbook wb = new HSSFWorkbook(inputStream);

		// creating a Sheet object
		HSSFSheet sheet = wb.getSheet("Validation Error Report");
		// Map<Integer, String> map = new HashMap<Integer, String>();
		// get all rows in the sheet
		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
		System.out.println("----->    " + rowCount);

		return rowCount;

	}

	public void VerifyEnablement_of_Save_button() throws Exception {

		DesktopSession = Root();
		Robot rb = new Robot();
		Actions rightclick = new Actions(DesktopSession);
		// DesktopSession.findElementByName(ProjectName).click();

		rb.keyPress(KeyEvent.VK_RIGHT);
		rb.keyPress(KeyEvent.VK_RIGHT);
		logger.info("Expanded the Project");
		DesktopSession.findElementByName("ECUExtract.arxml").click();
		logger.info("Clicked ECUExtract.arxml file");
		WebElement ecu = DesktopSession.findElementByName("ECUExtract.arxml");
		rightclick.contextClick(ecu).perform();
		logger.info("RightClick on the ECUExtract.arxml file");
		Thread.sleep(1000);
		DesktopSession.findElementByName("Clear validation markers").click();
		logger.info("Clear validation markers");
		Thread.sleep(1000);
		rightclick.contextClick(ecu).perform();
		logger.info("RightClick on the ECUExtract.arxml file");
		Thread.sleep(1000);
		DesktopSession.findElementByName("Batch Validation").click();
		logger.info("Clicked on Batch Validation");

		int i = 0;
		while (i <= 7) {
			System.out.println(i);
			logger.info("Waiting");
			Thread.sleep(2000);
			if (DesktopSession.findElementByName("Export Validation Report").isEnabled()) {

				DesktopSession.findElementByName("Export Validation Report").click();
				break;
			} else {
				Thread.sleep(2000);
			}
			i++;
		}
		logger.pass("Clicked on Export Validation Report");

		Thread.sleep(3000);
		boolean save = DesktopSession.findElementByName("Save").isEnabled();
		boolean cancel = DesktopSession.findElementByName("Cancel").isEnabled();
		DesktopSession.findElementByName("Cancel").click();
		System.out.println("---->  " + save + "  ====>  " + cancel);
		Assert.assertEquals(save, true);
		Assert.assertEquals(cancel, true);

	}

	public void addModuleDefinationFilesBswmd(String Project) throws Exception {

		DesktopSession = Root();
		Actions act = new Actions(DesktopSession);
		Robot rb = new Robot();
		SoftAssert softAssert = new SoftAssert();
		WebElement proj = DesktopSession.findElementByName(Project);
		proj.click();
		logger.pass("Clicked the Project");
		act.contextClick(proj).perform();
		logger.pass("Right Clicked the Project");
		Thread.sleep(1000);
		boolean flag = DesktopSession.findElementByName(Pageobj.Properties_Tab).isEnabled();
		Assert.assertEquals(true, flag);
		logger.pass("Verified the Properties tab is enabled");
		DesktopSession.findElementByName(Pageobj.Properties_Tab).click();
		logger.pass("Clicked the properties Tab");
		DesktopSession.findElementByName(Pageobj.Module_Defination).click();
		logger.pass("Clicked the Module Defination Option");
		// DesktopSession = Root();
		WebElement ele = DesktopSession.findElementByXPath(Pageobj.Module_Defination_File3);
		act.moveByOffset(0, 0).moveToElement(ele, 545, 247).doubleClick().perform();
		Thread.sleep(1000);

		// WebElement Defination_File3 =
		// DesktopSession.findElementByAccessibilityId(Pageobj.Module_Defination_File3);
		// act.doubleClick(Defination_File3).perform();
		// Thread.sleep(1000);
		/*
		 * if(DesktopSession.findElementByAccessibilityId(Pageobj.
		 * Module_Defination_File3).isDisplayed()) {
		 * DesktopSession.findElementByAccessibilityId(Pageobj.Module_Defination_File3).
		 * click(); }
		 */
		/*
		 * Thread.sleep(1000); rb.keyPress(KeyEvent.VK_SPACE); Thread.sleep(100);
		 * rb.keyPress(KeyEvent.VK_ENTER); Thread.sleep(3000);
		 * 
		 * try { WebElement Defination_File3 =
		 * DesktopSession.findElementByAccessibilityId(Pageobj.Module_Defination_File3);
		 * act.doubleClick(Defination_File3).perform();
		 * logger.info("Clicked the Module Defination file3"); } catch (Exception e) {
		 * System.out.println("Not Clicked the Module Defination file3");
		 * 
		 * }
		 * 
		 * 
		 * logger.pass("Clicked the Module Defination file3");
		 * 
		 * rb.keyPress(KeyEvent.VK_SPACE); Thread.sleep(100);
		 * rb.keyPress(KeyEvent.VK_ENTER); Thread.sleep(3000);
		 * 
		 * 
		 * WebElement Defination_File4 =
		 * DesktopSession.findElementByAccessibilityId(Pageobj.Module_Defination_File4);
		 * act.click(Defination_File4).build().perform();
		 * logger.pass("Clicked the Module Defination file4");
		 * rb.keyPress(KeyEvent.VK_SPACE); Thread.sleep(100);
		 * rb.keyPress(KeyEvent.VK_ENTER); Thread.sleep(3000);
		 * 
		 * 
		 * Thread.sleep(1000); //act.moveByOffset(0, 0).moveByOffset(375,
		 * 247).click().perform();
		 * DesktopSession.findElementByName(Pageobj.Module_Defination_File4).click();
		 * //Thread.sleep(1000); //act.moveByOffset(0, 0).moveByOffset(375,
		 * 387).click().perform(); Thread.sleep(1000);
		 * 
		 * 
		 * WebElement AR1124 =
		 * DesktopSession.findElementByName(Pageobj.Project_Folder1);
		 * act.doubleClick(AR1124).perform(); WebElement bswmdFolder =
		 * DesktopSession.findElementByName(Pageobj.BSWMD_Folder);
		 * act.click(bswmdFolder).perform(); act.doubleClick(bswmdFolder).perform();
		 * boolean bswmd =
		 * DesktopSession.findElementByName(Pageobj.BSWMD_Folder).isDisplayed();
		 * Assert.assertEquals(bswmd, true);
		 * logger.pass("Verify the foldername created"); boolean file3 =
		 * DesktopSession.findElementByName(Pageobj.Module_Defination_File3).isDisplayed
		 * (); softAssert.assertEquals(file3, true); boolean file4 =
		 * DesktopSession.findElementByName(Pageobj.Module_Defination_File4).isDisplayed
		 * (); softAssert.assertEquals(file4, true);
		 */

	}

	public void verifyPreviousLocation(String AppPath1) throws Exception {

		DesktopSession = Root();
		Actions rightclick = new Actions(DesktopSession);
		logger.pass("Application opened for App Path1");
		WebElement wb = DesktopSession.findElementByName(Pageobj.workspaces);
		rightclick.click(wb).perform();
		logger.pass("Click on the Workspace");
		String select = Keys.chord(Keys.CONTROL, "a");
		rightclick.sendKeys(wb, select).perform();
		rightclick.sendKeys(wb, AppPath1).perform();
		logger.pass("entered the Workspace path");
		DesktopSession.findElementByName(Pageobj.Launch).click();
		logger.pass("Clicked Ok");
		Thread.sleep(11000);
		WebElement max = DesktopSession.findElementByXPath(Pageobj.Maximize);
		rightclick.doubleClick(max).perform();
		logger.pass("Maximized1");
		logger.pass("First Application Instance has been launched");
		WebElement close1 = DesktopSession.findElementByName(Pageobj.CloseButton);
		rightclick.doubleClick(close1).perform();

	}

	public void Upload_IOPT_File(String ProjectName) throws Exception {

		DesktopSession = Root();
		Robot rb = new Robot();
		Actions rightclick = new Actions(DesktopSession);
		Thread.sleep(5000);
		boolean AR = DesktopSession.findElementByName(Pageobj.ProjectFolderIOPT).isDisplayed();
		Assert.assertEquals(AR, true);
		WebElement abc = DesktopSession.findElementByName(Pageobj.ProjectFolderIOPT);
		System.out.println(AR);
		if (AR == true) {
			Thread.sleep(1000);
			abc.click();
			rightclick.contextClick(abc).perform();
		} else {
			rightclick.contextClick(abc).perform();
		}
		logger.pass("Clicked On AR431 project folder");
		rightclick.contextClick().build().perform();
		logger.pass("Right Clicked On ProjectFolder");
		DesktopSession.findElementByName(Pageobj.Import).click();
		logger.pass("Clicked On Import");
		DesktopSession.findElementByName(Pageobj.General_Folder).click();
		logger.pass("Clicked on the General_Folder");
		rb.keyPress(KeyEvent.VK_RIGHT);
		logger.pass("Expanded the General_Folder");
		DesktopSession.findElementByName(Pageobj.Import_FileSystem).click();
		logger.pass("Clicked On Filesystem");
		DesktopSession.findElementByName(Pageobj.Next_Button).click();
		logger.pass("Clicked On NextButton");
		String filePath = getFilePath("ImportProject\\AR431");
		WebElement Inputfilepath = DesktopSession.findElementByName(Pageobj.File_Directory);
		rightclick.click(Inputfilepath).perform();
		rightclick.sendKeys(Inputfilepath, filePath).perform();
		logger.pass("Passed The file path");
		rightclick.sendKeys(Keys.ENTER).perform();
		DesktopSession.findElementByName(Pageobj.ProjectFolderIOPT).click();
		rb.keyPress(KeyEvent.VK_SPACE);
		logger.pass("Selected the File to Upload");
		DesktopSession.findElementByName(Pageobj.Finish_Button).click();
		logger.pass("Clicked On Finish Button");
		Thread.sleep(500);
		System.out.println(AR);
		rightclick.doubleClick(abc).perform();
		logger.pass("Double Clicked On Project_Folder2");
		boolean IoptFile = DesktopSession.findElementByName(Pageobj.IOPTFileName).isDisplayed();
		Assert.assertEquals(IoptFile, true);
		logger.pass("Verify the IOPTFile Uploaded");
		boolean IOPTfileConfirmation = DesktopSession.findElementByName(Pageobj.IOPTFileName).isDisplayed();
		WebElement IOPTfile = DesktopSession.findElementByName(Pageobj.IOPTFileName);
		if (IOPTfileConfirmation == true) {

			rightclick.contextClick(IOPTfile).perform();
		} else
			Thread.sleep(1000);
		rightclick.contextClick(IOPTfile).perform();
		logger.pass("Right Clicked On IOPTFileName");
		boolean ECUExtractOptionflag = DesktopSession.findElementByName(Pageobj.ECU_ExtractOption).isDisplayed();
		Assert.assertEquals(ECUExtractOptionflag, true);
		logger.pass("Verify the ECUExtractOption display");
		Thread.sleep(500);
		DesktopSession.findElementByName(Pageobj.ECU_ExtractOption).click();
		String MsgLabel = DesktopSession.findElementByName(Pageobj.ECU_ExtraxtDisabledOption).getText();
		Assert.assertEquals(MsgLabel, "The chosen operation is not enabled.");
		DesktopSession.findElementByName(Pageobj.Launch).click();
		// WebElement close1 = DesktopSession.findElementByName(Pageobj.CloseButton);
		// rightclick.doubleClick(close1).perform();
	}

	public void exportFileContextOptionValidations() throws Exception {

		DesktopSession = Root();
		Actions rightclick = new Actions(DesktopSession);
		WebElement workspace = DesktopSession.findElementByClassName(Pageobj.BlankWorkspaceArea);
		rightclick.moveToElement(workspace, 161, 244).contextClick().perform();
		logger.pass("Right Clicked on Blank Workspace");

		boolean exportFileContext_option;
		try {
			exportFileContext_option = DesktopSession.findElementByName(Pageobj.ExportFileOption).isDisplayed();
			System.out.println(exportFileContext_option);
		} catch (Exception e) {
			exportFileContext_option = false;
			System.out.println(exportFileContext_option);
		}

		Assert.assertEquals(false, exportFileContext_option);

		logger.pass("Verify the ExportFileOption Can Filter option is not displayed");
		// WebElement close1 = DesktopSession.findElementByName(Pageobj.CloseButton);
		// rightclick.doubleClick(close1).perform();
		logger.pass("Closed The Application Successfully");

	}

	public void showInSystemExplorerOptionValidations() throws Exception {

		DesktopSession = Root();
		Actions rightclick = new Actions(DesktopSession);
		WebElement workspace = DesktopSession.findElementByClassName(Pageobj.BlankWorkspaceArea);
		rightclick.moveToElement(workspace, 161, 244).contextClick().perform();
		logger.pass("Right Clicked on Blank Workspace");

		boolean showInSystemExplorer_option;
		try {
			showInSystemExplorer_option = DesktopSession.findElementByName(Pageobj.ShowInSystemExplorerOption)
					.isDisplayed();
			System.out.println(showInSystemExplorer_option);
		} catch (Exception e) {
			showInSystemExplorer_option = false;
			System.out.println(showInSystemExplorer_option);
		}

		Assert.assertEquals(false, showInSystemExplorer_option);
		logger.pass("Verify the Show In SystemExplorer option is not displayed");
		// WebElement close1 = DesktopSession.findElementByName(Pageobj.CloseButton);
		// rightclick.doubleClick(close1).perform();
		logger.pass("Closed The Application Successfully");

	}

	@SuppressWarnings("unchecked")
	public void VerifyBookmark() throws Exception {

		DesktopSession = Root();
		Robot rb = new Robot();
		Actions rightclick = new Actions(DesktopSession);
		DesktopSession.findElementByName(Pageobj.Help).click();
		logger.pass("Clicked on Help");
		DesktopSession.findElementByName(Pageobj.Help_Contents).click();
		logger.pass("Clicked on Help_Contents");
		DesktopSession = Root();
		DesktopSession.findElementByName(Pageobj.JD_User_Guide).click();
		logger.pass("Clicked on JD_User_Guide");
		rb.keyPress(KeyEvent.VK_RIGHT);
		Thread.sleep(1000);
		rb.keyRelease(KeyEvent.VK_RIGHT);
		List<WebElement> getting = DesktopSession.findElementsByName("Getting Started");
		System.out.println(getting.size());
		// getting.get(0).click();
		getting.get(1).click();
		rb.keyPress(KeyEvent.VK_RIGHT);
		Thread.sleep(1000);
		rb.keyRelease(KeyEvent.VK_RIGHT);
		logger.pass("Clicked on Getting_Started");
		String basic_tutorial = DesktopSession.findElementByName(Pageobj.Basic_tutorial).getText();
		logger.pass("Get Text on Basic_tutorial");
		System.out.println(basic_tutorial);
		List<WebElement> basic = DesktopSession.findElementsByName(Pageobj.Basic_tutorial);
		// DesktopSession.findElementByName(Pageobj.Basic_tutorial).click();
		System.out.println(basic.size());
		basic.get(1).click();
		logger.pass("Clicked on Basic_tutorial");
		rb.keyPress(KeyEvent.VK_RIGHT);
		Thread.sleep(1000);
		rb.keyRelease(KeyEvent.VK_RIGHT);
		DesktopSession.findElementByName(Pageobj.Bookmark_Document).click();
		logger.pass("Clicked on Bookmark_Document");
		DesktopSession.findElementByName(Pageobj.JD_User_Guide).click();
		logger.pass("Clicked on JD_User_Guide");
		rb.keyPress(KeyEvent.VK_LEFT);
		Thread.sleep(1000);
		logger.pass("Close the JD_User_Guide");
		DesktopSession.findElementByName("Index").click();
		rb.keyPress(KeyEvent.VK_RIGHT);
		rb.keyPress(KeyEvent.VK_RIGHT);
		rb.keyRelease(KeyEvent.VK_RIGHT);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		logger.pass("Clicked on Bookmarks");
		boolean flag = DesktopSession.findElementByName(Pageobj.Basic_tutorial).isDisplayed();
		System.out.println(flag);
		Assert.assertEquals(flag, true);
		logger.pass("Clicked on Help");
	}

	@SuppressWarnings("unchecked")
	public void navigateToLink() throws Exception {
		DesktopSession = Root();
		Robot rb = new Robot();
		Actions act = new Actions(DesktopSession);
		List<WebElement> all = DesktopSession.findElementsByName(Pageobj.Help);
		System.out.println(all.size());
		// all.get(0).click();
		all.get(0).click();
		act.moveToElement(all.get(0)).perform();
		// DesktopSession.findElementByName(Pageobj.Help).click();
		logger.pass("Clicked on Help");
		DesktopSession.findElementByName(Pageobj.Help_Contents).click();
		logger.pass("Clicked on Help_Contents");
		DesktopSession = Root();
		DesktopSession.findElementByName(Pageobj.JD_User_Guide).click();
		logger.pass("Clicked on JD_User_Guide");
		rb.keyPress(KeyEvent.VK_RIGHT);
		Thread.sleep(1000);
		rb.keyRelease(KeyEvent.VK_RIGHT);
		List<WebElement> getting = DesktopSession.findElementsByName("Getting Started");
		System.out.println(getting.size());
		// getting.get(0).click();
		getting.get(1).click();
		rb.keyPress(KeyEvent.VK_RIGHT);
		Thread.sleep(1000);
		rb.keyRelease(KeyEvent.VK_RIGHT);
		logger.pass("Clicked on Getting_Started");
		String basic_tutorial = DesktopSession.findElementByName(Pageobj.Basic_tutorial).getText();
		logger.pass("Get Text on Basic_tutorial");
		System.out.println(basic_tutorial);
		List<WebElement> basic = DesktopSession.findElementsByName(Pageobj.Basic_tutorial);
		System.out.println(basic.size());
		basic.get(1).click();
		logger.pass("Clicked on Basic_tutorial");
		rb.keyPress(KeyEvent.VK_RIGHT);
		Thread.sleep(1000);
		rb.keyRelease(KeyEvent.VK_RIGHT);
		DesktopSession.findElementByName(Pageobj.PreparingEclipse).click();
		Thread.sleep(1000);
		DesktopSession.findElementByName(Pageobj.Window_Preferences).click();
		String titlevalue = DesktopSession.findElementByXPath(Pageobj.Titlebar).getAttribute("Value.Value");
		System.out.println(" ----->  " + titlevalue);
		Assert.assertEquals(titlevalue, "Preferences");
	}

	@SuppressWarnings("unchecked")
	public void SearchedContent(String Content) throws Exception {

		DesktopSession = Root();
		Actions act = new Actions(DesktopSession);
		List<WebElement> all = DesktopSession.findElementsByName(Pageobj.Help);
		System.out.println(all.size());
		all.get(0).click();
		// all.get(1).click();
		act.moveToElement(all.get(0)).perform();
		// DesktopSession.findElementByName(Pageobj.Help).click();
		logger.pass("Clicked on Help");
		DesktopSession.findElementByName(Pageobj.Help_Contents).click();
		logger.pass("Clicked on Help_Contents");
		Thread.sleep(2000);
		DesktopSession = Root();
		List<WebElement> lst = DesktopSession.findElementsByName("Search:");
		System.out.println(" === > " + lst.size());

		WebElement wb = lst.get(1);
		logger.pass("Clicked on Search Input");
		wb.click();
		String select = Keys.chord(Keys.CONTROL, "a");
		wb.sendKeys(select);
		logger.pass("cleared on Search Input");
		wb.sendKeys(Keys.BACK_SPACE);
		logger.pass("backspace on Search Input");
		wb.sendKeys(Content);
		DesktopSession.findElementByName(Pageobj.Go_Button).click();
		logger.pass("Clicked on Go button");
		Thread.sleep(1000);
		DesktopSession = Root();
		wb.sendKeys(select);
		wb.sendKeys(Keys.BACK_SPACE);
		Thread.sleep(1000);
		boolean flag = DesktopSession.findElementByName(Content).isDisplayed();
		logger.pass("Searched flag is " + flag);
		System.out.println(flag + " = -= - => ");
		Assert.assertEquals(flag, true);
		logger.pass("All is Well");
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_ALT);
		Thread.sleep(500);
		rb.keyPress(KeyEvent.VK_F4);
		Thread.sleep(500);
		rb.keyRelease(KeyEvent.VK_ALT);
		Thread.sleep(500);
		rb.keyRelease(KeyEvent.VK_F4);

	}

	@SuppressWarnings("unchecked")
	public void VerifyPrintOption() throws Exception {

		DesktopSession = Root();
		Robot rb = new Robot();
		Actions act = new Actions(DesktopSession);
		List<WebElement> all = DesktopSession.findElementsByName(Pageobj.Help);
		System.out.println(all.size());
		all.get(0).click();
		// all.get(1).click();
		act.moveToElement(all.get(0)).perform();
		DesktopSession.findElementByName(Pageobj.Help).click();
		logger.pass("Clicked on Help");
		DesktopSession.findElementByName(Pageobj.Help_Contents).click();
		logger.pass("Clicked on Help_Contents");
		DesktopSession = Root();
		DesktopSession.findElementByName(Pageobj.JD_User_Guide).click();
		logger.pass("Clicked on JD_User_Guide");
		rb.keyPress(KeyEvent.VK_RIGHT);
		Thread.sleep(1000);
		rb.keyRelease(KeyEvent.VK_RIGHT);
		List<WebElement> getting = DesktopSession.findElementsByName("Getting Started");
		System.out.println(getting.size());
		// getting.get(0).click();
		getting.get(1).click();
		rb.keyPress(KeyEvent.VK_RIGHT);
		Thread.sleep(1000);
		rb.keyRelease(KeyEvent.VK_RIGHT);
		logger.pass("Clicked on Getting_Started");
		String basic_tutorial = DesktopSession.findElementByName(Pageobj.Basic_tutorial).getText();
		logger.pass("Get Text on Basic_tutorial");
		System.out.println(basic_tutorial);
		List<WebElement> basic = DesktopSession.findElementsByName(Pageobj.Basic_tutorial);
		System.out.println(basic.size());
		basic.get(1).click();
		logger.pass("Clicked on Basic_tutorial");
		rb.keyPress(KeyEvent.VK_RIGHT);
		Thread.sleep(2000);
		rb.keyRelease(KeyEvent.VK_RIGHT);
		DesktopSession.findElementByName(Pageobj.PreparingEclipse).click();
		logger.pass("Clicked on PreparingEclipse");
		DesktopSession.findElementByName(Pageobj.Print_page).click();
		logger.pass("Clicked on Print_page");
		DesktopSession = Root();
		List<WebElement> titlebar = DesktopSession.findElementsByXPath(Pageobj.Maximize);
		System.out.println(titlebar.size() + " --------->   ");
		String PrintPopup = titlebar.get(0).getAttribute("Value.Value");
		System.out.println(PrintPopup + "   ===========> ");
		Assert.assertEquals(PrintPopup, "Print");
		DesktopSession.findElementByName(Pageobj.CancelButton).click();
		rb.keyPress(KeyEvent.VK_ALT);
		Thread.sleep(500);
		rb.keyPress(KeyEvent.VK_F4);
		Thread.sleep(500);
		rb.keyRelease(KeyEvent.VK_ALT);
		Thread.sleep(500);
		rb.keyRelease(KeyEvent.VK_F4);

	}

	@SuppressWarnings("unchecked")
	public void VerifyNextLink() throws Exception {
		DesktopSession = Root();
		Robot rb = new Robot();
		// Actions rightclick = new Actions(DesktopSession);
		System.out.println("VerifyNextLink is executing =====================================================>>>>>");
		DesktopSession.findElementByName(Pageobj.Help).click();
		logger.pass("Clicked on Help");
		DesktopSession.findElementByName(Pageobj.Help_Contents).click();
		logger.pass("Clicked on Help_Contents");
		DesktopSession = Root();
		DesktopSession.findElementByName(Pageobj.JD_User_Guide).click();
		logger.pass("Clicked on JD_User_Guide");
		rb.keyPress(KeyEvent.VK_RIGHT);
		Thread.sleep(1000);
		rb.keyRelease(KeyEvent.VK_RIGHT);
		List<WebElement> getting = DesktopSession.findElementsByName("Getting Started");
		System.out.println(getting.size());
		// getting.get(0).click();
		getting.get(1).click();
		rb.keyPress(KeyEvent.VK_RIGHT);
		Thread.sleep(1000);
		rb.keyRelease(KeyEvent.VK_RIGHT);
		logger.pass("Clicked on Getting_Started");
		String basic_tutorial = DesktopSession.findElementByName(Pageobj.Basic_tutorial).getText();
		logger.pass("Get Text on Basic_tutorial");
		System.out.println(basic_tutorial);
		List<WebElement> basic = DesktopSession.findElementsByName(Pageobj.Basic_tutorial);
		// DesktopSession.findElementByName(Pageobj.Basic_tutorial).click();
		System.out.println(basic.size());
		basic.get(1).click();
		logger.pass("Clicked on Basic_tutorial");
		rb.keyPress(KeyEvent.VK_RIGHT);
		Thread.sleep(1000);
		rb.keyRelease(KeyEvent.VK_RIGHT);
		DesktopSession.findElementByName(Pageobj.PreparingEclipse).click();
		logger.pass("Clicked on PreparingEclipse");
		DesktopSession.findElementByName("Verifying JRE installation and classpath variables").click();
		logger.pass("Click on Verifying JRE installation and classpath variables");
		WebElement NextSection = DesktopSession.findElementByName("Next Section:");
		int i = 0;
		while (i <= 21) {
			System.out.println(i);
			logger.info("scrolling");
			Thread.sleep(1000);
			if (NextSection.isDisplayed()) {
				rb.keyPress(KeyEvent.VK_DOWN);
				Thread.sleep(1000);
				break;
			} else {
				rb.keyPress(KeyEvent.VK_DOWN);
				Thread.sleep(1000);
			}
			i++;
		}
		String NextLink = NextSection.getText();
		System.out.println(" ---  >> " + NextLink);
		List<WebElement> nxtLink = DesktopSession.findElementsByName(Pageobj.Creating_your_first_Java_project);
		System.out.println(nxtLink.size() + "  -=-=-=-  >  ");
		List<WebElement> txet = DesktopSession.findElementsByXPath("//*[@LocalizedControlType = 'text']");
		String nextquestion = txet.get(11).getAttribute("Value.Value");
		System.out.println(nextquestion);
		String nextQuestValue = nextquestion.substring(9, 57);
		System.out.println(nextQuestValue);
		String nextquestionLink = txet.get(91).getAttribute("Value.Value");
		System.out.println(nextquestionLink);
		String expectedquestion = nextquestionLink.substring(34, 82);
		System.out.println(expectedquestion);

		Assert.assertEquals(nextQuestValue, expectedquestion);
		rb.keyPress(KeyEvent.VK_ALT);
		rb.keyPress(KeyEvent.VK_F4);
		Thread.sleep(1000);
		rb.keyRelease(KeyEvent.VK_ALT);
		rb.keyRelease(KeyEvent.VK_F4);

//		Thread.sleep(1000);
//		rb.keyPress(KeyEvent.VK_ALT);
//		rb.keyPress(KeyEvent.VK_F4);
//		Thread.sleep(1000);
//		rb.keyRelease(KeyEvent.VK_ALT);
//		rb.keyRelease(KeyEvent.VK_F4);

	}

	public void VerifyHelpContentGroup() throws Exception {

		DesktopSession = Root();
		Robot rb = new Robot();
		DesktopSession.findElementByName(Pageobj.Help).click();
		logger.pass("Clicked on Help");
		DesktopSession.findElementByName(Pageobj.Help_Contents).click();
		logger.pass("Clicked on Help_Contents");
		DesktopSession = Root();
		boolean WorkbenchUserGuide = DesktopSession.findElementByName("Workbench User Guide").isDisplayed();
		System.out.println(WorkbenchUserGuide);
		boolean Javadevelopmentuserguide = DesktopSession.findElementByName("Java development user guide")
				.isDisplayed();
		System.out.println(Javadevelopmentuserguide);
		boolean PlatformPlugDeveloperGuide = DesktopSession.findElementByName("Platform Plug-in Developer Guide")
				.isDisplayed();
		System.out.println(PlatformPlugDeveloperGuide);
		boolean PlugDevelopmentEnvironmentGuide = DesktopSession
				.findElementByName("Plug-in Development Environment Guide").isDisplayed();
		System.out.println(PlatformPlugDeveloperGuide);
		boolean EMFDeveloperGuide = DesktopSession.findElementByName("EMF Developer Guide").isDisplayed();
		System.out.println(EMFDeveloperGuide);
		if (WorkbenchUserGuide && Javadevelopmentuserguide && PlatformPlugDeveloperGuide
				&& PlugDevelopmentEnvironmentGuide && EMFDeveloperGuide == true) {

			Assert.assertTrue(true, "elements are Present");

		} else {

			Assert.assertFalse(false, "elements are not Present");
		}
	}

	@SuppressWarnings("unchecked")
	public void VerifyDisplayOnRte(String ProjectName) throws Exception {

		DesktopSession = Root();
		Robot rb = new Robot();
		Actions act = new Actions(DesktopSession);
		DesktopSession.findElementByName(ProjectName).click();
		logger.pass("Clicked On ProjectName");
		System.out.println("donesssa ----> ");
		// Thread.sleep(2000);
		rb.keyPress(KeyEvent.VK_RIGHT);
		logger.pass("Clicked On Project");
		WebElement wbn = DesktopSession.findElementByName(Pageobj.EcucDescription_arxml);
		// Thread.sleep(5000);
		wbn.click();
		logger.pass("Clicked On EcucDescription_arxml");
		ExpandProject(7);
		WebElement rte = DesktopSession.findElementByName(Pageobj.Rte);
		act.contextClick(rte).perform();
		Thread.sleep(1000);
		boolean bal = DesktopSession.findElementByName(Pageobj.Configure_Event_Mapping).isDisplayed();
		System.out.println("===-=-=-=-=-- >  " + bal);
		if (bal == true) {
			Thread.sleep(1000);
			DesktopSession.findElementByName(Pageobj.Configure_Event_Mapping).click();
		} else {
			act.contextClick(rte).perform();
			Thread.sleep(3000);
			DesktopSession.findElementByName(Pageobj.Configure_Event_Mapping).click();
		}
		logger.pass("Clicked Configure Event Mapping");
		Thread.sleep(1000);
		DesktopSession.findElementByName(Pageobj.COMM_Impl_ComM_IB).click();
		rb.keyPress(KeyEvent.VK_RIGHT);
		logger.pass("Clicked On COMM_Impl_ComM_IB");
		DesktopSession.findElementByName("Hide mapped events").click();
		Thread.sleep(1000);
		List<WebElement> filter = DesktopSession.findElementsByClassName("Edit");
		System.out.println(filter.size() + "  -=111==-> ");
		for (int i = 0; i <= filter.size() - 1; i++) {
			String helptext = filter.get(i).getAttribute("Name");
			System.out.println(helptext + " !!!!!===> ");
			if (helptext.equalsIgnoreCase("type filter text")) {
				filter.get(i).sendKeys("COMM");
				break;
			}
		}
		WebElement wb = DesktopSession.findElementByName(Pageobj.ComM_MainFunction);
		act.moveToElement(wb).perform();
		Thread.sleep(1000);
		logger.pass("Move cursor to ComM_MainFunction ");
		String str = wb.getText();
		System.out.println(str + "  -=- uu ===>  ");// ComM_MainFunction_4 [BswTimingEvent] [ComM_MainFunction_4] [0.01]
		String[] arry = str.split(" ");
		System.out.println("909 ===> " + arry.length);
		System.out.println(arry[0]);
		String EventName = arry[0];
		String EventType = arry[1].replaceAll("\\[", "").replaceAll("\\]", "");
		System.out.println("jbj ===> " + EventType);
		String Runnable = arry[1].replaceAll("\\[", "").replaceAll("\\]", "");
		System.out.println("dxz ===> " + Runnable);
		String Period = arry[3].replaceAll("\\[", "").replaceAll("\\]", "");
		System.out.println("dd ===> " + Period);
//		boolean gnf = DesktopSession.findElementByName("ComM_MainFunction_0").isDisplayed();
//		logger.pass("ComM_MainFunction is displayed");
//		System.out.println(gnf + " =-= - =- > ");
//		WebElement value = DesktopSession.findElementByName("ComM_MainFunction_0");
//		// act.moveToElement(value).perform();
//		value.click();
//		List<WebElement> lst = DesktopSession.findElementsByXPath("//*[@LocalizedControlType = 'header item']");
//		System.out.println(lst.size());
//		for (int i = 0; i <= lst.size() - 1; i++) {
//			System.out.println(" =-= - - > " + lst.get(i).getText());
//		}
//		// Table.ItemColumnHeaderItems:
//		String eventname = value.getAttribute("Table.ItemColumnHeaderItems");
//		System.out.println(eventname + "  = = == = = = >  ");
//		System.out.println(value.getAttribute("Table.ItemColumnHeaderItems:"));

		boolean flag = DesktopSession.findElementByName(EventName).isDisplayed();
		logger.pass("EventName is displayed");
		boolean flag1 = DesktopSession.findElementByName(Runnable).isDisplayed();
		logger.pass("Runnable is displayed");
		boolean flag2 = DesktopSession.findElementByName(EventType).isDisplayed();
		logger.pass("EventType is displayed");
		boolean flag3 = DesktopSession.findElementByName(Period).isDisplayed();
		logger.pass("Period is displayed");
		System.out.println(flag + " ==> " + flag1 + "  --->  " + flag2 + " ==> " + flag3);
		if (flag || flag1 || flag2 || flag3 == true) {
			System.out.println("All is well");
			Assert.assertTrue(true);
		} else {
			System.out.println("All is not well");
			Assert.assertFalse(false);
		}

	}

	@SuppressWarnings("unchecked")
	public void ECUCompareReport(String Project) throws Exception {
		DesktopSession = Root();
		Robot rb = new Robot();
		Actions act = new Actions(DesktopSession);

		WebElement proj = DesktopSession.findElementByName(Project);
		proj.click();
		logger.pass("Clicked Project");
		ExpandProject(2);
		logger.pass(" Project expanded");
		Thread.sleep(1000);
		String defaultarxml = Pageobj.default_arxml;
		DesktopSession.findElementByName(defaultarxml).click();
		logger.pass("Clicked defaultarxml");
		act.contextClick().perform();
		logger.pass("Right Clicked on defaultarxml");
		Thread.sleep(500);
		DesktopSession.findElementByName(Pageobj.CompareECUC).click();
		logger.pass(" Clicked on CompareECUC");
		DesktopSession.findElementByName(Pageobj.LDFBrowse).click();
		logger.pass(" Clicked on Browse");
		String Projectlocation = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator
				+ "AR_1014" + File.separator + "Project_Redmine";
		DesktopSession.findElementByName("All locations").click();
		logger.pass(" Clicked on All Location");
		Thread.sleep(1000);
		WebElement filepath = DesktopSession.findElementByName("Address");
		String select = Keys.chord(Keys.CONTROL, "a");
		act.sendKeys(filepath, select);
		logger.pass(" Cntrl All");
		act.perform();
		act.sendKeys(Keys.BACK_SPACE).perform();
		logger.pass("delete input field data");
		act.sendKeys(Projectlocation).perform();
		logger.pass(" entered the project location");
		Thread.sleep(500);
		String arrow = "Go to " + '"' + Projectlocation + '"';
		DesktopSession.findElementByName(arrow).click();
		logger.pass(" Clicked on Go (->) button");
		List<WebElement> file = DesktopSession.findElementsByName("Name");
		System.out.println(file.size());
		for (int k = 1; k <= file.size() - 1; k++) {

			String values = file.get(k).getAttribute("Value.Value");
			if (values.equals("default")) {
				file.get(k).click();
				logger.pass(" Clicked on to be compared file");
				System.out.println("dhtg");
				break;
			} else {
				System.out.println("increase K");
			}
		}
		Thread.sleep(1000);
		rb.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		rb.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		logger.pass("Pressed entered");
		List<WebElement> lst = DesktopSession.findElementsByClassName("Edit");
		System.out.println("lst size " + lst.size());
		String reportpath = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator
				+ "ECUCReport";
		lst.get(3).sendKeys(select);
		logger.pass(" Cntrl All");
		lst.get(3).sendKeys(Keys.BACK_SPACE);
		logger.pass("delete input field data");
		lst.get(3).sendKeys(reportpath);
		logger.pass(" entered the report location");
		Thread.sleep(1000);
		rb.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		rb.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		logger.pass(" Pressed enter");
		rb.keyPress(KeyEvent.VK_ALT);
		rb.keyPress(KeyEvent.VK_F4);
		Thread.sleep(1000);
		rb.keyRelease(KeyEvent.VK_ALT);
		rb.keyRelease(KeyEvent.VK_F4);
	}

	public void readHTMLReport() throws Exception {
		DesktopSession = Root();
		String reportpath = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator
				+ "ECUCReport" + File.separator + "EcuExtractCompareReport.html";

		String chromePath = System.getProperty("user.dir") + File.separator + "chomedriver";
		System.setProperty("webdriver.chrome.driver", chromePath + File.separator + "chromedriver.exe");
		logger.pass("Chrome configuration");
		WebDriver driver = new ChromeDriver();
		driver.get(reportpath);
		logger.pass("Navigate to repot html file");
		driver.manage().window().maximize();
		logger.pass("maximize the browser");
		boolean addition = driver.findElement(By.xpath("//a[contains(text(),'Additions')]")).isDisplayed();
		boolean Deletions = driver.findElement(By.xpath("//a[contains(text(),'Deletions')]")).isDisplayed();
		boolean Changes = driver.findElement(By.xpath("//a[contains(text(),'Changes')]")).isDisplayed();
		System.out.println(addition + "  ==-> " + Deletions + "  ==-> " + Changes + "  ==-> ");
		if (Deletions || addition || Changes == true) {

			Assert.assertTrue(true);
		} else {
			Assert.assertFalse(false);
		}

		driver.close();
		logger.pass("close the browser");

	}

	@SuppressWarnings("unchecked")
	public void IsignalECUCCompare(String Project) throws Exception {

		DesktopSession = Root();
		Robot rb = new Robot();
		Actions act = new Actions(DesktopSession);

		WebElement proj = DesktopSession.findElementByName(Project);
		proj.click();
		logger.pass("Clicked Project");
		ExpandProject(2);
		logger.pass("expaned the Project");
		Thread.sleep(1000);
		String defaultarxml = Pageobj.default_arxml;
		DesktopSession.findElementByName(defaultarxml).click();
		logger.pass("Clicked default arxml");
		act.contextClick().perform();
		logger.pass("Right Clicked on default arxml");
		Thread.sleep(500);
		DesktopSession.findElementByName(Pageobj.CompareECUC).click();
		logger.pass(" Clicked on CompareECUC");
		DesktopSession.findElementByName(Pageobj.LDFBrowse).click();
		logger.pass(" Clicked on Browse");
		String Projectlocation = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator
				+ "Isignal_arxml";
		DesktopSession.findElementByName("All locations").click();
		logger.pass(" Clicked on All location");
		Thread.sleep(1000);
		WebElement filepath = DesktopSession.findElementByName("Address");
		String select = Keys.chord(Keys.CONTROL, "a");
		act.sendKeys(filepath, select);
		act.perform();
		logger.pass(" Cntrl All");
		act.sendKeys(Keys.BACK_SPACE).perform();
		logger.pass("Backspace");
		act.sendKeys(Projectlocation).perform();
		logger.pass(" entered project location");
		// DesktopSession.findElementById("1001").click();
		Thread.sleep(500);
		String arrow = "Go to " + '"' + Projectlocation + '"';
		DesktopSession.findElementByName(arrow).click();
		List<WebElement> file = DesktopSession.findElementsByName("Name");
		System.out.println(file.size());
		for (int k = 1; k <= file.size() - 1; k++) {

			String values = file.get(k).getAttribute("Value.Value");
			if (values.equals("Isignal")) {
				file.get(k).click();
				logger.pass(" Clicked file");
				System.out.println("dhtg");
				break;
			} else {
				System.out.println("increase K");
			}
		}
		Thread.sleep(1000);
		rb.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		rb.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		logger.pass("press entered");
		List<WebElement> lst = DesktopSession.findElementsByClassName("Edit");
		System.out.println("lst size " + lst.size());
		String reportpath = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator
				+ "ECUCReport" + File.separator + "isignalreport";
		lst.get(3).sendKeys(select);
		logger.pass("Cntrl All");
		lst.get(3).sendKeys(Keys.BACK_SPACE);
		logger.pass("press backspace");
		lst.get(3).sendKeys(reportpath);
		Thread.sleep(1000);
		logger.pass("entered reprt path");
		rb.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		logger.pass("press entered");
		rb.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		logger.pass("release entered");
		rb.keyPress(KeyEvent.VK_ALT);
		rb.keyPress(KeyEvent.VK_F4);
		Thread.sleep(1000);
		rb.keyRelease(KeyEvent.VK_ALT);
		rb.keyRelease(KeyEvent.VK_F4);
	}

	public void readIsignalHTMLReport() throws Exception {
		DesktopSession = Root();
		String reportpath = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator
				+ "ECUCReport" + File.separator + "isignalreport" + File.separator + "EcuExtractCompareReport.html";

		String chromePath = System.getProperty("user.dir") + File.separator + "chomedriver";
		System.setProperty("webdriver.chrome.driver", chromePath + File.separator + "chromedriver.exe");
		logger.pass("Chrome setup");
		WebDriver driver = new ChromeDriver();
		driver.get(reportpath);
		driver.manage().window().maximize();
		logger.pass("Browser maximized");
		boolean addition = driver.findElement(By.xpath("//a[contains(text(),'Additions')]")).isDisplayed();
		driver.findElement(By.xpath("//a[contains(text(),'Additions')]")).click();
		logger.pass("clicked addition");
		boolean ISignal = driver.findElement(By.xpath("//a[contains(text(),'ISignal')]")).isDisplayed();
		driver.findElement(By.xpath("//a[contains(text(),'ISignal')]")).click();
		logger.pass("clicked ISignal");
		boolean ARRoot_ISignal = driver.findElement(By.xpath("//a[contains(text(),'/ARRoot/ISignal')]")).isDisplayed();
		System.out.println(addition + "  ==-> " + ISignal + "  ==-> ");
		if (ISignal || addition || ARRoot_ISignal == true) {

			Assert.assertTrue(true);
		} else {
			Assert.assertFalse(false);
		}

		driver.close();
		logger.pass("Close the browser");
	}

	@SuppressWarnings("unchecked")
	public void CompareECUC(String Project, String filename, String Comparefile, String reportpath) throws Exception {

		DesktopSession = Root();
		Robot rb = new Robot();
		Actions act = new Actions(DesktopSession);

		WebElement proj = DesktopSession.findElementByName(Project);
		proj.click();
		logger.pass("clicked Project");
		ExpandProject(2);
		logger.pass("expand Project");
		Thread.sleep(1000);
		String defaultarxml = filename;
		DesktopSession.findElementByName(defaultarxml).click();
		logger.pass("clicked defaultarxml");
		act.contextClick().perform();
		logger.pass("Right clicked on defaultarxml");
		Thread.sleep(500);
		DesktopSession.findElementByName(Pageobj.CompareECUC).click();
		logger.pass("clicked CompareECUC");
		DesktopSession.findElementByName(Pageobj.LDFBrowse).click();
		logger.pass("clicked LDFBrowse");
		Thread.sleep(1000);
		DesktopSession.findElementByName("File name:").click();
		String Projectlocation = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator
				+ "CompareECUCExtract" + File.separator + "Compare_ECUC_Extract";
		DesktopSession.findElementByName("All locations").click();
		logger.pass("clicked All location");
		Thread.sleep(1000);
		WebElement filepath = DesktopSession.findElementByName("Address");
		String select = Keys.chord(Keys.CONTROL, "a");
		act.sendKeys(filepath, select);
		logger.pass("cntrl All");
		act.perform();
		act.sendKeys(Keys.BACK_SPACE).perform();
		logger.pass("Pressed Backspace");
		act.sendKeys(Projectlocation).perform();
		logger.pass("entered ProjectLocation");
		Thread.sleep(500);
		String arrow = "Go to " + '"' + Projectlocation + '"';
		DesktopSession.findElementByName(arrow).click();
		logger.pass("clicked go button ");
		List<WebElement> file = DesktopSession.findElementsByName("Name");
		System.out.println(file.size());
		System.out.println(" --   >  " + Comparefile);
		for (int k = 1; k <= file.size() - 1; k++) {

			String values = file.get(k).getAttribute("Value.Value");
			if (values.equals(Comparefile)) {
				file.get(k).click();
				logger.pass("clicked comparefile");
				System.out.println("dhtg");
				break;
			} else {
				System.out.println("increase K");
			}
		}
		Thread.sleep(1000);
		rb.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		logger.pass("clicked entered");
		rb.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		logger.pass("released enter");
		List<WebElement> lst = DesktopSession.findElementsByClassName("Edit");
		System.out.println("lst size " + lst.size());
		lst.get(3).sendKeys(select);
		logger.pass("Cntrl All");
		lst.get(3).sendKeys(Keys.BACK_SPACE);
		logger.pass("clicked backspace");
		lst.get(3).sendKeys(reportpath);
		logger.pass("entered report path");
		Thread.sleep(1000);
		rb.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		logger.pass("clicked entered");
		rb.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		rb.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		logger.pass("clicked entered");
		rb.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		logger.pass("released enter");
		DesktopSession = Root();
		rb.keyPress(KeyEvent.VK_ALT);
		rb.keyPress(KeyEvent.VK_F4);
		Thread.sleep(1000);
		rb.keyRelease(KeyEvent.VK_ALT);
		rb.keyRelease(KeyEvent.VK_F4);
		Thread.sleep(2000);

	}

	public void CompareTwoECUC_Report(String Path1, String Path2) throws Exception {
		DesktopSession = Root();
		Robot rb = new Robot();
		String reportpath1 = Path1 + File.separator + "EcuExtractCompareReport.html";
		String reportpath2 = Path1 + File.separator + "EcuExtractCompareReport.html";
		String chromePath = System.getProperty("user.dir") + File.separator + "chomedriver";
		System.setProperty("webdriver.chrome.driver", chromePath + File.separator + "chromedriver.exe");
		logger.pass("Chrome setup");
		WebDriver driver = new ChromeDriver();
		driver.get(reportpath1);
		driver.manage().window().maximize();
		logger.pass("Browser maximized");
		boolean addition = driver.findElement(By.xpath("//a[contains(text(),'Additions')]")).isDisplayed();
		boolean Deletions = driver.findElement(By.xpath("//a[contains(text(),'Deletions')]")).isDisplayed();
		boolean Changes = driver.findElement(By.xpath("//a[contains(text(),'Changes')]")).isDisplayed();
		System.out.println(addition + "  ==-> " + Deletions + "  ==-> " + Changes + "  ==-> ");
		driver.close();
		logger.pass("Close the browser");
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(2000);
		driver = new ChromeDriver();
		driver.get(reportpath2);
		driver.manage().window().maximize();
		logger.pass("Browser maximized");
		boolean additionN = driver.findElement(By.xpath("//a[contains(text(),'Additions')]")).isDisplayed();
		boolean DeletionsN = driver.findElement(By.xpath("//a[contains(text(),'Deletions')]")).isDisplayed();
		boolean ChangesN = driver.findElement(By.xpath("//a[contains(text(),'Changes')]")).isDisplayed();
		System.out.println(additionN + "  ==-> " + DeletionsN + "  ==-> " + ChangesN + "  ==-> ");

		if (addition == additionN && Deletions == DeletionsN && Changes == ChangesN) {
			Assert.assertTrue(true);

		} else {
			Assert.assertFalse(false);
		}
		driver.close();
		logger.pass("Close the browser");
		Thread.sleep(1000);
		rb.keyPress(KeyEvent.VK_ALT);
		rb.keyPress(KeyEvent.VK_F4);
		Thread.sleep(1000);
		rb.keyRelease(KeyEvent.VK_ALT);
		rb.keyRelease(KeyEvent.VK_F4);
	}

	@SuppressWarnings("unchecked")
	public void VerifyDeleteonHTMLFile(String Project) throws Exception {
		DesktopSession = Root();
		Robot rb = new Robot();
		Actions act = new Actions(DesktopSession);
		DesktopSession.findElementByName(Project).click();
		logger.pass("Clicked on the Project");
		ExpandProject(3);
		logger.pass("Project expanded");
		DesktopSession.findElementByName(Pageobj.default_arxml).click();
		logger.pass("Clicked on the default_arxml");
		ExpandProject(4);
		logger.pass("Project expanded");
		DesktopSession.findElementByName(Pageobj.ARPackage).click();
		logger.pass("Clicked on ArPackage");
		Thread.sleep(500);
		act.contextClick().perform();
		Thread.sleep(1000);
		logger.pass("Clicked on ArPackage");
		List<WebElement> lstnx = DesktopSession.findElementsByXPath("//*[@LocalizedControlType='menu item']");
		System.out.println(lstnx.size() + " -=-=-=-> ");
		for (int i = 0; i <= lstnx.size() - 1; i++) {
			System.out.println(lstnx.get(i).getAttribute("Name") + "  --->  " + i);
		}
		DesktopSession.findElementByName(Pageobj.ModuleConfiguration).click();
		logger.pass("Clicked on ModuleConfiguration");
		DesktopSession.findElementByName(Pageobj.AddElement).click();
		logger.pass("Clicked on adding element");
//		DesktopSession.findElementByName(Pageobj.RteElement).click();
//		logger.pass("Clicked on RteElement");
		Thread.sleep(1000);
		List<WebElement> lstn = DesktopSession.findElementsByXPath("//*[@LocalizedControlType='menu item']");
		System.out.println(lstn.size() + " -=-=-=-> ");
		for (int i = 0; i <= lstn.size() - 1; i++) {
			System.out.println(lstn.get(i).getAttribute("Name") + "  --->  " + i);
		}

		// DesktopSession.findElementByName(Pageobj.Ote).click();
		String value = lstn.get(21).getAttribute("Name");
		System.out.println(value + " =-=-=->  ");
		String newvalue = value + "_0 [" + value + "]";
		System.out.println(newvalue);
		logger.pass("Clicked on RteElement");
		lstn.get(21).click();
		Thread.sleep(2000);
		DesktopSession.findElementByName("Save (Ctrl+S)").click();
		logger.pass("Clicked on Save");
		DesktopSession.findElementByName(Pageobj.default_arxml).click();
		logger.pass("Clicked on the default_arxml");
		act.contextClick().perform();
		Thread.sleep(500);
		logger.pass("Right Click on the default_arxml");
		DesktopSession.findElementByName("Copy").click();
		logger.pass("Clicked on the copy");
		DesktopSession.findElementByName(Project).click();
		logger.pass("Clicked on the Project");
		act.contextClick().perform();
		Thread.sleep(500);
		logger.pass("Right Click on the Project");
		DesktopSession.findElementByName("Paste").click();
		logger.pass("Click on the Paste");
		List<WebElement> edit = DesktopSession.findElementsByClassName("Edit");
		System.out.println(edit.size() + " ====> ");
		String copiedFilename = edit.get(1).getAttribute("Value.Value");
		System.out.println(copiedFilename + "    =-=-=-y677 ==-> ");
		DesktopSession.findElementByName("OK").click();
		logger.pass("Clicked OK");
		Thread.sleep(3000);
		DesktopSession.findElementByName(newvalue).click();
		logger.pass("Clicked on Rte");
		act.contextClick().perform();
		Thread.sleep(500);
		logger.pass("Right Clicked on rte");
		DesktopSession.findElementByName("Delete").click();
		logger.pass("Clicked on Delete");
		Thread.sleep(1000);
		DesktopSession.findElementByName("OK").click();
		logger.pass("Clicked OK");
		Thread.sleep(2000);
		DesktopSession.findElementByName("Save (Ctrl+S)").click();
		logger.pass("Clicked on Save");
		Thread.sleep(2000);
		DesktopSession.findElementByName(copiedFilename).click();
		logger.pass("clicked defaultarxml");
		act.contextClick().perform();
		logger.pass("Right clicked on defaultarxml");
		Thread.sleep(500);
		DesktopSession.findElementByName(Pageobj.CompareECUC).click();
		logger.pass("clicked CompareECUC");
		DesktopSession.findElementByName(Pageobj.LDFBrowse).click();
		logger.pass("clicked LDFBrowse");
		Thread.sleep(1000);
		DesktopSession.findElementByName("File name:").click();
		String Projectlocation = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator
				+ "811" + File.separator + "delete";
		DesktopSession.findElementByName("All locations").click();
		logger.pass("clicked All location");
		Thread.sleep(1000);
		WebElement filepath = DesktopSession.findElementByName("Address");
		String select = Keys.chord(Keys.CONTROL, "a");
		act.sendKeys(filepath, select);
		logger.pass("cntrl All");
		act.perform();
		act.sendKeys(Keys.BACK_SPACE).perform();
		logger.pass("Pressed Backspace");
		act.sendKeys(Projectlocation).perform();
		logger.pass("entered ProjectLocation");
		Thread.sleep(500);
		String arrow = "Go to " + '"' + Projectlocation + '"';
		DesktopSession.findElementByName(arrow).click();
		logger.pass("clicked go button ");
		List<WebElement> file = DesktopSession.findElementsByName("Name");
		System.out.println(file.size());
		for (int k = 1; k <= file.size() - 1; k++) {

			String values = file.get(k).getAttribute("Value.Value");
			if (values.equals("default")) {
				file.get(k).click();
				logger.pass("clicked comparefile");
				System.out.println("dhtg");
				break;
			} else {
				System.out.println("increase K");
			}
		}
		Thread.sleep(1000);
		rb.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		logger.pass("clicked entered");
		rb.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		logger.pass("released enter");
		String reportpath = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator
				+ "ECUCReport" + File.separator + "DeleteECUCReport";
		List<WebElement> lst = DesktopSession.findElementsByClassName("Edit");
		System.out.println("lst size " + lst.size());
		lst.get(3).sendKeys(select);
		logger.pass("Cntrl All");
		lst.get(3).sendKeys(Keys.BACK_SPACE);
		logger.pass("clicked backspace");
		lst.get(3).sendKeys(reportpath);
		logger.pass("entered report path");
		Thread.sleep(1000);
		rb.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		logger.pass("clicked entered");
		rb.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		rb.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		logger.pass("clicked entered");
		rb.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(4000);
		logger.pass("released enter");
		DesktopSession = Root();
		rb.keyPress(KeyEvent.VK_ALT);
		rb.keyPress(KeyEvent.VK_F4);
		Thread.sleep(1000);
		rb.keyRelease(KeyEvent.VK_ALT);
		rb.keyRelease(KeyEvent.VK_F4);
		Thread.sleep(2000);
		logger.pass("closed the window");
		DesktopSession.findElementByName(copiedFilename).click();
		logger.pass("clicked copiedFilename");
		WebElement wbs = DesktopSession.findElementByName(copiedFilename);
		logger.pass("Right clicked copiedFilename");
		rb.keyPress(KeyEvent.VK_DELETE);
		logger.pass("clicked Delete");
		Thread.sleep(500);
		DesktopSession.findElementByName("OK").click();
		logger.pass("clicked OK");
		Thread.sleep(3000);
		DesktopSession.findElementByName("Save (Ctrl+S)").click();
		logger.pass("clicked Save");
		rb.keyPress(KeyEvent.VK_ALT);
		rb.keyPress(KeyEvent.VK_F4);
		Thread.sleep(1000);
		rb.keyRelease(KeyEvent.VK_ALT);
		logger.pass("clicked Close C4K");
	}

	public void VerifyDeletedOnEcuc(String Path) throws Exception {

		DesktopSession = Root();
		Robot rb = new Robot();
		String reportpath1 = Path + File.separator + "EcuExtractCompareReport.html";
		String chromePath = System.getProperty("user.dir") + File.separator + "chomedriver";
		System.setProperty("webdriver.chrome.driver", chromePath + File.separator + "chromedriver.exe");
		logger.pass("Chrome setup");
		WebDriver driver = new ChromeDriver();
		driver.get(reportpath1);
		driver.manage().window().maximize();
		boolean Deletions = driver.findElement(By.xpath("//a[contains(text(),'Deletions')]")).isDisplayed();
		System.out.println(Deletions);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[contains(text(),'Deletions')]")).click();
		boolean Os = driver.findElement(By.xpath("//a[contains(text(),'Os')]")).isDisplayed();
		System.out.println(Os);
		driver.findElement(By.xpath("//a[contains(text(),'Os')]")).click();
		boolean Ar_Os = driver.findElement(By.xpath("//a[contains(text(),'/ARRoot/Os_0')]")).isDisplayed();
		System.out.println(Ar_Os);
		if (Deletions == true && Os == true && Ar_Os == true) {
			Assert.assertTrue(true);

		} else {
			Assert.assertFalse(false);
		}
		logger.pass("Browser closed");
	}

	@SuppressWarnings("unchecked")
	public void VerifyCheatSheetSkip() throws Exception {
		DesktopSession = Root();
		Actions act = new Actions(DesktopSession);
		DesktopSession.findElementByName("Help").click();
		logger.pass("Clicked Help");
		// Thread.sleep(500);
		DesktopSession.findElementByName("Cheat Sheets...").click();
		// Thread.sleep(500);
		logger.pass("Clicked Chest Sheet");
		DesktopSession.findElementByName("Compose4Ksar").click();
		logger.pass("Clicked Compose4ksr");
		ExpandProject(1);
		logger.pass("Exanded");
		DesktopSession.findElementByName("Getting Started With C4K").click();
		logger.pass("Clicked getting started");
		DesktopSession.findElementByName("OK").click();
		logger.pass("Clicked OK");
		// Thread.sleep(1000);
		DesktopSession.findElementByName("Compose for K-SAR").click();
		logger.pass("Clicked Compose K-sar");
		ExpandProject(1);
		DesktopSession.findElementByName("Event To Task mapping").click();
		logger.pass("Clicked Event maping");
		act.contextClick().perform();
		// Thread.sleep(500);
		logger.pass("Right Clicked event mapping");
		DesktopSession.findElementByName("Skip").click();
		logger.pass("Clicked Skip");
		boolean flag = DesktopSession.findElementByName(" Go to 'Validation'").isDisplayed();
		String value = DesktopSession.findElementByName(" Go to 'Validation'").getText();
		System.out.println(value);
		String arr[] = value.split(" ");
		String str = arr[3];
		System.out.println(str);
		str = str.replaceAll("\\'", "").replaceAll("\\'", "");
		System.out.println("=12  ==  > " + str);
		List<WebElement> lst = DesktopSession.findElementsByXPath("//*[@LocalizedControlType='tree item']");
		System.out.println(" == == > " + lst.size());
		for (int i = 0; i <= lst.size() - 1; i++) {

			String items = lst.get(i).getText();
			System.out.println(items + "  -=-=-=-=-=- >" + i);
		}
		int k = 5;
		String eventmapping = lst.get(k).getText();
		String Validation = lst.get(k + 1).getText();
		System.out.println(eventmapping + "   = =- =-  >  " + Validation);
		if (str.equals(Validation)) {
			Assert.assertTrue(true);
			logger.pass("Verified test case");

		} else {
			Assert.assertFalse(false);
		}

		// DesktopSession.findElementByName("Close").click();
		logger.pass("Closed  C4K");

	}

	public void Upload_ECU_File(String ProjectName) throws Exception {

		DesktopSession = Root();
		Robot rb = new Robot();
		Actions rightclick = new Actions(DesktopSession);
		Thread.sleep(5000);
		boolean AR = DesktopSession.findElementByName(Pageobj.ProjectFolderECU).isDisplayed();
		Assert.assertEquals(AR, true);
		WebElement abc = DesktopSession.findElementByName(Pageobj.ProjectFolderECU);
		System.out.println(AR);
		if (AR == true) {
			Thread.sleep(1000);
			abc.click();
			rightclick.contextClick(abc).perform();
		} else {
			rightclick.contextClick(abc).perform();
		}
		logger.pass("Clicked On AR431 project folder");
		rightclick.contextClick().build().perform();
		logger.pass("Right Clicked On ProjectFolder");
		DesktopSession.findElementByName(Pageobj.Import).click();
		logger.pass("Clicked On Import");
		DesktopSession.findElementByName(Pageobj.General_Folder).click();
		logger.pass("Clicked on the General_Folder");
		rb.keyPress(KeyEvent.VK_RIGHT);
		logger.pass("Expanded the General_Folder");
		DesktopSession.findElementByName(Pageobj.Import_FileSystem).click();
		logger.pass("Clicked On Filesystem");
		DesktopSession.findElementByName(Pageobj.Next_Button).click();
		logger.pass("Clicked On NextButton");
		String filePath = getFilePath("ImportProject\\AR1028");
		WebElement Inputfilepath = DesktopSession.findElementByName(Pageobj.File_Directory);
		rightclick.click(Inputfilepath).perform();
		rightclick.sendKeys(Inputfilepath, filePath).perform();
		logger.pass("Passed The file path");
		rightclick.sendKeys(Keys.ENTER).perform();
		DesktopSession.findElementByName(Pageobj.ProjectFolderECU).click();
		rb.keyPress(KeyEvent.VK_SPACE);
		logger.pass("Selected the File to Upload");
		DesktopSession.findElementByName(Pageobj.Finish_Button).click();
		logger.pass("Clicked On Finish Button");
		Thread.sleep(2000);
		System.out.println(ProjectName);
		// DesktopSession.findElementByName(ProjectName).click();
		ExpandProject(2);
		System.out.println(AR);
		rightclick.doubleClick(abc).perform();
		Thread.sleep(500);
		logger.pass("Double Clicked On Project_Folder2");
		boolean ECUFile = true;
		try {
			ECUFile = DesktopSession.findElementByName(Pageobj.ECUFileName).isDisplayed();
		} catch (Exception e) {
			System.out.println(e);
		}
		Assert.assertEquals(ECUFile, true);
		logger.pass("Verify the ECUFile Uploaded");
		DesktopSession.findElementByName(Pageobj.ECUFileName).click();
		logger.pass("Clicked on ECU file");
		rb.keyPress(KeyEvent.VK_RIGHT);
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyPress(KeyEvent.VK_RIGHT);
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyPress(KeyEvent.VK_RIGHT);
		rb.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(500);
		rb.keyPress(KeyEvent.VK_RIGHT);
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyPress(KeyEvent.VK_DOWN);
		boolean ARpackageFlag = DesktopSession.findElementByName(Pageobj.ECUC_ARpackage).isDisplayed();
		Assert.assertEquals(ARpackageFlag, true);
		System.out.println("Ar package is displayed: ---> " + ARpackageFlag);
		WebElement Arpackage = DesktopSession.findElementByName(Pageobj.ECUC_ARpackage);

		Arpackage.click();
		logger.pass("Clicked on AR package");
		rightclick.contextClick(Arpackage).perform();
		logger.pass("Right Clicked on AR package");

		boolean showInSystemExplorer_option;
		try {
			showInSystemExplorer_option = DesktopSession.findElementByName(Pageobj.ShowInSystemExplorerOption)
					.isDisplayed();
			System.out.println(showInSystemExplorer_option);
		} catch (Exception e) {
			showInSystemExplorer_option = false;
			System.out.println(showInSystemExplorer_option);
		}

		Assert.assertEquals(false, showInSystemExplorer_option);
		logger.pass("Verified in ECU AR package ShowInSystemExplorer is not displaying in Context Menu ");
		DesktopSession.findElementByClassName(Pageobj.DefaultSpace).click();

		boolean ecuModule = DesktopSession.findElementByName(Pageobj.ECUC_ARpackage).isDisplayed();
		Assert.assertEquals(ecuModule, true);
		System.out.println("Ar package is displayed: ---> " + ARpackageFlag);

		boolean ecuModuless = DesktopSession.findElementByName(Pageobj.EcuModulesFolder).isDisplayed();
		Assert.assertEquals(ecuModuless, true);
		WebElement ecuModules = DesktopSession.findElementByName(Pageobj.EcuModulesFolder);

		ecuModules.click();
		logger.pass("Clicked on ECU Modules");
		rightclick.contextClick(ecuModules).perform();
		logger.pass("Right Clicked on ECU Modules");

		boolean showInSystemExplorer_options;
		try {
			showInSystemExplorer_options = DesktopSession.findElementByName(Pageobj.ShowInSystemExplorerOption)
					.isDisplayed();
			System.out.println(showInSystemExplorer_options);
		} catch (Exception e) {
			showInSystemExplorer_options = false;
			System.out.println(showInSystemExplorer_options);
		}

		Assert.assertEquals(false, showInSystemExplorer_options);
		logger.pass("Verified in ECU Module ShowInSystemExplorer is not displaying in Context Menu ");
		DesktopSession.findElementByClassName(Pageobj.DefaultSpace).click();
		rightclick.click(ecuModules).perform();
		rb.keyPress(KeyEvent.VK_RIGHT);
		rb.keyPress(KeyEvent.VK_DOWN);

		boolean ecuModulesss = DesktopSession.findElementByName(Pageobj.EcuContainer).isDisplayed();
		Assert.assertEquals(ecuModulesss, true);
		WebElement ecucontainers = DesktopSession.findElementByName(Pageobj.EcuContainer);

		ecucontainers.click();
		logger.pass("Clicked on ECU Containers");
		rightclick.contextClick(ecucontainers).perform();
		logger.pass("Right Clicked on ECU Containers");

		boolean showInSystemExplorer_option3;
		try {
			showInSystemExplorer_option3 = DesktopSession.findElementByName(Pageobj.ShowInSystemExplorerOption)
					.isDisplayed();
			System.out.println(showInSystemExplorer_option3);
		} catch (Exception e) {
			showInSystemExplorer_option3 = false;
			System.out.println(showInSystemExplorer_option3);
		}

		Assert.assertEquals(false, showInSystemExplorer_option3);
		logger.pass("Verified in ECU container ShowInSystemExplorer is not displaying in Context Menu ");
		DesktopSession.findElementByClassName(Pageobj.DefaultSpace).click();
		// WebElement close1 = DesktopSession.findElementByName(Pageobj.CloseButton);
		// rightclick.doubleClick(close1).perform();
		logger.pass("Closed The Application Successfully");

	}

	public void cheatSheetOpenC4K(String CheatSheet) throws Exception {

		DesktopSession = Root();
		Robot rb = new Robot();
		Actions rightclick = new Actions(DesktopSession);
		List<WebElement> all = DesktopSession.findElementsByName(Pageobj.Help);
		System.out.println(all.size());
		// all.get(0).click();
		all.get(1).click();
		rightclick.moveToElement(all.get(0)).perform();
		DesktopSession.findElementByName(Pageobj.Help).click();
		DesktopSession.findElementByName(Pageobj.CheatsheetOption).click();
		boolean Compose4KsarCheatsheetFolder = DesktopSession.findElementByName(Pageobj.Compose4KsarCheatsheetFolder)
				.isDisplayed();
		Assert.assertEquals(Compose4KsarCheatsheetFolder, true);
		DesktopSession.findElementByName(Pageobj.Compose4KsarCheatsheetFolder).click();
		rb.keyPress(KeyEvent.VK_RIGHT);
		rb.keyPress(KeyEvent.VK_DOWN);
		DesktopSession.findElementByName(Pageobj.Launch).click();
		boolean Compose4KsarCheatsheetLabel = DesktopSession.findElementByName(Pageobj.Compose4KsarCheatsheetLabel)
				.isDisplayed();
		Assert.assertEquals(Compose4KsarCheatsheetLabel, true);

		DesktopSession.findElementByName(Pageobj.CheatSheetsTab).click();
		Thread.sleep(500);
		rightclick.contextClick().build().perform();
		Thread.sleep(500);
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyPress(KeyEvent.VK_ENTER);

		WebElement wb = DesktopSession.findElementByName(Pageobj.QuickAccessTextbox);
		rightclick.click(wb).perform();
		rightclick.sendKeys(wb, CheatSheet);
		rightclick.perform();
		Thread.sleep(1000);
		DesktopSession.findElementByName(Pageobj.QuickAccessMenus).click();
		DesktopSession.findElementByName(Pageobj.Launch).click();
		boolean Compose4KsarCheatsheetLabel1 = DesktopSession.findElementByName(Pageobj.Compose4KsarCheatsheetLabel)
				.isDisplayed();
		Assert.assertEquals(Compose4KsarCheatsheetLabel1, true);
		WebElement close1 = DesktopSession.findElementByName(Pageobj.CloseButton);
		rightclick.doubleClick(close1).perform();
		logger.pass("Closed The Application Successfully");

	}

	public void validateWorkspacePath() throws Exception {

		DesktopSession = Root();
		Actions rightclick = new Actions(DesktopSession);
		WebElement abc = DesktopSession.findElementByAccessibilityId(Pageobj.WorkspaceLabel);
		String WorkspacePath = abc.getAttribute("Value.Value");
		System.out.println(WorkspacePath);
		logger.pass("Geting the attribute value as workspace path");
		String finalWorkspacePath = WorkspacePath.substring(31);
		System.out.println(finalWorkspacePath + "=============");
		String Titlepath = getFilePathHomeDir("c4k_workspace");
		System.out.println(Titlepath + "------------------");
		String TitlepathFinal = finalWorkspacePath.replaceAll("\\\\", "/");
		System.out.println(finalWorkspacePath);
		System.out.println(Titlepath);
		Assert.assertEquals(finalWorkspacePath, TitlepathFinal);
		logger.pass("Verified the workspace path");
		logger.pass("Expected and actual Workspacepath" + finalWorkspacePath + " " + TitlepathFinal);
		WebElement close1 = DesktopSession.findElementByName(Pageobj.CloseButton);
		rightclick.doubleClick(close1).perform();
		logger.pass("Closed The Application Successfully");
	}

	@SuppressWarnings("unchecked")
	public void validateDefaultWorkspacePath(String path) throws Exception {

		DesktopSession = Root();

		List<WebElement> wb = DesktopSession.findElementsByClassName("Edit");
		System.out.println(wb.size());
		for (int i = 0; i <= wb.size() - 1; i++) {
			String values = wb.get(i).getAttribute("Value.Value");
			if (values.equals(path))
				;
			break;
		}
		String pathVerify1 = wb.get(2).getAttribute("Value.Value");
		System.out.println();
		Assert.assertEquals(path, pathVerify1);
		logger.pass("Verified the Default workspace path");
		logger.pass("Expected and actual Workspacepath" + path + "   " + pathVerify1);
		DesktopSession.findElementByName("Cancel").click();
		logger.pass("Second Application Instance has been launched and closed");

	}

	public void cheatSheetTask() throws Exception {

		cheatSheetCommon();
		DesktopSession = Root();
		Robot rb = new Robot();
		Actions rightclick = new Actions(DesktopSession);

		boolean ClickToBeginLabelFlag = DesktopSession.findElementByName(Pageobj.ClickToBeginLabel).isDisplayed();
		Assert.assertEquals(ClickToBeginLabelFlag, true);
		logger.pass("Verified ClickToBegin Label is Displayed");
		DesktopSession.findElementByName(Pageobj.ClickToBeginLabel).click();
		logger.pass("Clicked On ClickToBegin Label");
		Thread.sleep(1000);
		boolean ClickToPerformLabelFlag = DesktopSession.findElementByName(Pageobj.ClickToPerformLabel).isDisplayed();
		Assert.assertEquals(ClickToPerformLabelFlag, true);
		logger.pass("Verified ClickToPerform Label is Displayed");
		WebElement web = DesktopSession.findElementByName(Pageobj.ClickToSkipLabel);
		rightclick.click(web).perform();
		logger.pass("Clicked On ClickToSkip Label");
		Thread.sleep(1000);
		WebElement clickPerform = DesktopSession.findElementByName(Pageobj.ClickToPerformLabel);
		rightclick.click(clickPerform).perform();
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		boolean flagperform = DesktopSession.findElementByName(Pageobj.ProjectName).isDisplayed();
		logger.pass("Clicked On ClickToPerform Label");

		WebElement Project = DesktopSession.findElementByName(Pageobj.ProjectName);
		rightclick.click(Project).perform();
		logger.pass("Click on the Project");
		Thread.sleep(1000);
		String select = Keys.chord(Keys.CONTROL, "a");
		rightclick.sendKeys(Project, select);
		rightclick.perform();
		String ProjectName = "AR842";
		rightclick.sendKeys(Project, ProjectName);
		rightclick.perform();
		logger.pass("Entered the ProjectName");
		DesktopSession.findElementByName(Pageobj.Finish_Button).click();

		boolean Project_FolderLabelFlag = DesktopSession.findElementByName(Pageobj.Project_FolderLabel).isDisplayed();
		Assert.assertEquals(Project_FolderLabelFlag, true);
		logger.pass("Verified Project Folder is dispayed");
		// WebElement close1 = DesktopSession.findElementByName(Pageobj.CloseButton);
		// rightclick.doubleClick(close1).perform();

	}

	// This function will close the application.

	public void closeApplication() throws Exception {
		DesktopSession = Root();
		Actions rightclick = new Actions(DesktopSession);
		Robot rb = new Robot();

		try {
			WebElement close1 = DesktopSession.findElementByName(Pageobj.CloseButton);
			rb.keyPress(KeyEvent.VK_ESCAPE);
			rb.keyRelease(KeyEvent.VK_ESCAPE);
			rb.keyPress(KeyEvent.VK_ESCAPE);
			rb.keyRelease(KeyEvent.VK_ESCAPE);
			rightclick.doubleClick(close1).perform();
			logger.pass("Clicked On Closed Button");
			boolean NoButtonFlag = DesktopSession.findElementByName(Pageobj.NoButton).isDisplayed();
			boolean YesButtonFlag = DesktopSession.findElementByName(Pageobj.YesButton).isDisplayed();
			if (NoButtonFlag == true) {
				DesktopSession.findElementByName(Pageobj.NoButton).click();
			} else if (YesButtonFlag == true) {
				DesktopSession.findElementByName(Pageobj.NoButton).click();
			} else {
				rb.keyPress(KeyEvent.VK_ESCAPE);
				rb.keyRelease(KeyEvent.VK_ESCAPE);
				rb.keyPress(KeyEvent.VK_ESCAPE);
				rb.keyRelease(KeyEvent.VK_ESCAPE);
				rightclick.doubleClick(close1).perform();
			}
		} catch (Exception e) {
			// logger.fail("NO button is not enabled");
		}
	}

	public void cheatSheetCommon() throws Exception {

		DesktopSession = Root();
		Robot rb = new Robot();
		Actions rightclick = new Actions(DesktopSession);
		DesktopSession.findElementByName(Pageobj.Help).click();
		logger.pass("Clicked on Help Button");
		DesktopSession.findElementByName(Pageobj.CheatsheetOption).click();
		logger.pass("Clicked on Cheatsheet Option");
		boolean Compose4KsarCheatsheetFolder = DesktopSession.findElementByName(Pageobj.Compose4KsarCheatsheetFolder)
				.isDisplayed();
		Assert.assertEquals(Compose4KsarCheatsheetFolder, true);
		logger.pass("Verified Compose4KsarCheatsheetFolder is Displayed");
		DesktopSession.findElementByName(Pageobj.Compose4KsarCheatsheetFolder).click();
		logger.pass("Clicked on Compose4Ksar Cheatsheet Folder");
		rb.keyPress(KeyEvent.VK_RIGHT);
		DesktopSession.findElementByName(Pageobj.GettingStartedOption).click();
		DesktopSession.findElementByName(Pageobj.Launch).click();
		logger.pass("Clicked on OK Button");
		boolean Compose4KsarCheatsheetLabel = DesktopSession.findElementByName(Pageobj.Compose4KsarCheatsheetLabel)
				.isDisplayed();
		Assert.assertEquals(Compose4KsarCheatsheetLabel, true);
		logger.pass("Verified Compose4Ksar Cheatsheet Label is Displayed");
		DesktopSession.findElementByName(Pageobj.Compose4KsarCheatsheetLabel).click();
		logger.pass("Clicked on Compose4Ksar Cheatsheet Label");
		rb.keyPress(KeyEvent.VK_RIGHT);
		boolean AutosarProjectCreation = DesktopSession.findElementByName(Pageobj.AutosarProjectCreationLabel)
				.isDisplayed();
		Assert.assertEquals(AutosarProjectCreation, true);
		logger.pass("Verified Autosar ProjectCreation Label is Displayed");
		DesktopSession.findElementByName(Pageobj.AutosarProjectCreationLabel).click();
		logger.pass("Clicked On Autosar ProjectCreation Label");
		boolean StartWorkingFlag = DesktopSession.findElementByName(Pageobj.StartWorkingLabel).isDisplayed();
		Assert.assertEquals(StartWorkingFlag, true);
		logger.pass("Verified StartWorking Label is Displayed");
		DesktopSession.findElementByName(Pageobj.StartWorkingLabel).click();
		logger.pass("Clicked On StartWorking Label");
		boolean IntroductionLabelFlag = DesktopSession.findElementByName(Pageobj.IntroductionLabel).isDisplayed();
		Assert.assertEquals(IntroductionLabelFlag, true);
		logger.pass("Verified IntroductionLabel Label is Displayed");
		boolean OpenTheComposeLabelFlag = DesktopSession.findElementByName(Pageobj.OpenTheComposeLabel).isDisplayed();
		Assert.assertEquals(OpenTheComposeLabelFlag, true);
		logger.pass("Verified OpenTheCompose Label is Displayed");
		boolean CreateAUTOSARLabelFlag = DesktopSession.findElementByName(Pageobj.CreateAUTOSARLabel).isDisplayed();
		Assert.assertEquals(CreateAUTOSARLabelFlag, true);
		logger.pass("Verified CreateAUTOSAR Label is Displayed");
		boolean NewAUTOSARFileLabelFlag = DesktopSession.findElementByName(Pageobj.NewAUTOSARFileLabel).isDisplayed();
		Assert.assertEquals(NewAUTOSARFileLabelFlag, true);
		logger.pass("Verified NewAUTOSARFile Label is Displayed");
		boolean ModuleConfigurationLabelFlag = DesktopSession.findElementByName(Pageobj.ModuleConfigurationLabel)
				.isDisplayed();
		Assert.assertEquals(ModuleConfigurationLabelFlag, true);
		logger.pass("Verified ModuleConfiguration Label is Displayed");
	}

	@SuppressWarnings("unchecked")
	public void cheatSheetTaskSkipandNext() throws Exception {

		cheatSheetCommon();
		DesktopSession = Root();
		Robot rb = new Robot();
		Actions rightclick = new Actions(DesktopSession);

		boolean ClickToBeginLabelFlag = DesktopSession.findElementByName(Pageobj.ClickToBeginLabel).isDisplayed();
		Assert.assertEquals(ClickToBeginLabelFlag, true);
		logger.pass("Verified ClickToBegin Label is Displayed");
		DesktopSession.findElementByName(Pageobj.ClickToBeginLabel).click();
		logger.pass("Clicked On ClickToBegin Label");
		boolean ClickToPerformLabelFlag = DesktopSession.findElementByName(Pageobj.ClickToPerformLabel).isDisplayed();
		Assert.assertEquals(ClickToPerformLabelFlag, true);
		logger.pass("Verified ClickToPerform Label is Displayed");
		WebElement web = DesktopSession.findElementByName(Pageobj.ClickToSkipLabel);
		rightclick.click(web).perform();
		logger.pass("Clicked On ClickToSkip Label");
		String actual = "To create AUTOSAR project, go to File -> New -> Other -> AUTOSAR -> New AUTOSAR project -> Give Project Nameclick on finish.";
		String FinalActual = actual.trim();
		List<WebElement> wb = DesktopSession.findElementsByXPath(Pageobj.NextTaskLabel);
		System.out.println(wb.size());
		String pathVerify1 = wb.get(0).getAttribute("Name");
		String pathVerifyFInal = pathVerify1.trim();
		Assert.assertEquals(pathVerifyFInal, FinalActual);

		List<WebElement> wb1 = DesktopSession.findElementsByXPath(Pageobj.ClickWhenCompleteLabel);
		int size = wb1.size();
		for (int i = 0; i <= size - 1; i++) {

			String values = wb1.get(i).getAttribute("Name").trim();
			System.out.println(values);
			if (values.equals("Click when complete")) {
				rightclick.click(wb1.get(i)).build().perform();
				logger.pass("clicked Click when complete option");
				System.out.println("Clicked Click when complete");
				break;

			}
			System.out.println(wb1.get(i).getAttribute("Name"));
		}
		Thread.sleep(1000);
		List<WebElement> wb2 = DesktopSession.findElementsByXPath("//*[@LocalizedControlType='edit']");
		int size1 = wb2.size();
		String validationString = "To create description file, right click on the Project -> New -> Other -> AUTOSAR -> New AUTOSAR File Click on Next button , provide name to the file and click on finish.";
		validationString.trim();

		String actualName = wb2.get(0).getAttribute("Name").trim();
		System.out.println(validationString);
		System.out.println(actualName);
		Assert.assertEquals(validationString, actualName);

	}

	public void resetAllTask() throws Exception {

		cheatSheetTaskSkipandNext();
		DesktopSession = Root();
		Robot rb = new Robot();
		Actions rightclick = new Actions(DesktopSession);

		DesktopSession.findElementByName(Pageobj.Compose4KsarCheatsheetLabel).click();
		logger.pass("Clicked On Autosar Compose4Ksar Cheatsheet Label");
		rightclick.contextClick().build().perform();
		logger.pass("Right Clicked On Autosar Compose4Ksar Cheatsheet Label");
		boolean optionreset = DesktopSession.findElementByName(Pageobj.RestartAllTaskOption).isEnabled();
		assertEquals(optionreset, true);
		logger.pass("RestartAllTaskOption Label is enabled");
		DesktopSession.findElementByName(Pageobj.RestartAllTaskOption).click();
		logger.pass("Clicked in RestartAllTaskOption Label");
		DesktopSession.findElementByName(Pageobj.Launch).click();
		logger.pass("Clicked on OK button");

	}

	public void resetSingleTask() throws Exception {

		cheatSheetTaskSkipandNext();
		DesktopSession = Root();
		Robot rb = new Robot();
		Actions rightclick = new Actions(DesktopSession);

		DesktopSession.findElementByName(Pageobj.AutosarProjectCreationLabel).click();
		logger.pass("Clicked On Autosar ProjectCreation Label");
		rightclick.contextClick().build().perform();
		logger.pass("Right Clicked On Autosar ProjectCreation Label");
		boolean optionresetone = DesktopSession.findElementByName(Pageobj.ResetOption).isEnabled();
		assertEquals(optionresetone, true);
		logger.pass("Reset Option Label is enabled");
		DesktopSession.findElementByName(Pageobj.ResetOption).click();
		logger.pass("Clicked in Reset Option Label");
		DesktopSession.findElementByName(Pageobj.Launch).click();
		logger.pass("Clicked on OK button");

	}

	public void LunchAppWithoutRandom(String AppPath) throws Exception {

		DesktopSession = Root();
		Actions rightclick = new Actions(DesktopSession);
		logger.pass("Application opened");
		WebElement wb = DesktopSession.findElementByName(Pageobj.workspaces);
		rightclick.click(wb);
		rightclick.perform();
		logger.pass("Click on the Workspace");
		String select = Keys.chord(Keys.CONTROL, "a");
		rightclick.sendKeys(wb, select);
		rightclick.perform();
		rightclick.sendKeys(wb, AppPath);
		rightclick.perform();
		logger.pass("entered the Workspace path");
		DesktopSession.findElementByName(Pageobj.Launch).click();
		logger.pass("Clicked Ok");
		Thread.sleep(20000);
		// WebElement max = DesktopSession.findElementByXPath(Pageobj.Maximize);
		// rightclick.doubleClick(max).perform();
		// logger.pass("Maximized");
		logger.pass("Sencond Application Instance has been launched");
	}

	@SuppressWarnings("unchecked")
	public void VerifyElementInfo(String Project) throws Exception {
		DesktopSession = Root();
		Robot rb = new Robot();
		Actions act = new Actions(DesktopSession);
		DesktopSession.findElementByName(Project).click();
		logger.pass("Clicked on the Project");
		ExpandProject(4);
		logger.pass("Project expanded");
		// DesktopSession.findElementByName(Pageobj.default_arxml).click();
		// logger.pass("Clicked on the default_arxml");
		ExpandProject(5);
		logger.pass("Project expanded");
		DesktopSession.findElementByName(Pageobj.ARPackage).click();
		logger.pass("Clicked on ArPackage");
		act.contextClick().perform();
		Thread.sleep(1000);
		logger.pass("Clicked on ArPackage");
		// DesktopSession.findElementByName(Pageobj.ModuleConfiguration).click();
		rb.keyPress(KeyEvent.VK_N);
		rb.keyRelease(KeyEvent.VK_N);
		rb.keyPress(KeyEvent.VK_N);
		rb.keyRelease(KeyEvent.VK_N);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(500);
		logger.pass("Clicked on ModuleConfiguration");
		DesktopSession.findElementByName(Pageobj.AddElement).click();
		logger.pass("Clicked on adding element");
		int i = 0;
		while (i <= 71) {
			System.out.println(i + " -- -- - > ");
			logger.pass("Waiting");
			Thread.sleep(1000);
			try {

				if (DesktopSession.findElementByName(Pageobj.RteElement).isDisplayed()) {
					System.out.println(
							" =-=-=->  987 " + DesktopSession.findElementByName(Pageobj.RteElement).isDisplayed());
					DesktopSession.findElementByName(Pageobj.RteElement).click();
					break;
				}
			} catch (Exception e) {
				System.out.println(e + " -- -- - > ");
			}
			rb.keyPress(KeyEvent.VK_DOWN);
			rb.keyRelease(KeyEvent.VK_DOWN);

			i++;
		}
		DesktopSession.findElementByName(Pageobj.RteElement).click();
		logger.pass("Clicked on RteElement");
		Thread.sleep(1000);
		DesktopSession.findElementByName(Pageobj.Ote).click();
		logger.pass("Clicked on Ote");
		DesktopSession.findElementByName(Pageobj.ARPackage).click();
		logger.pass("Clicked on ArPackage");
		ExpandProject(3);
		DesktopSession.findElementByName(Pageobj.View_Menu).click();
		logger.pass("Selected the View_Menu");
		DesktopSession.findElementByName(Pageobj.CustomizeView).click();
		logger.pass("Selected the CustomizeView");
		DesktopSession.findElementByName(Pageobj.Resource).click();
		logger.pass("Selected the Resource");
		rb.keyPress(KeyEvent.VK_SPACE);
		DesktopSession.findElementByName(Pageobj.HideECUParam).click();
		rb.keyPress(KeyEvent.VK_SPACE);
		logger.pass("Selected the HideECUParam");
		DesktopSession.findElementByName(Pageobj.Launch).click();
		logger.pass("Selected the Launch");
		Thread.sleep(1000);
		DesktopSession.findElementByName("Os_0 [Os]").click();
		ExpandProject(2);
		DesktopSession.findElementByName("OsOS_0 [OsOS]").click();
		logger.pass("Clicked on ArPackage");
		ExpandProject(3);
		// OsStackMonitoring [EcucNumericalParamValue]
		DesktopSession.findElementByName("OsStackMonitoring [EcucNumericalParamValue]").click();
		act.doubleClick().perform();
		Thread.sleep(1000);
		DesktopSession.findElementByName("OsHooks_0").click();
		rb.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(1000);
		rb.keyRelease(KeyEvent.VK_DOWN);
		DesktopSession.findElementByName("OsNumberOfCores").click();
		List<WebElement> lst = DesktopSession.findElementsByName("OsNumberOfCores");
		System.out.println(lst.size());
		WebElement hover = lst.get(3);
		act.moveToElement(hover).perform();
		act.clickAndHold(hover).build().perform();
		act.contextClick(hover).perform();
		Thread.sleep(1000);

		boolean flag = DesktopSession.findElementByName("Maximum number of cores that are controlled by the OS.")
				.isDisplayed();
		String value = DesktopSession.findElementByClassName("Static").getAttribute("Name");
		String val = DesktopSession.findElementByClassName("Static").getText();
		System.out.println(flag + " - - - -  >  " + val + "  =-=-=-=->  " + value);
		Assert.assertEquals(value, "Maximum number of cores that are controlled by the OS.");

	}

	public void CreateDefaultArxml(String Project) throws Exception {

		DesktopSession = Root();
		Actions act = new Actions(DesktopSession);
		DesktopSession.findElementByName(Project).click();
		logger.pass("Clicked on Project");
		act.contextClick().perform();
		logger.pass("Right Clicked on Project");
		DesktopSession.findElementByName(Pageobj.New).click();
		logger.pass("Clicked on New");
		Thread.sleep(500);
//		DesktopSession.findElementByName(Pageobj.Other).click();
//		logger.pass("Clicked on Other");
		DesktopSession.findElementByName(Pageobj.Autosar).click();
		logger.pass("Clicked on Autosar");
		ExpandProject(2);
		DesktopSession.findElementByName(Pageobj.NewAUTOSARFile).click();
		logger.pass("Clicked on NewAUTOSARFile");
		DesktopSession.findElementByName(Pageobj.Next_Button).click();
		logger.pass("Clicked on Next_Button");
		DesktopSession.findElementByName(Pageobj.Finish_Button).click();
		logger.pass("Clicked on Finish_Button");
	}

	public void NewCreateDefaultArxml(String Project) throws Exception {

		DesktopSession = Root();
		Actions act = new Actions(DesktopSession);
		Robot rb = new Robot();
		DesktopSession.findElementByName(Project).click();
		logger.pass("Clicked on Project");
		act.contextClick().perform();
		logger.pass("Right Clicked on Project");
		DesktopSession.findElementByName(Pageobj.New).click();
		logger.pass("Clicked on New");
		Thread.sleep(500);
//		DesktopSession.findElementByName(Pageobj.Other).click();
//		logger.pass("Clicked on Other");
		DesktopSession.findElementByName(Pageobj.General_Folder).click();
		logger.pass("Clicked on General folder");
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		ExpandProject(2);
		DesktopSession.findElementByName("ECU Configuration File").click();
		logger.pass("Clicked on Ecu Configuration File");
		DesktopSession.findElementByName(Pageobj.Next_Button).click();
		logger.pass("Clicked on Next_Button");
		DesktopSession.findElementByName(Pageobj.Finish_Button).click();
		logger.pass("Clicked on Finish_Button");
	}

	public boolean VerifyDefaultarxml(String Project) throws Exception {
		DesktopSession = Root();
		Actions act = new Actions(DesktopSession);
		DesktopSession.findElementByName(Project).click();
		logger.pass("Clicked on Project");
		ExpandProject(3);
		boolean flag = false;
		try {
			flag = DesktopSession.findElementByName(Pageobj.default_arxml).isDisplayed();
		} catch (Exception e) {
			System.out.println(e);
			flag = false;
		}
		return flag;

	}

	@SuppressWarnings("unchecked")
	public void VerifyParameterTooltip(String Project) throws Exception {

		DesktopSession = Root();
		Actions act = new Actions(DesktopSession);
		Robot rb = new Robot();
		DesktopSession.findElementByName(Project).click();
		logger.pass("Clicked on Project one");
		ExpandProject(2);
		logger.pass("Project Expanded");
		DesktopSession.findElementByName(Pageobj.EcucDescription_arxml).click();
		ExpandProject(7);
		DesktopSession.findElementByName("Can_0 [Can]").click();
		act.doubleClick().perform();
		DesktopSession.findElementByName("CanConfigSet_0").click();
		ExpandProject(1);
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		DesktopSession.findElementByName("CanController_0").click();
		ExpandProject(1);
		List<WebElement> lstn = DesktopSession.findElementsByName("CanController_0");
		System.out.println(lstn.size() + " -=--=> ");
		WebElement canController = lstn.get(4);
		canController.click();
		Thread.sleep(1000);
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(500);
		List<WebElement> lst = DesktopSession.findElementsByName("CanBusoffProcessing");
		System.out.println(lst.size());
		for (int i = 0; i <= lst.size() - 1; i++) {

			System.out.println(lst.get(i));
			System.out.println(lst.get(i).getText() + " =======>  ");
			act.moveToElement(lst.get(i)).perform();
			String value = DesktopSession.findElementByClassName("Static").getAttribute("Name");
			String val = DesktopSession.findElementByClassName("Static").getText();
			System.out.println(value + " - - - - -  > " + i + "  ====>  " + val);
		}
		lst.get(3).click();
		String value = DesktopSession.findElementByClassName("Static").getAttribute("Name");
		String val = DesktopSession.findElementByClassName("Static").getText();
		System.out.println(value + " - - - - -  > " + "  ====>  " + val);
	}

	public void MergeFileoption() throws Exception {
		DesktopSession = Root();
		Actions act = new Actions(DesktopSession);
		Robot rb = new Robot();
		Thread.sleep(3000);
		DesktopSession.findElementByName("Sam").click();
		logger.pass("Clicked on Project one");
		ExpandProject(2);
		logger.pass("Project expanded");
		DesktopSession.findElementByName("Tom").click();
		logger.pass("Clicked on Project two");
		ExpandProject(1);
		logger.pass("Project expanded");
		rb.keyPress(KeyEvent.VK_CONTROL);
		logger.pass("Clicked on cntrl");
		DesktopSession.findElementByName("BswM_1.arxml").click();
		logger.pass("Clicked on BswM_1.arxml");
		DesktopSession.findElementByName("Daimler_extract.arxml").click();
		logger.pass("Clicked on Daimler_extract.arxml");
		DesktopSession.findElementByName("BswM.arxml").click();
		logger.pass("Clicked on BswM.arxml");
		DesktopSession.findElementByName("Daimler.arxml").click();
		logger.pass("Clicked on Daimler.arxml");
		Thread.sleep(1000);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		logger.pass("Released cntrl button");
		act.contextClick().perform();
		logger.pass("Right Clicked on Project");
		boolean flag = false;
		try {
			if (DesktopSession.findElementByName("Merge Files").isDisplayed()) {
				flag = true;
				System.out.println("Option is Present");
			} else {
				flag = false;
				System.out.println("Option is not Present");
			}
		} catch (Exception e) {
			System.out.println(e);
			flag = false;
		}
		Assert.assertEquals(flag, false);

	}

	public void SingleFileMergeOption() throws Exception {

		DesktopSession = Root();
		Actions act = new Actions(DesktopSession);
		Robot rb = new Robot();
		Thread.sleep(4000);
		DesktopSession.findElementByName("Sam").click();
		logger.pass("Clicked on Project one");
		ExpandProject(2);
		logger.pass("Project expanded");
		DesktopSession.findElementByName("Tom").click();
		logger.pass("Clicked on Project two");
		ExpandProject(1);
		logger.pass("Project expanded");
		DesktopSession.findElementByName("BswM_1.arxml").click();
		logger.pass("Clicked on BswM_1.arxml");
		act.contextClick().perform();
		logger.pass("Right Clicked on Project");
		boolean flag = false;
		try {
			if (DesktopSession.findElementByName("Merge Files").isDisplayed()) {
				flag = true;
				System.out.println("Option is Present");
			} else {
				flag = false;
				System.out.println("Option is not Present");
			}
		} catch (Exception e) {
			System.out.println(e);
			flag = false;
		}
		Assert.assertEquals(flag, false);
	}

	public void ImportArxmlAndDelete(String Project, String Filepath) throws Exception {

		DesktopSession = Root();
		Actions act = new Actions(DesktopSession);
		Robot rb = new Robot();
		WebElement proj = DesktopSession.findElementByName(Project);
		proj.click();
		logger.pass("Clicked on Project");
		act.contextClick(proj).perform();
		logger.pass("Right Clicked on Project");
		Thread.sleep(500);
		DesktopSession.findElementByName(Pageobj.Import).click();
		logger.pass("Clicked on Import");
		DesktopSession.findElementByName(Pageobj.General_Folder).click();
		logger.pass("Clicked on General Folder");
		rb.keyPress(KeyEvent.VK_RIGHT);
		DesktopSession.findElementByName(Pageobj.Import_FileSystem).click();
		logger.pass("Clicked on file system");
		DesktopSession.findElementByName(Pageobj.Next_Button).click();
		logger.pass("Clicked on Next button");
		DesktopSession.findElementByName(Pageobj.File_Directory).click();
		logger.pass("Clicked on directory ");
		WebElement field = DesktopSession.findElementByName(Pageobj.File_Directory);
		act.sendKeys(field, Filepath);
		act.perform();
		logger.pass("Send keys on filepath");
		logger.pass("Entered the Dir");
		DesktopSession.findElementByClassName(Pageobj.TreeView32).click();
		logger.pass("Clicked on TreeView32");
		DesktopSession.findElementByName(Pageobj.default_arxml).click();
		logger.pass("Clicked on default arxml");
		rb.keyPress(KeyEvent.VK_SPACE);
		logger.pass("Clicked on checkbox");
		DesktopSession.findElementByName(Pageobj.Finish_Button).click();
		Thread.sleep(500);
		logger.pass("Clicked on finish button");
		boolean flag = DesktopSession.findElementByName("AUTOSAR Navigator").isDisplayed();
		Assert.assertEquals(flag, true);
		logger.pass("Verified on testcase");
	}

	public void VerifyEcucOptionDisable(String project) throws Exception {

		DesktopSession = Root();
		Actions act = new Actions(DesktopSession);
		Robot rb = new Robot();
		WebElement proj = DesktopSession.findElementByName(project);
		proj.click();
		logger.pass("Clicked on Project");
		ExpandProject(2);
		// EcucDescription_copy1.arxml
		rb.keyPress(KeyEvent.VK_CONTROL);
		logger.pass("Pressed on Cntrl");
		// DesktopSession.findElementByName("EcucDescription_copy1.arxml").click();
		logger.pass("Clicked on EcucDescription_copy1.arxml");
		DesktopSession.findElementByName("EcucDescription.arxml").click();
		logger.pass("Clicked on EcucDescription.arxml");
		rb.keyRelease(KeyEvent.VK_CONTROL);
		logger.pass("Released on Cntrl");
		act.contextClick().perform();
		Thread.sleep(1000);
		logger.pass("Right Click on Performed");
		boolean enable = false;
		try {
			enable = DesktopSession.findElementByName("ECU Extract").isEnabled();
			logger.pass("ECU Extract is enable ?");
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println(enable + "  = = = = => ");
		if (enable == true) {
			DesktopSession.findElementByName("ECU Extract").click();
			boolean info = DesktopSession.findElementByName("Info").isDisplayed();
			Assert.assertEquals(info, true);
			String str = DesktopSession.findElementByName("The chosen operation is not enabled.").getText();
			DesktopSession.findElementByName("OK").click();
			logger.pass("Clicked on OK");
			rb.keyRelease(KeyEvent.VK_CONTROL);
			Assert.assertEquals(str, "The chosen operation is not enabled.");

		} else {
			Assert.assertEquals(enable, false);
			logger.pass("Test case Verified");
		}
	}

	@SuppressWarnings("unchecked")
	public void SubcontainerViews(String project) throws Exception {

		DesktopSession = Root();
		Actions act = new Actions(DesktopSession);
		Robot rb = new Robot();
		WebElement proj = DesktopSession.findElementByName(project);
		proj.click();
		logger.pass("Clicked on Project");
		ExpandProject(2);
		logger.pass("Project expanded");
		DesktopSession.findElementByName(Pageobj.EcucDescription_arxml).click();
		logger.pass("Clicked on EcucDescription_arxml");
		ExpandProject(7);
		logger.pass("Expanded");
		DesktopSession.findElementByName("EcuC_0 [EcuC]").click();
		logger.pass("Clicked on EcuC_0");
		act.doubleClick().perform();
		logger.pass("double Clicked on EcuC_0");
		boolean EcucConfig = DesktopSession.findElementByName("EcucConfigSet_0").isDisplayed();
		System.out.println(EcucConfig + "  ===>  ");
		Thread.sleep(1000);
		DesktopSession.findElementByName("Nm_0 [Nm]").click();
		logger.pass("Clicked on Nm_0");
		act.doubleClick().perform();
		logger.pass("double Clicked on Nm_0");
		Thread.sleep(1000);
//		rb.keyPress(KeyEvent.VK_LEFT);
//		logger.pass("Clicked on right arrow");
//		rb.keyPress(KeyEvent.VK_LEFT);
//		logger.pass("Clicked on right arrow");
		rb.keyPress(KeyEvent.VK_DOWN);
		logger.pass("Clicked on down arrow");
		rb.keyPress(KeyEvent.VK_DOWN);
		logger.pass("Clicked on down arrow");
		rb.keyPress(KeyEvent.VK_DOWN);
		logger.pass("Clicked on down arrow");
		rb.keyRelease(KeyEvent.VK_DOWN);
		logger.pass("released on down arrow");
		rb.keyPress(KeyEvent.VK_RIGHT);
		logger.pass("Clicked on right arrow");
		rb.keyPress(KeyEvent.VK_RIGHT);
		logger.pass("Clicked on right arrow");
		rb.keyPress(KeyEvent.VK_DOWN);
		logger.pass("Clicked on down arrow");
		rb.keyRelease(KeyEvent.VK_DOWN);
		logger.pass("released on down arrow");
		boolean NmGlobal = DesktopSession.findElementByName("NmGlobalConstants_0").isDisplayed();
		System.out.println(NmGlobal + "  ===>  ");
		List<WebElement> lst = DesktopSession.findElementsByXPath("//*[@LocalizedControlType = 'tab item']");
		System.out.println(lst.size() + " --- - - >");
		String EcuCTab = lst.get(3).getText();
		String NmTab = lst.get(4).getText();
		WebElement drag = lst.get(3);
		WebElement drop = lst.get(4);
		act.dragAndDrop(drag, drop).perform();
		Thread.sleep(1000);
		act.clickAndHold(drag).perform();
		act.dragAndDrop(drag, drop).perform();
		lst.get(3).click();
		act.contextClick().perform();
		System.out.println("right clicked");
		logger.pass("Clicked On ecuc Button");
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		DesktopSession.findElementByName("EcuC_0 [EcuC]").click();
		logger.pass("Clicked on EcuC_0");
		act.doubleClick().perform();
		logger.pass("double Clicked on EcuC_0");
		Thread.sleep(1000);
		List<WebElement> lstn = DesktopSession.findElementsByXPath("//*[@LocalizedControlType = 'tab item']");
		System.out.println(lstn.size() + " --- - - >");
		String EcuCTabn = lst.get(3).getText();
		String NmTabn = lst.get(4).getText();
		System.out.println(EcuCTab + " ==s12w==> " + EcuCTabn);
		System.out.println(NmTab + " ===2w3=> " + NmTabn);
		Assert.assertEquals(EcuCTab, NmTab);
		Assert.assertEquals(EcuCTabn, NmTabn);
	}

	@SuppressWarnings("unchecked")
	public void VerifyClearSearch(String project) throws Exception {

		DesktopSession = Root();
		Actions act = new Actions(DesktopSession);
		Robot rb = new Robot();
		WebElement proj = DesktopSession.findElementByName(project);
		proj.click();
		logger.pass("Clicked on Project");
		ExpandProject(2);
		logger.pass("Project expanded");
		DesktopSession.findElementByName(Pageobj.LocalParameters).click();
		logger.pass("Clicked on LocalParameters");
		ExpandProject(9);
		logger.pass("LocalParameters expanded");
		DesktopSession.findElementByName(Pageobj.BswM_Module).click();
		logger.pass("Clicked on BswM_Module");
		act.contextClick().perform();
		logger.pass("Right Clicked on BswM_Module");
		Thread.sleep(500);
		DesktopSession.findElementByName(Pageobj.Find_All_References).click();
		logger.pass("Clicked on Find_All_References");
		Thread.sleep(1000);
		boolean flag = DesktopSession.findElementByName("AUTOSAR Reference Search").isDisplayed();
		logger.pass("AUTOSAR Reference Search is displayed");
		System.out.println(flag + " =-=-> ");
		Thread.sleep(1000);
		proj.click();
		logger.pass("Clicked on Project");
		act.contextClick().perform();
		logger.pass("Right Clicked on Project");
		Thread.sleep(500);
		DesktopSession.findElementByName("Close Project").click();
		logger.pass(" Clicked on close Project");
		List<WebElement> lst = DesktopSession.findElementsByClassName("SysLink");
		System.out.println(lst.size());
		System.out.println(lst.get(1).getText() + " --> 1");
		String str = lst.get(1).getText();
		logger.pass("get text");
		System.out.println(" =--=->  m " + str);
		Thread.sleep(1000);
		proj.click();
		logger.pass("Clicked on Project");
		act.contextClick().perform();
		logger.pass("Right Clicked on Project");
		Thread.sleep(500);
		DesktopSession.findElementByName("Open Project").click();
		logger.pass(" Clicked on Open Project");
		Thread.sleep(1000);
		DesktopSession.findElementByName(Pageobj.LocalParameters).click();
		logger.pass("LocalParameters expanded");
		ExpandProject(9);
		logger.pass("LocalParameters expanded");
		DesktopSession.findElementByName(Pageobj.BswM_Module).click();
		logger.pass("Clicked on BswM_Module");
		act.contextClick().perform();
		logger.pass("Right Clicked on Project");
		Thread.sleep(500);
		DesktopSession.findElementByName(Pageobj.Find_All_References).click();
		logger.pass("Clicked on Find_All_References");
		Thread.sleep(1000);
		boolean flag1 = DesktopSession.findElementByName("AUTOSAR Reference Search").isDisplayed();
		logger.pass("AUTOSAR Reference Search is displayed");
		System.out.println(flag + " =-=-> ");
		Thread.sleep(1000);
		proj.click();
		logger.pass(" Clicked on Open Project");
		act.contextClick().perform();
		logger.pass("Right Clicked on Project");
		Thread.sleep(500);
		DesktopSession.findElementByName("Delete").click();
		logger.pass(" Clicked on Delete");
		rb.keyPress(KeyEvent.VK_ENTER);
		logger.pass(" Clicked on Enter");
		Thread.sleep(500);
		rb.keyRelease(KeyEvent.VK_ENTER);
		String nostr2 = lst.get(1).getText();
		System.out.println(" =--=->  fyfv " + nostr2);
		Assert.assertEquals(str, nostr2);
		Assert.assertEquals(flag, flag1);
	}

	@SuppressWarnings({ "unchecked", "resource" })
	public void VerifyOrderofElement(String Project, String path) throws Exception {

		DesktopSession = Root();
		Actions act = new Actions(DesktopSession);
		Robot rb = new Robot();
		WebElement proj = DesktopSession.findElementByName(Project);
		proj.click();
		logger.pass("Clicked on Project");
		ExpandProject(2);
		logger.pass("Project expanded");
		DesktopSession.findElementByName("Test.arxml").click();
		logger.pass("Clicked on Test arxml");
		act.contextClick().perform();
		logger.pass("Right Click on Test arxml");
		Thread.sleep(500);
		DesktopSession.findElementByName("Copy").click();
		logger.pass("Clicked on copy");
		DesktopSession.findElementByName(Project).click();
		logger.pass("Clicked on Project");
		act.contextClick().perform();
		logger.pass("Right Click on Project");
		Thread.sleep(500);
		DesktopSession.findElementByName("Paste").click();
		logger.pass("Clicked on Paste");
		Thread.sleep(500);
		List<WebElement> lstf = DesktopSession.findElementsByClassName("Edit");
		System.out.println(lstf.size());
		String copyfile1 = "";
		String copyfile = "";
		for (int i = 0; i <= lstf.size() - 1; i++) {
			copyfile1 = lstf.get(i).getAttribute("Name");
			System.out.println(copyfile1 + " =-==> ");
			if (copyfile1.equalsIgnoreCase("Enter a new name for 'Test.arxml'")) {
				copyfile = lstf.get(i).getAttribute("Value.Value");
				break;
			}
		}

		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		logger.pass("Clicked on Enter");
		DesktopSession.findElementByName(Project).click();
		act.contextClick().perform();
		Thread.sleep(500);
		DesktopSession.findElementByName("Refresh").click();
		Thread.sleep(500);

		DesktopSession.findElementByName(copyfile).click();
		act.contextClick().perform();
		Thread.sleep(500);
		DesktopSession.findElementByName("Properties").click();
		Thread.sleep(500);
		List<WebElement> lst2 = DesktopSession.findElementsByXPath("//*[@LocalizedControlType='document']");
		System.out.println(lst2.size());
		for (int i = 0; i <= lst2.size() - 1; i++) {
			System.out.println(lst2.get(i).getAttribute("Value.Value") + " =-=->  " + i);
		}
		String FileLoc = lst2.get(2).getAttribute("Value.Value");
		System.out.println(FileLoc + " =- - > ");
		DesktopSession.findElementByName(Pageobj.Launch).click();
		BufferedReader bufferedReader = new BufferedReader(new FileReader(FileLoc));
		Map<Integer, String> map = new HashedMap();
		String curLine;
		int i = 1;
		while ((curLine = bufferedReader.readLine()) != null) {
			System.out.println(curLine);
			String[] data = curLine.split("\\r?\\n|\\r");
			String value = data[0];
			map.put(i, value);
			i++;
		}
		String file1 = path + File.separator + "Test.arxml";
		BufferedReader bufferedReader1 = new BufferedReader(new FileReader(file1));
		Map<Integer, String> map1 = new HashedMap();
		String curLine1;
		int j = 1;
		while ((curLine1 = bufferedReader1.readLine()) != null) {
			// process the line as required
			// System.out.println(curLine1);
			String[] data = curLine1.split("\\r?\\n|\\r");
			String value1 = data[0];
			map1.put(j, value1);
			j++;
		}
		System.out.println(map1.size());
		System.out.println(map.size());
		System.out.println(map.get(821).equals(map1.get(821)));
		System.out.println(map.get(824).equals(map1.get(824)));
		System.out.println(map.get(828).equals(map1.get(828)));
		System.out.println(map.get(832).equals(map1.get(832)));
		System.out.println(map.get(836).equals(map1.get(836)));

		bufferedReader.close();
		Assert.assertEquals(map, map1);
	}

	public void ImportArxmlFile(String Project, String filename, String Path) throws Exception {
		DesktopSession = Root();
		Thread.sleep(3000);
		Actions act = new Actions(DesktopSession);
		Robot rb = new Robot();
		DesktopSession.findElementByName(Project).click();
		logger.pass("Click the Project");
		act.contextClick().perform();
		Thread.sleep(1000);
		DesktopSession.findElementByName(Pageobj.Import).click();
		logger.pass("Clicked On Import");
		DesktopSession.findElementByName(Pageobj.General_Folder).click();
		logger.pass("Click the General_Folder");
		rb.keyPress(KeyEvent.VK_RIGHT);
		Thread.sleep(500);
		DesktopSession.findElementByName(Pageobj.Import_FileSystem).click();
		logger.pass("Click the Import_FileSystem");
		DesktopSession.findElementByName(Pageobj.Next_Button).click();
		logger.pass("Click the Next_Button");
		// DesktopSession.findElementByName(Pageobj.Browse).click();
		DesktopSession.findElementByName(Pageobj.File_Directory).click();
		logger.pass("Click the File_Directory");
		String Filepath = Path;
		WebElement Inputfilepath = DesktopSession.findElementByName(Pageobj.File_Directory);
		// DesktopSession.findElementByName(Pageobj.File_Directory).sendKeys(Filepath);
		act.sendKeys(Inputfilepath, Filepath).perform();
		DesktopSession.findElementByClassName("SysTreeView32").click();
		logger.pass("Click the SysTreeView32");
		DesktopSession.findElementByName(filename).click();
		logger.pass("Click the filename");
		rb.keyPress(KeyEvent.VK_SPACE);
		Thread.sleep(500);
		DesktopSession.findElementByName(Pageobj.Finish_Button).click();
		logger.pass("Click the Finish_Button");
		Thread.sleep(1000);
	}

	@SuppressWarnings("unchecked")
	public void CanHardwareMapping(String Project) throws Exception {

		DesktopSession = Root();
		Actions act = new Actions(DesktopSession);
		Robot rb = new Robot();
		WebElement proj = DesktopSession.findElementByName(Project);
		proj.click();
		logger.pass("Click the Project");
		act.contextClick(proj).perform();
		Thread.sleep(1000);
		DesktopSession.findElementByName(Pageobj.CanMapping).click();
		// Can Hardware Object Mapping [NewProject]
		DesktopSession.findElementByName(Pageobj.Properties_Tab).click();
		act.doubleClick().perform();
		Thread.sleep(1000);
		DesktopSession.findElementByName(Pageobj.Properties_Tab).click();
		act.contextClick().perform();
		Thread.sleep(500);
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
//		DesktopSession.findElementByName("Hardware Object List").click();
//		rb.keyPress(KeyEvent.VK_DOWN);
//		rb.keyRelease(KeyEvent.VK_DOWN);
		Map<Integer, String> map = new HashedMap();
		Map<Integer, String> map1 = new HashedMap();
		List<WebElement> tree = DesktopSession.findElementsByXPath("//*[@LocalizedControlType='tree item']");
		System.out.println(tree.size() + " =-=-=->  ");
		for (int k = 0; k <= tree.size() - 1; k++) {
			System.out.println(tree.get(k).getAttribute("Name"));
			String values = tree.get(k).getAttribute("Name");
			if (values.contains("CanHardwareObject")) {
				map.put(k, values);
			}
		}
		List<WebElement> lst = DesktopSession.findElementsByXPath("//*[@LocalizedControlType='image']");
		System.out.println(lst.size());

		lst.get(4).click();
		List<WebElement> tree1 = DesktopSession.findElementsByXPath("//*[@LocalizedControlType='tree item']");
		System.out.println(tree1.size() + " =-=-x=->  ");
		for (int i = 0; i <= tree1.size() - 1; i++) {
			// System.out.println(tree1.get(i).getAttribute("Name"));
			String values = tree1.get(i).getAttribute("Name");
			if (values.contains("CanHardwareObject")) {
				map1.put(i, values);
			}
		}

		System.out.println(map.size() + "  =-=--=>  " + map1.size());
		int actual = map1.size();
		int exp = map.size();
		String diff = map1.get(85);
		System.out.println(diff + " =-=-=-> " + map.get(85));
		System.out.println(map1.get(85) + " =-=-=-> " + map.get(84));
		// Assert.assertEquals(diff, "CanHardwareObject_1");
		Assert.assertEquals(actual, exp + 1);
	}

	@SuppressWarnings("unchecked")
	public void VerifyCanController(String project) throws Exception {

		DesktopSession = Root();
		Actions act = new Actions(DesktopSession);
		Robot rb = new Robot();
		WebElement proj = DesktopSession.findElementByName(project);
		proj.click();
		logger.pass("Click the Project");
		act.contextClick(proj).perform();
		Thread.sleep(1000);
		DesktopSession.findElementByName(Pageobj.CanMapping).click();
		// Can Hardware Object Mapping [NewProject]
//		DesktopSession.findElementByName(Pageobj.Properties_Tab).click();
//		act.doubleClick().perform();
//		for(int j=0;j<=8;j++) {
//			System.out.println(j);
//			rb.keyPress(KeyEvent.VK_TAB);
//			rb.keyRelease(KeyEvent.VK_TAB);
//			System.out.println("done");
//		}
		WebElement prop = DesktopSession.findElementByName("Can Hardware Object Mapping [NewProject]");
		Thread.sleep(1000);
		act.doubleClick(prop).perform();
//		rb.keyPress(KeyEvent.VK_DOWN);
//		rb.keyRelease(KeyEvent.VK_DOWN);
//		rb.keyPress(KeyEvent.VK_ENTER);
//		rb.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(1000);

		DesktopSession.findElementByName(Pageobj.Modify).click();
		Thread.sleep(1000);
		DesktopSession.findElementByName(Pageobj.EnterCanController).click();
		Thread.sleep(1000);
		List<WebElement> edit = DesktopSession.findElementsByClassName("Edit");
		System.out.println(edit.size() + " =-= -=> ");
		for (int i = 0; i <= edit.size() - 1; i++) {
			System.out.println(edit.get(i).getAttribute("AutomationId") + " =-=-7u> ");
			String text = edit.get(i).getAttribute("Name");
			System.out.println(text + "  =-sc-=- > ");
			if (text.equalsIgnoreCase("Enter the number of CAN Controller")) {
				edit.get(i).sendKeys("2");
				break;
			}
		}
		// edit.get(2).sendKeys("2");
		List<WebElement> lst = DesktopSession.findElementsByXPath("//*[@LocalizedControlType='image']");
		System.out.println(lst.size());
		for (int i = 0; i <= lst.size() - 1; i++) {
			System.out.println(lst.get(i).getAttribute("AutomationId") + "  =--==> " + i);
		}
		List<WebElement> lst1 = DesktopSession.findElementsByXPath("//*[@LocalizedControlType='tab item']");
		System.out.println(lst1.size());// 0
		int totaltab = lst1.size();
		lst.get(0).click();
		// tab item
		List<WebElement> lst2 = DesktopSession.findElementsByXPath("//*[@LocalizedControlType='tab item']");
		System.out.println(lst2.size() + "  =-99 =-=>");// 0
		int finalTotaltab = lst2.size();
		Assert.assertEquals(finalTotaltab - 2, totaltab);

	}

	@SuppressWarnings("unchecked")
	public void VerifynewlyAddCanTab(String project) throws Exception {

		DesktopSession = Root();
		Actions act = new Actions(DesktopSession);
		Robot rb = new Robot();
		DesktopSession.findElementByName(project).click();
		logger.pass("Click the Project");
		act.contextClick().perform();
		Thread.sleep(1000);
		DesktopSession.findElementByName(Pageobj.CanMapping).click();
		WebElement prop = DesktopSession.findElementByName("Can Hardware Object Mapping [NewProject]");
		Thread.sleep(1000);
		act.doubleClick(prop).perform();
		Thread.sleep(1000);

		DesktopSession.findElementByName(Pageobj.Modify).click();
		Thread.sleep(1000);
		DesktopSession.findElementByName(Pageobj.EnterCanController).click();
		Thread.sleep(1000);
		List<WebElement> edit = DesktopSession.findElementsByClassName("Edit");
		System.out.println(edit.size() + " =-= -=> ");
		for (int i = 0; i <= edit.size() - 1; i++) {
			System.out.println(edit.get(i).getAttribute("AutomationId") + " =-=-7u> ");
			String text = edit.get(i).getAttribute("Name");
			System.out.println(text + "  =-sc-=- > ");
			if (text.equalsIgnoreCase("Enter the number of CAN Controller")) {
				edit.get(i).sendKeys("2");
				break;
			}
		}
		// edit.get(2).sendKeys("2");
		List<WebElement> lst = DesktopSession.findElementsByXPath("//*[@LocalizedControlType='image']");
		System.out.println(lst.size());
		for (int i = 0; i <= lst.size() - 1; i++) {
			System.out.println(lst.get(i).getAttribute("AutomationId") + "  =--==> " + i);
		}
		List<WebElement> lst1 = DesktopSession.findElementsByXPath("//*[@LocalizedControlType='tab item']");
		System.out.println(lst1.size());// 0
		int totaltab = lst1.size();
		lst.get(0).click();
		// tab item
		int count = 0;
		int count1 = 0;
		List<WebElement> lst2 = DesktopSession.findElementsByXPath("//*[@LocalizedControlType='tab item']");
		System.out.println(lst2.size() + "  =-99 =-=>");// 0
		for (int i = 0; i <= lst1.size() - 1; i++) {
			String Value = lst1.get(i).getAttribute("Name");
			System.out.println(Value + " =-=-> ");
			if (Value.contains("CanCommunicationController")) {
				count++;
			} else {
				System.out.println(" =-=> ");
			}
		}
		System.out.println(count + "   =-=-=hgdr->");
		for (int i = 0; i <= lst2.size() - 1; i++) {
			String Value1 = lst2.get(i).getAttribute("Name");
			System.out.println(Value1 + " =-=-> ");
			if (Value1.contains("CanCommunicationController")) {
				count1++;
			} else {
				System.out.println(" =-=> ");
			}
		}
		System.out.println(count1 + "   =-=-=fg->");
		Assert.assertEquals(count + 2, count1);
	}

	@SuppressWarnings("unchecked")
	public String ECUCCompareonTwoFiles(String project) throws Exception {

		DesktopSession = Root();
		Actions act = new Actions(DesktopSession);
		Robot rb = new Robot();
		WebElement proj = DesktopSession.findElementByName(project);
		// proj.click();
		logger.pass("Click the Project");
		ExpandProject(2);
		logger.pass("Expand the Project");
		Thread.sleep(1000);
		rb.keyPress(KeyEvent.VK_CONTROL);
//		DesktopSession.findElementByName(project).click();
//		Thread.sleep(500);
		DesktopSession.findElementByName("DBC_RHS_Extract_20210820100759.arxml").click();
		logger.pass("Click DBC_RHS_Extract_20210820100759");
		Thread.sleep(500);
//		DesktopSession.findElementByName(project).click();
//		Thread.sleep(500);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		act.contextClick().perform();
		logger.pass("RightClick the Project");
		Thread.sleep(1000);
		DesktopSession.findElementByName(Pageobj.Merging_ECUC).click();
		logger.pass("Click the Merge ECUC");
		Thread.sleep(3000);
		String filename = "";
		List<WebElement> lst = DesktopSession.findElementsByXPath("//*[@LocalizedControlType='tree item']");
		System.out.println(lst.size() + "  =- =- > ");
		for (int i = 0; i <= lst.size() - 1; i++) {

			filename = lst.get(i).getAttribute("Name");
			System.out.println(filename + "  0=0--> ");
			if (filename.contains("EcuExtract_")) {
				System.out.println("inside if");
				lst.get(i).click();
				logger.pass("Click the EcuExtract file");
				act.contextClick().perform();
				logger.pass("RightClick the EcuExtract file");
				Thread.sleep(500);
				DesktopSession.findElementByName("Copy").click();
				logger.pass("Click the Copy");
				break;
			}
		}
		return filename;

	}

	@SuppressWarnings("unchecked")
	public void PasteNewECUfile(String Project, String Filename) throws Exception {
		DesktopSession = Root();
		Actions act = new Actions(DesktopSession);
		Robot rb = new Robot();
		WebElement proj = DesktopSession.findElementByName(Project);
		Thread.sleep(1000);
		// proj.click();
		act.contextClick(proj).perform();
		logger.pass("Right Click the project file");
		Thread.sleep(500);
		DesktopSession.findElementByName("Paste").click();
		logger.pass(" Click the paste");
		ExpandProject(3);
		logger.pass("Expand");
		DesktopSession.findElementByName(Filename).click();
		logger.pass("Click on the filename");
		act.contextClick().perform();
		logger.pass("Right Click the file");
		Thread.sleep(1000);
		DesktopSession.findElementByName(Pageobj.ClearValidation).click();
		logger.pass("Click on the clear validation");
		DesktopSession.findElementByName(Filename).click();
		logger.pass("Click on the filename");
		act.contextClick().perform();
		logger.pass("Right Click the file");
		Thread.sleep(1000);
		DesktopSession.findElementByName(Pageobj.BatchValidation).click();
		logger.pass("Click the batch validation");
		Thread.sleep(3000);
		DesktopSession.findElementByName("Description").click();
		Thread.sleep(1000);
		List<WebElement> lst = DesktopSession.findElementsByXPath("//*[@LocalizedControlType='tree item']");
		System.out.println(lst.size() + " -0-0-0-0-0-> ");
		boolean flag = false;
		for (int i = 0; i <= lst.size() - 1; i++) {

			String value = lst.get(i).getAttribute("Name");
			System.out.println(value + "  -9-9-9-9-9> ");
			if (value.equalsIgnoreCase("ERR009001: Unresolved proxies (100 of 794 items)")
					|| value.equalsIgnoreCase("ERR009001: Unresolved proxies (100 of 798 items)")) {
				flag = true;
				System.out.println(flag);
				break;
			}
		}
		Assert.assertEquals(flag, true);
	}

	@SuppressWarnings("unchecked")
	public void VerifyECUCExtarctDBCFile(String Project, String DBCpath) throws Exception {

		DesktopSession = Root();
		Actions act = new Actions(DesktopSession);
		Robot rb = new Robot();
		WebElement proj = DesktopSession.findElementByName(Project);
		Thread.sleep(1000);
		ExpandProject(2);
		logger.pass("Expanded");
		act.contextClick(proj).perform();
		logger.pass("Right Click the Project");
		Thread.sleep(500);
		DesktopSession.findElementByName(Pageobj.Import).click();
		logger.pass("Click the Import");
		List<WebElement> lst = DesktopSession.findElementsByName(Pageobj.C4K);
		System.out.println(lst.size());
		lst.get(1).click();
		logger.pass("Click the c4k");
		rb.keyPress(KeyEvent.VK_RIGHT);
		rb.keyRelease(KeyEvent.VK_RIGHT);
		DesktopSession.findElementByName(Pageobj.DBC).click();
		logger.pass("Click the DBC");
		DesktopSession.findElementByName(Pageobj.Next_Button).click();
		logger.pass("Click the Next button");
		DesktopSession.findElementByName(Pageobj.Browse).click();
		logger.pass("Click the browse");
		DesktopSession.findElementByName("All locations").click();
		logger.pass("Click the All location");
		Thread.sleep(1000);
		WebElement filepath = DesktopSession.findElementByName("Address");
		String select = Keys.chord(Keys.CONTROL, "a");
		act.sendKeys(filepath, select);
		act.perform();
		act.sendKeys(Keys.BACK_SPACE).perform();
		logger.pass("Click the backspace");
		act.sendKeys(DBCpath).perform();
		// DesktopSession.findElementById("1001").click();
		Thread.sleep(500);
		String arrow = "Go to " + '"' + DBCpath + '"';
		DesktopSession.findElementByName(arrow).click();
		logger.pass("Click the Arrow");
		WebElement name = DesktopSession.findElementByName("File name:");
		DesktopSession.findElementByName("Open").click();
		List<WebElement> lstedit = DesktopSession.findElementsByClassName("Edit");
		System.out.println(lstedit.size());
		lstedit.get(2).sendKeys(select);

		lstedit.get(2).sendKeys(Keys.BACK_SPACE);
		lstedit.get(2).click();
		logger.pass("Clicked dirpath");
		lstedit.get(2).sendKeys("Message List ITS2-FD.dbc");
		logger.info("Entered the value on the input field");
		Thread.sleep(1000);
		DesktopSession.findElementByName(Pageobj.Open).click();
		logger.pass("Click the Open");
		Thread.sleep(1000);
		DesktopSession.findElementByName("Open").click();
		logger.pass("Click the Open");
		DesktopSession.findElementByName("ADAS").click();
		logger.pass("Click the ADAS");
		DesktopSession.findElementByName(Pageobj.Finish_Button).click();
		logger.pass("Click the Finish Button");
		Thread.sleep(7000);
		List<WebElement> lst2 = DesktopSession.findElementsByXPath("//*[@LocalizedControlType='tree item']");
		System.out.println(lst2.size() + " --==dc=-> ");
		boolean flag = false;
		for (int j = 0; j <= lst2.size() - 1; j++) {
			String value = lst2.get(j).getAttribute("Name");
			System.out.println(value + " = - -=- > ");
			if (value.contains("DBC_ADAS_Extract_")) {
				flag = true;
				System.out.println(flag);
				break;
			} else {
				flag = true;
				System.out.println(flag);
			}

		}

		Assert.assertEquals(flag, true);
	}

	@SuppressWarnings("unchecked")
	public String VerifyProductLicence() throws Exception {

		DesktopSession = Root();
		Actions act = new Actions(DesktopSession);
		Robot rb = new Robot();
		DesktopSession.findElementByName(Pageobj.Help).click();
		logger.pass("Click the Help");
		DesktopSession.findElementByName("About C4K").click();
		logger.pass("Click the About C4K");
		// DesktopSession.findElementByName(Pageobj.AboutKsar).click();
		List<WebElement> lst = DesktopSession.findElementsByXPath("//*[@LocalizedControlType='edit']");
		System.out.println(lst.size());
		String exactvalue = "";
		for (int i = 0; i <= lst.size() - 1; i++) {

			System.out.println(lst.get(i).getAttribute("Value.Value") + "  =-=-=-98==-> ");
			// compose for K-SAR
			String value = lst.get(i).getAttribute("Value.Value");
			if (value.contains("ECU Configuration Tool for AUTOSAR R4.3.1")) {

				exactvalue = lst.get(i).getAttribute("Value.Value");
				System.out.println(exactvalue + "  - =- > 6 ");

				break;
			}
		}
		exactvalue = lst.get(0).getAttribute("Value.Value");
		System.out.println(exactvalue + "  = -adssasdf= - > ");
		return exactvalue;
	}

	public void VerifyContainer(String Project) throws Exception {
		DesktopSession = Root();
		Actions act = new Actions(DesktopSession);
		Robot rb = new Robot();
		DesktopSession.findElementByName(Pageobj.View_Menu).click();
		logger.pass("Selected the View_Menu");
		DesktopSession.findElementByName(Pageobj.CustomizeView).click();
		logger.pass("Selected the CustomizeView");
		DesktopSession.findElementByName(Pageobj.HideECUParam).click();
		rb.keyPress(KeyEvent.VK_SPACE);
		logger.pass("Selected the HideECUParam");
		DesktopSession.findElementByName(Pageobj.Launch).click();
		logger.pass("Selected the Launch");
		Thread.sleep(1000);
		DesktopSession.findElementByName(Project).click();
		ExpandProject(4);
//		DesktopSession.findElementByName(Pageobj.default_arxml).click();
//		ExpandProject(3);
		DesktopSession.findElementByName(Pageobj.ARPackage).click();
		act.contextClick().perform();
		Thread.sleep(1000);
		// DesktopSession.findElementByName(Pageobj.ModuleConfigurationLabel).click();
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		rb.keyPress(KeyEvent.VK_RIGHT);
		rb.keyRelease(KeyEvent.VK_RIGHT);
		Thread.sleep(1000);
		DesktopSession.findElementByName(Pageobj.Autosar_KPIT).click();
		Thread.sleep(1000);
		DesktopSession.findElementByName("EcuC").click();
		Thread.sleep(1000);
		DesktopSession.findElementByName(Pageobj.ARPackage).click();
		ExpandProject(1);
		Thread.sleep(1000);
		DesktopSession.findElementByName("EcuC_0 [EcuC]").click();
		act.contextClick().perform();
		Thread.sleep(1000);
		// DesktopSession.findElementByName(Pageobj.ModuleConfigurationLabel).click();
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		rb.keyPress(KeyEvent.VK_RIGHT);
		rb.keyRelease(KeyEvent.VK_RIGHT);
		Thread.sleep(1000);
		DesktopSession.findElementByName("EcucConfigSet").click();
		Thread.sleep(500);
		DesktopSession.findElementByName("EcuC_0 [EcuC]").click();
		ExpandProject(1);
		DesktopSession.findElementByName("EcucConfigSet_0 [EcucConfigSet]").click();
		Thread.sleep(1000);
		act.contextClick().perform();
		Thread.sleep(1000);
		// DesktopSession.findElementByName(Pageobj.ModuleConfigurationLabel).click();
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		rb.keyPress(KeyEvent.VK_RIGHT);
		rb.keyRelease(KeyEvent.VK_RIGHT);
		Thread.sleep(1000);
		DesktopSession.findElementByName("EcucPduCollection").click();
		Thread.sleep(1000);
		DesktopSession.findElementByName("EcucConfigSet_0 [EcucConfigSet]").click();
		ExpandProject(1);
		Thread.sleep(500);
		DesktopSession.findElementByName("EcucPduCollection_0 [EcucPduCollection]").click();
		Thread.sleep(1000);
		ExpandProject(1);
		Thread.sleep(1000);
		act.contextClick().perform();
		Thread.sleep(1000);
		// DesktopSession.findElementByName(Pageobj.ModuleConfigurationLabel).click();
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		rb.keyPress(KeyEvent.VK_RIGHT);
		rb.keyRelease(KeyEvent.VK_RIGHT);
		Thread.sleep(1000);
		DesktopSession.findElementByName("Pdu").click();
		Thread.sleep(1000);
		DesktopSession.findElementByName("EcucPduCollection_0 [EcucPduCollection]").click();
		ExpandProject(1);
		Thread.sleep(500);
		DesktopSession.findElementByName("Pdu_0 [Pdu]").click();
		Thread.sleep(1000);
		act.contextClick().perform();
		Thread.sleep(1000);
		// DesktopSession.findElementByName(Pageobj.ModuleConfigurationLabel).click();
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		rb.keyPress(KeyEvent.VK_RIGHT);
		rb.keyRelease(KeyEvent.VK_RIGHT);
		Thread.sleep(1000);
		DesktopSession.findElementByName("EcucPduDedicatedPartition").click();
		Thread.sleep(1000);
		DesktopSession.findElementByName("Pdu_0 [Pdu]").click();
		Thread.sleep(1000);
		ExpandProject(1);
		DesktopSession.findElementByName("EcucPduDedicatedPartition_0 [EcucPduDedicatedPartition]").click();
		Thread.sleep(1000);
		act.contextClick().perform();
		Thread.sleep(1000);
		// DesktopSession.findElementByName(Pageobj.ModuleConfigurationLabel).click();
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		rb.keyPress(KeyEvent.VK_RIGHT);
		rb.keyRelease(KeyEvent.VK_RIGHT);
		Thread.sleep(1000);
		DesktopSession.findElementByName("EcucPduDedicatedPartitionRef").click();
		Thread.sleep(1000);
		DesktopSession.findElementByName("EcucPduDedicatedPartition_0 [EcucPduDedicatedPartition]").click();
		Thread.sleep(1000);
		act.contextClick().perform();
		Thread.sleep(1000);
		// DesktopSession.findElementByName(Pageobj.ModuleConfigurationLabel).click();
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		rb.keyPress(KeyEvent.VK_RIGHT);
		rb.keyRelease(KeyEvent.VK_RIGHT);
		Thread.sleep(1000);
		DesktopSession.findElementByName("EcucPduDedicatedPartitionRef").click();
		Thread.sleep(1000);
		DesktopSession.findElementByName("EcucPduDedicatedPartition_0 [EcucPduDedicatedPartition]").click();
		ExpandProject(1);
		// EcucPduDedicatedPartitionRef [EcucReferenceValue]
		boolean flag = false;
		flag = DesktopSession.findElementByName("EcucPduDedicatedPartitionRef [2]").isDisplayed();
		System.out.println(flag + " ddd==-=-=-=-=> ");
	}

	@SuppressWarnings("unchecked")
	public void SortingValidation(String project) throws Exception {

		DesktopSession = Root();
		Actions act = new Actions(DesktopSession);
		Robot rb = new Robot();
		DesktopSession.findElementByName(project).click();
		logger.pass("Click the Project");
		act.contextClick().perform();
		logger.pass("Right Click the Project");
		Thread.sleep(500);
		DesktopSession.findElementByName(Pageobj.ClearValidation).click();
		logger.pass("Click the Clear Validation");
		Thread.sleep(500);
		act.contextClick().perform();
		logger.pass("Right Click the Project");
		Thread.sleep(500);
		DesktopSession.findElementByName(Pageobj.BatchValidation).click();
		logger.pass("Clicked the Batch Validation");
		int i = 0;
		while (i <= 7) {
			System.out.println(i);
			logger.pass("Waiting");
			Thread.sleep(2000);
			rb.keyPress(KeyEvent.VK_ENTER);
			rb.keyRelease(KeyEvent.VK_ENTER);
			logger.pass("Clicked the Enter");
			if (DesktopSession.findElementByName("Export Validation Report").isEnabled()) {

				break;
			} else {
				Thread.sleep(2000);
			}
			i++;
		}
		Thread.sleep(5000);
		Map<Integer, String> map = new HashMap<Integer, String>();
		Map<Integer, String> map2 = new HashMap<Integer, String>();
		List<WebElement> lst1 = DesktopSession.findElementsByName("Validation");
		System.out.println(lst1.size() + " =-0-=--=-> ");
		WebElement validationTab = lst1.get(2);
		// act.doubleClick(validationTab).perform();
		act.doubleClick(validationTab).perform();
		logger.pass("Double Clicked the Validation Tab");
		List<WebElement> lst = DesktopSession.findElementsByXPath("//*[@LocalizedControlType = 'tree item']");
		System.out.println(lst.size());
		for (int j = 0; j <= lst.size() - 1; j++) {
			System.out.println(lst.get(j).getAttribute("Name") + " =-=-=---> " + j);
			String errors = lst.get(j).getAttribute("Name");
			if (errors.contains("WRN") || errors.contains("INF") || errors.contains("ERR")) {
				map.put(j, errors);
			}
		}
		System.out.println(map + " ---------------------------->          ");
		WebElement description = DesktopSession.findElementByName("Description");
		act.doubleClick(description).perform();
		logger.pass("doubleClick the description");
		Thread.sleep(500);
		act.doubleClick(description).perform();
		logger.pass("doubleClick the description");
		Thread.sleep(1000);
		List<WebElement> lst2 = DesktopSession.findElementsByXPath("//*[@LocalizedControlType = 'tree item']");
		System.out.println(lst2.size());
		for (int l = 0; l <= lst2.size() - 1; l++) {
			System.out.println(lst2.get(l).getAttribute("Name") + " =-=-=---> " + l);
			String errors = lst.get(l).getAttribute("Name");
			if (errors.contains("WRN") || errors.contains("INF") || errors.contains("ERR")) {
				map2.put(l, errors);
			}
		}
		System.out.println(map2 + "  =========================>  ");

		String Firstele = map.get(0);
		System.out.println(Firstele + " =-=-->  ");
		logger.pass("First error name");
		System.out.println(map2.size() - 1);
		String Lastele = map2.get(map2.size() - 1);
		System.out.println(Lastele + " =-33=-->  ");
		logger.pass("Last Error name");
		Assert.assertEquals(Firstele, Lastele);

	}

	@SuppressWarnings("unchecked")
	public void SortingChildLebel(String project) throws Exception {

		DesktopSession = Root();
		Actions act = new Actions(DesktopSession);
		Robot rb = new Robot();
		DesktopSession.findElementByName(project).click();
		logger.pass("Click the Project");
		act.contextClick().perform();
		logger.pass("Right Click the Project");
		Thread.sleep(500);
		DesktopSession.findElementByName(Pageobj.ClearValidation).click();
		logger.pass("Click the Clear Validation");
		Thread.sleep(500);
		act.contextClick().perform();
		logger.pass("Right Click the Project");
		Thread.sleep(500);
		DesktopSession.findElementByName(Pageobj.BatchValidation).click();
		logger.pass("Clicked the Batch Validation");
		int i = 0;
		while (i <= 7) {
			System.out.println(i);
			logger.pass("Waiting");
			Thread.sleep(2000);
			rb.keyPress(KeyEvent.VK_ENTER);
			rb.keyRelease(KeyEvent.VK_ENTER);
			logger.pass("Clicked the Enter");
			if (DesktopSession.findElementByName("Export Validation Report").isEnabled()) {

				break;
			} else {
				Thread.sleep(2000);
			}
			i++;
		}
		Thread.sleep(5000);
		Map<Integer, String> map = new HashMap<Integer, String>();
		Map<Integer, String> map2 = new HashMap<Integer, String>();
		List<WebElement> lst1 = DesktopSession.findElementsByName("Validation");
		System.out.println(lst1.size() + " =-0-=--=-> ");
		WebElement validationTab = lst1.get(2);
		// act.doubleClick(validationTab).perform();
		act.doubleClick(validationTab).perform();
		logger.pass("Double Clicked the Validation Tab");
		List<WebElement> lst = DesktopSession.findElementsByXPath("//*[@LocalizedControlType = 'tree item']");
		System.out.println(lst.size());
		// ERR087002: Multiplicity out of Range (23 items)
		for (int j = 0; j <= lst.size() - 1; j++) {

			System.out.println(lst.get(j).getAttribute("Name") + " =-=-=---> " + j);
			String errors = lst.get(j).getAttribute("Name");
			if (errors.equalsIgnoreCase("ERR087002: Multiplicity out of Range (23 items)")) {
				lst.get(j).click();
				rb.keyPress(KeyEvent.VK_RIGHT);
				rb.keyRelease(KeyEvent.VK_RIGHT);
				break;
			}
		}
		List<WebElement> lst2 = DesktopSession.findElementsByXPath("//*[@LocalizedControlType = 'tree item']");
		System.out.println(lst2.size());
		int count = 0;
		for (int k = 0; k <= lst2.size() - 1; k++) {
			System.out.println(lst2.get(k).getAttribute("Name") + " =-=-=---> " + k);
			String errors = lst2.get(k).getAttribute("Name");
			if (errors.contains("ERR087002: Multiplicity out of Range for ")) {
				map.put(count, errors);
				count++;
			}
		}
		System.out.println(map + " -=-=-> ");
		WebElement description = DesktopSession.findElementByName("Description");
		act.doubleClick(description).perform();
		logger.pass("doubleClick the description");
		Thread.sleep(500);
		act.doubleClick(description).perform();
		logger.pass("doubleClick the description");
		Thread.sleep(500);
		act.doubleClick(description).perform();
		logger.pass("doubleClick the description");
		Thread.sleep(1000);
		List<WebElement> newlst = DesktopSession.findElementsByXPath("//*[@LocalizedControlType = 'tree item']");
		System.out.println(newlst.size());
		int countnew = 0;
		for (int m = 0; m <= newlst.size() - 1; m++) {
			System.out.println(newlst.get(m).getAttribute("Name") + " =-=-=---> " + m);
			String newerrors = newlst.get(m).getAttribute("Name");
			if (newerrors.contains("ERR087002: Multiplicity out of Range for ")) {
				map2.put(countnew, newerrors);
				countnew++;
			}
		}
		System.out.println(map2);
		System.out.println(map.get(0) + " =-99=-=> " + map2.get(0));
		String beforesort = map.get(0);
		String aftersort = map2.get(countnew - 1);
		System.out
				.println(beforesort + "  -=-=-=->909  " + aftersort + " 88888=-=> " + count + " =-=-=->  " + countnew);
		Assert.assertEquals(beforesort, aftersort);
	}

	public void basikToll_Integraate_As_Addon() throws Exception {

		DesktopSession = Root();
		Actions rightclick = new Actions(DesktopSession);
		Robot rb = new Robot();
		DesktopSession.findElementByName(Pageobj.Help).click();
		logger.pass("Clicked on help Menu Button");
		DesktopSession.findElementByName(Pageobj.InstalNewSoftwareOption).click();
		logger.pass("Clicked on InstalNewSoftwareOption Button");
		DesktopSession.findElementByName(Pageobj.AddButton).click();
		logger.pass("Clicked on AddButton Button");
		DesktopSession.findElementByName(Pageobj.LocationTextbox).click();
		logger.pass("Clicked on LocationTextbox");
		rb.keyPress(KeyEvent.VK_TAB);
		rb.keyRelease(KeyEvent.VK_TAB);
		String select = Keys.chord(Keys.CONTROL, "a");
		rightclick.sendKeys(DesktopSession.findElementByName(Pageobj.LocationTextbox), select);
		rightclick.perform();
		String filelocation = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator
				+ "com.kpit.basik.basikaddonupdatesite";
		rightclick.sendKeys(DesktopSession.findElementByName(Pageobj.LocationTextbox), "file:/" + filelocation);
		rightclick.perform();
		logger.pass("Entered the path in location textbox");
		DesktopSession.findElementByName(Pageobj.Launch).click();
		logger.pass("Clicked on OK Button");
		DesktopSession.findElementByName(Pageobj.Select_All).click();
		logger.pass("Clicked onSelect All Button");
		DesktopSession.findElementByName(Pageobj.Next_Button).click();
		logger.pass("Clicked on Next_Button Button");
		DesktopSession.findElementByName(Pageobj.Next_Button).click();
		logger.pass("Clicked on Next_Button Button");
		Thread.sleep(1000);
		DesktopSession.findElementByName(Pageobj.AcceptAgreementRadioButton).click();
		logger.pass("Clicked on AcceptAgreementRadio Button");
		DesktopSession.findElementByName(Pageobj.Finish_Button).click();
		logger.pass("Clicked on Finish Button");
		Thread.sleep(5000);
		DesktopSession.findElementByName(Pageobj.Launch).click();
		logger.pass("Clicked on OK Button");
		Thread.sleep(3000);
		DesktopSession.findElementByName(Pageobj.YesButton).click();
		logger.pass("Clicked on Yes Button");
		Thread.sleep(30000);
		boolean BaSIK_Addon_flag = DesktopSession.findElementByName(Pageobj.BaSIK_Addon).isDisplayed();
		System.out.println(BaSIK_Addon_flag);
		Assert.assertEquals(BaSIK_Addon_flag, true);
		logger.pass("Basik Addon is displayed after installation");
		Thread.sleep(3000);

	}

	public void uninstall_BasikToll_Integraate_As_Addon() throws Exception {

		DesktopSession = Root();
		Actions rightclick = new Actions(DesktopSession);
		Robot rb = new Robot();
		Thread.sleep(1000);
		List<WebElement> all = DesktopSession.findElementsByName(Pageobj.Help);
		System.out.println(all.size());
		all.get(0).click();
		// all.get(1).click();
		rightclick.moveToElement(all.get(0)).perform();
		logger.pass("Clicked on Help Button");
		Thread.sleep(500);
		DesktopSession.findElementByName(Pageobj.InstallationDetails_Option).click();
		logger.pass("Clicked on installation Detail Option");
		DesktopSession.findElementByName(Pageobj.Basikaddonfeature_option).click();
		logger.pass("Clicked on Basikaddonfeature_option");
		DesktopSession.findElementByName(Pageobj.UnistallButton).click();
		logger.pass("Clicked on uninstall Button");
		Thread.sleep(3000);
		DesktopSession.findElementByName(Pageobj.Finish_Button).click();
		logger.pass("Clicked on Finish_Button");
		Thread.sleep(3000);
		DesktopSession = Root();
		DesktopSession.findElementByName(Pageobj.YesButton).click();
		logger.pass("Clicked on Yes_Button");
		Thread.sleep(25000);
		logger.pass("Verify the BaSIK_Addon option is not displayed");

	}

	public void basikTool_Interface() throws Exception {
		DesktopSession = Root();
		Actions rightclick = new Actions(DesktopSession);
		Robot rb = new Robot();
		DesktopSession.findElementByName(Pageobj.BaSIK_Addon).click();
		logger.pass("Clicked on Basik Addon");
		DesktopSession.findElementByName(Pageobj.communicationOption).click();
		logger.pass("Clicked on communication Option");
		Thread.sleep(1000);
		boolean com = DesktopSession.findElementByName(Pageobj.communicationOptionCom).isDisplayed();
		System.out.println(com);
		Assert.assertEquals(com, true);
		logger.pass("Clicked on communication Option and COM option is visible");
		DesktopSession.findElementByName(Pageobj.Diagnosticoption).click();
		logger.pass("Clicked on Diagnostic option");
		Thread.sleep(1000);
		boolean dcm = DesktopSession.findElementByName(Pageobj.DiagnosticoptionDCM).isDisplayed();
		System.out.println(dcm);
		Assert.assertEquals(dcm, true);
		Thread.sleep(1000);
		logger.pass("Clicked on Diagnostic option DCM option is visible");
		boolean dem = DesktopSession.findElementByName(Pageobj.DiagnosticoptionDEM).isDisplayed();
		System.out.println(dem);
		Assert.assertEquals(dem, true);
		logger.pass("Clicked on Diagnostic option DEM option is visible");
		DesktopSession.findElementByName(Pageobj.BuildAcceleratorOption).click();
		Thread.sleep(1000);
		logger.pass("Clicked on BuildAccelerator Option");
		boolean oem = DesktopSession.findElementByName(Pageobj.BuildAcceleratorOCMExtracter).isDisplayed();
		System.out.println(oem);
		Assert.assertEquals(oem, true);
		logger.pass("Clicked on BuildAcceleratorOCMExtracter option OEM option is visible");
		boolean BuildAcceleratorMemmap = DesktopSession.findElementByName(Pageobj.BuildAcceleratorMemmap).isDisplayed();
		System.out.println(BuildAcceleratorMemmap);
		Assert.assertEquals(BuildAcceleratorMemmap, true);
		logger.pass("Clicked on BuildAcceleratorOCMExtracter option MEMMAP option is visible");
		DesktopSession.findElementByName(Pageobj.MemoryOption).click();
		Thread.sleep(1000);
		logger.pass("Clicked on MemoryOption DEM option is visible");
		boolean mem = DesktopSession.findElementByName(Pageobj.MemoryOptionNvm).isDisplayed();
		System.out.println(mem);
		Assert.assertEquals(mem, true);
		logger.pass("Clicked on MemoryOption MEM option is visible");
		WebElement workspace = DesktopSession.findElementByClassName(Pageobj.BlankWorkspaceArea);
		rightclick.moveToElement(workspace, 161, 244).click().perform();

	}

	public void basikToll_Reinstall() throws Exception {

		DesktopSession = Root();
		Actions rightclick = new Actions(DesktopSession);
		Robot rb = new Robot();
		DesktopSession.findElementByName(Pageobj.Help).click();
		logger.pass("Clicked on help Menu Button");
		DesktopSession.findElementByName(Pageobj.InstalNewSoftwareOption).click();
		logger.pass("Clicked on InstalNewSoftwareOption Button");
		DesktopSession.findElementByName(Pageobj.AddButton).click();
		logger.pass("Clicked on AddButton Button");
		DesktopSession.findElementByName(Pageobj.LocationTextbox).click();
		logger.pass("Clicked on LocationTextbox");
		rb.keyPress(KeyEvent.VK_TAB);
		rb.keyRelease(KeyEvent.VK_TAB);
		String select = Keys.chord(Keys.CONTROL, "a");
		rightclick.sendKeys(DesktopSession.findElementByName(Pageobj.LocationTextbox), select);
		rightclick.perform();
		String filelocation = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator
				+ "com.kpit.basik.basikaddonupdatesite";
		rightclick.sendKeys(DesktopSession.findElementByName(Pageobj.LocationTextbox), "file:/" + filelocation);
		rightclick.perform();
		logger.pass("Entered the path in location textbox");
		DesktopSession.findElementByName(Pageobj.Launch).click();
		logger.pass("Clicked on OK Button");
		DesktopSession.findElementByName(Pageobj.Select_All).click();
		logger.pass("Clicked onSelect All Button");
		DesktopSession.findElementByName(Pageobj.Next_Button).click();
		logger.pass("Clicked on Next_Button Button");
		DesktopSession.findElementByName(Pageobj.Next_Button).click();
		logger.pass("Clicked on Next_Button Button");
		DesktopSession.findElementByName(Pageobj.AcceptAgreementRadioButton).click();
		logger.pass("Clicked on AcceptAgreementRadio Button");
		DesktopSession.findElementByName(Pageobj.Finish_Button).click();
		logger.pass("Clicked on Finish Button");
		Thread.sleep(5000);
		DesktopSession.findElementByName(Pageobj.Launch).click();
		logger.pass("Clicked on OK Button");
		Thread.sleep(5000);
		DesktopSession = Root();
		DesktopSession.findElementByName(Pageobj.YesButton).click();
		logger.pass("Clicked on Yes Button");
		Thread.sleep(30000);
		DesktopSession = Root();
		boolean BaSIK_Addon_flag = DesktopSession.findElementByName(Pageobj.BaSIK_Addon).isDisplayed();
		System.out.println(BaSIK_Addon_flag);
		Assert.assertEquals(BaSIK_Addon_flag, true);
		logger.pass("Basik Addon is displayed after installation");
		Thread.sleep(3000);
		DesktopSession.findElementByName(Pageobj.BaSIK_Addon).click();
		logger.pass("Clicked on Basik Addon");
		DesktopSession.findElementByName(Pageobj.Diagnosticoption).click();
		logger.pass("Clicked on Diagnostic option");
		Thread.sleep(1000);
		boolean dcm = DesktopSession.findElementByName(Pageobj.DiagnosticoptionDCM).isDisplayed();
		System.out.println(dcm);
		Assert.assertEquals(dcm, true);
		logger.pass("Diagnosticoption DCM option is visible");
		Thread.sleep(1000);
		boolean dem = DesktopSession.findElementByName(Pageobj.DiagnosticoptionDEM).isDisplayed();
		System.out.println(dem);
		Assert.assertEquals(dem, true);
		logger.pass("Diagnosticoption DEM option is visible");

	}

	public void code_Generation(String Project) throws Exception {

		DesktopSession = Root();
		Actions act = new Actions(DesktopSession);
		Robot rb = new Robot();
		WebElement proj = DesktopSession.findElementByName(Project);
		proj.click();
		logger.pass("Click the Project");
		act.contextClick(proj).perform();
		Thread.sleep(1000);
		DesktopSession.findElementByName(Pageobj.PccrGenerateCode).click();
		DesktopSession.findElementByName(Pageobj.MemifOption).click();
		rb.keyPress(KeyEvent.VK_SPACE);
		DesktopSession.findElementByName(Pageobj.Output_LocationTextbox).click();
		DesktopSession.findElementByName(Pageobj.Finish_Button).click();
		Thread.sleep(10000);

	}

	public boolean ValidateExtensionsFiles(String loc, String extn) {

		SearchFiles files = new SearchFiles(extn);

		File folder = new File(loc);

		if (folder.isDirectory() == false) {
			System.out.println("Folder does not exists: " + loc);
			return false;
		}

		String[] list = folder.list(files);

		if (list.length == 0) {
			System.out.println("There are no files with " + extn + " Extension");
			return false;
		}

		for (String file : list) {
			String temp = new StringBuffer(loc).append(File.separator).append(file).toString();
			System.out.println("file : " + temp);
			logger.pass("file : " + temp);
		}
		return true;
	}

	public class SearchFiles implements FilenameFilter {

		private String ext;

		public SearchFiles(String ext) {
			this.ext = ext;
		}

		public boolean accept(File loc, String name) {
			if (name.lastIndexOf('.') > 0) {
				// get last index for '.'
				int lastIndex = name.lastIndexOf('.');
				// get extension
				String str = name.substring(lastIndex);
				// matching extension
				if (str.equalsIgnoreCase(ext)) {
					return true;
				}
			}
			return false;

		}
	}

	public void installPCCR_As_Addon_Validation() throws Exception {

		DesktopSession = Root();
		Actions act = new Actions(DesktopSession);
		Robot rb = new Robot();
		DesktopSession.findElementByName(Pageobj.Help).click();
		logger.pass("Clicked on Help Button");
		DesktopSession.findElementByName(Pageobj.InstallationDetails_Option).click();
		logger.pass("Clicked on installation Detail Option");

		WebElement pccr = DesktopSession.findElementByName(Pageobj.PreCompile_Check_Option);
		DesktopSession.findElementByName(Pageobj.uninstall_Check_Option).click();
		int i = 0;
		while (i <= 50) {
			System.out.println(i);
			logger.info("scrolling");
			Thread.sleep(500);
			if (pccr.isDisplayed()) {
				rb.keyPress(KeyEvent.VK_DOWN);
				Thread.sleep(500);
				break;
			} else {
				rb.keyPress(KeyEvent.VK_DOWN);
				Thread.sleep(500);
			}
			i++;
		}
		String NextLink = pccr.getText();
		System.out.println(NextLink);

		boolean pccr_Addon_flag;
		try {
			pccr_Addon_flag = DesktopSession.findElementByName(Pageobj.PreCompile_Check_Option).isDisplayed();
			System.out.println(pccr_Addon_flag);
		} catch (Exception e) {
			pccr_Addon_flag = true;
			System.out.println(pccr_Addon_flag);
		}
		Assert.assertEquals(pccr_Addon_flag, true);
		logger.pass("Verify the pccr_Addon_flag option is displayed");

		System.out.println(DesktopSession.findElementByName(Pageobj.PreCompile_Check_Option).isDisplayed());
		logger.pass("Clicked on PreCompile_Check_Option");
		logger.pass("Verify the PCCR_Addon option is displayed");

	}

	public void pccR_Install_As_Addon() throws Exception {

		DesktopSession = Root();
		Actions rightclick = new Actions(DesktopSession);
		Robot rb = new Robot();
		DesktopSession.findElementByName(Pageobj.Help).click();
		logger.pass("Clicked on help Menu Button");
		DesktopSession.findElementByName(Pageobj.InstalNewSoftwareOption).click();
		logger.pass("Clicked on InstalNewSoftwareOption Button");
		DesktopSession.findElementByName(Pageobj.AddButton).click();
		logger.pass("Clicked on AddButton Button");
		DesktopSession.findElementByName(Pageobj.LocationTextbox).click();
		logger.pass("Clicked on LocationTextbox");
		rb.keyPress(KeyEvent.VK_TAB);
		rb.keyRelease(KeyEvent.VK_TAB);
		String select = Keys.chord(Keys.CONTROL, "a");
		rightclick.sendKeys(DesktopSession.findElementByName(Pageobj.LocationTextbox), select);
		rightclick.perform();
		String filelocation = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator
				+ "com.kpit.c4k.tools.pccr.updatesite";
		rightclick.sendKeys(DesktopSession.findElementByName(Pageobj.LocationTextbox), "file:/" + filelocation);
		rightclick.perform();
		logger.pass("Entered the path in location textbox");
		DesktopSession.findElementByName(Pageobj.Launch).click();
		logger.pass("Clicked on OK Button");
		DesktopSession.findElementByName(Pageobj.Select_All).click();
		logger.pass("Clicked onSelect All Button");
		DesktopSession.findElementByName(Pageobj.Next_Button).click();
		logger.pass("Clicked on Next_Button Button");
		DesktopSession.findElementByName(Pageobj.Next_Button).click();
		logger.pass("Clicked on Next_Button Button");
		DesktopSession.findElementByName(Pageobj.AcceptAgreementRadioButton).click();
		logger.pass("Clicked on AcceptAgreementRadio Button");
		DesktopSession.findElementByName(Pageobj.Finish_Button).click();
		logger.pass("Clicked on Finish Button");
		Thread.sleep(5000);
		DesktopSession.findElementByName(Pageobj.Launch).click();
		logger.pass("Clicked on OK Button");
		Thread.sleep(3000);
		DesktopSession.findElementByName(Pageobj.YesButton).click();
		logger.pass("Clicked on Yes Button");
		Thread.sleep(20000);

	}

	public void ImportArxmlFile(String Project, String filepath) throws Exception {
		DesktopSession = Root();
		Thread.sleep(3000);
		Actions act = new Actions(DesktopSession);
		Robot rb = new Robot();
		WebElement proj = DesktopSession.findElementByName(Project);
		proj.click();
		logger.pass("Click the Project");
		act.contextClick(proj).perform();
		Thread.sleep(1000);
		DesktopSession.findElementByName(Pageobj.Import).click();
		logger.pass("Clicked On Import");
		DesktopSession.findElementByName(Pageobj.General_Folder).click();
		logger.pass("Click the General_Folder");
		rb.keyPress(KeyEvent.VK_RIGHT);
		Thread.sleep(1000);
		DesktopSession.findElementByName(Pageobj.Import_FileSystem).click();
		logger.pass("Click the Import_FileSystem");
		DesktopSession.findElementByName(Pageobj.Next_Button).click();
		logger.pass("Click the Next_Button");
		DesktopSession.findElementByName(Pageobj.File_Directory).click();
		logger.pass("Click the File_Directory");
		WebElement Inputfilepath = DesktopSession.findElementByName(Pageobj.File_Directory);
		act.sendKeys(Inputfilepath, filepath).perform();
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		rb.keyPress(KeyEvent.VK_SPACE);
		Thread.sleep(500);
		DesktopSession.findElementByName(Pageobj.Finish_Button).click();
		logger.pass("Click the Finish_Button");
		Thread.sleep(4000);
		rb.keyPress(KeyEvent.VK_RIGHT);
		Thread.sleep(1000);
		boolean EcuExtractFile = DesktopSession.findElementByName(Pageobj.EcuExtractFileName).isDisplayed();
		System.out.println(EcuExtractFile);
		Assert.assertEquals(EcuExtractFile, true);
		logger.pass("EcuExtractFile option is visible");
		DesktopSession.findElementByName(Pageobj.EcuExtractFileName).click();
		rb.keyPress(KeyEvent.VK_RIGHT);
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyPress(KeyEvent.VK_RIGHT);
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyPress(KeyEvent.VK_RIGHT);
		Thread.sleep(3000);
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyPress(KeyEvent.VK_RIGHT);
		Thread.sleep(500);
		boolean VariationpointOption = DesktopSession.findElementByName(Pageobj.VariationpointOption).isDisplayed();
		System.out.println(VariationpointOption);
		Assert.assertEquals(VariationpointOption, true);
		WebElement var = DesktopSession.findElementByName(Pageobj.VariationpointOption);
		act.click(var).build().perform();
		act.contextClick(var).build().perform();
		DesktopSession.findElementByName(Pageobj.CopyOption).click();
		WebElement als = DesktopSession.findElementByName(Pageobj.ALS_CMD);
		act.click(als).build().perform();
		act.contextClick(als).build().perform();
		DesktopSession.findElementByName(Pageobj.PasteOption).click();
		Thread.sleep(1000);
		rb.keyPress(KeyEvent.VK_RIGHT);
		Thread.sleep(500);
		boolean VariationpointOptionAfterPaste = DesktopSession.findElementByName(Pageobj.VariationpointOption)
				.isDisplayed();
		System.out.println(VariationpointOptionAfterPaste);
		Assert.assertEquals(VariationpointOptionAfterPaste, true);
	}

	public void IntegratorBswmdVerification(String Project) throws Exception {

		DesktopSession = Root();
		Actions act = new Actions(DesktopSession);
		Robot rb = new Robot();
		SoftAssert softAssert = new SoftAssert();
		WebElement proj = DesktopSession.findElementByName(Project);
		proj.click();
		logger.pass("Clicked the Project");
		act.contextClick(proj).perform();
		logger.pass("Right Clicked the Project");
		Thread.sleep(1000);
		boolean flag = DesktopSession.findElementByName(Pageobj.Properties_Tab).isEnabled();
		Assert.assertEquals(true, flag);
		logger.pass("Verified the Properties tab is enabled");
		DesktopSession.findElementByName(Pageobj.Properties_Tab).click();
		logger.pass("Clicked the properties Tab");
		DesktopSession.findElementByName(Pageobj.Module_Defination).click();
		logger.pass("Clicked the Module Defination Option");
		DesktopSession.findElementByName(Pageobj.Module_Defination_File1).click();
		rb.keyPress(KeyEvent.VK_SPACE);
		Thread.sleep(100);
		rb.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		logger.pass("Clicked the Module Defination file1");
		WebElement AR1124 = DesktopSession.findElementByName(Pageobj.Project_Folder);
		act.doubleClick(AR1124).perform();
		WebElement bswmdFolder = DesktopSession.findElementByName(Pageobj.BSWMD_Folder);
		act.click(bswmdFolder).perform();
		act.doubleClick(bswmdFolder).perform();
		boolean bswmd = DesktopSession.findElementByName(Pageobj.BSWMD_Folder).isDisplayed();
		Assert.assertEquals(bswmd, true);
		logger.pass("Verify the foldername created");
		boolean CanIf_BSWMD = DesktopSession.findElementByName(Pageobj.Module_Defination_File1).isDisplayed();
		softAssert.assertEquals(CanIf_BSWMD, true);
		logger.pass("Verify the File1 created");
		bswmdFolder.click();
		act.contextClick(bswmdFolder).perform();
		logger.pass("Right click on bswmdFolder");
		Thread.sleep(500);
		boolean merge_Files;
		try {
			merge_Files = DesktopSession.findElementByName(Pageobj.Merge_Files).isDisplayed();
			System.out.println(merge_Files);
		} catch (Exception e) {
			merge_Files = false;
			System.out.println(merge_Files);
		}

		Assert.assertEquals(false, merge_Files);

		logger.pass("Verify the merge file option is not displayed");

	}

	public String CreateProjectAndNewFolderBswmd(String ProjectName, String folderName) throws Exception {
		DesktopSession = Root();
		Robot rb = new Robot();
		Actions rightclick = new Actions(DesktopSession);

		DesktopSession.findElementByName(Pageobj.File).click();
		logger.pass("Clicked On File");
		DesktopSession.findElementByName(Pageobj.New).click();
		logger.pass("Clicked On New");
		DesktopSession.findElementByName(Pageobj.Project).click();
		logger.pass("Clicked On Project");
		DesktopSession.findElementByName(Pageobj.Autosar).click();
		logger.pass("Clicked On Autosar");
		rb.keyPress(KeyEvent.VK_RIGHT);
		DesktopSession.findElementByName(Pageobj.NewAutosar).click();
		logger.pass("Clicked On NewAutosar");
		DesktopSession.findElementByName(Pageobj.Next_Button).click();
		logger.pass("Clicked On NextButton");
		WebElement Project = DesktopSession.findElementByName(Pageobj.ProjectName);
		rightclick.click(Project);
		rightclick.perform();
		logger.pass("Click on the Project");
		Thread.sleep(10000);
		String select = Keys.chord(Keys.CONTROL, "a");
		rightclick.sendKeys(Project, select);
		rightclick.perform();
		rightclick.sendKeys(Project, ProjectName);
		rightclick.perform();
		logger.pass("entered the ProjectName");
		DesktopSession.findElementByName(Pageobj.Finish_Button).click();
		Thread.sleep(8000);
		DesktopSession = Root();
		WebElement proj = DesktopSession.findElementByName(Pageobj.IntergratorBswmd);
		proj.click();
		logger.pass("Clicked the Project");
		rightclick.contextClick().perform();
		Thread.sleep(500);
		logger.pass("Right Clicked the Project");
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyPress(KeyEvent.VK_ENTER);
		logger.pass("Clicked On New");
		Thread.sleep(500);
		DesktopSession.findElementByName(Pageobj.ProjectFolderCreation).click();
		logger.pass("Clicked On Folder Option");
		Thread.sleep(500);
		WebElement FolderName = DesktopSession.findElementByName(Pageobj.ProjectFolderName);
		FolderName.click();
		rightclick.sendKeys(folderName).perform();
		DesktopSession.findElementByName(Pageobj.Finish_Button).click();
		Thread.sleep(500);

		return ProjectName;

	}

	public String NewCreateProjectAndNewFolderBswmd(String ProjectName, String folderName) throws Exception {
		DesktopSession = Root();
		Robot rb = new Robot();
		Actions rightclick = new Actions(DesktopSession);

		DesktopSession.findElementByName(Pageobj.File).click();
		logger.pass("Clicked On File");
		DesktopSession.findElementByName(Pageobj.New).click();
		logger.pass("Clicked On New");
		DesktopSession.findElementByName(Pageobj.Project).click();
		logger.pass("Clicked On Project");
		DesktopSession.findElementByName(Pageobj.General_Folder).click();
		logger.pass("Clicked On General_Folder");
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		rb.keyPress(KeyEvent.VK_RIGHT);
		rb.keyRelease(KeyEvent.VK_RIGHT);
		DesktopSession.findElementByName("ECU Configuration Project").click();
		logger.pass("Clicked On NewAutosar");
		DesktopSession.findElementByName(Pageobj.Next_Button).click();
		logger.pass("Clicked On NextButton");
		WebElement Project = DesktopSession.findElementByName(Pageobj.ProjectName);
		rightclick.click(Project);
		rightclick.perform();
		logger.pass("Click on the Project");
		Thread.sleep(10000);
		String select = Keys.chord(Keys.CONTROL, "a");
		rightclick.sendKeys(Project, select);
		rightclick.perform();
		rightclick.sendKeys(Project, ProjectName);
		rightclick.perform();
		logger.pass("entered the ProjectName");
		DesktopSession.findElementByName(Pageobj.Finish_Button).click();
		Thread.sleep(8000);
		DesktopSession = Root();
		WebElement proj = DesktopSession.findElementByName(Pageobj.IntergratorBswmd);
		proj.click();
		logger.pass("Clicked the Project");
		rightclick.contextClick().perform();
		Thread.sleep(500);
		logger.pass("Right Clicked the Project");
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyPress(KeyEvent.VK_ENTER);
		logger.pass("Clicked On New");
		Thread.sleep(500);
		DesktopSession.findElementByName(Pageobj.ProjectFolderCreation).click();
		logger.pass("Clicked On Folder Option");
		Thread.sleep(500);
		WebElement FolderName = DesktopSession.findElementByName(Pageobj.ProjectFolderName);
		FolderName.click();
		rightclick.sendKeys(folderName).perform();
		DesktopSession.findElementByName(Pageobj.Finish_Button).click();
		Thread.sleep(500);

		return ProjectName;

	}

	public void propertiesEnabledVerificationBswmd(String Project) throws Exception {

		DesktopSession = Root();
		Actions act = new Actions(DesktopSession);
		Robot rb = new Robot();
		SoftAssert softAssert = new SoftAssert();
		WebElement proj = DesktopSession.findElementByName(Project);
		proj.click();
		logger.pass("Clicked the Project");
		act.contextClick(proj).perform();
		logger.pass("Right Clicked the Project");
		Thread.sleep(1000);
		boolean flag = DesktopSession.findElementByName(Pageobj.Properties_Tab).isEnabled();
		Assert.assertEquals(true, flag);
		logger.pass("Verified the Properties tab is enabled");
		DesktopSession.findElementByName(Pageobj.Properties_Tab).click();
		logger.pass("Clicked the properties Tab");
		DesktopSession.findElementByName(Pageobj.Module_Defination).click();
		logger.pass("Clicked the Module Defination Option");
		DesktopSession.findElementByName(Pageobj.Module_Defination_File1).click();
		rb.keyPress(KeyEvent.VK_SPACE);
		Thread.sleep(100);
		rb.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		logger.pass("Clicked the Module Defination file1");
		WebElement AR1124 = DesktopSession.findElementByName(Pageobj.Project_Folder_);
		WebElement bswmdFolder = DesktopSession.findElementByName(Pageobj.BSWMD_Folder);
		DesktopSession.findElementByName(Pageobj.BSWMD_Folder).click();
		rb.keyPress(KeyEvent.VK_RIGHT);
		Thread.sleep(200);
		boolean bswmd = DesktopSession.findElementByName(Pageobj.BSWMD_Folder).isDisplayed();
		Assert.assertEquals(bswmd, true);
		logger.pass("Verify the foldername created");
		boolean CanIf_BSWMD = DesktopSession.findElementByName(Pageobj.Module_Defination_File1).isDisplayed();
		softAssert.assertEquals(CanIf_BSWMD, true);
		logger.pass("Verify the File1 created");

		WebElement IntegratorBswmdFolder = DesktopSession.findElementByName(Pageobj.IntegratorBswmdFolder);
		IntegratorBswmdFolder.click();
		logger.pass("Clicked the IntegratorBswmdFolder");
		act.contextClick(IntegratorBswmdFolder).perform();
		logger.pass("Right Clicked the IntegratorBswmdFolder");
		Thread.sleep(500);
		DesktopSession.findElementByName(Pageobj.MergeBswmdOption).click();
		Thread.sleep(1000);
		boolean MergeBswmdOptionmessage = DesktopSession.findElementByName(Pageobj.MergeBswmdOptionmessage)
				.isDisplayed();
		Assert.assertEquals(MergeBswmdOptionmessage, true);
		DesktopSession.findElementByName(Pageobj.Launch).click();

	}

	@SuppressWarnings("unchecked")
	public String Generate_ECU_Report(String project, String Reportpath, String reportType, String Filename)
			throws Exception {

		DesktopSession = Root();
		Actions act = new Actions(DesktopSession);
		Robot rb = new Robot();
		DesktopSession.findElementByName(project).click();
		logger.pass("Click the Project");
		ExpandProject(2);
		logger.pass("expand Project");
		DesktopSession.findElementByName(Filename).click();
		logger.pass("Click the Filename");
		act.contextClick().perform();
		logger.pass("Click the Filename");
		Thread.sleep(500);
		DesktopSession.findElementByName(Pageobj.ECU_Report).click();
		logger.pass("Click the ECU_Report");
		Thread.sleep(500);
		DesktopSession.findElementByName(Pageobj.Browse).click();
		DesktopSession.findElementByName(Pageobj.Folder_Browse).click();
		List<WebElement> lst = DesktopSession.findElementsByXPath("//*[@LocalizedControlType='edit']");
		System.out.println(lst.size());
		String select = Keys.chord(Keys.CONTROL, "a");
		lst.get(0).sendKeys(select);
		logger.pass("Cntrl All");
		lst.get(0).sendKeys(Keys.BACK_SPACE);
		logger.pass("Backspace ");
		lst.get(0).sendKeys(Reportpath);
		logger.pass("Entering report path");
		Thread.sleep(1000);
		DesktopSession.findElementByName("OK").click();
		logger.pass("Click OK");
		// Destination File Path*:
		List<WebElement> lst1 = DesktopSession.findElementsByXPath("//*[@LocalizedControlType='edit']");
		System.out.println(lst1.size());
		for (int i = 0; i <= lst1.size() - 1; i++) {

			String value = lst1.get(i).getAttribute("Name");
			System.out.println(value + " =-=-=>  " + i);
		}

		String filepath = lst1.get(0).getAttribute("Value.Value");
		logger.pass("filepath " + filepath);
		System.out.println(filepath);
		DesktopSession.findElementByName("Open").click();
		logger.pass("Click the Open");
		DesktopSession.findElementByName(reportType).click();
		logger.pass("Click the report type");
		DesktopSession.findElementByName(Pageobj.Generate_Button).click();
		logger.pass("Click the Generate_Button");
		try {
			DesktopSession.findElementByName("OK").click();
			logger.pass("Click OK");
		} catch (Exception e) {
			System.out.println(e);
		}
		{

			System.out.println("No such Ok button");
		}
		return filepath;
	}

	public void DeleteFileInsideFolder(String filepath) {

		File file = new File(filepath);

		if (file.delete()) {
			System.out.println("File deleted successfully");
		} else {
			System.out.println("Failed to delete the file");
		}

	}

	public void VerifyHTMLReport(String Reportpath) throws Exception {

		DesktopSession = Root();
		String reportpath = Reportpath + File.separator + "RHS_ECU_Extract_Report.html";

		String chromePath = System.getProperty("user.dir") + File.separator + "chomedriver";
		System.setProperty("webdriver.chrome.driver", chromePath + File.separator + "chromedriver.exe");
		logger.pass("Chrome configuration");
		WebDriver driver = new ChromeDriver();
		driver.get(reportpath);
		logger.pass("Navigate to repot html file");
		driver.manage().window().maximize();
		logger.pass("maximize the browser");
		boolean Isignal = driver.findElement(By.xpath("//*[text()='ISignalIPdu_ADB_ECU_RightLampCMD_CAN00']"))
				.isDisplayed();
		boolean CanFrame = driver.findElement(By.xpath("//*[text()='CanFrame_ADB_ECU_RightLampCMD_CAN00']"))
				.isDisplayed();
		boolean CanCommunication = driver
				.findElement(By
						.xpath("//*[text()='CanCommunicationController_RHS_HongQi_C100_LDC_ADB_LHS_RHS_LRS_RRS_CAN']"))
				.isDisplayed();
		Assert.assertEquals(CanFrame, true);
		Assert.assertEquals(CanCommunication, true);
		Assert.assertEquals(Isignal, true);
		driver.close();
	}

	public void VerifyEcuCHTMLReport(String Reportpath) throws Exception {

		DesktopSession = Root();
		String reportpath = Reportpath + File.separator + "Daimler_extract_Report.html";
		String chromePath = System.getProperty("user.dir") + File.separator + "chomedriver";
		System.setProperty("webdriver.chrome.driver", chromePath + File.separator + "chromedriver.exe");
		logger.pass("Chrome configuration");
		WebDriver driver = new ChromeDriver();
		try {
			driver.get(reportpath);
			logger.pass("Navigate to repot html file");
			driver.manage().window().maximize();
			logger.pass("maximize the browser");
			String Controller = driver.findElement(By.xpath("//th[@id='TableMainHed'][1]")).getText();
			String FrameName = driver.findElement(By.xpath("//th[@id='TableMainHed'][2]")).getText();
			String PduName = driver.findElement(By.xpath("//th[@id='TableMainHed'][3]")).getText();
			String FrameDirection = driver.findElement(By.xpath("//th[@id='TableMainHed'][4]")).getText();
			String Identifier = driver.findElement(By.xpath("//th[@id='TableMainHed'][5]")).getText();
			String TrueTXMode = driver.findElement(By.xpath("//th[@id='TableMainHed'][6]")).getText();
			String FalseTXMode = driver.findElement(By.xpath("//th[@id='TableMainHed'][7]")).getText();
			String BaseCycle = driver.findElement(By.xpath("//th[@id='TableMainHed'][8]")).getText();
			String RepetitionCycle = driver.findElement(By.xpath("//th[@id='TableMainHed'][9]")).getText();
			String Periodicity = driver.findElement(By.xpath("//th[@id='TableMainHed'][10]")).getText();
			String Offset = driver.findElement(By.xpath("//th[@id='TableMainHed'][11]")).getText();
			String ISignalGroup = driver.findElement(By.xpath("//th[@id='TableMainHed'][12]")).getText();
			String ISignals = driver.findElement(By.xpath("//th[@id='TableMainHed'][13]")).getText();
			String SignalRange = driver.findElement(By.xpath("//th[@id='TableMainHed'][14]")).getText();
			Assert.assertEquals(Controller, "Controller");
			Assert.assertEquals(FrameName, "FrameName");
			Assert.assertEquals(PduName, "PduName");
			Assert.assertEquals(FrameDirection, "FrameDirection");
			Assert.assertEquals(ISignalGroup, "ISignal-Group");
			Assert.assertEquals(ISignals, "ISignals");
			Assert.assertEquals(SignalRange, "Signal-Range");
			Assert.assertEquals(Periodicity, "Periodicity");
			Assert.assertEquals(Offset, "Offset");
			Assert.assertEquals(FalseTXMode, "FalseTXMode");
		} finally {
			driver.close();
		}
	}

	public void VerifyMessage(String project, String filename) throws Exception {

		DesktopSession = Root();
		Actions act = new Actions(DesktopSession);
		Robot rb = new Robot();
		DesktopSession.findElementByName(project).click();
		logger.pass("Click the Project");
		ExpandProject(2);
		logger.pass("expand Project");
		DesktopSession.findElementByName(filename).click();
		logger.pass("Click file");
		ExpandProject(7);
		logger.pass("expand File");
		WebElement element = DesktopSession.findElementByName("DefaultEcucValueCollection [EcucValueCollection]");
		act.doubleClick(element).perform();
		logger.pass("Double click file");
		boolean flag = DesktopSession.findElementByName("No editor is available to open the selected element type.")
				.isDisplayed();
		System.out.println(flag + " = - - - = > ");
		DesktopSession.findElementByName("OK").click();
		logger.pass("Click OK");
		Assert.assertEquals(flag, true);
	}

	@SuppressWarnings("unchecked")
	public void VerifyRefernceObject(String project, String filename) throws Exception {

		DesktopSession = Root();
		Actions act = new Actions(DesktopSession);
		Robot rb = new Robot();
		DesktopSession.findElementByName(project).click();
		logger.pass("Click the Project");
		ExpandProject(9);
		logger.pass("Expand the Project");
		DesktopSession.findElementByName("CanIf_0 [CanIf]").click();
		logger.pass("Click the CanIf");
		ExpandProject(2);
		logger.pass("Expand the Project");
		WebElement canif = DesktopSession.findElementByName("CanIfCtrlDrvCfg_0 [CanIfCtrlDrvCfg]");
		act.doubleClick(canif).perform();
		logger.pass("Double Click on the CanIfCtrlDrvCfg_0");
		Thread.sleep(1000);
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		logger.pass("Click the down button");
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		logger.pass("Click the down button");
		List<WebElement> lst = DesktopSession.findElementsByName("CanIfCtrlDrvInitHohConfigRef");
		System.out.println(lst.size() + " =-=-=-=-=-=->   ");
		rb.keyPress(KeyEvent.VK_CONTROL);
		logger.pass("Click the cntrl button");
		lst.get(4).click();
		logger.pass("Click the CanIfInitHohCfg_0 [CanIfInitHohCfg]");
		rb.keyRelease(KeyEvent.VK_CONTROL);
		boolean flag = DesktopSession.findElementByName("CanIfInitHohCfg_0 [CanIfInitHohCfg]").isDisplayed();
		boolean enable = DesktopSession.findElementByName("CanIfInitHohCfg_0 [CanIfInitHohCfg]").isEnabled();
		System.out.println(flag + " ==-=-0op;=->  " + enable);
		Assert.assertEquals(flag, true);
		Assert.assertEquals(enable, true);
	}

	@SuppressWarnings("unchecked")
	public void VerifyObjectHighlighted(String project, String filename) throws Exception {

		DesktopSession = Root();
		Actions act = new Actions(DesktopSession);
		Robot rb = new Robot();
		DesktopSession.findElementByName(project).click();
		logger.pass("Click the Project");
		ExpandProject(9);
		logger.pass("Expand the Project");
		DesktopSession.findElementByName("CanIf_0 [CanIf]").click();
		logger.pass("Click the CanIf");
		ExpandProject(2);
		logger.pass("Expand the Project");
		WebElement canif = DesktopSession.findElementByName("CanIfCtrlDrvCfg_0 [CanIfCtrlDrvCfg]");
		act.doubleClick(canif).perform();
		logger.pass("Double Click on the CanIfCtrlDrvCfg_0");
		Thread.sleep(1000);
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		logger.pass("Click the down button");
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		logger.pass("Click the down button");
		List<WebElement> lst = DesktopSession.findElementsByName("CanIfCtrlDrvInitHohConfigRef");
		System.out.println(lst.size() + " =-=-=-=-=-=->   ");
		lst.get(4).click();
		;
		act.contextClick().perform();
		Thread.sleep(500);
		DesktopSession.findElementByName(Pageobj.Go_To_Reference_Object).click();
		Thread.sleep(500);
		boolean flag = DesktopSession.findElementByName("CanIfInitHohCfg_0 [CanIfInitHohCfg]").isDisplayed();
		boolean enable = DesktopSession.findElementByName("CanIfInitHohCfg_0 [CanIfInitHohCfg]").isEnabled();
		System.out.println(flag + " ==-=-0op;=->  " + enable);
		Assert.assertEquals(flag, true);
		Assert.assertEquals(enable, true);
	}

	@SuppressWarnings("unchecked")
	public void VerifyMultivalueEle(String project, String filename) throws Exception {

		DesktopSession = Root();
		Actions act = new Actions(DesktopSession);
		Robot rb = new Robot();
		DesktopSession.findElementByName(project).click();
		logger.pass("Click the Project");
		ExpandProject(1);
		logger.pass("Expand the Project");
		DesktopSession.findElementByName(filename).click();
		logger.pass("Click the File");
		ExpandProject(3);
		logger.pass("Expand the file");
		DesktopSession.findElementByName(Pageobj.BswMArPackage).click();
		logger.pass("Click the BswM");
		ExpandProject(1);
		logger.pass("Expand the BswM");
		DesktopSession.findElementByName(Pageobj.BswMService).click();
		logger.pass("Click the BswMService");
		ExpandProject(1);
		logger.pass("Expand the BswM");
		DesktopSession.findElementByName(Pageobj.BswMInternal).click();
		logger.pass("Click the BswMInternal");
		Thread.sleep(500);
		List<WebElement> lst1 = DesktopSession.findElementsByXPath("//*[@LocalizedControlType='tab item']");
		System.out.println(lst1.size() + " -0-9-=-> ");
		for (int i = 0; i <= lst1.size() - 1; i++) {
			System.out.println(lst1.get(i).getAttribute("Name") + " =-0-g6e==>  ");
			System.out.println(lst1.get(i).getAttribute("ProcessId") + " =-0-d5xgxtrea==>  " + i);
			lst1.get(i).click();
		}
		lst1.get(3).click();
		List<WebElement> lst2 = DesktopSession.findElementsByName("Properties");
		System.out.println(lst2.size() + " -0-59-=-> ");
		for (int i = 0; i <= lst2.size() - 1; i++) {
			String data = lst2.get(i).getAttribute("LocalizedControlType");
			System.out.println("=--=-=>  jgy  " + data);
			if (data.equalsIgnoreCase("tab item")) {
				lst2.get(i).click();
			}
		}
		DesktopSession.findElementByName("Properties").click();
		logger.pass("Click the Properties Tab");
		Thread.sleep(1000);
		List<WebElement> scoll = DesktopSession.findElementsByName("Page down");
		System.out.println(scoll.size() + " ohsh=-=-=->  ");
		for (int i = 0; i <= scoll.size() - 1; i++) {
			System.out.println(scoll.get(i).getAttribute("LegacyIAccessible.Description") + " =-0-99==>  ");
			System.out.println(scoll.get(i).getAttribute("ProcessId") + " =-0-7y7==>  " + i);
		}
		scoll.get(1).click();
		logger.pass("Click the DatatypeMapping");
		rb.keyPress(KeyEvent.VK_CONTROL);
		logger.pass("Click the cntrl button");
		DesktopSession.findElementByName(Pageobj.DatatypeMapping).click();
		logger.pass("Click the DatatypeMapping");
		rb.keyPress(KeyEvent.VK_CONTROL);
		logger.pass("Release the cntrl button");
		List<WebElement> lst = DesktopSession.findElementsByXPath("//*[@LocalizedControlType='title bar']");
		System.out.println(lst.size());
		String value = "";
		boolean flag = false;
		for (int i = 0; i <= lst.size() - 1; i++) {

			value = lst.get(i).getAttribute("Value.Value");
			System.out.println(value + "  = -3e=-> ");
			if (value.equalsIgnoreCase("Select an item to show in Navigator")) {
				flag = true;
				break;
			}
		}
		System.out.println(value + "  =- - > ");
		DesktopSession.findElementByName("DataTypeMappingSet_0 [/ArPackage_BswM/DataTypeMappingSet_0]").click();
		boolean set0 = DesktopSession.findElementByName("DataTypeMappingSet_0 [DataTypeMappingSet]").isEnabled();
		System.out.println(set0 + " = -= -> ");
		DesktopSession.findElementByName("DataTypeMappingSet_1 [/ArPackage_BswM/DataTypeMappingSet_1]").click();
		boolean set1 = DesktopSession.findElementByName("DataTypeMappingSet_1 [DataTypeMappingSet]").isEnabled();
		System.out.println(set1 + " = sg-= -> ");
		DesktopSession.findElementByName("DataTypeMappingSet_0 [/ArPackage_ComM/DataTypeMappingSet_0]").click();
		boolean set2 = DesktopSession.findElementByName("DataTypeMappingSet_0 [DataTypeMappingSet]").isEnabled();
		System.out.println(set2 + " = xcd-= -> ");
		DesktopSession.findElementByName("Close").click();
		Assert.assertEquals(flag, true);
		Assert.assertEquals(set0, true);
		Assert.assertEquals(set1, true);
		Assert.assertEquals(set2, true);

	}

	@SuppressWarnings("unchecked")
	public void SelectElementDialogOpen(String project, String filename) throws Exception {

		DesktopSession = Root();
		Actions act = new Actions(DesktopSession);
		Robot rb = new Robot();
		DesktopSession.findElementByName(project).click();
		logger.pass("Click the Project");
		ExpandProject(1);
		logger.pass("Expand the Project");
		DesktopSession.findElementByName(filename).click();
		logger.pass("Click the File");
		ExpandProject(3);
		logger.pass("Expand the file");
		DesktopSession.findElementByName(Pageobj.BswMArPackage).click();
		logger.pass("Click the BswM");
		ExpandProject(1);
		logger.pass("Expand the BswM");
		DesktopSession.findElementByName(Pageobj.BswMService).click();
		logger.pass("Click the BswMService");
		ExpandProject(1);
		logger.pass("Expand the BswM");
		DesktopSession.findElementByName(Pageobj.BswMInternal).click();
		logger.pass("Click the BswMInternal");
		Thread.sleep(500);
		List<WebElement> lst1 = DesktopSession.findElementsByName("Properties");
		System.out.println(lst1.size() + " -0-9-=-> ");
		lst1.get(0).click();
		logger.pass("Click the Properties Tab");
		Thread.sleep(1000);
		List<WebElement> scoll = DesktopSession.findElementsByName("Page down");
		System.out.println(scoll.size() + " ohsh=-=-=->  ");
		for (int i = 0; i <= scoll.size() - 1; i++) {
			System.out.println(scoll.get(i).getAttribute("BoundingRectangle") + " =- =>  ");
			System.out.println(scoll.get(i).getAttribute("ProcessId") + " =-0-7y7==>  " + i);
			String elementscroll = scoll.get(i).getAttribute("BoundingRectangle");
			if (elementscroll.equalsIgnoreCase("Left:1343 Top:644 Width:17 Height:35")) {
				scoll.get(i).click();
			}
		}
		logger.pass("Click the DatatypeMapping");
		rb.keyPress(KeyEvent.VK_CONTROL);
		logger.pass("Click the cntrl button");
		DesktopSession.findElementByName(Pageobj.DatatypeMapping).click();
		logger.pass("Click the DatatypeMapping");
		rb.keyRelease(KeyEvent.VK_CONTROL);
		logger.pass("Release the cntrl button");
		// EcuMStateType [ModeDeclarationGroup]
		String text = DesktopSession.findElementByName("EcuMStateType [ModeDeclarationGroup]").getText();
		System.out.println("=-= >   " + text);
		String[] arry = text.split(" ");
		String txt = arry[0];
		System.out.println(txt + "   = -=-0 ==> ");
		DesktopSession.findElementByName("EcuMStateType [ModeDeclarationGroup]").click();
		Thread.sleep(500);
		DesktopSession.findElementByName("EcuMStateType [ModeDeclarationGroup]").click();
		for (int i = 0; i <= scoll.size() - 1; i++) {
			System.out.println(scoll.get(i).getAttribute("BoundingRectangle") + " =- =>  ");
			System.out.println(scoll.get(i).getAttribute("ProcessId") + " =-0-7y7==>  " + i);
			String elementscroll = scoll.get(i).getAttribute("BoundingRectangle");
			if (elementscroll.equalsIgnoreCase("Left:1343 Top:644 Width:17 Height:35")) {
				scoll.get(i).click();
				scoll.get(i).click();
			}
		}
		DesktopSession.findElementByName("Short Name").click();
		List<WebElement> list = DesktopSession.findElementsByClassName("Edit");
		String Value = "";
		Thread.sleep(1000);
		System.out.println(list.size() + " =-d => ");
		for (int i = 0; i <= list.size() - 1; i++) {
			String data = list.get(i).getAttribute("Value.Value");
			System.out.println(data);
			Value = data;
		}
		System.out.println(Value + "  =-123223r==-> ");
		Assert.assertEquals(txt, Value);
	}

	public int VerifySequenceOfBlock(String project, String filename) throws Exception {

		DesktopSession = Root();
		Actions act = new Actions(DesktopSession);
		Robot rb = new Robot();
		DesktopSession.findElementByName(project).click();
		logger.pass("Click the Project");
		ExpandProject(1);
		logger.pass("Expand the Project");
		int count = 0;
		DesktopSession.findElementByName(filename).click();
		logger.pass("Click the File");
		ExpandProject(7);
		logger.pass("Expand the file");
		DesktopSession.findElementByName("Fee_0 [Fee]").click();
		ExpandProject(1);
		logger.pass("Expand the Project");
		count++;
		System.out.println(count);
		logger.pass("Fee_0 [Fee]" + count);
		DesktopSession.findElementByName("FeeClusterConfigSpecific_0 [FeeClusterConfigSpecific]").click();
		ExpandProject(1);
		logger.pass("Expand the Project");
		count++;
		logger.pass("FeeClusterConfigSpecific_0" + count);
		DesktopSession.findElementByName("FeeSectorList_0 [FeeSectorList]").click();
		ExpandProject(1);
		logger.pass("Expand the Project");
		count++;
		logger.pass("FeeSectorList_0 [FeeSectorList]" + count);
		DesktopSession.findElementByName("FeeSector [7]").click();
		ExpandProject(1);
		logger.pass("Expand the Project");
		count++;
		logger.pass("FeeSector [7]" + count);
		System.out.println(count);
		boolean flag = DesktopSession.findElementByName("FlsSector_DTC [FeeSector]").isDisplayed();
		Assert.assertEquals(flag, true);
		return count;
	}

	public void RestartProject() throws Exception {

		DesktopSession = Root();
		Actions act = new Actions(DesktopSession);
		Robot rb = new Robot();
		DesktopSession.findElementByName(Pageobj.File).click();
		logger.pass("Click the File");
		Thread.sleep(500);
		DesktopSession.findElementByName("Restart").click();
		logger.pass("Click the Restart");
		Thread.sleep(5000);
		// DesktopSession.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

	}

	public void VerifyGenerateCode(String project, String filename) throws Exception {

		DesktopSession = Root();
		Actions act = new Actions(DesktopSession);
		Robot rb = new Robot();
		ExpandProject(2);
		DesktopSession.findElementByName(filename).click();
		act.contextClick().perform();
		Thread.sleep(500);
		DesktopSession.findElementByName("Generate Report").click();
		boolean flag = false;
		try {
			flag = DesktopSession.findElementByName("Generate Report").isDisplayed();
			System.out.println(flag);
		} catch (Exception e) {
			flag = false;
			System.out.println(flag);
		}
		if (flag == true) {
			System.out.println(" displayed");
			rb.keyPress(KeyEvent.VK_ENTER);
			rb.keyRelease(KeyEvent.VK_ENTER);
		} else {
			System.out.println("Nothing displayed");
		}
		Thread.sleep(2000);

		DesktopSession.findElementByName("Reports").click();
		// ExpandProject(1);
//		rb.keyPress(KeyEvent.VK_UP);
//		rb.keyRelease(KeyEvent.VK_UP);
//		rb.keyPress(KeyEvent.VK_UP);
//		rb.keyRelease(KeyEvent.VK_UP);
		act.contextClick().perform();
		Thread.sleep(500);
		DesktopSession.findElementByName("Properties").click();
		Thread.sleep(2000);
		String value = "";
		List<WebElement> lst = DesktopSession.findElementsByXPath("//*[@LocalizedControlType='document']");
		System.out.println(lst.size());
		for (int i = 0; i <= lst.size() - 1; i++) {

			String str = lst.get(i).getAttribute("Name");
			System.out.println(str + "  =-=-=-=-=->  ");
			if (str.contains("Location:")) {
				value = lst.get(i).getAttribute("Value.Value");
				System.out.println(value + " -=-=43-=-=>  ");
				break;
			}
		}
		Utility ut = new Utility();
		String reportpath = ut.FilesnamesOnDir(value, ".html");
		System.out.println("adjvb=  " + reportpath);
		String redOnReport = "#FF0000";
		String yellowOnReport = "#ffff00";
		int redcount = 0;
		int yellowcount = 0;
		String filepath = value + File.separator + reportpath;
		System.out.println(filepath + " 0--090-0-090-0==>  ");
		String chromePath = System.getProperty("user.dir") + File.separator + "chomedriver";
		System.setProperty("webdriver.chrome.driver", chromePath + File.separator + "chromedriver.exe");
		logger.pass("Chrome configuration");
		WebDriver driver = new ChromeDriver();
		driver.get(filepath);
		logger.pass("Navigate to repot html file");
		driver.manage().window().maximize();
		logger.pass("maximize the browser");
		List<WebElement> lst1 = driver.findElements(By.xpath("//tr[@id='TableContainer']"));
		System.out.println(lst1.size());
		for (int j = 0; j <= lst1.size() - 1; j++) {

			String color = lst1.get(j).getAttribute("bgcolor");
			System.out.println(color + " --=-=-=-p>juh ");
			if (yellowOnReport.equals(color)) {
				System.out.println(yellowcount + "   -=-> dsgfh7654erthjkl;");
				yellowcount++;
			}
			if (redOnReport.equals(color)) {
				System.out.println(redcount + "   -=-> dsgfh7654erthjkl;");
				redcount++;

			}
		}
		System.out.println(yellowcount + " ==6-=> " + " =--4==> " + redcount);
		driver.close();

		Assert.assertTrue(redcount > 0 || yellowcount > 0);

	}

	public void ImportProjectSaveWorkspace(String PathDir) throws Exception {
		DesktopSession = Root();
		Robot rbb = new Robot();
		Actions rightclickaS = new Actions(DesktopSession);
		System.out.println("===================>     " + DesktopSession.findElementByName(Pageobj.File).isDisplayed());
		DesktopSession.findElementByName(Pageobj.File).click();
		logger.pass("Clicked On File");
		DesktopSession.findElementByName(Pageobj.Import).click();
		logger.pass("Clicked On Import");
		DesktopSession.findElementByClassName(Pageobj.Edit).click();
		logger.pass("Clicked On Edit");
		DesktopSession.findElementByName(Pageobj.General_Folder).click();
		logger.pass("Clicked On General");
		rbb.keyPress(KeyEvent.VK_RIGHT);
		rbb.keyPress(KeyEvent.VK_RIGHT);
		logger.pass("Expaned General");
		DesktopSession.findElementByName(Pageobj.Existing_dir).click();
		logger.pass("Clicked On Existing Project dir");
		DesktopSession.findElementByName(Pageobj.Next_Button).click();
		logger.pass("Clicked On Next");
		DesktopSession.findElementByName(Pageobj.Select_Root_dir).click();
		DesktopSession.findElementByClassName(Pageobj.Edit).click();
		WebElement field = DesktopSession.findElementByName(Pageobj.Select_Root_dir);
		rightclickaS.sendKeys(field, PathDir);
		rightclickaS.perform();
		logger.pass("Entered the Dir");
		DesktopSession.findElementByClassName(Pageobj.TreeView32).click();
		DesktopSession.findElementByName(Pageobj.CopyToProject).click();
		DesktopSession.findElementByName(Pageobj.Finish_Button).click();
		System.out.println("done ----> ");
		Thread.sleep(2000);
		logger.pass("Clicked On Finish");
		//Loading Model Resources
		//Loading model files
		boolean flag = true;
		try {
			flag =	DesktopSession.findElementByClassName("Cancel").isDisplayed();
			if(flag=false) {
				System.out.println("No waiting");
			}else {
				Thread.sleep(3000);
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
	}

	public boolean verifyObject(String element, String project) throws Exception {

		DesktopSession = Root();
		Robot rbb = new Robot();
		Actions act = new Actions(DesktopSession);
		DesktopSession.findElementByName(project).click();
		logger.pass("Click on the Project");
		act.contextClick().perform();
		Thread.sleep(500);
		DesktopSession.findElementByName(Pageobj.BatchValidation).click();
		logger.pass("Click on the BatchValidation");
		Thread.sleep(500);
		rbb.keyPress(KeyEvent.VK_ENTER);
		rbb.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		List<WebElement> viewlist = DesktopSession.findElementsByName(Pageobj.View_Menu);
		viewlist.get(1).click();
		logger.pass("Click on the view_menu");
		Thread.sleep(500);
		DesktopSession.findElementByName(Pageobj.Group_By).click();
		logger.pass("Click on the Group_By");
		boolean flag = false;
		try {
			flag = DesktopSession.findElementByName(element).isDisplayed();
			System.out.println(flag + " =-=-> ");
		} catch (Exception e) {
			System.out.println(e);
		}
		return flag;
	}

	public void BSWgroupbyErrors(String project, String element) throws Exception {

		DesktopSession = Root();
		Robot rbb = new Robot();
		Actions act = new Actions(DesktopSession);
		DesktopSession.findElementByName(project).click();
		logger.pass("Click on the Project");
		act.contextClick().perform();
		Thread.sleep(500);
		DesktopSession.findElementByName(Pageobj.BatchValidation).click();
		logger.pass("Click on the BatchValidation");
		Thread.sleep(500);
		rbb.keyPress(KeyEvent.VK_ENTER);
		rbb.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		List<WebElement> viewlist = DesktopSession.findElementsByName(Pageobj.View_Menu);
		viewlist.get(1).click();
		logger.pass("Click on the ViewMenu");
		Thread.sleep(500);
		DesktopSession.findElementByName(Pageobj.Group_By).click();
		logger.pass("Click on the Group By");
		boolean flag = false;
		try {
			flag = DesktopSession.findElementByName(element).isDisplayed();
			System.out.println(flag + " =-=-> ");
			DesktopSession.findElementByName(element).click();
			logger.pass("Click on the element");
		} catch (Exception e) {
			System.out.println(e);
		}
		Map<Integer, String> map = new HashMap<Integer, String>();
		List<WebElement> lst = DesktopSession.findElementsByXPath("//*[@LocalizedControlType = 'tree item']");
		System.out.println(lst.size());
		for (int j = 0; j <= lst.size() - 1; j++) {
			System.out.println(lst.get(j).getAttribute("Name") + " =-=-=---> " + j);
			String errors = lst.get(j).getAttribute("Name");
			if (errors.contains("WRN") || errors.contains("INF") || errors.contains("ERR")) {
				map.put(j, errors);
			}
		}
		System.out.println(map + " =-90-=>  ");
		boolean val = map.containsValue("ERR009001: The feature definition references unresolved target objects.");
		System.out.println(val);
	}

//	public void GenerateCode(String Projectname) throws Exception {
//
//		DesktopSession = Root();
//		Robot rbb = new Robot();
//		Actions act = new Actions(DesktopSession);
//		Thread.sleep(4000);
//		DesktopSession.findElementByName(Projectname).click();
//		logger.pass("Click on the Project");
//		ExpandProject(2);
//		logger.pass("Expand on the Project");
//		DesktopSession.findElementByName("ECUC").click();
//		logger.pass("Click on the Ecuc");
//		ExpandProject(11);
//		logger.pass("Expand the ECUC");
//		DesktopSession.findElementByName("Rte_0 [Rte]").click();
//		logger.pass("Click on the Rte_0 [Rte]");
//		act.contextClick().build().perform();
//		Thread.sleep(500);
//		DesktopSession.findElementByName("Generate Code").click();
//		logger.pass("Click on the Generate Code");
//		Thread.sleep(500);
//		DesktopSession.findElementByName("Rte_0 [/KPIT/EcucDefs/Rte]").click();
//		logger.pass("Click on the Rte_o [/KPIT/EcucDefs/Rte]");
//		List<WebElement> lst = DesktopSession.findElementsByXPath("//*[@LocalizedControlType='text']");
//		System.out.println(lst.size());
//		int count = 0;
//		for (int i = 0; i <= lst.size() - 1; i++) {
//
//			String value = lst.get(i).getAttribute("AutomationId");
//			System.out.println(value);
//try {
//			if (value.equals("ListViewSubItem-1")) {
//
//				System.out.println(value + " -9876==-=-> ");
//				count++;
//			}
//
//		
//		System.out.println(count + " -3456-=-=-> ");
//}
//		catch (Exception e) {
//			System.out.println(e);
//		}
//		}
//		
//	}

	public void GenerateCodes(String Projectname, String modules) throws Exception {
		DesktopSession = Root();
		Robot rbb = new Robot();
		Actions act = new Actions(DesktopSession);
		Thread.sleep(4000);
		DesktopSession.findElementByName(Projectname).click();
		logger.pass("Click on the Project");
		ExpandProject(2);
		logger.pass("Expand on the Project");
		act.contextClick(DesktopSession.findElementByName(Projectname)).build().perform();
		Thread.sleep(1000);
		DesktopSession.findElementByName("Generate Code").click();
		Thread.sleep(500);
		DesktopSession.findElementByName(modules).click();
		rbb.keyPress(KeyEvent.VK_SPACE);
		rbb.keyRelease(KeyEvent.VK_SPACE);
		DesktopSession.findElementByName(po.Finish_Button).click();
		String process = "Processing Code Generation........                                ";
		int i = 0;
		while (i <= 15) {
			System.out.println(i);
			logger.info("Waiting");
			Thread.sleep(2000);
			try {
				System.out.println(DesktopSession.findElementByName(process).isEnabled() + " -=-=>");
				System.out.println(DesktopSession.findElementByName("OK").isEnabled());
				if (DesktopSession.findElementByName("OK").isEnabled()) {

					// DesktopSession.findElementByName("OK").click();
					break;

				} else {
					Thread.sleep(2000);
				}
			} catch (Exception e) {
				System.out.println(e);
			}
			i++;
		}
		try {
			boolean flag = DesktopSession.findElementByName("Completed").isDisplayed();
			System.out.println(flag);
			Assert.assertEquals(flag, true);
		} catch (Exception e) {
			System.out.println(e);// TODO: handle exception
		}
		DesktopSession.findElementByName("OK").click();
		Thread.sleep(1000);

	}

	public void VerifyMappedFrame(String project) throws Exception {

		DesktopSession = Root();
		Robot rbb = new Robot();
		Actions act = new Actions(DesktopSession);
		DesktopSession.findElementByName(project).click();
		logger.pass("Click the Project");
		act.contextClick().perform();
		Thread.sleep(1000);
		DesktopSession.findElementByName(Pageobj.CanMapping).click();
		logger.pass("Click the CanMapping");
		Thread.sleep(1000);
		List<WebElement> lst1 = DesktopSession.findElementsByName("Properties");
		System.out.println(lst1.size() + " 0-0-> ");
		// DesktopSession.findElementByName("Properties").click();
		lst1.get(0).click();
		act.doubleClick().build().perform();
		Thread.sleep(1000);
		act.contextClick(lst1.get(0)).build().perform();
		rbb.keyPress(KeyEvent.VK_DOWN);
		rbb.keyRelease(KeyEvent.VK_DOWN);
		rbb.keyPress(KeyEvent.VK_ENTER);
		rbb.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(500);
		DesktopSession.findElementByName("FRM_ECU_GWCANLIN_PDUWithGaps").click();
		logger.pass("Click the FRM_ECU_GWCANLIN_PDUWithGaps");
		Thread.sleep(500);
		act.contextClick().build().perform();
		Thread.sleep(1000);
		DesktopSession.findElementByName("Map to H/W Object").click();
		logger.pass("Click the H/W Objects");
		Thread.sleep(500);
		rbb.keyPress(KeyEvent.VK_DOWN);
		rbb.keyRelease(KeyEvent.VK_DOWN);
		rbb.keyPress(KeyEvent.VK_ENTER);
		rbb.keyRelease(KeyEvent.VK_ENTER);
		List<WebElement> lst = DesktopSession.findElementsByName("FRM_ECU_GWCANLIN_PDUWithGaps");
		System.out.println("ajsncz=-=-> " + lst.size());

	}

	public void VerifyTXTfile() throws Exception {
		DesktopSession = Root();
		Thread.sleep(4000);
		DesktopSession.findElementByName("DBC_Project").click();
		logger.pass("Click the DBC_Project");
		Actions act = new Actions(DesktopSession);
		Robot rb = new Robot();
		act.contextClick().build().perform();
		logger.pass("Right Click the DBC_Project");
		Thread.sleep(500);
		DesktopSession.findElementByName(po.Import).click();
		logger.pass("Click the import");
		DesktopSession.findElementByName(po.General_Folder).click();
		logger.pass("Click the General folder");
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		rb.keyPress(KeyEvent.VK_RIGHT);
		rb.keyRelease(KeyEvent.VK_RIGHT);
		DesktopSession.findElementByName(po.DBC).click();
		logger.pass("Click on the DBC");
		DesktopSession.findElementByName(po.Next_Button).click();
		logger.pass("Click on the Next button");
		DesktopSession.findElementByName(po.Browse).click();
		logger.pass("Click on the browser");
		String Projectlocation = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator
				+ "Testtxt";
		DesktopSession.findElementByName("All locations").click();
		logger.pass("Click on the All location");
		Thread.sleep(1000);
		WebElement filepath = DesktopSession.findElementByName("Address");
		String select = Keys.chord(Keys.CONTROL, "a");
		act.sendKeys(filepath, select);
		act.perform();
		act.sendKeys(Keys.BACK_SPACE).perform();
		act.sendKeys(Projectlocation).perform();
		// DesktopSession.findElementById("1001").click();
		Thread.sleep(500);
		String arrow = "Go to " + '"' + Projectlocation + '"';
		DesktopSession.findElementByName(arrow).click();
		logger.pass("Click on the arrow");
		String dbc = "";
		boolean flag = false;
		List<WebElement> lst = DesktopSession.findElementsByName("Name");
		System.out.println(lst.size());
		for (int i = 0; i <= lst.size() - 1; i++) {

			String file = lst.get(i).getAttribute("Value.Value");
			System.out.println(file);

			if (file != null) {
				dbc = file;
				System.out.println(dbc + " -=-=-=-> ");
				if (dbc.contains(".txt")) {
					flag = true;
				} else {
					flag = false;
				}
			}
		}
		Assert.assertEquals(flag, false);
		DesktopSession.findElementByName("Cancel").click();
		logger.pass("Click on the Cancel");
		DesktopSession.findElementByName("Cancel").click();
		logger.pass("Click on the Cancel");

	}

	public void VerifyTXTfileLDF() throws Exception {
		DesktopSession = Root();
		Thread.sleep(4000);
		DesktopSession.findElementByName("LDF_Project").click();
		logger.pass("Click the LDF_Project");
		Actions act = new Actions(DesktopSession);
		Robot rb = new Robot();
		act.contextClick().build().perform();
		logger.pass("Right click LDF_Project");
		Thread.sleep(500);
		DesktopSession.findElementByName(po.Import).click();
		logger.pass("Click the Import");
		DesktopSession.findElementByName(po.General_Folder).click();
		logger.pass("Click the General Folder");
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		rb.keyPress(KeyEvent.VK_RIGHT);
		rb.keyRelease(KeyEvent.VK_RIGHT);
		DesktopSession.findElementByName(po.LDF).click();
		logger.pass("Click the LDF");
		DesktopSession.findElementByName(po.Next_Button).click();
		logger.pass("Click the Next_Button");
		DesktopSession.findElementByName(po.LDFBrowse).click();
		logger.pass("Click the LDF_Browse");
		String Projectlocation = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator
				+ "TesttxtLdf";
		DesktopSession.findElementByName("All locations").click();
		Thread.sleep(1000);
		WebElement filepath = DesktopSession.findElementByName("Address");
		String select = Keys.chord(Keys.CONTROL, "a");
		act.sendKeys(filepath, select);
		act.perform();
		act.sendKeys(Keys.BACK_SPACE).perform();
		act.sendKeys(Projectlocation).perform();
		// DesktopSession.findElementById("1001").click();
		Thread.sleep(500);
		String arrow = "Go to " + '"' + Projectlocation + '"';
		DesktopSession.findElementByName(arrow).click();
		String dbc = "";
		boolean flag = false;
		List<WebElement> lst = DesktopSession.findElementsByName("Name");
		System.out.println(lst.size());
		for (int i = 0; i <= lst.size() - 1; i++) {

			String file = lst.get(i).getAttribute("Value.Value");
			System.out.println(file);

			if (file != null) {
				dbc = file;
				System.out.println(dbc + " -=-=-=-> ");
				if (dbc.contains(".txt")) {
					flag = true;
				} else {
					flag = false;
				}
			}
		}
		Assert.assertEquals(flag, false);
		DesktopSession.findElementByName("Cancel").click();
		logger.pass("Click the Cancel");
		DesktopSession.findElementByName("Cancel").click();
		logger.pass("Click the Cancel");

	}

	public void VerifyHTMLfile() throws Exception {
		DesktopSession = Root();
		Thread.sleep(2000);
		// DesktopSession.findElementByName("RegressionTest_Generate_DifferentialReport").click();
		ExpandProject(2);
		DesktopSession.findElementByName("workflow.c4k").click();
		logger.pass("Click on the workflow");
		Actions act = new Actions(DesktopSession);
		act.contextClick().build().perform();
		logger.pass("Right Click on the workflow");
		Thread.sleep(1000);
		DesktopSession.findElementByName("Run As").click();
		logger.pass("Click on the Run As");
		Thread.sleep(500);
		DesktopSession.findElementByName("1 c4k Workflow").click();
		logger.pass("Click on the workflow");
		Thread.sleep(3000);
		DesktopSession.findElementByName("testdir").click();
		logger.pass("Click on the testdir");
		act.contextClick().build().perform();
		logger.pass("Right Click on the testdir");
		Thread.sleep(500);
		DesktopSession.findElementByName("Refresh").click();
		logger.pass("Click on the Refresh");
		Thread.sleep(500);
		DesktopSession.findElementByName("testdir").click();
		logger.pass("Click on the testdir");
		ExpandProject(2);
		logger.pass("expand the Project");
		boolean flag = true;
		String reportpath = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator
				+ "RegressionTest_Generate_DifferentialReport" + File.separator + "testdir" + File.separator + "report";
		File directoryPath = new File(reportpath);
		String contents[] = directoryPath.list();
		System.out.println("List of files and directories in the specified directory:");
		for (int i = 0; i < contents.length; i++) {
			System.out.println(contents[i]);
			String value = contents[i];
			if (value.contains(".html")) {
				flag = true;
				System.out.println(flag);
			}
		}
		System.out.println(flag);
		Assert.assertEquals(flag, true);
	}

	public void VerifySampleHTMLReport() throws Exception {

		DesktopSession = Root();
		Thread.sleep(2000);
		// DesktopSession.findElementByName("RegressionTest_Generate_DifferentialReport").click();
		ExpandProject(2);
		DesktopSession.findElementByName("workflow.c4k").click();
		logger.pass("Click on the workflow");
		Actions act = new Actions(DesktopSession);
		act.contextClick().build().perform();
		logger.pass("Right Click on the workflow");
		Thread.sleep(1000);
		DesktopSession.findElementByName("Run As").click();
		logger.pass("Click on the Run As");
		Thread.sleep(500);
		DesktopSession.findElementByName("1 c4k Workflow").click();
		logger.pass("Click on the c4k workflow");
		Thread.sleep(4000);
		DesktopSession.findElementByName("testdir").click();
		logger.pass("Click on the testdir");
		act.contextClick().build().perform();
		logger.pass("Right Click on the testdir");
		Thread.sleep(500);
		DesktopSession.findElementByName("Refresh").click();
		logger.pass("Click on the refresh");
		Thread.sleep(500);
		DesktopSession.findElementByName("testdir").click();
		logger.pass("Click on the testdir");
		ExpandProject(2);
		logger.pass("expand the Project");
		boolean flag = true;
		// RegressionTest_Generate_DifferentialReport
		String reportpath = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator
				+ "Regression_Generate_DifferentialReport" + File.separator
				+ "RegressionTest_Generate_DifferentialReport" + File.separator + "testdir" + File.separator + "report";
		System.out.println(reportpath);
		File directoryPath = new File(reportpath);
		String contents[] = directoryPath.list();
		System.out.println("List of files and directories in the specified directory:");
		for (int i = 0; i < contents.length; i++) {
			System.out.println(contents[i]);
			String value = contents[i];
			if (value.contains("sample.diff.html")) {
				flag = true;
				System.out.println(flag);
			} else {
				flag = false;
				System.out.println(flag);
			}
		}
		Assert.assertEquals(flag, false);
	}

	public void VerifyContraints(String Project) throws Exception {

		DesktopSession = Root();
		Thread.sleep(1000);
		DesktopSession.findElementByName(Project).click();
		logger.pass("Click on the Project");
		ExpandProject(6);
		logger.pass("Expand the Project");
		Actions act = new Actions(DesktopSession);
		Robot rb = new Robot();
		WebElement wb = DesktopSession.findElementByName("ARRoot [ARPackage]");
		act.contextClick(wb).build().perform();
		logger.pass("Right Click on the ArPackage");
		Thread.sleep(1000);
		// DesktopSession.findElementByName("ARRoot [ARPackage]").click();
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		rb.keyPress(KeyEvent.VK_RIGHT);
		rb.keyRelease(KeyEvent.VK_RIGHT);
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		rb.keyPress(KeyEvent.VK_RIGHT);
		rb.keyRelease(KeyEvent.VK_RIGHT);
		DesktopSession.findElementByName("ARRoot [ARPackage]").click();
		logger.pass("Click on the ARPackage");
		act.contextClick(wb).perform();
		logger.pass("Right Click on the ARPackage");
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		rb.keyPress(KeyEvent.VK_RIGHT);
		rb.keyRelease(KeyEvent.VK_RIGHT);
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		rb.keyPress(KeyEvent.VK_RIGHT);
		rb.keyRelease(KeyEvent.VK_RIGHT);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		act.contextClick(wb).perform();
		Thread.sleep(2000);
		boolean flag = false;
		try {
			flag = DesktopSession.findElementByName("New Module Configuration").isDisplayed();
			System.out.println(flag);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		Assert.assertEquals(flag, true);
	}

	public void VerifyValidationTxt(String Project, String Validationfile) throws Exception {

		DesktopSession = Root();
		Actions act = new Actions(DesktopSession);
		Robot rb = new Robot();
		DesktopSession.findElementByName(Project).click();
		logger.pass("Click on the Project");
		act.contextClick().build().perform();
		logger.pass("Right Click on the Project");
		Thread.sleep(500);
		DesktopSession.findElementByName(po.ECUC_Mapping).click();
		logger.pass("Click on the Ecuc Mapping");
		DesktopSession.findElementByName("Finish").click();
		logger.pass("Click on the Finish");
		Thread.sleep(4000);
		DesktopSession = Root();
		DesktopSession.findElementByName(Project).click();
		logger.pass("Click on the Project");
		ExpandProject(2);
		logger.pass("Expand the Project");
		DesktopSession.findElementByName("EcucDescription.arxml").click();
		logger.pass("Click on the EcucDesc.arxml");
		ExpandProject(8);
		logger.pass("Expand the Project");
		DesktopSession.findElementByName("EcucDescription.arxml").click();
		logger.pass("Click on the EcucDec.arxml");
		DesktopSession.findElementByName("EcuC_0 [EcuC]").click();
		logger.pass("Click on the Ecuc_0[EcuC]");
		act.contextClick().build().perform();
		logger.pass("Right Click on the Ecuc_0[Ecuc]");
		Thread.sleep(500);
		DesktopSession.findElementByName(po.Generate_Code).click();
		logger.pass("Click on the Generate Code");
		// Thread.sleep(2000);
		String select = Keys.chord(Keys.CONTROL, "a");
		DesktopSession.findElementByName("Output Location").click();
		logger.pass("Click on the Output Location");
		List<WebElement> lst = DesktopSession.findElementsByName("Output Location");
		System.out.println(lst.size());
		for (int i = 0; i <= lst.size() - 1; i++) {
			String str = lst.get(i).getAttribute("Value.Value");
			System.out.println(str);
		}
		lst.get(1).sendKeys(select);
		lst.get(1).sendKeys(Validationfile);
		DesktopSession.findElementByName("Finish").click();
		logger.pass("Click on the Finish");
		int i = 0;
		while (i <= 8) {
			System.out.println(i);
			logger.info("Waiting");
			Thread.sleep(4000);
			try {
				if (DesktopSession.findElementByName("Processing Code Generation").isEnabled()) {

					Thread.sleep(2000);

				} else {

				}
			} catch (Exception e) {
				System.out.println(e);
			}
			i++;
		}
		Thread.sleep(3000);

	}

	public void ReworkLunchApp(String AppPath) throws Exception {
		int length = 7;
		boolean useLetters = true;
		boolean useNumbers = true;
		DesktopSession = Root();
		Actions rightclick = new Actions(DesktopSession);
		logger.pass("Application opened");
		DesktopSession.findElementByName(Pageobj.workspaces).click();
		logger.pass("Click on the Workspace");
		String select = Keys.chord(Keys.CONTROL, "a");
		rightclick.sendKeys(DesktopSession.findElementByXPath(Pageobj.workspace), select);
		rightclick.perform();
		// String generatedString = RandomStringUtils.random(length, useLetters,
		// useNumbers);
		rightclick.sendKeys(DesktopSession.findElementByXPath(Pageobj.workspace), AppPath);
		// rightclick.sendKeys(DesktopSession.findElementByXPath(Pageobj.workspace),
		// AppPath);
		rightclick.perform();
		logger.pass("entered the Workspace path");
		DesktopSession.findElementByName(Pageobj.Launch).click();
		logger.pass("Clicked Ok");
		Thread.sleep(11000);
//		WebElement max = DesktopSession.findElementByXPath(Pageobj.Maximize);
//		rightclick.doubleClick(max).perform();
		logger.pass("Maximized");
		logger.pass("Sencond Application Instance has been launched");
	}

	public void ReadValidationTxt(String Path) throws Exception {

		DesktopSession = Root();
		String fileName = Path + File.separator + "EcuC" + File.separator + "Validation.txt";
		File file = new File(fileName);
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String line;
		String[] data;
		Map<Integer, String> map = new HashedMap();
		int i = 1;
		while ((line = br.readLine()) != null) {
			// process the line
			// System.out.println(line);
			String[] value = line.split(":");
			System.out.println(value[0]);
			if (value[0].contains("INF00000")) {
				map.put(i, value[0]);
				i++;
			}
		}
		System.out.println(map);
		map.get(1);
		Assert.assertEquals(map.get(1), "INF000001");
		Assert.assertEquals(map.get(2), "INF000002");
		Assert.assertEquals(map.get(3), "INF000003");
		Assert.assertEquals(map.get(4), "INF000004");
	}

	public void VerifyDEMModule(String Project) throws Exception {

		DesktopSession = Root();
		Actions act = new Actions(DesktopSession);
		Thread.sleep(5000);
		WebElement proj = DesktopSession.findElementByName(Project);
		logger.pass("Clicked Project");
		act.contextClick(proj).perform();
		Thread.sleep(2000);
		logger.pass("Right Clicked Project");
		DesktopSession.findElementByName(po.ECUC_Mapping).click();
		logger.pass("Clicked ECUC_Mapping");
		DesktopSession.findElementByName("Select/ De-Select All").click();
		logger.pass("Clicked Select/ De-Select All");
		DesktopSession.findElementByName("Select/ De-Select All").click();
		logger.pass("Clicked Select/ De-Select All");
		WebElement dem = DesktopSession.findElementByName("Dem");
		ScrollToElement(dem);
		logger.pass("Scroll to dem");
		Robot rb = new Robot();
		dem.click();
		logger.pass("Clicked dem");
		rb.keyPress(KeyEvent.VK_SPACE);
		rb.keyRelease(KeyEvent.VK_SPACE);
		DesktopSession.findElementByName("Retain Configuration").click();
		logger.pass("Clicked Retain Configuration");
		DesktopSession.findElementByName("Browse").click();
		logger.pass("Clicked Browse");
		rb.keyPress(KeyEvent.VK_RIGHT);
		rb.keyRelease(KeyEvent.VK_RIGHT);
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		rb.keyPress(KeyEvent.VK_RIGHT);
		rb.keyRelease(KeyEvent.VK_RIGHT);
		DesktopSession.findElementByName("LocalParameters_24M_CAN.arxml").click();
		logger.pass("Clicked LocalParameters_24M_CAN.arxml");
		DesktopSession.findElementByName("OK").click();
		logger.pass("Clicked OK");
		DesktopSession.findElementByName("Finish").click();
		logger.pass("Clicked Finish");
		Thread.sleep(3000);
		DesktopSession.findElementByName("EcucDescription.arxml").click();
		logger.pass("Clicked EcucDescription");
		ExpandProject(7);
		logger.pass("Clicked Expand");
		DesktopSession.findElementByName("Dem_0 [Dem]").click();
		logger.pass("Clicked Dem_0");
		ExpandProject(3);
		logger.pass("Clicked Expand");
		DesktopSession.findElementByName("DemDtr_USDs [14]").click();
		logger.pass("Clicked DemDtr_USDs");
		String CountDem = DesktopSession.findElementByName("DemDtr_USDs [14]").getText();
		System.out.println(CountDem);
	}

	public void addModuleGenerateCodes(String Projectname, String arxmlpath) throws Exception {
		DesktopSession = Root();
		Robot rbb = new Robot();
		Actions act = new Actions(DesktopSession);
		Thread.sleep(4000);
		DesktopSession.findElementByName(Projectname).click();
		Thread.sleep(500);
		act.contextClick().build().perform();
		Thread.sleep(2000);
		int j = 0;
		Thread.sleep(1000);
		while (j <= 5) {
			System.out.println(j);
			logger.info("Waiting");
			// Thread.sleep(1000);
			try {
				System.out.println(DesktopSession.findElementByName("Generate Code").isDisplayed() + " -=-=>");

				if (DesktopSession.findElementByName("Generate Code").isDisplayed()) {

					DesktopSession.findElementByName("Generate Code").click();
					break;

				} else {
					Thread.sleep(2000);
				}
			} catch (Exception e) {
				System.out.println(e);
			}
			j++;
		}
		// DesktopSession.findElementByName("Generate Code");
		Thread.sleep(1000);
		DesktopSession.findElementByName("Add").click();
		Thread.sleep(500);
		logger.pass("Clicked on ADD button");
		WebElement adressBar = DesktopSession.findElementByName("File name:");
		adressBar.clear();
		adressBar.click();
		logger.pass("Clicked the Address Field");
		act.sendKeys(adressBar, arxmlpath).perform();
		logger.pass("Entered File Location");
		Thread.sleep(500);
		act.sendKeys(Keys.ENTER).perform();
		logger.pass("Clicked Enter Button");
		String moduleName = DesktopSession.findElementByName("BswM_0 [/AUTOSAR/KPIT/BswM]").getText();
		Assert.assertEquals(moduleName, "BswM_0 [/AUTOSAR/KPIT/BswM]");
		logger.pass("Module name is matching");
	}

	public void validateGenricStucture(String Projectname, String outputPath) throws Exception {
		DesktopSession = Root();
		Robot rbb = new Robot();
		Actions act = new Actions(DesktopSession);
		Thread.sleep(4000);
		DesktopSession.findElementByName(Projectname).click();
		logger.pass("Click on the Project");
		ExpandProject(9);
		logger.pass("Expand on the Project");
		DesktopSession.findElementByName("BswM_0 [BswM]").click();
		logger.pass("Clicked on BswM_0 [BswM] option");
		act.contextClick(DesktopSession.findElementByName("BswM_0 [BswM]")).build().perform();
		logger.pass("Right Clicked on BswM_0 [BswM] option");
		Thread.sleep(1000);
		DesktopSession.findElementByName("Batch Validation").click();
		Thread.sleep(1000);
		logger.pass("Clicked on Batch Validation option");
		DesktopSession.findElementByName(Pageobj.YesButton).click();
		Thread.sleep(500);
		String errorName = DesktopSession.findElementByName("ERR087020: Empty Value (1 item)").getText();
		Assert.assertEquals(errorName, "ERR087020: Empty Value (1 item)");
		logger.pass("Error name is matching");
		DesktopSession.findElementByName("BswM_0 [BswM]").click();
		logger.pass("Clicked on BswM_0 [BswM] option");
		act.contextClick(DesktopSession.findElementByName("BswM_0 [BswM]")).build().perform();
		logger.pass("Right Clicked on BswM_0 [BswM] option");
		Thread.sleep(1000);
		DesktopSession.findElementByName("Generate Code").click();
		Thread.sleep(500);
		logger.pass("Clicked on Generate Code Option");
		String moduleName = DesktopSession.findElementByName("BswM_0 [/AUTOSAR/KPIT/BswM]").getText();
		Assert.assertEquals(moduleName, "BswM_0 [/AUTOSAR/KPIT/BswM]");

		WebElement adressBar = DesktopSession.findElementByName(Pageobj.Output_LocationTextbox);
		adressBar.clear();
		adressBar.click();
		logger.pass("Clicked the Address Field");
		act.sendKeys(adressBar, outputPath).perform();
		logger.pass("Entered File Location");
		Thread.sleep(500);
		DesktopSession.findElementByName(Pageobj.Finish_Button).click();
		logger.pass("Clicked on Finish button");
		Thread.sleep(40000);

		String content = Utility.Read(outputPath);
		if (content.contains("INF000001: Command line arguments: \r\n"
				+ "/plugin/com.kpit.c4k.bsw.bswm/resources/VSMD/AUTOSAR_KPIT_BswM_ECU_Configuration_PDF.arxml\r\n"
				+ "/test1/EcucDescription.arxml\r\n" + "INF000002: Configuration Variant chosen for module \r\n"
				+ "INF000003: <0> Error(s) and <0> Warning(s) detected\r\n"
				+ "INF000004: Execution completed successfully.")) {
			logger.pass("Validation text file matched");

		}

	}

//		logger.pass("Clicked on ADD button");
//		WebElement adressBar = DesktopSession.findElementByName("File name:");
//		adressBar.clear();
//		adressBar.click();
//		logger.pass("Clicked the Address Field");
//		act.sendKeys(adressBar, arxmlpath).perform();
//		logger.pass("Entered File Location");
//		Thread.sleep(500);
//		act.sendKeys(Keys.ENTER).perform();
//		logger.pass("Clicked Enter Button");
//	    String moduleName = DesktopSession.findElementByName("BswM_0 [/AUTOSAR/KPIT/BswM]").getText();
//		Assert.assertEquals(moduleName, "BswM_0 [/AUTOSAR/KPIT/BswM]");
//		logger.pass("Module name is matching");

	public void validatePrefixName(String Projectname, String filepath) throws Exception {
		DesktopSession = Root();
		Robot rbb = new Robot();
		Actions act = new Actions(DesktopSession);
		Thread.sleep(4000);
		DesktopSession.findElementByName(Projectname).click();
		logger.pass("Click on the Project");
		ExpandProject(2);
		logger.pass("Expand on the Project");
		act.contextClick(DesktopSession.findElementByName(Projectname)).build().perform();
		Thread.sleep(1000);
		DesktopSession.findElementByName("Generate Code").click();
		Thread.sleep(500);
		logger.pass("Clicked on Generate Code Option");
		DesktopSession.findElementByName(Pageobj.Select_All).click();
		Thread.sleep(500);
		logger.pass("Clicked on select all Option");
		DesktopSession.findElementByName(Pageobj.Finish_Button).click();
		logger.pass("Clicked on finish button");
		Thread.sleep(200000);
		Utility.getNameOfDir(filepath);
		logger.pass("All the prefix matched");

	}

	public void validatePrefixNameEcuc(String Projectname, String filepath) throws Exception {
		DesktopSession = Root();
		Robot rbb = new Robot();
		Actions act = new Actions(DesktopSession);
		Thread.sleep(4000);
		DesktopSession.findElementByName(Projectname).click();
		logger.pass("Click on the Project");
		ExpandProject(2);
		logger.pass("Expand on the Project");
		act.contextClick(DesktopSession.findElementByName(Projectname)).build().perform();
		Thread.sleep(1000);
		DesktopSession.findElementByName(Pageobj.ECUC_Mapping).click();
		Thread.sleep(500);
		logger.pass("Clicked on ECUC mapping option");
		DesktopSession.findElementByName(Pageobj.Finish_Button).click();
		logger.pass("Clicked on finish button");
		Thread.sleep(10000);
		DesktopSession.findElementByName(Projectname).click();
		logger.pass("Click on the Project");
		ExpandProject(2);
		logger.pass("Expand on the Project");
		act.contextClick(DesktopSession.findElementByName(Projectname)).build().perform();
		Thread.sleep(1000);
		DesktopSession.findElementByName("Generate Code").click();
		Thread.sleep(500);
		logger.pass("Clicked on Generate Code Option");
		DesktopSession.findElementByName(Pageobj.Select_All).click();
		Thread.sleep(500);
		logger.pass("Clicked on select all Option");
		DesktopSession.findElementByName(Pageobj.Finish_Button).click();
		logger.pass("Clicked on finish button");
		Thread.sleep(150000);
		Utility.getNameOfDir(filepath);
		logger.pass("All the prefix matched");

	}

	public void addModuleNpeGenerateCodes(String Projectname, String arxmlpath) throws Exception {
		DesktopSession = Root();
		Robot rbb = new Robot();
		Actions act = new Actions(DesktopSession);
		Thread.sleep(4000);
		DesktopSession.findElementByName(Projectname).click();
		logger.pass("Click on the Project");
		ExpandProject(2);
		logger.pass("Expand on the Project");
		act.contextClick(DesktopSession.findElementByName(Projectname)).build().perform();
		Thread.sleep(1000);
		DesktopSession.findElementByName("Generate Code").click();
		Thread.sleep(500);
		logger.pass("Clicked on Generate Code Option");
		DesktopSession.findElementByName("Add").click();
		Thread.sleep(500);
		logger.pass("Clicked on ADD button");
		WebElement adressBar = DesktopSession.findElementByName("File name:");
		adressBar.clear();
		adressBar.click();
		logger.pass("Clicked the Address Field");
		act.sendKeys(adressBar, arxmlpath).perform();
		logger.pass("Entered File Location");
		Thread.sleep(500);
		act.sendKeys(Keys.ENTER).perform();
		logger.pass("Clicked Enter Button");
		Thread.sleep(100);
		DesktopSession.findElementByName(Pageobj.Select_All).click();
		Thread.sleep(500);
		logger.pass("Clicked on select all Option");
		DesktopSession.findElementByName(Pageobj.Finish_Button).click();
		logger.pass("Clicked on finish button");
		Thread.sleep(60000);
	}

	public void validateComCodeGeneration(String Projectname) throws Exception {
		DesktopSession = Root();
		Robot rbb = new Robot();
		Actions act = new Actions(DesktopSession);
		Thread.sleep(4000);
		DesktopSession.findElementByName(Projectname).click();
		logger.pass("Click on the Project");
		rbb.keyPress(KeyEvent.VK_RIGHT);
		// ExpandProject(9);
		DesktopSession.findElementByName("EcuDescription_CFG9.arxml").click();
		logger.pass("Click on the EcuDescription_CFG9.arxml");
		rbb.keyPress(KeyEvent.VK_RIGHT);
		logger.pass("Expand on the Project");
		DesktopSession.findElementByName("AUTOSAR [AUTOSAR]").click();
		logger.pass("Click on the AUTOSAR [AUTOSAR]");
		rbb.keyPress(KeyEvent.VK_RIGHT);
		DesktopSession.findElementByName("AUTOSAR [ARPackage]").click();
		logger.pass("Click on the AUTOSAR [ARPackage]");
		rbb.keyPress(KeyEvent.VK_RIGHT);
		DesktopSession.findElementByName("BswM_0 [BswM]").click();
		logger.pass("Clicked on BswM_0 [BswM] option");
		act.contextClick(DesktopSession.findElementByName("Com_0 [Com]")).build().perform();
		logger.pass("Right Clicked on Com_0 [Com] option");
		Thread.sleep(1000);
		DesktopSession.findElementByName("Generate Code").click();
		Thread.sleep(500);
		logger.pass("Clicked on Generate Code Option");
		DesktopSession.findElementByName(Pageobj.Finish_Button).click();
		logger.pass("Clicked on finish button");
		Thread.sleep(60000);
	}

	public void CodeGenerationForRte(String Project, String Rtemodule) throws Exception {
		DesktopSession = Root();
		Robot rb = new Robot();
		Actions act = new Actions(DesktopSession);
		Thread.sleep(10000);
		System.out.println(Project);
		WebElement ele = DesktopSession.findElementByName(Project);
		act.click(ele).build().perform();
		Thread.sleep(500);
		act.contextClick().build().perform();
		Thread.sleep(2000);
		int j = 0;
		Thread.sleep(1000);
		while (j <= 5) {
			System.out.println(j);
			logger.info("Waiting");
			// Thread.sleep(1000);
			try {
				System.out.println(DesktopSession.findElementByName("Generate Code").isDisplayed() + " -=-=>");

				if (DesktopSession.findElementByName("Generate Code").isDisplayed()) {

					DesktopSession.findElementByName("Generate Code").click();
					break;

				} else {
					Thread.sleep(2000);
				}
			} catch (Exception e) {
				System.out.println(e);
			}
			j++;
		}
		// DesktopSession.findElementByName("Generate Code");
		Thread.sleep(1000);
		WebElement wb = DesktopSession.findElementByName(Rtemodule);
		DesktopSession.findElementByName(Rtemodule).click();
		rb.keyPress(KeyEvent.VK_SPACE);
		rb.keyRelease(KeyEvent.VK_SPACE);
		Thread.sleep(1000);
		DesktopSession.findElementByName(po.Finish_Button).click();
		String process = "Processing Code Generation........ ";
		int i = 0;
		Thread.sleep(1000);
		while (i <= 9) {
			System.out.println(i);
			logger.info("Waiting");
			Thread.sleep(1000);
			try {
				System.out.println(DesktopSession.findElementByName(process).isEnabled() + " -=-=>");
				System.out.println(DesktopSession.findElementByName("OK").isEnabled());
				DesktopSession.findElementByName("Yes").click();
				if (DesktopSession.findElementByName("OK").isEnabled()) {

					// DesktopSession.findElementByName("OK").click();
					break;

				} else {
					Thread.sleep(2000);
				}
			} catch (Exception e) {
				System.out.println(e);
			}
			i++;
		}
		DesktopSession.findElementByName("OK").click();
		Thread.sleep(1000);

		DesktopSession.findElementByName(Project).click();
		Thread.sleep(500);
		act.contextClick().build().perform();
		Thread.sleep(2000);
		int k = 0;
		Thread.sleep(1000);
		while (k <= 5) {
			System.out.println(j);
			logger.info("Waiting");
			// Thread.sleep(1000);
			try {
				System.out.println(DesktopSession.findElementByName("Generate Code").isDisplayed() + " -=-=>");

				if (DesktopSession.findElementByName("Generate Code").isDisplayed()) {

					DesktopSession.findElementByName("Generate Code").click();
					break;

				} else {
					Thread.sleep(2000);
				}
			} catch (Exception e) {
				System.out.println(e);
			}
			k++;
		}
		// DesktopSession.findElementByName("Generate Code");
		Thread.sleep(1000);
		// WebElement wb = DesktopSession.findElementByName(Rtemodule);
		DesktopSession.findElementByName(Rtemodule).click();
		rb.keyPress(KeyEvent.VK_SPACE);
		rb.keyRelease(KeyEvent.VK_SPACE);

		String WdgM_BSWMD = DesktopSession.findElementByName("WdgM_BSWMD.arxml").getText();
		String RLM_1LR_2LR = DesktopSession.findElementByName("RLM_1LR_2LR\\BSW\\SWC\\ServiceSwPortInterface.arxml")
				.getText();
		String RLM_1LR_2LR1 = DesktopSession.findElementByName("RLM_1LR_2LR\\BAC\\SWC\\StdDiag_ext_interfaces.arxml")
				.getText();
		Assert.assertEquals(WdgM_BSWMD, "WdgM_BSWMD.arxml");
		Assert.assertEquals(RLM_1LR_2LR, "RLM_1LR_2LR\\BSW\\SWC\\ServiceSwPortInterface.arxml");
		Assert.assertEquals(RLM_1LR_2LR1, "RLM_1LR_2LR\\BAC\\SWC\\StdDiag_ext_interfaces.arxml");

	}

	public void addSystemExtractFileVerification(String Projectname, String path) throws Exception {
		DesktopSession = Root();
		Robot rbb = new Robot();
		Actions act = new Actions(DesktopSession);
		Thread.sleep(4000);
		DesktopSession.findElementByName(Projectname).click();
		logger.pass("Click on the Project");
		ExpandProject(9);
		logger.pass("Expand on the Project");
		DesktopSession.findElementByName("Rte_0 [Rte]").click();
		logger.pass("Clicked on Rte_0 [Rte] option");
		act.contextClick().build().perform();
		logger.pass("Right Clicked on Rte_0 [Rte] module option");
		Thread.sleep(1000);
		DesktopSession.findElementByName("Generate Code").click();
		Thread.sleep(500);
		logger.pass("Clicked on Generate Code Option");
		DesktopSession.findElementByName("Rte_0 [/KPIT/EcucDefs/Rte]").click();
		logger.pass("Clicked on Rte Option");

		List<WebElement> edit = DesktopSession.findElementsByClassName("Button");
		System.out.println(edit.size() + " =-= -=> ");
		for (int i = 0; i <= edit.size() - 1; i++) {
			System.out.println(edit.get(i).getAttribute("AutomationId") + " =-=-7u> " + i);
			String text = edit.get(i).getAttribute("Name");
			System.out.println(text + "  =-sc-=- > " + i);
		}

		edit.get(11).click();
		// DesktopSession.findElementByName("Add").click();
		DesktopSession.findElementByName("File name:").click();
		WebElement adressBar = DesktopSession.findElementByName("File name:");
		// adressBar.clear();
		// adressBar.click();
		logger.pass("Clicked the Address Field");
		act.sendKeys(adressBar, path).perform();
		logger.pass("Entered File Location");
		Thread.sleep(500);
		act.sendKeys(Keys.ENTER).perform();
		logger.pass("Clicked Enter Button");
		Thread.sleep(1000);

		DesktopSession.findElementByName(Pageobj.Finish_Button).click();

		String process = "Processing Code Generation........ ";
		int i = 0;
		Thread.sleep(1000);
		while (i <= 9) {
			System.out.println(i);
			logger.info("Waiting");
			Thread.sleep(1000);
			try {
				System.out.println(DesktopSession.findElementByName(process).isEnabled() + " -=-=>");
				System.out.println(DesktopSession.findElementByName("OK").isEnabled());
				DesktopSession.findElementByName("Yes").click();
				if (DesktopSession.findElementByName("OK").isEnabled()) {

					// DesktopSession.findElementByName("OK").click();
					break;

				} else {
					Thread.sleep(2000);
				}
			} catch (Exception e) {
				System.out.println(e);
			}
			i++;
		}
		DesktopSession.findElementByName("OK").click();
		Thread.sleep(1000);

		DesktopSession.findElementByName(Projectname).click();
		Thread.sleep(500);
		act.contextClick().build().perform();
		Thread.sleep(2000);
		int k = 0;
		Thread.sleep(1000);
		while (k <= 5) {
			System.out.println(k);
			logger.info("Waiting");
			// Thread.sleep(1000);
			try {
				System.out.println(DesktopSession.findElementByName("Generate Code").isDisplayed() + " -=-=>");

				if (DesktopSession.findElementByName("Generate Code").isDisplayed()) {

					DesktopSession.findElementByName("Generate Code").click();
					break;

				} else {
					Thread.sleep(2000);
				}
			} catch (Exception e) {
				System.out.println(e);
			}
			k++;
		}
		// DesktopSession.findElementByName("Generate Code");
		Thread.sleep(1000);
		// WebElement wb = DesktopSession.findElementByName(Rtemodule);
		DesktopSession.findElementByName("Rte_0 [/KPIT/EcucDefs/Rte]").click();
		rbb.keyPress(KeyEvent.VK_SPACE);
		rbb.keyRelease(KeyEvent.VK_SPACE);

		String filename = DesktopSession.findElementByName("Flexray_system_file.arxml").getText();
		Assert.assertEquals("Flexray_system_file.arxml", filename);
		logger.pass("Input File name is matching");

	}

	public void toolRememberTheInputs(String Projectname, String path) throws Exception {
		DesktopSession = Root();
		Robot rbb = new Robot();
		Actions act = new Actions(DesktopSession);
		Thread.sleep(4000);
		DesktopSession.findElementByName(Projectname).click();
		logger.pass("Click on the Project");
		ExpandProject(9);
		logger.pass("Expand on the Project");
		DesktopSession.findElementByName("Rte_0 [Rte]").click();
		logger.pass("Clicked on Rte_0 [Rte] option");
		act.contextClick().build().perform();
		logger.pass("Right Clicked on Rte_0 [Rte] module option");
		Thread.sleep(1000);
		DesktopSession.findElementByName("Generate Code").click();
		Thread.sleep(500);
		logger.pass("Clicked on Generate Code Option");
		DesktopSession.findElementByName("Rte_0 [/KPIT/EcucDefs/Rte]").click();
		logger.pass("Clicked on Rte Option");

		List<WebElement> edit = DesktopSession.findElementsByClassName("Button");
		System.out.println(edit.size() + " =-= -=> ");
		for (int i = 0; i <= edit.size() - 1; i++) {
			String text = edit.get(i).getAttribute("Name");
			System.out.println(text + "  =-sc-=- > " + i);

		}
		edit.get(15).click();
		// DesktopSession.findElementByName("Add").click();
		WebElement adressBar = DesktopSession.findElementByName("File name:");
		adressBar.clear();
		adressBar.click();
		logger.pass("Clicked the Address Field");
		act.sendKeys(adressBar, path).perform();
		logger.pass("Entered File Location");
		Thread.sleep(500);
		act.sendKeys(Keys.ENTER).perform();
		logger.pass("Clicked Enter Button");
		Thread.sleep(1000);
		DesktopSession.findElementByName(Pageobj.Finish_Button).click();

		String process = "Processing Code Generation........ ";
		int i = 0;
		Thread.sleep(1000);
		while (i <= 9) {
			System.out.println(i);
			logger.info("Waiting");
			Thread.sleep(1000);
			try {
				System.out.println(DesktopSession.findElementByName(process).isEnabled() + " -=-=>");
				System.out.println(DesktopSession.findElementByName("OK").isEnabled());
				DesktopSession.findElementByName("Yes").click();
				if (DesktopSession.findElementByName("OK").isEnabled()) {

					// DesktopSession.findElementByName("OK").click();
					break;

				} else {
					Thread.sleep(2000);
				}
			} catch (Exception e) {
				System.out.println(e);
			}
			i++;
		}
		DesktopSession.findElementByName("OK").click();
		Thread.sleep(1000);

		DesktopSession.findElementByName(Projectname).click();
		Thread.sleep(500);
		act.contextClick().build().perform();
		Thread.sleep(2000);
		int k = 0;
		Thread.sleep(1000);
		while (k <= 5) {
			System.out.println(k);
			logger.info("Waiting");
			// Thread.sleep(1000);
			try {
				System.out.println(DesktopSession.findElementByName("Generate Code").isDisplayed() + " -=-=>");

				if (DesktopSession.findElementByName("Generate Code").isDisplayed()) {

					DesktopSession.findElementByName("Generate Code").click();
					break;

				} else {
					Thread.sleep(2000);
				}
			} catch (Exception e) {
				System.out.println(e);
			}
			k++;
		}
		// DesktopSession.findElementByName("Generate Code");
		Thread.sleep(1000);
		// WebElement wb = DesktopSession.findElementByName(Rtemodule);
		DesktopSession.findElementByName("Rte_0 [Rte]").click();
		rbb.keyPress(KeyEvent.VK_SPACE);
		rbb.keyRelease(KeyEvent.VK_SPACE);

		String filename = DesktopSession.findElementByName("Flexray_system_file.arxml").getText();
		Assert.assertEquals("Flexray_system_file.arxml", filename);
		logger.pass("Input File name is matching");

	}

	public void saveConfigValidation(String Projectname) throws Exception {
		DesktopSession = Root();
		Robot rbb = new Robot();
		Actions act = new Actions(DesktopSession);
		Thread.sleep(4000);
		DesktopSession.findElementByName(Projectname).click();
		logger.pass("Click on the Project");
		rbb.keyPress(KeyEvent.VK_RIGHT);
		DesktopSession.findElementByName("SYSTEM").click();
		rbb.keyPress(KeyEvent.VK_RIGHT);
		DesktopSession.findElementByName("EcuExtract_CFG9.arxml").click();
		rbb.keyPress(KeyEvent.VK_RIGHT);
		rbb.keyPress(KeyEvent.VK_DOWN);
		rbb.keyPress(KeyEvent.VK_RIGHT);
		DesktopSession.findElementByName("AR_Composition [ARPackage]").click();
		act.contextClick().build().perform();
		Thread.sleep(3000);
		// WebElement ele= DesktopSession.findElementByName("New Child");
		// ele.click();
		// act.contextClick().moveToElement(ele).click().build().perform();

		// Thread.sleep(200);

		rbb.keyPress(KeyEvent.VK_DOWN);
		rbb.keyRelease(KeyEvent.VK_DOWN);
		rbb.keyPress(KeyEvent.VK_RIGHT);
		rbb.keyRelease(KeyEvent.VK_RIGHT);

		WebElement ele1 = DesktopSession.findElementByName("Elements");
		act.moveToElement(ele1).click().build().perform();
		Thread.sleep(200);
		WebElement ele2 = DesktopSession.findElementByName("Application Sw Component Type");
		act.moveToElement(ele2).click().build().perform();
		Thread.sleep(1000);
		String option = DesktopSession.findElementByName("ApplicationSwComponentType [ApplicationSwComponentType]")
				.getText();
		Assert.assertEquals("ApplicationSwComponentType [ApplicationSwComponentType]", option);

		DesktopSession.findElementByName(Projectname).click();
		Thread.sleep(500);
		act.contextClick().build().perform();
		Thread.sleep(2000);
		int j = 0;
		Thread.sleep(1000);
		while (j <= 5) {
			System.out.println(j);
			logger.info("Waiting");
			// Thread.sleep(1000);
			try {
				System.out.println(DesktopSession.findElementByName("Generate Code").isDisplayed() + " -=-=>");

				if (DesktopSession.findElementByName("Generate Code").isDisplayed()) {

					DesktopSession.findElementByName("Generate Code").click();
					break;

				} else {
					Thread.sleep(2000);
				}
			} catch (Exception e) {
				System.out.println(e);
			}
			j++;
		}
		// DesktopSession.findElementByName("Generate Code");
		Thread.sleep(1000);
		WebElement wb = DesktopSession.findElementByName("Rte_0 [/KPIT/EcucDefs/Rte]");
		DesktopSession.findElementByName("Rte_0 [/KPIT/EcucDefs/Rte]").click();
		rbb.keyPress(KeyEvent.VK_SPACE);
		rbb.keyRelease(KeyEvent.VK_SPACE);
		Thread.sleep(1000);
		DesktopSession.findElementByName(po.Finish_Button).click();
		Thread.sleep(1000);
		DesktopSession.findElementByName(po.YesButton).click();

	}

	public void RenameEcucFile(String Project, String Renamechar, String filename) throws Exception {

		DesktopSession = Root();
		Actions act = new Actions(DesktopSession);
		Thread.sleep(5000);
		WebElement proj = DesktopSession.findElementByName(Project);
		logger.pass("Clicked Project");
		ExpandProject(2);
		logger.pass("Expand Project");
		DesktopSession.findElementByName("ECUC").click();
		logger.pass("click ECUC");
		ExpandProject(2);
		logger.pass("Expand ECUC");
		DesktopSession.findElementByName(filename).click();
		logger.pass("click EcucDescription_arxml");
		act.contextClick(DesktopSession.findElementByName(filename)).build().perform();
		logger.pass("Right click EcucDescription_arxml");
		Thread.sleep(500);
		DesktopSession.findElementByName(po.RenameContext).click();
		List<WebElement> lst = DesktopSession.findElementsByClassName("Edit");
		System.out.println(lst.size());
		lst.get(1).click();
		logger.pass("Click EcucDescription_arxml rename field");
		// DesktopSession.findElementByName(po.Renamefield).click();
		String select = Keys.chord(Keys.CONTROL, "a");
		act.sendKeys(lst.get(1), select);
		act.perform();

		lst.get(1).sendKeys(Renamechar);
		logger.pass("Rename EcucDescription_arxml rename field");
		DesktopSession.findElementByName("OK").click();
		logger.pass("Clicked Ok");
		Thread.sleep(500);
	}

	public void AddContainerToDefaultArxml(String project, String module) throws Exception {

		DesktopSession = Root();
		Actions act = new Actions(DesktopSession);
		Robot rb = new Robot();
		Thread.sleep(3000);
		DesktopSession.findElementByName(project).click();
		logger.pass("Clicked on project");
		ExpandProject(4);
		logger.pass("expand the Default arxml");
		DesktopSession.findElementByName(Pageobj.ARPackage).click();
		act.contextClick().perform();
		Thread.sleep(1000);
		// DesktopSession.findElementByName(Pageobj.ModuleConfigurationLabel).click();
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		rb.keyPress(KeyEvent.VK_RIGHT);
		rb.keyRelease(KeyEvent.VK_RIGHT);
		Thread.sleep(1000);
		DesktopSession.findElementByName(Pageobj.Autosar_KPIT).click();
		Thread.sleep(1000);
		DesktopSession.findElementByName(module).click();
		// DesktopSession.findElementByName("Crc").click();
		Thread.sleep(1000);

	}

	public void GenerateCodeToParticularDir(String Projectname, String modules, String dirPath) throws Exception {

		DesktopSession = Root();
		Robot rbb = new Robot();
		Actions act = new Actions(DesktopSession);
		Thread.sleep(4000);
		DesktopSession.findElementByName(Projectname).click();
		logger.pass("Click on the Project");
		ExpandProject(2);
		logger.pass("Expand on the Project");
		act.contextClick(DesktopSession.findElementByName(Projectname)).build().perform();
		Thread.sleep(1000);
		DesktopSession.findElementByName("Generate Code").click();
		Thread.sleep(500);
		DesktopSession.findElementByName(modules).click();
		rbb.keyPress(KeyEvent.VK_SPACE);
		rbb.keyRelease(KeyEvent.VK_SPACE);
		List<WebElement> lst = DesktopSession.findElementsByClassName("Edit");
		System.out.println(lst.size() + " 0-0-=-=---> ");
		for (int i = 0; i <= lst.size() - 1; i++) {
			String value = lst.get(i).getAttribute("Value.Value");
			System.out.println(value + " ~~~~~~~~> " + i);
		}
		lst.get(lst.size() - 1).click();
		logger.pass("Click output location field");
		// DesktopSession.findElementByName(po.Renamefield).click();
		String select = Keys.chord(Keys.CONTROL, "a");
		act.sendKeys(lst.get(lst.size() - 1), select);
		act.perform();
		lst.get(lst.size() - 1).sendKeys(dirPath);
		logger.pass("Enter desire Dir");
		DesktopSession.findElementByName(po.Finish_Button).click();
		String process = "Processing Code Generation........                                ";
		int i = 0;
		Thread.sleep(1000);

		while (i <= 12) {
			System.out.println(i);
			logger.info("Waiting");
			Thread.sleep(2000);
			try {
				System.out.println(DesktopSession.findElementByName(process).isEnabled() + " -=-=>");
				System.out.println(DesktopSession.findElementByName("OK").isEnabled());
				DesktopSession.findElementByName("Yes").click();
				if (DesktopSession.findElementByName("OK").isEnabled()) {

					// DesktopSession.findElementByName("OK").click();
					break;

				} else {
					Thread.sleep(2000);
				}
			} catch (Exception e) {
				System.out.println(e);
			}
			i++;
		}
		DesktopSession.findElementByName("OK").click();
		Thread.sleep(1000);
	}

	public void VerifySelectAllButton(String Projectname) throws Exception {

		DesktopSession = Root();
		Robot rbb = new Robot();
		Actions act = new Actions(DesktopSession);
		Thread.sleep(4000);
		DesktopSession.findElementByName(Projectname).click();
		logger.pass("Click on the Project");
		ExpandProject(2);
		logger.pass("Expand on the Project");
		act.contextClick(DesktopSession.findElementByName(Projectname)).build().perform();
		Thread.sleep(1000);
		DesktopSession.findElementByName("Generate Code").click();
		Thread.sleep(500);
		boolean flag = DesktopSession.findElementByName(po.Select_All).isEnabled();
		System.out.println(flag + " Before clicking Selectall");
		logger.pass("Click on the Project");
		boolean flagd = DesktopSession.findElementByName(po.Deselect_All).isEnabled();
		System.out.println(flagd + " Before clicking Selectall");
		logger.pass("Before clicking Selectall");
		DesktopSession.findElementByName(po.Select_All).click();
		logger.pass("Clicking Selectall");
		boolean flagafter = DesktopSession.findElementByName(po.Select_All).isEnabled();
		System.out.println(flagafter + " After clicking Selectall");
		logger.pass("After clicking Selectall");
		boolean flagafterd = DesktopSession.findElementByName(po.Deselect_All).isEnabled();
		System.out.println(flagafterd + " After clicking Selectall");
		logger.pass("After clicking Selectall");
		Assert.assertEquals(flag, flagafterd);
		Assert.assertEquals(flagafter, flagd);
		logger.pass("Assertion done");

	}

	public void AddContainerToECUCDescription(String project, String module) throws Exception {

		DesktopSession = Root();
		Actions act = new Actions(DesktopSession);
		Robot rb = new Robot();
		Thread.sleep(3000);
		DesktopSession.findElementByName(project).click();
		logger.pass("Clicked on project");
		ExpandProject(7);
		logger.pass("expand the Default arxml");
		DesktopSession.findElementByName(Pageobj.ECUC_ARpackage).click();
		act.contextClick().perform();
		Thread.sleep(1000);
		// DesktopSession.findElementByName(Pageobj.ModuleConfigurationLabel).click();
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		rb.keyPress(KeyEvent.VK_RIGHT);
		rb.keyRelease(KeyEvent.VK_RIGHT);
		Thread.sleep(1000);
		DesktopSession.findElementByName(Pageobj.Autosar_KPIT).click();
		Thread.sleep(1000);
		DesktopSession.findElementByName(module).click();
		// DesktopSession.findElementByName("Crc").click();
		Thread.sleep(1000);
	}

	public void GenerateECUCMapping(String Project) throws Exception {

		DesktopSession = Root();
		Actions act = new Actions(DesktopSession);
		Robot rb = new Robot();
		Thread.sleep(3000);
		DesktopSession.findElementByName(Project).click();
		logger.pass("Clicked on project");
		act.contextClick(DesktopSession.findElementByName(Project)).build().perform();
		logger.pass("Right Click on project");
		Thread.sleep(500);
		DesktopSession.findElementByName(po.ECUC_Mapping).click();
		logger.pass("Click on Ecuc Mapping");
		Thread.sleep(500);
		DesktopSession.findElementByName(po.Finish_Button).click();
		logger.pass("Click on Finish");
		Thread.sleep(2000);
	}

	public void selectModuleCodeGeneration(String module) throws Exception {

		DesktopSession = Root();
		Robot rbb = new Robot();
		Actions act = new Actions(DesktopSession);
		Thread.sleep(500);
		DesktopSession.findElementByName(module).click();
		rbb.keyPress(KeyEvent.VK_SPACE);
		rbb.keyRelease(KeyEvent.VK_SPACE);
	}

	public void CodeGenerationToSpecificDir(String path) throws Exception {
		DesktopSession = Root();
		Robot rbb = new Robot();
		Actions act = new Actions(DesktopSession);
		Thread.sleep(1000);
		List<WebElement> lst = DesktopSession.findElementsByClassName("Edit");
		System.out.println(lst.size() + " 0-0-=-=---> ");
		for (int i = 0; i <= lst.size() - 1; i++) {
			String value = lst.get(i).getAttribute("Value.Value");
			System.out.println(value + " ~~~~~~~~> " + i);
		}
		lst.get(lst.size() - 1).click();
		logger.pass("Click output location field");
		// DesktopSession.findElementByName(po.Renamefield).click();
		String select = Keys.chord(Keys.CONTROL, "a");
		act.sendKeys(lst.get(lst.size() - 1), select);
		act.perform();
		lst.get(lst.size() - 1).sendKeys(path);
		logger.pass("Enter desire Dir");
		DesktopSession.findElementByName(po.Finish_Button).click();
		String process = "Processing Code Generation........                                ";
		int i = 0;
		Thread.sleep(1000);
		while (i <= 9) {
			System.out.println(i);
			logger.info("Waiting");
			Thread.sleep(1000);
			try {
				System.out.println(DesktopSession.findElementByName(process).isEnabled() + " -=-=>");
				System.out.println(DesktopSession.findElementByName("OK").isEnabled());
				DesktopSession.findElementByName("Yes").click();
				if (DesktopSession.findElementByName("OK").isEnabled()) {

					// DesktopSession.findElementByName("OK").click();
					break;

				} else {
					Thread.sleep(2000);
				}
			} catch (Exception e) {
				System.out.println(e);
			}
			i++;
		}
		DesktopSession.findElementByName("OK").click();
		Thread.sleep(1000);
	}

	public void VerifyOptionAllbutton(String project, String module) throws Exception {

		DesktopSession = Root();
		Robot rb = new Robot();
		Actions act = new Actions(DesktopSession);
		Thread.sleep(3000);
		DesktopSession.findElementByName(project).click();
		logger.pass("Clicked on project");
		ExpandProject(7);
		logger.pass("expand the Default arxml");
		DesktopSession.findElementByName("ARRoot [ARPackage]").click();
		act.contextClick().perform();
		Thread.sleep(1000);
		// DesktopSession.findElementByName(Pageobj.ModuleConfigurationLabel).click();
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		rb.keyPress(KeyEvent.VK_RIGHT);
		rb.keyRelease(KeyEvent.VK_RIGHT);
		Thread.sleep(1000);
		DesktopSession.findElementByName(Pageobj.Autosar_Ecuc_Defs).click();
		logger.pass("Clicked on Autosar_Ecuc_Defs");
		Thread.sleep(1000);
		DesktopSession.findElementByName(module).click();
		logger.pass("Clicked on Rte");
		// DesktopSession.findElementByName("Crc").click();
		Thread.sleep(1000);
		act.contextClick(DesktopSession.findElementByName("TestDemo")).build().perform();
		Thread.sleep(1000);
		logger.pass("Right Click on Project");
		DesktopSession.findElementByName("Generate Code").click();
		logger.pass("Clicked on Generate Code");
		Thread.sleep(500);
		selectModuleCodeGeneration("Rte_0 [/KPIT/EcucDefs/Rte]");
		boolean flag = DesktopSession.findElementByName("Options").isEnabled();
		System.out.println(flag);
		DesktopSession.findElementByName("Options").click();
		logger.pass("Clicked Option");
		Thread.sleep(500);
		boolean Add = DesktopSession.findElementByName("Add").isDisplayed();
		boolean Clear = DesktopSession.findElementByName("Clear").isDisplayed();
		boolean Add_All = DesktopSession.findElementByName("Add All").isDisplayed();
		boolean Edit = DesktopSession.findElementByName("Edit").isDisplayed();
		boolean Delete = DesktopSession.findElementByName("Delete").isDisplayed();
		boolean Restore = DesktopSession.findElementByName("Restore").isDisplayed();
		boolean OK = DesktopSession.findElementByName("OK").isDisplayed();
		boolean Cancel = DesktopSession.findElementByName("Cancel").isDisplayed();
		DesktopSession.findElementByName("OK").click();
		logger.pass("Clicked Cancel");
		System.out.println(Add + " =-=> " + Clear + " =-=> " + Add_All + " =-=> " + Edit + " =-=> " + Delete + " =-=> "
				+ Restore + " =-=> " + OK + " =-=> " + Cancel);
		Assert.assertEquals(Add, true);
		Assert.assertEquals(Cancel, true);
		Assert.assertEquals(Clear, true);
		Assert.assertEquals(Add_All, true);
		Assert.assertEquals(Edit, true);
		Assert.assertEquals(Delete, true);
		Assert.assertEquals(Restore, true);
		Assert.assertEquals(OK, true);
		Assert.assertEquals(flag, true);
		DesktopSession.findElementByName("Cancel").click();
	}

	public void CodeGenerationDiffFiles(String project) throws Exception {

		DesktopSession = Root();
		Robot rb = new Robot();
		Actions act = new Actions(DesktopSession);
		Thread.sleep(3000);
		DesktopSession.findElementByName(project).click();
		logger.pass("Clicked on project");
		ExpandProject(2);
		logger.pass("expand the Default arxml");
		List<WebElement> lstd = DesktopSession.findElementsByName(po.default_arxml);
		System.out.println(lstd.size() + " =-=-09--> ");
		lstd.get(1).click();
		ExpandProject(3);
		logger.pass("expand the Default arxml");
		DesktopSession.findElementByName(Pageobj.ARPackage).click();
		act.contextClick().perform();
		Thread.sleep(1000);
		// DesktopSession.findElementByName(Pageobj.ModuleConfigurationLabel).click();
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		rb.keyPress(KeyEvent.VK_RIGHT);
		rb.keyRelease(KeyEvent.VK_RIGHT);
		Thread.sleep(1000);
		DesktopSession.findElementByName(Pageobj.Autosar_KPIT).click();
		Thread.sleep(1000);
		DesktopSession.findElementByName("Com").click();
		// DesktopSession.findElementByName("Crc").click();
		Thread.sleep(1000);
		List<WebElement> lstd1 = DesktopSession.findElementsByName("default1.arxml");
		System.out.println(lstd1.size() + " =-=-04e9--> ");
		for (int i = 0; i <= lstd1.size() - 1; i++) {
			String val = lstd1.get(i).getAttribute("FrameworkId");
			System.out.println(val + " 0987654=-=-> " + i);
		}
		lstd1.get(lstd1.size() - 1).click();
		ExpandProject(3);
		logger.pass("expand the Default arxml");
		List<WebElement> lstA = DesktopSession.findElementsByName(Pageobj.ARPackage);
		System.out.println(lstA.size() + " =-=-=-789=->");
		lstA.get(1).click();
		act.contextClick().perform();
		Thread.sleep(1000);
		// DesktopSession.findElementByName(Pageobj.ModuleConfigurationLabel).click();
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		rb.keyPress(KeyEvent.VK_RIGHT);
		rb.keyRelease(KeyEvent.VK_RIGHT);
		Thread.sleep(1000);
		DesktopSession.findElementByName(Pageobj.Autosar_KPIT).click();
		Thread.sleep(1000);
		DesktopSession.findElementByName("EcuC").click();
		// DesktopSession.findElementByName("Crc").click();
		Thread.sleep(1000);
		DesktopSession.findElementByName(project).click();
		act.contextClick().perform();
		Thread.sleep(1000);
		DesktopSession.findElementByName("Generate Code").click();
		Thread.sleep(500);
		selectModuleCodeGeneration("Com_0 [/AUTOSAR/KPIT/Com]");
		selectModuleCodeGeneration("EcuC_0 [/AUTOSAR/KPIT/EcuC]");
		String DirPath = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator
				+ "CodeGenerationFiles";
		CodeGenerationToSpecificDir(DirPath);
	}

	public void CodeGenerationMultipleArxml(String project) throws Exception {

		DesktopSession = Root();
		Robot rb = new Robot();
		Actions act = new Actions(DesktopSession);
		Thread.sleep(3000);
		DesktopSession.findElementByName(project).click();
		logger.pass("Clicked on project");
		ExpandProject(2);
		logger.pass("expand the Default arxml");
		List<WebElement> lstd = DesktopSession.findElementsByName(po.default_arxml);
		System.out.println(lstd.size() + " =-=-09--> ");
		lstd.get(1).click();
		ExpandProject(3);
		logger.pass("expand the Default arxml");
		DesktopSession.findElementByName(Pageobj.ARPackage).click();
		act.contextClick().perform();
		Thread.sleep(1000);
		// DesktopSession.findElementByName(Pageobj.ModuleConfigurationLabel).click();
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		rb.keyPress(KeyEvent.VK_RIGHT);
		rb.keyRelease(KeyEvent.VK_RIGHT);
		Thread.sleep(1000);
		DesktopSession.findElementByName(Pageobj.Autosar_KPIT).click();
		Thread.sleep(1000);
		DesktopSession.findElementByName("Com").click();
		// DesktopSession.findElementByName("Crc").click();
		Thread.sleep(1000);
		List<WebElement> lstd1 = DesktopSession.findElementsByName("default1.arxml");
		System.out.println(lstd1.size() + " =-=-04e9--> ");
		for (int i = 0; i <= lstd1.size() - 1; i++) {
			String val = lstd1.get(i).getAttribute("FrameworkId");
			System.out.println(val + " 0987654=-=-> " + i);
		}
		lstd1.get(lstd1.size() - 1).click();
		ExpandProject(3);
		logger.pass("expand the Default arxml");
		List<WebElement> lstA = DesktopSession.findElementsByName(Pageobj.ARPackage);
		System.out.println(lstA.size() + " =-=-=-789=->");
		lstA.get(1).click();
		act.contextClick().perform();
		Thread.sleep(1000);
		// DesktopSession.findElementByName(Pageobj.ModuleConfigurationLabel).click();
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		rb.keyPress(KeyEvent.VK_RIGHT);
		rb.keyRelease(KeyEvent.VK_RIGHT);
		Thread.sleep(1000);
		DesktopSession.findElementByName(Pageobj.Autosar_KPIT).click();
		Thread.sleep(1000);
		DesktopSession.findElementByName("EcuC").click();
		// DesktopSession.findElementByName("Crc").click();
		Thread.sleep(1000);
		DesktopSession.findElementByName(project).click();
		Thread.sleep(500);
		DesktopSession.findElementByName(project).click();
		rb.keyPress(KeyEvent.VK_CONTROL);
		lstd.get(1).click();
		lstd1.get(lstd1.size() - 1).click();
		// lstA.get(1).click();
		rb.keyRelease(KeyEvent.VK_CONTROL);
		act.contextClick().perform();
		Thread.sleep(1000);
		DesktopSession.findElementByName("Generate Code").click();
		Thread.sleep(500);
		selectModuleCodeGeneration("Com_0 [/AUTOSAR/KPIT/Com]");
		selectModuleCodeGeneration("EcuC_0 [/AUTOSAR/KPIT/EcuC]");
		String DirPath = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator
				+ "CodeGenerationFiles";
		// Thread.sleep(1000);
		DesktopSession = Root();
		List<WebElement> lst = DesktopSession.findElementsByClassName("Edit");
		System.out.println(lst.size() + " 0-0-=-=---> ");
		for (int i = 0; i <= lst.size() - 1; i++) {
			String value = lst.get(i).getAttribute("Value.Value");
			System.out.println(value + " ~~~~~~~~> " + i);
		}
		lst.get(lst.size() - 1).click();
		logger.pass("Click output location field");
		// DesktopSession.findElementByName(po.Renamefield).click();
		String select = Keys.chord(Keys.CONTROL, "a");
//		act.sendKeys(lst.get(lst.size()-1), select);
//		act.perform();
		lst.get(lst.size() - 1).sendKeys(select);
		lst.get(lst.size() - 1).sendKeys(DirPath);
		logger.pass("Enter desire Dir");
		DesktopSession.findElementByName(po.Finish_Button).click();
		String process = "Processing Code Generation........                                ";
		int i = 0;
		Thread.sleep(1500);
		while (i <= 12) {
			System.out.println(i);
			logger.info("Waiting");
			Thread.sleep(2000);
			try {
				System.out.println(DesktopSession.findElementByName(process).isEnabled() + " -=-=>");
				System.out.println(DesktopSession.findElementByName("OK").isEnabled());
				DesktopSession.findElementByName("Yes").click();
				if (DesktopSession.findElementByName("OK").isEnabled()) {

					// DesktopSession.findElementByName("OK").click();
					break;

				} else {
					Thread.sleep(2000);
				}
			} catch (Exception e) {
				System.out.println(e);
			}
			i++;
		}

		DesktopSession.findElementByName("OK").click();
		Thread.sleep(1000);
	}

	public void VerifyToolHang(String project) throws Exception {
		DesktopSession = Root();
		Robot rb = new Robot();
		Actions act = new Actions(DesktopSession);
		int length = 5;
		boolean useLetters = true;
		boolean useNumbers = true;
		String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
		System.out.println(generatedString + "  =-===>  ");
		Thread.sleep(3000);
		DesktopSession.findElementByName(project).click();
		logger.pass("Click on the Project");
		ExpandProject(2);
		logger.pass("Expand on the Project");
		act.contextClick(DesktopSession.findElementByName(project)).build().perform();
		Thread.sleep(1000);
		DesktopSession.findElementByName("Generate Code").click();
		Thread.sleep(500);
		String DirPath = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator
				+ "CodeGenerationFiles" + File.separator + generatedString;
		selectModuleCodeGeneration("EcuC_0 [/AUTOSAR/KPIT/EcuC]");
		selectModuleCodeGeneration("Crc_0 [/AUTOSAR/KPIT/Crc]");
		Thread.sleep(1000);
		List<WebElement> lst = DesktopSession.findElementsByClassName("Edit");
		System.out.println(lst.size() + " 0-0-=-=---> ");
		for (int i = 0; i <= lst.size() - 1; i++) {
			String value = lst.get(i).getAttribute("Value.Value");
			System.out.println(value + " ~~~~~~~~> " + i);
		}
		lst.get(lst.size() - 1).click();
		logger.pass("Click output location field");
		// DesktopSession.findElementByName(po.Renamefield).click();
		String select = Keys.chord(Keys.CONTROL, "a");
		lst.get(lst.size() - 1).sendKeys(select);
		lst.get(lst.size() - 1).sendKeys(DirPath);
		logger.pass("Enter desire Dir");
		DesktopSession.findElementByName("Finish").click();
		Thread.sleep(1000);
		try {
			DesktopSession.findElementByName("Yes").click();
		} catch (Exception e) {
			// TODO: handle exception
		}
		DesktopSession.findElementByName("Cancel All").click();
		logger.pass("Click Cancel All");
		File file = new File(DirPath);
		String[] names = file.list();
		for (int j = 0; j <= names.length - 1; j++) {
			String val = names[j];
			System.out.println(val + " -=-=-> " + j);

		}
		String folder = names[0];
		System.out.println(folder + " -=-=-=-> ");
		Assert.assertEquals(folder, "workspace");
	}

	public void VerifyInputSectionFile(String Project) throws Exception {

		DesktopSession = Root();
		Robot rb = new Robot();
		Actions act = new Actions(DesktopSession);
		int length = 5;
		boolean useLetters = true;
		boolean useNumbers = true;
		String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
		System.out.println(generatedString + "  =-===>  ");
		DesktopSession.findElementByName(Project).click();
		logger.pass("Click on the Project");
		ExpandProject(2);
		logger.pass("Expand on the Project");
		act.contextClick(DesktopSession.findElementByName(Project)).build().perform();
		Thread.sleep(1000);
		DesktopSession.findElementByName("Generate Code").click();
		Thread.sleep(500);
		String DirPath = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator
				+ "CodeGenerationFiles" + File.separator + generatedString;
		WebElement wb = DesktopSession.findElementByName("BswM_0 [/AUTOSAR/KPIT/BswM]");
		ScrollToElement(wb);
		selectModuleCodeGeneration("BswM_0 [/AUTOSAR/KPIT/BswM]");
		List<WebElement> lstN = DesktopSession.findElementsByXPath("//*[@LocalizedControlType='text']");
		System.out.println(lstN.size() + " =-=->  ");
		String filename = "";
		for (int k = 0; k <= lstN.size() - 1; k++) {
			String val = lstN.get(k).getAttribute("Name");
			System.out.println(val);
			try {
				if (val.equalsIgnoreCase("PlatformTypes.arxml")) {
					filename = val;
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		List<WebElement> lst = DesktopSession.findElementsByClassName("Edit");
		System.out.println(lst.size() + " 0-0-=-=---> ");
		for (int i = 0; i <= lst.size() - 1; i++) {
			String value = lst.get(i).getAttribute("Value.Value");
			System.out.println(value + " ~~~~~~~~> " + i);
		}
		lst.get(lst.size() - 1).click();
		logger.pass("Click output location field");
		String select = Keys.chord(Keys.CONTROL, "a");
		lst.get(lst.size() - 1).sendKeys(select);
		lst.get(lst.size() - 1).sendKeys(DirPath);
		logger.pass("Enter desire Dir");
		DesktopSession.findElementByName(po.Finish_Button).click();
		String process = "Processing Code Generation........                                ";
		int i = 0;
		Thread.sleep(1500);
		while (i <= 6) {
			System.out.println(i);
			logger.info("Waiting");
			Thread.sleep(1000);
			try {
				System.out.println(DesktopSession.findElementByName(process).isEnabled() + " -=-=>");
				System.out.println(DesktopSession.findElementByName("OK").isEnabled());
				DesktopSession.findElementByName("Yes").click();
				if (DesktopSession.findElementByName("OK").isEnabled()) {
					break;

				} else {
					Thread.sleep(2000);
				}
			} catch (Exception e) {
				System.out.println(e);
			}
			i++;
		}

		DesktopSession.findElementByName("OK").click();
		Thread.sleep(1000);
		DesktopSession.findElementByName("SYSTEM").click();
		ExpandProject(2);
		DesktopSession.findElementByName("PlatformTypes.arxml").click();
		act.contextClick().build().perform();
		logger.pass("Right click EcucDescription_arxml");
		Thread.sleep(500);
		DesktopSession.findElementByName(po.RenameContext).click();
		List<WebElement> lst1 = DesktopSession.findElementsByClassName("Edit");
		System.out.println(lst1.size() + " -0-0-0-0-> ");
		lst1.get(1).click();
		logger.pass("Click EcucDescription_arxml rename field");
		lst1.get(lst1.size() - 1).sendKeys(select);
		lst1.get(1).sendKeys("PlatformTypes_Modified.arxml");
		logger.pass("Rename EcucDescription_arxml rename field");
		DesktopSession.findElementByName("OK").click();
		logger.pass("Clicked Ok");
		Thread.sleep(500);
		DesktopSession.findElementByName(Project).click();
		act.contextClick(DesktopSession.findElementByName(Project)).build().perform();
		Thread.sleep(1000);
		DesktopSession.findElementByName("Generate Code").click();
		Thread.sleep(1000);
		WebElement BswM_0 = DesktopSession.findElementByName("BswM_0 [/AUTOSAR/KPIT/BswM]");
		ScrollToElement(BswM_0);
		selectModuleCodeGeneration("BswM_0 [/AUTOSAR/KPIT/BswM]");
		List<WebElement> lstNew = DesktopSession.findElementsByXPath("//*[@LocalizedControlType='text']");
		System.out.println(lstNew.size() + " =-=->  ");
		String filenameNew = "";
		for (int j = 0; j <= lstNew.size() - 1; j++) {
			String val = lstNew.get(j).getAttribute("Name");
			System.out.println(val);
			try {
				if (val.equalsIgnoreCase("PlatformTypes_Modified.arxml")) {
					filenameNew = val;
				}
			} catch (Exception e) {
			}
		}
		File file = new File(DirPath);
		try {
			File fil = new File(DirPath);

			FileUtils.deleteDirectory(fil);
		} catch (Exception e) {
		}
		boolean flag = file.delete();

		System.out.println(flag);
		System.out.println(filename + " =-=--=> " + filenameNew);
		boolean filechange = filename.equalsIgnoreCase(filenameNew);
		System.out.println(filechange);
		Assert.assertEquals(filechange, false);
	}

	public void CodeGenerationProjectLevel(String Project, String Dirpath, String SelectModule) throws Exception {

		DesktopSession = Root();
		Robot rb = new Robot();
		Actions act = new Actions(DesktopSession);
		int length = 5;
		boolean useLetters = true;
		boolean useNumbers = true;
		String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
		System.out.println(generatedString + "  =-===>  ");
		DesktopSession.findElementByName(Project).click();
		Thread.sleep(500);
		act.contextClick().build().perform();
		Thread.sleep(500);
		DesktopSession.findElementByName("Generate Code").click();
		Thread.sleep(500);
		selectModuleCodeGeneration(SelectModule);
		CodeGenerationToSpecificDir(Dirpath);
	}

	public void CodeGeneration4Rte(String Project, String Rtemodule) throws Exception {
		DesktopSession = Root();
		Robot rb = new Robot();
		Actions act = new Actions(DesktopSession);
		DesktopSession.findElementByName(Project).click();
		Thread.sleep(500);
		act.contextClick().build().perform();
		Thread.sleep(2000);
		int j = 0;
		Thread.sleep(1000);
		while (j <= 5) {
			System.out.println(j);
			logger.info("Waiting");
			// Thread.sleep(1000);
			try {
				System.out.println(DesktopSession.findElementByName("Generate Code").isDisplayed() + " -=-=>");

				if (DesktopSession.findElementByName("Generate Code").isDisplayed()) {

					DesktopSession.findElementByName("Generate Code").click();
					break;

				} else {
					Thread.sleep(2000);
				}
			} catch (Exception e) {
				System.out.println(e);
			}
			j++;
		}
		// DesktopSession.findElementByName("Generate Code");
		Thread.sleep(1000);
		WebElement wb = DesktopSession.findElementByName(Rtemodule);
		// ScrollToElement(wb);
		rb.keyPress(KeyEvent.VK_R);
		rb.keyRelease(KeyEvent.VK_R);
		rb.keyPress(KeyEvent.VK_R);
		rb.keyRelease(KeyEvent.VK_R);
		rb.keyPress(KeyEvent.VK_R);
		rb.keyRelease(KeyEvent.VK_R);
		selectModuleCodeGeneration(Rtemodule);
		Thread.sleep(1000);
		DesktopSession.findElementByName(po.Finish_Button).click();
		String process = "Processing Code Generation........                                ";
		int i = 0;
		Thread.sleep(1000);
		while (i <= 9) {
			System.out.println(i);
			logger.info("Waiting");
			Thread.sleep(1000);
			try {
				System.out.println(DesktopSession.findElementByName(process).isEnabled() + " -=-=>");
				System.out.println(DesktopSession.findElementByName("OK").isEnabled());
				DesktopSession.findElementByName("Yes").click();
				if (DesktopSession.findElementByName("OK").isEnabled()) {

					// DesktopSession.findElementByName("OK").click();
					break;

				} else {
					Thread.sleep(2000);
				}
			} catch (Exception e) {
				System.out.println(e);
			}
			i++;
		}
		DesktopSession.findElementByName("OK").click();
		Thread.sleep(1000);

	}

	public void MergeECUExtract(String Project, String fileone, String filetwo) throws Exception {

		DesktopSession = Root();
		Robot rb = new Robot();
		Actions act = new Actions(DesktopSession);
		DesktopSession.findElementByName(Project).click();
		Thread.sleep(500);
		ExpandProject(1);
		rb.keyPress(KeyEvent.VK_CONTROL);
		DesktopSession.findElementByName(Project).click();
		DesktopSession.findElementByName(fileone).click();
		DesktopSession.findElementByName(filetwo).click();
		rb.keyRelease(KeyEvent.VK_CONTROL);
		act.contextClick().build().perform();
		Thread.sleep(500);
		DesktopSession.findElementByName(po.Merging_ECUC).click();
		Thread.sleep(2000);
	}

	public void GenerateECUCMappingForDem(String Project) throws Exception {

		DesktopSession = Root();
		Actions act = new Actions(DesktopSession);
		Robot rb = new Robot();
		Thread.sleep(6000);
		DesktopSession.findElementByName(Project).click();
		logger.pass("Clicked on project");
		act.contextClick(DesktopSession.findElementByName(Project)).build().perform();
		logger.pass("Right Click on project");
		Thread.sleep(500);
		int i = 0;
		Thread.sleep(1000);
		while (i <= 5) {
			System.out.println(i);
			logger.info("Waiting");
			Thread.sleep(1000);
			try {
				System.out.println(DesktopSession.findElementByName(po.ECUC_Mapping).isEnabled() + " -=-=>");
				if (DesktopSession.findElementByName(po.ECUC_Mapping).isEnabled()) {

					DesktopSession.findElementByName(po.ECUC_Mapping).click();
					logger.pass("Click on Ecuc Mapping");
					break;

				} else {
					Thread.sleep(2000);
				}
			} catch (Exception e) {
				System.out.println(e);
			}
			i++;
		}
		Thread.sleep(500);
		DesktopSession.findElementByName("Select/ De-Select All").click();
		logger.pass("Clicked Select and Deselectall checkbox");
		rb.keyPress(KeyEvent.VK_SPACE);
		rb.keyRelease(KeyEvent.VK_SPACE);
		Thread.sleep(500);
		DesktopSession.findElementByName("Select/ De-Select All").click();
		logger.pass("Clicked Select and Deselectall checkbox");
		rb.keyPress(KeyEvent.VK_SPACE);
		rb.keyRelease(KeyEvent.VK_SPACE);
		WebElement wb = DesktopSession.findElementByName("Dem");
		ScrollToElement(wb);
		logger.pass("Scrolling");
		DesktopSession.findElementByName("Dem").click();
		logger.pass("Clicking Dem Module");
		rb.keyPress(KeyEvent.VK_SPACE);
		rb.keyRelease(KeyEvent.VK_SPACE);
		logger.pass("Select Dem Module");
		DesktopSession.findElementByName(po.LocalParameterForEcucDialog).click();
		logger.pass("CLick LocalParameterForEcucDialog");
		DesktopSession.findElementByName(po.RetainConfiguration).click();
		logger.pass("CLick RetainConfiguration");
		List<WebElement>lstbro =  DesktopSession.findElementsByName(po.Browse);
		System.out.println(lstbro.size());
		lstbro.get(1).click();
		logger.pass("CLick Browse");
		Thread.sleep(500);
		ExpandProject(1);
		Thread.sleep(500);
		DesktopSession.findElementByName("LocalParameters").click();
		Thread.sleep(500);
		ExpandProject(1);
		DesktopSession.findElementByName("LocalParameters_24M_CAN.arxml").click();
		logger.pass("CLick LocalParameters_24M_CAN.arxml");
		DesktopSession.findElementByName("OK").click();
		logger.pass("Click on ok");
		Thread.sleep(500);
		DesktopSession.findElementByName(po.Finish_Button).click();
		logger.pass("Click on Finish");
		Thread.sleep(2000);
	}

	public  Map<Integer, String> VerifyDemModule(String Project) throws Exception {
		DesktopSession = Root();
		Actions act = new Actions(DesktopSession);
		Robot rb = new Robot();
		Thread.sleep(3000);
		DesktopSession.findElementByName(Project).click();
		logger.pass("Click on Project");
		ExpandProject(1);
		DesktopSession.findElementByName(po.ECUFileName).click();
		logger.pass("Click on EcucDescription");
		ExpandProject(7);
		DesktopSession.findElementByName("Dem_0 [Dem]").click();
		logger.pass("Click on Dem");
		ExpandProject(3);
		DesktopSession.findElementByName("DemDtr_USD [14]").click();
		logger.pass("Click on DemDtr");
		ExpandProject(3);
		int count =0;
		Map <Integer,String>map= new HashedMap();
		List<WebElement> lst = DesktopSession.findElementsByXPath("//*[@LocalizedControlType='tree item']");
		System.out.println(lst.size() + " =-=->  ");
		for(int i=0;i<=lst.size()-1;i++) {
			String val = lst.get(i).getAttribute("Name");
			
			if(val.contains("DemDtr_MID")) {
				map.put(count, val);
				count++;
			}
		}
		System.out.println(count+" -0-0=-=> ");
		System.out.println(map);
		Assert.assertEquals(count, 14);
		return map;
	}
	
	public boolean VerifyBatchValidationOnEmptyContainer(String Project) throws Exception {
		DesktopSession = Root();
		Actions act = new Actions(DesktopSession);
		Robot rb = new Robot();
		Thread.sleep(3000);
		DesktopSession.findElementByName(Project).click();
		logger.pass("Click on Project");
		ExpandProject(1);
		DesktopSession.findElementByName(po.default_arxml).click();
		logger.pass("Click on default_arxml");
		ExpandProject(11);
		boolean flag = DesktopSession.findElementByName("DemDebounceAlgorithmClass_0 [DemDebounceAlgorithmClass]").isDisplayed();
		System.out.println(flag);
		DesktopSession.findElementByName(Project).click();
		logger.pass("Click on Project");
		act.contextClick().build().perform();
		logger.pass("Right Click on Project");
		Thread.sleep(1000);
		DesktopSession.findElementByName(po.ClearValidation).click();
		logger.pass("Click on ClearValidation");
		act.contextClick().build().perform();
		logger.pass("Right Click on Project");
		Thread.sleep(1000);
		DesktopSession.findElementByName(po.BatchValidation).click();
		logger.pass("Click on BatchValidation");
		Thread.sleep(500);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		List<WebElement>lsttab = DesktopSession.findElementsByName("Validation");
		System.out.println(lsttab.size()+" 909---->");
		for(int j=0;j<=lsttab.size()-1;j++) {
			
			String val = lsttab.get(j).getAttribute("LocalizedControlType");
			System.out.println(val+" -0-> ");
			try {
				if(val.equalsIgnoreCase("tab item")) {
					act.doubleClick(lsttab.get(j)).build().perform();
				}
			}catch (Exception e) {
				// TODO: handle exception
			}
			
		}
		List<WebElement> lst = DesktopSession.findElementsByXPath("//*[@LocalizedControlType='tree item']");
		System.out.println(lst.size() + " -0-0-0-0-0-> ");
		boolean flagN = false;
		for (int i = 0; i <= lst.size() - 1; i++) {

			String value = lst.get(i).getAttribute("Name");
			System.out.println(value + "  -9-9-9-9-9> ");
			try {
				//
			if(value.equalsIgnoreCase("ERR087005: Mandatory container elements must be configured (2 items)")) {
				{
					lst.get(i).click();
					ExpandProject(1);
					//ERR087005: Mandatory container DemDebounceAlgorithmClass_0 should be configured at least with one parameter or sub-container
					flagN =DesktopSession.findElementByName("ERR087005: Mandatory container DemDebounceAlgorithmClass_0 should be configured at least with one parameter or sub-container").isDisplayed();
				}
				
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
		
		Assert.assertEquals(flag, true);
		return flagN;
		
		}
	
	public boolean VerifyBatchValidationOnEmptyIpduContainer(String Project) throws Exception {
		DesktopSession = Root();
		Actions act = new Actions(DesktopSession);
		Robot rb = new Robot();
		Thread.sleep(3000);
		DesktopSession.findElementByName(Project).click();
		logger.pass("Click on Project");
		ExpandProject(1);
		DesktopSession.findElementByName(po.default_arxml).click();
		logger.pass("Click on default_arxml");
		ExpandProject(11);
		//IpduMConfig_0 [IpduMConfig]
		//IpduMGeneral_0 [IpduMGeneral]
		//IpduMPublishedInformation_0 [IpduMPublishedInformation]
		boolean flag = DesktopSession.findElementByName("IpduMConfig_0 [IpduMConfig]").isDisplayed();
		System.out.println(flag);
		boolean flag1 = DesktopSession.findElementByName("IpduMGeneral_0 [IpduMGeneral]").isDisplayed();
		boolean flag2 = DesktopSession.findElementByName("IpduMPublishedInformation_0 [IpduMPublishedInformation]").isDisplayed();
		System.out.println(flag1);
		System.out.println(flag2);
		DesktopSession.findElementByName(Project).click();
		logger.pass("Click on Project");
		act.contextClick().build().perform();
		logger.pass("Right Click on Project");
		Thread.sleep(1000);
		DesktopSession.findElementByName(po.ClearValidation).click();
		logger.pass("Click on ClearValidation");
		act.contextClick().build().perform();
		logger.pass("Right Click on Project");
		Thread.sleep(1000);
		DesktopSession.findElementByName(po.BatchValidation).click();
		logger.pass("Click on BatchValidation");
		Thread.sleep(500);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		List<WebElement>lsttab = DesktopSession.findElementsByName("Validation");
		System.out.println(lsttab.size()+" 909---->");
		for(int j=0;j<=lsttab.size()-1;j++) {
			
			String val = lsttab.get(j).getAttribute("LocalizedControlType");
			System.out.println(val+" -0-> ");
			try {
				if(val.equalsIgnoreCase("tab item")) {
					act.doubleClick(lsttab.get(j)).build().perform();
				}
			}catch (Exception e) {
				// TODO: handle exception
			}
			
		}
		List<WebElement> lst = DesktopSession.findElementsByXPath("//*[@LocalizedControlType='tree item']");
		System.out.println(lst.size() + " -0-0-0-0-0-> ");
		boolean flagN = false;
		for (int i = 0; i <= lst.size() - 1; i++) {

			String value = lst.get(i).getAttribute("Name");
			System.out.println(value + "  -9-9-9-9-9> ");
			try {
				//
			if(value.equalsIgnoreCase("ERR087005: Mandatory container elements must be configured (2 items)")) {
				{
					lst.get(i).click();
					ExpandProject(1);
					//ERR087005: Mandatory container DemDebounceAlgorithmClass_0 should be configured at least with one parameter or sub-container
					flagN =DesktopSession.findElementByName("ERR087005: Mandatory container IpduMConfig_0 must contain at least one parameter or sub-container").isDisplayed();
				}
				// ERR087005: Mandatory container IpduMConfig_0 must contain at least one parameter or sub-container
				// ERR087005: Mandatory container IpduMConfig_0 should be configured at least with one parameter or sub-container				
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
		
		Assert.assertEquals(flag, true);
		Assert.assertEquals(flag1, true);
		Assert.assertEquals(flag2, true);
		return flagN;
		
		}
	
	public void ImportDBCFile(String Project,String DBCPath,String Module) throws Exception {
		
		DesktopSession = Root();
		Robot rb = new Robot();
		Actions rightclick = new Actions(DesktopSession);
		WebElement Projectname = DesktopSession.findElementByName(Project);
		rightclick.contextClick(Projectname);
		rightclick.perform();
		Thread.sleep(1000);
		DesktopSession.findElementByName(Pageobj.Import).click();
		logger.pass("Clicked On Import");
		// DesktopSession.findElementByName(po.C4K).click();
		@SuppressWarnings("unchecked")
		List<WebElement> lstn = DesktopSession.findElementsByName(Pageobj.C4K);
		System.out.println(lstn.size());
		lstn.get(1).click();
		logger.pass("Clicked C4K");
		logger.pass("Clicked on the C4K");
		rb.keyPress(KeyEvent.VK_RIGHT);
		// rb.keyPress(KeyEvent.VK_RIGHT);
		logger.pass("Expanded the c4k");
		DesktopSession.findElementByName(Pageobj.DBC).click();
		logger.pass("Click DBC");
		DesktopSession.findElementByName(Pageobj.Next_Button).click();
		logger.pass("Clicked On NextButton");
		DesktopSession.findElementByName(Pageobj.Browse).click();
		logger.pass("Clicked On Browse button");
		Thread.sleep(1000);
		// Address: Documents
		DesktopSession.findElementByName("All locations").click();
		Thread.sleep(1000);
		WebElement filepath = DesktopSession.findElementByName("Address");
		String select = Keys.chord(Keys.CONTROL, "a");
		rightclick.sendKeys(filepath, select);
		rightclick.perform();
		rightclick.sendKeys(Keys.BACK_SPACE).perform();
		rightclick.sendKeys(filepath, DBCPath);
		rightclick.perform();
		//Go to "D:\HQIBuild_Script\winappdriver_automation\Autosar_C4K\ImportProject\AR-1695"
		String arrow ="Go to "+'"'+DBCPath+'"';
		System.out.println(arrow);
		DesktopSession.findElementByName(arrow).click();
		logger.pass("entered the DBCPath");
		Thread.sleep(1000);
		DesktopSession.findElementByClassName("UIProperty").click();
		Thread.sleep(1000);
		DesktopSession.findElementByName(Pageobj.Open).click();
		logger.pass("Select open");
		Thread.sleep(1000);
		DesktopSession.findElementByClassName(Pageobj.Dropdown).click();
		logger.pass("Selected the Dropdown");
		DesktopSession.findElementByName(Module).click();
		logger.pass("Selected the Module");
//		DesktopSession.findElementByName(Pageobj.Select_All).click();
//		logger.pass("Selected the Select All");
		DesktopSession.findElementByName(Pageobj.Finish_Button).click();
		logger.pass("Selected the Finish button");
		Thread.sleep(2000);
		//DBC_HCP_Extract_
	}
	
	public void TranferPropertyCyclicAllSignal(String project,String container,int NoofScrolling) throws Exception{
		
		DesktopSession = Root();
		Robot rb = new Robot();
		Actions rightclick = new Actions(DesktopSession);
		Thread.sleep(2000);
		DesktopSession.findElementByName(project).click();
		logger.pass("Clicked On project");
		ExpandProject(2);
		Thread.sleep(3000);
		logger.pass("Expand the project");
		List<WebElement> lst = DesktopSession.findElementsByXPath("//*[@LocalizedControlType='tree item']");
		System.out.println(lst.size() + " -0-0-0-0-0-> ");
		boolean flagN = false;
		for (int i = 0; i <= lst.size() - 1; i++) {

			String value = lst.get(i).getAttribute("Name");
			System.out.println(value + "  -9-9-9-9-9> ");
			try {
				//
			if(value.contains("DBC_HCP_Extract_")) {
				{
					lst.get(i).click();
					logger.pass("Clicked On DBC_HCP_Extract_");
					ExpandProject(5);
					logger.pass("Expand the DBC_HCP_Extract_");
				Thread.sleep(3000);
				}
				
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
		for(int j=0;j<=NoofScrolling;j++) {
		rb.keyPress(KeyEvent.VK_I);
		rb.keyRelease(KeyEvent.VK_I);
		logger.pass("Scrolling");
		}
		//ISignalIPdu_ENGINE_HYBD_FD_3_CAN_ePT
		DesktopSession.findElementByName(container).click();
		logger.pass("Clicked the module");
		ExpandProject(2);
		logger.pass("Expand the module");
	}
	
	public boolean VerifyProperty(String Element,String Selectproperty,String property) throws Exception {
		
		DesktopSession = Root();
		Robot rb = new Robot();
		Actions act = new Actions(DesktopSession);
		//Thread.sleep(2000);
		DesktopSession.findElementByName(Element).click();
		logger.pass("Clicked the module ele");
		DesktopSession.findElementByName(po.Properties_Tab).click();
		Thread.sleep(500);
		//WebElement prop = DesktopSession.findElementByName(po.Properties_Tab);
		act.doubleClick().build().perform();
		logger.pass("Double Clicked the Properties tab");
		Thread.sleep(500);
		//Transfer Property
		DesktopSession.findElementByName(Selectproperty).click();
		logger.pass("Clicked the Transfer Property");
		List<WebElement>lst = DesktopSession.findElementsByXPath("//*[@LocalizedControlType='document']");
		System.out.println(lst.size()+" -=-> ");
		boolean flag = false;
		for(int i= 0;i<=lst.size()-1;i++) {
			String val = lst.get(i).getAttribute("Value.Value");
			System.out.println(val+"  0 - -= -> ");
			try {
			if(val.equalsIgnoreCase(property)) {
				flag=true;
			}
			}catch (Exception e) {
				
			}
		}
		DesktopSession.findElementByName(po.Properties_Tab).click();
		//WebElement propn = DesktopSession.findElementByName(po.Properties_Tab);
		act.doubleClick().build().perform();
		logger.pass("Double Clicked the Properties tab");
		return flag;
		
	}

}
