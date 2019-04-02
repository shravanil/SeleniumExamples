package ApplicationPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import FrameworkLibrary.ReportLibrary;
import FrameworkLibrary.WebLibrary;

public class LoginPage {
	
	WebDriver driver;
	static boolean stepstatus;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how=How.XPATH,using="//input[@name='username']")
	WebElement Username;
	
	@FindBy(how=How.XPATH,using="//input[@name='password']")
	WebElement Password;
		
	@FindBy(how=How.XPATH,using="//button[text()='Sign In']")
	WebElement SignIn;
	
	@FindBy(how=How.XPATH,using="//input[@id='checkbox']")
	WebElement KeepMeSignIn;
	
	@FindBy(how=How.XPATH,using="//a[text()=' Forgot Password? ']")
	WebElement ForgotPasswordLink;
	
	@FindBy(how=How.XPATH,using="//h4[contains(text(),'Forgot Password')]")
	public WebElement ForgotPasswordPopup;
	
	@FindBy(how=How.XPATH,using="//input[@id='emailId']")
	WebElement RegisteredEmail;
	
	@FindBy(how=How.XPATH,using="//input[@type='submit']")
	WebElement SubmitButton;

	@FindBy(how=How.XPATH,using="//form[@id='LoginForm']/div[4]/a")
	WebElement SignUpLink;
	
	@FindBy(how=How.XPATH,using="//h5[contains(text(),'User Registration')]")
	public WebElement UserRegistrationPage;
	
	@FindBy(how=How.ID,using="emailId")
	WebElement EmailAddress;
	
	@FindBy(how=How.ID,using="firstName")
	WebElement FirstName;
	
	@FindBy(how=How.ID,using="lastName")
	WebElement LastName;
	
	@FindBy(how=How.ID,using="password")
	WebElement Password1;
	
	@FindBy(how=How.ID,using="confirmPassword")
	WebElement ConfirmPassword;
	
	@FindBy(how=How.ID,using="acceptTermsCheckBox")
	WebElement AcceptTerms;
	
	@FindBy(how=How.XPATH,using="//input[@value='Register']")
	WebElement RegisterBtn;
			
	
	public void setUsername(String StrUsername)
	{
		stepstatus = WebLibrary.setText(Username, StrUsername);
		ReportLibrary.reportEvent(stepstatus, "Able to enter Username Field", "Unable to enter Username Field");
	}
	
	public void setPassword(String StrPassword)
	{
		stepstatus = WebLibrary.setText(Password, StrPassword);
		ReportLibrary.reportEvent(stepstatus, "Able to enter Password Field", "Unable to enter Password Field");
	}
	
	public void clickonLogin()
	{
		stepstatus = WebLibrary.clickElement(SignIn);
		ReportLibrary.reportEvent(stepstatus, "Able to click on SignIn Button", "Unable to click on SignIn Button");
	}
	
	public void clickonKeepMeSignIn()
	{
		stepstatus = WebLibrary.clickElement(KeepMeSignIn);
		ReportLibrary.reportEvent(stepstatus, "Able to click on KeepMeSignIn checkbox", "Unable to click on KeepMeSignIn checkbox",true);
	}
	
	public void clickonForgotPassword()
	{
		stepstatus = WebLibrary.clickElement(ForgotPasswordLink);
		ReportLibrary.reportEvent(stepstatus, "Able to click on ForgotPassword Link", "Unable to click on ForgotPassword Link",true);
	}
	
	public void setRegisteredEmail(String StrRegisteredEmail)
	{
		stepstatus = WebLibrary.setText(RegisteredEmail, StrRegisteredEmail);
		ReportLibrary.reportEvent(stepstatus, "Able to enter RegisteredEmail Field", "Unable to enter RegisteredEmail Field");
	}

	public void clickonSubmitButton()
	{
		stepstatus = WebLibrary.clickElement(SubmitButton);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Submit Button", "Unable to click on Submit Button",true);
	}
	
	public void clickonSignUpLink()
		{
			stepstatus = WebLibrary.clickElement(SignUpLink);
			ReportLibrary.reportEvent(stepstatus, "Able to click on SignUpLink", "Unable to click on SignUpLink",true);
		}
	
	public void setEmailAddress(String StrEmailAddress)
	{
		stepstatus = WebLibrary.setText(EmailAddress, StrEmailAddress);
		ReportLibrary.reportEvent(stepstatus, "Able to enter Email Address Field", "Unable to enter Email Address Field");
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
	
	public void setPassword1(String StrPassword1)
	{
		stepstatus = WebLibrary.setText(Password1, StrPassword1);
		ReportLibrary.reportEvent(stepstatus, "Able to enter Password Field", "Unable to enter Password Field");
	}
	
	public void setConfirmPassword(String StrConfirmPassword)
	{
		stepstatus = WebLibrary.setText(ConfirmPassword, StrConfirmPassword);
		ReportLibrary.reportEvent(stepstatus, "Able to enter ConfirmPassword Field", "Unable to enter ConfirmPassword Field");
	}
	
	public void clickonAcceptTerms()
	{
		stepstatus = WebLibrary.clickElement(AcceptTerms);
		ReportLibrary.reportEvent(stepstatus, "Able to click on AcceptTerms Link", "Unable to click on AcceptTerms Link");
	}
	
	public void clickonRegisterBtn()
	{
		stepstatus = WebLibrary.clickElement(RegisterBtn);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Register Button", "Unable to click on Register Button");
	}
}
