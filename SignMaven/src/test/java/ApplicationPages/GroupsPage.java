package ApplicationPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import FrameworkLibrary.DataLibrary;
import FrameworkLibrary.ReportLibrary;
import FrameworkLibrary.WebLibrary;

public class GroupsPage {
	
	WebDriver driver;
	boolean stepstatus;
	public GroupsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(how=How.XPATH,using="//span[contains(text(),'Create Group')]")
	public WebElement CreateGroupIcon;

	@FindBy(how=How.XPATH,using="//input[@id='groupName']")
	public WebElement GroupName;
	
	@FindBy(how=How.XPATH,using="//span[contains(text(),'Browse')]")
	WebElement BrowseBtn;
	
	@FindBy(how=How.XPATH,using="//input[@value='Search']")
	WebElement SearchButton;
	
	@FindBy(how=How.XPATH,using="//input[@value='Save']")
	WebElement SaveBtn;
	
	@FindBy(how=How.XPATH,using="//input[@value='Update']")
	WebElement UpdateBtn;
	
	@FindBy(how=How.XPATH,using="//input[@value='Deactivate']")
	WebElement DeactivateBtn;
	
	@FindBy(how=How.XPATH,using="//input[@value='Activate']")
	WebElement ActivateBtn;
	
	@FindBy(how=How.XPATH,using="//input[@value='Delete']")
	WebElement DeleteBtn;
	
	@FindBy(how=How.XPATH,using="//input[@id='searchGroupName']")
	public WebElement SearchGroupName;
	
	@FindBy(how=How.XPATH,using="//h4[contains(text(),'Group Members')]")
	public WebElement GroupMembersPopup;
	
	@FindBy(how=How.XPATH,using="(//img[@class='adduser'])[2]")
	WebElement AddMember;
	
	@FindBy(how=How.ID,using="requestTitle")
	WebElement MemberName;
	
	@FindBy(how=How.ID,using="signerEmailId")
	WebElement MemberEmail;
	
	@FindBy(how=How.XPATH,using="//img[@class='active_inactive']")
	WebElement ActivateInactivateMember;
	
	@FindBy(how=How.XPATH,using="//img[@class='delete_enable']")
	WebElement DeleteMemberIcon;
			
	
	public void clickonCreateGroupIcon()
	{
		stepstatus = WebLibrary.JsclickElement(CreateGroupIcon, driver);
		ReportLibrary.reportEvent(stepstatus, "Able to click on CreateGroup Icon", "Unable to click on CreateGroup Icon");
	}
	
	public void setGroupName(String StrGroupName)
	{
		stepstatus = WebLibrary.setText(GroupName, StrGroupName);
		ReportLibrary.reportEvent(stepstatus, "Able to enter Group Name Field", "Unable to enter Group Name Field");
	}	
	
	public void clickonBrowseBtn()
	{
		stepstatus = WebLibrary.clickElement(BrowseBtn);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Browse Button", "Unable to click on Browse Button");
	}
	
	public void clickonSearchButton()
	{
		stepstatus = WebLibrary.clickElement(SearchButton);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Search Button", "Unable to click on Search Button");
	}

	public void clickonSaveBtn()
	{
		stepstatus = WebLibrary.clickElement(SaveBtn);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Save Button", "Unable to click on Save Button");
	}

	public void clickonUpdateBtn()
	{
		stepstatus = WebLibrary.clickElement(UpdateBtn);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Update button", "Unable to click on Update button");
	}
	
	public void clickonDeactivateBtn()
	{
		stepstatus = WebLibrary.clickElement(DeactivateBtn);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Deactivate button", "Unable to click on Deactivate button");
	}
	
	public void clickonActivateBtn()
	{
		stepstatus = WebLibrary.clickElement(ActivateBtn);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Activate button", "Unable to click on Activate button");
	}

	public void clickonDeleteBtn()
	{
		stepstatus = WebLibrary.clickElement(DeleteBtn);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Delete button", "Unable to click on Delete button");
	}
	
	public void EditGroup()
	{
		stepstatus = WebLibrary.clickElement(driver.findElement(By.xpath("//table/tbody/tr/td[2]/div[contains(text(),'"+DataLibrary.getdata("GroupName")+"')]/parent::td/following-sibling::td[4]/a/img[@title='Edit']")));
		ReportLibrary.reportEvent(stepstatus, "Able to click on Edit Group Icon", "Unable to click on Edit Group Icon",true);
	}
	
	public void ViewMembersList()
	{
		stepstatus = WebLibrary.clickElement(driver.findElement(By.xpath("//table/tbody/tr/td[2]/div[contains(text(),'"+DataLibrary.getdata("GroupName")+"')]/parent::td/following-sibling::td[4]/a/img[@alt='user']")));
		ReportLibrary.reportEvent(stepstatus, "Able to click on View Members List Icon", "Unable to click on View Members List Icon",true);
	}
	
	public void setSearchGroupName(String StrSearchGroupName)
	{
		stepstatus = WebLibrary.setText(SearchGroupName, StrSearchGroupName);
		ReportLibrary.reportEvent(stepstatus, "Able to enter Group Name Field in search section", "Unable to enter Group Name Field in search section");
	}

	public String GetGroupStatus()
	{
		String GroupStatus = driver.findElement(By.xpath("//table/tbody/tr/td[2]/div[contains(text(),'"+DataLibrary.getdata("GroupName")+"')]/parent::td/following-sibling::td[1]/div")).getText();
		System.out.println(GroupStatus);
		return GroupStatus;		
	}
	
	public String GetGroupName()
	{
		String GroupName = driver.findElement(By.xpath("//table/tbody/tr/td[2]/div")).getText();
		System.out.println(GroupName);
		return GroupName;	
	}
	
	public void clickonAddMemberIcon()
	{
		stepstatus = WebLibrary.clickElement(AddMember);
		ReportLibrary.reportEvent(stepstatus, "Able to click on AddMember Icon", "Unable to click on AddMember Icon");
	}
	
	public void setMemberName(String StrMemberName)
	{
		stepstatus = WebLibrary.setText(MemberName, StrMemberName);
		ReportLibrary.reportEvent(stepstatus, "Able to enter MemberName Field", "Unable to enter MemberName Field");
	}
	
	public void setMemberEmail(String StrMemberEmail)
	{
		stepstatus = WebLibrary.setText(MemberEmail, StrMemberEmail);
		ReportLibrary.reportEvent(stepstatus, "Able to enter MemberEmail Field", "Unable to enter MemberEmail Field");
	}
	
	public void clickonActivateInactivateMember()
	{
		stepstatus = WebLibrary.clickElement(ActivateInactivateMember);
		ReportLibrary.reportEvent(stepstatus, "Able to click on ActivateInactivateMember Icon", "Unable to click on ActivateInactivateMember Icon");
	}
	
	public void clickonDeleteMemberIcon()
	{
		stepstatus = WebLibrary.clickElement(DeleteMemberIcon);
		ReportLibrary.reportEvent(stepstatus, "Able to click on DeleteMember Icon", "Unable to click on DeleteMember Icon");
	}
}
