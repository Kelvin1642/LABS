// Reference solution; understand and adapt it before using.
public class Lab05Q01_OverloadAPrintMethod {
    static void print(int x){System.out.println("int: "+x);} static void print(double x){System.out.println("double: "+x);} static void print(String x){System.out.println("String: "+x);} static void print(int[] xs){System.out.println(java.util.Arrays.toString(xs));}
    public static void main(String[] args){print(7);print(3.14);print("checkmate");print(new int[]{1,2,3});}
}
