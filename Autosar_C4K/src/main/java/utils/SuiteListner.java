package utils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Base64;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.IAnnotationTransformer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;


@SuppressWarnings("unused")
public class SuiteListner implements ITestListener, IAnnotationTransformer {
	
	@SuppressWarnings("rawtypes")
	public static WindowsDriver DesktopSession = null;
	    public void onFinish(ITestContext Result) 					
	    {		
	                		
	    }		

	
	    public void onStart(ITestContext Result)					
	    {		
	            		
	    }		

	  
	    public void onTestFailedButWithinSuccessPercentage(ITestResult Result)					
	    {		
	    		
	    }		

	    // When Test case get failed, this method is called.		
			
	    public void onTestFailure(ITestResult Result) 					
	    {		DesiredCapabilities appCapabilities = new DesiredCapabilities();
		appCapabilities.setCapability("app", "Root");
		WindowsDriver<WindowsElement> DesktopSession = null;
		try {
			DesktopSession = new WindowsDriver<WindowsElement>(new URL("http://127.0.0.1:4723"), appCapabilities);
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    System.out.println("The name of the testcase failed is :"+Result.getName());
//	    SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
//		Date date = new Date();
//		System.out.println(formatter.format(date));
//		
//		String name = Result.getMethod().getMethodName()+"_"+date;
//		System.out.println(name+"  000000   ---->");
	    String filename = System.getProperty("user.dir")+File.separator+"Screenshot"+File.separator+Result.getMethod().getMethodName();
	   // File screenshot = ((TakesScreenshot)DesktopSession).getScreenshotAs(OutputType.FILE);
	     String sc = DesktopSession.getScreenshotAs(OutputType.BASE64);
	     byte[] decodedBytes = Base64.getDecoder().decode(sc);
	     try {
			FileUtils.writeByteArrayToFile(new File(filename), decodedBytes);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 
	     System.out.println("--------->   :"+filename);
	    
	    }		

	    // When Test case get Skipped, this method is called.		
			
	    public void onTestSkipped(ITestResult Result)					
	    {		
	    System.out.println("The name of the testcase Skipped is :"+Result.getName());					
	    }		

	    // When Test case get Started, this method is called.		
	 	
	    public void onTestStart(ITestResult Result)					
	    {		
	    System.out.println(Result.getName()+" test case started");					
	    }		

	    // When Test case get passed, this method is called.		
	  	
	    public void onTestSuccess(ITestResult Result)					
	    {		
	    System.out.println("The name of the testcase passed is :"+Result.getName());					
	    }		
	
	    
	    public void transform(ITestAnnotation itestAnotation,Class aclass, Constructor constructor, Method method) {
	    	
	    	itestAnotation.setRetryAnalyzer(RetryAnalyzer.class);
	    }
	
	

}
