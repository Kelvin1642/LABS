// Reference solution; understand and adapt it before using.
public class Lab10Q01_WriteAProgramThat {
    public static void main(String[] args){java.nio.file.Path path=java.nio.file.Path.of("five-lines.txt");try(java.util.Scanner in=new java.util.Scanner(System.in)){java.util.List<String> lines=new java.util.ArrayList<>();for(int i=1;i<=5;i++){System.out.print("Line "+i+": ");lines.add(in.nextLine());}java.nio.file.Files.write(path,lines);System.out.println("Saved and read back:");for(String line:java.nio.file.Files.readAllLines(path))System.out.println(line);}catch(java.io.IOException e){System.err.println("File operation failed: "+e.getMessage());}}
}
