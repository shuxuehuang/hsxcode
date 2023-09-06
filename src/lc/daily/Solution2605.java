package lc.daily;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Solution2605 {
    public int minNumber(int[] nums1, int[] nums2) {
        int num1 = Arrays.stream(nums1).min().getAsInt();
        int num2 = Arrays.stream(nums2).min().getAsInt();
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            set2.add(nums2[i]);
        }
        int min = Math.min(num1, num2);
        if (set1.contains(min) && set1.contains(min)){
            return min;
        }

        return num1 == num2 ? num1 : Math.max(num1 * 10 + num2, num2 * 10 + num1);
    }
}
