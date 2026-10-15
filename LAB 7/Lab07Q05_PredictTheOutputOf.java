// Reference solution; understand and adapt it before using.
public class Lab07Q05_PredictTheOutputOf {
    static String returnFromTry(){try{return "return value chosen in try";}finally{System.out.println("finally executes before the return completes");}}
    public static void main(String[] args){System.out.println(returnFromTry());}
}
