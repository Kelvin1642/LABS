// Reference solution; understand and adapt it before using.
public class Lab11R01_ModelClasses {
    static class Book { private final String id,title; Book(String id,String title){if(id==null||id.isBlank()||title==null||title.isBlank())throw new IllegalArgumentException("Book id and title are required");this.id=id;this.title=title;} public String toString(){return "Book{"+id+", "+title+"}";} }
    static class Member { private final String id,name; Member(String id,String name){if(id==null||id.isBlank()||name==null||name.isBlank())throw new IllegalArgumentException("Member id and name are required");this.id=id;this.name=name;} public String toString(){return "Member{"+id+", "+name+"}";} }
    static class Loan { private final Book book; private final Member member; private final java.time.LocalDate dueDate; Loan(Book b,Member m,java.time.LocalDate due){book=b;member=m;dueDate=due;} public String toString(){return member+" borrowed "+book+", due "+dueDate;} }
    public static void main(String[] args){Book b=new Book("B-01","Java OOP");Member m=new Member("M-01","Kelvin");System.out.println(new Loan(b,m,java.time.LocalDate.now().plusDays(14)));}
}
