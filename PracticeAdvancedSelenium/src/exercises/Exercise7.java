package exercises;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Exercise7 {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\borja.herranz\\Desktop\\Drivers Auto\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		/** Go to the URI to test */
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		/** 1. Print number of rows */
		System.out.println(driver.findElements(By.cssSelector(".table-display tr")).size());
		
		/** 2. Print number of columns */
		System.out.println(driver.findElements(By.cssSelector(".table-display th")).size());
		
		/** 3. Print third row */
		List<WebElement> values = driver.findElements(By.cssSelector(".table-display tr:nth-child(3)"));
		
		for(int i=0; i<values.size(); i++) {
			System.out.print(values.get(i).getText());
		}

	}

}
