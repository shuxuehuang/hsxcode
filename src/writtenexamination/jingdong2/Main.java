package writtenexamination.jingdong2;

import java.util.Scanner;

public class Main {
    static int res = 0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        String[] graph = new String[n];
        in.nextLine();
        for (int i = 0; i < n; i++) {
            graph[i] = in.nextLine();
        }
        char[][] chars = new char[n][m];
        for (int i = 0; i < n; i++) {
            chars[i] = graph[i].toCharArray();
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (chars[i][j] == 'o'){
                    for (int x = 0; x < n; x++) {
                        chars[x] = graph[x].toCharArray();
                    }
                    res = 0;
                    dfs(chars, i, j, k);
                    ans = Math.max(ans, res);
                }
            }
        }
        System.out.println(ans);
    }
    public static void dfs(char[][] chars, int i, int j, int k){
        if (k <= 0){
            return;
        }
        if (i < 0 || i >= chars.length || j < 0 || j >= chars[0].length){
            return;
        }
        if (chars[i][j] == '*' || chars[i][j] == 'r'){

            return;
        }
        if (i - 1 >= 0 && chars[i - 1][j] == 'r' && chars[i][j] == 'o'){
            res++;
        }
        chars[i][j] = 'r';
        dfs(chars, i + 1, j, k - 1);
        dfs(chars, i - 1, j, k - 1);
        dfs(chars, i , j - 1, k - 1);
        dfs(chars, i , j + 1, k - 1);
        chars[i][j] = 'o';
    }
}
