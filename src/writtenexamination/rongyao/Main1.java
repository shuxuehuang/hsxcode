package writtenexamination.rongyao;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        int n = 2; // 不同的字符最多为n个
        int l = 3; // 长度在1到l之间

        int total = countStrings(n, l);
        System.out.println("满足条件的字符串个数：" + total);
    }

    public static int countStrings(int n, int l) {
        // 边界情况处理
        if (n <= 0 || l <= 0) {
            return 0;
        }

        // 初始化动态规划数组
        int[][] dp = new int[l + 1][n + 1];
        dp[1][1] = n;
        // 动态规划计算
        for (int i = 2; i <= l; i++) {
            dp[i][1] = dp[i - 1][1] * n;
            for (int j = 2; j <= n; j++) {
                dp[i][j] = dp[i - 1][j] * (n - j + 1) + dp[i - 1][j - 1] * j;
            }
        }

        // 统计总数
        int total = 0;

        for (int j = 1; j <= n; j++) {
            total += dp[l][j];
        }

        return total;
    }
}
