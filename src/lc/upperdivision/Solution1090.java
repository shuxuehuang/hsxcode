package lc.upperdivision;

import writtenexamination.cvte.main;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution1090 {
    public static void main(String[] args) {
        Solution1090 solution1090 = new Solution1090();
        solution1090.largestValsFromLabels(new int[]{3,2,3,2,1}, new int[]{1,0,2,2,1}, 2, 1);
    }
        /*public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
            PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> b[0] - a[0]);
            Map<Integer, Integer> map2 = new HashMap<>();
            for (int i = 0; i < values.length; i++) {
                queue.offer(new int[]{values[i], labels[i]});
            }
            Arrays.sort(values);
            int res = 0;
            for (int i = values.length - 1; i >= 0; i--){
                int[] x = queue.poll();
                int value = x[0];
                int label = x[1];
                if (numWanted == 0){
                    return res;
                }
                if (map2.get(label) == null || map2.get(label) < useLimit){
                    res += value;
                    map2.put(label, map2.getOrDefault(label, 0) + 1);
                    numWanted--;
                }
            }
            return res;
        }*/
        public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
            int n = values.length;
            Map<Integer, Integer> map2 = new HashMap<>();
            Integer[] id = new Integer[n];
            for (int i = 0; i < n; i++) {
                id[i] = i;
            }
            int res = 0;
            Arrays.sort(id, (a, b) -> values[b] - values[a]);
            for (int i = 0; i < n; i++){
                int value = values[id[i]];
                int label = labels[id[i]];
                if (numWanted == 0){
                    return res;
                }
                if (map2.get(label) == null || map2.get(label) < useLimit){
                    res += value;
                    map2.put(label, map2.getOrDefault(label, 0) + 1);
                    numWanted--;
                }
            }
            return res;
        }
}
