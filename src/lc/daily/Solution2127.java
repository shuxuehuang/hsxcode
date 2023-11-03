package lc.daily;

import java.util.*;

public class Solution2127 {
    public int maximumInvitations(int[] favorite) {
        int n = favorite.length;
        int[] deg = new int[n];
        for (int f : favorite){
            deg[f]++;
        }
        List<Integer>[] rg = new List[n];
        Arrays.setAll(rg, e -> new ArrayList<>());
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (deg[i] == 0){
                q.add(i);
            }
        }
        while (!q.isEmpty()){
            int x = q.poll();
            int y = favorite[x];
            rg[y].add(x);
            if (--deg[y] == 0){
                q.add(y);
            }
        }
        int maxRingSize = 0, sumChainSize = 0;
        for (int i = 0; i < n; i++) {
            if (deg[i] == 0) continue;
            deg[i] = 0;
            int ringSize = 1;
            for (int x = favorite[i]; x != i; x = favorite[x]){
                deg[x] = 0;
                ringSize++;
            }
            if (ringSize == 2){
                sumChainSize += rdfs(i, rg) + rdfs(favorite[i], rg);
            }else {
                maxRingSize = Math.max(maxRingSize, ringSize);
            }
        }
        return Math.max(maxRingSize, sumChainSize);
    }
    public int rdfs(int x, List<Integer>[] rg){
        int maxDepth = 1;
        for (int son : rg[x]){
            maxDepth = Math.max(maxDepth, rdfs(son, rg) + 1);
        }
        return maxDepth;
    }
}
