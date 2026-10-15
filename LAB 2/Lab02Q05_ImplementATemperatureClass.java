// Reference solution; understand and adapt it before using.
public class Lab02Q05_ImplementATemperatureClass {
    static class Temperature {
        private final double celsius; private Temperature(double c){if(c< -273.15)throw new IllegalArgumentException("Below absolute zero");celsius=c;}
        static Temperature fromCelsius(double c){return new Temperature(c);} static Temperature fromFahrenheit(double f){return new Temperature((f-32)*5/9);}
        double asCelsius(){return celsius;} double asFahrenheit(){return celsius*9/5+32;}
    }
    public static void main(String[] args){Temperature t=Temperature.fromFahrenheit(68);System.out.printf("%.1f C / %.1f F%n",t.asCelsius(),t.asFahrenheit());}
}
