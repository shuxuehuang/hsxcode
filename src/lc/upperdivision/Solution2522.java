package lc.upperdivision;

public class Solution2522 {
    public static void main(String[] args) {
        Solution2522 solution2522 = new Solution2522();
        solution2522.minimumPartition("165462", 60);
    }
    public int minimumPartition(String s, int k) {
        int n = s.length();
        int res = 0;
        int temp = 0;
        for (int i = 0; i < n; i++) {
            int num = s.charAt(i) - '0';
            if (num > k){
                return -1;
            }
            temp = (temp * 10 + num);

            if (temp <= k && temp * 10 + (s.charAt(i + 1) - '0') > k){
                res ++;
                temp = 0;
            }
        }
        return res;
    }
    /*public int minimumPartition(String s, int k) {
        int n = s.length();
        int res = 0;
        int temp = 0;
        int left = 0, right = 0;
        while (left < n){
            while (right < n && temp <= k){
                int num = s.charAt(right) - '0';
                temp = temp * 10 + num;
                right++;
            }
            temp = 0;
            res ++;
            left = right;

        }
        return res;
    }*/
}
