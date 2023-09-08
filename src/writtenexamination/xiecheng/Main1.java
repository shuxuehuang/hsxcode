package writtenexamination.xiecheng;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main1 {
    static List<List<Integer>> res = new LinkedList<>();
    static List<Integer> path = new LinkedList<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int ans = 0;
        boolean[] isVisited = new boolean[n + 1];
        backTracking(n, 1, isVisited);
//        for (List<Integer> list : res){
//            if (!isValid(list)){
//                ans++;
//            }
//        }
        System.out.println(res.size());
    }
    public static boolean isValid(List<Integer> list){
        for (int i = 1; i < list.size(); i++){
            if (!isNum(list.get(i) + list.get(i - 1))){
                return false;
            }
        }
        return true;
    }
    public static boolean isNum(int num){
        for (int i = 2; i < num; i++){
            if (num % i == 0){
                return false;
            }
        }
        //是一个质数
        return true;
    }
    public static void backTracking(int n, int startIndex, boolean[] isVisited){
        if (path.size() == n){
            res.add(new LinkedList<>(path));
            return;
        }
        for (int i = 1; i <= n; i++){
            if (isVisited[i]) continue;
            if (path.size() != 0 && isNum(path.get(path.size() - 1) + i))continue;
            path.add(i);
            isVisited[i] = true;
            backTracking(n, i + 1, isVisited);
            path.remove(path.size() - 1);
            isVisited[i] = false;
        }
    }
}
