// Reference solution; understand and adapt it before using.
public class Lab02Q02_AddAStaticCounter {
    static class Circle { private static int count; private final double radius; Circle(){this(1.0);} Circle(double r){if(r<=0)throw new IllegalArgumentException("Radius must be positive");radius=r;count++;} static int getCount(){return count;} }
    public static void main(String[] args){new Circle();new Circle(2);new Circle(4);System.out.println("Circles created: "+Circle.getCount());}
}
