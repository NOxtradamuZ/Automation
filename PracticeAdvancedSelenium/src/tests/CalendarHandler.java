package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalendarHandler {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\borja.herranz\\Desktop\\Drivers Auto\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		/** Go to the URI to test */
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		// Let's catch the dynamic dropdown from the menu
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
				
		driver.findElement(By.xpath("//a[@value='BLR']")).click(); //Origin
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click(); //Destination
		
		
		// ui-state-default.ui-state-highlight.ui-state-active
		/** Let's continue selecting the calendar after selecting the origin and destination */
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();

	}

}
