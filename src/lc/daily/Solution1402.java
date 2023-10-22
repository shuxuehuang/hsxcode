package lc.daily;

import java.util.Arrays;

public class Solution1402 {
    /*public int maxSatisfaction(int[] satisfaction) {
        int n = satisfaction.length;
        Arrays.sort(satisfaction);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0, time = 1;
            for (int j = i; j < n; j++) {
                sum += (satisfaction[j] * time);
                time++;
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }*/
    public int maxSatisfaction(int[] satisfaction) {
        int n = satisfaction.length;
        Arrays.sort(satisfaction);
        int s = 0;
        int f = 0;
        for (int i = n - 1; i >= 0 ; i--) {
            s += satisfaction[i];
            if (s < 0) break;
            f += s;
        }
        return f;
    }
}
