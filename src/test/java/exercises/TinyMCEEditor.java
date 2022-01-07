package exercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TinyMCEEditor {

	public static void main(String[] args) {
		
		//Launching the driver and getting the Logging in
		

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://the-internet.herokuapp.com/iframe");
		//switching to the driver

		driver.switchTo().frame("mce_0_ifr");
		//clearing the default text
		driver.findElement(By.xpath("//body[@id='tinymce']/p")).clear();
		//entering the text
		driver.findElement(By.xpath("//body[@id='tinymce']/p")).sendKeys("GenInvo");
		

	}

}
