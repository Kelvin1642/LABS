// Reference solution; understand and adapt it before using.
public class Lab10Q03_ReadATextFile {
    public static void main(String[] args){java.nio.file.Path path=java.nio.file.Path.of(args.length>0?args[0]:"sample.txt");try{String text=java.nio.file.Files.readString(path);long lines=text.isEmpty()?0:text.lines().count();long words=java.util.Arrays.stream(text.trim().split("\\s+")).filter(w->!w.isEmpty()).count();System.out.printf("Lines: %d%nWords: %d%nCharacters: %d%n",lines,words,text.length());}catch(java.io.IOException e){System.err.println("Cannot read "+path+": "+e.getMessage());}}
}
