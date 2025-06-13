import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.Scanner;
import org.json.JSONObject;

public class CurrencyConverter {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter base currency (e.g., USD): ");
            String base = scanner.nextLine().toUpperCase();

            System.out.print("Enter target currency (e.g., INR): ");
            String target = scanner.nextLine().toUpperCase();

            System.out.print("Enter amount to convert: ");
            double amount = scanner.nextDouble();

            String apiUrl = "https://api.exchangerate-api.com/v4/latest/" + base;

            URL url = URI.create(apiUrl).toURL(); // Modern way
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            StringBuilder response = new StringBuilder();
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            JSONObject obj = new JSONObject(response.toString());
            double rate = obj.getJSONObject("rates").getDouble(target);
            double result = amount * rate;

            System.out.printf("%.2f %s = %.2f %s%n", amount, base, result, target);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
