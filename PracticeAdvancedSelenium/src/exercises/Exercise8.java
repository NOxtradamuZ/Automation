package exercises;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Exercise8 {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\borja.herranz\\Desktop\\Drivers Auto\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		/** Go to the URI to test */
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.findElement(By.id("autocomplete")).sendKeys("uni");
		Thread.sleep(5000);
		
		/** Get all the options from the dynamic list */
		List<WebElement> options = driver.findElements(By.cssSelector(".ui-menu-item-wrapper"));
		
		/** Create a variable to perform the action to move the mouse afterwards */
		Actions action = new Actions(driver);
		
		/** For loop and select the desired country*/
		for(int i=0; i<options.size(); i++) {
			if(options.get(i).getText().equalsIgnoreCase("United Kingdom (UK)")) {
				action.moveToElement(options.get(i)).perform();
			}
		}
		
//		/** Alternative */
//		for(int i=0; i<options.size(); i++) {
//			driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
//			if(options.get(i).getText().equalsIgnoreCase("United Kingdom (UK)")) {
//				break;
//			}
//		}
	}

}
