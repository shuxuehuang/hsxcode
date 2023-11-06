package lc.daily;

import java.util.*;

public class Solution318 {
    public int maxProduct(String[] words) {
        int n = words.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            String s1 = words[i];
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < s1.length(); j++) {
                set.add(s1.charAt(i));
            }
            for (int j = 1; j < n; j++) {
                String s2 = words[i];
                for (int k = 0; k < s2.length(); k++) {
                    if (set.contains(s2.charAt(k))){
                        break;
                    }
                }
                ans = Math.max(ans, s1.length() * s2.length());
            }
        }
        return ans;
    }
}
