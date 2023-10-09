package lc.contest.contest366;

import java.util.*;

public class Main3 {
    public static void main(String[] args) {
        Main3 main3 = new Main3();
        main3.minOperations("0110010001101011010",
                "1011110101000001100",
                3);
    }
    public int minOperations(String s1, String s2, int x) {
        int n = s1.length();
        TreeSet<Integer> idx = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) != s2.charAt(i)){
                idx.add(i);
            }
        }
        if (idx.size() % 2 != 0){
            return -1;
        }
        int res = 0;
        List<Integer> left = new LinkedList<>();
        Iterator<Integer> iterator = idx.iterator();
        while (iterator.hasNext()){
            Integer index = iterator.next();
            Integer floor = idx.floor(index);
            Integer ceiling = idx.ceiling(index);
            if (floor == null && ceiling != null&& ceiling - index <= x){
                res += ceiling - index;
                idx.remove(index);
                idx.remove(ceiling);
            }else if (ceiling == null && floor != null && index - floor <= x){
                res += index - floor;
                idx.remove(index);
                idx.remove(floor);
            }else if (ceiling != null && floor != null){
                int minDis = 0;
                if (index - floor < ceiling - index){
                    minDis = index - floor;
                    if (minDis < x){
                        res += minDis;
                        idx.remove(index);
                        idx.remove(floor);
                    }else {
                        left.add(index);
                    }
                }else {
                    minDis = ceiling - index;
                    if (minDis < x){
                        res += minDis;
                        idx.remove(index);
                        idx.remove(ceiling);
                    }else {
                        left.add(index);
                    }
                }
            }else {
                left.add(index);
            }
        }
        res += left.size() / 2 * x;
        return res;
    }
}
