package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import keywords.Cart;
import keywords.GenericKeywords;
import keywords.Login;
import keywords.Product;

public class US3Product extends Product{

	public static String test_time;
	public static WebDriver driver;
	static String test_data_file_path = GenericKeywords.test_data_path + "/US3-data.csv";
	
	
	@BeforeTest
	public void testSetUp() {
		GenericKeywords.clearTestOutput(GenericKeywords.test_output_path);
		driver = GenericKeywords.startWebDriver();
		
	}
	
	@Test(description = "Test Case 1 - Add Item To Cart And Assert Results - Positive")
	public void US2testCase1() {
		Login.OpenBrowserAndLogin(driver, "Standard");
		verifyItemInProductPage(driver, test_data_file_path);
		Cart.verifyItemInCartPage(driver, test_data_file_path);
	}
	
	@AfterTest
	public void testTearDown() {
		GenericKeywords.quitWebDriver(driver);
	}
}
