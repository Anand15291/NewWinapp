package example;

import java.awt.Robot;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import com.Common;

import base.BaseClass;

import desktopSession.CommonUtility;
import desktopSession.DriverAction;
import pageObject.Pageobj;

@SuppressWarnings("unused")
public class TipTool extends BaseClass {

	public Pageobj pj = new Pageobj();

	

	public void RunTip(String AppPath) throws Exception {
		logger = BaseClass.exreporter.createTest("RunTip");
		logger.info("Application opened");
		DesktopSession = Root();
		
		Actions rightclick = new Actions(DesktopSession);
		Robot rb = new Robot();
		System.out.println("---->   " );
		WebElement wb = DesktopSession.findElementByName(pj.workspace);
		rightclick.click(wb);
		rightclick.perform();
		logger.info("Click on the Workspace");
		Thread.sleep(10000);
		String select = Keys.chord(Keys.CONTROL, "a");
		rightclick.sendKeys(wb, select);
		rightclick.perform();
		rightclick.sendKeys(wb, AppPath);
		rightclick.perform();
		logger.info("entered the Workspace path");
		DesktopSession.findElementByName(pj.Launch).click();
		
		logger.info("Clicked Ok");
		Thread.sleep(10000);
		
		DesktopSession.close();
		DesktopSession.quit();
	
		

	}
}
