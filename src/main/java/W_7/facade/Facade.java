package W_7.facade;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Facade {
    public static String getAttributeValueFromJson(String urlString, String attributeName) throws IllegalArgumentException, IOException {
        URL url = new URL(urlString);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(content.toString());
            Object value = jsonObject.get(attributeName);

            return value.toString();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        } finally {
            con.disconnect();
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println("getAttributeValueFromJson(\"https://api.chucknorris.io/jokes/random\", \"value\")");
        System.out.println(getAttributeValueFromJson("https://api.chucknorris.io/jokes/random", "value"));

        System.out.println("\ngetAttributeValueFromJson(\"https://api.chucknorris.io/jokes/random\", \"value\")");
        System.out.println(getAttributeValueFromJson("https://api.chucknorris.io/jokes/random", "value"));

        System.out.println("\ngetAttributeValueFromJson(\"https://api.chucknorris.io/jokes/random\", \"value\")");
        System.out.println(getAttributeValueFromJson("https://api.chucknorris.io/jokes/random", "value"));

        System.out.println("\ngetAttributeValueFromJson(\"https://api.fxratesapi.com/latest\", \"rates\"");
        System.out.println(getAttributeValueFromJson("https://api.fxratesapi.com/latest", "rates"));
    }
}
