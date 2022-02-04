package exercises;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SwagLabsProductwithHighPrice {

	public static void main(String[] l) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.get("https://www.saucedemo.com/");

		String expproduct = "Sauce Labs Fleece Jacket";

		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//input[@id='login-button']")).click();


		String cartxapth="//div[@class='inventory_item_price']/following-sibling::button";

		//div[@class='inventory_item_price']

		List<WebElement> prices = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));

		//prices.stream().forEach(e -> {System.out.println(e.getText());});

		double maxprice=0;
		int maxindex=0;

		for(int i=0; i <prices.size(); i++)
		{

			Double tempprice=Double.parseDouble(prices.get(i).getText().substring(1));
			if(tempprice > maxprice)
			{
				maxprice=tempprice;
				maxindex=i;
			}
		}

		maxindex+=1;
		System.out.println(maxprice+ " "+maxindex);

		cartxapth="("+cartxapth+")["+maxindex+"]";

		driver.findElement(By.xpath(cartxapth)).click();

		driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();

		String actualprod = driver.findElement(By.xpath("//div[@class='inventory_item_name']")).getText();
		double actualprice =Double.parseDouble(driver.findElement(By.xpath("//div[@class='inventory_item_price']")).getText().substring(1));

		if(expproduct.equals(actualprod))
		{
			System.out.println("Product Name Matches - Test 1 Passed");
		}
		else 
		{
			System.out.println("Product Name doesnt match - Test 1 Failed");
		}

		if(maxprice == actualprice)
		{
			System.out.println("Product Price Matches - Test 2 Passed");
		}
		else
		{
			System.out.println("Product Price doesnt match - Test 2 Failed");

		}
		driver.close();


	}

}
