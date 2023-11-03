package lc.daily;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution2103 {
    public int countPoints(String rings) {
        int n = rings.length();
        Set<Character>[] sets = new Set[10];
        Arrays.setAll(sets, e -> new HashSet<>());
        for (int i = 0; i < n - 1; i += 2) {
            char color = rings.charAt(i);
            int index = rings.charAt(i + 1) - '0';
            sets[index].add(color);
        }
        int res = 0;
        for (Set<Character> set : sets) {
            if (set.size() == 3){
                res++;
            }
        }
        return res;
    }
}
