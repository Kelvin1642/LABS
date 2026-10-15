// Reference solution; understand and adapt it before using.
public class Lab01Q02_AddAMethodIsantique {
    static class Car {
        String brand; int year; double mileage;
        Car(String brand,int year,double mileage){this.brand=brand;this.year=year;this.mileage=mileage;}
        boolean isAntique(){return java.time.Year.now().getValue()-year>25;}
        void display(){System.out.printf("%s %d, %.0f km, antique=%s%n",brand,year,mileage,isAntique());}
    }
    public static void main(String[] args){new Car("BMW M4",2022,18000).display();new Car("Classic coupe",1998,120000).display();}
}
