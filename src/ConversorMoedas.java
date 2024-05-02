import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;
import java.util.Scanner;

public class ConversorMoedas {
    private static final String API_KEY = "f5e655e2585880aa52eda52d";
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/";

    public static void converterMoeda(String from, String to) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nDigite o valor que deseja converter:");
        double valueInput = scanner.nextDouble();

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL + from))
                .build();

        Gson gson = new Gson();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                ExchangeRateData data = gson.fromJson(response.body(), ExchangeRateData.class);
                Map<String, Double> conversionRates = data.getConversion_rates();
                if (conversionRates.containsKey(to)) {
                    double tax = conversionRates.get(to);
                    double convertedValue = valueInput * tax;
                    String responseResult = String.format("\n%.2f %s corresponde ao valor final de %.2f %s\n", valueInput, from, convertedValue, to);
                    System.out.println(responseResult);
                } else {
                    System.out.println("Código de moeda inválido. Por favor, tente novamente.");
                }
            } else {
                System.out.println("Erro ao obter dados da taxa de câmbio.");
            }
        } catch (IOException | InterruptedException e) {
            System.out.println("Erro ao fazer request no client");
        }
    }
}
