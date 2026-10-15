// Reference solution; understand and adapt it before using.
public class Lab01Q04_PredictThenRunA {
    static class Rectangle { double width,height; Rectangle(double w,double h){width=w;height=h;} }
    public static void main(String[] args){
        Rectangle r1=new Rectangle(4,3); Rectangle r2=r1; r2.width=9;
        System.out.println("r1.width = "+r1.width); // 9: both references point to the same object
    }
}
