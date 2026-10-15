// Reference solution; understand and adapt it before using.
public class Lab11R02_LibraryItemHierarchy {
    abstract static class LibraryItem { private final String id,title; LibraryItem(String id,String title){this.id=id;this.title=title;} String getId(){return id;} String getTitle(){return title;} abstract int loanPeriodDays(); }
    static class Book extends LibraryItem { Book(String id,String title){super(id,title);} int loanPeriodDays(){return 14;} }
    static class Dvd extends LibraryItem { Dvd(String id,String title){super(id,title);} int loanPeriodDays(){return 7;} }
    public static void main(String[] args){LibraryItem[] items={new Book("B1","Java OOP"),new Dvd("D1","Chess documentary")};for(LibraryItem i:items)System.out.println(i.getTitle()+" loan period: "+i.loanPeriodDays()+" days");}
}
