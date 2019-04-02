package ApplicationPages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import FrameworkLibrary.ReportLibrary;
import FrameworkLibrary.WebLibrary;

public class CustomizePage {
	
	WebDriver driver;
	boolean stepstatus;
	public CustomizePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(how=How.XPATH,using="//table/tbody/tr/td[2][@title='Request Notification']/following-sibling::td[7]/div/a/img[@title='Edit']")
	WebElement EditRequestNotification;
	
	@FindBy(how=How.XPATH,using="//table/tbody/tr/td[2][@title='Request Notification']/following-sibling::td[7]/div/a/img[@title='History']")
	WebElement RequestNotificationHistory;

	@FindBy(how=How.XPATH,using="//table/tbody/tr/td[2][@title='Request Pending']/following-sibling::td[7]/div/a/img[@title='Edit']")
	WebElement EditRequestPending;
	
	@FindBy(how=How.XPATH,using="//table/tbody/tr/td[2][@title='Request Pending']/following-sibling::td[7]/div/a/img[@title='History']")
	WebElement RequestPendingHistory;
	
	@FindBy(how=How.XPATH,using="//table/tbody/tr/td[2][@title='User Notification']/following-sibling::td[6]/a/img[@title='Edit']")
	WebElement EditUserNotification;
	
	@FindBy(how=How.XPATH,using="//input[@id='hours']")
	WebElement Hours;
	
	@FindBy(how=How.XPATH,using="//input[@id='minutes']")
	WebElement Minutes;
	
	@FindBy(how=How.XPATH,using="//input[@value='Deactivate']")
	public WebElement DeactivateBtn;
	
	@FindBy(how=How.XPATH,using="//input[@value='Update']")
	WebElement UpdateBtn;
	
	@FindBy(how=How.XPATH,using="//input[@value='Activate']")
	WebElement ActivateBtn;
	
	@FindBy(how=How.XPATH,using="//button[contains(text(),'OK')]")
	public WebElement OkBtn;
	
	@FindBy(how=How.XPATH,using="//input[@value='Run Now']")
	WebElement RunNowBtn;
	
	@FindBy(how=How.XPATH,using="//button[text()='OK']")
	public WebElement RunNowOKBtn;
	
	@FindBy(how=How.XPATH,using="(//a[contains(text(),'Batch Jobs')])[2]")
	WebElement BatchJobLink;
	
	@FindBy(how=How.ID,using="frmdate")
	WebElement FromDate;
	
	@FindBy(how=How.XPATH,using="(//input[@value='Search'])[2]")
	WebElement SearchBtn;
	
	public void clickonEditRequestNotification()
	{
		stepstatus = WebLibrary.clickElement(EditRequestNotification);
		ReportLibrary.reportEvent(stepstatus, "Able to click on EditRequestNotification Icon", "Unable to click on EditRequestNotification Icon");
	}
	
	public void clickonRequestNotificationHistory()
	{
		stepstatus = WebLibrary.clickElement(RequestNotificationHistory);
		ReportLibrary.reportEvent(stepstatus, "Able to click on RequestNotificationHistory Icon", "Unable to click on RequestNotificationHistory Icon");
	}
	
	public void clickonEditRequestPending()
	{
		stepstatus = WebLibrary.clickElement(EditRequestPending);
		ReportLibrary.reportEvent(stepstatus, "Able to click on EditRequestPending Icon", "Unable to click on EditRequestPending Icon");
	}
	
	public void clickonRequestPendingHistory()
	{
		stepstatus = WebLibrary.clickElement(RequestPendingHistory);
		ReportLibrary.reportEvent(stepstatus, "Able to click on RequestPendingHistory Icon", "Unable to click on RequestPendingHistory Icon");
	}
	
	public void clickonEditUserNotification()
	{
		stepstatus = WebLibrary.clickElement(EditUserNotification);
		ReportLibrary.reportEvent(stepstatus, "Able to click on EditUserNotification Icon", "Unable to click on EditUserNotification Icon");
	}
	
	public void setHours(String StrHours)
	{
		stepstatus = WebLibrary.setText(Hours, StrHours);
		ReportLibrary.reportEvent(stepstatus, "Able to enter Hours Field", "Unable to enter Hours Field");
	}

	public void setMinutes(String StrMinutes)
	{
		stepstatus = WebLibrary.setText(Minutes, StrMinutes);
		ReportLibrary.reportEvent(stepstatus, "Able to enter Minutes Field", "Unable to enter Minutes Field");
	}
	
	public void clickonDeactivateBtn()
	{
		stepstatus = WebLibrary.clickElement(DeactivateBtn);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Deactivate Button", "Unable to click on Deactivate Button");
	}
	
	public void clickonUpdateBtn()
	{
		stepstatus = WebLibrary.clickElement(UpdateBtn);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Update Button", "Unable to click on Update Button");
	}
	
	public void clickonActivateBtn()
	{
		stepstatus = WebLibrary.clickElement(ActivateBtn);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Activate Button", "Unable to click on Activate Button");
	}
	
	public void clickonOkBtn()
	{
		stepstatus = WebLibrary.clickElement(OkBtn);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Ok Button", "Unable to click on Ok Button");
	}

	public void clickonRunNowBtn()
	{
		stepstatus = WebLibrary.clickElement(RunNowBtn);
		ReportLibrary.reportEvent(stepstatus, "Able to click on RunNow Button", "Unable to click on RunNow Button");
	}
	
	public void clickonRunNowOkBtn()
	{
		stepstatus = WebLibrary.clickElement(RunNowOKBtn);
		ReportLibrary.reportEvent(stepstatus, "Able to click on 'Ok' button in Accept Terms popup", "Unable to click on 'Ok' button in Accept Terms popup",true);
	}
	
	public void clickonBatchJobLink()
	{
		stepstatus = WebLibrary.clickElement(BatchJobLink);
		ReportLibrary.reportEvent(stepstatus, "Able to click on BatchJob Link", "Unable to click on BatchJob Link",true);
	}
	
	public void clickonFromDate()
	{
		stepstatus = WebLibrary.clickElement(FromDate);
		ReportLibrary.reportEvent(stepstatus, "Able to click on FromDate", "Unable to click on FromDate",true);
	}
	
	public void clickonSearchBtn()
	{
		stepstatus = WebLibrary.clickElement(SearchBtn);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Search Button", "Unable to click on Search Button",true);
	}
	
	
}
