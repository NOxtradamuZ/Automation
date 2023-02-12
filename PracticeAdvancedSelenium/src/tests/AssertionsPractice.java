package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class AssertionsPractice {

	/**
	 * Let's use the code from the CheckboxHandler class and the UpdateDropDown
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\borja.herranz\\Desktop\\Drivers Auto\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		/** Go to the URI to test */
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		/** Let's use TestNG for checking assertions
		 * In this case, let's check the checkbox
		 */		
		Assert.assertFalse(driver.findElement(By.cssSelector("input[id*=SeniorCitizenDiscount]")).isSelected());
		
		driver.findElement(By.cssSelector("input[id*=SeniorCitizenDiscount]")).click();
		
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*=SeniorCitizenDiscount]")).isSelected());
		
		/** Let's use TestNG for checking assertions
		 * In this case, let's check the click three buttons for adding (+) options */		
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000); // In future sections it will be done with explicit waiters
		
		// Loop continuously until 5 adults
		int i = 1;
		while(i<5) {
			driver.findElement(By.id("hrefIncAdt")).click(); // 5 adults
			i++;
		}
		
		Thread.sleep(2000);
		driver.findElement(By.id("btnclosepaxoption")).click();
		
		// Assertion
		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");
	}

}
