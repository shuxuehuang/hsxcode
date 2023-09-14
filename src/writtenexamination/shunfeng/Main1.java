package writtenexamination.shunfeng;

import java.util.Arrays;
import java.util.Scanner;

public class Main1 {
    static int[] memo;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        memo = new int[n + 1];
        Arrays.fill(memo, -1);
        System.out.println(dfs(n));
    }
    public static int dfs(int n){

        if (n <= 0){
            return 0;
        }
        if (memo[n] != -1){
            return memo[n];
        }
        //面积为n最短的周长
        int res = Integer.MAX_VALUE;
        for (int i = 1; i <= Math.sqrt(n); i++) {
            res = Math.min(res, 4 * i + dfs(n - i * i));
        }
        memo[n] = res;
        return res;
    }

}
