package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalendarHandler {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\borja.herranz\\Desktop\\Drivers Auto\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		/** Go to the URI to test */
		driver.get("https://www.path2usa.com/travel-companion/");
		
		/** Let's provide month's name and date.
		 * For example March 21
		 */
		driver.findElement(By.id("form-field-travel_comp_date")).click();
		
		// To add the code for the calendar here.


	}

}
