package exercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Exercise6 {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\borja.herranz\\Desktop\\Drivers Auto\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		/** Go to the URI to test */
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		/** 1. Select one option from the checkbox */
		driver.findElement(By.id("checkBoxOption2")).click();
		
		/** 2. Store the value selected */
		String label = driver.findElement(By.id("checkBoxOption2")).getAttribute("value");
		
		/** 3. Select from the dropdown the option selected in step 2 */
		WebElement staticDropDown = driver.findElement(By.id("dropdown-class-example"));
		Select dropDown = new Select(staticDropDown);
		dropDown.selectByValue(label);
		
		/** 4. Fill the value selected in the EditBox field */
		driver.findElement(By.id("name")).sendKeys(dropDown.getFirstSelectedOption().getText());
		
		/** 5. Click on the alert and check if the value is there*/
		driver.findElement(By.id("alertbtn")).click();
		String alertText = driver.switchTo().alert().getText();
		
		String optionAlert = alertText.split(",")[0].split(" ")[1];
		System.out.println(optionAlert);

	}

}
