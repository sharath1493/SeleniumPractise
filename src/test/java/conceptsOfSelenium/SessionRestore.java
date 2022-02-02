package conceptsOfSelenium;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.html5.Location;

public class SessionRestore {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\shara\\Desktop\\LibraryFiles\\trng\\Recordings, docs and sessions\\chromedriver.exe");

		//Initial Set up
		ChromeDriver driver = new ChromeDriver();

		Capabilities cap = driver.getCapabilities();
		Map<String, Object> m = cap.asMap();

		m.forEach((K, V) -> { System.out.println("Key: " + K + " - Value: "+V);});

		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("No Way Home");
		
		



  
		// Restoring the session
		//		ChromeOptions op = new ChromeOptions();
		//		op.setExperimentalOption("debuggerAddress", "localhost:60922");
		//		//
		//		ChromeDriver driver = new ChromeDriver(op);
		//		Capabilities cap = driver.getCapabilities();
		//
		//		
		//		Map<String, Object> m = cap.asMap();
		//
		//		m.forEach((K, V) -> { System.out.println("Key: " + K + " - Value: "+V);});
		//		driver.findElement(By.name("q")).sendKeys("No Way Home");
		//
		//		
		//		
	}

}
