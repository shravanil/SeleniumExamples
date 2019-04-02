package TestScripts;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import ApplicationPages.LoginPage;
import FrameworkLibrary.BaseClass;
import FrameworkLibrary.DataLibrary;
import FrameworkLibrary.ReportLibrary;
import FrameworkLibrary.WebLibrary;

public class Login extends BaseClass{
	
	@Test(testName="To Verify Forgot Password and User Registration")
	public void ForgotPasswordAndUserRegistratation()
	{
		LoginPage loginpage = new LoginPage(driver);
		
		loginpage.clickonSignUpLink();
		WebLibrary.setExplicitWait(loginpage.UserRegistrationPage, driver, 40);
		loginpage.setEmailAddress(DataLibrary.getdata("EmailAddress"));
		loginpage.setFirstName(DataLibrary.getdata("FirstName"));
		loginpage.setLastName(DataLibrary.getdata("LastName"));
		loginpage.setPassword1(DataLibrary.getdata("Password1"));
		loginpage.setConfirmPassword(DataLibrary.getdata("ConfirmPassword"));
		loginpage.clickonAcceptTerms();
		loginpage.clickonRegisterBtn();
		WebLibrary.wait(3);
		if(driver.getCurrentUrl().contains("registerSuccess.action")){
	    	ReportLibrary.test.log(LogStatus.PASS, "User Registration successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		 }else{
			 ReportLibrary.test.log(LogStatus.FAIL, "User Registration failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
	 	}
		driver.get(DataLibrary.getdata("BaseURL"));
		loginpage.clickonForgotPassword();
		WebLibrary.setExplicitWait(loginpage.ForgotPasswordPopup, driver, 40);
		loginpage.setRegisteredEmail(DataLibrary.getdata("RegisteredEmail"));
		loginpage.clickonSubmitButton();
		WebLibrary.wait(3);
		boolean ForgotPassword = WebLibrary.verifyTextPresent("Your request for new password is successful. Kindly check your mail for the instructions to reset your password");
		if(ForgotPassword == true){
			ReportLibrary.test.log(LogStatus.PASS, "Forgot Password successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Forgot Password failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		WebLibrary.wait(10);
	}
}
