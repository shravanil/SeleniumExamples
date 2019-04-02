package ApplicationPages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.model.Test;

import FrameworkLibrary.ReportLibrary;
import FrameworkLibrary.WebLibrary;

public class SAUserPage {
	
	WebDriver driver;
	boolean stepstatus;
	public SAUserPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH,using="//input[@onclick='SearchEmployee();']")
	public WebElement SearchBtn;
				
	@FindBy(how=How.XPATH,using="//input[@id='startdate']")
	WebElement FromDate;
	
	@FindBy(how=How.XPATH,using="//input[@id='enddate']")
	WebElement ToDate;
	
	@FindBy(how=How.XPATH,using="//span[contains(text(),'Send Report')]")
	public WebElement SendReport;
	
	@FindBy(how=How.XPATH,using="//h4[contains(text(),'Send User Report')]")
	public WebElement SendUserReportPopup;
	
	@FindBy(how=How.ID,using="toAddress")
	WebElement ToAddress;
	
	@FindBy(how=How.XPATH,using="//input[@name='Send']")
	WebElement SendBtn;
	
	@FindBy(how=How.XPATH,using="//div[@class='alert alert-success']")
	public WebElement AlertMsg;
	
	@FindBy(how=How.XPATH,using="(//img[@title='Close'])[1]")
	WebElement CloseIcon;
	
	@FindBy(how=How.XPATH,using="//span[contains(text(),'Download Report')]")
	WebElement DownloadReport;
	
	@FindBy(how=How.XPATH,using="//input[@id='startdate']")
	WebElement StartDate;
	
	@FindBy(how=How.XPATH,using="//input[@value='Search']")
	public WebElement DetailedSearchBtn;
	
	@FindBy(how=How.XPATH,using="//img[@src='images/forward-mail-icon.png']")
	public WebElement DetailedSendReport;
	
	@FindBy(how=How.XPATH,using="//img[@src='images/download-icon.png']")
	WebElement DetailedDownloadReport;
	
	@FindBy(how=How.ID,using="withoutRequestId")
	WebElement NoRequestTab;
	
	@FindBy(how=How.ID,using="oneRequestId")
	WebElement OneRequestTab;
	
	@FindBy(how=How.ID,using="moreRequestId")
	WebElement MoreRequestTab;
	
	@FindBy(how=How.ID,using="withoutTemplateId")
	WebElement NoTemplateTab;
	
	@FindBy(how=How.ID,using="oneTemplateId")
	WebElement OneTemplateTab;
	
	@FindBy(how=How.ID,using="moreTemplateId")
	WebElement MoreTemplateTab;
	
	@FindBy(how=How.ID,using="emailId")
	public WebElement EmailAddress;
	
	@FindBy(how=How.ID,using="firstName")
	WebElement FirstName;
	
	@FindBy(how=How.ID,using="lastName")
	WebElement LastName;
	
	@FindBy(how=How.ID,using="password")
	WebElement Password;
	
	@FindBy(how=How.ID,using="confirmPassword")
	WebElement ConfirmPassword;
	
	@FindBy(how=How.XPATH,using="//input[@value='Save']")
	WebElement SaveBtn;
	
	@FindBy(how=How.XPATH,using="//select[@id='userslistitems']")
	WebElement SelectUser;
	
	@FindBy(how=How.ID,using="newpassword")
	WebElement NewPassword;
	
	@FindBy(how=How.ID,using="confirmpassword")
	WebElement ConfirmNewPassword;
	
	@FindBy(how=How.XPATH,using="//input[@value='Update']")
	public WebElement UpdateBtn;
	
	@FindBy(how=How.ID,using="accountli")
	public WebElement MyPreferencesMenu;
	
	@FindBy(how=How.ID,using="password")
	WebElement ChangePassword;
	
	
	public void clickonSearchBtn()
	{
		stepstatus = WebLibrary.clickElement(SearchBtn);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Search Button", "Unable to click on Search Button");
	}
	
	public void clickonFromDate()
	{
		stepstatus = WebLibrary.clickElement(FromDate);
		ReportLibrary.reportEvent(stepstatus, "Able to click on FromDate Field", "Unable to click on FromDate Field");
	}
	
	public void clickonToDate()
	{
		stepstatus = WebLibrary.clickElement(ToDate);
		ReportLibrary.reportEvent(stepstatus, "Able to click on To Date Field", "Unable to click on To Date Field");
	}
	
	public void clickonSendReportIcon()
	{
		stepstatus = WebLibrary.clickElement(SendReport);
		ReportLibrary.reportEvent(stepstatus, "Able to click on SendReport Icon", "Unable to click on SendReport Icon");
	}
	
	public void setToAddress(String StrToAddress)
	{
		stepstatus = WebLibrary.setText(ToAddress, StrToAddress);
		ReportLibrary.reportEvent(stepstatus, "Able to enter To Address Field", "Unable to enter To Address Field");
	}
	
	public void clickonSendBtn()
	{
		stepstatus = WebLibrary.clickElement(SendBtn);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Send Button", "Unable to click on Send Button");
	}

	public void clickonCloseIcon()
	{
		stepstatus = WebLibrary.clickElement(CloseIcon);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Close Icon", "Unable to click on Close Icon");
	}
	
	public void clickonDownloadReport()
	{
		stepstatus = WebLibrary.clickElement(DownloadReport);
		ReportLibrary.reportEvent(stepstatus, "Able to click on DownloadReport Icon", "Unable to click on DownloadReport Icon");
	}
	
	public void setStartDate()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].removeAttribute('readonly','readonly')", StartDate);
		WebLibrary.setText(StartDate, "Jan-01-2017");
	}
	
	public void clickonDetailedSearchBtn()
	{
		stepstatus = WebLibrary.clickElement(DetailedSearchBtn);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Search Button", "Unable to click on Search Button");
	}
	
	public void clickonDetailedSendReport()
	{
		stepstatus = WebLibrary.clickElement(DetailedSendReport);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Send Report Icon", "Unable to click on Send Report Icon");
	}
	
	public void clickonDetailedDownloadReport()
	{
		stepstatus = WebLibrary.clickElement(DetailedDownloadReport);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Download Report Icon", "Unable to click on Download Report Icon");
	}
	
	public void clickonNoRequestTab()
	{
		stepstatus = WebLibrary.clickElement(NoRequestTab);
		ReportLibrary.reportEvent(stepstatus, "Able to click on NoRequest Tab", "Unable to click on NoRequest Tab");
	}
	
	public void clickonOneRequestTab()
	{
		stepstatus = WebLibrary.clickElement(OneRequestTab);
		ReportLibrary.reportEvent(stepstatus, "Able to click on OneRequest Tab", "Unable to click on OneRequest Tab");
	}
	
	public void clickonMoreRequestTab()
	{
		stepstatus = WebLibrary.clickElement(MoreRequestTab);
		ReportLibrary.reportEvent(stepstatus, "Able to click on MoreRequest Tab", "Unable to click on MoreRequest Tab");
	}
	
	public void clickonNoTemplateTab()
	{
		stepstatus = WebLibrary.clickElement(NoTemplateTab);
		ReportLibrary.reportEvent(stepstatus, "Able to click on NoTemplate Tab", "Unable to click on NoTemplate Tab");
	}
	
	public void clickonOneTemplateTab()
	{
		stepstatus = WebLibrary.clickElement(OneTemplateTab);
		ReportLibrary.reportEvent(stepstatus, "Able to click on OneTemplate Tab", "Unable to click on OneTemplate Tab");
	}
	
	public void clickonMoreTemplateTab()
	{
		stepstatus = WebLibrary.clickElement(MoreTemplateTab);
		ReportLibrary.reportEvent(stepstatus, "Able to click on MoreTemplate Tab", "Unable to click on MoreTemplate Tab");
	}
	
	public void setEmailAddress(String StrEmailAddress)
	{
		stepstatus = WebLibrary.setText(EmailAddress, StrEmailAddress);
		ReportLibrary.reportEvent(stepstatus, "Able to enter Email Address Field", "Unable to enter Email Address Field");
	}
	
	public void setFirstName(String StrFirstName)
	{
		stepstatus = WebLibrary.setText(FirstName, StrFirstName);
		ReportLibrary.reportEvent(stepstatus, "Able to enter First Name Field", "Unable to enter First Name Field");
	}
	
	public void setLastName(String StrLastName)
	{
		stepstatus = WebLibrary.setText(LastName, StrLastName);
		ReportLibrary.reportEvent(stepstatus, "Able to enter Last Name Field", "Unable to enter Last Name Field");
	}
	
	public void setPassword(String StrPassword)
	{
		stepstatus = WebLibrary.setText(Password, StrPassword);
		ReportLibrary.reportEvent(stepstatus, "Able to enter Password Field", "Unable to enter Password Field");
	}
	
	public void setConfirmPassword(String StrConfirmPassword)
	{
		stepstatus = WebLibrary.setText(ConfirmPassword, StrConfirmPassword);
		ReportLibrary.reportEvent(stepstatus, "Able to enter Confirm Password Field", "Unable to enter Confirm Password Field");
	}
	
	public void clickonSaveBtn()
	{
		stepstatus = WebLibrary.clickElement(SaveBtn);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Save Button", "Unable to click on Save Button");
	}
	
	public void selectUser(String StrUser)
	{
		stepstatus = WebLibrary.setOptionInSelectBox(SelectUser, StrUser);
		ReportLibrary.reportEvent(stepstatus, "Able to select user in EmailAddress field", "Unable to selectuser in EmailAddress field");
	}
	
	public void setNewPassword(String StrNewPassword)
	{
		stepstatus = WebLibrary.setText(NewPassword, StrNewPassword);
		ReportLibrary.reportEvent(stepstatus, "Able to enter New Password Field", "Unable to enter New Password Field");
	}
	
	public void setConfirmNewPassword(String StrConfirmNewPassword)
	{
		stepstatus = WebLibrary.setText(ConfirmNewPassword, StrConfirmNewPassword);
		ReportLibrary.reportEvent(stepstatus, "Able to enter Confirm Password Field", "Unable to enter Confirm Password Field");
	}
	
	public void clickonUpdateBtn()
	{
		stepstatus = WebLibrary.clickElement(UpdateBtn);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Update Button", "Unable to click on Update Button");
	}
	
	public void clickonMyPreferencesMenu()
	{
		stepstatus = WebLibrary.clickElement(MyPreferencesMenu);
		ReportLibrary.reportEvent(stepstatus, "Able to click on My Preferences Menu", "Unable to click on My Preferences Menu");
	}
	
	public void clickonChangePassword()
	{
		stepstatus = WebLibrary.clickElement(ChangePassword);
		ReportLibrary.reportEvent(stepstatus, "Able to click on ChangePassword Menu", "Unable to click on ChangePassword Menu",true);
	}
	
}