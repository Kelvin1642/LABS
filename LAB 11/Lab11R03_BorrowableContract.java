// Reference solution; understand and adapt it before using.
public class Lab11R03_BorrowableContract {
    interface Borrowable { void borrow(String memberName); void giveBack(); }
    static class Copy implements Borrowable { private final String title; private boolean available=true; Copy(String title){this.title=title;} public void borrow(String member){if(!available)throw new IllegalStateException("Item is already borrowed");available=false;System.out.println(member+" borrowed "+title);} public void giveBack(){if(available)throw new IllegalStateException("Item was not borrowed");available=true;System.out.println(title+" returned");} }
    public static void main(String[] args){Copy c=new Copy("Java OOP");c.borrow("Kelvin");c.giveBack();}
}
