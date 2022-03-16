package manualTestCase;

import org.testng.annotations.Test;

import com.Common;
import com.Utility;

import base.BaseClass;

public class Workflow extends BaseClass {
	
	Common com = new Common();
	Utility ut = new Utility();
	@Test
	
	public void WorkflowLDFToEcuExtract() throws Exception {
		
		logger = BaseClass.exreporter.createTest("AR-1333");
		//com.LunchApp("D:\\workspace\\");
		String value = ut.Read("C:\\Users\\sandeepa8\\Downloads\\LDF_Input_Files\\LDF2ECU.c4k");
		System.out.println(value+ "  =-=-=-> ");
		 String search  = "C:\\Users\\soujanyap1.KPIT\\Downloads\\LDF_Input_Files\\PWL21_E1A_R1_HCP_LIN_1.ldf, C:\\Users\\soujanyap1.KPIT\\Downloads\\LDF_Input_Files\\PWL21_E1A_R1_HCP_LIN_2.ldf";
	        String replacement = "C:\\Users\\sandeepa8\\Downloads\\LDF_Input_Files\\PWL21_E1A_R1_HCP_LIN_1.ldf, C:\\Users\\sandeepa8\\Downloads\\LDF_Input_Files\\PWL21_E1A_R1_HCP_LIN_2.ldf";
	        //value.replaceAll(search, replacement);
	       String [] arr =  value.split("= ");
	       System.out.println(arr[1]+" 8888888=====> ");
	       String data = arr[1];
	       String [] data1 = data.split("\n");
	       System.out.println(data1[0]+" *******========>   ");
	       String filepath = "C:\\Users\\sandeepa8\\Downloads\\LDF_Input_Files\\PWL21_E1A_R1_HCP_LIN_1.ldf, C:\\Users\\sandeepa8\\Downloads\\LDF_Input_Files\\PWL21_E1A_R1_HCP_LIN_2.ldf";
	       String oldpath  = data1[0];
	       ut.WriteOnTxt("C:\\Users\\sandeepa8\\Downloads\\LDF_Input_Files\\LDF2ECU.c4k", oldpath, filepath);
	
	}

}
