package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsDemo {
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\borja.herranz\\Desktop\\Drivers Auto\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		/** Go to the URI to test */
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
		
		/** Actions to control the mouse */
		Actions action = new Actions(driver);
		WebElement move = driver.findElement(By.cssSelector("a[id='nav-link-accountList']"));
		
		/** Let's write some fields to perform a search
		 * In order to put in Capital, we need to press SHIFT after clicking the field.
		 * Then, we send the keys.
		 * For all the actions, we need to use the action class
		 */
		action.moveToElement(driver.findElement(By.id("twotabsearchtextbox")))
			.click()
			.keyDown(Keys.SHIFT)
			.sendKeys("hello")
			.doubleClick()
			.build()
			.perform();
		
		
		/** Let's move to the element 
		 * The argument is to pass the element to open the pop-up
		 * The method is moveToElement()
		 * Finally, we need to put build() to build this step. And perform() what executes all          
		 * Let's use composite actions: Put more than one method in same line                                                                    
		 */
		action.moveToElement(move)
			.contextClick()
			.build()
			.perform();
		
		
	}

}
