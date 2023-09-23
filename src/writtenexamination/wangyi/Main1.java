package writtenexamination.wangyi;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = in.nextInt();
            }
            solution(arr);
        }

    }
    /*public static void solution(int[] arr){
        int n = arr.length;
        if (n == 1){
            System.out.println("YES");
            return;
        }
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]){
                int num1 = arr[(i + 2) % n];
                int num2 = arr[(i + 2 + 1) % n];
                if (num1 <= arr[i + 1]){
                    int temp = arr[i];
                    arr[i] = num1;
                    arr[(i + 2) % n] = temp;
                }else if (num2 >= arr[i]){
                    int temp = arr[i + 1];
                    arr[i + 1] = num2;
                    arr[(i + 2 + 1) % n] = temp;
                }else {
                    System.out.println("NO");
                    return;
                }

            }
        }
        System.out.println("YES");
    }*/
    /*public static void solution(int[] arr){
        int n = arr.length;
        if (n == 1){
            System.out.println("YES");
            return;
        }
        HashMap<Integer, Integer> oldMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            oldMap.put(arr[i], i);
        }
        Arrays.sort(arr);
        HashMap<Integer, Integer> newMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            newMap.put(arr[i], i);
        }
        for (int i = 0; i < n; i++){
            int oldIndex = oldMap.get(arr[i]);
            int newIndex = newMap.get(arr[i]);
            if (Math.abs(oldIndex - newIndex) != 2 || Math.abs(oldIndex - newIndex) != 0){
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }*/
    /*public static void solution(int[] arr){
        int n = arr.length;
        if (n == 1){
            System.out.println("YES");
            return;
        }
        int[] newArr = new int[2 * n];
        for (int i = 0; i < n; i++){
            newArr[i] = arr[i];
        }
        for (int i = n; i < 2 * n; i++){
            newArr[i] = arr[i - n];
        }
        for (int i = 0; i <= n - 1; i++) {
            int index = i;
            while (index < n - 2 && newArr[index] >= newArr[index + 2]){
                int temp = newArr[index];
                newArr[index] = newArr[index + 2];
                newArr[index + 2] = temp;
            }
        }
        for (int i = 0; i < n - 1; i++) {
            if (newArr[i] > newArr[i + 1]){
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }*/
    public static void solution(int[] arr){
        Integer[] ids = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ids[i] = i;
        }
        Arrays.sort(ids, (a, b) -> {
            return arr[a] - arr[b];
        });
        for (int i = 0; i < ids.length; i++) {
            if (Math.abs(i - ids[i]) != 0 && Math.abs(i - ids[i]) != 2){
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
        return;
    }


}
