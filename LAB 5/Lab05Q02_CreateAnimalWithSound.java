// Reference solution; understand and adapt it before using.
public class Lab05Q02_CreateAnimalWithSound {
    static class Animal { String sound(){return "?";} } static class Cat extends Animal {@Override String sound(){return "meow";}} static class Cow extends Animal {@Override String sound(){return "moo";}} static class Duck extends Animal {@Override String sound(){return "quack";}}
    public static void main(String[] args){Animal[] animals={new Cat(),new Cow(),new Duck()};for(Animal a:animals)System.out.println(a.sound());}
}
