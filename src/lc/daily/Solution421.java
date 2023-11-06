package lc.daily;

import algo.array.Array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution421 {
    public int findMaximumXOR(int[] nums) {
        int max = 0;
        for (int x : nums){
            max = Math.max(max, x);
        }
        int highBit = 31 - Integer.numberOfLeadingZeros(max);

        int ans = 0, mask = 0;
        Set<Integer> seen = new HashSet<>();
        for (int i = highBit; i >= 0; i--) {
            seen.clear();
            mask |= 1 << i;
            int newAns = ans | (1 << i);
            for (int x : nums) {
                x &= mask;
                if (seen.contains(newAns ^ x)){
                    ans = newAns;
                    break;
                }
                seen.add(x);
            }
        }
        return ans;
    }
}
