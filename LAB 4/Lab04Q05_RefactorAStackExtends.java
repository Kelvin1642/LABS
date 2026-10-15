// Reference solution; understand and adapt it before using.
public class Lab04Q05_RefactorAStackExtends {
    static class Stack<T> { private final java.util.ArrayList<T> items=new java.util.ArrayList<>(); void push(T item){items.add(item);} T pop(){if(items.isEmpty())throw new java.util.NoSuchElementException("Stack is empty");return items.remove(items.size()-1);} int size(){return items.size();} }
    public static void main(String[] args){Stack<String> s=new Stack<>();s.push("e4");s.push("Nf3");System.out.println(s.pop()+"; remaining "+s.size());/* Composition exposes only stack operations; extending ArrayList would expose queue/index/remove operations too. */}
}
