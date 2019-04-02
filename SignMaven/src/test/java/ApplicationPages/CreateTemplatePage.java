package ApplicationPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import FrameworkLibrary.DataLibrary;
import FrameworkLibrary.ReportLibrary;
import FrameworkLibrary.WebLibrary;

public class CreateTemplatePage {
	
	WebDriver driver;
	boolean stepstatus;
	public CreateTemplatePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(how=How.XPATH,using="//input[@id='hierarchyname1']")
	WebElement TemplateName;

	@FindBy(how=How.XPATH,using="//select[@id='acceptancemode']")
	WebElement AcceptanceMode;

	@FindBy(how=How.XPATH,using="//span[@id='file_browse_wrapper']")
	WebElement MainDocumentBtn;
	
	@FindBy(how=How.XPATH,using="//div[@id='templateDocumentAddingArea']/div/div[2]/div/table")
	public WebElement DocumentsList;

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
	
	@FindBy(how=How.XPATH,using="//img[@id='editSignerInfo0']")
	WebElement Signer1Edit;

	@FindBy(how=How.XPATH,using="//img[@id='editSignerInfo1']")
	WebElement Signer2Edit;

	@FindBy(how=How.XPATH,using="//img[@id='addOptionButtonId']")
	WebElement AddSignerIcon;

	@FindBy(how=How.XPATH,using="(//img[@id='deleteOptionButtonId'])[1]")
	WebElement DeleteSignerIcon;

	@FindBy(how=How.XPATH,using="//input[@value='Next']")
	WebElement NextBtn;
	
	@FindBy(how=How.XPATH,using="//input[@value='Update']")
	WebElement UpdateBtn;

	@FindBy(how=How.XPATH,using="//input[@name='Save']")
	public WebElement SaveBtn;
	
	@FindBy(how=How.XPATH,using="//input[@name='Activate']")
	WebElement ActivateBtn;
	
	@FindBy(how=How.XPATH,using="//input[@value='Deactivate']")
	WebElement DeActivateBtn;
	
	@FindBy(how=How.XPATH,using="//button[contains(text(),'OK')]")
	WebElement OkBtn;
	
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
	
	@FindBy(how=How.XPATH,using="//input[@value='Save']")
	public WebElement DocumentSetupSaveBtn;
	
	@FindBy(how=How.XPATH,using="//input[@value='Activate']")
	WebElement DocumentSetupActivateBtn;
	
	
	public void setTemplateName(String StrTemplateName)
	{
		stepstatus = WebLibrary.setText(TemplateName, StrTemplateName);
		ReportLibrary.reportEvent(stepstatus, "Able to enter Template Name Field", "Unable to enter Template Name Field");
	}

	public void setAcceptanceMode(String StrAcceptanceMode)
	{
		stepstatus = WebLibrary.setOptionInSelectBox(AcceptanceMode, StrAcceptanceMode);
		ReportLibrary.reportEvent(stepstatus, "Able to select Acceptance Mode", "Unable to select AcceptanceMode",true);
	}
	
	public void clickonMainDocumentBtn()
	{
		stepstatus = WebLibrary.clickElement(MainDocumentBtn);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Main Document Button", "Unable to click on Main Document Button",true);
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

	public void setSigner1Approver(String StrSigner1Approver)
	{
		stepstatus = WebLibrary.setOptionInSelectBox(Signer1Approver, StrSigner1Approver);
		ReportLibrary.reportEvent(stepstatus, "Able to select on Signer1 Approver from dropdown", "Unable to select on Signer1 Approver from dropdown",true);
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
	
	public void setSigner2Approver(String StrSigner2Approver)
	{
		stepstatus = WebLibrary.setOptionInSelectBox(Signer2Approver, StrSigner2Approver);
		ReportLibrary.reportEvent(stepstatus, "Able to select on Signer2 Approver from dropdown", "Unable to select on Signer2 Approver from dropdown",true);
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
	

	public void setSigner3Approver(String StrSigner3Approver)
	{
		stepstatus = WebLibrary.setOptionInSelectBox(Signer3Approver, StrSigner3Approver);
		ReportLibrary.reportEvent(stepstatus, "Able to select on Signer3 Approver from dropdown", "Unable to select on Signer3 Approver from dropdown",true);
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

	public void clickonNextBtn()
	{
		stepstatus = WebLibrary.clickElement(NextBtn);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Next Button", "Unable to click on Next Button",true);
	}
	
	public void clickonUpdateBtn()
	{
		stepstatus = WebLibrary.clickElement(UpdateBtn);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Update Button", "Unable to click on Update Button",true);
	}

	public void clickonSaveBtn()
	{
		stepstatus = WebLibrary.clickElement(SaveBtn);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Save Button", "Unable to click on Save Button",true);
	}
	
	public void clickonActivateBtn()
	{
		stepstatus = WebLibrary.clickElement(ActivateBtn);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Activate Button", "Unable to click on Activate Button",true);
	}
	
	public void clickonDeActivateBtn()
	{
		stepstatus = WebLibrary.clickElement(DeActivateBtn);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Deactivate Button", "Unable to click on Deactivate Button",true);
	}
	
	public void clickonOkBtn()
	{
		stepstatus = WebLibrary.clickElement(OkBtn);
		ReportLibrary.reportEvent(stepstatus, "Able to click on OK Button", "Unable to click on OK Button",true);
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
		ReportLibrary.reportEvent(stepstatus, "Able to click on Signature Field", "Unable to click on Signature Field",true);
	}
	
	public void clickonInitial()
	{
		stepstatus = WebLibrary.clickElement(Initial);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Initial Field", "Unable to click on Initial Field",true);
	}
	
	public void clickonDate()
	{
		stepstatus = WebLibrary.clickElement(Date);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Date Field", "Unable to click on Date Field",true);
	}
	
	public void clickonTextbox()
	{
		stepstatus = WebLibrary.clickElement(TextBox);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Textbox Field", "Unable to click on Textbox Field",true);
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
	
	public void clickonDocumentSetupActivateBtn()
	{
		stepstatus = WebLibrary.clickElement(DocumentSetupActivateBtn);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Activate Button", "Unable to click on Activate Button",true);
	}
	
	public void clickonDocumentSetupSaveBtn()
	{
		stepstatus = WebLibrary.clickElement(DocumentSetupSaveBtn);
		ReportLibrary.reportEvent(stepstatus, "Able to click on SaveButton", "Unable to click on Save Button",true);
	}
	
	public void selectTemplate()
	{
		stepstatus = WebLibrary.clickElement(driver.findElement(By.xpath("(//table)[2]/tbody/tr/td[2]/div[contains(text(),'"+DataLibrary.getdata("TemplateName")+"')]")));
		//driver.findElement(By.xpath("(//table)[2]/tbody/tr/td[2]/div[contains(text(),'"+DataLibrary.getdata("TemplateName")+"')]")).click();
		
		ReportLibrary.reportEvent(stepstatus, "Able to select template", "Unable to select template",true);
	}
	
	public void setTemplatesDocPreview()
	{
		WebElement documentPreview = driver.findElement(By.xpath("//table/tbody/tr/td[2]/div[contains(text(),'"+DataLibrary.getdata("TemplateName")+"')]/parent::td[1]/preceding-sibling::td[1]/div/span[@title='Document Preview']"));
		Actions a1 = new Actions(driver);
		a1.doubleClick(documentPreview);
		a1.build().perform();
	}
	
}