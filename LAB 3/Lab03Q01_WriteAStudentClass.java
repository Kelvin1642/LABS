// Reference solution; understand and adapt it before using.
public class Lab03Q01_WriteAStudentClass {
    static class Student { private String name; private int marks; Student(String name,int marks){this.name=name;setMarks(marks);} String getName(){return name;} int getMarks(){return marks;} void setName(String name){if(name==null||name.isBlank())throw new IllegalArgumentException("Name required");this.name=name.trim();} void setMarks(int marks){if(marks<0||marks>100)throw new IllegalArgumentException("Marks must be 0..100");this.marks=marks;} }
    public static void main(String[] args){Student s=new Student("Kelvin",86);System.out.println(s.getName()+": "+s.getMarks());try{s.setMarks(140);}catch(IllegalArgumentException e){System.out.println(e.getMessage());}}
}
