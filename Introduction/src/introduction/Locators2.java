package introduction;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Locators2 {

	public static void main(String[] args) throws InterruptedException {
		
		String name = "rahul";
		
		/** This time we will log in */
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\borja.herranz\\Desktop\\Drivers Auto\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		String password = getPassword(driver);
		
		// Return to the current page	
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		
		driver.findElement(By.id("inputUsername")).sendKeys(name);
		driver.findElement(By.name("inputPassword")).sendKeys(password);
		driver.findElement(By.className("signInBtn")).click();
		
		// In the future we will use an explicit wait
		Thread.sleep(2000);
		
		/** Let's use an assertion with TestNG 
		 * In this case, we use the Assert class with the assertEquals method
		 * This will expect an expected entry to compare with the actual result
		 */
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
		
		/** Check the name of the user */
		Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(), "Hello " + name + ",");
		
		/** Log out
		 * In this case, we will do it using the text() value as
		 * //Tagname[text()='value']		 
		 */ 
		driver.findElement(By.xpath("//*[text()='Log Out']")).click();
		
		/** Close the browser */
		driver.close();

	}
	
	/**
	 * Gets the password from the page
	 * @throws InterruptedException 
	 */
	public static String getPassword(WebDriver driver) throws InterruptedException {
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.linkText("Forgot your password?")).click();
		
		Thread.sleep(1000);
		
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		String passwordText = driver.findElement(By.cssSelector("form p")).getText();
		
		// Split the string to catch "rahulsettyacademy"
		String[] passwordArray = passwordText.split("'");
		String password = passwordArray[1];
		System.out.println(password);
		return password;	
	}

}
