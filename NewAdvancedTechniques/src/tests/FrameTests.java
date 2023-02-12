package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FrameTests {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\borja.herranz\\Desktop\\Drivers Auto\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		/** Go to the URI to test */
		driver.get("https://jqueryui.com/droppable/");
		
		/** First, we have to switch the context to the frame */
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));
				
		/** Let's find the element to work with */
		driver.findElement(By.id("draggable")).click();
		
		/** Now, we are going to drag n drop the element */
		Actions action = new Actions(driver);
		
		/** Origin */
		WebElement source = driver.findElement(By.id("draggable"));
		
		/** Destination */
		WebElement destination = driver.findElement(By.id("droppable"));
		
		/** Let's perform the drag 'n drop action */
		action.dragAndDrop(source, destination).build().perform();
		
		/** Come back to the web */
		driver.switchTo().defaultContent();

	}

}
