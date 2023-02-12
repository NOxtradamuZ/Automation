package exercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Exercise1 {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\borja.herranz\\Desktop\\Drivers Auto\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		Assert.assertFalse(driver.findElement(By.xpath("//div[@id='checkbox-example'] //input[@id='checkBoxOption1']")).isSelected());
		driver.findElement(By.xpath("//div[@id='checkbox-example'] //input[@id='checkBoxOption1']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//div[@id='checkbox-example'] //input[@id='checkBoxOption1']")).isSelected());
		
		/** To get the number of checkboxes present in the web page */
		System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());

	}

}
