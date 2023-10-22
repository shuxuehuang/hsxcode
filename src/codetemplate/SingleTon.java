package codetemplate;

public class SingleTon {
    private static volatile SingleTon instance;

    private SingleTon(){}

    public static SingleTon getInstance(){
        if (instance == null){
            synchronized (SingleTon.class){
                 if (instance == null){
                     return new SingleTon();
                 }
            }
        }
        return instance;
    }
}
