// Reference solution; understand and adapt it before using.
public class Lab04Q02_AddATeacherSubclass {
    static class Person { private final String name; private final int age; Person(String n,int a){name=n;age=a;} void display(){System.out.println(name+", age "+age);} }
    static class Student extends Person { private final String course; Student(String n,int a,String c){super(n,a);course=c;} @Override void display(){super.display();System.out.println("Student, course: "+course);} }
    static class Teacher extends Person { private final String subject; Teacher(String n,int a,String s){super(n,a);subject=s;} @Override void display(){super.display();System.out.println("Teacher, subject: "+subject);} }
    public static void main(String[] args){Person[] people={new Student("Kelvin",20,"Computer Science"),new Teacher("Ms Moyo",39,"Java")};for(Person p:people)p.display();}
}
