package ApplicationPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import FrameworkLibrary.ReportLibrary;
import FrameworkLibrary.WebLibrary;

public class CreateInPersonRequest {
	
	WebDriver driver;
	boolean stepstatus;
	public CreateInPersonRequest(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(how=How.XPATH,using="//input[@id='description1']")
	public WebElement RequestTitle;

	@FindBy(how=How.XPATH,using="//select[@id='newHierarchy']")
	WebElement SelectTemplate;
	
	@FindBy(how=How.XPATH,using="//i[@title='Replace Document']")
	WebElement ReplaceDocumentIcon;
	
	@FindBy(how=How.XPATH,using="//i[@title='Undo Replaced Document']")
	public WebElement UndoReplacedDocumentIcon;
	
	@FindBy(how=How.XPATH,using="//input[@value='Create Request']")
	public WebElement CreateRequestBtn;
	
	@FindBy(how=How.XPATH,using="//input[@value='Cancel Request']")
	WebElement CancelRequestBtn;

	public void setRequestTitle(String StrRequestTitle)
	{
		stepstatus = WebLibrary.setText(RequestTitle, StrRequestTitle);
		ReportLibrary.reportEvent(stepstatus, "Able to enter RequestTitle Field", "Unable to enter RequestTitle Field");
	}

	public void setSelectTemplate(String StrSignerSelection)
	{
		stepstatus = WebLibrary.setOptionInSelectBox(SelectTemplate, StrSignerSelection);
		ReportLibrary.reportEvent(stepstatus, "Able to select Template from dropdown", "Unable to select Template from dropdown");
	}
	
	
	public void clickonReplaceDocumentIcon()
	{
		stepstatus = WebLibrary.clickElement(ReplaceDocumentIcon);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Replace Document Icon", "Unable to click on Replace Document Icon",true);
	}
	
	public void clickonUndoReplacedDocumentIcon()
	{
		stepstatus = WebLibrary.clickElement(UndoReplacedDocumentIcon);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Undo Replaced Document Icon", "Unable to click on Undo Replaced Document Icon",true);
	}
	
	public void clickonCreateRequestBtn()
	{
		stepstatus = WebLibrary.clickElement(CreateRequestBtn);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Create Request Button", "Unable to click on Create Request Button",true);
	}
	
	public void clickonCancelRequestBtn()
	{
		stepstatus = WebLibrary.clickElement(CancelRequestBtn);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Cancel Request Button", "Unable to click on Cancel Request Button",true);
	}
	
}