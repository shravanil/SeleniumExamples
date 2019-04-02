package ApplicationPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import FrameworkLibrary.ReportLibrary;
import FrameworkLibrary.WebLibrary;

public class CompanySettingsPage {
	
	WebDriver driver;
	boolean stepstatus;
	public CompanySettingsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(how=How.XPATH,using="//div[contains(text(),'Address Book')]/following-sibling::div/div/div[@class='checkbox-toggle-button']")
	WebElement AddressBookSetting;

	@FindBy(how=How.XPATH,using="//div[contains(text(),'In-Person Request')]/following-sibling::div/div/div[@class='checkbox-toggle-button']")
	WebElement InPersonRequestSetting;

	@FindBy(how=How.XPATH,using="//div[contains(text(),'Supporting Documents')]/following-sibling::div/div/div[@class='checkbox-toggle-button']")
	WebElement SupportingDocumentsSetting;
	
	@FindBy(how=How.XPATH,using="//input[@value='Update']")
	WebElement UpdateBtn;

	public void clickonAddressBookSetting()
	{
		stepstatus = WebLibrary.clickElement(AddressBookSetting);
		ReportLibrary.reportEvent(stepstatus, "Able to click ON/OFF AddressBook Setting", "Unable to ON/OFF AddressBook Setting");
	}
	
	public void clickonInPersonRequestSetting()
	{
		stepstatus = WebLibrary.clickElement(InPersonRequestSetting);
		ReportLibrary.reportEvent(stepstatus, "Able to click ON/OFF InPersonRequest Setting", "Unable to ON/OFF InPersonRequest Setting");
	}
	
	public void clickonSupportingDocumentsSetting()
	{
		stepstatus = WebLibrary.clickElement(SupportingDocumentsSetting);
		ReportLibrary.reportEvent(stepstatus, "Able to click ON/OFF SupportingDocuments Setting", "Unable to ON/OFF SupportingDocuments Setting");
	}
	
	public void clickonUpdateBtn()
	{
		stepstatus = WebLibrary.clickElement(UpdateBtn);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Update Button", "Unable to click on Update Button");
	}
	

}
