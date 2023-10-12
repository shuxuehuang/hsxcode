package lc.daily;

public class Solution2562 {
    public long findTheArrayConcVal(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1;
        long num = 0;
        while (left <= right){
            if (left == right){
                num += nums[left];

            }else {
                String s = String.valueOf(nums[left]) + String.valueOf(nums[right]);
                num += Integer.parseInt(s);
            }
            left++;
            right--;
        }
        return num;
    }
}
