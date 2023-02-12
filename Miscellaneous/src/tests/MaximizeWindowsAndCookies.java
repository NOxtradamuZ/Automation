package tests;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MaximizeWindowsAndCookies {

	public static void main(String[] args) throws IOException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\borja.herranz\\Desktop\\Drivers Auto\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		/** Maximize window */
		driver.manage().window().maximize();
		
		/** Delete cookies */
		driver.manage().deleteAllCookies();
		
		/** Delete some cookies */
		//driver.manage().deleteCookieNamed("asdf");
		
		/** Delete some cookies for session validation */
		//driver.manage().deleteCookieNamed("sessionKey");
		
		driver.get("https://google.com");
		
		/** We will create screenshots */
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		/** Copy the file from the source to the local machine */
		FileUtils.copyFile(src, new File("\"C:\\\\Users\\\\borja.herranz\\\\Desktop\\screenshot.png"));

	}

}
