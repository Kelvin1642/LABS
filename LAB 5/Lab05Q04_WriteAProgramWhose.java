// Reference solution; understand and adapt it before using.
public class Lab05Q04_WriteAProgramWhose {
    static class Parent { String label="parent field"; String describe(){return "parent method";} }
    static class Child extends Parent { String label="child field"; @Override String describe(){return "child method";} }
    public static void main(String[] args){Parent ref=new Child();System.out.println(ref.label);System.out.println(ref.describe());/* Fields resolve from the reference type; overridden methods dispatch to the object type. */}
}
