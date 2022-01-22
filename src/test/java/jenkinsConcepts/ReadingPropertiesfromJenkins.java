package jenkinsConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReadingPropertiesfromJenkins {

	@Test
	public void readDatafromJenkins() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();

		String userName=System.getProperty("userName");
		String password=System.getProperty("password");
		String finalUrl= "https://"+userName+password+"@the-internet.herokuapp.com/basic_auth";

		System.out.println("Constructed URL is : "+finalUrl);

		driver.get(finalUrl);

		String etext=driver.findElement(By.cssSelector("div[class='example'] p")).getText();

		driver.close();

		Assert.assertTrue(etext.equals("Congratulations! You must have the proper credentials."));


	}

}
