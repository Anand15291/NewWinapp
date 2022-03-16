package manualTestCase;

import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Common;

import base.BaseClass;
import pageObject.Pageobj;

public class HorizontalQualityFeature extends BaseClass {
	public Pageobj po = new Pageobj();
	Common com = new Common();

	@Test
	public void Redmine63038() throws Exception {

		logger = BaseClass.exreporter.createTest("AR-1636");
		com.LunchApp("D:\\workspace\\");
		com.CreateProjectOnNewTool("Redmine");
		com.NewCreateDefaultArxml("Redmine");
		com.VerifyContainer("Redmine");
		com.closeApplication();
	}

	@Test

	public void VerifyToolName() throws Exception {
		logger = BaseClass.exreporter.createTest("AR-1652");
		List<WebElement> lst = DesktopSession.findElements(By.className("Edit"));
		System.out.println(lst.size() + " =-=-=-> ");
		for (int i = 0; i <= lst.size() - 1; i++) {

			System.out.println(lst.get(i).getAttribute("Value.Value") + "  " + i);
		}

		String value = lst.get(0).getAttribute("Value.Value");
		System.out.println(value);

		Assert.assertEquals(value,
				"C4K uses the workspace directory to store its preferences and development artifacts.");
		DesktopSession.findElementByName("Cancel").click();
	
	}

	@Test

	public void VerifyFilterButton() throws Exception {
		logger = BaseClass.exreporter.createTest("AR-1655");
		com.LunchApp("D:\\workspace\\");
		com.CreateProjectOnNewTool("Demo");
		Thread.sleep(1000);
		DesktopSession.findElementByName("Demo").click();
		Actions act = new Actions(DesktopSession);
		act.contextClick().perform();
		Thread.sleep(1000);
		DesktopSession.findElementByName("Batch Validation").click();
		Thread.sleep(1000);
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		
		boolean flag = false;
		try {

			flag = DesktopSession.findElementByName("Configure the filters to be applied to this view").isDisplayed();
			System.out.println(flag + "  -=-=-=> ");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			flag = false;
			System.out.println(flag + "  -=-3=-=> ");

		}

		Assert.assertEquals(flag, false);
		com.closeApplication();
	}

	@Test

	public void VerifyFilterUnderViewMenu() throws Exception {

		logger = BaseClass.exreporter.createTest("AR-1656");
		com.LunchApp("D:\\workspace\\");
		com.CreateProjectOnNewTool("Demo");
		Thread.sleep(1000);
		DesktopSession.findElementByName("Demo").click();
		Actions act = new Actions(DesktopSession);
		act.contextClick().perform();
		Thread.sleep(1000);
		DesktopSession.findElementByName("Batch Validation").click();
		Thread.sleep(1000);
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		try {

			DesktopSession.findElementByName("OK").click();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		boolean flag = false;
		DesktopSession.findElementByName(po.View_Menu).click();

		try {

			flag = DesktopSession.findElementByName("Filters").isDisplayed();
			System.out.println(flag + "  -=-=-=> ");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			flag = false;
			System.out.println(flag + "  -=-3=-=> ");

		}
		Assert.assertEquals(flag, false);
		com.closeApplication();
	}

	@Test

	public void VerifyStrictMode() throws Exception {

		logger = BaseClass.exreporter.createTest("AR-1667");
		com.LunchApp("D:\\workspace\\");
		boolean flag = false;
		try {

			flag = DesktopSession.findElementByName("Filters").isDisplayed();
			System.out.println(flag + "  -=-=-=> ");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			flag = false;
			System.out.println(flag + "  -=-3=-=> ");

		}
		Assert.assertEquals(flag, false);
		com.closeApplication();
	}
	
	@Test
	
	public void VerifyTooltipMsg () throws Exception {
		
		logger = BaseClass.exreporter.createTest("AR-1670");
		com.LunchApp("D:\\workspace\\");
		com.CreateProjectOnNewTool("Demo");
		Thread.sleep(1000);
		DesktopSession.findElementByName("Demo").click();
		Actions act = new Actions(DesktopSession);
		act.contextClick().perform();
		Thread.sleep(1000);
		DesktopSession.findElementByName("Batch Validation").click();
		Thread.sleep(1000);
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		//ERR009001: Unresolved proxies (5 items)
		List<WebElement>lst =DesktopSession.findElementsByName("Validation");
		System.out.println(lst.size());
		lst.get(1).click();
		act.doubleClick().perform();
		try {
			
			WebElement wb = DesktopSession.findElementByName("ERR009001: Unresolved proxies (5 items)");
			System.out.println(wb.isDisplayed());
			act.moveToElement(wb).build().perform();
		}catch (Exception e) {
			// TODO: handle exception
		}
		lst.get(1).click();
		act.doubleClick().perform();
		
		com.closeApplication();
	}
	
	@Test
	
public void VerifyTooltipErrorMsg () throws Exception {
		
		logger = BaseClass.exreporter.createTest("AR-1671");
		com.LunchApp("D:\\workspace\\");
		com.CreateProjectOnNewTool("Demo");
		Thread.sleep(1000);
		DesktopSession.findElementByName("Demo").click();
		Actions act = new Actions(DesktopSession);
		act.contextClick().perform();
		Thread.sleep(1000);
		DesktopSession.findElementByName("Batch Validation").click();
		Thread.sleep(1000);
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		//ERR009001: Unresolved proxies (5 items)
		List<WebElement>lst =DesktopSession.findElementsByName("Validation");
		System.out.println(lst.size());
		lst.get(1).click();
		act.doubleClick().perform();
		try {
			
			WebElement wb = DesktopSession.findElementByName("ERR009001: Unresolved proxies (5 items)");
			System.out.println(wb.isDisplayed());
			wb.click();
			rb.keyPress(KeyEvent.VK_RIGHT);
			rb.keyRelease(KeyEvent.VK_RIGHT);
			act.moveToElement(wb).build().perform();
		}catch (Exception e) {
			// TODO: handle exception
		}
		lst.get(1).click();
		act.doubleClick().perform();
		com.closeApplication();
	
	}
	
	@Test
	public void VerifyiniFile () throws Exception {
	
	logger = BaseClass.exreporter.createTest("AR-1673");
	String MemorySize = "";
	File f1=new File(Composepath+File.separator+"compose.ini"); //Creation of File Descriptor for input file
    String[] words=null;  //Intialize the word Array
    FileReader fr = new FileReader(f1);  //Creation of File Reader object
    BufferedReader br = new BufferedReader(fr); //Creation of BufferedReader object
    String s;     
    String input="failures=\"1\"";   // Input word to be searched
   
    int count=0;
    
    while((s=br.readLine())!=null)   //Reading Content from the file
    {
       words=s.split(" ");  //Split the word using space
       
        for (String word : words) 
        {
        	System.out.println(word);
               if (word.contains("-Xms"))   //Search for the given word
               {
              	 
                 MemorySize = word;  //If Present increase the count by one
                System.out.println(MemorySize);
                break;
                 
               }
        }
    }
   
       fr.close();
       System.out.println(MemorySize+"  klhgfxzfcj===> ");
       DesktopSession.findElementByName("Cancel").click();
       Assert.assertEquals(MemorySize, "-Xms256m");
 }
//	@Test
//
//	public void VerifyReloadPopup () throws Exception {
//	
//		logger = BaseClass.exreporter.createTest("AR-1734");
//		com.LunchApp("D:\\workspace\\");
//		String ProjPath = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator+"Model_Reload";
//		com.ImportProject(ProjPath);
//		//<SHORT-NAME>Dcm_0</SHORT-NAME>
//		try {
//		File f1=new File(ProjPath+File.separator+"EcucDescription.arxml"); //Creation of File Descriptor for input file
//	    String[] words=null;  //Intialize the word Array
//	    FileReader fr = new FileReader(f1);  //Creation of File Reader object
//	    BufferedReader br = new BufferedReader(fr); //Creation of BufferedReader object
//	    String s;     
//	    String input="failures=\"1\"";   // Input word to be searched
//	   
//	    int count=0;
//	    
//	    while((s=br.readLine())!=null)   //Reading Content from the file
//	    {
//	    	
//	    	 for (String word : words) 
//	         {
//	         	System.out.println(word);
//	                if (word.contains("<SHORT-NAME>Dcm_0</SHORT-NAME>"))   //Search for the given word
//	                {
//	                	word.replace("<SHORT-NAME>Dcm_0</SHORT-NAME>", "<SHORT-NAME>Dcm_1</SHORT-NAME>");
//	                	break;
//	                }
//	                }
//	    	
//	    	
//	    }
//	    DesktopSession.findElementByName("Model_Reload").click();
//	    com.ExpandProject(2);
//	    DesktopSession.findElementByName("EcucDescription.arxml").click();
//	    com.ExpandProject(7);
//	    Thread.sleep(500);
//	    WebElement wb =  DesktopSession.findElementByName("Rte_0 [Rte]");
//	    Actions act = new Actions(DesktopSession);
//	    act.doubleClick(wb).build().perform();
//	    Thread.sleep(500);
//	    boolean flag = DesktopSession.findElementByName("File Update").isDisplayed();
//	    System.out.println(flag);
//	    Assert.assertEquals(flag, true);
//	    
//		}finally {
//			File f1=new File(ProjPath+File.separator+"EcucDescription.arxml"); //Creation of File Descriptor for input file
//		    String[] words=null;  //Intialize the word Array
//		    FileReader fr = new FileReader(f1);  //Creation of File Reader object
//		    BufferedReader br = new BufferedReader(fr); //Creation of BufferedReader object
//		    String s;     
//		    String input="failures=\"1\"";   // Input word to be searched
//		   
//		    int count=0;
//		    
//		    while((s=br.readLine())!=null)   //Reading Content from the file
//		    {
//		    	
//		    	 for (String word : words) 
//		         {
//		         	System.out.println(word);
//		                if (word.contains("<SHORT-NAME>Dcm_1</SHORT-NAME>"))   //Search for the given word
//		                {
//		                	word.replace("<SHORT-NAME>Dcm_1</SHORT-NAME>", "<SHORT-NAME>Dcm_0</SHORT-NAME>");
//		                	break;
//		                }
//		                }
//		    	
//		    	
//		    }
//		    DesktopSession.findElementByName("Model_Reload").click();
//		    com.ExpandProject(2);
//		    DesktopSession.findElementByName("EcucDescription.arxml").click();
//		    com.ExpandProject(7);
//		    Thread.sleep(500);
//		    WebElement wb =  DesktopSession.findElementByName("Rte_0 [Rte]");
//		    Actions act = new Actions(DesktopSession);
//		    act.doubleClick(wb).build().perform();
//		    Thread.sleep(500);
//		    boolean flag = DesktopSession.findElementByName("File Update").isDisplayed();
//		    System.out.println(flag);
//		    Assert.assertEquals(flag, true);
//		}
//	
//}
}
