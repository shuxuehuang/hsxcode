package lc.dp;

import java.util.Arrays;

public class Solution198 {
    //打家劫舍
    int[] memo;
    public int rob(int[] nums) {
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return rob(nums, 0);
    }
    public int rob(int[] nums, int i){
        if (i >= nums.length){
            return 0;
        }
        if (memo[i] != -1){
            return memo[i];
        }
        int did = nums[i] + rob(nums, i + 2);
        int noDid = rob(nums, i + 1);
        memo[i] = Math.max(did, noDid);
        return memo[i];
    }
}
