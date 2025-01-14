package keywords;

import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import objectRepository.CartObject;

public class Cart extends CartObject{

    public static void verifyItemInCartPage(WebDriver driver, String data_file_path) {
        
		List<List<String>> item_list = CSVReader.readCSVWithoutHeader(data_file_path);
		
		for (List element : item_list) {
			String itemname = (String) element.get(0);
			String itemprice = (String) element.get(1);
			String itemdesc = (String) element.get(2);
			System.out.println("\n\nItem Name: " + itemname);
			System.out.println("Item Price: " + itemprice);
			System.out.println("Item Desc: " + itemdesc + "\n\n");
			lbl_item_name_cart(driver, itemname).isDisplayed();
			lbl_item_price_cart(driver, itemname, itemprice).isDisplayed();
			String item_desc = lbl_item_desc_cart(driver, itemname).getText();
			assertEquals(item_desc, itemdesc);
		}
    }
}
