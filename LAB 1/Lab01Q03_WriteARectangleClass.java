// Reference solution; understand and adapt it before using.
public class Lab01Q03_WriteARectangleClass {
    static class Rectangle {
        double width,height;
        Rectangle(double width,double height){if(width<=0||height<=0)throw new IllegalArgumentException("Dimensions must be positive");this.width=width;this.height=height;}
        double area(){return width*height;} double perimeter(){return 2*(width+height);}
    }
    public static void main(String[] args){
        Rectangle[] rs={new Rectangle(2,5),new Rectangle(4,4),new Rectangle(3,8),new Rectangle(6,2),new Rectangle(5,5)};
        Rectangle largest=rs[0]; for(Rectangle r:rs)if(r.area()>largest.area())largest=r;
        System.out.printf("Largest area: %.1f (perimeter %.1f)%n",largest.area(),largest.perimeter());
    }
}
