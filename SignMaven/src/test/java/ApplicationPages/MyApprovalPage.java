package ApplicationPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.LogStatus;

import FrameworkLibrary.ReportLibrary;
import FrameworkLibrary.WebLibrary;

public class MyApprovalPage {
	
	WebDriver driver;
	boolean stepstatus;
	public MyApprovalPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH,using="//img[@src='images/sign_here1.jpg']")
	WebElement SignHere;

	@FindBy(how=How.XPATH,using="//img[@src='images/initial_here.jpg']")
	WebElement InitialHere;
	
	@FindBy(how=How.XPATH,using="//input[@id='typeUserName']")
	WebElement TypeSignature;
	
	@FindBy(how=How.XPATH,using="(//input[@value='Apply'])[1]")
	WebElement TypeApplyBtn;
	
	@FindBy(how=How.XPATH,using="//button[text()='OK']")
	WebElement AcceptOKBtn;
	
	@FindBy(how=How.XPATH,using="(//button[text()='OK'])[2]")
	WebElement NextDocumentOKBtn;
	
	@FindBy(how=How.XPATH,using="//input[@placeholder='Text Box']")
	WebElement TextBox;
	
	@FindBy(how=How.XPATH,using="//i[@class='fa fa-calendar']")
	WebElement CalendarIcon1;
	
	@FindBy(how=How.XPATH,using="(//i[@class='fa fa-calendar'])[2]")
	WebElement CalendarIcon2;
	
	@FindBy(how=How.XPATH,using="//table/tbody/tr/td")
	WebElement SelectDate;
	
	@FindBy(how=How.XPATH,using="//button[contains(text(),'More')]")
	public WebElement MoreBtn;
	
	@FindBy(how=How.XPATH,using="//a[@onclick='mainDocumentPreviewDetailsFunction();']")
	WebElement DocumentDetails;
	
	@FindBy(how=How.XPATH,using="//h4[@id='myModalLabel']")
	public WebElement Popup;
	
	@FindBy(how=How.XPATH,using="//a[@onclick='commentsSubmit();']")
	WebElement Comments;
	
	@FindBy(how=How.XPATH,using="//input[@value='Add comment']")
	WebElement AddCommentBtn;
	
	@FindBy(how=How.ID,using="approverComments")
	WebElement CommentsField;
	
	@FindBy(how=How.XPATH,using="//input[@onclick='saveComments();']")
	WebElement SaveCommentBtn;
	
	@FindBy(how=How.XPATH,using="//a[@onclick='reqSubmitApprovalOrderSubmit();']")
	WebElement ApprovalOrder;
	
	@FindBy(how=How.XPATH,using="//h4[contains(text(),'Approval Order')]")
	public WebElement ApprovalOrderPopup;
	
	@FindBy(how=How.XPATH,using="//a[@onclick='showSignatory();']")
	WebElement EmailDocument;
	
	@FindBy(how=How.ID,using="addMoreMailIds")
	WebElement EmailAddressField;
	
	@FindBy(how=How.XPATH,using="//input[@onclick='sendNotifications();']")
	WebElement SendBtn;
	
	@FindBy(how=How.ID,using="Decline")
	WebElement Reject;
	
	@FindBy(how=How.ID,using="Nominate")
	WebElement Forward;
	
	@FindBy(how=How.ID,using="userName")
	WebElement AlternateSigner;
	
	@FindBy(how=How.XPATH,using="//button[text()='Forward']")
	WebElement ForwardBtn;
	
	@FindBy(how=How.ID,using="trandetails")
	WebElement TransactionDetails;
	
	@FindBy(how=How.XPATH,using="//h4[contains(text(),'Transaction Details')]")
	public WebElement TransactionDetailsPopup;
	
	@FindBy(how=How.ID,using="downloadImage")
	WebElement DownloadMainDocument;
	
	@FindBy(how=How.XPATH,using="//h4[contains(text(),'Download Document')]")
	public WebElement ChooseTextFontSizePopup;
	
	@FindBy(how=How.XPATH,using="//select[@id='textFontSizeSelectId']")
	WebElement ChooseFontSize;
	
	@FindBy(how=How.XPATH,using="//input[@value='Proceed']")
	WebElement ProceedBtn;
	
	@FindBy(how=How.ID,using="downloadTansactionFile")
	WebElement DownloadTransactionDocument;
	
	@FindBy(how=How.XPATH,using="//a[contains(text(),' Supporting Documents ')]")
	WebElement SupportingDocuments;
	
	@FindBy(how=How.XPATH,using="//img[@title='Download']")
	WebElement DownloadDocument;
	
	@FindBy(how=How.XPATH,using="//img[@title='Download All']")
	WebElement DownloadAll;
	
	@FindBy(how=How.XPATH,using="//span[@id='file_browse_wrapper']")
	WebElement AttachRequiredDocument;
	
	@FindBy(how=How.XPATH,using="//td[@width='90%'])[1]")
	public WebElement Attachment1;
	
	@FindBy(how=How.XPATH,using="(//td[@width='90%'])[2]")
	public WebElement Attachment2;
	
	@FindBy(how=How.XPATH,using="(//td[@width='90%'])[3]")
	public WebElement Attachment3;
	
	@FindBy(how=How.XPATH,using="//button[@name='start']")
	public WebElement StartBtn;
	
	@FindBy(how=How.XPATH,using="//button[text()='Next']")
	public WebElement NextBtn;
	
	@FindBy(how=How.XPATH,using="//button[text()='Finish']")
	public WebElement FinishBtn;
	
	@FindBy(how=How.XPATH,using="//button[text()='Back']")
	WebElement BackBtn;
	
	@FindBy(how=How.XPATH,using="//div[@id='modalContentDiv']/div/button")
	WebElement CloseIcon;

	public void clickonSignHere()
	{
		stepstatus = WebLibrary.JsclickElement(SignHere, driver);
		ReportLibrary.reportEvent(stepstatus, "Able to click on 'Sign Here' Image", "Unable to click on 'Sign Here' Image",true);
	}
	
	public void clickonInitialHere()
	{
		stepstatus = WebLibrary.JsclickElement(InitialHere, driver);
		ReportLibrary.reportEvent(stepstatus, "Able to click on 'Initial Here' Image", "Unable to click on 'Initial Here' Image",true);
	}
	
	public void setTypeSignature(String StrTypeSignature)
	{
		stepstatus = WebLibrary.setText(TypeSignature, StrTypeSignature);
		ReportLibrary.reportEvent(stepstatus, "Able to enter Signature", "Unable to enter Signature");
	}
	
	public void clickonTypeApplyBtn()
	{
		stepstatus = WebLibrary.clickElement(TypeApplyBtn);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Apply Button", "Unable to click on Apply Button",true);
	}
	
	public void clickonAcceptOKBtn()
	{
		stepstatus = WebLibrary.clickElement(AcceptOKBtn);
		ReportLibrary.reportEvent(stepstatus, "Able to click on 'Ok' button in Accept Terms popup", "Unable to click on 'Ok' button in Accept Terms popup",true);
	}
	
	public void clickonNextDocumentOKBtn()
	{
		stepstatus = WebLibrary.clickElement(NextDocumentOKBtn);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Next Document 'Ok' button in Accept Terms popup", "Unable to click on 'Ok' button in Accept Terms popup",true);
	}
	
	public void setEmployeeName(String StrEmployeeName)
	{
		stepstatus = WebLibrary.setText(TextBox, StrEmployeeName);
		ReportLibrary.reportEvent(stepstatus, "Able to enter Employee Name", "Unable to enter Employee Name");
	}
	
	public void clickonCalendarIcon1()
	{
		stepstatus = WebLibrary.JsclickElement(CalendarIcon1, driver);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Calendar Icon in Date Field", "Unable to click on Calendar Icon in Date Field",true);
	}
	
	public void clickonCalendarIcon2()
	{
		stepstatus = WebLibrary.JsclickElement(CalendarIcon2, driver);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Calendar Icon in Date Field", "Unable to click on Calendar Icon in Date Field",true);
	}
	
	public void setDay(String strDay)
	{
		stepstatus = WebLibrary.setOptionInSelectBox(SelectDate, strDay);
		ReportLibrary.reportEvent(stepstatus, "Able to select date from calendar", "Unable to select date from calendar",true);
	}
	
	public void clickonMoreBtn()
	{
		stepstatus = WebLibrary.clickElement(MoreBtn);
		ReportLibrary.reportEvent(stepstatus, "Able to click on More button", "Unable to click on More button",true);
	}
	
	public void clickonDocumentDetailsOption()
	{
		stepstatus = WebLibrary.clickElement(DocumentDetails);
		ReportLibrary.reportEvent(stepstatus, "Able to click on DocumentDetails option", "Unable to click on DocumentDetails option",true);
	}
	
	public void clickonComments()
	{
		stepstatus = WebLibrary.clickElement(Comments);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Comments option", "Unable to click on Comments option",true);
	}
	
	public void clickonAddCommentBtn()
	{
		stepstatus = WebLibrary.clickElement(AddCommentBtn);
		ReportLibrary.reportEvent(stepstatus, "Able to click on AddCommentBtn button", "Unable to click on AddCommentBtn button",true);
	}
	
	public void setCommentsField(String StrCommentsField)
	{
		stepstatus = WebLibrary.setText(CommentsField, StrCommentsField);
		ReportLibrary.reportEvent(stepstatus, "Able to enter Comments Field", "Unable to enter Comments Field",true);
	}
	
	public void clickonSaveCommentBtn()
	{
		stepstatus = WebLibrary.clickElement(SaveCommentBtn);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Save Comment Button", "Unable to click on Save Comment Button",true);
	}
	
	
	public void clickonApprovalOrder()
	{
		stepstatus = WebLibrary.clickElement(ApprovalOrder);
		ReportLibrary.reportEvent(stepstatus, "Able to click on ApprovalOrder option", "Unable to click on ApprovalOrder option",true);
	}
	
	public void clickonEmailDocument()
	{
		stepstatus = WebLibrary.clickElement(EmailDocument);
		ReportLibrary.reportEvent(stepstatus, "Able to click on EmailDocument option", "Unable to click on EmailDocument option",true);
	}
	
	public void setEmailAddress(String StrEmailAddressField)
	{
		stepstatus = WebLibrary.setText(EmailAddressField, StrEmailAddressField);
		ReportLibrary.reportEvent(stepstatus, "Able to enter Email Address Field", "Unable to enter Email Address Field",true);
	}
	
	public void clickonSendBtn()
	{
		stepstatus = WebLibrary.clickElement(SendBtn);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Send button", "Unable to click on Send buttons",true);
	}
	
	public void clickonReject()
	{
		stepstatus = WebLibrary.clickElement(Reject);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Reject option", "Unable to click on Reject option",true);
	}
	
	public void clickonForward()
	{
		stepstatus = WebLibrary.clickElement(Forward);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Forward option", "Unable to click on Forward option",true);
	}
	
	public void setAlternateSigner(String StrAlternateSigner)
	{
		stepstatus = WebLibrary.setText(AlternateSigner, StrAlternateSigner);
		ReportLibrary.reportEvent(stepstatus, "Able to enter Alternate Signer Field", "Unable to enter Alternate Signer Field",true);
	}
	
	public void clickonForwardBtn()
	{
		stepstatus = WebLibrary.clickElement(ForwardBtn);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Forward Button", "Unable to click on Forward Button",true);
	}
	
	public void clickonTransactionDetails()
	{
		stepstatus = WebLibrary.clickElement(TransactionDetails);
		ReportLibrary.reportEvent(stepstatus, "Able to click on TransactionDetails option", "Unable to click on TransactionDetails option",true);
	}
	
	public void clickonDownloadMainDocument()
	{
		stepstatus = WebLibrary.clickElement(DownloadMainDocument);
		ReportLibrary.reportEvent(stepstatus, "Able to click on DownloadMainDocument option", "Unable to click on DownloadMainDocument option",true);
	}
	
	public void setFontSize(String StrFontSize)
	{
		stepstatus = WebLibrary.setOptionInSelectBox(ChooseFontSize, StrFontSize);
		ReportLibrary.reportEvent(stepstatus, "Able to select font size from dropdown", "Unable to select font size from dropdown",true);
	}
	
	public void clickonProceedBtn()
	{
		stepstatus = WebLibrary.clickElement(ProceedBtn);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Proceed Button", "Unable to click on Proceed Button",true);
	}
	
	public void clickonDownloadTransactionDocument()
	{
		stepstatus = WebLibrary.clickElement(DownloadTransactionDocument);
		ReportLibrary.reportEvent(stepstatus, "Able to click on DownloadTransactionDocument option", "Unable to click on DownloadTransactionDocument option",true);
	}
	
	public void clickonSupportingDocuments()
	{
		stepstatus = WebLibrary.clickElement(SupportingDocuments);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Supporting Documents Menu", "Unable to click on Supporting Documents Menu",true);
	}
	
	public void clickonDownloadDocument()
	{
		stepstatus = WebLibrary.clickElement(DownloadDocument);
		ReportLibrary.reportEvent(stepstatus, "Able to download Documents Menu", "Unable to download Documents Menu",true);
	}
	
	public void clickonDownloadAll()
	{
		stepstatus = WebLibrary.clickElement(DownloadAll);
		ReportLibrary.reportEvent(stepstatus, "Able to click 'Download All' icon", "Unable to click on 'Download All' icon",true);
	}
	
	public void ScrollToViewAttachBtn()
	{
		stepstatus = WebLibrary.JsScrollToWebElement(AttachRequiredDocument, driver);
	}
	
	public void clickonAttachRequiredDocument()
	{
		stepstatus = WebLibrary.clickElement(AttachRequiredDocument);
		ReportLibrary.reportEvent(stepstatus, "Able to click on 'Attach Required Document' button", "Unable to click on AttachRequiredDocument button",true);
	}
	
	public void mousehoveronStartBtn()
	{
		stepstatus = WebLibrary.mouseHover(StartBtn,driver);
		ReportLibrary.reportEvent(stepstatus, "Able to mousehover on Start button", "Unable to mousehover on Start button");
	}
	
	public void clickonStartBtn()
	{
		stepstatus = WebLibrary.clickElement(StartBtn);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Start button", "Unable to click on Start button",true);
	}
	
	public void clickonNextBtn()
	{
		stepstatus = WebLibrary.clickElement(NextBtn);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Next button", "Unable to click on Next button",true);
	}
	
	public void clickonFinishBtn()
	{
		stepstatus = WebLibrary.clickElement(FinishBtn);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Finish button", "Unable to click on Finish button",true);
	}
	
	public void clickonBackBtn()
	{
		stepstatus = WebLibrary.clickElement(BackBtn);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Back button", "Unable to click on Back button",true);
	}
	
	public void clickonCloseIcon()
	{
		stepstatus = WebLibrary.clickElement(CloseIcon);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Close Icon", "Unable to click on Close Icon");
	}
	
}
