package tests;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandler {

	public static void main(String[] args) {
		
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\borja.herranz\\Desktop\\Drivers Auto\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		/** Go to the URI to test */
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.manage().window().maximize();
		
		/** Let's click on the link to navigate to another window */
		driver.findElement(By.cssSelector("a.blinkingText")).click();
		
		/** After clicking the context will stay in the parent
		 * We need to tell Selenium to change the context of the tests from the parent to the child.
		 * Firstable, we need to ensure how many tabs are opened.
		 * Then, we will iterate throught the windows with the Iterator class.
		 */
		Set<String> windows = driver.getWindowHandles(); // [parentId, childId]
		
		// In future occasions, we can use the for each loop
		Iterator<String> it = windows.iterator();
		String parentId = it.next();
		String childId = it.next();
		
		/** Let's change the context from the parent to the child */
		driver.switchTo().window(childId);
		
		/** Let's extract the text of a paragraph */
		System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText());
		
		/** Let's check only the mail */
		String email = driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0];
		
		/** Let's paste this in the parent window */
		driver.switchTo().window(parentId);
		driver.findElement(By.id("username")).sendKeys(email);

	}

}
