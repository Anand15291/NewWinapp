package utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.*;

@SuppressWarnings("unused")
public class RetryAnalyzer implements IRetryAnalyzer {
int count = 0 ;
int retryCount = 1;
	public boolean retry(ITestResult result) {
		while(count<retryCount) {
			
			count++;
		}
		return false;
	}

}
