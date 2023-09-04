package algo.binarysearch;

public class Bsearch {
    public int bSearch(int[] arr, int target){
        int l = 0, r = arr.length;
        while (l <= r){
            int mid = l + (r - l) / 2;
            if (arr[mid] == target){
                return mid;
            }else if (arr[mid] < target){
                l = mid + 1;
            }else {
                r = mid - 1;
            }
        }
        return -1;
    }
    /**
     * 二分查找递归实现
     */
    public int dBSearch(int[] arr, int l, int r, int target){
        if (l > r){
            return - 1;
        }
        int mid = l + (r - l) / 2;
        if (arr[mid] == target){
            return mid;
        }else if (arr[mid] < target){
            return dBSearch(arr, mid + 1, r, target);
        }else {
            return dBSearch(arr, l, mid - 1, target);
        }
    }
    /**
     * 查找第一个 值等于给定值 的元素
     */
    public int bSearch1(int[] arr, int target){
        int left = 0, right = arr.length - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (arr[mid] < target){
                left = mid + 1;
            }else if (arr[mid] >  target){
                right = mid - 1;
            }else {
                if (mid == 0 || arr[mid - 1] != target) return mid;
                right = mid - 1;
            }
        }
        return -1;
    }
    /**
     * 查找最后一个 值等于给定值的元素
     */
    public int bSearch2(int[] arr, int target){
        int left = 0, right = arr.length - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (arr[mid] > target){
                right = mid - 1;
            }else if (arr[mid] < target){
                left = mid + 1;
            }else {
                if (mid == arr.length - 1 || arr[mid + 1] != target) return mid;
                left = mid + 1;
            }
        }
        return -1;
    }
    /**
     * 查找第一个 大于等于给定值的元素
     */
    public int bSearch3(int[] arr, int target){
        int left = 0, right = arr.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if (arr[mid] >= target){
                if (mid == 0 || arr[mid - 1] < target) return mid;
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return -1;
    }
    /**
     * 查找最后一个小于等于给定值的元素
     */
    public int bSearch4(int[] arr, int target){
        int left = 0, right = arr.length - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (mid <= target){
                if (mid == arr.length - 1 || arr[mid + 1] > target) return mid;
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return -1;
    }

}

