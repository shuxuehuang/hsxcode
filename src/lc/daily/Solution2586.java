package lc.daily;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution2586 {
    public int vowelStrings(String[] words, int left, int right) {
        Set<Character> set = new HashSet<>(Arrays.asList(new Character[]{'a', 'e', 'i', 'o', 'u'}));
        int ans = 0;
        for (int i = left; i <= right; i++){
            String word = words[i];
            if (set.contains(word.charAt(0)) && set.contains(word.charAt(word.length() - 1))){
                ans++;
            }
        }
        return ans;
    }
}
