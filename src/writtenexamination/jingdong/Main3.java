package writtenexamination.jingdong;

import java.util.Arrays;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        solution(arr);
    }
    /*public static void solution(int[] arr){
        int n = arr.length;
        Integer[] ids = new Integer[n];
        for (int i = 0; i < n; i++) {
            ids[i] = i;
        }
        Arrays.sort(ids, (a, b) -> arr[a] - arr[b]);
        int res = 0;
        for (int i = 0; i < n; i++) {
            int index = ids[i];
            if (i % 2 == 0 && index % 2 == 0){
                res++;
            }else if (i % 2 == 1 && index % 2 == 1){
                res++;
            }else {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(res);
    }*/
    public static void solution(int[] arr){
        int n = arr.length;
        int res = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n - i; j++){
                if (arr[j] > arr[j + 2]){
                    int temp = arr[j + 2];
                    arr[j + 2] = arr[j];
                    arr[j] = temp;
                    res++;
                }
            }

        }
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]){
                System.out.println(-1);
                return;
            }
        }
        System.out.println(res);
    }
}

