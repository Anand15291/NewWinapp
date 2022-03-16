package desktopSession;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;




@SuppressWarnings("unused")
public class DriverAction {
	 public static WindowsDriver<WindowsElement> DesktopSession;

    /**
     * To get the corresponding WebElement object of the element locator provided
     * @throws Exception 
     */
    public static WebElement FindElement(LocatorValue locator) throws Exception {
        WebElement element = null;
      //  DesktopSession = CommonUtility.Session();
        if (locator.getValue().contains("automationId=")) {
            element = DesktopSession
                .findElementByAccessibilityId(StringUtils.substringAfter(locator.getValue(), "automationId="));
        }
        if (locator.getValue().contains("className=")) {
            element = DesktopSession
            .findElementByClassName(StringUtils.substringAfter(locator.getValue(), "className="));
        }
        if (locator.getValue().contains("name=")) {            
            element = DesktopSession            
                .findElementByName(StringUtils.substringAfter(locator.getValue(), "name="));
        }
        if (locator.getValue().contains("xpath=")) {
            element = DesktopSession
                .findElementByName(StringUtils.substringAfter(locator.getValue(), "xpath="));
        }
        
        return element;    
    }

    /**
     * Action to click particular locator element
     * @throws Exception 
     */
    public static void Click(LocatorValue locator) throws Exception {
      
        FindElement(locator).click();
        
    }

    /**
     * Action to get embedded text in locator
     * @throws Exception 
     */
    public static String GetText(LocatorValue locator) throws Exception {        
        return FindElement(locator).getText();
    }



}
