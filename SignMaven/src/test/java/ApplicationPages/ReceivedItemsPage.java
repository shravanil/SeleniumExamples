package ApplicationPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import com.relevantcodes.extentreports.LogStatus;
import FrameworkLibrary.ReportLibrary;
import FrameworkLibrary.WebLibrary;

public class ReceivedItemsPage {
	
	WebDriver driver;
	boolean stepstatus;
	public ReceivedItemsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH,using="//span[contains(text(),'Send to Received Items')]")
	WebElement ReceivedItemsIcon;
	
	@FindBy(how=How.XPATH,using="//textarea[@id='secondaryEmail']")
	WebElement SecondaryEmail;
	
	@FindBy(how=How.XPATH,using="//input[@value='Save']")
	WebElement SaveBtn;
	
	@FindBy(how=How.XPATH,using="//div[@class='alert alert-success']")
	WebElement SuccessMsg;
	
	@FindBy(how=How.XPATH,using="//span[contains(text(),'Delete Document')]")
	WebElement DeleteIcon;
	
	@FindBy(how=How.XPATH,using="//div[@class='bootbox-body']")
	WebElement DeleteAlertMsg;
	
	@FindBy(how=How.XPATH,using="//table/tbody/tr/td")
	WebElement NoDocumentsMsg;
	
	@FindBy(how=How.XPATH,using="(//input[@type='checkbox'])[2]")
	WebElement SelectDocument;
	
	@FindBy(how=How.XPATH,using="//button[text()='OK']")
	WebElement DeleteRequestOKBtn;
		
	public void clickonReceivedItemsIcon()
	{
		stepstatus = WebLibrary.clickElement(ReceivedItemsIcon);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Send to Received Items Icon", "Unable to click on Send to Received Items Icon",true);

	}
	
	public void setSecondaryEmail(String StrSecondaryEmail)
	{
		stepstatus = WebLibrary.setText(SecondaryEmail, StrSecondaryEmail);
		ReportLibrary.reportEvent(stepstatus, "Able to enter SecondaryEmail Field", "Unable to enter SecondaryEmail Field");
	}
	
	public void clickonSaveBtn()
	{
		stepstatus = WebLibrary.clickElement(SaveBtn);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Save Button", "Unable to click on Save Button",true);

	}
	
	public void SuccessMsg()
	{
		String Msg = WebLibrary.getLinkText(SuccessMsg);
		String text = Msg;
		System.out.println(text);
		if(Msg.contains("You have successfully updated the secondary email"))
		{
			ReportLibrary.test.log(LogStatus.PASS, "Received Item details updated successfully "+ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
			//ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot());
			
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Received Item details updation failed "+ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
			//ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot());
		}
	}
	
	public void clickonDeleteIcon()
	{
		stepstatus = WebLibrary.doubleClick(DeleteIcon, driver);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Delete Icon", "Unable to click on Delete Icon",true);

	}
	
	public void DeleteAlert() throws Exception
	{
		Thread.sleep(2000);
		String Msg = WebLibrary.getLinkText(DeleteAlertMsg);
		System.out.println(Msg);
		if(Msg.contains("Please select atleast one Document"))
		{
			ReportLibrary.test.log(LogStatus.PASS, "Alert validation successfull without selecting documents"+ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Alert validation not displaying"+ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
	}
	
	public void clickonDeleteRequestOKBtn()
	{
		stepstatus = WebLibrary.clickElement(DeleteRequestOKBtn);
		ReportLibrary.reportEvent(stepstatus, "Able to click on DeleteRequest OK Button", "Unable to click on DeleteRequest OK Button",true);

	}
	
	public boolean NoDocumentstoDelete()
	{
		try{
		String Msg = WebLibrary.getLinkText(NoDocumentsMsg);
		System.out.println(Msg);
		if(Msg.contains("No Records available"))
		{
			ReportLibrary.test.log(LogStatus.PASS, "No Records available to Delete"+ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Records are present to delete document"+ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		} catch (Exception e) {
			stepstatus = false;
		}
		return stepstatus;
	}
	
	
	public void Documentexists() throws Exception
	{
		String Msg = WebLibrary.getLinkText(NoDocumentsMsg);
		System.out.println(Msg);
		if(Msg.contains("No Records available")){
			WebLibrary.doubleClick(DeleteIcon, driver);
			Thread.sleep(2000);
			String Msg1 = WebLibrary.getLinkText(DeleteAlertMsg);
			System.out.println(Msg1);
			if(Msg1.contains("There are no documents to Delete"))
			{
				ReportLibrary.test.log(LogStatus.PASS, "'No documents to delete' alert message is displaying succesffully"+ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
			}else{
				ReportLibrary.test.log(LogStatus.FAIL, "No alert is displaying when there are no documents to delete"+ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
			}			
		}else{
			WebLibrary.doubleClick(DeleteIcon, driver);
			DeleteAlert();
			clickonDeleteRequestOKBtn();	
			WebLibrary.clickElement(SelectDocument);
			WebLibrary.doubleClick(DeleteIcon, driver);
			Thread.sleep(2000);
			WebLibrary.clickElement(DeleteRequestOKBtn);
			Thread.sleep(2000);
			String Msg2 = WebLibrary.getLinkText(SuccessMsg);
			System.out.println(Msg2);
			if(Msg2.contains("document(s) are deleted successfully."))
			{
				ReportLibrary.test.log(LogStatus.PASS, "Document got deleted successfully "+ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
				
			}else{
				ReportLibrary.test.log(LogStatus.FAIL, "Document deletion failed "+ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
			}
		}
	}
	
}
