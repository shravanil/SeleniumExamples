package ApplicationPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import FrameworkLibrary.ReportLibrary;
import FrameworkLibrary.WebLibrary;

public class CreateGroupRequest {
	
	WebDriver driver;
	boolean stepstatus;
	public CreateGroupRequest(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(how=How.XPATH,using="//input[@id='description1']")
	WebElement RequestTitle;

	@FindBy(how=How.XPATH,using="//select[@id='newHierarchy']")
	WebElement SelectTemplate;
	
	@FindBy(how=How.XPATH,using="//select[@id='groupName']")
	WebElement SignerGroup;
	
	@FindBy(how=How.XPATH,using="//span[contains(text(),'Browse')]")
	public WebElement BrowseBtn;
	
	@FindBy(how=How.XPATH,using="//input[@value='Send Now']")
	WebElement SendNowBtn;

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
	
	public void SelectSignerGroup(String StrSignerGroup)
	{
		stepstatus = WebLibrary.SelectOptionByValue(SignerGroup, StrSignerGroup);
		ReportLibrary.reportEvent(stepstatus, "Able to select SignerGroup from dropdown", "Unable to select SignerGroup from dropdown");
	}
	
	public void clickonBrowseBtn()
	{
		stepstatus = WebLibrary.clickElement(BrowseBtn);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Browse Button", "Unable to click on Browse Button",true);
	}
	
	public void clickonSendNowBtn()
	{
		stepstatus = WebLibrary.clickElement(SendNowBtn);
		ReportLibrary.reportEvent(stepstatus, "Able to click on SendNow Button", "Unable to click on SendNow Button",true);
	}
	
}