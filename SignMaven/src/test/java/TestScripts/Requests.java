package TestScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import ApplicationPages.AdminHomePage;
import ApplicationPages.CreateRequestPage;
import ApplicationPages.HomePage;
import ApplicationPages.LoginPage;
import ApplicationPages.MyApprovalPage;
import ApplicationPages.RequestPage;
import ApplicationPages.UsersPage;
import FrameworkLibrary.BaseClass;
import FrameworkLibrary.DataLibrary;
import FrameworkLibrary.ReportLibrary;
import FrameworkLibrary.WebLibrary;

public class Requests extends BaseClass{

	boolean stepstatus;
	@Test(testName="Template Creation, Updation, Activation, Deactivation, Copying and Deleting")
	public void RequestEditUpdateSendLater() throws Exception
	{
		LoginPage loginpage = new LoginPage(driver);
		HomePage homepage = new HomePage(driver);
		CreateRequestPage CreateRequest = new CreateRequestPage(driver);
		RequestPage Request = new RequestPage(driver);
		MyApprovalPage myapproval = new MyApprovalPage(driver);
		AdminHomePage admin = new AdminHomePage(driver);
		UsersPage users = new UsersPage(driver);
		loginpage.setUsername(DataLibrary.getdata("Username"));
		loginpage.setPassword(DataLibrary.getdata("Password"));
		loginpage.clickonLogin();
		homepage.clickonCreateMenu();
		homepage.clickonCreateRequestMenu();
		CreateRequest.setRequestTitle(DataLibrary.getdata("RequestTitle"));
		CreateRequest.clickonMainDocumentBtn();
		WebLibrary.wait(3);
		Runtime.getRuntime().exec(AutoItPath + "\\Approval.exe");
		WebLibrary.setExplicitWait(CreateRequest.DocumentsList, driver, 30);
		CreateRequest.setSigner1Email(DataLibrary.getdata("Signer1Email"));
		CreateRequest.clickonSaveToDraft();
		boolean RequestStatus = WebLibrary.verifyTextPresent("Request Saved Successfully");
		if(RequestStatus==true){
			ReportLibrary.test.log(LogStatus.PASS, "Request created and saved to draft successfully");
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Request creation failed");
		}
		//To UPdate Request
		driver.findElement(By.xpath("//table/tbody/tr/td[2]/div[contains(text(),'"+DataLibrary.getdata("RequestTitle")+"')]")).click();
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
		CreateRequest.clickonDocumentSetupSaveToDraft();
		//To Verify Send Later button
		WebLibrary.wait(2);
		driver.findElement(By.xpath("//table/tbody/tr/td[2]/div[contains(text(),'"+DataLibrary.getdata("RequestTitle")+"')]")).click();
		WebLibrary.setExplicitWait(Request.SendLater, driver, 20);
		Request.clickonSendLater();
		WebLibrary.setExplicitWait(Request.AllRequestPage, driver, 20);
		boolean RequestSendLater = WebLibrary.verifyTextPresent("Request updated successfully");
		if(RequestSendLater == true){
			ReportLibrary.test.log(LogStatus.PASS, "Request Send Later is working successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Request Send Later button not working"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		// TO Verify Cancel button
		driver.findElement(By.xpath("//table/tbody/tr/td[2]/div[contains(text(),'"+DataLibrary.getdata("RequestTitle")+"')]")).click();
		WebLibrary.setExplicitWait(Request.SendLater, driver, 20);
		Request.clickonCancelBtn();
		WebLibrary.setExplicitWait(Request.AllRequestPage, driver, 20);
		if(Request.AllRequestPage.isDisplayed()){
			ReportLibrary.test.log(LogStatus.PASS, "Cancel button is working successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Cancel button is not working"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		// To verify Copy Request
		driver.findElement(By.xpath("//table/tbody/tr/td[2]/div[contains(text(),'"+DataLibrary.getdata("RequestTitle")+"')]")).click();
		WebLibrary.setExplicitWait(Request.SendLater, driver, 20);
		Request.clickonEditRequestCopyBtn();
		WebLibrary.setExplicitWait(Request.OkBtn, driver, 20);
		Request.clickonOkBtn();
		WebLibrary.setExplicitWait(Request.AllRequestPage, driver, 20);
		boolean RequestCopy = WebLibrary.verifyTextPresent("Request Copied Successfully");
		if(RequestCopy == true){
			ReportLibrary.test.log(LogStatus.PASS, "Request Copied successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Request Copy failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		//To verify delete Request
		driver.findElement(By.xpath("//table/tbody/tr/td[2]/div[contains(text(),'"+DataLibrary.getdata("RequestTitle")+"')]")).click();
		WebLibrary.setExplicitWait(Request.SendLater, driver, 20);
		Request.clickonDeleteRequestBtn();
		WebLibrary.setExplicitWait(Request.OkBtn, driver, 20);
		Request.clickonOkBtn();
		WebLibrary.setExplicitWait(Request.AllRequestPage, driver, 20);
		boolean RequestDelete = WebLibrary.verifyTextPresent("Request deleted successfully");
		if(RequestDelete == true){
			ReportLibrary.test.log(LogStatus.PASS, "Request deleted successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Request delete failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		//To Send Request for Approval
		
		driver.findElement(By.xpath("//table/tbody/tr/td[2]/div[contains(text(),'"+DataLibrary.getdata("RequestTitle")+"')]")).click();
		WebLibrary.setExplicitWait(Request.SendLater, driver, 20);
		Request.clickonNextBtn();
		WebLibrary.setExplicitWait(CreateRequest.DocumentSetupSaveBtn, driver, 20);
		Request.clickonSendNowBtn();
		boolean RequestSent = WebLibrary.verifyTextPresent("Request Sent Successfully");
		if(RequestSent == true){
			ReportLibrary.test.log(LogStatus.PASS, "Request created and sent for approval successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Request sending for approval failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}		
		homepage.clickonHeadProfile();
		homepage.clickonSignOutLink();	
		
		// Signer1 Approval Process
		loginpage.setUsername(DataLibrary.getdata("Signer1Email"));
		loginpage.setPassword(DataLibrary.getdata("Signer1Password"));
		loginpage.clickonLogin();
		homepage.clickonNeedToSign();
		WebLibrary.setExplicitWait(homepage.NeedToSignPage, driver, 60);
		driver.findElement(By.xpath("(//table)[2]/tbody/tr/td[2]/div[contains(text(),'"+DataLibrary.getdata("RequestTitle")+"')]")).click();
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
		//myapproval.clickonStartBtn();
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
		homepage.clickonHeadProfile();
		homepage.clickonSignOutLink();	
		
		// Signer2 Approval Process
		loginpage.setUsername(DataLibrary.getdata("Signer2Email"));
		loginpage.setPassword(DataLibrary.getdata("Signer2Password"));
		loginpage.clickonLogin();
		homepage.clickonNeedToSign();
		WebLibrary.setExplicitWait(homepage.NeedToSignPage, driver, 60);
		driver.findElement(By.xpath("(//table)[2]/tbody/tr/td[2]/div[contains(text(),'"+DataLibrary.getdata("RequestTitle")+"')]")).click();
		WebLibrary.setExplicitWait(myapproval.StartBtn, driver, 60);
		myapproval.clickonSignHere();
		if(driver.findElement(By.xpath("//div[@id='createSignContentDiv']")).isDisplayed()){
			myapproval.setTypeSignature(DataLibrary.getdata("Signer2FirstName"));
			myapproval.clickonTypeApplyBtn();
			myapproval.clickonAcceptOKBtn();
		}else{
			myapproval.clickonAcceptOKBtn();
		}
		myapproval.clickonInitialHere();
		if(driver.findElement(By.xpath("//div[@id='createSignContentDiv']")).isDisplayed()){
			myapproval.setTypeSignature(DataLibrary.getdata("Signer2LastName"));
			myapproval.clickonTypeApplyBtn();
			myapproval.clickonAcceptOKBtn();
		}else{
			myapproval.clickonAcceptOKBtn();
		}
		
		myapproval.clickonCalendarIcon1();
		WebLibrary.selectDate(DataLibrary.getdata("Date"));
		//myapproval.clickonStartBtn();
		myapproval.clickonFinishBtn();	
		myapproval.clickonAcceptOKBtn();
		WebLibrary.wait(2);	
		boolean Signer2ApprovalStatus = WebLibrary.verifyTextPresent("You have successfully completed the signing process for this document");
		if(Signer2ApprovalStatus == true){
			ReportLibrary.test.log(LogStatus.PASS, "Signer 2 : Request approval process done successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Signer 2 : Request approval process failed" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		myapproval.clickonBackBtn();
		homepage.clickonHeadProfile();
		homepage.clickonSignOutLink();
		//Login to Admin Account
		loginpage.setUsername(DataLibrary.getdata("Username"));
		loginpage.setPassword(DataLibrary.getdata("Password"));
		loginpage.clickonLogin();
		homepage.clickonRequestMenu();
		WebLibrary.setExplicitWait(Request.MoreBtn, driver, 20);
		String RequestApprovalStatus = driver.findElement(By.xpath("//table/tbody/tr/td[2]/div[contains(text(),'"+DataLibrary.getdata("RequestTitle")+"')]/parent::td/following-sibling::td[1]/div")).getText();
		if(RequestApprovalStatus != null && RequestApprovalStatus.trim().equalsIgnoreCase("Fully Signed")){
			ReportLibrary.test.log(LogStatus.PASS, "Request Approval Status is displaying as 'Fully Signed' in Admin account" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Request Approval Status is displaying wrong in Admin account"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		//To Verify Signer details popup
		WebElement documentPreview = driver.findElement(By.xpath("//table/tbody/tr/td[2]/div[contains(text(),'"+DataLibrary.getdata("RequestTitle")+"')]/parent::td/preceding-sibling::td[1]/div/span[@class='fa fa-eye']"));
		Actions action1 = new Actions(driver);
		action1.moveToElement(documentPreview).click().perform();
		WebLibrary.wait(3);
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
		//To verify download document
		WebLibrary.setExplicitWait(Request.MoreBtn, driver, 20);
		String RequestDocumentName = Request.getDocumentName();
		System.out.println("Document Name is" +RequestDocumentName);
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
		//To Verify Download Transaction button
		driver.findElement(By.xpath("//table/tbody/tr/td[2]/div[contains(text(),'"+DataLibrary.getdata("RequestTitle")+"')]")).click();
		WebLibrary.setExplicitWait(Request.MainDocumentRequestId, driver, 40);
		String RequestId = Request.getMainDocumentRequestId();
		System.out.println("Request Id is " +RequestId);
		homepage.clickonRequestMenu();
		WebLibrary.wait(3);
		WebElement documentPreview1 = driver.findElement(By.xpath("//table/tbody/tr/td[2]/div[contains(text(),'"+DataLibrary.getdata("RequestTitle")+"')]/parent::td/preceding-sibling::td[1]/div/span[@class='fa fa-eye']"));
		Actions action2 = new Actions(driver);
		action2.moveToElement(documentPreview1).click().perform();
		WebLibrary.wait(3);
		WebLibrary.setExplicitWait(Request.MoreBtn, driver, 20);
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
		//To Verify Print button
		Request.clickonPrintBtn();
		WebLibrary.setExplicitWait(Request.OkBtn, driver, 20);
		Request.clickonOkBtn();
		WebLibrary.setExplicitWait(myapproval.ChooseTextFontSizePopup, driver, 60);
		myapproval.setFontSize("10");
		myapproval.clickonProceedBtn();
		WebLibrary.wait(3);
		stepstatus = WebLibrary.isWindowExists("sutisign/requestMainAction_requestDocumentsPrint.action?requestId="+ RequestId, driver);
		if(stepstatus==true){
			WebLibrary.wait(3);
			ReportLibrary.test.log(LogStatus.PASS, "Document printed successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Document print failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		driver.close();
		WebLibrary.SwitchtoWindow("sutisign/commonDisplay_dashBoardRequestSearch.action", driver);
		//To verify Share Request functionality
		WebLibrary.setExplicitWait(Request.Share, driver, 20);
		Request.clickonShare();
		System.out.println(driver.findElement(By.xpath("//div[@class='modal-content']/div[2]/div")).getText());
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
		String RequestTitle = driver.findElement(By.xpath("//table/tbody/tr/td[2]/div")).getText();
		System.out.println(RequestTitle);
		WebElement checkbox = driver.findElement(By.xpath("(//input[@type='checkbox'])[3]"));
		Actions action3 = new Actions(driver);
		action3.moveToElement(checkbox).click().build().perform();
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
			action3.moveToElement(checkbox).click().build().perform();
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
		//String RequestTitle = "To Verify Edit, Update, Send Later, Cancel Button, Copy, Download, Share and Delete Request{2334}";
		if(AdminsCurrentCompany.equals(CompanyName)){
			homepage.clickonRequestMenu();
			WebLibrary.wait(3);
			if(driver.findElement(By.xpath("//table/tbody/tr/td[2]/div[contains(text(),'"+RequestTitle+"')]")).isDisplayed()){
				ReportLibrary.test.log(LogStatus.PASS, "Request shared to Admin successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
			}else{
				ReportLibrary.test.log(LogStatus.FAIL, "Request shared to Admin failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
			}
		}else{
			homepage.clickonMenuBar();
			driver.findElement(By.xpath("//div[@class='user-name']/ul/li/ul/li[@title='"+CompanyName+"']")).click();
			WebLibrary.wait(3);
			homepage.clickonRequestMenu();
			WebLibrary.wait(3);
			if(driver.findElement(By.xpath("//table/tbody/tr/td[2]/div[contains(text(),'"+RequestTitle+"')]")).isDisplayed()){
				ReportLibrary.test.log(LogStatus.PASS, "Request shared to Admin successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
			}else{
				ReportLibrary.test.log(LogStatus.FAIL, "Request shared to Admin failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
			}
		}
		//View Sent Request > To Verify Download Main Document	
		driver.findElement(By.xpath("(//table)[2]/tbody/tr/td[2]/div[contains(text(),'"+DataLibrary.getdata("RequestTitle")+"')]")).click();
		WebLibrary.setExplicitWait(Request.DownloadMainDocumentBtn, driver, 30);
		WebLibrary.removeDownloadFiles();
		Request.clickonDownloadMainDocumentBtn();
		WebLibrary.wait(5);
		//String RequestDocumentName = "To_Verify_Edit__Update__Send_Later__Cancel_Button__Copy__Download__Share_and_Delete_Request_2334";
		stepstatus = WebLibrary.getLatestFileName(RequestDocumentName + ".pdf");
		if(stepstatus==true){
			ReportLibrary.test.log(LogStatus.PASS, "Downloaded Main document successfully from Main Document Tab" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Downloaded Main document failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		//View Sent Request > To Verify Download Transaction Document
		WebLibrary.removeDownloadFiles();
		driver.navigate().refresh();
		WebLibrary.setExplicitWait(Request.DownloadMainDocumentBtn, driver, 30);
		Request.clickonDownloadTransactionDocumentBtn();
		//String RequestId = "2334";
		WebLibrary.wait(5);
		stepstatus = WebLibrary.getLatestFileName("TransactionDetails_" + RequestId + ".pdf");
		if(stepstatus==true){
			ReportLibrary.test.log(LogStatus.PASS, "Downloaded Transaction document successfully from Main Document Tab" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Downloaded Transaction document failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		//View Sent Request > To Verify Transaction Details Tab
		Request.clickonTransactionDetailsTab();
		WebLibrary.setExplicitWait(Request.TransactionDetailsPage, driver, 30);
		if(Request.TransactionDetailsPage.isDisplayed()){
			ReportLibrary.test.log(LogStatus.PASS, "Transaction Details Page got displayed successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Unable to view Transaction Details Page"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		//View Sent Request > To Verify History details
		Request.clickonHistoryTab();
		WebLibrary.setExplicitWait(Request.HistoryPage, driver, 30);
		if(Request.HistoryPage.isDisplayed()){
			ReportLibrary.test.log(LogStatus.PASS, "History Page got displayed successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Unable to view History details"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		//View Sent Request > To Verify Approval Order details
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
			
		
	}

	@Test(testName="Template Creation, Updation, Activation, Deactivation, Copying and Deleting")
	public void RemoveReplaceVoidBypassSigner() throws Exception
	{
		LoginPage loginpage = new LoginPage(driver);
		HomePage homepage = new HomePage(driver);
		CreateRequestPage CreateRequest = new CreateRequestPage(driver);
		RequestPage Request = new RequestPage(driver);
		MyApprovalPage myapproval = new MyApprovalPage(driver);
		AdminHomePage admin = new AdminHomePage(driver);
		UsersPage users = new UsersPage(driver);
		loginpage.setUsername(DataLibrary.getdata("Username"));
		loginpage.setPassword(DataLibrary.getdata("Password"));
		loginpage.clickonLogin();
		homepage.clickonCreateMenu();
		homepage.clickonCreateRequestMenu();
		CreateRequest.setRequestTitle(DataLibrary.getdata("RequestTitle"));
		CreateRequest.clickonMainDocumentBtn();
		WebLibrary.wait(3);
		Runtime.getRuntime().exec(AutoItPath + "\\Approval.exe");
		WebLibrary.setExplicitWait(CreateRequest.DocumentsList, driver, 30);
		CreateRequest.setSigner1Email(DataLibrary.getdata("Signer1Email"));
		CreateRequest.setSigner1FirstName(DataLibrary.getdata("Signer1FirstName"));
		CreateRequest.setSigner1LastName(DataLibrary.getdata("Signer1LastName"));
		CreateRequest.clickonAddSignerIcon();
		CreateRequest.setSigner2Email(DataLibrary.getdata("Signer2Email"));
		CreateRequest.setSigner2FirstName(DataLibrary.getdata("Signer2FirstName"));
		CreateRequest.setSigner2LastName(DataLibrary.getdata("Signer2LastName"));
		CreateRequest.clickonAddSignerIcon();
		CreateRequest.setSigner3Email(DataLibrary.getdata("Signer3Email"));
		CreateRequest.setSigner3FirstName(DataLibrary.getdata("Signer3FirstName"));
		CreateRequest.setSigner3LastName(DataLibrary.getdata("Signer3LastName"));
		CreateRequest.clickonAddSignerIcon();
		CreateRequest.setSigner4Email(DataLibrary.getdata("Signer4Email"));
		CreateRequest.setSigner4FirstName(DataLibrary.getdata("Signer4FirstName"));
		CreateRequest.setSigner4LastName(DataLibrary.getdata("Signer4LastName"));
		CreateRequest.setSigner2Approver(DataLibrary.getdata("Signer2ApproverOrder"));
		CreateRequest.setSigner3Approver(DataLibrary.getdata("Signer3ApproverOrder"));	
		CreateRequest.setSigner4Approver(DataLibrary.getdata("Signer4ApproverOrder"));	
		CreateRequest.clickonNextBtn();
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
		WebLibrary.wait(2);
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
		WebLibrary.wait(2);
		//To Add Custom fields for Signer 3
		CreateRequest.setSignerSelection(DataLibrary.getdata("Signer3Email"));
		WebLibrary.wait(3);
		WebLibrary.setExplicitWait(CreateRequest.Signature, driver, 60);
		CreateRequest.clickonSignature();
		action.moveToElement(driver.findElement(By.xpath("//img[@id='documentPageImage1']"))).build().perform();
		int ycord2 = 656;
		action.moveToElement(target, xcord, ycord2).click().build().perform();
		WebLibrary.setExplicitWait(CreateRequest.Initial, driver, 60);
		CreateRequest.clickonInitial();
		action.moveToElement(driver.findElement(By.xpath("//img[@id='documentPageImage1']"))).build().perform();
		action.moveToElement(target, xcord1, ycord2).click().build().perform();
		CreateRequest.clickonDate();
		action.moveToElement(driver.findElement(By.xpath("//img[@id='documentPageImage1']"))).build().perform();
		action.moveToElement(target, xcord2, ycord2).click().build().perform();
		WebLibrary.wait(5);
		CreateRequest.clickonSendNowBtn();
		boolean RequestStatus = WebLibrary.verifyTextPresent("Request Sent Successfully");
		if(RequestStatus == true){
			ReportLibrary.test.log(LogStatus.PASS, "Request created and sent for approval successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Request sending for approval failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		//To verify remove signer
		WebElement documentPreview = driver.findElement(By.xpath("//table/tbody/tr/td[2]/div[contains(text(),'"+DataLibrary.getdata("RequestTitle")+"')]/parent::td/preceding-sibling::td[1]/div/span[@class='fa fa-eye']"));
		Actions action1 = new Actions(driver);
		action1.moveToElement(documentPreview).click().perform();
		WebLibrary.wait(3);
		WebLibrary.setExplicitWait(Request.MoreBtn, driver, 40);
		Request.clickonMoreBtn();
		Request.clickonRemoveOption();
		WebLibrary.setExplicitWait(Request.RemoveSignerWindow, driver, 40);
		driver.findElement(By.xpath("//form[@id='removeSignerForm']/div/table/tbody/tr/td[2][contains(text(),'"+DataLibrary.getdata("Signer4Email")+"')]/following-sibling::td[2]/input")).click();
		Request.clickonRemoveIcon();
		WebLibrary.wait(2);
		boolean RemoveSigner = WebLibrary.verifyTextPresent("Signer removed successfully");
		if(RemoveSigner == true){
			ReportLibrary.test.log(LogStatus.PASS, "Signer got removed successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Signer remove failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		//To perform replace signer
		Request.clickonCloseIcon();
		WebLibrary.setExplicitWait(Request.MoreBtn, driver, 40);
		Request.clickonMoreBtn();
		Request.clickonReplace();
		WebLibrary.setExplicitWait(Request.ReplaceSignerWindow, driver, 40);
		driver.findElement(By.xpath("//form[@id='replaceForm']/div[2]/table/tbody/tr/td[2][contains(text(),'"+DataLibrary.getdata("Signer2Email")+"')]/following-sibling::td[3]/input[@name='replacename']")).click();
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
		// To Verify Bypass Signer	
		Request.clickonCloseIcon();
		WebLibrary.setExplicitWait(Request.MoreBtn, driver, 40);
		Request.clickonMoreBtn();
		Request.clickonBypass();
		WebLibrary.setExplicitWait(Request.BypassSignerWindow, driver, 40);
		Request.BypassApprover1();
		Request.clickonBypassIcon();
		WebLibrary.wait(2);
		boolean BypassSigner = WebLibrary.verifyTextPresent("Bypass has been done Successfully");
		if(BypassSigner == true){
			ReportLibrary.test.log(LogStatus.PASS, "Signer got Bypassed successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Signer Bypass failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		Request.clickonCloseIcon();
		homepage.clickonLogo();
		homepage.clickonNeedToSign();
		WebLibrary.setExplicitWait(homepage.NeedToSignPage, driver, 60);
		if(!driver.findElements(By.xpath("(//table)[2]/tbody/tr/td[2]/div[contains(text(),'"+DataLibrary.getdata("RequestTitle")+"')]")).isEmpty()){
			ReportLibrary.test.log(LogStatus.PASS, "After Bypass second approver is able to view the request" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "After Bypass second approver is unable to view the request"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		//To Verify Void Request
		homepage.clickonRequestMenu();
		WebElement documentPreview3 = driver.findElement(By.xpath("//table/tbody/tr/td[2]/div[contains(text(),'"+DataLibrary.getdata("RequestTitle")+"')]/parent::td/preceding-sibling::td[1]/div/span[@class='fa fa-eye']"));
		action1.moveToElement(documentPreview3).click().perform();
		WebLibrary.wait(3);
		
		//Request.clickonCloseIcon();
		WebLibrary.setExplicitWait(Request.MoreBtn, driver, 40);
		Request.clickonMoreBtn();
		Request.clickonVoid();
		WebLibrary.setExplicitWait(Request.OkBtn, driver, 20);
		Request.clickonOkBtn();
		WebLibrary.wait(2);
		boolean VoidRequest = WebLibrary.verifyTextPresent("Request has been voided Successfully ");
		if(VoidRequest == true){
			ReportLibrary.test.log(LogStatus.PASS, "Request has been voided successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Void Request failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		//To Verify Copy Request
		WebElement documentPreview1 = driver.findElement(By.xpath("//table/tbody/tr/td[2]/div[contains(text(),'"+DataLibrary.getdata("RequestTitle")+"')]/parent::td/preceding-sibling::td[1]/div/span[@class='fa fa-eye']"));
		action1.moveToElement(documentPreview1).click().perform();
		WebLibrary.wait(3);
		WebLibrary.setExplicitWait(Request.MoreBtn, driver, 40);
		Request.clickonMoreBtn();
		Request.clickonCopy();
		WebLibrary.setExplicitWait(Request.OkBtn, driver, 20);
		Request.clickonOkBtn();
		WebLibrary.wait(2);
		boolean CopyRequest = WebLibrary.verifyTextPresent("Request Copied Successfully");
		if(CopyRequest == true){
			ReportLibrary.test.log(LogStatus.PASS, "Request copied successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Request Copy failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		//To Verify Delete Request
		WebElement documentPreview2 = driver.findElement(By.xpath("//table/tbody/tr/td[2]/div[contains(text(),'"+DataLibrary.getdata("RequestTitle")+"')]/parent::td/preceding-sibling::td[1]/div/span[@class='fa fa-eye']"));
		action1.moveToElement(documentPreview2).click().perform();
		WebLibrary.wait(3);
		WebLibrary.setExplicitWait(Request.MoreBtn, driver, 40);
		Request.clickonMoreBtn();
		Request.clickonDelete();
		WebLibrary.setExplicitWait(Request.OkBtn, driver, 20);
		Request.clickonOkBtn();
		WebLibrary.wait(2);
		boolean DeleteRequest = WebLibrary.verifyTextPresent("Request deleted successfully");
		if(DeleteRequest == true){
			ReportLibrary.test.log(LogStatus.PASS, "Request deleted successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Request delete failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		WebLibrary.wait(10);
	}
		
	@Test(testName="Template Creation, Updation, Activation, Deactivation, Copying and Deleting")
	public void EditRequestAddCustomFieldsUpdatePrivileges() throws Exception
	{
		LoginPage loginpage = new LoginPage(driver);
		HomePage homepage = new HomePage(driver);
		CreateRequestPage CreateRequest = new CreateRequestPage(driver);
		RequestPage Request = new RequestPage(driver);
		MyApprovalPage myapproval = new MyApprovalPage(driver);
		AdminHomePage admin = new AdminHomePage(driver);
		UsersPage users = new UsersPage(driver);
		loginpage.setUsername(DataLibrary.getdata("Username"));
		loginpage.setPassword(DataLibrary.getdata("Password"));
		loginpage.clickonLogin();
		
/*		homepage.clickonRequestMenu();
		WebLibrary.setExplicitWait(Request.DraftTab, driver, 30);
		Request.clickonDraftTab();
		driver.findElement(By.xpath("//table/tbody/tr/td[2]/div")).click();*/
		
		
		homepage.clickonCreateMenu();
		homepage.clickonCreateRequestMenu();
		CreateRequest.setRequestTitle(DataLibrary.getdata("RequestTitle"));
		CreateRequest.clickonMainDocumentBtn();
		WebLibrary.wait(3);
		Runtime.getRuntime().exec(AutoItPath + "\\Approval.exe");
		WebLibrary.setExplicitWait(CreateRequest.DocumentsList, driver, 30);
		CreateRequest.setSigner1Email(DataLibrary.getdata("Signer1Email"));
		CreateRequest.setSigner1FirstName(DataLibrary.getdata("Signer1FirstName"));
		CreateRequest.setSigner1LastName(DataLibrary.getdata("Signer1LastName"));
		CreateRequest.clickonSaveToDraft();
		boolean RequestStatus = WebLibrary.verifyTextPresent("Request Saved Successfully");
		if(RequestStatus==true){
			ReportLibrary.test.log(LogStatus.PASS, "Request created and saved to draft successfully");
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Request creation failed");
		}
		driver.findElement(By.xpath("//table/tbody/tr/td[2]/div[contains(text(),'"+DataLibrary.getdata("RequestTitle")+"')]")).click();
		Request.clickonCustomDataTab();
		//To Add TextBox
		Request.clickonAddTextBox();
		Request.setFieldName(DataLibrary.getdata("TextBoxName"));
		Request.setDataType(DataLibrary.getdata("TextBoxDataType"));
		Request.clickonSaveBtn();
		WebLibrary.wait(3);
		boolean TextBoxStatus = WebLibrary.verifyTextPresent("Custom Data Saved Successfully");
		if(TextBoxStatus==true){
			ReportLibrary.test.log(LogStatus.PASS, "TextBox added successfully");
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Adding TextBox got failed");
		}
		//To Add TextArea
		Request.clickonAddTextArea();
		Request.setFieldName(DataLibrary.getdata("TextAreaName"));
		Request.clickonSaveBtn();
		WebLibrary.wait(3);
		boolean TextAreaStatus = WebLibrary.verifyTextPresent("Custom Data Saved Successfully");
		if(TextAreaStatus==true){
			ReportLibrary.test.log(LogStatus.PASS, "TextArea added successfully");
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Adding TextArea got failed");
		}
		//To Add RadioButton
		WebLibrary.setExplicitWait(Request.AddRadioBtn, driver, 30);
		Request.clickonAddRadioBtn();
		Request.setFieldName(DataLibrary.getdata("RadioButtonName"));
		Request.clickonSaveBtn();
		WebLibrary.wait(3);
		boolean RadioBtnStatus = WebLibrary.verifyTextPresent("Custom Data Saved Successfully");
		if(RadioBtnStatus==true){
			ReportLibrary.test.log(LogStatus.PASS, "RadioButton added successfully");
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Adding RadioButton got failed");
		}
		//To Add Checkbox
		Request.clickonAddCheckBox();
		Request.setFieldName(DataLibrary.getdata("CheckBoxName"));
		Request.clickonSaveBtn();
		WebLibrary.wait(3);
		boolean CheckboxStatus = WebLibrary.verifyTextPresent("Custom Data Saved Successfully");
		if(CheckboxStatus==true){
			ReportLibrary.test.log(LogStatus.PASS, "Checkbox added successfully");
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Adding Checkbox got failed");
		}
		// To Add Select box
		Request.clickonAddSelectBox();
		Request.setFieldName(DataLibrary.getdata("SelectBoxName"));
		Request.clickonSaveBtn();
		WebLibrary.wait(3);
		Request.setOption(DataLibrary.getdata("SelectBoxOptions"));
		Request.clickonSelectOptionSaveBtn();
		WebLibrary.wait(3);
		boolean SelectBoxStatus = WebLibrary.verifyTextPresent("Custom Data Saved Successfully");
		if(SelectBoxStatus==true){
			ReportLibrary.test.log(LogStatus.PASS, "Select-box with options added successfully");
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Adding Select-box got failed");
		}
		// To Copy and delete the record
		driver.findElement(By.xpath("//table/tbody/tr/td[2][contains(text(),'"+DataLibrary.getdata("SelectBoxName")+"')]/following-sibling::td[6]/a[1]")).click();
		WebLibrary.setExplicitWait(Request.UpdateBtn, driver, 30);
		Request.clickonUpdateBtn();
		WebLibrary.wait(3);
		boolean UpdateFields = WebLibrary.verifyTextPresent("Custom Data updated Successfully");
		if(UpdateFields==true){
			ReportLibrary.test.log(LogStatus.PASS, "Custom Data details updated successfully");
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Custom Data details updation failed");
		}
		Request.clickonCopyBtn();
		driver.findElement(By.xpath("//table/tbody/tr/td[2][contains(text(),'"+DataLibrary.getdata("SelectBoxName")+"')]/preceding-sibling::td[1]/input[@type='checkbox']")).click();
		Request.clickonDeleteIcon();
		Request.clickonOkBtn();
		boolean DeleteField = WebLibrary.verifyTextPresent("Custom Data deleted successfully");
		if(DeleteField==true){
			ReportLibrary.test.log(LogStatus.PASS, "Custom Data details deleted successfully");
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Custom Data details deletion failed");
		}
		Request.clickonEditRequestBreadcrumbLink();
		Request.clickonPrivilegesTab();
		Request.setEmployeeSearch(DataLibrary.getdata("Employee"));
		Request.clickonSearchBtn();
		Request.selectAdmin();
		WebLibrary.setExplicitWait(Request.UpdateAdmin, driver, 30);
		Request.clickonupdateAdmin();
		boolean UpdateAdmin = WebLibrary.verifyTextPresent("Admin privileges updated successfully");
		if(UpdateAdmin==true){
			ReportLibrary.test.log(LogStatus.PASS, "Admin privileges updated successfully");
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Admin privileges updation failed");
		}
		WebLibrary.wait(10);
	}
	
}

	