package lc.dp;

//股票买卖1
public class Solution121 {
    public static void main(String[] args) {
        Solution121 solution121 = new Solution121();
//        solution121.maxProfit1(new int[]{1,2,3,0,2});
        solution121.maxProfit2(new int[]{1,2,3,0,2});
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1] ,dp[i - 1][0] + prices[i]);
        }
        return dp[n - 1][1];
    }

    public int maxProfit1(int[] prices) {
        int n = prices.length;
        if (prices == null || n < 2){
            return 0;
        }
        int[][] dp = new int[n][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;

        dp[1][0] = Math.max(dp[0][0], -prices[1]);
        dp[1][1] = Math.max(dp[0][1], dp[0][0] + prices[1]);
        for (int i = 2; i < n; i++){
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 2][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[n - 1][1];
    }
    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int n = prices.length;
        int[][] dp = new int[prices.length][2];

        // bad case
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[1][0] = Math.max(dp[0][0], dp[0][1] + prices[1]);
        dp[1][1] = Math.max(dp[0][1], -prices[1]);

        for (int i = 2; i < prices.length; i++) {
            // dp公式
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(dp[i][j]);
            }
            System.out.println();
        }
        return dp[prices.length - 1][0];
    }
}
