package lc.daily;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution187 {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ans = new LinkedList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i <= s.length() - 10; i++) {
            String substring = s.substring(i, i + 10);
            if (map.containsKey(substring) && !ans.contains(substring)){
                ans.add(substring);
            }else {
                map.put(substring, map.getOrDefault(substring, 0) + 1);
            }
        }
        return ans;
    }
}
