package algo.sort;

import java.util.Arrays;

public class QuikSort {
    public void sort(int[] arr){
        int n = arr.length;
        if (n <= 1){
            return;
        }
        quickSort(arr, 0, n - 1);
    }
    public void quickSort(int[] arr, int l, int r){
        if (l >= r){
            return;
        }
        int p = partition(arr, l, r);
        quickSort(arr, l, p - 1);
        quickSort(arr, p + 1, r);
    }

    public int partition(int[] arr, int l, int r){
        int pivot = arr[r];
        int pointer = l;
        for (int i = l; i < r; i++){
            if (arr[i] < pivot){
                int temp = arr[pointer];
                arr[pointer] = arr[i];
                arr[i] = temp;
                pointer++;
            }
        }
        int temp = arr[r];
        arr[r] = arr[pointer];
        arr[pointer] = temp;
        return pointer;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5,4,3,6,7,8};
        QuikSort quikSort = new QuikSort();
        quikSort.sort(arr);
        Arrays.stream(arr).forEach(a -> System.out.print(a + " "));
    }
}
