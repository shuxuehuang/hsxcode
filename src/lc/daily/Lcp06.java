package lc.daily;

import java.util.Arrays;

public class Lcp06 {
    public int minCount(int[] coins) {
        int res = 0;
        for (int coin : coins) {
            res += coin % 2 == 0 ? coin / 2 : (coin + 1) / 2;
        }
        return res;
    }
}
