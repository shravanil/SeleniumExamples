package ApplicationPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import FrameworkLibrary.ReportLibrary;
import FrameworkLibrary.WebLibrary;

public class RequestPage {
	
	WebDriver driver;
	boolean stepstatus;
	public RequestPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH,using="//span[contains(text(),'Share')]")
	public WebElement Share;

	@FindBy(how=How.XPATH,using="//span[@id='shareEnable']/button")
	WebElement ShareAccessBtn;
	
	@FindBy(how=How.XPATH,using="//button[text()='Print']")
	public WebElement PrintBtn;

	@FindBy(how=How.XPATH,using="//button[text()='Download']")
	WebElement DownloadBtn;

	@FindBy(how=How.XPATH,using="//button[text()='Download Transaction']")
	WebElement DownloadTransBtn;

	@FindBy(how=How.XPATH,using="//button[contains(text(),'More')]")
	public WebElement MoreBtn;

	@FindBy(how=How.XPATH,using="//a[contains(text(),'Replace')]")
	WebElement Replace;
	
	@FindBy(how=How.XPATH,using="//form[@id='replaceForm']")
	public WebElement ReplaceSignerWindow;
	
	@FindBy(how=How.XPATH,using="//img[@title='Replace']")
	public WebElement ReplaceIcon;

	@FindBy(how=How.XPATH,using="//a[contains(text(),'Remove')]")
	WebElement RemoveOption;
	
	@FindBy(how=How.XPATH,using="//form[@id='removeSignerForm']")
	public WebElement RemoveSignerWindow;
	
	@FindBy(how=How.XPATH,using="//img[@title='Remove']")
	WebElement RemoveIcon;

	@FindBy(how=How.XPATH,using="//a[contains(text(),'Void')]")
	WebElement Void;

	@FindBy(how=How.XPATH,using="//a[contains(text(),'Copy')]")
	WebElement Copy;

	@FindBy(how=How.ID,using="delete")
	WebElement Delete;
	
	@FindBy(how=How.ID,using="bypass")
	WebElement Bypass;
	
	@FindBy(how=How.XPATH,using="//form[@id='bypassForm']")
	public WebElement BypassSignerWindow;
	
	@FindBy(how=How.XPATH,using="//form[@id='bypassForm']/div/div/table/tbody/tr/td/b[contains(text(),'Approver 1')]/parent::td/following-sibling::td[1]/input[@type='checkbox']")
	WebElement BypassApprover1;
	
	@FindBy(how=How.XPATH,using="//img[@title='Bypass']")
	WebElement BypassIcon;
	
	@FindBy(how=How.ID,using="signerDetails")
	WebElement SignerDetails;
	
	@FindBy(how=How.XPATH,using="//a[contains(text(),'Edit Request')]")
	WebElement EditRequestBreadcrumbLink;
	
	@FindBy(how=How.XPATH,using="//table[@id='signerInfoTableDetailsId']")
	public WebElement SignerDetailsPopup;

	@FindBy(how=How.XPATH,using="//div[@id='modalContentDiv']/div/button")
	WebElement CloseIcon;
	
	@FindBy(how=How.ID,using="resend")
	WebElement Resend;

	@FindBy(how=How.ID,using="archive")
	WebElement Archive;
	
	@FindBy(how=How.XPATH,using="//input[@value='Next']")
	WebElement NextBtn;
	
	@FindBy(how=How.XPATH,using="//input[@value='Send Later']")
	public WebElement SendLater;
	
	@FindBy(how=How.XPATH,using="//input[@value='Copy']")
	WebElement EditRequestCopyBtn;
	
	@FindBy(how=How.XPATH,using="//button[contains(text(),'OK')]")
	public WebElement OkBtn;
	
	@FindBy(how=How.XPATH,using="//input[@value='Delete Request']")
	WebElement DeleteRequestBtn;	
	
	@FindBy(how=How.XPATH,using="//input[@value='Cancel']")
	WebElement CancelBtn;
	
	@FindBy(how=How.ID,using="allTabId")
	public WebElement AllTab;
	
	@FindBy(how=How.XPATH,using="//div[@class='mainhead']/div[1]/span[contains(text(),'All  Requests')]")
	public WebElement AllRequestPage;	
	
	@FindBy(how=How.ID,using="archivedTabId")
	public WebElement ArchivedTab;
	
	@FindBy(how=How.XPATH,using="//div[@class='mainhead']/div[1]/span[contains(text(),'Archived  Requests')]")
	public WebElement ArchivedRequestPage;
	
	@FindBy(how=How.ID,using="draftTabId")
	public WebElement DraftTab;
	
	@FindBy(how=How.ID,using="expiredTabId")
	public WebElement ExpiredTab;
	
	@FindBy(how=How.ID,using="fullySignedTabId")
	public WebElement FullySignedTab;
	
	@FindBy(how=How.ID,using="trashTabId")
	public WebElement TrashTab;
	
	@FindBy(how=How.ID,using="WaitingForOthersTabId")
	public WebElement WaitingForOthersTab;
	
	@FindBy(how=How.ID,using="inpersonTabId")
	public WebElement InPersonRequestTab;
	
	@FindBy(how=How.XPATH,using="//input[@value='Send Now']")
	WebElement SendNowBtn;
	
	@FindBy(how=How.XPATH,using="//h4[@class='media-heading']/div")
	WebElement DocumentName;
	
	@FindBy(how=How.XPATH,using="//table/tbody/tr/td[1]")
	public WebElement MainDocumentRequestId;
	
	@FindBy(how=How.XPATH,using="//span[contains(text(),'Download Main Document')]")
	public WebElement DownloadMainDocumentBtn;
	
	@FindBy(how=How.XPATH,using="//span[contains(text(),'Download Transaction Document')]")
	public WebElement DownloadTransactionDocumentBtn;
	
	@FindBy(how=How.XPATH,using="//a[contains(text(),'Supporting Documents')]")
	WebElement SupportingDocumentsTab;
	
	@FindBy(how=How.XPATH,using="//div[@class='mainhead']/div/span[contains(text(),'Supporting Documents')]")
	public WebElement SupportingDocumentsPage;
	
	@FindBy(how=How.XPATH,using="//img[@title='Download']")
	WebElement DownloadDocumentIcon;
	
	@FindBy(how=How.XPATH,using="//img[@title='Download All']")
	WebElement DownloadAllIcon;
	
	@FindBy(how=How.XPATH,using="//a[contains(text(),'Transaction Details')]")
	WebElement TransactionDetailsTab;
	
	@FindBy(how=How.XPATH,using="//div[@class='mainhead']/div/span[contains(text(),'Transaction Details')]")
	public WebElement TransactionDetailsPage;
	
	@FindBy(how=How.XPATH,using="//a[contains(text(),'Comments')]")
	WebElement CommentsTab;
	
	@FindBy(how=How.XPATH,using="//div[@class='mainhead']/div/span[contains(text(),'Comments')]")
	public WebElement CommentsPage;
	
	@FindBy(how=How.XPATH,using="//a[contains(text(),'History')]")
	WebElement HistoryTab;
	
	@FindBy(how=How.XPATH,using="//div[@class='mainhead']/div/span[contains(text(),'History')]")
	public WebElement HistoryPage;
	
	@FindBy(how=How.XPATH,using="//a[contains(text(),'Approval Order')]")
	WebElement ApprovalOrderTab;
	
	@FindBy(how=How.XPATH,using="//div[@class='mainhead']/div/span[contains(text(),'Approval Order')]")
	public WebElement ApprovalOrderPage;
	
	@FindBy(how=How.XPATH,using="//span[@title='View Details']")
	WebElement ViewSignerDetails;
	
	@FindBy(how=How.XPATH,using="//div[@id='modalContentDiv']")
	public WebElement ViewSignerDetailsPopup;
	
	@FindBy(how=How.ID,using="customDataTab")
	WebElement CustomDataTab;
	
	@FindBy(how=How.XPATH,using="//img[@title='Add Text Box']")
	WebElement AddTextBox;
	
	@FindBy(how=How.XPATH,using="//img[@title='Add Text Area']")
	WebElement AddTextArea;
	
	@FindBy(how=How.XPATH,using="//img[@title='Add Radio Button']")
	public WebElement AddRadioBtn;
	
	@FindBy(how=How.XPATH,using="//img[@title='Add Check Box']")
	WebElement AddCheckBox;
	
	@FindBy(how=How.XPATH,using="//img[@title='Add Single Select']")
	WebElement AddSelectBox;
	
	@FindBy(how=How.ID,using="addValueLabel")
	WebElement Option;
	
	@FindBy(how=How.XPATH,using="//input[@onclick='setSelectFieldOptions()']")
	WebElement SelectOptionSaveBtn;
	
	@FindBy(how=How.XPATH,using="//img[@title='Delete']")
	WebElement DeleteIcon;
	
	@FindBy(how=How.ID,using="fieldName")
	WebElement FieldName;
	
	@FindBy(how=How.XPATH,using="//select[@id='fieldDataType']")
	WebElement DataType;
	
	@FindBy(how=How.ID,using="save")
	WebElement SaveBtn;
	
	@FindBy(how=How.NAME,using="update")
	public WebElement UpdateBtn;
	
	@FindBy(how=How.NAME,using="copy")
	WebElement CopyBtn;
	
	@FindBy(how=How.ID,using="privilegesTab")
	WebElement PrivilegesTab;
	
	@FindBy(how=How.ID,using="userName")
	WebElement EmployeeSearch;
	
	@FindBy(how=How.XPATH,using="//input[@value='Search']")
	WebElement SearchBtn;
	
	@FindBy(how=How.XPATH,using="//table/tbody/tr/td")
	WebElement SelectAdmin;
	
	@FindBy(how=How.XPATH,using="//input[@id='enableUpdateButtonId']")
	public WebElement UpdateAdmin;
	
	public void clickonShare()
	{
		stepstatus = WebLibrary.JsclickElement(Share, driver);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Share Icon", "Unable to click on Share Icon",true);
	}
	
	public void clickonShareAccessBtn()
	{
		stepstatus = WebLibrary.clickElement(ShareAccessBtn);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Share Access Button", "Unable to click on Share Access Button",true);
	}

	public void clickonPrintBtn()
	{
		stepstatus = WebLibrary.clickElement(PrintBtn);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Print Button", "Unable to click on Print Button");
	}

	public void clickonDownloadBtn()
	{
		stepstatus = WebLibrary.clickElement(DownloadBtn);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Download Button", "Unable to click on Download Button");
	}

	public void clickonDownloadTransBtn()
	{
		stepstatus = WebLibrary.clickElement(DownloadTransBtn);
		ReportLibrary.reportEvent(stepstatus, "Able to click on DownloadTransaction Button", "Unable to click on DownloadTransaction Button");
	}
		
	public void clickonMoreBtn()
	{
		stepstatus = WebLibrary.clickElement(MoreBtn);
		ReportLibrary.reportEvent(stepstatus, "Able to click on More Button", "Unable to click on More Button");
	}

	public void clickonReplace()
	{
		stepstatus = WebLibrary.clickElement(Replace);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Replace Button", "Unable to click on Replace Button");
	}
	
	public void clickonReplaceIcon()
	{
		stepstatus = WebLibrary.clickElement(ReplaceIcon);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Replace Icon", "Unable to click on Replace Icon");
	}


	public void clickonRemoveOption()
	{
		stepstatus = WebLibrary.clickElement(RemoveOption);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Remove Button", "Unable to click on Remove Button");
	}
	
	public void clickonRemoveIcon()
	{
		stepstatus = WebLibrary.clickElement(RemoveIcon);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Remove Icon", "Unable to click on Remove Icon");
	}

	public void clickonVoid()
	{
		stepstatus = WebLibrary.clickElement(Void);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Void option", "Unable to click on Void option");
	}

	public void clickonCopy()
	{
		stepstatus = WebLibrary.clickElement(Copy);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Copy Button", "Unable to click on Copy Button");
	}
	
	public void clickonDelete()
	{
		stepstatus = WebLibrary.clickElement(Delete);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Delete Option", "Unable to click on Delete Option");
	}
	
	public void clickonBypass()
	{
		stepstatus = WebLibrary.clickElement(Bypass);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Bypass Option", "Unable to click on Bypass Option");
	}
	
	public void BypassApprover1()
	{
		stepstatus = WebLibrary.clickElement(BypassApprover1);
		ReportLibrary.reportEvent(stepstatus, "Able to select Approver 1 to Bypass", "Unable to select Approver 1 to Bypass",true);
	}

	public void clickonBypassIcon()
	{
		stepstatus = WebLibrary.clickElement(BypassIcon);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Bypass Icon", "Unable to click on Bypass Icon",true);
	}
	
	public void clickonSignerDetails()
	{
		stepstatus = WebLibrary.clickElement(SignerDetails);
		ReportLibrary.reportEvent(stepstatus, "Able to click on SignerDetails Option", "Unable to click on SignerDetails Option");
	}
	
	public void clickonEditRequestBreadcrumbLink()
	{
		stepstatus = WebLibrary.clickElement(EditRequestBreadcrumbLink);
		ReportLibrary.reportEvent(stepstatus, "Able to click on 'Edit Request' Breadcrumb Link", "Unable to click on 'Edit Request' Breadcrumb Link",true);
	}
	
	public void clickonCloseIcon()
	{
		stepstatus = WebLibrary.clickElement(CloseIcon);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Close Icon", "Unable to click on Close Icon");
	}	

	public void clickonResend()
	{
		stepstatus = WebLibrary.clickElement(Resend);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Resend Option", "Unable to click on Resend Option");
	}

	public void clickonArchive()
	{
		stepstatus = WebLibrary.clickElement(Archive);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Archive Option", "Unable to click on Archive Option",true);
	}
	
	public void clickonNextBtn()
	{
		stepstatus = WebLibrary.clickElement(NextBtn);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Next Button", "Unable to click on Next Button");
	}

	public void clickonSendLater()
	{
		stepstatus = WebLibrary.clickElement(SendLater);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Send Later Button", "Unable to click on Send Later Button");
	}
	
	public void clickonEditRequestCopyBtn()
	{
		stepstatus = WebLibrary.clickElement(EditRequestCopyBtn);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Send Later Button", "Unable to click on Send Later Button");
	}

	public void clickonCancelBtn()
	{
		stepstatus = WebLibrary.clickElement(CancelBtn);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Cancel Button", "Unable to click on Cancel Button",true);
	}
	
	public void clickonAllTab()
	{
		stepstatus = WebLibrary.clickElement(AllTab);
		ReportLibrary.reportEvent(stepstatus, "Able to click on 'All' Tab", "Unable to click on 'All' Tab",true);
	}
	
	public void clickonArchivedTab()
	{
		stepstatus = WebLibrary.clickElement(ArchivedTab);
		ReportLibrary.reportEvent(stepstatus, "Able to click on 'Archived' Tab", "Unable to click on 'Archived' Tab",true);
	}
	
	public void clickonDraftTab()
	{
		stepstatus = WebLibrary.clickElement(DraftTab);
		ReportLibrary.reportEvent(stepstatus, "Able to click on 'Draft' Tab", "Unable to click on 'Draft' Tab",true);
	}
	
	public void clickonExpiredTab()
	{
		stepstatus = WebLibrary.clickElement(ExpiredTab);
		ReportLibrary.reportEvent(stepstatus, "Able to click on 'Expired' Tab", "Unable to click on 'Expired' Tab",true);
	}
	
	public void clickonFullySignedTab()
	{
		stepstatus = WebLibrary.clickElement(FullySignedTab);
		ReportLibrary.reportEvent(stepstatus, "Able to click on 'FullySigned' Tab", "Unable to click on 'FullySigned' Tab",true);
	}
	
	public void clickonTrashTab()
	{
		stepstatus = WebLibrary.clickElement(TrashTab);
		ReportLibrary.reportEvent(stepstatus, "Able to click on 'Trash' Tab", "Unable to click on 'Trash' Tab",true);
	}
	
	public void clickonWaitingForOthersTab()
	{
		stepstatus = WebLibrary.clickElement(WaitingForOthersTab);
		ReportLibrary.reportEvent(stepstatus, "Able to click on 'WaitingForOthers' Tab", "Unable to click on 'WaitingForOthers' Tab");
	}
	
	public void clickonInPersonRequestTab()
	{
		stepstatus = WebLibrary.clickElement(InPersonRequestTab);
		ReportLibrary.reportEvent(stepstatus, "Able to click on 'InPersonRequest' Tab", "Unable to click on 'InPersonRequest' Tab");
	}
	
	public String getMainDocumentRequestId()
	{
		String RequestId = WebLibrary.getLinkText(MainDocumentRequestId);
		System.out.println(RequestId);
		return RequestId;
	}
	public void clickonOkBtn()
	{
		stepstatus = WebLibrary.clickElement(OkBtn);
		ReportLibrary.reportEvent(stepstatus, "Able to click on OK Button", "Unable to click on OK Button");
	}
	
	public void clickonDeleteRequestBtn()
	{
		stepstatus = WebLibrary.clickElement(DeleteRequestBtn);
		ReportLibrary.reportEvent(stepstatus, "Able to click on DeleteRequest Button", "Unable to click on DeleteRequest Button");
	}
	
	public void clickonSendNowBtn()
	{
		stepstatus = WebLibrary.clickElement(SendNowBtn);
		ReportLibrary.reportEvent(stepstatus, "Able to click on SendNow Button", "Unable to click on SendNow Button");
	}
	
	public void clickonDownloadMainDocumentBtn()
	{
		stepstatus = WebLibrary.JsclickElement(DownloadMainDocumentBtn,driver);
		ReportLibrary.reportEvent(stepstatus, "Able to click on 'Download Main Document' Button", "Unable to click on 'Download Main Document' Button");
	}
	
	public void clickonDownloadTransactionDocumentBtn()
	{
		stepstatus = WebLibrary.JsclickElement(DownloadTransactionDocumentBtn,driver);
		ReportLibrary.reportEvent(stepstatus, "Able to click on 'Download Transaction Document' Button", "Unable to click on 'Download Transaction Document' Button");
	}
	
	public void clickonSupportingDocumentsTab()
	{
		stepstatus = WebLibrary.clickElement(SupportingDocumentsTab);
		ReportLibrary.reportEvent(stepstatus, "Able to click on 'Supporting Documents' Tab", "Unable to click on 'Supporting Documents' Tab");
	}
	
	public void clickonDownloadDocumentIcon()
	{
		stepstatus = WebLibrary.clickElement(DownloadDocumentIcon);
		ReportLibrary.reportEvent(stepstatus, "Able to click on 'Download Document' Icon", "Unable to click on 'Download Document' Icon");
	}
	
	public void clickonDownloadAllIcon()
	{
		stepstatus = WebLibrary.clickElement(DownloadAllIcon);
		ReportLibrary.reportEvent(stepstatus, "Able to click on 'Download All' Icon", "Unable to click on 'Download All' Icon");
	}

	public void clickonTransactionDetailsTab()
	{
		stepstatus = WebLibrary.clickElement(TransactionDetailsTab);
		ReportLibrary.reportEvent(stepstatus, "Able to click on 'Transaction Details' Tab", "Unable to click on 'Transaction Details' Tab");
	}
	
	public void clickonCommentsTab()
	{
		stepstatus = WebLibrary.clickElement(CommentsTab);
		ReportLibrary.reportEvent(stepstatus, "Able to click on 'Comments' Tab", "Unable to click on 'Comments' Tab");
	}
	
	public void clickonHistoryTab()
	{
		stepstatus = WebLibrary.clickElement(HistoryTab);
		ReportLibrary.reportEvent(stepstatus, "Able to click on 'History' Tab", "Unable to click on 'History' Tab");
	}
	
	public void clickonApprovalOrderTab()
	{
		stepstatus = WebLibrary.clickElement(ApprovalOrderTab);
		ReportLibrary.reportEvent(stepstatus, "Able to click on 'Approval Order' Tab", "Unable to click on 'Approval Order' Tab");
	}

	public void clickonViewSignerDetailsIcon()
	{
		stepstatus = WebLibrary.clickElement(ViewSignerDetails);
		ReportLibrary.reportEvent(stepstatus, "Able to click on 'ViewSignerDetails' Icon", "Unable to click on 'ViewSignerDetails' Icon");
	}
	
	public void clickonCustomDataTab()
	{
		stepstatus = WebLibrary.clickElement(CustomDataTab);
		ReportLibrary.reportEvent(stepstatus, "Able to click on 'Custom Data' Tab", "Unable to click on 'Custom Data' Tab");
	}
	
	public void clickonAddTextBox()
	{
		stepstatus = WebLibrary.clickElement(AddTextBox);
		ReportLibrary.reportEvent(stepstatus, "Able to click on 'Add TextBox' Icon", "Unable to click on 'Add TextBox' Icon",true);
	}
	
	public void clickonAddTextArea()
	{
		stepstatus = WebLibrary.clickElement(AddTextArea);
		ReportLibrary.reportEvent(stepstatus, "Able to click on 'Add TextArea' Icon", "Unable to click on 'Add TextArea' Icon",true);
	}
	
	public void clickonAddRadioBtn()
	{
		stepstatus = WebLibrary.clickElement(AddRadioBtn);
		ReportLibrary.reportEvent(stepstatus, "Able to click on 'Add RadioBtn' Icon", "Unable to click on 'Add RadioBtn' Icon",true);
	}
	
	public void clickonAddCheckBox()
	{
		stepstatus = WebLibrary.clickElement(AddCheckBox);
		ReportLibrary.reportEvent(stepstatus, "Able to click on 'Add Checkbox' Icon", "Unable to click on 'Add Checkbox' Icon",true);
	}
	
	public void clickonAddSelectBox()
	{
		stepstatus = WebLibrary.clickElement(AddSelectBox);
		ReportLibrary.reportEvent(stepstatus, "Able to click on 'Add SelectBox' Icon", "Unable to click on 'Add SelectBox' Icon",true);
	}
	
	public void setOption(String StrOption)
	{
		stepstatus = WebLibrary.setText(Option, StrOption);
		ReportLibrary.reportEvent(stepstatus, "Able to enter options", "Unable to enter options");
	}
	
	 public void clickonSelectOptionSaveBtn()
	{
		stepstatus = WebLibrary.clickElement(SelectOptionSaveBtn);
		ReportLibrary.reportEvent(stepstatus, "Able to click on 'Save' Button", "Unable to click on 'Save' Button",true);
	}
	
	public void clickonDeleteIcon()
	{
		stepstatus = WebLibrary.clickElement(DeleteIcon);
		ReportLibrary.reportEvent(stepstatus, "Able to click on 'Delete' Icon", "Unable to click on 'Delete' Icon",true);
	}
	
	public void setFieldName(String StrFieldName)
	{
		stepstatus = WebLibrary.setText(FieldName, StrFieldName);
		ReportLibrary.reportEvent(stepstatus, "Able to enter Field Name", "Unable to enter Field Name");
	}
	
	public void setDataType(String StrDataType)
	{
		stepstatus = WebLibrary.setOptionInSelectBox(DataType, StrDataType);
		ReportLibrary.reportEvent(stepstatus, "Able to select DataType from dropdown", "Unable to select DataType from dropdown",true);
	}
	
	public void clickonSaveBtn()
	{
		stepstatus = WebLibrary.clickElement(SaveBtn);
		ReportLibrary.reportEvent(stepstatus, "Able to click on 'Save' Button", "Unable to click on 'Save' Button",true);
	}
	
	public void clickonUpdateBtn()
	{
		stepstatus = WebLibrary.clickElement(UpdateBtn);
		ReportLibrary.reportEvent(stepstatus, "Able to click on 'Update' Button", "Unable to click on 'Update' Button",true);
	}
	
	public void clickonCopyBtn()
	{
		stepstatus = WebLibrary.clickElement(CopyBtn);
		ReportLibrary.reportEvent(stepstatus, "Able to click on 'Copy' Button", "Unable to click on 'Copy' Button",true);
	}
	
	public void clickonPrivilegesTab()
	{
		stepstatus = WebLibrary.clickElement(PrivilegesTab);
		ReportLibrary.reportEvent(stepstatus, "Able to click on 'Privileges' Tab", "Unable to click on 'Privileges' Tab",true);
	}
	
	public void setEmployeeSearch(String StrEmployeeSearch)
	{
		stepstatus = WebLibrary.setText(EmployeeSearch, StrEmployeeSearch);
		ReportLibrary.reportEvent(stepstatus, "Able to enter Employee", "Unable to enter Employee");
	}
	
	public void clickonSearchBtn()
	{
		stepstatus = WebLibrary.clickElement(SearchBtn);
		ReportLibrary.reportEvent(stepstatus, "Able to click on 'Search' Button", "Unable to click on 'Search' Button",true);
	}
	
	public void selectAdmin()
	{
		stepstatus = WebLibrary.clickElement(SelectAdmin);
		ReportLibrary.reportEvent(stepstatus, "Able to Select Admin", "Unable to Select Admin",true);
	}
	
	public void clickonupdateAdmin()
	{
		stepstatus = WebLibrary.clickElement(UpdateAdmin);
		ReportLibrary.reportEvent(stepstatus, "Able to update Admin", "Unable to update Admin",true);
	}
	
	public String getDocumentName()
	{
		String value =	WebLibrary.getAttributeValue(DocumentName, "title");
		System.out.println("Current Doc name is" +value);
		String Name = value.replace(" ", "_");
		String Name1 = Name.replace(",", "_");
		String Name2 = Name1.replace("{", "");
		String Name3 = Name2.replace("}", "");
		System.out.println("Modified Doc name is" +Name3);
		return Name3;
	}
	
	
	
}
