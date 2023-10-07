package test;


import java.util.Arrays;
import java.util.TreeMap;

public class Test {
    public static void main(String[] args) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(1, 1);
        map.put(6, 4);
        map.put(5, 1);
        for (int key : map.keySet()){
            System.out.println(key);
        }
    }
}
