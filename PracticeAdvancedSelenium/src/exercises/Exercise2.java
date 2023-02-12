package exercises;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Exercise2 {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\borja.herranz\\Desktop\\Drivers Auto\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		// User credentials
		driver.findElement(By.xpath("//input[@name='name']")).sendKeys("name");
		driver.findElement(By.name("email")).sendKeys("email@gmail.com");
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("password");
		
		// Checkbox
		driver.findElement(By.id("exampleCheck1")).click();

		// Select
		Select dropDown = new Select(driver.findElement(By.id("exampleFormControlSelect1")));
		dropDown.selectByVisibleText("Female");
		dropDown.getFirstSelectedOption().click();
		
		// Round
		driver.findElement(By.id("inlineRadio2")).click();
		
		// Calendar
		driver.findElement(By.name("bday")).sendKeys("21031992");
		
		// Button
		driver.findElement(By.cssSelector(".btn.btn-success")).click();
		
		// Assertion
		Thread.sleep(3000);
		System.out.print(driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText());

	}

}
