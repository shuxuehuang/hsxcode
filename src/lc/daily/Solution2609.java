package lc.daily;

import java.util.HashMap;
import java.util.Map;

public class Solution2609 {
    public int findTheLongestBalancedSubstring(String s) {
        int n = s.length();
        int left = 0 , right = 0;
        int count0 = 0, count1 = 0;
        int ans = 0;
        while (left < n){
            while (s.charAt(left) != '0'){
                left++;
            }
            while (s.charAt(left) == '0'){
                left++;
                count0++;
            }
            while (s.charAt(left) == '1'){
                left++;
                count1++;
            }
            ans = Math.min(count0, count1);
            count0 = 0;
            count1 = 1;
        }
        return ans;
    }
}
