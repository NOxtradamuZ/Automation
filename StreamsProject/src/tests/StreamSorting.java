package tests;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class StreamSorting {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\borja.herranz\\Desktop\\Drivers Auto\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		/** Go to the URI to test */
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		/** Steps to perform 
		 * 1. Click on the column
		 * 2. Capture all WebElements to a list
		 * 3. Capture the text of all WebElements into a new list
		 * 4. Sort the list of these elements
		 * 5. Compare the original list with the new list
		 */
		driver.findElement(By.xpath("//tr/th[1]")).click();
		List<WebElement> elements = driver.findElements(By.xpath("//tr/td[1]"));
		List<String> originalList = elements.stream().map(s->s.getText()).collect(Collectors.toList());
		List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
		Assert.assertTrue(originalList.equals(sortedList));
		
		/** Get the price for every item 
		 * 1. Let's get the price of one elements (we have already all elements)
		 * 2. Get the the text after scanning
		 * 3. Print the price of the item
		 */
		List<String> price = new ArrayList<>();
		do {
			List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));
			
			price = rows
				.stream()
				.filter(s->s.getText().contains("Rice"))
				.map(s->getPriceVeggie(s))
				.collect(Collectors.toList());
			
			price.forEach(s->System.out.println(s));
			
			/** Condition to check if it's displayed on the page 
			 * If not, we move the next page
			 */
			if(price.size()<1) {
				driver.findElement(By.cssSelector("[aria-label='Next']")).click();
			}
		
		} while(price.size()<1);
	}

	/** Sibling from one element to the next one */
	private static String getPriceVeggie(WebElement price) {
		return price.findElement(By.xpath("following-sibling::td[1]")).getText();
	}

}
