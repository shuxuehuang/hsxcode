package writtenexamination.huawei;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(solution(arr, k));
    }
    public static int solution(int[] arr, int k){
        int res = 0;
        int n = arr.length;
        //前一天留下的数量
        int lastNum = 0;
        for (int i = 0; i < n; i++) {
            //当天新到的数量
            int curNum = arr[i];
            if (lastNum == 0){
                //前一天没有剩余
                if (curNum < k){
                    //当天的活少于一车，不送
                    lastNum = curNum;
                }else if (curNum >= k){
                    //当天的货大于一车
                    res += curNum / k;
                    lastNum = curNum % k;
                }
            }else if (lastNum > 0){
                //前一天有剩下的,必须送
                //必须把前一天所有的送走
                res += lastNum / k;
                lastNum %= k;
                if (lastNum == 0){
                    //刚好送走, 只需要管今天的
                    if (curNum < k){
                        //不送
                        lastNum = curNum;
                    }else if (curNum >= k){
                        res += curNum / k;
                        lastNum = curNum % k;
                    }
                }else{
                    //前一天还剩下left,加上今天的一起送走
                    //前一天的lastNum, 加上今天的left;
                    int left = k - lastNum;
                    res ++;
                    if (curNum <= left){
                        //今天的货正好补前天的
                        lastNum = 0;
                    }else {
                        //今天的货补完前一天的还有
                        curNum -= left;
                        res += curNum / k;
                        lastNum = curNum % k;
                    }
                }

            }
        }
        if (lastNum > 0){
            if (lastNum % k == 0){
                res += lastNum / k;
            }else {
                res += lastNum / k + 1;
            }

        }
        return res;

    }

}
