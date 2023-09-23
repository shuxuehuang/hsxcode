package lc.daily;

import java.util.*;

public class Solution2603 {
    public int collectTheCoins(int[] coins, int[][] edges) {
        int n = coins.length;
        List<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        int[] deg = new int[n];
        for (int[] e : edges){
            int x = e[0];
            int y = e[1];
            g[x].add(y);
            g[y].add(x);
            deg[x]++;
            deg[y]++;
        }
        int leftEdges = n - 1;
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (deg[i] == 1 && coins[i] == 0){
                q.add(i);
            }
        }
        while (!q.isEmpty()){
            leftEdges--;
            for (int y : g[q.poll()]){
                if (--deg[y] == 1 && coins[y] == 0){
                    q.add(y);
                }
            }
        }
        //再次拓扑
        for (int i = 0; i < n; i++) {
            if (deg[i] == 1 && coins[i] == 1){
                q.add(i);
            }
        }
        leftEdges -= q.size();
        for (int x : q){
            for (int y : g[x]){
                if (--deg[y] == 1){
                    leftEdges--;
                }
            }
        }
        return Math.max(leftEdges * 2, 0);
    }
}
