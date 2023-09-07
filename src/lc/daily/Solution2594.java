package lc.daily;

import java.util.Arrays;
/*
* 最短修车时间，答案有单调性的考虑二分答案的方法
* */
public class Solution2594 {
    public long repairCars(int[] ranks, int cars) {
        return binarySearch(ranks, cars, 0, Long.MAX_VALUE);
    }
    public long binarySearch(int[] ranks, int cars, long l, long r){
        while (l <= r){
            long mid = (r - l) / 2 + l;
            if (check(ranks, cars, mid)){
                r = mid - 1;
            }else {
                l = mid + 1;
            }
        }
        return l;
    }
    public boolean check(int[] ranks, int cars, long time){
        int n = 0;
        for (int r : ranks){
            n += Math.sqrt(time / r);
        }
        return n > cars;
    }
}
