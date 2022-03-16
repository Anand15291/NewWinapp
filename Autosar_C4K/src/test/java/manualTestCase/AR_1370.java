package manualTestCase;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Common;
import com.Utility;

import base.BaseClass;
import example.Process;
import example.Process.GetProcess;

public class AR_1370 extends BaseClass{
	
Common com = new Common();
Process po = new Process();
Utility pro = new Utility();
	
	@Test
	public void multipleInstanceVerification() throws Exception {
		logger = BaseClass.exreporter.createTest("Executemultipleinstances");

		for (int i = 0; i <= 1; i++) {
			Setup();
			Thread.sleep(1000);

		}
		DesktopSession = Root();
		int a = pro.listRunningProcesses();
		Assert.assertEquals(3, a);
		logger.pass("Application Instances has launched" +" "+ a + "times");
		for (int i = 0; i <= 2; i++) {
			WindowsProcessKiller.killProcess("compose.exe");
		}
		logger.pass("Application Instances has closed" +" "+ a + "times");

	}

}
