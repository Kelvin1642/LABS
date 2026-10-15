// Reference solution; understand and adapt it before using.
public class Lab07Q02_WriteAMethodThat {
    static int getElement(int[] values,int index){try{return values[index];}catch(ArrayIndexOutOfBoundsException e){System.out.println("Index "+index+" is outside array length "+values.length);return -1;}}
    public static void main(String[] args){int[] scores={86,74,92};System.out.println(getElement(scores,1));System.out.println(getElement(scores,7));}
}
