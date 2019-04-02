package ApplicationPages;

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

public class SACompanyPage {
	
	WebDriver driver;
	boolean stepstatus;
	public SACompanyPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH,using="//input[@id='companyname']")
	public WebElement Company;
				
	@FindBy(how=How.XPATH,using="//textarea[@id='address']")
	WebElement Address;

	@FindBy(how=How.XPATH,using="//input[@id='cityname']")
	WebElement City;

	@FindBy(how=How.XPATH,using="//input[@id='state']")
	WebElement State;
	
	@FindBy(how=How.XPATH,using="//select[@id='country']")
	WebElement Country;
	
	@FindBy(how=How.XPATH,using="(//input[@value='Next'])[1]")
	public WebElement NextBtn;
	
	@FindBy(how=How.XPATH,using="//input[@value='Finish']")
	public WebElement FinishBtn;
	
	@FindBy(how=How.XPATH,using="//input[@value='Click here']")
	public WebElement ClickHereBtn;
	
	@FindBy(how=How.XPATH,using="//input[@value='Select']")
	public WebElement SelectBtn;
	
	@FindBy(how=How.XPATH,using="(//img[@title='Close'])[2]")
	WebElement CloseIcon;
	
	@FindBy(how=How.XPATH,using="(//img[@title='Close'])[1]")
	WebElement CreateAdminCloseIcon;
	
	@FindBy(how=How.XPATH,using="//div[@id='s2id_userlistitem1']/a")
	public WebElement User;
	
	@FindBy(how=How.XPATH,using="//input[@id='s2id_autogen2_search']")
	WebElement UserAutoSearch;
	
	@FindBy(how=How.ID,using="s2id_companylistitem")
	public WebElement CreateAdminCompany;
	
	@FindBy(how=How.XPATH,using="//input[@id='s2id_autogen1']")
	WebElement CompanyAutosearch;
	
	@FindBy(how=How.XPATH,using="//input[@id='companyName']")
	WebElement CompanySearch;
	
	@FindBy(how=How.XPATH,using="//input[@id='companyId']")
	WebElement CompanyId;
	
	@FindBy(how=How.XPATH,using="//select[@id='searchCompanyStatus']")
	public WebElement Status;
	
	@FindBy(how=How.XPATH,using="//select[@id='searchCompanyStatus']/option[contains(text(),'Draft')]")
	WebElement DraftStatus;
	
	@FindBy(how=How.XPATH,using="//select[@id='searchCountry']")
	WebElement SearchCountry;
	
	@FindBy(how=How.XPATH,using="//input[@value='Search']")
	public WebElement SearchBtn;
	
	@FindBy(how=How.ID,using="noOfEmployee")
	public WebElement NumOfEmployees;
	
	@FindBy(how=How.ID,using="noOfRequest")
	WebElement NumOfRequests;
	
	@FindBy(how=How.ID,using="AdminSettingsAction_isPANVerificationRequired")
	WebElement PanVerificationRequired;
	
	@FindBy(how=How.XPATH,using="//input[@name='update']")
	WebElement UpdateBtn;
	
	@FindBy(how=How.XPATH,using="//span[contains(text(),'Admin List')]")
	public WebElement AdminListPage;
	
	@FindBy(how=How.XPATH,using="//a[@onclick='removeCompanyLogo();']")
	public WebElement RemoveLink;
	
	@FindBy(how=How.XPATH,using="//span[contains(text(),'Browse')]")
	public WebElement BrowseBtn;
	
	@FindBy(how=How.XPATH,using="//input[@value='Preview']")
	WebElement PreviewBtn;
	
	@FindBy(how=How.XPATH,using="//input[@value='Accept']")
	public WebElement AcceptBtn;
	
	@FindBy(how=How.XPATH,using="//img[@alt='sutisignAdminLogo']")
	public WebElement AdminLogo;
	
	@FindBy(how=How.XPATH,using="//img[@alt='uploadLogo']")
	public WebElement AdminAccountLogo;
	
	@FindBy(how=How.XPATH,using="//input[@value='Reupload']")
	WebElement ReuploadBtn;
		
	@FindBy(how=How.XPATH,using="//input[@value='Reset']")
	WebElement ResetBtn;
	
	@FindBy(how=How.XPATH,using="(//img[@title='Edit'])[1]")
	WebElement EditDropdown;
	
	@FindBy(how=How.XPATH,using="//input[@onclick='saveDropDownValues();']")
	public WebElement UpdateDropdownBtn;
	
	@FindBy(how=How.XPATH,using="(//img[@title='View'])[1]")
	public WebElement ViewDropdown;
	
	@FindBy(how=How.XPATH,using="//span[contains(text(),'Dropdown Values')]")
	public WebElement DropdownValuesPage;
	
	@FindBy(how=How.XPATH,using="(//img[@title='Inactivate'])[1]")
	WebElement Inactivatevalue;
	
	@FindBy(how=How.XPATH,using="//button[contains(text(),'OK')]")
	public WebElement OkBtn;
	
	@FindBy(how=How.XPATH,using="(//img[@title='Activate'])[1]")
	WebElement ActivateValue;
	
	@FindBy(how=How.XPATH,using="//img[@title='Company Information']")
	WebElement ViewCompanyInformation;
	
	@FindBy(how=How.XPATH,using="//h4[contains(text(),'Company Information')]")
	public WebElement CompanyInformationPopup;
	
	@FindBy(how=How.XPATH,using="//img[@title='Users']")
	WebElement UsersIcon;
	
	@FindBy(how=How.XPATH,using="//h4[contains(text(),'Users')]")
	public WebElement UsersPopup;
	
	public void setCompany(String StrCompany)
	{
		stepstatus = WebLibrary.setText(Company, StrCompany);
		ReportLibrary.reportEvent(stepstatus, "Able to enter Company Field", "Unable to enter Company Field");
	}

	public void setAddress(String StrAddress)
	{
		stepstatus = WebLibrary.setText(Address, StrAddress);
		ReportLibrary.reportEvent(stepstatus, "Able to enter Address Field", "Unable to enter Address Field");
	}

	public void setCity(String StrCity)
	{
		stepstatus = WebLibrary.setText(City, StrCity);
		ReportLibrary.reportEvent(stepstatus, "Able to enter City Field", "Unable to enter City Field");
	}
	
	public void setState(String StrState)
	{
		stepstatus = WebLibrary.setText(State, StrState);
		ReportLibrary.reportEvent(stepstatus, "Able to enter State Field", "Unable to enter State Field");
	}

	public void setCountry(String StrCountry)
	{
		stepstatus = WebLibrary.setOptionInSelectBox(Country, StrCountry);
		ReportLibrary.reportEvent(stepstatus, "Able to select value in Country field", "Unable to select value in Country field");
	}
	
	public void clickonNextBtn()
	{
		stepstatus = WebLibrary.clickElement(NextBtn);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Next Button", "Unable to click on Next Button");
	}
	
	public void clickonFinishBtn()
	{
		stepstatus = WebLibrary.clickElement(FinishBtn);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Finish Button", "Unable to click on Finish Button");
	}
	
	public void clickonClickHereBtn()
	{
		stepstatus = WebLibrary.clickElement(ClickHereBtn);
		ReportLibrary.reportEvent(stepstatus, "Able to click on ClickHere Button", "Unable to click on ClickHere Button");
	}
	
	public void clickonCloseIcon()
	{
		stepstatus = WebLibrary.clickElement(CloseIcon);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Close Icon", "Unable to click on Close Icon");
	}
	
	public void clickonCreateAdminCloseIcon()
	{
		stepstatus = WebLibrary.clickElement(CreateAdminCloseIcon);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Close Icon", "Unable to click on Close Icon");
	}
	
	public void setUser(String StrUser)
	{
		stepstatus = WebLibrary.clickElement(User);
		ReportLibrary.reportEvent(stepstatus, "Able to click on User Field", "Unable to click on User Field");
		stepstatus = WebLibrary.setText(UserAutoSearch, StrUser);
		ReportLibrary.reportEvent(stepstatus, "Able to enter User name in Field", "Unable to enter User name in Field");
	}
	
	public void setAdminCompany()
	{
		WebLibrary.clickElement(CreateAdminCompany);
		WebLibrary.wait(2);
		WebLibrary.clickElement(CreateAdminCompany);
	}
	
	public void setCompanySearch(String StrCompany)
	{
		stepstatus = WebLibrary.setText(CompanySearch, StrCompany);
		ReportLibrary.reportEvent(stepstatus, "Able to enter Company Field", "Unable to enter Company Field");
	}
	
	public void setCompanyId(String StrCompanyId)
	{
		stepstatus = WebLibrary.setText(CompanyId, StrCompanyId);
		ReportLibrary.reportEvent(stepstatus, "Able to enter CompanyId Field", "Unable to enter CompanyId Field");
	}
	
	public void setStatus(String StrStatus)
	{
		stepstatus = WebLibrary.setOptionInSelectBox(Status, StrStatus);
		ReportLibrary.reportEvent(stepstatus, "Able to select status", "Unable to select status");
	}
	
	public void selectDraftStatus()
	{
		stepstatus = WebLibrary.clickElement(DraftStatus);
		ReportLibrary.reportEvent(stepstatus, "Able to select Draft status", "Unable to select Draft status");
	}
	
	public void setSearchCountry(String StrCountry)
	{
		stepstatus = WebLibrary.setOptionInSelectBox(SearchCountry, StrCountry);
		ReportLibrary.reportEvent(stepstatus, "Able to select value in Country field", "Unable to select value in Country field");
	}
	
	public void clickonSearchBtn()
	{
		stepstatus = WebLibrary.clickElement(SearchBtn);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Search button", "Unable to click on Search button");
	}
	
	public void setNumOfEmployees(String StrNumOfEmployees)
	{
		stepstatus = WebLibrary.setText(NumOfEmployees, StrNumOfEmployees);
		ReportLibrary.reportEvent(stepstatus, "Able to enter Number of Employees Field", "Unable to enter Number of Employees Field");
	}
	
	public void setNumOfRequests(String StrNumOfRequests)
	{
		stepstatus = WebLibrary.setText(NumOfRequests, StrNumOfRequests);
		ReportLibrary.reportEvent(stepstatus, "Able to enter Number of Requests Field", "Unable to enter Number of Requests Field");
	}
	
	public void selectPanVerificationRequired()
	{
		stepstatus = WebLibrary.clickElement(PanVerificationRequired);
		ReportLibrary.reportEvent(stepstatus, "Able to select PanVerificationRequired option", "Unable to select PanVerificationRequired option");
	}
	
	public void clickonUpdateBtn()
	{
		stepstatus = WebLibrary.clickElement(UpdateBtn);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Update button", "Unable to click on Update button");
	}
	
	public void clickonRemoveLink()
	{
		stepstatus = WebLibrary.clickElement(RemoveLink);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Remove Link", "Unable to click on Remove Link");
	}
	
	public void clickonBrowseBtn()
	{
		stepstatus = WebLibrary.clickElement(BrowseBtn);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Browse button", "Unable to click on Browse button");
	}
	
	public void clickonPreviewBtn()
	{
		stepstatus = WebLibrary.clickElement(PreviewBtn);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Preview button", "Unable to click on Preview button");
	}
	
	public void clickonAcceptBtn()
	{
		stepstatus = WebLibrary.clickElement(AcceptBtn);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Accept button", "Unable to click on Accept button");
	}
	
	public void clickonReuploadBtn()
	{
		stepstatus = WebLibrary.clickElement(ReuploadBtn);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Reupload button", "Unable to click on Reupload button");
	}
	
	public void clickonResetBtn()
	{
		stepstatus = WebLibrary.clickElement(ResetBtn);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Reset button", "Unable to click on Reset button");
	}
	
	public void clickonEditDropdown()
	{
		stepstatus = WebLibrary.clickElement(EditDropdown);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Edit Dropdown Icon", "Unable to click on Edit Dropdown Icon");
	}
	
	public void clickonUpdateDropdownBtn()
	{
		stepstatus = WebLibrary.clickElement(UpdateDropdownBtn);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Update Button", "Unable to click on Update Button");
	}
	
	public void clickonViewDropdown()
	{
		stepstatus = WebLibrary.clickElement(ViewDropdown);
		ReportLibrary.reportEvent(stepstatus, "Able to click on View Dropdown Icon", "Unable to click on View Dropdown Icon");
	}
	
	public void clickonInactivatevalue()
	{
		stepstatus = WebLibrary.clickElement(Inactivatevalue);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Inactivate Icon", "Unable to click on Inactivate Icon");
	}
	
	public void clickonOkBtn()
	{
		stepstatus = WebLibrary.clickElement(OkBtn);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Ok button", "Unable to click on Ok button");
	}
	
	public void clickonActivateValue()
	{
		stepstatus = WebLibrary.clickElement(ActivateValue);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Activate Icon", "Unable to click on Activate Icon");
	}
	
	public void clickonViewCompanyInformationIcon()
	{
		stepstatus = WebLibrary.clickElement(ViewCompanyInformation);
		ReportLibrary.reportEvent(stepstatus, "Able to click on View Company-Information Icon", "Unable to click on View Company-Information Icon");
	}
	
	public void clickonUsersIcon()
	{
		stepstatus = WebLibrary.clickElement(UsersIcon);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Users Icon", "Unable to click on Users Icon");
	}
}

