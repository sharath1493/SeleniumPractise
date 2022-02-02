package shubchallenges;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EnterUserNameinShadowRootOpen {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.get("https://selectorshub.com/xpath-practice-page/");

		Thread.sleep(2000);

		//Entering text in username text box

		SearchContext un = driver.findElement(By.cssSelector("#userName")).getShadowRoot();
		un.findElement(By.cssSelector("#kils")).sendKeys("era mawa");


		

		driver.quit();


	}

}
