// Reference solution; understand and adapt it before using.
public class Lab08Q01_Store10IntegersIn {
    public static void main(String[] args){java.util.List<Integer> nums=new java.util.ArrayList<>(java.util.List.of(12,4,27,8,15,2,19,6,11,3));int sum=0;for(int n:nums)sum+=n;System.out.println("Sum: "+sum);System.out.println("Max: "+java.util.Collections.max(nums));java.util.Collections.reverse(nums);System.out.println("Reverse: "+nums);}
}
