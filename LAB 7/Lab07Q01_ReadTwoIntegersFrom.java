// Reference solution; understand and adapt it before using.
public class Lab07Q01_ReadTwoIntegersFrom {
    public static void main(String[] args){try(java.util.Scanner in=new java.util.Scanner(System.in)){try{System.out.print("Numerator: ");int a=in.nextInt();System.out.print("Denominator: ");int b=in.nextInt();System.out.println("Result: "+(a/b));}catch(java.util.InputMismatchException e){System.out.println("Please enter whole numbers.");}catch(ArithmeticException e){System.out.println("Cannot divide by zero.");}}}
}
