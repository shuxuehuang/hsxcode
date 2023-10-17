package lc.contest.contest367;

public class Mian2 {
    public static void main(String[] args) {
        Mian2 mian2 = new Mian2();
        mian2.shortestBeautifulSubstring("1100100101011001001"
                ,7);
    }
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        int nums1 = 0;
        int right = 0, left = 0;
        String res = s;
        while (right < n){
            if (s.charAt(right) == '1'){
                nums1++;
            }
            right++;
            while (nums1 == k){
                if ((right - left) < res.length()){
                    res = s.substring(left, right);
                }else if ((right - left) == s.length()){
                    res = res.compareTo(s.substring(left, right)) > 0 ? s.substring(left, right) : res;
                }
                if (s.charAt(left) == '1'){
                    nums1--;
                }
                left++;
            }

        }
        if (s.equals(res)){
            return "";
        }
        return res;
    }
}
