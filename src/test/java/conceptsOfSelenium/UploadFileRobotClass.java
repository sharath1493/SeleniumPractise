package conceptsOfSelenium;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UploadFileRobotClass {

	public static void main(String[] args)  {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.get("http://the-internet.herokuapp.com/upload");

		driver.findElement(By.xpath("//div[@id='drag-drop-upload']")).click();


		//Copying the file path to clip board and getting ready for Robot Class to consume via Keyboard Actions
		String filepath="C:\\Users\\shara\\Downloads\\sampleFile.jpeg";
		StringSelection s = new StringSelection(filepath);

		Clipboard c= Toolkit.getDefaultToolkit().getSystemClipboard();
		c.setContents(s, s);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}


		Robot robot;
		try {
			robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

			try {
				Thread.sleep(2000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);


		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}


		String actual = driver.findElement(By.xpath("//div/div/span[text()='sampleFile.jpeg']")).getText();

		if(actual.equals("sampleFile.jpeg"))
		{
			System.out.println("Test Case Passed");
		}

		driver.quit();


	}

}
