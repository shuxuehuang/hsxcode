package codetemplate;

public class Sort {
    /*
    * 冒泡
    * */
    public  static int[] bubbleSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            boolean flag = true;
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = false;
                }
            }
            if (flag){
                break;
            }
        }
        return arr;
    }

    public static int[] selectionSort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++){
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i){
                int tmp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = tmp;
            }
        }
        return arr;
    }
    public static int[] insertionSort(int[] arr){
        for (int i = 1; i < arr.length; i++){
            int preIndex = i -1;
            int current = arr[i];
            while (preIndex >= 0 && current < arr[preIndex]){
                arr[preIndex + 1] = arr[preIndex];
                preIndex --;
            }
            arr[preIndex + 1] = current;
        }
        return arr;
    }
}
