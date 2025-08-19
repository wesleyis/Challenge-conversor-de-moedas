public class ExchangeRateResponse {
    private String base_code;
    private java.util.Map<String, Double> conversion_rates;
    
    // Getters e Setters
    public String getBaseCode() {
        return base_code;
    }
    
    public void setBaseCode(String base_code) {
        this.base_code = base_code;
    }
    
    public java.util.Map<String, Double> getConversionRates() {
        return conversion_rates;
    }
    
    public void setConversionRates(java.util.Map<String, Double> conversion_rates) {
        this.conversion_rates = conversion_rates;
    }
}