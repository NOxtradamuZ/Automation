package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckboxHandle {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\borja.herranz\\Desktop\\Drivers Auto\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		/** Go to the URI to test */
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		/** Let's click on the checkbox
		 * Reminder: Use the '*=' to catch parts of the value
		 */
		driver.findElement(By.cssSelector("input[id*=SeniorCitizenDiscount]")).click();
		
		/** Let's find if the checkbox is selected.
		 * The isSelected() method will tell that
		 */
		System.out.println(driver.findElement(By.cssSelector("input[id*=SeniorCitizenDiscount]")).isSelected());
		
		/** Count the number of checkboxes
		 */
		System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());

	}

}
