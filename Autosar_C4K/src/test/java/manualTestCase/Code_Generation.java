package manualTestCase;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.Common;
import com.Utility;

import base.BaseClass;

public class Code_Generation extends BaseClass {

	Common com = new Common();
	Utility ut = new Utility();

	@Test

	public void addModuleGenerateCode() throws Exception {

		logger = BaseClass.exreporter.createTest("AR-379");
		com.LunchApp("D:\\workspace\\");
		String ProjPath = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator + "gctest";
		com.ImportProjectSaveWorkspace(ProjPath);
		String arxmlPath = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator
				+ "EcucDescription.arxml";
		com.addModuleGenerateCodes("gctest", arxmlPath);

	}
	
	
	@Test

	public void addSystemExtractFile() throws Exception {

		logger = BaseClass.exreporter.createTest("AR-380");
		com.LunchApp("D:\\workspace\\");
		String ProjPath = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator + "Test1234";
		String filePath = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator + "Flexray_system_file.arxml";
		com.ImportProjectSaveWorkspace(ProjPath);
		com.addSystemExtractFileVerification("Test1234", filePath);
		
	}
	

	@Test

	public void validationGenericStructure() throws Exception {

		logger = BaseClass.exreporter.createTest("AR-377");
		com.LunchApp("D:\\workspace\\");
		String ProjPath = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator + "test1";
		com.ImportProjectSaveWorkspace(ProjPath);
		String outPath = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator + "test1"
				+ File.separator + "output1" + File.separator + "Validation.txt";
		com.validateGenricStucture("test1", outPath);

	}

	@Test

	public void prefixValidation() throws Exception {

		logger = BaseClass.exreporter.createTest("AR-851");
		com.LunchApp("D:\\workspace\\");
		String ProjPath = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator + "BSW1";
		com.ImportProjectSaveWorkspace(ProjPath);
		com.validatePrefixName("KEIHIN_421", ProjPath);
		File directoryPath = new File(ProjPath);
		String contents[] = directoryPath.list();
		System.out.println(contents.length);
		System.out.println("List of files and directories in the specified directory:");
		for (int i = 0; i < contents.length; i++) {
			if (contents[i].contains(
					"_BswM, _EcuC, 10_EcuM, 11_FiM,12_ComM,140_CanSM,15_Det,2_Rte,20_NvM,201_Crc,22_MemIf,60_CanIf"))
				logger.pass("Prefix Actual Names" + contents[i]);

		}
	}
	
	
	@Test

	public void ecumCodeGenerationValidation() throws Exception {

		logger = BaseClass.exreporter.createTest("AR-858");
		com.LunchApp("D:\\workspace\\");
		String ProjPath = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator + "BSW1";
		com.ImportProjectSaveWorkspace(ProjPath);
	}
	

	
	
	
	
	@Test

	public void prefixVerification() throws Exception {

		logger = BaseClass.exreporter.createTest("AR-876");
		com.LunchApp("D:\\workspace\\");
		String ProjPath = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator + "hell";
		com.ImportProjectSaveWorkspace(ProjPath);
		com.validatePrefixNameEcuc("hell", ProjPath);
		File directoryPath = new File(ProjPath);
		String contents[] = directoryPath.list();
		System.out.println(contents.length);
		System.out.println("List of files and directories in the specified directory:");
		for (int i = 0; i < contents.length; i++) {
			if (contents[i].contains(
					"_BswM, _EcuC, 10_EcuM, 11_FiM,12_ComM,140_CanSM,15_Det,2_Rte,20_NvM,201_Crc,22_MemIf,60_CanIf"))
				logger.pass("Prefix Actual Names" + contents[i]);

		}
	}
	
	
	@Test

	public void npeGenerateCode() throws Exception {

		logger = BaseClass.exreporter.createTest("AR-883");
		com.LunchApp("D:\\workspace\\");
		String ProjPath = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator + "hell1";
		com.ImportProjectSaveWorkspace(ProjPath);
		String arxmlPath = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator
				+ "EcucDescription_flexray.arxml";
		com.addModuleNpeGenerateCodes("hell1", arxmlPath);

	}
	
	@Test

	public void comModuleNpeCodegeneration() throws Exception {

		logger = BaseClass.exreporter.createTest("AR-1083");
		com.LunchApp("D:\\workspace\\");
		String ProjPath = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator + "hell2";
		com.ImportProjectSaveWorkspace(ProjPath);
		com.validateComCodeGeneration("hell2");
	}
	
	

	
	
	@Test

	public void rememberInputTools() throws Exception {

		logger = BaseClass.exreporter.createTest("AR-923");
		com.LunchApp("D:\\workspace\\");
		String ProjPath = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator + "Test1234";
		String filePath = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator + "Flexray_system_file.arxml";
		com.ImportProjectSaveWorkspace(ProjPath);
		com.toolRememberTheInputs("Test1234", filePath);
		
	}
	
	
	
	
	
	@Test

	public void rteCodeGenerationValidation() throws Exception {

		logger = BaseClass.exreporter.createTest("AR-932");
		com.LunchApp("D:\\workspace\\");
		String ProjPath = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator + "RLM_1LR_2LR";
		com.ImportProjectSaveWorkspace(ProjPath);
		com.CodeGenerationForRte("RLM_1LR_2LR", "Rte_0 [/KPIT/EcucDefs/Rte]");
	}
	

	@Test

	public void NameSpaceOnCodeGeneration() throws Exception {
	    
		logger = BaseClass.exreporter.createTest("AR-1074");
		com.LunchApp("D:\\workspace\\");
		String ProjPath = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator
				+ "GenerateCode";
		com.ImportProjectSaveWorkspace(ProjPath);
		com.RenameEcucFile("BSW", "Ecuc Description.arxml", "EcucDescription.arxml");
		com.GenerateCodes("BSW", "CanSM_0 [/AUTOSAR/EcucDefs/CanSM]");
		//com.RenameEcucFile("BSW", "EcucDescription.arxml", "Ecuc Description.arxml");
		 com.closeApplication();
	}

	@Test

	public void CustomizeOutputPath() throws Exception {

		logger = BaseClass.exreporter.createTest("AR-373");
		com.LunchApp("D:\\workspace\\");
		com.CreateProjectOnNewTool("Demo");
		com.NewCreateDefaultArxml("Demo");
		String DirPath = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator
				+ "CodeGenerationFiles";
		com.AddContainerToDefaultArxml("Demo", "Crc");
		com.GenerateCodeToParticularDir("Demo", "Crc_0 [/AUTOSAR/KPIT/Crc]", DirPath);
		String validationtxtpath = DirPath + File.separator + "201_Crc";
		String filename = ut.FilesnamesOnDir(validationtxtpath, ".txt");
		System.out.println(filename + " -=-=-> ");
		String Hfile = validationtxtpath + File.separator + "inc";
		String filenameh = ut.FilesnamesOnDir(Hfile, ".h");
		System.out.println(filenameh + " -=-=-> ");
		Assert.assertEquals(filename, "Validation.txt");
		Assert.assertEquals(filenameh, "Crc_Cfg.h");
		com.closeApplication();
	}

	@Test

	public void ModuleSelection() throws Exception {

		logger = BaseClass.exreporter.createTest("AR-372");
		com.LunchApp("D:\\workspace\\");
		com.CreateProjectOnNewTool("Demo");
		com.NewCreateDefaultArxml("Demo");
		String DirPath = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator
				+ "CodeGenerationFiles";
		com.AddContainerToDefaultArxml("Demo", "Crc");
		com.AddContainerToDefaultArxml("Demo", "EcuC");
		com.VerifySelectAllButton("Demo");
		com.closeApplication();
	}

	@Test

	public void VerifyOptionsButton() throws Exception {
		logger = BaseClass.exreporter.createTest("AR-371");
		com.LunchApp("D:\\workspace\\");
		com.CreateProjectOnNewTool("TestDemo");
		com.NewCreateDefaultArxml("TestDemo");
		com.VerifyOptionAllbutton("TestDemo", "Rte");
		com.closeApplication();
	}

	@Test

	public void ContainingSameModule() throws Exception {

		logger = BaseClass.exreporter.createTest("AR-370");
		com.LunchApp("D:\\workspace\\");
		//com.CreateProjectOnNewTool("Demo");
		int length = 5;
		boolean useLetters = true;
		boolean useNumbers = true;
		String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
		System.out.println(generatedString + "  =-===>  ");
		String DirPath = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator
				+ "CodeGenerationFiles"+ File.separator +generatedString;
		String ProjPath = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator
				+ "AR-635";
		com.ImportProjectSaveWorkspace(ProjPath);
//		com.ImportSingleFile("Demo", "IOPT_minimal_system_desc.arxml");
//		com.GenerateECUCMapping("Demo");
		com.AddContainerToECUCDescription("OldTest", "Com");
		Thread.sleep(4000);
		DesktopSession.findElementByName("OldTest").click();
		logger.pass("Click on the Project");
		com.ExpandProject(2);
		logger.pass("Expand on the Project");
		Actions act = new Actions(DesktopSession);
		act.contextClick(DesktopSession.findElementByName("OldTest")).build().perform();
		Thread.sleep(1000);
		DesktopSession.findElementByName("Generate Code").click();
		Thread.sleep(500);
		com.selectModuleCodeGeneration("Com_0 [/AUTOSAR/KPIT/Com]");
		com.selectModuleCodeGeneration("Com_1 [/AUTOSAR/KPIT/Com]");
		com.CodeGenerationToSpecificDir(DirPath);
		boolean flag = false;
		File file = new File(DirPath);
		String[] names = file.list();

		for (String name : names) {
			System.out.println(name);
			if (name.contains("_Com")) {
				flag = true;

			}
		}
		System.out.println(flag);
		Assert.assertEquals(flag, true);
		com.closeApplication();

	}

	@Test

	public void SupportDeppendantModule() throws Exception {

		logger = BaseClass.exreporter.createTest("AR-368");
		com.LunchApp("D:\\workspace\\");
		com.CreateProjectOnNewTool("TestDemo");
		com.NewCreateDefaultArxml("TestDemo");
		com.NewCreateDefaultArxml("TestDemo");
		com.CodeGenerationDiffFiles("TestDemo");
		String DirPath = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator
				+ "CodeGenerationFiles";
		boolean flag = false;
		File file = new File(DirPath);
		String[] names = file.list();

		for (String name : names) {
			System.out.println(name);
			if (name.contains("_Com") || name.contains("_EcuC")) {
				flag = true;

			}
		}
		System.out.println(flag);
		Assert.assertEquals(flag, true);
		com.closeApplication();
	}

	@Test

	public void CodeGenerationofDifftArxml() throws Exception {

		logger = BaseClass.exreporter.createTest("AR-366");
		com.LunchApp("D:\\workspace\\");
		com.CreateProjectOnNewTool("TestNewDemo");
		com.NewCreateDefaultArxml("TestNewDemo");
		com.NewCreateDefaultArxml("TestNewDemo");
		com.CodeGenerationMultipleArxml("TestNewDemo");
		String DirPath = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator
				+ "CodeGenerationFiles";
		boolean flag = false;
		File file = new File(DirPath);
		String[] names = file.list();

		for (String name : names) {
			System.out.println(name);
			if (name.contains("_Com") || name.contains("_EcuC")) {
				flag = true;

			}
		}
		System.out.println(flag);
		Assert.assertEquals(flag, true);
		com.closeApplication();

	}
	
	@Test

	public void saveConfigurationVerification() throws Exception {

		logger = BaseClass.exreporter.createTest("AR-1142");
		com.LunchApp("D:\\workspace\\");
		String ProjPath = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator + "BSR";
		//String filePath = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator + "Flexray_system_file.arxml";
		com.ImportProjectSaveWorkspace(ProjPath);
		com.saveConfigValidation("ASR");
		
	}

	@Test

	public void CodegenerationFiles() throws Exception {
		logger = BaseClass.exreporter.createTest("AR-367");
		com.LunchApp("D:\\workspace\\");
		com.CreateProjectOnNewTool("DemoTest");
		com.NewCreateDefaultArxml("DemoTest");
		DesktopSession.findElementByName("DemoTest").click();
		com.ExpandProject(2);
		com.AddContainerToDefaultArxml("DemoTest", "EcuC");
		com.AddContainerToDefaultArxml("DemoTest", "Crc");
		com.AddContainerToDefaultArxml("DemoTest", "Csm");
		int length = 5;
		boolean useLetters = true;
		boolean useNumbers = true;
		String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
		System.out.println(generatedString + "  =-===>  ");
		Thread.sleep(3000);
		DesktopSession.findElementByName("DemoTest").click();
		logger.pass("Click on the Project");
		com.ExpandProject(2);
		logger.pass("Expand on the Project");
		Actions act = new Actions(DesktopSession);
		act.contextClick(DesktopSession.findElementByName("DemoTest")).build().perform();
		Thread.sleep(1000);
		DesktopSession.findElementByName("Generate Code").click();
		Thread.sleep(500);
		String DirPath = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator
				+ "CodeGenerationFiles" + File.separator + generatedString;
		com.selectModuleCodeGeneration("Csm_0 [/AUTOSAR/KPIT/Csm]");
		com.selectModuleCodeGeneration("EcuC_0 [/AUTOSAR/KPIT/EcuC]");
		com.selectModuleCodeGeneration("Crc_0 [/AUTOSAR/KPIT/Crc]");
		com.CodeGenerationToSpecificDir(DirPath);
		File file = new File(DirPath);
		String[] names = file.list();
		for (int j = 0; j <= names.length - 1; j++) {
			String val = names[j];
			System.out.println(val + " -=-=-> " + j);

		}
		Assert.assertEquals(names[0], "110_Csm");
		Assert.assertEquals(names[1], "201_Crc");
		Assert.assertEquals(names[3], "_EcuC");
		com.closeApplication();
		try {
			File fil = new File(DirPath);

			FileUtils.deleteDirectory(fil);
		} catch (Exception e) {
			// TODO: handle exception
		}
		boolean flag = file.delete();

		System.out.println(flag);
	}

	@Test

	public void SupportEcucDescFile() throws Exception {

		logger = BaseClass.exreporter.createTest("AR-365");
		com.LunchApp("D:\\workspace\\");
		//com.CreateProjectOnNewTool("OldDemo");
		int length = 5;
		boolean useLetters = true;
		boolean useNumbers = true;
		String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
		System.out.println(generatedString + "  =-===>  ");
		String DirPath = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator
				+ "CodeGenerationFiles" + File.separator + generatedString;
		String ProjPath = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator
				+ "AR-635";
		com.ImportProjectSaveWorkspace(ProjPath);
//		com.ImportSingleFile("OldDemo", "IOPT_minimal_system_desc.arxml");
//		com.GenerateECUCMapping("OldDemo");
		Thread.sleep(4000);
		DesktopSession.findElementByName("OldTest").click();
		logger.pass("Click on the Project");
		com.ExpandProject(2);
		logger.pass("Expand on the Project");
		Actions act = new Actions(DesktopSession);
		act.contextClick(DesktopSession.findElementByName("OldTest")).build().perform();
		Thread.sleep(1000);
		DesktopSession.findElementByName("Generate Code").click();
		Thread.sleep(500);
		com.selectModuleCodeGeneration("ComM_0 [/AUTOSAR/KPIT/ComM]");
		com.selectModuleCodeGeneration("CanIf_0 [/AUTOSAR/EcucDefs/CanIf]");
		com.selectModuleCodeGeneration("BswM_0 [/AUTOSAR/KPIT/BswM]");
		com.selectModuleCodeGeneration("Com_0 [/AUTOSAR/KPIT/Com]");
		com.CodeGenerationToSpecificDir(DirPath);
		String validationtxtpath = DirPath + File.separator + "_BswM";
		String filename = ut.FilesnamesOnDir(validationtxtpath, ".txt");
		//System.out.println(filename + " -=-=-> ");
		String Hfile = DirPath + File.separator + "12_ComM" + File.separator + "inc";
		String Cfile = DirPath + File.separator + "12_ComM" + File.separator + "src";
		String filenameh = ut.FilesnamesOnDir(Hfile, ".h");
		//System.out.println(filenameh + " -=-=-> ");
		String filenamec = ut.FilesnamesOnDir(Cfile, ".c");
		//System.out.println(filenamec + " -=-=-> ");
		String txtfile = ut.Read(DirPath + File.separator + "_BswM" + File.separator + "Validation.txt");
		boolean val = txtfile.contains("ERR");
		boolean val1 = txtfile.contains("INF");
		String CanIftxtfile = ut.Read(DirPath + File.separator + "60_CanIf" + File.separator + "Validation.txt");
		boolean val2 = CanIftxtfile.contains("ERR");
		boolean val3 = CanIftxtfile.contains("INF");
		String comtxtfile = ut.Read(DirPath + File.separator + "50_Com" + File.separator + "Validation.txt");
		boolean val4 = comtxtfile.contains("ERR");
		boolean val5 = comtxtfile.contains("INF");
		String ComIftxtfile = ut.Read(DirPath + File.separator + "12_ComM" + File.separator + "Validation.txt");
		boolean val6 = ComIftxtfile.contains("ERR");
		boolean val7 = ComIftxtfile.contains("INF");
		System.out.println(val + "-- " + val1 + "-- " + val2 + "-- " + val3 + "-- " + val4 + "-- " + val5 + "-- " + val6
				+ "-- " + val7);
		Assert.assertEquals(filenameh, "ComM_Cfg.h");
		Assert.assertEquals(filenamec, "ComM_Cfg.c");
		Assert.assertEquals(val, true);
		Assert.assertEquals(val1, true);
		Assert.assertEquals(val2, true);
		Assert.assertEquals(val3, true);
		Assert.assertEquals(val4, true);
		Assert.assertEquals(val5, true);
		Assert.assertEquals(val6, false);
		Assert.assertEquals(val7, true);
		com.closeApplication();
		File file = new File(DirPath);
		try {
			File fil = new File(DirPath);

			FileUtils.deleteDirectory(fil);
		} catch (Exception e) {
			// TODO: handle exception
		}
		boolean flag = file.delete();

		System.out.println(flag);
		
	}

//	public void VerifyModule() throws Exception {
//		logger = BaseClass.exreporter.createTest("AR-364");
//		com.LunchApp("D:\\workspace\\");
//		com.CreateProjectOnNewTool("DemoTest");
//		com.NewCreateDefaultArxml("DemoTest");
//		DesktopSession.findElementByName("DemoTest").click();
//		com.ExpandProject(2);
//		com.AddContainerToDefaultArxml("DemoTest", "EcuC");
//		com.AddContainerToDefaultArxml("DemoTest", "Crc");
//		com.AddContainerToDefaultArxml("DemoTest", "Csm");
//		int length = 5;
//		boolean useLetters = true;
//		boolean useNumbers = true;
//		String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
//		System.out.println(generatedString+"  =-===>  ");
//		Thread.sleep(3000);
//		
//	}

	@Test

	public void VerifyToolHang() throws Exception {
		logger = BaseClass.exreporter.createTest("AR-1131");
		com.LunchApp("D:\\workspace\\");
		com.CreateProjectOnNewTool("DemoTest");
		com.NewCreateDefaultArxml("DemoTest");
		DesktopSession.findElementByName("DemoTest").click();
		com.ExpandProject(2);
		com.AddContainerToDefaultArxml("DemoTest", "EcuC");
		com.AddContainerToDefaultArxml("DemoTest", "Crc");
		com.VerifyToolHang("DemoTest");
		com.closeApplication();
	}

	@Test

	public void ARXMLFileFolderSelection() throws Exception {

		logger = BaseClass.exreporter.createTest("AR-1050");
		com.LunchApp("D:\\workspace\\");
		String projpath = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator + "AR1050";
		com.CopyProjectToWorkspace(projpath);
		com.VerifyInputSectionFile("BSW");
		com.closeApplication();
	}

	@Test

	public void CodeGenerationOnProjectLevel() throws Exception {

		logger = BaseClass.exreporter.createTest("AR-369");
		com.LunchApp("D:\\workspace\\");
		String Projpath = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator
				+ "CodeGenerationFiles";
		int length = 5;
		boolean useLetters = true;
		boolean useNumbers = true;
		String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
		String generatedString1 = RandomStringUtils.random(length, useLetters, useNumbers);
		String generatedString2 = RandomStringUtils.random(length, useLetters, useNumbers);
		com.ImportProjectSaveWorkspace(Projpath);
		Thread.sleep(6000);
		String ProjectOne = "TestDemo";
		String ProjectTwo = "TestDemo1";
		String ProjectThree = "TestDemo2";
		String DirPath = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator
				+ "CodeGenerationFiles" + File.separator + generatedString;
		String DirPath1 = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator
				+ "CodeGenerationFiles" + File.separator + generatedString1;
		String DirPath2 = System.getProperty("user.dir") + File.separator + "ImportProject" + File.separator
				+ "CodeGenerationFiles" + File.separator + generatedString2;
		// Project one Generate Code
		com.CodeGenerationProjectLevel(ProjectOne, DirPath, "Crc_0 [/AUTOSAR/KPIT/Crc]");
		String Hfile = DirPath + File.separator + "201_Crc" + File.separator + "inc";
		String Cfile = DirPath + File.separator + "201_Crc" + File.separator + "src";
		System.out.println(Cfile + "  = -=-> " + Hfile);
		String validationtxtpath = DirPath + File.separator + "201_Crc";
		String filename = ut.FilesnamesOnDir(validationtxtpath, ".txt");
		String H = ut.FilesnamesOnDir(Hfile, ".h");
		String C = ut.FilesnamesOnDir(Cfile, ".c");
		System.out.println(filename + " -=-=-> Project one ");
		System.out.println(H + " -=-=-> H file ");
		System.out.println(C + " -=-=-> c file ");
		// Project Two Generate Code
		com.CodeGenerationProjectLevel(ProjectTwo, DirPath1, "Csm_0 [/AUTOSAR/KPIT/Csm]");
		String Hfile1 = DirPath1 + File.separator + "110_Csm" + File.separator + "inc";
		String Cfile1 = DirPath1 + File.separator + "110_Csm" + File.separator + "src";
		System.out.println(Cfile1 + "  = -=-> " + Hfile1);
		String validationtxtpath1 = DirPath1 + File.separator + "110_Csm";
		String filename1 = ut.FilesnamesOnDir(validationtxtpath1, ".txt");
		System.out.println(filename1 + " -=-=-> Project Two ");
		String H1 = ut.FilesnamesOnDir(Hfile1, ".h");
		String C1 = ut.FilesnamesOnDir(Cfile1, ".c");
		System.out.println(H1 + " -=-=-> H file ");
		System.out.println(C1 + " -=-=-> c file ");
		// Project Three Generate Code
		com.CodeGenerationProjectLevel(ProjectThree, DirPath2, "EcuC_0 [/AUTOSAR/KPIT/EcuC]");
		String Hfile2 = DirPath2 + File.separator + "110_Csm" + File.separator + "inc";
		String Cfile2 = DirPath2 + File.separator + "110_Csm" + File.separator + "src";
		System.out.println(Cfile2 + "  = -=-> " + Hfile2);
		String validationtxtpath2 = DirPath2 + File.separator + "110_Csm";
		String filename2 = ut.FilesnamesOnDir(validationtxtpath2, ".txt");
		System.out.println(filename2 + " -=-=->Project Three ");
		String H2 = ut.FilesnamesOnDir(Hfile2, ".h");
		String C2 = ut.FilesnamesOnDir(Cfile2, ".c");
		System.out.println(H2 + " -=-=-> H file ");
		System.out.println(C2 + " -=-=-> c file ");
		com.closeApplication();
		// Delete folderOne
		File file = new File(DirPath);
		try {
			File fil = new File(DirPath);

			FileUtils.deleteDirectory(fil);
		} catch (Exception e) {
			// TODO: handle exception
		}
		boolean flag = file.delete();

		System.out.println(flag);
//		// Delete folderTwo
		try {
			File fil = new File(DirPath1);

			FileUtils.deleteDirectory(fil);
		} catch (Exception e) {
			// TODO: handle exception
		}
		boolean flag1 = file.delete();

		System.out.println(flag1);
		// Delete folderTHree
		try {
			File fil = new File(DirPath2);

			FileUtils.deleteDirectory(fil);
		} catch (Exception e) {
			// TODO: handle exception
		}
		boolean flag2 = file.delete();
		boolean hflag =false;
		boolean cflag = false;
		boolean validationflag= false;
		System.out.println(flag2);
		if((H.contains(".h"))||(H1.contains(".h"))||(H2.contains(".h"))) {
			hflag=true;
		}
		if((C.contains(".c"))||(C1.contains(".c"))||(C2.contains(".c"))) {
			cflag=true;
		}
		if(filename.equalsIgnoreCase("Validation.txt") && filename.equalsIgnoreCase("Validation.txt")&&filename.equalsIgnoreCase("Validation.txt")) {
			validationflag = true;
		}
		Assert.assertEquals(cflag, true);
		Assert.assertEquals(hflag, true);
		Assert.assertEquals(validationflag, true);
	}
	

}
