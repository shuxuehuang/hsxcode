package zhongxing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Mian2 {
    static int[] memo;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        String s = sc.nextLine();
        String[] s1 = s.split(" ");

        int[] arr = new int[s1.length];
        for (int i = 0; i < s1.length; i++) {
            arr[i] = Integer.parseInt(s1[i]);
        }
        memo = new int[arr.length];
        Arrays.fill(memo,-1);
        int rob = rob(arr, 0);
        System.out.println(rob);
    }
    public static int rob(int[] arr, int index){

        if (index >= arr.length){
            return 0;
        }
        if (memo[index] != -1){
            return memo[index];
        }
        int num1 = arr[index] + rob(arr, index + 2);
        int num2 = rob(arr, index + 2);
        memo[index] = Math.max(num1, num2);
        return memo[index];
    }
}
