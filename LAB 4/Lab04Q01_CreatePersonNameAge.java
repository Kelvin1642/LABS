// Reference solution; understand and adapt it before using.
public class Lab04Q01_CreatePersonNameAge {
    static class Person { private final String name; private final int age; Person(String n,int a){name=n;age=a;} void display(){System.out.println(name+", age "+age);} }
    static class Student extends Person { private final String course; Student(String n,int a,String c){super(n,a);course=c;} void display(){super.display();System.out.println("Course: "+course);} }
    public static void main(String[] args){new Student("Kelvin",20,"Computer Science").display();}
}
