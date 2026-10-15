// Reference solution; understand and adapt it before using.
public class Lab11R05_CollectionStorage {
    static class Member { final String id,name; Member(String i,String n){id=i;name=n;} }
    static class Item { final String id,title; Item(String i,String t){id=i;title=t;} }
    static class Library { final java.util.Map<String,Item> items=new java.util.HashMap<>(); final java.util.Map<String,Member> members=new java.util.HashMap<>(); void add(Item item){if(items.putIfAbsent(item.id,item)!=null)throw new IllegalArgumentException("Duplicate item id: "+item.id);} void register(Member member){if(members.putIfAbsent(member.id,member)!=null)throw new IllegalArgumentException("Duplicate member id: "+member.id);} }
    public static void main(String[] args){Library l=new Library();l.add(new Item("B-01","Java OOP"));l.register(new Member("M-01","Kelvin"));System.out.println("Items="+l.items.keySet()+", members="+l.members.keySet());}
}
