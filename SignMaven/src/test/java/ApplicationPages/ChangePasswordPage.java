package ApplicationPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.model.Test;

import FrameworkLibrary.ReportLibrary;
import FrameworkLibrary.WebLibrary;

public class ChangePasswordPage {
	
	WebDriver driver;
	boolean stepstatus;
	public ChangePasswordPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH,using="//input[@id='oldpassword']")
	WebElement OldPassword;
				
	@FindBy(how=How.XPATH,using="//input[@id='newpassword']")
	WebElement NewPassword;

	@FindBy(how=How.XPATH,using="//input[@id='confirmpassword']")
	WebElement ConfirmPassword;

	@FindBy(how=How.XPATH,using="//input[@value='Update']")
	WebElement UpdateButton;
	
	@FindBy(how=How.XPATH,using="/html/body/div[3]/div/div/div[2]/div")
	WebElement ErrMsg;
	
	public void setOldPassword(String StrOldPassword)
	{
		stepstatus = WebLibrary.setText(OldPassword, StrOldPassword);
		ReportLibrary.reportEvent(stepstatus, "Able to enter OldPassword Field", "Unable to enter OldPassword Field");
	}

	public void setNewPassword(String StrNewPassword)
	{
		stepstatus = WebLibrary.setText(NewPassword, StrNewPassword);
		ReportLibrary.reportEvent(stepstatus, "Able to enter NewPassword Field", "Unable to enter NewPassword Field");
	}

	public void setConfirmPassword(String StrConfirmPassword)
	{
		stepstatus = WebLibrary.setText(ConfirmPassword, StrConfirmPassword);
		ReportLibrary.reportEvent(stepstatus, "Able to enter ConfirmPassword Field", "Unable to enter ConfirmPassword Field");
	}

	public void clickonUpdateButton()
	{
		stepstatus = WebLibrary.clickElement(UpdateButton);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Update Button", "Unable to click on Update Button");
	}
	
	public void BlankErrorMsg()
	{
		String ErrorMsg = WebLibrary.getLinkText(ErrMsg);
		String text = ErrorMsg;
		System.out.println(ErrorMsg);
		if(text.contains("Old Password is required"))
		{
			ReportLibrary.test.log(LogStatus.PASS, "Change Password successfull with blank data"+ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
			//ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot());
			
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Change Password not successfull with blank data"+ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
			//ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot());
		}
	}
	
	public void ValidationMsg()
	{
		String ErrorMsg = WebLibrary.getLinkText(ErrMsg);
		String text = ErrorMsg;
		System.out.println(ErrorMsg);
		if(text.contains("Confirm Password should match with Password"))
		{
			ReportLibrary.test.log(LogStatus.PASS, "Change Password successfull by entering invalid passwords"+ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
			//ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot());
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Change Password failed by entering invalid passwords"+ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
			//ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot());
		}
	}
	
	public void SuccessMsg()
	{
		String ErrorMsg = WebLibrary.getLinkText(ErrMsg);
		String text = ErrorMsg;
		System.out.println(ErrorMsg);
		if(text.contains("Password changed successfully."))
		{
			ReportLibrary.test.log(LogStatus.PASS, "Change Password successfull with valid data"+ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
			//ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot());
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Change Password failed with valid data"+ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
			//ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot());
		}
			
	}
}

