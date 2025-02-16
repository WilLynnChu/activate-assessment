package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import keywords.GenericKeywords;

public class CartObject {
	
	static WebElement element = null;
	public static String login_url = "https://www.saucedemo.com/";

	public static WebElement lbl_header_cart(WebDriver driver) {
		
		By locator = By.xpath("//span[@class='title' and text()='Your Cart']");
		element = GenericKeywords.pageShouldContainElement(driver, locator);
		return element;
	}
	
	public static WebElement lbl_item_name_cart(WebDriver driver, String itemname) {
		
		By locator = By.xpath("//div[@class='inventory_item_name' and text()='" + itemname + "']");
		element = GenericKeywords.pageShouldContainElement(driver, locator);
		return element;
		
	}
	
	public static WebElement lbl_item_price_cart(WebDriver driver, String itemname, String itemprice) {
		
		By locator = By.xpath("//div[@class='inventory_item_name' and text()='" + itemname + "']/ancestor::div[@class='cart_item_label']/descendant::div[@class='inventory_item_price' and normalize-space()='" + itemprice + "']");
		element = GenericKeywords.pageShouldContainElement(driver, locator);
		return element;
		
	}
	
	public static WebElement lbl_item_desc_cart(WebDriver driver, String itemname) {
		
		By locator = By.xpath("//div[@class='inventory_item_name' and text()='" + itemname + "']/ancestor::div[@class='cart_item_label']/descendant::div[@class='inventory_item_desc']");
		element = GenericKeywords.pageShouldContainElement(driver, locator);
		return element;
		
	}
}
