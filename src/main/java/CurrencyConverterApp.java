import java.io.IOException;
import java.util.Scanner;

public class CurrencyConverterApp {
    private final CurrencyService currencyService;
    private final Scanner scanner;
    
    public CurrencyConverterApp() {
        this.currencyService = new CurrencyService();
        this.scanner = new Scanner(System.in);
    }
    
    public void start() {
        System.out.println("=== CONVERSOR DE MOEDAS ===");
        System.out.println("Bem-vindo ao conversor de moedas!");
        System.out.println("API: https://v6.exchangerate-api.com/v6/7b9905b9b448a7971959d152/latest/");
        
        // Teste de conexão inicial
        try {
            System.out.println("\nTestando conexão com a API...");
            currencyService.testConnection();
        } catch (Exception e) {
            System.out.println("⚠️  Aviso: Problema na conexão inicial: " + e.getMessage());
        }
        
        while (true) {
            try {
                displayMenu();
                int option = getIntInput("Escolha uma opção: ");
                
                switch (option) {
                    case 1:
                        performConversion();
                        break;
                    case 2:
                        showSupportedCurrencies();
                        break;
                    case 3:
                        testApiConnection();
                        break;
                    case 4:
                        System.out.println("Obrigado por usar o conversor! Até logo!");
                        return;
                    default:
                        System.out.println("Opção inválida! Tente novamente.\n");
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage() + "\n");
            }
        }
    }
    
    private void displayMenu() {
        System.out.println("\n--- MENU ---");
        System.out.println("1. Converter moedas");
        System.out.println("2. Ver moedas suportadas");
        System.out.println("3. Testar conexão da API");
        System.out.println("4. Sair");
    }
    
    private void performConversion() throws IOException, InterruptedException {
        System.out.println("\n--- CONVERSÃO DE MOEDAS ---");
        
        String fromCurrency = getStringInput("Digite a moeda de origem (ex: USD, EUR, BRL): ").toUpperCase();
        String toCurrency = getStringInput("Digite a moeda de destino (ex: USD, EUR, BRL): ").toUpperCase();
        double amount = getDoubleInput("Digite o valor a ser convertido: ");
        
        System.out.println("Processando...");
        
        double convertedAmount = currencyService.convertCurrency(amount, fromCurrency, toCurrency);
        double exchangeRate = currencyService.getExchangeRate(fromCurrency, toCurrency);
        
        System.out.printf("\n=== RESULTADO DA CONVERSÃO ===\n");
        System.out.printf("Valor original: %.2f %s\n", amount, fromCurrency);
        System.out.printf("Taxa de câmbio: 1 %s = %.6f %s\n", fromCurrency, exchangeRate, toCurrency);
        System.out.printf("Valor convertido: %.2f %s\n", convertedAmount, toCurrency);
        System.out.println("================================\n");
        
        // Perguntar se quer fazer outra conversão
        String continueOption = getStringInput("Deseja fazer outra conversão? (s/n): ");
        if (continueOption.toLowerCase().startsWith("s")) {
            performConversion();
        }
    }
    
    private void showSupportedCurrencies() {
        System.out.println("\n--- ALGUMAS MOEDAS SUPORTADAS ---");
        System.out.println("USD - Dólar Americano");
        System.out.println("EUR - Euro");
        System.out.println("BRL - Real Brasileiro");
        System.out.println("GBP - Libra Esterlina");
        System.out.println("JPY - Iene Japonês");
        System.out.println("CAD - Dólar Canadense");
        System.out.println("AUD - Dólar Australiano");
        System.out.println("CHF - Franco Suíço");
        System.out.println("CNY - Yuan Chinês");
        System.out.println("INR - Rupia Indiana");
        System.out.println("MXN - Peso Mexicano");
        System.out.println("ARS - Peso Argentino");
        System.out.println("KRW - Won Sul-Coreano");
        System.out.println("ZAR - Rand Sul-Africano");
        System.out.println("\n* E muitas outras! Total: 168+ moedas suportadas\n");
    }
    
    private void testApiConnection() {
        System.out.println("\n--- TESTE DE CONEXÃO ---");
        try {
            currencyService.testConnection();
            
            // Teste prático com USD para BRL
            System.out.println("\nTeste prático: Convertendo 1 USD para BRL...");
            double rate = currencyService.getExchangeRate("USD", "BRL");
            System.out.printf("Taxa atual: 1 USD = %.4f BRL\n", rate);
            System.out.println("✅ API funcionando perfeitamente!\n");
            
        } catch (Exception e) {
            System.out.println("❌ Erro na conexão: " + e.getMessage() + "\n");
        }
    }
    
    private String getStringInput(String message) {
        System.out.print(message);
        return scanner.nextLine().trim();
    }
    
    private int getIntInput(String message) {
        while (true) {
            try {
                System.out.print(message);
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Por favor, digite um número válido!");
            }
        }
    }
    
    private double getDoubleInput(String message) {
        while (true) {
            try {
                System.out.print(message);
                return Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Por favor, digite um valor numérico válido!");
            }
        }
    }
    
    public static void main(String[] args) {
        new CurrencyConverterApp().start();
    }
}