// Reference solution; understand and adapt it before using.
public class Lab09Q02_CreateARecordStudent {
    record Student(String name,int age) {}
    public static void main(String[] args){Student a=new Student("Kelvin",20),b=new Student("Kelvin",20);System.out.println(a);System.out.println("Equal values: "+a.equals(b));System.out.println("Name component: "+a.name());}
}
