package keywords;

import static org.testng.Assert.assertEquals;
import java.util.Map;
import objectRepository.APIObject;

public class Auth{
    
    public static String authAPI(String username, String password) {
    	Map<String, String> api_request_payload = GenericKeywords.createDictionary();
    	api_request_payload = GenericKeywords.addToDictionary(api_request_payload, "username", username);
    	api_request_payload = GenericKeywords.addToDictionary(api_request_payload, "password", password);
    	String json_payload_string = APIHelper.convertDictToJsonString(api_request_payload);
    	String requestBody = APIHelper.postAPI(APIObject.auth_api, json_payload_string, "200");
    	return requestBody;
    }
    
    public static void validateResponse(String responseBody, String role) {
    	String key = "";
    	String message = "";
    	if (role.equals("Invalid")) {
    		key = "reason";
    		String expectedMsg = "Bad credentials";
        	message = APIHelper.extractResponseBodyByKey(responseBody, key);
      	    System.out.println("Expected Message: " + expectedMsg);
      	    System.out.println("Actual Message: " + message);
      	    assertEquals(message, expectedMsg);
    	} else {
    		key = "token";
        	message = APIHelper.extractResponseBodyByKey(responseBody, key);
    	}
	}
    
    public static String getAuthToken() {
    	String token;
    	Map<String, String> credentials = CSVReader.getCredentials("Admin", GenericKeywords.test_data_path + "/role-credential.csv");
    	String response = authAPI(credentials.get("username"), credentials.get("password"));
    	token = APIHelper.extractResponseBodyByKey(response, "token");
		return token;
    }
}
