package TestScripts;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import ApplicationPages.ChangePasswordPage;
import ApplicationPages.CompanyDetailsPage;
import ApplicationPages.CustomizePage;
import ApplicationPages.HomePage;
import ApplicationPages.LoginPage;
import ApplicationPages.MyPreferencesHomePage;
import ApplicationPages.PersonalInformationPage;
import ApplicationPages.SACompanyPage;
import ApplicationPages.SAUserPage;
import FrameworkLibrary.BaseClass;
import FrameworkLibrary.DataLibrary;
import FrameworkLibrary.ReportLibrary;
import FrameworkLibrary.WebLibrary;

public class SuperAdmin extends BaseClass{

	boolean stepstatus;
	@Test(testName="All Actions in Metrics Report")
	public void AllActionsOfCompanyModule() throws Exception
	{
		LoginPage loginpage = new LoginPage(driver);
		HomePage homepage = new HomePage(driver);
		SACompanyPage company = new SACompanyPage(driver);
		CompanyDetailsPage companydetails = new CompanyDetailsPage(driver);
		loginpage.setUsername(DataLibrary.getdata("SAUsername"));
		loginpage.setPassword(DataLibrary.getdata("SAPassword"));
		loginpage.clickonLogin();
		homepage.clickonCompanyMenu();
		homepage.clickonCreateCompanyMenu();
		WebLibrary.setExplicitWait(company.Company, driver, 30);
		company.setCompany(DataLibrary.getdata("Company"));
		company.setAddress(DataLibrary.getdata("Address"));
		company.setCity(DataLibrary.getdata("City"));
		company.setState(DataLibrary.getdata("State"));
		company.setCountry(DataLibrary.getdata("Country"));
		company.clickonNextBtn();
		WebLibrary.setExplicitWait(company.FinishBtn, driver, 30);
		company.clickonFinishBtn();
		WebLibrary.setExplicitWait(company.ClickHereBtn, driver, 30);
		boolean CreateCompany = WebLibrary.verifyTextPresent("Company Created Successfully.");
		if(CreateCompany == true){
			ReportLibrary.test.log(LogStatus.PASS, "Company created successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Company creation failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		company.clickonCloseIcon();
		WebLibrary.setExplicitWait(company.Status, driver, 30);
		company.setCompanySearch(DataLibrary.getdata("Company"));
		company.selectDraftStatus();
		company.setSearchCountry(DataLibrary.getdata("Country"));
		company.clickonSearchBtn();
		driver.findElement(By.xpath("//table/tbody/tr/td[2]/div[contains(text(),'"+DataLibrary.getdata("Company")+"')]")).click();
		companydetails.clickonUpdateBtn();
		companydetails.ValidDataValidation();
		WebLibrary.wait(2);
		companydetails.clickonDeleteBtn();
		WebLibrary.setExplicitWait(companydetails.ConfirmOkBtn, driver, 30);
		companydetails.clickonConfirmOkBtn();
		WebLibrary.wait(3);
		boolean DeleteCompany = WebLibrary.verifyTextPresent("Company deleted successfully");
		if(DeleteCompany == true){
			ReportLibrary.test.log(LogStatus.PASS, "Company deleted successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Company deletion failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		WebLibrary.setExplicitWait(homepage.CompanyMenu, driver, 30);
		homepage.clickonCompanyMenu();
		homepage.clickonCreateCompanyMenu();
		WebLibrary.setExplicitWait(company.Company, driver, 30);
		company.setCompany(DataLibrary.getdata("Company1"));
		company.setAddress(DataLibrary.getdata("Address"));
		company.setCity(DataLibrary.getdata("City"));
		company.setState(DataLibrary.getdata("State"));
		company.setCountry(DataLibrary.getdata("Country"));
		company.clickonNextBtn();
		WebLibrary.setExplicitWait(company.FinishBtn, driver, 30);
		company.clickonFinishBtn();
		WebLibrary.setExplicitWait(company.ClickHereBtn, driver, 30);
		boolean CreateCompany1 = WebLibrary.verifyTextPresent("Company Created Successfully.");
		if(CreateCompany1 == true){
			ReportLibrary.test.log(LogStatus.PASS, "Company created successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Company creation failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		company.clickonCloseIcon();
		WebLibrary.setExplicitWait(homepage.CompanyMenu, driver, 30);
		homepage.clickonCompanyMenu();
		homepage.clickonCreateAdminMenu();
		WebLibrary.setExplicitWait(company.User, driver, 30);
		company.setUser(DataLibrary.getdata("User"));
		driver.switchTo().activeElement().sendKeys(Keys.ENTER);
		WebLibrary.setExplicitWait(company.CreateAdminCompany, driver, 60);
		company.setAdminCompany();
		driver.switchTo().activeElement().sendKeys(DataLibrary.getdata("Company1"));
		driver.switchTo().activeElement().sendKeys(Keys.ENTER);
		WebLibrary.wait(2);
		WebLibrary.setExplicitWait(company.NextBtn, driver, 30);
		company.clickonNextBtn();
		WebLibrary.setExplicitWait(company.FinishBtn, driver, 30);
		company.clickonFinishBtn();
		WebLibrary.setExplicitWait(company.SelectBtn, driver, 30);
		boolean CreateAdmin = WebLibrary.verifyTextPresent("Admin has been created successfully");
		if(CreateAdmin == true){
			ReportLibrary.test.log(LogStatus.PASS, "Admin created successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Admin creation failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		company.clickonCreateAdminCloseIcon();
		WebLibrary.setExplicitWait(company.Status, driver, 30);
		company.setCompanySearch(DataLibrary.getdata("Company1"));
		company.selectDraftStatus();
		company.setSearchCountry(DataLibrary.getdata("Country"));
		company.clickonSearchBtn();
		driver.findElement(By.xpath("//table/tbody/tr/td[2]/div[contains(text(),'"+DataLibrary.getdata("Company1")+"')]")).click();
		companydetails.clickonActivateBtn();
		companydetails.clickonConfirmOkBtn();
		WebLibrary.wait(3);
		companydetails.verifyCompanyActivationMsg();
		companydetails.clickonDeactivateBtn();
		companydetails.clickonConfirmOkBtn();
		WebLibrary.wait(3);
		companydetails.verifyCompanyDeactivationMsg();
		companydetails.clickonActivateBtn();
		companydetails.clickonConfirmOkBtn();
		WebLibrary.wait(3);
		homepage.clickonCompanyMenu();
		homepage.clickonAdminSettingsMenu();
		WebLibrary.setExplicitWait(company.NumOfEmployees, driver, 30);
		company.setNumOfEmployees(DataLibrary.getdata("NumOfEmployees"));
		company.setNumOfRequests(DataLibrary.getdata("NumOfRequests"));
		company.selectPanVerificationRequired();
		company.clickonUpdateBtn();
		WebLibrary.wait(2);
		boolean AdminSettingsUpdate = WebLibrary.verifyTextPresent("Settings updated successfully");
		if(AdminSettingsUpdate == true){
			ReportLibrary.test.log(LogStatus.PASS, "Admin settings updated successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Admin settings updation failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		WebLibrary.setExplicitWait(homepage.CompanyMenu, driver, 30);
		homepage.clickonCompanyMenu();
		homepage.clickonAdminsMenu();
		WebLibrary.setExplicitWait(company.AdminListPage, driver, 30);
		if(WebLibrary.exists(company.AdminListPage)){
			ReportLibrary.test.log(LogStatus.PASS, "Admins list viewed successfully"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Failed to view Admins List"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		WebLibrary.setExplicitWait(homepage.CompanyMenu, driver, 30);
		homepage.clickonCompanyMenu();
		homepage.clickonLogoMenu();
		WebLibrary.setExplicitWait(company.BrowseBtn, driver, 30);
		company.clickonBrowseBtn();
		WebLibrary.wait(5);
		Runtime.getRuntime().exec(AutoItPath + "\\AudiLogo.exe");
		WebLibrary.wait(5);
		company.clickonResetBtn();
		WebLibrary.wait(2);
		company.clickonBrowseBtn();
		WebLibrary.wait(5);
		Runtime.getRuntime().exec(AutoItPath + "\\AudiLogo.exe");
		WebLibrary.wait(5);
		company.clickonPreviewBtn();
		WebLibrary.setExplicitWait(company.AcceptBtn, driver, 30);
		company.clickonReuploadBtn();
		WebLibrary.wait(3);
		company.clickonBrowseBtn();
		WebLibrary.wait(5);
		Runtime.getRuntime().exec(AutoItPath + "\\SeleniumLogo.exe");
		WebLibrary.wait(5);
		company.clickonPreviewBtn();
		WebLibrary.setExplicitWait(company.AcceptBtn, driver, 30);
		company.clickonAcceptBtn();
		WebLibrary.setExplicitWait(company.AdminLogo, driver, 30);
		if(WebLibrary.exists(company.AdminLogo)){
			ReportLibrary.test.log(LogStatus.PASS, "Logo uploaded successfully"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Failed to upload Logo"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		WebLibrary.setExplicitWait(homepage.CompanyMenu, driver, 30);
		homepage.clickonCompanyMenu();
		homepage.clickonDropdownMenu();
		WebLibrary.setExplicitWait(company.ViewDropdown, driver, 30);
		company.clickonEditDropdown();
		WebLibrary.setExplicitWait(company.UpdateDropdownBtn, driver, 30);
		company.clickonUpdateDropdownBtn();
		WebLibrary.wait(2);
		boolean DropdownUpdate = WebLibrary.verifyTextPresent("Dropdown updated successfully");
		if(DropdownUpdate == true){
			ReportLibrary.test.log(LogStatus.PASS, "Dropdown details updated successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Dropdown details updation failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		WebLibrary.setExplicitWait(company.ViewDropdown, driver, 30);
		company.clickonViewDropdown();
		WebLibrary.setExplicitWait(company.DropdownValuesPage, driver, 30);
		company.clickonInactivatevalue();
		WebLibrary.setExplicitWait(company.OkBtn, driver, 30);
		company.clickonOkBtn();
		WebLibrary.wait(2);
		boolean ValueInactivate = WebLibrary.verifyTextPresent("Dropdown Value Deactivated Successfully");
		if(ValueInactivate == true){
			ReportLibrary.test.log(LogStatus.PASS, "Dropdown value inactivated successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Dropdown value inactivation failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		company.clickonActivateValue();
		WebLibrary.setExplicitWait(company.OkBtn, driver, 30);
		company.clickonOkBtn();
		WebLibrary.wait(2);
		boolean ValueActivate = WebLibrary.verifyTextPresent("Dropdown Value Activated Successfully");
		if(ValueActivate == true){
			ReportLibrary.test.log(LogStatus.PASS, "Dropdown value activated successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Dropdown value activation failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
	}
	
	@Test(testName="All Actions in Metrics Report")
	public void AllActionsOfUserAndCustomizeModule() throws Exception
	{
		LoginPage loginpage = new LoginPage(driver);
		HomePage homepage = new HomePage(driver);
		SAUserPage user = new SAUserPage(driver);
		CustomizePage batchjob = new CustomizePage(driver);
		loginpage.setUsername(DataLibrary.getdata("SAUsername"));
		loginpage.setPassword(DataLibrary.getdata("SAPassword"));
		loginpage.clickonLogin();
		homepage.clickonUserMenu();
		homepage.clickonUserInformationSearchMenu();
		WebLibrary.setExplicitWait(user.SearchBtn, driver, 30);
		driver.findElement(By.xpath("//select[@id='companyName1']/option[contains(@value,'"+DataLibrary.getdata("Company1")+"')]")).click();
		user.clickonSearchBtn();
		if(driver.findElement(By.xpath("//table/tbody/tr/td[5]/div[contains(text(),'"+DataLibrary.getdata("Company1")+"')]")).isDisplayed()){
			ReportLibrary.test.log(LogStatus.PASS, "User Information searched successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "User Information search failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		user.clickonFromDate();
		WebLibrary.selectDate(DataLibrary.getdata("FromDate"));
		user.clickonSearchBtn();
		homepage.clickonUserMenu();
		homepage.clickonUserInformationSearchMenu();
		WebLibrary.setExplicitWait(user.SearchBtn, driver, 30);
		user.clickonSendReportIcon();
		WebLibrary.setExplicitWait(user.SendUserReportPopup, driver, 30);
		user.setToAddress(DataLibrary.getdata("EmailAddress"));
		user.clickonSendBtn();
		WebLibrary.wait(3);
		WebLibrary.setExplicitWait(user.AlertMsg, driver, 60);
		boolean SendReport = WebLibrary.verifyTextPresent("Report sent to "+DataLibrary.getdata("EmailAddress")+" Successfully.");
		if(SendReport == true){
			ReportLibrary.test.log(LogStatus.PASS, "User Report sent successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Failed to send User Report"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		user.clickonCloseIcon();
		WebLibrary.setExplicitWait(user.SearchBtn, driver, 30);
		WebLibrary.removeDownloadFiles();
		user.clickonDownloadReport();
		WebLibrary.wait(3);
		stepstatus = WebLibrary.getLatestFileName("UsersInformationReport");
		if(stepstatus==true){
			ReportLibrary.test.log(LogStatus.PASS, "UsersInformation Report downloaded successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "UsersInformation Report download failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		homepage.clickonUserMenu();
		homepage.clickonDetailedInformationMenu();
		user.setStartDate();
		user.clickonDetailedSearchBtn();
		WebLibrary.wait(3);
		if(WebLibrary.exists(user.DetailedSendReport)){
			user.clickonDetailedSendReport();
			WebLibrary.setExplicitWait(user.SendUserReportPopup, driver, 30);
			user.setToAddress(DataLibrary.getdata("EmailAddress"));
			user.clickonSendBtn();
			WebLibrary.wait(3);
			WebLibrary.setExplicitWait(user.AlertMsg, driver, 60);
			boolean NeverLoggedInSendReport = WebLibrary.verifyTextPresent("Report sent to "+DataLibrary.getdata("EmailAddress")+" Successfully.");
			if(NeverLoggedInSendReport == true){
				ReportLibrary.test.log(LogStatus.PASS, "Detailed Information > 'Never Logged In' Detailed Report sent successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
			}else{
				ReportLibrary.test.log(LogStatus.FAIL, "Detailed Information > Failed to send 'Never Logged In' Detailed Report"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
			}
			user.clickonCloseIcon();
			WebLibrary.setExplicitWait(user.DetailedSearchBtn, driver, 30);
			WebLibrary.removeDownloadFiles();
			user.clickonDetailedDownloadReport();
			WebLibrary.wait(3);
			stepstatus = WebLibrary.getLatestFileName("UsersInformationReport");
			if(stepstatus==true){
				ReportLibrary.test.log(LogStatus.PASS, "Detailed Information > 'Never Logged In' Detailed Report downloaded successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
			}else{
				ReportLibrary.test.log(LogStatus.FAIL, "Detailed Information > 'Never Logged In' Detailed Report download failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
			}
		}else{
			ReportLibrary.test.log(LogStatus.INFO, "No records to download or send report" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		
		user.clickonNoRequestTab();
		WebLibrary.wait(3);
		driver.findElement(By.xpath("//select[@id='companyName1']/option[contains(@value,'"+DataLibrary.getdata("Company2")+"')]")).click();
		user.setStartDate();
		driver.findElement(By.xpath("//label[contains(text(),'Start Date')]")).click();
		WebLibrary.wait(2);
		user.clickonDetailedSearchBtn();
		WebLibrary.wait(3);
		if(WebLibrary.exists(user.DetailedSendReport)){
			user.clickonDetailedSendReport();
			WebLibrary.setExplicitWait(user.SendUserReportPopup, driver, 30);
			user.setToAddress(DataLibrary.getdata("EmailAddress"));
			user.clickonSendBtn();
			WebLibrary.wait(3);
			WebLibrary.setExplicitWait(user.AlertMsg, driver, 60);
			boolean NoRequestsSendReport = WebLibrary.verifyTextPresent("Report sent to "+DataLibrary.getdata("EmailAddress")+" Successfully.");
			if(NoRequestsSendReport == true){
				ReportLibrary.test.log(LogStatus.PASS, "Detailed Information > 'NoRequests' Detailed Report sent successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
			}else{
				ReportLibrary.test.log(LogStatus.FAIL, "Detailed Information > Failed to send 'NoRequests' Detailed Report"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
			}
			user.clickonCloseIcon();
			WebLibrary.setExplicitWait(user.DetailedSearchBtn, driver, 30);
			WebLibrary.removeDownloadFiles();
			user.clickonDetailedDownloadReport();
			WebLibrary.wait(3);
			stepstatus = WebLibrary.getLatestFileName("UsersInformationReport");
			if(stepstatus==true){
				ReportLibrary.test.log(LogStatus.PASS, "Detailed Information > 'NoRequests' Detailed Report downloaded successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
			}else{
				ReportLibrary.test.log(LogStatus.FAIL, "Detailed Information > 'NoRequests' Detailed Report download failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
			}
		}else{
			ReportLibrary.test.log(LogStatus.INFO, "No records to download or send report" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		user.clickonOneRequestTab();
		WebLibrary.wait(3);
		driver.findElement(By.xpath("//select[@id='companyName1']/option[contains(@value,'"+DataLibrary.getdata("Company2")+"')]")).click();
		user.setStartDate();
		user.clickonDetailedSearchBtn();
		WebLibrary.wait(3);
		if(WebLibrary.exists(user.DetailedSendReport)){
			user.clickonDetailedSendReport();
			WebLibrary.setExplicitWait(user.SendUserReportPopup, driver, 30);
			user.setToAddress(DataLibrary.getdata("EmailAddress"));
			user.clickonSendBtn();
			WebLibrary.wait(3);
			WebLibrary.setExplicitWait(user.AlertMsg, driver, 60);
			boolean OneRequestSendReport = WebLibrary.verifyTextPresent("Report sent to "+DataLibrary.getdata("EmailAddress")+" Successfully.");
			if(OneRequestSendReport == true){
				ReportLibrary.test.log(LogStatus.PASS, "Detailed Information > 'One Request' Detailed Report sent successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
			}else{
				ReportLibrary.test.log(LogStatus.FAIL, "Detailed Information > Failed to send 'One Request' Detailed Report"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
			}
			user.clickonCloseIcon();
			WebLibrary.setExplicitWait(user.DetailedSearchBtn, driver, 30);
			WebLibrary.removeDownloadFiles();
			user.clickonDetailedDownloadReport();
			WebLibrary.wait(3);
			stepstatus = WebLibrary.getLatestFileName("UsersInformationReport");
			if(stepstatus==true){
				ReportLibrary.test.log(LogStatus.PASS, "Detailed Information > 'One Request' Detailed Report downloaded successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
			}else{
				ReportLibrary.test.log(LogStatus.FAIL, "Detailed Information > 'One Request' Detailed Report download failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
			}
		}else{
			ReportLibrary.test.log(LogStatus.INFO, "No records to download or send report" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		user.clickonMoreRequestTab();
		WebLibrary.wait(3);
		driver.findElement(By.xpath("//select[@id='companyName1']/option[contains(@value,'"+DataLibrary.getdata("Company2")+"')]")).click();
		user.setStartDate();
		user.clickonDetailedSearchBtn();
		WebLibrary.wait(3);
		if(WebLibrary.exists(user.SendReport)){
			user.clickonSendReportIcon();
			WebLibrary.setExplicitWait(user.SendUserReportPopup, driver, 30);
			user.setToAddress(DataLibrary.getdata("EmailAddress"));
			user.clickonSendBtn();
			WebLibrary.wait(3);
			WebLibrary.setExplicitWait(user.AlertMsg, driver, 60);
			boolean MoreRequestSendReport = WebLibrary.verifyTextPresent("Report sent to "+DataLibrary.getdata("EmailAddress")+" Successfully.");
			if(MoreRequestSendReport == true){
				ReportLibrary.test.log(LogStatus.PASS, "Detailed Information > 'More Request' Detailed Report sent successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
			}else{
				ReportLibrary.test.log(LogStatus.FAIL, "Detailed Information > Failed to send 'More Request' Detailed Report"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
			}
			user.clickonCloseIcon();
			WebLibrary.setExplicitWait(user.DetailedSearchBtn, driver, 30);
			WebLibrary.removeDownloadFiles();
			user.clickonDownloadReport();
			WebLibrary.wait(3);
			stepstatus = WebLibrary.getLatestFileName("UsersInformationReport");
			if(stepstatus==true){
				ReportLibrary.test.log(LogStatus.PASS, "Detailed Information > 'More Request' Detailed Report downloaded successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
			}else{
				ReportLibrary.test.log(LogStatus.FAIL, "Detailed Information > 'More Request' Detailed Report download failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
			}
		}else{
			ReportLibrary.test.log(LogStatus.INFO, "No records to download or send report" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}	
		user.clickonNoTemplateTab();
		WebLibrary.wait(3);
		driver.findElement(By.xpath("//select[@id='companyName1']/option[contains(@value,'"+DataLibrary.getdata("Company2")+"')]")).click();
		user.setStartDate();
		user.clickonDetailedSearchBtn();
		WebLibrary.wait(3);
		if(WebLibrary.exists(user.DetailedSendReport)){
			user.clickonDetailedSendReport();
			WebLibrary.setExplicitWait(user.SendUserReportPopup, driver, 30);
			user.setToAddress(DataLibrary.getdata("EmailAddress"));
			user.clickonSendBtn();
			WebLibrary.wait(3);
			WebLibrary.setExplicitWait(user.AlertMsg, driver, 60);
			boolean NoTemplateSendReport = WebLibrary.verifyTextPresent("Report sent to "+DataLibrary.getdata("EmailAddress")+" Successfully.");
			if(NoTemplateSendReport == true){
				ReportLibrary.test.log(LogStatus.PASS, "Detailed Information > 'No Template' Detailed Report sent successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
			}else{
				ReportLibrary.test.log(LogStatus.FAIL, "Detailed Information > Failed to send 'No Template' Detailed Report"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
			}
			user.clickonCloseIcon();
			WebLibrary.setExplicitWait(user.DetailedSearchBtn, driver, 30);
			WebLibrary.removeDownloadFiles();
			user.clickonDetailedDownloadReport();
			WebLibrary.wait(3);
			stepstatus = WebLibrary.getLatestFileName("UsersInformationReport");
			if(stepstatus==true){
				ReportLibrary.test.log(LogStatus.PASS, "Detailed Information > 'No Template' Detailed Report downloaded successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
			}else{
				ReportLibrary.test.log(LogStatus.FAIL, "Detailed Information > 'No Template' Detailed Report download failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
			}
		}else{
			ReportLibrary.test.log(LogStatus.INFO, "No records to download or send report" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		user.clickonOneTemplateTab();
		WebLibrary.wait(3);
		driver.findElement(By.xpath("//select[@id='companyName1']/option[contains(@value,'"+DataLibrary.getdata("Company2")+"')]")).click();
		user.setStartDate();
		user.clickonDetailedSearchBtn();
		WebLibrary.wait(3);
		if(WebLibrary.exists(user.DetailedSendReport)){
			user.clickonDetailedSendReport();
			WebLibrary.setExplicitWait(user.SendUserReportPopup, driver, 30);
			user.setToAddress(DataLibrary.getdata("EmailAddress"));
			user.clickonSendBtn();
			WebLibrary.wait(3);
			WebLibrary.setExplicitWait(user.AlertMsg, driver, 60);
			boolean OneTemplateSendReport = WebLibrary.verifyTextPresent("Report sent to "+DataLibrary.getdata("EmailAddress")+" Successfully.");
			if(OneTemplateSendReport == true){
				ReportLibrary.test.log(LogStatus.PASS, "Detailed Information > 'One Template' Detailed Report sent successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
			}else{
				ReportLibrary.test.log(LogStatus.FAIL, "Detailed Information > Failed to send 'One Template' Detailed Report"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
			}
			user.clickonCloseIcon();
			WebLibrary.setExplicitWait(user.DetailedSearchBtn, driver, 30);
			WebLibrary.removeDownloadFiles();
			user.clickonDetailedDownloadReport();
			WebLibrary.wait(3);
			stepstatus = WebLibrary.getLatestFileName("UsersInformationReport");
			if(stepstatus==true){
				ReportLibrary.test.log(LogStatus.PASS, "Detailed Information > 'One Template' Detailed Report downloaded successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
			}else{
				ReportLibrary.test.log(LogStatus.FAIL, "Detailed Information > 'One Template' Detailed Report download failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
			}
		}else{
			ReportLibrary.test.log(LogStatus.INFO, "No records to download or send report" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		user.clickonMoreTemplateTab();
		WebLibrary.wait(3);
		driver.findElement(By.xpath("//select[@id='companyName1']/option[contains(@value,'"+DataLibrary.getdata("Company2")+"')]")).click();
		user.setStartDate();
		user.clickonDetailedSearchBtn();
		WebLibrary.wait(3);
		if(WebLibrary.exists(user.DetailedSendReport)){
			user.clickonDetailedSendReport();
			WebLibrary.setExplicitWait(user.SendUserReportPopup, driver, 30);
			user.setToAddress(DataLibrary.getdata("EmailAddress"));
			user.clickonSendBtn();
			WebLibrary.wait(3);
			WebLibrary.setExplicitWait(user.AlertMsg, driver, 60);
			boolean MoreTemplateSendReport = WebLibrary.verifyTextPresent("Report sent to "+DataLibrary.getdata("EmailAddress")+" Successfully.");
			if(MoreTemplateSendReport == true){
				ReportLibrary.test.log(LogStatus.PASS, "Detailed Information > 'More Template' Detailed Report sent successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
			}else{
				ReportLibrary.test.log(LogStatus.FAIL, "Detailed Information > Failed to send 'More Template' Detailed Report"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
			}
			user.clickonCloseIcon();
			WebLibrary.setExplicitWait(user.DetailedSearchBtn, driver, 30);
			WebLibrary.removeDownloadFiles();
			user.clickonDetailedDownloadReport();
			WebLibrary.wait(3);
			stepstatus = WebLibrary.getLatestFileName("UsersInformationReport");
			if(stepstatus==true){
				ReportLibrary.test.log(LogStatus.PASS, "Detailed Information > 'More Template' Detailed Report downloaded successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
			}else{
				ReportLibrary.test.log(LogStatus.FAIL, "Detailed Information > 'More Template' Detailed Report download failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
			}
		}else{
			ReportLibrary.test.log(LogStatus.INFO, "No records to download or send report" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		homepage.clickonCustomizeMenu();
		homepage.clickonBatchJobs();
		batchjob.clickonEditUserNotification();
		WebLibrary.setExplicitWait(batchjob.DeactivateBtn, driver, 60);
		batchjob.clickonDeactivateBtn();
		WebLibrary.setExplicitWait(batchjob.OkBtn, driver, 60);
		batchjob.clickonOkBtn();
		WebLibrary.wait(2);
		boolean DeactivateBatchjob = WebLibrary.verifyTextPresent("General Batch Job Deactivated Successfully");
		if(DeactivateBatchjob == true){
			ReportLibrary.test.log(LogStatus.PASS, "Batch Job deactivated successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Batch Job deactivation failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		batchjob.setHours(DataLibrary.getdata("Hours"));
		batchjob.setMinutes(DataLibrary.getdata("Minutes"));
		batchjob.clickonUpdateBtn();
		WebLibrary.wait(2);
		boolean UpdateBatchjob = WebLibrary.verifyTextPresent("General Batch Job Updated Successfully");
		if(UpdateBatchjob == true){
			ReportLibrary.test.log(LogStatus.PASS, "Batch Job update successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Batch Job updation failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		batchjob.clickonActivateBtn();
		WebLibrary.setExplicitWait(batchjob.OkBtn, driver, 60);
		batchjob.clickonOkBtn();
		WebLibrary.wait(3);
		boolean ActivateBatchjob = WebLibrary.verifyTextPresent("Notification Job Successful General Batch Job Activated Successfully");
		if(ActivateBatchjob == true){
			ReportLibrary.test.log(LogStatus.PASS, "Batch Job activated successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Batch Job activation failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		batchjob.setMinutes(DataLibrary.getdata("Minutes"));
		batchjob.clickonRunNowBtn();
		WebLibrary.setExplicitWait(batchjob.OkBtn, driver, 60);
		batchjob.clickonRunNowOkBtn();
		WebLibrary.wait(2);
		boolean RunBatchjob = WebLibrary.verifyTextPresent("Notification Job Successful");
		if(RunBatchjob == true){
			ReportLibrary.test.log(LogStatus.PASS, "Batch Job runned successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Batch Job run failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
	}
	
	@Test(testName="UserRegistration")
	public void UserRegistration() throws Exception
	{
		LoginPage loginpage = new LoginPage(driver);
		HomePage homepage = new HomePage(driver);
		SAUserPage user = new SAUserPage(driver);
		PersonalInformationPage personalinformation = new PersonalInformationPage(driver);
		ChangePasswordPage changepassword = new ChangePasswordPage(driver);
		loginpage.setUsername(DataLibrary.getdata("SAUsername"));
		loginpage.setPassword(DataLibrary.getdata("SAPassword"));
		loginpage.clickonLogin();
		homepage.clickonUserRegistrationMenu();
		homepage.clickonRegisterUserMenu();
		WebLibrary.setExplicitWait(user.EmailAddress, driver, 60);
		user.setEmailAddress(DataLibrary.getdata("EmailAddress"));
		user.setFirstName(DataLibrary.getdata("FirstName"));
		user.setLastName(DataLibrary.getdata("LastName"));
		user.setPassword(DataLibrary.getdata("Password1"));
		user.setConfirmPassword(DataLibrary.getdata("ConfirmPassword"));
		user.clickonSaveBtn();
		WebLibrary.wait(2);
		boolean RunBatchjob = WebLibrary.verifyTextPresent("User Registration Successful");
		if(RunBatchjob == true){
			ReportLibrary.test.log(LogStatus.PASS, "User Registration successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "User Registration failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		user.clickonCloseIcon();
		WebLibrary.setExplicitWait(homepage.UserRegistrationMenu, driver, 30);
		homepage.clickonUserRegistrationMenu();
		homepage.clickonChangeUserPasswordMenu();
		user.selectUser(DataLibrary.getdata("EmailAddress"));
		user.setNewPassword(DataLibrary.getdata("NewPassword"));
		user.setConfirmNewPassword(DataLibrary.getdata("ConfirmNewPassword"));
		user.clickonUpdateBtn();
		WebLibrary.wait(2);
		boolean ManagePassword = WebLibrary.verifyTextPresent(DataLibrary.getdata("EmailAddress")+"'s Password changed successfully.");
		if(ManagePassword == true){
			ReportLibrary.test.log(LogStatus.PASS, "User password changed successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Failed to change User Password "+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		homepage.clickonHeadProfile();
		homepage.clickonMyPreferences();
		personalinformation.setFirstName(DataLibrary.getdata("SAFirstName"));
		personalinformation.setLastName(DataLibrary.getdata("SALastName"));
		personalinformation.setAddress(DataLibrary.getdata("Address"));
		personalinformation.setZip(DataLibrary.getdata("Zip"));
		personalinformation.setContactNum(DataLibrary.getdata("ContactNo"));
		personalinformation.setFaxNo(DataLibrary.getdata("Fax"));
		personalinformation.setCityName(DataLibrary.getdata("City"));
		personalinformation.setState(DataLibrary.getdata("State"));
		personalinformation.clickonUpdateButton();
		WebLibrary.wait(2);
		boolean PersonalDetailsUpdate = WebLibrary.verifyTextPresent("User Account updated successfully");
		if(PersonalDetailsUpdate == true){
			ReportLibrary.test.log(LogStatus.PASS, "Personal Information Updated successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Personal Information Updation Failed "+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		WebLibrary.setExplicitWait(user.MyPreferencesMenu, driver, 30);
		user.clickonMyPreferencesMenu();
		user.clickonChangePassword();
		changepassword.setOldPassword(DataLibrary.getdata("SAOldPassword"));
		changepassword.setNewPassword(DataLibrary.getdata("NewPassword"));
		changepassword.setConfirmPassword(DataLibrary.getdata("ConfirmNewPassword"));
		changepassword.clickonUpdateButton();
		WebLibrary.wait(4);
		boolean ChangePassword = WebLibrary.verifyTextPresent("Password changed successfully.");
		if(ChangePassword == true){
			ReportLibrary.test.log(LogStatus.PASS, "Change Password successfull" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Change Password Failed "+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
	}
}
