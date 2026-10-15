// Reference solution; understand and adapt it before using.
public class Lab06Q03_BuildAnAbstractClass {
    abstract static class Account { protected double balance; Account(double opening){if(opening<0)throw new IllegalArgumentException();balance=opening;} void deposit(double amount){if(amount<=0)throw new IllegalArgumentException("Deposit must be positive");balance+=amount;} abstract double monthlyFee(); }
    static class SavingsAccount extends Account { SavingsAccount(double b){super(b);} double monthlyFee(){return 2.50;} }
    static class CurrentAccount extends Account { CurrentAccount(double b){super(b);} double monthlyFee(){return 8.00;} }
    public static void main(String[] args){Account[] accounts={new SavingsAccount(100),new CurrentAccount(100)};for(Account a:accounts){a.deposit(25);System.out.printf("balance %.2f; fee %.2f%n",a.balance,a.monthlyFee());}}
}
