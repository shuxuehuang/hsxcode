package writtenexamination.shengxinfu;

import java.util.Scanner;

public class Main4 {
    static int res = 0;
    static int[][] direction = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        int m = in.nextInt();
        int n = in.nextInt();
        dfs(0, 0, m, n, k, new boolean[m + 1][n + 1]);
        System.out.println(res);
    }
    public static void dfs(int x, int y, int m, int n, int k, boolean[][] isVisited){
        if (x < 0 || x > m || y < 0 || y > n){
            return;
        }
        if ((Math.abs(m - x) + Math.abs(n - y)) > k){
            return;
        }
        if (k <= 0){
            return;
        }
        if (isVisited[x][y]){
            return;
        }
        if (x == m && y == m){
            res++;
            return;
        }

        for (int i = 0; i < 4; i++) {
            isVisited[x][y] = true;
            k--;
            dfs(x + direction[i][0], y + direction[i][1], m, n, k, isVisited);
            k++;
            isVisited[x][y] = false;
        }
    }

}
