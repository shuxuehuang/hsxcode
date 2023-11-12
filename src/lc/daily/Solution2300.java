package lc.daily;

import java.util.Arrays;

public class Solution2300 {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int m = potions.length;
        Arrays.sort(potions);
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int spell = spells[i];
            int left = 0, right = m - 1;
            while (left <= right){
                int mid = left + (right - left) / 2;
                if ((long) potions[mid] * spell < success){
                    left = mid + 1;
                }else {
                    right = mid - 1;
                }
            }
            ans[i] = m - left;
        }
        return ans;
    }
}
