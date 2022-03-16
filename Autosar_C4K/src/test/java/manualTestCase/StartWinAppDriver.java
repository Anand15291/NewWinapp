package manualTestCase;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import org.codehaus.plexus.util.cli.CommandLineUtils;
import org.codehaus.plexus.util.cli.Commandline;
import org.codehaus.plexus.util.cli.WriterStreamConsumer;
import org.testng.annotations.Test;

public class StartWinAppDriver {
	
	
	@Test
	
	public static void start() throws Exception {
	
//		Process process = Runtime.getRuntime().exec(
//		        "cmd /c start.bat", null, new File("C:\\Users\\sandeepa8\\Desktop"));
//		
		String filelocation = System.getProperty("user.dir")+File.separator+"WinAppDriver"+File.separator+"WinAppDriver.exe";
		System.out.println("file ---->  "+filelocation);
		ProcessBuilder pBuilder = new ProcessBuilder(filelocation);
		pBuilder.inheritIO();
		Process p = pBuilder.start();
			
		
	
	}

}
