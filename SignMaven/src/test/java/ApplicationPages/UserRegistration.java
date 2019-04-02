package ApplicationPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import FrameworkLibrary.ReportLibrary;
import FrameworkLibrary.WebLibrary;

public class UserRegistration {
	
	WebDriver driver;
	boolean stepstatus;
	public UserRegistration(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how=How.XPATH,using="//input[@id='emailId']")
	WebElement EmailId;
	
	@FindBy(how=How.XPATH,using="//input[@id='firstName']")
	WebElement FirstName;
	
	@FindBy(how=How.XPATH,using="//input[@id='lastName']")
	WebElement LastName;
	
	@FindBy(how=How.XPATH,using="//input[@id='password']")
	WebElement Password;
	
	@FindBy(how=How.XPATH,using="//input[@id='confirmPassword']")
	WebElement ConfirmPassword;
	
	@FindBy(how=How.XPATH,using="//a[contains(text(),'I Accept the Terms and Conditions')]")
	WebElement TermsLink;
	
	@FindBy(how=How.XPATH,using="//input[@id='acceptTermsCheckBox']")
	WebElement TermsCheckbox;
	
	@FindBy(how=How.XPATH,using="//input[@value='Register']")
	WebElement RegisterButton;
	
	public void setEmailId(String StrEmailId)
	{
		stepstatus = WebLibrary.setText(EmailId, StrEmailId);
		ReportLibrary.reportEvent(stepstatus, "Able to enter EmailId Field", "Unable to enter EmailId Field");
	}
	
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
	
	public void setPassword(String StrPassword)
	{
		stepstatus = WebLibrary.setText(Password, StrPassword);
		ReportLibrary.reportEvent(stepstatus, "Able to enter Password Field", "Unable to enter Password Field");
	}
	
	public void setConfirmPassword(String StrConfirmPassword)
	{
		stepstatus = WebLibrary.setText(ConfirmPassword, StrConfirmPassword);
		ReportLibrary.reportEvent(stepstatus, "Able to enter ConfirmPassword Field", "Unable to enter ConfirmPassword Field");
	}
	
	public void clickonTermsLink()
	{
		stepstatus = WebLibrary.clickElement(TermsLink);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Terms Link", "Unable to click on Terms Link",true);

	}
	
	public void clickonTermsCheckbox()
	{
		stepstatus = WebLibrary.clickElement(TermsCheckbox);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Terms Checkbox", "Unable to click on Terms Checkbox",true);
		
	}
	
	public void clickonRegisterButton()
	{
		stepstatus = WebLibrary.clickElement(RegisterButton);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Register Button", "Unable to click on Register Button",true);
	}
}
