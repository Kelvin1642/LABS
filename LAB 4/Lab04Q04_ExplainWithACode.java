// Reference solution; understand and adapt it before using.
public class Lab04Q04_ExplainWithACode {
    static class Animal { private final String name; Animal(String name){this.name=name;} String getName(){return name;} }
    static class Dog extends Animal { Dog(String name){super(name);} }
    public static void main(String[] args){Dog dog=new Dog("Rex");System.out.println(dog.getName());/* Without Dog's super(name), Java inserts super(), which fails because Animal has no no-argument constructor. */}
}
