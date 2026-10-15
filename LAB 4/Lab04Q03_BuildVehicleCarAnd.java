// Reference solution; understand and adapt it before using.
public class Lab04Q03_BuildVehicleCarAnd {
    static class Vehicle { Vehicle(){System.out.println("Vehicle constructor");} }
    static class Car extends Vehicle { Car(){System.out.println("Car constructor");} }
    static class ElectricCar extends Car { ElectricCar(){System.out.println("ElectricCar constructor");} }
    public static void main(String[] args){new ElectricCar();}
}
