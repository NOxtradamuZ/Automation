package tests;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class CaptureElementScreenshot {

	public static void main(String[] args) throws IOException {
		
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
		WebElement name = driver.findElement(By.cssSelector("[name='name']"));
		name.sendKeys(courseName);
		
		/** Takes a screenshot of the element */
		File file = name.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("logo.png"));
		
		/** Get height and weight of an element with getRect() and choosing the parameter to check */
		System.out.println(name.getRect().height);
		System.out.println(name.getRect().width);

	}

}
