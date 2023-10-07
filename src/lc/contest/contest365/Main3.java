package lc.contest.contest365;

import java.util.Arrays;

public class Main3 {
    public int minSizeSubarray(int[] nums, int target) {
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();
        int left = 0, right = 0;
        int s = 0;
        int ans = Integer.MAX_VALUE;
        while (right < 2 * n){
            s += nums[right % n];
            right ++;
            while (s > target % sum){
                s -= nums[left % n];
                left++;
            }
            if (s == target % sum){
                ans = Math.min(ans, right - left + 1);
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans + target / sum;
    }
}
