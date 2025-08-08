import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

/// Hacer la llamada HTTP
///
/// Leer la respuesta JSON
///
/// Extraer la tasa de cambio
///
/// Devolverla al Conversor.java para su uso

public class ExchangerateAPI{
    private static final String DireccionAPI = "https://v6.exchangerate-api.com/v6/e1afe7e675242ffaf3b5a1bf/latest/USD";

    public static class ExchangeRateResponse {
        public Map<String, Double> conversion_rates;
    }
    public static double getRate(String targetCurrency) {
        try {
            // Cliente HTTP
            HttpClient client = HttpClient.newHttpClient();

            // Solicitud GET
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(DireccionAPI))
                    .build();

            // Respuesta
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Convertir JSON a objeto Java
            Gson gson = new Gson();
            ExchangeRateResponse exchange = gson.fromJson(response.body(), ExchangeRateResponse.class);
            return  exchange.conversion_rates.getOrDefault(targetCurrency, -1.0);


        } catch (IOException |InterruptedException e) {
            System.out.println("Error al obtener la tasa de cambio: " + e.getMessage());
            return -1;
        }
        }

    }









