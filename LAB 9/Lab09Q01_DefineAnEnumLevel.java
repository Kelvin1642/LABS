// Reference solution; understand and adapt it before using.
public class Lab09Q01_DefineAnEnumLevel {
    enum Level { LOW, MEDIUM, HIGH }
    static String advice(Level l){return switch(l){case LOW->"Keep a steady pace.";case MEDIUM->"Focus and manage your time.";case HIGH->"Prioritize the most important task.";};}
    public static void main(String[] args){for(Level l:Level.values())System.out.println(l+": "+advice(l));}
}
