package adapter;

interface ConversorTemperatura {
    double celsiusParaFahrenheit(double celsius);
    double fahrenheitParaCelsius(double fahrenheit);
}

class ConversorCelsius {
    public double converterParaFahrenheit(double celsius) {
        return (celsius * 9/5) + 32;
    }
}

class AdaptadorConversorTemperatura implements ConversorTemperatura {
    private ConversorCelsius conversorExistente;
    
    public AdaptadorConversorTemperatura() {
        this.conversorExistente = new ConversorCelsius();
    }
    
    @Override
    public double celsiusParaFahrenheit(double celsius) {
        
        return conversorExistente.converterParaFahrenheit(celsius);
    }
    
    @Override
    public double fahrenheitParaCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5/9;
    }
}

public class Resp_Adapter_Temperatura {
    public static void main(String[] args) {
        ConversorTemperatura conversor = new AdaptadorConversorTemperatura();
        
        System.out.println("=== Teste do Conversor de Temperatura ===");

        double f1 = conversor.celsiusParaFahrenheit(0);
        double f2 = conversor.celsiusParaFahrenheit(100);
        System.out.println("0°C = " + f1 + "°F");
        System.out.println("100°C = " + f2 + "°F");

        double c1 = conversor.fahrenheitParaCelsius(32);
        double c2 = conversor.fahrenheitParaCelsius(212);
        System.out.println("32°F = " + c1 + "°C");
        System.out.println("212°F = " + c2 + "°C");
    }
}
