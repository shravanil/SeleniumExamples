package ApplicationPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import FrameworkLibrary.DataLibrary;
import FrameworkLibrary.ReportLibrary;
import FrameworkLibrary.WebLibrary;

public class TemplatesPage {
	
	WebDriver driver;
	boolean stepstatus;
	public TemplatesPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH,using="//span[contains(text(),'Share')]")
	WebElement Share;
	
	@FindBy(how=How.XPATH,using="//img[@title='Close']")
	WebElement CloseIcon;
	
	@FindBy(how=How.XPATH,using="//span[@id='shareEnable']/button")
	WebElement ShareAccessBtn;
	
	@FindBy(how=How.XPATH,using="//select[@id='documentVOList2']/option")
	WebElement DocumentName;

	@FindBy(how=How.XPATH,using="//button[text()='Print']")
	WebElement PrintBtn;

	@FindBy(how=How.XPATH,using="//button[text()='Download']")
	public WebElement DownloadBtn;

	@FindBy(how=How.XPATH,using="//button[contains(text(),'More')]")
	public WebElement MoreBtn;

	@FindBy(how=How.XPATH,using="//a[contains(text(),'Copy')]")
	WebElement Copy;
	
	@FindBy(how=How.XPATH,using="//button[contains(text(),'OK')]")
	WebElement OkBtn;

	@FindBy(how=How.XPATH,using="//a[contains(text(),'Inactivate')]")
	WebElement Inactivate;
	
	@FindBy(how=How.ID,using="archive")
	WebElement Archive;

	@FindBy(how=How.XPATH,using="//a[contains(text(),'New')]")
	WebElement NewRequest;

	@FindBy(how=How.XPATH,using="//a[contains(text(),'Delete')]")
	WebElement Delete;

	@FindBy(how=How.XPATH,using="//a[contains(text(),'Activate')]")
	WebElement Activate;
	
	@FindBy(how=How.XPATH,using="//input[@value='Delete Template']")
	WebElement DeleteTemplateBtn;

	@FindBy(how=How.XPATH,using="//input[@value='Cancel']")
	WebElement CancelBtn;
	
	@FindBy(how=How.ID,using="allTabId")
	WebElement AllTab;
	
	@FindBy(how=How.ID,using="archivedTabId")
	WebElement ArchivedTab;
	
	@FindBy(how=How.XPATH,using="//span[contains(text(),'Archived Templates')]")
	public WebElement ArchivedPage;
	
	@FindBy(how=How.XPATH,using="//span[contains(text(),'Templates')]")
	public WebElement AllPage;
	
	public void clickonShare()
	{
		stepstatus = WebLibrary.clickElement(Share);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Share Icon", "Unable to click on Share Icon",true);
	}
	
	public void clickonCloseIcon()
	{
		stepstatus = WebLibrary.clickElement(CloseIcon);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Close Icon", "Unable to click on Close Icon",true);
	}
	
	public void clickonShareAccessBtn()
	{
		stepstatus = WebLibrary.clickElement(ShareAccessBtn);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Share Access Button", "Unable to click on Share Access Button",true);
	}
	
	public String getDocumentName()
	{
		String value =	WebLibrary.getAttributeValue(DocumentName, "title");
		System.out.println(value);
		return value;
	}
	
	public String getDocumentLinkText()
	{
		String value = WebLibrary.getLinkText(DocumentName);
		System.out.println(value);
		return value;
	}

	public void clickonPrintBtn()
	{
		stepstatus = WebLibrary.clickElement(PrintBtn);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Print Button", "Unable to click on Print Button",true);
	}

	public void clickonDownloadBtn()
	{
		stepstatus = WebLibrary.clickElement(DownloadBtn);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Download Button", "Unable to click on Download Button",true);
	}

	public void clickonMoreBtn()
	{
		stepstatus = WebLibrary.clickElement(MoreBtn);
		ReportLibrary.reportEvent(stepstatus, "Able to click on More Button", "Unable to click on More Button",true);
	}

	public void clickonCopy()
	{
		stepstatus = WebLibrary.clickElement(Copy);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Copy Option", "Unable to click on Copy Option",true);
	}
	
	public void clickonOkBtn()
	{
		stepstatus = WebLibrary.clickElement(OkBtn);
		ReportLibrary.reportEvent(stepstatus, "Able to click on OK Button", "Unable to click on OK Button",true);
	}

	public void clickonInactivate()
	{
		stepstatus = WebLibrary.clickElement(Inactivate);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Inactivate Option", "Unable to click on Inactivate Option",true);
	}

	public void clickonNewRequest()
	{
		stepstatus = WebLibrary.clickElement(NewRequest);
		ReportLibrary.reportEvent(stepstatus, "Able to click on NewRequest Option", "Unable to click on NewRequest Option",true);
	}

	public void clickonArchive()
	{
		stepstatus = WebLibrary.clickElement(Archive);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Archive Option", "Unable to click on Archive Option",true);
	}
	
	public void clickonDelete()
	{
		stepstatus = WebLibrary.clickElement(Delete);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Delete Option", "Unable to click on Delete Option",true);
	}

	public void clickonActivate()
	{
		stepstatus = WebLibrary.clickElement(Activate);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Activate Option", "Unable to click on Activate Option",true);
	}
	
	public void clickonDeleteTemplateBtn()
	{
		stepstatus = WebLibrary.clickElement(DeleteTemplateBtn);
		ReportLibrary.reportEvent(stepstatus, "Able to click on DeleteTemplate Button", "Unable to click on DeleteTemplate Button",true);
	}
	
	public void clickonCancelBtn()
	{
		stepstatus = WebLibrary.clickElement(CancelBtn);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Cancel Button", "Unable to click on Cancel Button",true);
	}
	
	public void clickonAllTab()
	{
		stepstatus = WebLibrary.clickElement(AllTab);
		ReportLibrary.reportEvent(stepstatus, "Able to click on All Tab", "Unable to click on All Tab",true);
	}
	
	public void clickonArchivedTab()
	{
		stepstatus = WebLibrary.clickElement(ArchivedTab);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Archived Tab", "Unable to click on Archived Tab",true);
	}
	
	public void clickonDocPreview()
	{
		WebElement documentPreview = driver.findElement(By.xpath("//table/tbody/tr/td[2]/div[contains(text(),'"+DataLibrary.getdata("TemplateName")+"')]/parent::td/preceding-sibling::td[1]/div/span[@class='fa fa-eye']"));
		Actions action = new Actions(driver);
		action.moveToElement(documentPreview).click().perform();
	}
	public void getDownloadedFileName()
	{
		stepstatus = WebLibrary.getLatestFileName(DocumentName + ".pdf");
		
	}
	
}
