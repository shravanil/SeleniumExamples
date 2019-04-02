package TestScripts;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.sikuli.hotkey.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import ApplicationPages.AdminHomePage;
import ApplicationPages.HomePage;
import ApplicationPages.LoginPage;
import ApplicationPages.ReportsPage;
import ApplicationPages.UsersPage;
import FrameworkLibrary.BaseClass;
import FrameworkLibrary.DataLibrary;
import FrameworkLibrary.ReportLibrary;
import FrameworkLibrary.WebLibrary;

public class Reports extends BaseClass{

	boolean stepstatus;
	@Test(testName="All Actions in Metrics Report")
	public void AllActionInMetricsReport()
	{
		LoginPage loginpage = new LoginPage(driver);
		HomePage homepage = new HomePage(driver);
		ReportsPage reports = new ReportsPage(driver);
		loginpage.setUsername(DataLibrary.getdata("Username"));
		loginpage.setPassword(DataLibrary.getdata("Password"));
		loginpage.clickonLogin();
		homepage.clickonReportsMenu();
		homepage.clickonMetricsReport();
		reports.setTemplateName();
		String Template = reports.getTemplateName();
		String SelectedTemplate = Template.substring(0,Template.indexOf("("));
		reports.clickonSearchBtn();
		int recordsCount = driver.findElements(By.xpath("//table/tbody/tr/td[4]")).size();
		for(int i=1; i<=recordsCount; i++){
			String TemplateName = driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[4]")).getText();
			if(TemplateName.equalsIgnoreCase(SelectedTemplate)){
				ReportLibrary.test.log(LogStatus.PASS, "Metrics Report searched succesfully using Template Name"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
			}else{
				ReportLibrary.test.log(LogStatus.FAIL, "Metrics Report search failed using Template Name"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
			}
		}
		reports.clickonEditIcon();
		WebLibrary.setExplicitWait(reports.RequestDetailsPopup, driver, 30);
		if(WebLibrary.exists(reports.RequestDetailsPopup)){
			ReportLibrary.test.log(LogStatus.PASS, "Request details viewed successfully"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Failed to view Request details"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		reports.clickonCloseIcon();		
		homepage.clickonReportsMenu();
		homepage.clickonMetricsReport();
		//To Download Current page records in all available formats
		WebLibrary.removeDownloadFiles();
		reports.SelectFormat("csv");
		reports.clickonDownloadCurrentPageIcon();
		WebLibrary.wait(5);
		stepstatus = WebLibrary.getLatestFileExtension(".csv");
		if(stepstatus==true){
			ReportLibrary.test.log(LogStatus.PASS, "Metrics Report > Downloaded current page records successfully in CSV format" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Metrics Report > Downloaded current page records failed in CSV format"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		
		WebLibrary.removeDownloadFiles();
		reports.SelectFormat("xls");
		reports.clickonDownloadCurrentPageIcon();
		WebLibrary.wait(5);
		stepstatus = WebLibrary.getLatestFileExtension(".xls");
		if(stepstatus==true){
			ReportLibrary.test.log(LogStatus.PASS, "Metrics Report > Downloaded current page records successfully in XLS format" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Metrics Report > Downloaded current page records failed in XLS format"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		
		WebLibrary.removeDownloadFiles();
		reports.SelectFormat("ods");
		reports.clickonDownloadCurrentPageIcon();
		WebLibrary.wait(5);
		stepstatus = WebLibrary.getLatestFileExtension(".ods");
		if(stepstatus==true){
			ReportLibrary.test.log(LogStatus.PASS, "Metrics Report > Downloaded current page records successfully in ODS format" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Metrics Report > Downloaded current page records failed in ODS format"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		
		WebLibrary.removeDownloadFiles();
		reports.SelectFormat("pdf");
		reports.clickonDownloadCurrentPageIcon();
		WebLibrary.wait(5);
		stepstatus = WebLibrary.getLatestFileExtension(".pdf");
		if(stepstatus==true){
			ReportLibrary.test.log(LogStatus.PASS, "Metrics Report > Downloaded current page records successfully in PDF format" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Metrics Report > Downloaded current page records failed in PDF format"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		
		//To Download All records in all available formats
		WebLibrary.removeDownloadFiles();
		reports.SelectFormat("csv");
		reports.clickonDownloadAllIcon();
		WebLibrary.wait(5);
		stepstatus = WebLibrary.getLatestFileExtension(".csv");
		if(stepstatus==true){
			ReportLibrary.test.log(LogStatus.PASS, "Metrics Report > Downloaded All records successfully in CSV format" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Metrics Report > Downloaded All records failed in CSV format"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		
		WebLibrary.removeDownloadFiles();
		reports.SelectFormat("xls");
		reports.clickonDownloadAllIcon();
		WebLibrary.wait(5);
		stepstatus = WebLibrary.getLatestFileExtension(".xls");
		if(stepstatus==true){
			ReportLibrary.test.log(LogStatus.PASS, "Metrics Report > Downloaded All records successfully in XLS format" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Metrics Report > Downloaded All records failed in XLS format"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		
		WebLibrary.removeDownloadFiles();
		reports.SelectFormat("ods");
		reports.clickonDownloadAllIcon();
		WebLibrary.wait(5);
		stepstatus = WebLibrary.getLatestFileExtension(".ods");
		if(stepstatus==true){
			ReportLibrary.test.log(LogStatus.PASS, "Metrics Report > Downloaded All records successfully in ODS format" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Metrics Report > Downloaded All records failed in ODS format"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		
		WebLibrary.removeDownloadFiles();
		reports.SelectFormat("pdf");
		reports.clickonDownloadAllIcon();
		WebLibrary.wait(5);
		stepstatus = WebLibrary.getLatestFileExtension(".pdf");
		if(stepstatus==true){
			ReportLibrary.test.log(LogStatus.PASS, "Metrics Report > Downloaded All records successfully in PDF format" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Metrics Report > Downloaded All records failed in PDF format"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
	}
	
	@Test(testName="All Actions in Detailed Report")
	public void AllActionInDetailedReport()
	{
		LoginPage loginpage = new LoginPage(driver);
		HomePage homepage = new HomePage(driver);
		ReportsPage reports = new ReportsPage(driver);
		loginpage.setUsername(DataLibrary.getdata("Username"));
		loginpage.setPassword(DataLibrary.getdata("Password"));
		loginpage.clickonLogin();
		homepage.clickonReportsMenu();
		homepage.clickonDetailedReport();
		reports.setTemplateName();
		String Template = reports.getTemplateName();
		String SelectedTemplate = Template.substring(0,Template.indexOf("("));
		reports.clickonSearchBtn();
		int recordsCount = driver.findElements(By.xpath("//table/tbody/tr/td[4]")).size();
		for(int i=1; i<=recordsCount; i++){
			String TemplateName = driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[3]")).getText();
			if(TemplateName.equalsIgnoreCase(SelectedTemplate)){
				ReportLibrary.test.log(LogStatus.PASS, "Detailed Report searched succesfully using Template Name"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
			}else{
				ReportLibrary.test.log(LogStatus.FAIL, "Detailed Report search failed using Template Name"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
			}
		}
		homepage.clickonReportsMenu();
		homepage.clickonDetailedReport();
		reports.setStatus(DataLibrary.getdata("Status"));
		reports.clickonSearchBtn();
		int StatusSearchRecords = driver.findElements(By.xpath("//table/tbody/tr/td[4]")).size();
		for(int i=1; i<=StatusSearchRecords; i++){
			String Status = driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[4]")).getText();
			if(Status.equalsIgnoreCase(DataLibrary.getdata("Status"))){
				ReportLibrary.test.log(LogStatus.PASS, "Detailed Report searched and validated succesfully using Status"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
			}else{
				ReportLibrary.test.log(LogStatus.FAIL, "Detailed Report search failed using Status"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
			}
		}
		String RequestId = driver.findElement(By.xpath("//table/tbody/tr/td[1]")).getText();
		reports.setRequestId(RequestId);
		reports.clickonSearchBtn();
		int RequestIdRecords = driver.findElements(By.xpath("//table/tbody/tr/td[4]")).size();
		for(int i=1; i<=RequestIdRecords; i++){
			String GetRequestId = driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[1]")).getText();
			if(GetRequestId.equalsIgnoreCase(RequestId)){
				ReportLibrary.test.log(LogStatus.PASS, "Detailed Report searched succesfully using RequestId"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
			}else{
				ReportLibrary.test.log(LogStatus.FAIL, "Detailed Report search failed using RequestId"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
			}
		}
		homepage.clickonReportsMenu();
		homepage.clickonDetailedReport();
		//To Download Current page records in all available formats
		WebLibrary.removeDownloadFiles();
		reports.SelectFormat("csv");
		reports.clickonDetailedReportDownloadCurrentPageIcon();
		WebLibrary.wait(5);
		stepstatus = WebLibrary.getLatestFileExtension(".csv");
		if(stepstatus==true){
			ReportLibrary.test.log(LogStatus.PASS, "Detailed Report > Downloaded current page records successfully in CSV format" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Detailed Report > Downloaded current page records failed in CSV format"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		
		WebLibrary.removeDownloadFiles();
		reports.SelectFormat("xls");
		reports.clickonDetailedReportDownloadCurrentPageIcon();
		WebLibrary.wait(5);
		stepstatus = WebLibrary.getLatestFileExtension(".xls");
		if(stepstatus==true){
			ReportLibrary.test.log(LogStatus.PASS, "Detailed Report > Downloaded current page records successfully in XLS format" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Detailed Report > Downloaded current page records failed in XLS format"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		
		WebLibrary.removeDownloadFiles();
		reports.SelectFormat("ods");
		reports.clickonDetailedReportDownloadCurrentPageIcon();
		WebLibrary.wait(5);
		stepstatus = WebLibrary.getLatestFileExtension(".ods");
		if(stepstatus==true){
			ReportLibrary.test.log(LogStatus.PASS, "Detailed Report > Downloaded current page records successfully in ODS format" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Detailed Report > Downloaded current page records failed in ODS format"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		
		WebLibrary.removeDownloadFiles();
		reports.SelectFormat("pdf");
		reports.clickonDetailedReportDownloadCurrentPageIcon();
		WebLibrary.wait(5);
		stepstatus = WebLibrary.getLatestFileExtension(".pdf");
		if(stepstatus==true){
			ReportLibrary.test.log(LogStatus.PASS, "Detailed Report > Downloaded current page records successfully in PDF format" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Detailed Report > Downloaded current page records failed in PDF format"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		
		//To Download All records in all available formats
		WebLibrary.removeDownloadFiles();
		reports.SelectFormat("csv");
		reports.clickonDetailedReportDownloadAllIcon();
		WebLibrary.wait(5);
		stepstatus = WebLibrary.getLatestFileExtension(".csv");
		if(stepstatus==true){
			ReportLibrary.test.log(LogStatus.PASS, "Detailed Report > Downloaded All records successfully in CSV format" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Detailed Report > Downloaded All records failed in CSV format"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		
		WebLibrary.removeDownloadFiles();
		reports.SelectFormat("xls");
		reports.clickonDetailedReportDownloadAllIcon();
		WebLibrary.wait(5);
		stepstatus = WebLibrary.getLatestFileExtension(".xls");
		if(stepstatus==true){
			ReportLibrary.test.log(LogStatus.PASS, "Detailed Report > Downloaded All records successfully in XLS format" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Detailed Report > Downloaded All records failed in XLS format"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		
		WebLibrary.removeDownloadFiles();
		reports.SelectFormat("ods");
		reports.clickonDetailedReportDownloadAllIcon();
		WebLibrary.wait(5);
		stepstatus = WebLibrary.getLatestFileExtension(".ods");
		if(stepstatus==true){
			ReportLibrary.test.log(LogStatus.PASS, "Detailed Report > Downloaded All records successfully in ODS format" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Detailed Report > Downloaded All records failed in ODS format"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		
		WebLibrary.removeDownloadFiles();
		reports.SelectFormat("pdf");
		reports.clickonDetailedReportDownloadAllIcon();
		WebLibrary.wait(5);
		stepstatus = WebLibrary.getLatestFileExtension(".pdf");
		if(stepstatus==true){
			ReportLibrary.test.log(LogStatus.PASS, "Detailed Report > Downloaded All records successfully in PDF format" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Detailed Report > Downloaded All records failed in PDF format"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
	}
	
	@Test(testName="All Actions in Signer Report")
	public void AllActionInSignerReport()
	{
		LoginPage loginpage = new LoginPage(driver);
		HomePage homepage = new HomePage(driver);
		ReportsPage reports = new ReportsPage(driver);
		loginpage.setUsername(DataLibrary.getdata("Username"));
		loginpage.setPassword(DataLibrary.getdata("Password"));
		loginpage.clickonLogin();
		homepage.clickonReportsMenu();
		homepage.clickonSignerReport();
		reports.selectSigner(DataLibrary.getdata("Signer"));
		reports.selectSignerStatus(DataLibrary.getdata("SignerStatus"));
		reports.selectRequestStatus(DataLibrary.getdata("RequestStatus1"));
		reports.selectRequestStatus(DataLibrary.getdata("RequestStatus2"));
		reports.clickonSearchBtn();
		String RequestStatus = driver.findElement(By.xpath("//table/tbody/tr/td[3]")).getText();
		if(RequestStatus.trim().equalsIgnoreCase(DataLibrary.getdata("RequestStatus1")) || RequestStatus.trim().equalsIgnoreCase(DataLibrary.getdata("RequestStatus2"))){
			ReportLibrary.test.log(LogStatus.PASS, "Signer Report searched succesfully"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Signer Report search failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		//To Download Current page records in all available formats
		WebLibrary.removeDownloadFiles();
		reports.SelectFormat("csv");
		reports.clickonDetailedReportDownloadCurrentPageIcon();
		WebLibrary.wait(5);
		stepstatus = WebLibrary.getLatestFileExtension(".csv");
		if(stepstatus==true){
			ReportLibrary.test.log(LogStatus.PASS, "Signer Report > Downloaded current page records successfully in CSV format" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Signer Report > Downloaded current page records failed in CSV format"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		
		WebLibrary.removeDownloadFiles();
		reports.SelectFormat("xls");
		reports.clickonDetailedReportDownloadCurrentPageIcon();
		WebLibrary.wait(5);
		stepstatus = WebLibrary.getLatestFileExtension(".xls");
		if(stepstatus==true){
			ReportLibrary.test.log(LogStatus.PASS, "Signer Report > Downloaded current page records successfully in XLS format" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Signer Report > Downloaded current page records failed in XLS format"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		
		WebLibrary.removeDownloadFiles();
		reports.SelectFormat("ods");
		reports.clickonDetailedReportDownloadCurrentPageIcon();
		WebLibrary.wait(5);
		stepstatus = WebLibrary.getLatestFileExtension(".ods");
		if(stepstatus==true){
			ReportLibrary.test.log(LogStatus.PASS, "Signer Report > Downloaded current page records successfully in ODS format" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Signer Report > Downloaded current page records failed in ODS format"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		
		WebLibrary.removeDownloadFiles();
		reports.SelectFormat("pdf");
		reports.clickonDetailedReportDownloadCurrentPageIcon();
		WebLibrary.wait(5);
		stepstatus = WebLibrary.getLatestFileExtension(".pdf");
		if(stepstatus==true){
			ReportLibrary.test.log(LogStatus.PASS, "Signer Report > Downloaded current page records successfully in PDF format" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Signer Report > Downloaded current page records failed in PDF format"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		
		//To Download All records in all available formats
		WebLibrary.removeDownloadFiles();
		reports.SelectFormat("csv");
		reports.clickonDetailedReportDownloadAllIcon();
		WebLibrary.wait(5);
		stepstatus = WebLibrary.getLatestFileExtension(".csv");
		if(stepstatus==true){
			ReportLibrary.test.log(LogStatus.PASS, "Signer Report > Downloaded All records successfully in CSV format" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Signer Report > Downloaded All records failed in CSV format"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		
		WebLibrary.removeDownloadFiles();
		reports.SelectFormat("xls");
		reports.clickonDetailedReportDownloadAllIcon();
		WebLibrary.wait(5);
		stepstatus = WebLibrary.getLatestFileExtension(".xls");
		if(stepstatus==true){
			ReportLibrary.test.log(LogStatus.PASS, "Signer Report > Downloaded All records successfully in XLS format" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Signer Report > Downloaded All records failed in XLS format"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		
		WebLibrary.removeDownloadFiles();
		reports.SelectFormat("ods");
		reports.clickonDetailedReportDownloadAllIcon();
		WebLibrary.wait(5);
		stepstatus = WebLibrary.getLatestFileExtension(".ods");
		if(stepstatus==true){
			ReportLibrary.test.log(LogStatus.PASS, "Signer Report > Downloaded All records successfully in ODS format" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Signer Report > Downloaded All records failed in ODS format"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		
		WebLibrary.removeDownloadFiles();
		reports.SelectFormat("pdf");
		reports.clickonDetailedReportDownloadAllIcon();
		WebLibrary.wait(5);
		stepstatus = WebLibrary.getLatestFileExtension(".pdf");
		if(stepstatus==true){
			ReportLibrary.test.log(LogStatus.PASS, "Signer Report > Downloaded All records successfully in PDF format" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Signer Report > Downloaded All records failed in PDF format"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}		
	}
	
	@Test(testName="All Actions in CustomField Report")
	public void AllActionInCustomFieldReport()
	{
		try{
		LoginPage loginpage = new LoginPage(driver);
		HomePage homepage = new HomePage(driver);
		ReportsPage reports = new ReportsPage(driver);
		loginpage.setUsername(DataLibrary.getdata("Username"));
		loginpage.setPassword(DataLibrary.getdata("Password"));
		loginpage.clickonLogin();
		homepage.clickonReportsMenu();
		homepage.clickonCustomFieldReport();
		reports.clickonSearchBtn();
		reports.selectFirstRequest();
		Robot robo = new Robot();
		robo.keyPress(KeyEvent.VK_CONTROL);
		robo.keyPress(KeyEvent.VK_HOME);
		robo.keyRelease(KeyEvent.VK_HOME);
		robo.keyRelease(KeyEvent.VK_CONTROL);
		//robo.keyPress(KeyEvent.VK_CONTROL);
		//reports.selectFirstRequest();
		//reports.selectFirstRequest();
		String Request = reports.getRequestName();
		String SelectedRequest = Request.substring(0,Request.indexOf("("));
		reports.clickonSearchBtn();
		int recordsCount = driver.findElements(By.xpath("//table/tbody/tr/td[4]")).size();
		for(int i=1; i<=recordsCount; i++){
			String RequestName = driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[3]")).getText();
			if(RequestName.equalsIgnoreCase(SelectedRequest)){
				ReportLibrary.test.log(LogStatus.PASS, "Custom Field Report searched succesfully"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
			}else{
				ReportLibrary.test.log(LogStatus.FAIL, "Custom Field Report search failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
			}
		}
		reports.clickonViewRequestDetails();
		WebLibrary.setExplicitWait(reports.RequestDetailsPopup, driver, 30);
		if(WebLibrary.exists(reports.RequestDetailsPopup)){
			ReportLibrary.test.log(LogStatus.PASS, "Request details viewed successfully"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Failed to view Request details"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		reports.clickonCloseIcon();
		homepage.clickonReportsMenu();
		homepage.clickonCustomFieldReport();
		WebLibrary.removeDownloadFiles();
		reports.clickonDownloadReport();
		WebLibrary.wait(5);
		stepstatus = WebLibrary.getLatestFileName("CustomFields Report.xls");
		if(stepstatus==true){
			ReportLibrary.test.log(LogStatus.PASS, "Custom Fields Report downloaded successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Custom Fields Report downloaded failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		}catch (Exception e) 
		{
			WebLibrary.wait(10);
			ReportLibrary.test.log(LogStatus.FAIL, "Failed to execute Need to Sign actions"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		
	}
}