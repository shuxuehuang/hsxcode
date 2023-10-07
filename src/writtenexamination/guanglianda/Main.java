package writtenexamination.guanglianda;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = in.nextInt();
        }
        Arrays.sort(a);
        Integer[] idx = new Integer[m];
        for (int i = 0; i < m; i++) {
            idx[i] = i;
        }
        Arrays.sort(idx, (x1, x2) -> b[x2] - b[x1]);
        int res = 0;
        for (int i = 0; i < m; i++) {
            res += a[i] * b[idx[i]] * 0.01;
        }
        System.out.println(res);
    }
}
