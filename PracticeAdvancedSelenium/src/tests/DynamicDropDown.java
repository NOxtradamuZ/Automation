package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicDropDown {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\borja.herranz\\Desktop\\Drivers Auto\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		/** Go to the URI to test */
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		// Let's catch the dynamic dropdown from the menu
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		
		/** After that, the origin and destination is clicked */
//		driver.findElement(By.xpath("//a[@value='BLR']")).click(); //Origin
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click(); //Destination
		
		/** We can reduce the scope using the parent-child functions 
		 * In order to do that, we should put a blank space to reduce the scope
		 * The scope will be reduced to the parent and all elements presented in there
		 * //ParentName[@attribute='value'] //ChildName[@attribute='value']
		 */
		driver.findElement(By.xpath("//a[@value='BLR']")).click(); //Origin
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click(); //Destination
	}

}
