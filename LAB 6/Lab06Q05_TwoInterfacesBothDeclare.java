// Reference solution; understand and adapt it before using.
public class Lab06Q05_TwoInterfacesBothDeclare {
    interface First { default void hello(){System.out.println("Hello from First");} }
    interface Second { default void hello(){System.out.println("Hello from Second");} }
    static class Greeting implements First,Second { public void hello(){First.super.hello();Second.super.hello();System.out.println("Conflict resolved in Greeting");} }
    public static void main(String[] args){new Greeting().hello();}
}
