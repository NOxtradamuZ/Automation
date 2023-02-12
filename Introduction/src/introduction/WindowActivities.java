package introduction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowActivities {

	/**
	 * Let's max the wider of the screen
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\borja.herranz\\Desktop\\Drivers Auto\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		// We use the manager().window().method() to manipulate the web window.
		driver.manage().window().maximize();
		
		driver.get("https://google.es"); // Wait until the URL is loaded
		
		// We can use another methods to navigate to a page
		driver.navigate().to("https://rahulshettyacademy.com"); // It does not wait until the URL is loaded
		
		// Return to the last page
		driver.navigate().back();

	}

}
