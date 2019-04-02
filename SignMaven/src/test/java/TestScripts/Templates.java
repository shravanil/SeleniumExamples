package TestScripts;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import ApplicationPages.AdminHomePage;
import ApplicationPages.CreateRequestPage;
import ApplicationPages.CreateTemplatePage;
import ApplicationPages.HomePage;
import ApplicationPages.LoginPage;
import ApplicationPages.TemplatesPage;
import ApplicationPages.UsersPage;
import FrameworkLibrary.BaseClass;
import FrameworkLibrary.DataLibrary;
import FrameworkLibrary.ReportLibrary;
import FrameworkLibrary.WebLibrary;

public class Templates extends BaseClass{

	boolean stepstatus;
	@Test(testName="Template Creation, Updation, Activation, Deactivation, Copying and Deleting")
	public void EditUpdateActivateDeactivateDeleteTemplate() throws Exception
	{
		LoginPage loginpage = new LoginPage(driver);
		HomePage homepage = new HomePage(driver);
		CreateTemplatePage CreateTemplate = new CreateTemplatePage(driver);
		TemplatesPage template = new TemplatesPage(driver);
		loginpage.setUsername(DataLibrary.getdata("Username"));
		loginpage.setPassword(DataLibrary.getdata("Password"));
		loginpage.clickonLogin();
		homepage.clickonCreateMenu();
		homepage.clickonCreateTemplateMenu();
		CreateTemplate.setTemplateName(DataLibrary.getdata("TemplateName"));
		CreateTemplate.setAcceptanceMode(DataLibrary.getdata("AcceptanceMode"));
		CreateTemplate.clickonMainDocumentBtn();
		WebLibrary.wait(3);
		Runtime.getRuntime().exec(AutoItPath + "\\Approval.exe");
		WebLibrary.setExplicitWait(CreateTemplate.DocumentsList, driver, 60);
		CreateTemplate.clickonSaveBtn();
		WebLibrary.wait(2);
		//To UPdate Template
		driver.findElement(By.xpath("//table/tbody/tr/td[2]/div[contains(text(),'"+DataLibrary.getdata("TemplateName")+"')]")).click();
		CreateTemplate.setSigner1Email(DataLibrary.getdata("Signer1Email"));
		CreateTemplate.setSigner1FirstName(DataLibrary.getdata("Signer1FirstName"));
		CreateTemplate.setSigner1LastName(DataLibrary.getdata("Signer1LastName"));
		CreateTemplate.clickonUpdateBtn();
		boolean TemplateUpdate = WebLibrary.verifyTextPresent("Template updated successfully");
		if(TemplateUpdate == true){
			ReportLibrary.test.log(LogStatus.PASS, "Template updated successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Template updation failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		//To Activate Template
		CreateTemplate.clickonNextBtn();
		WebLibrary.setExplicitWait(CreateTemplate.DocumentSetupSaveBtn, driver, 20);
		CreateTemplate.clickonSignature();
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//img[@id='documentPageImage1']"))).build().perform();	
		WebElement target = driver.findElement(By.xpath("//img[@id='documentPageImage1']"));
		int xcord = 99;
		int ycord = 428;
		action.moveToElement(target, xcord, ycord).click().build().perform();
		System.out.println("Signature added successfully");
		CreateTemplate.clickonInitial();
		action.moveToElement(driver.findElement(By.xpath("//img[@id='documentPageImage1']"))).build().perform();
		int xcord1 = 304;
		action.moveToElement(target, xcord1, ycord).click().build().perform();
		System.out.println("Initial added successfully");
		CreateTemplate.clickonDate();
		action.moveToElement(driver.findElement(By.xpath("//img[@id='documentPageImage1']"))).build().perform();
		int xcord2 = 514;
		action.moveToElement(target, xcord2, ycord).click().build().perform();
		System.out.println("Date added successfully");
		WebLibrary.wait(3);
		CreateTemplate.clickonDocumentSetupActivateBtn();
		WebLibrary.wait(3);
		boolean TemplateActivate = WebLibrary.verifyTextPresent("Template activated successfully");
		if(TemplateActivate == true){
			ReportLibrary.test.log(LogStatus.PASS, "Template created and activated successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Template activation failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		//To Deactivate Template
		homepage.clickonTemplatesMenu();
		driver.findElement(By.xpath("//table/tbody/tr/td[2]/div[contains(text(),'"+DataLibrary.getdata("TemplateName")+"')]")).click();
		CreateTemplate.clickonDeActivateBtn();
		CreateTemplate.clickonOkBtn();
		WebLibrary.wait(3);
		boolean TemplateDeActivate = WebLibrary.verifyTextPresent("Template deactivated successfully");
		if(TemplateDeActivate == true){
			ReportLibrary.test.log(LogStatus.PASS, "Template deactivated successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Template deactivation failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		//To Copy Template, Edit same Template then Delete
		homepage.clickonTemplatesMenu();
		WebLibrary.setExplicitWait(template.MoreBtn, driver, 20);
		WebElement documentPreview = driver.findElement(By.xpath("//table/tbody/tr/td[2]/div[contains(text(),'"+DataLibrary.getdata("TemplateName")+"')]/parent::td/preceding-sibling::td[1]/div/span[@class='fa fa-eye']"));
		Actions action1 = new Actions(driver);
		action1.moveToElement(documentPreview).click().perform();
		WebLibrary.setExplicitWait(template.MoreBtn, driver, 20);
		template.clickonMoreBtn();
		template.clickonCopy();
		template.clickonOkBtn();
		WebLibrary.wait(3);
		boolean TemplateCopy = WebLibrary.verifyTextPresent("Template copied successfully");
		if(TemplateCopy == true){
			ReportLibrary.test.log(LogStatus.PASS, "Template copied successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Template copy failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		driver.findElement(By.xpath("//table/tbody/tr/td[2]/div[contains(text(),'"+DataLibrary.getdata("TemplateName")+"')]")).click();
		template.clickonCancelBtn();
		driver.findElement(By.xpath("//table/tbody/tr/td[2]/div[contains(text(),'"+DataLibrary.getdata("TemplateName")+"')]")).click();
		template.clickonDeleteTemplateBtn();
		template.clickonOkBtn();
		WebLibrary.wait(5);			
	}

	@Test(testName="Template Activate, Deactivate, Archive, Copy and Delete from Document Preview")
	public void ActivateDeactivateArchiveCopyDeleteTemplate() throws Exception
	{
		LoginPage loginpage = new LoginPage(driver);
		HomePage homepage = new HomePage(driver);
		CreateTemplatePage CreateTemplate = new CreateTemplatePage(driver);
		TemplatesPage template = new TemplatesPage(driver);
		loginpage.setUsername(DataLibrary.getdata("Username"));
		loginpage.setPassword(DataLibrary.getdata("Password"));
		loginpage.clickonLogin();
		homepage.clickonCreateMenu();
		homepage.clickonCreateTemplateMenu();
		CreateTemplate.setTemplateName(DataLibrary.getdata("TemplateName"));
		CreateTemplate.setAcceptanceMode(DataLibrary.getdata("AcceptanceMode"));
		CreateTemplate.clickonMainDocumentBtn();
		WebLibrary.wait(3);
		Runtime.getRuntime().exec(AutoItPath + "\\Approval.exe");
		WebLibrary.setExplicitWait(CreateTemplate.DocumentsList, driver, 60);
		CreateTemplate.clickonActivateBtn();
		WebLibrary.wait(3);
		boolean TemplateActivate = WebLibrary.verifyTextPresent("Template activated successfully");
		if(TemplateActivate == true){
			ReportLibrary.test.log(LogStatus.PASS, "Template created and activated successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Template activation failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		// To Deactivate Template from Document Preview screen.
		homepage.clickonTemplatesMenu();
		WebLibrary.setExplicitWait(template.MoreBtn, driver, 20);
		template.clickonDocPreview();
		WebLibrary.wait(3);
		template.clickonMoreBtn();
		template.clickonInactivate();
		template.clickonOkBtn();
		WebLibrary.wait(3);
		boolean DocPreviewDeactivate = WebLibrary.verifyTextPresent("Template deactivated successfully");
		if(DocPreviewDeactivate == true){
			ReportLibrary.test.log(LogStatus.PASS, "Template deactivated successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Template deactivated failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		// To Activate Template from Document Preview screen.
		WebLibrary.setExplicitWait(template.MoreBtn, driver, 20);
		template.clickonDocPreview();
		WebLibrary.wait(3);
		template.clickonMoreBtn();
		template.clickonActivate();
		template.clickonOkBtn();
		WebLibrary.wait(3);
		boolean DocPreviewActivate = WebLibrary.verifyTextPresent("Template activated successfully");
		if(DocPreviewActivate == true){
			ReportLibrary.test.log(LogStatus.PASS, "Template activated successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Template activated failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		//To Copy Template then delete template from Document Preview screen.
		WebLibrary.setExplicitWait(template.MoreBtn, driver, 20);
		template.clickonDocPreview();
		WebLibrary.wait(3);
		template.clickonMoreBtn();
		template.clickonCopy();
		template.clickonOkBtn();
		WebLibrary.wait(3);
		boolean TemplateCopy = WebLibrary.verifyTextPresent("Template copied successfully");
		if(TemplateCopy == true){
			ReportLibrary.test.log(LogStatus.PASS, "Template copied successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Template copy failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		WebLibrary.setExplicitWait(template.MoreBtn, driver, 20);
		template.clickonDocPreview();
		WebLibrary.wait(3);
		template.clickonMoreBtn();
		template.clickonDelete();		
		template.clickonOkBtn();
		WebLibrary.wait(3);
		boolean DocPreviewDelete = WebLibrary.verifyTextPresent("Template deleted successfully");
		if(DocPreviewDelete == true){
			ReportLibrary.test.log(LogStatus.PASS, "Template deleted successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Template delete failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		// To Archive Template from Document Preview screen.
		WebLibrary.setExplicitWait(template.MoreBtn, driver, 20);
		template.clickonDocPreview();
		WebLibrary.wait(3);
		WebLibrary.wait(2);
		template.clickonMoreBtn();
		template.clickonArchive();
		template.clickonOkBtn();
		WebLibrary.wait(3);
		boolean DocPreviewArchive = WebLibrary.verifyTextPresent("successfully sent to Archived items.");
		if(DocPreviewArchive == true){
			ReportLibrary.test.log(LogStatus.PASS, "Template archived validation displayed" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Template archived validation not displayed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		template.clickonArchivedTab();
		WebLibrary.setExplicitWait(template.ArchivedPage, driver, 20);
		if(driver.findElement(By.xpath("//table/tbody/tr/td[2]/div[contains(text(),'"+DataLibrary.getdata("TemplateName")+"')]")).isDisplayed()){
			ReportLibrary.test.log(LogStatus.PASS, "Template archived successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Template archive failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		WebLibrary.wait(5);
	}

	@Test(testName="Print and Download Template document")
	public void PrintAndDownloadTemplateDocument() throws Exception
	{
		LoginPage loginpage = new LoginPage(driver);
		HomePage homepage = new HomePage(driver);
		AdminHomePage admin = new AdminHomePage(driver);
		UsersPage users = new UsersPage(driver);
		CreateTemplatePage CreateTemplate = new CreateTemplatePage(driver);
		TemplatesPage template = new TemplatesPage(driver);
		/*loginpage.setUsername("sravyab@ibt.example.com");
		loginpage.setPassword("testing");*/
		loginpage.setUsername(DataLibrary.getdata("Username"));
		loginpage.setPassword(DataLibrary.getdata("Password"));
		loginpage.clickonLogin();
		homepage.clickonTemplatesMenu();
		WebLibrary.wait(3);
		String TemplatesCount = driver.findElement(By.xpath("//span[@class='headcount']")).getText();
		String DocumentLinkText = template.getDocumentLinkText();
		if((TemplatesCount != null && TemplatesCount.trim().equalsIgnoreCase("0")) || DocumentLinkText!= null && DocumentLinkText.trim().contains("No Document")){
			homepage.clickonCreateMenu();
			homepage.clickonCreateTemplateMenu();
			CreateTemplate.setTemplateName(DataLibrary.getdata("TemplateName"));
			CreateTemplate.setAcceptanceMode(DataLibrary.getdata("AcceptanceMode"));
			CreateTemplate.clickonMainDocumentBtn();
			WebLibrary.wait(3);
			Runtime.getRuntime().exec(AutoItPath + "\\Approval.exe");
			WebLibrary.setExplicitWait(CreateTemplate.DocumentsList, driver, 60);
			CreateTemplate.clickonSaveBtn();
			WebLibrary.wait(2);
			WebLibrary.setExplicitWait(template.MoreBtn, driver, 20);
			template.clickonDocPreview();
			WebLibrary.wait(3);
			String DocumentName = template.getDocumentName();
			System.out.println("Document Name is" +DocumentName);
			WebLibrary.removeDownloadFiles();
			template.clickonDownloadBtn();
			WebLibrary.wait(3);
			stepstatus = WebLibrary.getLatestFileName(DocumentName + ".pdf");
			if(stepstatus=true){
				ReportLibrary.test.log(LogStatus.PASS, "Document downloaded successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
			}else{
				ReportLibrary.test.log(LogStatus.FAIL, "Document downloaded failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
			}
		}else{
			WebLibrary.setExplicitWait(template.MoreBtn, driver, 20);
			String DocumentName = template.getDocumentName();
			System.out.println("Document Name is" +DocumentName);
			WebLibrary.removeDownloadFiles();
			template.clickonDownloadBtn();
			WebLibrary.wait(3);
			stepstatus = WebLibrary.getLatestFileName(DocumentName + ".pdf");
			if(stepstatus==true){
				ReportLibrary.test.log(LogStatus.PASS, "Document downloaded successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
			}else{
				ReportLibrary.test.log(LogStatus.FAIL, "Document downloaded failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
			}
		}
		template.clickonPrintBtn();
		template.clickonOkBtn();
		WebLibrary.wait(3);
		stepstatus = WebLibrary.isWindowExists("sutisign/hierarchyPreview_printHierarchyDocuments.action?hierarchyId", driver);
		if(stepstatus==true){
			WebLibrary.wait(3);
			ReportLibrary.test.log(LogStatus.PASS, "Document printed successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Document print failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		driver.close();
		WebLibrary.SwitchtoWindow("sutisign/commonDisplay_dashBoardTemplateSearch.action", driver);
		template.clickonShare();
		System.out.println(driver.findElement(By.xpath("//div[@class='modal-content']/div[2]/div")).getText());
		boolean ShareValidation = WebLibrary.verifyTextPresent("Please select atleast one Template");
		if(ShareValidation == true){
			ReportLibrary.test.log(LogStatus.PASS, "Share validation successfull when no Templates has been selected" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "Share validation failed when no Templates has been selected"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		template.clickonOkBtn();
		String Name = HomePage.getCurrentCompanyName();
		String Name1 = Name.replace("(", "( ");
		String CompanyName = Name1.replace(")", " )");
		String TemplateName = driver.findElement(By.xpath("//table/tbody/tr/td[2]/div")).getText();
		System.out.println(TemplateName);
		WebElement checkbox = driver.findElement(By.xpath("(//input[@type='checkbox'])[3]"));
		Actions action = new Actions(driver);
		action.moveToElement(checkbox).click().build().perform();
		template.clickonShare();
		if(!driver.findElements(By.xpath("//table[@id='userDetailsTableId']/tbody/tr/td[3]/div[contains(text(),'"+DataLibrary.getdata("Admin")+"')]")).isEmpty())
		{
			driver.findElement(By.xpath("//table[@id='userDetailsTableId']/tbody/tr/td[3]/div[contains(text(),'"+DataLibrary.getdata("Admin")+"')]/parent::td/preceding-sibling::td[2]/input[@type='checkbox']")).click();
		}else{
			template.clickonCloseIcon();
			homepage.clickonHeadProfile();
			homepage.clickonAdminLink();
			admin.clickonCompanyMenu();
			admin.clickonUsersMenu();
			users.clickonAddAdminIcon();
			WebLibrary.wait(2);
			users.setEmailAddress(DataLibrary.getdata("Admin"));
			users.setFirstName(DataLibrary.getdata("FirstName"));
			users.setLastName(DataLibrary.getdata("LastName"));
			users.clickonSaveBtn();
			WebLibrary.wait(5);
			boolean AdminCreation = WebLibrary.verifyTextPresent("Admin Created Successfully");
			if(AdminCreation == true){
				ReportLibrary.test.log(LogStatus.PASS, "Admin created successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
			}else{
				ReportLibrary.test.log(LogStatus.FAIL, "Admin creation failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
			}
			driver.navigate().refresh();
			homepage.clickonLogo();
			homepage.clickonTemplatesMenu();
			WebLibrary.wait(3);
			action.moveToElement(checkbox).click().build().perform();
			template.clickonShare();
			driver.findElement(By.xpath("//table[@id='userDetailsTableId']/tbody/tr/td[3]/div[contains(text(),'sravyab@ibt.example.com')]/parent::td/preceding-sibling::td[2]/input[@type='checkbox']")).click();
		}
		template.clickonShareAccessBtn();
		template.clickonOkBtn();
		WebLibrary.wait(2);
		boolean ShareValidation1 = WebLibrary.verifyTextPresent("Access shared successfully");
		if(ShareValidation1 == true){
			ReportLibrary.test.log(LogStatus.PASS, "'Access shared successfully' validation message got displayed" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}else{
			ReportLibrary.test.log(LogStatus.FAIL, "'Access shared successfully' validation message not displayed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
		}
		homepage.clickonHeadProfile();
		homepage.clickonSignOutLink();
		// To Verify whether template has been shared to Admin.  
		loginpage.setUsername(DataLibrary.getdata("Admin"));
		loginpage.setPassword(DataLibrary.getdata("Password"));
		loginpage.clickonLogin();
		String AdminsCurrentCompany = HomePage.getCurrentCompanyName();
		if(AdminsCurrentCompany.equals(CompanyName)){
			homepage.clickonTemplatesMenu();
			WebLibrary.wait(3);
			if(driver.findElement(By.xpath("//table/tbody/tr/td[2]/div[contains(text(),'"+TemplateName+"')]")).isDisplayed()){
				ReportLibrary.test.log(LogStatus.PASS, "Template shared to Admin successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
			}else{
				ReportLibrary.test.log(LogStatus.FAIL, "Template shared to Admin failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
			}
		}else{
			homepage.clickonMenuBar();
			driver.findElement(By.xpath("//div[@class='user-name']/ul/li/ul/li[@title='"+CompanyName+"']")).click();
			WebLibrary.wait(3);
			homepage.clickonTemplatesMenu();
			WebLibrary.wait(3);
			if(driver.findElement(By.xpath("//table/tbody/tr/td[2]/div[contains(text(),'"+TemplateName+"')]")).isDisplayed()){
				ReportLibrary.test.log(LogStatus.PASS, "Template shared to Admin successfully" + ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
			}else{
				ReportLibrary.test.log(LogStatus.FAIL, "Template shared to Admin failed"+ ReportLibrary.test.addScreenCapture(ReportLibrary.getScreenshot()));
			}
		
		}
	}
}
