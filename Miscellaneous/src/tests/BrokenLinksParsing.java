package tests;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class BrokenLinksParsing {

	public static void main(String[] args) throws MalformedURLException, IOException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\borja.herranz\\Desktop\\Drivers Auto\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		/** Go to the URI to test */
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		
		/** Let's use soft assert for not breaking the flow of the program. */
		SoftAssert assertion = new SoftAssert();
		
		/** Iterate through the list of links*/
		for(WebElement link:links) {
			String url = link.getAttribute("href");
			
			/** We connect to the URI */
			HttpURLConnection conn = (HttpURLConnection)new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			
			/** Get the response code */
			int responseCode = conn.getResponseCode();
			System.out.println(responseCode);
			
			assertion.assertTrue(responseCode < 400, "The link with text " + link.getText() + " is broken with code " + responseCode);
		}
	}

}
