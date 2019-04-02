package TestScripts;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import ApplicationPages.AdminHomePage;
import ApplicationPages.CompanySettingsPage;
import ApplicationPages.CreateGroupRequest;
import ApplicationPages.CreateInPersonRequest;
import ApplicationPages.CreateRequestPage;
import ApplicationPages.CreateTemplatePage;
import ApplicationPages.CustomizePage;
import ApplicationPages.GroupsPage;
import ApplicationPages.HomePage;
import ApplicationPages.LoginPage;
import ApplicationPages.MyApprovalPage;
import ApplicationPages.TemplatesPage;
import FrameworkLibrary.BaseClass;
import FrameworkLibrary.DataLibrary;
import FrameworkLibrary.ReportLibrary;
import FrameworkLibrary.WebLibrary;

public class CreateRequest extends BaseClass{

	@Test(testName="Request Creation and Save to Draft")
	public void CreateRequestSaveToDraft() throws Exception
	{
		LoginPage loginpage = new LoginPage(driver);
		HomePage homepage = new HomePage(driver);
		CreateRequestPage CreateRequest = new CreateRequestPage(driver);
		loginpage.setUsername(DataLibrary.getdata("Username"));
		loginpage.setPassword(DataLibrary.getdata("Password"));
		loginpage.clickonLogin();
		homepage.clickonCreateMenu();
		homepage.clickonCreateRequestMenu();
		CreateRequest.setRequestTitle(DataLibrary.getdata("RequestTitle"));
		CreateRequest.clickonMainDocumentBtn();
		WebLibrary.wait(3);
		WebLibrary.RobotKeysFileUpload(AttachmentFiles + "\\Approval.docx");
		WebLibrary.setExplicitWait(CreateRequest.DocumentsList, driver, 30);
		CreateRequest.setSigner1Email(DataLibrary.getdata("SignerEmail1"));
		CreateRequest.clickonAddSignerIcon();
		CreateRequest.setSigner2Email(DataLibrary.getdata("SignerEmail2"));
		CreateRequest.clickonSaveToDraft();
		boolean RequestStatus = WebLibrary.verifyTextPresent("Request Saved Successfully");
		if(RequestStatus==true){
			ReportLibrary.test.log(LogStatus.PASS, "Request created and saved to draft successfully");
		}else{
			ReportLibrary.test.log(LogStatus.PASS, "Request creation failed");
		}
	}
	
	@Test(testName="Request Approval Process With Single Signer")
	public void RequestApprovalProcessWithSingleSigner() throws Exception
	{
		LoginPage loginpage = new LoginPage(driver);
		HomePage homepage = new HomePage(driver);
		CreateRequestPage CreateRequest = new CreateRequestPage(driver);
		MyApprovalPage myapproval = new MyApprovalPage(driver);
		loginpage.setUsername(DataLibrary.getdata("Username"));
		loginpage.setPassword(DataLibrary.getdata("Password"));
		loginpage.clickonLogin();
		homepage.clickonCreateMenu();
		homepage.clickonCreateRequestMenu();
		CreateRequest.setRequestTitle(DataLibrary.getdata("RequestTitle"));
		CreateRequest.clickonMainDocumentBtn();
		WebLibrary.wait(3);
		WebLibrary.RobotKeysFileUpload(AttachmentFiles + "\\Approval.docx");
		WebLibrary.setExplicitWait(CreateRequest.DocumentsList, driver, 30);
		CreateRequest.setSigner1Email(DataLibrary.getdata("SignerEmail1"));
		CreateRequest.clickonNextBtn();
		WebLibrary.setExplicitWait(CreateRequest.DocumentSetupSaveBtn, driver, 20);
		//To Add Signature Field
		CreateRequest.clickonSignature();
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//img[@id='documentPageImage1']"))).build().perform();	
		WebElement target = driver.findElement(By.xpath("//img[@id='documentPageImage1']"));
		int xcord = 99;
		int ycord = 428;
		action.moveToElement(target, xcord, ycord).click().build().perform();
		System.out.println("Signature added successfully");
		
		//To Add Initial Field
		CreateRequest.clickonInitial();
		action.moveToElement(driver.findElement(By.xpath("//img[@id='documentPageImage1']"))).build().perform();
		int xcord1 = 304;
		action.moveToElement(target, xcord1, ycord).click().build().perform();
		System.out.println("Initial added successfully");
		
		//To Add Date Field
		CreateRequest.clickonDate();
		action.moveToElement(driver.findElement(By.xpath("//img[@id='documentPageImage1']"))).build().perform();
		int xcord2 = 514;
		action.moveToElement(target, xcord2, ycord).click().build().perform();
		System.out.println("Date added successfully");
		
		WebLibrary.wait(2);
		
		CreateRequest.clickonSendNowBtn();
		boolean RequestStatus = WebLibrary.verifyTextPresent("Request Sent Successfully");
		if(RequestStatus == true){
			ReportLibrary.test.log(LogStatus.PASS, "Request created and sent for approval successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Request sending for approval failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		
		homepage.clickonHeadProfile();
		homepage.clickonSignOutLink();	
		loginpage.setUsername("sravyab@ibt.example.com");
		loginpage.setPassword("testing");
		loginpage.clickonLogin();
		homepage.clickonNeedToSign();
		WebLibrary.wait(6);
		driver.findElement(By.xpath("(//table)[2]/tbody/tr/td[2]/div[contains(text(),'"+DataLibrary.getdata("RequestTitle")+"')]")).click();
		WebLibrary.setExplicitWait(myapproval.StartBtn, driver, 60);
		myapproval.clickonSignHere();
		if(driver.findElement(By.xpath("//div[@id='createSignContentDiv']")).isDisplayed()){
			myapproval.setTypeSignature(DataLibrary.getdata("SignatureName"));
			myapproval.clickonTypeApplyBtn();
			myapproval.clickonAcceptOKBtn();
		}else{
			myapproval.clickonAcceptOKBtn();
		}
		myapproval.clickonInitialHere();
		if(driver.findElement(By.xpath("//div[@id='createSignContentDiv']")).isDisplayed()){
			myapproval.setTypeSignature(DataLibrary.getdata("InitialName"));
			myapproval.clickonTypeApplyBtn();
			myapproval.clickonAcceptOKBtn();
		}else{
			myapproval.clickonAcceptOKBtn();
		}
		
		myapproval.clickonCalendarIcon1();
		WebLibrary.selectDate("15");
		//myapproval.clickonStartBtn();
		myapproval.clickonFinishBtn();	
		myapproval.clickonAcceptOKBtn();
		WebLibrary.wait(2);	
		boolean ApprovalStatus = WebLibrary.verifyTextPresent("You have successfully completed the signing process for this document");
		if(ApprovalStatus == true){
			ReportLibrary.test.log(LogStatus.PASS, "Request approval process done successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Request approval process failed" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		
		
	}
	
	
	@Test(testName="Request Approval Process With Multiple Signers")
	public void RequestApprovalProcessWithMultipleSigners() throws Exception
	{
		LoginPage loginpage = new LoginPage(driver);
		HomePage homepage = new HomePage(driver);
		CreateRequestPage CreateRequest = new CreateRequestPage(driver);
		MyApprovalPage myapproval = new MyApprovalPage(driver);
		loginpage.setUsername(DataLibrary.getdata("Username"));
		loginpage.setPassword(DataLibrary.getdata("Password"));
		loginpage.clickonLogin();
		homepage.clickonCreateMenu();
		homepage.clickonCreateRequestMenu();
		CreateRequest.setRequestTitle(DataLibrary.getdata("RequestTitle"));
		CreateRequest.clickonMainDocumentBtn();
		WebLibrary.wait(3);
		WebLibrary.RobotKeysFileUpload(AttachmentFiles + "\\Approval.docx");
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
	
		//To Add Custom fields for Signer 3
		CreateRequest.setSignerSelection(DataLibrary.getdata("Signer3Email"));
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
		
		homepage.clickonHeadProfile();
		homepage.clickonSignOutLink();	
		
		// Signer1 Approval Process
		loginpage.setUsername(DataLibrary.getdata("Signer1Email"));
		loginpage.setPassword("testing");
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
		loginpage.setPassword("testing");
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
		
		// Signer3 Approval Process
		loginpage.setUsername(DataLibrary.getdata("Signer3Email"));
		loginpage.setPassword("test0101");
		loginpage.clickonLogin();
		homepage.clickonNeedToSign();
		WebLibrary.setExplicitWait(homepage.NeedToSignPage, driver, 60);
		driver.findElement(By.xpath("(//table)[2]/tbody/tr/td[2]/div[contains(text(),'"+DataLibrary.getdata("RequestTitle")+"')]")).click();
		WebLibrary.setExplicitWait(myapproval.StartBtn, driver, 60);
		myapproval.clickonSignHere();
		if(driver.findElement(By.xpath("//div[@id='createSignContentDiv']")).isDisplayed()){
			myapproval.setTypeSignature(DataLibrary.getdata("Signer3FirstName"));
			myapproval.clickonTypeApplyBtn();
			myapproval.clickonAcceptOKBtn();
		}else{
			myapproval.clickonAcceptOKBtn();
		}
		myapproval.clickonInitialHere();
		if(driver.findElement(By.xpath("//div[@id='createSignContentDiv']")).isDisplayed()){
			myapproval.setTypeSignature(DataLibrary.getdata("Signer3LastName"));
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
		boolean Signer3ApprovalStatus = WebLibrary.verifyTextPresent("You have successfully completed the signing process for this document");
		if(Signer3ApprovalStatus == true){
			ReportLibrary.test.log(LogStatus.PASS, "Signer 3 : Request approval process done successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Signer 3 : Request approval process failed" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}

		myapproval.clickonBackBtn();
		homepage.clickonHeadProfile();
		homepage.clickonSignOutLink();
	}

	@Test(testName="Request Approval Process With Multiple Documents")
	public void RequestApprovalProcessWithMultipleDocuments() throws Exception
	{
		LoginPage loginpage = new LoginPage(driver);
		HomePage homepage = new HomePage(driver);
		CreateRequestPage CreateRequest = new CreateRequestPage(driver);
		MyApprovalPage myapproval = new MyApprovalPage(driver);
		loginpage.setUsername(DataLibrary.getdata("Username"));
		loginpage.setPassword(DataLibrary.getdata("Password"));
		loginpage.clickonLogin();
		homepage.clickonCreateMenu();
		homepage.clickonCreateRequestMenu();
		CreateRequest.setRequestTitle(DataLibrary.getdata("RequestTitle"));
		CreateRequest.clickonMainDocumentBtn();
		WebLibrary.wait(5);
		Runtime.getRuntime().exec(AutoItPath + "\\Approval.exe");
		//WebLibrary.RobotKeysFileUpload(AttachmentFiles + "\\Approval.docx");
		WebLibrary.setExplicitWait(CreateRequest.DocumentsList, driver, 30);
		driver.switchTo().activeElement().sendKeys(Keys.ESCAPE);
		CreateRequest.clickonMainDocumentBtn();
		WebLibrary.wait(5);
		Runtime.getRuntime().exec(AutoItPath + "\\LeaveRequestForm.exe");
		//WebLibrary.RobotKeysFileUpload(AttachmentFiles + "\\Leave Request Form.docx");
		WebLibrary.setExplicitWait(CreateRequest.DocumentsList, driver, 30);
		WebLibrary.wait(3);
		CreateRequest.setSigner1Email(DataLibrary.getdata("Signer1Email"));
		CreateRequest.setSigner1FirstName(DataLibrary.getdata("Signer1FirstName"));
		CreateRequest.setSigner1LastName(DataLibrary.getdata("Signer1LastName"));
		CreateRequest.clickonNextBtn();
		
		/*homepage.clickonRequestMenu();
		driver.findElement(By.xpath("(//table)[2]/tbody/tr/td[2]/div[contains(text(),'"+DataLibrary.getdata("RequestTitle")+"')]")).click();
		driver.findElement(By.xpath("//a[@id='documentPageBtn']")).click();*/
		
		WebLibrary.setExplicitWait(CreateRequest.DocumentSetupSaveBtn, driver, 40);
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
		
		CreateRequest.setDocumentSelection(DataLibrary.getdata("Document2"));
		WebLibrary.wait(4);
		CreateRequest.clickonTextbox();
		action.moveToElement(driver.findElement(By.xpath("//img[@id='documentPageImage1']"))).build().perform();
		WebElement target1 = driver.findElement(By.xpath("//img[@id='documentPageImage1']"));
		int xcord3 = 195;
		int ycord3 = 205;
		action.moveToElement(target1, xcord3, ycord3).click().build().perform();
		System.out.println("Textbox added successfully");
		WebLibrary.wait(3);
		CreateRequest.clickonTextbox();
		action.moveToElement(driver.findElement(By.xpath("//img[@id='documentPageImage1']"))).build().perform();
		action.moveToElement(target1, 143, 236).click().build().perform();
		System.out.println("Textbox added successfully");
		WebLibrary.wait(3);
		CreateRequest.clickonCheckbox();
		action.moveToElement(driver.findElement(By.xpath("//img[@id='documentPageImage1']"))).build().perform();
		action.moveToElement(target1, 102, 308).click().build().perform();
		System.out.println("Checkbox added successfully");
		WebLibrary.wait(3);
		action.moveToElement(driver.findElement(By.xpath("//span[@id='jqueryUnique3']"))).build().perform();
		driver.findElement(By.xpath("//span[@id='jqueryUnique3']/img[@id='setRadioGroupNameImage']")).click();
		WebLibrary.setExplicitWait(CreateRequest.GroupName, driver, 20);
		CreateRequest.setGroupName(DataLibrary.getdata("CheckboxGroupName"));
		CreateRequest.clickonSetGroup();
		WebLibrary.wait(2);
		action.moveToElement(driver.findElement(By.xpath("//span[@id='jqueryUnique3']"))).build().perform();
		driver.findElement(By.xpath("//span[@id='jqueryUnique3']/img[@id='copyImage']")).click();
		action.moveToElement(target1, 265, 308).click().build().perform();
		CreateRequest.clickonDate();
		action.moveToElement(driver.findElement(By.xpath("//img[@id='documentPageImage1']"))).build().perform();
		action.moveToElement(target1, 252, 401).click().build().perform();
		System.out.println("Date added successfully");
		WebLibrary.wait(4);
		CreateRequest.clickonDate();
		action.moveToElement(driver.findElement(By.xpath("//img[@id='documentPageImage1']"))).build().perform();
		action.moveToElement(target1, 532, 401).click().build().perform();
		System.out.println("Date added successfully");
		WebLibrary.wait(4);
		CreateRequest.clickonSignature();
		action.moveToElement(driver.findElement(By.xpath("//img[@id='documentPageImage1']"))).build().perform();	
		action.moveToElement(target1, 74, 737).click().build().perform();
		System.out.println("Signature added successfully");
		WebLibrary.wait(2);
		CreateRequest.clickonSendNowBtn();
		WebLibrary.wait(2);
		boolean RequestStatus = WebLibrary.verifyTextPresent("Request Sent Successfully");
		if(RequestStatus == true){
			ReportLibrary.test.log(LogStatus.PASS, "Request created and sent for approval successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Request sending for approval failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		
		homepage.clickonHeadProfile();
		homepage.clickonSignOutLink();
		
		// Signer1 Approval Process
		loginpage.setUsername(DataLibrary.getdata("Signer1Email"));
		loginpage.setPassword("testing");
		loginpage.clickonLogin();
		homepage.clickonNeedToSign();
		WebLibrary.setExplicitWait(homepage.NeedToSignPage, driver, 60);
		driver.findElement(By.xpath("(//table)[2]/tbody/tr/td[2]/div[contains(text(),'"+DataLibrary.getdata("RequestTitle")+"')]")).click();
		WebLibrary.wait(3);
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
		WebLibrary.wait(2);
		myapproval.clickonNextDocumentOKBtn();
		WebLibrary.wait(3);
		//myapproval.clickonAcceptOKBtn();
		myapproval.setEmployeeName(DataLibrary.getdata("EmployeeName"));
		driver.switchTo().activeElement().sendKeys(Keys.TAB);
		driver.switchTo().activeElement().sendKeys("Shravani");
		driver.switchTo().activeElement().sendKeys(Keys.TAB);
		driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();
		myapproval.clickonCalendarIcon1();
		WebLibrary.selectDate(DataLibrary.getdata("FromDate"));
		myapproval.clickonCalendarIcon2();
		WebLibrary.selectDate(DataLibrary.getdata("ToDate"));
		myapproval.clickonSignHere();
		if(driver.findElement(By.xpath("//div[@id='createSignContentDiv']")).isDisplayed()){
			myapproval.setTypeSignature(DataLibrary.getdata("Signer1FirstName"));
			myapproval.clickonTypeApplyBtn();
			myapproval.clickonAcceptOKBtn();
		}else{
			myapproval.clickonAcceptOKBtn();
		}
		WebLibrary.wait(2);
		myapproval.clickonFinishBtn();	
		myapproval.clickonAcceptOKBtn();
		WebLibrary.wait(2);	
		boolean ApprovalStatus = WebLibrary.verifyTextPresent("You have successfully completed the signing process for this document");
		if(ApprovalStatus == true){
			ReportLibrary.test.log(LogStatus.PASS, "Request approval process with multiple documents done successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Signer 1 : Request approval process with multiple documents failed" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		myapproval.clickonBackBtn();
		homepage.clickonHeadProfile();
		homepage.clickonSignOutLink();
	}

	@Test(testName="Request Approval Process by adding supporting documents")
	public void RequestApprovalProcessWithSupportingDocuments() throws Exception
	{
		LoginPage loginpage = new LoginPage(driver);
		HomePage homepage = new HomePage(driver);
		CreateRequestPage CreateRequest = new CreateRequestPage(driver);
		AdminHomePage admin = new AdminHomePage(driver);
		CompanySettingsPage settings = new CompanySettingsPage(driver);
		MyApprovalPage myapproval = new MyApprovalPage(driver);
		loginpage.setUsername(DataLibrary.getdata("Username"));
		loginpage.setPassword(DataLibrary.getdata("Password"));
		loginpage.clickonLogin();
		homepage.clickonCreateMenu();
		homepage.clickonCreateRequestMenu();
		//TO Verify whether 'Supporting Documents' is On/Off
			
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
			homepage.clickonCreateMenu();
			homepage.clickonCreateRequestMenu();
		}
				
		CreateRequest.setRequestTitle(DataLibrary.getdata("RequestTitle"));
		CreateRequest.clickonMainDocumentBtn();
		WebLibrary.wait(5);
		Runtime.getRuntime().exec(AutoItPath + "\\Approval.exe");
		WebLibrary.setExplicitWait(CreateRequest.DocumentsList, driver, 30);
		CreateRequest.clickonSupportingDocumentBtn();
		WebLibrary.wait(2);
		CreateRequest.clickonBrowseBtn();
		WebLibrary.wait(5);
		Runtime.getRuntime().exec(AutoItPath + "\\Attachment1.exe");
		//WebLibrary.RobotKeysFileUpload(AttachmentFiles + "\\Agreement.pdf");
		WebLibrary.wait(3);
		CreateRequest.clickonUploadBtn();
		WebLibrary.wait(1);
		boolean SupportingDocMsg = WebLibrary.verifyTextPresent("Supporting Document uploaded successfully");
		if(SupportingDocMsg == true){
			ReportLibrary.test.log(LogStatus.PASS, "Supporting Document uploaded successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Supporting Document upload failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		WebLibrary.wait(3);
		CreateRequest.setSigner1Email(DataLibrary.getdata("Signer1Email"));
		CreateRequest.clickonNextBtn();
		WebLibrary.setExplicitWait(CreateRequest.DocumentSetupSaveBtn, driver, 20);
		//To Add Signature Field
		CreateRequest.clickonSignature();
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//img[@id='documentPageImage1']"))).build().perform();	
		WebElement target = driver.findElement(By.xpath("//img[@id='documentPageImage1']"));
		int xcord = 99;
		int ycord = 428;
		action.moveToElement(target, xcord, ycord).click().build().perform();
		System.out.println("Signature added successfully");
		
		//To Add Initial Field
		CreateRequest.clickonInitial();
		action.moveToElement(driver.findElement(By.xpath("//img[@id='documentPageImage1']"))).build().perform();
		int xcord1 = 304;
		action.moveToElement(target, xcord1, ycord).click().build().perform();
		System.out.println("Initial added successfully");
		
		//To Add Date Field
		CreateRequest.clickonDate();
		action.moveToElement(driver.findElement(By.xpath("//img[@id='documentPageImage1']"))).build().perform();
		int xcord2 = 514;
		action.moveToElement(target, xcord2, ycord).click().build().perform();
		System.out.println("Date added successfully");
		
		WebLibrary.wait(2);
		
		CreateRequest.clickonSendNowBtn();
		boolean RequestStatus = WebLibrary.verifyTextPresent("Request Sent Successfully");
		if(RequestStatus == true){
			ReportLibrary.test.log(LogStatus.PASS, "Request created and sent for approval successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Request sending for approval failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		
		homepage.clickonHeadProfile();
		homepage.clickonSignOutLink();	
		loginpage.setUsername(DataLibrary.getdata("Signer1Email"));
		loginpage.setPassword(DataLibrary.getdata("Signer1Password"));
		loginpage.clickonLogin();
		homepage.clickonNeedToSign();
		WebLibrary.setExplicitWait(homepage.NeedToSignPage, driver, 60);
		driver.findElement(By.xpath("(//table)[2]/tbody/tr/td[2]/div[contains(text(),'"+DataLibrary.getdata("RequestTitle")+"')]")).click();
		WebLibrary.setExplicitWait(myapproval.StartBtn, driver, 60);
		myapproval.clickonSignHere();
		//Verifying whether Supporting documents message is displaying or not.
		boolean SupportingDocValidation = WebLibrary.verifyTextPresent("There are some Supporting Documents to be Viewed before Performing the Action");
		if(SupportingDocValidation == true){
			ReportLibrary.test.log(LogStatus.PASS, "Verify Supporting Document Validation message is displaying successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
			myapproval.clickonMoreBtn();
			myapproval.clickonSupportingDocuments();
			myapproval.clickonDownloadDocument();
			WebLibrary.getLatestFilefromDir();	
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Verify Supporting Document Validation message not displaying"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		driver.navigate().refresh();
		WebLibrary.setExplicitWait(myapproval.StartBtn, driver, 60);
		myapproval.clickonSignHere();
		if(driver.findElement(By.xpath("//div[@id='createSignContentDiv']")).isDisplayed()){
			myapproval.setTypeSignature(DataLibrary.getdata("SignatureName"));
			myapproval.clickonTypeApplyBtn();
			myapproval.clickonAcceptOKBtn();
		}else{
			myapproval.clickonAcceptOKBtn();
		}
		myapproval.clickonInitialHere();
		if(driver.findElement(By.xpath("//div[@id='createSignContentDiv']")).isDisplayed()){
			myapproval.setTypeSignature(DataLibrary.getdata("InitialName"));
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
			ReportLibrary.test.log(LogStatus.PASS, "Request approval process done successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Request approval process failed" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		myapproval.clickonBackBtn();
		homepage.clickonHeadProfile();
		homepage.clickonSignOutLink();
	}
	
	@Test(testName="Request Creation by using 'Is Attachment Required at the time of Approval?' setting")
	public void RequestAttachmentRequiredAtTheTimeOfApproval() throws Exception
	{
		LoginPage loginpage = new LoginPage(driver);
		HomePage homepage = new HomePage(driver);
		CreateRequestPage CreateRequest = new CreateRequestPage(driver);
		AdminHomePage admin = new AdminHomePage(driver);
		CompanySettingsPage settings = new CompanySettingsPage(driver);
		MyApprovalPage myapproval = new MyApprovalPage(driver);
		loginpage.setUsername(DataLibrary.getdata("Username"));
		loginpage.setPassword(DataLibrary.getdata("Password"));
		loginpage.clickonLogin();
		homepage.clickonCreateMenu();
		homepage.clickonCreateRequestMenu();	
		CreateRequest.setRequestTitle(DataLibrary.getdata("RequestTitle"));
		CreateRequest.clickonMainDocumentBtn();
		WebLibrary.wait(3);
		WebLibrary.RobotKeysFileUpload(AttachmentFiles + "\\Approval.docx");
		WebLibrary.setExplicitWait(CreateRequest.DocumentsList, driver, 30);
		CreateRequest.setSigner1Email(DataLibrary.getdata("Signer1Email"));
		CreateRequest.clickonOtherSettings();
		CreateRequest.clickonAttachmentRequiredYes();
		CreateRequest.setNoOfAttachments(DataLibrary.getdata("NumOfAttachments"));
		CreateRequest.setMandatoryAttachments(DataLibrary.getdata("MandatoryAttachments"));
		WebLibrary.wait(10);
		CreateRequest.clickonNextBtn();
		WebLibrary.setExplicitWait(CreateRequest.DocumentSetupSaveBtn, driver, 20);
		//To Add Signature Field
		CreateRequest.clickonSignature();
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//img[@id='documentPageImage1']"))).build().perform();	
		WebElement target = driver.findElement(By.xpath("//img[@id='documentPageImage1']"));
		int xcord = 99;
		int ycord = 428;
		action.moveToElement(target, xcord, ycord).click().build().perform();
		System.out.println("Signature added successfully");
		
		//To Add Initial Field
		CreateRequest.clickonInitial();
		action.moveToElement(driver.findElement(By.xpath("//img[@id='documentPageImage1']"))).build().perform();
		int xcord1 = 304;
		action.moveToElement(target, xcord1, ycord).click().build().perform();
		System.out.println("Initial added successfully");
		
		//To Add Date Field
		CreateRequest.clickonDate();
		action.moveToElement(driver.findElement(By.xpath("//img[@id='documentPageImage1']"))).build().perform();
		int xcord2 = 514;
		action.moveToElement(target, xcord2, ycord).click().build().perform();
		System.out.println("Date added successfully");
		
		WebLibrary.wait(2);
		
		CreateRequest.clickonSendNowBtn();
		boolean RequestStatus = WebLibrary.verifyTextPresent("Request Sent Successfully");
		if(RequestStatus == true){
			ReportLibrary.test.log(LogStatus.PASS, "Request created and sent for approval successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Request sending for approval failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		
		homepage.clickonHeadProfile();
		homepage.clickonSignOutLink();	
		loginpage.setUsername(DataLibrary.getdata("Signer1Email"));
		loginpage.setPassword(DataLibrary.getdata("Signer1Password"));
		loginpage.clickonLogin();
		homepage.clickonNeedToSign();
		WebLibrary.setExplicitWait(homepage.NeedToSignPage, driver, 60);
		driver.findElement(By.xpath("(//table)[2]/tbody/tr/td[2]/div[contains(text(),'"+DataLibrary.getdata("RequestTitle")+"')]")).click();
		WebLibrary.setExplicitWait(myapproval.StartBtn, driver, 60);
		myapproval.clickonSignHere();
		if(driver.findElement(By.xpath("//div[@id='createSignContentDiv']")).isDisplayed()){
			myapproval.setTypeSignature(DataLibrary.getdata("SignatureName"));
			myapproval.clickonTypeApplyBtn();
			myapproval.clickonAcceptOKBtn();
		}else{
			myapproval.clickonAcceptOKBtn();
		}
		myapproval.clickonInitialHere();
		if(driver.findElement(By.xpath("//div[@id='createSignContentDiv']")).isDisplayed()){
			myapproval.setTypeSignature(DataLibrary.getdata("InitialName"));
			myapproval.clickonTypeApplyBtn();
			myapproval.clickonAcceptOKBtn();
		}else{
			myapproval.clickonAcceptOKBtn();
		}
		
		myapproval.clickonCalendarIcon1();
		WebLibrary.selectDate(DataLibrary.getdata("Date"));
		myapproval.ScrollToViewAttachBtn();
		WebLibrary.wait(2);
		myapproval.clickonAttachRequiredDocument();
		WebLibrary.wait(3);
		Runtime.getRuntime().exec(AutoItPath + "\\OrientationPolicies.exe");
		WebLibrary.setExplicitWait(myapproval.Attachment1, driver, 30);
		myapproval.clickonFinishBtn();
		myapproval.clickonAcceptOKBtn();
		//myapproval.clickonNextBtn();
		boolean AttachmentValidation1 = WebLibrary.verifyTextPresent("Please upload the documents for attachment.");
		if(AttachmentValidation1 == true){
			ReportLibrary.test.log(LogStatus.PASS, "Attachments Validation displayed successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Attachments Validation is not displaying"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		WebLibrary.wait(3);
		//driver.switchTo().activeElement().sendKeys(Keys.ESCAPE);
		myapproval.clickonAttachRequiredDocument();
		WebLibrary.wait(3);
		Runtime.getRuntime().exec(AutoItPath + "\\Attachment1.exe");
		//WebLibrary.RobotKeysFileUpload(AttachmentFiles + "\\Agreement.pdf");
		WebLibrary.setExplicitWait(myapproval.Attachment2, driver, 30);

		boolean AttachmentValidation2 = WebLibrary.verifyTextPresent("File Uploaded successfully");
		if(AttachmentValidation2 == true){
			ReportLibrary.test.log(LogStatus.PASS, "File Uploaded successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "File Uploaded Failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		WebLibrary.wait(2);
		//driver.switchTo().activeElement().sendKeys(Keys.ESCAPE);
		myapproval.clickonAttachRequiredDocument();
		WebLibrary.wait(3);
		Runtime.getRuntime().exec(AutoItPath + "\\LeaveRequestForm.exe");
		//WebLibrary.RobotKeysFileUpload(AttachmentFiles + "\\Leave Request Form.docx");
		WebLibrary.setExplicitWait(myapproval.Attachment3, driver, 60);
		WebLibrary.setExplicitWait(myapproval.FinishBtn, driver, 30);
		myapproval.clickonFinishBtn();	
		myapproval.clickonAcceptOKBtn();
		WebLibrary.wait(2);	
		boolean ApprovalStatus = WebLibrary.verifyTextPresent("You have successfully completed the signing process for this document");
		if(ApprovalStatus == true){
			ReportLibrary.test.log(LogStatus.PASS, "Request approval process done successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Request approval process failed" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		myapproval.clickonBackBtn();
		homepage.clickonHeadProfile();
		homepage.clickonSignOutLink();
	}
	
	@Test(testName="Template creation and activation, Request creation by using same template ")
	public void TemplateCreationActivationAndRequestCreationApprovalProcess() throws Exception
	{
		LoginPage loginpage = new LoginPage(driver);
		HomePage homepage = new HomePage(driver);
		CreateTemplatePage CreateTemplate = new CreateTemplatePage(driver);
		TemplatesPage template = new TemplatesPage(driver);
		CreateRequestPage CreateRequest = new CreateRequestPage(driver);
		MyApprovalPage myapproval = new MyApprovalPage(driver);
		loginpage.setUsername(DataLibrary.getdata("Username"));
		loginpage.setPassword(DataLibrary.getdata("Password"));
		loginpage.clickonLogin();
		homepage.clickonCreateMenu();
		homepage.clickonCreateTemplateMenu();
		CreateTemplate.setTemplateName(DataLibrary.getdata("TemplateName"));
		CreateTemplate.setAcceptanceMode(DataLibrary.getdata("AcceptanceMode"));
		CreateTemplate.clickonMainDocumentBtn();
		WebLibrary.wait(3);
		WebLibrary.RobotKeysFileUpload(AttachmentFiles + "\\Approval.docx");
		WebLibrary.setExplicitWait(CreateTemplate.DocumentsList, driver, 60);
		CreateTemplate.setSigner1Email(DataLibrary.getdata("Signer1Email"));
		CreateTemplate.setSigner1FirstName(DataLibrary.getdata("Signer1FirstName"));
		CreateTemplate.setSigner1LastName(DataLibrary.getdata("Signer1LastName"));
		CreateTemplate.clickonAddSignerIcon();
		CreateTemplate.setSigner2Email(DataLibrary.getdata("Signer2Email"));
		CreateTemplate.setSigner2FirstName(DataLibrary.getdata("Signer2FirstName"));
		CreateTemplate.setSigner2LastName(DataLibrary.getdata("Signer2LastName"));
		CreateTemplate.clickonAddSignerIcon();
		CreateTemplate.setSigner3Email(DataLibrary.getdata("Signer3Email"));
		CreateTemplate.setSigner3FirstName(DataLibrary.getdata("Signer3FirstName"));
		CreateTemplate.setSigner3LastName(DataLibrary.getdata("Signer3LastName"));
		CreateTemplate.setSigner2Approver(DataLibrary.getdata("Signer2ApproverOrder"));
		CreateTemplate.setSigner3Approver(DataLibrary.getdata("Signer3ApproverOrder"));		
		CreateTemplate.clickonNextBtn();
		WebLibrary.setExplicitWait(CreateTemplate.DocumentSetupSaveBtn, driver, 40);
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
		WebLibrary.setExplicitWait(CreateTemplate.Initial, driver, 60);
		//To Add Custom fields for Signer 2
		CreateTemplate.setSignerSelection(DataLibrary.getdata("Signer2Email"));
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
		WebLibrary.setExplicitWait(CreateTemplate.Initial, driver, 60);
		//To Add Custom fields for Signer 3
		CreateTemplate.setSignerSelection(DataLibrary.getdata("Signer3Email"));
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
			ReportLibrary.test.log(LogStatus.PASS, "Template created and activated successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Template activation failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		CreateTemplate.setTemplatesDocPreview();
		WebLibrary.setExplicitWait(template.MoreBtn, driver, 30);
		template.clickonMoreBtn();
		template.clickonNewRequest();
		CreateRequest.setRequestTitle(DataLibrary.getdata("RequestTitle"));
		CreateRequest.clickonNextBtn();
		CreateRequest.clickonSendNowBtn();
		WebLibrary.wait(2);
		boolean RequestStatus = WebLibrary.verifyTextPresent("Request Sent Successfully");
		if(RequestStatus == true){
			ReportLibrary.test.log(LogStatus.PASS, "Request created and sent for approval successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Request sending for approval failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}	
		homepage.clickonHeadProfile();
		homepage.clickonSignOutLink();
		 
		// Signer1 Approval Process
		loginpage.setUsername(DataLibrary.getdata("Signer1Email"));
		loginpage.setPassword("testing");
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
		
		// Signer3 Approval Process
		loginpage.setUsername(DataLibrary.getdata("Signer3Email"));
		loginpage.setPassword("test0101");
		loginpage.clickonLogin();
		homepage.clickonNeedToSign();
		WebLibrary.setExplicitWait(homepage.NeedToSignPage, driver, 60);
		driver.findElement(By.xpath("(//table)[2]/tbody/tr/td[2]/div[contains(text(),'"+DataLibrary.getdata("RequestTitle")+"')]")).click();
		WebLibrary.setExplicitWait(myapproval.StartBtn, driver, 60);
		myapproval.clickonSignHere();
		if(driver.findElement(By.xpath("//div[@id='createSignContentDiv']")).isDisplayed()){
			myapproval.setTypeSignature(DataLibrary.getdata("Signer3FirstName"));
			myapproval.clickonTypeApplyBtn();
			myapproval.clickonAcceptOKBtn();
		}else{
			myapproval.clickonAcceptOKBtn();
		}
		myapproval.clickonInitialHere();
		if(driver.findElement(By.xpath("//div[@id='createSignContentDiv']")).isDisplayed()){
			myapproval.setTypeSignature(DataLibrary.getdata("Signer3LastName"));
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
		boolean Signer3ApprovalStatus = WebLibrary.verifyTextPresent("You have successfully completed the signing process for this document");
		if(Signer3ApprovalStatus == true){
			ReportLibrary.test.log(LogStatus.PASS, "Signer 3 : Request approval process done successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Signer 3 : Request approval process failed" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}

		myapproval.clickonBackBtn();
		homepage.clickonHeadProfile();
		homepage.clickonSignOutLink();
		
		// Signer2 Approval Process
		loginpage.setUsername(DataLibrary.getdata("Signer2Email"));
		loginpage.setPassword("testing");
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
	//	myapproval.clickonStartBtn();
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
	}

	@Test(testName="Group Request Template and Request creation")
	public void GroupRequestApprovalProcess() throws Exception
	{
		LoginPage loginpage = new LoginPage(driver);
		HomePage homepage = new HomePage(driver);
		AdminHomePage admin = new AdminHomePage(driver);
		GroupsPage group = new GroupsPage(driver);
		CreateTemplatePage CreateTemplate = new CreateTemplatePage(driver);
		CustomizePage batchjob = new CustomizePage(driver);
		CreateGroupRequest GroupRequest = new CreateGroupRequest(driver);
		MyApprovalPage myapproval = new MyApprovalPage(driver);
		loginpage.setUsername(DataLibrary.getdata("Username"));
		loginpage.setPassword(DataLibrary.getdata("Password"));
		loginpage.clickonLogin();
		homepage.clickonCreateMenu();
		homepage.clickonCreateTemplateMenu();
		CreateTemplate.setTemplateName(DataLibrary.getdata("TemplateName"));
		CreateTemplate.setAcceptanceMode(DataLibrary.getdata("AcceptanceMode"));
		CreateTemplate.clickonMainDocumentBtn();
		WebLibrary.wait(3);
		WebLibrary.RobotKeysFileUpload(AttachmentFiles + "\\Leave Request Form.docx");
		WebLibrary.setExplicitWait(CreateTemplate.DocumentsList, driver, 60);
		CreateTemplate.clickonNextBtn();
		WebLibrary.setExplicitWait(CreateTemplate.DocumentSetupSaveBtn, driver, 20);
		CreateTemplate.clickonTextbox();
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//img[@id='documentPageImage1']"))).build().perform();
		WebElement target = driver.findElement(By.xpath("//img[@id='documentPageImage1']"));
		int xcord3 = 195;
		int ycord3 = 205;
		action.moveToElement(target, xcord3, ycord3).click().build().perform();
		System.out.println("Textbox added successfully");
		WebLibrary.wait(3);
		CreateTemplate.clickonTextbox();
		action.moveToElement(driver.findElement(By.xpath("//img[@id='documentPageImage1']"))).build().perform();
		action.moveToElement(target, 143, 236).click().build().perform();
		System.out.println("Textbox added successfully");
		WebLibrary.wait(3);
		CreateTemplate.clickonCheckbox();
		action.moveToElement(driver.findElement(By.xpath("//img[@id='documentPageImage1']"))).build().perform();
		action.moveToElement(target, 102, 308).click().build().perform();
		System.out.println("Checkbox added successfully");
		WebLibrary.wait(3);
		action.moveToElement(driver.findElement(By.xpath("//span[@id='jqueryUnique3']"))).build().perform();
		driver.findElement(By.xpath("//span[@id='jqueryUnique3']/img[@id='setRadioGroupNameImage']")).click();
		WebLibrary.setExplicitWait(CreateTemplate.GroupName, driver, 20);
		CreateTemplate.setGroupName(DataLibrary.getdata("CheckboxGroupName"));
		CreateTemplate.clickonSetGroup();
		WebLibrary.wait(2);
		action.moveToElement(driver.findElement(By.xpath("//span[@id='jqueryUnique3']"))).build().perform();
		driver.findElement(By.xpath("//span[@id='jqueryUnique3']/img[@id='copyImage']")).click();
		action.moveToElement(target, 265, 308).click().build().perform();
		CreateTemplate.clickonDate();
		action.moveToElement(driver.findElement(By.xpath("//img[@id='documentPageImage1']"))).build().perform();
		action.moveToElement(target, 252, 401).click().build().perform();
		System.out.println("Date added successfully");
		WebLibrary.wait(4);
		CreateTemplate.clickonDate();
		action.moveToElement(driver.findElement(By.xpath("//img[@id='documentPageImage1']"))).build().perform();
		action.moveToElement(target, 532, 401).click().build().perform();
		System.out.println("Date added successfully");
		WebLibrary.wait(4);
		CreateTemplate.clickonSignature();
		action.moveToElement(driver.findElement(By.xpath("//img[@id='documentPageImage1']"))).build().perform();	
		action.moveToElement(target, 74, 737).click().build().perform();
		System.out.println("Signature added successfully");
		WebLibrary.wait(2);
		CreateTemplate.clickonDocumentSetupActivateBtn();
		WebLibrary.wait(3);
		boolean TemplateStatus = WebLibrary.verifyTextPresent("Template activated successfully");
		if(TemplateStatus == true){
			ReportLibrary.test.log(LogStatus.PASS, "Template created and activated successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Template activation failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		WebLibrary.wait(2);
		homepage.clickonTemplatesMenu();
		String TemplateName =driver.findElement(By.xpath("//table/tbody/tr/td[2]/div[contains(text(),'"+DataLibrary.getdata("TemplateName")+"')]")).getText();
		String ReplaceTemplateName = TemplateName.replace('{', '(');
		String LatestTemplateName = ReplaceTemplateName.replace('}', ')');
		System.out.println(LatestTemplateName);
		
		homepage.clickonHeadProfile();
		homepage.clickonAdminLink();
		admin.clickonCompanyMenu();
		admin.clickonGroupsMenu();
		WebLibrary.setExplicitWait(group.CreateGroupIcon, driver, 30);
		group.clickonCreateGroupIcon();
		WebLibrary.setExplicitWait(group.GroupName, driver, 30);
		group.setGroupName(DataLibrary.getdata("ValidGroupName"));
		group.clickonBrowseBtn();
		WebLibrary.wait(5);
		Runtime.getRuntime().exec(AutoItPath + "\\SampleGroupUsers.exe");
		//WebLibrary.RobotKeysFileUpload(AttachmentFiles + "\\SampleGroupUsers.csv");
		WebLibrary.wait(3);
		group.clickonSaveBtn();
		WebLibrary.wait(2);
		boolean GroupSuccessMsg = WebLibrary.verifyTextPresent("Group Created Successfully");
		if(GroupSuccessMsg == true){
			ReportLibrary.test.log(LogStatus.PASS, "Group Created successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Group Creation failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		driver.navigate().refresh();
		String GroupId =driver.findElement(By.xpath("//table/tbody/tr/td[2]/div[contains(text(),'"+DataLibrary.getdata("ValidGroupName")+"')]/parent::td/preceding-sibling::td[1]/div")).getText();
		System.out.println(GroupId);
		homepage.clickonLogo();
		//Group Request Creation
		homepage.clickonCreateMenu();
		homepage.clickonCreateGroupRequestMenu();
		GroupRequest.setRequestTitle(DataLibrary.getdata("GroupRequestTitle"));
		GroupRequest.setSelectTemplate(LatestTemplateName);
		GroupRequest.SelectSignerGroup(GroupId);
		GroupRequest.clickonSendNowBtn();
		WebLibrary.wait(2);
		boolean GroupRequestStatus = WebLibrary.verifyTextPresent("Request(s) created successfully");
		if(GroupRequestStatus == true){
			ReportLibrary.test.log(LogStatus.PASS, "Group Request sent for approval successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Group Request sent for approval failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		// Running Batchjob for sending Group Requests immediately
		
		homepage.clickonHeadProfile();
		homepage.clickonAdminLink();
		admin.clickonCustomizeMenu();
		admin.clickonBatchJobsMenu();
		batchjob.clickonEditRequestNotification();
		batchjob.setHours(DataLibrary.getdata("Hours"));
		batchjob.setMinutes(DataLibrary.getdata("Minutes"));
		batchjob.clickonRunNowBtn();
		WebLibrary.setExplicitWait(batchjob.RunNowOKBtn, driver, 30);
		batchjob.clickonRunNowOkBtn();
		boolean BatchjobMsg = WebLibrary.verifyTextPresent("Notification Job Successful");
		if(BatchjobMsg == true){
			ReportLibrary.test.log(LogStatus.PASS, "RequestNotification Batchjob runned successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "RequestNotification Batchjob run failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		admin.clickonCustomizeMenu();
		admin.clickonBatchJobsMenu();
		batchjob.clickonEditRequestPending();
		batchjob.setHours(DataLibrary.getdata("Hours"));
		batchjob.setMinutes(DataLibrary.getdata("Minutes"));
		batchjob.clickonRunNowBtn();
		WebLibrary.setExplicitWait(batchjob.RunNowOKBtn, driver, 30);
		batchjob.clickonRunNowOkBtn();
		boolean BatchjobMsg1 = WebLibrary.verifyTextPresent("Request Pending Job Successful");
		if(BatchjobMsg1 == true){
			ReportLibrary.test.log(LogStatus.PASS, "RequestPending Batchjob runned successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "RequestPending Batchjob run failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		
		homepage.clickonHeadProfile();
		homepage.clickonSignOutLink();

		//Signer1 Main Approver Approval Process
		loginpage.setUsername(DataLibrary.getdata("Signer1MainApprover"));
		loginpage.setPassword(DataLibrary.getdata("Signer1MainApproverPassword"));
		loginpage.clickonLogin();
		homepage.clickonNeedToSign();
		WebLibrary.setExplicitWait(homepage.NeedToSignPage, driver, 60);
		driver.findElement(By.xpath("(//table)[2]/tbody/tr/td[2]/div[contains(text(),'"+DataLibrary.getdata("GroupRequestTitle")+"')]")).click();
		WebLibrary.wait(3);
		WebLibrary.setExplicitWait(myapproval.StartBtn, driver, 60);
		myapproval.setEmployeeName(DataLibrary.getdata("Signer1EmployeeName"));
		driver.switchTo().activeElement().sendKeys(Keys.TAB);
		driver.switchTo().activeElement().sendKeys("Shravani");
		driver.switchTo().activeElement().sendKeys(Keys.TAB);
		driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();
		myapproval.clickonCalendarIcon1();
		WebLibrary.selectDate(DataLibrary.getdata("FromDate"));
		myapproval.clickonCalendarIcon2();
		WebLibrary.selectDate(DataLibrary.getdata("ToDate"));
		myapproval.clickonSignHere();
		if(driver.findElement(By.xpath("//div[@id='createSignContentDiv']")).isDisplayed()){
			myapproval.setTypeSignature(DataLibrary.getdata("Signer1EmployeeName"));
			myapproval.clickonTypeApplyBtn();
			myapproval.clickonAcceptOKBtn();
		}else{
			myapproval.clickonAcceptOKBtn();
		}
		WebLibrary.wait(2);
		//myapproval.clickonStartBtn();
		myapproval.clickonFinishBtn();	
		myapproval.clickonAcceptOKBtn();
		WebLibrary.wait(2);	
		boolean ApprovalStatus = WebLibrary.verifyTextPresent("You have successfully completed the signing process for this document");
		if(ApprovalStatus == true){
			ReportLibrary.test.log(LogStatus.PASS, "Request approval process with multiple documents done successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Signer 1 : Request approval process with multiple documents failed" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		myapproval.clickonBackBtn();
		homepage.clickonHeadProfile();
		homepage.clickonSignOutLink();
		
		//Signer2 Main Approver Approval Process
		loginpage.setUsername(DataLibrary.getdata("Signer2ProxyApprover"));
		loginpage.setPassword(DataLibrary.getdata("Signer2ProxyApproverPassword"));
		loginpage.clickonLogin();
		homepage.clickonNeedToSign();
		WebLibrary.setExplicitWait(homepage.NeedToSignPage, driver, 60);
		driver.findElement(By.xpath("(//table)[2]/tbody/tr/td[2]/div[contains(text(),'"+DataLibrary.getdata("GroupRequestTitle")+"')]")).click();
		WebLibrary.wait(3);
		WebLibrary.setExplicitWait(myapproval.StartBtn, driver, 60);
		myapproval.setEmployeeName(DataLibrary.getdata("Signer2EmployeeName"));
		driver.switchTo().activeElement().sendKeys(Keys.TAB);
		driver.switchTo().activeElement().sendKeys("Shravani");
		driver.switchTo().activeElement().sendKeys(Keys.TAB);
		driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();
		myapproval.clickonCalendarIcon1();
		WebLibrary.selectDate(DataLibrary.getdata("FromDate"));
		myapproval.clickonCalendarIcon2();
		WebLibrary.selectDate(DataLibrary.getdata("ToDate"));
		myapproval.clickonSignHere();
		if(driver.findElement(By.xpath("//div[@id='createSignContentDiv']")).isDisplayed()){
			myapproval.setTypeSignature(DataLibrary.getdata("Signer2EmployeeName"));
			myapproval.clickonTypeApplyBtn();
			myapproval.clickonAcceptOKBtn();
		}else{
			myapproval.clickonAcceptOKBtn();
		}
		WebLibrary.wait(2);
		//myapproval.clickonStartBtn();
		myapproval.clickonFinishBtn();	
		myapproval.clickonAcceptOKBtn();
		WebLibrary.wait(2);	
		boolean Signer2ApprovalStatus = WebLibrary.verifyTextPresent("You have successfully completed the signing process for this document");
		if(Signer2ApprovalStatus == true){
			ReportLibrary.test.log(LogStatus.PASS, "Request approval process with multiple documents done successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Signer 1 : Request approval process with multiple documents failed" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		myapproval.clickonBackBtn();
		homepage.clickonHeadProfile();
		homepage.clickonSignOutLink();
		
	}
		
	@Test(dependsOnMethods = { "GroupRequestApprovalProcess" })
	public void GroupRequestApprovalProcessbyUploadingSignersFile() throws Exception
	{
		LoginPage loginpage = new LoginPage(driver);
		HomePage homepage = new HomePage(driver);
		AdminHomePage admin = new AdminHomePage(driver);
		CustomizePage batchjob = new CustomizePage(driver);
		CreateGroupRequest GroupRequest = new CreateGroupRequest(driver);
		MyApprovalPage myapproval = new MyApprovalPage(driver);
		/*loginpage.setUsername("sravyab@ibt.example.com");
		loginpage.setPassword("testing");*/
		loginpage.setUsername(DataLibrary.getdata("Username"));
		loginpage.setPassword(DataLibrary.getdata("Password"));
		loginpage.clickonLogin();
		homepage.clickonTemplatesMenu();
		String TemplateName =driver.findElement(By.xpath("//table/tbody/tr/td[2]/div[contains(text(),'"+DataLibrary.getdata("TemplateName")+"')]")).getText();
		String ReplaceTemplateName = TemplateName.replace('{', '(');
		String LatestTemplateName = ReplaceTemplateName.replace('}', ')');
		System.out.println(LatestTemplateName);

		homepage.clickonCreateMenu();
		homepage.clickonCreateGroupRequestMenu();
		GroupRequest.setRequestTitle(DataLibrary.getdata("GroupRequestTitle"));
		GroupRequest.setSelectTemplate(LatestTemplateName);
		WebLibrary.setExplicitWait(GroupRequest.BrowseBtn, driver, 30);
		GroupRequest.clickonBrowseBtn();
		WebLibrary.wait(5);
		Runtime.getRuntime().exec(AutoItPath + "\\SignersGroup.exe");
		//WebLibrary.RobotKeysFileUpload(AttachmentFiles + "\\SignersGroup.csv");
		WebLibrary.wait(7);
		GroupRequest.clickonSendNowBtn();
		/*boolean InvalidFileMsg = WebLibrary.verifyTextPresent("Upload valid file");
		if(InvalidFileMsg == true){
			ReportLibrary.test.log(LogStatus.PASS, "Validation displayed successfully when invalid file is uploaded" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Validation is not displaying when invalid file is uploaded"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}*/
		WebLibrary.wait(2);
		boolean GroupRequestStatus = WebLibrary.verifyTextPresent("Request(s) created successfully");
		if(GroupRequestStatus == true){
			ReportLibrary.test.log(LogStatus.PASS, "Group Request sent for approval successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Group Request sent for approval failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		
		// Running Batchjob for sending Group Requests immediately
		homepage.clickonHeadProfile();
		homepage.clickonAdminLink();
		admin.clickonCustomizeMenu();
		admin.clickonBatchJobsMenu();
		batchjob.clickonEditRequestNotification();
		batchjob.setHours(DataLibrary.getdata("Hours"));
		batchjob.setMinutes(DataLibrary.getdata("Minutes"));
		batchjob.clickonRunNowBtn();
		WebLibrary.setExplicitWait(batchjob.RunNowOKBtn, driver, 30);
		batchjob.clickonRunNowOkBtn();
		boolean BatchjobMsg = WebLibrary.verifyTextPresent("Notification Job Successful");
		if(BatchjobMsg == true){
			ReportLibrary.test.log(LogStatus.PASS, "RequestNotification Batchjob runned successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "RequestNotification Batchjob run failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		admin.clickonCustomizeMenu();
		admin.clickonBatchJobsMenu();
		batchjob.clickonEditRequestPending();
		batchjob.setHours(DataLibrary.getdata("Hours"));
		batchjob.setMinutes(DataLibrary.getdata("Minutes"));
		batchjob.clickonRunNowBtn();
		WebLibrary.setExplicitWait(batchjob.RunNowOKBtn, driver, 30);
		batchjob.clickonRunNowOkBtn();
		boolean BatchjobMsg1 = WebLibrary.verifyTextPresent("Request Pending Job Successful");
		if(BatchjobMsg1 == true){
			ReportLibrary.test.log(LogStatus.PASS, "RequestPending Batchjob runned successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "RequestPending Batchjob run failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		
		homepage.clickonHeadProfile();
		homepage.clickonSignOutLink();
		
		//Signer1 Main Approver Approval Process
		loginpage.setUsername(DataLibrary.getdata("Signer1MainApprover"));
		loginpage.setPassword(DataLibrary.getdata("Signer1MainApproverPassword"));
		loginpage.clickonLogin();
		homepage.clickonNeedToSign();
		WebLibrary.setExplicitWait(homepage.NeedToSignPage, driver, 60);
		driver.findElement(By.xpath("(//table)[2]/tbody/tr/td[2]/div[contains(text(),'"+DataLibrary.getdata("GroupRequestTitle")+"')]")).click();
		WebLibrary.wait(3);
		WebLibrary.setExplicitWait(myapproval.StartBtn, driver, 60);
		myapproval.setEmployeeName(DataLibrary.getdata("Signer1EmployeeName"));
		driver.switchTo().activeElement().sendKeys(Keys.TAB);
		driver.switchTo().activeElement().sendKeys("Shravani");
		driver.switchTo().activeElement().sendKeys(Keys.TAB);
		driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();
		myapproval.clickonCalendarIcon1();
		WebLibrary.selectDate(DataLibrary.getdata("FromDate"));
		myapproval.clickonCalendarIcon2();
		WebLibrary.selectDate(DataLibrary.getdata("ToDate"));
		myapproval.clickonSignHere();
		if(driver.findElement(By.xpath("//div[@id='createSignContentDiv']")).isDisplayed()){
			myapproval.setTypeSignature(DataLibrary.getdata("Signer1EmployeeName"));
			myapproval.clickonTypeApplyBtn();
			myapproval.clickonAcceptOKBtn();
		}else{
			myapproval.clickonAcceptOKBtn();
		}
		WebLibrary.wait(2);
		//myapproval.clickonStartBtn();
		myapproval.clickonFinishBtn();	
		myapproval.clickonAcceptOKBtn();
		WebLibrary.wait(2);	
		boolean ApprovalStatus = WebLibrary.verifyTextPresent("You have successfully completed the signing process for this document");
		if(ApprovalStatus == true){
			ReportLibrary.test.log(LogStatus.PASS, "Request approval process with multiple documents done successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Signer 1 : Request approval process with multiple documents failed" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		myapproval.clickonBackBtn();
		homepage.clickonHeadProfile();
		homepage.clickonSignOutLink();
		
		//Signer2 Main Approver Approval Process
		loginpage.setUsername(DataLibrary.getdata("Signer2ProxyApprover"));
		loginpage.setPassword(DataLibrary.getdata("Signer2ProxyApproverPassword"));
		loginpage.clickonLogin();
		homepage.clickonNeedToSign();
		WebLibrary.setExplicitWait(homepage.NeedToSignPage, driver, 60);
		driver.findElement(By.xpath("(//table)[2]/tbody/tr/td[2]/div[contains(text(),'"+DataLibrary.getdata("GroupRequestTitle")+"')]")).click();
		WebLibrary.wait(3);
		WebLibrary.setExplicitWait(myapproval.StartBtn, driver, 60);
		myapproval.setEmployeeName(DataLibrary.getdata("Signer2EmployeeName"));
		driver.switchTo().activeElement().sendKeys(Keys.TAB);
		driver.switchTo().activeElement().sendKeys("Shravani");
		driver.switchTo().activeElement().sendKeys(Keys.TAB);
		driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();
		myapproval.clickonCalendarIcon1();
		WebLibrary.selectDate(DataLibrary.getdata("FromDate"));
		myapproval.clickonCalendarIcon2();
		WebLibrary.selectDate(DataLibrary.getdata("ToDate"));
		myapproval.clickonSignHere();
		if(driver.findElement(By.xpath("//div[@id='createSignContentDiv']")).isDisplayed()){
			myapproval.setTypeSignature(DataLibrary.getdata("Signer2EmployeeName"));
			myapproval.clickonTypeApplyBtn();
			myapproval.clickonAcceptOKBtn();
		}else{
			myapproval.clickonAcceptOKBtn();
		}
		WebLibrary.wait(2);
		//myapproval.clickonStartBtn();
		myapproval.clickonFinishBtn();	
		myapproval.clickonAcceptOKBtn();
		WebLibrary.wait(2);	
		boolean Signer2ApprovalStatus = WebLibrary.verifyTextPresent("You have successfully completed the signing process for this document");
		if(Signer2ApprovalStatus == true){
			ReportLibrary.test.log(LogStatus.PASS, "Request approval process with multiple documents done successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Signer 1 : Request approval process with multiple documents failed" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		myapproval.clickonBackBtn();
		homepage.clickonHeadProfile();
		homepage.clickonSignOutLink();
	}

	@Test(testName="In-Person Template and Request creation")
	public void InPersonRequestCreation() throws Exception
	{
		LoginPage loginpage = new LoginPage(driver);
		HomePage homepage = new HomePage(driver);
		CreateTemplatePage CreateTemplate = new CreateTemplatePage(driver);
		CreateInPersonRequest InPerson = new CreateInPersonRequest(driver);
		loginpage.setUsername(DataLibrary.getdata("Username"));
		loginpage.setPassword(DataLibrary.getdata("Password"));
		loginpage.clickonLogin();
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
		
		WebLibrary.setExplicitWait(CreateTemplate.DocumentSetupSaveBtn, driver, 40);
		
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
		InPerson.clickonCreateRequestBtn();
		boolean TemplateSelectionErr = WebLibrary.verifyTextPresent("Please select the Template");
		if(TemplateSelectionErr == true){
			ReportLibrary.test.log(LogStatus.PASS, "Validation msg got displayed succesffully when Template not selected" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Validation msg not displaying when Template not selected"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		InPerson.setSelectTemplate(LatestTemplateName);
		WebLibrary.wait(3);
		WebLibrary.setExplicitWait(InPerson.CreateRequestBtn, driver, 30);
		InPerson.clickonCreateRequestBtn();
		boolean RequestTitleErr = WebLibrary.verifyTextPresent("Request title is required");
		if(RequestTitleErr == true){
			ReportLibrary.test.log(LogStatus.PASS, "Validation msg got displayed succesfully when Request Title is empty" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Validation msg not displaying when Request Title is empty"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		WebLibrary.setExplicitWait(InPerson.RequestTitle, driver, 30);
		InPerson.setRequestTitle(DataLibrary.getdata("RequestTitle"));
		InPerson.clickonReplaceDocumentIcon();
		WebLibrary.wait(4);
		WebLibrary.RobotKeysFileUpload(AttachmentFiles + "\\Approval.docx");
		WebLibrary.setExplicitWait(InPerson.UndoReplacedDocumentIcon, driver, 30);
		boolean ReplaceDocMsg = WebLibrary.verifyTextPresent("Document Replaced Successfully");
		if(ReplaceDocMsg == true){
			ReportLibrary.test.log(LogStatus.PASS, "Validation msg got displayed succesfully after replacing document" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Validation msg not displaying after replacing document"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		InPerson.clickonUndoReplacedDocumentIcon();
		boolean UndoReplaceDocMsg = WebLibrary.verifyTextPresent("Replaced document cancelled successfully");
		if(UndoReplaceDocMsg == true){
			ReportLibrary.test.log(LogStatus.PASS, "Validation msg got displayed succesfully after cancelling replacing document" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Validation msg not displaying after cancelling replacing document"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		WebLibrary.setExplicitWait(InPerson.CreateRequestBtn, driver, 30);
		InPerson.clickonCreateRequestBtn();
		WebLibrary.wait(2);
		boolean InPersonRequestStatus = WebLibrary.verifyTextPresent("In-Person Request created successfully");
		if(InPersonRequestStatus == true){
			ReportLibrary.test.log(LogStatus.PASS, "In-Person Request sent for approval successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "In-Person Request sent for approval failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		homepage.clickonHeadProfile();
		homepage.clickonSignOutLink();
	}
}

	
	



