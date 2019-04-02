package ApplicationPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import FrameworkLibrary.ReportLibrary;
import FrameworkLibrary.WebLibrary;

public class HomePage {
	
	WebDriver driver;
	boolean stepstatus;
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how=How.XPATH,using="//img[@class='logo']")
	static WebElement Logo;
	
	@FindBy(how=How.XPATH,using="//a[text()='Requests']")
	WebElement RequestMenu;
		
	@FindBy(how=How.XPATH,using="//a[text()='Templates']")
	WebElement TemplatesMenu;
	
	@FindBy(how=How.XPATH,using="//a[text()='Statistics']")
	WebElement StatisticsMenu;
		
	@FindBy(how=How.XPATH,using="//a[text()='Reports']")
	WebElement ReportsMenu;
	
	@FindBy(how=How.XPATH,using="//a[text()='Metrics Report']")
	WebElement MetricsReport;
	
	@FindBy(how=How.XPATH,using="//a[text()='Detailed Report']")
	WebElement DetailedReport;
	
	@FindBy(how=How.XPATH,using="//a[text()='Signer Report']")
	WebElement SignerReport;
	
	@FindBy(how=How.XPATH,using="//a[text()='Custom Field Report']")
	WebElement CustomFieldReport;
	
	@FindBy(how=How.XPATH,using="//a[text()='Create']")
	WebElement CreateMenu;
	
	@FindBy(how=How.XPATH,using="//a[@id='createRequestId']")
	WebElement CreateRequestMenu;
	
	@FindBy(how=How.XPATH,using="//a[@id='groupRequestId']")
	WebElement CreateGroupRequestMenu;
	
	@FindBy(how=How.XPATH,using="//a[@id='inPersonId']")
	WebElement CreateInPersonRequest;
	
	@FindBy(how=How.XPATH,using="//a[@id='templateId']")
	WebElement CreateTemplateMenu;
	
	@FindBy(how=How.XPATH,using="//img[@src='images/request-icon.png']")
	WebElement SendARequest;
	
	@FindBy(how=How.XPATH,using="//img[@src='images/waiting-icon.png']")
	WebElement WaitingForOthers;
	
	@FindBy(how=How.XPATH,using="//div[@class='mainhead']/div[1]/span[contains(text(),'Waiting for others')]")
	public WebElement WaitingForOthersPage;
	
	@FindBy(how=How.XPATH,using="//img[@src='images/need-sign-icon.png']")
	WebElement NeedToSign;
	
	@FindBy(how=How.XPATH,using="//span[contains(text(),'Need To Sign')]")
	public WebElement NeedToSignPage;
		
	@FindBy(how=How.XPATH,using="//img[@src='images/signed-icon.png']")
	WebElement MySignedItems;
	
	@FindBy(how=How.XPATH,using="//span[contains(text(),'My signed items')]")
	public WebElement MySignedItemsPage;
	
	@FindBy(how=How.XPATH,using="//img[@src='images/doc-archived-1.png']")
	WebElement ArchivedItems;
	
	@FindBy(how=How.XPATH,using="//img[@src='images/in-person-signing-icon.png']")
	WebElement InPersonSigning;
	
	@FindBy(how=How.XPATH,using="//span[contains(text(),'In Person Request')]")
	public WebElement InPersonSigningPage;
	
	@FindBy(how=How.XPATH,using="//img[@class='head-profile']")
	WebElement HeadProfile;

	@FindBy(how=How.XPATH,using="//a[text()='My Preferences']")
	WebElement MyPreferences;
	
	@FindBy(how=How.XPATH,using="//a[text()='Admin']")
	WebElement AdminLink;
	
	@FindBy(how=How.XPATH,using="//a[text()='Help']")
	WebElement HelpLink;
	
	@FindBy(how=How.XPATH,using="//a[text()='Sign out']")
	WebElement SignOutLink;
	
	@FindBy(how=How.XPATH,using="//div[@class='user-name']/ul")
	WebElement MenuBar;
	
	@FindBy(how=How.XPATH,using="//table/tbody/tr/td[2]")
	public static WebElement RecordsSize;
	
	@FindBy(how=How.XPATH,using="//ul[@class='pagination bootpag']/li[@class='next']")
	public static WebElement Pagination;
	
	@FindBy(how=How.XPATH,using="//img[@src='images/next-arrow.png']")
	public static WebElement NextArrow;
	
	@FindBy(how=How.XPATH,using="//a[@id='company']")
	public WebElement CompanyMenu;
	
	@FindBy(how=How.XPATH,using="//a[contains(text(),'Create Company')]")
	WebElement CreateCompanyMenu;
	
	@FindBy(how=How.XPATH,using="//a[contains(text(),'Create Admin')]")
	WebElement CreateAdmin;
	
	@FindBy(how=How.ID,using="companiesList")
	WebElement CompanySettingMenu;
	
	@FindBy(how=How.XPATH,using="//a[@id='adminSettings']")
	WebElement AdminSettingsMenu;
	
	@FindBy(how=How.XPATH,using="//a[contains(text(),' Admins')]")
	WebElement AdminsMenu;
	
	@FindBy(how=How.XPATH,using="//a[@id='companyLogo']")
	WebElement LogoMenu;
	
	@FindBy(how=How.ID,using="dropDownsList")
	WebElement DropdownMenu;
	
	@FindBy(how=How.XPATH,using="//a[@id='UserInfo']")
	WebElement UserMenu;
	
	@FindBy(how=How.XPATH,using="//a[contains(text(),'User Information Search')]")
	WebElement UserInformationSearchMenu;
	
	@FindBy(how=How.XPATH,using="//a[contains(text(),'Detailed Information')]")
	WebElement DetailedInformationMenu;
	
	@FindBy(how=How.XPATH,using="//a[@id='customize']")
	WebElement CustomizeMenu;
	
	@FindBy(how=How.ID,using="batchJobsList")
	WebElement BatchJobs;
	
	@FindBy(how=How.XPATH,using="//li[@id='UserRegistrationli']")
	public WebElement UserRegistrationMenu;
	
	@FindBy(how=How.XPATH,using="//a[contains(text(),'Register User')]")
	WebElement RegisterUserMenu;
	
	@FindBy(how=How.XPATH,using="//a[@id='ChangeUserPassword']")
	WebElement ChangeUserPasswordMenu;
	
	
	public void clickonLogo()
	{
		stepstatus = WebLibrary.clickElement(Logo);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Logo", "Unable to click on Logo");
	}
	
	public static String getCurrentCompanyName()
	{
		return WebLibrary.getAttributeValue(Logo, "title");
	}
	
	public void clickonRequestMenu()
	{
		stepstatus = WebLibrary.clickElement(RequestMenu);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Request Menu", "Unable to click on Request Menu");
	}
	
	public void clickonTemplatesMenu()
	{
		stepstatus = WebLibrary.clickElement(TemplatesMenu);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Templates Menu", "Unable to click on Templates Menu",true);
	}
	
	public void clickonStatisticsMenu()
	{
		stepstatus = WebLibrary.clickElement(StatisticsMenu);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Statistics Menu", "Unable to click on Statistics Menu",true);
	}
	
	public void clickonReportsMenu()
	{
		stepstatus = WebLibrary.clickElement(ReportsMenu);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Reports Menu", "Unable to click on Reports Menu",true);
	}
	
	public void clickonMetricsReport()
	{
		stepstatus = WebLibrary.clickElement(MetricsReport);
		ReportLibrary.reportEvent(stepstatus, "Able to click on MetricsReport Menu", "Unable to click on MetricsReport Menu",true);
	}
	
	public void clickonDetailedReport()
	{
		stepstatus = WebLibrary.clickElement(DetailedReport);
		ReportLibrary.reportEvent(stepstatus, "Able to click on DetailedReport Menu", "Unable to click on DetailedReport Menu",true);
	}
	
	public void clickonSignerReport()
	{
		stepstatus = WebLibrary.clickElement(SignerReport);
		ReportLibrary.reportEvent(stepstatus, "Able to click on SignerReport Menu", "Unable to click on SignerReport Menu",true);
	}
	
	public void clickonCustomFieldReport()
	{
		stepstatus = WebLibrary.clickElement(CustomFieldReport);
		ReportLibrary.reportEvent(stepstatus, "Able to click on CustomFieldReport Menu", "Unable to click on CustomFieldReport Menu",true);
	}

	public void clickonCreateMenu()
	{
		stepstatus = WebLibrary.clickElement(CreateMenu);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Create Menu", "Unable to click on Create Menu",true);
	}
	
	public void clickonCreateRequestMenu()
	{
		stepstatus = WebLibrary.clickElement(CreateRequestMenu);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Create Request Menu", "Unable to click on Create Request Menu",true);
	}
	
	public void clickonCreateGroupRequestMenu()
	{
		stepstatus = WebLibrary.clickElement(CreateGroupRequestMenu);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Create Group Request Menu", "Unable to click on Create Group Request Menu",true);
	}
	
	public void clickonCreateInPersonRequest()
	{
		stepstatus = WebLibrary.clickElement(CreateInPersonRequest);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Create In-Person Request Menu", "Unable to click on Create In-Person Request Menu",true);
	}
	
	public void clickonCreateTemplateMenu()
	{
		stepstatus = WebLibrary.clickElement(CreateTemplateMenu);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Create Template Menu", "Unable to click on Create Template Menu",true);
	}
	
	public void clickonSendARequest()
	{
		stepstatus = WebLibrary.clickElement(SendARequest);
		ReportLibrary.reportEvent(stepstatus, "Able to click on SendARequest Tile", "Unable to click on SendARequest Tile");
	}
	
	public void clickonWaitingForOthers()
	{
		stepstatus = WebLibrary.clickElement(WaitingForOthers);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Waiting For Others Tab", "Unable to click on Waiting For Others Tab");
	}
	
	public void clickonNeedToSign()
	{
		stepstatus = WebLibrary.clickElement(NeedToSign);
		ReportLibrary.reportEvent(stepstatus, "Able to click on NeedToSign Tile", "Unable to click on NeedToSign Tile",true);
	}
	
	public void clickonMySignedItems()
	{
		stepstatus = WebLibrary.clickElement(MySignedItems);
		ReportLibrary.reportEvent(stepstatus, "Able to click on MySignedItems Tile", "Unable to click on MySignedItems Tile",true);
	}
	
	public void clickonArchivedItems()
	{
		stepstatus = WebLibrary.clickElement(ArchivedItems);
		ReportLibrary.reportEvent(stepstatus, "Able to click on ArchivedItems Tile", "Unable to click on ArchivedItems Tile",true);
	}
	
	public void clickonInPersonSigning()
	{
		stepstatus = WebLibrary.clickElement(InPersonSigning);
		ReportLibrary.reportEvent(stepstatus, "Able to click on InPersonSigning Tile", "Unable to click on InPersonSigning Tile",true);
	}
	
	public void clickonHeadProfile()
	{
		stepstatus = WebLibrary.clickElement(HeadProfile);
		ReportLibrary.reportEvent(stepstatus, "Able to click on HeadProfile Icon", "Unable to click on HeadProfile Icon");
	}
	
	public void clickonMyPreferences()
	{
		stepstatus = WebLibrary.clickElement(MyPreferences);
		ReportLibrary.reportEvent(stepstatus, "Able to click on MyPreferences Menu", "Unable to click on MyPreferences Menu",true);
	}
	
	public void clickonAdminLink()
	{
		stepstatus = WebLibrary.clickElement(AdminLink);
		ReportLibrary.reportEvent(stepstatus, "Able to click on AdminLink Menu", "Unable to click on AdminLink Menu");
	}
	
	public void clickonHelpLink()
	{
		stepstatus = WebLibrary.clickElement(HelpLink);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Help Link", "Unable to click on Help Link",true);
	}
	
	public void clickonSignOutLink()
	{
		stepstatus = WebLibrary.clickElement(SignOutLink);
		ReportLibrary.reportEvent(stepstatus, "Able to click on SignOutLink Menu", "Unable to click on SignOutLink Menu");
	}
	
	public void clickonMenuBar()
	{
		stepstatus = WebLibrary.clickElement(MenuBar);
		ReportLibrary.reportEvent(stepstatus, "Able to click on MenuBar", "Unable to click on MenuBar");
	}
	
	public void RecordsCount()
	{
		WebLibrary.NoOfEntriesCount("//table/tbody/tr/td[2]", "//ul[@class='pagination bootpag']/li[@class='next']", "//img[@src='images/next-arrow.png']");
		ReportLibrary.reportEvent(stepstatus, "Able to get number of entries count", "Unable to get number of entries count");			
	}
	
	public void clickonCompanyMenu()
	{
		stepstatus = WebLibrary.clickElement(CompanyMenu);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Company Menu", "Unable to click on Company Menu");
	}
	
	public void clickonCreateCompanyMenu()
	{
		stepstatus = WebLibrary.clickElement(CreateCompanyMenu);
		ReportLibrary.reportEvent(stepstatus, "Able to click on CreateCompany Menu", "Unable to click on CreateCompany Menu");
	}
	
	public void clickonCreateAdminMenu()
	{
		stepstatus = WebLibrary.clickElement(CreateAdmin);
		ReportLibrary.reportEvent(stepstatus, "Able to click on CreateAdmin Menu", "Unable to click on CreateAdmin Menu");
	}
	
	public void clickonCompanySettingMenu()
	{
		stepstatus = WebLibrary.clickElement(CompanySettingMenu);
		ReportLibrary.reportEvent(stepstatus, "Able to click on CompanySetting Menu", "Unable to click on CompanySetting Menu");
	}
	
	public void clickonAdminSettingsMenu()
	{
		stepstatus = WebLibrary.clickElement(AdminSettingsMenu);
		ReportLibrary.reportEvent(stepstatus, "Able to click on AdminSettings Menu", "Unable to click on AdminSettings Menu");
	}
	
	public void clickonAdminsMenu()
	{
		stepstatus = WebLibrary.clickElement(AdminsMenu);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Admins Menu", "Unable to click on Admins Menu");
	}
	
	public void clickonLogoMenu()
	{
		stepstatus = WebLibrary.clickElement(LogoMenu);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Logo Menu", "Unable to click on Logo Menu");
	}
	
	public void clickonDropdownMenu()
	{
		stepstatus = WebLibrary.clickElement(DropdownMenu);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Dropdown Menu", "Unable to click on Dropdown Menu");
	}
	
	public void clickonUserMenu()
	{
		stepstatus = WebLibrary.clickElement(UserMenu);
		ReportLibrary.reportEvent(stepstatus, "Able to click on User Menu", "Unable to click on User Menu");
	}
	
	public void clickonUserInformationSearchMenu()
	{
		stepstatus = WebLibrary.clickElement(UserInformationSearchMenu);
		ReportLibrary.reportEvent(stepstatus, "Able to click on UserInformationSearch Menu", "Unable to click on UserInformationSearch Menu");
	}
	
	public void clickonDetailedInformationMenu()
	{
		stepstatus = WebLibrary.clickElement(DetailedInformationMenu);
		ReportLibrary.reportEvent(stepstatus, "Able to click on DetailedInformation Menu", "Unable to click on DetailedInformation Menu");
	}
	
	public void clickonCustomizeMenu()
	{
		stepstatus = WebLibrary.clickElement(CustomizeMenu);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Customize Menu", "Unable to click on Customize Menu");
	}
	
	public void clickonBatchJobs()
	{
		stepstatus = WebLibrary.clickElement(BatchJobs);
		ReportLibrary.reportEvent(stepstatus, "Able to click on BatchJobs Menu", "Unable to click on BatchJobs Menu");
	}
	
	public void clickonUserRegistrationMenu()
	{
		stepstatus = WebLibrary.clickElement(UserRegistrationMenu);
		ReportLibrary.reportEvent(stepstatus, "Able to click on UserRegistration Menu", "Unable to click on UserRegistration Menu");
	}
	
	public void clickonRegisterUserMenu()
	{
		stepstatus = WebLibrary.clickElement(RegisterUserMenu);
		ReportLibrary.reportEvent(stepstatus, "Able to click on RegisterUser Menu", "Unable to click on RegisterUser Menu");
	}
	
	public void clickonChangeUserPasswordMenu()
	{
		stepstatus = WebLibrary.clickElement(ChangeUserPasswordMenu);
		ReportLibrary.reportEvent(stepstatus, "Able to click on ChangeUserPassword Menu", "Unable to click on ChangeUserPassword Menu");
	}
	
	
}
