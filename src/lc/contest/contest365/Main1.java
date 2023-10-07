package lc.contest.contest365;

import writtenexamination.guanglianda.Main;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class Main1 {
    public static void main(String[] args) {
        Main1 main1 = new Main1();
        main1.maximumTripletValue(new int[]{8,6,3,13,2,12,19,5,19,6,10,11,9});
    }
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long res = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        int temp1 = 0;
        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && nums[i] >= deque.peekLast()){
                deque.pollLast();
            }


            deque.addLast(nums[i]);
            if (temp1 != 0){
                res = Math.max(res, (long) temp1 * nums[i]);
            }
            if (!deque.isEmpty()){
                temp1 = Math.max(temp1, deque.peekFirst() - nums[i]);
            }
        }
        return res > 0 ? res : 0;
    }
}
