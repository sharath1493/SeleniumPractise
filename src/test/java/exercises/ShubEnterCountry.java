package exercises;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ShubEnterCountry {
	
	
	@Test
	public void enterCountry() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\shara\\Desktop\\LibraryFiles\\trng\\Recordings, docs and sessions\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://selectorshub.com/xpath-practice-page/");
		
		//This Element is inside single shadow DOM.
		String cssSelectorForHost1 = "#userName";
		Thread.sleep(1000);
		WebElement shadowDomHostElement = driver.findElement(By.cssSelector("#userName"));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement last = (WebElement) js.executeScript("return arguments[0].shadowRoot", shadowDomHostElement);
		
		Thread.sleep(1000);
		last.findElement(By.cssSelector("#pact1"));
		WebElement element = last.findElement(By.cssSelector("#pact1"));
		
		driver.switchTo().frame(element);
		driver.findElement(By.cssSelector("#jex")).sendKeys("India");
		//String text = driver.findElement(By.cssSelector("#jex")).getText();
		
		
		//Assert.assertEquals(text, "India");
		
		
		driver.quit();
		
	}

}
