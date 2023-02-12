package exercises;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Exercise3 {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\borja.herranz\\Desktop\\Drivers Auto\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		/** Go to the URI to test */
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		/** Wait the submission */
		WebDriverWait waitSignIn = new WebDriverWait(driver, 5);
		
		/** Fill the form */
		fillLoginForm(driver);
		waitSignIn.until(ExpectedConditions.urlMatches("https://rahulshettyacademy.com/angularpractice/shop"));
		addItemsChart(driver);
	}
	
	public static void fillLoginForm(WebDriver driver) {
		
		/** Wait the alert display */
		WebDriverWait waitAlert = new WebDriverWait(driver, 2);
		
		/** Fill the form */
		driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("password")).sendKeys("learning");
		driver.findElement(By.xpath("//div[@class='form-check-inline']/label[2]/span")).click();
		waitAlert.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".modal-body")));
		driver.findElement(By.id("okayBtn")).click();
		
		/** Dropdown */
		WebElement staticDropDown = driver.findElement(By.cssSelector("select[class='form-control']"));
		Select dropDown = new Select(staticDropDown);
		dropDown.selectByValue("consult");
		
		/** Terms and conditions */
		driver.findElement(By.id("terms")).click();
		
		/** Click button */
		driver.findElement(By.id("signInBtn")).click();	
	}
	
	public static void addItemsChart(WebDriver driver) throws InterruptedException {
		
		/** 1. Catch all the elements */
		List<WebElement> products = driver.findElements(By.xpath("//div[@class='card h-100']"));
		
		/** 2. Let's put the condition for the loop */
		for(WebElement product : products) {
			product.findElement(By.cssSelector(".btn-info")).click();
		}
		
		/** 3. Finally we put the checkout */
		driver.findElement(By.xpath("//div[@id='navbarResponsive'] //a")).click();
	}

}
