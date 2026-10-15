// Reference solution; understand and adapt it before using.
public class Lab03Q05_BuildATemperatureClass {
    static class Temperature { private final double kelvin; Temperature(double kelvin){if(kelvin<0)throw new IllegalArgumentException("Kelvin cannot be below zero");this.kelvin=kelvin;} double getCelsius(){return kelvin-273.15;} double getFahrenheit(){return getCelsius()*9/5+32;} }
    public static void main(String[] args){Temperature room=new Temperature(293.15);System.out.printf("%.1f C, %.1f F%n",room.getCelsius(),room.getFahrenheit());try{new Temperature(-1);}catch(IllegalArgumentException e){System.out.println(e.getMessage());}}
}
