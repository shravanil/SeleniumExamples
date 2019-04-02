package FrameworkLibrary;

import java.lang.reflect.Method;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ApplicationPages.LoginPage;

public class BaseClass 
{
	public static WebDriver driver = null;

	public static String DataFilesPath = "DataFiles";
	public static String AttachmentFiles = "F:\\NeonWorkspace\\SignMaven\\AttachFiles";
	public static String AutoItPath = "F:\\NeonWorkspace\\SignMaven\\AutoITFiles";
	public static String DownloadPath = "C:\\Users\\shravanim\\Downloads";
	public static String CurrentTestCaseName = "";
	public static String CurrentModuleName = "";
	public static String CurrentFolderPath= "";
	
	@BeforeSuite
	public void beforesuite()
	{
		ReportLibrary.CreateNewExtentReportInResultsFolderWithDateAndTimeStamp();
	}
	
	@BeforeMethod
	public void beforemethod(Method currentmethod)
	{
		CurrentTestCaseName = currentmethod.getName();
		CurrentModuleName = currentmethod.getDeclaringClass().getSimpleName();
		
		DataLibrary.CurrentTestData = DataLibrary.loadDataFromExceltoHashMap(CurrentTestCaseName, CurrentModuleName);
		DataLibrary.loadDataFromJsontoHashMap();
		
		
		ReportLibrary.startExtentTestForCurrentTestCase();
		
		WebLibrary.launchBrowser(DataLibrary.CurrentTestData.get("BrowserName"));
		WebLibrary.launchApplication(DataLibrary.CurrentTestData.get("BaseURL"));
		WebLibrary.SetImplicitWait(30, driver);
		
	}
	
	@AfterMethod
	public void aftermethod()
	{
		ReportLibrary.endExtentTestForCurrentTestCase();
		DataLibrary.loadDataFromHashMaptoExcel(CurrentTestCaseName, CurrentModuleName);
		
		WebLibrary.quitdriver();
	}
	
	@AfterSuite
	public void aftersuite()
	{
		ReportLibrary.closeExtentReport();
		ReportLibrary.LaunchReport();
		
	}
}
