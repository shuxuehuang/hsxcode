package lc.daily;

import java.util.Arrays;

public class Solution198 {
    int[] memo;
    public int rob(int[] nums) {
        int n = nums.length;
        memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return dp(nums, 0);
    }
    public int dp(int[] nums, int index){
        if (index >= nums.length){
            return 0;
        }
        if (memo[index] != -1){
            return memo[index];
        }
        int did = nums[index] + dp(nums, index + 2);
        int notDo = dp(nums, index + 1);
        memo[index] = Math.min(did, notDo);
        return memo[index];
    }
}
