import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CurrencyService {
    // URL completa da API já configurada
    private static final String API_BASE_URL = "https://v6.exchangerate-api.com/v6/7b9905b9b448a7971959d152/latest/";
    private final HttpClient client;
    private final Gson gson;
    
    public CurrencyService() {
        this.client = HttpClient.newHttpClient();
        this.gson = new Gson();
    }
    
    public double getExchangeRate(String fromCurrency, String toCurrency) throws IOException, InterruptedException {
        // Construir URL completa: https://v6.exchangerate-api.com/v6/7b9905b9b448a7971959d152/latest/USD
        String url = API_BASE_URL + fromCurrency.toUpperCase();
        
        System.out.println("Consultando API: " + url);
        
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Accept", "application/json")
                .GET()
                .build();
        
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        
        if (response.statusCode() == 200) {
            ExchangeRateResponse exchangeResponse = gson.fromJson(response.body(), ExchangeRateResponse.class);
            
            if (exchangeResponse.getConversionRates() != null) {
                Double rate = exchangeResponse.getConversionRates().get(toCurrency.toUpperCase());
                if (rate != null) {
                    return rate;
                } else {
                    throw new IllegalArgumentException("Moeda de destino não encontrada: " + toCurrency);
                }
            } else {
                throw new IOException("Resposta da API inválida");
            }
        } else {
            throw new IOException("Erro na API: " + response.statusCode() + " - " + response.body());
        }
    }
    
    public double convertCurrency(double amount, String fromCurrency, String toCurrency) 
            throws IOException, InterruptedException {
        double rate = getExchangeRate(fromCurrency, toCurrency);
        return amount * rate;
    }
    
    // Método para testar conectividade com a API
    public void testConnection() throws IOException, InterruptedException {
        String testUrl = API_BASE_URL + "USD";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(testUrl))
                .GET()
                .build();
        
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("Teste de conexão - Status: " + response.statusCode());
        
        if (response.statusCode() == 200) {
            System.out.println("✅ Conexão com API funcionando perfeitamente!");
        } else {
            System.out.println("❌ Problema na conexão: " + response.body());
        }
    }
}