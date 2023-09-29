package lc.daily;

public class Solution605 {
    public static void main(String[] args) {
        Solution605 solution605 = new Solution605();
        solution605.canPlaceFlowers(new int[]{1,0,0,0,0,0,1}, 2);
    }
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        return dfs(flowerbed, 0, n);
    }
    public boolean dfs(int[] flowerbed, int i, int n){
        if (n <= 0){
            return true;
        }
        if (i >= flowerbed.length){
            return false;
        }

        boolean doIt = false;
        if ((i >= 1 && flowerbed[i - 1] != 1 && flowerbed[i] == 0 && i + 1 < flowerbed.length && flowerbed[i + 1] == 0)
        || (i == 0 && flowerbed[i] == 0 && i + 1 < flowerbed.length && flowerbed[i + 1] == 0)
        || (i == flowerbed.length - 1 && flowerbed[i] == 0 && flowerbed[i- 1] == 0)){
            flowerbed[i] = 1;
            doIt = dfs(flowerbed, i + 2, n - 1);
        }
        boolean notDo = dfs(flowerbed, i + 1, n);
        return doIt || notDo;

    }
}
