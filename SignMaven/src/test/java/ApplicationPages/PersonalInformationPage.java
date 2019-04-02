package ApplicationPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import FrameworkLibrary.ReportLibrary;
import FrameworkLibrary.WebLibrary;

public class PersonalInformationPage {
	
	WebDriver driver;
	boolean stepstatus;
	public PersonalInformationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH,using="//input[@id='firstname']")
	WebElement FirstName;

	@FindBy(how=How.XPATH,using="//input[@id='lastname']")
	WebElement LastName;

	@FindBy(how=How.XPATH,using="//textarea[@id='address']")
	WebElement Address;	

	@FindBy(how=How.XPATH,using="//textarea[@id='address']")
	WebElement OtherDetails;	

	@FindBy(how=How.XPATH,using="//input[@id='zipcode']")
	WebElement Zip;

	@FindBy(how=How.XPATH,using="//input[@id='contactno']")
	WebElement ContactNum;

	@FindBy(how=How.XPATH,using="//input[@id='faxno']")
	WebElement FaxNo;

	@FindBy(how=How.XPATH,using="//input[@id='cityname']")
	WebElement CityName;

	@FindBy(how=How.XPATH,using="//input[@id='state']")
	WebElement State;

	@FindBy(how=How.XPATH,using="//input[@type='submit']")
	WebElement UpdateButton;
		
	public void setFirstName(String StrFirstName)
	{
		stepstatus = WebLibrary.setText(FirstName, StrFirstName);
		ReportLibrary.reportEvent(stepstatus, "Able to enter FirstName Field", "Unable to enter FirstName Field");
	}

	public void setLastName(String StrLastName)
	{
		stepstatus = WebLibrary.setText(LastName, StrLastName);
		ReportLibrary.reportEvent(stepstatus, "Able to enter LastName Field", "Unable to enter LastName Field");
	}

	public void setAddress(String StrAddress)
	{
		stepstatus = WebLibrary.setText(Address, StrAddress);
		ReportLibrary.reportEvent(stepstatus, "Able to enter Address Field", "Unable to enter Address Field");
	}

	public void setOtherDetails(String StrOtherDetails)
	{
		stepstatus = WebLibrary.setText(OtherDetails, StrOtherDetails);
		ReportLibrary.reportEvent(stepstatus, "Able to enter OtherDetails Field", "Unable to enter OtherDetails Field");
	}

	public void setZip(String StrZip)
	{
		stepstatus = WebLibrary.setText(Zip, StrZip);
		ReportLibrary.reportEvent(stepstatus, "Able to enter Zip Field", "Unable to enter Zip Field");
	}

	public void setContactNum(String StrContactNum)
	{
		stepstatus = WebLibrary.setText(ContactNum, StrContactNum);
		ReportLibrary.reportEvent(stepstatus, "Able to enter ContactNum Field", "Unable to enter ContactNum Field");
	}

	public void setFaxNo(String StrFaxNo)
	{
		stepstatus = WebLibrary.setText(FaxNo, StrFaxNo);
		ReportLibrary.reportEvent(stepstatus, "Able to enter FaxNo Field", "Unable to enter FaxNo Field");
	}

	public void setCityName(String StrCityName)
	{
		stepstatus = WebLibrary.setText(CityName, StrCityName);
		ReportLibrary.reportEvent(stepstatus, "Able to enter CityName Field", "Unable to enter CityName Field");
	}

	public void setState(String StrState)
	{
		stepstatus = WebLibrary.setText(State, StrState);
		ReportLibrary.reportEvent(stepstatus, "Able to enter State Field", "Unable to enter State Field");
	}

	public void clickonUpdateButton()
	{
		stepstatus = WebLibrary.clickElement(UpdateButton);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Update Button", "Unable to click on Update Button",true);
		
	}

}
