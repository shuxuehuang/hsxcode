package writtenexamination.xiecheng;

import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        String[] temp = new String[n];
        for (int i = 0; i < n; i++) {
            temp[i] = in.next();
        }
        char[][] chars = new char[n][m];
        for (int i = 0; i < n; i++) {
            chars[i] = temp[i].toCharArray();
        }
        int[][] row = new int[3][n];
        int[][] col = new int[3][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                switch (chars[i][j]){
                    case 'y':
                        row[0][i] ++;
                        col[0][j] ++;
                        break;
                    case 'o':
                        row[1][i] ++;
                        col[1][j] ++;
                        break;
                    case 'u':
                        row[2][i]++;
                        col[2][j]++;
                        break;
                }
            }
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (chars[i][j] == 'y'){
                    ans += row[1][i] * col[2][j];
                    ans += row[2][i] * col[1][j];
                } else if (chars[i][j] == 'o') {
                    ans += row[0][i] * col[2][j];
                    ans += row[2][i] * col[0][j];
                }else if (chars[i][j] == 'u'){
                    ans += row[0][i] * col[1][j];
                    ans += row[1][i] * col[0][j];
                }
            }
        }
        System.out.println(ans);
    }
}
