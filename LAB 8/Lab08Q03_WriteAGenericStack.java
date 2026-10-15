// Reference solution; understand and adapt it before using.
public class Lab08Q03_WriteAGenericStack {
    static class Stack<T> { private final java.util.List<T> data=new java.util.ArrayList<>(); void push(T item){data.add(java.util.Objects.requireNonNull(item));} T pop(){if(data.isEmpty())throw new java.util.NoSuchElementException("Stack is empty");return data.remove(data.size()-1);} T peek(){if(data.isEmpty())throw new java.util.NoSuchElementException("Stack is empty");return data.get(data.size()-1);} boolean isEmpty(){return data.isEmpty();} }
    public static void main(String[] args){Stack<String> moves=new Stack<>();moves.push("e4");moves.push("c5");System.out.println("top="+moves.peek()+", pop="+moves.pop());}
}
