package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import keywords.GenericKeywords;
import keywords.Login;

public class US2Login extends Login{

	public static String test_time;
	public static WebDriver driver;
	
	
	@BeforeTest
	public void testSetUp() {
		GenericKeywords.clearTestOutput(GenericKeywords.test_output_path);
		driver = GenericKeywords.startWebDriver();
		
	}
	
	@Test(description = "Test Case 1 - Login As Standard User - Positive")
	public void US2testCase1() {
		Login.OpenBrowserAndLogin(driver, "Standard");
	}
	
	@AfterTest
	public void testTearDown() {
		GenericKeywords.quitWebDriver(driver);
	}
}