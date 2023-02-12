package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

/**
 * This class will do an e2e test case like the following
 * 1. Select an origin
 * 2. Select a destination
 * 3. Select 'Family and Friends' checkbox
 * 3. Select the current date for flying
 * 4. Select the default value for returning
 * 5. Select the number of passengers
 * 6. Select the currency
 * 7. Search the results
 * @author borja.herranz
 *
 */
public class End2end {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\borja.herranz\\Desktop\\Drivers Auto\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		/** Go to the URI to test */
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		// First we click on the round button, just in case
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();
		
		/** 1. Select the origin */
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@value='DEL']")).click();
		
		/** 2. Select the destination */
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();
		
		/** 3. Select the current date*/
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
		
		/** 4. Select the returning back. Code will be available again */
		// We check if we have selected the returning back
		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5")) {
			System.out.println("It is disabled");
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
		
		/** 5. Select the number of passengers */
		// Loops until 5 passengers is selected
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000);
		
		int i = 1;
		while(i<5) {
			driver.findElement(By.id("hrefIncAdt")).click(); // 5 adults
			i++;
		}
		
		Thread.sleep(2000);
		driver.findElement(By.id("btnclosepaxoption")).click();
		
		// Checking that 5 passengers have been selected
		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");
		
		/** 6. Select the currency */
		Thread.sleep(2000);
		WebElement staticDropDown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select dropDown = new Select(staticDropDown);
		dropDown.selectByVisibleText("USD");
		
		/** 7. Click on the Search button */
		driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
	}

}
