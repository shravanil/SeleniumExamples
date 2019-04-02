package FrameworkLibrary;


import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Driver;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Finder;
import org.sikuli.script.Match;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import com.relevantcodes.extentreports.LogStatus;

import ApplicationPages.MyApprovalPage;

public class WebLibrary
{


	public static void launchBrowser(String BrowserName)
	{
		WebDriver driver = null;
		switch (BrowserName.toLowerCase()) 
		{
			case "chrome": 
				{
					System.setProperty("webdriver.chrome.driver", "BrowserServers\\chromedriver.exe");
					driver = new ChromeDriver();
					break;
				}
			case "ie":
			case "internetexplorer": 
				{
					System.setProperty("webdriver.ie.driver", "BrowserServers\\IEDriverServer.exe");
					driver = new InternetExplorerDriver();
					break;
				}
			case "firefox": 
			{
				boolean firefoxinvoked = false;
				try 
				{
					driver = new FirefoxDriver();
					firefoxinvoked = true;
				} catch (Exception e) 
				{
					firefoxinvoked = false;
				}
				if (firefoxinvoked == false) 
				{
					System.setProperty("webdriver.gecko.driver", "BrowserServers\\geckodriver.exe");
					driver = new FirefoxDriver();
				}
				break;
			}
			default: 
				{
					System.out.println("please Select the correct browser");
				}
		}
		BaseClass.driver = driver;
	}
	
	
	public static boolean launchApplication(String URL) 
	{
		boolean stepstatus;
		try 
		{
			BaseClass.driver.get(URL);
			BaseClass.driver.manage().window().maximize();
			stepstatus = true;
		} catch (Exception e) 
		{
			stepstatus = false;
		}
		return stepstatus;
	}
	
	public static boolean setText(WebElement ele, String StrValue) 
	{	boolean stepstatus;
		try
		{
			ele.click();
			ele.clear();
			ele.sendKeys(StrValue);
			stepstatus = true;
		} catch (Exception e) 
		{
			stepstatus = false;
		}
		return stepstatus;
	}

	public static boolean clickElement(WebElement ele) 
	{
		boolean stepstatus;
		try
		{
			ele.click();
			stepstatus = true;
		} 
		catch (Exception e)
		{
			stepstatus = false;
		}
		return stepstatus;
	}

	public static boolean selectDate(String StrDate)
	{
		boolean stepstatus;
		try
		{
			BaseClass.driver.findElement(By.xpath("//table/tbody/tr/td[contains(text(),'"+StrDate+"')]")).click();
			stepstatus = true;
			ReportLibrary.reportEvent(stepstatus, "Able to select date", "Unable to select date",true);
		}
		catch (Exception e)
		{
			stepstatus = false;
			System.out.println("Unable to select date");
		}
		return stepstatus;
	}
	
	public static boolean setOptionInSelectBox(WebElement ele, String eleOption) 
	{
		boolean stepstatus = false;
		try 
		{
			Select s1 = new Select(ele);
			s1.selectByVisibleText(eleOption);
			stepstatus = true;
		} catch (Exception e) {
			stepstatus = false;
		}
		return stepstatus;
	}
	
	public static boolean SelectOptionByValue(WebElement ele, String eleOption) 
	{
		boolean stepstatus = false;
		try 
		{
			Select s1 = new Select(ele);
			s1.selectByValue(eleOption);
			stepstatus = true;
		} catch (Exception e) {
			stepstatus = false;
		}
		return stepstatus;
	}

	public static boolean setOptionInRadioGroup(List<WebElement> RadioGroupElements, String StrOption) 
	{
		boolean stepstatus = false;
		try 
		{
			for(WebElement ele:RadioGroupElements)
			{
				if(ele.getAttribute("value").equalsIgnoreCase(StrOption))
				{
					ele.click();
				}
			}
			stepstatus = true;
		} catch (Exception e) 
		{
			stepstatus = false;
		}
		return stepstatus;
	}
	
	

	public static String getLinkText(WebElement ele) 
	{
		String value = "";
		try 
		{
			if(exists(ele))
			{
				value=ele.getText();
				//System.out.println(value);
			}
		} catch (Exception e) 
		{
			value = "";
		}
		return value;
		
	}
	
	
	
	public static String getAttributeValue(WebElement ele,String AttributeName) 
	{
		String value = "";
		try 
		{
			if(exists(ele))
			{
				value=ele.getAttribute(AttributeName);
			}
		} catch (Exception e) 
		{
			value = "";
		}
		return value;
	}
	
	public  static void waitForPageToLoad(WebDriver driver) 
	{
		String pageLoadStatus;
		do 
		{
	    	JavascriptExecutor js = (JavascriptExecutor)driver;
	        pageLoadStatus = (String)js.executeScript("return document.readyState");
	    } while (!pageLoadStatus.equals("complete") );
	}
	
	public static boolean verifyTextPresent(WebElement ele, String value)
	{
		return BaseClass.driver.getPageSource().contains(value);
	}
	
	
	public static boolean verifyTextPresent(String value)
	{
		return BaseClass.driver.getPageSource().contains(value);
	}
	
	/*public static boolean setText(WebElement ele, String StrValue) 
	{	boolean stepstatus;
		try
		{
			ele.click();
			ele.clear();
			ele.sendKeys(StrValue);
			stepstatus = true;
		} catch (Exception e) 
		{
			stepstatus = false;
		}
		return stepstatus;
	}*/
	
	public static boolean exists(WebElement ele) 
	{
		boolean stepstatus;
		try 
		{
			stepstatus = ele.isDisplayed();
		} catch (Exception e) 
		{
			stepstatus = false;
		}
		return stepstatus;
	}
	
	public static boolean isEnabled(WebElement ele) 
	{
		boolean stepstatus;
		try 
		{
			stepstatus = ele.isEnabled();
		} catch (Exception e) 
		{
			stepstatus = false;
		}
		return stepstatus;
	}
	
	public static boolean isSelected(WebElement ele) 
	{
		boolean stepstatus;
		try 
		{
			stepstatus = ele.isSelected();
		} catch (Exception e) 
		{
			stepstatus = false;
		}
		return stepstatus;
	}
	public static boolean mouseHover(WebElement ele, WebDriver driver) {
		boolean stepstatus;
		try 
		{
			Actions a1 = new Actions(driver);
			a1.moveToElement(ele);
			a1.build().perform();
			stepstatus = true;
		} catch (Exception e) 
		{
			stepstatus = false;
		}
		return stepstatus;
	}

	public static boolean rightClick(WebElement ele, WebDriver driver) {
		boolean stepstatus;
		try {
			Actions a1 = new Actions(driver);
			a1.contextClick(ele);
			a1.build().perform();
			stepstatus = true;
		} catch (Exception e) {
			stepstatus = false;
		}
		return stepstatus;
	}

	public static boolean doubleClick(WebElement ele, WebDriver driver) {
		boolean stepstatus;
		try {
			Actions a1 = new Actions(driver);
			a1.doubleClick(ele);
			a1.build().perform();
			stepstatus = true;
		} catch (Exception e) {
			stepstatus = false;
		}
		return stepstatus;
	}

	public static boolean dragAndDrop(WebElement drag, WebElement drop, WebDriver driver) {
		boolean stepstatus;
		try {
			Actions a1 = new Actions(driver);
			a1.dragAndDrop(drag, drop);
			a1.build().perform();
			stepstatus = true;
		} catch (Exception e) {
			stepstatus = false;
		}
		return stepstatus;
	}

	public static boolean JsclickElement(WebElement ele, WebDriver driver) {
		boolean stepstatus;
		try {

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", ele);
			stepstatus = true;
		} catch (Exception e) {
			stepstatus = false;
		}
		return stepstatus;
	}

	public static boolean JssetText(WebElement ele, String StrValue, WebDriver driver) {
		boolean stepstatus;
		try {

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].value='" + StrValue + ";", ele);
			stepstatus = true;
		} catch (Exception e) {
			stepstatus = false;
		}
		return stepstatus;
	}

	public static boolean JsScrollToWebElement(WebElement ele, WebDriver driver) {
		boolean stepstatus;
		try {

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", ele);
			stepstatus = true;
		} catch (Exception e) {
			stepstatus = false;
		}
		return stepstatus;
	}

	public static boolean dismissAlert(WebElement ele, WebDriver driver) {
		boolean stepstatus;
		try {
			Alert a1 = driver.switchTo().alert();
			a1.dismiss();
			stepstatus = true;
		} catch (Exception e) {
			stepstatus = false;
		}
		return stepstatus;
	}

	public static boolean alertExist(WebElement ele, WebDriver driver) {
		boolean stepstatus;
		try {
			driver.switchTo().alert();
			stepstatus = true;
		} catch (Exception e) {
			stepstatus = false;
		}
		return stepstatus;
	}

	public static String alertGetText(WebElement ele, WebDriver driver) {
		String StrValue = "";
		try {
			Alert a1 = driver.switchTo().alert();
			StrValue = a1.getText();
		} catch (Exception e) {

		}
		return StrValue;
	}

	public static boolean isWindowExists(String URL, WebDriver driver) {
		boolean stepstatus = false;
		try {
			Set<String> allhandles = driver.getWindowHandles();
			for (String handle : allhandles) {
				driver.switchTo().window(handle);
				String CurrentURL = driver.getCurrentUrl();
				System.out.println(CurrentURL);
				if (CurrentURL.contains(URL)) {
					stepstatus = true;
					break;
				}
			}
		} catch (Exception e) {
			stepstatus = false;
		}
		return stepstatus;
	}

	public static WebDriver SwitchtoWindow(String URL, WebDriver driver) {
		try {
			Set<String> allhandles = driver.getWindowHandles();
			for (String handle : allhandles) {
				driver.switchTo().window(handle);
				String CurrentURL = driver.getCurrentUrl();
				if (CurrentURL.contains(URL)) {
					break;
				}
			}
		} catch (Exception e) {

		}
		return driver;
	}

	public static WebDriver SwitchtoFrame(WebElement FrameRef, WebDriver driver) {
		try {
			driver.switchTo().frame(FrameRef);
		} catch (Exception e) {

		}
		return driver;
	}

	public static WebDriver SwitchtoParentDocument(String FrameRef, WebDriver driver) {
		try {
			driver.switchTo().defaultContent();
		} catch (Exception e) {

		}
		return driver;
	}

	public static WebDriver closeWindow(String URL, WebDriver driver) {
		try {
			Set<String> allhandles = driver.getWindowHandles();
			for (String handle : allhandles) {
				driver.switchTo().window(handle);
				String CurrentURL = driver.getCurrentUrl();
				if (CurrentURL.contains(URL)) {
					driver.close();
					break;
				}
			}
		} catch (Exception e) {

		}
		return driver;
	}

	public static boolean RobotKeysFileUpload(String Filepath) {
		boolean stepstatus;
		try {
			wait(2);
			StringSelection selection = new StringSelection(Filepath);
			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			clipboard.setContents(selection, selection);

			Robot robo = new Robot();
			robo.keyPress(KeyEvent.VK_ALT);
			robo.keyPress(KeyEvent.VK_O);
			robo.keyRelease(KeyEvent.VK_O);
			robo.keyRelease(KeyEvent.VK_ALT);
			
			/*robo.keyPress(KeyEvent.VK_TAB);
			robo.keyRelease(KeyEvent.VK_TAB);*/
			robo.keyPress(KeyEvent.VK_CONTROL);
			robo.keyPress(KeyEvent.VK_V);
			robo.keyRelease(KeyEvent.VK_V);
			robo.keyRelease(KeyEvent.VK_CONTROL);

			wait(2);
			robo.keyPress(KeyEvent.VK_ENTER);
			robo.keyRelease(KeyEvent.VK_ENTER);
			robo.keyPress(KeyEvent.VK_ENTER);
			robo.keyRelease(KeyEvent.VK_ENTER);
			wait(2);
			stepstatus = true;
		} catch (Exception e) {
			stepstatus = false;
		}
		System.out.println("stepstatus :"+stepstatus);
		return stepstatus;
	}
	
	public static boolean ImageComparision(String Filepath, String Filepath1){
		boolean stepstatus;
		try {
			Screen screen=new Screen();
			Pattern pa1=new Pattern(Filepath);
			String img=screen.capture().save(Filepath1,"image");
			Finder f1=new Finder(screen.capture().getImage());
			f1.find(pa1);
			if(f1.hasNext()){
				        Match m=f1.next();
				        System.out.println("Match found with "+(m.getScore())+"100"+"%");
				        f1.destroy();
				        stepstatus = true;
				    }
				    else{
				        System.out.println("No Match Found");
					stepstatus = false;
				    }
		} catch (Exception e) {
			stepstatus = false;
				}
		return stepstatus;
		}
	
	public static int NoOfEntriesCount(String TableXpath, String PaginationNextIcon, String NextArrow){
		try{
			int NoOfEntries = BaseClass.driver.findElements(By.xpath(TableXpath)).size();
			while(!BaseClass.driver.findElements(By.xpath(PaginationNextIcon)).isEmpty()){
				BaseClass.driver.findElement(By.xpath(NextArrow)).click();
				wait(5);
				NoOfEntries = NoOfEntries + BaseClass.driver.findElements(By.xpath(TableXpath)).size();
			}
			
			System.out.println(NoOfEntries);
			return NoOfEntries;
		} catch (Exception e)
		{
		}
		return 0;
	}
	
	public static File getLatestFilefromDir(){
		File dir = new File("C:\\Users\\shravanim\\Downloads");
	    File[] files = dir.listFiles();
	    if (files == null || files.length == 0) {
	        return null;
	    }
	    File lastModifiedFile = files[0];
	    for (int i = 1; i < files.length; i++) {
	       if (lastModifiedFile.lastModified() < files[i].lastModified()) {
	           lastModifiedFile = files[i];
	       }
	    }
	    System.out.println("Latest File is " + lastModifiedFile);
	    return lastModifiedFile;
	}
	
	public static void removeDownloadFiles(){
		File file = new File("C:\\Users\\shravanim\\Downloads");
		String[] myFiles;
        if (file.isDirectory()) {
            myFiles = file.list();
            for (int i = 0; i < myFiles.length; i++) {
                File myFile = new File(file, myFiles[i]);
                System.out.println(myFile);
               if (!myFile.isDirectory()) {
                    myFile.delete();
                }
            }
        }
	}
	
	
	public static boolean getLatestFileName(String fileName) {
		boolean stepstatus = false;
		try{
		    File dir = new File("C:\\Users\\shravanim\\Downloads");
		    File[] dir_contents = dir.listFiles();
		    for (int i = 0; i < dir_contents.length; i++) {
		    	String DownloadFileName1 = dir_contents[i].getName();
		    	System.out.println(DownloadFileName1);
		    	String DownloadFileName = DownloadFileName1.replace(".crdownload", "");
		    	if(DownloadFileName.contains(fileName)){
		    	//if(DownloadFileName.equals(fileName)){
		    		stepstatus = true;
		    	}else{
	            	stepstatus = false;	
	            }
		    	/*if(dir_contents[i].getName().equals(fileName)){
		        	 stepstatus = true;
		            }else{
		            	stepstatus = false;	
		            }*/   
		    }
		}catch (Exception e) {
			stepstatus = false;
		}
		return stepstatus;
	}
	
	public static boolean getLatestFileExtension(String Ext){
		boolean stepstatus = false;
		try{
			 File dir = new File("C:\\Users\\shravanim\\Downloads");
			 File[] dir_contents = dir.listFiles();
			 
			 if (dir_contents == null || dir_contents.length == 0) {
				 stepstatus = false;
			    }
			    
			    for (int i = 0; i < dir_contents.length; i++) {
			    	if(dir_contents[i].getName().contains(Ext)) {
			    		stepstatus=true;
			    	}
			    }
		}catch (Exception e) {
			stepstatus = false;
		}
		return stepstatus;
	}
	
	
	public static int ExcelRowCount(String SheetName, int HeaderCount) throws Exception{
		//String FilePath = WebLibrary.getLatestFilefromDir() + ".xls";
		File f1 = getLatestFilefromDir();
		FileInputStream fis = new FileInputStream(f1);
		HSSFWorkbook wb1 = new HSSFWorkbook(fis);
		HSSFSheet ws1 = wb1.getSheet(SheetName);
		int rowcount = ws1.getLastRowNum()+1;
		rowcount = (rowcount > HeaderCount) ? rowcount - HeaderCount : 0; 
		System.out.println(rowcount);
		return rowcount;
		
		
	}
	
	
	public static boolean wait(int timeInSec) {
		boolean stepStatus;
		try {
			Thread.sleep(timeInSec * 1000);
			stepStatus = true;
		} catch (Exception e) {
			stepStatus = false;
		}
		return stepStatus;
	}

	public static boolean dynamicWait(By by, WebDriver driver, int waittimeinsec) {
		boolean status = false;
		int counter = 0;
		while (counter <= waittimeinsec) {
			try {
				driver.findElement(by);
				status = true;
				break;
			} catch (Exception e) {
				try {
					Thread.sleep(1000);
				} catch (Exception e1) {

				}
				counter = counter + 1;
			}
		}
		if (counter > waittimeinsec) {
			status = false;
		}
		return status;
	}

	public static WebDriver SetImplicitWait(int TimeInSec, WebDriver driver) {
		try {
			driver.manage().timeouts().implicitlyWait(TimeInSec, TimeUnit.SECONDS);
		} catch (Exception e) {
		}
		return driver;
	}
	
	public static WebDriver setExplicitWait(WebElement ele, WebDriver driver, int TimeInSec){
		try{
	        WebDriverWait wait = new WebDriverWait(driver, TimeInSec);
	        wait.until(ExpectedConditions.visibilityOf(ele));
	        wait.until(ExpectedConditions.elementToBeClickable(ele));
	        }catch (Exception e) {
		}
		return null;
	}
	

	
	/*public String waitForElement(String item) {
		try{
			WebDriverWait wait = new WebDriverWait(driver,30);
		    WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id(item)));
		}catch (Exception e) {
		}
		return item;
	}
	
	public static WebDriver waitForElement(WebElement ele){
		try{
			
		}catch (Exception e) {
		}
		return driver;
	}*/
	
	
	public static void quitdriver()
	{
		BaseClass.driver.quit();
	}
	

}
