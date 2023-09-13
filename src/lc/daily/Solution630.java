package lc.daily;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution630 {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a ,b) -> a[1] - b[1]);
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int day = 0;
        int res = 0;
        for (int[] course : courses){
            int needDays = course[0];
            int lastDay = course[1];
            if (day + needDays <= lastDay){
                res ++;
                queue.offer(needDays);
            }else if (!queue.isEmpty() && needDays < queue.peek()){
                int longestDay = queue.poll();
                day -= longestDay;
                day += needDays;
                queue.offer(needDays);

            }
        }
        return res;
    }
}
