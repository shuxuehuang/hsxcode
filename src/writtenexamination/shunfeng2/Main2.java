package writtenexamination.shunfeng2;

import java.util.*;

public class Main2 {
    static int res = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> A = new ArrayList<>(n);
        int[] B = new int[n];
        for (int i = 0; i < n; i++) {
            A.add(sc.nextInt());
        }
        for (int i = 0; i < n; i++) {
            B[i] = sc.nextInt();
        }
        backTracking(A, B, new Stack<>(), 0, 0);
        System.out.println(res);
    }
    public static void backTracking(List<Integer> A, int[] B, Stack<Integer> stack, int money, int num){
        if (num == A.size() * 2){
            res += money;
            return;
        }
        if (A.size() != 0){
            //操作1
            stack.push(A.get(0));
            Integer firstElement = A.remove(0);
            backTracking(A, B, stack, money, num + 1);
            stack.pop();
            A.add(0, firstElement);
        }
        if (!stack.empty()){
            //操作2
            money += B[stack.size() - 1] * stack.peek();
            Integer pop = stack.pop();
            backTracking(A, B, stack, money, num + 1);
            stack.push(pop);
            money -= B[stack.size() - 1] * stack.peek();

        }

    }

}
