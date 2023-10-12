package lc.daily;

import java.util.Arrays;

public class Solution2731 {
    public int sumDistance(int[] nums, String s, int d) {
        int n = nums.length;
        int mod = (int) (1e9 + 7);
        for (int i = 0; i < n; i++) {
            nums[i] += s.charAt(i) == 'R' ? d : -d;
        }
        Arrays.sort(nums);
        int num = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            num = (num + i * x - sum) % mod;
            sum += x;
        }
        return num;
    }
}
