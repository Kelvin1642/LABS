// Reference solution; understand and adapt it before using.
public class Lab01Q05_CreateAddressAndPerson {
    static class Address { String city; Address(String city){this.city=city;} }
    static class Person { String name; Address address; Person(String name,Address address){this.name=name;this.address=address;} }
    public static void main(String[] args){
        Person kelvin=new Person("Kelvin",new Address("Harare"));
        System.out.println(kelvin.name+" lives in "+kelvin.address.city);
        Person unknown=new Person("Guest",null);
        try { System.out.println(unknown.address.city); }
        catch(NullPointerException ex){System.out.println("No address is recorded for "+unknown.name);}
    }
}
