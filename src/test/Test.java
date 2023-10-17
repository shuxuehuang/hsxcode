package test;


import java.util.Arrays;
import java.util.TreeMap;

public class Test {
    public static void main(String[] args) {
        S s = new S();
        s.printValue();
        A as = (A) s;
        as.printValue();
    }
}
class A{
    public void printValue(){
        System.out.print("A");
    }

}
class S extends A{
    public void printValue(){
        System.out.print("S");
    }
}
