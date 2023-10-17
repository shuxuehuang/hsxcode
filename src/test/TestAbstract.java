package test;

public abstract class TestAbstract {
    public static void test1() {
        System.out.println("抽象类里面也可以声明普通方法");
    }

    abstract void getData(String url, String method);
}
