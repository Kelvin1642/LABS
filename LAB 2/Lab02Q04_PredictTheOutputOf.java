// Reference solution; understand and adapt it before using.
public class Lab02Q04_PredictTheOutputOf {
    static int show(String text){System.out.println(text);return 0;}
    static int staticField=show("static field 1"); static{show("static block 1");} static int secondStatic=show("static field 2"); static{show("static block 2");}
    int instanceField=show("instance field 1"); {show("instance block 1");} int secondInstance=show("instance field 2"); {show("instance block 2");}
    Lab02Q04_PredictTheOutputOf(){show("constructor");}
    public static void main(String[] args){System.out.println("-- first --");new Lab02Q04_PredictTheOutputOf();System.out.println("-- second --");new Lab02Q04_PredictTheOutputOf();}
}
