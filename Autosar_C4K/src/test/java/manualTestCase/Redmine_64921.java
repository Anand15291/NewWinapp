package manualTestCase;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Common;
import com.Utility;

import base.BaseClass;
import pageObject.Pageobj;

public class Redmine_64921 extends BaseClass {

	Common com = new Common();
	Utility ut = new Utility();
	public Pageobj po = new Pageobj();

	@Test

	public void VerifyMergeFiles() throws Exception {

		logger = BaseClass.exreporter.createTest("AR-1634");
		com.LunchApp("D:\\workspace\\");
		com.CreateProjectOnNewTool("Demo");
		String FilePath = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator + "AR1634";
		com.ImportFile("Demo", "Data.arxml", FilePath);
		Thread.sleep(1000);
		com.ImportFile("Demo", "Value.arxml", FilePath);
		com.MergeECUExtract("Demo", "Value.arxml", "Data.arxml");
		String ecuextract = "";
		List<WebElement> lst = DesktopSession.findElementsByXPath("//*[@LocalizedControlType='tree item']");
		System.out.println(lst.size() + " =-=-=>  ");
		int count = 0;
		for (int i = 0; i <= lst.size() - 1; i++) {

			String frameid = lst.get(i).getAttribute("FrameworkId");
			String name = lst.get(i).getAttribute("Name");
			System.out.println(frameid + " -=-=-=> " + name);
			if (name.contains("EcuExtract_")) {
				System.out.println(name + " =-=-> " + i);
				ecuextract = name;
				count++;
			}

		}
		System.out.println(count + " =-=-=>909 ");
		Thread.sleep(1000);
		com.ImportFile("Demo", "Later.arxml", FilePath);
		Thread.sleep(1500);
		DesktopSession.findElementByName("Demo").click();
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_LEFT);
		rb.keyRelease(KeyEvent.VK_LEFT);
		com.MergeECUExtract("Demo", ecuextract, "Later.arxml");
		int countnew = 0;
		List<WebElement> lst1 = DesktopSession.findElementsByXPath("//*[@LocalizedControlType='tree item']");
		System.out.println(lst1.size() + " =-=-=>  ");
		for (int i = 0; i <= lst1.size() - 1; i++) {

			String frameid = lst1.get(i).getAttribute("FrameworkId");
			String name = lst1.get(i).getAttribute("Name");
			System.out.println(frameid + " -=-=-=> " + name);
			if (name.contains("EcuExtract_")) {
				System.out.println(name + " =-=-> " + i);
				ecuextract = name;
				countnew++;
			}

		}
		System.out.println(countnew + " =-=-=>909 ");
		com.closeApplication();
		Assert.assertEquals(countnew, 2);
	}

	@Test

	public void VerifyValidationFile() throws Exception {

		logger = BaseClass.exreporter.createTest("AR-1687");
		com.LunchApp("D:\\workspace\\");
		com.CreateProjectOnNewTool("Demo");
		String FilePath = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator + "AR1634";
		com.ImportFile("Demo", "Data.arxml", FilePath);
		Thread.sleep(1000);
		com.ImportFile("Demo", "Value.arxml", FilePath);
		com.MergeECUExtract("Demo", "Value.arxml", "Data.arxml");
		Thread.sleep(2000);
		boolean flag = DesktopSession.findElementByName("VariantHandling.arxml").isDisplayed();
		System.out.println(flag);
		String ecuextract = "";
		List<WebElement> lst = DesktopSession.findElementsByXPath("//*[@LocalizedControlType='tree item']");
		System.out.println(lst.size() + " =-=-=>  ");

		for (int i = 0; i <= lst.size() - 1; i++) {

			String frameid = lst.get(i).getAttribute("FrameworkId");
			String name = lst.get(i).getAttribute("Name");
			System.out.println(frameid + " -=-=-=> " + name);
			if (name.contains("EcuExtract_")) {
				System.out.println(name + " =-=-> " + i);
				ecuextract = name;
			}

		}
		Actions act = new Actions(DesktopSession);
		DesktopSession.findElementByName("VariantHandling.arxml").click();
		act.contextClick().build().perform();
		Thread.sleep(500);
		DesktopSession.findElementByName("Delete").click();
		Thread.sleep(500);
		DesktopSession.findElementByName("OK").click();
		Thread.sleep(1000);
		com.ImportFile("Demo", "Later.arxml", FilePath);
		Thread.sleep(1500);
		DesktopSession.findElementByName("Demo").click();
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_LEFT);
		rb.keyRelease(KeyEvent.VK_LEFT);
		com.MergeECUExtract("Demo", ecuextract, "Later.arxml");
		Thread.sleep(1500);
		boolean flagN = DesktopSession.findElementByName("VariantHandling.arxml").isDisplayed();
		System.out.println(flagN);
		com.closeApplication();
		Assert.assertEquals(flag, flagN);
	}

	@Test

	public void VerifyVariationPoint() throws Exception {

		logger = BaseClass.exreporter.createTest("AR-1689");
		com.LunchApp("D:\\workspace\\");
		String FilePath = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator
				+ "AR-1689";
		com.ImportProjectSaveWorkspace(FilePath);
		Thread.sleep(2000);
		String FilePathn = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator
				+ "AR1634";
		com.ImportFile("Demo", "ServiceSwComponent.arxml", FilePathn);
		Thread.sleep(1000);
		com.MergeECUExtract("Demo", "Value.arxml", "Data.arxml");
		Thread.sleep(2000);
		DesktopSession.findElementByName("VariantHandling.arxml").click();
		com.ExpandProject(3);
		DesktopSession.findElementByName("PredefinedVariants [ARPackage]").click();
		com.ExpandProject(1);

		int count = 0;
		List<WebElement> lst = DesktopSession.findElementsByXPath("//*[@LocalizedControlType='tree item']");
		System.out.println(lst.size() + " =-=-=>  ");

		for (int i = 0; i <= lst.size() - 1; i++) {

			String frameid = lst.get(i).getAttribute("FrameworkId");
			String name = lst.get(i).getAttribute("Name");
			System.out.println(frameid + " -=-=-=> " + name);
			if (name.contains("PDV_")) {
				System.out.println(name + " =-=-> " + i);
				count++;
			}

		}
		System.out.println(count + " -=-0-=> ");
		Actions act = new Actions(DesktopSession);
		Robot rb = new Robot();
		DesktopSession.findElementByName("VariantHandling.arxml").click();
		act.contextClick().build().perform();
		Thread.sleep(500);
		DesktopSession.findElementByName("Delete").click();
		Thread.sleep(500);
		DesktopSession.findElementByName("OK").click();
		Thread.sleep(1000);
		DesktopSession.findElementByName("Demo").click();
		Thread.sleep(500);
		rb.keyPress(KeyEvent.VK_CONTROL);
		DesktopSession.findElementByName("Demo").click();
		DesktopSession.findElementByName("Value.arxml").click();
		DesktopSession.findElementByName("Later.arxml").click();
		DesktopSession.findElementByName("Data.arxml").click();
		rb.keyRelease(KeyEvent.VK_CONTROL);
		act.contextClick().build().perform();
		Thread.sleep(500);
		DesktopSession.findElementByName(po.Merging_ECUC).click();
		Thread.sleep(2000);
		Thread.sleep(2000);
		DesktopSession.findElementByName("VariantHandling.arxml").click();
		com.ExpandProject(3);
		DesktopSession.findElementByName("PredefinedVariants [ARPackage]").click();
		com.ExpandProject(1);
		int countN = 0;
		List<WebElement> lst1 = DesktopSession.findElementsByXPath("//*[@LocalizedControlType='tree item']");
		System.out.println(lst1.size() + " =-=-=>  ");

		for (int i = 0; i <= lst1.size() - 1; i++) {

			String frameid = lst1.get(i).getAttribute("FrameworkId");
			String name = lst1.get(i).getAttribute("Name");
			System.out.println(frameid + " -=-=-=> " + name);
			if (name.contains("PDV_")) {
				System.out.println(name + " =-=-> " + i);
				countN++;
			}

		}
		com.closeApplication();
		System.out.println(countN + " -=-023-=> ");

		Assert.assertEquals(countN, count + 1);
	}

	@Test

	public void EnableMergeEUCExtract() throws Exception {

		logger = BaseClass.exreporter.createTest("AR-1688");
		com.LunchApp("D:\\workspace\\");
		com.CreateProjectOnNewTool("Demo");
		String FilePath = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator + "AR1634";
		com.ImportFile("Demo", "Data.arxml", FilePath);
		Thread.sleep(1000);
		com.ImportFile("Demo", "Value.arxml", FilePath);
		com.MergeECUExtract("Demo", "Value.arxml", "Data.arxml");
		String ecuextract = "";
		List<WebElement> lst = DesktopSession.findElementsByXPath("//*[@LocalizedControlType='tree item']");
		System.out.println(lst.size() + " =-=-=>  ");
		int count = 0;
		for (int i = 0; i <= lst.size() - 1; i++) {

			String frameid = lst.get(i).getAttribute("FrameworkId");
			String name = lst.get(i).getAttribute("Name");
			System.out.println(frameid + " -=-=-=> " + name);
			if (name.contains("EcuExtract_")) {
				System.out.println(name + " =-=-> " + i);
				ecuextract = name;
				count++;
			}

		}
		System.out.println(count + " =-=-=>909 ");
		Thread.sleep(1000);
		com.ImportFile("Demo", "Later.arxml", FilePath);
		Thread.sleep(1500);
		DesktopSession.findElementByName("Demo").click();
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_LEFT);
		rb.keyRelease(KeyEvent.VK_LEFT);
		com.MergeECUExtract("Demo", "Value.arxml", "Later.arxml");
		int countnew = 0;
		String ecuextractnew = "";
		List<WebElement> lst1 = DesktopSession.findElementsByXPath("//*[@LocalizedControlType='tree item']");
		System.out.println(lst1.size() + " =-=-=>  ");
		for (int i = 0; i <= lst1.size() - 1; i++) {

			String frameid = lst1.get(i).getAttribute("FrameworkId");
			String name = lst1.get(i).getAttribute("Name");
			System.out.println(frameid + " -=-=-=> " + name);
			if (name.contains("EcuExtract_")) {
				System.out.println(name + " =-=-> " + i);
				ecuextractnew = name;
				countnew++;
			}

		}
		System.out.println(ecuextract + "   =-=->0==> " + ecuextractnew);

		Actions act = new Actions(DesktopSession);
		// DesktopSession.findElementByName("Demo").click();
		Thread.sleep(500);
		// com.ExpandProject(1);
		rb.keyPress(KeyEvent.VK_CONTROL);
		// DesktopSession.findElementByName("Demo").click();
		DesktopSession.findElementByName(ecuextract).click();
		DesktopSession.findElementByName(ecuextractnew).click();
		rb.keyRelease(KeyEvent.VK_CONTROL);
		act.contextClick().build().perform();
		Thread.sleep(500);
		boolean flag = DesktopSession.findElementByName(po.Merging_ECUC).isDisplayed();
		System.out.println(flag);

		com.closeApplication();
		Assert.assertEquals(flag, true);
	}

	// @Test

	// public void VerifyErrorView() throws Exception {

	// 	logger = BaseClass.exreporter.createTest("AR-1691");
	// 	com.LunchApp("D:\\workspace\\");
	// 	String FilePath = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator
	// 			+ "AR-1689";
	// 	com.ImportProjectSaveWorkspace(FilePath);
	// 	Thread.sleep(1000);
	// 	// com.ImportFile("Demo", "Value.arxml", FilePath);
	// 	com.MergeECUExtract("Demo", "Value.arxml", "Data.arxml");
	// 	Thread.sleep(1500);
	// 	String ecuextract = "";
	// 	List<WebElement> lst = DesktopSession.findElementsByXPath("//*[@LocalizedControlType='tree item']");
	// 	System.out.println(lst.size() + " =-=-=>  ");
	// 	int count = 0;
	// 	for (int i = 0; i <= lst.size() - 1; i++) {

	// 		String frameid = lst.get(i).getAttribute("FrameworkId");
	// 		String name = lst.get(i).getAttribute("Name");
	// 		System.out.println(frameid + " -=-=-=> " + name);
	// 		if (name.contains("EcuExtract_")) {
	// 			System.out.println(name + " =-=-> " + i);
	// 			ecuextract = name;
	// 			count++;
	// 		}

	// 	}
	// 	System.out.println(count + " =-=-=>909 ");
	// 	Thread.sleep(1000);
	// 	DesktopSession.findElementByName("Demo").click();
	// 	Thread.sleep(500);
	// 	com.ExpandProject(1);
	// 	Robot rb = new Robot();
	// 	Actions act = new Actions(DesktopSession);
	// 	rb.keyPress(KeyEvent.VK_CONTROL);
	// 	// DesktopSession.findElementByName("Demo").click();
	// 	DesktopSession.findElementByName(ecuextract).click();
	// 	DesktopSession.findElementByName("Value.arxml").click();
	// 	rb.keyRelease(KeyEvent.VK_CONTROL);
	// 	act.contextClick().build().perform();
	// 	Thread.sleep(500);
	// 	DesktopSession.findElementByName(po.Merging_ECUC).click();
	// 	Thread.sleep(2500);
	// 	List<WebElement> lstnew = DesktopSession.findElementsByClassName("Edit");
	// 	System.out.println(lstnew.size() + " =-=> ");
	// 	lstnew.get(0).click();
	// 	lstnew.get(0).sendKeys("Error Log");
	// 	DesktopSession.findElementByName("Error Log (General)").click();
	// 	Thread.sleep(1000);
	// 	try {
	// 		DesktopSession.findElementByName("Yes").click();
	// 		Thread.sleep(500);
	// 		DesktopSession.findElementByName("Yes").click();
	// 	} catch (Exception e) {
	// 		// TODO: handle exception
	// 	}
	// 	boolean flagnew = true;
	// 	List<WebElement> lsterror = DesktopSession.findElementsByXPath("//*[@LocalizedControlType='tree item']");
	// 	System.out.println(lsterror.size() + " =-=-=>  ");
	// 	for (int i = 0; i <= lsterror.size() - 1; i++) {

	// 		System.out.println(lsterror.get(i));
	// 		if (lsterror.contains("NullPointer")) {
	// 			flagnew = true;
	// 		} else {
	// 			flagnew = false;
	// 		}
	// 	}
	// 	System.out.println(flagnew);
	// 	com.closeApplication();
	// 	Assert.assertEquals(flagnew, false);
	// }
}
