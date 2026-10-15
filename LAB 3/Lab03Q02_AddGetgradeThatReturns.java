// Reference solution; understand and adapt it before using.
public class Lab03Q02_AddGetgradeThatReturns {
    static class Student { private final String name; private int marks; Student(String n,int m){name=n;setMarks(m);} void setMarks(int m){if(m<0||m>100)throw new IllegalArgumentException("Marks must be 0..100");marks=m;} String getGrade(){if(marks>=80)return "A";if(marks>=70)return "B";if(marks>=60)return "C";return "F";} }
    public static void main(String[] args){for(int m:new int[]{91,75,63,48}){Student s=new Student("Learner",m);System.out.println(m+" -> "+s.getGrade());}}
}
