package writtenexamination.mihayou;

import java.util.*;

public class Main3 {
    static List<Integer> path = new LinkedList<>();
    static long res;
    static int mod = 1000000007;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        long[] preNum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        for(int i = 1; i <= n; i++){
            preNum[i] = preNum[i - 1] + a[i - 1];
        }
        long res = 0;
        long temp = 0;
        int index = n;
        for (int i = n - 2; i >= 0; i--){
            temp = (temp + preNum[index] - preNum[i + 1]) % mod;
            index --;
            res = (res + temp * (a[i])) % mod;
        }
        /*ArrayList<Integer> b = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < a[i]; j++) {
                b.add(i + 1);
            }
        }
//        backTracking(b, 0);
        solution(b, a);*/
        System.out.println(res);
    }
    public static void solution(ArrayList<Integer> b, int[] a){
        int n = b.size();
        for (int i = 1; i < n; i++) {
            if (b.get(i) != b.get(i - 1)){
                int pre = b.get(i - 1);
                int cur = b.get(i);
                res += ((long) a[pre - 1] * a[cur - 1] * (cur - pre)) % mod;
            }
        }
        System.out.println(res);
    }

    public static void backTracking(ArrayList<Integer> b, int startIndex){
        if (path.size() != 0){
            res += path.get(path.size() - 1) - path.get(0);
        }
        for (int i = startIndex; i < b.size(); i++) {
            path.add(b.get(i));
            backTracking(b, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
