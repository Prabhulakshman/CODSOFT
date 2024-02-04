package Task4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;
import org.json.JSONObject;

public class Currency_Converter {
    public static void main(String[] args) throws IOException {
        HashMap<Integer, String> currency_code = new HashMap<>();
        currency_code.put(1, "INR");
        currency_code.put(2, "USD");
        currency_code.put(3, "CAD");
        currency_code.put(4, "EUR");
        currency_code.put(5, "HKD");

        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to the Currency Converter :) ");
        System.out.println("Enter amount to be converted: ");
        double amount = scan.nextDouble();

        System.out.println("Choose the Base Currency from the list given: ");
        System.out.println("1. INR\t2. USD\t3. CAD\t4. EUR\t5. HKD");
        String base_currency = currency_code.get(scan.nextInt());
        System.out.println("Choose the Target Currency from the list: ");
        String target_currency = currency_code.get(scan.nextInt());

        sendHttpGETRequest(base_currency, target_currency, amount);
        System.out.println("Thank You for using Current Converter ");
    }
    //Add JSON.jar file By clicking Project (Right)>Build Path>Configure>Add Library>ADD External Jar file to the ClassPath
    private static void sendHttpGETRequest(String base_currency, String target_currency, double amount) throws IOException {
    	//Add Decimal Formatter
    	DecimalFormat f=new DecimalFormat("00.00");
        String GET_URL = "http://api.exchangeratesapi.io/v1/latest?access_key=1fcd207ea32d0a400456efb53f58b341&format=1?base=" + base_currency + "&symbols=" + target_currency;
        URL url = new URL(GET_URL);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod("GET");

        int responseCode = httpURLConnection.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_OK) {
            // Success
            BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // Adjusted JSON parsing
            JSONObject obj = new JSONObject(response.toString());

            // Extracting the exchange rate correctly
            double exchangeRate = obj.getJSONObject("rates").getDouble(target_currency);

            // Displaying the result
            System.out.println(f.format(amount) + " " + base_currency + " = " + f.format(amount * exchangeRate) + " " + target_currency);
        } else {
            System.out.println("GET Request Failed with response code: " + responseCode);
        }
    }
}
