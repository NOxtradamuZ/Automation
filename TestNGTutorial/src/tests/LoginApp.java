package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginApp {
	
	@Parameters({"URL"})
	@Test
	public void webLoginCarLoan(String urlName) {
		// Selenium
		System.out.println("Web Login Car Home");
		System.out.println(urlName);
	}
	
	@Test(enabled = false)
	public void mobileLoginCarLoan() {
		// App
		System.out.println("App Login Car Home");
	}
	
	@Test(groups = {"Smoke"})
	public void mobileSignInCarLoan() {
		// App
		System.out.println("App Sign-in Car Home");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("I execute at the end each time a method is called");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("I execute in the beginning each time a method is called");
	}
	
	@Test(dependsOnMethods = {"WebLoginCarLoan()"})
	public void mobileLogoutCarLoan() {
		// App
		System.out.println("App Logout Car Home");
	}
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("First test to be executed in the suite");
	}
	
	@Test(timeOut = 400)
	public void apiLoginCarLoan() {
		// REST API automation
		System.out.println("REST API Login Car Home");
	}
	
	@Test(dataProvider = "getData")
	public void validationData(String userName, String password) {
		System.out.println("Validation is taken place in this method");
		System.out.println(userName);
		System.out.println(password);
	}
	
	/** Let's use the @DataProvider annotation for providing all the test data 
	 * for the project
	 */
	@DataProvider
	public Object[][] getData() {
		// 1st combination with one user and a password - Good credit history
		// 2nd combination with one user and a password - No credit history
		// 3rd combination with one user and a password - Fraudlent credit 
		
		/** Define the matrix with the data
		 * The rows are the combinations (3 test cases)
		 * The columns are the values (in this case, the username and the password 
		 */
		 Object[][] data = new Object[3][2];
		 
		 /** Initialization */
		 // 1st combination - Test case
		 data[0][0] = "firstusername";
		 data[0][1] = "password";
		 
		 // 2nd combination - Test case
		 data[1][0] = "secondusername";
		 data[1][1] = "secondpassword";
		 
		 // 3rd combination - Test case
		 data[2][0] = "thirdusername";
		 data[2][1] = "thirdpassword";
		 
		 return data;
	}

}
