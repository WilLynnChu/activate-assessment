package keywords;
import java.util.Map;
import objectRepository.APIObject;

public class Booking{
    
    public static String updateBooking(String token, String firstname, String lastname, String additionalneeds, String checkin, String checkout, String totalprice, String depositpaid) {
    	Map<String, String> api_request_payload = GenericKeywords.createDictionary();
    	api_request_payload = GenericKeywords.addToDictionary(api_request_payload, "firstname", firstname);
    	api_request_payload = GenericKeywords.addToDictionary(api_request_payload, "lastname", lastname);
    	api_request_payload = GenericKeywords.addToDictionary(api_request_payload, "additionalneeds", additionalneeds);
    	Map<String, String> bookingdates = GenericKeywords.createDictionary();
    	bookingdates = GenericKeywords.addToDictionary(bookingdates, "checkin", checkin);
    	bookingdates = GenericKeywords.addToDictionary(bookingdates, "checkout", checkout);
    	String bookingdates_string = APIHelper.convertDictToJsonString(bookingdates);
    	api_request_payload = GenericKeywords.addToDictionary(api_request_payload, "bookingdates", bookingdates_string);
    	api_request_payload = GenericKeywords.addToDictionary(api_request_payload, "totalprice", totalprice);
    	api_request_payload = GenericKeywords.addToDictionary(api_request_payload, "depositpaid", depositpaid);
    	String json_payload_string = APIHelper.convertDictToJsonString(api_request_payload);
    	String requestBody = APIHelper.putAPI(APIObject.update_booking_api + "/1", json_payload_string, token, null);
    	return requestBody;
    }
}
