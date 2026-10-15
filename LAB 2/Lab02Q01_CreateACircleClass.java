// Reference solution; understand and adapt it before using.
public class Lab02Q01_CreateACircleClass {
    static class Circle { private final double radius; Circle(){this(1.0);} Circle(double radius){if(radius<=0)throw new IllegalArgumentException("Radius must be positive");this.radius=radius;} double area(){return Math.PI*radius*radius;} }
    public static void main(String[] args){System.out.printf("Default area %.2f%n",new Circle().area());System.out.printf("Radius 3 area %.2f%n",new Circle(3).area());}
}
