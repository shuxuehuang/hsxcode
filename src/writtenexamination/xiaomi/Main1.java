package writtenexamination.xiaomi;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] split = s.split(",");
        int towersNum = Integer.parseInt(split[0]);
        int radius = Integer.parseInt(split[1]);
        int[][] towers = new int[towersNum][3];
        for (int i = 0; i < towersNum; i++) {
            String line = in.nextLine();
            String[] split1 = line.split(",");
            for (int j = 0; j < 3; j++) {
                towers[i][j] = Integer.parseInt(split1[j]);
            }
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) ->{
         if (a[2] != b[2]){
             return b[2] - a[2];
         }else if (a[0] != b[0]){
             return a[0] - b[0];
         }else {
             return a[1] - b[1];
         }
        });
        for (int i = 0; i <= 100; i++) {
            for (int j = 0; j <= 100; j++) {
                int temp = 0;
                for (int[] tower : towers){
                    double d = Math.sqrt(Math.pow(i - tower[0],2) + Math.pow(j - tower[1], 2));
                    if (d > radius){
                        continue;
                    }
                    temp += tower[2] / (1 + d);
                }
                queue.offer(new int[]{i, j, temp});
            }
        }
        System.out.println(queue.peek()[0] + "," + queue.peek()[1]);
    }
}
