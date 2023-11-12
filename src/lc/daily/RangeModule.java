package lc.daily;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RangeModule {
    List<int[]> list;
    public RangeModule() {
        list = new ArrayList<>();
    }

    public void addRange(int left, int right) {
        list.add(new int[]{left, right});
        Collections.sort(list, (a, b) -> a[0] - b[0]);
        List<int[]> temp = new ArrayList<>();
        temp.add(list.remove(0));
        for (int[] range : list){
            int[] ints = temp.get(temp.size() - 1);
            if (range[0] > ints[1]){
                temp.add(range);
            }else if (range[0] >= ints[0] && range[0] <= ints[1]){
                ints[1] = Math.max(range[1], ints[1]);
            }
        }
        list = temp;
    }

    public boolean queryRange(int left, int right) {
        for (int[] range : list){
            int index1 = range[0];
            int index2 = range[1];
            if (left >= index1 && right <= index2){
                return true;
            }
        }
        return false;
    }

    public void removeRange(int left, int right) {
        List<int[]> temp = new ArrayList<>();
        for (int[] range : list){
            int index1 = range[0];
            int index2 = range[1];
            if (left > index1 && right < index2){
                temp.add(new int[]{index1, left});
                temp.add(new int[]{right, index2});
            }else if (left == index1 && right < index2){
                temp.add(new int[]{right, index2});
            }else if (left > index1 && right == index2){
                temp.add(new int[]{index1, left});
            }else if (left > index2 || right < index1){
                temp.add(range);
            }
        }
        list = temp;
    }
}
