package lc.daily;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution1155 {
    private static final int MOD = 1_000_000_007;
    int[][] memo;
    public int numRollsToTarget(int n, int k, int target) {
        if (target < n || target > n * k){
            return 0;
        }
        memo = new int[n + 1][target + 1];
        for (int[] m : memo){
            Arrays.fill(m, -1);
        }
        return dfs(n, k, target);
    }

    public int dfs(int n, int k, int target){
        if (n == 0){
            return target == 0 ? 1 : 0;
        }
        if (memo[n][target] != -1){
            return memo[n][target];
        }
        int count = 0;
        for (int i = 1; i <= k && i <= target; i++){
            count = (count + dfs(n - 1, k, target - i)) % MOD;
        }
        return memo[n][target] = count;
    }

}
