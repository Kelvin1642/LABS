// Reference solution; understand and adapt it before using.
public class Lab02Q03_WriteAnEmployeeClass {
    static class Employee {
        private static int nextId=1; final int employeeId; String name; String role; double salary;
        Employee(){this("Unassigned","Intern",0);}
        Employee(String name){this(name,"Staff",0);}
        Employee(String name,String role,double salary){this.employeeId=nextId++;this.name=name;this.role=role;this.salary=salary;}
        Employee(Employee other){this(other.name,other.role,other.salary);}
        public String toString(){return "#"+employeeId+" "+name+" — "+role+" ($"+salary+")";}
    }
    public static void main(String[] args){Employee a=new Employee("Kelvin","Student Assistant",250);Employee b=new Employee(a);System.out.println(a);System.out.println(b);System.out.println(new Employee("Unassigned"));}
}
