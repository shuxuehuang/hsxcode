package writtenexamination.mihayou;

import java.util.Arrays;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long[] a = new long[n];
        long[] b = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = in.nextInt();
        }
        long res = 0;
        long sumA = Arrays.stream(a).sum();
        long sumB = Arrays.stream(b).sum();
        for (int i = 0; i < n; i++){
            long temp = sumA;
            temp -= a[i];
            res = Math.max(res, temp ^ sumB);
        }
        for (int i = 0; i < n; i++){
            long temp = sumB;
            temp -= b[i];
            res = Math.max(res, temp ^ sumA);
        }
        System.out.println(res);
        /*if (sumA < sumB){
            sumA -= Arrays.stream(a).max().getAsLong();
        }else {
            sumB -= Arrays.stream(b).max().getAsLong();
        }
        System.out.println(sumA ^ sumB);*/
    }
}
