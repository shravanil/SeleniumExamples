package Company;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Interview {
	@Test
	public void MultipleWindows(){
			
		System.setProperty("webdriver.chrome.driver","F:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.sutisoft.com/");
		driver.findElement(By.xpath("//a[text()=' Expense Management']")).click();
		for(String handle : driver.getWindowHandles())
		{
			driver.switchTo().window(handle);
			System.out.println(driver.getTitle());
			if(driver.getTitle().equals("Expense Report Software | Automated Expense Reporting - SutiExpense"))
			{
				driver.findElement(By.xpath("//a[text()=' Watch Video']")).click();
			}
		}
	
	}
	
	@Test
	public void DocumentPreview(){
		System.setProperty("webdriver.chrome.driver", "F:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://192.168.10.101/sutisign");
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("shravanim@ibt.example.com");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("algorithm");
		driver.findElement(By.xpath("//button[text()='Sign In']")).click();
		driver.findElement(By.xpath("//img[@src='images/need-sign-icon.png']")).click();
		List<WebElement> allitems = driver.findElements(By.xpath("//table/tbody/tr/td[2]"));
		List<String> RequestTitle = new ArrayList<String>();
		for(WebElement ele : allitems)
		{
			System.out.println(ele.getText());
			
			RequestTitle.add(ele.getText());
			driver.findElement(By.xpath("//td[@id='reqTitle']/div[1][contains(text(),'"+RequestTitle+"')]/parent::td[1]/preceding-sibling::td[1]/div")).click();
			String Str1 = ele.getText();
			driver.findElement(By.xpath("//td[@id='reqTitle']/div[1][contains(text(),'"+Str1+"')]/parent::td[1]/preceding-sibling::td[1]/div")).click();
			
			
		}
		/*for(String RequestNames : RequestTitle)
		{
		driver.findElement(By.xpath("//td[@id='reqTitle']/div[1][contains(text(),'"+RequestNames+ "')]/parent::td[1]/preceding-sibling::td[1]/div")).click();
		}*/
		/*WebElement ele = driver.findElement(By.xpath("//button[text()='Sign In']");
		if(ele.isDisplayed())
		{
			
		}*/
		
	}
	
	@Test
	public void Stringreverse(){
		String str = "SutiSoft Private Ltd";
		String []split = str.split(" ");
		String result = "";
		for(int i=split.length-1; i>=0; i--)
		{
			result+=(split[i])+" ";
			System.out.println(split[i]);
		}
		System.out.println(result);
}
}
