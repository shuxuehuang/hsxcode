package lc.upperdivision;

import java.util.PriorityQueue;

public class Solution1508 {
    PriorityQueue<Integer> queue = new PriorityQueue<>();

    public static void main(String[] args) {
        Solution1508 solution1508 = new Solution1508();
        solution1508.rangeSum(new int[]{1,2,3,4}, 4, 3, 4);
    }
    public int rangeSum(int[] nums, int n, int left, int right) {

        int[] preSum = new int[n + 1];
        for (int i = 1; i < n + 1; i++){
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
        for (int i = 1; i <= n; i++){
            for (int j = i; j < n + 1; j ++){
                queue.offer(preSum[j] - preSum[j - i]);
            }
        }
        int num = right - left + 1;
        while (left > 1 && !queue.isEmpty()){
            queue.poll();
            left--;
        }
        int res = 0;

        while (num > 0 && !queue.isEmpty()){
            res += queue.poll();
            num--;
        }
        return res;
    }
    /*public void backTracking(int[] nums, int startIndex, int sum){
        if (sum != 0){
            queue.offer(sum);
        }

        for (int i = startIndex; i < nums.length; i++) {
            sum += nums[i];
            backTracking(nums, i + 1, sum);
            sum -= nums[i];
        }
    }*/
}
