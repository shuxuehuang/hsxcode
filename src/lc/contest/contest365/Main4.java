package lc.contest.contest365;

import java.util.*;

public class Main4 {
    public static void main(String[] args) {
        Main4 main4 = new Main4();
        main4.countVisitedNodes(new LinkedList<>(Arrays.asList(1,2,0,0)));
    }
    public int[] countVisitedNodes(List<Integer> edges) {
        int[] g = edges.stream().mapToInt(i -> i).toArray();
        int n = g.length;
        List<Integer>[] rg = new ArrayList[n];
        Arrays.setAll(rg, e -> new ArrayList<>());
        int[] deg = new int[n];
        for (int i = 0; i < n; i++) {
            int y = g[i];
            rg[y].add(i);
            deg[y]++;
        }

        //拓扑排序
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (deg[i] == 0){
                q.add(i);
            }
        }
        while (!q.isEmpty()){
            int x = q.poll();
            int y = g[x];
            if (--deg[y] == 0){
                q.add(y);
            }
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            if (deg[i] <= 0) continue;
            List<Integer> ring = new ArrayList<>();
            for (int x = i; ; x = g[x]) {
                deg[x] = -1;
                ring.add(x);
                if (g[x] == i){
                    break;
                }
            }
            for (int r : ring){
                rdfs(r, ring.size(), rg, deg, ans);
            }
        }
        return ans;
    }
    private void rdfs(int x, int depth, List<Integer>[] rg, int[] deg, int[] ans){
        ans[x] = depth;
        for (int y : rg[x]) {
            if (deg[y] == 0){
                rdfs(x, depth + 1, rg, deg, ans);
            }
        }

    }

}
