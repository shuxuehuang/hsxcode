package test;

public class MyImpl implements MyInterface{
    @Override
    public void method1() {
        MyInterface.super.method1();
    }


    public static void method2() {

    }

    public static void main(String[] args) {
        MyImpl my = new MyImpl();
        my.method1();

    }
}
