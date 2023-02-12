package tests;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class InvokingMultipleWindows {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\borja.herranz\\Desktop\\Drivers Auto\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		/** Go to the URI to test */
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		/** Open a new window */
		driver.switchTo().newWindow(WindowType.WINDOW);
		
		/** Change the context to the next tab, as it is not done yet */
		/** First, we have to manage all the windows displayed */
		Set<String> windowHandlers = driver.getWindowHandles();
		Iterator<String> it = windowHandlers.iterator();
		
		String parentWindowId = it.next();
		String childWindowId = it.next();
		driver.switchTo().window(childWindowId);
		
		/** Switch to the other window ad check the URI */
		driver.get("https://rahulshettyacademy.com/");
		String courseName = driver
			.findElements(By.cssSelector("a[href='https://courses.rahulshettyacademy.com/p/core-java-for-automation-testers-interview-programs']"))
			.get(1)
			.getText();
		
		/** Return to the first browser */
		driver.switchTo().window(parentWindowId);
		driver.findElement(By.cssSelector("[name='name']")).sendKeys(courseName);
		
		Thread.sleep(5000);
		driver.quit();

	}

}
