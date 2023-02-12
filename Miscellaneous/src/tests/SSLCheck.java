package tests;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SSLCheck {

	public static void main(String[] args) {
		
		/** We need to use the ChromeOptions to bypass the certificate */
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		
		/** Set proxy 
		 * More information in https://chromedriver.chromium.org/capabilities
		 * */
		Proxy proxy = new Proxy();
		proxy.setHttpProxy("ipaddress:8080");
		options.setCapability("proxy", proxy);
		
		/** Add extensions, plugins,... */
		//options.addExtensions(null);
		
		/** Set the download directory */
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("download.default_directory", "/directory/path");
		options.setExperimentalOption("prefs", prefs);
		
		/** Pass the options for bypass */
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\borja.herranz\\Desktop\\Drivers Auto\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		
		/** Go to the URI to test */
		driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle());

	}

}
