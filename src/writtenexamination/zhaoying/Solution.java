package writtenexamination.zhaoying;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            queue.offer(new int[]{scanner.nextInt(), scanner.nextInt()});
        }
        int res = 1;
        int endTime = queue.poll()[1];
        while(!queue.isEmpty()){
            int[] x = queue.poll();
            if (x[0] >= endTime){
                endTime = x[0];
                res++;
            }
        }
        System.out.println(res);
    }
}
