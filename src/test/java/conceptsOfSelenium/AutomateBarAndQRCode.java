package conceptsOfSelenium;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutomateBarAndQRCode {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://testautomationpractice.blogspot.com/");
		
		//Provide the Xpath of BarCode or QR Code
		String imgSourceURL= driver.findElement(By.xpath("//div[@id='HTML4']//img")).getAttribute("src");
		URL url;
		BufferedImage bi;
		LuminanceSource ls;
		BinaryBitmap bm;
		Result rs=null;
		try {
			url= new URL(imgSourceURL);
			bi=ImageIO.read(url);
			ls=new BufferedImageLuminanceSource(bi);
			bm=new BinaryBitmap(new HybridBinarizer(ls));
			rs=new MultiFormatReader().decode(bm);

		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		} catch (NotFoundException e) {
			e.printStackTrace();
		} 
		
		
		System.out.println(rs.getText());
		
		driver.quit();



	}

}
