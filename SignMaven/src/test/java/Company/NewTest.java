package Company;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class NewTest {
	@Test
	public void CompanyUpdate(){
		System.setProperty("webdriver.chrome.driver", "F:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://192.168.10.101/sutisign");
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("shravanim@ibt.example.com");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("algorithm");
		driver.findElement(By.xpath("//button[text()='Sign In']")).click();
		/*driver.findElement(By.xpath("//img[@class='head-profile']")).click();
		driver.findElement(By.xpath("//a[@id='admin']")).click();
		driver.findElement(By.xpath("//input[@name='update']")).click();
		driver.findElement(By.xpath("//a[@id='company']")).click();
	
		
		driver.findElement(By.xpath("//a[@id='companySettings']")).click();
		driver.findElement(By.xpath("//input[@name='update']")).click();*/
		//driver.findElement(By.xpath("//a[text()='Requests']")).click();
		driver.findElement(By.xpath("//div[text()='Send A Request']")).click();
		//List<String> alldata = new ArrayList<String>();
		List<WebElement> allitems = driver.findElements(By.xpath("//table/tbody/tr/td[3]"));
		TreeSet<String> Citynames = new TreeSet<String>();
		
		for(WebElement ele : allitems)
		{
			Citynames.add(ele.getText());		
		}
		System.out.println(Citynames);
		
		
		//driver.findElement(By.xpath("//table/tbody/tr/td")).getSize();
		
	}
}
