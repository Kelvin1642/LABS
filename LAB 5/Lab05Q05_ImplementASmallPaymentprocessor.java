// Reference solution; understand and adapt it before using.
public class Lab05Q05_ImplementASmallPaymentprocessor {
    interface Payment { boolean process(); }
    static class CardPayment implements Payment { final String lastFour; CardPayment(String n){lastFour=n;} public boolean process(){System.out.println("Card ending "+lastFour+" processed");return true;} }
    static class MobileMoneyPayment implements Payment { final String phone; MobileMoneyPayment(String p){phone=p;} public boolean process(){System.out.println("Mobile money sent to "+phone);return true;} }
    static class PaymentProcessor { boolean payUsingTypeCheck(Payment p){if(p instanceof CardPayment c){System.out.println("Card "+c.lastFour);return true;}if(p instanceof MobileMoneyPayment m){System.out.println("Mobile "+m.phone);return true;}throw new IllegalArgumentException("Unsupported payment");} boolean pay(Payment p){return p.process();} }
    public static void main(String[] args){PaymentProcessor processor=new PaymentProcessor();Payment[] options={new CardPayment("652C"),new MobileMoneyPayment("+263771234567")};for(Payment p:options)processor.pay(p);/* Polymorphism lets new payment types add behavior without editing the processor. */}
}
