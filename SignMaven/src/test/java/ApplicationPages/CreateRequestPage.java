package ApplicationPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import FrameworkLibrary.ReportLibrary;
import FrameworkLibrary.WebLibrary;

public class CreateRequestPage {
	
	WebDriver driver;
	boolean stepstatus;
	public CreateRequestPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(how=How.XPATH,using="//input[@id='description']")
	WebElement RequestTitle;

	@FindBy(how=How.XPATH,using="//input[@id='isTemplateRequired']")
	WebElement UseATemplate;

	@FindBy(how=How.XPATH,using="//span[@id='file_browse_wrapper']")
	WebElement MainDocumentBtn;
	
	@FindBy(how=How.XPATH,using="//div[@id='documentAddingArea']/div/div[2]/div/table")
	public WebElement DocumentsList;

	@FindBy(how=How.XPATH,using="//button[@title='Supporting Document']")
	public WebElement SupportingDocumentBtn;
	
	@FindBy(how=How.XPATH,using="//span[contains(text(),'Browse')]")
	WebElement BrowseBtn;
	
	@FindBy(how=How.XPATH,using="//input[@value='Upload']")
	WebElement UploadBtn;
	
	@FindBy(how=How.XPATH,using="//button[contains(text(),'Get From Cloud')]]")
	WebElement SignersGetFromCloud;

	@FindBy(how=How.XPATH,using="//input[@id='signatoryEmail0']")
	WebElement Signer1Email;
	
	@FindBy(how=How.XPATH,using="//input[@id='signatoryFirstName0']")
	WebElement Signer1FirstName;
	
	@FindBy(how=How.XPATH,using="//input[@id='signatoryLastName0']")
	WebElement Signer1LastName;
	
	@FindBy(how=How.XPATH,using="//select[@id='signatoryApprovalOrder0']")
	WebElement Signer1Approver;

	@FindBy(how=How.XPATH,using="//input[@id='signatoryEmail1']")
	WebElement Signer2Email;

	@FindBy(how=How.XPATH,using="//input[@id='signatoryFirstName1']")
	WebElement Signer2FirstName;
	
	@FindBy(how=How.XPATH,using="//input[@id='signatoryLastName1']")
	WebElement Signer2LastName;

	@FindBy(how=How.XPATH,using="//select[@id='signatoryApprovalOrder1']")
	WebElement Signer2Approver;

	@FindBy(how=How.XPATH,using="//input[@id='signatoryEmail2']")
	WebElement Signer3Email;

	@FindBy(how=How.XPATH,using="//input[@id='signatoryFirstName2']")
	WebElement Signer3FirstName;
	
	@FindBy(how=How.XPATH,using="//input[@id='signatoryLastName2']")
	WebElement Signer3LastName;

	@FindBy(how=How.XPATH,using="//select[@id='signatoryApprovalOrder2']")
	WebElement Signer3Approver;
	
	@FindBy(how=How.XPATH,using="//input[@id='signatoryEmail3']")
	WebElement Signer4Email;

	@FindBy(how=How.XPATH,using="//input[@id='signatoryFirstName3']")
	WebElement Signer4FirstName;
	
	@FindBy(how=How.XPATH,using="//input[@id='signatoryLastName3']")
	WebElement Signer4LastName;

	@FindBy(how=How.XPATH,using="//select[@id='signatoryApprovalOrder3']")
	WebElement Signer4Approver;
	
	@FindBy(how=How.XPATH,using="//img[@id='editSignerInfo0']")
	WebElement Signer1Edit;

	@FindBy(how=How.XPATH,using="//img[@id='editSignerInfo1']")
	WebElement Signer2Edit;

	@FindBy(how=How.XPATH,using="//img[@id='addOptionButtonId']")
	WebElement AddSignerIcon;

	@FindBy(how=How.XPATH,using="(//img[@id='deleteOptionButtonId'])[1]")
	WebElement DeleteSignerIcon;
	
	@FindBy(how=How.XPATH,using="//h4[@class='panel-title']/a")
	WebElement OtherSettings;
	
	@FindBy(how=How.XPATH,using="//input[@id='authenticationForAttachmentYes']")
	WebElement AttachmentRequiredYes;
	
	@FindBy(how=How.XPATH,using="//select[@id='attachmentVal']")
	WebElement NoOfAttachments;
	
	@FindBy(how=How.XPATH,using="//select[@id='mandatoryAttachmentVal']")
	WebElement MandatoryAttachments;

	@FindBy(how=How.XPATH,using="//input[@name='Next']")
	WebElement NextBtn;

	@FindBy(how=How.XPATH,using="//input[@name='Save to Draft']")
	public WebElement SaveToDraft;

	@FindBy(how=How.XPATH,using="//input[@name='Cancel']")
	WebElement CancelBtn;

	@FindBy(how=How.XPATH,using="//a[@id='docSetupTab']")
	public WebElement DocumentSetupTab;
	
	@FindBy(how=How.XPATH,using="//select[@id='signatorySelect']")
	WebElement SignerSelection;
	
	@FindBy(how=How.XPATH,using="//select[@id='documentNameSelect']")
	WebElement DocumentSelection;
	
	@FindBy(how=How.XPATH,using="//img[@id='documentPageImage1']")
	public	WebElement DocumentPage1;
	
	@FindBy(how=How.XPATH,using="//div[@id='list-group']/a[1]")
	public	WebElement Signature;
	
	@FindBy(how=How.XPATH,using="//div[@id='list-group']/a[2]")
	public WebElement Initial;
	
	@FindBy(how=How.XPATH,using="//div[@id='list-group']/a[3]")
	WebElement Date;
	
	@FindBy(how=How.XPATH,using="//div[@id='list-group']/a[4]")
	public WebElement TextBox;
	
	@FindBy(how=How.XPATH,using="//div[@id='list-group']/a[5]")
	WebElement TextArea;
	
	@FindBy(how=How.XPATH,using="//div[@id='list-group']/a[6]")
	WebElement SelectBox;
	
	@FindBy(how=How.XPATH,using="//div[@id='list-group']/a[8]")
	public WebElement Checkbox;
	
	@FindBy(how=How.XPATH,using="//input[@id='setGroupName']")
	public WebElement GroupName;
	
	@FindBy(how=How.XPATH,using="//input[@value='Set Group']")
	WebElement SetGroup;
	
	@FindBy(how=How.XPATH,using="//input[@value='Save to Draft']")
	public WebElement DocumentSetupSaveBtn;
	
	@FindBy(how=How.XPATH,using="//input[@value='Send Now']")
	WebElement SendNowBtn;

	public void setRequestTitle(String StrRequestTitle)
	{
		stepstatus = WebLibrary.setText(RequestTitle, StrRequestTitle);
		ReportLibrary.reportEvent(stepstatus, "Able to enter RequestTitle Field", "Unable to enter RequestTitle Field");
	}

	public void clickonUseATemplate()
	{
		stepstatus = WebLibrary.clickElement(UseATemplate);
		ReportLibrary.reportEvent(stepstatus, "Able to select UseATemplate checkbox", "Unable to select UseATemplate checkbox",true);
	}

	public void clickonMainDocumentBtn()
	{
		stepstatus = WebLibrary.clickElement(MainDocumentBtn);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Main Document Button", "Unable to click on Main Document Button");
	}

	public void clickonSupportingDocumentBtn()
	{
		stepstatus = WebLibrary.clickElement(SupportingDocumentBtn);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Supporting Document Button", "Unable to click on Supporting Document Button");
	}
	
	public void clickonBrowseBtn()
	{
		stepstatus = WebLibrary.clickElement(BrowseBtn);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Browse Button", "Unable to click on Browse Button");
	}
	
	public void clickonUploadBtn()
	{
		stepstatus = WebLibrary.clickElement(UploadBtn);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Upload Button", "Unable to click on Upload Button");
	}
	
	public void clickonSignersGetFromCloud()
	{
		stepstatus = WebLibrary.clickElement(SignersGetFromCloud);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Signers Get From Cloud Button", "Unable to click on Signers Get From Cloud Button",true);
	}

	public void setSigner1Email(String StrSigner1Email)
	{
		stepstatus = WebLibrary.setText(Signer1Email, StrSigner1Email);
		ReportLibrary.reportEvent(stepstatus, "Able to enter Signer1 Email", "Unable to enter Signer1 Email");
	}
	
	public void setSigner1FirstName(String StrSigner1FirstName)
	{
		stepstatus = WebLibrary.setText(Signer1FirstName, StrSigner1FirstName);
		ReportLibrary.reportEvent(stepstatus, "Able to enter Signer1 First Name", "Unable to enter Signer1 First Name");
	}
	
	public void setSigner1LastName(String StrSigner1LastName)
	{
		stepstatus = WebLibrary.setText(Signer1LastName, StrSigner1LastName);
		ReportLibrary.reportEvent(stepstatus, "Able to enter Signer1 Last Name", "Unable to enter Signer1 Last Name");
	}

	public void setSigner2Email(String StrSigner2Email)
	{
		stepstatus = WebLibrary.setText(Signer2Email, StrSigner2Email);
		ReportLibrary.reportEvent(stepstatus, "Able to enter Signer2 Email", "Unable to enter Signer2 Email");
	}
	
	public void setSigner2FirstName(String StrSigner2FirstName)
	{
		stepstatus = WebLibrary.setText(Signer2FirstName, StrSigner2FirstName);
		ReportLibrary.reportEvent(stepstatus, "Able to enter Signer2 First Name", "Unable to enter Signer2 First Name");
	}
	
	public void setSigner2LastName(String StrSigner2LastName)
	{
		stepstatus = WebLibrary.setText(Signer2LastName, StrSigner2LastName);
		ReportLibrary.reportEvent(stepstatus, "Able to enter Signer2 Last Name", "Unable to enter Signer2 Last Name");
	}
	
	public void setSigner3Email(String StrSigner3Email)
	{
		stepstatus = WebLibrary.setText(Signer3Email, StrSigner3Email);
		ReportLibrary.reportEvent(stepstatus, "Able to enter Signer3 Email", "Unable to enter Signer3 Email");
	}
	
	public void setSigner3FirstName(String StrSigner3FirstName)
	{
		stepstatus = WebLibrary.setText(Signer3FirstName, StrSigner3FirstName);
		ReportLibrary.reportEvent(stepstatus, "Able to enter Signer3 First Name", "Unable to enter Signer3 First Name");
	}
	
	public void setSigner3LastName(String StrSigner3LastName)
	{
		stepstatus = WebLibrary.setText(Signer3LastName, StrSigner3LastName);
		ReportLibrary.reportEvent(stepstatus, "Able to enter Signer3 Last Name", "Unable to enter Signer3 Last Name");
	}
	
	public void setSigner4Email(String StrSigner4Email)
	{
		stepstatus = WebLibrary.setText(Signer4Email, StrSigner4Email);
		ReportLibrary.reportEvent(stepstatus, "Able to enter Signer4 Email", "Unable to enter Signer4 Email");
	}
	
	public void setSigner4FirstName(String StrSigner4FirstName)
	{
		stepstatus = WebLibrary.setText(Signer4FirstName, StrSigner4FirstName);
		ReportLibrary.reportEvent(stepstatus, "Able to enter Signer4 First Name", "Unable to enter Signer4 First Name");
	}
	
	public void setSigner4LastName(String StrSigner4LastName)
	{
		stepstatus = WebLibrary.setText(Signer4LastName, StrSigner4LastName);
		ReportLibrary.reportEvent(stepstatus, "Able to enter Signer4 Last Name", "Unable to enter Signer4 Last Name");
	}

	public void setSigner1Approver(String StrSigner1Approver)
	{
		stepstatus = WebLibrary.setOptionInSelectBox(Signer1Approver, StrSigner1Approver);
		ReportLibrary.reportEvent(stepstatus, "Able to select on Signer1 Approver from dropdown", "Unable to select on Signer1 Approver from dropdown",true);
	}
	
	public void setSigner2Approver(String StrSigner2Approver)
	{
		stepstatus = WebLibrary.setOptionInSelectBox(Signer2Approver, StrSigner2Approver);
		ReportLibrary.reportEvent(stepstatus, "Able to select on Signer2 Approver from dropdown", "Unable to select on Signer2 Approver from dropdown",true);
	}
	
	public void setSigner3Approver(String StrSigner3Approver)
	{
		stepstatus = WebLibrary.setOptionInSelectBox(Signer3Approver, StrSigner3Approver);
		ReportLibrary.reportEvent(stepstatus, "Able to select on Signer3 Approver from dropdown", "Unable to select on Signer3 Approver from dropdown",true);
	}
	
	public void setSigner4Approver(String StrSigner4Approver)
	{
		stepstatus = WebLibrary.setOptionInSelectBox(Signer4Approver, StrSigner4Approver);
		ReportLibrary.reportEvent(stepstatus, "Able to select on Signer4 Approver from dropdown", "Unable to select on Signer4 Approver from dropdown",true);
	}

	public void clickonSigner1Edit()
	{
		stepstatus = WebLibrary.clickElement(Signer1Edit);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Signer1 Edit Icon", "Unable to click on Signer1 Edit Icon",true);
	}

	public void clickonSigner2Edit()
	{
		stepstatus = WebLibrary.clickElement(Signer2Edit);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Signer2 Edit Icon", "Unable to click on Signer2 Edit Icon",true);
	}

	public void clickonAddSignerIcon()
	{
		stepstatus = WebLibrary.clickElement(AddSignerIcon);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Add Signer Icon", "Unable to click on Add Signer Icon",true);
	}

	public void clickonDeleteSignerIcon()
	{
		stepstatus = WebLibrary.clickElement(DeleteSignerIcon);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Delete Signer Icon", "Unable to click on Delete Signer Icon",true);
	}
	
	public void clickonOtherSettings()
	{
		stepstatus = WebLibrary.clickElement(OtherSettings);
		ReportLibrary.reportEvent(stepstatus, "Able to click on 'Other Settings' section", "Unable to click on 'Other Settings' section",true);
	}
	
	public void clickonAttachmentRequiredYes()
	{
		stepstatus = WebLibrary.clickElement(AttachmentRequiredYes);
		ReportLibrary.reportEvent(stepstatus, "Able to click on 'Yes' radio button of 'Attachment Required' section", "Unable to click on 'Yes' radio button of 'Attachment Required' section",true);
	}
	
	public void setNoOfAttachments(String StrNoOfAttachments)
	{
		stepstatus = WebLibrary.setOptionInSelectBox(NoOfAttachments, StrNoOfAttachments);
		ReportLibrary.reportEvent(stepstatus, "Able to select NoOfAttachments from dropdown", "Unable to select NoOfAttachments from dropdown");
	}
	
	public void setMandatoryAttachments(String StrMandatoryAttachments)
	{
		stepstatus = WebLibrary.setOptionInSelectBox(MandatoryAttachments, StrMandatoryAttachments);
		ReportLibrary.reportEvent(stepstatus, "Able to select MandatoryAttachments count from dropdown", "Unable to select MandatoryAttachments count from dropdown");
	}
	
	public void clickonNextBtn()
	{
		stepstatus = WebLibrary.clickElement(NextBtn);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Next Button", "Unable to click on Next Button",true);
	}

	public void clickonSaveToDraft()
	{
		stepstatus = WebLibrary.clickElement(SaveToDraft);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Save To Draft Button", "Unable to click on Save To Draft Button",true);
	}

	public void clickonCancelBtn()
	{
		stepstatus = WebLibrary.clickElement(CancelBtn);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Cancel Button", "Unable to click on Cancel Button",true);
	}

	public void clickonDocumentSetupTab()
	{
		stepstatus = WebLibrary.clickElement(DocumentSetupTab);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Document Setup Tab", "Unable to click on Document Setup Tab",true);
	}
	
	public void setSignerSelection(String StrSignerSelection)
	{
		stepstatus = WebLibrary.setOptionInSelectBox(SignerSelection, StrSignerSelection);
		ReportLibrary.reportEvent(stepstatus, "Able to select signer from dropdown", "Unable to select signer from dropdown");
	}
	
	public void setDocumentSelection(String StrDocumentSelection)
	{
		stepstatus = WebLibrary.setOptionInSelectBox(DocumentSelection, StrDocumentSelection);
		ReportLibrary.reportEvent(stepstatus, "Able to select document from dropdown", "Unable to select document from dropdown");
	}
	
	
	public void clickonSignature()
	{
		stepstatus = WebLibrary.clickElement(Signature);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Signature Field", "Unable to click on Signature Field");
	}
	
	public void clickonInitial()
	{
		stepstatus = WebLibrary.clickElement(Initial);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Initial Field", "Unable to click on Initial Field");
	}
	
	public void clickonDate()
	{
		stepstatus = WebLibrary.clickElement(Date);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Date Field", "Unable to click on Date Field");
	}
	
	public void clickonTextbox()
	{
		stepstatus = WebLibrary.clickElement(TextBox);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Textbox Field", "Unable to click on Textbox Field");
	}
	
	public void clickonCheckbox()
	{
		stepstatus = WebLibrary.clickElement(Checkbox);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Checkbox Field", "Unable to click on Checkbox Field",true);
	}
	
	public void setGroupName(String StrGroupName)
	{
		stepstatus = WebLibrary.setText(GroupName, StrGroupName);
		ReportLibrary.reportEvent(stepstatus, "Able to enter Group Name", "Unable to enter Group Name");
	}
	
	public void clickonSetGroup()
	{
		stepstatus = WebLibrary.clickElement(SetGroup);
		ReportLibrary.reportEvent(stepstatus, "Able to click on 'Set Group' button", "Unable to click on 'Set Group' button",true);
	}
	
	public void clickonSendNowBtn()
	{
		stepstatus = WebLibrary.clickElement(SendNowBtn);
		ReportLibrary.reportEvent(stepstatus, "Able to click on SendNow Button", "Unable to click on SendNow Button",true);
	}
	
	public void clickonDocumentSetupSaveToDraft()
	{
		stepstatus = WebLibrary.clickElement(DocumentSetupSaveBtn);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Save To Draft Button", "Unable to click on Save To Draft Button",true);
	}
}