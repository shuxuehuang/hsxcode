package lc.daily;

import javafx.util.Pair;

import java.util.Map;

public class Solution2560 {
    public int minCapability(int[] nums, int k) {
        int n = nums.length;
        int max = 0;
        for (int x : nums) max = Math.max(max, x);
        int l = 0, r = max;
        while (l <= r){
            int c = l + (r - l) / 2;
            if (check(nums, k, c)){
                r = c - 1;
            }else{
                l = c + 1;
            }
        }
        return l;
    }
    public boolean check(int[] nums, int k, int c){
        int dp0 = 0, dp1 = 0;
        for (int x : nums) {
            if (x > c) dp0 = dp1;
            else {
                int tmp = dp1;
                dp1 = Math.max(dp1, dp0 + 1);
                dp0 = tmp;
            }
            if (dp1 >= k) return true;
        }
        return false;
    }
}
