// Reference solution; understand and adapt it before using.
public class Lab10Q02_UseAPredicateAnd {
    public static void main(String[] args){java.util.List<Integer> values=new java.util.ArrayList<>(java.util.List.of(1,2,3,4,5,6,7,8));java.util.function.Predicate<Integer> even=n->n%2==0;values.removeIf(even);System.out.println(values);}
}
