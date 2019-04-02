package ApplicationPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import com.relevantcodes.extentreports.LogStatus;
import FrameworkLibrary.ReportLibrary;
import FrameworkLibrary.WebLibrary;

public class AddressBookPage {
	
	WebDriver driver;
	boolean stepstatus;
	public AddressBookPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH,using="//input[@id='firstName']")
	WebElement FirstName;

	@FindBy(how=How.XPATH,using="//input[@id='lastName']")
	WebElement LastName;
	
	@FindBy(how=How.XPATH,using="//input[@value='Update']")
	WebElement UpdateBtn;
	
	@FindBy(how=How.XPATH,using="//span[contains(text(),'Delete')]")
	WebElement DeleteIcon;
	
	@FindBy(how=How.XPATH,using="//button[contains(text(),'OK')]")
	WebElement OKButton;
	
	@FindBy(how=How.XPATH,using="//div[@class='alert alert-success']")
	WebElement SuccessMsg;
		
	public void setFirstName(String StrFirstName)
	{
		stepstatus = WebLibrary.setText(FirstName, StrFirstName);
		ReportLibrary.reportEvent(stepstatus, "Able to enter First Name Field", "Unable to enter First Name Field");
	}
	
	public void setLastName(String StrLastName)
	{
		stepstatus = WebLibrary.setText(LastName, StrLastName);
		ReportLibrary.reportEvent(stepstatus, "Able to enter Last Name Field", "Unable to enter Last Name Field");
	}

	public void clickonUpdateBtn()
	{
		stepstatus = WebLibrary.clickElement(UpdateBtn);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Update Button", "Unable to click on Update Button",true);

	}
	
	public void clickonDeleteIcon()
	{
		stepstatus = WebLibrary.clickElement(DeleteIcon);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Delete Icon", "Unable to click on Delete Icon",true);

	}
	
	public void clickonOKButton()
	{
		stepstatus = WebLibrary.clickElement(OKButton);
		ReportLibrary.reportEvent(stepstatus, "Able to click on OK Button", "Unable to click on OK Button",true);

	}
	
	public void DeleteSuccessMsg()
	{
		String Msg = WebLibrary.getLinkText(SuccessMsg);
		String text = Msg;
		System.out.println(Msg);
		if(text.contains("1 contact(s) deleted Successfully"))
		{
			ReportLibrary.test.log(LogStatus.PASS, "Contact deleted successfully "+ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
			//ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot());
			
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Contact deletion failed"+ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
			//ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot());
		}
	}
	
	public void SuccessMsg()
	{
		String Msg = WebLibrary.getLinkText(SuccessMsg);
		String text = Msg;
		System.out.println(text);
		if(Msg.contains("Address book details updated successfully"))
		{
			ReportLibrary.test.log(LogStatus.PASS, "Address book details updated successfully "+ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
			//ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot());
			
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Address book details updation failed "+ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
			//ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot());
		}
	}
}
