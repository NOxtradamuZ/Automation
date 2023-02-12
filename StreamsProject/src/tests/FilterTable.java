package tests;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class FilterTable {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\borja.herranz\\Desktop\\Drivers Auto\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		/** Go to the URI to test */
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		/** Let's filter with a search filter */
		driver.findElement(By.id("search-field")).sendKeys("Rice");
		List<WebElement> elements = driver.findElements(By.xpath("//tr/td[1]"));
		
		/** With all the results, we will check the text */
		List<WebElement> filterElements = elements
			.stream()
			.filter(s->s.getText().contains("Rice"))
			.collect(Collectors.toList());
			
		Assert.assertEquals(elements.size(), filterElements.size());

	}

}
