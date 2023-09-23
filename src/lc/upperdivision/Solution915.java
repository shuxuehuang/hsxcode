package lc.upperdivision;

import java.util.Arrays;

//rating1500
/*
* 需要判断左边和右边的某个条件的时候
* 同时维护两个数组，一个从左边开始，一个从右边开始
*本次维护从左边开始的最大值，从右边开始的最小值，当左边最大值小于右边最小值时，这个数组长度就是合法的
* */
public class Solution915 {
    public int partitionDisjoint(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        left[0] = nums[0];
        int[] right = new int[n];
        right[n - 1] = nums[n - 1];
        for (int i = 1; i < n; i++) {
            if (nums[i] < left[i - 1]){
                left[i] = left[i - 1];
            }else {
                left[i] = nums[i];
            }
        }
        for (int i = n - 2; i >= 0 ; i--) {
            if (right[i] < right[i + 1]){
                right[i] = nums[i];
            }else {
                right[i] = right[i + 1];
            }
        }
        Arrays.stream(left).forEach(value -> System.out.println(value));
        for (int i = 0; i < n; i++) {
            if (left[i] < right[i + 1]){
                return i + 1;
            }
        }
        return 0;
    }
}
