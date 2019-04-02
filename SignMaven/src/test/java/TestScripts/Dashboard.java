package TestScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import ApplicationPages.AdminHomePage;
import ApplicationPages.CompanySettingsPage;
import ApplicationPages.CreateInPersonRequest;
import ApplicationPages.CreateRequestPage;
import ApplicationPages.CreateTemplatePage;
import ApplicationPages.HomePage;
import ApplicationPages.LoginPage;
import ApplicationPages.MyApprovalPage;
import ApplicationPages.RequestPage;
import ApplicationPages.UsersPage;
import FrameworkLibrary.BaseClass;
import FrameworkLibrary.DataLibrary;
import FrameworkLibrary.ReportLibrary;
import FrameworkLibrary.WebLibrary;

public class Dashboard extends BaseClass{

boolean stepstatus;
@Test(testName="Template Creation, Updation, Activation, Deactivation, Copying and Deleting")
public void ToVerifyAllActionsInWaitingForOthers() throws Exception
	{
	try{
		LoginPage loginpage = new LoginPage(driver);
		HomePage homepage = new HomePage(driver);
		CreateRequestPage CreateRequest = new CreateRequestPage(driver);
		CompanySettingsPage settings = new CompanySettingsPage(driver);
		RequestPage Request = new RequestPage(driver);
		MyApprovalPage myapproval = new MyApprovalPage(driver);
		AdminHomePage admin = new AdminHomePage(driver);
		UsersPage users = new UsersPage(driver);
		loginpage.setUsername(DataLibrary.getdata("Username"));
		loginpage.setPassword(DataLibrary.getdata("Password"));
		loginpage.clickonLogin();
		homepage.clickonSendARequest();
		if(WebLibrary.exists(CreateRequest.SupportingDocumentBtn)){
			System.out.println("Supporting Documents button is already enabled");
		}else{
			homepage.clickonHeadProfile();
			homepage.clickonAdminLink();
			admin.clickonCompanyMenu();
			admin.clickonCompanySettingsMenu();
			settings.clickonSupportingDocumentsSetting();
			settings.clickonUpdateBtn();
			boolean SettingsUpdateMsg = WebLibrary.verifyTextPresent("Company settings updated successfully");
			if(SettingsUpdateMsg == true){
				ReportLibrary.test.log(LogStatus.PASS, "Company settings got updated successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
			}else{
				ReportLibrary.test.log(LogStatus.FAIL, "Company settings updation failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
			}
			homepage.clickonLogo();
			homepage.clickonSendARequest();
		}
		CreateRequest.setRequestTitle(DataLibrary.getdata("RequestTitle"));
		CreateRequest.clickonMainDocumentBtn();
		WebLibrary.wait(5);
		Runtime.getRuntime().exec(AutoItPath + "\\Approval.exe");
		WebLibrary.setExplicitWait(CreateRequest.DocumentsList, driver, 30);
		CreateRequest.clickonSupportingDocumentBtn();
		CreateRequest.clickonBrowseBtn();
		WebLibrary.wait(3);
		Runtime.getRuntime().exec(AutoItPath + "\\OrientationPolicies.exe");
		WebLibrary.wait(3);
		CreateRequest.clickonUploadBtn();
		WebLibrary.wait(6);
		CreateRequest.clickonSupportingDocumentBtn();
		WebLibrary.wait(3);
		CreateRequest.clickonBrowseBtn();
		WebLibrary.wait(5);
		Runtime.getRuntime().exec(AutoItPath + "\\Attachment1.exe");
		WebLibrary.wait(5);
		CreateRequest.clickonUploadBtn();
		WebLibrary.wait(3);
		CreateRequest.setSigner1Email(DataLibrary.getdata("Signer1Email"));
		CreateRequest.setSigner1FirstName(DataLibrary.getdata("Signer1FirstName"));
		CreateRequest.setSigner1LastName(DataLibrary.getdata("Signer1LastName"));
		CreateRequest.clickonAddSignerIcon();
		CreateRequest.setSigner2Email(DataLibrary.getdata("Signer2Email"));
		CreateRequest.setSigner2FirstName(DataLibrary.getdata("Signer2FirstName"));
		CreateRequest.setSigner2LastName(DataLibrary.getdata("Signer2LastName"));
		Request.clickonNextBtn();
		WebLibrary.setExplicitWait(CreateRequest.DocumentSetupSaveBtn, driver, 20);
		CreateRequest.clickonSignature();
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//img[@id='documentPageImage1']"))).build().perform();	
		WebElement target = driver.findElement(By.xpath("//img[@id='documentPageImage1']"));
		int xcord = 99;
		int ycord = 428;
		action.moveToElement(target, xcord, ycord).click().build().perform();
		System.out.println("Signature added successfully");
		CreateRequest.clickonInitial();
		action.moveToElement(driver.findElement(By.xpath("//img[@id='documentPageImage1']"))).build().perform();
		int xcord1 = 304;
		action.moveToElement(target, xcord1, ycord).click().build().perform();
		System.out.println("Initial added successfully");
		CreateRequest.clickonDate();
		action.moveToElement(driver.findElement(By.xpath("//img[@id='documentPageImage1']"))).build().perform();
		int xcord2 = 514;
		action.moveToElement(target, xcord2, ycord).click().build().perform();
		System.out.println("Date added successfully");
		
		//To Add Custom fields for Signer 2
		CreateRequest.setSignerSelection(DataLibrary.getdata("Signer2Email"));
		CreateRequest.clickonSignature();
		action.moveToElement(driver.findElement(By.xpath("//img[@id='documentPageImage1']"))).build().perform();
		int ycord1 = 542;
		action.moveToElement(target, xcord, ycord1).click().build().perform();
		WebLibrary.setExplicitWait(CreateRequest.Initial, driver, 60);
		CreateRequest.clickonInitial();
		action.moveToElement(driver.findElement(By.xpath("//img[@id='documentPageImage1']"))).build().perform();
		action.moveToElement(target, xcord1, ycord1).click().build().perform();
		CreateRequest.clickonDate();
		action.moveToElement(driver.findElement(By.xpath("//img[@id='documentPageImage1']"))).build().perform();
		action.moveToElement(target, xcord2, ycord1).click().build().perform();
		WebLibrary.wait(3);
		Request.clickonSendNowBtn();
		WebLibrary.wait(2);
		boolean RequestSent = WebLibrary.verifyTextPresent("Request Sent Successfully");
		if(RequestSent == true){
			ReportLibrary.test.log(LogStatus.PASS, "Request created and sent for approval successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Request sending for approval failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}		
		homepage.clickonLogo();
		homepage.clickonWaitingForOthers();
		WebLibrary.setExplicitWait(homepage.WaitingForOthersPage, driver, 60);		
		WebLibrary.wait(3);
		driver.findElement(By.xpath("//table/tbody/tr/td[2]/div[contains(text(),'"+DataLibrary.getdata("RequestTitle")+"')]")).click();
		WebLibrary.setExplicitWait(Request.MainDocumentRequestId, driver, 40);
		String RequestId = Request.getMainDocumentRequestId();
		System.out.println("Request Id is " +RequestId);
		homepage.clickonRequestMenu();
		WebLibrary.setExplicitWait(Request.WaitingForOthersTab, driver, 60);
		WebLibrary.wait(3);
		Request.clickonWaitingForOthersTab();
		// To Verify Print, Download and Download Transaction document in WaitingForOthers Page	
		WebElement documentPreview = driver.findElement(By.xpath("//table/tbody/tr/td[2]/div[contains(text(),'"+DataLibrary.getdata("RequestTitle")+"')]/parent::td/preceding-sibling::td[1]/div/span[@class='fa fa-eye']"));
		Actions action1 = new Actions(driver);
		action1.moveToElement(documentPreview).click().perform();
		WebLibrary.wait(3);
		WebLibrary.setExplicitWait(Request.MoreBtn, driver, 40);
		String RequestDocumentName = Request.getDocumentName();//To Get Request Document Name
		System.out.println("Document Name is" +RequestDocumentName); 
		
		Request.clickonPrintBtn();
		WebLibrary.setExplicitWait(Request.OkBtn, driver, 20);
		Request.clickonOkBtn();
		WebLibrary.wait(2);
		WebLibrary.setExplicitWait(myapproval.ChooseTextFontSizePopup, driver, 60);
		myapproval.setFontSize("10");
		myapproval.clickonProceedBtn();
		WebLibrary.wait(5);
		stepstatus = WebLibrary.isWindowExists("sutisign/requestMainAction_requestDocumentsPrint.action?requestId="+ RequestId, driver);
		if(stepstatus==true){
			WebLibrary.wait(3);
			ReportLibrary.test.log(LogStatus.PASS, "Document printed successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Document print failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		driver.close();
		WebLibrary.SwitchtoWindow("sutisign/commonDisplay_dashBoardRequestSearch.action", driver);
		WebLibrary.setExplicitWait(Request.MoreBtn, driver, 20);
		WebLibrary.removeDownloadFiles();
		Request.clickonDownloadBtn();
		WebLibrary.setExplicitWait(myapproval.ChooseTextFontSizePopup, driver, 60);
		myapproval.setFontSize("10");
		myapproval.clickonProceedBtn();
		WebLibrary.wait(3);
		stepstatus = WebLibrary.getLatestFileName(RequestDocumentName + ".pdf");
		if(stepstatus==true){
			ReportLibrary.test.log(LogStatus.PASS, "Document downloaded successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Document downloaded failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		WebLibrary.wait(3);
		WebLibrary.removeDownloadFiles();
		Request.clickonDownloadTransBtn();
		WebLibrary.wait(3);
		System.out.println("TransactionDetails_" + RequestId + ".pdf");
		stepstatus = WebLibrary.getLatestFileName("TransactionDetails_" + RequestId + ".pdf");
		if(stepstatus==true){
			ReportLibrary.test.log(LogStatus.PASS, "Transaction details downloaded successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Transaction details downloaded failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		//To Replace signer, remove signer, view signer details and Resend Notification
		WebLibrary.setExplicitWait(Request.MoreBtn, driver, 40);
		Request.clickonMoreBtn();
		Request.clickonReplace();
		WebLibrary.setExplicitWait(Request.ReplaceSignerWindow, driver, 40);
		driver.findElement(By.xpath("//form[@id='replaceForm']/div[2]/table/tbody/tr/td[2][contains(text(),'"+DataLibrary.getdata("Signer1Email")+"')]/following-sibling::td[3]/input[@name='replacename']")).click();
		driver.switchTo().activeElement().sendKeys(DataLibrary.getdata("ReplaceSignerEmail"));
		WebLibrary.setExplicitWait(Request.ReplaceIcon, driver, 40);
		Request.clickonReplaceIcon();
		WebLibrary.wait(2);
		boolean ReplaceSigner = WebLibrary.verifyTextPresent("User(s) are Replaced Successfully");
		if(ReplaceSigner == true){
			ReportLibrary.test.log(LogStatus.PASS, "Signer got replaced successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Signer replace failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		Request.clickonCloseIcon();
		WebLibrary.setExplicitWait(Request.MoreBtn, driver, 40);
		Request.clickonMoreBtn();
		Request.clickonRemoveOption();
		WebLibrary.setExplicitWait(Request.RemoveSignerWindow, driver, 40);
		driver.findElement(By.xpath("//form[@id='removeSignerForm']/div/table/tbody/tr/td[2][contains(text(),'"+DataLibrary.getdata("Signer2Email")+"')]/following-sibling::td[2]/input")).click();
		Request.clickonRemoveIcon();
		WebLibrary.wait(2);
		boolean RemoveSigner = WebLibrary.verifyTextPresent("Signer removed successfully");
		if(RemoveSigner == true){
			ReportLibrary.test.log(LogStatus.PASS, "Signer got removed successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Signer remove failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		
		Request.clickonCloseIcon();
		WebLibrary.setExplicitWait(Request.MoreBtn, driver, 40);
		Request.clickonMoreBtn();
		Request.clickonSignerDetails();
		WebLibrary.setExplicitWait(Request.SignerDetailsPopup, driver, 20);
		if(Request.SignerDetailsPopup.isDisplayed()){
			ReportLibrary.test.log(LogStatus.PASS, "Signer Details popup got displayed successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Unable to view Signer Details popup"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		Request.clickonCloseIcon();
		WebLibrary.setExplicitWait(Request.MoreBtn, driver, 40);
		Request.clickonMoreBtn();
		Request.clickonResend();
		WebLibrary.setExplicitWait(Request.OkBtn, driver, 20);
		Request.clickonOkBtn();
		WebLibrary.wait(3);
		boolean ResendNotification = WebLibrary.verifyTextPresent("Notification has been resent successfully");
		if(ResendNotification == true){
			ReportLibrary.test.log(LogStatus.PASS, "Request notification got resent successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Request resend notification failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		Request.clickonWaitingForOthersTab();
		WebLibrary.setExplicitWait(homepage.WaitingForOthersPage, driver, 60);	
		WebLibrary.wait(3);
		driver.findElement(By.xpath("//table/tbody/tr/td[2]/div[contains(text(),'"+DataLibrary.getdata("RequestTitle")+"')]")).click();
		WebLibrary.setExplicitWait(Request.DownloadMainDocumentBtn, driver, 30);
		WebLibrary.removeDownloadFiles();
		Request.clickonDownloadMainDocumentBtn();
		WebLibrary.wait(5);
		stepstatus = WebLibrary.getLatestFileName(RequestDocumentName + ".pdf");
		if(stepstatus==true){
			ReportLibrary.test.log(LogStatus.PASS, "Downloaded Main document successfully from Main Document Tab" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Downloaded Main document failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		WebLibrary.removeDownloadFiles();
		driver.navigate().refresh();
		WebLibrary.setExplicitWait(Request.DownloadMainDocumentBtn, driver, 30);
		Request.clickonDownloadTransactionDocumentBtn();
		WebLibrary.wait(5);
		stepstatus = WebLibrary.getLatestFileName("TransactionDetails_" + RequestId + ".pdf");
		if(stepstatus==true){
			ReportLibrary.test.log(LogStatus.PASS, "Downloaded Transaction document successfully from Main Document Tab" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Downloaded Transaction document failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		
		Request.clickonSupportingDocumentsTab();
		WebLibrary.setExplicitWait(Request.SupportingDocumentsPage, driver, 30);
		WebLibrary.removeDownloadFiles();
		String DocumentName = driver.findElement(By.xpath("//table/tbody/tr/td[2]")).getText();
		Request.clickonDownloadDocumentIcon();
		WebLibrary.wait(3);
		stepstatus = WebLibrary.getLatestFileName(DocumentName);
		if(stepstatus==true){
			ReportLibrary.test.log(LogStatus.PASS, "Supporting document downloaded successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Supporting document downloaded failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		WebLibrary.removeDownloadFiles();
		Request.clickonDownloadAllIcon();
		WebLibrary.wait(3);
		stepstatus = WebLibrary.getLatestFileName("SupportingDocs");
		if(stepstatus==true){
			ReportLibrary.test.log(LogStatus.PASS, "Supporting document downloaded successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Supporting document downloaded failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		
		Request.clickonTransactionDetailsTab();
		WebLibrary.setExplicitWait(Request.TransactionDetailsPage, driver, 30);
		if(Request.TransactionDetailsPage.isDisplayed()){
			ReportLibrary.test.log(LogStatus.PASS, "Transaction Details Page got displayed successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Unable to view Transaction Details Page"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		
		Request.clickonCommentsTab();
		WebLibrary.setExplicitWait(Request.CommentsPage, driver, 30);
		if(Request.CommentsPage.isDisplayed()){
			ReportLibrary.test.log(LogStatus.PASS, "Comments Page got displayed successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Unable to view Comments"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		
		Request.clickonHistoryTab();
		WebLibrary.setExplicitWait(Request.HistoryPage, driver, 30);
		if(Request.HistoryPage.isDisplayed()){
			ReportLibrary.test.log(LogStatus.PASS, "History Page got displayed successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Unable to view History details"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		
		Request.clickonApprovalOrderTab();
		WebLibrary.setExplicitWait(Request.ApprovalOrderPage, driver, 30);
		if(Request.ApprovalOrderPage.isDisplayed()){
			ReportLibrary.test.log(LogStatus.PASS, "Approval Order Page got displayed successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Unable to view Approval Order details"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		Request.clickonViewSignerDetailsIcon();
		WebLibrary.setExplicitWait(Request.ViewSignerDetailsPopup, driver, 30);
		if(Request.ViewSignerDetailsPopup.isDisplayed()){
			ReportLibrary.test.log(LogStatus.PASS, "View Signer Details Popup got displayed successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Unable to view Signer Details"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		Request.clickonCloseIcon();		
		homepage.clickonLogo();
		homepage.clickonWaitingForOthers();		
		WebLibrary.setExplicitWait(homepage.WaitingForOthersPage, driver, 60);	
		Request.clickonShare();
		boolean ShareValidation = WebLibrary.verifyTextPresent("Please select atleast one request");
		if(ShareValidation == true){
			ReportLibrary.test.log(LogStatus.PASS, "Share validation successfull when no requests has been selected" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Share validation failed when no requests has been selected"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		Request.clickonOkBtn();
		String Name = HomePage.getCurrentCompanyName(); //To get Company Name
		String Name1 = Name.replace("(", "( ");
		String CompanyName = Name1.replace(")", " )");
		System.out.println(CompanyName);
		WebElement Checkbox = driver.findElement(By.xpath("//table/tbody/tr/td[2]/div[contains(text(),'"+DataLibrary.getdata("RequestTitle")+"')]/parent::td/preceding-sibling::td[1]/div/input[@type='checkbox']"));
		//Actions action1 = new Actions(driver);
		action1.moveToElement(Checkbox).click().build().perform();
		Request.clickonShare();
		if(!driver.findElements(By.xpath("//table[@id='userDetailsTableId']/tbody/tr/td[3]/div[contains(text(),'"+DataLibrary.getdata("Admin")+"')]")).isEmpty())
		{
			driver.findElement(By.xpath("//table[@id='userDetailsTableId']/tbody/tr/td[3]/div[contains(text(),'"+DataLibrary.getdata("Admin")+"')]/parent::td/preceding-sibling::td[2]/input[@type='checkbox']")).click();
		}else{
			Request.clickonCloseIcon();
			homepage.clickonHeadProfile();
			homepage.clickonAdminLink();
			admin.clickonCompanyMenu();
			admin.clickonUsersMenu();
			users.clickonAddAdminIcon();
			WebLibrary.wait(2);
			users.setEmailAddress(DataLibrary.getdata("Admin"));
			users.setFirstName(DataLibrary.getdata("FirstName"));
			users.setLastName(DataLibrary.getdata("LastName"));
			users.clickonSaveBtn();
			WebLibrary.wait(5);
			boolean AdminCreation = WebLibrary.verifyTextPresent("Admin Created Successfully");
			if(AdminCreation == true){
				ReportLibrary.test.log(LogStatus.PASS, "Admin created successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
			}else{
				ReportLibrary.test.log(LogStatus.FAIL, "Admin creation failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
			}
			driver.navigate().refresh();
			homepage.clickonLogo();
			homepage.clickonRequestMenu();
			WebLibrary.wait(3);
			driver.findElement(By.xpath("//table/tbody/tr/td[2]/div[contains(text(),'"+DataLibrary.getdata("RequestTitle")+"')]/parent::td/preceding-sibling::td[1]/div/input[@type='checkbox']")).click();
			Request.clickonShare();
			driver.findElement(By.xpath("//table[@id='userDetailsTableId']/tbody/tr/td[3]/div[contains(text(),'"+DataLibrary.getdata("Admin")+"')]/parent::td/preceding-sibling::td[2]/input[@type='checkbox']")).click();
		}
		Request.clickonShareAccessBtn();
		Request.clickonOkBtn();
		WebLibrary.wait(3);
		boolean ShareValidation1 = WebLibrary.verifyTextPresent("Access shared successfully");
		if(ShareValidation1 == true){
			ReportLibrary.test.log(LogStatus.PASS, "'Access shared successfully' validation message got displayed" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "'Access shared successfully' validation message not displayed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		Request.clickonWaitingForOthersTab();
		WebLibrary.setExplicitWait(homepage.WaitingForOthersPage, driver, 60);	
		WebLibrary.wait(3);
		WebElement documentPreview1 = driver.findElement(By.xpath("//table/tbody/tr/td[2]/div[contains(text(),'"+DataLibrary.getdata("RequestTitle")+"')]/parent::td/preceding-sibling::td[1]/div/span[@class='fa fa-eye']"));
		action1.moveToElement(documentPreview1).click().perform();
		WebLibrary.wait(3);
		WebLibrary.setExplicitWait(Request.MoreBtn, driver, 40);
		Request.clickonMoreBtn();
		Request.clickonCopy();
		WebLibrary.setExplicitWait(Request.OkBtn, driver, 20);
		Request.clickonOkBtn();
		WebLibrary.wait(3);
		boolean RequestCopy = WebLibrary.verifyTextPresent("Request Copied Successfully");
		if(RequestCopy == true){
			ReportLibrary.test.log(LogStatus.PASS, "Request Copied successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Request Copy failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		
		homepage.clickonHeadProfile();
		homepage.clickonSignOutLink();
		// To Verify whether Request has been shared to Admin.  
		loginpage.setUsername(DataLibrary.getdata("Admin"));
		loginpage.setPassword(DataLibrary.getdata("AdminPassword"));
		loginpage.clickonLogin();
		String AdminsCurrentCompany = HomePage.getCurrentCompanyName();
		//String RequestTitle = "To Verify Edit, Update, Send Later, Cancel Button, Copy, Download, Share and Delete Request{2334}";
		if(AdminsCurrentCompany.equals(CompanyName)){
			homepage.clickonWaitingForOthers();
			WebLibrary.wait(3);
			if(driver.findElement(By.xpath("//table/tbody/tr/td[2]/div[contains(text(),'"+DataLibrary.getdata("RequestTitle")+"')]")).isDisplayed()){
				ReportLibrary.test.log(LogStatus.PASS, "Request shared to Admin successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
			}else{
				ReportLibrary.test.log(LogStatus.FAIL, "Request shared to Admin failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
			}
		}else{
			homepage.clickonMenuBar();
			driver.findElement(By.xpath("//div[@class='user-name']/ul/li/ul/li[@title='"+CompanyName+"']")).click();
			WebLibrary.wait(3);
			homepage.clickonWaitingForOthers();
			WebLibrary.wait(3);
			if(driver.findElement(By.xpath("//table/tbody/tr/td[2]/div[contains(text(),'"+DataLibrary.getdata("RequestTitle")+"')]")).isDisplayed()){
				ReportLibrary.test.log(LogStatus.PASS, "Request shared to Admin successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
			}else{
				ReportLibrary.test.log(LogStatus.FAIL, "Request shared to Admin failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
			}
		}
		WebLibrary.wait(3);
		//Request.clickonWaitingForOthersTab();
		WebLibrary.setExplicitWait(homepage.WaitingForOthersPage, driver, 40);
		WebLibrary.wait(3);
		WebElement documentPreview2 = driver.findElement(By.xpath("//table/tbody/tr/td[2]/div[contains(text(),'"+DataLibrary.getdata("RequestTitle")+"')]/parent::td/preceding-sibling::td[1]/div/span[@class='fa fa-eye']"));
		action1.moveToElement(documentPreview2).click().perform();
		WebLibrary.wait(3);
		WebLibrary.setExplicitWait(Request.MoreBtn, driver, 40);
		Request.clickonMoreBtn();
		Request.clickonVoid();
		WebLibrary.setExplicitWait(Request.OkBtn, driver, 20);
		Request.clickonOkBtn();
		WebLibrary.wait(3);
		boolean RequestVoid = WebLibrary.verifyTextPresent("Request has been voided Successfully");
		if(RequestVoid == true){
			ReportLibrary.test.log(LogStatus.PASS, "Request voided successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Request void failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}

		WebLibrary.wait(10);
		
	}catch (Exception e) 
	{
		WebLibrary.wait(10);
		ReportLibrary.test.log(LogStatus.FAIL, "Failed to execute Waiting for Other actions"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
	}
		
}

@Test(testName="Template Creation, Updation, Activation, Deactivation, Copying and Deleting")
public void ToVerifyAllActionsInNeedToVerify() throws Exception
	{
	try{
		LoginPage loginpage = new LoginPage(driver);
		HomePage homepage = new HomePage(driver);
		CreateRequestPage CreateRequest = new CreateRequestPage(driver);
		CompanySettingsPage settings = new CompanySettingsPage(driver);
		RequestPage Request = new RequestPage(driver);
		MyApprovalPage myapproval = new MyApprovalPage(driver);
		AdminHomePage admin = new AdminHomePage(driver);
		UsersPage users = new UsersPage(driver);
		loginpage.setUsername(DataLibrary.getdata("Username"));
		loginpage.setPassword(DataLibrary.getdata("Password"));
		loginpage.clickonLogin();
		homepage.clickonSendARequest();
		if(WebLibrary.exists(CreateRequest.SupportingDocumentBtn)){
			System.out.println("Supporting Documents button is already enabled");
		}else{
			homepage.clickonHeadProfile();
			homepage.clickonAdminLink();
			admin.clickonCompanyMenu();
			admin.clickonCompanySettingsMenu();
			settings.clickonSupportingDocumentsSetting();
			settings.clickonUpdateBtn();
			boolean SettingsUpdateMsg = WebLibrary.verifyTextPresent("Company settings updated successfully");
			if(SettingsUpdateMsg == true){
				ReportLibrary.test.log(LogStatus.PASS, "Company settings got updated successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
			}else{
				ReportLibrary.test.log(LogStatus.FAIL, "Company settings updation failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
			}
			homepage.clickonLogo();
			homepage.clickonSendARequest();
		}
		CreateRequest.setRequestTitle(DataLibrary.getdata("RequestTitle"));
		CreateRequest.clickonMainDocumentBtn();
		WebLibrary.wait(5);
		Runtime.getRuntime().exec(AutoItPath + "\\Approval.exe");
		WebLibrary.setExplicitWait(CreateRequest.DocumentsList, driver, 60);
		CreateRequest.clickonSupportingDocumentBtn();
		CreateRequest.clickonBrowseBtn();
		WebLibrary.wait(3);
		Runtime.getRuntime().exec(AutoItPath + "\\OrientationPolicies.exe");
		WebLibrary.wait(3);
		CreateRequest.clickonUploadBtn();
		WebLibrary.wait(6);
		CreateRequest.clickonSupportingDocumentBtn();
		WebLibrary.wait(3);
		CreateRequest.clickonBrowseBtn();
		WebLibrary.wait(3);
		Runtime.getRuntime().exec(AutoItPath + "\\Attachment1.exe");
		WebLibrary.wait(3);
		CreateRequest.clickonUploadBtn();
		WebLibrary.wait(3);
		CreateRequest.setSigner1Email(DataLibrary.getdata("Signer1Email"));
		CreateRequest.setSigner1FirstName(DataLibrary.getdata("Signer1FirstName"));
		CreateRequest.setSigner1LastName(DataLibrary.getdata("Signer1LastName"));
		Request.clickonNextBtn();
		WebLibrary.setExplicitWait(CreateRequest.DocumentSetupSaveBtn, driver, 20);
		CreateRequest.clickonSignature();
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//img[@id='documentPageImage1']"))).build().perform();	
		WebElement target = driver.findElement(By.xpath("//img[@id='documentPageImage1']"));
		int xcord = 99;
		int ycord = 428;
		action.moveToElement(target, xcord, ycord).click().build().perform();
		System.out.println("Signature added successfully");
		CreateRequest.clickonInitial();
		action.moveToElement(driver.findElement(By.xpath("//img[@id='documentPageImage1']"))).build().perform();
		int xcord1 = 304;
		action.moveToElement(target, xcord1, ycord).click().build().perform();
		System.out.println("Initial added successfully");
		CreateRequest.clickonDate();
		action.moveToElement(driver.findElement(By.xpath("//img[@id='documentPageImage1']"))).build().perform();
		int xcord2 = 514;
		action.moveToElement(target, xcord2, ycord).click().build().perform();
		System.out.println("Date added successfully");
		
		WebLibrary.wait(3);
		Request.clickonSendNowBtn();
		WebLibrary.wait(2);
		boolean RequestSent = WebLibrary.verifyTextPresent("Request Sent Successfully");
		if(RequestSent == true){
			ReportLibrary.test.log(LogStatus.PASS, "Request created and sent for approval successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Request sending for approval failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}		
		homepage.clickonLogo();
		homepage.clickonNeedToSign();
		WebLibrary.setExplicitWait(homepage.NeedToSignPage, driver, 30);		
		WebLibrary.wait(3);
		WebElement documentPreview = driver.findElement(By.xpath("//table/tbody/tr/td[2]/div[contains(text(),'"+DataLibrary.getdata("RequestTitle")+"')]/parent::td/preceding-sibling::td[1]/div/span[@class='fa fa-eye']"));
		Actions action1 = new Actions(driver);
		action1.moveToElement(documentPreview).click().perform();
		WebLibrary.wait(3);
		WebLibrary.setExplicitWait(Request.PrintBtn, driver, 40);
		String RequestDocumentName = Request.getDocumentName();//To Get Request Document Name
		System.out.println("Document Name is" +RequestDocumentName); 
		driver.findElement(By.xpath("//table/tbody/tr/td[2]/div[contains(text(),'"+DataLibrary.getdata("RequestTitle")+"')]")).click();
		WebLibrary.setExplicitWait(myapproval.StartBtn, driver, 20);
		//To View Document Details
		myapproval.clickonMoreBtn();
		myapproval.clickonDocumentDetailsOption();
		WebLibrary.setExplicitWait(myapproval.Popup, driver, 60);
		String RequestId = driver.findElement(By.xpath("//table/tbody/tr/td[contains(text(),'Request ID')]/following-sibling::td[1]")).getText();
		if(myapproval.Popup.isDisplayed()){
			ReportLibrary.test.log(LogStatus.PASS, "Document Details Popup got displayed successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Unable to view Document Details"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		myapproval.clickonCloseIcon();
		//To View and download support document
		myapproval.clickonSignHere();
		boolean SupportingDocValidation = WebLibrary.verifyTextPresent("There are some Supporting Documents to be Viewed before Performing the Action");
		if(SupportingDocValidation == true){
			ReportLibrary.test.log(LogStatus.PASS, "Verify Supporting Document Validation message is displaying successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Verify Supporting Document Validation message not displaying"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		WebLibrary.removeDownloadFiles();
		myapproval.clickonMoreBtn();
		myapproval.clickonSupportingDocuments();
		String DocumentName = driver.findElement(By.xpath("//table/tbody/tr/td[2]")).getText();
		
		myapproval.clickonDownloadDocument();
		WebLibrary.wait(3);
		stepstatus = WebLibrary.getLatestFileName(DocumentName);
		if(stepstatus==true){
			ReportLibrary.test.log(LogStatus.PASS, "Supporting document downloaded successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Supporting document download failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		WebLibrary.removeDownloadFiles();
		myapproval.clickonDownloadAll();
		WebLibrary.wait(6);
		stepstatus = WebLibrary.getLatestFileName("supportingDoc");
		if(stepstatus==true){
			ReportLibrary.test.log(LogStatus.PASS, "All Supporting documents downloaded successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "All Supporting documents download failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}	
		myapproval.clickonCloseIcon();
		
		//To View/Add Comments
		myapproval.clickonMoreBtn();
		myapproval.clickonComments();
		WebLibrary.setExplicitWait(myapproval.Popup, driver, 60);
		myapproval.clickonAddCommentBtn();
		myapproval.setCommentsField(DataLibrary.getdata("Comments"));
		myapproval.clickonSaveCommentBtn();
		myapproval.clickonAcceptOKBtn();
		boolean Comments = WebLibrary.verifyTextPresent("Comment added successfully");
		if(Comments == true){
			ReportLibrary.test.log(LogStatus.PASS, "Comment added successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Failed to add Comment"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		myapproval.clickonCloseIcon();
		// To View Approval Order
		/*myapproval.clickonMoreBtn();
		myapproval.clickonApprovalOrder();
		WebLibrary.setExplicitWait(myapproval.Popup, driver, 60);
		if(myapproval.ApprovalOrderPopup.isDisplayed()){
			ReportLibrary.test.log(LogStatus.PASS, "ApprovalOrder Popup got displayed successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Unable to view Approval Order Details"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		myapproval.clickonCloseIcon();*/
		//TO Email Document
		myapproval.clickonMoreBtn();
		myapproval.clickonEmailDocument();
		WebLibrary.setExplicitWait(myapproval.Popup, driver, 60);
		myapproval.setEmailAddress(DataLibrary.getdata("SendEmail"));
		myapproval.clickonSendBtn();
		boolean EmailDocument = WebLibrary.verifyTextPresent("Document sent successfully");
		if(EmailDocument == true){
			ReportLibrary.test.log(LogStatus.PASS, "Email document has been sent successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Email document sending Failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		myapproval.clickonMoreBtn();
		//TO download main document
		WebLibrary.removeDownloadFiles();
		myapproval.clickonDownloadMainDocument();
		/*WebLibrary.setExplicitWait(myapproval.ChooseTextFontSizePopup, driver, 60);
		myapproval.setFontSize(DataLibrary.getdata("FontSize"));
		myapproval.clickonAcceptOKBtn();*/
		WebLibrary.wait(3);
		stepstatus = WebLibrary.getLatestFileName(RequestDocumentName + ".pdf");
		if(stepstatus==true){
			ReportLibrary.test.log(LogStatus.PASS, "Downloaded Main document successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Downloaded Main document failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		//To download transaction details
		WebLibrary.wait(3);
		WebLibrary.removeDownloadFiles();
		myapproval.clickonMoreBtn();
		myapproval.clickonDownloadTransactionDocument();
		WebLibrary.wait(3);
		System.out.println("TransactionDetails_" + RequestId + ".pdf");
		stepstatus = WebLibrary.getLatestFileName("TransactionDetails_" + RequestId + ".pdf");
		if(stepstatus==true){
			ReportLibrary.test.log(LogStatus.PASS, "Transaction details downloaded successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Transaction details downloaded failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		
		myapproval.clickonMoreBtn();
		myapproval.clickonForward();
		WebLibrary.setExplicitWait(myapproval.Popup, driver, 60);
		myapproval.setAlternateSigner(DataLibrary.getdata("AlternateSigner"));
		myapproval.clickonForwardBtn();
		WebLibrary.setExplicitWait(homepage.NeedToSignPage,driver, 80);
		homepage.clickonHeadProfile();
		homepage.clickonSignOutLink();
		// AlternateSigner Approval Process
		loginpage.setUsername(DataLibrary.getdata("AlternateSigner"));
		loginpage.setPassword(DataLibrary.getdata("AlternateSignerPassword"));
		loginpage.clickonLogin();
		homepage.clickonNeedToSign();
		WebLibrary.setExplicitWait(homepage.NeedToSignPage, driver, 60);
		if(driver.findElement(By.xpath("//table/tbody/tr/td[2]/div[contains(text(),'"+DataLibrary.getdata("RequestTitle")+"')]")).isDisplayed()){
			ReportLibrary.test.log(LogStatus.PASS, "Request forwarded successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Request forward failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		WebElement documentPreview1 = driver.findElement(By.xpath("//table/tbody/tr/td[2]/div[contains(text(),'"+DataLibrary.getdata("RequestTitle")+"')]/parent::td/preceding-sibling::td[1]/div/span[@class='fa fa-eye']"));
		action1.moveToElement(documentPreview1).click().perform();	
		WebLibrary.setExplicitWait(Request.MoreBtn, driver, 20);
		Request.clickonPrintBtn();
		WebLibrary.setExplicitWait(Request.OkBtn, driver, 20);
		Request.clickonOkBtn();
		WebLibrary.wait(5);
		//stepstatus = WebLibrary.isWindowExists("sutisign/myapproval_printCommonApprovalDocuments.action?requestId=", driver);
		stepstatus = WebLibrary.isWindowExists("sutisign/myapproval_printCommonApprovalDocuments.action?requestId="+ RequestId, driver);
		if(stepstatus==true){
			WebLibrary.wait(3);
			ReportLibrary.test.log(LogStatus.PASS, "Document printed successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Document print failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		driver.close();
		WebLibrary.SwitchtoWindow("sutisign/myApprovalPendingAction_dashBoardpendingList.action", driver);
		WebLibrary.setExplicitWait(Request.MoreBtn, driver, 20);
		WebLibrary.removeDownloadFiles();
		Request.clickonDownloadBtn();
		/*WebLibrary.setExplicitWait(myapproval.ChooseTextFontSizePopup, driver, 60);
		myapproval.setFontSize(DataLibrary.getdata("FontSize"));
		myapproval.clickonAcceptOKBtn();*/
		WebLibrary.wait(3);
		//stepstatus = WebLibrary.getLatestFileName("need_to_sign");
		stepstatus = WebLibrary.getLatestFileName(RequestDocumentName + ".pdf");
		if(stepstatus==true){
			ReportLibrary.test.log(LogStatus.PASS, "'Need to Sign' page document preview > Downloaded Main document successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "'Need to Sign' page document preview > Downloaded Main document failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		
		WebLibrary.wait(3);
		WebLibrary.removeDownloadFiles();
		Request.clickonDownloadTransBtn();
		WebLibrary.wait(3);
		System.out.println("TransactionDetails_" + RequestId + ".pdf");
		//stepstatus = WebLibrary.getLatestFileName("TransactionDetails_");
		stepstatus = WebLibrary.getLatestFileName("TransactionDetails_" + RequestId + ".pdf");
		if(stepstatus==true){
			ReportLibrary.test.log(LogStatus.PASS, "'Need to Sign' page document preview >Transaction details downloaded successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "'Need to Sign' page document preview >Transaction details downloaded failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		driver.findElement(By.xpath("//table/tbody/tr/td[2]/div[contains(text(),'"+DataLibrary.getdata("RequestTitle")+"')]")).click();
		WebLibrary.setExplicitWait(myapproval.StartBtn, driver, 20);
		myapproval.clickonMoreBtn();
		myapproval.clickonReject();
		myapproval.clickonAcceptOKBtn();
		WebLibrary.wait(2);	
		boolean RejectRequest = WebLibrary.verifyTextPresent("You have successfully completed the signing process for this document");
		if(RejectRequest == true){
			ReportLibrary.test.log(LogStatus.PASS, "Request has been rejeceted successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Request rejecetion failed" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		
	}catch (Exception e) 
	{
		WebLibrary.wait(10);
		ReportLibrary.test.log(LogStatus.FAIL, "Failed to execute Need to Sign actions"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
	}
}

@Test(testName="Template Creation, Updation, Activation, Deactivation, Copying and Deleting")
public void ToVerifyAllActionsInMySignedItems() throws Exception
	{
	try{
		LoginPage loginpage = new LoginPage(driver);
		HomePage homepage = new HomePage(driver);
		CreateRequestPage CreateRequest = new CreateRequestPage(driver);
		CompanySettingsPage settings = new CompanySettingsPage(driver);
		RequestPage Request = new RequestPage(driver);
		MyApprovalPage myapproval = new MyApprovalPage(driver);
		AdminHomePage admin = new AdminHomePage(driver);
		UsersPage users = new UsersPage(driver);
		loginpage.setUsername(DataLibrary.getdata("Username"));
		loginpage.setPassword(DataLibrary.getdata("Password"));
		loginpage.clickonLogin();
		//homepage.clickonMySignedItems();
		homepage.clickonSendARequest();
		if(WebLibrary.exists(CreateRequest.SupportingDocumentBtn)){
			System.out.println("Supporting Documents button is already enabled");
		}else{
			homepage.clickonHeadProfile();
			homepage.clickonAdminLink();
			admin.clickonCompanyMenu();
			admin.clickonCompanySettingsMenu();
			settings.clickonSupportingDocumentsSetting();
			settings.clickonUpdateBtn();
			boolean SettingsUpdateMsg = WebLibrary.verifyTextPresent("Company settings updated successfully");
			if(SettingsUpdateMsg == true){
				ReportLibrary.test.log(LogStatus.PASS, "Company settings got updated successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
			}else{
				ReportLibrary.test.log(LogStatus.FAIL, "Company settings updation failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
			}
			homepage.clickonLogo();
			homepage.clickonSendARequest();
		}
		CreateRequest.setRequestTitle(DataLibrary.getdata("RequestTitle"));
		CreateRequest.clickonMainDocumentBtn();
		WebLibrary.wait(5);
		Runtime.getRuntime().exec(AutoItPath + "\\Approval.exe");
		WebLibrary.setExplicitWait(CreateRequest.DocumentsList, driver, 30);
		CreateRequest.clickonSupportingDocumentBtn();
		CreateRequest.clickonBrowseBtn();
		WebLibrary.wait(3);
		Runtime.getRuntime().exec(AutoItPath + "\\OrientationPolicies.exe");
		WebLibrary.wait(3);
		CreateRequest.clickonUploadBtn();
		WebLibrary.wait(6);
		CreateRequest.clickonSupportingDocumentBtn();
		WebLibrary.wait(3);
		CreateRequest.clickonBrowseBtn();
		WebLibrary.wait(3);
		Runtime.getRuntime().exec(AutoItPath + "\\Attachment1.exe");
		WebLibrary.wait(3);
		CreateRequest.clickonUploadBtn();
		WebLibrary.wait(3);
		CreateRequest.setSigner1Email(DataLibrary.getdata("Signer1Email"));
		CreateRequest.setSigner1FirstName(DataLibrary.getdata("Signer1FirstName"));
		CreateRequest.setSigner1LastName(DataLibrary.getdata("Signer1LastName"));
		CreateRequest.clickonAddSignerIcon();
		CreateRequest.setSigner2Email(DataLibrary.getdata("Signer2Email"));
		CreateRequest.setSigner2FirstName(DataLibrary.getdata("Signer2FirstName"));
		CreateRequest.setSigner2LastName(DataLibrary.getdata("Signer2LastName"));
		Request.clickonNextBtn();
		WebLibrary.setExplicitWait(CreateRequest.DocumentSetupSaveBtn, driver, 20);
		CreateRequest.clickonSignature();
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//img[@id='documentPageImage1']"))).build().perform();	
		WebElement target = driver.findElement(By.xpath("//img[@id='documentPageImage1']"));
		int xcord = 99;
		int ycord = 428;
		action.moveToElement(target, xcord, ycord).click().build().perform();
		System.out.println("Signature added successfully");
		CreateRequest.clickonInitial();
		action.moveToElement(driver.findElement(By.xpath("//img[@id='documentPageImage1']"))).build().perform();
		int xcord1 = 304;
		action.moveToElement(target, xcord1, ycord).click().build().perform();
		System.out.println("Initial added successfully");
		CreateRequest.clickonDate();
		action.moveToElement(driver.findElement(By.xpath("//img[@id='documentPageImage1']"))).build().perform();
		int xcord2 = 514;
		action.moveToElement(target, xcord2, ycord).click().build().perform();
		System.out.println("Date added successfully");
		
		//To Add Custom fields for Signer 2
		CreateRequest.setSignerSelection(DataLibrary.getdata("Signer2Email"));
		WebLibrary.wait(3);
		CreateRequest.clickonSignature();
		action.moveToElement(driver.findElement(By.xpath("//img[@id='documentPageImage1']"))).build().perform();
		int ycord1 = 542;
		action.moveToElement(target, xcord, ycord1).click().build().perform();
		WebLibrary.setExplicitWait(CreateRequest.Initial, driver, 60);
		CreateRequest.clickonInitial();
		action.moveToElement(driver.findElement(By.xpath("//img[@id='documentPageImage1']"))).build().perform();
		action.moveToElement(target, xcord1, ycord1).click().build().perform();
		CreateRequest.clickonDate();
		action.moveToElement(driver.findElement(By.xpath("//img[@id='documentPageImage1']"))).build().perform();
		action.moveToElement(target, xcord2, ycord1).click().build().perform();
		WebLibrary.wait(3);
		Request.clickonSendNowBtn();
		WebLibrary.wait(2);
		boolean RequestSent = WebLibrary.verifyTextPresent("Request Sent Successfully");
		if(RequestSent == true){
			ReportLibrary.test.log(LogStatus.PASS, "Request created and sent for approval successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Request sending for approval failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}	
		WebLibrary.setExplicitWait(homepage.WaitingForOthersPage, driver, 30);	
		homepage.clickonLogo();
		homepage.clickonNeedToSign();
		WebLibrary.setExplicitWait(homepage.NeedToSignPage, driver, 30);		
		WebLibrary.wait(3);
		WebElement documentPreview = driver.findElement(By.xpath("//table/tbody/tr/td[2]/div[contains(text(),'"+DataLibrary.getdata("RequestTitle")+"')]/parent::td/preceding-sibling::td[1]/div/span[@class='fa fa-eye']"));
		Actions action1 = new Actions(driver);
		action1.moveToElement(documentPreview).click().perform();
		WebLibrary.wait(3);
		WebLibrary.setExplicitWait(Request.PrintBtn, driver, 40);
		String RequestDocumentName = Request.getDocumentName();//To Get Request Document Name
		System.out.println("Document Name is" +RequestDocumentName); 
		driver.findElement(By.xpath("//table/tbody/tr/td[2]/div[contains(text(),'"+DataLibrary.getdata("RequestTitle")+"')]")).click();
		WebLibrary.setExplicitWait(myapproval.StartBtn, driver, 20);
		//To View Document Details
		myapproval.clickonMoreBtn();
		myapproval.clickonDocumentDetailsOption();
		WebLibrary.setExplicitWait(myapproval.Popup, driver, 60);
		String RequestId = driver.findElement(By.xpath("//table/tbody/tr/td[contains(text(),'Request ID')]/following-sibling::td[1]")).getText();
		if(myapproval.Popup.isDisplayed()){
			ReportLibrary.test.log(LogStatus.PASS, "Document Details Popup got displayed successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Unable to view Document Details"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		myapproval.clickonCloseIcon();
		//To View and download support document
		myapproval.clickonSignHere();
		boolean SupportingDocValidation = WebLibrary.verifyTextPresent("There are some Supporting Documents to be Viewed before Performing the Action");
		if(SupportingDocValidation == true){
			ReportLibrary.test.log(LogStatus.PASS, "Verify Supporting Document Validation message is displaying successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Verify Supporting Document Validation message not displaying"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		WebLibrary.removeDownloadFiles();
		myapproval.clickonMoreBtn();
		myapproval.clickonSupportingDocuments();
		WebLibrary.wait(3);
		myapproval.clickonDownloadAll();
		WebLibrary.wait(6);
		stepstatus = WebLibrary.getLatestFileName("supportingDoc");
		if(stepstatus==true){
			ReportLibrary.test.log(LogStatus.PASS, "All Supporting documents downloaded successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "All Supporting documents download failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}	
		myapproval.clickonCloseIcon();
		
		WebLibrary.setExplicitWait(myapproval.StartBtn, driver, 60);
		myapproval.clickonSignHere();
		if(driver.findElement(By.xpath("//div[@id='createSignContentDiv']")).isDisplayed()){
			myapproval.setTypeSignature(DataLibrary.getdata("Signer1FirstName"));
			myapproval.clickonTypeApplyBtn();
			myapproval.clickonAcceptOKBtn();
		}else{
			myapproval.clickonAcceptOKBtn();
		}
		myapproval.clickonInitialHere();
		if(driver.findElement(By.xpath("//div[@id='createSignContentDiv']")).isDisplayed()){
			myapproval.setTypeSignature(DataLibrary.getdata("Signer1LastName"));
			myapproval.clickonTypeApplyBtn();
			myapproval.clickonAcceptOKBtn();
		}else{
			myapproval.clickonAcceptOKBtn();
		}
		myapproval.clickonCalendarIcon1();
		WebLibrary.selectDate(DataLibrary.getdata("Date"));
		myapproval.clickonFinishBtn();	

		myapproval.clickonAcceptOKBtn();
		WebLibrary.wait(2);	
		boolean ApprovalStatus = WebLibrary.verifyTextPresent("You have successfully completed the signing process for this document");
		if(ApprovalStatus == true){
			ReportLibrary.test.log(LogStatus.PASS, "Signer 1 : Request approval process done successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Signer 1 : Request approval process failed" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		myapproval.clickonBackBtn();
		WebLibrary.setExplicitWait(homepage.MySignedItemsPage, driver, 30);
		WebElement documentPreview1 = driver.findElement(By.xpath("//table/tbody/tr/td[2]/div[contains(text(),'"+DataLibrary.getdata("RequestTitle")+"')]/parent::td/preceding-sibling::td[1]/div/span[@class='fa fa-eye']"));
		action1.moveToElement(documentPreview1).click().perform();
		WebLibrary.setExplicitWait(Request.PrintBtn, driver, 60);
		WebLibrary.wait(3);
		Request.clickonPrintBtn();
		WebLibrary.setExplicitWait(Request.OkBtn, driver, 20);
		Request.clickonOkBtn();
		WebLibrary.wait(5);
		//stepstatus = WebLibrary.isWindowExists("sutisign/myapproval_printCommonApprovalDocuments.action?requestId=", driver);
		stepstatus = WebLibrary.isWindowExists("sutisign/myapproval_printCommonApprovalDocuments.action?requestId="+ RequestId, driver);
		if(stepstatus==true){
			WebLibrary.wait(3);
			ReportLibrary.test.log(LogStatus.PASS, "Document printed successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Document print failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		driver.close();
		WebLibrary.SwitchtoWindow("sutisign/myApprovalPendingAction_dashBoardCompletedApprovals.action", driver);
		WebLibrary.setExplicitWait(Request.PrintBtn, driver, 20);
		WebLibrary.removeDownloadFiles();
		Request.clickonDownloadBtn();
/*		WebLibrary.setExplicitWait(myapproval.ChooseTextFontSizePopup, driver, 60);
		myapproval.setFontSize(DataLibrary.getdata("FontSize"));
		myapproval.clickonAcceptOKBtn();*/
		WebLibrary.wait(3);
		stepstatus = WebLibrary.getLatestFileName(RequestDocumentName + ".pdf");
		if(stepstatus==true){
			ReportLibrary.test.log(LogStatus.PASS, "'My Signed Items' page document preview > Downloaded Main document successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "'My Signed Items' page document preview > Downloaded Main document failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		
		WebLibrary.wait(3);
		WebLibrary.removeDownloadFiles();
		Request.clickonDownloadTransBtn();
		WebLibrary.wait(3);
		System.out.println("TransactionDetails_" + RequestId + ".pdf");
		//stepstatus = WebLibrary.getLatestFileName("TransactionDetails_");
		stepstatus = WebLibrary.getLatestFileName("TransactionDetails_" + RequestId + ".pdf");
		if(stepstatus==true){
			ReportLibrary.test.log(LogStatus.PASS, "'My Signed Items' page document preview >Transaction details downloaded successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "'My Signed Items' page document preview >Transaction details downloaded failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		driver.findElement(By.xpath("//table/tbody/tr/td[2]/div[contains(text(),'"+DataLibrary.getdata("RequestTitle")+"')]")).click();
		WebLibrary.setExplicitWait(myapproval.MoreBtn, driver, 20);
		//To View Document Details
		myapproval.clickonMoreBtn();
		myapproval.clickonDocumentDetailsOption();
		WebLibrary.setExplicitWait(myapproval.Popup, driver, 40);
		if(myapproval.Popup.isDisplayed()){
			ReportLibrary.test.log(LogStatus.PASS, "Document Details Popup got displayed successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Unable to view Document Details"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		myapproval.clickonCloseIcon();
		WebLibrary.wait(3);
		//To View and download support document
		WebLibrary.removeDownloadFiles();
		myapproval.clickonMoreBtn();
		myapproval.clickonSupportingDocuments();
		String DocumentName = driver.findElement(By.xpath("//table/tbody/tr/td[2]")).getText();
		myapproval.clickonDownloadDocument();
		WebLibrary.wait(3);
		stepstatus = WebLibrary.getLatestFileName(DocumentName);
		if(stepstatus==true){
			ReportLibrary.test.log(LogStatus.PASS, "Supporting document downloaded successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Supporting document download failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		WebLibrary.removeDownloadFiles();
		myapproval.clickonDownloadAll();
		WebLibrary.wait(6);
		stepstatus = WebLibrary.getLatestFileName("supportingDoc");
		if(stepstatus==true){
			ReportLibrary.test.log(LogStatus.PASS, "All Supporting documents downloaded successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "All Supporting documents download failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}	
		myapproval.clickonCloseIcon();
		WebLibrary.wait(3);
		//To View/Add Comments
		myapproval.clickonMoreBtn();
		myapproval.clickonComments();
		WebLibrary.setExplicitWait(myapproval.Popup, driver, 60);
		if(myapproval.Popup.isDisplayed()){
			ReportLibrary.test.log(LogStatus.PASS, "Comments Popup got displayed successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Unable to view Comment Details"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		myapproval.clickonCloseIcon();
		WebLibrary.wait(3);
		//To View Approval Order
		myapproval.clickonMoreBtn();
		myapproval.clickonApprovalOrder();
		WebLibrary.setExplicitWait(myapproval.Popup, driver, 60);
		if(myapproval.ApprovalOrderPopup.isDisplayed()){
			ReportLibrary.test.log(LogStatus.PASS, "ApprovalOrder Popup got displayed successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Unable to view Approval Order Details"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		myapproval.clickonCloseIcon();
		WebLibrary.wait(3);
		//TO Email Document
		myapproval.clickonMoreBtn();
		myapproval.clickonEmailDocument();
		WebLibrary.setExplicitWait(myapproval.Popup, driver, 60);
		myapproval.setEmailAddress(DataLibrary.getdata("SendEmail"));
		myapproval.clickonSendBtn();
		boolean EmailDocument = WebLibrary.verifyTextPresent("Document sent successfully");
		if(EmailDocument == true){
			ReportLibrary.test.log(LogStatus.PASS, "Email document has been sent successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Email document sending Failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		myapproval.clickonMoreBtn();
		myapproval.clickonTransactionDetails();
		WebLibrary.setExplicitWait(myapproval.Popup, driver, 60);
		if(myapproval.TransactionDetailsPopup.isDisplayed()){
			ReportLibrary.test.log(LogStatus.PASS, "TransactionDetails Popup got displayed successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Unable to view Transaction Details"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		myapproval.clickonCloseIcon();
		WebLibrary.wait(3);
		myapproval.clickonMoreBtn();
		//TO download main document
		WebLibrary.removeDownloadFiles();
		myapproval.clickonDownloadMainDocument();
		/*WebLibrary.setExplicitWait(myapproval.ChooseTextFontSizePopup, driver, 60);
		myapproval.setFontSize(DataLibrary.getdata("FontSize"));
		myapproval.clickonAcceptOKBtn();*/
		WebLibrary.wait(5);
		stepstatus = WebLibrary.getLatestFileName(RequestDocumentName + ".pdf");
		if(stepstatus==true){
			ReportLibrary.test.log(LogStatus.PASS, "Downloaded Main document successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Downloaded Main document failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		//To download transaction details
		WebLibrary.wait(3);
		WebLibrary.removeDownloadFiles();
		myapproval.clickonMoreBtn();
		myapproval.clickonDownloadTransactionDocument();
		WebLibrary.wait(3);
		System.out.println("TransactionDetails_" + RequestId + ".pdf");
		stepstatus = WebLibrary.getLatestFileName("TransactionDetails_" + RequestId + ".pdf");
		if(stepstatus==true){
			ReportLibrary.test.log(LogStatus.PASS, "Transaction details downloaded successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Transaction details downloaded failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		
	}catch (Exception e) 
	{
		WebLibrary.wait(10);
		ReportLibrary.test.log(LogStatus.FAIL, "Failed to execute My Signed Items Test case"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
	}
}

@Test(testName="To Verify all actions unders Archived Items tab")
public void ToVerifyAllActionsInArchivedItems() throws Exception
{
try{
	LoginPage loginpage = new LoginPage(driver);
	HomePage homepage = new HomePage(driver);
	CreateRequestPage CreateRequest = new CreateRequestPage(driver);
	CompanySettingsPage settings = new CompanySettingsPage(driver);
	RequestPage Request = new RequestPage(driver);
	MyApprovalPage myapproval = new MyApprovalPage(driver);
	AdminHomePage admin = new AdminHomePage(driver);
	UsersPage users = new UsersPage(driver);
	loginpage.setUsername(DataLibrary.getdata("Username"));
	loginpage.setPassword(DataLibrary.getdata("Password"));
	loginpage.clickonLogin();
	homepage.clickonSendARequest();
	if(WebLibrary.exists(CreateRequest.SupportingDocumentBtn)){
		System.out.println("Supporting Documents button is already enabled");
	}else{
		homepage.clickonHeadProfile();
		homepage.clickonAdminLink();
		admin.clickonCompanyMenu();
		admin.clickonCompanySettingsMenu();
		settings.clickonSupportingDocumentsSetting();
		settings.clickonUpdateBtn();
		boolean SettingsUpdateMsg = WebLibrary.verifyTextPresent("Company settings updated successfully");
		if(SettingsUpdateMsg == true){
			ReportLibrary.test.log(LogStatus.PASS, "Company settings got updated successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Company settings updation failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		homepage.clickonLogo();
		homepage.clickonSendARequest();
	}
	CreateRequest.setRequestTitle(DataLibrary.getdata("RequestTitle"));
	CreateRequest.clickonMainDocumentBtn();
	WebLibrary.wait(5);
	Runtime.getRuntime().exec(AutoItPath + "\\Approval.exe");
	WebLibrary.setExplicitWait(CreateRequest.DocumentsList, driver, 30);
	CreateRequest.clickonSupportingDocumentBtn();
	WebLibrary.wait(3);
	CreateRequest.clickonBrowseBtn();
	WebLibrary.wait(3);
	Runtime.getRuntime().exec(AutoItPath + "\\OrientationPolicies.exe");
	WebLibrary.wait(3);
	CreateRequest.clickonUploadBtn();
	WebLibrary.wait(5);
	CreateRequest.clickonSupportingDocumentBtn();
	WebLibrary.wait(3);
	CreateRequest.clickonBrowseBtn();
	WebLibrary.wait(3);
	Runtime.getRuntime().exec(AutoItPath + "\\Attachment1.exe");
	WebLibrary.wait(4);
	CreateRequest.clickonUploadBtn();
	WebLibrary.wait(3);
	CreateRequest.setSigner1Email(DataLibrary.getdata("Signer1Email"));
	CreateRequest.setSigner1FirstName(DataLibrary.getdata("Signer1FirstName"));
	CreateRequest.setSigner1LastName(DataLibrary.getdata("Signer1LastName"));
	CreateRequest.clickonAddSignerIcon();
	CreateRequest.setSigner2Email(DataLibrary.getdata("Signer2Email"));
	CreateRequest.setSigner2FirstName(DataLibrary.getdata("Signer2FirstName"));
	CreateRequest.setSigner2LastName(DataLibrary.getdata("Signer2LastName"));
	Request.clickonNextBtn();
	WebLibrary.setExplicitWait(CreateRequest.DocumentSetupSaveBtn, driver, 20);
	CreateRequest.clickonSignature();
	Actions action = new Actions(driver);
	action.moveToElement(driver.findElement(By.xpath("//img[@id='documentPageImage1']"))).build().perform();	
	WebElement target = driver.findElement(By.xpath("//img[@id='documentPageImage1']"));
	int xcord = 99;
	int ycord = 428;
	action.moveToElement(target, xcord, ycord).click().build().perform();
	System.out.println("Signature added successfully");
	CreateRequest.clickonInitial();
	action.moveToElement(driver.findElement(By.xpath("//img[@id='documentPageImage1']"))).build().perform();
	int xcord1 = 304;
	action.moveToElement(target, xcord1, ycord).click().build().perform();
	System.out.println("Initial added successfully");
	CreateRequest.clickonDate();
	action.moveToElement(driver.findElement(By.xpath("//img[@id='documentPageImage1']"))).build().perform();
	int xcord2 = 514;
	action.moveToElement(target, xcord2, ycord).click().build().perform();
	System.out.println("Date added successfully");
	
	//To Add Custom fields for Signer 2
	CreateRequest.setSignerSelection(DataLibrary.getdata("Signer2Email"));
	WebLibrary.wait(3);
	CreateRequest.clickonSignature();
	action.moveToElement(driver.findElement(By.xpath("//img[@id='documentPageImage1']"))).build().perform();
	int ycord1 = 542;
	action.moveToElement(target, xcord, ycord1).click().build().perform();
	WebLibrary.setExplicitWait(CreateRequest.Initial, driver, 60);
	CreateRequest.clickonInitial();
	action.moveToElement(driver.findElement(By.xpath("//img[@id='documentPageImage1']"))).build().perform();
	action.moveToElement(target, xcord1, ycord1).click().build().perform();
	CreateRequest.clickonDate();
	action.moveToElement(driver.findElement(By.xpath("//img[@id='documentPageImage1']"))).build().perform();
	action.moveToElement(target, xcord2, ycord1).click().build().perform();
	WebLibrary.wait(6);
	Request.clickonSendNowBtn();
	WebLibrary.wait(3);
	boolean RequestSent = WebLibrary.verifyTextPresent("Request Sent Successfully");
	if(RequestSent == true){
		ReportLibrary.test.log(LogStatus.PASS, "Request created and sent for approval successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
	}else{
		ReportLibrary.test.log(LogStatus.FAIL, "Request sending for approval failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
	}
	Request.clickonAllTab();
	WebLibrary.setExplicitWait(Request.AllRequestPage, driver, 60);
	driver.findElement(By.xpath("//table/tbody/tr/td[2]/div[contains(text(),'"+DataLibrary.getdata("RequestTitle")+"')]")).click();
	WebLibrary.setExplicitWait(Request.MainDocumentRequestId, driver, 40);
	String RequestId = Request.getMainDocumentRequestId();
	System.out.println("Request Id is " +RequestId);
	homepage.clickonRequestMenu();
	WebLibrary.setExplicitWait(Request.WaitingForOthersTab, driver, 60);
	WebLibrary.wait(3);
	WebElement documentPreview = driver.findElement(By.xpath("//table/tbody/tr/td[2]/div[contains(text(),'"+DataLibrary.getdata("RequestTitle")+"')]/parent::td/preceding-sibling::td[1]/div/span[@class='fa fa-eye']"));
	Actions action1 = new Actions(driver);
	action1.moveToElement(documentPreview).click().perform();
	WebLibrary.wait(3);
	WebLibrary.setExplicitWait(Request.MoreBtn, driver, 40);
	String RequestDocumentName = Request.getDocumentName();//To Get Request Document Name
	System.out.println("Document Name is" +RequestDocumentName);
	Request.clickonMoreBtn();
	Request.clickonArchive();
	Request.clickonOkBtn();
	WebLibrary.wait(2);
	boolean ArchiveRequest = WebLibrary.verifyTextPresent("Successfully sent to Archived items");
	if(ArchiveRequest == true){
		ReportLibrary.test.log(LogStatus.PASS, "Archived request validation got displayed successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
	}else{
		ReportLibrary.test.log(LogStatus.FAIL, "Archived request validation not displayed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
	}
	Request.clickonArchivedTab();
	WebLibrary.setExplicitWait(Request.ArchivedRequestPage, driver, 40);
	if(driver.findElement(By.xpath("//table/tbody/tr/td[2]/div[contains(text(),'"+DataLibrary.getdata("RequestTitle")+"')]")).isDisplayed()){
		ReportLibrary.test.log(LogStatus.PASS, "Request Archived successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
	}else{
		ReportLibrary.test.log(LogStatus.FAIL, "Request Archive failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
	}

	WebElement documentPreview1 = driver.findElement(By.xpath("//table/tbody/tr/td[2]/div[contains(text(),'"+DataLibrary.getdata("RequestTitle")+"')]/parent::td/preceding-sibling::td[1]/div/span[@class='fa fa-eye']"));
	action1.moveToElement(documentPreview1).click().perform();
	WebLibrary.setExplicitWait(Request.MoreBtn, driver, 60);
	WebLibrary.wait(3);
	Request.clickonPrintBtn();
	WebLibrary.setExplicitWait(Request.OkBtn, driver, 20);
	Request.clickonOkBtn();
	WebLibrary.setExplicitWait(myapproval.ChooseTextFontSizePopup, driver, 60);
	myapproval.setFontSize(DataLibrary.getdata("FontSize"));
	myapproval.clickonProceedBtn();
	WebLibrary.wait(5);
	stepstatus = WebLibrary.isWindowExists("sutisign/requestMainAction_requestDocumentsPrint.action?requestId="+ RequestId, driver);
	if(stepstatus==true){
		WebLibrary.wait(3);
		ReportLibrary.test.log(LogStatus.PASS, "Document printed successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
	}else{
		ReportLibrary.test.log(LogStatus.FAIL, "Document print failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
	}
	driver.close();
	WebLibrary.SwitchtoWindow("sutisign/commonDisplay_dashBoardRequestSearch.action", driver);
	WebLibrary.setExplicitWait(Request.MoreBtn, driver, 20);
	WebLibrary.removeDownloadFiles();
	Request.clickonDownloadBtn();
	WebLibrary.setExplicitWait(myapproval.ChooseTextFontSizePopup, driver, 60);
	myapproval.setFontSize(DataLibrary.getdata("FontSize"));
	myapproval.clickonProceedBtn();
	WebLibrary.wait(6);
	stepstatus = WebLibrary.getLatestFileName(RequestDocumentName + ".pdf");
	if(stepstatus==true){
		ReportLibrary.test.log(LogStatus.PASS, "Document downloaded successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
	}else{
		ReportLibrary.test.log(LogStatus.FAIL, "Document downloaded failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
	}
	WebLibrary.wait(3);
	WebLibrary.removeDownloadFiles();
	Request.clickonDownloadTransBtn();
	WebLibrary.wait(3);
	System.out.println("TransactionDetails_" + RequestId + ".pdf");
	stepstatus = WebLibrary.getLatestFileName("TransactionDetails_" + RequestId + ".pdf");
	if(stepstatus==true){
		ReportLibrary.test.log(LogStatus.PASS, "Transaction details downloaded successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
	}else{
		ReportLibrary.test.log(LogStatus.FAIL, "Transaction details downloaded failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
	}
	//To Replace signer, remove signer, view signer details and Resend Notification
	WebLibrary.setExplicitWait(Request.MoreBtn, driver, 40);
	Request.clickonMoreBtn();
	Request.clickonReplace();
	WebLibrary.setExplicitWait(Request.ReplaceSignerWindow, driver, 40);
	driver.findElement(By.xpath("//form[@id='replaceForm']/div[2]/table/tbody/tr/td[2][contains(text(),'"+DataLibrary.getdata("Signer1Email")+"')]/following-sibling::td[3]/input[@name='replacename']")).click();
	driver.switchTo().activeElement().sendKeys(DataLibrary.getdata("ReplaceSignerEmail"));
	WebLibrary.setExplicitWait(Request.ReplaceIcon, driver, 40);
	Request.clickonReplaceIcon();
	WebLibrary.wait(2);
	boolean ReplaceSigner = WebLibrary.verifyTextPresent("User(s) are Replaced Successfully");
	if(ReplaceSigner == true){
		ReportLibrary.test.log(LogStatus.PASS, "Signer got replaced successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
	}else{
		ReportLibrary.test.log(LogStatus.FAIL, "Signer replace failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
	}
	Request.clickonCloseIcon();
	WebLibrary.setExplicitWait(Request.MoreBtn, driver, 40);
	
	Request.clickonMoreBtn();
	Request.clickonRemoveOption();
	WebLibrary.setExplicitWait(Request.RemoveSignerWindow, driver, 40);
	driver.findElement(By.xpath("//form[@id='removeSignerForm']/div/table/tbody/tr/td[2][contains(text(),'"+DataLibrary.getdata("Signer2Email")+"')]/following-sibling::td[2]/input")).click();
	Request.clickonRemoveIcon();
	WebLibrary.wait(2);
	boolean RemoveSigner = WebLibrary.verifyTextPresent("Signer removed successfully");
	if(RemoveSigner == true){
		ReportLibrary.test.log(LogStatus.PASS, "Signer got removed successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
	}else{
		ReportLibrary.test.log(LogStatus.FAIL, "Signer remove failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
	}
	
	Request.clickonCloseIcon();
	WebLibrary.setExplicitWait(Request.MoreBtn, driver, 40);
	Request.clickonMoreBtn();
	Request.clickonSignerDetails();
	WebLibrary.setExplicitWait(Request.SignerDetailsPopup, driver, 20);
	if(Request.SignerDetailsPopup.isDisplayed()){
		ReportLibrary.test.log(LogStatus.PASS, "Signer Details popup got displayed successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
	}else{
		ReportLibrary.test.log(LogStatus.FAIL, "Unable to view Signer Details popup"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
	}
	Request.clickonCloseIcon();
	WebLibrary.setExplicitWait(Request.MoreBtn, driver, 40);
	Request.clickonMoreBtn();
	Request.clickonResend();
	WebLibrary.setExplicitWait(Request.OkBtn, driver, 20);
	Request.clickonOkBtn();
	WebLibrary.wait(3);
	boolean ResendNotification = WebLibrary.verifyTextPresent("Notification has been resent successfully");
	if(ResendNotification == true){
		ReportLibrary.test.log(LogStatus.PASS, "Request notification got resent successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
	}else{
		ReportLibrary.test.log(LogStatus.FAIL, "Request resend notification failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
	}
	

	Request.clickonArchivedTab();
	WebLibrary.setExplicitWait(Request.ArchivedRequestPage, driver, 60);	
	WebLibrary.wait(3);
	driver.findElement(By.xpath("//table/tbody/tr/td[2]/div[contains(text(),'"+DataLibrary.getdata("RequestTitle")+"')]")).click();
	WebLibrary.setExplicitWait(Request.DownloadMainDocumentBtn, driver, 30);
	WebLibrary.removeDownloadFiles();
	Request.clickonDownloadMainDocumentBtn();
	WebLibrary.wait(5);
	stepstatus = WebLibrary.getLatestFileName(RequestDocumentName + ".pdf");
	if(stepstatus==true){
		ReportLibrary.test.log(LogStatus.PASS, "Downloaded Main document successfully from Main Document Tab" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
	}else{
		ReportLibrary.test.log(LogStatus.FAIL, "Downloaded Main document failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
	}
	WebLibrary.removeDownloadFiles();
	driver.navigate().refresh();
	WebLibrary.setExplicitWait(Request.DownloadMainDocumentBtn, driver, 30);
	Request.clickonDownloadTransactionDocumentBtn();
	WebLibrary.wait(5);
	stepstatus = WebLibrary.getLatestFileName("TransactionDetails_" + RequestId + ".pdf");
	if(stepstatus==true){
		ReportLibrary.test.log(LogStatus.PASS, "Downloaded Transaction document successfully from Main Document Tab" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
	}else{
		ReportLibrary.test.log(LogStatus.FAIL, "Downloaded Transaction document failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
	}
	
	Request.clickonSupportingDocumentsTab();
	WebLibrary.setExplicitWait(Request.SupportingDocumentsPage, driver, 30);
	WebLibrary.removeDownloadFiles();
	String DocumentName = driver.findElement(By.xpath("//table/tbody/tr/td[2]")).getText();
	Request.clickonDownloadDocumentIcon();
	WebLibrary.wait(3);
	stepstatus = WebLibrary.getLatestFileName(DocumentName);
	if(stepstatus==true){
		ReportLibrary.test.log(LogStatus.PASS, "Supporting document downloaded successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
	}else{
		ReportLibrary.test.log(LogStatus.FAIL, "Supporting document downloaded failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
	}
	WebLibrary.removeDownloadFiles();
	Request.clickonDownloadAllIcon();
	WebLibrary.wait(3);
	stepstatus = WebLibrary.getLatestFileName("SupportingDocs");
	if(stepstatus==true){
		ReportLibrary.test.log(LogStatus.PASS, "Supporting document downloaded successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
	}else{
		ReportLibrary.test.log(LogStatus.FAIL, "Supporting document downloaded failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
	}
	
	Request.clickonTransactionDetailsTab();
	WebLibrary.setExplicitWait(Request.TransactionDetailsPage, driver, 30);
	if(Request.TransactionDetailsPage.isDisplayed()){
		ReportLibrary.test.log(LogStatus.PASS, "Transaction Details Page got displayed successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
	}else{
		ReportLibrary.test.log(LogStatus.FAIL, "Unable to view Transaction Details Page"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
	}
	
	Request.clickonCommentsTab();
	WebLibrary.setExplicitWait(Request.CommentsPage, driver, 30);
	if(Request.CommentsPage.isDisplayed()){
		ReportLibrary.test.log(LogStatus.PASS, "Comments Page got displayed successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
	}else{
		ReportLibrary.test.log(LogStatus.FAIL, "Unable to view Comments"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
	}
	
	Request.clickonHistoryTab();
	WebLibrary.setExplicitWait(Request.HistoryPage, driver, 30);
	if(Request.HistoryPage.isDisplayed()){
		ReportLibrary.test.log(LogStatus.PASS, "History Page got displayed successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
	}else{
		ReportLibrary.test.log(LogStatus.FAIL, "Unable to view History details"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
	}
	
	Request.clickonApprovalOrderTab();
	WebLibrary.setExplicitWait(Request.ApprovalOrderPage, driver, 30);
	if(Request.ApprovalOrderPage.isDisplayed()){
		ReportLibrary.test.log(LogStatus.PASS, "Approval Order Page got displayed successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
	}else{
		ReportLibrary.test.log(LogStatus.FAIL, "Unable to view Approval Order details"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
	}
	Request.clickonViewSignerDetailsIcon();
	WebLibrary.setExplicitWait(Request.ViewSignerDetailsPopup, driver, 30);
	if(Request.ViewSignerDetailsPopup.isDisplayed()){
		ReportLibrary.test.log(LogStatus.PASS, "View Signer Details Popup got displayed successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
	}else{
		ReportLibrary.test.log(LogStatus.FAIL, "Unable to view Signer Details"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
	}
	Request.clickonCloseIcon();		
	homepage.clickonLogo();
	homepage.clickonArchivedItems();
	WebLibrary.setExplicitWait(Request.ArchivedRequestPage, driver, 60);	
	Request.clickonShare();
	boolean ShareValidation = WebLibrary.verifyTextPresent("Please select atleast one request");
	if(ShareValidation == true){
		ReportLibrary.test.log(LogStatus.PASS, "Share validation successfull when no requests has been selected" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
	}else{
		ReportLibrary.test.log(LogStatus.FAIL, "Share validation failed when no requests has been selected"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
	}
	Request.clickonOkBtn();
	String Name = HomePage.getCurrentCompanyName(); //To get Company Name
	String Name1 = Name.replace("(", "( ");
	String CompanyName = Name1.replace(")", " )");
	System.out.println(CompanyName);
	WebElement Checkbox = driver.findElement(By.xpath("//table/tbody/tr/td[2]/div[contains(text(),'"+DataLibrary.getdata("RequestTitle")+"')]/parent::td/preceding-sibling::td[1]/div/input[@type='checkbox']"));
	//Actions action1 = new Actions(driver);
	action1.moveToElement(Checkbox).click().build().perform();
	Request.clickonShare();
	if(!driver.findElements(By.xpath("//table[@id='userDetailsTableId']/tbody/tr/td[3]/div[contains(text(),'"+DataLibrary.getdata("Admin")+"')]")).isEmpty())
	{
		driver.findElement(By.xpath("//table[@id='userDetailsTableId']/tbody/tr/td[3]/div[contains(text(),'"+DataLibrary.getdata("Admin")+"')]/parent::td/preceding-sibling::td[2]/input[@type='checkbox']")).click();
	}else{
		Request.clickonCloseIcon();
		homepage.clickonHeadProfile();
		homepage.clickonAdminLink();
		admin.clickonCompanyMenu();
		admin.clickonUsersMenu();
		users.clickonAddAdminIcon();
		WebLibrary.wait(2);
		users.setEmailAddress(DataLibrary.getdata("Admin"));
		users.setFirstName(DataLibrary.getdata("Signer1FirstName"));
		users.setLastName(DataLibrary.getdata("Signer1LastName"));
		users.clickonSaveBtn();
		WebLibrary.wait(5);
		boolean AdminCreation = WebLibrary.verifyTextPresent("Admin Created Successfully");
		if(AdminCreation == true){
			ReportLibrary.test.log(LogStatus.PASS, "Admin created successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Admin creation failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		driver.navigate().refresh();
		homepage.clickonLogo();
		WebLibrary.wait(3);
		homepage.clickonArchivedItems();
		WebLibrary.setExplicitWait(Request.ArchivedRequestPage, driver, 60);
		driver.findElement(By.xpath("//table/tbody/tr/td[2]/div[contains(text(),'"+DataLibrary.getdata("RequestTitle")+"')]/parent::td/preceding-sibling::td[1]/div/input[@type='checkbox']")).click();
		Request.clickonShare();
		driver.findElement(By.xpath("//table[@id='userDetailsTableId']/tbody/tr/td[3]/div[contains(text(),'"+DataLibrary.getdata("Admin")+"')]/parent::td/preceding-sibling::td[2]/input[@type='checkbox']")).click();
	}
	Request.clickonShareAccessBtn();
	Request.clickonOkBtn();
	WebLibrary.wait(3);
	boolean ShareValidation1 = WebLibrary.verifyTextPresent("Access shared successfully");
	if(ShareValidation1 == true){
		ReportLibrary.test.log(LogStatus.PASS, "'Access shared successfully' validation message got displayed" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
	}else{
		ReportLibrary.test.log(LogStatus.FAIL, "'Access shared successfully' validation message not displayed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
	}
	Request.clickonArchivedTab();
	WebLibrary.setExplicitWait(Request.ArchivedRequestPage, driver, 60);	
	WebLibrary.wait(3);
	WebElement documentPreview2 = driver.findElement(By.xpath("//table/tbody/tr/td[2]/div[contains(text(),'"+DataLibrary.getdata("RequestTitle")+"')]/parent::td/preceding-sibling::td[1]/div/span[@class='fa fa-eye']"));
	action1.moveToElement(documentPreview2).click().perform();
	WebLibrary.wait(3);
	WebLibrary.setExplicitWait(Request.MoreBtn, driver, 40);
	Request.clickonMoreBtn();
	Request.clickonCopy();
	WebLibrary.setExplicitWait(Request.OkBtn, driver, 20);
	Request.clickonOkBtn();
	WebLibrary.wait(3);
	boolean RequestCopy = WebLibrary.verifyTextPresent("Request Copied Successfully");
	if(RequestCopy == true){
		ReportLibrary.test.log(LogStatus.PASS, "Request Copied successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
	}else{
		ReportLibrary.test.log(LogStatus.FAIL, "Request Copy failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
	}
	
	homepage.clickonHeadProfile();
	homepage.clickonSignOutLink();
	// To Verify whether Request has been shared to Admin.  
	loginpage.setUsername(DataLibrary.getdata("Admin"));
	loginpage.setPassword(DataLibrary.getdata("AdminPassword"));
	loginpage.clickonLogin();
	String AdminsCurrentCompany = HomePage.getCurrentCompanyName();
	//String RequestTitle = "To Verify Edit, Update, Send Later, Cancel Button, Copy, Download, Share and Delete Request{2334}";
	if(AdminsCurrentCompany.equals(CompanyName)){
		homepage.clickonArchivedItems();
		WebLibrary.setExplicitWait(Request.ArchivedRequestPage, driver, 60);
		WebLibrary.wait(3);
		if(driver.findElement(By.xpath("//table/tbody/tr/td[2]/div[contains(text(),'"+DataLibrary.getdata("RequestTitle")+"')]")).isDisplayed()){
			ReportLibrary.test.log(LogStatus.PASS, "Request shared to Admin successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Request shared to Admin failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
	}else{
		homepage.clickonMenuBar();
		driver.findElement(By.xpath("//div[@class='user-name']/ul/li/ul/li[@title='"+CompanyName+"']")).click();
		WebLibrary.wait(3);
		homepage.clickonArchivedItems();
		WebLibrary.setExplicitWait(Request.ArchivedRequestPage, driver, 60);
		WebLibrary.wait(3);
		if(driver.findElement(By.xpath("//table/tbody/tr/td[2]/div[contains(text(),'"+DataLibrary.getdata("RequestTitle")+"')]")).isDisplayed()){
			ReportLibrary.test.log(LogStatus.PASS, "Request shared to Admin successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Request shared to Admin failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
	}
	WebLibrary.wait(3);
	WebElement documentPreview3 = driver.findElement(By.xpath("//table/tbody/tr/td[2]/div[contains(text(),'"+DataLibrary.getdata("RequestTitle")+"')]/parent::td/preceding-sibling::td[1]/div/span[@class='fa fa-eye']"));
	action1.moveToElement(documentPreview3).click().perform();
	WebLibrary.wait(3);
	WebLibrary.setExplicitWait(Request.MoreBtn, driver, 40);
	Request.clickonMoreBtn();
	Request.clickonVoid();
	WebLibrary.setExplicitWait(Request.OkBtn, driver, 20);
	Request.clickonOkBtn();
	WebLibrary.wait(3);
	boolean RequestVoid = WebLibrary.verifyTextPresent("Request has been voided Successfully");
	if(RequestVoid == true){
		ReportLibrary.test.log(LogStatus.PASS, "Request voided successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
	}else{
		ReportLibrary.test.log(LogStatus.FAIL, "Request void failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
	}
}catch (Exception e) 
{
	WebLibrary.wait(10);
	ReportLibrary.test.log(LogStatus.FAIL, "Failed to execute My Signed Items Test case"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
}
}


@Test(testName="To verify all actions of In-Person Signing")
public void ToVerifyAllActionsOfInPersonSigning() throws Exception
{
	try{
		LoginPage loginpage = new LoginPage(driver);
		HomePage homepage = new HomePage(driver);
		CreateRequestPage CreateRequest = new CreateRequestPage(driver);
		CreateTemplatePage CreateTemplate = new CreateTemplatePage(driver);
		CreateInPersonRequest InPerson = new CreateInPersonRequest(driver);
		CompanySettingsPage settings = new CompanySettingsPage(driver);
		RequestPage Request = new RequestPage(driver);
		MyApprovalPage myapproval = new MyApprovalPage(driver);
		AdminHomePage admin = new AdminHomePage(driver);
		UsersPage users = new UsersPage(driver);
		loginpage.setUsername(DataLibrary.getdata("Username"));
		loginpage.setPassword(DataLibrary.getdata("Password"));
		loginpage.clickonLogin();
		/*homepage.clickonInPersonSigning();
		WebLibrary.setExplicitWait(homepage.InPersonSigningPage, driver, 40);*/
		homepage.clickonCreateMenu();
		homepage.clickonCreateInPersonRequest();
		boolean InPersonTemplate = WebLibrary.verifyTextPresent("No Template Exists for In Person Request creation");
		if(InPersonTemplate == true){
			homepage.clickonCreateMenu();
			homepage.clickonCreateTemplateMenu();
			CreateTemplate.setTemplateName(DataLibrary.getdata("TemplateName"));
			CreateTemplate.setAcceptanceMode(DataLibrary.getdata("AcceptanceMode"));
			CreateTemplate.clickonMainDocumentBtn();
			WebLibrary.wait(3);
			WebLibrary.RobotKeysFileUpload(AttachmentFiles + "\\Approval.docx");
			WebLibrary.setExplicitWait(CreateTemplate.DocumentsList, driver, 60);
			CreateTemplate.clickonAddSignerIcon();
			CreateTemplate.clickonAddSignerIcon();
			CreateTemplate.clickonNextBtn();
			
			WebLibrary.setExplicitWait(CreateTemplate.DocumentSetupSaveBtn, driver, 20);
			
			CreateTemplate.clickonSignature();
			Actions action = new Actions(driver);
			action.moveToElement(driver.findElement(By.xpath("//img[@id='documentPageImage1']"))).build().perform();	
			WebElement target = driver.findElement(By.xpath("//img[@id='documentPageImage1']"));
			int xcord = 99;
			int ycord = 428;
			action.moveToElement(target, xcord, ycord).click().build().perform();
			System.out.println("Signature added successfully");
			CreateTemplate.clickonInitial();
			action.moveToElement(driver.findElement(By.xpath("//img[@id='documentPageImage1']"))).build().perform();
			int xcord1 = 304;
			action.moveToElement(target, xcord1, ycord).click().build().perform();
			System.out.println("Initial added successfully");
			CreateTemplate.clickonDate();
			action.moveToElement(driver.findElement(By.xpath("//img[@id='documentPageImage1']"))).build().perform();
			int xcord2 = 514;
			action.moveToElement(target, xcord2, ycord).click().build().perform();
			System.out.println("Date added successfully");
			
			//To Add Custom fields for Signer 2
			CreateTemplate.setSignerSelection("Signer2");
			CreateTemplate.clickonSignature();
			action.moveToElement(driver.findElement(By.xpath("//img[@id='documentPageImage1']"))).build().perform();
			int ycord1 = 542;
			action.moveToElement(target, xcord, ycord1).click().build().perform();
			WebLibrary.setExplicitWait(CreateTemplate.Initial, driver, 60);
			CreateTemplate.clickonInitial();
			action.moveToElement(driver.findElement(By.xpath("//img[@id='documentPageImage1']"))).build().perform();
			action.moveToElement(target, xcord1, ycord1).click().build().perform();
			CreateTemplate.clickonDate();
			action.moveToElement(driver.findElement(By.xpath("//img[@id='documentPageImage1']"))).build().perform();
			action.moveToElement(target, xcord2, ycord1).click().build().perform();
		
			//To Add Custom fields for Signer 3
			CreateTemplate.setSignerSelection("Signer3");
			WebLibrary.setExplicitWait(CreateTemplate.Signature, driver, 60);
			CreateTemplate.clickonSignature();
			action.moveToElement(driver.findElement(By.xpath("//img[@id='documentPageImage1']"))).build().perform();
			int ycord2 = 656;
			action.moveToElement(target, xcord, ycord2).click().build().perform();
			WebLibrary.setExplicitWait(CreateTemplate.Initial, driver, 60);
			CreateTemplate.clickonInitial();
			action.moveToElement(driver.findElement(By.xpath("//img[@id='documentPageImage1']"))).build().perform();
			action.moveToElement(target, xcord1, ycord2).click().build().perform();
			CreateTemplate.clickonDate();
			action.moveToElement(driver.findElement(By.xpath("//img[@id='documentPageImage1']"))).build().perform();
			action.moveToElement(target, xcord2, ycord2).click().build().perform();
			WebLibrary.wait(3);
			CreateTemplate.clickonDocumentSetupActivateBtn();
			WebLibrary.wait(3);
			boolean TemplateStatus = WebLibrary.verifyTextPresent("Template activated successfully");
			if(TemplateStatus == true){
				ReportLibrary.test.log(LogStatus.PASS, "InPerson Template created and activated successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
			}else{
				ReportLibrary.test.log(LogStatus.FAIL, "InPerson Template activation failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
			}
			WebLibrary.wait(2);
			homepage.clickonTemplatesMenu();
			String TemplateName =driver.findElement(By.xpath("//table/tbody/tr/td[2]/div[contains(text(),'"+DataLibrary.getdata("TemplateName")+"')]")).getText();
			String ReplaceTemplateName = TemplateName.replace('{', '(');
			String LatestTemplateName = ReplaceTemplateName.replace('}', ')');
			System.out.println(LatestTemplateName);
			//InPerson Request creation
			homepage.clickonCreateMenu();
			homepage.clickonCreateInPersonRequest();
			InPerson.setRequestTitle(DataLibrary.getdata("RequestTitle"));
			InPerson.setSelectTemplate(LatestTemplateName);
			WebLibrary.setExplicitWait(InPerson.CreateRequestBtn, driver, 30);
		}else{
			InPerson.setRequestTitle(DataLibrary.getdata("RequestTitle"));
			driver.findElement(By.xpath("//select[@id='newHierarchy']/option[2]")).click();
		}
		WebLibrary.wait(3);
		InPerson.clickonCreateRequestBtn();
		WebLibrary.wait(2);
		boolean InPersonRequestStatus = WebLibrary.verifyTextPresent("In-Person Request created successfully");
		if(InPersonRequestStatus == true){
			ReportLibrary.test.log(LogStatus.PASS, "In-Person Request sent for approval successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "In-Person Request sent for approval failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		
		driver.findElement(By.xpath("//table/tbody/tr/td[2]/div[contains(text(),'"+DataLibrary.getdata("RequestTitle")+"')]")).click();
		WebLibrary.setExplicitWait(Request.MainDocumentRequestId, driver, 40);
		String RequestId = Request.getMainDocumentRequestId();
		System.out.println("Request Id is " +RequestId);
		homepage.clickonLogo();
		homepage.clickonInPersonSigning();
		WebLibrary.setExplicitWait(homepage.InPersonSigningPage, driver, 60);
		WebLibrary.wait(3);
		WebElement documentPreview = driver.findElement(By.xpath("//table/tbody/tr/td[2]/div[contains(text(),'"+DataLibrary.getdata("RequestTitle")+"')]/parent::td/preceding-sibling::td[1]/div/span[@class='fa fa-eye']"));
		Actions action1 = new Actions(driver);
		action1.moveToElement(documentPreview).click().perform();
		WebLibrary.wait(3);
		WebLibrary.setExplicitWait(Request.MoreBtn, driver, 40);
		String RequestDocumentName = Request.getDocumentName();//To Get Request Document Name
		System.out.println("Document Name is" +RequestDocumentName);
		Request.clickonPrintBtn();
		WebLibrary.setExplicitWait(Request.OkBtn, driver, 20);
		Request.clickonOkBtn();
		WebLibrary.setExplicitWait(myapproval.ChooseTextFontSizePopup, driver, 60);
		myapproval.setFontSize("10");
		myapproval.clickonProceedBtn();
		WebLibrary.wait(5);
		stepstatus = WebLibrary.isWindowExists("sutisign/requestMainAction_requestDocumentsPrint.action?requestId="+ RequestId, driver);
		if(stepstatus==true){
			WebLibrary.wait(3);
			ReportLibrary.test.log(LogStatus.PASS, "Document printed successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Document print failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		driver.close();
		WebLibrary.SwitchtoWindow("sutisign/commonDisplay_dashBoardRequestSearch.action", driver);
		WebLibrary.setExplicitWait(Request.MoreBtn, driver, 20);
		WebLibrary.removeDownloadFiles();
		Request.clickonDownloadBtn();
		WebLibrary.setExplicitWait(myapproval.ChooseTextFontSizePopup, driver, 60);
		myapproval.setFontSize(DataLibrary.getdata("FontSize"));
		myapproval.clickonProceedBtn();
		WebLibrary.wait(3);
		stepstatus = WebLibrary.getLatestFileName(RequestDocumentName + ".pdf");
		if(stepstatus==true){
			ReportLibrary.test.log(LogStatus.PASS, "Document downloaded successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Document downloaded failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		WebLibrary.wait(3);
		WebLibrary.removeDownloadFiles();
		Request.clickonDownloadTransBtn();
		WebLibrary.wait(3);
		System.out.println("TransactionDetails_" + RequestId + ".pdf");
		stepstatus = WebLibrary.getLatestFileName("TransactionDetails_" + RequestId + ".pdf");
		if(stepstatus==true){
			ReportLibrary.test.log(LogStatus.PASS, "Transaction details downloaded successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Transaction details downloaded failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		WebLibrary.wait(2);
		driver.findElement(By.xpath("//table/tbody/tr/td[2]/div[contains(text(),'"+DataLibrary.getdata("RequestTitle")+"')]")).click();
		WebLibrary.setExplicitWait(Request.DownloadMainDocumentBtn, driver, 30);
		WebLibrary.removeDownloadFiles();
		Request.clickonDownloadMainDocumentBtn();
		WebLibrary.wait(5);
		stepstatus = WebLibrary.getLatestFileName(RequestDocumentName + ".pdf");
		if(stepstatus==true){
			ReportLibrary.test.log(LogStatus.PASS, "Downloaded Main document successfully from Main Document Tab" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Downloaded Main document failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		WebLibrary.removeDownloadFiles();
		driver.navigate().refresh();
		WebLibrary.setExplicitWait(Request.DownloadMainDocumentBtn, driver, 30);
		Request.clickonDownloadTransactionDocumentBtn();
		WebLibrary.wait(5);
		stepstatus = WebLibrary.getLatestFileName("TransactionDetails_" + RequestId + ".pdf");
		if(stepstatus==true){
			ReportLibrary.test.log(LogStatus.PASS, "Downloaded Transaction document successfully from Main Document Tab" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Downloaded Transaction document failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		
		
		Request.clickonTransactionDetailsTab();
		WebLibrary.setExplicitWait(Request.TransactionDetailsPage, driver, 30);
		if(Request.TransactionDetailsPage.isDisplayed()){
			ReportLibrary.test.log(LogStatus.PASS, "Transaction Details Page got displayed successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Unable to view Transaction Details Page"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
	
		Request.clickonHistoryTab();
		WebLibrary.setExplicitWait(Request.HistoryPage, driver, 30);
		if(Request.HistoryPage.isDisplayed()){
			ReportLibrary.test.log(LogStatus.PASS, "History Page got displayed successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Unable to view History details"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		homepage.clickonLogo();
		homepage.clickonInPersonSigning();
		WebLibrary.setExplicitWait(homepage.InPersonSigningPage, driver, 40);
		
		Request.clickonShare();
		boolean ShareValidation = WebLibrary.verifyTextPresent("Please select atleast one request");
		if(ShareValidation == true){
			ReportLibrary.test.log(LogStatus.PASS, "Share validation successfull when no requests has been selected" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Share validation failed when no requests has been selected"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		Request.clickonOkBtn();
		String Name = HomePage.getCurrentCompanyName(); //To get Company Name
		String Name1 = Name.replace("(", "( ");
		String CompanyName = Name1.replace(")", " )");
		System.out.println(CompanyName);
		WebElement Checkbox = driver.findElement(By.xpath("//table/tbody/tr/td[2]/div[contains(text(),'"+DataLibrary.getdata("RequestTitle")+"')]/parent::td/preceding-sibling::td[1]/div/input[@type='checkbox']"));
		action1.moveToElement(Checkbox).click().build().perform();
		Request.clickonShare();
		if(!driver.findElements(By.xpath("//table[@id='userDetailsTableId']/tbody/tr/td[3]/div[contains(text(),'"+DataLibrary.getdata("Admin")+"')]")).isEmpty())
		{
			driver.findElement(By.xpath("//table[@id='userDetailsTableId']/tbody/tr/td[3]/div[contains(text(),'"+DataLibrary.getdata("Admin")+"')]/parent::td/preceding-sibling::td[2]/input[@type='checkbox']")).click();
		}else{
			Request.clickonCloseIcon();
			homepage.clickonHeadProfile();
			homepage.clickonAdminLink();
			admin.clickonCompanyMenu();
			admin.clickonUsersMenu();
			users.clickonAddAdminIcon();
			WebLibrary.wait(2);
			users.setEmailAddress(DataLibrary.getdata("Admin"));
			users.setFirstName(DataLibrary.getdata("AdminFirstName"));
			users.setLastName(DataLibrary.getdata("AdminLastName"));
			users.clickonSaveBtn();
			WebLibrary.wait(5);
			boolean AdminCreation = WebLibrary.verifyTextPresent("Admin Created Successfully");
			if(AdminCreation == true){
				ReportLibrary.test.log(LogStatus.PASS, "Admin created successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
			}else{
				ReportLibrary.test.log(LogStatus.FAIL, "Admin creation failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
			}
			driver.navigate().refresh();
			homepage.clickonLogo();
			homepage.clickonRequestMenu();
			WebLibrary.wait(3);
			driver.findElement(By.xpath("//table/tbody/tr/td[2]/div[contains(text(),'"+DataLibrary.getdata("RequestTitle")+"')]/parent::td/preceding-sibling::td[1]/div/input[@type='checkbox']")).click();
			Request.clickonShare();
			driver.findElement(By.xpath("//table[@id='userDetailsTableId']/tbody/tr/td[3]/div[contains(text(),'"+DataLibrary.getdata("Admin")+"')]/parent::td/preceding-sibling::td[2]/input[@type='checkbox']")).click();
		}
		Request.clickonShareAccessBtn();
		Request.clickonOkBtn();
		WebLibrary.wait(3);
		boolean ShareValidation1 = WebLibrary.verifyTextPresent("Access shared successfully");
		if(ShareValidation1 == true){
			ReportLibrary.test.log(LogStatus.PASS, "'Access shared successfully' validation message got displayed" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "'Access shared successfully' validation message not displayed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		homepage.clickonHeadProfile();
		homepage.clickonSignOutLink();
		// To Verify whether Request has been shared to Admin.  
		loginpage.setUsername(DataLibrary.getdata("Admin"));
		loginpage.setPassword(DataLibrary.getdata("AdminPassword"));
		loginpage.clickonLogin();
		String AdminsCurrentCompany = HomePage.getCurrentCompanyName();
		if(AdminsCurrentCompany.equals(CompanyName)){
			homepage.clickonInPersonSigning();
			WebLibrary.setExplicitWait(homepage.InPersonSigningPage, driver, 40);
			if(driver.findElement(By.xpath("//table/tbody/tr/td[2]/div[contains(text(),'"+DataLibrary.getdata("RequestTitle")+"')]")).isDisplayed()){
				ReportLibrary.test.log(LogStatus.PASS, "In-Person Request shared to Admin successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
			}else{
				ReportLibrary.test.log(LogStatus.FAIL, "In-Person Request shared to Admin failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
			}
		}else{
			homepage.clickonMenuBar();
			driver.findElement(By.xpath("//div[@class='user-name']/ul/li/ul/li[@title='"+CompanyName+"']")).click();
			WebLibrary.wait(3);
			homepage.clickonInPersonSigning();
			WebLibrary.setExplicitWait(homepage.InPersonSigningPage, driver, 40);
			if(driver.findElement(By.xpath("//table/tbody/tr/td[2]/div[contains(text(),'"+DataLibrary.getdata("RequestTitle")+"')]")).isDisplayed()){
				ReportLibrary.test.log(LogStatus.PASS, "In-Person Request shared to Admin successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
			}else{
				ReportLibrary.test.log(LogStatus.FAIL, "In-Person Request shared to Admin failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
			}
		}

		WebElement documentPreview1 = driver.findElement(By.xpath("//table/tbody/tr/td[2]/div[contains(text(),'"+DataLibrary.getdata("RequestTitle")+"')]/parent::td/preceding-sibling::td[1]/div/span[@class='fa fa-eye']"));
		action1.moveToElement(documentPreview1).click().perform();
		WebLibrary.wait(3);
		WebLibrary.setExplicitWait(Request.MoreBtn, driver, 40);
		Request.clickonMoreBtn();
		Request.clickonArchive();
		Request.clickonOkBtn();
		WebLibrary.wait(2);
		boolean ArchiveRequest = WebLibrary.verifyTextPresent("Successfully sent to Archived items");
		if(ArchiveRequest == true){
			ReportLibrary.test.log(LogStatus.PASS, "Archived request validation got displayed successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Archived request validation not displayed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		Request.clickonInPersonRequestTab();
		WebLibrary.setExplicitWait(homepage.InPersonSigningPage, driver, 40);
		WebElement documentPreview2 = driver.findElement(By.xpath("//table/tbody/tr/td[2]/div[contains(text(),'"+DataLibrary.getdata("RequestTitle")+"')]/parent::td/preceding-sibling::td[1]/div/span[@class='fa fa-eye']"));
		action1.moveToElement(documentPreview2).click().perform();
		WebLibrary.wait(3);
		WebLibrary.setExplicitWait(Request.MoreBtn, driver, 40);
		Request.clickonMoreBtn();
		Request.clickonVoid();
		WebLibrary.setExplicitWait(Request.OkBtn, driver, 20);
		Request.clickonOkBtn();
		WebLibrary.wait(3);
		boolean RequestVoid = WebLibrary.verifyTextPresent("Request has been voided Successfully");
		if(RequestVoid == true){
			ReportLibrary.test.log(LogStatus.PASS, "Request voided successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Request void failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		
	}catch (Exception e) 
	{
		WebLibrary.wait(10);
		ReportLibrary.test.log(LogStatus.FAIL, "Failed to execute InPerson Signing Test case"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
	}
}
}
	