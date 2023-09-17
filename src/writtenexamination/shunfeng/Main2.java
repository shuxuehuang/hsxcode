package writtenexamination.shunfeng;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        solution(arr, k);
    }
    public static void solution(int[] arr, int k){
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (k == 0){
                break;
            }
            while (arr[i] != 0){
                if (k == 0) break;
                arr[i]--;
                arr[arr.length - 1]++;
                k--;
            }

        }
    }
}
