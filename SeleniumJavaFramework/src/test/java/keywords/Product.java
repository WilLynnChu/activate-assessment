package keywords;

import org.openqa.selenium.WebDriver;

import java.util.List;
import objectRepository.ProductObject;

public class Product extends ProductObject{

    public static void verifyItemInProductPage(WebDriver driver, String data_file_path) {
        
        // Get credentials for the specified role
		List<List<String>> item_list = CSVReader.readCSVWithoutHeader(data_file_path);
		
		for (List<String> element : item_list) {
			String itemname = (String) element.get(0);
			String itemprice = (String) element.get(1);
			String itemdesc = (String) element.get(2);
			System.out.println("\n\nItem Name: " + itemname);
			System.out.println("Item Price: " + itemprice);
			System.out.println("Item Desc: " + itemdesc + "\n\n");
			lbl_item_name_product(driver, itemname).isDisplayed();
			lbl_item_price_product(driver, itemname, itemprice).isDisplayed();
			btn_add_to_cart_product(driver, itemname).click();
			btn_view_cart_product(driver).click();
		}
    }
}
