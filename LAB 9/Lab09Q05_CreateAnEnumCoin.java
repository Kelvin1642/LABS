// Reference solution; understand and adapt it before using.
public class Lab09Q05_CreateAnEnumCoin {
    enum Coin { PENNY(1),NICKEL(5),DIME(10),QUARTER(25); final int cents; Coin(int c){cents=c;} }
    static java.util.Map<Coin,Integer> fewestCoins(int amount){if(amount<0)throw new IllegalArgumentException("Amount cannot be negative");java.util.Map<Coin,Integer> result=new java.util.LinkedHashMap<>();for(Coin c:new Coin[]{Coin.QUARTER,Coin.DIME,Coin.NICKEL,Coin.PENNY}){int n=amount/c.cents;if(n>0){result.put(c,n);amount%=c.cents;}}return result;}
    public static void main(String[] args){int cents=87;System.out.println(cents+" cents: "+fewestCoins(cents));}
}
