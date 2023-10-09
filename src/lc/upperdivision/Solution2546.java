package lc.upperdivision;

import java.util.Map;
import java.util.TreeSet;

//rating1604
public class Solution2546 {
    public static void main(String[] args) {
        Solution2546 solution2546 = new Solution2546();
        solution2546.makeStringsEqual("11", "00");
    }
    /*public boolean makeStringsEqual(String s, String target) {
        int n = s.length();
        char[] charsS = s.toCharArray();
        char[] charsT = target.toCharArray();
        //1可以换到任意一个0的位置
        for (int i = 0; i < n; i++) {
            if (charsS[i] == charsT[i]) continue;
            if (charsS[i] == '1' && charsT[i] == '0'){
                for (int j = i + 1; j < n; j++){
                    if (charsS[j] == '1'){
                        charsS[i] = '0';
                        break;
                    }
                }
                for (int j = i - 1; j >= 0; j--){
                    if (charsS[j] == '1'){
                        charsS[i] = '0';
                        break;
                    }
                }

                if (charsS[i] == '1') return false;
            }else {
                for (int j = i + 1; j < n; j++){
                    if (charsS[j] == '1'){
                        charsS[i] = '1';
                        break;
                    }
                }
                for (int j = i - 1; j >= 0; j--){
                    if (charsS[j] == '1'){
                        charsS[i] = '1';
                        break;
                    }
                }
                if (charsS[i] == '0') return false;
            }
        }
        return true;
    }*/
    public boolean makeStringsEqual(String s, String target) {
        int n = s.length();
        char[] charsS = s.toCharArray();
        char[] charsT = target.toCharArray();
        int num1 = 0;
        int num0 = 1;
        for (int i = 0; i < n; i++) {
            if (charsS[i] == '1'){
                num1++;
            }else {
                num0++;
            }
        }
        for (int i = 0; i < n; i++) {
            if (charsT[i] == '1'){
                num1--;
            }else {
                num0--;
            }
        }
        System.out.println(num0);
        System.out.println(num1);
        return num1 == 0 && num0 == 0;
    }
}
