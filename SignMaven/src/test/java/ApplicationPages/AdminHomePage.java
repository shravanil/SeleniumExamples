package ApplicationPages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import FrameworkLibrary.ReportLibrary;
import FrameworkLibrary.WebLibrary;

public class AdminHomePage {
	
	WebDriver driver;
	boolean stepstatus;
	public AdminHomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how=How.XPATH,using="//a[@id='company']")
	public WebElement CompanyMenu;
		
	@FindBy(how=How.XPATH,using="//a[@id='customize']")
	WebElement CustomizeMenu;
	
	@FindBy(how=How.XPATH,using="//a[text()='Bulk Download']")
	WebElement BulkDownload;
	
	@FindBy(how=How.XPATH, using="//a[@id='companyEdit']")
	WebElement CompanyDetailsMenu;

	@FindBy(how=How.XPATH, using="//a[@id='companySettings']")
	WebElement CompanySettingsMenu;

	@FindBy(how=How.XPATH, using="//a[@id='companyPrivileges']")
	WebElement UsersMenu;

	@FindBy(how=How.XPATH, using="//a[@id='companyLogo']")
	WebElement LogoMenu;

	@FindBy(how=How.XPATH, using="//a[@id='subOperations']")
	WebElement SearchMenu;

	@FindBy(how=How.XPATH, using="//a[text()='Groups']")
	WebElement GroupsMenu;

	@FindBy(how=How.XPATH, using="//a[@id='ChangeUserPasswordli']")
	WebElement ManagePasswordMenu;
	
	@FindBy(how=How.XPATH, using="//a[@id='batchJobsList']")
	WebElement BatchJobsMenu;

	@FindBy(how=How.XPATH, using="//a[@id='validateDoc']")
	WebElement ValidatedDocument;
	
	@FindBy(how=How.XPATH, using="//span[contains(text(),'Browse')]")
	WebElement BrowseBtn;
	
	@FindBy(how=How.XPATH, using="//input[@value='Verify']")
	public WebElement VerifyBtn;
	
	@FindBy(how=How.XPATH, using="//input[@id='frmdate']")
	WebElement FromDate;
	
	@FindBy(how=How.ID, using="searchEnable")
	WebElement SearchBtn;
	
	@FindBy(how=How.XPATH, using="//select[@id='requestStatus']")
	WebElement RequestStatus;
	
	@FindBy(how=How.ID, using="massDownload_enable")
	WebElement BulkDownloadIcon;
	
	public void clickonCompanyMenu()
	{
		stepstatus = WebLibrary.clickElement(CompanyMenu);
		ReportLibrary.reportEvent(stepstatus, "Able to click on CompanyMenu", "Unable to click on CompanyMenu");
	}
	
	public void clickonCustomizeMenu()
	{
		stepstatus = WebLibrary.clickElement(CustomizeMenu);
		ReportLibrary.reportEvent(stepstatus, "Able to click on CustomizeMenu", "Unable to click on CustomizeMenu",true);
	}
	
	public void clickonBulkDownload()
	{
		stepstatus = WebLibrary.clickElement(BulkDownload);
		ReportLibrary.reportEvent(stepstatus, "Able to click on BulkDownload menu", "Unable to click on BulkDownload menu",true);
	}
	
	public void clickonCompanyDetailsMenu()
	{
		stepstatus = WebLibrary.clickElement(CompanyDetailsMenu);
		ReportLibrary.reportEvent(stepstatus, "Able to click on CompanyDetails menu", "Unable to click on CompanyDetails menu",true);

	}

	public void clickonCompanySettingsMenu()
	{
		stepstatus = WebLibrary.clickElement(CompanySettingsMenu);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Company Settings menu", "Unable to click on Company Settings menu");

	}

	public void clickonUsersMenu()
	{
		stepstatus = WebLibrary.clickElement(UsersMenu);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Users menu", "Unable to click on Users menu");

	}

	public void clickonLogoMenu()
	{
		stepstatus = WebLibrary.clickElement(LogoMenu);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Logo menu", "Unable to click on Logo menu",true);

	}

	public void clickonSearchMenu()
	{
		stepstatus = WebLibrary.clickElement(SearchMenu);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Search menu", "Unable to click on Search menu",true);
	}

	public void clickonGroupsMenu()
	{
		stepstatus = WebLibrary.clickElement(GroupsMenu);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Groups menu", "Unable to click on Groups menu",true);
	}

	public void clickonManagePasswordMenu()
	{
		stepstatus = WebLibrary.clickElement(ManagePasswordMenu);
		ReportLibrary.reportEvent(stepstatus, "Able to click on ManagePassword menu", "Unable to click on ManagePassword menu",true);
	}

	public void clickonBatchJobsMenu()
	{
		stepstatus = WebLibrary.clickElement(BatchJobsMenu);
		ReportLibrary.reportEvent(stepstatus, "Able to click on BatchJobs menu", "Unable to click on BatchJobs menu",true);
	}

	public void clickonValidatedDocument()
	{
		stepstatus = WebLibrary.clickElement(ValidatedDocument);
		ReportLibrary.reportEvent(stepstatus, "Able to click on ValidatedDocument menu", "Unable to click on ValidatedDocument menu",true);
	}
	
	public void clickonBrowseBtn()
	{
		stepstatus = WebLibrary.clickElement(BrowseBtn);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Browse Button", "Unable to click on Browse Button",true);
	}
	
	public void clickonVerifyBtn()
	{
		stepstatus = WebLibrary.clickElement(VerifyBtn);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Verify Button", "Unable to click on Verify Button",true);
	}

	public void setFromDate()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].removeAttribute('readonly','readonly')", FromDate);
		WebLibrary.setText(FromDate, "Jan-01-2017");
	}
	
	public void clickonSearchBtn()
	{
		stepstatus = WebLibrary.clickElement(SearchBtn);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Search Button", "Unable to click on Search Button",true);
	}
	
	public void selectRequestStatus(String StrRequestStatus)
	{
		stepstatus = WebLibrary.setOptionInSelectBox(RequestStatus, StrRequestStatus);
		ReportLibrary.reportEvent(stepstatus, "Able to select RequestStatus", "Unable to select RequestStatus");
	}
	
	public void clickonBulkDownloadIcon()
	{
		stepstatus = WebLibrary.clickElement(BulkDownloadIcon);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Bulk Download Icon", "Unable to click on Bulk Download Icon",true);
	}
	
}
