package exercises;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ACMEDemoApp
{
	public static void main(String[] k)
	{
		
		//Launching the driver and getting the Logging in
		

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.applitools.com/");
		driver.findElement(By.id("username")).sendKeys("Test1");
		driver.findElement(By.id("password")).sendKeys("Test1");
		driver.findElement(By.id("log-in")).click();
		
		
		//Defining wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		
		//Print total number of recent transactions on the page
		By transactionList = By.xpath("//table/tbody/tr");
		
		List<WebElement> rt = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(transactionList));
		
		System.out.println("Total number recent transactions are : "+rt.size());
		
		//Print total links on the page 

		List<WebElement> links = driver.findElements(By.tagName("a"));
		
		System.out.println("Total number links on the page are : "+links.size());
		
		


	}


}
