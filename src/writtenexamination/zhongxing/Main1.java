package writtenexamination.zhongxing;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] sub = new int[4];
        for (int i = 0; i < 4; i++) {
            sub[i] = scanner.nextInt();
        }
        int min = scanner.nextInt();
        int max = scanner.nextInt();
        int[] temp = new int[5];
        temp[4] = 0;
        for (int i = 3; i >= 0; i--){
             temp[i] = -1 * sub[i] + temp[i + 1];
        }
        int minRes = min;
        int maxRes = max;
        for (int i = 0; i < 5; i++){
            if (temp[i] > 0){
                minRes = Math.max(minRes, min - Math.abs(temp[i]));
                maxRes = Math.min(maxRes, max - Math.abs(temp[i]));
            }else {
                minRes = Math.max(minRes, min + Math.abs(temp[i]));
                maxRes = Math.min(maxRes, max + Math.abs(temp[i]));
            }
        }
        System.out.println(maxRes - minRes + 1);
    }
}
