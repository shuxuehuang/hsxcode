package writtenexamination.jingdong;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] red = new int[n];
        int[] blue = new int[n];
        for (int i = 0; i < n; i++) {
            red[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            blue[i] = red[in.nextInt() - 1] + red[in.nextInt() - 1];
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += Math.min(red[i], blue[i]);
        }
        System.out.println(res);
    }
}
