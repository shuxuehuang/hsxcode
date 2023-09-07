package codetemplate;

import javax.swing.*;
import java.util.Arrays;

/*
* 快排代码
* */
public class QuikSort {
    public static int partition(int[] arr, int low, int high){
        int pivot = arr[high];
        int pointer = low;
        for (int i = low; i < high; i++) {
            if (arr[i] <= pivot){
                int temp = arr[i];
                arr[i] = arr[pointer];
                arr[pointer] = temp;
                pointer++;
            }

        }
        int temp = arr[pointer];
        arr[pointer] = arr[high];
        arr[high] = temp;
//        System.out.println(Arrays.toString(arr));
        return pointer;
    }
    public static void sort(int[] arr, int l, int r){
        if (l >= r){
            return;
        }
        int position = partition(arr, l, r);
        sort(arr, l, position - 1);
        sort(arr, position + 1, r);
    }
    public static void main(String[] args) {
        int[] arr = {8, 7, 6, 1, 0, 9, 2};
//        int[] arr = {6,72,113,11,23};
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
