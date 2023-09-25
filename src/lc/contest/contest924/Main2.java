package lc.contest.contest924;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Main2 {
    public static void main(String[] args) {
        Main2 main2 = new Main2();
        main2.maximumSumOfHeights(new LinkedList<>(Arrays.asList(5,3,4,1,1)));
    }
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        int n = maxHeights.size();
        int maxHeight = 0;
        long res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, calSum(maxHeights, i, maxHeights.get(i)));
        }
        /*List<Integer> maxIndex = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (maxHeights.get(i) > maxHeight){
                maxHeight = maxHeights.get(i);
            }
        }
        for (int i = 0; i < n; i++) {
            if (maxHeights.get(i) == maxHeight){
                maxIndex.add(i);
            }
        }
        long res = 0;
        for(int index : maxIndex){
            res = Math.max(res, calSum(maxHeights, index, maxHeight));
        }*/
        return res;
    }
    public long calSum(List<Integer> maxHeights, int maxIndex, int maxHeight){
        int n = maxHeights.size();
        long[] heights = new long[n];
        heights[maxIndex] = maxHeight;
        long preHeight = maxHeight;
        for (int i = maxIndex - 1; i >= 0; i--) {
            if (maxHeights.get(i) <= preHeight){
                heights[i] = maxHeights.get(i);
            }else {
                heights[i] = preHeight;
            }
            preHeight = heights[i];
        }

        preHeight = maxHeight;
        for (int i = maxIndex + 1; i < n; i++) {
            if (maxHeights.get(i) <= preHeight){
                heights[i] = maxHeights.get(i);
            }else {
                heights[i] = preHeight;
            }
            preHeight = heights[i];
        }
        long sum = Arrays.stream(heights).sum();
        return sum;
    }
}
