package tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Basics {
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("Method executed before any of the ones contained in the class");
	}
	
	@AfterTest
	public void lastExecution() {
		System.out.println("I will execute this method last");
	}

	@Parameters({"URL","APIKey/username"})
	@Test(groups = {"Smoke"})
	public void demo(String urlName, String key) {
		System.out.println("TestNG test without Java compiler");
		System.out.println(urlName);
		System.out.println(key);
		Assert.assertTrue(false);
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("Last test to be executed after the Suite");
	}
	
	@Test
	public void secondTest() {
		System.out.println("bye");
	}
	
	@BeforeTest
	public void prerequisite() {
		System.out.println("I will execute this method first");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("Method executed after all the methods contained in the class");
	}
	
}
