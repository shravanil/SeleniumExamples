package ApplicationPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import FrameworkLibrary.ReportLibrary;
import FrameworkLibrary.WebLibrary;

public class ReportsPage {
	
	WebDriver driver;
	boolean stepstatus;
	public ReportsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how=How.XPATH,using="//select[@id='hierarchy']/option[2]")
	WebElement TemplateName;	
	
	@FindBy(how=How.XPATH,using="//select[@id='reportType']")
	WebElement ReportType;	
	
	@FindBy(how=How.XPATH,using="//select[@id='statNames']")
	WebElement Status;
	
	@FindBy(how=How.XPATH,using="//input[@id='requestId']")
	WebElement RequestId;
	
	@FindBy(how=How.XPATH,using="//input[@id='reqdate']")
	WebElement RequestFromDate;
	
	@FindBy(how=How.XPATH,using="//input[@id='todate']")
	WebElement RequestToDate;
	
	@FindBy(how=How.XPATH,using="//select[@id='signatory']")
	WebElement Signer;
	
	@FindBy(how=How.XPATH,using="//select[@id='signatoryStatus']")
	WebElement SignerStatus;
	
	@FindBy(how=How.XPATH,using="//select[@id='requestStatus']")
	WebElement RequestStatus;
	
	@FindBy(how=How.XPATH,using="//select[@name='templateRequests']/option[1]")
	WebElement FirstRequest;
	
	@FindBy(how=How.XPATH,using="//input[@value='Search']")
	WebElement SearchBtn;
	
	@FindBy(how=How.XPATH,using="//table/tbody/tr/td[1]/div/span")
	WebElement ViewRequestDetails;
	
	@FindBy(how=How.XPATH,using="//span[contains(text(),'Download Report')]")
	WebElement DownloadReport;
	
	@FindBy(how=How.XPATH,using="(//img[@title='Edit'])[1]")
	WebElement EditIcon;
	
	@FindBy(how=How.XPATH,using="//h4[contains(text(),'Request Details')]")
	public WebElement RequestDetailsPopup;
	
	@FindBy(how=How.XPATH,using="(//img[@title='Close'])[1]")
	WebElement CloseIcon;	
	
	@FindBy(how=How.XPATH,using="//select[@id='formats']")
	WebElement SelectFormat;
	
	@FindBy(how=How.XPATH,using="//a[@id='downloadCur']")
	WebElement DownloadCurrentPageIcon;
	
	@FindBy(how=How.XPATH,using="//a[@id='downloadAll']")
	WebElement DownloadAllIcon;
	
	@FindBy(how=How.XPATH,using="//img[@id='downloadCur']")
	WebElement DetailedReportDownloadCurrentPageIcon;
	
	@FindBy(how=How.XPATH,using="//img[@id='downloadAll']")
	WebElement DetailedReportDownloadAllIcon;
	
	public void setTemplateName()
	{
		stepstatus = WebLibrary.clickElement(TemplateName);
		ReportLibrary.reportEvent(stepstatus, "Able to select Template from list", "Unable to select Template from list");
	}
	
	public String getTemplateName()
	{
		return WebLibrary.getLinkText(TemplateName);
	}
	
	public void setReportType(String StrReportType)
	{
		stepstatus = WebLibrary.setOptionInSelectBox(ReportType, StrReportType);
		ReportLibrary.reportEvent(stepstatus, "Able to select ReportType from list", "Unable to select ReportType from list");
	}
	
	public void setStatus(String StrStatus)
	{
		stepstatus = WebLibrary.setOptionInSelectBox(Status, StrStatus);
		ReportLibrary.reportEvent(stepstatus, "Able to select Status from list", "Unable to select Status from list");
	}
	
	public void setRequestId(String StrRequestId)
	{
		stepstatus = WebLibrary.setText(RequestId, StrRequestId);
		ReportLibrary.reportEvent(stepstatus, "Able to enter RequestId Field", "Unable to enter RequestTitle Field");
	}
	
	public void clickonRequestFromDate()
	{
		stepstatus = WebLibrary.clickElement(RequestFromDate);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Request From Date", "Unable to click on Request From Date");
	}
	
	public void clickonRequestToDate()
	{
		stepstatus = WebLibrary.clickElement(RequestToDate);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Request To Date", "Unable to click on Request To Date");
	}
	
	public void selectSigner(String StrSigner)
	{
		stepstatus = WebLibrary.setOptionInSelectBox(Signer, StrSigner);
		ReportLibrary.reportEvent(stepstatus, "Able to select Signer from list", "Unable to select Signer from list");
	}
	
	public void selectSignerStatus(String StrSignerStatus)
	{
		stepstatus = WebLibrary.setOptionInSelectBox(SignerStatus, StrSignerStatus);
		ReportLibrary.reportEvent(stepstatus, "Able to select Signer Status from list", "Unable to select Signer Status from list");
	}
	
	public void selectRequestStatus(String StrRequestStatus)
	{
		stepstatus = WebLibrary.setOptionInSelectBox(RequestStatus, StrRequestStatus);
		ReportLibrary.reportEvent(stepstatus, "Able to select Request Status from list", "Unable to select Request Status from list");
	}
	
	public void selectFirstRequest()
	{
		stepstatus = WebLibrary.clickElement(FirstRequest);
		ReportLibrary.reportEvent(stepstatus, "Able to select Request", "Unable to select Request");
	}
	
	public String getRequestName()
	{
		return WebLibrary.getLinkText(FirstRequest);
	}
	
	
	public void clickonSearchBtn()
	{
		stepstatus = WebLibrary.clickElement(SearchBtn);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Search Button", "Unable to click on Search Button");
	}
	
	public void clickonViewRequestDetails()
	{
		stepstatus = WebLibrary.clickElement(ViewRequestDetails);
		ReportLibrary.reportEvent(stepstatus, "Able to click on View RequestDetails Icon", "Unable to click on View RequestDetails Icon");
	}
	
	public void clickonDownloadReport()
	{
		stepstatus = WebLibrary.clickElement(DownloadReport);
		ReportLibrary.reportEvent(stepstatus, "Able to click on DownloadReport Icon", "Unable to click on DownloadReport Icon");
	}
	
	public void clickonEditIcon()
	{
		stepstatus = WebLibrary.clickElement(EditIcon);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Edit Icon", "Unable to click on Edit Icon");
	}
	
	public void clickonCloseIcon()
	{
		stepstatus = WebLibrary.clickElement(CloseIcon);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Close Icon", "Unable to click on Close Icon");
	}
	
	
	public void SelectFormat(String StrSelectFormat)
	{
		stepstatus = WebLibrary.setOptionInSelectBox(SelectFormat, StrSelectFormat);
		ReportLibrary.reportEvent(stepstatus, "Able to select Format from list", "Unable to select Format from list");
	}
	
	public void clickonDownloadCurrentPageIcon()
	{
		stepstatus = WebLibrary.clickElement(DownloadCurrentPageIcon);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Download Current Page Icon", "Unable to click on Download Current Page Icon");
	}
	
	public void clickonDownloadAllIcon()
	{
		stepstatus = WebLibrary.clickElement(DownloadAllIcon);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Download All Icon", "Unable to click on Download All Icon");
	}
	
	public void clickonDetailedReportDownloadCurrentPageIcon()
	{
		stepstatus = WebLibrary.clickElement(DetailedReportDownloadCurrentPageIcon);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Download Current Page Icon in Detailed Report screen", "Unable to click on Download Current Page Icon in Detailed Report screen");
	}
	
	public void clickonDetailedReportDownloadAllIcon()
	{
		stepstatus = WebLibrary.clickElement(DetailedReportDownloadAllIcon);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Download All Icon in Detailed Report screen", "Unable to click on Download All Icon in Detailed Report screen");
	}
}

