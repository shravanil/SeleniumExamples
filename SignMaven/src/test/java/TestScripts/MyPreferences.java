package TestScripts;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import ApplicationPages.AccountSettingsPage;
import ApplicationPages.AddressBookPage;
import ApplicationPages.ChangePasswordPage;
import ApplicationPages.CreateRequestPage;
import ApplicationPages.HomePage;
import ApplicationPages.LoginPage;
import ApplicationPages.MyPreferencesHomePage;
import ApplicationPages.PersonalInformationPage;
import ApplicationPages.ReceivedItemsPage;
import ApplicationPages.SignaturesPage;
import FrameworkLibrary.BaseClass;
import FrameworkLibrary.DataLibrary;
import FrameworkLibrary.WebLibrary;

public class MyPreferences extends BaseClass{

	@Test(testName="To Update Personal Information")
	public void ToUpdatePersonalInformation()
	{
		LoginPage loginpage = new LoginPage(driver);
		HomePage homepage = new HomePage(driver);
		MyPreferencesHomePage mypreference = new MyPreferencesHomePage(driver);
		PersonalInformationPage personalinformation = new PersonalInformationPage(driver);
		loginpage.setUsername(DataLibrary.getdata("Username"));
		loginpage.setPassword(DataLibrary.getdata("Password"));
		loginpage.clickonLogin();
		homepage.clickonHeadProfile();
		homepage.clickonMyPreferences();
		mypreference.clickonMyPreferences();
		mypreference.clickonPersonalInformation();
		personalinformation.setFirstName(DataLibrary.getdata("FirstName"));
		personalinformation.setLastName(DataLibrary.getdata("LastName"));
		personalinformation.setAddress(DataLibrary.getdata("Address"));
		personalinformation.setOtherDetails(DataLibrary.getdata("OtherDetails"));
		personalinformation.setZip(DataLibrary.getdata("Zip"));
		personalinformation.setContactNum(DataLibrary.getdata("ContactNo"));
		personalinformation.setFaxNo(DataLibrary.getdata("Fax"));
		personalinformation.setCityName(DataLibrary.getdata("City"));
		personalinformation.setState(DataLibrary.getdata("State"));
		personalinformation.clickonUpdateButton();
		homepage.clickonHeadProfile();
		homepage.clickonSignOutLink();		
	}
	@Test(testName="To Verify Change Password")
	public void ToVerifyChangePassword()
	{
		LoginPage loginpage = new LoginPage(driver);
		HomePage homepage = new HomePage(driver);
		MyPreferencesHomePage mypreference = new MyPreferencesHomePage(driver);
		ChangePasswordPage changepassword = new ChangePasswordPage(driver);
		loginpage.setUsername(DataLibrary.getdata("Username"));
		loginpage.setPassword(DataLibrary.getdata("Password"));
		loginpage.clickonLogin();
		homepage.clickonHeadProfile();
		homepage.clickonMyPreferences();
		mypreference.clickonMyPreferences();
		mypreference.clickonChangePassword();
		// To verify Change Password with blank data
		try{
			changepassword.clickonUpdateButton();
			Thread.sleep(1000);
			changepassword.BlankErrorMsg();
		}catch(Exception e) 
		{
			System.out.println("Exception occured while fetching the validation message");
		}
		// To verify Change Password by entering invalid passwords
		try{
			changepassword.setOldPassword(DataLibrary.getdata("OldPassword"));
			changepassword.setNewPassword(DataLibrary.getdata("NewPassword"));
			changepassword.setConfirmPassword(DataLibrary.getdata("ConfirmPassword"));
			changepassword.clickonUpdateButton();
			Thread.sleep(1000);
			changepassword.ValidationMsg();
		}catch(Exception e) 
		{
			System.out.println("Exception occured while fetching the validation message");
		}
		//To Verify Change Password with valid data
		try{
			changepassword.setOldPassword(DataLibrary.getdata("OldPassword"));
			changepassword.setNewPassword(DataLibrary.getdata("NewPassword1"));
			changepassword.setConfirmPassword(DataLibrary.getdata("ConfirmPassword1"));
			changepassword.clickonUpdateButton();
			Thread.sleep(1000);
			changepassword.SuccessMsg();
		}catch(Exception e) 
		{
			System.out.println("Exception occured while fetching the validation message");
		}
		
		
	}
	
	@Test(testName="To Generate Signature")
	public void ToVerifySignaturefunctionality()
	{
		LoginPage loginpage = new LoginPage(driver);
		HomePage homepage = new HomePage(driver);
		MyPreferencesHomePage mypreference = new MyPreferencesHomePage(driver);
		SignaturesPage signature = new SignaturesPage(driver);
		loginpage.setUsername(DataLibrary.getdata("Username"));
		loginpage.setPassword(DataLibrary.getdata("Password"));
		loginpage.clickonLogin();
		homepage.clickonHeadProfile();
		homepage.clickonMyPreferences();
		mypreference.clickonMyPreferences();
		mypreference.clickonSignatureMenu();
		// To Generate Signature
		try{
			signature.clickonClickHereLink();
			signature.setSignatureField(DataLibrary.getdata("SignatureName"));
			signature.setFontSize(DataLibrary.getdata("FontSize"));
			signature.setColor(DataLibrary.getdata("Color"));
			Thread.sleep(3000);
			signature.clickonSaveBtn();
			signature.SignatureSuccessMsg();
		}catch(Exception e) 
		{
			System.out.println("Exception occured while generating signature");
		}
		
		//To verify Signature without uploading file
		try{
			signature.clickonPreviewBtn();
			Thread.sleep(1000);
			signature.SignatureErrorMsgWithoutFile();		
		}catch(Exception e) 
		{
			System.out.println("Exception occured while verify Signature without uploading file");
		}
		
		// To verify uploading Signature
		try{
			signature.clickonBrowseBtn();
			//Thread.sleep(3000);	
			WebLibrary.RobotKeysFileUpload("C:\\Users\\shravanim\\Desktop\\Samples\\13_80.jpg");
			Thread.sleep(1000);
			signature.clickonPreviewBtn();
			Thread.sleep(1000);
			signature.clickonPreviewAccept();
			signature.SignatureSuccessMsg();
		}catch(Exception e) 
		{
			System.out.println("Exception occured while uploading signature");
		}
		
	}
	
	@Test(testName="To Generate Initial")
	public void ToVerifyIntialfunctionality()
	{
		LoginPage loginpage = new LoginPage(driver);
		HomePage homepage = new HomePage(driver);
		MyPreferencesHomePage mypreference = new MyPreferencesHomePage(driver);
		SignaturesPage signature = new SignaturesPage(driver);
		loginpage.setUsername(DataLibrary.getdata("Username"));
		loginpage.setPassword(DataLibrary.getdata("Password"));
		loginpage.clickonLogin();
		homepage.clickonHeadProfile();
		homepage.clickonMyPreferences();
		mypreference.clickonMyPreferences();
		mypreference.clickonSignatureMenu();
		signature.clickonInitialTab();
		/*// To Generate Initial
				try{
					signature.clickonInitialClickHere();
					signature.setSignatureField(DataLibrary.getdata("InitialName"));
					signature.setFontSize(DataLibrary.getdata("FontSize"));
					signature.setColor(DataLibrary.getdata("Color"));
					Thread.sleep(3000);
					signature.clickonInitialSaveBtn();
					Thread.sleep(2000);
					signature.InitialSuccessMsg();
				}catch(Exception e) 
				{
					System.out.println("Exception occured while generating initial");
				}*/
		
		
		// To verify Initial without uploading file
			try{
				signature.clickonPreviewBtn();
				Thread.sleep(1000);
				signature.IntialErrorMsgWithoutFile();		
			}catch(Exception e) 
			{
				System.out.println("Exception occured while verify Intial without uploading file");
			}
		// To verify uploading initial
			try{
				signature.clickonBrowseBtn();
				//Thread.sleep(3000);	
				WebLibrary.RobotKeysFileUpload("C:\\Users\\shravanim\\Desktop\\Samples\\kalyan1-130_100 - Copy.jpg");
				Thread.sleep(1000);
				signature.clickonPreviewBtn();
				Thread.sleep(1000);
				signature.clickonPreviewAccept();
				Thread.sleep(1000);
				signature.InitialSuccessMsg();
				
			}catch(Exception e) 
			{
				System.out.println("Exception occured while uploading Intial");
			}
		
	}
	@Test(testName="To verify default company selection setting")
	public void ToVerifyAccountSettings()
	{
		LoginPage loginpage = new LoginPage(driver);
		HomePage homepage = new HomePage(driver);
		MyPreferencesHomePage mypreference = new MyPreferencesHomePage(driver);
		AccountSettingsPage accountsettings = new AccountSettingsPage(driver);
		loginpage.setUsername(DataLibrary.getdata("Username"));
		loginpage.setPassword(DataLibrary.getdata("Password"));
		loginpage.clickonLogin();
		homepage.clickonHeadProfile();
		homepage.clickonMyPreferences();
		mypreference.clickonMyPreferences();
		mypreference.clickonAccountSettings();
		driver.findElement(By.xpath("//label[contains(text(),'"+DataLibrary.getdata("CompanyName")+"')]/preceding-sibling::input[@type='radio']")).click();
		//accountsettings.clickonCompanySelection();
		accountsettings.clickonSaveBtn();
		accountsettings.SuccessMsg();
		//System.out.println(driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText());
		
	}
		
	@Test(testName="To verify Address Book functionality")
	public void ToVerifyAddressBook()
	{	
		try{
		LoginPage loginpage = new LoginPage(driver);
		HomePage homepage = new HomePage(driver);
		MyPreferencesHomePage mypreference = new MyPreferencesHomePage(driver);
		AddressBookPage addressbook = new AddressBookPage(driver);
		loginpage.setUsername(DataLibrary.getdata("Username"));
		loginpage.setPassword(DataLibrary.getdata("Password"));
		loginpage.clickonLogin();
		homepage.clickonHeadProfile();
		homepage.clickonMyPreferences();
		mypreference.clickonMyPreferences();
		mypreference.clickonAddressBook();
		driver.findElement(By.xpath("//table/tbody/tr/td[3]/div[contains(text(),'"+DataLibrary.getdata("Email")+"')]/parent::td[1]/following-sibling::td[5]/a")).click();
		Thread.sleep(1000);
		addressbook.setFirstName(DataLibrary.getdata("FirstName"));
		addressbook.setLastName(DataLibrary.getdata("LastName"));
		addressbook.clickonUpdateBtn();
		Thread.sleep(1000);
		addressbook.SuccessMsg();
		driver.findElement(By.xpath("//table/tbody/tr/td[3]/div[contains(text(),'"+DataLibrary.getdata("Email1")+"')]/parent::td[1]/preceding-sibling::td[2]")).click();
		addressbook.clickonDeleteIcon();
		addressbook.clickonOKButton();
		addressbook.DeleteSuccessMsg();
		}catch(Exception e) 
		{
			System.out.println("Exception occured while performing address book functionality");
		}
		
		
	}
	
	@Test(testName="To verify Received Items functionality")
	public void ToVerifyReceivedItems()
	{	
		try{
		LoginPage loginpage = new LoginPage(driver);
		HomePage homepage = new HomePage(driver);
		MyPreferencesHomePage mypreference = new MyPreferencesHomePage(driver);
		ReceivedItemsPage receiveditems = new ReceivedItemsPage(driver);
		loginpage.setUsername(DataLibrary.getdata("Username"));
		loginpage.setPassword(DataLibrary.getdata("Password"));
		loginpage.clickonLogin();
		homepage.clickonHeadProfile();
		homepage.clickonMyPreferences();
		mypreference.clickonMyDocuments();
		mypreference.clickonReceivedItems();
		receiveditems.clickonReceivedItemsIcon();
		receiveditems.setSecondaryEmail(DataLibrary.getdata("SecondaryEmail"));
		receiveditems.clickonSaveBtn();
		receiveditems.SuccessMsg();
		mypreference.clickonMyDocuments();
		mypreference.clickonReceivedItems();
		//To check validation message when deleting without selecting documents
		/*receiveditems.clickonDeleteIcon();
		Thread.sleep(1000);	*/
		receiveditems.Documentexists();
		
		
		}catch(Exception e) 
		{
			System.out.println("Exception occured while performing Received Items functionality");
		}
	}
	
}

