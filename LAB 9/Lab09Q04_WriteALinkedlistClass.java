// Reference solution; understand and adapt it before using.
public class Lab09Q04_WriteALinkedlistClass {
    static class ChessLinkedList<T> implements Iterable<T> {
        private static class Node<E>{E value;Node<E> next;Node(E v){value=v;}}
        private Node<T> head,tail; void add(T value){Node<T> n=new Node<>(value);if(tail==null)head=n;else tail.next=n;tail=n;}
        public java.util.Iterator<T> iterator(){return new java.util.Iterator<>(){private Node<T> current=head;public boolean hasNext(){return current!=null;}public T next(){if(current==null)throw new java.util.NoSuchElementException();T v=current.value;current=current.next;return v;}};}
    }
    public static void main(String[] args){ChessLinkedList<String> moves=new ChessLinkedList<>();moves.add("e4");moves.add("Nf3");moves.add("Bc4");for(String move:moves)System.out.println(move);}
}
