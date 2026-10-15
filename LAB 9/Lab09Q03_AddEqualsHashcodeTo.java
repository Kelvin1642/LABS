// Reference solution; understand and adapt it before using.
public class Lab09Q03_AddEqualsHashcodeTo {
    static final class Book { final String title,isbn; Book(String t,String i){title=t;isbn=i;} @Override public boolean equals(Object o){return o instanceof Book b&&isbn.equals(b.isbn);} @Override public int hashCode(){return java.util.Objects.hash(isbn);} public String toString(){return title+" ("+isbn+")";} }
    public static void main(String[] args){java.util.Set<Book> shelf=new java.util.HashSet<>();shelf.add(new Book("Java Basics","978-1"));shelf.add(new Book("Java Basics, new copy","978-1"));System.out.println("Unique ISBN count: "+shelf.size()+" "+shelf);}
}
