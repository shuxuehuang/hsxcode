package writtenexamination.shengxinfu;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;

public class Main3 {
    static boolean isValid;
    static int woodsNum = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        s = s.substring(1, s.length() - 1);
        s = s.replace(" ", "");
        String[] split = s.split(",");
        int[] arr = new int[split.length];
        Arrays.sort(arr);
        for (int i = 0; i < split.length; i++) {
            arr[i] = Integer.valueOf(split[i]);
        }
        int length = Integer.valueOf(in.nextLine());
//        backTracking(arr, length, 0, 0);
        System.out.println(dp(arr, length));
    }

    public static void backTracking(int[] arr, int length, int num, int curLength){
        if (curLength > length){
            return;
        }
        if (curLength == length){
            isValid = true;
            woodsNum = Math.min(num, woodsNum);
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            curLength += arr[i];
            num++;
            backTracking(arr, length, num, curLength);
            num--;
            curLength -= arr[i];
        }
    }
    public static int dp(int[] arr, int length){
        int n = arr.length;
        //dp[i]长度为i的最少木材树
        int[] dp = new int[length + 1];
        for (int index : arr) {
            dp[index] = 1;
        }
        for (int i = 1; i <= length; i++){
            for (int j = 0; j < n; j++) {
                if (i - arr[j] >= 0){
                    dp[i] = Math.min(1 + dp[i - arr[j]], dp[i]);
                }
            }
        }
        for (int i = 0; i <= length; i++) {
            System.out.println(dp[i]);
        }
        return dp[length];
    }

    /*public static int dfs(int[] arr, int length, Set<Integer> set){
        //长度为length需要的最少木材量
        if (length <= 0){
            return 0;
        }
        if (set.contains(length)){
            return 1;
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++){
            res = Math.max(res, 1 + dfs(arr, length - arr[i], set));
        }
        return res;
    }*/

}
