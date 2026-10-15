// Reference solution; understand and adapt it before using.
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
public class Lab11R08_MiniProjectIntegration {

    interface Borrowable { void borrow(Member member); void giveBack(); }
    abstract static class LibraryItem {
        private final String id,title; private boolean available=true;
        LibraryItem(String id,String title){if(blank(id)||blank(title))throw new IllegalArgumentException("Item id and title are required");this.id=id;this.title=title;}
        String id(){return id;} String title(){return title;} boolean available(){return available;} void setAvailable(boolean value){available=value;} abstract int loanPeriodDays(); abstract String kind();
        @Override public String toString(){return kind()+" "+id+" — "+title+(available?" [available]":" [on loan]");}
    }
    static final class Book extends LibraryItem implements Borrowable {
        private Member currentMember; Book(String id,String title){super(id,title);} int loanPeriodDays(){return 14;} String kind(){return "Book";}
        public void borrow(Member member){if(!available())throw new IllegalStateException("Item is already borrowed");currentMember=member;setAvailable(false);} public void giveBack(){if(available())throw new IllegalStateException("Item is not on loan");currentMember=null;setAvailable(true);}
    }
    static final class Dvd extends LibraryItem implements Borrowable {
        private Member currentMember; Dvd(String id,String title){super(id,title);} int loanPeriodDays(){return 7;} String kind(){return "DVD";}
        public void borrow(Member member){if(!available())throw new IllegalStateException("Item is already borrowed");currentMember=member;setAvailable(false);} public void giveBack(){if(available())throw new IllegalStateException("Item is not on loan");currentMember=null;setAvailable(true);}
    }
    static final class Member {
        private final String id,name; private final List<Loan> loans=new ArrayList<>();
        Member(String id,String name){if(blank(id)||blank(name))throw new IllegalArgumentException("Member id and name are required");this.id=id;this.name=name;}
        String id(){return id;} String name(){return name;} long activeLoanCount(){return loans.stream().filter(l->!l.returned).count();} void addLoan(Loan l){loans.add(l);} List<Loan> loans(){return Collections.unmodifiableList(loans);}
        public String toString(){return id+" — "+name+" (active loans: "+activeLoanCount()+")";}
    }
    static final class Loan {
        final Member member; final LibraryItem item; final LocalDate dueDate; boolean returned;
        Loan(Member m,LibraryItem i,LocalDate due){member=m;item=i;dueDate=due;}
        boolean overdue(){return !returned&&dueDate.isBefore(LocalDate.now());}
        public String toString(){return item.title()+" / "+member.name()+" / due "+dueDate+(returned?" / returned":"");}
    }
    static final class ItemNotAvailableException extends Exception { ItemNotAvailableException(String id){super("Item "+id+" is unavailable");} }
    static final class MemberLimitExceededException extends Exception { MemberLimitExceededException(String name){super(name+" already has 3 active loans");} }
    static final class Library {
        private static final int MAX_LOANS=3;
        private final Map<String,LibraryItem> items=new HashMap<>(); private final Map<String,Member> members=new HashMap<>(); private final List<Loan> loans=new ArrayList<>();
        void addItem(LibraryItem item){if(items.putIfAbsent(item.id(),item)!=null)throw new IllegalArgumentException("Item id already exists: "+item.id());}
        void register(Member member){if(members.putIfAbsent(member.id(),member)!=null)throw new IllegalArgumentException("Member id already exists: "+member.id());}
        void borrow(String memberId,String itemId) throws ItemNotAvailableException,MemberLimitExceededException {
            Member m=Optional.ofNullable(members.get(memberId)).orElseThrow(()->new IllegalArgumentException("Unknown member: "+memberId));
            LibraryItem item=Optional.ofNullable(items.get(itemId)).orElseThrow(()->new IllegalArgumentException("Unknown item: "+itemId));
            if(!item.available())throw new ItemNotAvailableException(itemId); if(m.activeLoanCount()>=MAX_LOANS)throw new MemberLimitExceededException(m.name());
            ((Borrowable)item).borrow(m); Loan loan=new Loan(m,item,LocalDate.now().plusDays(item.loanPeriodDays()));m.addLoan(loan);loans.add(loan);
        }
        void giveBack(String itemId){LibraryItem item=Optional.ofNullable(items.get(itemId)).orElseThrow(()->new IllegalArgumentException("Unknown item: "+itemId));if(item.available())throw new IllegalStateException("Item is not on loan: "+itemId);((Borrowable)item).giveBack();loans.stream().filter(l->l.item==item&&!l.returned).findFirst().orElseThrow().returned=true;}
        List<LibraryItem> searchByTitle(String text){String q=text.toLowerCase(Locale.ROOT);return items.values().stream().filter(i->i.title().toLowerCase(Locale.ROOT).contains(q)).sorted(Comparator.comparing(LibraryItem::title)).toList();}
        List<Loan> overdue(){return loans.stream().filter(Loan::overdue).sorted(Comparator.comparing(l->l.dueDate)).toList();}
        Collection<LibraryItem> items(){return items.values();} Collection<Member> members(){return members.values();}
        void save(Path dir) throws IOException {
            Files.createDirectories(dir);
            Files.write(dir.resolve("members.csv"),members.values().stream().map(m->enc(m.id)+","+enc(m.name)).toList());
            Files.write(dir.resolve("items.csv"),items.values().stream().map(i->i.kind()+","+enc(i.id())+","+enc(i.title())).toList());
            Files.write(dir.resolve("loans.csv"),loans.stream().map(l->enc(l.member.id)+","+enc(l.item.id())+","+l.dueDate+","+l.returned).toList());
        }
        void load(Path dir) throws IOException {
            Path mf=dir.resolve("members.csv"), inf=dir.resolve("items.csv"), lf=dir.resolve("loans.csv");
            if(Files.exists(mf))for(String row:Files.readAllLines(mf)){if(row.isBlank())continue;String[] p=row.split(",",-1);register(new Member(dec(p[0]),dec(p[1])));}
            if(Files.exists(inf))for(String row:Files.readAllLines(inf)){if(row.isBlank())continue;String[] p=row.split(",",-1);String id=dec(p[1]),title=dec(p[2]);addItem(p[0].equals("Book")?new Book(id,title):new Dvd(id,title));}
            if(Files.exists(lf))for(String row:Files.readAllLines(lf)){if(row.isBlank())continue;String[] p=row.split(",",-1);Member m=members.get(dec(p[0]));LibraryItem item=items.get(dec(p[1]));LocalDate due=LocalDate.parse(p[2]);boolean returned=Boolean.parseBoolean(p[3]);if(m!=null&&item!=null){Loan l=new Loan(m,item,due);l.returned=returned;m.addLoan(l);loans.add(l);if(!returned)((Borrowable)item).borrow(m);}}
        }
    }
    static boolean blank(String s){return s==null||s.isBlank();} static String enc(String s){return Base64.getEncoder().encodeToString(s.getBytes(java.nio.charset.StandardCharsets.UTF_8));} static String dec(String s){return new String(Base64.getDecoder().decode(s),java.nio.charset.StandardCharsets.UTF_8);}
    static void menu(){System.out.println("\nHIT Library | 1 Add item | 2 Register member | 3 Borrow | 4 Return | 5 Overdue | 6 Search | 7 List | 0 Save and exit");}
    static String ask(Scanner in,String label){System.out.print(label+": ");return in.nextLine().trim();}
    public static void main(String[] args){Library library=new Library();Path data=Path.of("library-data");try{library.load(data);}catch(Exception e){System.err.println("Could not load saved data: "+e.getMessage());}
        try(Scanner in=new Scanner(System.in)){boolean running=true;while(running){menu();String choice=ask(in,"Choice");try{switch(choice){
            case "1"->{String type=ask(in,"Type (book/dvd)");String id=ask(in,"Item id");String title=ask(in,"Title");library.addItem(type.equalsIgnoreCase("dvd")?new Dvd(id,title):new Book(id,title));System.out.println("Item added.");}
            case "2"->{library.register(new Member(ask(in,"Member id"),ask(in,"Name")));System.out.println("Member registered.");}
            case "3"->{library.borrow(ask(in,"Member id"),ask(in,"Item id"));System.out.println("Loan recorded.");}
            case "4"->{library.giveBack(ask(in,"Item id"));System.out.println("Return recorded.");}
            case "5"->library.overdue().forEach(System.out::println);
            case "6"->library.searchByTitle(ask(in,"Title contains")).forEach(System.out::println);
            case "7"->{System.out.println("Members:");library.members().forEach(System.out::println);System.out.println("Items:");library.items().forEach(System.out::println);}
            case "0"->{library.save(data);System.out.println("Saved to "+data.toAbsolutePath());running=false;}
            default->System.out.println("Choose a listed option.");
        }}catch(ItemNotAvailableException|MemberLimitExceededException|IllegalArgumentException|IllegalStateException e){System.out.println("Request not completed: "+e.getMessage());}}
        }catch(IOException e){System.err.println("Could not save library data: "+e.getMessage());}
        /* Design: Library coordinates maps and loans; Member owns its loan history; item subclasses define loan periods. */
    }
}
