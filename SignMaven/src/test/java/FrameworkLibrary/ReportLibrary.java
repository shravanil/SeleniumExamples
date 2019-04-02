package FrameworkLibrary;


import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.imageio.ImageIO;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ReportLibrary 
{
	public static ExtentReports report;
	public static ExtentTest test;
	public static String CurrentResultPath;
	
	public static void CreateNewExtentReportInResultsFolderWithDateAndTimeStamp()
	{
		// get current folder path
		BaseClass.CurrentFolderPath = System.getProperty("user.dir") + "\\Results";

		// create folder with date and time stamp
		DateFormat dateTimeInstance = SimpleDateFormat.getDateTimeInstance();
		String DateTimeStamp = dateTimeInstance.format(Calendar.getInstance().getTime());
		DateTimeStamp = DateTimeStamp.replace(",", "");
		DateTimeStamp = DateTimeStamp.replace(" ", "_");
		DateTimeStamp = DateTimeStamp.replace(":", "-");
		CurrentResultPath = BaseClass.CurrentFolderPath + "\\" + DateTimeStamp;
		File dir = new File(CurrentResultPath);
		dir.mkdir();
		
		//create folder with name as Scrrenshots
		File dir1 = new File(CurrentResultPath + "\\Screenshots");
		dir1.mkdir();

		// create extent report
		report = new ExtentReports(CurrentResultPath + "\\Summary.html", true);
	}
	
	public static void startExtentTestForCurrentTestCase()
	{
		test = report.startTest(BaseClass.CurrentTestCaseName);
		System.out.println("<<TestStart>>" + BaseClass.CurrentTestCaseName);
	}
	
	public static void endExtentTestForCurrentTestCase()
	{
		report.endTest(test);
		System.out.println("<<TestCompleted>>" + BaseClass.CurrentTestCaseName);
	}
	
	public static void closeExtentReport()
	{
		report.close();
	}


	public static void reportEvent(boolean stepstatus,String PassMessage, String FailMessage,boolean takescrrenshot) 
	{
		if (stepstatus == true) 
		{
			System.out.println("	<<PASS>> " + PassMessage);
			if (takescrrenshot==true) 
			{
				test.log(LogStatus.PASS, PassMessage + test.addScreenCapture(getScreenshot()));
			} 
			else 
			{
				test.log(LogStatus.PASS, PassMessage);
			}
		} 
		else 
		{
			System.out.println("	<<FAIL>> " + FailMessage);
			if (takescrrenshot==true) 
			{
				test.log(LogStatus.FAIL, FailMessage + test.addScreenCapture(getScreenshot()));
			} 
			else 
			{
				test.log(LogStatus.FAIL, FailMessage);
			}
		}
		Assert.assertEquals(stepstatus, true);
	}
	
	public static void reportEvent(boolean stepstatus,String PassMessage, String FailMessage) 
	{
		if (stepstatus == true) 
		{
			System.out.println("	<<PASS>> " + PassMessage);
			test.log(LogStatus.PASS, PassMessage);
		} 
		else 
		{
			System.out.println("	<<FAIL>> " + FailMessage);
			test.log(LogStatus.FAIL, FailMessage);
		}
		Assert.assertEquals(stepstatus, true);
	}
	
	
	public static String  getScreenshot()
	{
		String Dest = CurrentResultPath + "\\Screenshots\\";
		try 
		{
			DateFormat dateTimeInstance = SimpleDateFormat.getDateTimeInstance();
			String DateTimeStamp = dateTimeInstance.format(Calendar.getInstance().getTime());
			DateTimeStamp = DateTimeStamp.replace(",", "");
			DateTimeStamp = DateTimeStamp.replace(" ", "_");
			DateTimeStamp = DateTimeStamp.replace(":", "-");

			Dest = Dest + BaseClass.CurrentTestCaseName + DateTimeStamp + ".png";

			TakesScreenshot ts = (TakesScreenshot) BaseClass.driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			File destinationfile = new File(Dest);
			FileUtils.copyFile(source, destinationfile);

			// Get entire page screenshot
			File screenshot = ((TakesScreenshot) BaseClass.driver).getScreenshotAs(OutputType.FILE);
			ImageIO.write(ImageIO.read(screenshot), "png", screenshot);

			// Copy the element screenshot to disk
			FileUtils.copyFile(screenshot, new File(Dest));
		} 
		catch (Exception e) 
		{
			System.out.println("Exception occured while taking Scrrenshot");
		}
		return Dest;
	}
	
	public static void LaunchReport()
	{
		WebLibrary.launchBrowser("chrome");
		WebLibrary.launchApplication(CurrentResultPath + "\\Summary.html");
	}
}