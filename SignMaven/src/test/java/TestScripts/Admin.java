package TestScripts;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Wait;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Finder;
import org.sikuli.script.Match;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.javascript.host.Iterator;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import ApplicationPages.AdminHomePage;
import ApplicationPages.CompanyDetailsPage;
import ApplicationPages.CustomizePage;
import ApplicationPages.GroupsPage;
import ApplicationPages.HomePage;
import ApplicationPages.LoginPage;
import ApplicationPages.MyApprovalPage;
import ApplicationPages.RequestPage;
import ApplicationPages.SACompanyPage;
import ApplicationPages.SAUserPage;
import ApplicationPages.UsersPage;
import FrameworkLibrary.BaseClass;
import FrameworkLibrary.DataLibrary;
import FrameworkLibrary.ReportLibrary;
import FrameworkLibrary.WebLibrary;

public class Admin extends BaseClass{

	boolean stepstatus;
	public static ExtentTest test;
	
	@Test(testName="To Update Company Details")
	public void CompanyDetailsUpdation()
	{
		LoginPage loginpage = new LoginPage(driver);
		HomePage homepage = new HomePage(driver);
		AdminHomePage admin = new AdminHomePage(driver);
		CompanyDetailsPage company = new CompanyDetailsPage(driver);
		loginpage.setUsername(DataLibrary.getdata("Username"));
		loginpage.setPassword(DataLibrary.getdata("Password"));
		loginpage.clickonLogin();
		homepage.clickonHeadProfile();
		homepage.clickonAdminLink();
		admin.clickonCompanyMenu();
		admin.clickonCompanyDetailsMenu();
		// To Verify Company details with blank data
		try {
			company.setAddress(DataLibrary.getdata("Address"));
			company.setCity(DataLibrary.getdata("City"));
			company.setState(DataLibrary.getdata("State"));
			company.setCountry(DataLibrary.getdata("Country"));
			company.setZip(DataLibrary.getdata("Zip"));
			company.setPhoneNum(DataLibrary.getdata("Phone"));
			company.setFax(DataLibrary.getdata("Fax"));
			company.setSupportEmail(DataLibrary.getdata("SupportEmail"));
			company.setSupportURL(DataLibrary.getdata("SupportURL"));
			company.clickonUpdateBtn();
			company.BlankDataValidation();					
		} catch (Exception e) 
		{
			System.out.println("Exception occured while verify Company details with blank data");
		}
		// To Verify Company details with invalid data
			try {
				company.setAddress(DataLibrary.getdata("Address1"));
				company.setCity(DataLibrary.getdata("City1"));
				company.setState(DataLibrary.getdata("State1"));
				company.setCountry(DataLibrary.getdata("Country1"));
				company.setZip(DataLibrary.getdata("Zip1"));
				company.setPhoneNum(DataLibrary.getdata("Phone1"));
				company.setFax(DataLibrary.getdata("Fax1"));
				company.setSupportEmail(DataLibrary.getdata("SupportEmail1"));
				company.setSupportURL(DataLibrary.getdata("SupportURL1"));
				company.clickonUpdateBtn();
				company.InvalidDataValidation();					
			} catch (Exception e) 
			{
				System.out.println("Exception occured while verify Company details with invalid data");
			}
		// To Verify Company details with valid data
			try {
				company.setAddress(DataLibrary.getdata("Address2"));
				company.setCity(DataLibrary.getdata("City2"));
				company.setState(DataLibrary.getdata("State2"));
				company.setCountry(DataLibrary.getdata("Country1"));
				company.setZip(DataLibrary.getdata("Zip2"));
				company.setPhoneNum(DataLibrary.getdata("Phone2"));
				company.setFax(DataLibrary.getdata("Fax2"));
				company.setSupportEmail(DataLibrary.getdata("SupportEmail2"));
				company.setSupportURL(DataLibrary.getdata("SupportURL2"));
				company.clickonUpdateBtn();
				company.ValidDataValidation();					
			} catch (Exception e) 
			{
				System.out.println("Exception occured while verify Company details with valid data");
			}
		homepage.clickonHeadProfile();
		homepage.clickonSignOutLink();		
	}
	
	@Test(testName="To Activate/Deactivate Company")
	public void CompanyDetailsActivation()
	{
		LoginPage loginpage = new LoginPage(driver);
		HomePage homepage = new HomePage(driver);
		AdminHomePage admin = new AdminHomePage(driver);
		CompanyDetailsPage company = new CompanyDetailsPage(driver);
		loginpage.setUsername(DataLibrary.getdata("Username"));
		loginpage.setPassword(DataLibrary.getdata("Password"));
		loginpage.clickonLogin();
		homepage.clickonHeadProfile();
		homepage.clickonAdminLink();
		admin.clickonCompanyMenu();
		admin.clickonCompanyDetailsMenu();
		//To Deactivate Company
		company.clickonDeactivateBtn();
		company.clickonConfirmOkBtn();
		company.verifyCompanyDeactivationMsg();
		//To Activate Company
		company.clickonActivateBtn();
		company.clickonConfirmOkBtn();
		WebLibrary.wait(3);
		company.verifyCompanyActivationMsg();
	}
		
	
	@Test(testName="To Add Admin and To update Admin Privileges")
	public void AdminCreationAndUpdation()
	{
		LoginPage loginpage = new LoginPage(driver);
		HomePage homepage = new HomePage(driver);
		AdminHomePage admin = new AdminHomePage(driver);
		UsersPage users = new UsersPage(driver);
		loginpage.setUsername(DataLibrary.getdata("Username"));
		loginpage.setPassword(DataLibrary.getdata("Password"));
		loginpage.clickonLogin();
		homepage.clickonHeadProfile();
		homepage.clickonAdminLink();
		admin.clickonCompanyMenu();
		admin.clickonUsersMenu();
/*		// To Verify Admin creation with blank data
		try{
		users.clickonAddAdminIcon();
		WebLibrary.wait(2);
		users.clickonSaveBtn();
		users.BlankDataValidation();
		}catch (Exception e) 
		{
			System.out.println("Exception occured while verify Admin creation with blank data");
		}
		// To Verify Admin creation with invalid data
		try{
			users.setEmailAddress(DataLibrary.getdata("EmailAddress"));
			users.setFirstName(DataLibrary.getdata("FirstName"));
			users.setLastName(DataLibrary.getdata("LastName"));
			users.clickonSaveBtn();
			users.InvalidDataValidation();
			}catch (Exception e) 
			{
				System.out.println("Exception occured while verify Admin creation with invalid data");
			}
		// To Verify Admin creation with valid data
		try{
			users.setEmailAddress(DataLibrary.getdata("EmailAddress1"));
			users.setFirstName(DataLibrary.getdata("FirstName1"));
			users.setLastName(DataLibrary.getdata("LastName1"));
			users.clickonSaveBtn();
			WebLibrary.wait(6);
			users.ValidDataValidation();
			}catch (Exception e) 
			{
				System.out.println("Exception occured while verify Admin creation with invalid data");
			}
		users.clickonCloseIcon();*/
		//To update Admin privileges
		users.selectRecord();
		WebLibrary.wait(2);
		users.selectAllTemplateCheckbox();
		users.clickonUpdateBtn();
		WebLibrary.wait(6);
		users.verifySuccessMsg();
		users.clickonDeleteBtn();
		WebLibrary.setExplicitWait(users.OkBtn, driver, 30);
		users.clickonOkBtn();
		boolean DeleteAdmin = WebLibrary.verifyTextPresent("Admin deleted successfully");
		if(DeleteAdmin == true){
			ReportLibrary.test.log(LogStatus.PASS, "Admin deleted successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Admin deletion failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		users.clickonCloseIcon();
		WebLibrary.setExplicitWait(users.SearchButton, driver, 30);
		users.setUsername(DataLibrary.getdata("EmailAddress1"));
		users.searchFirstName(DataLibrary.getdata("FirstName1"));
		users.searchLastName(DataLibrary.getdata("LastName1"));
		users.clickonSearchButton();
		WebLibrary.wait(2);
		if(driver.findElement(By.xpath("//table/tbody/tr/td[2]/div[contains(text(),'"+DataLibrary.getdata("EmailAddress1")+"')]")).isDisplayed()){
			ReportLibrary.test.log(LogStatus.PASS, "User searched successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "User search failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
	}
	
	@Test(testName="To verify logo functionality, Company Search actions and Manage password")
	public void AllActionsOfLogoCompanySearchAndManagePassword() throws Exception
	{
		LoginPage loginpage = new LoginPage(driver);
		HomePage homepage = new HomePage(driver);
		AdminHomePage admin = new AdminHomePage(driver);
		UsersPage users = new UsersPage(driver);
		SAUserPage user = new SAUserPage(driver);
		SACompanyPage company = new SACompanyPage(driver);
		loginpage.setUsername(DataLibrary.getdata("Username"));
		loginpage.setPassword(DataLibrary.getdata("Password"));
		loginpage.clickonLogin();
		homepage.clickonHeadProfile();
		homepage.clickonAdminLink();
		admin.clickonCompanyMenu();
		admin.clickonLogoMenu();
		WebLibrary.setExplicitWait(company.BrowseBtn, driver, 30);
		if(WebLibrary.exists(company.RemoveLink)){
			company.clickonRemoveLink();
			ReportLibrary.test.log(LogStatus.INFO, "Previous Logo removed successfully"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.INFO, "No Previous Logo to remove"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		WebLibrary.wait(2);
		company.clickonBrowseBtn();
		WebLibrary.wait(5);
		Runtime.getRuntime().exec(AutoItPath + "\\SutiSoftLogo.exe");
		WebLibrary.wait(8);
		company.clickonPreviewBtn();
		WebLibrary.setExplicitWait(company.AcceptBtn, driver, 30);
		company.clickonReuploadBtn();
		WebLibrary.wait(3);
		company.clickonBrowseBtn();
		WebLibrary.wait(5);
		Runtime.getRuntime().exec(AutoItPath + "\\SutiSoftLogo.exe");
		WebLibrary.wait(5);
		company.clickonPreviewBtn();
		WebLibrary.setExplicitWait(company.AcceptBtn, driver, 30);
		company.clickonAcceptBtn();
		WebLibrary.setExplicitWait(company.AdminAccountLogo, driver, 30);
		if(WebLibrary.exists(company.AdminAccountLogo)){
			ReportLibrary.test.log(LogStatus.PASS, "Logo uploaded successfully"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Failed to upload Logo"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		WebLibrary.setExplicitWait(admin.CompanyMenu, driver, 30);
		admin.clickonCompanyMenu();
		admin.clickonSearchMenu();
		WebLibrary.setExplicitWait(company.SearchBtn, driver, 30);
		String CompanyId = driver.findElement(By.xpath("//td[@id='companyId']")).getText();
		String CompanyName = driver.findElement(By.xpath("//td[@id='companyName']")).getText();
		String Status = driver.findElement(By.xpath("//td[@id='companystatus']")).getText();
		company.setCompanySearch(CompanyName);
		company.setCompanyId(CompanyId);
		company.setStatus(Status);
		company.clickonSearchBtn();
		WebLibrary.wait(3);
		if(driver.findElement(By.xpath("//table/tbody/tr/td[2][contains(text(),'"+CompanyName+"')]")).isDisplayed()){
			ReportLibrary.test.log(LogStatus.PASS, "Company details searched successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Company details search failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		company.clickonViewCompanyInformationIcon();
		WebLibrary.setExplicitWait(company.CompanyInformationPopup, driver, 30);
		if(WebLibrary.exists(company.CompanyInformationPopup)){
			ReportLibrary.test.log(LogStatus.PASS, "Company Information viewed successfully"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Failed to view Company Information"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		company.clickonCreateAdminCloseIcon();
		WebLibrary.setExplicitWait(company.SearchBtn, driver, 30);
		company.clickonUsersIcon();
		WebLibrary.setExplicitWait(company.UsersPopup, driver, 30);
		if(WebLibrary.exists(company.UsersPopup)){
			ReportLibrary.test.log(LogStatus.PASS, "Users List viewed successfully"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Failed to view Users List"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		company.clickonCreateAdminCloseIcon();
		WebLibrary.setExplicitWait(admin.CompanyMenu, driver, 30);
		admin.clickonCompanyMenu();
		admin.clickonManagePasswordMenu();
		WebLibrary.setExplicitWait(user.UpdateBtn, driver, 30);
		driver.findElement(By.xpath("//select[@id='userslistitems']/option[2]")).click();
		user.setNewPassword(DataLibrary.getdata("NewPassword"));
		user.clickonUpdateBtn();
		WebLibrary.wait(2);
		boolean ManagePassword = WebLibrary.verifyTextPresent("Password changed successfully");
		if(ManagePassword == true){
			ReportLibrary.test.log(LogStatus.PASS, "User password changed successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Failed to change User Password "+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}

	}
	
	@Test(testName="To Export Admin details")
	public void ExportAdmin()
	{
		LoginPage loginpage = new LoginPage(driver);
		HomePage homepage = new HomePage(driver);
		AdminHomePage admin = new AdminHomePage(driver);
		UsersPage users = new UsersPage(driver);
		loginpage.setUsername(DataLibrary.getdata("Username"));
		loginpage.setPassword(DataLibrary.getdata("Password"));
		loginpage.clickonLogin();
		homepage.clickonHeadProfile();
		try {
			homepage.clickonAdminLink();
			admin.clickonCompanyMenu();
			admin.clickonUsersMenu();
			//To Get NUmber of Records Count
			int Userscount = users.RecordsCount();
			System.out.println("UsersCount is " + Userscount );
			WebLibrary.wait(3);
			users.clickonExportToExcelIcon();
			WebLibrary.wait(4);
			// To get number of records in ExportedFile
			int ExportCount = WebLibrary.ExcelRowCount("Company Admins Information Repo",3);
			WebLibrary.wait(3);
			if(Userscount==ExportCount){
				ReportLibrary.test.log(LogStatus.PASS, "Total Number of Users count in the application and numbers of records in exported file are matched");
			}else{
				System.out.println("Exported records are not matched with application records");
			}
			
			users.clickonImportAdminsIcon();
			users.clickonBrowseBtn();
			WebLibrary.wait(5);
			Runtime.getRuntime().exec(AutoItPath + "\\ImportUsers.exe");
			WebLibrary.wait(6);
			users.clickonImportBtn();
			WebLibrary.wait(6);
			boolean ImportAdmin = WebLibrary.verifyTextPresent("Company Admins are successfully imported.");
			if(ImportAdmin == true){
				ReportLibrary.test.log(LogStatus.PASS, "Users imported successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
			}else{
				ReportLibrary.test.log(LogStatus.FAIL, "Users import failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
			}
			WebLibrary.wait(10);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Unable to Export Records");
		}
	}

	@Test(testName="Group Creation with blank,invalid and valid data")
	public void GroupCreationScenarios()
	{
		LoginPage loginpage = new LoginPage(driver);
		HomePage homepage = new HomePage(driver);
		AdminHomePage admin = new AdminHomePage(driver);
		GroupsPage group = new GroupsPage(driver);
		loginpage.setUsername(DataLibrary.getdata("Username"));
		loginpage.setPassword(DataLibrary.getdata("Password"));
		loginpage.clickonLogin();
		homepage.clickonHeadProfile();
		homepage.clickonAdminLink();
		admin.clickonCompanyMenu();
		admin.clickonGroupsMenu();
		group.clickonCreateGroupIcon();
		WebLibrary.setExplicitWait(group.GroupName, driver, 30);
		// To Verify Group Creation with blank data
		group.clickonSaveBtn();
		boolean GroupBlankMsg = WebLibrary.verifyTextPresent("Group Name is required");
		if(GroupBlankMsg == true){
			ReportLibrary.test.log(LogStatus.PASS, "Group Creation with blank data validation successfull" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Group Creation with blank data validation failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		// To Verify Group Creation with invalid data
		group.setGroupName(DataLibrary.getdata("InvalidGroupName"));
		group.clickonSaveBtn();
		boolean GroupInvalidMsg = WebLibrary.verifyTextPresent("Group Name must be alphanumeric");
		if(GroupInvalidMsg == true){
			ReportLibrary.test.log(LogStatus.PASS, "Group Name with invalid data validation successfull" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Group Name with invalid data validation failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		group.setGroupName(DataLibrary.getdata("ValidGroupName"));
		group.clickonBrowseBtn();
		WebLibrary.wait(3);
		WebLibrary.RobotKeysFileUpload(AttachmentFiles + "\\Approval.docx");
		WebLibrary.wait(3);
		group.clickonSaveBtn();
		WebLibrary.wait(3);
		boolean GroupInvalidFileMsg = WebLibrary.verifyTextPresent("Upload only csv file");
		if(GroupInvalidFileMsg == true){
			ReportLibrary.test.log(LogStatus.PASS, "Group Creation with invalid file validation successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Group Creation with invalid file validation failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		// To Verify Group Creation with valid data
		group.setGroupName(DataLibrary.getdata("ValidGroupName"));
		group.clickonBrowseBtn();
		WebLibrary.wait(3);
		WebLibrary.RobotKeysFileUpload(AttachmentFiles + "\\SampleGroupUsers.csv");
		WebLibrary.wait(3);
		group.clickonSaveBtn();
		WebLibrary.wait(2);
		boolean GroupSuccessMsg = WebLibrary.verifyTextPresent("Group Created Successfully");
		if(GroupSuccessMsg == true){
			ReportLibrary.test.log(LogStatus.PASS, "Group Created successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Group Creation failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
	}
		
	@Test(testName="Group updation, activate and deactivate scenarios")
	public void GroupUpdationActivateDeactivate()
	{
		LoginPage loginpage = new LoginPage(driver);
		HomePage homepage = new HomePage(driver);
		AdminHomePage admin = new AdminHomePage(driver);
		GroupsPage group = new GroupsPage(driver);
		loginpage.setUsername(DataLibrary.getdata("Username"));
		loginpage.setPassword(DataLibrary.getdata("Password"));
		loginpage.clickonLogin();
		homepage.clickonHeadProfile();
		homepage.clickonAdminLink();
		admin.clickonCompanyMenu();
		admin.clickonGroupsMenu();
		group.clickonCreateGroupIcon();
		WebLibrary.setExplicitWait(group.GroupName, driver, 30);
		group.setGroupName(DataLibrary.getdata("GroupName"));
		group.clickonSaveBtn();
		WebLibrary.wait(2);
		boolean GroupSuccessMsg = WebLibrary.verifyTextPresent("Group Created Successfully");
		if(GroupSuccessMsg == true){
			ReportLibrary.test.log(LogStatus.PASS, "Group Created successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Group Creation failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		// To verify Group updation
		driver.navigate().refresh();
		group.EditGroup();
		group.clickonUpdateBtn();
		WebLibrary.wait(2);
		boolean GroupUpdateMsg = WebLibrary.verifyTextPresent("Group updated successfully");
		if(GroupUpdateMsg == true){
			ReportLibrary.test.log(LogStatus.PASS, "Group updated successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Group updation failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		
		//To Verify Group Deactivate
		group.clickonDeactivateBtn();
		WebLibrary.wait(2);
		String Status = group.GetGroupStatus();
		if(Status != null && Status.trim().equalsIgnoreCase("Inactive")){
			ReportLibrary.test.log(LogStatus.PASS, "Group deactivated successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Group deactivation failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		//To Verify Group Activate
		group.EditGroup();
		group.clickonActivateBtn();
		WebLibrary.wait(2);
		String Status1 = group.GetGroupStatus();
		if(Status1!=null && Status1.trim().equalsIgnoreCase("Active")){
			ReportLibrary.test.log(LogStatus.PASS, "Group activated successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Group activation failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		//To Verify search Group and delete group
		group.setSearchGroupName(DataLibrary.getdata("GroupName"));
		group.clickonSearchButton();
		String GroupName = group.GetGroupName();
		if(GroupName!=null && GroupName.trim().equalsIgnoreCase(DataLibrary.getdata("GroupName"))){
			ReportLibrary.test.log(LogStatus.PASS, "Group searched successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Group search failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		group.EditGroup();
		group.clickonDeleteBtn();
		WebLibrary.setExplicitWait(group.SearchGroupName, driver, 30);
		WebLibrary.wait(2);
		group.setSearchGroupName(DataLibrary.getdata("GroupName"));
		group.clickonSearchButton();
		boolean SearchResultsMsg = WebLibrary.verifyTextPresent("No Records available");
		if(SearchResultsMsg == true){
			ReportLibrary.test.log(LogStatus.PASS, "Group deleted successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Group deletion failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
	}
	
	@Test(testName="Add Update Activate Deactivate and delete member")
	public void GroupMembersUpdationActivateDeactivate()
	{
		LoginPage loginpage = new LoginPage(driver);
		HomePage homepage = new HomePage(driver);
		AdminHomePage admin = new AdminHomePage(driver);
		GroupsPage group = new GroupsPage(driver);
		loginpage.setUsername(DataLibrary.getdata("Username"));
		loginpage.setPassword(DataLibrary.getdata("Password"));
		loginpage.clickonLogin();
		homepage.clickonHeadProfile();
		homepage.clickonAdminLink();
		admin.clickonCompanyMenu();
		admin.clickonGroupsMenu();
		group.clickonCreateGroupIcon();
		WebLibrary.setExplicitWait(group.GroupName, driver, 30);
		group.setGroupName(DataLibrary.getdata("GroupName"));
		group.clickonSaveBtn();
		WebLibrary.wait(2);
		boolean GroupSuccessMsg = WebLibrary.verifyTextPresent("Group Created Successfully");
		if(GroupSuccessMsg == true){
			ReportLibrary.test.log(LogStatus.PASS, "Group Created successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Group Creation failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		driver.navigate().refresh();
		group.ViewMembersList();
		group.clickonAddMemberIcon();
		group.setMemberName(DataLibrary.getdata("MemberName"));
		group.setMemberEmail(DataLibrary.getdata("MemberEmail"));		
		group.clickonSaveBtn();
		WebLibrary.setExplicitWait(group.GroupMembersPopup, driver, 30);
		if(driver.findElement(By.xpath("(//table)[2]/tbody/tr/td[3][contains(text(),'"+DataLibrary.getdata("MemberEmail")+"')]")).isDisplayed()){
			ReportLibrary.test.log(LogStatus.PASS, "Member Added successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Failed to add member"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		driver.findElement(By.xpath("(//table)[2]/tbody/tr/td[3][contains(text(),'"+DataLibrary.getdata("MemberEmail")+"')]/following-sibling::td[4]/a")).click();
		group.setMemberEmail(DataLibrary.getdata("MemberEmail1"));
		group.clickonUpdateBtn();
		WebLibrary.setExplicitWait(group.GroupMembersPopup, driver, 30);
		if(driver.findElement(By.xpath("(//table)[2]/tbody/tr/td[3][contains(text(),'"+DataLibrary.getdata("MemberEmail1")+"')]")).isDisplayed()){
			ReportLibrary.test.log(LogStatus.PASS, "Member updated successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Failed to update group member"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		driver.findElement(By.xpath("(//table)[2]/tbody/tr/td[3][contains(text(),'"+DataLibrary.getdata("MemberEmail1")+"')]/preceding-sibling::td[2]/input")).click();
		group.clickonActivateInactivateMember();
		WebLibrary.wait(3);
		String MemberStatus = driver.findElement(By.xpath("(//table)[2]/tbody/tr/td[3][contains(text(),'"+DataLibrary.getdata("MemberEmail1")+"')]/following-sibling::td[1]")).getText();
		if(MemberStatus != null && MemberStatus.trim().equalsIgnoreCase("Inactive")){
			ReportLibrary.test.log(LogStatus.PASS, "Member deactivated successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Member deactivation failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		driver.findElement(By.xpath("(//table)[2]/tbody/tr/td[3][contains(text(),'"+DataLibrary.getdata("MemberEmail1")+"')]/preceding-sibling::td[2]/input")).click();
		group.clickonActivateInactivateMember();		
		WebLibrary.wait(4);
		String MemberStatus1 = driver.findElement(By.xpath("(//table)[2]/tbody/tr/td[3][contains(text(),'"+DataLibrary.getdata("MemberEmail1")+"')]/following-sibling::td[1]")).getText();
		if(MemberStatus1 != null && MemberStatus.trim().equalsIgnoreCase("Active")){
			ReportLibrary.test.log(LogStatus.PASS, "Member activated successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Member activation failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		driver.findElement(By.xpath("(//table)[2]/tbody/tr/td[3][contains(text(),'"+DataLibrary.getdata("MemberEmail1")+"')]/preceding-sibling::td[2]/input")).click();
		group.clickonDeleteMemberIcon();
		WebLibrary.wait(4);
		if(driver.findElement(By.xpath("//table/tbody/tr/td/font[contains(text(),'No Records available')]")).isDisplayed()){
			ReportLibrary.test.log(LogStatus.PASS, "Member deleted successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Failed to delete group member"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		
		
		
		
	}

	@Test(testName="To Verify all actions under Customize and BulkDownload Modules")
	public void ToVerifyCustomizeAndBulkDownloadModules()
	{
		LoginPage loginpage = new LoginPage(driver);
		HomePage homepage = new HomePage(driver);
		AdminHomePage admin = new AdminHomePage(driver);
		CustomizePage customize = new CustomizePage(driver);
		RequestPage Request = new RequestPage(driver);
		MyApprovalPage myapproval = new MyApprovalPage(driver);
		loginpage.setUsername(DataLibrary.getdata("Username"));
		loginpage.setPassword(DataLibrary.getdata("Password"));
		loginpage.clickonLogin();
		homepage.clickonHeadProfile();
		homepage.clickonAdminLink();
		admin.clickonCustomizeMenu();
		admin.clickonBatchJobsMenu();
		customize.clickonEditRequestNotification();
		WebLibrary.setExplicitWait(customize.DeactivateBtn, driver, 60);
		customize.clickonDeactivateBtn();
		WebLibrary.setExplicitWait(customize.OkBtn, driver, 60);
		customize.clickonOkBtn();
		WebLibrary.wait(2);
		boolean DeactivateBatchjob = WebLibrary.verifyTextPresent("Batch Job Deactivated Successfully");
		if(DeactivateBatchjob == true){
			ReportLibrary.test.log(LogStatus.PASS, "RequestNotification Batch Job deactivated successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "RequestNotification Batch Job deactivation failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		customize.setHours(DataLibrary.getdata("Hours"));
		customize.setMinutes(DataLibrary.getdata("Minutes"));
		customize.clickonUpdateBtn();
		WebLibrary.wait(2);
		boolean UpdateBatchjob = WebLibrary.verifyTextPresent("Batch Job updated successfully");
		if(UpdateBatchjob == true){
			ReportLibrary.test.log(LogStatus.PASS, "RequestNotification Batch Job update successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "RequestNotification Batch Job updation failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		customize.clickonActivateBtn();
		WebLibrary.setExplicitWait(customize.OkBtn, driver, 60);
		customize.clickonOkBtn();
		WebLibrary.wait(3);
		boolean ActivateBatchjob = WebLibrary.verifyTextPresent("Notification Job Successful");
		if(ActivateBatchjob == true){
			ReportLibrary.test.log(LogStatus.PASS, "RequestNotification Batch Job activated successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "RequestNotification Batch Job activation failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		customize.setMinutes(DataLibrary.getdata("Minutes"));
		customize.clickonRunNowBtn();
		WebLibrary.setExplicitWait(customize.OkBtn, driver, 60);
		customize.clickonRunNowOkBtn();
		WebLibrary.wait(2);
		boolean RunBatchjob = WebLibrary.verifyTextPresent("Notification Job Successful");
		if(RunBatchjob == true){
			ReportLibrary.test.log(LogStatus.PASS, "RequestNotification Batch Job runned successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "RequestNotification Batch Job run failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		customize.clickonBatchJobLink();
		customize.clickonRequestNotificationHistory();
		customize.clickonFromDate();
		WebLibrary.selectDate(DataLibrary.getdata("FromDate"));
		customize.clickonSearchBtn();
		WebLibrary.wait(3);
		ReportLibrary.test.log(LogStatus.PASS, "RequestNotification Batch Job history searched successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		customize.clickonBatchJobLink();
		customize.clickonEditRequestPending();
		WebLibrary.setExplicitWait(customize.DeactivateBtn, driver, 60);
		customize.clickonDeactivateBtn();
		WebLibrary.setExplicitWait(customize.OkBtn, driver, 60);
		customize.clickonOkBtn();
		WebLibrary.wait(2);
		boolean DeactivateBatchjob1 = WebLibrary.verifyTextPresent("Batch Job Deactivated Successfully");
		if(DeactivateBatchjob1 == true){
			ReportLibrary.test.log(LogStatus.PASS, "RequestPending Batch Job deactivated successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "RequestPending Batch Job deactivation failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		customize.setHours(DataLibrary.getdata("Hours"));
		customize.setMinutes(DataLibrary.getdata("Minutes"));
		customize.clickonUpdateBtn();
		WebLibrary.wait(2);
		boolean UpdateBatchjob1 = WebLibrary.verifyTextPresent("Batch Job updated successfully");
		if(UpdateBatchjob1 == true){
			ReportLibrary.test.log(LogStatus.PASS, "RequestPending Batch Job update successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "RequestPending Batch Job updation failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		customize.clickonActivateBtn();
		WebLibrary.setExplicitWait(customize.OkBtn, driver, 60);
		customize.clickonOkBtn();
		WebLibrary.wait(3);
		boolean ActivateBatchjob1 = WebLibrary.verifyTextPresent("Request Pending Job Successful");
		if(ActivateBatchjob1 == true){
			ReportLibrary.test.log(LogStatus.PASS, "RequestPending Batch Job activated successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "RequestPending Batch Job activation failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		customize.setMinutes(DataLibrary.getdata("Minutes"));
		customize.clickonRunNowBtn();
		WebLibrary.setExplicitWait(customize.OkBtn, driver, 60);
		customize.clickonRunNowOkBtn();
		WebLibrary.wait(2);
		boolean RunBatchjob1 = WebLibrary.verifyTextPresent("Request Pending Job Successful");
		if(RunBatchjob1 == true){
			ReportLibrary.test.log(LogStatus.PASS, "RequestPending Batch Job runned successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "RequestPending Batch Job run failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		customize.clickonBatchJobLink();
		customize.clickonRequestPendingHistory();
		customize.clickonFromDate();
		WebLibrary.selectDate(DataLibrary.getdata("FromDate"));
		customize.clickonSearchBtn();
		WebLibrary.wait(3);
		ReportLibrary.test.log(LogStatus.PASS, "RequestPending Batch Job history searched successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		customize.clickonBatchJobLink();
		homepage.clickonLogo();
		homepage.clickonRequestMenu();
		
		WebElement documentPreview = driver.findElement(By.xpath("//table/tbody/tr/td[3]/div[contains(text(),'In Process') or contains(text(),'Fully Signed')]/parent::td/preceding-sibling::td[2]/div/span[@class='fa fa-eye']"));
		Actions action1 = new Actions(driver);
		action1.moveToElement(documentPreview).click().perform();
		WebLibrary.wait(3);
		WebLibrary.setExplicitWait(Request.MoreBtn, driver, 40);
		String RequestDocumentName = Request.getDocumentName();//To Get Request Document Name
		System.out.println("Document Name is" +RequestDocumentName);
		WebLibrary.removeDownloadFiles();
		Request.clickonDownloadBtn();
		WebLibrary.setExplicitWait(myapproval.ChooseTextFontSizePopup, driver, 60);
		myapproval.setFontSize(DataLibrary.getdata("FontSize"));
		myapproval.clickonProceedBtn();
		WebLibrary.wait(8);
		homepage.clickonHeadProfile();
		homepage.clickonAdminLink();
		admin.clickonCustomizeMenu();
		admin.clickonValidatedDocument();
		WebLibrary.setExplicitWait(admin.VerifyBtn, driver, 40);
		admin.clickonBrowseBtn();
		WebLibrary.wait(4);
		WebLibrary.RobotKeysFileUpload("C:\\Users\\shravanim\\Downloads\\"+ RequestDocumentName + ".pdf" );
		WebLibrary.wait(5);
		admin.clickonVerifyBtn();
		WebLibrary.wait(5);
		boolean ValidateDocument = WebLibrary.verifyTextPresent("Document Verification Successful. Document Match.");
		if(ValidateDocument == true){
			ReportLibrary.test.log(LogStatus.PASS, "Document validated successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Document validation failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		admin.clickonCustomizeMenu();
		admin.clickonBulkDownload();
		admin.setFromDate();
		admin.selectRequestStatus(DataLibrary.getdata("Status"));
		admin.clickonSearchBtn();
		WebLibrary.wait(3);
		WebLibrary.removeDownloadFiles();
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		admin.clickonBulkDownloadIcon();
		customize.clickonOkBtn();
		WebLibrary.wait(6);
		stepstatus = WebLibrary.getLatestFileName("MassDownload");
		if(stepstatus==true){
			ReportLibrary.test.log(LogStatus.PASS, "Bulk Download > Request document downloaded successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Bulk Download > Request document download failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
	}
}
	