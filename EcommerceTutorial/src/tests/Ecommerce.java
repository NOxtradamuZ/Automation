package tests;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Ecommerce {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\borja.herranz\\Desktop\\Drivers Auto\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		/** Go to the URI to test */
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		/** Let's put an explicit wait */
		WebDriverWait explicitWait = new WebDriverWait(driver, 5);
		
		/** Let's add items to the cart */
		// In this case, there is no attribute and we should parse the product. We will use index for that after finding the product to add
		String[] expectedItems = {"Cucumber", "Brocolli", "Beetroot", "Carrot"};
		addItems(driver, expectedItems);
		
		/** Let's add the items, apply the promo code and see what is happening */
		driver.findElement(By.cssSelector("img[alt=Cart]")).click();
		
		driver.findElement(By.xpath("//button[contains(text(), 'PROCEED TO CHECKOUT')]")).click();
		
		// Wait until the element is present before filling with the promo code
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
		
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
	}
	
	public static void addItems(WebDriver driver, String[] expectedItems) {
		
		/** 1. Catch all the elements */
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		
		/** Let's put a condition to break the loop */
		int j = 0;
		
		/** 2. Iterate through all the elements */
		for(int i=0; i<products.size(); i++) {
			// We will convert the array to arraylist for easy search
			/** We will split the 1kg to the rest of the text*/
			String[] name = products.get(i).getText().split("-");
			String formattedVegetable = name[0].trim();
			
			List<String> expectedItemsList = Arrays.asList(expectedItems);
			
			if(expectedItemsList.contains(formattedVegetable)) {
				// Click on Add to cart. It will parse the right button
				/** Add a new item to the chart */
				j++;
				/** Never use text locators. Instead, use another locator */
				//driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				if(j==expectedItems.length) {
					break;
				}
			}
		}
		
	}
}
