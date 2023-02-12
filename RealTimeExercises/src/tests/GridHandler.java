package tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class GridHandler {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\borja.herranz\\Desktop\\Drivers Auto\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		/** Go to the URI to test */
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		/** Let's grab the value of a grid with Selenium and CSS */
		List<WebElement> values = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		int sum = 0;
		
		/** After catching all the elements of the 4th column, we are going to put as integer */
		for(int i=0; i<values.size(); i++) {
			sum += Integer.parseInt(values.get(i).getText());
		}
		
		System.out.println(sum);
		
		/** Finally, let's compare the value from the front-end with the sum obtained */
		int valueToCompare = Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());
		
		Assert.assertEquals(sum, valueToCompare);

	}

}
