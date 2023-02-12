package tests;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverScope {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		/** Assignment 1: Give me the number links of the page 
		 * All the links have the tag 'a'
		 */
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\borja.herranz\\Desktop\\Drivers Auto\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		/** Go to the URI to test */
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		/** Let's check for tagname. */
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		/** Now, get the number of links in the footer section. */
		System.out.println(driver.findElements(By.cssSelector("div[id='gf-BIG'] a")).size());
		
		/** Now get the links of the left column of the footer */
		WebElement firstColumn = driver.findElements(By.cssSelector("table.gf-t ul")).get(0);
		System.out.println(firstColumn.findElements(By.tagName("a")).size());
		
		/** Let's click on each link and check if the pages are opened
		 * Afterwards, grab the title of each page
		 */
		Integer firstColumnSize = firstColumn.findElements(By.tagName("a")).size();
		
		/** Let's use the KEYS word for printing the control and enter values
		 * Afterwards, we are going to store this value in a string variable
		 */		
		for(int i=0; i<firstColumnSize; i++) {
			String clickOnLinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
			firstColumn.findElements(By.tagName("a")).get(i).sendKeys(clickOnLinkTab);	
		}
			
		/** Finally let's check if everything is correct */
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		
		while(it.hasNext()) {
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}
		
	}

}
