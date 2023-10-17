package lc.contest.contest367;

public class Main4 {
    public int[][] constructProductMatrix(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int mod = 12345;
        int[][] p = new int[m][n];
        int suffix = 1;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0 ; j--) {
                p[i][j] = suffix;
                suffix = suffix * grid[i][j] % mod;
            }
        }
        int pre = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                p[i][j] = pre * p[i][j] % mod;
                pre = pre * grid[i][j] % mod;
            }
        }
        return p;
    }
}
