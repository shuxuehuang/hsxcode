package lc.upperdivision;

import java.util.HashSet;
import java.util.Set;

public class Solution1525 {
    public int numSplits(String s) {
        int n = s.length();
        if (n == 1){
            return 0;
        }
        Set<Character> leftSet = new HashSet<>();
        Set<Character> rightSet = new HashSet<>();
        int[] leftDp = new int[n];
        int[] rightDp = new int[n];
        for (int i = 1; i < n; i++) {
            char c = s.charAt(i);
            if (leftSet.contains(c)){
                leftDp[i] = leftDp[i - 1];
            }else {
                leftDp[i] = leftDp[i - 1] + 1;
                leftSet.add(c);
            }
        }
        for (int i = n - 1; i >= 0; i--){
            char c = s.charAt(i);
            if (rightSet.contains(c)){
                rightDp[i] = rightDp[i - 1];
            }else {
                rightSet.add(c);
                rightDp[i] = rightDp[i - 1] + 1;
            }
        }
        int res = 0;
        for (int i = 1; i < n; i++){
            if (leftDp[i] == rightDp[n - i]){
                res++;
            }
        }
        return res;
    }
}
