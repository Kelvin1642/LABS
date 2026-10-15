// Reference solution; understand and adapt it before using.
public class Lab06Q02_DefineAnInterfaceFlyable {
    interface Flyable { void fly(); }
    static class Bird implements Flyable { public void fly(){System.out.println("Bird flaps its wings");} }
    static class Aeroplane implements Flyable { public void fly(){System.out.println("Aeroplane uses its engines");} }
    public static void main(String[] args){Flyable[] flyers={new Bird(),new Aeroplane()};for(Flyable f:flyers)f.fly();}
}
