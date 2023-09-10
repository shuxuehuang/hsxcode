package test;

public interface MyInterface {
    //接口中的属性（成员变量）默认是public static final的
    int x = 1;
    default void method1(){
        System.out.println("ssss");
    }

    static void method2() {

    }
}
