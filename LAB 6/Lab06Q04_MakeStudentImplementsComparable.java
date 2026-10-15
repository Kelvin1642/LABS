// Reference solution; understand and adapt it before using.
public class Lab06Q04_MakeStudentImplementsComparable {
    static class Student implements Comparable<Student> { final String name; final int marks; Student(String n,int m){name=n;marks=m;} public int compareTo(Student other){return name.compareToIgnoreCase(other.name);} public String toString(){return name+" ("+marks+")";} }
    public static void main(String[] args){java.util.List<Student> students=new java.util.ArrayList<>(java.util.List.of(new Student("Tariro",78),new Student("Kelvin",86),new Student("Farai",91)));java.util.Collections.sort(students);System.out.println("By name: "+students);students.sort(java.util.Comparator.comparingInt((Student s)->s.marks).reversed());System.out.println("By marks: "+students);}
}
