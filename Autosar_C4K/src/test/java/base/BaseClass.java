package base;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.naming.spi.DirStateFactory.Result;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.internal.TestMethodArguments;
import org.testng.internal.TestMethodWithDataProviderMethodWorker;
import org.testng.internal.TestNGMethod;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;
import manualTestCase.StartWinAppDriver;
import manualTestCase.WindowsProcessKiller;
import okio.Timeout;
import utils.*;


@SuppressWarnings("unused")
public class BaseClass {

	@SuppressWarnings("rawtypes")
	public static WindowsDriver DesktopSession = null;
	public ExtentHtmlReporter htmlrepoter;
	public static ExtentReports exreporter;
	public static ExtentTest logger;
	public static ITestResult result;
	SuiteListner lisyner = new SuiteListner();
	WindowsProcessKiller processkill = new WindowsProcessKiller();
	static Process p;
	public static String Composepath = "D:\\10thMarchR431Build\\compose4ksar-18.2.3.1-win32.win32.x86_64";
	
	
	@BeforeSuite (alwaysRun = true)
	public void BeforeMethodTest() throws Exception {
		System.out.println("BeforeSuite");
		 
		htmlrepoter = new ExtentHtmlReporter(new File(System.getProperty("user.dir") + File.separator + "reports"
				+ File.separator + "AutomationReport.html"));
		htmlrepoter.config().setEncoding("uft-8");
		htmlrepoter.config().setDocumentTitle("AutomationReport");
		htmlrepoter.config().setDocumentTitle("Automation Test Results");
		htmlrepoter.config().setTheme(Theme.DARK);

		exreporter = new ExtentReports();
		exreporter.attachReporter(htmlrepoter);
		exreporter.setSystemInfo("CK4", "Sandeep Anand");
	}

	@BeforeMethod 
	public void BeforeMethod() throws Exception {
		System.out.println("BeforeMethod");
		Robot rb = new Robot();
		//rb.keyPress(KeyEvent.VK_ESCAPE);
		//rb.keyRelease(KeyEvent.VK_ESCAPE);
		//rb.keyPress(KeyEvent.VK_ESCAPE);
		//rb.keyRelease(KeyEvent.VK_ESCAPE);
		Setup();
		Thread.sleep(20000);
	}

	@SuppressWarnings("static-access")
	@AfterMethod
	public void AfterMethod(ITestResult result) {

		System.out.println("AfterMethod");
		if (result.getStatus() == ITestResult.SUCCESS) {

			String methodname = result.getMethod().getMethodName();
			String logText = "Test Cases: " + methodname + " Passed";
			Markup mark = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
			logger.log(Status.PASS, mark);
			exreporter.getStats();
		} else if (result.getStatus() == ITestResult.FAILURE) {
			lisyner.onTestFailure(result);

			String methodname = result.getMethod().getMethodName();
			String logText = "Test Cases: " + methodname + " Failed";
			Markup mark = MarkupHelper.createLabel(logText, ExtentColor.RED);
			logger.log(Status.FAIL, mark);
			exreporter.getStats();
			processkill.killProcess("compose.exe");

		} else if (result.getStatus() == ITestResult.SKIP) {
			String methodname = result.getMethod().getMethodName();
			String logText = "Test Cases: " + methodname + " Skipped";
			Markup mark = MarkupHelper.createLabel(logText, ExtentColor.CYAN);
			logger.log(Status.SKIP, mark);
			exreporter.getStats();
			processkill.killProcess("compose.exe");
		}

		
		//DesktopSession.quit();
		exreporter.flush();
	}

	@SuppressWarnings("static-access")
	@AfterSuite(alwaysRun = true)
	public void tearDown() throws Exception {

		System.out.println("AfterSuite");
		DesktopSession = null;
		if (DesktopSession != null) {
			DesktopSession.quit();
		}
		DesktopSession = null;
		processkill.killProcess("compose.exe");
		System.out.println("Desktop Session ending and closing");
	}

	@AfterTest
	public void AfterTest() {
		System.out.println("AfterTest");

		exreporter.flush();
		if (DesktopSession != null) {
			DesktopSession.quit();
			//DesktopSession = null;
		}
		//DesktopSession = null;
		//WindowsProcessKiller.killProcess("compose.exe");
	}

	public static void Setup() throws Exception {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platormName", "Windows");
		capabilities.setCapability("deviceName", "WindowsPC");
		capabilities.setCapability("app", Composepath+File.separator+"compose.exe");
		capabilities.setCapability("appArguments", "compose");
		capabilities.setCapability("ms:waitForAppLaunch", "25");
		capabilities.setCapability("isHeadless", true);
		try {
		DesktopSession = new WindowsDriver<WindowsElement>(new URL("http://127.0.0.1:4723"), capabilities);
		} catch (MalformedURLException e) {
		e.printStackTrace();
		}
		
	}

	public static WindowsDriver<WindowsElement> Root() throws Exception {

		DesiredCapabilities appCapabilities = new DesiredCapabilities();
		appCapabilities.setCapability("app", "Root");
		WindowsDriver<WindowsElement> DesktopSession = new WindowsDriver<WindowsElement>(
				new URL("http://127.0.0.1:4723"), appCapabilities);
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Thread.sleep(2000);
		return DesktopSession;

	}

	public static void strat_Driver() throws Exception {

		String filelocation = System.getProperty("user.dir") + File.separator + "WinAppDriver" + File.separator
				+ "WinAppDriver.exe";
		System.out.println("file ---->  " + filelocation);
		ProcessBuilder pBuilder = new ProcessBuilder(filelocation).inheritIO(); 
		// pBuilder.inheritIO(); p =
		pBuilder.start();

	}

	/*
	 * public static void TearDown() { if (DesktopSession != null) {
	 * DesktopSession.quit(); //DesktopSession = null; } DesktopSession = null;
	 * 
	 * if (DesktopSession != null) { DesktopSession.quit(); //DesktopSession = null;
	 * } DesktopSession = null; }
	 */
	public static void startWInapp() {
	 try
     {
		 Runtime.getRuntime().exec("C:\\Users\\krishnad8\\Desktop\\winapp.bat");
			/*
			 * // Command to create an external process String command =
			 * "C:\\Users\\krishnad8\\Desktop\\winapp.bat";
			 * 
			 * // Running the above command Runtime run = Runtime.getRuntime(); Process proc
			 * = run.exec(command);
			 */
         System.out.println("Winnappdriver Started");
     }

     catch (IOException e)
     {
         e.printStackTrace();
     }

}
}
