package shubchallenges;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClickUdemyLink {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://selectorshub.com/xpath-practice-page/");
		
		
		//This Element is inside single shadow DOM.
		String cssSelectorForHost1 = "#userName";
		Thread.sleep(1000);
		WebElement shadowDomHostElement = driver.findElement(By.cssSelector("#userName"));
		WebElement ele = (WebElement)( driver.executeScript("return arguments[0].shadowRootOpen",shadowDomHostElement));
		Thread.sleep(1000);
		//ele.findElement(By.cssSelector("#concepts"));
		
		
		//This Element is inside 2 nested shadow DOM.
		String cssSelectorForHost2 = "#concepts";
		Thread.sleep(1000);
		WebElement shadowDomHostElement0 = driver.findElement(By.cssSelector("#userName"));
		WebElement last0 = (WebElement) ((JavascriptExecutor) driver).executeScript("return arguments[0].shadowRoot", shadowDomHostElement0);
		Thread.sleep(1000);
		WebElement shadowDomHostElement1 = last0.findElement(By.cssSelector("#concepts"));
		WebElement last1 = (WebElement) ((JavascriptExecutor) driver).executeScript("return arguments[0].shadowRoot", shadowDomHostElement1);
		Thread.sleep(1000);
		last1.findElement(By.cssSelector("element is inside iframe & it is not supported by SelectorsHub currently. Please write CSS manually."));
		
		
		ele.click();
		ele.sendKeys(Keys.TAB);
		ele.sendKeys(Keys.TAB);
		ele.sendKeys(Keys.ENTER);

		

	}

}
