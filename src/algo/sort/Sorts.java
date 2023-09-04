package algo.sort;

import java.util.Arrays;

public class Sorts {
    public void bubbleSort(int[] arr){
        int len = arr.length;
        if (len <= 1){
            return;
        }
        for (int i = 0; i < len; i++){
            for (int j = i + 1; j < len; j++){
                if (arr[i] > arr[j]){
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }

    public void insertSort(int[] arr){
        int n = arr.length;
        if (n <= 1){
            return;
        }
        for (int i = 1; i < n; i++){
            int j = i - 1;
            int value = arr[i];
            for (; j >= 0; j--){

                if (arr[j] > value){
                    arr[j + 1] = arr[j];
                }else {
                    break;
                }
            }
            arr[j + 1] = value;
        }
    }

    public void selectSort(int[] arr){
        int len = arr.length;
        if (len <= 1)return;
        for (int i = 0; i < len; i++){
            int minIndex = i;
            for (int j = i + 1; j < len; j++){
                if (arr[minIndex] > arr[j]){
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        Sorts sorts = new Sorts();
        int[] array = new int[]{3, 4, 2, 1, 5, 6, 7, 8};
//        sorts.bubbleSort(array);
//        sorts.insertSort(array);
        sorts.selectSort(array);
        Arrays.stream(array).forEach(a -> System.out.print(a + " "));
    }
}
