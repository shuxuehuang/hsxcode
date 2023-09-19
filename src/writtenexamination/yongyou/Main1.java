package writtenexamination.yongyou;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        if (m == 1 && n == 1){
            System.out.println(2);
            return;
        }
        int[][] dp = new int[m][n];
        dp[m - 1][0] = 0;
        dp[m - 2][0] = 1;
        dp[m - 1][1] = 1;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i + 1][j] + dp[i][j - 1];
            }
        }
        System.out.println(dp[0][n - 1]);
    }
}
