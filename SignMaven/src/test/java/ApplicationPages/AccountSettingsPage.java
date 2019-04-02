package ApplicationPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.LogStatus;

import FrameworkLibrary.DataLibrary;
import FrameworkLibrary.ReportLibrary;
import FrameworkLibrary.WebLibrary;

public class AccountSettingsPage {
	
	WebDriver driver;
	boolean stepstatus;
	public AccountSettingsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH,using="//label[contains(text(),'SutiHVM')]/preceding-sibling::input[@type='radio']")
	WebElement CompanySelection;

	@FindBy(how=How.XPATH,using="//input[@value='Save']")
	WebElement SaveBtn;
	
	@FindBy(how=How.XPATH,using="//div[@class='alert alert-success']")
	WebElement SuccessMsg;
		
	public void clickonCompanySelection()
	{
		stepstatus = WebLibrary.clickElement(CompanySelection);
		ReportLibrary.reportEvent(stepstatus, "Able to click on CompanySelection", "Unable to click on CompanySelection",true);
	}

	public void clickonSaveBtn()
	{
		stepstatus = WebLibrary.clickElement(SaveBtn);
		ReportLibrary.reportEvent(stepstatus, "Able to click on SaveBtn", "Unable to click on SaveBtn",true);

	}
	
	public void SuccessMsg()
	{
		String Msg = WebLibrary.getLinkText(SuccessMsg);
		String text = Msg;
		System.out.println(Msg);
		if(text.contains("has been set as your default company."))
		{
			ReportLibrary.test.log(LogStatus.PASS, "Account settings got saved successfully"+ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
			//ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot());
			
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Account settings got failed"+ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
			//ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot());
		}
	}
}
