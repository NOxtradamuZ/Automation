package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollHandler {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\borja.herranz\\Desktop\\Drivers Auto\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		/** Go to the URI to test */
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		/** In order to handle with the scrolling, we have to activate the JavaScript executor class
		 * It is indicated the driver what will manage everything 
		 */
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		/** Here it is needed to pass the javascript script */
		js.executeScript("window.scroll(0,500)");
		Thread.sleep(3000);
		
		/** Now let's do the same with the scroll in one of the elements */
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");

	}

}
