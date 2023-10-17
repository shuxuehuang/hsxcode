package lc.daily;

import java.util.*;

public class Solution1488 {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] ans = new int[n];
        Map<Integer, Integer> map = new HashMap<>();
        TreeSet<Integer> idx = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            if (rains[i] == 0){
                idx.add(0);
            }else {
                if (map.containsKey(rains[i])){
                    Integer firstIdx = map.get(rains[i]);
                    Integer ceiling = idx.ceiling(firstIdx);
                    if (ceiling == null){
                        return new int[0];
                    }
                    ans[ceiling] = rains[i];
                    idx.remove(ceiling);
                }
                map.put(rains[i], i);
            }
        }

        return ans;
    }
}
