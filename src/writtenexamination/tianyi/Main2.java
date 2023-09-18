package writtenexamination.tianyi;

import java.util.Arrays;

public class Main2 {
    int memo[][];
    int method1;
    int method2;

    public static void main(String[] args) {
        Main2 main2 = new Main2();
        main2.count(5);
    }
    public int count (int h) {
        // write code here
        memo = new int[h + 1][2];
        for (int[] m : memo){
            Arrays.fill(m, -1);
        }

        return dfs(h, false);
    }
    public int dfs(int h, boolean isUsed){
        //距离为h最少需要多少次,isUsed表示上一次有没有用技能
        if (h <= 0){
            return 0;
        }
        if (memo[h][!isUsed ? 0 : 1] != -1){
            return memo[h][!isUsed ? 0 : 1];
        }
        method1 = 1 + dfs(h - 1, false);
        method2 = Integer.MAX_VALUE;
        if (!isUsed){
            method2 = 1 + dfs(h - 3, true);
        }
        memo[h][!isUsed ? 0 : 1] = Math.min(method1, method2);
        return memo[h][!isUsed ? 0 : 1];
    }
    public int count1 (int h) {
        // write code here
        //dp[h][0] 第h步正常走，最少的步数
        //dp[h][1] 第h步走三步，最少的步数
        int[][] dp = new int[h + 1][2];
        dp[0][1] = 1;
        dp[0][1] = 1;
        dp[1][0] = 1;
        dp[1][1] = 1;
        dp[2][0] = 1;
        dp[2][1] = 2;
        dp[3][0] = 2;
        dp[3][1] = 1;
        for (int i = 4; i < h + 1; i++){
            dp[i][0] = Math.min(dp[i - 1][0], dp[i - 3][1]) + 1;
            dp[i][1] = dp[i - 1][0] + 1;
        }
        return Math.min(dp[h][0], dp[h][1]);
    }
}
