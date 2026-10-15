// Reference solution; understand and adapt it before using.
public class Lab05Q03_ExtendTheEmployeeHierarchy {
    static class Employee { final String name; final double salary; Employee(String n,double s){name=n;salary=s;} double payroll(){return salary;} }
    static class Manager extends Employee { Manager(String n,double s){super(n,s);} }
    static class Intern extends Employee { Intern(String n,double stipend){super(n,stipend);} }
    public static void main(String[] args){Employee[] staff={new Manager("Tariro",2400),new Intern("Kelvin",350),new Employee("Farai",1200)};double total=0;for(Employee e:staff)total+=e.payroll();System.out.printf("Payroll: $%.2f%n",total);}
}
