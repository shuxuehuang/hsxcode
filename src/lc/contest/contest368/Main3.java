package lc.contest.contest368;

import java.util.HashMap;
import java.util.Map;

public class Main3 {
    public static void main(String[] args) {
        Main3 main3 = new Main3();
        main3.minGroupsForValidAssignment(new int[]{1,1,3,3,1,1,2,2,3,1,3,2});
    }
    public int minGroupsForValidAssignment(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int minLen = Integer.MAX_VALUE;
        for (int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int len : map.values()){
            minLen = Math.min(minLen, len);
        }
        int maxLen = minLen + 1;
        int res = Integer.MAX_VALUE;
        for (int i = 1; i < n - 1; i++){
            int len = i + 1;
            int temp = 0;
            for (int num : map.values()){
                temp += Math.ceil((double) num / len);
            }
            if (temp != 0){
                res = Math.min(res, temp);
            }
        }
        return res;
    }
}
