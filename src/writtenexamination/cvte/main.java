package writtenexamination.cvte;

import java.util.Arrays;
import java.util.Map;

public class main {
    public static void main(String[] args) {
        main main = new main();
        main.jump(new int[]{1, 1, 1, 1});
    }
    int[] memo;
    public int jump(int[] arr){
        int n = arr.length;
        if (n == 1){
            return 0;
        }
        memo = new int[n];
        Arrays.fill(memo, -1);
        return dfs(arr, 0);
    }
    public int dfs(int[] arr, int startIndex){
        if (startIndex >= arr.length - 1){
            return 0;
        }
        if (memo[startIndex] != -1){
            return memo[startIndex];
        }
        int step = arr[startIndex];
        int res = arr.length;
        for(int i = 1; i <= step; i++){
            res = Math.min(res, 1 + dfs(arr, startIndex + i));
        }
        memo[startIndex] = res;
        return res;
    }
}
