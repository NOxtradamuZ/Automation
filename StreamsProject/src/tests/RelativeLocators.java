package tests;

/** New package should be added manually */
import static org.openqa.selenium.support.locators.RelativeLocator.with;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RelativeLocators {
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\borja.herranz\\Desktop\\Drivers Auto\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		/** Go to the URI to test */
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		WebElement nameEditBox = driver.findElement(By.cssSelector("[name='name']"));
		
		/** Let's use the relative locators with the 'with(By)' method' */
		
		/** above() */
		System.out.println(driver.findElement(with(By.tagName("label")).above(nameEditBox)).getText());
		
		/** below() */
		WebElement dateOfBirth = driver.findElement(By.cssSelector("[for='dateofBirth']"));
		driver.findElement(with(By.tagName("input")).below(dateOfBirth)).click();
		
		/** toLeftOf() */
		WebElement iceCreamLabel = driver.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));
		driver.findElement(with(By.tagName("input")).toLeftOf(iceCreamLabel)).click();
		
		/** toRightOf() */
		WebElement roundButton = driver.findElement(By.id("inlineRadio1"));
		System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(roundButton)).getText());
				
	}

}
