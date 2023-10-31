package lc.contest.contest368;

import lc.contest.contest367.Mian2;

import java.util.LinkedList;
import java.util.List;

public class Main2 {
    public static void main(String[] args) {
        Main2 main2 = new Main2();
        main2.minimumSum(new int[]{1,3,4,5,2});
    }
    public int minimumSum(int[] nums) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        int[] minLeft = new int[n];
        minLeft[0] = nums[0];

        int[] minRight = new int[n];
        minRight[n - 1] = nums[n - 1];
        for (int i = 1; i < n; i++) {
            if (nums[i] < minLeft[i - 1]){
                minLeft[i] = nums[i];
            }else {
                minLeft[i] = minLeft[i - 1];
            }
        }
        for (int i = n - 2; i >= 0 ; i--) {
            if (nums[i] < minRight[i + 1]){
                minRight[i] = nums[i];
            }else {
                minRight[i] = minRight[i + 1];
            }
        }
        for (int i = 1; i < n - 1; i++) {
            if (minLeft[i - 1] < nums[i] && minRight[i + 1] < nums[i]){
                ans = Math.min(ans, nums[i] + minRight[i + 1] + minLeft[i - 1]);
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
