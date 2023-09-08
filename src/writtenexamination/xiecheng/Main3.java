package writtenexamination.xiecheng;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int l = in.nextInt();
            int r = in.nextInt();
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = in.nextInt();
            }
            solution(arr, l , r);
        }
    }
    public static void solution(int[] arr, int l, int r){
        int n = arr.length;
        int sum = Arrays.stream(arr).sum();
        if (n * l > sum || n * r < sum){
            System.out.println(-1);
            return;
        }
        Arrays.sort(arr);
        int res = 0;
        int index = 0;
        while (arr[index] < l){
            res += l - arr[index];
            index++;
        }
        int temp = 0;
        index = n - 1;
        while (arr[index] > r){
            temp = arr[index] - r;
            index--;
        }
        System.out.println(Math.max(res, temp));
    }
}
