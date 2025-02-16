package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import keywords.GenericKeywords;

public class LoginObject {
	
	static WebElement element = null;
	public static String login_url = "https://www.saucedemo.com/";
	
	public static WebElement btn_login_login(WebDriver driver) {
		
		By locator = By.id("login-button");
		element = GenericKeywords.pageShouldContainElement(driver, locator);
		return element;
	}

	public static WebElement lbl_header_login(WebDriver driver) {
		
		By locator = By.xpath("//div[@class='login_logo']");
		element = GenericKeywords.pageShouldContainElement(driver, locator);
		return element;
	}
	
	public static WebElement lbl_verify_header_successful_login(WebDriver driver) {
		
		By locator = By.xpath("//span[@class='title']");
		element = GenericKeywords.pageShouldContainElement(driver, locator);
		return element;
	}

	public static WebElement input_username_login(WebDriver driver) {
		
		By locator = By.id("user-name");
		element = GenericKeywords.pageShouldContainElement(driver, locator);
		return element;
	}
	
	public static WebElement input_password_login(WebDriver driver) {
		
		By locator = By.id("password");
		element = GenericKeywords.pageShouldContainElement(driver, locator);
		return element;
	}
}
