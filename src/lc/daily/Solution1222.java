package lc.daily;

import java.util.*;

public class Solution1222 {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        int x = king[0], y = king[1];
        List<List<Integer>> res = new ArrayList<>();
        int[][] arr = new int[8][8];
        for (int[] queen: queens){
            arr[queen[0]][queen[1]] = 1;
        }
        for (int i = x - 1; i >= 0; i++){
            if (arr[i][y] == 1){
                res.add(new ArrayList<>(Arrays.asList(i, y)));
                break;
            }
        }
        for (int i = x + 1; i < 8; i++){
            if (arr[i][y] == 1){
                res.add(new ArrayList<>(Arrays.asList(i, y)));
                break;
            }
        }
        for (int j = y - 1; j >=0 ; j--) {
            if (arr[x][j] == 1){
                res.add(new ArrayList<>(Arrays.asList(x, j)));
                break;
            }
        }
        for (int j = y + 1; j < 8 ; j++) {
            if (arr[x][j] == 1){
                res.add(new ArrayList<>(Arrays.asList(x, j)));
                break;
            }
        }
        for (int i = x - 1; i >= 0; i--) {
            if (arr[i][i] == 1){
                res.add(new ArrayList<>(Arrays.asList(i, i)));
                break;
            }
        }
        for (int i = x + 1; i < 8; i++) {
            if (arr[i][i] == 1){
                res.add(new ArrayList<>(Arrays.asList(i, i)));
                break;
            }
        }
        int temp = 1;
        for (int i = x + 1; i < 8; i++) {
            if (arr[i][y - temp] == 1){
                res.add(new ArrayList<>(Arrays.asList(i, y - temp)));
                break;
            }
            temp++;
        }
        temp = 1;
        for (int i = x - 1; i >= 0; i--) {
            if (arr[i][y + temp] == 1){
                res.add(new ArrayList<>(Arrays.asList(i, y + temp)));
                break;
            }
            temp++;
        }
        return res;
    }
}
