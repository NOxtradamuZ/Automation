package introduction;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\borja.herranz\\Desktop\\Drivers Auto\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys("rahul");
		driver.findElement(By.name("inputPassword")).sendKeys("hello123");
		driver.findElement(By.className("signInBtn")).click();
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
		
		/**
		 * Link locators
		 * They have to have the 'a' link (mandatory)
		 */
		driver.findElement(By.linkText("Forgot your password?")).click();
		
		// Wait in Java
		Thread.sleep(2000);
		
		/**
		 * XPath locators
		 * Sintax:
		 * //Tagname[@attribute=’value’].
		 * 
		 * Ex: //Input[@placeholder=’Username’]
		 * The attribute must be unique. There should be only one attribute to use XPath locators
		 */
		driver.findElement(By.xpath("//Input[@placeholder='Name']")).sendKeys("John");
		
		// Using CSS Selector
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("john@rsa.com");
		
		// Using XPath
		/**
		 * Delete text using the clear() method
		 * If the elements are repeated, we can use:
		 * //Tagname[@attribute=’value’][index]
		 */
		driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
		
		// Continue with child indexes
		/**
		 * For accessing the childs, use the ':'
		 * ":nth-child(index)"
		 */
		driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("john@gmail.com");
		
		/**
		 * Accessing to the different Xpath elements can be done with a slash
		 */
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("9864353253");
		
		/** Finally, we can click the button to submit */
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		
		/** Accessing to the child element with CSS Selector is with an empty space*/
		System.out.println(driver.findElement(By.cssSelector("form p")).getText());
		
		/** This will not work due to the handling of the exeception */
		
		/** Go to login */
		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
		
		// Wait in Java
		Thread.sleep(2000);
		
		/**
		 * Let's access to the private area after login with a real user
		 */
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys("rahul");
		
		/**
		 * Let's extract the temporary password
		 * I should use RegEx, by using the '*' symbol like:
		 * Tagname[attribute*='not-all-value']
		 */
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy"); // We will see how to extract the value in the future
		
		/** Click the button to remember the username*/
		driver.findElement(By.id("chkboxOne")).click();
		
		/** Submit the button
		 * We will use the regular expression:
		 * //Tagname[contains(@attribute, 'value')]
		 */
		driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
		
	}

}
