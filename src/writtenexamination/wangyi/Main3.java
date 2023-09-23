package writtenexamination.wangyi;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main3 {
    static BigDecimal res;
    public static void main(String[] args) {
        int mod = (int)1e9 + 7;
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        backTracking(arr, 0, 0, 0);
//        System.out.println((int)(res.));
//        int a = 3, b = 2;
//        System.out.println((double) a / b);

    }
    public static void backTracking(int[] arr, int startIndex, int sum, int length){
        if (length != 0){
//            res = res + (double) sum / length;
        }
        for (int i = startIndex; i < arr.length; i++) {
            sum += arr[i];
            length += 1;
            backTracking(arr, i + 1, sum, length);
            sum -= arr[i];
            length -= 1;
        }
    }
}
