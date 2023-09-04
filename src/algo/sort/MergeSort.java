package algo.sort;

import java.util.Arrays;

public class MergeSort {
    public void sort(int[] arr){
        int n = arr.length;
        if (n <= 1){
            return;
        }
        mergeSort(arr, 0, n - 1);
    }

    private void mergeSort(int[] arr, int l, int r) {
        if (l >= r){
            return ;
        }
        int mid = (l + r) / 2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    public void merge(int[] arr, int l, int mid, int r){
        int[] temp = new int[arr.length];
        int i = l, j = mid + 1;
        int index = l;
        while (i <= mid && j <= r){
            if (arr[i] > arr[j]){
                temp[index++] = arr[j++];
            }else {
                temp[index++] = arr[i++];
            }
        }
        if (i <= mid){
            for (int k = i; k <= mid; k++){
                temp[index++] = arr[k];
            }
        }
        if (j <= r){
            for (int k = j; k <= r; k++){
                temp[index++] = arr[k];
            }
        }
        for(int k = l; k <= r; k++){
            arr[k] = temp[k];
        }
    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] array = new int[]{9, 5, 2, 1, 5, 6, 7, 8};
        mergeSort.sort(array);
        Arrays.stream(array).forEach(a -> System.out.print(a + " "));
    }

}
