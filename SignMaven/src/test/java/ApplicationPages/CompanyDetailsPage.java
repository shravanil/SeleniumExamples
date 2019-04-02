package ApplicationPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import FrameworkLibrary.ReportLibrary;
import FrameworkLibrary.WebLibrary;

public class CompanyDetailsPage {
	
	WebDriver driver;
	boolean stepstatus;
	public CompanyDetailsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(how=How.XPATH,using="//textarea[@id='address']")
	WebElement Address;

	@FindBy(how=How.XPATH,using="//input[@id='cityname']")
	WebElement City;

	@FindBy(how=How.XPATH,using="//input[@id='state']")
	WebElement State;
	
	@FindBy(how=How.XPATH,using="//select[@id='country']")
	WebElement Country;

	@FindBy(how=How.XPATH,using="//input[@id='zipcode']")
	WebElement Zip;

	@FindBy(how=How.XPATH,using="//input[@id='phoneno']")
	WebElement PhoneNum;

	@FindBy(how=How.XPATH,using="//input[@id='faxno']")
	WebElement Fax;

	@FindBy(how=How.XPATH,using="//input[@id='supportemail']")
	WebElement SupportEmail;

	@FindBy(how=How.XPATH,using="//input[@id='supporturl']")
	WebElement SupportURL;

	@FindBy(how=How.XPATH,using="//input[@name='update']")
	WebElement UpdateBtn;
	
	@FindBy(how=How.XPATH,using="//input[@name='delete']")
	WebElement DeleteBtn;

	@FindBy(how=How.XPATH,using="//input[@value='Deactivate']")
	WebElement DeactivateBtn;
	
	@FindBy(how=How.XPATH,using="//input[@value='Activate']")
	WebElement ActivateBtn;
	
	@FindBy(how=How.XPATH,using="//button[text()='OK']")
	public WebElement ConfirmOkBtn;
	
	@FindBy(how=How.XPATH,using="//div[@class='alert alert-success']")
	WebElement Message;

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
	
	public void setZip(String StrZip)
	{
		stepstatus = WebLibrary.setText(Zip, StrZip);
		ReportLibrary.reportEvent(stepstatus, "Able to enter Zip Field", "Unable to enter Zip Field");
	}

	public void setPhoneNum(String StrPhoneNum)
	{
		stepstatus = WebLibrary.setText(PhoneNum, StrPhoneNum);
		ReportLibrary.reportEvent(stepstatus, "Able to enter PhoneNum Field", "Unable to enter PhoneNum Field");
	}

	public void setFax(String StrFax)
	{
		stepstatus = WebLibrary.setText(Fax, StrFax);
		ReportLibrary.reportEvent(stepstatus, "Able to enter Fax Field", "Unable to enter Fax Field");
	}

	public void setSupportEmail(String StrSupportEmail)
	{
		stepstatus = WebLibrary.setText(SupportEmail, StrSupportEmail);
		ReportLibrary.reportEvent(stepstatus, "Able to enter SupportEmail Field", "Unable to enter SupportEmail Field");
	}

	public void setSupportURL(String StrSupportURL)
	{
		stepstatus = WebLibrary.setText(SupportURL, StrSupportURL);
		ReportLibrary.reportEvent(stepstatus, "Able to enter SupportURL Field", "Unable to enter SupportURL Field");
	}

	public void clickonUpdateBtn()
	{
		stepstatus = WebLibrary.clickElement(UpdateBtn);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Update Button", "Unable to click on Update Button");
	}
	
	public void clickonDeleteBtn()
	{
		stepstatus = WebLibrary.clickElement(DeleteBtn);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Delete Button", "Unable to click on Delete Button");
	}
	

	public void clickonDeactivateBtn()
	{
		stepstatus = WebLibrary.clickElement(DeactivateBtn);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Deactivate Button", "Unable to click on Deactivate Button",true);
	}
	
	public void clickonActivateBtn()
	{
		stepstatus = WebLibrary.clickElement(ActivateBtn);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Activate Button", "Unable to click on Activate Button",true);
	}
	
	public void clickonConfirmOkBtn()
	{
		stepstatus = WebLibrary.clickElement(ConfirmOkBtn);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Confirm Ok Button", "Unable to click on Confirm Ok Button",true);
	}
	
	public void BlankDataValidation()
	{
		stepstatus=WebLibrary.ImageComparision("F:\\SignSikuliScreens\\CompanyDetails_BlankErrMsg.PNG", "F:\\SignAutomationScreens\\");
		ReportLibrary.reportEvent(stepstatus, "Blank Data Error message validation successfull", "Blank Data Error message validation failed",true);		
	}
	
	public void InvalidDataValidation()
	{
		stepstatus=WebLibrary.ImageComparision("F:\\SignSikuliScreens\\CompanyDetails_InvalidErrMsg.PNG", "F:\\SignAutomationScreens\\");
		ReportLibrary.reportEvent(stepstatus, "Invalid Data Error message validation successfull", "Invalid Data Error message validation failed",true);		
	}
	
	public void ValidDataValidation()
	{
		stepstatus=WebLibrary.ImageComparision("F:\\SignSikuliScreens\\CompanyDetails_ValidMsg.PNG", "F:\\SignAutomationScreens\\");
		ReportLibrary.reportEvent(stepstatus, "Company Details with Valid Data validation successfull", "Company Details with Valid Data validation failed",true);		
	}

	public void verifyCompanyDeactivationMsg()
	{
		stepstatus = WebLibrary.verifyTextPresent(Message, "Company deactivated successfully");
		ReportLibrary.reportEvent(stepstatus, "Company Deactivation success message got displayed", "Company Deactivation success message not displayed", true);
	}	
	
	public void verifyCompanyActivationMsg()
	{
		stepstatus = WebLibrary.verifyTextPresent(Message, "Company Activated Successfully");
		ReportLibrary.reportEvent(stepstatus, "Company Activation success message got displayed", "Company Activation success message not displayed", true);
	}	
}
