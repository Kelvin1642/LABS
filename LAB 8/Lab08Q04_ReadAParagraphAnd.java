// Reference solution; understand and adapt it before using.
public class Lab08Q04_ReadAParagraphAnd {
    public static void main(String[] args){String paragraph="Chess rewards patience. Patience helps in chess.";java.util.Map<String,Integer> frequency=new java.util.HashMap<>();for(String word:paragraph.toLowerCase().replaceAll("[^a-z0-9 ]"," ").trim().split("\\s+"))if(!word.isBlank())frequency.merge(word,1,Integer::sum);frequency.entrySet().stream().sorted(java.util.Map.Entry.<String,Integer>comparingByValue().reversed().thenComparing(java.util.Map.Entry.comparingByKey())).forEach(e->System.out.println(e.getKey()+": "+e.getValue()));}
}
