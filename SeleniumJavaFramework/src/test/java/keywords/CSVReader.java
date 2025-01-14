package keywords;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.File;
import java.io.FileNotFoundException;

public class CSVReader {

    public static Map<String, String> getCredentials(String role, String filePath){
        Map<String, String> credentials = new HashMap<>();
        try (CSVParser csvParser = new CSVParser(new FileReader(filePath), CSVFormat.DEFAULT.withHeader())) {
            for (CSVRecord record : csvParser) {
                if (record.get("role").equals(role)) {
                    credentials.put("username", record.get("username"));
                    credentials.put("password", record.get("password"));
                    break;
                }
            }
        } catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AssertionError(e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AssertionError(e);
		}
        return credentials;
    }
    
    public static List<List<String>> readCSVWithoutHeader(String filePath) {
        List<List<String>> data = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",", -1); // Split values
                List<String> row = new ArrayList<>();
                for (String value : values) {
                	value = value.replace(":comma", ",");
                    row.add(value.trim());
                }
                data.add(row);
            }
        } catch (IOException e) {
			throw new AssertionError(e.getMessage());
        }
        data.remove(0);
        return data;
    }
}
