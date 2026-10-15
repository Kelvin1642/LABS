// Reference solution; understand and adapt it before using.
public class Lab11R06_CsvPersistence {
    record Learner(String name,int mark) { String toCsv(){return name+","+mark;} static Learner parse(String row){String[] p=row.split(",",2);return new Learner(p[0],Integer.parseInt(p[1]));} }
    public static void main(String[] args){java.nio.file.Path file=java.nio.file.Path.of("learners.csv");try{java.util.List<Learner> data=java.util.List.of(new Learner("Kelvin",86),new Learner("Tariro",74));java.nio.file.Files.write(file,data.stream().map(Learner::toCsv).toList());java.util.List<Learner> loaded=java.nio.file.Files.readAllLines(file).stream().filter(s->!s.isBlank()).map(Learner::parse).toList();loaded.forEach(System.out::println);}catch(java.io.IOException e){System.err.println("CSV operation failed: "+e.getMessage());}}
}
