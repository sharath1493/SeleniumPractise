package conceptsOfSelenium;

import java.time.LocalDate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectDateInCalendar {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("http://testautomationpractice.blogspot.com/");



		LocalDate ld= LocalDate.of(2022, 7, 17);
		String specificDate=ld.toString();
		System.out.println(specificDate);

		String date[] = specificDate.split("-");

		String sYear= date[0];
		String sMonth = date[1];
		String sDay = date[2];

		String descMonth = SelectDateInCalendar.mapMonth(sMonth);


		//Calendar Input box
		WebElement cal = driver.findElement(By.xpath("//input[@id='datepicker']"));

		cal.click();

		//Calendar Buttons - Gets Stale on each click

		WebElement next = driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']"));
		WebElement previous = driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']"));

		//Calendar Title with Month and Year - Gets Stale on each click
		WebElement calMonth= driver.findElement(By.xpath("//span[@class='ui-datepicker-month']"));
		WebElement calyear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']"));


		//Select year
		while(!driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText().equals(sYear))
		{
			if(Integer.parseInt(driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText()) > Integer.parseInt(sYear))
				driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
			if(Integer.parseInt(driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText()) < Integer.parseInt(sYear))
				driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
			if(Integer.parseInt(driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText()) == Integer.parseInt(sYear))
				break;
		}

		//Select Month
		while(!driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText().equalsIgnoreCase(descMonth))
		{
			if(SelectDateInCalendar.mapDigitMonth(driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText()) > Integer.parseInt(sMonth))
				driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
			if(SelectDateInCalendar.mapDigitMonth(driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText()) < Integer.parseInt(sMonth))
				driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
			if(SelectDateInCalendar.mapDigitMonth(driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText()) == Integer.parseInt(sMonth))
				break;
		}

		//Select Day
		String dayXapth = "//a[normalize-space()='XX']";

		driver.findElement(By.xpath(dayXapth.replace("XX", sDay))).click();




		//Manually Sending the date in calendar input box
		/*
		String manualdate = "07/17/2024";
		cal.sendKeys(manualdate);

		 */

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.close();

	}

	private static String mapMonth(String sMonth) {

		if(Integer.parseInt(sMonth)==1)
			return "January";
		if(Integer.parseInt(sMonth)==2)
			return "February";
		if(Integer.parseInt(sMonth)==3)
			return "March";
		if(Integer.parseInt(sMonth)==4)
			return "April";
		if(Integer.parseInt(sMonth)==5)
			return "May";
		if(Integer.parseInt(sMonth)==6)
			return "June";
		if(Integer.parseInt(sMonth)==7)
			return "July";
		if(Integer.parseInt(sMonth)==8)
			return "August";
		if(Integer.parseInt(sMonth)==9)
			return "September";
		if(Integer.parseInt(sMonth)==10)
			return "October";
		if(Integer.parseInt(sMonth)==11)
			return "November";
		if(Integer.parseInt(sMonth)==12)
			return "December";

		return sMonth;

	}

	private static int mapDigitMonth(String text)
	{
		if(text.equals("January"))
			return 1;
		if(text.equals("February"))
			return 2;
		if(text.equals("March"))
			return 3;
		if(text.equals("April"))
			return 4;
		if(text.equals("May"))
			return 5;
		if(text.equals("June"))
			return 6;
		if(text.equals("July"))
			return 7;
		if(text.equals("August"))
			return 8;
		if(text.equals("September"))
			return 9;
		if(text.equals("October"))
			return 10;
		if(text.equals("November"))
			return 11;
		if(text.equals("December"))
			return 12;

		return 0;

	}

}
