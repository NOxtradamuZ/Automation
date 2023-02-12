package introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators3 {

	/**
	 * We are going to do a practice with parents and siblings
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\borja.herranz\\Desktop\\Drivers Auto\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		/** Get the page */
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		// The route to use is //header/button[1]/following-sibling::button[1]
		driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).click();
		
		// Example of siblings, parents
		System.out.println(driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText());
		System.out.println(driver.findElement(By.xpath(
				"//header/div/button[1]/following-sibling::button[1]/parent::div/parent::header/div/button[1]/following-sibling::button[1]"
				))
				.getText());

	}

}
