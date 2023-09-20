package lc.upperdivision;

public class Solution1750 {
    public int minimumLength(String s) {
        int n = s.length();
        int left = 0, right = s.length() - 1;
        int res = n;
        while (left < right){
            if (s.charAt(left) == s.charAt(right)){
                char c = s.charAt(left);
                while (s.charAt(left) == c){
                    left++;
                }
                while (s.charAt(right) == c){
                    right--;
                }

            }
            if (right == left - 1){
                res = 0;
            }
            res = Math.min(res, right - left + 1);
        }

        return res;
    }
}
