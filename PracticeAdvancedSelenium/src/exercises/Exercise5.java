package exercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Exercise5 {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\borja.herranz\\Desktop\\Drivers Auto\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		/** Go to the URI to test */
		driver.get("https://the-internet.herokuapp.com/nested_frames");
		
		/** Let's find the middle frame. */
		driver
			.switchTo()
			.frame(driver.findElement(By.cssSelector("frame[name=frame-top]")))
			.switchTo()
			.frame(driver.findElement(By.cssSelector("frame[name=frame-middle]")));
		
		System.out.println(driver.findElement(By.id("content")).getText());
		
	}

}
