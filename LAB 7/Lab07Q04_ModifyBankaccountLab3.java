// Reference solution; understand and adapt it before using.
public class Lab07Q04_ModifyBankaccountLab3 {
    static class InsufficientFundsException extends Exception { InsufficientFundsException(double balance,double requested){super("Balance $"+balance+" is below requested withdrawal $"+requested);} }
    static class BankAccount { private double balance; BankAccount(double b){if(b<0)throw new IllegalArgumentException();balance=b;} void withdraw(double amount) throws InsufficientFundsException {if(amount<=0)throw new IllegalArgumentException("Amount must be positive");if(amount>balance)throw new InsufficientFundsException(balance,amount);balance-=amount;} double getBalance(){return balance;} }
    public static void main(String[] args){BankAccount a=new BankAccount(100);try{a.withdraw(25);a.withdraw(200);}catch(InsufficientFundsException e){System.out.println(e.getMessage());}System.out.println("Balance remains $"+a.getBalance());/* Checked exceptions force callers to handle expected failure; returning false is simpler for routine decisions. */}
}
