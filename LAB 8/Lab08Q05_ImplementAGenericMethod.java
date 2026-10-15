// Reference solution; understand and adapt it before using.
public class Lab08Q05_ImplementAGenericMethod {
    static <T extends Comparable<T>> void bubbleSort(T[] values){for(int end=values.length-1;end>0;end--){boolean changed=false;for(int i=0;i<end;i++)if(values[i].compareTo(values[i+1])>0){T t=values[i];values[i]=values[i+1];values[i+1]=t;changed=true;}if(!changed)break;}}
    public static void main(String[] args){Integer[] numbers={7,2,9,1};String[] words={"mate","check","chess"};bubbleSort(numbers);bubbleSort(words);System.out.println(java.util.Arrays.toString(numbers));System.out.println(java.util.Arrays.toString(words));/* Generic type parameters require reference types; use Integer[] rather than int[]. */}
}
