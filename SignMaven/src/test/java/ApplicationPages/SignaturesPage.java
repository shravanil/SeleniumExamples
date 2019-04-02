package ApplicationPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.LogStatus;

import FrameworkLibrary.ReportLibrary;
import FrameworkLibrary.WebLibrary;

public class SignaturesPage {
	
	WebDriver driver;
	boolean stepstatus;
	public SignaturesPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH,using="//a[text()='Signature']")
	WebElement SignatureTab;

	@FindBy(how=How.XPATH,using="//a[text()='Initials']")
	WebElement InitialTab;

	@FindBy(how=How.XPATH,using="//span[contains(text(),'Browse')]")
	WebElement BrowseBtn;

	@FindBy(how=How.XPATH,using="//div[@id='contentSign']/div/div[3]/div/div/div[2]/p/a")
	WebElement ClickHereLink;
	
	@FindBy(how=How.XPATH,using="//input[@value='Preview']")
	WebElement PreviewBtn;
	
	@FindBy(how=How.XPATH,using="//div[@id='previewErrors']")
	WebElement FileErrMsg;
	
	@FindBy(how=How.XPATH,using="//input[@value='Accept']")
	WebElement PreviewAccept;
	
	@FindBy(how=How.XPATH,using="//input[@value='Reupload']")
	WebElement PreviewReupload;
	
	@FindBy(how=How.XPATH,using="//div[@class='alert alert-success']")
	WebElement SuccessMsg;
	
	@FindBy(how=How.XPATH,using="//input[@id='userName']")
	WebElement SignatureField;
	
	@FindBy(how=How.XPATH,using="//select[@id='signFontSize']")
	WebElement FontSize;
	
	@FindBy(how=How.XPATH,using="//select[@id='colorCode']")
	WebElement Color;
	
	@FindBy(how=How.XPATH,using="//div[@id='saveDiv']/div/div[2]/input[@value='Save']")
	WebElement SaveBtn;

	@FindBy(how=How.XPATH,using="//a[text()='Click here']")
	WebElement InitialClickHere;
	
	@FindBy(how=How.XPATH,using="//input[@value='Save']")
	WebElement InitialSaveBtn;

	public void clickonSignatureTab()
	{
		stepstatus = WebLibrary.clickElement(SignatureTab);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Signature Tab", "Unable to click on Signature Tab",true);
	}

	public void clickonInitialTab()
	{
		stepstatus = WebLibrary.clickElement(InitialTab);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Initial Tab", "Unable to click on Initial Tab",true);
	}

	public void clickonBrowseBtn()
	{
		stepstatus = WebLibrary.clickElement(BrowseBtn);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Browse Button", "Unable to click on Browse Button");
	}

	public void clickonClickHereLink()
	{
		stepstatus = WebLibrary.clickElement(ClickHereLink);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Click-Here Link", "Unable to click on Click-Here Link",true);
	}

	public void clickonPreviewBtn()
	{
		stepstatus = WebLibrary.clickElement(PreviewBtn);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Preview Button", "Unable to click on Preview Button");
	}
	
	public void SignatureErrorMsgWithoutFile()
	{
		String ErrMsg = WebLibrary.getLinkText(FileErrMsg);
		String text = ErrMsg;
		System.out.println(ErrMsg);
		if(text.contains("Upload Signature"))
		{
			ReportLibrary.test.log(LogStatus.PASS, "Signature validation message got displayed successfully without file"+ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
			//ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot());
			
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Signature validation message is not displayed"+ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
			//ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot());
		}
	}
	
	public void IntialErrorMsgWithoutFile()
	{
		String ErrMsg = WebLibrary.getLinkText(FileErrMsg);
		String text = ErrMsg;
		System.out.println(ErrMsg);
		if(text.contains("Upload Initial"))
		{
			ReportLibrary.test.log(LogStatus.PASS, "Intial validation message got displayed successfully without file"+ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
			//ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot());
			
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Intial validation message is not displayed"+ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
			//ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot());
		}
	}
	
	public void clickonPreviewAccept()
	{
		stepstatus = WebLibrary.clickElement(PreviewAccept);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Accept Button in Preview popup", "Unable to click on Accept Button in Preview popup");
	}
	
	public void clickonPreviewReupload()
	{
		stepstatus = WebLibrary.clickElement(PreviewReupload);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Reupload Button in Preview popup", "Unable to click on Reupload Button in Preview popup");
	}

	public void SignatureSuccessMsg()
	{
		String Msg = WebLibrary.getLinkText(SuccessMsg);
		String text = Msg;
		System.out.println(Msg);
		if(text.contains("Signature updated successfully"))
		{
			ReportLibrary.test.log(LogStatus.PASS, "Signature got generated successfully"+ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
			//ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot());
			
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Signature generation failed"+ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
	}
	
	
	public void InitialSuccessMsg()
	{
		String Msg = WebLibrary.getLinkText(SuccessMsg);
		String text = Msg;
		System.out.println(Msg);
		if(text.contains("Initial updated successfully"))
		{
			ReportLibrary.test.log(LogStatus.PASS, "Intial got uploaded successfully"+ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
			//ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot());
			
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Intial upload failed"+ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
			//ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot());
		}
	}
	
	
	public void setSignatureField(String StrSignatureField)
	{
		stepstatus = WebLibrary.setText(SignatureField, StrSignatureField);
		ReportLibrary.reportEvent(stepstatus, "Able to enter Signature Field", "Unable to enter Signature Field");
	}
		
	public void setFontSize(String StrFontSize)
	{
		stepstatus = WebLibrary.setOptionInSelectBox(FontSize, StrFontSize);
		ReportLibrary.reportEvent(stepstatus, "Able to select value in FontSize field", "Unable to select value in FontSize field");
	}

	public void setColor(String StrColor)
	{
		stepstatus = WebLibrary.setOptionInSelectBox(Color, StrColor);
		ReportLibrary.reportEvent(stepstatus, "Able to select value in Color field", "Unable to select value in Color field",true);
	}
		
	public void clickonSaveBtn()
	{
		stepstatus = WebLibrary.clickElement(SaveBtn);
		
		ReportLibrary.reportEvent(stepstatus, "Able to click on Save Button and Signature Generated successfully", "Unable to click on Save Button" ,true);
	}

	public void clickonInitialClickHere()
	{
		stepstatus = WebLibrary.clickElement(InitialClickHere);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Initial ClickHere", "Unable to click on Initial ClickHere",true);
	}
	
	public void clickonInitialSaveBtn()
	{
		stepstatus = WebLibrary.clickElement(InitialSaveBtn);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Save Button and Initial generated successfully", "Unable to click on Save Button",true);
	}



}
