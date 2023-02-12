package exercises;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Exercise4 {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\borja.herranz\\Desktop\\Drivers Auto\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		/** Go to the URI to test */
		driver.get("https://the-internet.herokuapp.com/windows");
		
		/** Go to the child */
		driver.findElement(By.cssSelector("div.example a")).click();
		
		/** Let's manage the open windows */
		Set<String> windows = driver.getWindowHandles();
		
		Iterator<String> it = windows.iterator();
		it.next();
		String childId = it.next();
		
		String oldWindow = driver.findElement(By.cssSelector("div.example h3")).getText();
		
		driver.switchTo().window(childId);
		
		/** Let's catch the value */
		String newWindow = driver.findElement(By.cssSelector("div.example")).getText();
		
		/** Let's catch the old value */
		System.out.println(newWindow);
		System.out.println(oldWindow);
		
	}

}
