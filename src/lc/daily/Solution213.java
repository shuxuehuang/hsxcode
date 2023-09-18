package lc.daily;

import java.util.Arrays;

public class Solution213 {
    int[][] memo;
    public int rob(int[] nums) {
        memo = new int[nums.length][nums.length];
        for (int[] m : memo){
            Arrays.fill(memo, -1);
        }
        return Math.max(rob(nums, 0, memo.length - 2), rob(nums, 1, memo.length - 1));
    }
    public int rob(int[] nums, int start, int end){
        if (start > end){
            return 0;
        }
        if (memo[start][end] != -1){
            return memo[start][end];
        }
        int did = nums[start] + rob(nums, start + 2, end);
        int notDid = rob(nums, start + 1, end);
        memo[start][end] = Math.max(did, notDid);
        return memo[start][end];
    }
}
