package lc.dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution740 {
    int[] memo;
    public static void main(String[] args) {
        Solution740 solution740 = new Solution740();
        solution740.deleteAndEarn(new int[]{2,2,3,3,3,4});
    }
    public int deleteAndEarn(int[] nums) {
        int n = nums.length;
        memo = new int[n];
        Arrays.fill(memo, -1);
        Arrays.sort(nums);
        return dfs(nums, 0);
    }
    public int dfs(int[] nums, int i){
        if (i >= nums.length){
            return 0;
        }
        if (nums[i] != -1){
            return memo[i];
        }
        //选择nums[i];
        int index = i;
        int x = nums[i];
        int temp = nums[i];
        while (i + 1 < nums.length && nums[i + 1] == nums[i]) {
            temp += nums[i];
            i++;
        }
        while (nums[i] == x || nums[i] == x + 1) {
            i++;
        }
        int num1 = temp + dfs(nums, i);
        //不选择nums[i];
        while (nums[index] != nums[i]) {
            index++;
        }
        int num2 = dfs(nums, index);
        return memo[i] = Math.max(num1, num2);
    }

}
