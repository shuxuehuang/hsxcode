package writtenexamination.jingdong;

import java.util.*;

public class Main2 {
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
        if (n < 3){
            System.out.println(0);
            return;
        }
        int res = 0;
        int left = 0, right = 0;
        while (left < n){
            while (left + 1 < n && arr[left] <= arr[left + 1]){
                left++;
            }
            right = left + 1;
            while (right < n && arr[right] > arr[right - 1]){
                right++;
            }
            int length = right - left;
            if (length > 3){
                if ((length - 2) % 3 == 0){
                    res += (length - 2) / 3;
                }else {
                    res += (length - 2) / 3 + 1;
                }

            }
        }
        System.out.println(res);
    }*/
    public static void solution(int[] arr){
        int n = arr.length;
        if (n < 3){
            System.out.println(0);
            return;
        }
        int res = 0;
        int left = 0, right = 0;
        while (right < n){
            right++;
            if (right - left == 3){
                if ((arr[left] < arr[left + 1] || arr[left] == arr[left + 1])&&
                        (arr[left + 1] < arr[left + 2] || arr[left + 1] == arr[left + 2])){
                    res++;
                    arr[left + 1] = arr[left + 2] + 1;
                }
                left++;
            }
        }
        System.out.println(res);
    }

}
