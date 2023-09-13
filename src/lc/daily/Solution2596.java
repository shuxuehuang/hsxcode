package lc.daily;

import javafx.util.Pair;

import java.util.PriorityQueue;

public class Solution2596 {
    public boolean checkValidGrid(int[][] grid) {
        int n = grid.length;
        PriorityQueue<Pair<Integer, int[]>> queue = new PriorityQueue<>((a, b) -> a.getKey() - b.getKey());
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                queue.offer(new Pair<>(grid[i][j], new int[]{i, j}));
            }
        }
        Pair<Integer, int[]> pre = queue.poll();
        while (!queue.isEmpty()){
            int[] preIndex = pre.getValue();
            Pair<Integer, int[]> next = queue.poll();
            int[] nextIndex = next.getValue();
            if ((Math.abs(nextIndex[0] - preIndex[0]) == 2 && Math.abs(nextIndex[1] - preIndex[1]) == 1)
            || (Math.abs(nextIndex[0] - preIndex[0]) == 1 && Math.abs(nextIndex[1] - preIndex[1]) == 2)){
                continue;
            }else {
                return false;
            }
        }
        return true;
    }
}
