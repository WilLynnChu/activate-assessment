package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import keywords.GenericKeywords;

public class ProductObject {
	
	static WebElement element = null;
	public static String login_url = "https://www.saucedemo.com/";

	public static WebElement lbl_item_name_product(WebDriver driver, String itemname) {
		
		By locator = By.xpath("//div[@class='inventory_item_name ' and text()='" + itemname + "']");
		element = GenericKeywords.pageShouldContainElement(driver, locator);
		return element;
		
	}
	
	public static WebElement lbl_item_price_product(WebDriver driver, String itemname, String itemprice) {
		
		By locator = By.xpath("//div[@class='inventory_item_name ' and text()='" + itemname + "']/ancestor::div[@class='inventory_item_description']/descendant::div[@class='inventory_item_price' and normalize-space()='" + itemprice + "']");
		element = GenericKeywords.pageShouldContainElement(driver, locator);
		return element;
		
	}
	
	public static WebElement btn_add_to_cart_product(WebDriver driver, String itemname) {
		
		By locator = By.xpath("//div[@class='inventory_item_name ' and text()='" + itemname + "']/ancestor::div[@class='inventory_item_description']/descendant::button[contains(@id, 'add-to-cart')]");
		element = GenericKeywords.pageShouldContainElement(driver, locator);
		return element;
	}
	
	public static WebElement btn_view_cart_product(WebDriver driver) {
		
		By locator = By.xpath("//a[@class='shopping_cart_link']");
		element = GenericKeywords.pageShouldContainElement(driver, locator);
		return element;
	}
	
}
