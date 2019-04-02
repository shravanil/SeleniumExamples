package ApplicationPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import FrameworkLibrary.ReportLibrary;
import FrameworkLibrary.WebLibrary;

public class MyPreferencesHomePage {
	
	WebDriver driver;
	boolean stepstatus;
	public MyPreferencesHomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(how=How.XPATH,using="//a[text()='My Preferences']")
	WebElement MyPreferences;
			
	@FindBy(how=How.XPATH,using="//a[text()='Personal Information']")
	WebElement PersonalInformation;
		
	@FindBy(how=How.XPATH,using="//a[@id='changePassword']")
	WebElement ChangePassword;

	@FindBy(how=How.XPATH,using="//a[@id='signature']")
	WebElement Signature;

	@FindBy(how=How.XPATH,using="//a[text()='Account Settings']")
	WebElement AccountSettings;

	@FindBy(how=How.XPATH,using="//a[text()='Address Book']")
	WebElement AddressBook;

	@FindBy(how=How.XPATH,using="//a[text()='App Settings']")
	WebElement AppSettings;

	@FindBy(how=How.XPATH,using="//a[text()='My Documents']")
	WebElement MyDocuments;

	@FindBy(how=How.XPATH,using="//a[text()='Received Items']")
	WebElement ReceivedItems;

	public void clickonMyPreferences()
	{
		stepstatus = WebLibrary.clickElement(MyPreferences);
		ReportLibrary.reportEvent(stepstatus, "Able to click on MyPreferences Menu", "Unable to click on MyPreferences Menu",true);
	}

	public void clickonPersonalInformation()
	{
		stepstatus = WebLibrary.clickElement(PersonalInformation);
		ReportLibrary.reportEvent(stepstatus, "Able to click on PersonalInformation Menu", "Unable to click on PersonalInformation Menu",true);
	}

	public void clickonChangePassword()
	{
		stepstatus = WebLibrary.clickElement(ChangePassword);
		ReportLibrary.reportEvent(stepstatus, "Able to click on ChangePassword Menu", "Unable to click on ChangePassword Menu",true);
	}

	public void clickonSignatureMenu()
	{
		stepstatus = WebLibrary.clickElement(Signature);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Signature Menu", "Unable to click on Signature Menu",true);
	}

	public void clickonAccountSettings()
	{
		stepstatus = WebLibrary.clickElement(AccountSettings);
		ReportLibrary.reportEvent(stepstatus, "Able to click on AccountSettings Menu", "Unable to click on AccountSettings Menu",true);
	}

	public void clickonAddressBook()
	{
		stepstatus = WebLibrary.clickElement(AddressBook);
		ReportLibrary.reportEvent(stepstatus, "Able to click on AddressBook Menu", "Unable to click on AddressBook Menu",true);
	}

	public void clickonAppSettings()
	{
		stepstatus = WebLibrary.clickElement(AppSettings);
		ReportLibrary.reportEvent(stepstatus, "Able to click on AppSettings Menu", "Unable to click on AppSettings Menu",true);
	}

	public void clickonMyDocuments()
	{
		stepstatus = WebLibrary.clickElement(MyDocuments);
		ReportLibrary.reportEvent(stepstatus, "Able to click on MyDocuments Menu", "Unable to click on MyDocuments Menu",true);
	}

	public void clickonReceivedItems()
	{
		stepstatus = WebLibrary.clickElement(ReceivedItems);
		ReportLibrary.reportEvent(stepstatus, "Able to click on ReceivedItems Menu", "Unable to click on ReceivedItems Menu",true);
	}
		
}
