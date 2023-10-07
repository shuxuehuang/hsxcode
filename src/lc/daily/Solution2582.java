package lc.daily;

public class Solution2582 {
    public int passThePillow(int n, int time) {
        boolean tar = true;
        int res = 1;
        while (time > 0){
            if (tar){
                res ++;
                if (res == n){
                    tar = false;
                }
            }else {
                res --;
                if (res == 1){
                    tar = true;
                }
            }
            time--;
        }
        return res;
    }
}
