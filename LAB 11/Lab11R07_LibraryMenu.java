// Reference solution; understand and adapt it before using.
public class Lab11R07_LibraryMenu {
    static class Item { final String id,title; final int days; boolean available=true; String borrower; java.time.LocalDate due; Item(String id,String title,int days){this.id=id;this.title=title;this.days=days;} }
    static class Member { final String id,name; int active; Member(String id,String name){this.id=id;this.name=name;} }
    static final java.util.Map<String,Item> items=new java.util.HashMap<>(); static final java.util.Map<String,Member> members=new java.util.HashMap<>();
    static String ask(java.util.Scanner in,String prompt){System.out.print(prompt+": ");return in.nextLine().trim();}
    static void menu(){System.out.println("\n1 Add item | 2 Register member | 3 Borrow | 4 Return | 5 Overdue | 6 Search | 0 Exit");}
    public static void main(String[] args){try(java.util.Scanner in=new java.util.Scanner(System.in)){boolean running=true;while(running){menu();String choice=ask(in,"Choice");try{switch(choice){
        case "1"->{String type=ask(in,"Type book/DVD");String id=ask(in,"Item id");String title=ask(in,"Title");if(items.containsKey(id))throw new IllegalArgumentException("Duplicate item id");items.put(id,new Item(id,title,type.equalsIgnoreCase("dvd")?7:14));System.out.println("Item added.");}
        case "2"->{String id=ask(in,"Member id");if(members.containsKey(id))throw new IllegalArgumentException("Duplicate member id");members.put(id,new Member(id,ask(in,"Name")));System.out.println("Member registered.");}
        case "3"->{Member m=java.util.Optional.ofNullable(members.get(ask(in,"Member id"))).orElseThrow(()->new IllegalArgumentException("Unknown member"));Item item=java.util.Optional.ofNullable(items.get(ask(in,"Item id"))).orElseThrow(()->new IllegalArgumentException("Unknown item"));if(!item.available)throw new IllegalStateException("Item is already borrowed");if(m.active>=3)throw new IllegalStateException("Member already has three active loans");item.available=false;item.borrower=m.id;item.due=java.time.LocalDate.now().plusDays(item.days);m.active++;System.out.println("Due date: "+item.due);}
        case "4"->{Item item=java.util.Optional.ofNullable(items.get(ask(in,"Item id"))).orElseThrow(()->new IllegalArgumentException("Unknown item"));if(item.available)throw new IllegalStateException("Item is not on loan");Member m=members.get(item.borrower);m.active--;item.available=true;item.borrower=null;System.out.println("Return recorded.");}
        case "5"->items.values().stream().filter(i->!i.available&&i.due.isBefore(java.time.LocalDate.now())).forEach(i->System.out.println(i.title+" overdue since "+i.due));
        case "6"->{String q=ask(in,"Title contains").toLowerCase(java.util.Locale.ROOT);items.values().stream().filter(i->i.title.toLowerCase(java.util.Locale.ROOT).contains(q)).sorted(java.util.Comparator.comparing(i->i.title)).forEach(i->System.out.println(i.id+" "+i.title+(i.available?" [available]":" [loaned]")));}
        case "0"->running=false; default->System.out.println("Choose one of the listed options.");
    }}catch(IllegalArgumentException|IllegalStateException e){System.out.println("Request not completed: "+e.getMessage());}}}}
}
