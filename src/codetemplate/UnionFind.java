package codetemplate;
/*
* 并查集
* */
public class UnionFind {
    int count;
    int[] parent;

    public UnionFind(int count) {
        this.count = count;
        this.parent = new int[count];
        for (int i = 0; i < count; i++) {
            parent[i] = i;
        }
    }
    public int find(int x){
        while (parent[x] != x){
            x = parent[x];
        }
        return x;
    }
    public void union(int p, int q){
        int rootP = find(p);
        int rootQ = find(q);
        if (rootQ == rootP){
            return;
        }
        parent[rootQ] = rootP;
    }
    public boolean isConnect(int p, int q){
        int rootP = find(p);
        int rootQ = find(q);
        return rootQ == rootP;
    }
    public int getCount(){
        return count;
    }
}
