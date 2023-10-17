package lc.daily;

public class Solution260 {
    public int[] singleNumber(int[] nums) {
        int xOrAll = 0;
        for (int num : nums){
            xOrAll ^= num;
        }
        int tz = Integer.numberOfTrailingZeros(xOrAll);
        int[] ans = new int[2];
        for (int num : nums){
            ans[num >> tz & 1] ^= num;
        }
        return ans;
    }
}
