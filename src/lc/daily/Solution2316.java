package lc.daily;

import java.util.*;

public class Solution2316 {
    public static void main(String[] args) {
        Solution2316 solution2316 = new Solution2316();
        solution2316.countPairs(7, new int[][]{{0,2},{0,5},{2,4},{1,6},{5,4}});
    }
    public long countPairs(int n, int[][] edges) {
        UF uf = new UF(n);
        for (int[] edge : edges){
            uf.union(edge[0], edge[1]);
        }
        if (uf.count == 1){
            return 0;
        }
        long ans = 0;
        for (int i = 0; i < uf.size.length; i++) {
            ans += n - uf.size[uf.find(i)];
        }
        return ans / 2;
    }
}
class UF{
    int[] parent;
    int[] size;
    int count;
    Set<Integer> set = new HashSet<>();
    public UF(int n) {
        this.count = n;
        this.parent = new int[n];
        this.size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }
    public void union(int p, int q){
        int parentP = find(p);
        int parentQ = find(q);
        if (parentP == parentQ){
            return;
        }
        if (size[parentP] > size[parentQ]){
            parent[parentQ] = parentP;
            size[parentP] += size[parentQ];
        }else {
            parent[parentP] = parentQ;
            size[parentQ]+=size[parentP];
        }

        count--;
    }
    public int find(int x){
        while (x != parent[x]){
            x = parent[x];
        }
        return x;
    }
    public void count(){

        for (int i = 0; i < parent.length; i++) {
            int temp = i;
            while (temp != parent[temp]){
                temp = parent[temp];
            }
            parent[i] = temp;
        }
    }
}
