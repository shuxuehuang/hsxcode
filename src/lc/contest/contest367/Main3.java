package lc.contest.contest367;

public class Main3 {
    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        int n = nums.length;
        int[][] max = new int[n][2];
        int[][] min = new int[n][2];
        max[n - 1][0] = nums[n - 1];
        max[n - 1][1] = n-1;
        min[n - 1][0] = nums[n - 1];
        min[n - 1][1] = n - 1;
        int maxIndex = -1, minIndex = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] > max[i + 1][0]){
                max[i][0] = nums[i];
                max[i][1] = i;
            }else {
                max[i][0] = max[i + 1][0];
                max[i][1] = max[i + 1][1];
            }
            if (nums[i] < min[i + 1][0]){
                min[i][0] = nums[i];
                min[i][1] = i;
            }else {
                min[i][0] = min[i + 1][0];
                min[i][1] = min[i + 1][1];
            }
        }
        for (int i = 0; i < n - indexDifference; i++) {
            if (Math.abs(nums[i] - max[i + indexDifference][0]) >= valueDifference){
                return new int[]{i, max[i + indexDifference][1]};
            }
            if (Math.abs(nums[i] - min[i + indexDifference][0]) >= valueDifference){
                return new int[]{i , min[i + indexDifference][1]};
            }
        }
        return new int[]{-1, -1};
    }
}
