package desktopSession;

import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;

@SuppressWarnings("unused")
public class CommonUtility {
	
	

	   
	    public static WebDriverWait explicitWait;
	    public static Actions keyAction;

	    public static WindowsDriver<WindowsElement> Session () throws Exception {
			
			DesiredCapabilities appCapabilities = new DesiredCapabilities();
			appCapabilities.setCapability("app", "Root");
			WindowsDriver<WindowsElement>
			DesktopSession = new WindowsDriver<WindowsElement>(appCapabilities);
		
			
			return DesktopSession;
		}

}
