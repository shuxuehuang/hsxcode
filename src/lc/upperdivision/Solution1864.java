package lc.upperdivision;

public class Solution1864 {
    public int minSwaps(String s) {
        int n = s.length();
        int num0 = 0, num1 = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '0'){
                num0++;
            }else {
                num1++;
            }
        }
        if (Math.abs(num0 - num1) > 1){
            return -1;
        }
        StringBuilder s0 = new StringBuilder();
        StringBuilder s1 = new StringBuilder();
        for (int i = 0; i < n; i++) {
            s0.append(i % 2);
            s1.append((i + 1) % 2 );
        }
        String s2 = s0.toString();
        String s3 = s1.toString();
        int dif1 = 0;
        int dif2 = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != s2.charAt(i)){
                dif1++;
            }
            if (s.charAt(i) != s3.charAt(i)){
                dif2++;
            }
        }
        return Math.min(dif1, dif2) / 2;
    }
}
