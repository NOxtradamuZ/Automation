package tests;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestLinks {

	public static void main(String[] args) throws MalformedURLException, IOException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\borja.herranz\\Desktop\\Drivers Auto\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		/** Go to the URI to test */
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		/** Let's use the methods to check the status after sending a request, with Java */
		
		/** First, we will have all the URL in the page ^/
		 * Then, if it's 200, is fine, it's 400 or greater is wrong
		 */
//		driver.findElements(By.cssSelector(".gf-li"));

		String url = driver.findElement(By.cssSelector("a[href*=soapui]")).getAttribute("href");
		
		/** We connect to the URI */
		HttpURLConnection conn = (HttpURLConnection)new URL(url).openConnection();
		conn.setRequestMethod("HEAD");
		conn.connect();
		
		/** Get the response code */
		int responseCode = conn.getResponseCode();
		System.out.println(responseCode);

	}

}
