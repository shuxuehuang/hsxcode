package writtenexamination.shunfeng2;

import java.util.Arrays;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        solution(arr, m);
    }
    public static void solution(int arr[], int m){
        int n = arr.length;
        Arrays.sort(arr);
        int left = 0, right = n - 1;
        int res = 0;
        while (left < right){
            while (arr[right] >= m){
                right--;
                res++;
            }
            int power = arr[right];
            int need = m % power == 0 ? m / power : m / power + 1;
            left += (need - 1);
            right--;
            res++;
        }
        System.out.println(res);
    }
}
