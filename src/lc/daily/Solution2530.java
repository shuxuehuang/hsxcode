package lc.daily;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution2530 {
    public long maxKelements(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> b - a);
        for (int num : nums){
            priorityQueue.add(num);
        }
        long ans = 0;
        while (k > 0){
            int poll = priorityQueue.poll();
            ans += poll;
            priorityQueue.add((int) Math.ceil((poll / 3.0)));
            k--;
        }
        return ans;
    }
}
