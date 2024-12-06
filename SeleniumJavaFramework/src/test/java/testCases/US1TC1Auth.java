package testCases;


import keywords.GenericKeywords;
import keywords.Auth;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class US1TC1Auth extends Auth{
	
	static String test_data_file_name = "/role-credential.csv";
	static String positive_json_schema_file_name = "/US1TC1-positive-json-schema.json";
	static String negative_json_schema_file_name = "/US1TC1-negative-json-schema.json";
	
	@BeforeTest
	public void testSetUp() {
		GenericKeywords.clearTestOutput(GenericKeywords.test_output_path);
	}
	
	@DataProvider(name = "csvDataProvider")
    public Iterator<Object[]> getCsvData() throws IOException {
        String csvFilePath = GenericKeywords.test_data_path + test_data_file_name; // Update with your CSV file path
        List<Object[]> data = new ArrayList<>();

        try (FileReader fileReader = new FileReader(csvFilePath);
             CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT.withHeader())) { // Use this to set the first row as header

            for (CSVRecord record : csvParser) {
                String testCaseName = record.get("test_case_name"); // Use the header column name
                // Add other columns as needed
                data.add(new Object[]{testCaseName, record});
            }
        }

        return data.iterator();
    }

    @Test(dataProvider = "csvDataProvider")
    public void US1testWithCsvData(String testCaseName, CSVRecord record) {
        System.out.println("Running test: " + testCaseName);
        String username = record.get("username");
        String password = record.get("password");
        String role = record.get("role");
        String responseBody = authAPI(username, password);
        if (role.equals("Invalid")) {
	        GenericKeywords.validateJsonSchema(negative_json_schema_file_name, responseBody);
		} else {
	        GenericKeywords.validateJsonSchema(positive_json_schema_file_name, responseBody);
		}
        validateResponse(responseBody, role);
    }
}
