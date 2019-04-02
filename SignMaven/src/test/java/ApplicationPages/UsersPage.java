package ApplicationPages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import FrameworkLibrary.ReportLibrary;
import FrameworkLibrary.WebLibrary;

public class UsersPage {
	
	WebDriver driver;
	boolean stepstatus;
	public UsersPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(how=How.XPATH,using="//span[contains(text(),'Add Admin')]")
	WebElement AddAdminIcon;

	@FindBy(how=How.XPATH,using="//span[contains(text(),'Export to excel')]")
	WebElement ExportToExcelIcon;
	
	@FindBy(how=How.XPATH,using="//span[contains(text(),'Import Admins')]")
	WebElement ImportAdminsIcon;
	
	@FindBy(how=How.XPATH,using="//input[@value='Search']")
	public WebElement SearchButton;
	
	@FindBy(how=How.XPATH,using="//input[@id='adminEmailId']")
	WebElement EmailAddress;
	
	@FindBy(how=How.XPATH,using="//input[@id='adminFirstName']")
	WebElement FirstName;
	
	@FindBy(how=How.XPATH,using="//input[@id='adminLastName']")
	WebElement LastName;
	
	@FindBy(how=How.XPATH,using="//input[@value='Save']")
	WebElement SaveBtn;
	
	@FindBy(how=How.XPATH,using="//table/tbody/tr/td[5]/div[contains(text(),'Active')]")
	WebElement SelectRecord;
	
	@FindBy(how=How.XPATH,using="//input[@id='hierarchyAdmin']")
	WebElement TemplateCheckbox;
	
	@FindBy(how=How.XPATH,using="(//input[@value='Update'])[1]")
	WebElement UpdateBtn;
	
	@FindBy(how=How.ID,using="enableDeleteButtonId")
	WebElement DeleteBtn;
	
	@FindBy(how=How.XPATH,using="//button[text()='OK']")
	public WebElement OkBtn;
	
	@FindBy(how=How.XPATH,using="//div[@class='alert alert-success'])[2]")
	WebElement popupSuccessMsg;
	
	@FindBy(how=How.XPATH,using="(//img[@title='Close'])[1]")
	WebElement CloseIcon;
	
	@FindBy(how=How.XPATH,using="//span[contains(text(),'Browse')]")
	WebElement BrowseBtn;
	
	@FindBy(how=How.XPATH,using="//input[@value='Import']")
	WebElement ImportBtn;
	
	@FindBy(how=How.ID,using="userName")
	WebElement SearchUsername;
	
	@FindBy(how=How.ID,using="firstName")
	WebElement SearchFirstName;
	
	@FindBy(how=How.ID,using="lastName")
	WebElement SearchLastName;
	
	public void clickonAddAdminIcon()
	{
		stepstatus = WebLibrary.clickElement(AddAdminIcon);
		ReportLibrary.reportEvent(stepstatus, "Able to click on AddAdmin Icon", "Unable to click on AddAdmin Icon");
	}
	
	public void clickonExportToExcelIcon()
	{
		stepstatus = WebLibrary.JsclickElement(ExportToExcelIcon, driver);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Export-To-Excel Icon", "Unable to click on Export-To-Excel Icon",true);
	}
	
	public void clickonImportAdminsIcon()
	{
		stepstatus = WebLibrary.clickElement(ImportAdminsIcon);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Import-Admins Icon", "Unable to click on Import-Admins Icon");
	}
	
	public void clickonSearchButton()
	{
		stepstatus = WebLibrary.clickElement(SearchButton);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Search Button", "Unable to click on Search Button");
	}

	public void setEmailAddress(String StrEmailAddress)
	{
		stepstatus = WebLibrary.setText(EmailAddress, StrEmailAddress);
		ReportLibrary.reportEvent(stepstatus, "Able to enter Email Address Field", "Unable to enter Email Address Field");
	}

	public void setFirstName(String StrFirstName)
	{
		stepstatus = WebLibrary.setText(FirstName, StrFirstName);
		ReportLibrary.reportEvent(stepstatus, "Able to First Name Field", "Unable to enter First Name Field");
	}
	
	public void setLastName(String StrLastName)
	{
		stepstatus = WebLibrary.setText(LastName, StrLastName);
		ReportLibrary.reportEvent(stepstatus, "Able to enter Last Name Field", "Unable to enter Last Name Field");
	}
	
	public void clickonSaveBtn()
	{
		stepstatus = WebLibrary.clickElement(SaveBtn);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Save Button", "Unable to click on Save Button");
	}
	
	public void selectRecord()
	{
		stepstatus = WebLibrary.clickElement(SelectRecord);
		ReportLibrary.reportEvent(stepstatus, "Able to select Active record to Update", "Unable to select Active record to Update");
	}
	
	public void selectAllTemplateCheckbox()
	{
		stepstatus = WebLibrary.clickElement(TemplateCheckbox);
		ReportLibrary.reportEvent(stepstatus, "Able to select All Template Checkbox", "Unable to select All Template Checkbox");
	}
	
	public void clickonUpdateBtn()
	{
		stepstatus = WebLibrary.clickElement(UpdateBtn);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Update button", "Unable to click on Update button");
	}
	
	public void clickonDeleteBtn()
	{
		WebLibrary.JsScrollToWebElement(DeleteBtn, driver);
		stepstatus = WebLibrary.clickElement(DeleteBtn);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Delete button", "Unable to click on Delete button");
	}
	
	public void clickonOkBtn()
	{
		stepstatus = WebLibrary.clickElement(OkBtn);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Ok Button", "Unable to click on Ok Button",true);
	}
	
	public void verifySuccessMsg()
	{
		stepstatus = WebLibrary.verifyTextPresent(popupSuccessMsg, "Admin privileges updated successfully");
		ReportLibrary.reportEvent(stepstatus, "Admin updation success message got displayed", "Admin updation success message not displayed", true);
	}	
	
	public void clickonCloseIcon()
	{
		WebLibrary.JsScrollToWebElement(CloseIcon, driver);
		stepstatus = WebLibrary.clickElement(CloseIcon);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Close Icon", "Unable to click on Close Icon");
	}
	
	
	public void clickonBrowseBtn()
	{
		stepstatus = WebLibrary.clickElement(BrowseBtn);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Browse Button", "Unable to click on Browse Button");
	}

	public void clickonImportBtn()
	{
		stepstatus = WebLibrary.clickElement(ImportBtn);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Import Button", "Unable to click on Import Button");
	}
	
	public void BlankDataValidation()
	{
		stepstatus=WebLibrary.ImageComparision("F:\\SignSikuliScreens\\AddAdmin_BlankErrMsg.PNG", "F:\\SignAutomationScreens\\");
		ReportLibrary.reportEvent(stepstatus, "Blank Data Error message validation successfull", "Blank Data Error message validation failed",true);		
	}
	
	public void InvalidDataValidation()
	{
		stepstatus=WebLibrary.ImageComparision("F:\\SignSikuliScreens\\AddAdmin_InvalidErrMsg.PNG", "F:\\SignAutomationScreens\\");
		ReportLibrary.reportEvent(stepstatus, "Invalid Data Error message validation successfull", "Invalid Data Error message validation failed",true);		
	}
	
	public void ValidDataValidation()
	{
		stepstatus=WebLibrary.ImageComparision("F:\\SignSikuliScreens\\AddAdmin_ValidMsg.PNG", "F:\\SignAutomationScreens\\");
		ReportLibrary.reportEvent(stepstatus, "Admin Creation with Valid Data validation successfull", "Admin Creation with Valid Data validation failed",true);		
	}
	
	public int RecordsCount()
	{
		int Userscount = WebLibrary.NoOfEntriesCount("//table/tbody/tr/td[2]", "//ul[@class='pagination bootpag']/li[@class='next']", "//img[@src='images/next-arrow.png']");
		WebLibrary.wait(2);
		return Userscount;			
	}
	
	public void setUsername(String StrUsername)
	{
		stepstatus = WebLibrary.setText(SearchUsername, StrUsername);
		ReportLibrary.reportEvent(stepstatus, "Able to enter Username Field", "Unable to enter Username Field");
	}
	
	public void searchFirstName(String StrFirstName)
	{
		stepstatus = WebLibrary.setText(SearchFirstName, StrFirstName);
		ReportLibrary.reportEvent(stepstatus, "Able to First Name Field", "Unable to enter First Name Field");
	}
	
	public void searchLastName(String StrLastName)
	{
		stepstatus = WebLibrary.setText(SearchLastName, StrLastName);
		ReportLibrary.reportEvent(stepstatus, "Able to enter Last Name Field", "Unable to enter Last Name Field");
	}
}
