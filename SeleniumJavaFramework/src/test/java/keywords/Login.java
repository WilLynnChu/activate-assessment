package keywords;

import org.openqa.selenium.WebDriver;
import java.util.Map;
import objectRepository.LoginObject;

public class Login extends LoginObject{

    public static void OpenBrowserAndLogin(WebDriver driver, String role) {
        driver.get(login_url);
        
        // Get credentials for the specified role
		Map<String, String> credentials = CSVReader.getCredentials(role, GenericKeywords.test_data_path + "/login-credential.csv");
//            Thread.sleep(10000);
		if (!credentials.isEmpty()) {
		    // Find elements and perform login actions
		    if (lbl_header_login(driver).isDisplayed()) {
		        input_username_login(driver).sendKeys(credentials.get("username"));
		        input_password_login(driver).sendKeys(credentials.get("password"));
		        btn_login_login(driver).click();
		    }
		    lbl_verify_header_successful_login(driver).isDisplayed();
		} else {
		    System.out.println("Credentials not found for the specified role.");
		}
    }
}
