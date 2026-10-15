// Reference solution; understand and adapt it before using.
public class Lab01Q01_CreateACarClass {
    static class Car {
        String brand; int year; double mileage;
        Car(String brand, int year, double mileage) { this.brand=brand; this.year=year; this.mileage=mileage; }
        void display() { System.out.printf("%s (%d), %.0f km%n", brand, year, mileage); }
    }
    public static void main(String[] args) {
        Car[] cars={new Car("BMW M4",2022,18000),new Car("Toyota Corolla",2018,64000),new Car("Honda Civic",2020,39000)};
        for(Car car:cars) car.display();
    }
}
