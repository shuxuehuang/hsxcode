package lc.daily;

import java.util.HashMap;

public class Solution2525 {
    public String categorizeBox(int length, int width, int height, int mass) {
        int[] type = new int[2];
        if (length >= 1e4 || width >= 1e4 || height >= 1e4 ||  ((long) length * width * height) >= 1e9){
            type[0] = 1;
        }
        if (mass >= 100){
            type[1] = 1;
        }
        if (type[0] == 1 && type[1] == 1){
            return "Both";
        }else if (type[0] == 0 && type[1] == 0){
            return "Neither";
        }else if (type[0] == 1 && type[1] == 0) {
            return "Bulky";
        }else if (type[0] == 0 && type[1] == 1){
            return "Heavy";
        }
        return null;
    }
}
