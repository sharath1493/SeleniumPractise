package conceptsOfSelenium;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenSizeScreenShotwithRobotClass {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();


		/*
		 * Steps to capture screenshot using Robot class:

    			- Create an object of Robot class.
    			- Get the screen size as a Rectangle.
    			- Use createScreenCapture of Robot class and capture screenshot. It will be temp image.
    			- Define destination path for screenshot.
    			- Write temp file in to permanent file.

		 */

		driver.get("https://www.saucedemo.com/");

		try {
			Robot robot = new Robot();
			Rectangle screenSize= new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
			BufferedImage bi=robot.createScreenCapture(screenSize);

			String path = System.getProperty("user.dir")+"/ScreenShots/"+"ScreenSizeScreenshot"+System.currentTimeMillis()+".png";
			ImageIO.write(bi, "png",new File(path));

		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.close();




	}

}
