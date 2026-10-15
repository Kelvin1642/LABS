// Reference solution; understand and adapt it before using.
public class Lab03Q04_CreateAnImmutablepersonClass {
    static final class ImmutablePerson { private final String name; private final int age; ImmutablePerson(String name,int age){if(name==null||name.isBlank())throw new IllegalArgumentException("Name required");if(age<0)throw new IllegalArgumentException("Age cannot be negative");this.name=name.trim();this.age=age;} String getName(){return name;} int getAge(){return age;} public String toString(){return name+", age "+age;} }
    public static void main(String[] args){ImmutablePerson p=new ImmutablePerson("Kelvin",20);System.out.println(p);/* final class prevents subclass mutation; final fields and no setters keep state fixed. */}
}
