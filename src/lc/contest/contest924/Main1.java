package lc.contest.contest924;

public class Main1 {
    public String maximumOddBinaryNumber(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        int num1 = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '1'){
                num1++;
            }
        }
        StringBuilder sb = new StringBuilder();
        while (num1 > 1){
            sb.append(1);
            num1--;
        }
        while (sb.length() < n - 1){
            sb.append(0);
        }
        sb.append(1);
        return sb.toString();
    }
}
