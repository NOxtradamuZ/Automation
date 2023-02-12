package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertsHandler {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\borja.herranz\\Desktop\\Drivers Auto\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		/** Go to the URI to test */
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		/** Let's catch the alert in JavaScript and put the enter */
		// This is the text to put it in the field
		String text = "Rahul";
		driver.findElement(By.id("name")).sendKeys(text);
		
		/** Click on the Alert button */
		driver.findElement(By.cssSelector("#alertbtn")).click();
		
		/** Switch the context from the browser to the alert. We use the switchTo() method for this and then alert() for mapping the alert */
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		
		/** For alerts with confirm behaviour. We use dismiss() for cancel */
		driver.findElement(By.id("confirmbtn")).click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().dismiss();
	}

}
