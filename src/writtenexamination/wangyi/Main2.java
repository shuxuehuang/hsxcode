package writtenexamination.wangyi;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        HashMap<String, Integer> map = new HashMap<>();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            String s = in.next();
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            s = String.valueOf(chars);
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        int res = 0;
        for (String key : map.keySet()){
            res += cal(map.get(key));
        }
        System.out.println(res);

    }
    public static int cal(int num){
        return num * (num - 1) / 2;
    }
}
