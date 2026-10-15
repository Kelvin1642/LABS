// Reference solution; understand and adapt it before using.
public class Lab06Q01_CreateAnAbstractShape {
    abstract static class Shape { abstract double area(); abstract double perimeter(); }
    static class Circle extends Shape { final double r; Circle(double r){if(r<=0)throw new IllegalArgumentException();this.r=r;} double area(){return Math.PI*r*r;} double perimeter(){return 2*Math.PI*r;} }
    static class Rectangle extends Shape { final double w,h; Rectangle(double w,double h){this.w=w;this.h=h;} double area(){return w*h;} double perimeter(){return 2*(w+h);} }
    static class Square extends Rectangle { Square(double side){super(side,side);} }
    public static void main(String[] args){Shape[] shapes={new Circle(2),new Rectangle(3,4),new Square(5)};for(Shape s:shapes)System.out.printf("%s area %.2f perimeter %.2f%n",s.getClass().getSimpleName(),s.area(),s.perimeter());}
}
