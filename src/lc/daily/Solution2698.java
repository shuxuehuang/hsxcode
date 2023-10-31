package lc.daily;

public class Solution2698 {
    boolean isValid;

    public static void main(String[] args) {
        Solution2698 solution2698 = new Solution2698();
        solution2698.backTracking("1369", 37, 0, 0);
    }
    public int punishmentNumber(int n) {
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            isValid = false;
            backTracking(String.valueOf(i * i), i, 0, 0);
            if (isValid){
                ans += i * i;
            }
        }
        return ans;
    }
    public void backTracking(String num, int target, int startIndex, int sum){
        if (sum == target && startIndex == num.length()){
            isValid = true;
            return;
        }
        for (int i = 1; i <= num.length() - startIndex; i++) {
            int temp = Integer.parseInt(num.substring(startIndex, startIndex + i));
            sum += temp;
            backTracking(num, target, startIndex + i, sum);
            sum -= temp;
        }
    }
}
