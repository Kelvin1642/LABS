// Reference solution; understand and adapt it before using.
public class Lab10Q04_GivenAListOf {
    record Student(String name,double marks) {}
    public static void main(String[] args){java.util.List<Student> classList=java.util.List.of(new Student("Tariro",74),new Student("Kelvin",86),new Student("Farai",91),new Student("Rudo",69));double average=classList.stream().mapToDouble(Student::marks).average().orElse(0);System.out.printf("Class average: %.1f%n",average);classList.stream().filter(s->s.marks()>average).map(Student::name).sorted().forEach(System.out::println);}
}
