package genericUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriverException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenersImplementationClass implements ITestListener 
{

	public JavaUtility jUtils=new JavaUtility();
	
	ExtentReports report;
	ExtentTest test;
	
	public void onTestStart(ITestResult result) {
		test=report.createTest(result.getMethod().getMethodName());		
	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, result.getMethod().getMethodName());
		test.log(Status.PASS, result.getThrowable());
				
	}

	public void onTestFailure(ITestResult result) 
	{
		test.log(Status.FAIL,result.getMethod().getMethodName());
		test.log(Status.FAIL, result.getThrowable());
		
		String testCaseName = result.getMethod().getMethodName();
		try {
			WebDriverUtility.takeAScreenShot(BaseClass.sDriver,IPathConstant.SCREENSHOT_FILE_PATH+""+testCaseName+jUtils.generateSystemDateTime()+".png");
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, result.getMethod().getMethodName());
		test.log(Status.SKIP, result.getThrowable());		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		ExtentSparkReporter spark=new ExtentSparkReporter("./ExtentReports/vtigerReport"+jUtils.generateSystemDateTime()+".html");
		spark.config().setTheme(Theme.DARK);
		spark.config().setReportName("Vtiger Extent Report For January 2024");
		spark.config().setDocumentTitle("Vtiger Report For Sprint 17");
		
		report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("createdBy", "vineet");
		report.setSystemInfo("ReviwedBy", "akash");
		report.setSystemInfo("platform", "windows10");
		report.setSystemInfo("ServerName","ApacheTomcat");
		report.setSystemInfo("OS","Windows");
		report.setSystemInfo("Version","5.0.3");
		
	}

	public void onFinish(ITestContext context) {
		report.flush();		
	}
	
	
	

}
